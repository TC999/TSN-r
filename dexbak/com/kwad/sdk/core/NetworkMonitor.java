package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class NetworkMonitor {
    private static volatile boolean aoV;
    private final List<InterfaceC9881a> aoW;
    private boolean aoX;
    private final BroadcastReceiver aoY;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    enum Holder {
        INSTANCE;
        
        private final NetworkMonitor mInstance = new NetworkMonitor((byte) 0);

        Holder() {
        }

        final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* renamed from: com.kwad.sdk.core.NetworkMonitor$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9881a {
        /* renamed from: a */
        void mo24766a(NetworkState networkState);
    }

    /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    /* renamed from: aP */
    private synchronized void m27462aP(Context context) {
        if (aoV || context == null) {
            return;
        }
        StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(this.aoY, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        aoV = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m27461b(NetworkState networkState) {
        for (InterfaceC9881a interfaceC9881a : this.aoW) {
            interfaceC9881a.mo24766a(networkState);
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
                    if ((ContextCompat.checkSelfPermission(context, C7282g.f24944b) == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.m27461b(NetworkState.NETWORK_NONE);
                        } else if (1 == activeNetworkInfo.getType()) {
                            NetworkMonitor.this.m27461b(NetworkState.NETWORK_WIFI);
                        } else if (activeNetworkInfo.getType() == 0) {
                            NetworkMonitor.this.m27461b(NetworkState.NETWORK_MOBILE);
                        } else {
                            NetworkMonitor.this.m27461b(NetworkState.NETWORK_NONE);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    /* renamed from: a */
    public final void m27465a(Context context, @NonNull InterfaceC9881a interfaceC9881a) {
        m27462aP(context);
        if (this.aoW.contains(interfaceC9881a)) {
            return;
        }
        this.aoW.add(interfaceC9881a);
    }

    /* renamed from: a */
    public final void m27464a(InterfaceC9881a interfaceC9881a) {
        this.aoW.remove(interfaceC9881a);
    }
}
