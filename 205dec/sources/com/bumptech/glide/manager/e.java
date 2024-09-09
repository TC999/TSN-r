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
import com.bumptech.glide.manager.c;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class e implements c {

    /* renamed from: f  reason: collision with root package name */
    private static final String f17589f = "ConnectivityMonitor";

    /* renamed from: a  reason: collision with root package name */
    private final Context f17590a;

    /* renamed from: b  reason: collision with root package name */
    final c.a f17591b;

    /* renamed from: c  reason: collision with root package name */
    boolean f17592c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17593d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f17594e = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DefaultConnectivityMonitor.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z3 = eVar.f17592c;
            eVar.f17592c = eVar.a(context);
            if (z3 != e.this.f17592c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f17592c);
                }
                e eVar2 = e.this;
                eVar2.f17591b.a(eVar2.f17592c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(@NonNull Context context, @NonNull c.a aVar) {
        this.f17590a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f17591b = aVar;
    }

    private void c() {
        if (this.f17593d) {
            return;
        }
        this.f17592c = a(this.f17590a);
        try {
            this.f17590a.registerReceiver(this.f17594e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f17593d = true;
        } catch (SecurityException e4) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e4);
            }
        }
    }

    private void d() {
        if (this.f17593d) {
            this.f17590a.unregisterReceiver(this.f17594e);
            this.f17593d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.bumptech.glide.util.j.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e4) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e4);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
        c();
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
        d();
    }
}
