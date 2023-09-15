package com.lafimsize.clickablesentence

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import com.lafimsize.clickablesentence.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spannableString=SpannableString(binding.mySentences.text)

        val sentences=binding.mySentences.text.split(".")

        for(sentence in sentences){

            val clickableSpan=object :ClickableSpan(){

                override fun onClick(widget: View) {
                    binding.mySentences.setTextColor(Color.RED)
                }
            }

            val sentenceStart = binding.mySentences.text.indexOf(sentence)
            val sentenceEnd = sentenceStart + sentence.length

            spannableString.setSpan(clickableSpan,sentenceStart,sentenceEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }


        binding.mySentences.text=spannableString
        binding.mySentences.movementMethod=LinkMovementMethod.getInstance()
    }
}