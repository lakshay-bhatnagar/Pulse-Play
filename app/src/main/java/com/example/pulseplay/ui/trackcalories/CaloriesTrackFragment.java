package com.example.pulseplay.ui.trackcalories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pulseplay.R;
import com.google.android.material.button.MaterialButton;

public class CaloriesTrackFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_calories_track, container, false);

        Fragment calorietrack = new CaloriesTrackFragment();
        EditText caloriesInput = view.findViewById(R.id.track_calorie_edttxt);
        MaterialButton trackBtn = view.findViewById(R.id.track_calorie_btn);
        trackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = caloriesInput.getText().toString();
                if (!userInput.isEmpty()) {
                    int totalCalories = Integer.parseInt(userInput);

                    if (totalCalories <= 0){
                        Toast.makeText(getActivity(), "Please enter a valid value of calories.", Toast.LENGTH_SHORT).show();
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putInt("calories", totalCalories);

                        // Navigate to HomeFragment
                        Navigation.findNavController(v).navigate(R.id.action_caloriesTrackFragment_to_nav_home, bundle);
                    }
                    // Create a bundle to pass the data
                }
            }
        });

        return view;
    }
}