package com.acse.ottn.animator.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.acse.ottn.animator.a.AbstractC1361a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class L extends AbstractC1361a {

    /* renamed from: b  reason: collision with root package name */
    private static final long f4854b = 10;

    /* renamed from: c  reason: collision with root package name */
    static final int f4855c = 0;

    /* renamed from: d  reason: collision with root package name */
    static final int f4856d = 1;

    /* renamed from: e  reason: collision with root package name */
    static final int f4857e = 0;

    /* renamed from: f  reason: collision with root package name */
    static final int f4858f = 1;

    /* renamed from: g  reason: collision with root package name */
    static final int f4859g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static ThreadLocal<a> f4860h = new ThreadLocal<>();

    /* renamed from: i  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<L>> f4861i = new G();

    /* renamed from: j  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<L>> f4862j = new H();

    /* renamed from: k  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<L>> f4863k = new I();

    /* renamed from: l  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<L>> f4864l = new J();

    /* renamed from: m  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<L>> f4865m = new K();

    /* renamed from: n  reason: collision with root package name */
    private static final Interpolator f4866n = new AccelerateDecelerateInterpolator();

    /* renamed from: o  reason: collision with root package name */
    private static final F f4867o = new C1369i();

    /* renamed from: p  reason: collision with root package name */
    private static final F f4868p = new C1367g();

    /* renamed from: q  reason: collision with root package name */
    private static long f4869q = 10;

    /* renamed from: r  reason: collision with root package name */
    public static final int f4870r = 1;

    /* renamed from: s  reason: collision with root package name */
    public static final int f4871s = 2;

    /* renamed from: t  reason: collision with root package name */
    public static final int f4872t = -1;
    private long A;

    /* renamed from: L  reason: collision with root package name */
    D[] f4873L;
    HashMap<String, D> M;

    /* renamed from: u  reason: collision with root package name */
    long f4874u;

    /* renamed from: v  reason: collision with root package name */
    long f4875v = -1;

    /* renamed from: w  reason: collision with root package name */
    private boolean f4876w = false;

    /* renamed from: x  reason: collision with root package name */
    private int f4877x = 0;

    /* renamed from: y  reason: collision with root package name */
    private float f4878y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    private boolean f4879z = false;
    int B = 0;
    private boolean C = false;
    private boolean D = false;
    boolean E = false;
    private long F = 300;
    private long G = 0;
    private int H = 0;
    private int I = 1;
    private Interpolator J = f4866n;
    private ArrayList<b> K = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a extends Handler {
        private a() {
        }

        /* synthetic */ a(G g4) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z3;
            ArrayList arrayList = (ArrayList) L.f4861i.get();
            ArrayList arrayList2 = (ArrayList) L.f4863k.get();
            int i4 = message.what;
            if (i4 == 0) {
                ArrayList arrayList3 = (ArrayList) L.f4862j.get();
                z3 = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        L l4 = (L) arrayList4.get(i5);
                        if (l4.G == 0) {
                            l4.E();
                        } else {
                            arrayList2.add(l4);
                        }
                    }
                }
            } else if (i4 != 1) {
                return;
            } else {
                z3 = true;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) L.f4865m.get();
            ArrayList arrayList6 = (ArrayList) L.f4864l.get();
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                L l5 = (L) arrayList2.get(i6);
                if (l5.f(currentAnimationTimeMillis)) {
                    arrayList5.add(l5);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i7 = 0; i7 < size3; i7++) {
                    L l6 = (L) arrayList5.get(i7);
                    l6.E();
                    l6.C = true;
                    arrayList2.remove(l6);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i8 = 0;
            while (i8 < size4) {
                L l7 = (L) arrayList.get(i8);
                if (l7.c(currentAnimationTimeMillis)) {
                    arrayList6.add(l7);
                }
                if (arrayList.size() == size4) {
                    i8++;
                } else {
                    size4--;
                    arrayList6.remove(l7);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i9 = 0; i9 < arrayList6.size(); i9++) {
                    ((L) arrayList6.get(i9)).D();
                }
                arrayList6.clear();
            }
            if (z3) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, L.f4869q - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface b {
        void a(L l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ArrayList<AbstractC1361a.InterfaceC0082a> arrayList;
        f4861i.get().remove(this);
        f4862j.get().remove(this);
        f4863k.get().remove(this);
        this.B = 0;
        if (this.C && (arrayList = this.f4880a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((AbstractC1361a.InterfaceC0082a) arrayList2.get(i4)).a(this);
            }
        }
        this.C = false;
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        ArrayList<AbstractC1361a.InterfaceC0082a> arrayList;
        A();
        f4861i.get().add(this);
        if (this.G <= 0 || (arrayList = this.f4880a) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((AbstractC1361a.InterfaceC0082a) arrayList2.get(i4)).d(this);
        }
    }

    public static L a(F f4, Object... objArr) {
        L l4 = new L();
        l4.a(objArr);
        l4.a(f4);
        return l4;
    }

    public static L a(float... fArr) {
        L l4 = new L();
        l4.b(fArr);
        return l4;
    }

    public static L a(int... iArr) {
        L l4 = new L();
        l4.b(iArr);
        return l4;
    }

    public static L a(D... dArr) {
        L l4 = new L();
        l4.b(dArr);
        return l4;
    }

    private void a(boolean z3) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f4876w = z3;
        this.f4877x = 0;
        this.B = 0;
        this.D = true;
        this.f4879z = false;
        f4862j.get().add(this);
        if (this.G == 0) {
            d(u());
            this.B = 0;
            this.C = true;
            ArrayList<AbstractC1361a.InterfaceC0082a> arrayList = this.f4880a;
            if (arrayList != null) {
                ArrayList arrayList2 = (ArrayList) arrayList.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((AbstractC1361a.InterfaceC0082a) arrayList2.get(i4)).d(this);
                }
            }
        }
        a aVar = f4860h.get();
        if (aVar == null) {
            aVar = new a(null);
            f4860h.set(aVar);
        }
        aVar.sendEmptyMessage(0);
    }

    public static void e(long j4) {
        f4869q = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(long j4) {
        if (!this.f4879z) {
            this.f4879z = true;
            this.A = j4;
            return false;
        }
        long j5 = j4 - this.A;
        long j6 = this.G;
        if (j5 > j6) {
            this.f4874u = j4 - (j5 - j6);
            this.B = 1;
            return true;
        }
        return false;
    }

    public static void q() {
        f4861i.get().clear();
        f4862j.get().clear();
        f4863k.get().clear();
    }

    public static int t() {
        return f4861i.get().size();
    }

    public static long v() {
        return f4869q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (this.E) {
            return;
        }
        int length = this.f4873L.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f4873L[i4].c();
        }
        this.E = true;
    }

    public void B() {
        ArrayList<b> arrayList = this.K;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.K = null;
    }

    public void C() {
        this.f4876w = !this.f4876w;
        if (this.B != 1) {
            a(true);
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f4874u = currentAnimationTimeMillis - (this.F - (currentAnimationTimeMillis - this.f4874u));
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public L a(long j4) {
        if (j4 >= 0) {
            this.F = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    public Object a(String str) {
        D d4 = this.M.get(str);
        if (d4 != null) {
            return d4.a();
        }
        return null;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void a() {
        if (!f4861i.get().contains(this) && !f4862j.get().contains(this)) {
            this.f4879z = false;
            E();
        } else if (!this.E) {
            A();
        }
        int i4 = this.H;
        a((i4 <= 0 || (i4 & 1) != 1) ? 1.0f : 0.0f);
        D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f4) {
        float interpolation = this.J.getInterpolation(f4);
        this.f4878y = interpolation;
        int length = this.f4873L.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f4873L[i4].a(interpolation);
        }
        ArrayList<b> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.K.get(i5).a(this);
            }
        }
    }

    public void a(int i4) {
        this.H = i4;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void a(Interpolator interpolator) {
        if (interpolator == null) {
            interpolator = new LinearInterpolator();
        }
        this.J = interpolator;
    }

    public void a(F f4) {
        D[] dArr;
        if (f4 == null || (dArr = this.f4873L) == null || dArr.length <= 0) {
            return;
        }
        dArr[0].a(f4);
    }

    public void a(b bVar) {
        if (this.K == null) {
            this.K = new ArrayList<>();
        }
        this.K.add(bVar);
    }

    public void a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        D[] dArr = this.f4873L;
        if (dArr == null || dArr.length == 0) {
            b(D.a("", (F) null, objArr));
        } else {
            dArr[0].a(objArr);
        }
        this.E = false;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public long b() {
        return this.F;
    }

    public void b(int i4) {
        this.I = i4;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void b(long j4) {
        this.G = j4;
    }

    public void b(b bVar) {
        ArrayList<b> arrayList = this.K;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(bVar);
        if (this.K.size() == 0) {
            this.K = null;
        }
    }

    public void b(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        D[] dArr = this.f4873L;
        if (dArr == null || dArr.length == 0) {
            b(D.a("", fArr));
        } else {
            dArr[0].a(fArr);
        }
        this.E = false;
    }

    public void b(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        D[] dArr = this.f4873L;
        if (dArr == null || dArr.length == 0) {
            b(D.a("", iArr));
        } else {
            dArr[0].a(iArr);
        }
        this.E = false;
    }

    public void b(D... dArr) {
        int length = dArr.length;
        this.f4873L = dArr;
        this.M = new HashMap<>(length);
        for (D d4 : dArr) {
            this.M.put(d4.b(), d4);
        }
        this.E = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean c(long r10) {
        /*
            r9 = this;
            int r0 = r9.B
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L1a
            r9.B = r3
            long r4 = r9.f4875v
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L12
            r9.f4874u = r10
            goto L1a
        L12:
            long r4 = r10 - r4
            r9.f4874u = r4
            r4 = -1
            r9.f4875v = r4
        L1a:
            int r0 = r9.B
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L23
            if (r0 == r4) goto L23
            goto L82
        L23:
            long r6 = r9.F
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L32
            long r1 = r9.f4874u
            long r10 = r10 - r1
            float r10 = (float) r10
            float r11 = (float) r6
            float r10 = r10 / r11
            goto L34
        L32:
            r10 = 1065353216(0x3f800000, float:1.0)
        L34:
            int r11 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r11 < 0) goto L77
            int r11 = r9.f4877x
            int r1 = r9.H
            if (r11 < r1) goto L47
            r11 = -1
            if (r1 != r11) goto L42
            goto L47
        L42:
            float r10 = java.lang.Math.min(r10, r0)
            goto L78
        L47:
            java.util.ArrayList<com.acse.ottn.animator.a.a$a> r11 = r9.f4880a
            if (r11 == 0) goto L60
            int r11 = r11.size()
            r1 = 0
        L50:
            if (r1 >= r11) goto L60
            java.util.ArrayList<com.acse.ottn.animator.a.a$a> r2 = r9.f4880a
            java.lang.Object r2 = r2.get(r1)
            com.acse.ottn.animator.a.a$a r2 = (com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a) r2
            r2.b(r9)
            int r1 = r1 + 1
            goto L50
        L60:
            int r11 = r9.I
            if (r11 != r4) goto L69
            boolean r11 = r9.f4876w
            r11 = r11 ^ r3
            r9.f4876w = r11
        L69:
            int r11 = r9.f4877x
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.f4877x = r11
            float r10 = r10 % r0
            long r1 = r9.f4874u
            long r3 = r9.F
            long r1 = r1 + r3
            r9.f4874u = r1
        L77:
            r3 = 0
        L78:
            boolean r11 = r9.f4876w
            if (r11 == 0) goto L7e
            float r10 = r0 - r10
        L7e:
            r9.a(r10)
            r5 = r3
        L82:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.animator.a.L.c(long):boolean");
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void cancel() {
        ArrayList<AbstractC1361a.InterfaceC0082a> arrayList;
        if (this.B != 0 || f4862j.get().contains(this) || f4863k.get().contains(this)) {
            if (this.C && (arrayList = this.f4880a) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((AbstractC1361a.InterfaceC0082a) it.next()).c(this);
                }
            }
            D();
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    /* renamed from: clone */
    public L mo10clone() {
        L l4 = (L) super.mo10clone();
        ArrayList<b> arrayList = this.K;
        if (arrayList != null) {
            l4.K = new ArrayList<>();
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                l4.K.add(arrayList.get(i4));
            }
        }
        l4.f4875v = -1L;
        l4.f4876w = false;
        l4.f4877x = 0;
        l4.E = false;
        l4.B = 0;
        l4.f4879z = false;
        D[] dArr = this.f4873L;
        if (dArr != null) {
            int length = dArr.length;
            l4.f4873L = new D[length];
            l4.M = new HashMap<>(length);
            for (int i5 = 0; i5 < length; i5++) {
                D mo9clone = dArr[i5].mo9clone();
                l4.f4873L[i5] = mo9clone;
                l4.M.put(mo9clone.b(), mo9clone);
            }
        }
        return l4;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public long d() {
        return this.G;
    }

    public void d(long j4) {
        A();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.B != 1) {
            this.f4875v = j4;
            this.B = 2;
        }
        this.f4874u = currentAnimationTimeMillis - j4;
        c(currentAnimationTimeMillis);
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public boolean e() {
        return this.B == 1 || this.C;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public boolean f() {
        return this.D;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void j() {
        a(false);
    }

    public float r() {
        return this.f4878y;
    }

    public Object s() {
        D[] dArr = this.f4873L;
        if (dArr == null || dArr.length <= 0) {
            return null;
        }
        return dArr[0].a();
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f4873L != null) {
            for (int i4 = 0; i4 < this.f4873L.length; i4++) {
                str = str + "\n    " + this.f4873L[i4].toString();
            }
        }
        return str;
    }

    public long u() {
        if (!this.E || this.B == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f4874u;
    }

    public Interpolator w() {
        return this.J;
    }

    public int x() {
        return this.H;
    }

    public int y() {
        return this.I;
    }

    public D[] z() {
        return this.f4873L;
    }
}
