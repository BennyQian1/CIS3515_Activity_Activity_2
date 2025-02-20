package edu.temple.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
        /*if (result.resultCode == Activity.RESULT_OK) {
            val newSize = result.data?.getFloatExtra("TEXT_SIZE", 16f) ?: 16f
            lyricsDisplayTextView.textSize = newSize
        }*/
        result.data?.let { data ->
            val newSize = data.getFloatExtra("TEXT_SIZE", 16f)
            lyricsDisplayTextView.textSize = newSize
        }
    }

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {
            val intent = Intent(this, TextSizeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            launcher.launch(intent)
        }

        }
}