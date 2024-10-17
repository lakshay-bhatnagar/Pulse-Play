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

import com.example.pulseplay.databinding.FragmentFamous2Binding;
import com.example.pulseplay.R;


public class Famous2Fragment extends Fragment {

    private FragmentFamous2Binding fragmentFamous2Binding;
    private Button bookButton, buyButton, rentButton;
    private TextView place;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFamous2Binding = FragmentFamous2Binding.inflate(inflater, container, false);

        place = fragmentFamous2Binding.placeNameTextView;
        bookButton = fragmentFamous2Binding.bookBtn;
        buyButton = fragmentFamous2Binding.buyBtn;
        rentButton = fragmentFamous2Binding.rentBtn;

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating a bundle that stores place name from famous place fragment and pass it to booking fragment
                Bundle bundle = new Bundle();
                String placeName = place.getText().toString();
                bundle.putString("place", placeName);

                Navigation.findNavController(v).navigate(R.id.action_famous2Fragment_to_bookFragment, bundle);
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_famous2Fragment_to_buyFragmentTableTennis);
            }
        });

        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_famous2Fragment_to_rentFragmentTableTennis);
            }
        });

        View view = fragmentFamous2Binding.getRoot();

        return view;
    }
}