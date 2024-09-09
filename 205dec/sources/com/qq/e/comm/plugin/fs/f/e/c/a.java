package com.qq.e.comm.plugin.fs.f.e.c;

import com.qq.e.comm.plugin.r0.n;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final n f43391a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f43392b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f43393c;

    public a(n nVar) {
        this.f43391a = nVar;
    }

    public abstract int a();

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(long j4) {
        int a4 = ((int) ((a() - j4) + 500)) / 1000;
        if (a4 == 0) {
            return 1;
        }
        return a4;
    }

    public void b(long j4) {
        if (this.f43393c || this.f43391a == null) {
            return;
        }
        if (a() - j4 <= 0) {
            this.f43393c = true;
            c();
        } else if (this.f43392b) {
            this.f43391a.a((CharSequence) String.valueOf(a(j4)));
        } else {
            this.f43392b = true;
            d();
        }
    }

    protected abstract void c();

    protected abstract void d();

    public boolean b() {
        return this.f43393c;
    }
}
