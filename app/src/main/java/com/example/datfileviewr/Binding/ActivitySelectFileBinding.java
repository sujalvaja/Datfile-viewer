package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import androidx.viewpager.widget.ViewPager;

import com.example.datfileviewr.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public  class ActivitySelectFileBinding implements ViewBinding {
    public  ImageView backId;
    public  FloatingActionButton floatingAdd;
    public  RelativeLayout relativeToolSaved;
    private  RelativeLayout rootView;
    public  TabLayout tabs;
    public  ViewPager viewpager;

    private ActivitySelectFileBinding(RelativeLayout relativeLayout, ImageView imageView, FloatingActionButton floatingActionButton, RelativeLayout relativeLayout2, TabLayout tabLayout, ViewPager viewPager) {
        this.rootView = relativeLayout;
        this.backId = imageView;
        this.floatingAdd = floatingActionButton;
        this.relativeToolSaved = relativeLayout2;
        this.tabs = tabLayout;
        this.viewpager = viewPager;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySelectFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySelectFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_select_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySelectFileBinding bind(View view) {
        int i = R.id.back_id;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.back_id);
        if (imageView != null) {
            i = R.id.floating_add;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.floating_add);
            if (floatingActionButton != null) {
                i = R.id.relative_tool_saved;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.relative_tool_saved);
                if (relativeLayout != null) {
                    i = R.id.tabs;
                    TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabs);
                    if (tabLayout != null) {
                        i = R.id.viewpager;
                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.viewpager);
                        if (viewPager != null) {
                            return new ActivitySelectFileBinding((RelativeLayout) view, imageView, floatingActionButton, relativeLayout, tabLayout, viewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
