package com.work.view.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.work.view.R;
import com.work.view.logic.CheckLogin;
import com.work.view.model.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private EditText etRegisterUsername, etRegisterPassword, etConfirmPassword;
    private Button btnRegister;
    private String username, password, cPassword;
    private List<Users> usersList = new ArrayList<>();

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        EditText text;

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        etRegisterUsername = view.findViewById(R.id.etRegisterUsername);
        etRegisterPassword = view.findViewById(R.id.etRegisterPassword);
        etConfirmPassword = view.findViewById(R.id.etConfirmPassword);
        btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etRegisterUsername.getText().toString();
                password = etRegisterPassword.getText().toString();
                cPassword = etConfirmPassword.getText().toString();

                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(cPassword)){
                    if (!password.equals(cPassword)){
                        etConfirmPassword.setError("Password must match");
                    } else {

                        Users users = new Users();
                        users.setUser(username);
                        users.setUserPassword(password);
                        usersList.add(users);

                        CheckLogin checkUser = new CheckLogin();
                        checkUser.setUserListLogin(usersList);

                        Toast.makeText(getActivity(),"Registration Successful", Toast.LENGTH_LONG).show();
                        etRegisterUsername.getText().clear();
                        etRegisterPassword.getText().clear();
                        etConfirmPassword.getText().clear();
                    }
                } else {
                    if (TextUtils.isEmpty(username)){
                        etRegisterUsername.setError("Enter User Name");
                    } if (TextUtils.isEmpty(password)){
                        etRegisterPassword.setError("Enter Password");
                    } if (TextUtils.isEmpty(cPassword)){
                        etConfirmPassword.setError("Re-Enter password");
                    }
                }
            }
        });
        return view;
    }
}