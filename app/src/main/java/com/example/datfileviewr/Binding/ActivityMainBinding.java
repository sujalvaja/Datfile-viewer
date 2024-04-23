package com.example.datfileviewr.Binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import com.example.datfileviewr.R;
import com.google.android.material.navigation.NavigationView;



public  class ActivityMainBinding implements ViewBinding {
    public  FrameLayout bannerContainer;
    public  CardView cardFavourite;
    public  CardView cardRecent;
    public  CardView cardSavedFiles;
    public  CardView cardSelectDat;
    public  TextView categoriesTextId;
    public  RelativeLayout drawerLayout;
    public  ImageView imageDat;
    public  ImageView imagePdf;
    public  ImageView imageSaved;
    public  ImageView imageWinmail;
    public  CardView liear1Cards;
    public  LinearLayout liear2Cards;
    public  LinearLayout linearToolMain;
    public  NavigationView navigationView;
    public  RelativeLayout relativeTitle;
    private  RelativeLayout rootView;
    public  TextView subtitleHome;
    public  TextView textDat;
    public  TextView textPdf;
    public  TextView textSaved;
    public  TextView textWinmail;
    public  TextView titleHome;
    public  MainToolbarBinding toolbarMainId;
    public RecyclerView recyclerview_frame_photos;

    private ActivityMainBinding(RelativeLayout advance3DDrawerLayout, FrameLayout frameLayout, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, TextView textView, RelativeLayout advance3DDrawerLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, CardView linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, NavigationView navigationView2, RelativeLayout relativeLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, MainToolbarBinding mainToolbarBinding , RecyclerView recyclerview_frame_photos) {
        this.rootView = advance3DDrawerLayout;
        this.bannerContainer = frameLayout;
        this.cardFavourite = cardView;
        this.cardRecent = cardView2;
        this.cardSavedFiles = cardView3;
        this.cardSelectDat = cardView4;
        this.categoriesTextId = textView;
        this.drawerLayout = advance3DDrawerLayout2;
        this.imageDat = imageView;
        this.imagePdf = imageView2;
        this.imageSaved = imageView3;
        this.imageWinmail = imageView4;
        this.liear1Cards = linearLayout;
        this.liear2Cards = linearLayout2;
        this.linearToolMain = linearLayout3;
        this.navigationView = navigationView2;
        this.relativeTitle = relativeLayout;
        this.subtitleHome = textView2;
        this.textDat = textView3;
        this.textPdf = textView4;
        this.textSaved = textView5;
        this.textWinmail = textView6;
        this.titleHome = textView7;
        this.toolbarMainId = mainToolbarBinding;
        this.recyclerview_frame_photos = recyclerview_frame_photos;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        View view2 = view;
        int i = R.id.banner_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.banner_container);
        if (frameLayout != null) {
            i = R.id.card_favourite;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.card_favourite);
            if (cardView != null) {
                i = R.id.card_recent;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.card_recent);
                if (cardView2 != null) {
                    i = R.id.card_savedFiles;
                    CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, R.id.card_savedFiles);
                    if (cardView3 != null) {
                        i = R.id.card_selectDat;
                        CardView cardView4 = (CardView) ViewBindings.findChildViewById(view2, R.id.card_selectDat);
                        if (cardView4 != null) {
                            i = R.id.categoriesText_id;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.categoriesText_id);
                            if (textView != null) {
                                RelativeLayout advance3DDrawerLayout = (RelativeLayout) view2;
                                i = R.id.image_dat;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.image_dat);
                                if (imageView != null) {
                                    i = R.id.image_pdf;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.image_pdf);
                                    if (imageView2 != null) {
                                        i = R.id.image_saved;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.image_saved);
                                        if (imageView3 != null) {
                                            i = R.id.image_winmail;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.image_winmail);
                                            if (imageView4 != null) {
                                                i = R.id.liear_1_cards;
                                                CardView linearLayout = (CardView) ViewBindings.findChildViewById(view2, R.id.liear_1_cards);
                                                if (linearLayout != null) {
                                                    i = R.id.liear_2_cards;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.liear_2_cards);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.linear_tool_main;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linear_tool_main);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.navigationView;
                                                            NavigationView navigationView2 = (NavigationView) ViewBindings.findChildViewById(view2, R.id.navigationView);
                                                            if (navigationView2 != null) {
                                                                i = R.id.relative_title;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.relative_title);
                                                                if (relativeLayout != null) {
                                                                    i = R.id.subtitleHome;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.subtitleHome);
                                                                    if (textView2 != null) {
                                                                        i = R.id.text_dat;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.text_dat);
                                                                        if (textView3 != null) {
                                                                            i = R.id.text_pdf;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.text_pdf);
                                                                            if (textView4 != null) {
                                                                                i = R.id.text_saved;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.text_saved);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.text_winmail;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.text_winmail);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.titleHome;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.titleHome);
                                                                                        if (textView7 != null){
                                                                                            i = R.id.recyclerview_frame_photos;
                                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2,R.id.recyclerview_frame_photos);
                                                                                            if(recyclerView != null){
                                                                                            i = R.id.toolbar_main_id;
                                                                                            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.toolbar_main_id);
                                                                                            if (findChildViewById != null) {
                                                                                                return new ActivityMainBinding(advance3DDrawerLayout, frameLayout, cardView, cardView2, cardView3, cardView4, textView, relativeLayout, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, linearLayout3, navigationView2, relativeLayout, textView2, textView3, textView4, textView5, textView6, textView7 , MainToolbarBinding.bind(findChildViewById),recyclerView);
                                                                                            }
                                                                                        }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));

    }
}
