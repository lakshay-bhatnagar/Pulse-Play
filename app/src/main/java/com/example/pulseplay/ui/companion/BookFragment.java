package com.example.pulseplay.ui.companion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pulseplay.databinding.FragmentBookBinding;
import com.example.pulseplay.R;
import com.google.android.material.button.MaterialButton;


public class BookFragment extends Fragment {

    private FragmentBookBinding fragmentBookBinding;
    private EditText name;
    private EditText date;
    private EditText joinPeople;
    private EditText reqPeople;
    private EditText place;
    private MaterialButton cancelBtn;
    private MaterialButton submitBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentBookBinding = FragmentBookBinding.inflate(inflater, container, false);
        View view = fragmentBookBinding.getRoot();

        name = fragmentBookBinding.nameEditText;
        date = fragmentBookBinding.dateEditTxt;
        joinPeople = fragmentBookBinding.numberOfPeopleEdtTxt;
        reqPeople = fragmentBookBinding.reqPeopleEdtTxt;
        place = fragmentBookBinding.placeEditTxt;
        cancelBtn = fragmentBookBinding.cancelBtn;
        submitBtn = fragmentBookBinding.playSubmitBtn;

        String username = name.getText().toString();
        String bookingDate = date.getText().toString();
        String currPeople = joinPeople.getText().toString();
        String requiredPeople = reqPeople.getText().toString();

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.cancel_btn_action_bookFragment_to_nav_play);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(name.getText()) || TextUtils.isEmpty(date.getText()) || TextUtils.isEmpty(joinPeople.getText()) || TextUtils.isEmpty(reqPeople.getText()) || TextUtils.isEmpty(place.getText())){
                    Toast.makeText(getActivity(),"Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {

                    Bundle bundle = new Bundle();
                    bundle.putString("name", username.toUpperCase());
                    bundle.putString("date", bookingDate);
                    bundle.putString("curr", currPeople);
                    bundle.putString("req", requiredPeople);
                    Navigation.findNavController(v).navigate(R.id.play_btn_action_bookFragment_to_successfulBookingFragment, bundle);
                }
            }
        });

        return view;
    }
}