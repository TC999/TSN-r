package com.kwad.components.core.q;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {
    private static volatile a Ss;
    private int Pb;
    private int St;
    private boolean Su;
    private boolean Sv;
    private int Sw;
    private boolean Sx;

    private a() {
    }

    public static a qH() {
        if (Ss == null) {
            synchronized (a.class) {
                if (Ss == null) {
                    Ss = new a();
                }
            }
        }
        return Ss;
    }

    public final void aH(int i4) {
        this.St = i4;
    }

    public final void aI(int i4) {
        this.Sw = i4;
    }

    public final void aJ(int i4) {
        this.Pb = i4;
    }

    public final void aK(boolean z3) {
        this.Su = true;
    }

    public final void aL(boolean z3) {
        this.Sv = z3;
    }

    public final void aM(boolean z3) {
        this.Sx = z3;
    }

    public final void clear() {
        this.Sv = false;
        this.Su = false;
        this.Sw = 0;
        this.Sx = false;
        this.St = -1;
        this.Pb = 0;
    }

    public final int qI() {
        return this.St;
    }

    public final boolean qJ() {
        return this.Su;
    }

    public final boolean qK() {
        return this.Sv;
    }

    public final boolean qL() {
        int i4 = this.Sw;
        return i4 == 1 || i4 == 3;
    }

    public final int qM() {
        return this.Sw;
    }

    public final boolean qN() {
        return this.Sx;
    }

    public final int qO() {
        return this.Pb;
    }
}
