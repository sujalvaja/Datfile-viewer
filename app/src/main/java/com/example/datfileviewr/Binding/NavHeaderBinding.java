package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import com.example.datfileviewr.R;


public  class NavHeaderBinding implements ViewBinding {
    public  LinearLayout headerView;
    public  ImageView imageView;
    private  LinearLayout rootView;

    private NavHeaderBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2) {
        this.rootView = linearLayout;
        this.headerView = linearLayout2;
        this.imageView = imageView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NavHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NavHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.nav_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NavHeaderBinding bind(View view) {
        int i = R.id.headerView;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.headerView);
        if (linearLayout != null) {
            i = R.id.imageView;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView);
            if (imageView2 != null) {
                return new NavHeaderBinding((LinearLayout) view, linearLayout, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
