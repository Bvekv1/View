package com.work.view.ui.slideshow;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.work.view.R;

import com.work.view.adapter.DetailsAdapter;
import com.work.view.model.Details;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SlideshowFragment extends Fragment {
    private CircleImageView imgProfile;
    private RecyclerView recyclerView;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        imgProfile = root.findViewById(R.id.imgProfile);
        recyclerView = root.findViewById(R.id.recyclerView);
        List<Details> detailsList = new ArrayList<>();
        detailsList.add(new Details("Villers","9867897255", R.drawable.adb));
        detailsList.add(new Details("ViratKholi","9869843488", R.drawable.virat));
        detailsList.add(new Details("Harbjan","9876543224", R.drawable.harbajan));
        detailsList.add(new Details("Karthik","9889765430", R.drawable.kartik));

        DetailsAdapter detailsAdapter = new DetailsAdapter(getActivity(), detailsList);
        recyclerView.setAdapter(detailsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}