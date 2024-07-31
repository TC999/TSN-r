package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.C3770j;
import com.stub.StubApp;

/* renamed from: com.bumptech.glide.manager.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* renamed from: f */
    private static final String f14272f = "ConnectivityMonitor";

    /* renamed from: a */
    private final Context f14273a;

    /* renamed from: b */
    final ConnectivityMonitor.InterfaceC3736a f14274b;

    /* renamed from: c */
    boolean f14275c;

    /* renamed from: d */
    private boolean f14276d;

    /* renamed from: e */
    private final BroadcastReceiver f14277e = new C3737a();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* renamed from: com.bumptech.glide.manager.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3737a extends BroadcastReceiver {
        C3737a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            boolean z = defaultConnectivityMonitor.f14275c;
            defaultConnectivityMonitor.f14275c = defaultConnectivityMonitor.m44766a(context);
            if (z != DefaultConnectivityMonitor.this.f14275c) {
                if (Log.isLoggable(DefaultConnectivityMonitor.f14272f, 3)) {
                    Log.d(DefaultConnectivityMonitor.f14272f, "connectivity changed, isConnected: " + DefaultConnectivityMonitor.this.f14275c);
                }
                DefaultConnectivityMonitor defaultConnectivityMonitor2 = DefaultConnectivityMonitor.this;
                defaultConnectivityMonitor2.f14274b.mo44767a(defaultConnectivityMonitor2.f14275c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultConnectivityMonitor(@NonNull Context context, @NonNull ConnectivityMonitor.InterfaceC3736a interfaceC3736a) {
        this.f14273a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f14274b = interfaceC3736a;
    }

    /* renamed from: c */
    private void m44765c() {
        if (this.f14276d) {
            return;
        }
        this.f14275c = m44766a(this.f14273a);
        try {
            this.f14273a.registerReceiver(this.f14277e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f14276d = true;
        } catch (SecurityException e) {
            if (Log.isLoggable(f14272f, 5)) {
                Log.w(f14272f, "Failed to register", e);
            }
        }
    }

    /* renamed from: d */
    private void m44764d() {
        if (this.f14276d) {
            this.f14273a.unregisterReceiver(this.f14277e);
            this.f14276d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    boolean m44766a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C3770j.m44392d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable(f14272f, 5)) {
                Log.w(f14272f, "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        m44765c();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        m44764d();
    }
}
