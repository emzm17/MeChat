package com.example.mechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.mechat.constants.Constants.Companion.PHONE_NUMBER
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
  private lateinit var phonenumber:String
  private lateinit var countrycode:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        phoneNumber.addTextChangedListener {
               nextBtn.isEnabled= !(it.isNullOrEmpty() || it.length<10 )
        }
        nextBtn.setOnClickListener {
            checkNumber()
        }
    }

    private fun checkNumber() {
            countrycode = countrycodePicker.selectedCountryCodeWithPlus
            phonenumber=countrycode+phoneNumber.text.toString()

            proceedNext()
    }

    private fun proceedNext() {
        MaterialAlertDialogBuilder(this).apply {
             setMessage("We will be Verifying the Phone Number:$phonenumber\n" + "Is this OK ,or would you like to edit the Number ?")
             setPositiveButton("ok"){_,_->
                 verify()
             }
            setNegativeButton("Edit"){dialog,it->
                    dialog.dismiss()
            }
            setCancelable(false)
            create()
            show()
        }
    }

    private fun verify() {
            val i=Intent(this,OtpActivity::class.java)
            i.putExtra(PHONE_NUMBER,phonenumber)
            startActivity(i)
            finish()
    }
}