package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.datfileviewr.R;
import tech.joeyck.bigedittext.BigEditText;

public  class ActivityFileViewerBinding implements ViewBinding {
    public  ImageView backId;
    public TextView filetitle;
    public  CardView cardConvertToPdf;
    public  CardView cardSave;
    public  RelativeLayout relativeToolDatviewer;
    private  RelativeLayout rootView;
    public  BigEditText textFileContent;

    private ActivityFileViewerBinding(RelativeLayout relativeLayout, ImageView imageView, CardView cardView, CardView cardView2, RelativeLayout relativeLayout2, BigEditText bigEditText,TextView filetitle) {
        this.rootView = relativeLayout;
        this.backId = imageView;
        this.cardConvertToPdf = cardView;
        this.cardSave = cardView2;
        this.relativeToolDatviewer = relativeLayout2;
        this.textFileContent = bigEditText;
        this.filetitle = filetitle ;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFileViewerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityFileViewerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_file_viewer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityFileViewerBinding bind(View view) {
        int i = R.id.back_id;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.back_id);
        if (imageView != null) {
            i = R.id.card_convert_to_pdf;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_convert_to_pdf);
            if (cardView != null) {
                i = R.id.card_save;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, R.id.card_save);
                if (cardView2 != null) {
                    i = R.id.relative_tool_datviewer;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.relative_tool_datviewer);
                    if (relativeLayout != null) {
                        i = R.id.text_fileContent;
                        BigEditText bigEditText = (BigEditText) ViewBindings.findChildViewById(view, R.id.text_fileContent);
                        if (bigEditText != null) {
                            i = R.id.filetitle;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.filetitle);
                            return new ActivityFileViewerBinding((RelativeLayout) view, imageView, cardView, cardView2, relativeLayout, bigEditText,textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
