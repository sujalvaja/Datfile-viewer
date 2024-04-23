package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import com.example.datfileviewr.R;



public  class DialogSaveFileBinding implements ViewBinding {
    public  CardView cardSave;
    public  EditText editTextDialog;
    public  RelativeLayout relativeEdittext;
    public  RelativeLayout relativeIconDialog;
    private  RelativeLayout rootView;
    public  ImageView saveImage;
    public  Spinner spinnerFileType;

    private DialogSaveFileBinding(RelativeLayout relativeLayout, CardView cardView, EditText editText, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, ImageView imageView, Spinner spinner) {
        this.rootView = relativeLayout;
        this.cardSave = cardView;
        this.editTextDialog = editText;
        this.relativeEdittext = relativeLayout2;
        this.relativeIconDialog = relativeLayout3;
        this.saveImage = imageView;
        this.spinnerFileType = spinner;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogSaveFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogSaveFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.custom_restore_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogSaveFileBinding bind(View view) {
        int i = R.id.card_save;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_save);
        if (cardView != null) {
            i = R.id.edit_text_dialog;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.edit_text_dialog);
            if (editText != null) {
                i = R.id.relative_edittext;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.relative_edittext);
                if (relativeLayout != null) {
                    i = R.id.relative_icon_dialog;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.relative_icon_dialog);
                    if (relativeLayout2 != null) {
                        i = R.id.save_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.save_image);
                        if (imageView != null) {
                            i = R.id.spinner_file_type;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.spinner_file_type);
                            if (spinner != null) {
                                return new DialogSaveFileBinding((RelativeLayout) view, cardView, editText, relativeLayout, relativeLayout2, imageView, spinner);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
