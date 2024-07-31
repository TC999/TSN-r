package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.p480a.CommonError;

/* renamed from: com.mbridge.msdk.foundation.same.net.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DefaultRetryPolicy implements RetryPolicy {

    /* renamed from: a */
    private int f30692a;

    /* renamed from: b */
    private int f30693b;

    /* renamed from: c */
    private final int f30694c;

    /* renamed from: d */
    private int f30695d;

    /* renamed from: e */
    private int f30696e;

    /* renamed from: f */
    private int f30697f;

    /* renamed from: g */
    private int f30698g;

    /* renamed from: h */
    private int f30699h;

    public DefaultRetryPolicy() {
        this(30000, 0);
    }

    @Override // com.mbridge.msdk.foundation.same.net.RetryPolicy
    /* renamed from: a */
    public final int mo22174a() {
        return this.f30694c;
    }

    @Override // com.mbridge.msdk.foundation.same.net.RetryPolicy
    /* renamed from: b */
    public final int mo22172b() {
        return this.f30692a;
    }

    @Override // com.mbridge.msdk.foundation.same.net.RetryPolicy
    /* renamed from: c */
    public final int mo22171c() {
        return this.f30693b;
    }

    @Override // com.mbridge.msdk.foundation.same.net.RetryPolicy
    /* renamed from: d */
    public final int mo22170d() {
        return this.f30696e;
    }

    @Override // com.mbridge.msdk.foundation.same.net.RetryPolicy
    /* renamed from: e */
    public final int mo22169e() {
        return this.f30697f;
    }

    @Override // com.mbridge.msdk.foundation.same.net.RetryPolicy
    /* renamed from: f */
    public final int mo22168f() {
        return this.f30698g;
    }

    @Override // com.mbridge.msdk.foundation.same.net.RetryPolicy
    /* renamed from: g */
    public final int mo22167g() {
        return this.f30699h;
    }

    public DefaultRetryPolicy(int i, int i2) {
        this.f30695d = 2;
        this.f30696e = 0;
        this.f30697f = 0;
        this.f30698g = 0;
        this.f30699h = 0;
        this.f30692a = i <= 0 ? 30000 : i;
        this.f30694c = i2;
    }

    @Override // com.mbridge.msdk.foundation.same.net.RetryPolicy
    /* renamed from: a */
    public final boolean mo22173a(CommonError commonError) {
        int i = this.f30693b + 1;
        this.f30693b = i;
        return i <= this.f30694c;
    }

    public DefaultRetryPolicy(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f30695d = 2;
        this.f30696e = 0;
        this.f30697f = 0;
        this.f30698g = 0;
        this.f30699h = 0;
        this.f30696e = Math.max(i, 0);
        this.f30697f = Math.max(i2, 0);
        this.f30698g = Math.max(i3, 0);
        this.f30699h = Math.max(i4, 0);
        this.f30694c = Math.max(i5, 0);
        this.f30695d = i6;
    }
}
