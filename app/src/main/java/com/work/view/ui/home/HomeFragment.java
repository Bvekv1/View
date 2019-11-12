package com.work.view.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.work.view.R;

public class HomeFragment extends Fragment {
    private EditText etRadius;
    private Button btnAreaOfCircle;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        etRadius = root.findViewById(R.id.etRadius);
        btnAreaOfCircle = root.findViewById(R.id.btnAreaOfCircle);
        btnAreaOfCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float radius = Float.parseFloat(etRadius.getText().toString());
                float result = 3.14f * radius * radius;
                Toast.makeText(getActivity(), "Area of the circle is " + result, Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }
}
