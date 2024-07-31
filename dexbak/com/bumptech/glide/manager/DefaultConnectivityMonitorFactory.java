package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor;

/* renamed from: com.bumptech.glide.manager.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {

    /* renamed from: a */
    private static final String f14279a = "ConnectivityMonitor";

    /* renamed from: b */
    private static final String f14280b = "android.permission.ACCESS_NETWORK_STATE";

    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    @NonNull
    /* renamed from: a */
    public ConnectivityMonitor mo44763a(@NonNull Context context, @NonNull ConnectivityMonitor.InterfaceC3736a interfaceC3736a) {
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable(f14279a, 3)) {
            Log.d(f14279a, z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new DefaultConnectivityMonitor(context, interfaceC3736a) : new NullConnectivityMonitor();
    }
}
