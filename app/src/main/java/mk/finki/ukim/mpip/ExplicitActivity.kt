package mk.finki.ukim.mpip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        val okButton = findViewById<Button>(R.id.ok)
        val backButton = findViewById<Button>(R.id.back)
        val textPole = findViewById<EditText>(R.id.textInput)
        okButton.setOnClickListener(){
            val firstIntent = Intent(this, MainActivity::class.java)
            val textValue = textPole.text.toString()
            firstIntent.putExtra("Tekst",textValue)
            startActivity(firstIntent)
        }
        backButton.setOnClickListener(){
            val backIntent = Intent(this,MainActivity::class.java)
            startActivity(backIntent)
        }
    }
}