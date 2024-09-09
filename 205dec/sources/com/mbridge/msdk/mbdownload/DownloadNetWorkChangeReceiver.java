package com.mbridge.msdk.mbdownload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DownloadNetWorkChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            boolean booleanExtra = intent.getBooleanExtra("FAILOVER_CONNECTION", false);
            boolean booleanExtra2 = intent.getBooleanExtra("EXTRA_NO_CONNECTIVITY", false);
            x.d("DownloadNetWorkChangeReceiver", "=======reConn:" + booleanExtra + "--noConn:" + booleanExtra2);
            if (com.mbridge.msdk.foundation.same.a.f39379g) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                ADownloadManager aDownloadManager = ADownloadManager.getInstance();
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        x.d("DownloadNetWorkChangeReceiver", "=======networkInfo:Connected");
                        aDownloadManager.reStartAllTask();
                        return;
                    }
                    x.d("DownloadNetWorkChangeReceiver", "=======networkInfo:not Connected");
                    aDownloadManager.cancelAllTask();
                    return;
                }
                aDownloadManager.cancelAllTask();
            }
        }
    }
}
