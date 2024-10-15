package com.example.pulseplay.ui.loginsignup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulseplay.R;
import com.example.pulseplay.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding fragmentLoginBinding;
    private EditText emailEdtTxt;
    private EditText passwordEdtTxt;
    private Button loginButton;
    private TextView newUserTxtView;

    private String newEmailId;
    private String newPassword;
    private String newFullname;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = fragmentLoginBinding.getRoot();

        emailEdtTxt = fragmentLoginBinding.emailidLoginpage;
        passwordEdtTxt = fragmentLoginBinding.passwordLoginpage;
        loginButton = fragmentLoginBinding.loginBtn;
        newUserTxtView = fragmentLoginBinding.newUserText;


        // new user created from sign up page
        if (getArguments() != null){
            newEmailId = getArguments().getString("newEmail");
            newPassword = getArguments().getString("newPassword");
            newFullname = getArguments().getString("newFullname");
        }

        // actions performing after pressing login button

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = emailEdtTxt.getText().toString();
                String password = passwordEdtTxt.getText().toString();

                if ((emailId.equals("admin@pulseplay.com") && password.equals("password")) || emailId.equals(newEmailId) && password.equals(newPassword)){
                    Bundle bundle = new Bundle();
                    bundle.putString("userFullname", newFullname);
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_nav_home, bundle);
                } else {
                    Toast.makeText(getActivity(),"Please enter valid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // actions performing after pressing new user textview

        newUserTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_signinFragment);
            }
        });

        return view;
    }
}