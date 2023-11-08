package com.example.ejercicioripley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val EditCategoria = findViewById<EditText>(R.id.editCategoria)
        val EditMonto = findViewById<EditText>(R.id.editMonto)
        val BtnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtIGV = findViewById<TextView>(R.id.txtIGV)
        val txtMontoSinDescuento = findViewById<TextView>(R.id.txtMontoSinDescuento)
        val txtPorcentajeDescuento = findViewById<TextView>(R.id.txtPorcentajeDescuento)
        val txtMontoPagarConDescuento = findViewById<TextView>(R.id.txtMontoPagarConDescuento)

        BtnCalcular.setOnClickListener {

            val categoria = EditCategoria.text.toString()
            val monto = EditMonto.text.toString().toDouble()
            val descuento = calcularDescuento(categoria, monto)

            val igv = monto * 0.18

            val precioigv = monto + igv

            val preciocondescuento = precioigv - (precioigv * descuento / 100)

            txtIGV.text = "IGV: $igv"
            txtMontoSinDescuento.text = "Monto a Pagar sin descuento: $precioigv"
            //txtPorcentajeDescuento.text = "Porcentaje de descuento: $descuento%"
            txtMontoPagarConDescuento.text = "Monto a Pagar con descuento: $preciocondescuento"
            txtPorcentajeDescuento.text = "Porcentaje de descuento: %.2f%%".format(descuento)
        }
    }
        private fun calcularDescuento(categoria: String, monto: Double): Double {
            var descuento = 0.0

            when (categoria){
                "Zapatos" -> {
                    if (monto >= 1000) {
                        descuento = 0.1 * 100
                    }
                }
                "Prendas para dama" -> {
                    if (monto >= 500) {
                        descuento = 0.18 * 100
                    }
                }
                "Electrodomesticos" -> {
                    if (monto >= 6000) {
                        descuento = 0.07 * 100
                    }
                }
                "Celulares" -> {
                    if (monto >= 3500) {
                        descuento = 0.09 * 100
                    }
                }
                "Ropa para caballero" -> {
                    if (monto >= 1500) {
                        descuento = 0.05 * 100
                    }
                }
                "Juguetes" -> {
                    if (monto >= 2500) {
                        descuento = 0.13 * 100
                    }
                }
                "Laptops" -> {
                    if (monto >= 8000) {
                        descuento = 0.19 * 100
                    }
                }
            }
            return descuento
        }
}