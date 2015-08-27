package com.tarunsoft.RecordManager.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tarunsoft.RecordManager.Handler.SessionManager;
import com.tarunsoft.RecordManager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private Context mContext;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

   View rootView =  inflater.inflate(R.layout.fragment_login, container, false);
        inputEmail = (EditText)rootView.findViewById(R.id.email);
        inputPassword = (EditText)rootView.findViewById(R.id.password);
        btnLogin = (Button)rootView.findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button)rootView.findViewById(R.id.btnLinkToRegisterScreen);
        mContext = getActivity();
    // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                // Check for empty data in the form
                if (email.trim().length() > 0 && password.trim().length() > 0) {
                    // login user
                  //  checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(mContext,
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }
            }

        });

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SecondFragment fragment = new SecondFragment();
                fragmentTransaction.add(R.id.flContent, fragment);
                fragmentTransaction.commit();
            }
        });
        return rootView;

       
    }


}
