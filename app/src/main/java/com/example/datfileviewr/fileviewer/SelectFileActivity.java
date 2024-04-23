package com.example.datfileviewr.fileviewer;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datfileviewr.Utils.FileUtil;
import com.example.datfileviewr.databinding.ActivitySelectFileBinding;
import com.example.datfileviewr.viewpage.ViewPager.FileTypeViewerFragment;
import com.example.datfileviewr.viewpage.ViewPager.ViewPagerAdaptor;
import com.example.safesdk.sample.analytics.events.RedirectEvent;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;


public  class SelectFileActivity extends AppCompatActivity
{
    private final int PICKFILE_REQUEST_CODE = 1234;

    public ActivitySelectFileBinding binding;
    public Animation bounce_animation;
    public ArrayList<File> datList;
    public ArrayList<File> pdfList;
    public ArrayList<File> winList;



    public static void SelectFile(SelectFileActivity p0, Intent p1, int p2) {
        if (p1 != null) {
            p0.startActivityForResult(p1, p2);
        }
    }


    public static void SelectFile1(SelectFileActivity p0, Intent p1) {

        if (p1 != null) {
            p0.startActivity(p1);
        }
    }



    public  ActivitySelectFileBinding getBinding() {
        ActivitySelectFileBinding activitySelectFileBinding = this.binding;
        return activitySelectFileBinding;
    }

    public  void setBinding(ActivitySelectFileBinding activitySelectFileBinding) {
        this.binding = activitySelectFileBinding;
    }

    public  ArrayList<File> getDatList() {
        ArrayList<File> arrayList = this.datList;
        return arrayList;
    }

    public  void setDatList(ArrayList<File> arrayList) {
        this.datList = arrayList;
    }

    public  ArrayList<File> getWinList() {
        ArrayList<File> arrayList = this.winList;
        return arrayList;
    }

    public  void setWinList(ArrayList<File> arrayList) {
        this.winList = arrayList;
    }

    public  ArrayList<File> getPdfList() {
        ArrayList<File> arrayList = this.pdfList;
        return arrayList;
    }

    public  void setPdfList(ArrayList<File> arrayList) {
        this.pdfList = arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivitySelectFileBinding inflate = ActivitySelectFileBinding.inflate(getLayoutInflater());
        setBinding(inflate);
        setContentView(Objects.requireNonNull(getBinding()).getRoot());
        setDatList(new ArrayList<>());
        setWinList(new ArrayList<>());
        setPdfList(new ArrayList<>());



        new MyCustomAsyncTask(this).execute();

        getBinding().backId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getBinding().floatingAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity();
            }
        });

    }
    @SuppressLint("StaticFieldLeak")
    public class MyCustomAsyncTask extends AsyncTask<Void,Void,Void> {
        private final Context context;
        ProgressDialog progressDialog;
        public MyCustomAsyncTask(Context context){
            this.context=context;
        }
        @Override
        protected void onPreExecute() {
            // write show progress Dialog code here
            super.onPreExecute();
            progressDialog = new ProgressDialog(SelectFileActivity.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(true);
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            // write service code here
            getBinding().viewpager.setVisibility(View.GONE);
            getDatFiles();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ViewPagerAdaptor viewPagerAdaptor = new ViewPagerAdaptor(getSupportFragmentManager());
            Bundle bundle2 = new Bundle();
            bundle2.putString("str1", "from_files");
            bundle2.putString("str2", "save_dat");
            FileTypeViewerFragment fileTypeViewerFragment = new FileTypeViewerFragment();
            fileTypeViewerFragment.setArguments(bundle2);
            fileTypeViewerFragment.setArguments(bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("str1", "from_files");
            bundle3.putString("str2", "save_winmail");
            FileTypeViewerFragment fileTypeViewerFragment2 = new FileTypeViewerFragment();
            fileTypeViewerFragment2.setArguments(bundle3);
            fileTypeViewerFragment2.setArguments(bundle3);
            viewPagerAdaptor.addFragment(fileTypeViewerFragment, "Dat Files");
            viewPagerAdaptor.addFragment(fileTypeViewerFragment2, "Winmail Files");
            getBinding().viewpager.setAdapter(viewPagerAdaptor);
            TabLayout tabLayout = getBinding().tabs;
            tabLayout.setupWithViewPager(getBinding().viewpager);
            getBinding().viewpager.setVisibility(View.VISIBLE);
            progressDialog.dismiss();

        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.PICKFILE_REQUEST_CODE && i2 == -1) {
            Intrinsics.checkNotNull(intent);
            Uri data = intent.getData();
            Intrinsics.checkNotNull(data);
            File from = null;
            try {
                from = FileUtil.mstaicfun.from(this, data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String name = from.getName();
            if (!StringsKt.contains(name, ".dat", false)) {
                String name2 = from.getName();
                if (!StringsKt.contains(name2, ".DAT", false)) {
                    String name3 = from.getName();
                    if (!StringsKt.contains(name3, "winmail.dat", false)) {
                        Toast.makeText(this, "Please choose .dat or winmail.dat file", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
            String absolutePath = from.getAbsolutePath();
            Log.d("TAG13","ss"+ absolutePath);
            intentToViewer(absolutePath);
        }

    }

    private  void getDatFiles() {
           Cursor query = getContentResolver().query(MediaStore.Files.getContentUri(RedirectEvent.f3284h), new String[]{"_data", "title", "_size", "date_modified"}, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(0);
                Intrinsics.checkNotNullExpressionValue(string, "uri");
                String lowerCase = string.toLowerCase(Locale.ROOT);
                if (StringsKt.endsWith(lowerCase, ".DAT", true)) {
                    String lowerCase2 = string.toLowerCase(Locale.ROOT);
                    if (!StringsKt.endsWith(lowerCase2, "winmail.dat", true)) {
                        Log.d("ContentValues", "getTiffFiles:uriiii" + string);
                        getDatList().add(new File(string));
                    }
                }
                String lowerCase3 = string.toLowerCase(Locale.ROOT);
                if (StringsKt.endsWith(lowerCase3, "winmail.dat", true)) {
                    Log.d("ContentValues", "getTiffFiles:uriiii222" + string);
                    getWinList().add(new File(string));
                } else {
                    CharSequence charSequence = string;
                    if (StringsKt.contains(charSequence, ".pdf", false) ||
                            StringsKt.contains(charSequence, ".PDF", false)) {
                        Log.d("ContentValues", "getTiffFiles:uriiii" + string);
                        getPdfList().add(new File(string));
                    }
                }
            }
            query.close();
        }
    }

    private  void startNewActivity() {
       Intent intent = new Intent();
       intent.setAction("android.intent.action.GET_CONTENT");
       intent.setType("*/*");
       SelectFile(this, Intent.createChooser(intent, "Select File"), 1234);

    }

    public  void intentToViewer(String str) {
        SelectFile1(this, new Intent(this, FileViewerActivity.class).putExtra("filePath", str));
    }


}

