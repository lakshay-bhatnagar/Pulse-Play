package com.example.pulseplay.ui.loginsignup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.pulseplay.databinding.FragmentPreferencesBinding;
import com.example.pulseplay.R;
import com.google.android.material.button.MaterialButton;


public class PreferencesFragment extends Fragment {

    private FragmentPreferencesBinding fragmentPreferencesBinding;
    private MaterialButton doneButton;
    private String passingData;
    private CheckBox cricket,football,volleyball,tennis,badminton,hockey,tabletennis,basketball;
    private int checkBoxCnt;
    private EditText usernamePref,agePref,localityPref;
    private RadioButton malePref,femalePref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentPreferencesBinding = FragmentPreferencesBinding.inflate(inflater, container, false);
        View view = fragmentPreferencesBinding.getRoot();

        if (getArguments() != null){
            passingData = getArguments().getString("userFullname");
        }

        doneButton = fragmentPreferencesBinding.doneBtnPref;
        usernamePref = fragmentPreferencesBinding.uniqueUsername;
        agePref = fragmentPreferencesBinding.agePreferences;
        localityPref = fragmentPreferencesBinding.localityPreferences;
        cricket = fragmentPreferencesBinding.cricketCheckbox;
        football = fragmentPreferencesBinding.footballCheckbox;
        volleyball = fragmentPreferencesBinding.volleyballCheckbox;
        tennis = fragmentPreferencesBinding.tennisCheckbox;
        badminton = fragmentPreferencesBinding.badmintonCheckbox;
        hockey = fragmentPreferencesBinding.hockeyCheckbox;
        tabletennis = fragmentPreferencesBinding.tabletennisCheckbox;
        basketball = fragmentPreferencesBinding.basketballCheckbox;

        malePref = fragmentPreferencesBinding.maleRadioPreferences;
        femalePref = fragmentPreferencesBinding.femaleRadioPreferences;


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamePrefer = usernamePref.getText().toString();
                String agePrefer = agePref.getText().toString();
                String localityPrefer = localityPref.getText().toString();
                // checking if at least 3 sports are filled or not
                if (cricket.isChecked()){
                    checkBoxCnt++;
                }
                if (football.isChecked()){
                    checkBoxCnt++;
                }
                if (volleyball.isChecked()){
                    checkBoxCnt++;
                }
                if (tennis.isChecked()){
                    checkBoxCnt++;
                }
                if (badminton.isChecked()){
                    checkBoxCnt++;
                }
                if (hockey.isChecked()){
                    checkBoxCnt++;
                }
                if (tabletennis.isChecked()){
                    checkBoxCnt++;
                }
                if (basketball.isChecked()){
                    checkBoxCnt++;
                }
                if (TextUtils.isEmpty(usernamePrefer) || TextUtils.isEmpty(agePrefer) || TextUtils.isEmpty(localityPrefer)){
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else if (checkBoxCnt < 3){
                    Toast.makeText(getActivity(), "Please fill atleast 3 sports preference", Toast.LENGTH_SHORT).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("userFullname", passingData);
                    Navigation.findNavController(v).navigate(R.id.action_preferencesFragment_to_nav_home, bundle);
                }
            }
        });

        return view;
    }
}