package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private int f1196a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1197b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f1196a = 0;
        Arrays.fill(this.f1197b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        if ((this.f1196a & 2) != 0) {
            return this.f1197b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i4) {
        return (this.f1196a & 32) != 0 ? this.f1197b[5] : i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i4) {
        return ((1 << i4) & this.f1196a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i4) {
        return (this.f1196a & 16) != 0 ? this.f1197b[4] : i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.f1196a & 128) != 0) {
            return this.f1197b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return Integer.bitCount(this.f1196a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n a(int i4, int i5) {
        if (i4 >= 0) {
            int[] iArr = this.f1197b;
            if (i4 < iArr.length) {
                this.f1196a = (1 << i4) | this.f1196a;
                iArr[i4] = i5;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i4) {
        return this.f1197b[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        for (int i4 = 0; i4 < 10; i4++) {
            if (nVar.d(i4)) {
                a(i4, nVar.a(i4));
            }
        }
    }
}
