package phuthotech.vn.hospital.sheet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.custom.MyEditText;
import phuthotech.vn.hospital.dialog.DialogPatientDetail;

/**
 * Created by kingpes on 9/21/18.
 */

public class SheetDoctor {
    private static SheetDoctor instance = null;

    public static SheetDoctor getInstance() {
        if (instance == null) {
            instance = new SheetDoctor();
        }
        return instance;
    }

    private Dialog dialog;

    public interface OnItemClickListener {
        void onItemClickListener(int p);
    }

    public void show(final Context context, OnItemClickListener onItemClickListener) {
        if (context != null) {
            dialog = new Dialog(context, R.style.MyAlert);
            dialog.setOwnerActivity((Activity) context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.sheet_doctor_item);
            dialog.setCancelable(false);

            Window window = dialog.getWindow();
            if (window != null) {

                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(ContextCompat.getColor(context, R.color.mainColor));
                }


                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.windowAnimations = R.style.SlideBottom2Top;
                wlp.gravity = Gravity.CENTER;
                window.setAttributes(wlp);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.show();

                 /*
                 * View
                */
                final View view = dialog.findViewById(R.id.header);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                ListView listView = dialog.findViewById(R.id.list);
                MyEditText input = dialog.findViewById(R.id.edt);
                ImageView search = dialog.findViewById(R.id.img);



                List<String> s = new ArrayList<>();

                for (int i = 0; i < 100; i++)
                    s.add("1");

                SheetDoctorAdapter adapter = new SheetDoctorAdapter(context, s);
                listView.setAdapter(adapter);


            }

        }
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }
}

class SheetDoctorAdapter extends ArrayAdapter<String> {
    private Context context;

    private List<String> lists;


    SheetDoctorAdapter(@NonNull Context context, List<String> lists) {
        super(context, 0, lists);
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.sheet_doctor_item_list, parent, false);
        }


        //TextView t = convertView.findViewById(R.id.txt);

        //t.setText(lists.getPatient(position));





        return convertView;
    }
}
