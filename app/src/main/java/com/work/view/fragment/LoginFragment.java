package com.work.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.work.view.DashboardActivity;
import com.work.view.R;
import com.work.view.logic.CheckLogin;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private EditText etLoginUsername, etLoginPassword;
    private Button btnLogin;
    private String loginUsername, loginPassword;
    private boolean result;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etLoginUsername = view.findViewById(R.id.etLoginUsername);
        etLoginPassword = view.findViewById(R.id.etLoginPassword);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsername = etLoginUsername.getText().toString();
                loginPassword = etLoginPassword.getText().toString();

                if (!TextUtils.isEmpty(loginUsername) && !TextUtils.isEmpty(loginPassword)) {
                    CheckLogin CheckLogin = new CheckLogin();
                    CheckLogin.setCheckLoginname(loginUsername);
                    CheckLogin.setCheckPassword(loginPassword);
                    result = CheckLogin.check();

                    if (result) {
                        etLoginUsername.getText().clear();
                        etLoginPassword.getText().clear();

                        Intent intent = new Intent(getActivity(), DashboardActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), "Username or password is invalid", Toast.LENGTH_LONG).show();
                        etLoginUsername.getText().clear();
                        etLoginPassword.getText().clear();
                    }
                } else {
                    if (TextUtils.isEmpty(loginUsername)) {
                        etLoginUsername.setError("Please enter  user name");
                    }
                    if (TextUtils.isEmpty(loginPassword)) {
                        etLoginPassword.setError("Please enter  password");
                    }
                }
            }
        });
        return view;
    }

}