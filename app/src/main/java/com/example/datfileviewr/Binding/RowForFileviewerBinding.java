package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import com.example.datfileviewr.R;


public  class RowForFileviewerBinding implements ViewBinding {
    public  RelativeLayout cardFileSelected;
    public  TextView fileNameId;
    public  TextView fileSizeId;
    public  ImageView iconFile;
    public RadioButton btnfavourite;
    public  ImageView moreDots;
    private final RelativeLayout rootView;

    private RowForFileviewerBinding(RelativeLayout relativeLayout, RelativeLayout cardView, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2 , RadioButton imageView3) {
        this.rootView = relativeLayout;
        this.cardFileSelected = cardView;
        this.fileNameId = textView;
        this.fileSizeId = textView2;
        this.iconFile = imageView;
        this.moreDots = imageView2;
        this.btnfavourite = imageView3;
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RowForFileviewerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowForFileviewerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_for_fileviewer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowForFileviewerBinding bind(View view) {
        int i = R.id.card_file_selected;
        RelativeLayout cardView = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.card_file_selected);
        if (cardView != null) {
            i = R.id.file_name_id;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.file_name_id);
            if (textView != null) {
                i = R.id.file_size_id;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.file_size_id);
                if (textView2 != null) {
                    i = R.id.icon_file;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon_file);
                    if (imageView != null) {
                        i = R.id.more_dots;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.more_dots);
                        if (imageView2 != null) {
                            i = R.id.btnfavourite;
                            RadioButton imageView3 = (RadioButton) ViewBindings.findChildViewById(view ,R.id.btnfavourite);
                            if (imageView3 != null) {
                                return new RowForFileviewerBinding((RelativeLayout) view, cardView, textView, textView2, imageView, imageView2 , imageView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
