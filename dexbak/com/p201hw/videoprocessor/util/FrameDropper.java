package com.p201hw.videoprocessor.util;

/* renamed from: com.hw.videoprocessor.util.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FrameDropper {

    /* renamed from: a */
    private int f24130a;

    /* renamed from: b */
    private int f24131b;

    /* renamed from: c */
    private boolean f24132c;

    /* renamed from: d */
    private int f24133d;

    /* renamed from: e */
    private int f24134e;

    public FrameDropper(int i, int i2) {
        this.f24130a = i;
        this.f24131b = i2;
        if (i <= i2) {
            CL.m34896f("原始帧率:" + i + "小于目标帧率:" + i2 + "，不支持补帧", new Object[0]);
            this.f24132c = true;
        }
    }

    /* renamed from: a */
    public boolean m34878a(int i) {
        int i2;
        if (this.f24132c) {
            return false;
        }
        if (i == 0) {
            this.f24134e++;
            return false;
        }
        float f = (i2 - this.f24131b) / this.f24130a;
        int i3 = this.f24133d;
        int i4 = this.f24134e;
        boolean z = Math.abs((((float) (i3 + 1)) / ((float) (i3 + i4))) - f) < Math.abs((((float) i3) / ((float) ((i3 + i4) + 1))) - f);
        if (z) {
            this.f24133d++;
        } else {
            this.f24134e++;
        }
        return z;
    }

    /* renamed from: b */
    public void m34877b() {
        if (this.f24132c) {
            return;
        }
        int i = this.f24133d;
        int i2 = this.f24134e;
        int i3 = this.f24130a;
        float f = i2 / ((i + i2) / i3);
        float f2 = (i3 - this.f24131b) / i3;
        CL.m34891k("最终帧率为:" + f, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("实际丢帧率:");
        int i4 = this.f24133d;
        sb.append(i4 / (i4 + this.f24134e));
        sb.append(" 目标丢帧率:");
        sb.append(f2);
        CL.m34891k(sb.toString(), new Object[0]);
    }
}
