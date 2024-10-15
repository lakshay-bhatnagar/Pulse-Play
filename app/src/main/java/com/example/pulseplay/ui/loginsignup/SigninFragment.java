package com.example.pulseplay.ui.loginsignup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulseplay.databinding.FragmentSigninBinding;
import com.example.pulseplay.R;


public class SigninFragment extends Fragment {

    private FragmentSigninBinding fragmentSigninBinding;
    private EditText newEmailEdtTxt;
    private EditText newPasswordEdtTxt;
    private EditText newPasswordConfirmEdtTxt;
    private EditText newFullName;
    private TextView alreadyUserTxtView;
    private Button signUpButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSigninBinding = FragmentSigninBinding.inflate(inflater, container, false);
        View view = fragmentSigninBinding.getRoot();

        newEmailEdtTxt = fragmentSigninBinding.newUseremail;
        newPasswordEdtTxt = fragmentSigninBinding.newUserpassword;
        newPasswordConfirmEdtTxt = fragmentSigninBinding.newUserconfirm;
        alreadyUserTxtView = fragmentSigninBinding.alreadyUser;
        signUpButton = fragmentSigninBinding.signupBtn;
        newFullName = fragmentSigninBinding.newUserfullname;

        // actions performing after pressing sign up button

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = newEmailEdtTxt.getText().toString();
                String password = newPasswordEdtTxt.getText().toString();
                String confirm = newPasswordConfirmEdtTxt.getText().toString();
                String fullname = newFullName.getText().toString();

                // checking conditions
                if (TextUtils.isEmpty(emailId) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirm)){
                    Toast.makeText(getActivity(), "Fill all the fields!", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirm)){
                    Toast.makeText(getActivity(), "Passwords does not match", Toast.LENGTH_SHORT).show();
                } else {
                    // creating a bundle to pass information to login page
                    Bundle bundle = new Bundle();
                    bundle.putString("newEmail", emailId);
                    bundle.putString("newPassword", password);
                    bundle.putString("newFullname", fullname);
                    Navigation.findNavController(v).navigate(R.id.action_signinFragment_to_loginFragment, bundle);
                }
            }
        });

        alreadyUserTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_signinFragment_to_loginFragment);
            }
        });

        return view;
    }
}