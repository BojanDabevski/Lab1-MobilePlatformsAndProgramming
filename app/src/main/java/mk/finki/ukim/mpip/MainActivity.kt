package mk.finki.ukim.mpip

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val imageView:ImageView by lazy {
        findViewById(R.id.imageView )
    }
    private val selectPictureLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){
        imageView.setImageURI(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstButton = findViewById<Button>(R.id.firstButton)
        val secondButton = findViewById<Button>(R.id.secondButton)
        val thirdButton = findViewById<Button>(R.id.thirdBytton)

        val bundle : Bundle? = intent.extras
        val textControl = findViewById<TextView>(R.id.teskt)

        if(bundle != null){
            val text = bundle.get("Tekst")
            textControl.setText("")
            textControl.setText(text.toString())

        }

        firstButton.setOnClickListener(){
            val explicitIntent = Intent(this, ExplicitActivity::class.java)
            startActivity(explicitIntent)
        }
        secondButton.setOnClickListener(){
            val implicitIntent = Intent(this, ImplicitActivity::class.java)
            implicitIntent.setAction("mk.ukim.finki.mpip.IMPLICIT_ACTION")
            startActivity(implicitIntent)
        }
        findViewById<Button>(R.id.fourthButton).setOnClickListener(){
           selectPictureLauncher.launch("image/*")
        }
        thirdButton.setOnClickListener(){
            val mail = Intent(Intent.ACTION_SEND)
            mail.putExtra(Intent.EXTRA_SUBJECT, "MPiP Send Title")
            mail.putExtra(Intent.EXTRA_TEXT, "Content send from MainActivity")
            mail.type = "mail/*"

            if (mail.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(mail, "Прати преко:"))
            }
        }


    }



}