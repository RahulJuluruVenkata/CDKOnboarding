package com.cdk.onboarding.cdkapplication.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.cdkapplication.home.CDKHomeGrid;
import com.cdk.onboarding.controller.LoginController;

public class CDKLoginFragment extends Fragment {

    private static final String TAG = "CDKTag_Login_Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cdk_login_fragment, container, false);
        setLoginButtonWithListener(view);
        return view;
    }

    private void setLoginButtonWithListener(View view){
        Button loginButton = (Button) view.findViewById(R.id.btn_login);
        final EditText txtUserName = (EditText) view.findViewById(R.id.txt_login);
        final EditText txtPassword = (EditText) view.findViewById(R.id.txt_password);
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoginController loginController = new LoginController();
                        if (loginController.isValidUser(txtUserName.getText().toString(),txtPassword.getText().toString())) {
                            buttonClicked(view);
                            Intent myIntent = new Intent(getActivity(), CDKHomeGrid.class);
                            getActivity().startActivity(myIntent);
                        }
                    }
                }
        );
    }

    public void buttonClicked(View view) {
        Log.i(TAG,"on login click of fragment");
    }
}
