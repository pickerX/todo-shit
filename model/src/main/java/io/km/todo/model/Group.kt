package io.km.todo.model

/**
 * tasks or plan group
 *
 * @author pengfei.huang
 * create on 2022/6/24
 */
data class Group(
    var title: String,
    var icon: String,
    var iconRes: Int,
    var taskIds: String,
    var planIds: String,
    var sort: Int,          // order by sort
) {
    var tasks: List<Task>? = null
    var plans: List<Plan>? = null

}