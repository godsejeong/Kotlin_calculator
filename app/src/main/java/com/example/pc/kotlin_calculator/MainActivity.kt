package com.example.pc.kotlin_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    var count : Int = 0
    var list : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button0.setOnClickListener(this)
        buttonj.setOnClickListener(this)
        buttonna.setOnClickListener(this)
        buttonx.setOnClickListener(this)
        buttonsum.setOnClickListener(this)
        buttonCLR.setOnClickListener(this)
        buttonminus.setOnClickListener(this)
        buttoneq.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
       when(p0!!.id) {
           R.id.button0 -> text.setText(text.text.toString()+"0");
           R.id.button1 -> text.setText(text.text.toString()+"1");
           R.id.button2 -> text.setText(text.text.toString()+"2");
           R.id.button3 -> text.setText(text.text.toString()+"3");
           R.id.button4 -> text.setText(text.text.toString()+"4");
           R.id.button5 -> text.setText(text.text.toString()+"5");
           R.id.button6 -> text.setText(text.text.toString()+"6");
           R.id.button7 -> text.setText(text.text.toString()+"7");
           R.id.button8 -> text.setText(text.text.toString()+"8");
           R.id.button9 -> text.setText(text.text.toString()+"9");
           R.id.buttonj -> text.setText(text.text.toString()+".");
           R.id.buttonna -> {
               list.add(text.text.toString())
               text.setText("")
               count=4
           }

           R.id.buttonx ->  {
               list.add(text.text.toString())
               text.setText("")
               count=3
           }
           R.id.buttonsum -> {
               list.add(text.text.toString())
               text.setText("")
               count=1
           }
           R.id.buttonminus -> {
               list.add(text.text.toString())
               text.setText("")
               count=2
           }
           R.id.buttonCLR -> {
               list.clear()
               text.setText("")
           }
           R.id.buttoneq -> {
               var bool : Boolean =false
               var sum_one : Int = 0
               var sum_two : Int = 0
               var sum : Int = 0

               var fum_one : Double = 0.0
               var fum_two : Double = 0.0
               var fum_sum : Double = 0.0
               if (list.isEmpty())
                   text.setText("")

               var num_one : String = list.get(0)
               var num_two : String = text.text.toString()
               var result : String = ""
               if(num_one.contains(".") || num_two.contains(".")){
                   bool=true

                   fum_one = num_one.toFloat().toDouble()
                   fum_two = num_two.toFloat().toDouble()
               }else{

                   sum_one = num_one.toInt()
                   sum_two = num_two.toInt()
               }

               when(count){
                   1->{
                       if(bool){
                           fum_sum=fum_one+fum_two
                           text.setText(fum_sum.toString())
                       }else{
                           sum = sum_one+sum_two
                           text.setText(sum.toString())
                       }
                   }
                   2->{
                       if(bool){
                           fum_sum=fum_one-fum_two
                           text.setText(fum_sum.toString())
                       }else{
                            sum = sum_one-sum_two
                           text.setText(sum.toString())
                   }
                   }
                   3->{
                       if(bool){
                           fum_sum=fum_one*fum_two
                           text.setText(fum_sum.toString())
                       }else{
                           sum = sum_one*sum_two
                           text.setText(sum.toString())
                       }
                   }
                   4->{
                       if(bool){
                           fum_sum=fum_one/fum_two
                           text.setText(fum_sum.toString())
                       }else{
                           sum = sum_one/sum_two
                           text.setText(sum.toString())
                       }
                   }
               }

           }
       }
    }
}
