package com.acse.ottn;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d4 extends g4 {
    public a N;
    public long O = -1;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(d4 d4Var, long j4, long j5);
    }

    @Override // com.acse.ottn.g4
    public void D() {
    }

    @Override // com.acse.ottn.g4
    public void a(float f4) {
    }

    public void a(a aVar) {
        this.N = aVar;
    }

    @Override // com.acse.ottn.g4
    public boolean c(long j4) {
        if (this.f5695i == 0) {
            this.f5695i = 1;
            long j5 = this.f5689c;
            if (j5 < 0) {
                this.f5688b = j4;
            } else {
                this.f5688b = j4 - j5;
                this.f5689c = -1L;
            }
        }
        a aVar = this.N;
        if (aVar != null) {
            long j6 = j4 - this.f5688b;
            long j7 = this.O;
            long j8 = j7 >= 0 ? j4 - j7 : 0L;
            this.O = j4;
            aVar.a(this, j6, j8);
            return false;
        }
        return false;
    }
}
