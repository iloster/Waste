package com.cheng.waste;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cheng.utils.LogUtils;

public class SettingsActivity extends AppCompatActivity {

    private static String TAG ="SettingsActivity";
    private SettingsFragment mSettingsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mSettingsFragment = new SettingsFragment();
        replaceFragment(R.id.settings_container, mSettingsFragment);

        Intent intent = new Intent(SettingsActivity.this,FloatService.class);
        startService(intent);

    }

    private void replaceFragment(int viewId, android.app.Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(viewId, fragment).commit();
    }

    /**
     * A placeholder fragment containing a settings view.
     */
    public static class SettingsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

            CheckBoxPreference nightShiftPre = (CheckBoxPreference) getPreferenceManager().findPreference("nightShiftPre");
            Preference winSizeShiftPre = (Preference)getPreferenceManager().findPreference("winSizeShiftPre");
            nightShiftPre.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    LogUtils.v(TAG,"ssss:"+newValue);
                    return true;
                }
            });

            winSizeShiftPre.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Toast.makeText(WasteApplication.getInstance(),"click",Toast.LENGTH_SHORT).show();
                    return true;
                }
            });


        }
    }
}
