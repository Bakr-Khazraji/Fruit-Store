package com.example.assignment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class FruitsDialogFragment: DialogFragment(R.layout.fragment_dialog_fruits) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbt:Button=view.findViewById(R.id.cancelbtn)
        val addbtn:Button=view.findViewById(R.id.addbtn)
        val radioGroup:RadioGroup=view.findViewById(R.id.fruitRadio)
        cancelbt.setOnClickListener {
            dismiss()
        }
        addbtn.setOnClickListener {
            val selectedoption : Int = radioGroup.checkedRadioButtonId
            val radiobtn:RadioButton=view.findViewById(selectedoption)
            val kg:EditText=view.findViewById(R.id.kgs)
            var price:Double =0.0
            when(radiobtn.text){
                "Apples" -> price=0.5*(kg.text.toString().toInt())
                "Oranges" -> price=0.6*(kg.text.toString().toInt())
                "Bananas" -> price=0.7*(kg.text.toString().toInt())
                "Mangos" -> price=1.2*(kg.text.toString().toInt())
            }
            val m1:MainActivity=getActivity() as MainActivity;
            m1.reciveFeedback(price.toString(),radiobtn.text.toString())
            dismiss()
        }
    }
}