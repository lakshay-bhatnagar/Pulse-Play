package com.example.pulseplay.ui.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pulseplay.databinding.FragmentMyActivitesBinding;
import com.example.pulseplay.R;
import com.google.android.material.button.MaterialButton;

public class MyActivitesFragment extends Fragment {

    private FragmentMyActivitesBinding fragmentMyActivitesBinding;
    private MaterialButton chatComp1, chatComp2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMyActivitesBinding = FragmentMyActivitesBinding.inflate(inflater, container, false);
        View view = fragmentMyActivitesBinding.getRoot();

        chatComp1 = fragmentMyActivitesBinding.chat1;
        chatComp2 = fragmentMyActivitesBinding.chat2;

        chatComp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_myActivitesFragment_to_chatCompanionFragment);
            }
        });

        chatComp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_myActivitesFragment_to_chatCompanionFragment);
            }
        });

        return view;
    }
}