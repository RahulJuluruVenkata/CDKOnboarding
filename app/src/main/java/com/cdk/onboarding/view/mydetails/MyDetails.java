package com.cdk.onboarding.view.mydetails;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.view.base.CDKOnboardGenericActivity;

import rx.Observable;
import rx.Observer;
import rx.Subscription;

public class MyDetails extends CDKOnboardGenericActivity {

    private static final String TAG = "MyDetails";
    private Subscription subscription;
    private Observable<String> mObservable;
    private Observer<String> mObserver;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details);
        mTextView = (TextView)findViewById(R.id.txt_my_details);
        mObservable = Observable.just("My Details updated");
        mObserver = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                mTextView.setText(s);
            }
        };
    }


    public void subscribeNow(View view){
        mObservable.subscribe(mObserver);
    }
}
