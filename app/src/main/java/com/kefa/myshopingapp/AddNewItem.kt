package com.kefa.myshopingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_new_item.*

class AddNewItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_item)


        btnSave.setOnClickListener {
            //        get instance from Database
            var name: String = edtName.text.toString()
            var price: String = edtprices.text.toString()
            var description: String = desription.text.toString()
            Thread({
                AppDatabase.invoke(this)
                    .contactsDao()
                    .insertContacts(
                        MyDataClass(0, name, price.toInt(), "description")
                    )
            }).start()

            finish()

        }


    }
}
