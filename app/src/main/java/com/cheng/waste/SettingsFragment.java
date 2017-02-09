package com.cheng.waste;

/**
 * Created by cheng on 2017/2/8.
 */

import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cheng.config.Constants;
import com.cheng.utils.LogUtils;
import com.cheng.utils.SpUtils;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * A placeholder fragment containing a settings view.
 */
public  class SettingsFragment extends PreferenceFragment {

    private Preference mWinSizeShiftPre;
    private CheckBoxPreference mLongPressPre;
    private static String TAG = "SettingsActivity";
    public SettingsFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        CheckBoxPreference nightShiftPre = (CheckBoxPreference) getPreferenceManager().findPreference("nightShiftPre");
        mWinSizeShiftPre = (Preference) getPreferenceManager().findPreference("winSizeShiftPre");
        mLongPressPre = (CheckBoxPreference)getPreferenceManager().findPreference("longPressPre");

        boolean longPressFlag = SpUtils.getBoolean(Constants.LONGPRESS_SP_KEY,true);
        mLongPressPre.setChecked(longPressFlag);
        int winSizeValue = SpUtils.getInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_LITTLE);
        if(winSizeValue == Constants.WINSIZE_LITTLE){
            mWinSizeShiftPre.setSummary("3/4屏幕");
        }else{
            mWinSizeShiftPre.setSummary("全屏");
        }

        if(!SpUtils.getBoolean(Constants.NIGHTSHIFT_SP_KEY,false)){
            nightShiftPre.setChecked(false);
        }else{
            nightShiftPre.setChecked(true);
        }
        nightShiftPre.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean flag = (boolean)newValue;
                SpUtils.setBoolean(Constants.NIGHTSHIFT_SP_KEY,flag);
//                Toast.makeText(WasteApplication.getInstance(),"夜间模式:"+flag,Toast.LENGTH_SHORT).show();
                if(flag) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                getActivity().recreate();
                return true;
            }
        });
        mLongPressPre.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean flag = (boolean)o;
                if(flag) {
                    Toast.makeText(WasteApplication.getInstance(),"已开启",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WasteApplication.getInstance(),"已关闭",Toast.LENGTH_SHORT).show();
                }
                SpUtils.setBoolean(Constants.LONGPRESS_SP_KEY,flag);
                return true;
            }
        });
        mWinSizeShiftPre.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
//                    Toast.makeText(WasteApplication.getInstance(), "click", Toast.LENGTH_SHORT).show();
                showDialog();
                return true;
            }
        });
    }


    private void showDialog(){
        final View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_settings_winsize, null);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        if(SpUtils.getInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_LITTLE) == Constants.WINSIZE_LITTLE){
            radioGroup.check(R.id.little);
        }else{
            radioGroup.check(R.id.large);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity(),R.style.MyDialog);
//        builder.setTitle("设置悬浮内容框大小");
        builder.setCustomTitle(LayoutInflater.from(getActivity()).inflate(R.layout.activity_settings_winsize_title,null));
        builder.setView(view);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
                if (radioGroup.getCheckedRadioButtonId() == R.id.little) {
                    SpUtils.setInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_LITTLE);
                    mWinSizeShiftPre.setSummary("3/4屏幕");
                } else {
                    SpUtils.setInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_FULLSCREEN);
                    mWinSizeShiftPre.setSummary("全屏");
                }
            }
        });
        builder.show();
    }

}

