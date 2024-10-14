package com.example.pulseplay.ui.places;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pulseplay.databinding.FragmentFamous1Binding;
import com.example.pulseplay.R;

public class Famous1Fragment extends Fragment {

    private FragmentFamous1Binding fragmentFamous1Binding;
    private Button bookButton;
    private TextView place;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFamous1Binding = FragmentFamous1Binding.inflate(inflater, container, false);
        bookButton = fragmentFamous1Binding.bookBtn;
        place = fragmentFamous1Binding.placeNameTxtView;

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating a bundle that stores place name from famous place fragment and pass it to booking fragment
                Bundle bundle = new Bundle();
                String placeName = place.getText().toString();
                bundle.putString("place", placeName);

                Navigation.findNavController(v).navigate(R.id.action_famous1Fragment_to_bookFragment, bundle);
            }
        });
        View view = fragmentFamous1Binding.getRoot();


        return view;
    }
}