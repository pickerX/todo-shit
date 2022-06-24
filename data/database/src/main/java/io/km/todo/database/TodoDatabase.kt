package io.km.todo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.km.todo.database.dao.TaskDao
import io.km.todo.database.entity.TaskEntity

/**
 *
 * @author pengfei.huang
 * create on 2022/6/24
 */
@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract val repositoryDao: TaskDao
}
