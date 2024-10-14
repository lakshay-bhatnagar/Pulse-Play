package com.example.pulseplay.ui.companion;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulseplay.databinding.FragmentBookBinding;
import com.example.pulseplay.R;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;


public class BookFragment extends Fragment {

    private FragmentBookBinding fragmentBookBinding;
    private EditText name;
    private TextView date;
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
        date = fragmentBookBinding.dateTxtView;
        joinPeople = fragmentBookBinding.numberOfPeopleEdtTxt;
        reqPeople = fragmentBookBinding.reqPeopleEdtTxt;
        place = fragmentBookBinding.placeEditTxt;
        cancelBtn = fragmentBookBinding.cancelBtn;
        submitBtn = fragmentBookBinding.playSubmitBtn;

        // if booking is done from famous places button, set place field of booking page to the famous place's name automatically
        if (getArguments() != null){
            place.setText(getArguments().getString("place"));
        }

        String username = name.getText().toString();
        String currPeople = joinPeople.getText().toString();
        String requiredPeople = reqPeople.getText().toString();

        // implementing date picker dialog box
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });

        // assigning value of date picked to bookingDate so that it can be passed as bundle
        String bookingDate = date.getText().toString();

        // navigating user to previous screen after pressing cancel button
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.cancel_btn_action_bookFragment_to_nav_play);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if statement to ensure no field is empty
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