package com.bytedance.sdk.component.widget.recycler.c.xv;

import android.view.View;
import android.view.ViewParent;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private ViewParent f30587c;
    private boolean sr;
    private int[] ux;

    /* renamed from: w  reason: collision with root package name */
    private ViewParent f30588w;
    private final View xv;

    public sr(View view) {
        this.xv = view;
    }

    private ViewParent sr(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return null;
            }
            return this.f30588w;
        }
        return this.f30587c;
    }

    public void c(boolean z3) {
        if (this.sr) {
            r.p(this.xv);
        }
        this.sr = z3;
    }

    public boolean w() {
        return c(0);
    }

    public void xv() {
        xv(0);
    }

    public boolean w(int i4) {
        return c(i4, 0);
    }

    public void xv(int i4) {
        ViewParent sr = sr(i4);
        if (sr != null) {
            ev.c(sr, this.xv, i4);
            c(i4, (ViewParent) null);
        }
    }

    public boolean c() {
        return this.sr;
    }

    public boolean c(int i4) {
        return sr(i4) != null;
    }

    public boolean c(int i4, int i5) {
        if (c(i5)) {
            return true;
        }
        if (c()) {
            View view = this.xv;
            for (ViewParent parent = this.xv.getParent(); parent != null; parent = parent.getParent()) {
                if (ev.c(parent, view, this.xv, i4, i5)) {
                    c(i5, parent);
                    ev.w(parent, view, this.xv, i4, i5);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public boolean c(int i4, int i5, int i6, int i7, int[] iArr) {
        return c(i4, i5, i6, i7, iArr, 0);
    }

    public boolean c(int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        ViewParent sr;
        int i9;
        int i10;
        if (!c() || (sr = sr(i8)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.xv.getLocationInWindow(iArr);
            i9 = iArr[0];
            i10 = iArr[1];
        } else {
            i9 = 0;
            i10 = 0;
        }
        ev.c(sr, this.xv, i4, i5, i6, i7, i8);
        if (iArr != null) {
            this.xv.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i9;
            iArr[1] = iArr[1] - i10;
        }
        return true;
    }

    public boolean c(int i4, int i5, int[] iArr, int[] iArr2) {
        return c(i4, i5, iArr, iArr2, 0);
    }

    public boolean c(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        ViewParent sr;
        int i7;
        int i8;
        if (!c() || (sr = sr(i6)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
            return false;
        }
        if (iArr2 != null) {
            this.xv.getLocationInWindow(iArr2);
            i7 = iArr2[0];
            i8 = iArr2[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr == null) {
            if (this.ux == null) {
                this.ux = new int[2];
            }
            iArr = this.ux;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ev.c(sr, this.xv, i4, i5, iArr, i6);
        if (iArr2 != null) {
            this.xv.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i7;
            iArr2[1] = iArr2[1] - i8;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean c(float f4, float f5, boolean z3) {
        ViewParent sr;
        if (!c() || (sr = sr(0)) == null) {
            return false;
        }
        return ev.c(sr, this.xv, f4, f5, z3);
    }

    public boolean c(float f4, float f5) {
        ViewParent sr;
        if (!c() || (sr = sr(0)) == null) {
            return false;
        }
        return ev.c(sr, this.xv, f4, f5);
    }

    private void c(int i4, ViewParent viewParent) {
        if (i4 == 0) {
            this.f30587c = viewParent;
        } else if (i4 != 1) {
        } else {
            this.f30588w = viewParent;
        }
    }
}
