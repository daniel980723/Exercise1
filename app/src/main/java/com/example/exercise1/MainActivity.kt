package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            if(editTextCarPrice.text.length==0){
                editTextCarPrice.setError("Pls Enter a Price")
                return@setOnClickListener
            }
            if(editTextDownPayment.text.length==0){
                editTextDownPayment.setError("Pls Enter a Down Payment")
                return@setOnClickListener
            }
            if(editTextInterestRate.text.length==0){

               editTextInterestRate.setError("Pls Enter a Interest")
                return@setOnClickListener
            }
            if(editTextLoanPeriod.text.length==0){

                editTextLoanPeriod.setError("Pls Enter loan period")
                return@setOnClickListener
            }
            val car_price = editTextCarPrice.text.toString().toInt()
            val down_payment = editTextDownPayment.text.toString().toInt()
            val loan_period = editTextLoanPeriod.text.toString().toInt()
            val interest_rate = editTextInterestRate.text.toString().toFloat()
            //TODO:CONTINUE YOUR CALCULATOR HERE
            val loan = car_price - down_payment
            textviewLoan.text=getString(R.string.loan) + "${loan}"
            val interest = (loan * interest_rate* loan_period)/100
            textviewInterest.text=getString(R.string.interest) + "${interest}"
            val payment = (loan+interest)/loan_period/12
            textviewmonthly_payment.text=getString(R.string.monthly_payment)+"${payment}"
        }
    }

    fun resetInput(view: View) {
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()
        editTextDownPayment.text.clear()
        editTextCarPrice.text.clear()
        textviewLoan.text = getString(R.string.loan)
        textviewInterest.text=getString(R.string.interest)
        textviewmonthly_payment.text=getString(R.string.monthly_payment)
    }
}
