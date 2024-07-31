package com.bytedance.pangle.service;

import android.content.Intent;
import android.os.IBinder;
import com.bytedance.pangle.plugin.Plugin;

/* renamed from: com.bytedance.pangle.service.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC6223a {
    void attach(Plugin plugin);

    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent intent, int i, int i2);

    boolean onUnbind(Intent intent);
}
