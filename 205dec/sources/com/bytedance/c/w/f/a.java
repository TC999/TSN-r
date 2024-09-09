package com.bytedance.c.w.f;

import android.os.Handler;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Handler f26527a;

    /* renamed from: b  reason: collision with root package name */
    private final long f26528b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26529c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Handler handler, long j4, long j5) {
        this.f26527a = handler;
        this.f26528b = j4;
        this.f26529c = j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (c() > 0) {
            this.f26527a.postDelayed(this, c());
        } else {
            this.f26527a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j4) {
        if (j4 > 0) {
            this.f26527a.postDelayed(this, j4);
        } else {
            this.f26527a.post(this);
        }
    }

    long c() {
        return this.f26528b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.f26529c;
    }
}
