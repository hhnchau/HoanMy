package phuthotech.vn.hospital.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import phuthotech.vn.hospital.model.api.patient.Additional;

/**
 * Created by kingpes on 9/3/18.
 */

public class Utils {
    public static SpannableString spannable(String s, String character) {
        if (s != null && !s.equals("") && character != null && !character.equals("") && character.length() <= s.length()) {
            SpannableString spannableString = new SpannableString(s);
            int start = s.toLowerCase().indexOf(character.toLowerCase());
            int end = start + character.length();
            if (start > -1)
                spannableString.setSpan(new ForegroundColorSpan(Color.RED), start, end, 0);
            return spannableString;
        }

        if (s == null) {
            return SpannableString.valueOf("");
        }

        return SpannableString.valueOf(s);
    }

    public static List<Additional> searchMatcher(List<Additional> lists, String keyword) {
        List<Additional> l = new ArrayList<>();
        String chr = "(?i)(" + keyword + ").*";
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getNAME().matches(chr)) {
                l.add(lists.get(i));
            }
        }
        return l;
    }


    public static List<Additional> searchContent(List<Additional> lists, String content) {
        List<Additional> l = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getNAME().toLowerCase().contains(content.toLowerCase())) {
                l.add(lists.get(i));
            }
        }
        return l;
    }

    public static String convertHexStrToUnicode(String hexString) {
        StringBuilder output = new StringBuilder();
        if (hexString.length() < 2)
            return "";
        for (int i = 0; i < hexString.length(); i += 2) {
            String s = hexString.substring(i, i + 2);
            output.append((char) Integer.parseInt(s, 16));
        }

        String s = "";
        try {
            s = new String(output.toString().getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static String convertUTF8ToString(String s) {
        String out = "";
        try {
            out = new String(s.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return out;
    }

    public static String convertStringToUTF8(String s) {
        String out = "";
        try {
            out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return out;
    }

    public static JSONObject convertStringToJSONObject(String json) {
        if (json != null)
            try {
                return new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return null;
    }

    public static int CalculateAge(String date) {
        if (date != null) {
            String[] d = date.split("\\/");
            if (d.length < 3)
                date = "01/01/" + d[d.length - 1];

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            try {
                Date start = simpleDateFormat.parse(date);
                Date end = new Date();

                return end.getYear() - start.getYear();

            } catch (ParseException e) {
                e.printStackTrace();

            }
        }

        return -1;
    }

    public static String[] splitName(String name) {
        if (name != null) {
            String[] namez = name.trim().split(" ");
            StringBuilder firstName = new StringBuilder();
            String lastName = "";
            for (int i = 0; i < namez.length; i++) {
                if (i == namez.length - 1) {
                    lastName = namez[i];
                } else {
                    firstName.append(namez[i]).append(" ");
                }
            }

            return new String[]{firstName.toString().trim(), lastName};
        }
        return null;
    }

    public static String[] splitDate(String date) {
        if (date != null) {
            String[] datez = date.split("\\/");
            if (datez.length == 3)
                return new String[]{datez[0], datez[1], datez[2]};
            if (datez.length == 2)
                return new String[]{"", datez[0], datez[1]};
            if (datez.length == 1)
                return new String[]{"", "", datez[0]};
        }
        return null;
    }

    public static String formatCurrency(int currency) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        String current = formatter.format(currency);
        return current.replaceAll(",", ".");
    }

    public static String dateFormat(String date) {
        if (date != null) {
            SimpleDateFormat response = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            SimpleDateFormat request = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            try {
                Date d = request.parse(date);
                return response.format(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
