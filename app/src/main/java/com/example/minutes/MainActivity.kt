package com.example.minutes

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import  android.view.View
import java.util.*
import java.text.SimpleDateFormat as SimpleDateFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{view->
            clickdatepicker(view)

        }
        }


    fun clickdatepicker(view:View){
        val mycalander= Calendar.getInstance()
        val year = mycalander.get(Calendar.YEAR)
        val month = mycalander.get(Calendar.MONTH)
        val  day = mycalander.get(Calendar.DAY_OF_MONTH)

       val dpd = DatePickerDialog(this, OnDateSetListener { selectedview, selectedyear, selectedmonth, selecteddayOfMonth ->
           val date = "$selecteddayOfMonth/${selectedmonth + 1}/$selectedyear"
           val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
           val theDate = sdf.parse(date)
           val selectedDateinMinutes = theDate!!.time / 60000
           val currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))
           val currentdateinminutes = currentdate!!.time / 60000
           val differenceinminutes = currentdateinminutes - selectedDateinMinutes
           val selectedDateinDays = theDate!!.time / (86400000)
           val currentdateinDays = currentdate!!.time / (86400000)
           val differenceindDays = currentdateinDays - selectedDateinDays



           textView4.setText("${differenceinminutes} In Minutes")
           textView.setText("${differenceindDays} In Days")



           textView3.setText("$date")




       }


               ,year,month,day)

dpd.datePicker.setMaxDate(Date().time -86400000)
        dpd.show()




    }
}




