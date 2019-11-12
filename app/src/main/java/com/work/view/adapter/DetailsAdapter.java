package com.work.view.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.work.view.ContactActivity;
import com.work.view.R;
import com.work.view.model.Details;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {

    Context context;
    List<Details> DetailsList;

    public DetailsAdapter(Context context, List<Details> DetailsList) {
        this.context = context;
        this.DetailsList = DetailsList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        final Details Details = DetailsList.get(position);
        holder.imgProfile.setImageResource(Details.getImageId());
        holder.tvName.setText(Details.getName());
        holder.tvPhoneNo.setText(Details.getPhoneNo());

        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContactActivity.class);
                intent.putExtra("Image", Details.getImageId());
                intent.putExtra("Name", Details.getName());
                intent.putExtra("Phone", Details.getPhoneNo());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DetailsList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgProfile;
        TextView tvName, tvPhoneNo;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhoneNo = itemView.findViewById(R.id.tvPhoneNo);
        }
    }
}
