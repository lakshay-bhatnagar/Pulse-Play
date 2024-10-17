package com.example.pulseplay.ui.places;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pulseplay.databinding.FragmentFamous3Binding;
import com.example.pulseplay.R;

public class Famous3Fragment extends Fragment {

    private FragmentFamous3Binding fragmentFamous3Binding;
    private TextView place;
    private Button bookButton, buyButton, rentButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFamous3Binding = FragmentFamous3Binding.inflate(inflater, container, false);

        place = fragmentFamous3Binding.placeNameTextView;
        bookButton = fragmentFamous3Binding.bookBtn;
        buyButton = fragmentFamous3Binding.buyBtn;
        rentButton = fragmentFamous3Binding.rentBtn;

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating a bundle that stores place name from famous place fragment and pass it to booking fragment
                Bundle bundle = new Bundle();
                String placeName = place.getText().toString();
                bundle.putString("place", placeName);

                Navigation.findNavController(v).navigate(R.id.action_famous3Fragment_to_bookFragment, bundle);
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_famous3Fragment_to_buyFragmentCricket);
            }
        });

        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_famous3Fragment_to_rentFragmentCricket);
            }
        });

        View view = fragmentFamous3Binding.getRoot();

        return view;
    }
}