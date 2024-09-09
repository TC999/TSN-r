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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
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
            Log.i("KSAd_DYI", "registerToApp action:" + str);
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
        Log.i("KSAd_DYI", "onReceive success");
        if (intent == null) {
            Log.i("KSAd_DYI", "intent is null");
            return;
        }
        String stringExtra = intent.getStringExtra("apkPath");
        final String stringExtra2 = intent.getStringExtra("sdkVersion");
        final File file = new File(stringExtra);
        if (!file.exists()) {
            Log.i("KSAd_DYI", "downloadFile not exists: " + file);
            return;
        }
        Log.i("KSAd_DYI", "downloadFile is exists, apkPath :" + stringExtra + " sdkVersion:" + stringExtra2);
        AsyncTask.execute(new Runnable() { // from class: com.kwad.sdk.api.loader.DynamicInstallReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.a(context, AnonymousClass1.class.getClassLoader(), file.getPath(), stringExtra2)) {
                        Log.i("KSAd_DYI", "onReceive ApkInstaller installApk success");
                        g.n(context, stringExtra2);
                        h.h(file);
                    }
                } catch (Exception e4) {
                    Log.i("KSAd_DYI", "onReceive ApkInstaller installApk error:" + e4);
                    e4.printStackTrace();
                }
            }
        });
    }
}
