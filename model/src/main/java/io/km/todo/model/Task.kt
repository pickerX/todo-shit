package io.km.todo.model

/**
 *
 * @author pengfei.huang
 * create on 2022/6/24
 */
data class Task(
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
    )
}

const val REPEAT_EVERYDAY = 0x111111
const val REPEAT_WORKDAY = 0x111100
