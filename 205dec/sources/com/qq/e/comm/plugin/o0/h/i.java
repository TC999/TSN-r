package com.qq.e.comm.plugin.o0.h;

import android.util.Pair;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f45198a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f45199b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4, int i5) {
        this.f45198a = i4;
        this.f45199b = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair<Integer, Integer> a(int i4, int i5, int i6, int i7) {
        if (this.f45198a != 0 && this.f45199b != 0) {
            if (i4 == 1073741824 && i5 == 1073741824) {
                if (this.f45198a * i7 < this.f45199b * i6) {
                    i6 = (this.f45198a * i7) / this.f45199b;
                } else if (this.f45198a * i7 > this.f45199b * i6) {
                    i7 = (this.f45199b * i6) / this.f45198a;
                }
            } else if (i4 == 1073741824) {
                int i8 = (this.f45199b * i6) / this.f45198a;
                if (i5 != Integer.MIN_VALUE || i8 <= i7) {
                    i7 = i8;
                }
            } else if (i5 == 1073741824) {
                int i9 = (this.f45198a * i7) / this.f45199b;
                if (i4 != Integer.MIN_VALUE || i9 <= i6) {
                    i6 = i9;
                }
            } else {
                int i10 = this.f45198a;
                int i11 = this.f45199b;
                if (i5 != Integer.MIN_VALUE || i11 <= i7) {
                    i7 = i11;
                } else {
                    i10 = (this.f45198a * i7) / this.f45199b;
                }
                if (i4 != Integer.MIN_VALUE || i10 <= i6) {
                    i6 = i10;
                } else {
                    i7 = (this.f45199b * i6) / this.f45198a;
                }
            }
            return new Pair<>(Integer.valueOf(i6), Integer.valueOf(i7));
        }
        return new Pair<>(0, 0);
    }
}
