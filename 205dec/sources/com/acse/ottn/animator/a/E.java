package com.acse.ottn.animator.a;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class E extends L {
    private a N;
    private long O = -1;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a(E e4, long j4, long j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.acse.ottn.animator.a.L
    public void A() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.acse.ottn.animator.a.L
    public void a(float f4) {
    }

    public void a(a aVar) {
        this.N = aVar;
    }

    @Override // com.acse.ottn.animator.a.L
    boolean c(long j4) {
        if (this.B == 0) {
            this.B = 1;
            long j5 = this.f4875v;
            if (j5 < 0) {
                this.f4874u = j4;
            } else {
                this.f4874u = j4 - j5;
                this.f4875v = -1L;
            }
        }
        a aVar = this.N;
        if (aVar != null) {
            long j6 = j4 - this.f4874u;
            long j7 = this.O;
            long j8 = j7 >= 0 ? j4 - j7 : 0L;
            this.O = j4;
            aVar.a(this, j6, j8);
            return false;
        }
        return false;
    }
}
