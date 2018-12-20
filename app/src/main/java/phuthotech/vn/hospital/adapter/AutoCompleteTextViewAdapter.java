package phuthotech.vn.hospital.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.model.api.patient.Additional;
import phuthotech.vn.hospital.utils.Utils;

/**
 * Created by kingpes on 9/7/18.
 */

public class AutoCompleteTextViewAdapter extends ArrayAdapter<Additional> {
    private List<Additional> lists;
    private String chr = "";

    public AutoCompleteTextViewAdapter(@NonNull Context context, @NonNull List<Additional> lists) {
        super(context, 0, lists);
        this.lists = new ArrayList<>(lists);
    }


    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mylistviewitem, parent, false);
        }

        TextView txt = convertView.findViewById(R.id.title);

        final Additional additional = getItem(position);

        if (additional != null) {
            txt.setText(Utils.spannable(additional.getNAME(), chr));
        }

        return convertView;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Additional> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(lists);
            } else {
                chr = constraint.toString().toLowerCase();

                for (Additional item : lists) {
                    if (item.getNAME().toLowerCase().contains(chr)) {
                        suggestions.add(item);
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
            return ((Additional) resultValue).getNAME();
        }
    };
}