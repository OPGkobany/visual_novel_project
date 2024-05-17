package com.example.trenirovka5

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

lateinit var imageView: ImageView

class ProjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        val background: ImageView = findViewById(R.id.backgroundImage)
        val chracter: ImageView = findViewById(R.id.characterImage)
        val btnBackground: Button = findViewById(R.id.buttonBackround)
        val btnChar: Button = findViewById(R.id.buttonCharacter)
        val textInput: EditText = findViewById(R.id.projectText)
        val floatBtn: FloatingActionButton = findViewById(R.id.floatingActionButtonProject)


        val pickMedia =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                if (uri != null) {
                    Log.d("PhotoPicker", "Selected URI: $uri")
                } else {
                    Log.d("PhotoPicker", "No media selected")
                }
            }

        //////I WAS COOKING WITH THIS
        btnBackground.setOnClickListener {
           // pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            val imageUri: Uri? = Uri.parse(
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    .toString()
            )
            imageView = findViewById(R.id.backgroundImage)
            imageView.setImageURI(imageUri)
        }

        btnChar.setOnClickListener {
            // pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            val imageUri: Uri? = Uri.parse(
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    .toString()
            )
            imageView = findViewById(R.id.characterImage)
            imageView.setImageURI(imageUri)
        }

        floatBtn.setOnClickListener {

        }

    }
}
