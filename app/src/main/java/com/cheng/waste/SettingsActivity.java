package com.cheng.waste;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cheng.config.Constants;
import com.cheng.content.DBMoment.Detail.DBDetailBean;
import com.cheng.utils.DeviceUtils;
import com.cheng.utils.LogUtils;
import com.cheng.utils.SpUtils;
import com.cheng.view.BaseAppCompatActivity;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.crashreport.CrashReport;

import me.drakeet.materialdialog.MaterialDialog;

public class SettingsActivity extends BaseAppCompatActivity {

    private static String TAG = "SettingsActivity";
    public SettingsFragment mSettingsFragment;

    public SettingsActivity(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mSettingsFragment = new SettingsFragment();
        replaceFragment(R.id.settings_container, mSettingsFragment);
        if (!DeviceUtils.isServiceRunning("com.cheng.waste.FloatService")) {
            Intent intent = new Intent(WasteApplication.getInstance(), FloatService.class);
            startService(intent);
        } else {
            LogUtils.v(TAG, "service is running");
        }

        initBugly();
    }


    private void replaceFragment(int viewId, Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(viewId, fragment).commit();
    }

    private void initBugly(){
        //正式为false ，测试环境为true
        Bugly.init(WasteApplication.getInstance(), "1be8278f1a", true);
    }

}
