package io.km.todo.model

/**
 * common user
 *
 * @author pengfei.huang
 * create on 2022/6/23
 */
data class User(
    val id: Int,
    val login: String,
    val pwd: String,
    val avatar: String,
)
