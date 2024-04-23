package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import com.example.datfileviewr.R;


public  class FragmentFileTypeViewerBinding implements ViewBinding {
    public  ImageView emptyStateId;
    public  RecyclerView recyclerviewFramePhotos;
    private  FrameLayout rootView;

    private FragmentFileTypeViewerBinding(FrameLayout frameLayout, ImageView imageView, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.emptyStateId = imageView;
        this.recyclerviewFramePhotos = recyclerView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFileTypeViewerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentFileTypeViewerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_file_type_viewer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentFileTypeViewerBinding bind(View view) {
        int i = R.id.empty_state_id;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.empty_state_id);
        if (imageView != null) {
            i = R.id.recyclerview_frame_photos;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerview_frame_photos);
            if (recyclerView != null) {
                return new FragmentFileTypeViewerBinding((FrameLayout) view, imageView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
