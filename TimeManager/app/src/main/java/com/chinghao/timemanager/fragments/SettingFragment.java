package com.chinghao.timemanager.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.chinghao.timemanager.R;
import com.chinghao.timemanager.constant.Constants;

/**
 * Created by ChingHao on 2017/1/13.
 */

public class SettingFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
        findPreference(Constants.CONFIG_KEY.SHOW_WEEK_TASK).setOnPreferenceChangeListener((preference1, newValue) -> {
            boolean b = (boolean) newValue;
            preference1.setSummary(b ? "主界面任务列表仅显示本周任务" : "主界面任务列表显示所有任务");
            return true;
        });

        findPreference(Constants.CONFIG_KEY.SHOW_AS_LIST).setOnPreferenceChangeListener((preference, newValue) -> {
            String s = (String) newValue;
            if (s.equals("list")) {
                preference.setSummary("列表形式展示任务列表");
            } else {
                preference.setSummary("网格形式展示任务列表");
            }
            return true;
        });


        findPreference(Constants.CONFIG_KEY.SHOW_PRIORITY).setOnPreferenceChangeListener((preference, newValue) -> {
            boolean b = (boolean) newValue;
            if (b)
                preference.setSummary("在任务卡片中将显示优先级");
            else
                preference.setSummary("在任务卡片中将不会显示优先级");
            return true;
        });

    }
}
