package com.qq.e.comm.plugin.apkmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends BroadcastReceiver implements p.h {

    /* renamed from: e  reason: collision with root package name */
    private static final e f41778e = new e();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f41779a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f41780b;

    /* renamed from: c  reason: collision with root package name */
    boolean f41781c;

    /* renamed from: d  reason: collision with root package name */
    private b f41782d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f41783c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f41784d;

        a(e eVar, String str, boolean z3) {
            this.f41783c = str;
            this.f41784d = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApkDownloadTask c4;
            com.qq.e.comm.plugin.f.e.d().a(this.f41783c, this.f41784d);
            if (!this.f41784d || (c4 = k.e().c(this.f41783c)) == null) {
                return;
            }
            com.qq.e.comm.plugin.apkmanager.x.d.a(1100937, c4);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    interface b {
        void b(String str);
    }

    private e() {
        this.f41780b = com.qq.e.comm.plugin.d0.a.d().f().a("raisr", 0) == 1;
        boolean a4 = com.qq.e.comm.plugin.m0.b.a("hieib");
        this.f41781c = a4;
        if (a4) {
            com.qq.e.comm.plugin.util.p.b().a(this);
        }
    }

    public static e d() {
        return f41778e;
    }

    public void a(b bVar) {
        this.f41782d = bVar;
    }

    @Override // com.qq.e.comm.plugin.util.p.h
    public boolean b() {
        f();
        return false;
    }

    @Override // com.qq.e.comm.plugin.util.p.h
    public boolean c() {
        g();
        return false;
    }

    public void e() {
        if (this.f41780b) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if ((!this.f41781c || com.qq.e.comm.plugin.util.p.b().c()) && this.f41779a.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            if (this.f41780b) {
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            }
            intentFilter.addDataScheme("package");
            try {
                com.qq.e.comm.plugin.d0.a.d().a().registerReceiver(this, intentFilter);
            } catch (Throwable unused) {
            }
        }
    }

    void g() {
        if (this.f41779a.compareAndSet(true, false)) {
            try {
                com.qq.e.comm.plugin.d0.a.d().a().unregisterReceiver(this);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (dataString != null && dataString.startsWith("package:")) {
            dataString = dataString.substring(8);
        }
        String action = intent.getAction();
        d1.a("gdt_tag_download_apk", "\u5305\u540d: %s, action %s", dataString, action);
        if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
            b bVar = this.f41782d;
            if (bVar != null) {
                bVar.b(dataString);
            }
            a(dataString, false);
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            a(dataString, true);
        }
    }

    private void a(String str, boolean z3) {
        if (this.f41780b) {
            d0.f46406b.submit(new a(this, str, z3));
        }
    }
}
