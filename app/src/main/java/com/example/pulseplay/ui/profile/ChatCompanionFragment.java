package com.example.pulseplay.ui.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pulseplay.databinding.FragmentChatCompanionBinding;
import com.example.pulseplay.R;


public class ChatCompanionFragment extends Fragment {

    private FragmentChatCompanionBinding fragmentChatCompanionBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentChatCompanionBinding = FragmentChatCompanionBinding.inflate(inflater, container, false);
        View view = fragmentChatCompanionBinding.getRoot();

        return view;
    }
}