package mx.itson.asignacion4_calculadoraimc_roman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.asignacion4_calculadoraimc_roman.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            calcularIMC()
        }

    }

    private fun calcularIMC() {

        val weight : EditText = findViewById<EditText>(R.id.etPeso)
        val height : EditText = findViewById<EditText>(R.id.etEstatura)

        if (weight.text.toString().isEmpty() || height.text.toString().isEmpty()){
            return
        }

        val peso = weight.text.toString().toDouble()
        val estatura = height.text.toString().toDouble() / 100
        val imc = peso / (estatura * estatura)

        findViewById<TextView>(R.id.imc).setText(imc.toString())

        val tvRange = findViewById<TextView>(R.id.range)

        when {
            imc < 18.5 -> {
                tvRange.text = "Bajo peso"
                tvRange.setBackgroundResource(R.color.colorGreenish)
            }
            imc in 18.5..24.9 -> {
                tvRange.text = "Normal"
                tvRange.setBackgroundResource(R.color.colorGreen)
            }
            imc in 25.0..29.9 -> {
                tvRange.text = "Sobrepeso"
                tvRange.setBackgroundResource(R.color.colorYellow)
            }
            imc in 30.0..34.9 -> {
                tvRange.text = "Obesidad grado 1"
                tvRange.setBackgroundResource(R.color.colorOrange)
            }
            imc in 35.0..39.9 -> {
                tvRange.text = "Obesidad grado 2"
                tvRange.setBackgroundResource(R.color.colorRed)
            }
            imc >= 40.0 -> {
                tvRange.text = "Obesidad grado 3"
                tvRange.setBackgroundResource(R.color.colorBrown)
            }
        }
    }
}