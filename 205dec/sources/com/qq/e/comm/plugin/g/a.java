package com.qq.e.comm.plugin.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0834a f43465a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f43466b;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.g.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface InterfaceC0834a {
        void a(float f4);
    }

    public a(InterfaceC0834a interfaceC0834a) {
        this.f43465a = interfaceC0834a;
    }

    public void a(Context context) {
        try {
            if (this.f43466b) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            context.getApplicationContext().registerReceiver(this, intentFilter);
            this.f43466b = true;
        } catch (Exception unused) {
        }
    }

    public void b(Context context) {
        if (this.f43466b) {
            try {
                context.getApplicationContext().unregisterReceiver(this);
                this.f43466b = false;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 3) == 3) {
            this.f43465a.a(((AudioManager) context.getSystemService("audio")).getStreamVolume(3));
        }
    }
}
