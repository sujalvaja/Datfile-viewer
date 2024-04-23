package com.example.datfileviewr.fileviewer;

import android.app.Dialog;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;


public  class FileViewerActivityshowSaveDialog implements View.OnClickListener {
      Dialog $dialog;
      Ref.ObjectRef<EditText> $eText;
      Ref.ObjectRef<CardView> $saveCard;
      Ref.ObjectRef<Spinner> $spinner;
      FileViewerActivity this$0;

    FileViewerActivityshowSaveDialog(FileViewerActivity fileViewerActivity, Ref.ObjectRef<CardView> objectRef, Ref.ObjectRef<EditText> objectRef2, Ref.ObjectRef<Spinner> objectRef3, Dialog dialog) {
        this.this$0 = fileViewerActivity;
        this.$saveCard = objectRef;
        this.$eText = objectRef2;
        this.$spinner = objectRef3;
        this.$dialog = dialog;
    }

    public void onClick(View view) {
        FileViewerActivity fileViewerActivity = this.this$0;

        Editable text = ((EditText) this.$eText.element).getText();
        Intrinsics.checkNotNullExpressionValue(text, "eText.text");
        if (!(text.length() == 0)) {
            FileViewerActivity fileViewerActivity2 = this.this$0;
            StringBuilder sb = new StringBuilder();
            sb.append(((EditText) this.$eText.element).getText());
            sb.append(((Spinner) this.$spinner.element).getSelectedItem());
            fileViewerActivity2.saveFile(sb.toString(), this.this$0.getBinding().textFileContent.getText().toString());
            this.$dialog.dismiss();
            return;
        }
        Toast.makeText(this.this$0, "File name cannot be empty!!", Toast.LENGTH_SHORT).show();
    }
}
