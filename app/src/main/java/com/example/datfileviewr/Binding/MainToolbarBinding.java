package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import com.example.datfileviewr.R;


public  class MainToolbarBinding implements ViewBinding {
    private  Toolbar rootView;
    public  TextView textView;
    public  Toolbar toolbar;

    private MainToolbarBinding(Toolbar toolbar2, TextView textView2, Toolbar toolbar3) {
        this.rootView = toolbar2;
        this.textView = textView2;
        this.toolbar = toolbar3;
    }

    public Toolbar getRoot() {
        return this.rootView;
    }

    public static MainToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MainToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.main_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MainToolbarBinding bind(View view) {
        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textView);
        if (textView2 != null) {
            Toolbar toolbar2 = (Toolbar) view;
            return new MainToolbarBinding(toolbar2, textView2, toolbar2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.textView)));
    }
}
