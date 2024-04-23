package com.example.datfileviewr;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.datfileviewr.Adaptor.MainAdaptor;
import com.example.datfileviewr.Binding.ActivityMainBinding;
import com.example.datfileviewr.FavouriteFiles.FavouriteFilesActivity;
import com.example.datfileviewr.Interface.DeleteInterface;
import com.example.datfileviewr.RecentFiles.RecentActivity;
import com.example.datfileviewr.SavedFiles.SavedFilesActivity;
import com.example.datfileviewr.fileviewer.SelectFileActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import io.paperdb.Paper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;


public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    DeleteInterface DeleteInterface;


    private String status = "";
    private final ArrayList<File> list_of_dat_files = new ArrayList<>();
    private final ArrayList<File> list_of_pdf_files = new ArrayList<>();
    private final ArrayList<File> list_of_win_files = new ArrayList<>();

    public static void m8455x902ef06(MainActivity p0, Intent p1) {
        if (p1 != null) {
            p0.startActivity(p1);
        }
    }

    public static void m8454xa4486d5(MainActivity p0, Intent p1, int p2) {
        if (p1 != null) {
            p0.startActivityForResult(p1, p2);
        }
    }

    public static void onCreate$lambda$0(MainActivity mainActivity) {

        if (mainActivity.status.equals("saved")) {
            m8455x902ef06(mainActivity, new Intent(mainActivity.getApplicationContext(), SavedFilesActivity.class));
            return;
        }
        mainActivity.intentToViewe();
    }



    public static void onCreate$lambda$2(MainActivity mainActivity) {
        mainActivity.status = "select";
        mainActivity.intentToViewe();
    }

    public static void onCreate$lambda$3(MainActivity mainActivity) {
        mainActivity.status = "recent";
        m8455x902ef06(mainActivity, new Intent(mainActivity.getApplicationContext(), RecentActivity.class));
    }

    public static void onCreate$lambda$4(MainActivity mainActivity) {
        mainActivity.status = "saved";
        m8455x902ef06(mainActivity, new Intent(mainActivity.getApplicationContext(), SavedFilesActivity.class));
    }

    public static void onCreate$lambda$5(MainActivity mainActivity) {
        mainActivity.status = "favourite";
        m8455x902ef06(mainActivity, new Intent(mainActivity.getApplicationContext(), FavouriteFilesActivity.class));
    }

    public static void onRequestPermissionsResult$lambda$6(MainActivity mainActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mainActivity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    public static void popUp$lambda$7(Dialog dialog, Activity activity) {

        dialog.dismiss();
        activity.finishAffinity();
    }

    public static void popUp$lambda$8(Dialog dialog, MainActivity mainActivity) {

        dialog.dismiss();
        m8455x902ef06(mainActivity, new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + mainActivity.getPackageName())));
    }



    public ActivityMainBinding getBinding() {
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding != null) {
            return activityMainBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public void setBinding(ActivityMainBinding activityMainBinding) {
        Intrinsics.checkNotNullParameter(activityMainBinding, "<set-?>");
        this.binding = activityMainBinding;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        setBinding(inflate);
        setContentView((View) getBinding().getRoot());
        Context context = this;

        FrameLayout frameLayout = getBinding().bannerContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bannerContainer");

        if (Build.VERSION.SDK_INT >= 30) {
            if (!Environment.isExternalStorageManager()) {
                requestPermission2();
            }
        } else if (!mcheckPermission()) {
            requestPermission();
        }
        Paper.init(context);

        getBinding().cardSelectDat.setOnClickListener(new MainActivityExternalSyntheticLambda5(this));
        getBinding().cardRecent.setOnClickListener(new MainActivityExternalSyntheticLambda6(this));
        getBinding().cardSavedFiles.setOnClickListener(new MainActivityExternalSyntheticLambda7(this));
        getBinding().cardFavourite.setOnClickListener(new MainActivityExternalSyntheticLambda8(this));
        // recentfile();

        new MyCustomAsyncTask(this).execute();
    }

    public void onResume() {
        super.onResume();
        new MyCustomAsyncTask(this).execute();
    }

    public class MyCustomAsyncTask extends AsyncTask<Void, Void, Void> {
        private final Context context;
        ProgressDialog progressDialog;
        private String status = "";
        private final ArrayList<File> list_of_dat_files = new ArrayList<>();
        private final ArrayList<File> list_of_pdf_files = new ArrayList<>();
        private final ArrayList<File> list_of_win_files = new ArrayList<>();
        public MyCustomAsyncTask(Context context){
            this.context=context;
        }
        @Override
        protected void onPreExecute() {
            // write show progress Dialog code here
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(true);
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            // write service code here
          //  getBinding().viewpager.setVisibility(View.GONE);
         //   getDatFiles();
            ArrayList arrayList = (ArrayList) Paper.book().read("recent_db", (Object) new ArrayList());
            assert arrayList != null;
            if (arrayList.isEmpty()) {
                getBinding().liear1Cards.setVisibility(View.GONE);

            } else {
                getBinding().liear1Cards.setVisibility(View.VISIBLE);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayList arrayList = (ArrayList) Paper.book().read("recent_db", (Object) new ArrayList());
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                File file;
                block9:
                {
                    block8:
                    {
                        file = new File((String)iterator.next());
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
                        MainAdaptor viewPagerAdaptor = new MainAdaptor(getApplicationContext(), list_of_dat_files, "", "", DeleteInterface);
                        viewPagerAdaptor.notifyDataSetChanged();
                        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
                        getBinding().recyclerview_frame_photos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        getBinding().recyclerview_frame_photos.setLayoutManager(layoutManager);
                        getBinding().recyclerview_frame_photos.setAdapter(viewPagerAdaptor);
                        Comparator<Object> c = Collections.reverseOrder();
                        Collections.sort(list_of_dat_files, c);
                        Log.d("TAG14", "as " + getBinding().recyclerview_frame_photos);
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
                        MainAdaptor viewPagerAdaptor1 = new MainAdaptor(getApplicationContext(), list_of_pdf_files, "", "", DeleteInterface);
                        viewPagerAdaptor1.notifyDataSetChanged();
                        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
                        getBinding().recyclerview_frame_photos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        getBinding().recyclerview_frame_photos.setLayoutManager(layoutManager);
                        getBinding().recyclerview_frame_photos.setAdapter(viewPagerAdaptor1);
                        viewPagerAdaptor1.notifyDataSetChanged();
                        Comparator<Object> c = Collections.reverseOrder();
                        Collections.sort(list_of_pdf_files, c);

                        continue;
                    }
                }
                this.list_of_win_files.add(file);
                MainAdaptor viewPagerAdaptor2 = new MainAdaptor(getApplicationContext(), list_of_win_files, "", "", DeleteInterface);
                viewPagerAdaptor2.notifyDataSetChanged();
                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
                getBinding().recyclerview_frame_photos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                getBinding().recyclerview_frame_photos.setLayoutManager(layoutManager);
                getBinding().recyclerview_frame_photos.setAdapter(viewPagerAdaptor2);
                viewPagerAdaptor2.notifyDataSetChanged();
                Comparator<Object> c = Collections.reverseOrder();
                Collections.sort(list_of_win_files, c);

            }
            progressDialog.dismiss();

        }
    }

    private boolean mcheckPermission() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) || ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.MANAGE_EXTERNAL_STORAGE") == 0;
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = true;
        if (i == 1 && iArr.length > 0) {
            if (iArr[0] != 0) {
                z = false;
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!z && shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE")) {
                    showMessageOKCancel(new MainActivityExternalSyntheticLambda2(this));
                }
            }
        }
    }


    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
    }

    private void requestPermission2() {
        try {
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.addCategory("android.intent.category.DEFAULT");
            String format = String.format("package:%s", Arrays.copyOf(new Object[]{getApplicationContext().getPackageName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            intent.setData(Uri.parse(format));
            m8454xa4486d5(this, intent, 2296);
        } catch (Exception unused) {
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
            m8454xa4486d5(this, intent2, 2296);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2296 && Build.VERSION.SDK_INT >= 30) {
            if (Environment.isExternalStorageManager()) {
                Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Allow permission for storage access!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void intentToViewe() {
        m8455x902ef06(this, new Intent(this, SelectFileActivity.class));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {

        return false;
    }

    private void showMessageOKCancel(DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(this).setMessage((CharSequence) "You need to allow access to both the permissions").setPositiveButton((CharSequence) "OK", onClickListener).setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) null).create().show();
    }
}
