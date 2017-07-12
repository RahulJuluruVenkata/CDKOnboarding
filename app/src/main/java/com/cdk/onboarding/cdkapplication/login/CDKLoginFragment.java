package com.cdk.onboarding.cdkapplication.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.controller.LoginController;

public class CDKLoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cdk_login_fragment, container, false);

        EditText txtUserName = (EditText) view.findViewById(R.id.txt_login);
        EditText txtPassword = (EditText) view.findViewById(R.id.txt_password);
        Button loginButton = (Button) view.findViewById(R.id.btn_login);

        loginButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LoginController loginController = new LoginController();
                    if (loginController.isValidUser()) {
                        buttonClicked(view);
                    }
                }

                private void buttonClicked(View view) {

                }
            }
        );
        return view;
    }
}
