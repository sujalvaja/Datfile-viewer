package com.example.datfileviewr.FavouriteFiles;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datfileviewr.Binding.ActivityFavouriteFilesBinding;
import com.example.datfileviewr.viewpage.ViewPager.FileTypeViewerFragment;
import com.example.datfileviewr.viewpage.ViewPager.ViewPagerAdaptor;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import io.paperdb.Paper;
import kotlin.jvm.internal.Intrinsics;

public  class FavouriteFilesActivity extends AppCompatActivity {
    public ActivityFavouriteFilesBinding binding;
    private ArrayList<File> list_of_dat_files = new ArrayList<>();
    private ArrayList<File> list_of_pdf_files = new ArrayList<>();
    private ArrayList<File> list_of_win_files = new ArrayList<>();

    public static  void onCreate$lambda$0() {
    }

    public  ActivityFavouriteFilesBinding getBinding() {
        ActivityFavouriteFilesBinding activityFavouriteFilesBinding = this.binding;
        if (activityFavouriteFilesBinding != null) {
            return activityFavouriteFilesBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public  void setBinding(ActivityFavouriteFilesBinding activityFavouriteFilesBinding) {
        Intrinsics.checkNotNullParameter(activityFavouriteFilesBinding, "<set-?>");
        this.binding = activityFavouriteFilesBinding;
    }


    public  ArrayList<File> getList_of_dat_files() {
        return this.list_of_dat_files;
    }

    public  void setList_of_dat_files(ArrayList<File> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list_of_dat_files = arrayList;
    }

    public  ArrayList<File> getList_of_win_files() {
        return this.list_of_win_files;
    }

    public  void setList_of_win_files(ArrayList<File> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list_of_win_files = arrayList;
    }

    public  ArrayList<File> getList_of_pdf_files() {
        return this.list_of_pdf_files;
    }

    public  void setList_of_pdf_files(ArrayList<File> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list_of_pdf_files = arrayList;
    }

    
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityFavouriteFilesBinding inflate = ActivityFavouriteFilesBinding.inflate(getLayoutInflater());
        setBinding(inflate);
        setContentView((View) getBinding().getRoot());
        Context context = this;

        FrameLayout frameLayout = getBinding().bannerContainer;

        ArrayList arrayList = (ArrayList) Paper.book().read("fav_files_dat", new ArrayList());
        ArrayList arrayList2 = (ArrayList) Paper.book().read("fav_files_win", new ArrayList());
        ArrayList arrayList3 = (ArrayList) Paper.book().read("fav_files_pdf", new ArrayList());
        StringBuilder sb = new StringBuilder("onCreate: ");
        Intrinsics.checkNotNull(arrayList);
        sb.append(arrayList.size());
        Log.d("TAG dat size", sb.toString());
        StringBuilder sb2 = new StringBuilder("onCreate: ");
        Intrinsics.checkNotNull(arrayList2);
        sb2.append(arrayList2.size());
        Log.d("TAG win size", sb2.toString());
        StringBuilder sb3 = new StringBuilder("onCreate: ");
        Intrinsics.checkNotNull(arrayList3);
        sb3.append(arrayList3.size());
        Log.d("TAG win size", sb3.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.list_of_dat_files.add(new File((String) it.next()));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.list_of_win_files.add(new File((String) it2.next()));
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            this.list_of_pdf_files.add(new File((String) it3.next()));
        }

        getBinding().backId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        ViewPagerAdaptor viewPagerAdaptor = new ViewPagerAdaptor(getSupportFragmentManager());
        Bundle bundle2 = new Bundle();
        bundle2.putString("str1", "from_favourites");
        bundle2.putString("str2", "save_dat");
        FileTypeViewerFragment fileTypeViewerFragment = new FileTypeViewerFragment();
        fileTypeViewerFragment.setArguments(bundle2);
        fileTypeViewerFragment.setArguments(bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("str1", "from_favourites");
        bundle3.putString("str2", "save_win");
        FileTypeViewerFragment fileTypeViewerFragment2 = new FileTypeViewerFragment();
        fileTypeViewerFragment2.setArguments(bundle3);
        fileTypeViewerFragment2.setArguments(bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putString("str1", "from_favourites");
        bundle4.putString("str2", "save_pdf");
        FileTypeViewerFragment fileTypeViewerFragment3 = new FileTypeViewerFragment();
        fileTypeViewerFragment3.setArguments(bundle4);
        fileTypeViewerFragment3.setArguments(bundle4);
        viewPagerAdaptor.addFragment(fileTypeViewerFragment, "Dat Files");
        viewPagerAdaptor.addFragment(fileTypeViewerFragment2, "Winmail Files");
        viewPagerAdaptor.addFragment(fileTypeViewerFragment3, "PDF Files");
        getBinding().viewpager.setAdapter(viewPagerAdaptor);
        TabLayout tabLayout = getBinding().tabs;
        tabLayout.setupWithViewPager(getBinding().viewpager);
    }
}

