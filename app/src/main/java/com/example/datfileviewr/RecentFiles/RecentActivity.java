package com.example.datfileviewr.RecentFiles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.example.datfileviewr.Binding.ActivityRecentBinding;
import com.example.datfileviewr.viewpage.ViewPager.FileTypeViewerFragment;
import com.example.datfileviewr.viewpage.ViewPager.ViewPagerAdaptor;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import io.paperdb.Paper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public  class RecentActivity extends AppCompatActivity {

    public ActivityRecentBinding binding;
    private ArrayList<File> list_of_dat_files = new ArrayList<>();
    private ArrayList<File> list_of_pdf_files = new ArrayList<>();
    private ArrayList<File> list_of_win_files = new ArrayList<>();

    public  ActivityRecentBinding getBinding() {
        ActivityRecentBinding activityRecentBinding = this.binding;
        if (activityRecentBinding != null) {
            return activityRecentBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String) "binding");
        return null;
    }

    public  void setBinding(ActivityRecentBinding activityRecentBinding) {
        this.binding = activityRecentBinding;
    }

    public  ArrayList<File> getList_of_dat_files() {
        return this.list_of_dat_files;
    }

    public  void setList_of_dat_files(ArrayList<File> arrayList) {
        this.list_of_dat_files = arrayList;

    }

    public  ArrayList<File> getList_of_pdf_files() {
        return this.list_of_pdf_files;
    }

    public  void setList_of_pdf_files(ArrayList<File> arrayList) {
        this.list_of_pdf_files = arrayList;
    }

    public  ArrayList<File> getList_of_win_files() {
        return this.list_of_win_files;
    }

    public  void setList_of_win_files(ArrayList<File> arrayList) {
        this.list_of_win_files = arrayList;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityRecentBinding activityRecentBinding = ActivityRecentBinding.inflate((LayoutInflater) this.getLayoutInflater());
        this.setBinding(activityRecentBinding);

       this.setContentView((View) this.getBinding().getRoot());
        ArrayList arrayList = (ArrayList) Paper.book().read("recent_db", new ArrayList());
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            File file;
            block9:
            {
                block8:
                {
                    file = new File((String) iterator.next());
                    String string = file.getName();
                    if (StringsKt.contains((CharSequence) string, (CharSequence) ".dat", (boolean) false))
                        break block8;
                    String string2 = file.getName();
                    if (!StringsKt.contains((CharSequence) string2, (CharSequence) ".DAT", (boolean) false)) {
                        break block9;
                    }
                }
                String string = file.getName();
                if (!StringsKt.contains(string, "winmail", false)) {
                    this.list_of_dat_files.add(file);
                    continue;
                }
            }
            String string = file.getName();
            if (!StringsKt.contains((CharSequence) string, (CharSequence) ".winmail.dat", (boolean) false)) {
                String string3 = file.getName();
                if (!StringsKt.contains((CharSequence) string3, (CharSequence) ".winmail.DAT", (boolean) false)) {
                    String string4 = file.getName();
                    if (!StringsKt.contains((CharSequence) string4, (CharSequence) ".pdf", (boolean) false)) {
                        String string5 = file.getName();
                        if (!StringsKt.contains((CharSequence) string5, (CharSequence) ".PDF", (boolean) false))
                            continue;
                    }
                    this.list_of_pdf_files.add(file);
                    continue;
                }
            }
            this.list_of_win_files.add(file);
        }
        ViewPagerAdaptor viewPagerAdaptor = new ViewPagerAdaptor(this.getSupportFragmentManager());
        Bundle bundle2 = new Bundle();
        bundle2.putString("str1", "from_recent");
        bundle2.putString("str2", "save_dat");
        FileTypeViewerFragment fileTypeViewerFragment = new FileTypeViewerFragment();
        fileTypeViewerFragment.setArguments(bundle2);
        fileTypeViewerFragment.setArguments(bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("str1", "from_recent");
        bundle3.putString("str2", "save_win");
        FileTypeViewerFragment fileTypeViewerFragment2 = new FileTypeViewerFragment();
        fileTypeViewerFragment2.setArguments(bundle3);
        fileTypeViewerFragment2.setArguments(bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putString("str1", "from_recent");
        bundle4.putString("str2", "save_pdf");
        FileTypeViewerFragment fileTypeViewerFragment3 = new FileTypeViewerFragment();
        fileTypeViewerFragment3.setArguments(bundle4);
        fileTypeViewerFragment3.setArguments(bundle4);
        viewPagerAdaptor.addFragment((Fragment) fileTypeViewerFragment, "Dat Files");
        viewPagerAdaptor.addFragment((Fragment) fileTypeViewerFragment2, "Winmail Files");
        viewPagerAdaptor.addFragment((Fragment) fileTypeViewerFragment3, "PDF Files");
        this.getBinding().viewpager.setAdapter((PagerAdapter) viewPagerAdaptor);
        TabLayout tabLayout = this.getBinding().tabs;
        tabLayout.setupWithViewPager(this.getBinding().viewpager);
           this.getBinding().backId.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   onBackPressed();
               }
           });
    }
}


