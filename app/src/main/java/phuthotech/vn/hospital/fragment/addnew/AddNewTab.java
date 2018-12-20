package phuthotech.vn.hospital.fragment.addnew;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import phuthotech.vn.hospital.R;

/**
 * Created by kingpes on 9/2/18.
 */

public class AddNewTab extends LinearLayout {
    public static final int TAB1 = 0;
    public static final int TAB2 = 1;
    public static final int TAB3 = 2;
    private ImageView img1, img2, img3;
    private TextView tv1, tv2, tv3;


    public interface OnTabClickListener {
        void onTab(int tab);
    }

    private OnTabClickListener tabClickListener;
    public void setOnTabClickListener(OnTabClickListener tabClickListener){
        this.tabClickListener = tabClickListener;
    }

    public AddNewTab(Context context) {
        super(context);
        create(context);
    }

    public AddNewTab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        create(context);
    }

    public AddNewTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        create(context);
    }

    private void create(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.addnew_tab, this);

            RelativeLayout tab1 = findViewById(R.id.tab1);
            RelativeLayout tab2 = findViewById(R.id.tab2);
            RelativeLayout tab3 = findViewById(R.id.tab3);

            img1 = findViewById(R.id.imgPatientInfo);
            img2 = findViewById(R.id.imgHealthInsurance);
            img3 = findViewById(R.id.imgPrivateInsurance);

            tv1 = findViewById(R.id.tvPatientInfo);
            tv2 = findViewById(R.id.tvHealthInsurance);
            tv3 = findViewById(R.id.tvPrivateInsurance);

            setTab1();

            tab1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tabClickListener.onTab(TAB1);
                    setTab1();
                }
            });

            tab2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tabClickListener.onTab(TAB2);
                    setTab2();
                }
            });

            tab3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tabClickListener.onTab(TAB3);
                    setTab3();
                }
            });
        }
    }

    public void setTab(int tab){
        if (tab == TAB1){
            setTab1();
        }else if (tab == TAB2){
            setTab2();
        }else if (tab == TAB3){
            setTab3();
        }
    }

    public void setBadge1(){
        tv1.setError("*");
    }

    public void setBadge2(){
        tv2.setError("*");
    }

    public void setBadge3(){
        tv3.setError("*");
    }

    private void setTab1(){
        //tab1.setBackgroundResource(R.drawable.radius_blue);
        img1.setImageResource(R.drawable.ic_info_white);
        tv1.setTextColor(getResources().getColor(R.color.wh));
        tv1.setError(null);

        //tab2.setBackgroundResource(R.drawable.radius_white);
        img2.setImageResource(R.drawable.ic_health_grey);
        tv2.setTextColor(getResources().getColor(R.color.bk_40p));

        //tab3.setBackgroundResource(R.drawable.radius_white);
        img3.setImageResource(R.drawable.ic_private_grey);
        tv3.setTextColor(getResources().getColor(R.color.bk_40p));
    }

    private void setTab2(){
        //tab1.setBackgroundResource(R.drawable.radius_white);
        img1.setImageResource(R.drawable.ic_info_grey);
        tv1.setTextColor(getResources().getColor(R.color.bk_40p));

        //tab2.setBackgroundResource(R.drawable.radius_blue);
        img2.setImageResource(R.drawable.ic_health_white);
        tv2.setTextColor(getResources().getColor(R.color.wh));
        tv2.setError(null);

        //tab3.setBackgroundResource(R.drawable.radius_white);
        img3.setImageResource(R.drawable.ic_private_grey);
        tv3.setTextColor(getResources().getColor(R.color.bk_40p));
    }

    private void setTab3(){
        //tab1.setBackgroundResource(R.drawable.radius_white);
        img1.setImageResource(R.drawable.ic_info_grey);
        tv1.setTextColor(getResources().getColor(R.color.bk_40p));

        //tab2.setBackgroundResource(R.drawable.radius_white);
        img2.setImageResource(R.drawable.ic_health_grey);
        tv2.setTextColor(getResources().getColor(R.color.bk_40p));

        //tab3.setBackgroundResource(R.drawable.radius_blue);
        img3.setImageResource(R.drawable.ic_private_white);
        tv3.setTextColor(getResources().getColor(R.color.wh));
        tv3.setError(null);
    }
}
