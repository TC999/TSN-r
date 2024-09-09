package com.autonavi.base.amap.mapcore.maploader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NetworkState {
    private NetworkChangeListener mNetworkListener;
    private boolean isNetReceiverRegistered = false;
    private MyBroadcastReceiver netChangeReceiver = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class MyBroadcastReceiver extends BroadcastReceiver {
        WeakReference<NetworkChangeListener> reference;

        public MyBroadcastReceiver(NetworkChangeListener networkChangeListener) {
            this.reference = null;
            this.reference = new WeakReference<>(networkChangeListener);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WeakReference<NetworkChangeListener> weakReference = this.reference;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.reference.get().networkStateChanged(context);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface NetworkChangeListener {
        void networkStateChanged(Context context);
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo == null) {
                    return null;
                }
                for (int i4 = 0; i4 < allNetworkInfo.length; i4++) {
                    if (allNetworkInfo[i4] != null && allNetworkInfo[i4].isConnected()) {
                        return allNetworkInfo[i4];
                    }
                }
                return activeNetworkInfo;
            }
            return activeNetworkInfo;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void registerNetChangeReceiver(Context context, boolean z3) {
        MyBroadcastReceiver myBroadcastReceiver;
        if (z3) {
            if (!this.isNetReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                if (this.netChangeReceiver == null) {
                    this.netChangeReceiver = new MyBroadcastReceiver(this.mNetworkListener);
                }
                context.registerReceiver(this.netChangeReceiver, intentFilter);
            }
        } else if (this.isNetReceiverRegistered && (myBroadcastReceiver = this.netChangeReceiver) != null) {
            context.unregisterReceiver(myBroadcastReceiver);
            this.netChangeReceiver = null;
        }
        this.isNetReceiverRegistered = z3;
    }

    public void setNetworkListener(NetworkChangeListener networkChangeListener) {
        this.mNetworkListener = networkChangeListener;
    }
}
