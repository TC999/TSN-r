package com.qq.e.comm.plugin.apkmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final a f41869a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void a();

        void b();
    }

    public p(a aVar) {
        this.f41869a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        if (this.f41869a == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            d1.a("\u8fde\u63a5\u5230\u8fd0\u8425\u5546\u7f51\u7edc", new Object[0]);
            this.f41869a.b();
        } else if (type == 1 && activeNetworkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) {
            d1.a("\u8fde\u63a5\u5230WIFI\u7f51\u7edc", new Object[0]);
            this.f41869a.a();
        }
    }
}
