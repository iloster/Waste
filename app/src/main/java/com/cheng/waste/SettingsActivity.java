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

import me.drakeet.materialdialog.MaterialDialog;

public class SettingsActivity extends BaseAppCompatActivity {

    private static String TAG = "SettingsActivity";
    public SettingsFragment mSettingsFragment;

    public SettingsActivity(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(savedInstanceState==null) {
            setContentView(R.layout.activity_settings);

            mSettingsFragment = new SettingsFragment();
            replaceFragment(R.id.settings_container, mSettingsFragment);
            if (!DeviceUtils.isServiceRunning("com.cheng.waste.FloatService")) {
                Intent intent = new Intent(SettingsActivity.this, FloatService.class);
                startService(intent);
            } else {
                LogUtils.v(TAG, "service is running");
            }
//        }
    }


    private void replaceFragment(int viewId, Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(viewId, fragment).commit();
    }

}
