package com.bytedance.pangle.f.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    int[] f28761a = new int[32];

    /* renamed from: b  reason: collision with root package name */
    int f28762b;

    /* renamed from: c  reason: collision with root package name */
    int f28763c;

    public final void a() {
        b();
        int i4 = this.f28762b;
        int[] iArr = this.f28761a;
        iArr[i4] = 0;
        iArr[i4 + 1] = 0;
        this.f28762b = i4 + 2;
        this.f28763c++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        int[] iArr = this.f28761a;
        int length = iArr.length;
        int i4 = this.f28762b;
        int i5 = length - i4;
        if (i5 <= 2) {
            int[] iArr2 = new int[(iArr.length + i5) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f28761a = iArr2;
        }
    }
}
