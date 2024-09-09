package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class PushService extends Service {
    private static final String TAG = "PushService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        return 2;
    }
}
