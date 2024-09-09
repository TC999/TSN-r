package com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface SVSD {
    IBinder onBind(Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(Intent intent);

    int onStartCommand(Intent intent, int i4, int i5);

    void onTaskRemoved(Intent intent);

    void onTrimMemory(int i4);

    boolean onUnbind(Intent intent);
}
