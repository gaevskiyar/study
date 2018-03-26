package com.example.gand.myfirstapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by gand on 24.03.18.
 */

public class FrDialog extends DialogFragment {
    private DialogCallback mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DialogCallback){
            mCallback = (DialogCallback) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public static final String TAG = FrDialog.class.getSimpleName();
    public static void show(FragmentManager fragmentManager){
        FrDialog infoDialog = new FrDialog();
        infoDialog.show(fragmentManager, TAG);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.fr_layout, null);
        builder.setTitle("Info")
                .setView(inflate)
                .setNegativeButton("false", null)
                .setPositiveButton("true", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mCallback.setPositiveResult("УРАААА!!!! Работает! ))");
                    }
                });
        return builder.create();
    }
    public interface DialogCallback{
        void setPositiveResult(String result);
    }
}
