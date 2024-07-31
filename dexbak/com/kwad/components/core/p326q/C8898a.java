package com.kwad.components.core.p326q;

/* renamed from: com.kwad.components.core.q.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8898a {

    /* renamed from: Ss */
    private static volatile C8898a f28761Ss;

    /* renamed from: Pb */
    private int f28762Pb;

    /* renamed from: St */
    private int f28763St;

    /* renamed from: Su */
    private boolean f28764Su;

    /* renamed from: Sv */
    private boolean f28765Sv;

    /* renamed from: Sw */
    private int f28766Sw;

    /* renamed from: Sx */
    private boolean f28767Sx;

    private C8898a() {
    }

    /* renamed from: qH */
    public static C8898a m29651qH() {
        if (f28761Ss == null) {
            synchronized (C8898a.class) {
                if (f28761Ss == null) {
                    f28761Ss = new C8898a();
                }
            }
        }
        return f28761Ss;
    }

    /* renamed from: aH */
    public final void m29657aH(int i) {
        this.f28763St = i;
    }

    /* renamed from: aI */
    public final void m29656aI(int i) {
        this.f28766Sw = i;
    }

    /* renamed from: aJ */
    public final void m29655aJ(int i) {
        this.f28762Pb = i;
    }

    /* renamed from: aK */
    public final void m29654aK(boolean z) {
        this.f28764Su = true;
    }

    /* renamed from: aL */
    public final void m29653aL(boolean z) {
        this.f28765Sv = z;
    }

    /* renamed from: aM */
    public final void m29652aM(boolean z) {
        this.f28767Sx = z;
    }

    public final void clear() {
        this.f28765Sv = false;
        this.f28764Su = false;
        this.f28766Sw = 0;
        this.f28767Sx = false;
        this.f28763St = -1;
        this.f28762Pb = 0;
    }

    /* renamed from: qI */
    public final int m29650qI() {
        return this.f28763St;
    }

    /* renamed from: qJ */
    public final boolean m29649qJ() {
        return this.f28764Su;
    }

    /* renamed from: qK */
    public final boolean m29648qK() {
        return this.f28765Sv;
    }

    /* renamed from: qL */
    public final boolean m29647qL() {
        int i = this.f28766Sw;
        return i == 1 || i == 3;
    }

    /* renamed from: qM */
    public final int m29646qM() {
        return this.f28766Sw;
    }

    /* renamed from: qN */
    public final boolean m29645qN() {
        return this.f28767Sx;
    }

    /* renamed from: qO */
    public final int m29644qO() {
        return this.f28762Pb;
    }
}
