package com.bytedance.pangle.p121f.p122a;

/* renamed from: com.bytedance.pangle.f.a.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6116c {

    /* renamed from: a */
    int[] f22000a = new int[32];

    /* renamed from: b */
    int f22001b;

    /* renamed from: c */
    int f22002c;

    /* renamed from: a */
    public final void m37152a() {
        m37151b();
        int i = this.f22001b;
        int[] iArr = this.f22000a;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.f22001b = i + 2;
        this.f22002c++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m37151b() {
        int[] iArr = this.f22000a;
        int length = iArr.length;
        int i = this.f22001b;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.f22000a = iArr2;
        }
    }
}
