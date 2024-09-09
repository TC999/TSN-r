package com.qq.e.comm.plugin.d.g;

import android.os.Looper;
import com.qq.e.comm.plugin.util.b1;
import java.io.File;
import java.util.UUID;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    final String f42186a;

    /* renamed from: b  reason: collision with root package name */
    final Thread f42187b;

    /* renamed from: c  reason: collision with root package name */
    final Throwable f42188c;

    /* renamed from: d  reason: collision with root package name */
    final long f42189d;

    /* renamed from: e  reason: collision with root package name */
    final long f42190e;

    /* renamed from: f  reason: collision with root package name */
    final StackTraceElement[] f42191f;

    /* renamed from: g  reason: collision with root package name */
    final String f42192g;

    /* renamed from: h  reason: collision with root package name */
    File f42193h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f42194i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f42195j;

    /* renamed from: k  reason: collision with root package name */
    byte[] f42196k;

    public b(Thread thread, Throwable th) {
        this.f42186a = UUID.randomUUID().toString();
        this.f42189d = System.currentTimeMillis();
        this.f42192g = this.f42189d + "-" + this.f42186a;
        this.f42190e = this.f42189d - com.qq.e.comm.plugin.d.a.g();
        this.f42187b = thread;
        this.f42188c = th;
        this.f42191f = th.getStackTrace();
        this.f42194i = this.f42190e > com.qq.e.comm.plugin.d.a.e();
        this.f42195j = this.f42187b == Looper.getMainLooper().getThread();
    }

    public b(String str, File file) {
        this.f42192g = str;
        int indexOf = str.indexOf(45);
        this.f42186a = str.substring(indexOf + 1);
        this.f42187b = null;
        this.f42188c = null;
        this.f42189d = Long.parseLong(str.substring(0, indexOf));
        this.f42190e = 0L;
        this.f42191f = null;
        this.f42193h = file;
        this.f42196k = b1.e(file);
        this.f42194i = true;
        this.f42195j = false;
    }
}
