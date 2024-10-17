package com.example.pulseplay.ui.play;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pulseplay.R;
import com.example.pulseplay.databinding.FragmentPlayBinding;

public class PlayFragment extends Fragment {

    private FragmentPlayBinding binding;
    private CardView famous1;
    private CardView famous2;
    private CardView famous3;
    private CardView footballCard;
    private CardView cricketCard;
    private CardView volleyballCard;
    private CardView tennisCard;
    private CardView badmintonCard;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPlayBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        famous1 = binding.famousPlace1;
        famous2 = binding.famousPlace2;
        famous3 = binding.famousPlace3;

        Button bookBtn = root.findViewById(R.id.bookBtn);

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_play_to_bookFragment);
            }
        });

        Button joinButton = binding.joinBtn; // JAI SHREE RAM

        // navigating to join page

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_play_to_joinFragment);
            }
        });

        // navigating from famous places to their description

        famous1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_play_to_famous1Fragment);
            }
        });

        famous2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_play_to_famous2Fragment);
            }
        });

        famous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_play_to_famous3Fragment);
            }
        });

        footballCard = binding.sport1CardView;
        cricketCard = binding.sport2CardView;
        volleyballCard = binding.sport3CardView;
        tennisCard = binding.sport4CardView;
        badmintonCard = binding.sport5CardView;

        footballCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_play_to_playFootballFragment);
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