package com.cheng.waste;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.net.Uri;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cheng.config.Constants;
import com.cheng.utils.DeviceUtils;
import com.cheng.utils.LogUtils;
import com.cheng.utils.SpUtils;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import me.drakeet.materialdialog.MaterialDialog;

public class SettingsActivity extends AppCompatActivity {

    private static String TAG = "SettingsActivity";
    private SettingsFragment mSettingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mSettingsFragment = new SettingsFragment();
        replaceFragment(R.id.settings_container, mSettingsFragment);
        if (!DeviceUtils.isServiceRunning("com.cheng.waste.FloatService")) {
            Intent intent = new Intent(SettingsActivity.this, FloatService.class);
            startService(intent);
        } else {
            LogUtils.v(TAG, "service is running");
        }
    }

    private void replaceFragment(int viewId, Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(viewId, fragment).commit();
    }

    /**
     * A placeholder fragment containing a settings view.
     */
    public class SettingsFragment extends PreferenceFragment {

        private Preference mWinSizeShiftPre;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

            CheckBoxPreference nightShiftPre = (CheckBoxPreference) getPreferenceManager().findPreference("nightShiftPre");
            mWinSizeShiftPre = (Preference) getPreferenceManager().findPreference("winSizeShiftPre");

            int winSizeValue = SpUtils.getInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_LITTLE);
            if(winSizeValue == Constants.WINSIZE_LITTLE){
                mWinSizeShiftPre.setSummary("3/4屏幕");
            }else{
                mWinSizeShiftPre.setSummary("全屏");
            }

            nightShiftPre.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    return true;
                }
            });

            mWinSizeShiftPre.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
//                    Toast.makeText(WasteApplication.getInstance(), "click", Toast.LENGTH_SHORT).show();
                    showDailog();
                    return true;
                }
            });
        }


        private void showDailog() {
            final View view1 = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.activity_settings_winsize, null);
            RadioGroup radioGroup = (RadioGroup) view1.findViewById(R.id.radioGroup);
            if(SpUtils.getInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_LITTLE) == Constants.WINSIZE_LITTLE){
                radioGroup.check(R.id.little);
            }else{
                radioGroup.check(R.id.large);
            }

            final MaterialDialog mMaterialDialog = new MaterialDialog(SettingsActivity.this);
            mMaterialDialog.setTitle("选择合适的屏幕大小吧");
            mMaterialDialog.setPositiveButton("确定", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RadioGroup radioGroup = (RadioGroup) view1.findViewById(R.id.radioGroup);
                    if (radioGroup.getCheckedRadioButtonId() == R.id.little) {
                        SpUtils.setInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_LITTLE);
                        mWinSizeShiftPre.setSummary("3/4屏幕");
                    } else {
                        SpUtils.setInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_FULLSCREEN);
                        mWinSizeShiftPre.setSummary("全屏");
                    }
                    mMaterialDialog.dismiss();
                }
            });
            mMaterialDialog.setContentView(view1);
            mMaterialDialog.show();

        }

    }


}
