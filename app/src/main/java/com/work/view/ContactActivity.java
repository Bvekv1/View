package com.work.view;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactActivity extends AppCompatActivity {

    CircleImageView imgProfileDetail;
    TextView tvNameDetail, tvPhoneNoDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        imgProfileDetail = findViewById(R.id.imgProfile);
        tvNameDetail = findViewById(R.id.tvName);
        tvPhoneNoDetail = findViewById(R.id.tvPhoneNo);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            imgProfileDetail.setImageResource(bundle.getInt("Image"));
            tvNameDetail.setText(bundle.getString("Name"));
            tvPhoneNoDetail.setText(bundle.getString("Phone"));
        }
    }
}
