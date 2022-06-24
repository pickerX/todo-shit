package io.km.todo.model

/**
 *
 * @author pengfei.huang
 * create on 2022/6/24
 */
data class Plan(
    val id: Int,
    val title: String,
    val step: Int,
    val tasks: Int,
)