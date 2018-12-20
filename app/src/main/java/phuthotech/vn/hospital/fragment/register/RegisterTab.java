package phuthotech.vn.hospital.fragment.register;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.logging.Handler;

import phuthotech.vn.hospital.R;


/**
 * Created by kingpes on 9/20/18.
 */


public class RegisterTab extends LinearLayout implements View.OnClickListener {
    public static final int TAB1 = 0;
    public static final int TAB2 = 1;
    public static final int TAB3 = 2;
    public static final int TAB4 = 3;
    public static final int TAB5 = 4;
    public static final int TAB6 = 5;
    public static final int TAB7 = 6;
    //private HorizontalScrollView hsv;
    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;

    private TextView[] TITLE;
    private ImageView[] IMG;

//    private static final String[] STRING_TITLE = {"Thông tin", "Tiếp nhận", "Tuỳ chọn", "BHTY", "BHTN","Triệu chứng","ĐK Khám"};
//    private static final int[] IC_ACTIVE = {R.drawable.ic_health_white, R.drawable.ic_info_white, R.drawable.ic_private_white, R.drawable.ic_health_white, R.drawable.ic_info_white,R.drawable.ic_private_white,R.drawable.ic_health_white};
//    private static final int[] IC_NONE_ACTIVE = {R.drawable.ic_health_grey, R.drawable.ic_info_grey, R.drawable.ic_private_grey, R.drawable.ic_health_grey, R.drawable.ic_info_grey,R.drawable.ic_private_grey,R.drawable.ic_health_grey};


    private static final String[] STRING_TITLE = {"Thông tin", "Tiếp nhận","ĐK Khám"};
    private static final int[] IC_ACTIVE = {R.drawable.ic_health_white, R.drawable.ic_info_white, R.drawable.ic_private_white};
    private static final int[] IC_NONE_ACTIVE = {R.drawable.ic_health_grey, R.drawable.ic_info_grey, R.drawable.ic_private_grey};

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tab1:
                setTab(TAB1);
                if (tabClickListener!= null)
                    tabClickListener.onTab(TAB1);
                break;
            case R.id.tab2:
                setTab(TAB1);
                if (tabClickListener!= null)
                    tabClickListener.onTab(TAB2);
                break;
            case R.id.tab3:
                setTab(TAB3);
                if (tabClickListener!= null)
                    tabClickListener.onTab(TAB3);
                break;
//            case R.id.tab4:
//                setTab(TAB4);
//                if (tabClickListener!= null)
//                    tabClickListener.onTab(TAB4);
//                break;
//            case R.id.tab5:
//                setTab(TAB5);
//                if (tabClickListener!= null)
//                    tabClickListener.onTab(TAB5);
//                break;
//            case R.id.tab6:
//                setTab(TAB6);
//                if (tabClickListener!= null)
//                    tabClickListener.onTab(TAB6);
//                break;
//            case R.id.tab7:
//                setTab(TAB7);
//                if (tabClickListener!= null)
//                    tabClickListener.onTab(TAB7);
//                break;
        }
    }


    public interface OnTabClickListener {
        void onTab(int tab);
    }

    private OnTabClickListener tabClickListener;

    public void setOnTabClickListener(OnTabClickListener tabClickListener) {
        this.tabClickListener = tabClickListener;
    }

    public RegisterTab(Context context) {
        super(context);
        create(context);
    }

    public RegisterTab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        create(context);
    }

    public RegisterTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        create(context);
    }

    private void create(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.register_tab, this);

            RelativeLayout tab1 = findViewById(R.id.tab1);
            tab1.setOnClickListener(this);
            RelativeLayout tab2 = findViewById(R.id.tab2);
            tab2.setOnClickListener(this);
            RelativeLayout tab3 = findViewById(R.id.tab3);
            tab3.setOnClickListener(this);
//            RelativeLayout tab4 = findViewById(R.id.tab4);
//            tab4.setOnClickListener(this);
//            RelativeLayout tab5 = findViewById(R.id.tab5);
//            tab5.setOnClickListener(this);
//            RelativeLayout tab6 = findViewById(R.id.tab6);
//            tab6.setOnClickListener(this);
//            RelativeLayout tab7 = findViewById(R.id.tab7);
//            tab7.setOnClickListener(this);

            ImageView img1 = findViewById(R.id.img1);
            ImageView img2 = findViewById(R.id.img2);
            ImageView img3 = findViewById(R.id.img3);
//            ImageView img4 = findViewById(R.id.img4);
//            ImageView img5 = findViewById(R.id.img5);
//            ImageView img6 = findViewById(R.id.img6);
//            ImageView img7 = findViewById(R.id.img7);

            //IMG = new ImageView[]{img1, img2, img3, img4, img5, img6, img7};
            IMG = new ImageView[]{img1, img2, img3};


            tv1 = findViewById(R.id.tv1);
            tv2 = findViewById(R.id.tv2);
            tv3 = findViewById(R.id.tv3);
//            tv4 = findViewById(R.id.tv4);
//            tv5 = findViewById(R.id.tv5);
//            tv6 = findViewById(R.id.tv6);
//            tv7 = findViewById(R.id.tv7);

            //TITLE = new TextView[]{tv1, tv2, tv3, tv4, tv5, tv6, tv7};
            TITLE = new TextView[]{tv1, tv2, tv3};

            //hsv = findViewById(R.id.hsv);

            //Set Default
            setTab(TAB1);

        }
    }

    public void scroll(final int direction){
//        hsv.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //hsv.fullScroll(View.FOCUS_RIGHT);
//                hsv.smoothScrollBy(direction * 338, 0); //width tab = 338px(150dp);
//            }
//        }, 50);
    }

    public void setTab(final int tab) {
        new android.os.Handler().post(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < TITLE.length; i++){
                    TITLE[i].setText(STRING_TITLE[i]);
                    if (tab == i){
                        TITLE[i].setTextColor(getResources().getColor(R.color.wh));
                        TITLE[i].setError(null);
                        IMG[i].setImageResource(IC_ACTIVE[i]);
                    }else {
                        TITLE[i].setTextColor(getResources().getColor(R.color.bk_40p));
                        IMG[i].setImageResource(IC_NONE_ACTIVE[i]);
                    }
                }
            }
        });
    }

    public void setBadge1() {
        tv1.setError("*");
    }

    public void setBadge2() {
        tv2.setError("*");
    }

    public void setBadge3() {
        tv3.setError("*");
    }

    public void setBadge4() {
        tv4.setError("*");
    }

    public void setBadge5() {
        tv5.setError("*");
    }

    public void setBadge6() {
        tv6.setError("*");
    }

    public void setBadge7() {
        tv7.setError("*");
    }

}