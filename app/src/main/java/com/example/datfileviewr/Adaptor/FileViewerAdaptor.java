package com.example.datfileviewr.Adaptor;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datfileviewr.Binding.RowForFileviewerBinding;
import com.example.datfileviewr.Interface.DeleteInterface;
import com.example.datfileviewr.R;
import com.example.datfileviewr.fileviewer.FileViewerActivity;
import com.itextpdf.text.Annotation;

import java.io.File;
import java.util.ArrayList;

import io.paperdb.Paper;
import kotlin.jvm.internal.Intrinsics;


public class FileViewerAdaptor extends RecyclerView.Adapter<FileViewerAdaptor.viewHolder> {
    private final Context context;
    private final DeleteInterface delInter;
    private final ArrayList<File> filesList;
    private final String intentFrom;
    private final String type;
    public RowForFileviewerBinding binding;
    int i;

    public FileViewerAdaptor(Context context2, ArrayList<File> arrayList, String str, String str2, DeleteInterface deleteInterface) {
        this.context = context2;
        this.filesList = arrayList;
        this.intentFrom = str;
        this.type = str2;
        this.delInter = deleteInterface;
    }

    public static void startActivity1(Context p0, Intent p1) {
        if (p1 != null) {
            p1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            p0.startActivity(p1);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public static boolean onBindViewHolderlambda1lambda0(FileViewerAdaptor fileViewerAdaptor, int i, MenuItem menuItem) {

        if (Intrinsics.areEqual(menuItem.toString(), "Delete File")) {
            fileViewerAdaptor.filesList.get(i).delete();
            fileViewerAdaptor.filesList.remove(i);
            fileViewerAdaptor.notifyDataSetChanged();
            fileViewerAdaptor.delInter.delete();
            return true;
        } else if (Intrinsics.areEqual(menuItem.toString(), "Share File")) {
            fileViewerAdaptor.shareFile(i);
            return true;
        } else if (Intrinsics.areEqual(menuItem.toString(), "Add to Favourite")) {
            if (Intrinsics.areEqual(fileViewerAdaptor.type, "save_dat")) {
                String absolutePath = fileViewerAdaptor.filesList.get(i).getAbsolutePath();
                fileViewerAdaptor.addfavData(absolutePath, "fav_files_dat");
                fileViewerAdaptor.addfavData(absolutePath, "fav_files_dat");
                return true;
            } else if (Intrinsics.areEqual(fileViewerAdaptor.type, "save_pdf")) {
                String absolutePath2 = fileViewerAdaptor.filesList.get(i).getAbsolutePath();
                fileViewerAdaptor.addfavData(absolutePath2, "fav_files_pdf");
                return true;
            } else {
                String absolutePath3 = fileViewerAdaptor.filesList.get(i).getAbsolutePath();
                fileViewerAdaptor.addfavData(absolutePath3, "fav_files_win");
                return true;
            }
        } else if (!Intrinsics.areEqual(menuItem.toString(), "Remove from Favourite")) {
            return true;
        } else {
            if (fileViewerAdaptor.type.equals("save_dat")) {
                String absolutePath4 = fileViewerAdaptor.filesList.get(i).getAbsolutePath();
                fileViewerAdaptor.removeFromFav(absolutePath4, "fav_files_dat", i);
            } else if (fileViewerAdaptor.type.equals("save_pdf")) {
                String absolutePath5 = fileViewerAdaptor.filesList.get(i).getAbsolutePath();
                fileViewerAdaptor.removeFromFav(absolutePath5, "fav_files_pdf", i);
            } else {
                String absolutePath6 = fileViewerAdaptor.filesList.get(i).getAbsolutePath();
                fileViewerAdaptor.removeFromFav(absolutePath6, "fav_files_win", i);
            }
            fileViewerAdaptor.filesList.remove(i);
            fileViewerAdaptor.notifyDataSetChanged();
            fileViewerAdaptor.delInter.delete();
            return true;
        }
    }

    public static void onBindViewHolderlambda2(FileViewerAdaptor fileViewerAdaptor, int i) {
        if (!fileViewerAdaptor.type.equals("save_pdf")) {
            File file = fileViewerAdaptor.filesList.get(i);
            String absolutePath = file.getAbsolutePath();
            fileViewerAdaptor.intentToViewer(absolutePath);
            Log.d("TAG14", "sa" + absolutePath);
            return;
        }
        fileViewerAdaptor.showSaveDialog();

    }

    public void onBindViewHolderlambda1(FileViewerAdaptor fileViewerAdaptor, viewHolder viewholder, int i) {


        PopupMenu popupMenu = new PopupMenu(fileViewerAdaptor.context, viewholder.getBinding().moreDots);
        switch (fileViewerAdaptor.intentFrom) {
            case "from_saved":
            case "from_files":
                popupMenu.getMenuInflater().inflate(R.menu.menu_more, popupMenu.getMenu());
                break;
            case "from_favourites":
                popupMenu.getMenuInflater().inflate(R.menu.fav_manu, popupMenu.getMenu());
                break;
            case "from_recent":
                popupMenu.getMenuInflater().inflate(R.menu.menu_recent, popupMenu.getMenu());
                break;
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onBindViewHolderlambda1lambda0(FileViewerAdaptor.this, i, item);
                return false;
            }
        });
        popupMenu.show();
    }

    public RowForFileviewerBinding getBinding() {
        return this.binding;
    }

    public void setBinding(RowForFileviewerBinding rowForFileviewerBinding) {
        this.binding = rowForFileviewerBinding;
    }

    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RowForFileviewerBinding inflate = RowForFileviewerBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        setBinding(inflate);
        return new viewHolder(getBinding());
    }

    public void onBindViewHolder(viewHolder viewholder, @SuppressLint("RecyclerView") int i) {
        getBinding().fileNameId.setText(this.filesList.get(i).getName());
        getBinding().fileSizeId.setText(getFolderSizeLabel(new File(this.filesList.get(i).getAbsolutePath())));
        getBinding().moreDots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBindViewHolderlambda1(FileViewerAdaptor.this, viewholder, i);
            }
        });

        getBinding().cardFileSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBindViewHolderlambda2(FileViewerAdaptor.this, i);
            }
        });
    }

    public String getFolderSizeLabel(File file) {
        Intrinsics.checkNotNullParameter(file, Annotation.FILE);
        double folderSize = ((double) getFolderSize(file)) / 1000.0d;
        if (folderSize >= 1024.0d) {
            return (folderSize / ((double) 1024)) + "MB";
        }
        return folderSize + "KB";
    }

    public long getFolderSize(File file) {
        Intrinsics.checkNotNullParameter(file, Annotation.FILE);
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        assert listFiles != null;
        for (File file2 : listFiles) {
            j += getFolderSize(file2);
        }
        return j;
    }

    public void showSaveDialog() {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_pdf_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        CardView okay_text = dialog.findViewById(R.id.card_yes);
        CardView cancel_text = dialog.findViewById(R.id.card_no);

        okay_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file2 = filesList.get(i);
                FileViewerAdaptor.this.OpenPDFFile(file2);
                dialog.show();
            }
        });

        cancel_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "no ", Toast.LENGTH_SHORT);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @SuppressLint("WrongConstant")
    public void OpenPDFFile(File file) {
        Intrinsics.checkNotNullParameter(file, "nameOfFile");
        Uri uriForFile = FileProvider.getUriForFile(this.context, this.context.getApplicationContext().getPackageName() + ".provider", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriForFile, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(1);
        startActivity1(this.context, intent);
    }

    private void removeFromFav(String str, String str2, int i) {
        Paper.init(this.context);
        ArrayList arrayList = Paper.book().read(str2, new ArrayList());
        Intrinsics.checkNotNull(arrayList);
        arrayList.remove(str);
        Paper.book().write(str2, arrayList);
        Toast.makeText(this.context, "Successfully removed from favourites.", Toast.LENGTH_SHORT).show();
    }

    public void addfavData(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(str2, "database");
        Paper.init(this.context);
        ArrayList arrayList = Paper.book().read(str2, new ArrayList());
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            arrayList2.add(str);
            Paper.book().write(str2, arrayList2);
        } else {
            arrayList.remove(str);
            arrayList.add(str);
            Paper.book().write(str2, arrayList);
        }
        Toast.makeText(this.context, "Successfully added to favourites.", Toast.LENGTH_SHORT).show();
    }

    private void shareFile(int i) {
        Intent intent = new Intent("android.intent.action.SEND");
        Uri parse = Uri.parse(this.filesList.get(i).getAbsolutePath());
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.STREAM", parse);
        startActivity1(this.context, Intent.createChooser(intent, "Share using"));
    }

    public int getItemCount() {
        return this.filesList.size();
    }

    public void intentToViewer(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        startActivity1(this.context, new Intent(this.context, FileViewerActivity.class).putExtra("filePath", str));
    }


    public static class viewHolder extends RecyclerView.ViewHolder {
        private RowForFileviewerBinding binding;


        public viewHolder(RowForFileviewerBinding rowForFileviewerBinding) {
            super(rowForFileviewerBinding.getRoot());
            Intrinsics.checkNotNullParameter(rowForFileviewerBinding, "binding");
            this.binding = rowForFileviewerBinding;
        }

        public RowForFileviewerBinding getBinding() {
            return this.binding;
        }

        public void setBinding(RowForFileviewerBinding rowForFileviewerBinding) {
            Intrinsics.checkNotNullParameter(rowForFileviewerBinding, "<set-?>");
            this.binding = rowForFileviewerBinding;
        }
    }
}
