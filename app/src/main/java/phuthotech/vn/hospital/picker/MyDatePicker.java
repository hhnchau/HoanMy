package phuthotech.vn.hospital.picker;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;

import phuthotech.vn.hospital.R;

/**
 * Created by kingpes on 9/8/18.
 */

public class MyDatePicker {
    private static MyDatePicker instance = null;

    public static MyDatePicker getInstance() {
        if (instance == null) {
            instance = new MyDatePicker();
        }
        return instance;
    }

    private static final String[] DAY = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private static final String[] MONTH = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
    private static final String[] YEAR = new String[100];

    private static String  d;
    private static  String m;
    private static String y;

    public void show(final Context context, final OnDatePickerClickListener onDatePickerClickListener) {
        final Dialog dialog = new Dialog(context, R.style.MyLoading);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.datepicker_item);
        Window window = dialog.getWindow();
        if (window != null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimary));
                }
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
            TextView btnOk = dialog.findViewById(R.id.btnOK);
            PickerDate day = dialog.findViewById(R.id.day);
            PickerDate month = dialog.findViewById(R.id.month);
            final PickerDate year = dialog.findViewById(R.id.year);

            frame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //dialog.dismiss();
                }
            });

            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    onDatePickerClickListener.onDate(d+"/"+m+"/"+y);
                }
            });

            int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            for (int i = 0; i < 100; i++){
                YEAR[i] = String.valueOf(currentYear);
                currentYear--;
            }

            day.setOffset(5);
            day.setSelection(DAY.length / 2);
            d = DAY[DAY.length/2];
            day.setItems(Arrays.asList(DAY));

            month.setOffset(5);
            month.setSelection(MONTH.length / 2);
            m = MONTH[MONTH.length/2].substring(6, MONTH[MONTH.length/2].length());
            month.setItems(Arrays.asList(MONTH));

            year.setOffset(5);
            year.setSelection(YEAR.length / 2);
            y = YEAR[YEAR.length/2];
            year.setItems(Arrays.asList(YEAR));

            day.setOnWheelViewListener(new PickerDate.OnWheelViewListener(){
                @Override
                void onSelected(int selectedIndex, String item) {
                    super.onSelected(selectedIndex, item);
                    d = item;
                }
            });

            month.setOnWheelViewListener(new PickerDate.OnWheelViewListener(){
                @Override
                void onSelected(int selectedIndex, String item) {
                    super.onSelected(selectedIndex, item);
                    m = item.substring(6,item.length());
                }
            });

            year.setOnWheelViewListener(new PickerDate.OnWheelViewListener(){
                @Override
                void onSelected(int selectedIndex, String item) {
                    super.onSelected(selectedIndex, item);
                    y = item;
                }
            });

        }
    }
}
