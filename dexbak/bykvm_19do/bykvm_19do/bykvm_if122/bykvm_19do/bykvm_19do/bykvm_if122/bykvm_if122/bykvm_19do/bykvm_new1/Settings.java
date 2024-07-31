package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.Arrays;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Settings {

    /* renamed from: a */
    private int f1203a;

    /* renamed from: b */
    private final int[] f1204b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58522a() {
        this.f1203a = 0;
        Arrays.fill(this.f1204b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m58518b() {
        if ((this.f1203a & 2) != 0) {
            return this.f1204b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m58515c(int i) {
        return (this.f1203a & 32) != 0 ? this.f1204b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean m58513d(int i) {
        return ((1 << i) & this.f1203a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m58517b(int i) {
        return (this.f1203a & 16) != 0 ? this.f1204b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m58516c() {
        if ((this.f1203a & 128) != 0) {
            return this.f1204b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m58514d() {
        return Integer.bitCount(this.f1203a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Settings m58520a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f1204b;
            if (i < iArr.length) {
                this.f1203a = (1 << i) | this.f1203a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m58521a(int i) {
        return this.f1204b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58519a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.m58513d(i)) {
                m58520a(i, settings.m58521a(i));
            }
        }
    }
}
