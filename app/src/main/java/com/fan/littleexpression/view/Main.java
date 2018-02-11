package com.fan.littleexpression.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.fan.littleexpression.R;
import com.fan.littleexpression.adapter.ViewpagerAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by Fan on 2018/2/4.
 */

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        String[] titles = {getString(R.string.tab1), getString(R.string.tab2), getString(R.string.tab3),
                getString(R.string.tab4), getString(R.string.tab5),getString(R.string.tab6)};
        viewPager.setAdapter(new ViewpagerAdapter(getSupportFragmentManager(), titles));
        MobileAds.initialize(this, "ca-app-pub-4544650091119087~2858731708");
        final InterstitialAd mads = new InterstitialAd(this);
        mads.setAdUnitId("ca-app-pub-4544650091119087/6129329661");
        mads.loadAd(new AdRequest.Builder().build());
        mads.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                new MaterialDialog.Builder(this)
                        .title(getString(R.string.about_title))
                        .content(getString(R.string.about_mes))
                        .onNeutral(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                Intent intent = new Intent();
                                intent.setData(Uri.parse(getString(R.string.qqkey)));
                                startActivity(intent);
                            }
                        })
                        .neutralColor(getColor(R.color.colorPrimary))
                        .positiveText(getString(R.string.about_bu))
                        .neutralText(getString(R.string.about_join))
                        .show();
                break;
        }
        return true;
    }
}
