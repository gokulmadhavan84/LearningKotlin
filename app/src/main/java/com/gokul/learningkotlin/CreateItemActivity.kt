package com.gokul.learningkotlin

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_create_item.*
import java.io.IOException

class CreateItemActivity : AppCompatActivity() {

    private val CHOOSE_IMAGE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_item)
    }
    fun onChooseImage(v :View){
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"

        val chooser = Intent.createChooser(intent,"Select an image")

        startActivityForResult(chooser, CHOOSE_IMAGE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == CHOOSE_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.data != null )
        {
            val bitmap = readBitMap(data.data)
            bitmap?.let { et_image.setImageBitmap(bitmap) }
        }
    }

    private fun readBitMap(data: Uri): Bitmap? {

        return try {
            MediaStore.Images.Media.getBitmap(contentResolver,data)
        }catch (e : IOException)
        {
            e.printStackTrace()
            null
        }

    }
}
