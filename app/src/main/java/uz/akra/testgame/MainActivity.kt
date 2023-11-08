package uz.akra.testgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    var javob = 0

    var random1 = 0
    var random2 = 0
    var random3 = 0


    lateinit var txt_misol: TextView
    lateinit var rad_group: RadioGroup
    lateinit var btn_next: Button
    lateinit var rad_a: RadioButton
    lateinit var rad_b: RadioButton
    lateinit var rad_c: RadioButton
    lateinit var rad_d: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_misol = findViewById(R.id.txt_misol)
        rad_group = findViewById(R.id.rad_group)
        btn_next = findViewById(R.id.btn_next)

        rad_a = findViewById(R.id.rad_a)
        rad_b = findViewById(R.id.rad_b)
        rad_c = findViewById(R.id.rad_c)
        rad_d = findViewById(R.id.rad_d)

        random()

        btn_next.setOnClickListener() {
            if (rad_a.isChecked) {
                if (rad_a.text.toString().toInt() == javob) Toast.makeText(
                    this,
                    "Javobingiz tog'ri",
                    Toast.LENGTH_SHORT
                ).show()
                else Toast.makeText(this, "Javobingiz noto'g'ri", Toast.LENGTH_SHORT).show()
            }
            random()
            if (rad_b.isChecked) {
                if (rad_b.text.toString().toInt() == javob) Toast.makeText(
                    this,
                    "Javobingiz tog'ri",
                    Toast.LENGTH_SHORT
                ).show()
                else Toast.makeText(this, "Javobingiz noto'g'ri", Toast.LENGTH_SHORT).show()
            }
            random()
            if (rad_c.isChecked) {
                if (rad_c.text.toString().toInt() == javob) Toast.makeText(
                    this,
                    "Javobingiz tog'ri",
                    Toast.LENGTH_SHORT
                ).show()
                else Toast.makeText(this, "Javobingiz noto'g'ri", Toast.LENGTH_SHORT).show()
            }
            random()
            if (rad_d.isChecked) {
                if (rad_d.text.toString().toInt() == javob) Toast.makeText(
                    this,
                    "Javobingiz tog'ri",
                    Toast.LENGTH_SHORT
                ).show()
                else Toast.makeText(this, "Javobingiz noto'g'ri", Toast.LENGTH_SHORT).show()
            }
            random()
        }
    }

    private fun random() {
        var number1 = Random().nextInt(20)
        var number2 = Random().nextInt(20)
        var amal = Random().nextInt(4)

        when (amal) {
            0 -> {
                txt_misol.text = "$number1 + $number2 = "
                javob = number1 + number2
            }

            1 -> {
                txt_misol.text = "$number1 - $number2 = "
                javob = number1 - number2
            }

            2 -> {
                txt_misol.text = "$number1 * $number2 = "
                javob = number1 * number2
            }

            3 -> {
                try {
                    if (number1 % number2 != 0) throw Exception()
                    txt_misol.text = "$number1 / $number2 = "
                    javob = number1 / number2
                } catch (e: Exception) {
                    random()
                }
            }
        }
        radEkranYoz()
    }

    fun randomSonAniqla() {
        random1 = Random().nextInt(100)
        random2 = Random().nextInt(100)
        random3 = Random().nextInt(100)

        if (random1 == random2 || random2 == random3 || random1 == random3) {
            randomSonAniqla()
        }
    }

    fun radEkranYoz() {
        var tj = Random().nextInt(4)
        randomSonAniqla()
        when (tj) {
            0 -> {
                rad_a.text = javob.toString()
                rad_b.text = random1.toString()
                rad_c.text = random2.toString()
                rad_d.text = random3.toString()
            }

            1 -> {
                rad_b.text = javob.toString()
                rad_a.text = random1.toString()
                rad_c.text = random2.toString()
                rad_d.text = random3.toString()
            }

            2 -> {
                rad_c.text = javob.toString()
                rad_b.text = random1.toString()
                rad_a.text = random2.toString()
                rad_d.text = random3.toString()
            }

            3 -> {
                rad_d.text = javob.toString()
                rad_b.text = random1.toString()
                rad_c.text = random2.toString()
                rad_a.text = random3.toString()
            }
        }
    }

}