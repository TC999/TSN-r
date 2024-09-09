package com.qq.e.comm.plugin.e0.d.h;

import android.os.Handler;
import android.os.Looper;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected Handler f42808a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    protected final Object f42809b = new Object();

    /* renamed from: c  reason: collision with root package name */
    protected final c<T> f42810c;

    public a(c<T> cVar) {
        this.f42810c = cVar;
    }

    protected abstract void a();

    public final void b() {
        a();
    }
}
