package com.loginapplication123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.loginapplication123.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etPassword.doOnTextChanged { text, _, _, _ ->
            if((text?.length ?:0) <6){
                binding.etPassword.error = resources.getString(R.string.please_enter_password)
            }else{
                binding.etPassword.error = null
            }
        }

        //intent used in forgotpassword

        binding.tvForgotPassword.setOnClickListener {
            var intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        //textview forget password ended


        binding.rgGender.setOnCheckedChangeListener { radioGroup, id ->
            when(id){
                R.id.rbOther->{ //toast is used to show popup message
                    Toast.makeText(this, resources.getString(R.string.others), Toast.LENGTH_LONG).show()
                    binding.etOtherName.visibility = View.VISIBLE
                }
                else->{
                    binding.etOtherName.visibility = View.INVISIBLE
                }
            }
        }
        //radio button other shows visibility only on clicking
        binding. rbOther.setOnCheckedChangeListener()  { _, isChecked ->
              if(isChecked){
                  binding.etOtherName.visibility = View.VISIBLE
              }else{
                  binding.etOtherName.visibility = View.INVISIBLE
              }
          }
        //check for email validation
        //validations on clicking login button
        binding. btnLogin.setOnClickListener {
            //to clear the text
            binding. etName.text.clear()
            var name =binding. etName.text.toString()
            var password =binding. etPassword.text.toString()
            //System.out.println("name $name")
            if(name.isNullOrEmpty()){
                binding.etName.error = resources.getString(R.string.please_enter_name)
                binding. etName.requestFocus()
            }else if(password.isNullOrEmpty()){
                binding.etPassword.error = resources.getString(R.string.please_enter_password)
                binding.etPassword.requestFocus()
            }else if(password.length<6){
                binding.etPassword.error = resources.getString(R.string.please_enter_password)
                binding.etPassword.requestFocus()
            }
            else{

                Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
                var intent = Intent(this, ForgotPasswordActivity::class.java)//forgetpassword activity start after clicking with the help of intent
                startActivity(intent)
                finish()
            }

        }

    }
}