package com.acse.ottn.animator.p031a;

/* renamed from: com.acse.ottn.animator.a.E */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1323E extends C1331L {

    /* renamed from: N */
    private InterfaceC1324a f2293N;

    /* renamed from: O */
    private long f2294O = -1;

    /* renamed from: com.acse.ottn.animator.a.E$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1324a {
        /* renamed from: a */
        void m57160a(C1323E c1323e, long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.acse.ottn.animator.p031a.C1331L
    /* renamed from: A */
    public void mo57058A() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.acse.ottn.animator.p031a.C1331L
    /* renamed from: a */
    public void mo57055a(float f) {
    }

    /* renamed from: a */
    public void m57161a(InterfaceC1324a interfaceC1324a) {
        this.f2293N = interfaceC1324a;
    }

    @Override // com.acse.ottn.animator.p031a.C1331L
    /* renamed from: c */
    boolean mo57139c(long j) {
        if (this.f2315B == 0) {
            this.f2315B = 1;
            long j2 = this.f2328v;
            if (j2 < 0) {
                this.f2327u = j;
            } else {
                this.f2327u = j - j2;
                this.f2328v = -1L;
            }
        }
        InterfaceC1324a interfaceC1324a = this.f2293N;
        if (interfaceC1324a != null) {
            long j3 = j - this.f2327u;
            long j4 = this.f2294O;
            long j5 = j4 >= 0 ? j - j4 : 0L;
            this.f2294O = j;
            interfaceC1324a.m57160a(this, j3, j5);
            return false;
        }
        return false;
    }
}
