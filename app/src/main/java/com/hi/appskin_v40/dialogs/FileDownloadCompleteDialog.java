package com.hi.appskin_v40.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.hi.appskin_v40.R;

public class FileDownloadCompleteDialog extends DialogFragment {
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = getLayoutInflater().inflate(R.layout.dialog_file_download_comlete, null);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Context context = getContext();
        if (context == null)
            return super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_file_download_comlete, null, false);
//        view.findViewById(R.id.button_Ok).setOnClickListener(v -> dismiss());
//        view.findViewById(R.id.never).setOnClickListener(v -> {
//            if (listener != null)
//                listener.onFinish();
//            dismiss();
//        });
//        view.findViewById(R.id.later).setOnClickListener(v -> dismiss());

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setCancelable(false)
                .setView(view);

        return builder.create();
    }
}
