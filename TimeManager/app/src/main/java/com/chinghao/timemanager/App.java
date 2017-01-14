package com.chinghao.timemanager;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ChingHao on 2017/1/12.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
        // 获取当前包名
        String packageName = context.getPackageName();
        // 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
//        CrashReport.initCrashReport(getApplicationContext(), "684db223b4", true, strategy);
        strategy.setAppChannel("Test");
        Bugly.init(getApplicationContext(), "684db223b4", true, strategy);


        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("data.realm")
                .build();
        Realm.setDefaultConfiguration(configuration);
        Fresco.initialize(this);
    }
    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
