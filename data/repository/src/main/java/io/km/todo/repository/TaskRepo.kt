package io.km.todo.repository

import io.km.todo.model.Task
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * @author pengfei.huang
 * create on 2022/6/24
 */
@Singleton
class TaskRepo @Inject constructor() {

    suspend fun addTask(task: Task): Boolean {
        task.createAt = System.currentTimeMillis()
        task.lastUpdateAt = task.createAt
        return false
    }

    suspend fun startTask(task: Task): Boolean {
        task.start = true
        return true
    }

}