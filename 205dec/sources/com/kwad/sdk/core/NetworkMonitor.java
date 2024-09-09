package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.stub.StubApp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class NetworkMonitor {
    private static volatile boolean aoV;
    private final List<a> aoW;
    private boolean aoX;
    private final BroadcastReceiver aoY;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    enum Holder {
        INSTANCE;
        
        private final NetworkMonitor mInstance = new NetworkMonitor((byte) 0);

        Holder() {
        }

        final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(NetworkState networkState);
    }

    /* synthetic */ NetworkMonitor(byte b4) {
        this();
    }

    private synchronized void aP(Context context) {
        if (aoV || context == null) {
            return;
        }
        StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(this.aoY, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        aoV = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        for (a aVar : this.aoW) {
            aVar.a(networkState);
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private NetworkMonitor() {
        this.aoW = new CopyOnWriteArrayList();
        this.aoX = false;
        this.aoY = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        } else if (1 == activeNetworkInfo.getType()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                        } else if (activeNetworkInfo.getType() == 0) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                        } else {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public final void a(Context context, @NonNull a aVar) {
        aP(context);
        if (this.aoW.contains(aVar)) {
            return;
        }
        this.aoW.add(aVar);
    }

    public final void a(a aVar) {
        this.aoW.remove(aVar);
    }
}
