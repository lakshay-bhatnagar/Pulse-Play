package com.example.pulseplay.ui.companion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pulseplay.databinding.FragmentSuccessfulBookingBinding;
import com.example.pulseplay.R;


public class SuccessfulBookingFragment extends Fragment {

    private FragmentSuccessfulBookingBinding fragmentSuccessfulBookingBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSuccessfulBookingBinding = FragmentSuccessfulBookingBinding.inflate(inflater, container, false);

        View view = fragmentSuccessfulBookingBinding.getRoot();

        if (getArguments() != null){

            String name = getArguments().getString("name");
            String date = getArguments().getString("date");
            String curr = getArguments().getString("curr");
            String req = getArguments().getString("req");

            TextView bookIdTxtView = view.findViewById(R.id.generatedBookingId);
            TextView bookDateTxtView = view.findViewById(R.id.bookingDate);
            TextView numberPeopleTxtView = view.findViewById(R.id.reqPeople);
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(date);
            sb.append(curr);
            sb.append(req);
            // setting booking id as name_date_currpeople_reqpeople
            bookIdTxtView.setText(sb.toString());

            bookDateTxtView.setText(date);
            numberPeopleTxtView.setText(curr);
        }

        return view;
    }
}