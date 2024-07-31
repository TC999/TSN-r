package com.acse.ottn.animator.p031a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.acse.ottn.animator.p031a.AbstractC1334a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.acse.ottn.animator.a.L */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1331L extends AbstractC1334a {

    /* renamed from: c */
    static final int f2296c = 0;

    /* renamed from: d */
    static final int f2297d = 1;

    /* renamed from: e */
    static final int f2298e = 0;

    /* renamed from: f */
    static final int f2299f = 1;

    /* renamed from: g */
    static final int f2300g = 2;

    /* renamed from: r */
    public static final int f2311r = 1;

    /* renamed from: s */
    public static final int f2312s = 2;

    /* renamed from: t */
    public static final int f2313t = -1;

    /* renamed from: A */
    private long f2314A;

    /* renamed from: L */
    C1320D[] f2325L;

    /* renamed from: M */
    HashMap<String, C1320D> f2326M;

    /* renamed from: u */
    long f2327u;

    /* renamed from: h */
    private static ThreadLocal<HandlerC1332a> f2301h = new ThreadLocal<>();

    /* renamed from: i */
    private static final ThreadLocal<ArrayList<C1331L>> f2302i = new C1326G();

    /* renamed from: j */
    private static final ThreadLocal<ArrayList<C1331L>> f2303j = new C1327H();

    /* renamed from: k */
    private static final ThreadLocal<ArrayList<C1331L>> f2304k = new C1328I();

    /* renamed from: l */
    private static final ThreadLocal<ArrayList<C1331L>> f2305l = new C1329J();

    /* renamed from: m */
    private static final ThreadLocal<ArrayList<C1331L>> f2306m = new C1330K();

    /* renamed from: n */
    private static final Interpolator f2307n = new AccelerateDecelerateInterpolator();

    /* renamed from: o */
    private static final InterfaceC1325F f2308o = new C1348i();

    /* renamed from: p */
    private static final InterfaceC1325F f2309p = new C1346g();

    /* renamed from: b */
    private static final long f2295b = 10;

    /* renamed from: q */
    private static long f2310q = f2295b;

    /* renamed from: v */
    long f2328v = -1;

    /* renamed from: w */
    private boolean f2329w = false;

    /* renamed from: x */
    private int f2330x = 0;

    /* renamed from: y */
    private float f2331y = 0.0f;

    /* renamed from: z */
    private boolean f2332z = false;

    /* renamed from: B */
    int f2315B = 0;

    /* renamed from: C */
    private boolean f2316C = false;

    /* renamed from: D */
    private boolean f2317D = false;

    /* renamed from: E */
    boolean f2318E = false;

    /* renamed from: F */
    private long f2319F = 300;

    /* renamed from: G */
    private long f2320G = 0;

    /* renamed from: H */
    private int f2321H = 0;

    /* renamed from: I */
    private int f2322I = 1;

    /* renamed from: J */
    private Interpolator f2323J = f2307n;

    /* renamed from: K */
    private ArrayList<InterfaceC1333b> f2324K = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.a.L$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class HandlerC1332a extends Handler {
        private HandlerC1332a() {
        }

        /* synthetic */ HandlerC1332a(C1326G c1326g) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = (ArrayList) C1331L.f2302i.get();
            ArrayList arrayList2 = (ArrayList) C1331L.f2304k.get();
            int i = message.what;
            if (i == 0) {
                ArrayList arrayList3 = (ArrayList) C1331L.f2303j.get();
                z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        C1331L c1331l = (C1331L) arrayList4.get(i2);
                        if (c1331l.f2320G == 0) {
                            c1331l.m57156E();
                        } else {
                            arrayList2.add(c1331l);
                        }
                    }
                }
            } else if (i != 1) {
                return;
            } else {
                z = true;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) C1331L.f2306m.get();
            ArrayList arrayList6 = (ArrayList) C1331L.f2305l.get();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                C1331L c1331l2 = (C1331L) arrayList2.get(i3);
                if (c1331l2.m57135f(currentAnimationTimeMillis)) {
                    arrayList5.add(c1331l2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i4 = 0; i4 < size3; i4++) {
                    C1331L c1331l3 = (C1331L) arrayList5.get(i4);
                    c1331l3.m57156E();
                    c1331l3.f2316C = true;
                    arrayList2.remove(c1331l3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i5 = 0;
            while (i5 < size4) {
                C1331L c1331l4 = (C1331L) arrayList.get(i5);
                if (c1331l4.mo57139c(currentAnimationTimeMillis)) {
                    arrayList6.add(c1331l4);
                }
                if (arrayList.size() == size4) {
                    i5++;
                } else {
                    size4--;
                    arrayList6.remove(c1331l4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i6 = 0; i6 < arrayList6.size(); i6++) {
                    ((C1331L) arrayList6.get(i6)).m57157D();
                }
                arrayList6.clear();
            }
            if (z) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, C1331L.f2310q - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    /* renamed from: com.acse.ottn.animator.a.L$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1333b {
        /* renamed from: a */
        void mo56857a(C1331L c1331l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m57157D() {
        ArrayList<AbstractC1334a.InterfaceC1335a> arrayList;
        f2302i.get().remove(this);
        f2303j.get().remove(this);
        f2304k.get().remove(this);
        this.f2315B = 0;
        if (this.f2316C && (arrayList = this.f2333a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                ((AbstractC1334a.InterfaceC1335a) arrayList2.get(i)).mo56852a(this);
            }
        }
        this.f2316C = false;
        this.f2317D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m57156E() {
        ArrayList<AbstractC1334a.InterfaceC1335a> arrayList;
        mo57058A();
        f2302i.get().add(this);
        if (this.f2320G <= 0 || (arrayList = this.f2333a) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC1334a.InterfaceC1335a) arrayList2.get(i)).mo56854d(this);
        }
    }

    /* renamed from: a */
    public static C1331L m57153a(InterfaceC1325F interfaceC1325F, Object... objArr) {
        C1331L c1331l = new C1331L();
        c1331l.mo57044a(objArr);
        c1331l.m57154a(interfaceC1325F);
        return c1331l;
    }

    /* renamed from: a */
    public static C1331L m57146a(float... fArr) {
        C1331L c1331l = new C1331L();
        c1331l.mo57042b(fArr);
        return c1331l;
    }

    /* renamed from: a */
    public static C1331L m57145a(int... iArr) {
        C1331L c1331l = new C1331L();
        c1331l.mo57041b(iArr);
        return c1331l;
    }

    /* renamed from: a */
    public static C1331L m57144a(C1320D... c1320dArr) {
        C1331L c1331l = new C1331L();
        c1331l.m57140b(c1320dArr);
        return c1331l;
    }

    /* renamed from: a */
    private void m57147a(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f2329w = z;
        this.f2330x = 0;
        this.f2315B = 0;
        this.f2317D = true;
        this.f2332z = false;
        f2303j.get().add(this);
        if (this.f2320G == 0) {
            m57137d(m57124u());
            this.f2315B = 0;
            this.f2316C = true;
            ArrayList<AbstractC1334a.InterfaceC1335a> arrayList = this.f2333a;
            if (arrayList != null) {
                ArrayList arrayList2 = (ArrayList) arrayList.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((AbstractC1334a.InterfaceC1335a) arrayList2.get(i)).mo56854d(this);
                }
            }
        }
        HandlerC1332a handlerC1332a = f2301h.get();
        if (handlerC1332a == null) {
            handlerC1332a = new HandlerC1332a(null);
            f2301h.set(handlerC1332a);
        }
        handlerC1332a.sendEmptyMessage(0);
    }

    /* renamed from: e */
    public static void m57136e(long j) {
        f2310q = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m57135f(long j) {
        if (!this.f2332z) {
            this.f2332z = true;
            this.f2314A = j;
            return false;
        }
        long j2 = j - this.f2314A;
        long j3 = this.f2320G;
        if (j2 > j3) {
            this.f2327u = j - (j2 - j3);
            this.f2315B = 1;
            return true;
        }
        return false;
    }

    /* renamed from: q */
    public static void m57128q() {
        f2302i.get().clear();
        f2303j.get().clear();
        f2304k.get().clear();
    }

    /* renamed from: t */
    public static int m57125t() {
        return f2302i.get().size();
    }

    /* renamed from: v */
    public static long m57123v() {
        return f2310q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public void mo57058A() {
        if (this.f2318E) {
            return;
        }
        int length = this.f2325L.length;
        for (int i = 0; i < length; i++) {
            this.f2325L[i].m57170c();
        }
        this.f2318E = true;
    }

    /* renamed from: B */
    public void m57159B() {
        ArrayList<InterfaceC1333b> arrayList = this.f2324K;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.f2324K = null;
    }

    /* renamed from: C */
    public void m57158C() {
        this.f2329w = !this.f2329w;
        if (this.f2315B != 1) {
            m57147a(true);
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f2327u = currentAnimationTimeMillis - (this.f2319F - (currentAnimationTimeMillis - this.f2327u));
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public C1331L mo57054a(long j) {
        if (j >= 0) {
            this.f2319F = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    /* renamed from: a */
    public Object m57148a(String str) {
        C1320D c1320d = this.f2326M.get(str);
        if (c1320d != null) {
            return c1320d.mo57166a();
        }
        return null;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public void mo57109a() {
        if (!f2302i.get().contains(this) && !f2303j.get().contains(this)) {
            this.f2332z = false;
            m57156E();
        } else if (!this.f2318E) {
            mo57058A();
        }
        int i = this.f2321H;
        mo57055a((i <= 0 || (i & 1) != 1) ? 1.0f : 0.0f);
        m57157D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57055a(float f) {
        float interpolation = this.f2323J.getInterpolation(f);
        this.f2331y = interpolation;
        int length = this.f2325L.length;
        for (int i = 0; i < length; i++) {
            this.f2325L[i].mo57165a(interpolation);
        }
        ArrayList<InterfaceC1333b> arrayList = this.f2324K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2324K.get(i2).mo56857a(this);
            }
        }
    }

    /* renamed from: a */
    public void m57155a(int i) {
        this.f2321H = i;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public void mo57108a(Interpolator interpolator) {
        if (interpolator == null) {
            interpolator = new LinearInterpolator();
        }
        this.f2323J = interpolator;
    }

    /* renamed from: a */
    public void m57154a(InterfaceC1325F interfaceC1325F) {
        C1320D[] c1320dArr;
        if (interfaceC1325F == null || (c1320dArr = this.f2325L) == null || c1320dArr.length <= 0) {
            return;
        }
        c1320dArr[0].m57190a(interfaceC1325F);
    }

    /* renamed from: a */
    public void m57152a(InterfaceC1333b interfaceC1333b) {
        if (this.f2324K == null) {
            this.f2324K = new ArrayList<>();
        }
        this.f2324K.add(interfaceC1333b);
    }

    /* renamed from: a */
    public void mo57044a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr == null || c1320dArr.length == 0) {
            m57140b(C1320D.m57180a("", (InterfaceC1325F) null, objArr));
        } else {
            c1320dArr[0].m57174a(objArr);
        }
        this.f2318E = false;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: b */
    public long mo57101b() {
        return this.f2319F;
    }

    /* renamed from: b */
    public void m57143b(int i) {
        this.f2322I = i;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: b */
    public void mo57100b(long j) {
        this.f2320G = j;
    }

    /* renamed from: b */
    public void m57142b(InterfaceC1333b interfaceC1333b) {
        ArrayList<InterfaceC1333b> arrayList = this.f2324K;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC1333b);
        if (this.f2324K.size() == 0) {
            this.f2324K = null;
        }
    }

    /* renamed from: b */
    public void mo57042b(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr == null || c1320dArr.length == 0) {
            m57140b(C1320D.m57178a("", fArr));
        } else {
            c1320dArr[0].mo57167a(fArr);
        }
        this.f2318E = false;
    }

    /* renamed from: b */
    public void mo57041b(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr == null || c1320dArr.length == 0) {
            m57140b(C1320D.m57177a("", iArr));
        } else {
            c1320dArr[0].mo57162a(iArr);
        }
        this.f2318E = false;
    }

    /* renamed from: b */
    public void m57140b(C1320D... c1320dArr) {
        int length = c1320dArr.length;
        this.f2325L = c1320dArr;
        this.f2326M = new HashMap<>(length);
        for (C1320D c1320d : c1320dArr) {
            this.f2326M.put(c1320d.m57173b(), c1320d);
        }
        this.f2318E = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean mo57139c(long r10) {
        /*
            r9 = this;
            int r0 = r9.f2315B
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L1a
            r9.f2315B = r3
            long r4 = r9.f2328v
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L12
            r9.f2327u = r10
            goto L1a
        L12:
            long r4 = r10 - r4
            r9.f2327u = r4
            r4 = -1
            r9.f2328v = r4
        L1a:
            int r0 = r9.f2315B
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L23
            if (r0 == r4) goto L23
            goto L82
        L23:
            long r6 = r9.f2319F
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L32
            long r1 = r9.f2327u
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
            int r11 = r9.f2330x
            int r1 = r9.f2321H
            if (r11 < r1) goto L47
            r11 = -1
            if (r1 != r11) goto L42
            goto L47
        L42:
            float r10 = java.lang.Math.min(r10, r0)
            goto L78
        L47:
            java.util.ArrayList<com.acse.ottn.animator.a.a$a> r11 = r9.f2333a
            if (r11 == 0) goto L60
            int r11 = r11.size()
            r1 = 0
        L50:
            if (r1 >= r11) goto L60
            java.util.ArrayList<com.acse.ottn.animator.a.a$a> r2 = r9.f2333a
            java.lang.Object r2 = r2.get(r1)
            com.acse.ottn.animator.a.a$a r2 = (com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a) r2
            r2.mo56856b(r9)
            int r1 = r1 + 1
            goto L50
        L60:
            int r11 = r9.f2322I
            if (r11 != r4) goto L69
            boolean r11 = r9.f2329w
            r11 = r11 ^ r3
            r9.f2329w = r11
        L69:
            int r11 = r9.f2330x
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.f2330x = r11
            float r10 = r10 % r0
            long r1 = r9.f2327u
            long r3 = r9.f2319F
            long r1 = r1 + r3
            r9.f2327u = r1
        L77:
            r3 = 0
        L78:
            boolean r11 = r9.f2329w
            if (r11 == 0) goto L7e
            float r10 = r0 - r10
        L7e:
            r9.mo57055a(r10)
            r5 = r3
        L82:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.animator.p031a.C1331L.mo57139c(long):boolean");
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    public void cancel() {
        ArrayList<AbstractC1334a.InterfaceC1335a> arrayList;
        if (this.f2315B != 0 || f2303j.get().contains(this) || f2304k.get().contains(this)) {
            if (this.f2316C && (arrayList = this.f2333a) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((AbstractC1334a.InterfaceC1335a) it.next()).mo56855c(this);
                }
            }
            m57157D();
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: clone */
    public C1331L mo60089clone() {
        C1331L c1331l = (C1331L) super.mo60089clone();
        ArrayList<InterfaceC1333b> arrayList = this.f2324K;
        if (arrayList != null) {
            c1331l.f2324K = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                c1331l.f2324K.add(arrayList.get(i));
            }
        }
        c1331l.f2328v = -1L;
        c1331l.f2329w = false;
        c1331l.f2330x = 0;
        c1331l.f2318E = false;
        c1331l.f2315B = 0;
        c1331l.f2332z = false;
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr != null) {
            int length = c1320dArr.length;
            c1331l.f2325L = new C1320D[length];
            c1331l.f2326M = new HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                C1320D mo60088clone = c1320dArr[i2].mo60088clone();
                c1331l.f2325L[i2] = mo60088clone;
                c1331l.f2326M.put(mo60088clone.m57173b(), mo60088clone);
            }
        }
        return c1331l;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: d */
    public long mo57096d() {
        return this.f2320G;
    }

    /* renamed from: d */
    public void m57137d(long j) {
        mo57058A();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f2315B != 1) {
            this.f2328v = j;
            this.f2315B = 2;
        }
        this.f2327u = currentAnimationTimeMillis - j;
        mo57139c(currentAnimationTimeMillis);
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: e */
    public boolean mo57094e() {
        return this.f2315B == 1 || this.f2316C;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: f */
    public boolean mo57093f() {
        return this.f2317D;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: j */
    public void mo57038j() {
        m57147a(false);
    }

    /* renamed from: r */
    public float m57127r() {
        return this.f2331y;
    }

    /* renamed from: s */
    public Object m57126s() {
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr == null || c1320dArr.length <= 0) {
            return null;
        }
        return c1320dArr[0].mo57166a();
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f2325L != null) {
            for (int i = 0; i < this.f2325L.length; i++) {
                str = str + "\n    " + this.f2325L[i].toString();
            }
        }
        return str;
    }

    /* renamed from: u */
    public long m57124u() {
        if (!this.f2318E || this.f2315B == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f2327u;
    }

    /* renamed from: w */
    public Interpolator m57122w() {
        return this.f2323J;
    }

    /* renamed from: x */
    public int m57121x() {
        return this.f2321H;
    }

    /* renamed from: y */
    public int m57120y() {
        return this.f2322I;
    }

    /* renamed from: z */
    public C1320D[] m57119z() {
        return this.f2325L;
    }
}
