package com.example.datfileviewr.fileviewer;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.datfileviewr.Binding.ActivityFileViewerBinding;
import com.example.datfileviewr.R;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.paperdb.Paper;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
public  class FileViewerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    
    public ActivityFileViewerBinding binding;

    private  Executor executor;
    public String filePath;
    private  Handler handler = new Handler(Looper.getMainLooper());

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public FileViewerActivity() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.executor = newSingleThreadExecutor;
    }

    public  String getFilePath() {
        String str = this.filePath;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filePath");
        return null;
    }

    public  void setFilePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filePath = str;
    }



  
    public  ActivityFileViewerBinding getBinding() {
        ActivityFileViewerBinding activityFileViewerBinding = this.binding;
        if (activityFileViewerBinding != null) {
            return activityFileViewerBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public  void setBinding(ActivityFileViewerBinding activityFileViewerBinding) {
        Intrinsics.checkNotNullParameter(activityFileViewerBinding, "<set-?>");
        this.binding = activityFileViewerBinding;
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityFileViewerBinding inflate = ActivityFileViewerBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        setBinding(inflate);
        setContentView((View) getBinding().getRoot());
        Context context = this;
        String stringExtra = getIntent().getStringExtra("filePath");
        Intrinsics.checkNotNull(stringExtra);
        setFilePath(stringExtra);
        Log.d("TAG13", "onCreate: " + getFilePath());
        addRecentData(context, getFilePath(), "recent_db");
        openDatFile(getFilePath());
        File file = new File(filePath);
        String strFileName = file.getName();
        getBinding().filetitle.setText(strFileName);
        getBinding().cardSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSaveDialog();
            }
        });
        getBinding().cardConvertToPdf.setOnClickListener(new FileViewerActivityExternalSyntheticLambda3(this));
        getBinding().backId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });
    }
    public static  void onCreate$lambda$1(FileViewerActivity fileViewerActivity, View view) {
            fileViewerActivity.converttoPDF();

    }

    public static  void onCreate$lambda$2(FileViewerActivity fileViewerActivity, View view) {
        fileViewerActivity.finish();
    }

    private  void converttoPDF() {
        if (!Intrinsics.areEqual(getBinding().textFileContent.getText(), (Object) "")) {
            this.executor.execute(new FileViewerActivityExternalSyntheticLambda0(this));
        } else {
            Toast.makeText(this, "Text is empty", Toast.LENGTH_SHORT).show();
        }
    }


    public static  void converttoPDF$lambda$4(FileViewerActivity fileViewerActivity) {
        fileViewerActivity.createPdf(fileViewerActivity.getBinding().textFileContent.getText());
        fileViewerActivity.handler.post(new FileViewerActivityExternalSyntheticLambda1(fileViewerActivity));
    }

    public static  void converttoPDF$lambda$4$lambda$3(FileViewerActivity fileViewerActivity) {
        Toast.makeText(fileViewerActivity, "File have been converted to pdf!", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("ResourceType")
    public  void showSaveDialog() {
        Dialog dialog = new Dialog(FileViewerActivity.this);
        dialog.setContentView(R.layout.custom_restore_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), 17367048, new String[]{".dat", ".winmail.dat"});
        arrayAdapter.setDropDownViewResource(17367049);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = dialog.findViewById(R.id.spinner_file_type);
        ((Spinner) objectRef.element).setAdapter(arrayAdapter);
        ((Spinner) objectRef.element).setOnItemSelectedListener(this);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = dialog.findViewById(R.id.edit_text_dialog);
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = dialog.findViewById(R.id.card_save);
        //  ((ImageView) dialog.findViewById(R.id.save_image)).startAnimation(getBounce_animation());
        ((CardView) objectRef3.element).setOnClickListener(new FileViewerActivityshowSaveDialog(this, objectRef3, objectRef2, objectRef, dialog));

        dialog.show();
      }

    public  void saveFile(String str, String str2) {
        try {
            File file = new File(getExternalFilesDir("Saved Files"), "");
            if (!file.exists()) {
                file.mkdirs();
            }
            FileWriter fileWriter = new FileWriter(new File(file, str));
            fileWriter.append(str2);
            fileWriter.flush();
            fileWriter.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public   void openDatFile(String r6)  {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            int i = 0;

            while ((line = br.readLine()) != null) {
                if(i == 0) getBinding().textFileContent.setText(line);
                else if(i == 1) getBinding().textFileContent.setText(line);
                i++;
            }
            br.close();
        }
        catch (IOException e) {
            //Handle error
        }

    }

    public  void createPdf(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Document document = new Document();
        try {
            File file = new File(getExternalFilesDir("Saved Files"), "");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(getFilePath());
            String name = file2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "filepth.name");
            String substring = name.substring(0, file2.getName().length() - 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            PdfWriter.getInstance(document, new FileOutputStream(new File(file, substring + ".pdf")));
            document.open();
            document.add(new Chunk(""));
            Paragraph paragraph = new Paragraph(str);
            paragraph.setAlignment(1);
            document.add(paragraph);
        } catch (DocumentException e) {
            Log.e("PDFCreator", "DocumentException:" + e);
        } catch (IOException e2) {
            Log.e("PDFCreator", "ioException:" + e2);
        } catch (ExceptionConverter e3) {
            Log.e("PDFCreator", "ioException:" + e3);
        } catch (Throwable th) {
            document.close();
            throw th;
        }
        document.close();
    }

    public  void addRecentData(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(str2, "database");
        Paper.init(context);
        ArrayList arrayList = (ArrayList) Paper.book().read(str2, new ArrayList());
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            arrayList2.add(str);
            Paper.book().write(str2, arrayList2);
            return;
        }
        if (arrayList.contains(str)) {
            arrayList.remove(str);
        }
        arrayList.add(str);
        Paper.book().write(str2, arrayList);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }


}
