package com.qq.e.comm.plugin.apkmanager.u;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.i;
import com.qq.e.comm.plugin.util.q1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final ApkDownloadTask f41920a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f41921b;

    /* renamed from: c  reason: collision with root package name */
    private final Intent f41922c;

    /* renamed from: d  reason: collision with root package name */
    private Intent f41923d;

    /* renamed from: e  reason: collision with root package name */
    private Intent f41924e;

    public b(Intent intent, ApkDownloadTask apkDownloadTask, Context context) {
        this.f41922c = intent;
        this.f41920a = apkDownloadTask;
        this.f41921b = context;
    }

    private PendingIntent a(boolean z3) {
        int i4 = (Build.VERSION.SDK_INT > 30 || "S".equals(Build.VERSION.CODENAME)) ? 33554432 : 134217728;
        if (z3) {
            if (this.f41923d == null) {
                Intent intent = new Intent();
                this.f41923d = intent;
                intent.setClassName(this.f41921b, q1.a());
                this.f41923d.putExtra("gdt_activity_delegate_name", com.qq.e.comm.plugin.a.DOWNLOAD_MANAGE);
                this.f41923d.putExtra("appid", com.qq.e.comm.plugin.d0.a.d().b().a());
            }
            return PendingIntent.getActivity(this.f41921b, 0, this.f41923d, i4);
        }
        if (this.f41924e == null) {
            Intent intent2 = new Intent(this.f41922c);
            this.f41924e = intent2;
            i.a(intent2, true);
        }
        return PendingIntent.getService(this.f41921b, this.f41920a.t(), this.f41924e, i4);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.e
    public PendingIntent b() {
        return a(true);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.e
    public PendingIntent c() {
        return a(false);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.e
    public PendingIntent d() {
        return a(false);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.e
    public PendingIntent e() {
        return a(true);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.e
    public PendingIntent a() {
        return PendingIntent.getActivity(this.f41921b, this.f41920a.t(), this.f41922c, Build.VERSION.SDK_INT >= 23 ? TTAdConstant.KEY_CLICK_AREA : 0);
    }
}
