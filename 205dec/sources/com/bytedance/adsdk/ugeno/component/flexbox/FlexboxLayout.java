package com.bytedance.adsdk.ugeno.component.flexbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.component.flexbox.b;
import java.util.ArrayList;
import java.util.List;
import l0.e;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class FlexboxLayout extends ViewGroup implements a {

    /* renamed from: a  reason: collision with root package name */
    private int f26062a;

    /* renamed from: b  reason: collision with root package name */
    private int f26063b;

    /* renamed from: c  reason: collision with root package name */
    private int f26064c;

    /* renamed from: d  reason: collision with root package name */
    private int f26065d;

    /* renamed from: e  reason: collision with root package name */
    private int f26066e;

    /* renamed from: f  reason: collision with root package name */
    private int f26067f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f26068g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f26069h;

    /* renamed from: i  reason: collision with root package name */
    private int f26070i;

    /* renamed from: j  reason: collision with root package name */
    private int f26071j;

    /* renamed from: k  reason: collision with root package name */
    private int f26072k;

    /* renamed from: l  reason: collision with root package name */
    private int f26073l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f26074m;

    /* renamed from: n  reason: collision with root package name */
    private SparseIntArray f26075n;

    /* renamed from: o  reason: collision with root package name */
    private b f26076o;

    /* renamed from: p  reason: collision with root package name */
    private List<d> f26077p;

    /* renamed from: q  reason: collision with root package name */
    private j0.d f26078q;

    /* renamed from: r  reason: collision with root package name */
    private b.C0360b f26079r;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends ViewGroup.MarginLayoutParams implements w {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private int f26080a;

        /* renamed from: b  reason: collision with root package name */
        private float f26081b;

        /* renamed from: c  reason: collision with root package name */
        private float f26082c;

        /* renamed from: d  reason: collision with root package name */
        private int f26083d;

        /* renamed from: e  reason: collision with root package name */
        private float f26084e;

        /* renamed from: f  reason: collision with root package name */
        private int f26085f;

        /* renamed from: g  reason: collision with root package name */
        private int f26086g;

        /* renamed from: h  reason: collision with root package name */
        private int f26087h;

        /* renamed from: i  reason: collision with root package name */
        private int f26088i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f26089j;

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        static class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public c[] newArray(int i4) {
                return new c[i4];
            }
        }

        public c(c cVar) {
            super((ViewGroup.MarginLayoutParams) cVar);
            this.f26080a = 1;
            this.f26081b = 0.0f;
            this.f26082c = 0.0f;
            this.f26083d = -1;
            this.f26084e = -1.0f;
            this.f26085f = -1;
            this.f26086g = -1;
            this.f26087h = 16777215;
            this.f26088i = 16777215;
            this.f26080a = cVar.f26080a;
            this.f26081b = cVar.f26081b;
            this.f26082c = cVar.f26082c;
            this.f26083d = cVar.f26083d;
            this.f26084e = cVar.f26084e;
            this.f26085f = cVar.f26085f;
            this.f26086g = cVar.f26086g;
            this.f26087h = cVar.f26087h;
            this.f26088i = cVar.f26088i;
            this.f26089j = cVar.f26089j;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public float a() {
            return this.f26084e;
        }

        public void b(float f4) {
            this.f26081b = f4;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int bk() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int c() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        public void d(int i4) {
            this.f26083d = i4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e(float f4) {
            this.f26082c = f4;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int ev() {
            return this.f26086g;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int f() {
            return this.f26083d;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int fp() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        public void g(float f4) {
            this.f26084e = f4;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int gd() {
            return this.f26087h;
        }

        public void h(int i4) {
            this.f26080a = i4;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public boolean k() {
            return this.f26089j;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int p() {
            return this.f26088i;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int r() {
            return this.f26085f;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public float sr() {
            return this.f26081b;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int t() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public float ux() {
            return this.f26082c;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int w() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f26080a);
            parcel.writeFloat(this.f26081b);
            parcel.writeFloat(this.f26082c);
            parcel.writeInt(this.f26083d);
            parcel.writeFloat(this.f26084e);
            parcel.writeInt(this.f26085f);
            parcel.writeInt(this.f26086g);
            parcel.writeInt(this.f26087h);
            parcel.writeInt(this.f26088i);
            parcel.writeByte(this.f26089j ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int xv() {
            return this.f26080a;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public int ys() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public void c(int i4) {
            this.f26085f = i4;
        }

        @Override // com.bytedance.adsdk.ugeno.component.flexbox.w
        public void w(int i4) {
            this.f26086g = i4;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f26080a = 1;
            this.f26081b = 0.0f;
            this.f26082c = 0.0f;
            this.f26083d = -1;
            this.f26084e = -1.0f;
            this.f26085f = -1;
            this.f26086g = -1;
            this.f26087h = 16777215;
            this.f26088i = 16777215;
        }

        public c(int i4, int i5) {
            super(new ViewGroup.LayoutParams(i4, i5));
            this.f26080a = 1;
            this.f26081b = 0.0f;
            this.f26082c = 0.0f;
            this.f26083d = -1;
            this.f26084e = -1.0f;
            this.f26085f = -1;
            this.f26086g = -1;
            this.f26087h = 16777215;
            this.f26088i = 16777215;
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f26080a = 1;
            this.f26081b = 0.0f;
            this.f26082c = 0.0f;
            this.f26083d = -1;
            this.f26084e = -1.0f;
            this.f26085f = -1;
            this.f26086g = -1;
            this.f26087h = 16777215;
            this.f26088i = 16777215;
        }

        protected c(Parcel parcel) {
            super(0, 0);
            this.f26080a = 1;
            this.f26081b = 0.0f;
            this.f26082c = 0.0f;
            this.f26083d = -1;
            this.f26084e = -1.0f;
            this.f26085f = -1;
            this.f26086g = -1;
            this.f26087h = 16777215;
            this.f26088i = 16777215;
            this.f26080a = parcel.readInt();
            this.f26081b = parcel.readFloat();
            this.f26082c = parcel.readFloat();
            this.f26083d = parcel.readInt();
            this.f26084e = parcel.readFloat();
            this.f26085f = parcel.readInt();
            this.f26086g = parcel.readInt();
            this.f26087h = parcel.readInt();
            this.f26088i = parcel.readInt();
            this.f26089j = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.f26067f = -1;
        this.f26076o = new b(this);
        this.f26077p = new ArrayList();
        this.f26079r = new b.C0360b();
    }

    private void g(int i4, int i5) {
        if (this.f26075n == null) {
            this.f26075n = new SparseIntArray(getChildCount());
        }
        if (this.f26076o.O(this.f26075n)) {
            this.f26074m = this.f26076o.x(this.f26075n);
        }
        int i6 = this.f26062a;
        if (i6 == 0 || i6 == 1) {
            t(i4, i5);
        } else if (i6 != 2 && i6 != 3) {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f26062a);
        } else {
            y(i4, i5);
        }
    }

    private void h(int i4, int i5, int i6, int i7) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (i4 == 0 || i4 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i4 != 2 && i4 != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + i4);
        } else {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i7 = View.combineMeasuredStates(i7, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i5, i7);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i5, i7);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i7 = View.combineMeasuredStates(i7, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i5, i7);
        } else {
            throw new IllegalStateException("Unknown width mode is set: " + mode);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i7 = View.combineMeasuredStates(i7, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i6, i7);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i6, i7);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i7 = View.combineMeasuredStates(i7, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i6, i7);
        } else {
            throw new IllegalStateException("Unknown height mode is set: " + mode2);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    private void i(Canvas canvas, int i4, int i5, int i6) {
        Drawable drawable = this.f26069h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i4, i5, this.f26073l + i4, i6 + i5);
        this.f26069h.draw(canvas);
    }

    private void j(Canvas canvas, boolean z3, boolean z4) {
        int i4;
        int i5;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f26077p.size();
        for (int i6 = 0; i6 < size; i6++) {
            d dVar = this.f26077p.get(i6);
            for (int i7 = 0; i7 < dVar.f26121h; i7++) {
                int i8 = dVar.f26128o + i7;
                View x3 = x(i8);
                if (x3 != null && x3.getVisibility() != 8) {
                    c cVar = (c) x3.getLayoutParams();
                    if (p(i8, i7)) {
                        if (z3) {
                            left = x3.getRight() + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        } else {
                            left = (x3.getLeft() - ((ViewGroup.MarginLayoutParams) cVar).leftMargin) - this.f26073l;
                        }
                        i(canvas, left, dVar.f26115b, dVar.f26120g);
                    }
                    if (i7 == dVar.f26121h - 1 && (this.f26071j & 4) > 0) {
                        if (z3) {
                            right = (x3.getLeft() - ((ViewGroup.MarginLayoutParams) cVar).leftMargin) - this.f26073l;
                        } else {
                            right = x3.getRight() + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        }
                        i(canvas, right, dVar.f26115b, dVar.f26120g);
                    }
                }
            }
            if (o(i6)) {
                if (z4) {
                    i5 = dVar.f26117d;
                } else {
                    i5 = dVar.f26115b - this.f26072k;
                }
                u(canvas, paddingLeft, i5, max);
            }
            if (n(i6) && (this.f26070i & 4) > 0) {
                if (z4) {
                    i4 = dVar.f26115b - this.f26072k;
                } else {
                    i4 = dVar.f26117d;
                }
                u(canvas, paddingLeft, i4, max);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.component.flexbox.FlexboxLayout.l(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.component.flexbox.FlexboxLayout.m(boolean, boolean, int, int, int, int):void");
    }

    private boolean n(int i4) {
        if (i4 < 0 || i4 >= this.f26077p.size()) {
            return false;
        }
        for (int i5 = i4 + 1; i5 < this.f26077p.size(); i5++) {
            if (this.f26077p.get(i5).c() > 0) {
                return false;
            }
        }
        return c() ? (this.f26070i & 4) != 0 : (this.f26071j & 4) != 0;
    }

    private boolean o(int i4) {
        if (i4 < 0 || i4 >= this.f26077p.size()) {
            return false;
        }
        return q(i4) ? c() ? (this.f26070i & 1) != 0 : (this.f26071j & 1) != 0 : c() ? (this.f26070i & 2) != 0 : (this.f26071j & 2) != 0;
    }

    private boolean p(int i4, int i5) {
        return r(i4, i5) ? c() ? (this.f26071j & 1) != 0 : (this.f26070i & 1) != 0 : c() ? (this.f26071j & 2) != 0 : (this.f26070i & 2) != 0;
    }

    private boolean q(int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.f26077p.get(i5).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean r(int i4, int i5) {
        for (int i6 = 1; i6 <= i5; i6++) {
            View x3 = x(i4 - i6);
            if (x3 != null && x3.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.f26068g == null && this.f26069h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private void t(int i4, int i5) {
        this.f26077p.clear();
        this.f26079r.a();
        this.f26076o.r(this.f26079r, i4, i5);
        this.f26077p = this.f26079r.f26096a;
        this.f26076o.i(i4, i5);
        if (this.f26065d == 3) {
            for (d dVar : this.f26077p) {
                int i6 = Integer.MIN_VALUE;
                for (int i7 = 0; i7 < dVar.f26121h; i7++) {
                    View x3 = x(dVar.f26128o + i7);
                    if (x3 != null && x3.getVisibility() != 8) {
                        c cVar = (c) x3.getLayoutParams();
                        if (this.f26063b != 2) {
                            i6 = Math.max(i6, x3.getMeasuredHeight() + Math.max(dVar.f26125l - x3.getBaseline(), ((ViewGroup.MarginLayoutParams) cVar).topMargin) + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin);
                        } else {
                            i6 = Math.max(i6, x3.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) cVar).topMargin + Math.max((dVar.f26125l - x3.getMeasuredHeight()) + x3.getBaseline(), ((ViewGroup.MarginLayoutParams) cVar).bottomMargin));
                        }
                    }
                }
                dVar.f26120g = i6;
            }
        }
        this.f26076o.K(i4, i5, getPaddingTop() + getPaddingBottom());
        this.f26076o.g();
        h(this.f26062a, i4, i5, this.f26079r.f26097b);
    }

    private void u(Canvas canvas, int i4, int i5, int i6) {
        Drawable drawable = this.f26068g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i4, i5, i6 + i4, this.f26072k + i5);
        this.f26068g.draw(canvas);
    }

    private void v(Canvas canvas, boolean z3, boolean z4) {
        int i4;
        int i5;
        int bottom;
        int top2;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f26077p.size();
        for (int i6 = 0; i6 < size; i6++) {
            d dVar = this.f26077p.get(i6);
            for (int i7 = 0; i7 < dVar.f26121h; i7++) {
                int i8 = dVar.f26128o + i7;
                View x3 = x(i8);
                if (x3 != null && x3.getVisibility() != 8) {
                    c cVar = (c) x3.getLayoutParams();
                    if (p(i8, i7)) {
                        if (z4) {
                            top2 = x3.getBottom() + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
                        } else {
                            top2 = (x3.getTop() - ((ViewGroup.MarginLayoutParams) cVar).topMargin) - this.f26072k;
                        }
                        u(canvas, dVar.f26114a, top2, dVar.f26120g);
                    }
                    if (i7 == dVar.f26121h - 1 && (this.f26070i & 4) > 0) {
                        if (z4) {
                            bottom = (x3.getTop() - ((ViewGroup.MarginLayoutParams) cVar).topMargin) - this.f26072k;
                        } else {
                            bottom = x3.getBottom() + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
                        }
                        u(canvas, dVar.f26114a, bottom, dVar.f26120g);
                    }
                }
            }
            if (o(i6)) {
                if (z3) {
                    i5 = dVar.f26116c;
                } else {
                    i5 = dVar.f26114a - this.f26073l;
                }
                i(canvas, i5, paddingTop, max);
            }
            if (n(i6) && (this.f26071j & 4) > 0) {
                if (z3) {
                    i4 = dVar.f26114a - this.f26073l;
                } else {
                    i4 = dVar.f26116c;
                }
                i(canvas, i4, paddingTop, max);
            }
        }
    }

    private void y(int i4, int i5) {
        this.f26077p.clear();
        this.f26079r.a();
        this.f26076o.N(this.f26079r, i4, i5);
        this.f26077p = this.f26079r.f26096a;
        this.f26076o.i(i4, i5);
        this.f26076o.K(i4, i5, getPaddingLeft() + getPaddingRight());
        this.f26076o.g();
        h(this.f26062a, i4, i5, this.f26079r.f26097b);
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int a(View view, int i4, int i5) {
        int i6;
        int i7;
        if (c()) {
            i6 = p(i4, i5) ? 0 + this.f26073l : 0;
            if ((this.f26071j & 4) <= 0) {
                return i6;
            }
            i7 = this.f26073l;
        } else {
            i6 = p(i4, i5) ? 0 + this.f26072k : 0;
            if ((this.f26070i & 4) <= 0) {
                return i6;
            }
            i7 = this.f26072k;
        }
        return i6 + i7;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (this.f26075n == null) {
            this.f26075n = new SparseIntArray(getChildCount());
        }
        this.f26074m = this.f26076o.y(view, i4, layoutParams, this.f26075n);
        super.addView(view, i4, layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int b(int i4, int i5, int i6) {
        return ViewGroup.getChildMeasureSpec(i4, i5, i6);
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int c(View view) {
        return 0;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public View c(int i4) {
        return getChildAt(i4);
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public void c(int i4, View view) {
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public void d(View view, int i4, int i5, d dVar) {
        if (p(i4, i5)) {
            if (c()) {
                int i6 = dVar.f26118e;
                int i7 = this.f26073l;
                dVar.f26118e = i6 + i7;
                dVar.f26119f += i7;
                return;
            }
            int i8 = dVar.f26118e;
            int i9 = this.f26072k;
            dVar.f26118e = i8 + i9;
            dVar.f26119f += i9;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int e(int i4, int i5, int i6) {
        return ViewGroup.getChildMeasureSpec(i4, i5, i6);
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public void f(d dVar) {
        if (c()) {
            if ((this.f26071j & 4) > 0) {
                int i4 = dVar.f26118e;
                int i5 = this.f26073l;
                dVar.f26118e = i4 + i5;
                dVar.f26119f += i5;
            }
        } else if ((this.f26070i & 4) > 0) {
            int i6 = dVar.f26118e;
            int i7 = this.f26072k;
            dVar.f26118e = i6 + i7;
            dVar.f26119f += i7;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof c) {
            return new c((c) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int getAlignContent() {
        return this.f26066e;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int getAlignItems() {
        return this.f26065d;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f26068g;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f26069h;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int getFlexDirection() {
        return this.f26062a;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<d> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f26077p.size());
        for (d dVar : this.f26077p) {
            if (dVar.c() != 0) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public List<d> getFlexLinesInternal() {
        return this.f26077p;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int getFlexWrap() {
        return this.f26063b;
    }

    public int getJustifyContent() {
        return this.f26064c;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int getLargestMainSize() {
        int i4 = Integer.MIN_VALUE;
        for (d dVar : this.f26077p) {
            i4 = Math.max(i4, dVar.f26118e);
        }
        return i4;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int getMaxLine() {
        return this.f26067f;
    }

    public int getShowDividerHorizontal() {
        return this.f26070i;
    }

    public int getShowDividerVertical() {
        return this.f26071j;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public int getSumOfCrossSize() {
        int i4;
        int i5;
        int size = this.f26077p.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = this.f26077p.get(i7);
            if (o(i7)) {
                if (c()) {
                    i5 = this.f26072k;
                } else {
                    i5 = this.f26073l;
                }
                i6 += i5;
            }
            if (n(i7)) {
                if (c()) {
                    i4 = this.f26072k;
                } else {
                    i4 = this.f26073l;
                }
                i6 += i4;
            }
            i6 += dVar.f26120g;
        }
        return i6;
    }

    public void k(com.bytedance.adsdk.ugeno.component.b bVar) {
        this.f26078q = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j0.d dVar = this.f26078q;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j0.d dVar = this.f26078q;
        if (dVar != null) {
            dVar.r();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f26069h == null && this.f26068g == null) {
            return;
        }
        if (this.f26070i == 0 && this.f26071j == 0) {
            return;
        }
        int a4 = e.a(this);
        int i4 = this.f26062a;
        if (i4 == 0) {
            j(canvas, a4 == 1, this.f26063b == 2);
        } else if (i4 == 1) {
            j(canvas, a4 != 1, this.f26063b == 2);
        } else if (i4 == 2) {
            boolean z3 = a4 == 1;
            if (this.f26063b == 2) {
                z3 = !z3;
            }
            v(canvas, z3, false);
        } else if (i4 == 3) {
            boolean z4 = a4 == 1;
            if (this.f26063b == 2) {
                z4 = !z4;
            }
            v(canvas, z4, true);
        }
        j0.d dVar = this.f26078q;
        if (dVar != null) {
            dVar.c(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        boolean z4;
        j0.d dVar = this.f26078q;
        if (dVar != null) {
            dVar.ux();
        }
        int a4 = e.a(this);
        int i8 = this.f26062a;
        if (i8 == 0) {
            l(a4 == 1, i4, i5, i6, i7);
        } else if (i8 == 1) {
            l(a4 != 1, i4, i5, i6, i7);
        } else if (i8 == 2) {
            z4 = a4 == 1;
            m(this.f26063b == 2 ? !z4 : z4, false, i4, i5, i6, i7);
        } else if (i8 == 3) {
            z4 = a4 == 1;
            m(this.f26063b == 2 ? !z4 : z4, true, i4, i5, i6, i7);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f26062a);
        }
        j0.d dVar2 = this.f26078q;
        if (dVar2 != null) {
            dVar2.c(i4, i5, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        j0.d dVar = this.f26078q;
        if (dVar != null) {
            int[] c4 = dVar.c(i4, i5);
            g(c4[0], c4[1]);
        } else {
            g(i4, i5);
        }
        j0.d dVar2 = this.f26078q;
        if (dVar2 != null) {
            dVar2.sr();
        }
    }

    public void setAlignContent(int i4) {
        if (this.f26066e != i4) {
            this.f26066e = i4;
            requestLayout();
        }
    }

    public void setAlignItems(int i4) {
        if (this.f26065d != i4) {
            this.f26065d = i4;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.f26068g) {
            return;
        }
        this.f26068g = drawable;
        if (drawable != null) {
            this.f26072k = drawable.getIntrinsicHeight();
        } else {
            this.f26072k = 0;
        }
        s();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.f26069h) {
            return;
        }
        this.f26069h = drawable;
        if (drawable != null) {
            this.f26073l = drawable.getIntrinsicWidth();
        } else {
            this.f26073l = 0;
        }
        s();
        requestLayout();
    }

    public void setFlexDirection(int i4) {
        if (this.f26062a != i4) {
            this.f26062a = i4;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public void setFlexLines(List<d> list) {
        this.f26077p = list;
    }

    public void setFlexWrap(int i4) {
        if (this.f26063b != i4) {
            this.f26063b = i4;
            requestLayout();
        }
    }

    public void setJustifyContent(int i4) {
        if (this.f26064c != i4) {
            this.f26064c = i4;
            requestLayout();
        }
    }

    public void setMaxLine(int i4) {
        if (this.f26067f != i4) {
            this.f26067f = i4;
            requestLayout();
        }
    }

    public void setShowDivider(int i4) {
        setShowDividerVertical(i4);
        setShowDividerHorizontal(i4);
    }

    public void setShowDividerHorizontal(int i4) {
        if (i4 != this.f26070i) {
            this.f26070i = i4;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i4) {
        if (i4 != this.f26071j) {
            this.f26071j = i4;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public View w(int i4) {
        return x(i4);
    }

    public View x(int i4) {
        if (i4 >= 0) {
            int[] iArr = this.f26074m;
            if (i4 >= iArr.length) {
                return null;
            }
            return getChildAt(iArr[i4]);
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.component.flexbox.a
    public boolean c() {
        int i4 = this.f26062a;
        return i4 == 0 || i4 == 1;
    }
}
