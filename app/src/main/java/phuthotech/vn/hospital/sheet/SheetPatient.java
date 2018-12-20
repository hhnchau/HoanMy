package phuthotech.vn.hospital.sheet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.custom.MyEditText;
import phuthotech.vn.hospital.dialog.DialogPatientDetail;
import phuthotech.vn.hospital.model.api.register.Combo;
import phuthotech.vn.hospital.model.api.register.LstDob;

/**
 * Created by kingpes on 9/22/18.
 */

public class SheetPatient {
    private static SheetPatient instance = null;

    public static SheetPatient getInstance() {
        if (instance == null) {
            instance = new SheetPatient();
        }
        return instance;
    }

    private Dialog dialog;

    public interface OnItemClickListener {
        void onItemClickListener(String sn);
    }

    public void show(final Context context, List<Combo> lists, final OnItemClickListener onItemClickListener) {
        if (context != null) {
            dialog = new Dialog(context, R.style.MyAlert);
            dialog.setOwnerActivity((Activity) context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.sheet_patient_item);
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
                final SheetPatientAdapter adapter = new SheetPatientAdapter(context, lists);
                listView.setAdapter(adapter);

                final MyEditText edtSn = dialog.findViewById(R.id.edtSn);
                final MyEditText edtName = dialog.findViewById(R.id.edtName);
                final MyEditText edtAddress = dialog.findViewById(R.id.edtAddress);
                final MyEditText edtGender = dialog.findViewById(R.id.edtGender);
                final MyEditText edtBirthday = dialog.findViewById(R.id.edtBirthday);
                final MyEditText edtIdentity = dialog.findViewById(R.id.edtIdentity);

                TextWatcher textWatcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String chr =
                                edtSn.getText()+ "-"+
                                        edtName.getText()+"-"+
                                        edtAddress.getText()+"-"+
                                        edtGender.getText()+"-"+
                                        edtBirthday.getText()+"-"+
                                        edtIdentity.getText();
                        adapter.getFilter().filter(chr);
                    }
                };



                edtSn.addTextChangedListener(textWatcher);
                edtName.addTextChangedListener(textWatcher);
                edtAddress.addTextChangedListener(textWatcher);
                edtGender.addTextChangedListener(textWatcher);
                edtBirthday.addTextChangedListener(textWatcher);
                edtIdentity.addTextChangedListener(textWatcher);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (onItemClickListener != null) {
                            Combo combo = (Combo) parent.getItemAtPosition(position);
                            onItemClickListener.onItemClickListener(combo.getCode());
                            dismiss();
                        }
                    }
                });


            }
        }
    }

    private void dismiss() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }
}

class SheetPatientAdapter extends ArrayAdapter<Combo> {
    private Context context;

    private List<Combo> lists;

    private String chr = "";


    SheetPatientAdapter(@NonNull Context context, List<Combo> lists) {
        super(context, 0, lists);
        this.context = context;
        this.lists = new ArrayList<>(lists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.sheet_patient_item_list, parent, false);
        }

        TextView tvSn = convertView.findViewById(R.id.tvSn);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvAddress = convertView.findViewById(R.id.tvAddress);
        TextView tvGender = convertView.findViewById(R.id.tvGender);

        final Combo combo = getItem(position);
        if (combo != null) {

            tvSn.setText(combo.getCode());
            tvName.setText(combo.getName());
            tvAddress.setText(combo.getName1());
            tvGender.setText(combo.getName2());

            ImageView ic = convertView.findViewById(R.id.ic);
            ic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogPatientDetail.getInstance().show(context, combo, null);
                }
            });

        }
        return convertView;
    }


    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<Combo> suggestions = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    suggestions.addAll(lists);
                } else {
                    chr = constraint.toString().toLowerCase();
                    String[] arrChr = chr.split("-");
                    for (int i = 0; i < arrChr.length; i++) {
                        if (!arrChr[i].isEmpty())
                            for (Combo item : lists) {
                                if (i==0 && item.getCode().toLowerCase().contains(arrChr[i])) {
                                    suggestions.add(item);
                                }else if (i==1 && item.getName().toLowerCase().contains(arrChr[i])) {
                                    suggestions.add(item);
                                }else if (i==2 && item.getName1().toLowerCase().contains(arrChr[i])) {
                                    suggestions.add(item);
                                }else if (i==3 && item.getName2().toLowerCase().contains(arrChr[i])) {
                                    suggestions.add(item);
                                }else if (i==4 && item.getName3().toLowerCase().contains(arrChr[i])) {
                                    suggestions.add(item);
                                }else if (i==5 && item.getName4().toLowerCase().contains(arrChr[i])) {
                                    suggestions.add(item);
                                }
                            }
                    }
                }

                results.values = suggestions;
                results.count = suggestions.size();

                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                addAll((List) results.values);
                notifyDataSetChanged();
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return ((Combo) resultValue).getName();
            }
        };
    }
}
