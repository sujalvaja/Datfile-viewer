package com.example.datfileviewr;

import android.content.DialogInterface;


public   class MainActivityExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public   MainActivity f$0;

    public  MainActivityExternalSyntheticLambda2(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    public  void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.onRequestPermissionsResult$lambda$6(this.f$0);
    }
}
