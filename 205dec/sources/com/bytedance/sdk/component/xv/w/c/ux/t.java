package com.bytedance.sdk.component.xv.w.c.ux;

import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class t {

    /* renamed from: c  reason: collision with root package name */
    private int f30897c;

    /* renamed from: w  reason: collision with root package name */
    private final int[] f30898w = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f30897c = 0;
        Arrays.fill(this.f30898w, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int sr(int i4) {
        return (this.f30897c & 32) != 0 ? this.f30898w[5] : i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(int i4) {
        return this.f30898w[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int xv() {
        if ((this.f30897c & 2) != 0) {
            return this.f30898w[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int sr() {
        if ((this.f30897c & 128) != 0) {
            return this.f30898w[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w() {
        return Integer.bitCount(this.f30897c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int xv(int i4) {
        return (this.f30897c & 16) != 0 ? this.f30898w[4] : i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t c(int i4, int i5) {
        if (i4 >= 0) {
            int[] iArr = this.f30898w;
            if (i4 < iArr.length) {
                this.f30897c = (1 << i4) | this.f30897c;
                iArr[i4] = i5;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i4) {
        return ((1 << i4) & this.f30897c) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(t tVar) {
        for (int i4 = 0; i4 < 10; i4++) {
            if (tVar.c(i4)) {
                c(i4, tVar.w(i4));
            }
        }
    }
}
