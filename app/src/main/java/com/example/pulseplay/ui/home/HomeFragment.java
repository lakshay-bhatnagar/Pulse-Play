package com.example.pulseplay.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.pulseplay.R;
import com.example.pulseplay.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private CardView tabToday;
    private CardView tabWeekly;
    private TextView tabTodayText;
    private TextView tabWeeklyText;
    private ImageButton addCalories;
    private SearchView searchView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tabToday = root.findViewById(R.id.tab_today_card);
        tabWeekly = root.findViewById(R.id.tab_weekly_card);
        tabTodayText = root.findViewById(R.id.tab_today_text);
        tabWeeklyText = root.findViewById(R.id.tab_weekly_text);
        addCalories = root.findViewById(R.id.addCaloriesBtn);
        searchView = root.findViewById(R.id.searchView);

        if (getArguments() != null) {
            int calories = getArguments().getInt("calories");
            updateMacros(calories);
        }
        // Set default states
        setSelectedTab(tabToday, tabTodayText, tabWeekly, tabWeeklyText);

        // Set click listeners for each tab
        tabToday.setOnClickListener(v -> setSelectedTab(tabToday, tabTodayText, tabWeekly, tabWeeklyText));
        tabWeekly.setOnClickListener(v -> setSelectedTab(tabWeekly, tabWeeklyText, tabToday, tabTodayText));

        addCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_home_to_caloriesTrackFragment);
            }
        });

        // todo : Have to add functionality for 'Calories Burned' button and check for daily and weekly tabs data to update dynamically
        // todo : learn how streak feature works so that it can be implemented actually

        return root;
    }

    private void updateMacros(int totalCalories) {
        int carbs = (int) (totalCalories * 0.50); // 50% calories from carbs
        int protein = (int) (totalCalories * 0.30); // 30% calories from protein
        int fat = (int) (totalCalories * 0.20); // 20% calories from fat

        // Assuming you have TextViews to display these values
        TextView carbsTextView = binding.carbsNumber;
        TextView proteinTextView = binding.proteinNumber;
        TextView fatTextView = binding.fatNumber;

        carbsTextView.setText(String.valueOf(carbs));
        proteinTextView.setText(String.valueOf(protein));
        fatTextView.setText(String.valueOf(fat));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setSelectedTab(CardView selectedTab, TextView selectedText, CardView unselectedTab, TextView unselectedText) {
        // Set the selected tab's appearance
        selectedTab.setCardBackgroundColor(Color.WHITE);
        selectedTab.setCardElevation(4f);
        selectedText.setTextColor(Color.BLACK);

        // Set the unselected tab's appearance
        unselectedTab.setCardBackgroundColor(Color.parseColor("#1E1E1E"));
        unselectedTab.setCardElevation(0f);
        unselectedText.setTextColor(Color.parseColor("#F5F5F5"));
    }
}