package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.*
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {
    var total:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addFbtn : Button =findViewById(R.id.fruitsbtn)

        addFbtn.setOnClickListener {
            var F_dialog =FruitsDialogFragment()
            F_dialog.show(supportFragmentManager,"Fruits Fragment")

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_my,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> clearCart()
            R.id.item2 -> {
                val mapintent: Intent =Uri.parse("geo:31.984323913202807, 35.8649121?z=18").let{ location ->
                    Intent(Intent.ACTION_VIEW,location)
                }
                startActivity(mapintent)
            }
        }
        return true
    }
    fun reciveFeedback(price:String,item:String){
        val appletxt:TextView=findViewById(R.id.fruit1txt)
        val orangetxt:TextView=findViewById(R.id.fruit2txt)
        val bananatxt:TextView=findViewById(R.id.fruit3txt)
        val mangotxt:TextView=findViewById(R.id.fruit4txt)
        when(item){
            "Apples"->appletxt.text="Apples   "+price+"JD"
            "Oranges"->orangetxt.text="Oranges   "+price+"JD"
            "Bananas"->bananatxt.text="Bananas   "+price+"JD"
            "Mangos"->mangotxt.text="Mangos   "+price+"JD"
        }

        total += price.toDouble()
        val totaltxt:TextView=findViewById(R.id.totaltxt)
        totaltxt.text="Total is "+total.toString() + "JD"
    }
    fun clearCart(){
        val appletxt:TextView=findViewById(R.id.fruit1txt)
        val orangetxt:TextView=findViewById(R.id.fruit2txt)
        val bananatxt:TextView=findViewById(R.id.fruit3txt)
        val mangotxt:TextView=findViewById(R.id.fruit4txt)
        val totaltxt:TextView=findViewById(R.id.totaltxt)
        totaltxt.text="Total is 0 JD"
        total=0.0
        appletxt.text=""
        orangetxt.text=""
        bananatxt.text=""
        mangotxt.text=""
    }
}
