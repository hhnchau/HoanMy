package phuthotech.vn.hospital.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.model.api.register.Combo;

/**
 * Created by kingpes on 9/22/18.
 */

public class DialogPatientDetail {
    private static DialogPatientDetail instance = null;

    public static DialogPatientDetail getInstance() {
        if (instance == null) {
            instance = new DialogPatientDetail();
        }
        return instance;
    }

    public interface OnClickListener {
        void onClickListener(int p);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void show(final Context context, Combo combo, OnClickListener onClickListener) {
        final Dialog dialog = new Dialog(context, R.style.MyAlert);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_patient_detail);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        if (window != null) {

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(ContextCompat.getColor(context, R.color.mainColor));
            }


            WindowManager.LayoutParams wlp = window.getAttributes();
            wlp.gravity = Gravity.CENTER;
            window.setAttributes(wlp);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            dialog.show();

            /*
            * VIEW
            */
            ConstraintLayout frame = dialog.findViewById(R.id.frame);


            frame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            WebView webView = dialog.findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true);

            webView.loadDataWithBaseURL("", context.getString(R.string.html_detail,
                    combo.getCode(),
                    combo.getName(),
                    combo.getName2(),
                    combo.getName3(),
                    combo.getName4(),
                    combo.getName1()), "text/html", "UTF-8", "");


            TextView tvEdit = dialog.findViewById(R.id.tvEdit);
            tvEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Goto Edit Patient
                    Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
