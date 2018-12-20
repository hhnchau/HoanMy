package phuthotech.vn.hospital.fragment.register;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.base.BaseFragment;

/**
 * Created by kingpes on 9/21/18.
 */

public class Register4 extends BaseFragment{
    private View v;
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.base_layout, container, false);

        new Handler().post(new Runnable() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void run() {

                if (getActivity()!= null) {

                    ViewGroup viewGroup = view.findViewById(R.id.baseLayout);
                    LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    if (vi != null) {
                        v = vi.inflate(R.layout.register4_fragment, viewGroup, false);
                        viewGroup.addView(v);


                        initView();


                    }
                }
            }
        });

        return view;
    }

    public boolean validate() {
        return false;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        webView = v.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.TRANSPARENT);

        ImageView img = v.findViewById(R.id.imgHealthCard);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void updateView(){
        Toast.makeText(getActivity(), "Update View", Toast.LENGTH_SHORT).show();
        webView.loadDataWithBaseURL("", getString(R.string.html_detail,
                "Chau",
                "Hoang",
                "Bao  sdf asdf asf sadfjsdfj asd jls jdfs j fksf;asj f fj",
                "Lan",
                "A",
                "B"), "text/html", "UTF-8", "");
    }
}
