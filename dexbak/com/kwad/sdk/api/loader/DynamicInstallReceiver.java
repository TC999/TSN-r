package com.kwad.sdk.api.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Keep;
import com.stub.StubApp;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DynamicInstallReceiver extends BroadcastReceiver {
    private static final AtomicBoolean HAS_REGISTER = new AtomicBoolean(false);
    private static final String TAG = "KSAd_DYI";

    @Keep
    public static void registerToApp(Context context) {
        if (context != null) {
            AtomicBoolean atomicBoolean = HAS_REGISTER;
            if (atomicBoolean.get() || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
                return;
            }
            String str = context.getPackageName() + ".loader.install.DynamicApk";
            Log.i(TAG, "registerToApp action:" + str);
            IntentFilter intentFilter = new IntentFilter(str);
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (Build.VERSION.SDK_INT >= 33) {
                origApplicationContext.registerReceiver(new DynamicInstallReceiver(), intentFilter, 2);
            } else {
                origApplicationContext.registerReceiver(new DynamicInstallReceiver(), intentFilter);
            }
            atomicBoolean.set(true);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Log.i(TAG, "onReceive success");
        if (intent == null) {
            Log.i(TAG, "intent is null");
            return;
        }
        String stringExtra = intent.getStringExtra("apkPath");
        final String stringExtra2 = intent.getStringExtra("sdkVersion");
        final File file = new File(stringExtra);
        if (!file.exists()) {
            Log.i(TAG, "downloadFile not exists: " + file);
            return;
        }
        Log.i(TAG, "downloadFile is exists, apkPath :" + stringExtra + " sdkVersion:" + stringExtra2);
        AsyncTask.execute(new Runnable() { // from class: com.kwad.sdk.api.loader.DynamicInstallReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (C9715b.m27952a(context, RunnableC97071.class.getClassLoader(), file.getPath(), stringExtra2)) {
                        Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk success");
                        C9723g.m27931n(context, stringExtra2);
                        C9724h.m27928h(file);
                    }
                } catch (Exception e) {
                    Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk error:" + e);
                    e.printStackTrace();
                }
            }
        });
    }
}
