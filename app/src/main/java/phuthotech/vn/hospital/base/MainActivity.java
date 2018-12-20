package phuthotech.vn.hospital.base;

import android.os.Build;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import phuthotech.vn.hospital.R;
import phuthotech.vn.hospital.adapter.DrawerAdapter;
import phuthotech.vn.hospital.fragment.addnew.AddNewFragment;
import phuthotech.vn.hospital.fragment.register.Register1;
import phuthotech.vn.hospital.model.Drawerz;
import phuthotech.vn.hospital.fragment.dashboard.DashboardFragment;
import phuthotech.vn.hospital.fragment.history.HistoryFragment;
import phuthotech.vn.hospital.fragment.register.RegisterFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ConstraintLayout drawer;
    private ListView drawerList;
    private DrawerAdapter drawerAdapter;

    private ImageView toolbarRight;
    private TextView toolbarTitle;


    private DashboardFragment dashboardFragment;
    private HistoryFragment newFragment;
    private RegisterFragment regisFragment;
    private AddNewFragment fragment;

    private static final int DASHBOARD = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

//        ApiManager.getInstance().getPatient(new OnCallback() {
//            @Override
//            public void onCallBack(Form form) {
//
//                ApiManager.getInstance().savePatient(form, new OnCallback() {
//                    @Override
//                    public void onCallBack(Form form) {
//
//                    }
//                });
//
//            }
//        });


        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(ContextCompat.getColor(this, R.color.mainColor));
                }
            }
        }

//        initFragment();
//        showDashboardFragment();


        addFragment(DASHBOARD);


        List<Drawerz> lists = new ArrayList<>();
        lists.add(new Drawerz(1, getResources().getString(R.string.screen_dashboard)));
        //lists.add(new Drawerz(1, getResources().getString(R.string.screen_history)));
        lists.add(new Drawerz(1, getResources().getString(R.string.screen_register)));
        lists.add(new Drawerz(1, getResources().getString(R.string.screen_add_new)));

        drawerList = findViewById(R.id.drawerList);
        drawerAdapter = new DrawerAdapter(this, lists);
        drawerList.setAdapter(drawerAdapter);

        drawerLayout = findViewById(R.id.drawerLayout);
        drawer = findViewById(R.id.drawer);


        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                drawerLayout.closeDrawer(drawer);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addFragment(position);
                    }
                }, 100);
            }
        });

    }


    private void initFragment() {
        dashboardFragment = new DashboardFragment();
        newFragment = new HistoryFragment();
        regisFragment = new RegisterFragment();
        fragment = new AddNewFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainFrame, dashboardFragment, DashboardFragment.class.getName())
                .add(R.id.mainFrame, newFragment, HistoryFragment.class.getName())
                .add(R.id.mainFrame, regisFragment, RegisterFragment.class.getName())
                .add(R.id.mainFrame, fragment, AddNewFragment.class.getName())
                .commit();
    }

    private void showDashboardFragment() {
        if (dashboardFragment == null)
            dashboardFragment = new DashboardFragment();

        if (!dashboardFragment.isVisible())
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, dashboardFragment, DashboardFragment.class.getName())
                    .commit();
    }

    private void showNewFragment() {
        if (newFragment == null)
            newFragment = new HistoryFragment();

        if (!newFragment.isVisible())
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, newFragment, HistoryFragment.class.getName())
                    .commit();
    }

    private void showRegisFragment() {
        if (regisFragment == null)
            regisFragment = new RegisterFragment();

        if (!regisFragment.isVisible())
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, regisFragment, RegisterFragment.class.getName())
                    .commit();
    }

    private void showFragment() {
        if (fragment == null)
            fragment = new AddNewFragment();

        if (!fragment.isVisible())
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, fragment, AddNewFragment.class.getName())
                    .commit();
    }

    private void addFragment(final int id) {
        setupToolbar(id);

        Fragment frg = null;
        String name = null;

        if (id == DASHBOARD) {
            name = DashboardFragment.class.getName();
            frg = new DashboardFragment();
//        } else if (id == 1) {
//            name = HistoryFragment.class.getName();
//            frg = new HistoryFragment();
        } else if (id == 1) {
            name = RegisterFragment.class.getName();
            frg = new RegisterFragment();
        } else if (id == 2) {
            name = AddNewFragment.class.getName();
            frg = new AddNewFragment();
        }

        if (frg != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, frg, name)
                    .commit();
        }

    }


    /*
    * Toolbar
    */
    private void initToolbar() {
        toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarRight = findViewById(R.id.toolbarRight);
    }

    private void setupToolbar(int id) {
        if (id == DASHBOARD) {
            toolbarRight.setImageResource(0);
            toolbarTitle.setText(getResources().getString(R.string.screen_dashboard));
//        } else if (id == 1) {
//            toolbarRight.setImageResource(0);
//            toolbarTitle.setText(getResources().getString(R.string.screen_history));
        } else if (id == 1) {
            toolbarRight.setImageResource(0);
            toolbarTitle.setText(getResources().getString(R.string.screen_register));
        } else if (id == 2) {
            toolbarRight.setImageResource(R.drawable.ic_qr);
            toolbarTitle.setText(R.string.screen_add_new);
        }
    }

    public void onMenuLeft(View v) {
        drawerLayout.openDrawer(drawer);
    }

    public void onMenuRight(View v) {
        AddNewFragment addNewFragment = (AddNewFragment) getSupportFragmentManager().findFragmentByTag(AddNewFragment.class.getName());
        if (addNewFragment != null) {
            addNewFragment.onQr();
        }
    }

}
