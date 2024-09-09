package com.bytedance.sdk.openadsdk.core.component.reward.ux;

import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements c.w {

    /* renamed from: c  reason: collision with root package name */
    long f32603c;

    /* renamed from: w  reason: collision with root package name */
    private long f32604w;
    private long xv;

    public xv() {
        k.sr().c(this);
    }

    public long c(TimeUnit timeUnit) {
        if (timeUnit != null) {
            return timeUnit.convert(this.f32603c, TimeUnit.MILLISECONDS);
        }
        return this.f32603c;
    }

    public void sr() {
        if (this.f32604w == 0) {
            return;
        }
        this.f32603c += System.currentTimeMillis() - this.f32604w;
        this.f32604w = 0L;
        this.xv = 0L;
    }

    public void ux() {
        this.f32604w = 0L;
        this.xv = 0L;
        this.f32603c = 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void w() {
        xv();
    }

    public void xv() {
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = this.f32604w;
        if (j4 != 0) {
            this.f32603c += currentTimeMillis - j4;
        }
        this.f32604w = currentTimeMillis;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void c() {
        sr();
    }
}
