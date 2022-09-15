package com.pix.dokkademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pix.libraryone.LibraryOne

class MainActivity : AppCompatActivity() {
    /**
     * 库1变量
     */
    var libraryOne:LibraryOne? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}