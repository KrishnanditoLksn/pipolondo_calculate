package app.ditodev.pipolondo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), View.OnClickListener {
    /*
    declare lateinit variable
     */
    private lateinit var editNumber1: EditText
    private lateinit var editNumber2: EditText
    private lateinit var btnTambah: Button
    private lateinit var btnKurang: Button
    private lateinit var btnBagi: Button
    private lateinit var btnKali: Button
    private lateinit var result: TextView
    private lateinit var viewModel: MainActivityViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editNumber1 = findViewById(R.id.edit_text_1)
        editNumber2 = findViewById(R.id.edit_text_2)
        btnTambah = findViewById(R.id.btn_tambah)
        btnKurang = findViewById(R.id.btn_kurang)
        btnBagi = findViewById(R.id.btn_bagi)
        btnKali = findViewById(R.id.btn_kali)
        result = findViewById(R.id.hasil_field)
        btnKurang.setOnClickListener(this)
        btnKali.setOnClickListener(this)
        btnTambah.setOnClickListener(this)
        btnBagi.setOnClickListener(this)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        val resultObserver: Observer<Int> = Observer {
            result.text = it.toString()
        }

        viewModel.res.observe(this, resultObserver)
    }

    /*
    override  a function onClick function
     */
    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        //get value from edittext 1 and 2
        val n1 = editNumber1.text.toString().trim()
        val n2 = editNumber2.text.toString().trim()
        if (n1.isNotEmpty() && n2.isNotEmpty()) {
            when (p0?.id) {
                R.id.btn_kali -> {
                    viewModel.calculateKali(n1, n2)
                }

                R.id.btn_bagi -> {
                    viewModel.calculateBagi(n1, n2)
                }

                R.id.btn_kurang -> {
                    viewModel.calculateKurang(n1, n2)
                }

                R.id.btn_tambah -> {
                    viewModel.calculateSum(n1, n2)
                }
            }
        } else if (n1.isEmpty()) {
            editNumber1.error = "Gaboleh kosong"
        } else if (n2.isEmpty()) {
            editNumber2.error = "Gaboleh Kosong"
        }
    }

//    private fun displayResult() {
//        result.text = viewModel.res.toString()
//    }
}