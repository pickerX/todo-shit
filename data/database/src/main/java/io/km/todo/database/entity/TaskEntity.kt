package io.km.todo.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.km.todo.model.Note
import io.km.todo.model.Task

/**
 *
 * @author pengfei.huang
 * create on 2022/6/24
 */
@Entity(tableName = "Task")
data class TaskEntity(
    @PrimaryKey
    val id: Long,
    var title: String,
    var note: Note? = null,
    var steps: List<Step>? = null,
    var createAt: Long,
    var lastUpdateAt: Long,
    var notifyTime: Long,    // notify data & time
    var repeat: Int,
    var done: Boolean,
    var start: Boolean,      // start collection
) {

    data class Step(
        val title: String,
        var done: Boolean,
    ) {
        fun toModel(): Task.Step = Task.Step(title, done)

        companion object {
            fun fromModule(step: Task.Step) = Step(step.title, step.done)
        }
    }

    fun toModel(): Task {
        val data = mutableListOf<Task.Step>()
        steps?.forEach {
            data.add(it.toModel())
        }
        return Task(id, title, note, data, createAt, lastUpdateAt, notifyTime, repeat, done, start)
    }


    companion object {
        fun fromModel(task: Task): TaskEntity {
            val steps = mutableListOf<Step>()
            task.steps?.let {
                it.forEach { s -> steps.add(Step.fromModule(s)) }
            }
            return TaskEntity(
                task.id,
                task.title,
                task.note,
                steps,
                task.createAt,
                task.lastUpdateAt,
                task.notifyTime,
                task.repeat,
                task.done,
                task.start
            )
        }
    }
}