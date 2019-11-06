package com.githumainDashboard.githubcode.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.githumainDashboard.githubcode.MainActivity;
import com.githumainDashboard.githubcode.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment implements View.OnClickListener {
    TextInputLayout txtInputEmailAddress,txtInputPassword;
    TextInputEditText edtEmailAddress,edtPassword;
    Button btnLogin;
    String email,pass;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {

        View view= inflater.inflate(R.layout.fragment_login, container, false);
        txtInputEmailAddress=view.findViewById(R.id.txtInputEmailAddress);
        txtInputPassword=view.findViewById(R.id.txtInputPassword);
        edtEmailAddress=view.findViewById(R.id.edtEmailAddress);
        edtPassword=view.findViewById(R.id.edtPassword);
        btnLogin=view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                    if(validate()){
                        Intent intent= new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                break;
        }
    }
    private boolean validate(){
        email=txtInputEmailAddress.getEditText().getText().toString().trim();
        pass=txtInputPassword.getEditText().getText().toString().trim();
        if(email.isEmpty()){
            txtInputEmailAddress.setError("Field can't be Empty...!!!");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            txtInputEmailAddress.setError("Enter Valid Email Address...!!!");
            return false;
        } else {
            txtInputEmailAddress.setErrorEnabled(false);
        }
        if(pass.isEmpty()){
            txtInputPassword.setError("Field can't be Empty");
            return false;
        }else {
            txtInputPassword.setErrorEnabled(false);
        }
        return true;

    }
}
