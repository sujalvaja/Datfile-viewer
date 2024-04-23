package com.example.datfileviewr.SavedFiles;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.example.datfileviewr.databinding.ActivitySavedFilesBinding;
import com.example.datfileviewr.viewpage.ViewPager.FileTypeViewerFragment;
import com.example.datfileviewr.viewpage.ViewPager.ViewPagerAdaptor;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.util.ArrayList;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public class SavedFilesActivity extends AppCompatActivity {
    public ActivitySavedFilesBinding binding;
    private ArrayList<File> list_of_dat_files = new ArrayList();
    private ArrayList<File> list_of_pdf_files = new ArrayList();
    private ArrayList<File> list_of_win_files = new ArrayList();


    public ActivitySavedFilesBinding getBinding() {
        ActivitySavedFilesBinding activitySavedFilesBinding = this.binding;
        if (activitySavedFilesBinding != null) {
            return activitySavedFilesBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String) "binding");
        return null;
    }

    public void setBinding(ActivitySavedFilesBinding activitySavedFilesBinding) {
        Intrinsics.checkNotNullParameter((Object) activitySavedFilesBinding, (String) "<set-?>");
        this.binding = activitySavedFilesBinding;
    }

    public ArrayList<File> getList_of_dat_files() {
        return this.list_of_dat_files;
    }

    public void setList_of_dat_files(ArrayList<File> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, (String) "<set-?>");
        this.list_of_dat_files = arrayList;
    }

    public ArrayList<File> getList_of_pdf_files() {
        return this.list_of_pdf_files;
    }

    public void setList_of_pdf_files(ArrayList<File> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, (String) "<set-?>");
        this.list_of_pdf_files = arrayList;
    }

    public ArrayList<File> getList_of_win_files() {
        return this.list_of_win_files;
    }

    public void setList_of_win_files(ArrayList<File> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, (String) "<set-?>");
        this.list_of_win_files = arrayList;
    }

    protected void onCreate(Bundle bundle) {
        ActivitySavedFilesBinding activitySavedFilesBinding = ActivitySavedFilesBinding.inflate((LayoutInflater) this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue((Object) activitySavedFilesBinding, (String) "inflate(layoutInflater)");
        this.setBinding(activitySavedFilesBinding);
        super.onCreate(bundle);
        this.setContentView((View) this.getBinding().getRoot());
        Context context = (Context) this;
        File[] arrfile = new File(this.getExternalFilesDir("Saved Files"), "").listFiles();
        for (File file : arrfile) {
            block9:
            {
                block8:
                {
                    String string = file.getName();
                    if (StringsKt.contains((CharSequence) string, (CharSequence) ".dat", (boolean) false))
                        break block8;
                    String string2 = file.getName();
                    if (!StringsKt.contains((CharSequence) string2, (CharSequence) ".DAT", (boolean) false))
                        break block9;
                }
                String string = file.getName();
                if (!StringsKt.contains((CharSequence) string, (CharSequence) ".winmail.dat", (boolean) false)) {
                    this.list_of_dat_files.add((File) file);
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
                    this.list_of_pdf_files.add((File) file);
                    continue;
                }
            }
            this.list_of_win_files.add((File) file);
        }
        StringBuilder stringBuilder = new StringBuilder("onCreate: ");
        stringBuilder.append(this.list_of_dat_files.size());
        Log.d((String) "TAG files list", (String) stringBuilder.toString());
        ViewPagerAdaptor viewPagerAdaptor = new ViewPagerAdaptor(this.getSupportFragmentManager());
        Bundle bundle2 = new Bundle();
        bundle2.putString("str1", "from_saved");
        bundle2.putString("str2", "save_dat");
        FileTypeViewerFragment fileTypeViewerFragment = new FileTypeViewerFragment();
        fileTypeViewerFragment.setArguments(bundle2);
        fileTypeViewerFragment.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putString("str1", "from_saved");
        bundle3.putString("str2", "save_winmail");
        FileTypeViewerFragment fileTypeViewerFragment2 = new FileTypeViewerFragment();
        fileTypeViewerFragment2.setArguments(bundle3);
        fileTypeViewerFragment2.setArguments(bundle3);

        Bundle bundle4 = new Bundle();
        bundle4.putString("str1", "from_saved");
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
        getBinding().backId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


}

