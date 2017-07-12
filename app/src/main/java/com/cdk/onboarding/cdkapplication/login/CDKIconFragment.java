package com.cdk.onboarding.cdkapplication.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdk.onboarding.cdkapplication.R;

/**
 * Created by julurur on 12/07/17.
 */

public class CDKIconFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cdk_icon_fragment, container, false);
        return view;
    }
}
