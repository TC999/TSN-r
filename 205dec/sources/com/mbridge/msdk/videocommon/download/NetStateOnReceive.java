package com.mbridge.msdk.videocommon.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NetStateOnReceive extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    if (activeNetworkInfo.getType() == 1) {
                        b.getInstance().b(true);
                    } else if (activeNetworkInfo.getType() == 0) {
                        b.getInstance().a();
                    }
                } else {
                    b.getInstance().a(false);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
