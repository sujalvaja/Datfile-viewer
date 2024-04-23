package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.example.datfileviewr.R;

public  class BackpressLayoutBinding implements ViewBinding {
    public  MaterialCardView cancelBtn;
    public  FrameLayout mrecContainer;
    public  CardView rateusBtn;
    private  CardView rootView;

    private BackpressLayoutBinding(CardView cardView, MaterialCardView materialCardView, FrameLayout frameLayout, CardView cardView2) {
        this.rootView = cardView;
        this.cancelBtn = materialCardView;
        this.mrecContainer = frameLayout;
        this.rateusBtn = cardView2;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static BackpressLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BackpressLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.backpress_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BackpressLayoutBinding bind(View view) {
        int i = R.id.cancelBtn;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.cancelBtn);
        if (materialCardView != null) {
            i = R.id.mrec_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.mrec_container);
            if (frameLayout != null) {
                i = R.id.rateusBtn;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.rateusBtn);
                if (cardView != null) {
                    return new BackpressLayoutBinding((CardView) view, materialCardView, frameLayout, cardView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
