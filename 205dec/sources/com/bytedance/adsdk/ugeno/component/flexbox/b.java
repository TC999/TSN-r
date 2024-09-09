package com.bytedance.adsdk.ugeno.component.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l0.g;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class b {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ boolean f26090f = true;

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.adsdk.ugeno.component.flexbox.a f26091a;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f26092b;

    /* renamed from: c  reason: collision with root package name */
    int[] f26093c;

    /* renamed from: d  reason: collision with root package name */
    long[] f26094d;

    /* renamed from: e  reason: collision with root package name */
    private long[] f26095e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.adsdk.ugeno.component.flexbox.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0360b {

        /* renamed from: a  reason: collision with root package name */
        List<d> f26096a;

        /* renamed from: b  reason: collision with root package name */
        int f26097b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.f26096a = null;
            this.f26097b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        int f26098a;

        /* renamed from: b  reason: collision with root package name */
        int f26099b;

        private c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            int i4 = this.f26099b;
            int i5 = cVar.f26099b;
            return i4 != i5 ? i4 - i5 : this.f26098a - cVar.f26098a;
        }

        public String toString() {
            return "Order{order=" + this.f26099b + ", index=" + this.f26098a + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.bytedance.adsdk.ugeno.component.flexbox.a aVar) {
        this.f26091a = aVar;
    }

    private int A(w wVar, boolean z3) {
        if (z3) {
            return wVar.ys();
        }
        return wVar.fp();
    }

    private int B(boolean z3) {
        if (z3) {
            return this.f26091a.getPaddingBottom();
        }
        return this.f26091a.getPaddingEnd();
    }

    private int C(w wVar, boolean z3) {
        if (z3) {
            return wVar.t();
        }
        return wVar.bk();
    }

    private int D(int i4, w wVar, int i5) {
        com.bytedance.adsdk.ugeno.component.flexbox.a aVar = this.f26091a;
        int e4 = aVar.e(i4, aVar.getPaddingTop() + this.f26091a.getPaddingBottom() + wVar.t() + wVar.fp() + i5, wVar.w());
        int size = View.MeasureSpec.getSize(e4);
        if (size > wVar.p()) {
            return View.MeasureSpec.makeMeasureSpec(wVar.p(), View.MeasureSpec.getMode(e4));
        }
        return size < wVar.ev() ? View.MeasureSpec.makeMeasureSpec(wVar.ev(), View.MeasureSpec.getMode(e4)) : e4;
    }

    private int F(View view, boolean z3) {
        if (z3) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int G(w wVar, boolean z3) {
        if (z3) {
            return wVar.w();
        }
        return wVar.c();
    }

    private int H(boolean z3) {
        if (z3) {
            return this.f26091a.getPaddingEnd();
        }
        return this.f26091a.getPaddingBottom();
    }

    private List<c> J(int i4) {
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            c cVar = new c();
            cVar.f26099b = ((w) this.f26091a.c(i5).getLayoutParams()).xv();
            cVar.f26098a = i5;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void L(int i4, int i5, d dVar, int i6, int i7, boolean z3) {
        int i8;
        int i9;
        int i10;
        int i11 = dVar.f26118e;
        float f4 = dVar.f26124k;
        float f5 = 0.0f;
        if (f4 <= 0.0f || i6 > i11) {
            return;
        }
        float f6 = (i11 - i6) / f4;
        dVar.f26118e = i7 + dVar.f26119f;
        if (!z3) {
            dVar.f26120g = Integer.MIN_VALUE;
        }
        int i12 = 0;
        boolean z4 = false;
        int i13 = 0;
        float f7 = 0.0f;
        while (i12 < dVar.f26121h) {
            int i14 = dVar.f26128o + i12;
            View w3 = this.f26091a.w(i14);
            if (w3 == null || w3.getVisibility() == 8) {
                i8 = i11;
                i9 = i12;
            } else {
                w wVar = (w) w3.getLayoutParams();
                int flexDirection = this.f26091a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = w3.getMeasuredHeight();
                    long[] jArr = this.f26095e;
                    if (jArr != null) {
                        measuredHeight = E(jArr[i14]);
                    }
                    int measuredWidth = w3.getMeasuredWidth();
                    long[] jArr2 = this.f26095e;
                    if (jArr2 != null) {
                        measuredWidth = b(jArr2[i14]);
                    }
                    if (this.f26092b[i14] || wVar.ux() <= f5) {
                        i8 = i11;
                        i9 = i12;
                    } else {
                        float ux = measuredHeight - (wVar.ux() * f6);
                        if (i12 == dVar.f26121h - 1) {
                            ux += f7;
                            f7 = 0.0f;
                        }
                        int round = Math.round(ux);
                        if (round < wVar.ev()) {
                            round = wVar.ev();
                            this.f26092b[i14] = true;
                            dVar.f26124k -= wVar.ux();
                            i8 = i11;
                            i9 = i12;
                            z4 = true;
                        } else {
                            f7 += ux - round;
                            i8 = i11;
                            i9 = i12;
                            double d4 = f7;
                            if (d4 > 1.0d) {
                                round++;
                                f7 -= 1.0f;
                            } else if (d4 < -1.0d) {
                                round--;
                                f7 += 1.0f;
                            }
                        }
                        int a4 = a(i4, wVar, dVar.f26126m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        w3.measure(a4, makeMeasureSpec);
                        measuredWidth = w3.getMeasuredWidth();
                        int measuredHeight2 = w3.getMeasuredHeight();
                        k(i14, a4, makeMeasureSpec, w3);
                        this.f26091a.c(i14, w3);
                        measuredHeight = measuredHeight2;
                    }
                    i10 = Math.max(i13, measuredWidth + wVar.bk() + wVar.ys() + this.f26091a.c(w3));
                    dVar.f26118e += measuredHeight + wVar.t() + wVar.fp();
                } else {
                    i8 = i11;
                    int i15 = i12;
                    int measuredWidth2 = w3.getMeasuredWidth();
                    long[] jArr3 = this.f26095e;
                    if (jArr3 != null) {
                        measuredWidth2 = b(jArr3[i14]);
                    }
                    int measuredHeight3 = w3.getMeasuredHeight();
                    long[] jArr4 = this.f26095e;
                    if (jArr4 != null) {
                        measuredHeight3 = E(jArr4[i14]);
                    }
                    if (this.f26092b[i14] || wVar.ux() <= 0.0f) {
                        i9 = i15;
                    } else {
                        float ux2 = measuredWidth2 - (wVar.ux() * f6);
                        i9 = i15;
                        if (i9 == dVar.f26121h - 1) {
                            ux2 += f7;
                            f7 = 0.0f;
                        }
                        int round2 = Math.round(ux2);
                        if (round2 < wVar.r()) {
                            round2 = wVar.r();
                            this.f26092b[i14] = true;
                            dVar.f26124k -= wVar.ux();
                            z4 = true;
                        } else {
                            f7 += ux2 - round2;
                            double d5 = f7;
                            if (d5 > 1.0d) {
                                round2++;
                                f7 -= 1.0f;
                            } else if (d5 < -1.0d) {
                                round2--;
                                f7 += 1.0f;
                            }
                        }
                        int D = D(i5, wVar, dVar.f26126m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        w3.measure(makeMeasureSpec2, D);
                        int measuredWidth3 = w3.getMeasuredWidth();
                        int measuredHeight4 = w3.getMeasuredHeight();
                        k(i14, makeMeasureSpec2, D, w3);
                        this.f26091a.c(i14, w3);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i13, measuredHeight3 + wVar.t() + wVar.fp() + this.f26091a.c(w3));
                    dVar.f26118e += measuredWidth2 + wVar.bk() + wVar.ys();
                    i10 = max;
                }
                dVar.f26120g = Math.max(dVar.f26120g, i10);
                i13 = i10;
            }
            i12 = i9 + 1;
            i11 = i8;
            f5 = 0.0f;
        }
        int i16 = i11;
        if (!z4 || i16 == dVar.f26118e) {
            return;
        }
        L(i4, i5, dVar, i6, i7, true);
    }

    private void M(View view, int i4, int i5) {
        int measuredHeight;
        w wVar = (w) view.getLayoutParams();
        int min = Math.min(Math.max(((i4 - wVar.bk()) - wVar.ys()) - this.f26091a.c(view), wVar.r()), wVar.gd());
        long[] jArr = this.f26095e;
        if (jArr != null) {
            measuredHeight = E(jArr[i5]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        k(i5, makeMeasureSpec2, makeMeasureSpec, view);
        this.f26091a.c(i5, view);
    }

    private int P(w wVar, boolean z3) {
        if (z3) {
            return wVar.bk();
        }
        return wVar.t();
    }

    private int Q(boolean z3) {
        if (z3) {
            return this.f26091a.getPaddingTop();
        }
        return this.f26091a.getPaddingStart();
    }

    private void R(int i4) {
        boolean[] zArr = this.f26092b;
        if (zArr == null) {
            this.f26092b = new boolean[Math.max(i4, 10)];
        } else if (zArr.length < i4) {
            this.f26092b = new boolean[Math.max(zArr.length * 2, i4)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private int a(int i4, w wVar, int i5) {
        com.bytedance.adsdk.ugeno.component.flexbox.a aVar = this.f26091a;
        int b4 = aVar.b(i4, aVar.getPaddingLeft() + this.f26091a.getPaddingRight() + wVar.bk() + wVar.ys() + i5, wVar.c());
        int size = View.MeasureSpec.getSize(b4);
        if (size > wVar.gd()) {
            return View.MeasureSpec.makeMeasureSpec(wVar.gd(), View.MeasureSpec.getMode(b4));
        }
        return size < wVar.r() ? View.MeasureSpec.makeMeasureSpec(wVar.r(), View.MeasureSpec.getMode(b4)) : b4;
    }

    private int c(View view, boolean z3) {
        if (z3) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int d(w wVar, boolean z3) {
        if (z3) {
            return wVar.c();
        }
        return wVar.w();
    }

    private int e(boolean z3) {
        if (z3) {
            return this.f26091a.getPaddingStart();
        }
        return this.f26091a.getPaddingTop();
    }

    private List<d> f(List<d> list, int i4, int i5) {
        ArrayList arrayList = new ArrayList();
        d dVar = new d();
        dVar.f26120g = (i4 - i5) / 2;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 == 0) {
                arrayList.add(dVar);
            }
            arrayList.add(list.get(i6));
            if (i6 == list.size() - 1) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    private void k(int i4, int i5, int i6, View view) {
        long[] jArr = this.f26094d;
        if (jArr != null) {
            jArr[i4] = I(i5, i6);
        }
        long[] jArr2 = this.f26095e;
        if (jArr2 != null) {
            jArr2[i4] = I(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void l(int i4, int i5, d dVar, int i6, int i7, boolean z3) {
        int i8;
        int i9;
        int i10;
        double d4;
        int i11;
        double d5;
        float f4 = dVar.f26123j;
        float f5 = 0.0f;
        if (f4 <= 0.0f || i6 < (i8 = dVar.f26118e)) {
            return;
        }
        float f6 = (i6 - i8) / f4;
        dVar.f26118e = i7 + dVar.f26119f;
        if (!z3) {
            dVar.f26120g = Integer.MIN_VALUE;
        }
        int i12 = 0;
        boolean z4 = false;
        int i13 = 0;
        float f7 = 0.0f;
        while (i12 < dVar.f26121h) {
            int i14 = dVar.f26128o + i12;
            View w3 = this.f26091a.w(i14);
            if (w3 == null || w3.getVisibility() == 8) {
                i9 = i8;
            } else {
                w wVar = (w) w3.getLayoutParams();
                int flexDirection = this.f26091a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = w3.getMeasuredHeight();
                    long[] jArr = this.f26095e;
                    if (jArr != null) {
                        measuredHeight = E(jArr[i14]);
                    }
                    int measuredWidth = w3.getMeasuredWidth();
                    long[] jArr2 = this.f26095e;
                    if (jArr2 != null) {
                        measuredWidth = b(jArr2[i14]);
                    }
                    if (this.f26092b[i14] || wVar.sr() <= f5) {
                        i11 = i8;
                    } else {
                        float sr = measuredHeight + (wVar.sr() * f6);
                        if (i12 == dVar.f26121h - 1) {
                            sr += f7;
                            f7 = 0.0f;
                        }
                        int round = Math.round(sr);
                        if (round > wVar.p()) {
                            round = wVar.p();
                            this.f26092b[i14] = true;
                            dVar.f26123j -= wVar.sr();
                            i11 = i8;
                            z4 = true;
                        } else {
                            f7 += sr - round;
                            i11 = i8;
                            double d6 = f7;
                            if (d6 > 1.0d) {
                                round++;
                                Double.isNaN(d6);
                                d5 = d6 - 1.0d;
                            } else if (d6 < -1.0d) {
                                round--;
                                Double.isNaN(d6);
                                d5 = d6 + 1.0d;
                            }
                            f7 = (float) d5;
                        }
                        int a4 = a(i4, wVar, dVar.f26126m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        w3.measure(a4, makeMeasureSpec);
                        measuredWidth = w3.getMeasuredWidth();
                        int measuredHeight2 = w3.getMeasuredHeight();
                        k(i14, a4, makeMeasureSpec, w3);
                        this.f26091a.c(i14, w3);
                        measuredHeight = measuredHeight2;
                    }
                    i10 = Math.max(i13, measuredWidth + wVar.bk() + wVar.ys() + this.f26091a.c(w3));
                    dVar.f26118e += measuredHeight + wVar.t() + wVar.fp();
                    i9 = i11;
                } else {
                    int i15 = i8;
                    int measuredWidth2 = w3.getMeasuredWidth();
                    long[] jArr3 = this.f26095e;
                    if (jArr3 != null) {
                        measuredWidth2 = b(jArr3[i14]);
                    }
                    int measuredHeight3 = w3.getMeasuredHeight();
                    long[] jArr4 = this.f26095e;
                    i9 = i15;
                    if (jArr4 != null) {
                        measuredHeight3 = E(jArr4[i14]);
                    }
                    if (!this.f26092b[i14] && wVar.sr() > 0.0f) {
                        float sr2 = measuredWidth2 + (wVar.sr() * f6);
                        if (i12 == dVar.f26121h - 1) {
                            sr2 += f7;
                            f7 = 0.0f;
                        }
                        int round2 = Math.round(sr2);
                        if (round2 > wVar.gd()) {
                            round2 = wVar.gd();
                            this.f26092b[i14] = true;
                            dVar.f26123j -= wVar.sr();
                            z4 = true;
                        } else {
                            f7 += sr2 - round2;
                            double d7 = f7;
                            if (d7 > 1.0d) {
                                round2++;
                                Double.isNaN(d7);
                                d4 = d7 - 1.0d;
                            } else if (d7 < -1.0d) {
                                round2--;
                                Double.isNaN(d7);
                                d4 = d7 + 1.0d;
                            }
                            f7 = (float) d4;
                        }
                        int D = D(i5, wVar, dVar.f26126m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        w3.measure(makeMeasureSpec2, D);
                        int measuredWidth3 = w3.getMeasuredWidth();
                        int measuredHeight4 = w3.getMeasuredHeight();
                        k(i14, makeMeasureSpec2, D, w3);
                        this.f26091a.c(i14, w3);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i13, measuredHeight3 + wVar.t() + wVar.fp() + this.f26091a.c(w3));
                    dVar.f26118e += measuredWidth2 + wVar.bk() + wVar.ys();
                    i10 = max;
                }
                dVar.f26120g = Math.max(dVar.f26120g, i10);
                i13 = i10;
            }
            i12++;
            i8 = i9;
            f5 = 0.0f;
        }
        int i16 = i8;
        if (!z4 || i16 == dVar.f26118e) {
            return;
        }
        l(i4, i5, dVar, i6, i7, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.component.flexbox.w r0 = (com.bytedance.adsdk.ugeno.component.flexbox.w) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.r()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.r()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.gd()
            if (r1 <= r3) goto L26
            int r1 = r0.gd()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.ev()
            if (r2 >= r5) goto L32
            int r2 = r0.ev()
            goto L3e
        L32:
            int r5 = r0.p()
            if (r2 <= r5) goto L3d
            int r2 = r0.p()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.k(r8, r1, r0, r7)
            com.bytedance.adsdk.ugeno.component.flexbox.a r0 = r6.f26091a
            r0.c(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.component.flexbox.b.m(android.view.View, int):void");
    }

    private void n(View view, int i4, int i5) {
        int measuredWidth;
        w wVar = (w) view.getLayoutParams();
        int min = Math.min(Math.max(((i4 - wVar.t()) - wVar.fp()) - this.f26091a.c(view), wVar.ev()), wVar.p());
        long[] jArr = this.f26095e;
        if (jArr != null) {
            measuredWidth = b(jArr[i5]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        k(i5, makeMeasureSpec, makeMeasureSpec2, view);
        this.f26091a.c(i5, view);
    }

    private void q(CompoundButton compoundButton) {
        w wVar = (w) compoundButton.getLayoutParams();
        int r3 = wVar.r();
        int ev = wVar.ev();
        Drawable a4 = g.a(compoundButton);
        int minimumWidth = a4 == null ? 0 : a4.getMinimumWidth();
        int minimumHeight = a4 != null ? a4.getMinimumHeight() : 0;
        if (r3 == -1) {
            r3 = minimumWidth;
        }
        wVar.c(r3);
        if (ev == -1) {
            ev = minimumHeight;
        }
        wVar.w(ev);
    }

    private void t(List<d> list, d dVar, int i4, int i5) {
        dVar.f26126m = i5;
        this.f26091a.f(dVar);
        dVar.f26129p = i4;
        list.add(dVar);
    }

    private boolean u(int i4, int i5, d dVar) {
        return i4 == i5 - 1 && dVar.c() != 0;
    }

    private boolean v(View view, int i4, int i5, int i6, int i7, w wVar, int i8, int i9, int i10) {
        if (this.f26091a.getFlexWrap() == 0) {
            return false;
        }
        if (wVar.k()) {
            return true;
        }
        if (i4 == 0) {
            return false;
        }
        int maxLine = this.f26091a.getMaxLine();
        if (maxLine == -1 || maxLine > i10 + 1) {
            int a4 = this.f26091a.a(view, i8, i9);
            if (a4 > 0) {
                i7 += a4;
            }
            return i5 < i6 + i7;
        }
        return false;
    }

    private int[] w(int i4, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i4];
        int i5 = 0;
        for (c cVar : list) {
            int i6 = cVar.f26098a;
            iArr[i5] = i6;
            sparseIntArray.append(i6, cVar.f26099b);
            i5++;
        }
        return iArr;
    }

    private int z(w wVar, boolean z3) {
        if (z3) {
            return wVar.fp();
        }
        return wVar.ys();
    }

    int E(long j4) {
        return (int) (j4 >> 32);
    }

    long I(int i4, int i5) {
        return (i4 & 4294967295L) | (i5 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(int i4, int i5, int i6) {
        int i7;
        int i8;
        int flexDirection = this.f26091a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i5);
            int size = View.MeasureSpec.getSize(i5);
            i7 = mode;
            i8 = size;
        } else if (flexDirection != 2 && flexDirection != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        } else {
            i7 = View.MeasureSpec.getMode(i4);
            i8 = View.MeasureSpec.getSize(i4);
        }
        List<d> flexLinesInternal = this.f26091a.getFlexLinesInternal();
        if (i7 == 1073741824) {
            int sumOfCrossSize = this.f26091a.getSumOfCrossSize() + i6;
            int i9 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f26120g = i8 - i6;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f26091a.getAlignContent();
                if (alignContent == 1) {
                    int i10 = i8 - sumOfCrossSize;
                    d dVar = new d();
                    dVar.f26120g = i10;
                    flexLinesInternal.add(0, dVar);
                } else if (alignContent == 2) {
                    this.f26091a.setFlexLines(f(flexLinesInternal, i8, sumOfCrossSize));
                } else if (alignContent == 3) {
                    if (sumOfCrossSize >= i8) {
                        return;
                    }
                    float size2 = (i8 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f4 = 0.0f;
                    while (i9 < size3) {
                        arrayList.add(flexLinesInternal.get(i9));
                        if (i9 != flexLinesInternal.size() - 1) {
                            d dVar2 = new d();
                            if (i9 == flexLinesInternal.size() - 2) {
                                dVar2.f26120g = Math.round(f4 + size2);
                                f4 = 0.0f;
                            } else {
                                dVar2.f26120g = Math.round(size2);
                            }
                            int i11 = dVar2.f26120g;
                            f4 += size2 - i11;
                            if (f4 > 1.0f) {
                                dVar2.f26120g = i11 + 1;
                                f4 -= 1.0f;
                            } else if (f4 < -1.0f) {
                                dVar2.f26120g = i11 - 1;
                                f4 += 1.0f;
                            }
                            arrayList.add(dVar2);
                        }
                        i9++;
                    }
                    this.f26091a.setFlexLines(arrayList);
                } else if (alignContent == 4) {
                    if (sumOfCrossSize >= i8) {
                        this.f26091a.setFlexLines(f(flexLinesInternal, i8, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i8 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    d dVar3 = new d();
                    dVar3.f26120g = size4;
                    for (d dVar4 : flexLinesInternal) {
                        arrayList2.add(dVar3);
                        arrayList2.add(dVar4);
                        arrayList2.add(dVar3);
                    }
                    this.f26091a.setFlexLines(arrayList2);
                } else if (alignContent == 5 && sumOfCrossSize < i8) {
                    float size5 = (i8 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f5 = 0.0f;
                    while (i9 < size6) {
                        d dVar5 = flexLinesInternal.get(i9);
                        float f6 = dVar5.f26120g + size5;
                        if (i9 == flexLinesInternal.size() - 1) {
                            f6 += f5;
                            f5 = 0.0f;
                        }
                        int round = Math.round(f6);
                        f5 += f6 - round;
                        if (f5 > 1.0f) {
                            round++;
                            f5 -= 1.0f;
                        } else if (f5 < -1.0f) {
                            round--;
                            f5 += 1.0f;
                        }
                        dVar5.f26120g = round;
                        i9++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(C0360b c0360b, int i4, int i5) {
        s(c0360b, i5, i4, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f26091a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i4 = 0; i4 < flexItemCount; i4++) {
            View c4 = this.f26091a.c(i4);
            if (c4 != null && ((w) c4.getLayoutParams()).xv() != sparseIntArray.get(i4)) {
                return true;
            }
        }
        return false;
    }

    int b(long j4) {
        return (int) j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        h(0);
    }

    void h(int i4) {
        View w3;
        if (i4 >= this.f26091a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f26091a.getFlexDirection();
        if (this.f26091a.getAlignItems() == 4) {
            int[] iArr = this.f26093c;
            List<d> flexLinesInternal = this.f26091a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i5 = iArr != null ? iArr[i4] : 0; i5 < size; i5++) {
                d dVar = flexLinesInternal.get(i5);
                int i6 = dVar.f26121h;
                for (int i7 = 0; i7 < i6; i7++) {
                    int i8 = dVar.f26128o + i7;
                    if (i7 < this.f26091a.getFlexItemCount() && (w3 = this.f26091a.w(i8)) != null && w3.getVisibility() != 8) {
                        w wVar = (w) w3.getLayoutParams();
                        if (wVar.f() == -1 || wVar.f() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                n(w3, dVar.f26120g, i8);
                            } else if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            } else {
                                M(w3, dVar.f26120g, i8);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (d dVar2 : this.f26091a.getFlexLinesInternal()) {
            for (Integer num : dVar2.f26127n) {
                View w4 = this.f26091a.w(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    n(w4, dVar2.f26120g, num.intValue());
                } else if (flexDirection != 2 && flexDirection != 3) {
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                } else {
                    M(w4, dVar2.f26120g, num.intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i4, int i5) {
        j(i4, i5, 0);
    }

    void j(int i4, int i5, int i6) {
        int size;
        int paddingLeft;
        int paddingRight;
        R(this.f26091a.getFlexItemCount());
        if (i6 >= this.f26091a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f26091a.getFlexDirection();
        int flexDirection2 = this.f26091a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i4);
            size = View.MeasureSpec.getSize(i4);
            int largestMainSize = this.f26091a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f26091a.getPaddingLeft();
            paddingRight = this.f26091a.getPaddingRight();
        } else if (flexDirection2 != 2 && flexDirection2 != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        } else {
            int mode2 = View.MeasureSpec.getMode(i5);
            size = View.MeasureSpec.getSize(i5);
            if (mode2 != 1073741824) {
                size = this.f26091a.getLargestMainSize();
            }
            paddingLeft = this.f26091a.getPaddingTop();
            paddingRight = this.f26091a.getPaddingBottom();
        }
        int i7 = paddingLeft + paddingRight;
        int[] iArr = this.f26093c;
        int i8 = iArr != null ? iArr[i6] : 0;
        List<d> flexLinesInternal = this.f26091a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i9 = i8; i9 < size2; i9++) {
            d dVar = flexLinesInternal.get(i9);
            int i10 = dVar.f26118e;
            if (i10 < size && dVar.f26130q) {
                l(i4, i5, dVar, size, i7, false);
            } else if (i10 > size && dVar.f26131r) {
                L(i4, i5, dVar, size, i7, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(View view, d dVar, int i4, int i5, int i6, int i7) {
        w wVar = (w) view.getLayoutParams();
        int alignItems = this.f26091a.getAlignItems();
        if (wVar.f() != -1) {
            alignItems = wVar.f();
        }
        int i8 = dVar.f26120g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f26091a.getFlexWrap() != 2) {
                    int i9 = i5 + i8;
                    view.layout(i4, (i9 - view.getMeasuredHeight()) - wVar.fp(), i6, i9 - wVar.fp());
                    return;
                }
                view.layout(i4, (i5 - i8) + view.getMeasuredHeight() + wVar.t(), i6, (i7 - i8) + view.getMeasuredHeight() + wVar.t());
                return;
            } else if (alignItems == 2) {
                int measuredHeight = (((i8 - view.getMeasuredHeight()) + wVar.t()) - wVar.fp()) / 2;
                if (this.f26091a.getFlexWrap() != 2) {
                    int i10 = i5 + measuredHeight;
                    view.layout(i4, i10, i6, view.getMeasuredHeight() + i10);
                    return;
                }
                int i11 = i5 - measuredHeight;
                view.layout(i4, i11, i6, view.getMeasuredHeight() + i11);
                return;
            } else if (alignItems == 3) {
                if (this.f26091a.getFlexWrap() != 2) {
                    int max = Math.max(dVar.f26125l - view.getBaseline(), wVar.t());
                    view.layout(i4, i5 + max, i6, i7 + max);
                    return;
                }
                int max2 = Math.max((dVar.f26125l - view.getMeasuredHeight()) + view.getBaseline(), wVar.fp());
                view.layout(i4, i5 - max2, i6, i7 - max2);
                return;
            } else if (alignItems != 4) {
                return;
            }
        }
        if (this.f26091a.getFlexWrap() != 2) {
            view.layout(i4, i5 + wVar.t(), i6, i7 + wVar.t());
        } else {
            view.layout(i4, i5 - wVar.fp(), i6, i7 - wVar.fp());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view, d dVar, boolean z3, int i4, int i5, int i6, int i7) {
        w wVar = (w) view.getLayoutParams();
        int alignItems = this.f26091a.getAlignItems();
        if (wVar.f() != -1) {
            alignItems = wVar.f();
        }
        int i8 = dVar.f26120g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z3) {
                    view.layout(((i4 + i8) - view.getMeasuredWidth()) - wVar.ys(), i5, ((i6 + i8) - view.getMeasuredWidth()) - wVar.ys(), i7);
                    return;
                } else {
                    view.layout((i4 - i8) + view.getMeasuredWidth() + wVar.bk(), i5, (i6 - i8) + view.getMeasuredWidth() + wVar.bk(), i7);
                    return;
                }
            } else if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i8 - view.getMeasuredWidth()) + l0.c.a(marginLayoutParams)) - l0.c.b(marginLayoutParams)) / 2;
                if (!z3) {
                    view.layout(i4 + measuredWidth, i5, i6 + measuredWidth, i7);
                    return;
                } else {
                    view.layout(i4 - measuredWidth, i5, i6 - measuredWidth, i7);
                    return;
                }
            } else if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z3) {
            view.layout(i4 + wVar.bk(), i5, i6 + wVar.bk(), i7);
        } else {
            view.layout(i4 - wVar.ys(), i5, i6 - wVar.ys(), i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(C0360b c0360b, int i4, int i5) {
        s(c0360b, i4, i5, Integer.MAX_VALUE, 0, -1, null);
    }

    void s(C0360b c0360b, int i4, int i5, int i6, int i7, int i8, List<d> list) {
        int i9;
        C0360b c0360b2;
        int i10;
        int i11;
        int i12;
        List<d> list2;
        int i13;
        View view;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        d dVar;
        int i20;
        int i21 = i4;
        int i22 = i5;
        int i23 = i8;
        boolean c4 = this.f26091a.c();
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        ArrayList arrayList = list == null ? new ArrayList() : list;
        c0360b.f26096a = arrayList;
        boolean z3 = i23 == -1;
        int e4 = e(c4);
        int H = H(c4);
        int Q = Q(c4);
        int B = B(c4);
        d dVar2 = new d();
        int i24 = i7;
        dVar2.f26128o = i24;
        int i25 = H + e4;
        dVar2.f26118e = i25;
        int flexItemCount = this.f26091a.getFlexItemCount();
        boolean z4 = z3;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = Integer.MIN_VALUE;
        while (true) {
            if (i24 >= flexItemCount) {
                i9 = i27;
                c0360b2 = c0360b;
                break;
            }
            View w3 = this.f26091a.w(i24);
            if (w3 == null) {
                if (u(i24, flexItemCount, dVar2)) {
                    t(arrayList, dVar2, i24, i26);
                }
            } else if (w3.getVisibility() == 8) {
                dVar2.f26122i++;
                dVar2.f26121h++;
                if (u(i24, flexItemCount, dVar2)) {
                    t(arrayList, dVar2, i24, i26);
                }
            } else {
                if (w3 instanceof CompoundButton) {
                    q((CompoundButton) w3);
                }
                w wVar = (w) w3.getLayoutParams();
                int i30 = flexItemCount;
                if (wVar.f() == 4) {
                    dVar2.f26127n.add(Integer.valueOf(i24));
                }
                int d4 = d(wVar, c4);
                if (wVar.a() != -1.0f && mode == 1073741824) {
                    d4 = Math.round(size * wVar.a());
                }
                if (c4) {
                    int b4 = this.f26091a.b(i21, i25 + P(wVar, true) + A(wVar, true), d4);
                    i10 = size;
                    i11 = mode;
                    int e5 = this.f26091a.e(i22, Q + B + C(wVar, true) + z(wVar, true) + i26, G(wVar, true));
                    w3.measure(b4, e5);
                    k(i24, b4, e5, w3);
                    i12 = b4;
                } else {
                    i10 = size;
                    i11 = mode;
                    int b5 = this.f26091a.b(i22, Q + B + C(wVar, false) + z(wVar, false) + i26, G(wVar, false));
                    int e6 = this.f26091a.e(i21, P(wVar, false) + i25 + A(wVar, false), d4);
                    w3.measure(b5, e6);
                    k(i24, b5, e6, w3);
                    i12 = e6;
                }
                this.f26091a.c(i24, w3);
                m(w3, i24);
                i27 = View.combineMeasuredStates(i27, w3.getMeasuredState());
                int i31 = i26;
                int i32 = i25;
                d dVar3 = dVar2;
                int i33 = i24;
                list2 = arrayList;
                int i34 = i12;
                if (v(w3, i11, i10, dVar2.f26118e, A(wVar, c4) + c(w3, c4) + P(wVar, c4), wVar, i33, i28, arrayList.size())) {
                    if (dVar3.c() > 0) {
                        if (i33 > 0) {
                            i20 = i33 - 1;
                            dVar = dVar3;
                        } else {
                            dVar = dVar3;
                            i20 = 0;
                        }
                        t(list2, dVar, i20, i31);
                        i26 = dVar.f26120g + i31;
                    } else {
                        i26 = i31;
                    }
                    if (c4) {
                        if (wVar.w() == -1) {
                            com.bytedance.adsdk.ugeno.component.flexbox.a aVar = this.f26091a;
                            i13 = i5;
                            i24 = i33;
                            view = w3;
                            view.measure(i34, aVar.e(i13, aVar.getPaddingTop() + this.f26091a.getPaddingBottom() + wVar.t() + wVar.fp() + i26, wVar.w()));
                            m(view, i24);
                        } else {
                            i13 = i5;
                            view = w3;
                            i24 = i33;
                        }
                    } else {
                        i13 = i5;
                        view = w3;
                        i24 = i33;
                        if (wVar.c() == -1) {
                            com.bytedance.adsdk.ugeno.component.flexbox.a aVar2 = this.f26091a;
                            view.measure(aVar2.b(i13, aVar2.getPaddingLeft() + this.f26091a.getPaddingRight() + wVar.bk() + wVar.ys() + i26, wVar.c()), i34);
                            m(view, i24);
                        }
                    }
                    dVar2 = new d();
                    dVar2.f26121h = 1;
                    i14 = i32;
                    dVar2.f26118e = i14;
                    dVar2.f26128o = i24;
                    i15 = 0;
                    i16 = Integer.MIN_VALUE;
                } else {
                    i13 = i5;
                    view = w3;
                    i24 = i33;
                    dVar2 = dVar3;
                    i14 = i32;
                    dVar2.f26121h++;
                    i15 = i28 + 1;
                    i26 = i31;
                    i16 = i29;
                }
                dVar2.f26130q |= wVar.sr() != 0.0f;
                dVar2.f26131r |= wVar.ux() != 0.0f;
                int[] iArr = this.f26093c;
                if (iArr != null) {
                    iArr[i24] = list2.size();
                }
                dVar2.f26118e += c(view, c4) + P(wVar, c4) + A(wVar, c4);
                dVar2.f26123j += wVar.sr();
                dVar2.f26124k += wVar.ux();
                this.f26091a.d(view, i24, i15, dVar2);
                int max = Math.max(i16, F(view, c4) + C(wVar, c4) + z(wVar, c4) + this.f26091a.c(view));
                dVar2.f26120g = Math.max(dVar2.f26120g, max);
                if (c4) {
                    if (this.f26091a.getFlexWrap() != 2) {
                        dVar2.f26125l = Math.max(dVar2.f26125l, view.getBaseline() + wVar.t());
                    } else {
                        dVar2.f26125l = Math.max(dVar2.f26125l, (view.getMeasuredHeight() - view.getBaseline()) + wVar.fp());
                    }
                }
                i17 = i30;
                if (u(i24, i17, dVar2)) {
                    t(list2, dVar2, i24, i26);
                    i26 += dVar2.f26120g;
                }
                i18 = i8;
                if (i18 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).f26129p >= i18 && i24 >= i18 && !z4) {
                        i26 = -dVar2.a();
                        i19 = i6;
                        z4 = true;
                        if (i26 <= i19 && z4) {
                            c0360b2 = c0360b;
                            i9 = i27;
                            break;
                        }
                        i28 = i15;
                        i29 = max;
                        i24++;
                        i21 = i4;
                        flexItemCount = i17;
                        i22 = i13;
                        i25 = i14;
                        arrayList = list2;
                        mode = i11;
                        i23 = i18;
                        size = i10;
                    }
                }
                i19 = i6;
                if (i26 <= i19) {
                }
                i28 = i15;
                i29 = max;
                i24++;
                i21 = i4;
                flexItemCount = i17;
                i22 = i13;
                i25 = i14;
                arrayList = list2;
                mode = i11;
                i23 = i18;
                size = i10;
            }
            i10 = size;
            i11 = mode;
            i13 = i22;
            i18 = i23;
            list2 = arrayList;
            i14 = i25;
            i17 = flexItemCount;
            i24++;
            i21 = i4;
            flexItemCount = i17;
            i22 = i13;
            i25 = i14;
            arrayList = list2;
            mode = i11;
            i23 = i18;
            size = i10;
        }
        c0360b2.f26097b = i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] x(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f26091a.getFlexItemCount();
        return w(flexItemCount, J(flexItemCount), sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] y(View view, int i4, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f26091a.getFlexItemCount();
        List<c> J = J(flexItemCount);
        c cVar = new c();
        if (view != null && (layoutParams instanceof w)) {
            cVar.f26099b = ((w) layoutParams).xv();
        } else {
            cVar.f26099b = 1;
        }
        if (i4 != -1 && i4 != flexItemCount) {
            if (i4 < this.f26091a.getFlexItemCount()) {
                cVar.f26098a = i4;
                while (i4 < flexItemCount) {
                    J.get(i4).f26098a++;
                    i4++;
                }
            } else {
                cVar.f26098a = flexItemCount;
            }
        } else {
            cVar.f26098a = flexItemCount;
        }
        J.add(cVar);
        return w(flexItemCount + 1, J, sparseIntArray);
    }
}
