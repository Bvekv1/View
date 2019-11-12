package  com.work.view.ui.gallery;



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

//import com.rohankharel.recyclerviewfragments.R;
import com.work.view.R;
import com.work.view.ui.gallery.GalleryViewModel;

public class GalleryFragment extends Fragment {

    private EditText etFirstNumber, etSecondNumber;
    private Button btnCalculate;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(com.work.view.ui.gallery.GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        etFirstNumber = root.findViewById(R.id.etFirstNumber);
        etSecondNumber = root.findViewById(R.id.etSecondNumber);
        btnCalculate = root.findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first = Integer.parseInt(etFirstNumber.getText().toString());
                int second = Integer.parseInt(etSecondNumber.getText().toString());
                int result = first + second;
                Toast.makeText(getActivity(), "Total Sum is " + result, Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}