package com.githumainDashboard.githubcode.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.githumainDashboard.githubcode.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment implements View.OnClickListener{
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");
    private static final Pattern MOBILE_PATTERN =
            //Pattern.compile("^([789]{1})([02346789]{1})([0-9]{8})$"); COMMENT ON 03-08-2019
            Pattern.compile("(0/91)?[7-9][0-9]{9}");

    TextInputLayout txtInpFirstName,txtInpLastName,txtInpMobileNumber,txtInpEmailAddressR,txtInpPasswordR,inpTextcnfPasswordR;
    TextInputEditText edtTextFistName,edtTextLastName,edtTextMobileNumebr,edtTextEmilAddressR,edtTextPasswordR,edtTextcnfPasswordR;
    Button btnRegistration;

    String fName,lName,mobile,email,pass,cnfpass;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view= inflater.inflate(R.layout.fragment_registration, container, false);
        txtInpFirstName=view.findViewById(R.id.txtInpFirstName);
        txtInpLastName=view.findViewById(R.id.txtInpLastName);
        txtInpMobileNumber=view.findViewById(R.id.txtInpMobileNumber);
        txtInpEmailAddressR=view.findViewById(R.id.txtInpEmailAddressR);
        txtInpPasswordR=view.findViewById(R.id.txtInpPasswordR);
        inpTextcnfPasswordR=view.findViewById(R.id.inpTextcnfPasswordR);

        edtTextFistName=view.findViewById(R.id.edtTextFistName);
        edtTextLastName=view.findViewById(R.id.edtTextLastName);
        edtTextMobileNumebr=view.findViewById(R.id.edtTextMobileNumebr);
        edtTextEmilAddressR=view.findViewById(R.id.edtTextEmilAddressR);
        edtTextPasswordR=view.findViewById(R.id.edtTextPasswordR);
        edtTextcnfPasswordR=view.findViewById(R.id.edtTextcnfPasswordR);

        btnRegistration=view.findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistration:
                if(validate()){
                    Toast.makeText(getContext(), "Registration Successfully....!!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
    protected boolean validate(){
        String name_Pattern="^[a-zA-Z]*$";
        fName=txtInpFirstName.getEditText().getText().toString().trim();
        lName=txtInpLastName.getEditText().getText().toString().trim();
        mobile=txtInpMobileNumber.getEditText().getText().toString().trim();
        email=txtInpEmailAddressR.getEditText().getText().toString().trim();
        pass=txtInpPasswordR.getEditText().getText().toString().trim();
        cnfpass=inpTextcnfPasswordR.getEditText().getText().toString().trim();
            if(fName.isEmpty()){
                txtInpFirstName.setError("Field can't be empty.");
                return false;
            }else if(!fName.matches(name_Pattern)){
                txtInpFirstName.setError("Please enter only Alphabets.");
                return  false;
            } else {
                txtInpFirstName.setErrorEnabled(false);
            }
            if(lName.isEmpty()){
                txtInpLastName.setError("Foeld can't be Empty.");
                return false;
            }else if(!lName.matches(name_Pattern)){
                txtInpLastName.setError("Please enter only Alphabets.");
                return  false;
            } else {
                txtInpLastName.setErrorEnabled(false);
            } if(mobile.isEmpty()){
                txtInpMobileNumber.setError("Field can't be Empty...!!!");
            return false;
            }else if(!MOBILE_PATTERN.matcher(mobile).matches()){
                txtInpMobileNumber.setError("Please enter a valid mobile number...!!!");
            return false;
            }else{
             txtInpMobileNumber.setErrorEnabled(false);
        } if(email.isEmpty()){
            txtInpEmailAddressR.setError("Field can't be Empty...!!!");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            txtInpEmailAddressR.setError("please Enter Valid Email Address...!!!");
            return false;
        }else {
                txtInpEmailAddressR.setErrorEnabled(false);
        }
             if(pass.isEmpty()){
            txtInpPasswordR.setError("Field can't be Empty...!!!");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(pass).matches()){
            txtInpPasswordR.setError("at least 1 special character,at least 4 characters");
            return false;
        }
        else {
            txtInpPasswordR.setErrorEnabled(false);
        }
        if(cnfpass.isEmpty()){
            inpTextcnfPasswordR.setError("Field can't be Empty...!!!");
            return false;
        }else if(!pass.equals(cnfpass)){
            inpTextcnfPasswordR.setError("Password Should be Same...!!!");
            return false;
        } else {
            inpTextcnfPasswordR.setErrorEnabled(false);
        }
        return true;
    }
}
