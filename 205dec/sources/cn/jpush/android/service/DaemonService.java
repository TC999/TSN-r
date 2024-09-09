package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import cn.jiguang.af.g;
import cn.jiguang.w.a;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DaemonService extends Service {
    private static final String TAG = "DaemonService";

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        g.a(StubApp.getOrigApplicationContext(getApplicationContext()), intent != null ? intent.getExtras() : null, 2);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.b(TAG, "action onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.b(TAG, "action onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i4, int i5) {
        g.a(StubApp.getOrigApplicationContext(getApplicationContext()), intent != null ? intent.getExtras() : null, 1);
        return 2;
    }
}
