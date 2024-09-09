package com.acse.ottn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.acse.ottn.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g4 extends i {
    public static ThreadLocal<f> A = new ThreadLocal<>();
    public static final ThreadLocal<ArrayList<g4>> B = new a();
    public static final ThreadLocal<ArrayList<g4>> C = new b();
    public static final ThreadLocal<ArrayList<g4>> D = new c();
    public static final ThreadLocal<ArrayList<g4>> E = new d();
    public static final ThreadLocal<ArrayList<g4>> F = new e();
    public static final Interpolator G = new AccelerateDecelerateInterpolator();
    public static final f4 H = new q1();
    public static final f4 I = new a1();
    public static long J = 10;
    public static final int K = 1;

    /* renamed from: L  reason: collision with root package name */
    public static final int f5681L = 2;
    public static final int M = -1;

    /* renamed from: u  reason: collision with root package name */
    public static final long f5682u = 10;

    /* renamed from: v  reason: collision with root package name */
    public static final int f5683v = 0;

    /* renamed from: w  reason: collision with root package name */
    public static final int f5684w = 1;

    /* renamed from: x  reason: collision with root package name */
    public static final int f5685x = 0;

    /* renamed from: y  reason: collision with root package name */
    public static final int f5686y = 1;

    /* renamed from: z  reason: collision with root package name */
    public static final int f5687z = 2;

    /* renamed from: b  reason: collision with root package name */
    public long f5688b;

    /* renamed from: h  reason: collision with root package name */
    public long f5694h;

    /* renamed from: s  reason: collision with root package name */
    public c3[] f5705s;

    /* renamed from: t  reason: collision with root package name */
    public HashMap<String, c3> f5706t;

    /* renamed from: c  reason: collision with root package name */
    public long f5689c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5690d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f5691e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f5692f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5693g = false;

    /* renamed from: i  reason: collision with root package name */
    public int f5695i = 0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5696j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5697k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5698l = false;

    /* renamed from: m  reason: collision with root package name */
    public long f5699m = 300;

    /* renamed from: n  reason: collision with root package name */
    public long f5700n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f5701o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f5702p = 1;

    /* renamed from: q  reason: collision with root package name */
    public Interpolator f5703q = G;

    /* renamed from: r  reason: collision with root package name */
    public ArrayList<g> f5704r = null;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends ThreadLocal<ArrayList<g4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<g4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends ThreadLocal<ArrayList<g4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<g4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends ThreadLocal<ArrayList<g4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<g4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d extends ThreadLocal<ArrayList<g4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<g4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e extends ThreadLocal<ArrayList<g4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<g4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z3;
            ArrayList arrayList = (ArrayList) g4.B.get();
            ArrayList arrayList2 = (ArrayList) g4.D.get();
            int i4 = message.what;
            if (i4 == 0) {
                ArrayList arrayList3 = (ArrayList) g4.C.get();
                z3 = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        g4 g4Var = (g4) arrayList4.get(i5);
                        if (g4Var.f5700n == 0) {
                            g4Var.G();
                        } else {
                            arrayList2.add(g4Var);
                        }
                    }
                }
            } else if (i4 != 1) {
                return;
            } else {
                z3 = true;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) g4.F.get();
            ArrayList arrayList6 = (ArrayList) g4.E.get();
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                g4 g4Var2 = (g4) arrayList2.get(i6);
                if (g4Var2.d(currentAnimationTimeMillis)) {
                    arrayList5.add(g4Var2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i7 = 0; i7 < size3; i7++) {
                    g4 g4Var3 = (g4) arrayList5.get(i7);
                    g4Var3.G();
                    g4Var3.f5696j = true;
                    arrayList2.remove(g4Var3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i8 = 0;
            while (i8 < size4) {
                g4 g4Var4 = (g4) arrayList.get(i8);
                if (g4Var4.c(currentAnimationTimeMillis)) {
                    arrayList6.add(g4Var4);
                }
                if (arrayList.size() == size4) {
                    i8++;
                } else {
                    size4--;
                    arrayList6.remove(g4Var4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i9 = 0; i9 < arrayList6.size(); i9++) {
                    ((g4) arrayList6.get(i9)).t();
                }
                arrayList6.clear();
            }
            if (z3) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, g4.J - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface g {
        void a(g4 g4Var);
    }

    public static void g(long j4) {
        J = j4;
    }

    public static void r() {
        B.get().clear();
        C.get().clear();
        D.get().clear();
    }

    public static int w() {
        return B.get().size();
    }

    public static long y() {
        return J;
    }

    public int A() {
        return this.f5701o;
    }

    public int B() {
        return this.f5702p;
    }

    public c3[] C() {
        return this.f5705s;
    }

    public void D() {
        if (this.f5698l) {
            return;
        }
        int length = this.f5705s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f5705s[i4].d();
        }
        this.f5698l = true;
    }

    public void E() {
        ArrayList<g> arrayList = this.f5704r;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.f5704r = null;
    }

    public void F() {
        this.f5690d = !this.f5690d;
        if (this.f5695i == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f5688b = currentAnimationTimeMillis - (this.f5699m - (currentAnimationTimeMillis - this.f5688b));
            return;
        }
        a(true);
    }

    public final void G() {
        ArrayList<i.a> arrayList;
        D();
        B.get().add(this);
        if (this.f5700n <= 0 || (arrayList = this.f5729a) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((i.a) arrayList2.get(i4)).a(this);
        }
    }

    @Override // com.acse.ottn.i
    public void cancel() {
        ArrayList<i.a> arrayList;
        if (this.f5695i != 0 || C.get().contains(this) || D.get().contains(this)) {
            if (this.f5696j && (arrayList = this.f5729a) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((i.a) it.next()).d(this);
                }
            }
            t();
        }
    }

    public final boolean d(long j4) {
        if (!this.f5693g) {
            this.f5693g = true;
            this.f5694h = j4;
            return false;
        }
        long j5 = j4 - this.f5694h;
        long j6 = this.f5700n;
        if (j5 > j6) {
            this.f5688b = j4 - (j5 - j6);
            this.f5695i = 1;
            return true;
        }
        return false;
    }

    public void e(long j4) {
        D();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f5695i != 1) {
            this.f5689c = j4;
            this.f5695i = 2;
        }
        this.f5688b = currentAnimationTimeMillis - j4;
        c(currentAnimationTimeMillis);
    }

    @Override // com.acse.ottn.i
    /* renamed from: f */
    public g4 a(long j4) {
        if (j4 >= 0) {
            this.f5699m = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.acse.ottn.i
    public void k() {
        a(false);
    }

    @Override // com.acse.ottn.i
    /* renamed from: s */
    public g4 clone() {
        g4 g4Var = (g4) super.clone();
        ArrayList<g> arrayList = this.f5704r;
        if (arrayList != null) {
            g4Var.f5704r = new ArrayList<>();
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                g4Var.f5704r.add(arrayList.get(i4));
            }
        }
        g4Var.f5689c = -1L;
        g4Var.f5690d = false;
        g4Var.f5691e = 0;
        g4Var.f5698l = false;
        g4Var.f5695i = 0;
        g4Var.f5693g = false;
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr != null) {
            int length = c3VarArr.length;
            g4Var.f5705s = new c3[length];
            g4Var.f5706t = new HashMap<>(length);
            for (int i5 = 0; i5 < length; i5++) {
                c3 clone = c3VarArr[i5].clone();
                g4Var.f5705s[i5] = clone;
                g4Var.f5706t.put(clone.c(), clone);
            }
        }
        return g4Var;
    }

    public final void t() {
        ArrayList<i.a> arrayList;
        B.get().remove(this);
        C.get().remove(this);
        D.get().remove(this);
        this.f5695i = 0;
        if (this.f5696j && (arrayList = this.f5729a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((i.a) arrayList2.get(i4)).b(this);
            }
        }
        this.f5696j = false;
        this.f5697k = false;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f5705s != null) {
            for (int i4 = 0; i4 < this.f5705s.length; i4++) {
                str = str + "\n    " + this.f5705s[i4].toString();
            }
        }
        return str;
    }

    public float u() {
        return this.f5692f;
    }

    public Object v() {
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr == null || c3VarArr.length <= 0) {
            return null;
        }
        return c3VarArr[0].b();
    }

    public long x() {
        if (!this.f5698l || this.f5695i == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f5688b;
    }

    public Interpolator z() {
        return this.f5703q;
    }

    public void b(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr == null || c3VarArr.length == 0) {
            b(c3.a("", iArr));
        } else {
            c3VarArr[0].a(iArr);
        }
        this.f5698l = false;
    }

    @Override // com.acse.ottn.i
    public long c() {
        return this.f5699m;
    }

    @Override // com.acse.ottn.i
    public boolean g() {
        return this.f5697k;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(long r10) {
        /*
            r9 = this;
            int r0 = r9.f5695i
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L1a
            r9.f5695i = r3
            long r4 = r9.f5689c
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L12
            r9.f5688b = r10
            goto L1a
        L12:
            long r4 = r10 - r4
            r9.f5688b = r4
            r4 = -1
            r9.f5689c = r4
        L1a:
            int r0 = r9.f5695i
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L23
            if (r0 == r4) goto L23
            goto L82
        L23:
            long r6 = r9.f5699m
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L32
            long r1 = r9.f5688b
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
            int r11 = r9.f5691e
            int r1 = r9.f5701o
            if (r11 < r1) goto L47
            r11 = -1
            if (r1 != r11) goto L42
            goto L47
        L42:
            float r10 = java.lang.Math.min(r10, r0)
            goto L78
        L47:
            java.util.ArrayList<com.acse.ottn.i$a> r11 = r9.f5729a
            if (r11 == 0) goto L60
            int r11 = r11.size()
            r1 = 0
        L50:
            if (r1 >= r11) goto L60
            java.util.ArrayList<com.acse.ottn.i$a> r2 = r9.f5729a
            java.lang.Object r2 = r2.get(r1)
            com.acse.ottn.i$a r2 = (com.acse.ottn.i.a) r2
            r2.c(r9)
            int r1 = r1 + 1
            goto L50
        L60:
            int r11 = r9.f5702p
            if (r11 != r4) goto L69
            boolean r11 = r9.f5690d
            r11 = r11 ^ r3
            r9.f5690d = r11
        L69:
            int r11 = r9.f5691e
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.f5691e = r11
            float r10 = r10 % r0
            long r1 = r9.f5688b
            long r3 = r9.f5699m
            long r1 = r1 + r3
            r9.f5688b = r1
        L77:
            r3 = 0
        L78:
            boolean r11 = r9.f5690d
            if (r11 == 0) goto L7e
            float r10 = r0 - r10
        L7e:
            r9.a(r10)
            r5 = r3
        L82:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.g4.c(long):boolean");
    }

    @Override // com.acse.ottn.i
    public boolean f() {
        return this.f5695i == 1 || this.f5696j;
    }

    public static g4 a(int... iArr) {
        g4 g4Var = new g4();
        g4Var.b(iArr);
        return g4Var;
    }

    public static g4 a(float... fArr) {
        g4 g4Var = new g4();
        g4Var.b(fArr);
        return g4Var;
    }

    public void b(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr == null || c3VarArr.length == 0) {
            b(c3.a("", fArr));
        } else {
            c3VarArr[0].a(fArr);
        }
        this.f5698l = false;
    }

    @Override // com.acse.ottn.i
    public long e() {
        return this.f5700n;
    }

    public static g4 a(c3... c3VarArr) {
        g4 g4Var = new g4();
        g4Var.b(c3VarArr);
        return g4Var;
    }

    public static g4 a(f4 f4Var, Object... objArr) {
        g4 g4Var = new g4();
        g4Var.a(objArr);
        g4Var.a(f4Var);
        return g4Var;
    }

    public void b(c3... c3VarArr) {
        int length = c3VarArr.length;
        this.f5705s = c3VarArr;
        this.f5706t = new HashMap<>(length);
        for (c3 c3Var : c3VarArr) {
            this.f5706t.put(c3Var.c(), c3Var);
        }
        this.f5698l = false;
    }

    public void a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr == null || c3VarArr.length == 0) {
            b(c3.a("", (f4) null, objArr));
        } else {
            c3VarArr[0].a(objArr);
        }
        this.f5698l = false;
    }

    @Override // com.acse.ottn.i
    public void b(long j4) {
        this.f5700n = j4;
    }

    public Object a(String str) {
        c3 c3Var = this.f5706t.get(str);
        if (c3Var != null) {
            return c3Var.b();
        }
        return null;
    }

    public void b(int i4) {
        this.f5702p = i4;
    }

    public void b(g gVar) {
        ArrayList<g> arrayList = this.f5704r;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(gVar);
        if (this.f5704r.size() == 0) {
            this.f5704r = null;
        }
    }

    public void a(int i4) {
        this.f5701o = i4;
    }

    public void a(g gVar) {
        if (this.f5704r == null) {
            this.f5704r = new ArrayList<>();
        }
        this.f5704r.add(gVar);
    }

    @Override // com.acse.ottn.i
    public void b() {
        if (!B.get().contains(this) && !C.get().contains(this)) {
            this.f5693g = false;
            G();
        } else if (!this.f5698l) {
            D();
        }
        int i4 = this.f5701o;
        if (i4 > 0 && (i4 & 1) == 1) {
            a(0.0f);
        } else {
            a(1.0f);
        }
        t();
    }

    @Override // com.acse.ottn.i
    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.f5703q = interpolator;
        } else {
            this.f5703q = new LinearInterpolator();
        }
    }

    public void a(f4 f4Var) {
        c3[] c3VarArr;
        if (f4Var == null || (c3VarArr = this.f5705s) == null || c3VarArr.length <= 0) {
            return;
        }
        c3VarArr[0].a(f4Var);
    }

    public final void a(boolean z3) {
        if (Looper.myLooper() != null) {
            this.f5690d = z3;
            this.f5691e = 0;
            this.f5695i = 0;
            this.f5697k = true;
            this.f5693g = false;
            C.get().add(this);
            if (this.f5700n == 0) {
                e(x());
                this.f5695i = 0;
                this.f5696j = true;
                ArrayList<i.a> arrayList = this.f5729a;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((i.a) arrayList2.get(i4)).a(this);
                    }
                }
            }
            f fVar = A.get();
            if (fVar == null) {
                fVar = new f(null);
                A.set(fVar);
            }
            fVar.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    public void a(float f4) {
        float interpolation = this.f5703q.getInterpolation(f4);
        this.f5692f = interpolation;
        int length = this.f5705s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f5705s[i4].a(interpolation);
        }
        ArrayList<g> arrayList = this.f5704r;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f5704r.get(i5).a(this);
            }
        }
    }
}
