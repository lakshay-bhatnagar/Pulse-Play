package com.example.pulseplay.ui.play;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pulseplay.databinding.FragmentPlayFootballBinding;
import com.example.pulseplay.R;

public class PlayFootballFragment extends Fragment {

    private FragmentPlayFootballBinding fragmentPlayFootballBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentPlayFootballBinding = FragmentPlayFootballBinding.inflate(inflater, container, false);

        View view = fragmentPlayFootballBinding.getRoot();

        return view;
    }
}