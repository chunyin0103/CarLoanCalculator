package com.example.carloancalculator

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CalculateButton.setOnClickListener {
            calculateLoan()
        }
    }

    fun calculateLoan() {
        if (editTextCarPrice.text.isEmpty()) {
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }

        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextdownPayment.text.toString().toInt()
        val loan: Int = carPrice - downPayment
        val interestRate: Float = editTextinterestRate.text.toString().toFloat()
        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
        val interest = loan + (interestRate)/100 + loanPeriod
        val monthlyRepayment = (loan + interest) / loanPeriod / 12

       // Toast.makeText(this, "Calculate Loan", Toast.LENGTH_SHORT).show()
        CarLoan.setText(getString(R.string.loan) +" ${ loan }")
        interestText.setText(getString(R.string.interest) + "${ interest }")
        monthlyRepaymentText.setText(getString(R.string.monthly_repayment) + "${ monthlyRepayment }")


    }

    fun reset(view: View) {
        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()

    }
}




