package com.example.trenirovka5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_reg_auth)

        val linkToReg = findViewById<TextView>(R.id.link_to_reg)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

            button.setOnClickListener {
                val loginAuth = userLogin.text.toString().trim()
                val passAuth = userPass.text.toString().trim()

                if (loginAuth == "" || passAuth == "")
                    Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
                else {
                   val db = databaseHelper(this,null)
                    val isAuth = db.getUser(loginAuth,passAuth)

                    if(isAuth) {
                        Toast.makeText(this, "Пользователь $loginAuth авторизован", Toast.LENGTH_SHORT).show()
                        userLogin.text.clear()
                        userPass.text.clear()

                        val intentItem = Intent(this, ItemsActivity::class.java)
                        startActivity(intentItem)

                    } else
                        Toast.makeText(this, "Пользователь $loginAuth НЕ авторизован", Toast.LENGTH_SHORT).show()
                }
            }
    }
}