package com.cdk.onboarding.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cdk.onboarding.CDKApplication;
import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.view.base.Home;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private LinearLayout prof_section;
    private Button signOut;
    private SignInButton signIn;
    private TextView Name, Email;
    private ImageView prof_pic;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_sign_in);

        prof_section = (LinearLayout) findViewById(R.id.prof_section);
        signOut = (Button) findViewById(R.id.btn_logout_google_account);
        signIn = (SignInButton) findViewById(R.id.btn_google_sign_in);
        Name = (TextView) findViewById(R.id.txt_google_username);
        Email = (TextView) findViewById(R.id.txt_google_user_email);
        prof_pic = (ImageView) findViewById(R.id.prof_pic);

        signIn.setOnClickListener(this);
        signOut.setOnClickListener(this);

        prof_section.setVisibility(View.GONE);
        googleApiClient = CDKApplication.getGoogleApiHelper().getGoogleApiClient();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_google_sign_in:
                signIn();
                break;
            case R.id.btn_logout_google_account:
                signOut();
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, REQ_CODE);

    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        prof_section.setVisibility(View.GONE);
                        signIn.setVisibility(View.VISIBLE);
                    }
                }
        );
    }

    private void handleResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            updateUI(result,true);
        } else {
            updateUI(result,false);
        }
    }

    private void updateUI(GoogleSignInResult result,boolean isLogin) {
        if (isLogin) {
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            String img_url = account.getPhotoUrl()!=null ? account.getPhotoUrl().toString() : "profileicon";

            Intent myIntent = new Intent(this, Home.class);
            myIntent.putExtra("username",name);
            myIntent.putExtra("email",email);
            myIntent.putExtra("photoUrl",img_url);
            this.startActivity(myIntent);
            Toast.makeText(MainActivity.this, "Succesfully logged in.", Toast.LENGTH_SHORT).show();
        } else {
            prof_section.setVisibility(View.GONE);
            signIn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }
}
