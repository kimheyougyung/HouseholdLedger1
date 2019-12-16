package com.example.householdledger2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
//AppCompatActivity 클래스는 과거 안드로이드 버전과의 호환성을 유지하면서
//  새로운 버전의 기능도 사용할 수 있게 한다.
    private AppBarConfiguration mAppBarConfiguration; // 앱바 위치배치?

    FloatingActionButton fab_add, fab_memo, fab_spend;
    Animation FabOpen, FabClose, FabClockwise, Fabanticlockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //setContentView - xml 에 정의되있는 View 들을 메모리 상에 객체화시켜줌


        fab_add = (FloatingActionButton)findViewById(R.id.fab_add);
        fab_memo = (FloatingActionButton)findViewById(R.id.fab_memo);
        fab_spend = (FloatingActionButton)findViewById(R.id.fab_spend);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        Fabanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.retate_anticlockwise);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen)
                {
                    fab_spend.startAnimation(FabClose);
                    fab_memo.startAnimation(FabClockwise);
                    fab_add.startAnimation(Fabanticlockwise);
                    fab_memo.setClickable(false);
                    fab_spend.setClickable(false);
                    isOpen = false;
                }
                else
                {
                    fab_spend.startAnimation(FabOpen);
                    fab_memo.startAnimation(FabOpen);
                    fab_add.startAnimation(Fabanticlockwise);
                    fab_memo.setClickable(true);
                    fab_spend.setClickable(true);
                    isOpen = true;

                }
            }
        });



        Toolbar toolbar = findViewById(R.id.toolbar); // 툴바설정
        setSupportActionBar(toolbar); // 액션바와 같게 만들어줌

        // FloatingActionButton 플로팅액션버튼 "+"  fab 선언함
        fab_add.setOnClickListener(new View.OnClickListener() { //  fab 클릭하였을 때
            @Override
            public void onClick(View view) {
                if (isOpen)
                {
                    fab_spend.startAnimation(FabClose);
                    fab_memo.startAnimation(FabClockwise);
                    fab_add.startAnimation(Fabanticlockwise);
                    fab_memo.setClickable(false);
                    fab_spend.setClickable(false);
                    isOpen = false;
                }
                else
                {
                    fab_spend.startAnimation(FabOpen);
                    fab_memo.startAnimation(FabOpen);
                    fab_add.startAnimation(Fabanticlockwise);
                    fab_memo.setClickable(true);
                    fab_spend.setClickable(true);
                    isOpen = true;

                }

//                Snackbar.make(view, "스낵바 출력", Snackbar.LENGTH_LONG).show();
////                Snackbar.make(view, "스낵바 출력", Snackbar.LENGTH_LONG).setAction
////                        ("Action", null).show();
//                // 스낵바 출력
            }
        });
        DrawerLayout drawer = findViewById(R.id.activity_layout); // 드로어 레이아웃, 메인 액티비티레이아웃
        NavigationView navigationView = findViewById(R.id.nav_view); // 네비게이션 드로어

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_calculator, R.id.nav_stats,
                R.id.nav_tools, R.id.nav_share, R.id.nav_setting)
                .setDrawerLayout(drawer)  // 드로어 레이아웃을 가져오다.
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); // 이게 왜그런건지모르겟음
//        // NavController 네비게이션 컨트롤러 역할한다.
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        //
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
