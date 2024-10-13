package com.example.pulseplay.ui.companion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pulseplay.databinding.FragmentJoinBinding;
import com.example.pulseplay.R;


public class JoinFragment extends Fragment {

    private FragmentJoinBinding joinFragmentBinding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        joinFragmentBinding = FragmentJoinBinding.inflate(inflater, container, false);
        View view = joinFragmentBinding.getRoot();

        return view;
    }
}