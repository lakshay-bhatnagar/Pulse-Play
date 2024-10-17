package com.example.pulseplay.ui.profile;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pulseplay.R;
import com.example.pulseplay.databinding.FragmentProfileBinding;
import com.google.android.material.card.MaterialCardView;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private CardView logoutButton;
    private MaterialCardView myActivitesButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        myActivitesButton = binding.myactivitiesProfileBtn;
        logoutButton = binding.logoutProfileBtn;
        // navigating to login page after user taps on logout
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_profile_to_loginFragment);
            }
        });

        myActivitesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_profile_to_myActivitesFragment);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}