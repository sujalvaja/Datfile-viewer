package com.example.datfileviewr.viewpage.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.datfileviewr.Adaptor.FileViewerAdaptor;
import com.example.datfileviewr.FavouriteFiles.FavouriteFilesActivity;
import com.example.datfileviewr.Interface.DeleteInterface;
import com.example.datfileviewr.RecentFiles.RecentActivity;
import com.example.datfileviewr.SavedFiles.SavedFilesActivity;
import com.example.datfileviewr.databinding.FragmentFileTypeViewerBinding;
import com.example.datfileviewr.fileviewer.SelectFileActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import kotlin.jvm.internal.Intrinsics;


public class FileTypeViewerFragment extends Fragment implements DeleteInterface {
    public ArrayList<File> path_name;
    private FragmentFileTypeViewerBinding binding;
    private String intentFrom = "";
    private String type = "";
    private ArrayList<File> updated_path_name;

    public FragmentFileTypeViewerBinding getBinding() {
        return this.binding;
    }

    public void setBinding(FragmentFileTypeViewerBinding fragmentFileTypeViewerBinding) {
        this.binding = fragmentFileTypeViewerBinding;
    }

    public ArrayList<File> getUpdated_path_name() {
        return this.updated_path_name;
    }

    public void setUpdated_path_name(ArrayList<File> arrayList) {
        this.updated_path_name = arrayList;
    }

    public ArrayList<File> getPath_name() {
        ArrayList<File> arrayList = this.path_name;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("path_name");
        return null;
    }

    public void setPath_name(ArrayList<File> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.path_name = arrayList;
    }

    public String getIntentFrom() {
        return this.intentFrom;
    }

    public void setIntentFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.intentFrom = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public void onViewCreated(View view, Bundle bundle) {
        ArrayList<File> arrayList;
        ArrayList<File> arrayList2;
        ArrayList<File> arrayList3;
        ArrayList<File> arrayList4;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            Bundle arguments = getArguments();
            Intrinsics.checkNotNull(arguments);
            this.intentFrom = String.valueOf(arguments.getString("str1"));
            this.type = String.valueOf(arguments.getString("str2"));
            setPath_name(new ArrayList());
            String str = this.intentFrom;
            switch (str.hashCode()) {
                case -1806611038:
                    if (str.equals("from_files")) {
                        if (Intrinsics.areEqual((Object) this.type, (Object) "save_dat")) {
                            FragmentActivity requireActivity = requireActivity();
                            Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.example.datfileviewr.fileviewer.SelectFileActivity");
                            arrayList = ((SelectFileActivity) requireActivity).getDatList();
                        } else {
                            FragmentActivity requireActivity2 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity2, "null cannot be cast to non-null type com.example.datfileviewr.fileviewer.SelectFileActivity");
                            arrayList = ((SelectFileActivity) requireActivity2).getWinList();
                        }
                        setPath_name(arrayList);
                        Collections.sort(arrayList);
                        break;
                    }
                    break;
                case -1794833998:
                    if (str.equals("from_saved")) {
                        if (Intrinsics.areEqual((Object) this.type, (Object) "save_dat")) {
                            FragmentActivity requireActivity3 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity3, "null cannot be cast to non-null type com.example.datfileviewr.SavedFiles.SavedFilesActivity");
                            arrayList2 = ((SavedFilesActivity) requireActivity3).getList_of_dat_files();
                        } else if (Intrinsics.areEqual((Object) this.type, (Object) "save_winmail")) {
                            FragmentActivity requireActivity4 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity4, "null cannot be cast to non-null type com.example.datfileviewr.SavedFiles.SavedFilesActivity");
                            arrayList2 = ((SavedFilesActivity) requireActivity4).getList_of_win_files();
                        } else {
                            FragmentActivity requireActivity5 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity5, "null cannot be cast to non-null type com.example.datfileviewr.SavedFiles.SavedFilesActivity");
                            arrayList2 = ((SavedFilesActivity) requireActivity5).getList_of_pdf_files();
                        }
                        setPath_name(arrayList2);
                        Collections.sort(arrayList2);
                        break;
                    }
                    break;
                case 169220240:
                    if (str.equals("from_recent")) {
                        String str2 = this.type;
                        if (Intrinsics.areEqual((Object) str2, (Object) "save_dat")) {
                            FragmentActivity requireActivity6 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity6, "null cannot be cast to non-null type com.example.datfileviewr.RecentFiles.RecentActivity");
                            arrayList3 = ((RecentActivity) requireActivity6).getList_of_dat_files();
                        } else if (Intrinsics.areEqual((Object) str2, (Object) "save_win")) {
                            FragmentActivity requireActivity7 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity7, "null cannot be cast to non-null type com.example.datfileviewr.RecentFiles.RecentActivity");
                            arrayList3 = ((RecentActivity) requireActivity7).getList_of_win_files();
                        } else {
                            FragmentActivity requireActivity8 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity8, "null cannot be cast to non-null type com.example.datfileviewr.RecentFiles.RecentActivity");
                            arrayList3 = ((RecentActivity) requireActivity8).getList_of_pdf_files();
                        }
                        setPath_name(arrayList3);
                        Comparator c = Collections.reverseOrder();
                        Collections.sort(arrayList3,c);
                        break;
                    }
                    break;
                case 2003838111:
                    if (str.equals("from_favourites")) {
                        if (Intrinsics.areEqual((Object) this.type, (Object) "save_dat")) {
                            FragmentActivity requireActivity9 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity9, "null cannot be cast to non-null type com.example.datfileviewr.FavouriteFiles.FavouriteFilesActivity");
                            arrayList4 = ((FavouriteFilesActivity) requireActivity9).getList_of_dat_files();
                        } else if (Intrinsics.areEqual((Object) this.type, (Object) "save_win")) {
                            FragmentActivity requireActivity10 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity10, "null cannot be cast to non-null type com.example.datfileviewr.FavouriteFiles.FavouriteFilesActivity");
                            arrayList4 = ((FavouriteFilesActivity) requireActivity10).getList_of_win_files();
                        } else {
                            FragmentActivity requireActivity11 = requireActivity();
                            Intrinsics.checkNotNull(requireActivity11, "null cannot be cast to non-null type com.example.datfileviewr.FavouriteFiles.FavouriteFilesActivity");
                            arrayList4 = ((FavouriteFilesActivity) requireActivity11).getList_of_pdf_files();
                        }
                        setPath_name(arrayList4);
                        Comparator c = Collections.reverseOrder();
                        Collections.sort(arrayList4,c);
                        break;
                    }
                    break;
            }
            this.updated_path_name = new ArrayList<>();
            int size = getPath_name().size();
            for (int i = 0; i < size; i++) {
                if (getPath_name().get(i).exists()) {
                    ArrayList<File> arrayList5 = this.updated_path_name;
                    Intrinsics.checkNotNull(arrayList5);
                    arrayList5.add(getPath_name().get(i));
                }
            }
            FragmentFileTypeViewerBinding fragmentFileTypeViewerBinding = this.binding;
            Intrinsics.checkNotNull(fragmentFileTypeViewerBinding);
            fragmentFileTypeViewerBinding.recyclerviewFramePhotos.setLayoutManager(new LinearLayoutManager(getContext()));
            FragmentActivity requireActivity12 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity12, "requireActivity()");
            ArrayList<File> arrayList6 = this.updated_path_name;
            Intrinsics.checkNotNull(arrayList6);
            FileViewerAdaptor fileViewerAdaptor = new FileViewerAdaptor(requireActivity12, arrayList6, this.intentFrom, this.type, this);
            FragmentFileTypeViewerBinding fragmentFileTypeViewerBinding2 = this.binding;
            Intrinsics.checkNotNull(fragmentFileTypeViewerBinding2);
            fragmentFileTypeViewerBinding2.recyclerviewFramePhotos.setAdapter(fileViewerAdaptor);
        }
    }

    public void delete() {
        FragmentFileTypeViewerBinding fragmentFileTypeViewerBinding = this.binding;
        Intrinsics.checkNotNull(fragmentFileTypeViewerBinding);
        fragmentFileTypeViewerBinding.recyclerviewFramePhotos.setLayoutManager(new LinearLayoutManager(getContext()));
        FragmentFileTypeViewerBinding fragmentFileTypeViewerBinding2 = this.binding;
        Intrinsics.checkNotNull(fragmentFileTypeViewerBinding2);
        fragmentFileTypeViewerBinding2.recyclerviewFramePhotos.setHasFixedSize(true);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ArrayList<File> arrayList = this.updated_path_name;
        Intrinsics.checkNotNull(arrayList);
        FileViewerAdaptor fileViewerAdaptor = new FileViewerAdaptor(requireActivity, arrayList, "from_saved", this.type, this);
        FragmentFileTypeViewerBinding fragmentFileTypeViewerBinding3 = this.binding;
        Intrinsics.checkNotNull(fragmentFileTypeViewerBinding3);
        fragmentFileTypeViewerBinding3.recyclerviewFramePhotos.setAdapter(fileViewerAdaptor);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentFileTypeViewerBinding inflate = FragmentFileTypeViewerBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        Intrinsics.checkNotNull(inflate);
        FrameLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding!!.root");
        return root;
    }
}
