package com.bytedance.adsdk.ugeno.viewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ViewPager extends ViewGroup {
    static final int[] I0 = {16842931};
    private static final Comparator<j> J0 = new a();
    private static final Interpolator K0 = new b();
    private static final f L0 = new f();
    private int A;
    private int B;
    private List<h> B0;
    private int C;
    private e C0;
    private float D;
    private int D0;
    private float E;
    private int E0;
    private float F;
    private ArrayList<View> F0;
    private float G;
    private final Runnable G0;
    private int H;
    private int H0;
    private VelocityTracker I;
    private int J;
    private int K;

    /* renamed from: L  reason: collision with root package name */
    private int f26281L;
    private int M;
    private boolean N;
    private long O;
    private EdgeEffect P;
    private EdgeEffect Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private List<i> V;
    private i W;

    /* renamed from: a  reason: collision with root package name */
    private int f26282a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<j> f26283b;

    /* renamed from: c  reason: collision with root package name */
    private final j f26284c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f26285d;

    /* renamed from: e  reason: collision with root package name */
    com.bytedance.adsdk.ugeno.viewpager.a f26286e;

    /* renamed from: f  reason: collision with root package name */
    int f26287f;

    /* renamed from: g  reason: collision with root package name */
    private int f26288g;

    /* renamed from: h  reason: collision with root package name */
    private Parcelable f26289h;

    /* renamed from: i  reason: collision with root package name */
    private ClassLoader f26290i;

    /* renamed from: j  reason: collision with root package name */
    private Scroller f26291j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f26292k;

    /* renamed from: l  reason: collision with root package name */
    private g f26293l;

    /* renamed from: m  reason: collision with root package name */
    private int f26294m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f26295n;

    /* renamed from: o  reason: collision with root package name */
    private int f26296o;

    /* renamed from: p  reason: collision with root package name */
    private int f26297p;

    /* renamed from: p0  reason: collision with root package name */
    private i f26298p0;

    /* renamed from: q  reason: collision with root package name */
    private float f26299q;

    /* renamed from: r  reason: collision with root package name */
    private float f26300r;

    /* renamed from: s  reason: collision with root package name */
    private int f26301s;

    /* renamed from: t  reason: collision with root package name */
    private int f26302t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f26303u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f26304v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f26305w;

    /* renamed from: x  reason: collision with root package name */
    private int f26306x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f26307y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f26308z;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class a implements Comparator<j> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(j jVar, j jVar2) {
            return jVar.f26315b - jVar2.f26315b;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * f5 * f5 * f5) + 1.0f;
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface c {
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.Q();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface e {
        void a(View view, float f4);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class ev extends com.bytedance.adsdk.ugeno.viewpager.c {
        public static final Parcelable.Creator<ev> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f26310c;

        /* renamed from: d  reason: collision with root package name */
        Parcelable f26311d;

        /* renamed from: e  reason: collision with root package name */
        ClassLoader f26312e;

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        static class a implements Parcelable.ClassLoaderCreator<ev> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ev createFromParcel(Parcel parcel) {
                return new ev(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public ev createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new ev(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public ev[] newArray(int i4) {
                return new ev[i4];
            }
        }

        public ev(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f26310c + "}";
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f26310c);
            parcel.writeParcelable(this.f26311d, i4);
        }

        ev(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f26310c = parcel.readInt();
            this.f26311d = parcel.readParcelable(classLoader);
            this.f26312e = classLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class f implements Comparator<View> {
        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            k kVar = (k) view.getLayoutParams();
            k kVar2 = (k) view2.getLayoutParams();
            boolean z3 = kVar.f26319a;
            if (z3 != kVar2.f26319a) {
                return z3 ? 1 : -1;
            }
            return kVar.f26323e - kVar2.f26323e;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class g extends DataSetObserver {
        g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.M();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.M();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface h {
        void a(ViewPager viewPager, com.bytedance.adsdk.ugeno.viewpager.a aVar, com.bytedance.adsdk.ugeno.viewpager.a aVar2);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface i {
        void c(int i4, float f4, int i5);

        void ev(int i4);

        void gd(int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        Object f26314a;

        /* renamed from: b  reason: collision with root package name */
        int f26315b;

        /* renamed from: c  reason: collision with root package name */
        boolean f26316c;

        /* renamed from: d  reason: collision with root package name */
        float f26317d;

        /* renamed from: e  reason: collision with root package name */
        float f26318e;

        j() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f26283b = new ArrayList<>();
        this.f26284c = new j();
        this.f26285d = new Rect();
        this.f26288g = -1;
        this.f26289h = null;
        this.f26290i = null;
        this.f26299q = -3.4028235E38f;
        this.f26300r = Float.MAX_VALUE;
        this.f26306x = 1;
        this.H = -1;
        this.R = true;
        this.S = false;
        this.G0 = new d();
        this.H0 = 0;
        h();
    }

    private void A(int i4) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.gd(i4);
        }
        List<i> list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                i iVar2 = this.V.get(i5);
                if (iVar2 != null) {
                    iVar2.gd(i4);
                }
            }
        }
        i iVar3 = this.f26298p0;
        if (iVar3 != null) {
            iVar3.gd(i4);
        }
    }

    private void C() {
        int i4 = 0;
        while (i4 < getChildCount()) {
            if (!((k) getChildAt(i4).getLayoutParams()).f26319a) {
                removeViewAt(i4);
                i4--;
            }
            i4++;
        }
    }

    private boolean D() {
        this.H = -1;
        b();
        this.P.onRelease();
        this.Q.onRelease();
        return this.P.isFinished() || this.Q.isFinished();
    }

    private void E() {
        if (this.E0 != 0) {
            ArrayList<View> arrayList = this.F0;
            if (arrayList == null) {
                this.F0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                this.F0.add(getChildAt(i4));
            }
            Collections.sort(this.F0, L0);
        }
    }

    private boolean H(int i4) {
        if (this.f26283b.size() == 0) {
            if (this.R) {
                return false;
            }
            this.T = false;
            j(0, 0.0f, 0);
            if (this.T) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        j a4 = a();
        int clientWidth = getClientWidth();
        int i5 = this.f26294m;
        int i6 = clientWidth + i5;
        float f4 = clientWidth;
        int i7 = a4.f26315b;
        float f5 = ((i4 / f4) - a4.f26318e) / (a4.f26317d + (i5 / f4));
        this.T = false;
        j(i7, f5, (int) (i6 * f5));
        if (this.T) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void J(int i4) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.ev(i4);
        }
        List<i> list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                i iVar2 = this.V.get(i5);
                if (iVar2 != null) {
                    iVar2.ev(i4);
                }
            }
        }
        i iVar3 = this.f26298p0;
        if (iVar3 != null) {
            iVar3.ev(i4);
        }
    }

    private void O(int i4, float f4, int i5) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.c(i4, f4, i5);
        }
        List<i> list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                i iVar2 = this.V.get(i6);
                if (iVar2 != null) {
                    iVar2.c(i4, f4, i5);
                }
            }
        }
        i iVar3 = this.f26298p0;
        if (iVar3 != null) {
            iVar3.c(i4, f4, i5);
        }
    }

    private void P(boolean z3) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).setLayerType(z3 ? this.D0 : 0, null);
        }
    }

    private void R(boolean z3) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z3);
        }
    }

    private boolean S(float f4) {
        boolean z3;
        boolean z4;
        float f5 = this.D - f4;
        this.D = f4;
        float scrollX = getScrollX() + f5;
        float clientWidth = getClientWidth();
        float f6 = this.f26299q * clientWidth;
        float f7 = this.f26300r * clientWidth;
        boolean z5 = false;
        j jVar = this.f26283b.get(0);
        ArrayList<j> arrayList = this.f26283b;
        j jVar2 = arrayList.get(arrayList.size() - 1);
        if (jVar.f26315b != 0) {
            f6 = jVar.f26318e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (jVar2.f26315b != this.f26286e.b() - 1) {
            f7 = jVar2.f26318e * clientWidth;
            z4 = false;
        } else {
            z4 = true;
        }
        if (scrollX < f6) {
            if (z3) {
                this.P.onPull(Math.abs(f6 - scrollX) / clientWidth);
                z5 = true;
            }
            scrollX = f6;
        } else if (scrollX > f7) {
            if (z4) {
                this.Q.onPull(Math.abs(scrollX - f7) / clientWidth);
                z5 = true;
            }
            scrollX = f7;
        }
        int i4 = (int) scrollX;
        this.D += scrollX - i4;
        scrollTo(i4, getScrollY());
        H(i4);
        return z5;
    }

    private static boolean U(View view) {
        return view.getClass().getAnnotation(c.class) != null;
    }

    private j a() {
        int i4;
        int clientWidth = getClientWidth();
        float f4 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f5 = clientWidth > 0 ? this.f26294m / clientWidth : 0.0f;
        j jVar = null;
        float f6 = 0.0f;
        int i5 = -1;
        int i6 = 0;
        boolean z3 = true;
        while (i6 < this.f26283b.size()) {
            j jVar2 = this.f26283b.get(i6);
            if (!z3 && jVar2.f26315b != (i4 = i5 + 1)) {
                jVar2 = this.f26284c;
                jVar2.f26318e = f4 + f6 + f5;
                jVar2.f26315b = i4;
                jVar2.f26317d = this.f26286e.a(i4);
                i6--;
            }
            f4 = jVar2.f26318e;
            float f7 = jVar2.f26317d + f4 + f5;
            if (!z3 && scrollX < f4) {
                return jVar;
            }
            if (scrollX < f7 || i6 == this.f26283b.size() - 1) {
                return jVar2;
            }
            i5 = jVar2.f26315b;
            f6 = jVar2.f26317d;
            i6++;
            jVar = jVar2;
            z3 = false;
        }
        return jVar;
    }

    private void b() {
        this.f26307y = false;
        this.f26308z = false;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
    }

    private int d(int i4, float f4, int i5, int i6) {
        if (Math.abs(i6) <= this.f26281L || Math.abs(i5) <= this.J) {
            i4 += (int) (f4 + (i4 >= this.f26287f ? 0.4f : 0.6f));
        } else if (i5 <= 0) {
            i4++;
        }
        if (this.f26283b.size() > 0) {
            ArrayList<j> arrayList = this.f26283b;
            return Math.max(this.f26283b.get(0).f26315b, Math.min(i4, arrayList.get(arrayList.size() - 1).f26315b));
        }
        return i4;
    }

    private Rect e(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void l(int i4, int i5, int i6, int i7) {
        if (i5 > 0 && !this.f26283b.isEmpty()) {
            if (!this.f26291j.isFinished()) {
                this.f26291j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i5 - getPaddingLeft()) - getPaddingRight()) + i7)) * (((i4 - getPaddingLeft()) - getPaddingRight()) + i6)), getScrollY());
                return;
            }
        }
        j K = K(this.f26287f);
        int min = (int) ((K != null ? Math.min(K.f26318e, this.f26300r) : 0.0f) * ((i4 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            t(false);
            scrollTo(min, getScrollY());
        }
    }

    private void n(int i4, boolean z3, int i5, boolean z4) {
        j K = K(i4);
        int clientWidth = K != null ? (int) (getClientWidth() * Math.max(this.f26299q, Math.min(K.f26318e, this.f26300r))) : 0;
        if (z3) {
            k(clientWidth, 0, i5);
            if (z4) {
                J(i4);
                return;
            }
            return;
        }
        if (z4) {
            J(i4);
        }
        t(false);
        scrollTo(clientWidth, 0);
        H(clientWidth);
    }

    private void q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.H) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.D = motionEvent.getX(i4);
            this.H = motionEvent.getPointerId(i4);
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void s(j jVar, int i4, j jVar2) {
        int i5;
        int i6;
        j jVar3;
        j jVar4;
        int b4 = this.f26286e.b();
        int clientWidth = getClientWidth();
        float f4 = clientWidth > 0 ? this.f26294m / clientWidth : 0.0f;
        if (jVar2 != null) {
            int i7 = jVar2.f26315b;
            int i8 = jVar.f26315b;
            if (i7 < i8) {
                float f5 = jVar2.f26318e + jVar2.f26317d + f4;
                int i9 = i7 + 1;
                int i10 = 0;
                while (i9 <= jVar.f26315b && i10 < this.f26283b.size()) {
                    j jVar5 = this.f26283b.get(i10);
                    while (true) {
                        jVar4 = jVar5;
                        if (i9 <= jVar4.f26315b || i10 >= this.f26283b.size() - 1) {
                            break;
                        }
                        i10++;
                        jVar5 = this.f26283b.get(i10);
                    }
                    while (i9 < jVar4.f26315b) {
                        f5 += this.f26286e.a(i9) + f4;
                        i9++;
                    }
                    jVar4.f26318e = f5;
                    f5 += jVar4.f26317d + f4;
                    i9++;
                }
            } else if (i7 > i8) {
                int size = this.f26283b.size() - 1;
                float f6 = jVar2.f26318e;
                while (true) {
                    i7--;
                    if (i7 < jVar.f26315b || size < 0) {
                        break;
                    }
                    j jVar6 = this.f26283b.get(size);
                    while (true) {
                        jVar3 = jVar6;
                        if (i7 >= jVar3.f26315b || size <= 0) {
                            break;
                        }
                        size--;
                        jVar6 = this.f26283b.get(size);
                    }
                    while (i7 > jVar3.f26315b) {
                        f6 -= this.f26286e.a(i7) + f4;
                        i7--;
                    }
                    f6 -= jVar3.f26317d + f4;
                    jVar3.f26318e = f6;
                }
            }
        }
        int size2 = this.f26283b.size();
        float f7 = jVar.f26318e;
        int i11 = jVar.f26315b;
        int i12 = i11 - 1;
        this.f26299q = i11 == 0 ? f7 : -3.4028235E38f;
        int i13 = b4 - 1;
        this.f26300r = i11 == i13 ? (jVar.f26317d + f7) - 1.0f : Float.MAX_VALUE;
        int i14 = i4 - 1;
        while (i14 >= 0) {
            j jVar7 = this.f26283b.get(i14);
            while (true) {
                i6 = jVar7.f26315b;
                if (i12 <= i6) {
                    break;
                }
                f7 -= this.f26286e.a(i12) + f4;
                i12--;
            }
            f7 -= jVar7.f26317d + f4;
            jVar7.f26318e = f7;
            if (i6 == 0) {
                this.f26299q = f7;
            }
            i14--;
            i12--;
        }
        float f8 = jVar.f26318e + jVar.f26317d + f4;
        int i15 = jVar.f26315b + 1;
        int i16 = i4 + 1;
        while (i16 < size2) {
            j jVar8 = this.f26283b.get(i16);
            while (true) {
                i5 = jVar8.f26315b;
                if (i15 >= i5) {
                    break;
                }
                f8 += this.f26286e.a(i15) + f4;
                i15++;
            }
            if (i5 == i13) {
                this.f26300r = (jVar8.f26317d + f8) - 1.0f;
            }
            jVar8.f26318e = f8;
            f8 += jVar8.f26317d + f4;
            i16++;
            i15++;
        }
        this.S = false;
    }

    private void setScrollingCacheEnabled(boolean z3) {
        if (this.f26304v != z3) {
            this.f26304v = z3;
        }
    }

    private void t(boolean z3) {
        boolean z4 = this.H0 == 2;
        if (z4) {
            setScrollingCacheEnabled(false);
            if (!this.f26291j.isFinished()) {
                this.f26291j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f26291j.getCurrX();
                int currY = this.f26291j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        H(currX);
                    }
                }
            }
        }
        this.f26305w = false;
        for (int i4 = 0; i4 < this.f26283b.size(); i4++) {
            j jVar = this.f26283b.get(i4);
            if (jVar.f26316c) {
                jVar.f26316c = false;
                z4 = true;
            }
        }
        if (z4) {
            if (z3) {
                postOnAnimation(this.G0);
            } else {
                this.G0.run();
            }
        }
    }

    private boolean w(float f4, float f5) {
        return (f4 < ((float) this.B) && f5 > 0.0f) || (f4 > ((float) (getWidth() - this.B)) && f5 < 0.0f);
    }

    public boolean B() {
        return this.N;
    }

    boolean F() {
        int i4 = this.f26287f;
        if (i4 > 0) {
            m(i4 - 1, true);
            return true;
        }
        return false;
    }

    public boolean G() {
        if (this.f26307y) {
            return false;
        }
        this.N = true;
        setScrollState(1);
        this.D = 0.0f;
        this.F = 0.0f;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker == null) {
            this.I = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.I.addMovement(obtain);
        obtain.recycle();
        this.O = uptimeMillis;
        return true;
    }

    public void I() {
        if (this.N) {
            if (this.f26286e != null) {
                VelocityTracker velocityTracker = this.I;
                velocityTracker.computeCurrentVelocity(1000, this.K);
                int xVelocity = (int) velocityTracker.getXVelocity(this.H);
                this.f26305w = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                j a4 = a();
                p(d(a4.f26315b, ((scrollX / clientWidth) - a4.f26318e) / a4.f26317d, xVelocity, (int) (this.D - this.F)), true, true, xVelocity);
            }
            b();
            this.N = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    j K(int i4) {
        for (int i5 = 0; i5 < this.f26283b.size(); i5++) {
            j jVar = this.f26283b.get(i5);
            if (jVar.f26315b == i4) {
                return jVar;
            }
        }
        return null;
    }

    j L(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return g(view);
            }
        }
    }

    void M() {
        int b4 = this.f26286e.b();
        this.f26282a = b4;
        boolean z3 = this.f26283b.size() < (this.f26306x * 2) + 1 && this.f26283b.size() < b4;
        int i4 = this.f26287f;
        int i5 = 0;
        boolean z4 = false;
        while (i5 < this.f26283b.size()) {
            j jVar = this.f26283b.get(i5);
            int c4 = this.f26286e.c(jVar.f26314a);
            if (c4 != -1) {
                if (c4 == -2) {
                    this.f26283b.remove(i5);
                    i5--;
                    if (!z4) {
                        this.f26286e.j(this);
                        z4 = true;
                    }
                    this.f26286e.k(this, jVar.f26315b, jVar.f26314a);
                    int i6 = this.f26287f;
                    if (i6 == jVar.f26315b) {
                        i4 = Math.max(0, Math.min(i6, b4 - 1));
                    }
                } else {
                    int i7 = jVar.f26315b;
                    if (i7 != c4) {
                        if (i7 == this.f26287f) {
                            i4 = c4;
                        }
                        jVar.f26315b = c4;
                    }
                }
                z3 = true;
            }
            i5++;
        }
        if (z4) {
            this.f26286e.p(this);
        }
        Collections.sort(this.f26283b, J0);
        if (z3) {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                k kVar = (k) getChildAt(i8).getLayoutParams();
                if (!kVar.f26319a) {
                    kVar.f26321c = 0.0f;
                }
            }
            o(i4, false, true);
            requestLayout();
        }
    }

    public void N(float f4) {
        ArrayList<j> arrayList;
        if (this.N) {
            if (this.f26286e == null) {
                return;
            }
            this.D += f4;
            float scrollX = getScrollX() - f4;
            float clientWidth = getClientWidth();
            float f5 = this.f26299q * clientWidth;
            float f6 = this.f26300r * clientWidth;
            j jVar = this.f26283b.get(0);
            j jVar2 = this.f26283b.get(arrayList.size() - 1);
            if (jVar.f26315b != 0) {
                f5 = jVar.f26318e * clientWidth;
            }
            if (jVar2.f26315b != this.f26286e.b() - 1) {
                f6 = jVar2.f26318e * clientWidth;
            }
            if (scrollX < f5) {
                scrollX = f5;
            } else if (scrollX > f6) {
                scrollX = f6;
            }
            int i4 = (int) scrollX;
            this.D += scrollX - i4;
            scrollTo(i4, getScrollY());
            H(i4);
            MotionEvent obtain = MotionEvent.obtain(this.O, SystemClock.uptimeMillis(), 2, this.D, 0.0f, 0);
            this.I.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    void Q() {
        i(this.f26287f);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean T(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto Lb
        L9:
            r0 = r3
            goto L69
        Lb:
            if (r0 == 0) goto L69
            android.view.ViewParent r4 = r0.getParent()
        L11:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1e
            if (r4 != r6) goto L19
            r4 = 1
            goto L1f
        L19:
            android.view.ViewParent r4 = r4.getParent()
            goto L11
        L1e:
            r4 = 0
        L1f:
            if (r4 != 0) goto L69
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L35:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L35
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
            goto L9
        L69:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto Lba
            if (r3 == r0) goto Lba
            if (r7 != r5) goto L9a
            android.graphics.Rect r1 = r6.f26285d
            android.graphics.Rect r1 = r6.e(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f26285d
            android.graphics.Rect r2 = r6.e(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L94
            if (r1 < r2) goto L94
            boolean r0 = r6.F()
            goto L98
        L94:
            boolean r0 = r3.requestFocus()
        L98:
            r2 = r0
            goto Lcd
        L9a:
            if (r7 != r4) goto Lcd
            android.graphics.Rect r1 = r6.f26285d
            android.graphics.Rect r1 = r6.e(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f26285d
            android.graphics.Rect r2 = r6.e(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto Lb5
            if (r1 > r2) goto Lb5
            boolean r0 = r6.z()
            goto L98
        Lb5:
            boolean r0 = r3.requestFocus()
            goto L98
        Lba:
            if (r7 == r5) goto Lc9
            if (r7 != r1) goto Lbf
            goto Lc9
        Lbf:
            if (r7 == r4) goto Lc4
            r0 = 2
            if (r7 != r0) goto Lcd
        Lc4:
            boolean r2 = r6.z()
            goto Lcd
        Lc9:
            boolean r2 = r6.F()
        Lcd:
            if (r2 == 0) goto Ld6
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Ld6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.T(int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i4, int i5) {
        j g4;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() == 0 && (g4 = g(childAt)) != null && g4.f26315b == this.f26287f) {
                    childAt.addFocusables(arrayList, i4, i5);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i5 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        j g4;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (g4 = g(childAt)) != null && g4.f26315b == this.f26287f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        k kVar = (k) layoutParams;
        boolean U = kVar.f26319a | U(view);
        kVar.f26319a = U;
        if (!this.f26303u) {
            super.addView(view, i4, layoutParams);
        } else if (!U) {
            kVar.f26322d = true;
            addViewInLayout(view, i4, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    float c(float f4) {
        return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i4) {
        if (this.f26286e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i4 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f26299q)) : i4 > 0 && scrollX < ((int) (((float) clientWidth) * this.f26300r));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof k) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f26292k = true;
        if (!this.f26291j.isFinished() && this.f26291j.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f26291j.getCurrX();
            int currY = this.f26291j.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!H(currX)) {
                    this.f26291j.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        t(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || x(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        j g4;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (g4 = g(childAt)) != null && g4.f26315b == this.f26287f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.viewpager.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z3 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (aVar = this.f26286e) == null || aVar.b() <= 1)) {
            this.P.finish();
            this.Q.finish();
        } else {
            if (!this.P.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f26299q * width);
                this.P.setSize(height, width);
                z3 = false | this.P.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.Q.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f26300r + 1.0f)) * width2);
                this.Q.setSize(height2, width2);
                z3 |= this.Q.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z3) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f26295n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    j f(int i4, int i5) {
        j jVar = new j();
        jVar.f26315b = i4;
        jVar.f26314a = this.f26286e.e(this, i4);
        jVar.f26317d = this.f26286e.a(i4);
        if (i5 >= 0 && i5 < this.f26283b.size()) {
            this.f26283b.add(i5, jVar);
        } else {
            this.f26283b.add(jVar);
        }
        return jVar;
    }

    j g(View view) {
        for (int i4 = 0; i4 < this.f26283b.size(); i4++) {
            j jVar = this.f26283b.get(i4);
            if (this.f26286e.l(view, jVar.f26314a)) {
                return jVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new k();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public com.bytedance.adsdk.ugeno.viewpager.a getAdapter() {
        return this.f26286e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i4, int i5) {
        if (this.E0 == 2) {
            i5 = (i4 - 1) - i5;
        }
        return ((k) this.F0.get(i5).getLayoutParams()).f26324f;
    }

    public int getCurrentItem() {
        return this.f26287f;
    }

    public int getOffscreenPageLimit() {
        return this.f26306x;
    }

    public int getPageMargin() {
        return this.f26294m;
    }

    void h() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f26291j = new Scroller(context, K0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.C = viewConfiguration.getScaledPagingTouchSlop();
        this.J = (int) (400.0f * f4);
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.P = new EdgeEffect(context);
        this.Q = new EdgeEffect(context);
        this.f26281L = (int) (25.0f * f4);
        this.M = (int) (2.0f * f4);
        this.A = (int) (f4 * 16.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void i(int r18) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.i(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void j(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.U
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$k r9 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.k) r9
            boolean r10 = r9.f26319a
            if (r10 != 0) goto L2c
            goto L68
        L2c:
            int r9 = r9.f26320b
            r9 = r9 & 7
            if (r9 == r2) goto L4d
            r10 = 3
            if (r9 == r10) goto L47
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5c
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L59
        L47:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L59:
            r11 = r9
            r9 = r3
            r3 = r11
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            r12.O(r13, r14, r15)
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$e r13 = r12.C0
            if (r13 == 0) goto L9f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7a:
            if (r1 >= r14) goto L9f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$k r0 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.k) r0
            boolean r0 = r0.f26319a
            if (r0 == 0) goto L8b
            goto L9c
        L8b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$e r3 = r12.C0
            r3.a(r15, r0)
        L9c:
            int r1 = r1 + 1
            goto L7a
        L9f:
            r12.T = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.j(int, float, int):void");
    }

    void k(int i4, int i5, int i6) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f26291j;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f26292k ? this.f26291j.getCurrX() : this.f26291j.getStartX();
            this.f26291j.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i7 = scrollX;
        int scrollY = getScrollY();
        int i8 = i4 - i7;
        int i9 = i5 - scrollY;
        if (i8 == 0 && i9 == 0) {
            t(false);
            Q();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f4 = clientWidth;
        float f5 = i10;
        float c4 = f5 + (c(Math.min(1.0f, (Math.abs(i8) * 1.0f) / f4)) * f5);
        int abs2 = Math.abs(i6);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(c4 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i8) / ((f4 * this.f26286e.a(this.f26287f)) + this.f26294m)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.f26292k = false;
        this.f26291j.startScroll(i7, scrollY, i8, i9, min);
        postInvalidateOnAnimation();
    }

    public void m(int i4, boolean z3) {
        this.f26305w = false;
        o(i4, z3, false);
    }

    void o(int i4, boolean z3, boolean z4) {
        p(i4, z3, z4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.R = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.G0);
        Scroller scroller = this.f26291j;
        if (scroller != null && !scroller.isFinished()) {
            this.f26291j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i4;
        float f4;
        float f5;
        super.onDraw(canvas);
        if (this.f26294m <= 0 || this.f26295n == null || this.f26283b.size() <= 0 || this.f26286e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f6 = this.f26294m / width2;
        int i5 = 0;
        j jVar = this.f26283b.get(0);
        float f7 = jVar.f26318e;
        int size = this.f26283b.size();
        int i6 = jVar.f26315b;
        int i7 = this.f26283b.get(size - 1).f26315b;
        while (i6 < i7) {
            while (true) {
                i4 = jVar.f26315b;
                if (i6 <= i4 || i5 >= size) {
                    break;
                }
                i5++;
                jVar = this.f26283b.get(i5);
            }
            if (i6 == i4) {
                float f8 = jVar.f26318e;
                float f9 = jVar.f26317d;
                f4 = (f8 + f9) * width2;
                f7 = f8 + f9 + f6;
            } else {
                float a4 = this.f26286e.a(i6);
                f4 = (f7 + a4) * width2;
                f7 += a4 + f6;
            }
            if (this.f26294m + f4 > scrollX) {
                f5 = f6;
                this.f26295n.setBounds(Math.round(f4), this.f26296o, Math.round(this.f26294m + f4), this.f26297p);
                this.f26295n.draw(canvas);
            } else {
                f5 = f6;
            }
            if (f4 > scrollX + width) {
                return;
            }
            i6++;
            f6 = f5;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.f26307y) {
                    return true;
                }
                if (this.f26308z) {
                    return false;
                }
            }
            if (action == 0) {
                float x3 = motionEvent.getX();
                this.F = x3;
                this.D = x3;
                float y3 = motionEvent.getY();
                this.G = y3;
                this.E = y3;
                this.H = motionEvent.getPointerId(0);
                this.f26308z = false;
                this.f26292k = true;
                this.f26291j.computeScrollOffset();
                if (this.H0 == 2 && Math.abs(this.f26291j.getFinalX() - this.f26291j.getCurrX()) > this.M) {
                    this.f26291j.abortAnimation();
                    this.f26305w = false;
                    Q();
                    this.f26307y = true;
                    R(true);
                    setScrollState(1);
                } else {
                    t(false);
                    this.f26307y = false;
                }
            } else if (action == 2) {
                int i4 = this.H;
                if (i4 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i4);
                    float x4 = motionEvent.getX(findPointerIndex);
                    float f4 = x4 - this.D;
                    float abs = Math.abs(f4);
                    float y4 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y4 - this.G);
                    if (f4 != 0.0f && !w(this.D, f4) && y(this, false, (int) f4, (int) x4, (int) y4)) {
                        this.D = x4;
                        this.E = y4;
                        this.f26308z = true;
                        return false;
                    }
                    int i5 = this.C;
                    if (abs > i5 && abs * 0.5f > abs2) {
                        this.f26307y = true;
                        R(true);
                        setScrollState(1);
                        this.D = f4 > 0.0f ? this.F + this.C : this.F - this.C;
                        this.E = y4;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > i5) {
                        this.f26308z = true;
                    }
                    if (this.f26307y && S(x4)) {
                        postInvalidateOnAnimation();
                    }
                }
            } else if (action == 6) {
                q(motionEvent);
            }
            if (this.I == null) {
                this.I = VelocityTracker.obtain();
            }
            this.I.addMovement(motionEvent);
            return this.f26307y;
        }
        D();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i4, Rect rect) {
        int i5;
        int i6;
        j g4;
        int childCount = getChildCount();
        int i7 = -1;
        if ((i4 & 2) != 0) {
            i7 = childCount;
            i5 = 0;
            i6 = 1;
        } else {
            i5 = childCount - 1;
            i6 = -1;
        }
        while (i5 != i7) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (g4 = g(childAt)) != null && g4.f26315b == this.f26287f && childAt.requestFocus(i4, rect)) {
                return true;
            }
            i5 += i6;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ev)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ev evVar = (ev) parcelable;
        super.onRestoreInstanceState(evVar.b());
        com.bytedance.adsdk.ugeno.viewpager.a aVar = this.f26286e;
        if (aVar != null) {
            aVar.g(evVar.f26311d, evVar.f26312e);
            o(evVar.f26310c, false, true);
            return;
        }
        this.f26288g = evVar.f26310c;
        this.f26289h = evVar.f26311d;
        this.f26290i = evVar.f26312e;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ev evVar = new ev(super.onSaveInstanceState());
        evVar.f26310c = this.f26287f;
        com.bytedance.adsdk.ugeno.viewpager.a aVar = this.f26286e;
        if (aVar != null) {
            evVar.f26311d = aVar.m();
        }
        return evVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 != i6) {
            int i8 = this.f26294m;
            l(i4, i6, i8, i8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.viewpager.a aVar;
        if (this.N) {
            return true;
        }
        boolean z3 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f26286e) == null || aVar.b() == 0) {
            return false;
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f26291j.abortAnimation();
            this.f26305w = false;
            Q();
            float x3 = motionEvent.getX();
            this.F = x3;
            this.D = x3;
            float y3 = motionEvent.getY();
            this.G = y3;
            this.E = y3;
            this.H = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.f26307y) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.H);
                    if (findPointerIndex == -1) {
                        z3 = D();
                    } else {
                        float x4 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x4 - this.D);
                        float y4 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y4 - this.E);
                        if (abs > this.C && abs > abs2) {
                            this.f26307y = true;
                            R(true);
                            float f4 = this.F;
                            this.D = x4 - f4 > 0.0f ? f4 + this.C : f4 - this.C;
                            this.E = y4;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f26307y) {
                    z3 = false | S(motionEvent.getX(motionEvent.findPointerIndex(this.H)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.D = motionEvent.getX(actionIndex);
                    this.H = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    q(motionEvent);
                    this.D = motionEvent.getX(motionEvent.findPointerIndex(this.H));
                }
            } else if (this.f26307y) {
                n(this.f26287f, true, 0, false);
                z3 = D();
            }
        } else if (this.f26307y) {
            VelocityTracker velocityTracker = this.I;
            velocityTracker.computeCurrentVelocity(1000, this.K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.H);
            this.f26305w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            j a4 = a();
            float f5 = clientWidth;
            p(d(a4.f26315b, ((scrollX / f5) - a4.f26318e) / (a4.f26317d + (this.f26294m / f5)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.H)) - this.F)), true, true, xVelocity);
            z3 = D();
        }
        if (z3) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    void p(int i4, boolean z3, boolean z4, int i5) {
        com.bytedance.adsdk.ugeno.viewpager.a aVar = this.f26286e;
        if (aVar != null && aVar.b() > 0) {
            if (!z4 && this.f26287f == i4 && this.f26283b.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i4 < 0) {
                i4 = 0;
            } else if (i4 >= this.f26286e.b()) {
                i4 = this.f26286e.b() - 1;
            }
            int i6 = this.f26306x;
            int i7 = this.f26287f;
            if (i4 > i7 + i6 || i4 < i7 - i6) {
                for (int i8 = 0; i8 < this.f26283b.size(); i8++) {
                    this.f26283b.get(i8).f26316c = true;
                }
            }
            boolean z5 = this.f26287f != i4;
            if (this.R) {
                this.f26287f = i4;
                if (z5) {
                    J(i4);
                }
                requestLayout();
                return;
            }
            i(i4);
            n(i4, z3, i5, z5);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void r(i iVar) {
        if (this.V == null) {
            this.V = new ArrayList();
        }
        this.V.add(iVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f26303u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.viewpager.a aVar) {
        com.bytedance.adsdk.ugeno.viewpager.a aVar2 = this.f26286e;
        if (aVar2 != null) {
            aVar2.f(null);
            this.f26286e.j(this);
            for (int i4 = 0; i4 < this.f26283b.size(); i4++) {
                j jVar = this.f26283b.get(i4);
                this.f26286e.k(this, jVar.f26315b, jVar.f26314a);
            }
            this.f26286e.p(this);
            this.f26283b.clear();
            C();
            this.f26287f = 0;
            scrollTo(0, 0);
        }
        com.bytedance.adsdk.ugeno.viewpager.a aVar3 = this.f26286e;
        this.f26286e = aVar;
        this.f26282a = 0;
        if (aVar != null) {
            if (this.f26293l == null) {
                this.f26293l = new g();
            }
            this.f26286e.f(this.f26293l);
            this.f26305w = false;
            boolean z3 = this.R;
            this.R = true;
            this.f26282a = this.f26286e.b();
            if (this.f26288g >= 0) {
                this.f26286e.g(this.f26289h, this.f26290i);
                o(this.f26288g, false, true);
                this.f26288g = -1;
                this.f26289h = null;
                this.f26290i = null;
            } else if (!z3) {
                Q();
            } else {
                requestLayout();
            }
        }
        List<h> list = this.B0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.B0.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.B0.get(i5).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i4) {
        this.f26305w = false;
        o(i4, !this.R, false);
    }

    public void setOffscreenPageLimit(int i4) {
        if (i4 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i4 + " too small; defaulting to 1");
            i4 = 1;
        }
        if (i4 != this.f26306x) {
            this.f26306x = i4;
            Q();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.W = iVar;
    }

    public void setPageMargin(int i4) {
        int i5 = this.f26294m;
        this.f26294m = i4;
        int width = getWidth();
        l(width, width, i4, i5);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f26295n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i4) {
        if (this.H0 == i4) {
            return;
        }
        this.H0 = i4;
        if (this.C0 != null) {
            P(i4 != 0);
        }
        A(i4);
    }

    public void setScroller(Scroller scroller) {
        this.f26291j = scroller;
    }

    public void u(boolean z3, e eVar) {
        v(z3, eVar, 2);
    }

    public void v(boolean z3, e eVar, int i4) {
        boolean z4 = eVar != null;
        boolean z5 = z4 != (this.C0 != null);
        this.C0 = eVar;
        setChildrenDrawingOrderEnabled(z4);
        if (z4) {
            this.E0 = z3 ? 2 : 1;
            this.D0 = i4;
        } else {
            this.E0 = 0;
        }
        if (z5) {
            Q();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f26295n;
    }

    public boolean x(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return F();
                }
                return T(17);
            } else if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return z();
                }
                return T(66);
            } else if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return T(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return T(1);
                }
            }
        }
        return false;
    }

    protected boolean y(View view, boolean z3, int i4, int i5, int i6) {
        int i7;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i8 = i5 + scrollX;
                if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && (i7 = i6 + scrollY) >= childAt.getTop() && i7 < childAt.getBottom() && y(childAt, true, i4, i8 - childAt.getLeft(), i7 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z3 && view.canScrollHorizontally(-i4);
    }

    boolean z() {
        com.bytedance.adsdk.ugeno.viewpager.a aVar = this.f26286e;
        if (aVar == null || this.f26287f >= aVar.b() - 1) {
            return false;
        }
        m(this.f26287f + 1, true);
        return true;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class k extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26319a;

        /* renamed from: b  reason: collision with root package name */
        public int f26320b;

        /* renamed from: c  reason: collision with root package name */
        float f26321c;

        /* renamed from: d  reason: collision with root package name */
        boolean f26322d;

        /* renamed from: e  reason: collision with root package name */
        int f26323e;

        /* renamed from: f  reason: collision with root package name */
        int f26324f;

        public k() {
            super(-1, -1);
            this.f26321c = 0.0f;
        }

        public k(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f26321c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.I0);
            this.f26320b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new k(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i4) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i4));
    }
}
