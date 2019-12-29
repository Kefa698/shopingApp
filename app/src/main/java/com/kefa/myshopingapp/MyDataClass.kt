package com.kefa.myshopingapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*


//create entity
@Entity
data class MyDataClass(
    @PrimaryKey(autoGenerate = true) var id: Int, var Name: String,
    var price: Int, var description: String
)


//create Database Access Object
@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertContacts(contacts: MyDataClass)

    @Query("SELECT * FROM MyDataClass WHERE id LIKE:id")
    fun getContactId(id: Int): LiveData<MyDataClass>

    @Query("SELECT * FROM MyDataClass ")
    fun getAllContacts(): LiveData<List<MyDataClass>>

    @Query("DELETE FROM MyDataClass WHERE id LIKE:id")
    fun deleteContact(id: Int)

}

//create database
@Database(
    entities = [MyDataClass::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "myshoping.db"
        )
            .build()
    }
}
