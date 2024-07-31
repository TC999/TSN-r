package com.acse.ottn.animator.p031a;

import android.view.View;
import com.acse.ottn.animator.p032b.AbstractC1373d;
import com.acse.ottn.animator.p033c.p034a.C1378a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.acse.ottn.animator.a.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C1355m extends C1331L {

    /* renamed from: N */
    private static final boolean f2401N = false;

    /* renamed from: O */
    private static final Map<String, AbstractC1373d> f2402O;

    /* renamed from: P */
    private Object f2403P;

    /* renamed from: Q */
    private String f2404Q;

    /* renamed from: R */
    private AbstractC1373d f2405R;

    static {
        HashMap hashMap = new HashMap();
        f2402O = hashMap;
        hashMap.put("alpha", C1318B.f2256a);
        hashMap.put("pivotX", C1318B.f2257b);
        hashMap.put("pivotY", C1318B.f2258c);
        hashMap.put("translationX", C1318B.f2259d);
        hashMap.put("translationY", C1318B.f2260e);
        hashMap.put("rotation", C1318B.f2261f);
        hashMap.put("rotationX", C1318B.f2262g);
        hashMap.put("rotationY", C1318B.f2263h);
        hashMap.put("scaleX", C1318B.f2264i);
        hashMap.put("scaleY", C1318B.f2265j);
        hashMap.put("scrollX", C1318B.f2266k);
        hashMap.put("scrollY", C1318B.f2267l);
        hashMap.put("x", C1318B.f2268m);
        hashMap.put("y", C1318B.f2269n);
    }

    public C1355m() {
    }

    private <T> C1355m(T t, AbstractC1373d<T, ?> abstractC1373d) {
        this.f2403P = t;
        m57053a((AbstractC1373d) abstractC1373d);
    }

    private C1355m(Object obj, String str) {
        this.f2403P = obj;
        m57043b(str);
    }

    /* renamed from: a */
    public static <T, V> C1355m m57051a(T t, AbstractC1373d<T, V> abstractC1373d, InterfaceC1325F<V> interfaceC1325F, V... vArr) {
        C1355m c1355m = new C1355m(t, abstractC1373d);
        c1355m.mo57044a((Object[]) vArr);
        c1355m.m57154a((InterfaceC1325F) interfaceC1325F);
        return c1355m;
    }

    /* renamed from: a */
    public static <T> C1355m m57050a(T t, AbstractC1373d<T, Float> abstractC1373d, float... fArr) {
        C1355m c1355m = new C1355m(t, abstractC1373d);
        c1355m.mo57042b(fArr);
        return c1355m;
    }

    /* renamed from: a */
    public static <T> C1355m m57049a(T t, AbstractC1373d<T, Integer> abstractC1373d, int... iArr) {
        C1355m c1355m = new C1355m(t, abstractC1373d);
        c1355m.mo57041b(iArr);
        return c1355m;
    }

    /* renamed from: a */
    public static C1355m m57048a(Object obj, String str, InterfaceC1325F interfaceC1325F, Object... objArr) {
        C1355m c1355m = new C1355m(obj, str);
        c1355m.mo57044a(objArr);
        c1355m.m57154a(interfaceC1325F);
        return c1355m;
    }

    /* renamed from: a */
    public static C1355m m57047a(Object obj, String str, float... fArr) {
        C1355m c1355m = new C1355m(obj, str);
        c1355m.mo57042b(fArr);
        return c1355m;
    }

    /* renamed from: a */
    public static C1355m m57046a(Object obj, String str, int... iArr) {
        C1355m c1355m = new C1355m(obj, str);
        c1355m.mo57041b(iArr);
        return c1355m;
    }

    /* renamed from: a */
    public static C1355m m57045a(Object obj, C1320D... c1320dArr) {
        C1355m c1355m = new C1355m();
        c1355m.f2403P = obj;
        c1355m.m57140b(c1320dArr);
        return c1355m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.acse.ottn.animator.p031a.C1331L
    /* renamed from: A */
    public void mo57058A() {
        if (this.f2318E) {
            return;
        }
        if (this.f2405R == null && C1378a.f2416a && (this.f2403P instanceof View)) {
            Map<String, AbstractC1373d> map = f2402O;
            if (map.containsKey(this.f2404Q)) {
                m57053a(map.get(this.f2404Q));
            }
        }
        int length = this.f2325L.length;
        for (int i = 0; i < length; i++) {
            this.f2325L[i].m57169c(this.f2403P);
        }
        super.mo57058A();
    }

    /* renamed from: D */
    public String m57057D() {
        return this.f2404Q;
    }

    /* renamed from: E */
    public Object m57056E() {
        return this.f2403P;
    }

    @Override // com.acse.ottn.animator.p031a.C1331L, com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public C1355m mo57054a(long j) {
        super.mo57054a(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.acse.ottn.animator.p031a.C1331L
    /* renamed from: a */
    public void mo57055a(float f) {
        super.mo57055a(f);
        int length = this.f2325L.length;
        for (int i = 0; i < length; i++) {
            this.f2325L[i].mo57163a(this.f2403P);
        }
    }

    /* renamed from: a */
    public void m57053a(AbstractC1373d abstractC1373d) {
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr != null) {
            C1320D c1320d = c1320dArr[0];
            String m57173b = c1320d.m57173b();
            c1320d.m57189a(abstractC1373d);
            this.f2326M.remove(m57173b);
            this.f2326M.put(this.f2404Q, c1320d);
        }
        if (this.f2405R != null) {
            this.f2404Q = abstractC1373d.m57007a();
        }
        this.f2405R = abstractC1373d;
        this.f2318E = false;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public void mo57052a(Object obj) {
        Object obj2 = this.f2403P;
        if (obj2 != obj) {
            this.f2403P = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.f2318E = false;
            }
        }
    }

    @Override // com.acse.ottn.animator.p031a.C1331L
    /* renamed from: a */
    public void mo57044a(Object... objArr) {
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr != null && c1320dArr.length != 0) {
            super.mo57044a(objArr);
            return;
        }
        AbstractC1373d abstractC1373d = this.f2405R;
        if (abstractC1373d != null) {
            m57140b(C1320D.m57188a(abstractC1373d, (InterfaceC1325F) null, objArr));
        } else {
            m57140b(C1320D.m57180a(this.f2404Q, (InterfaceC1325F) null, objArr));
        }
    }

    /* renamed from: b */
    public void m57043b(String str) {
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr != null) {
            C1320D c1320d = c1320dArr[0];
            String m57173b = c1320d.m57173b();
            c1320d.m57181a(str);
            this.f2326M.remove(m57173b);
            this.f2326M.put(str, c1320d);
        }
        this.f2404Q = str;
        this.f2318E = false;
    }

    @Override // com.acse.ottn.animator.p031a.C1331L
    /* renamed from: b */
    public void mo57042b(float... fArr) {
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr != null && c1320dArr.length != 0) {
            super.mo57042b(fArr);
            return;
        }
        AbstractC1373d abstractC1373d = this.f2405R;
        if (abstractC1373d != null) {
            m57140b(C1320D.m57187a(abstractC1373d, fArr));
        } else {
            m57140b(C1320D.m57178a(this.f2404Q, fArr));
        }
    }

    @Override // com.acse.ottn.animator.p031a.C1331L
    /* renamed from: b */
    public void mo57041b(int... iArr) {
        C1320D[] c1320dArr = this.f2325L;
        if (c1320dArr != null && c1320dArr.length != 0) {
            super.mo57041b(iArr);
            return;
        }
        AbstractC1373d abstractC1373d = this.f2405R;
        if (abstractC1373d != null) {
            m57140b(C1320D.m57186a((AbstractC1373d<?, Integer>) abstractC1373d, iArr));
        } else {
            m57140b(C1320D.m57177a(this.f2404Q, iArr));
        }
    }

    @Override // com.acse.ottn.animator.p031a.C1331L, com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: clone */
    public C1355m mo60089clone() {
        return (C1355m) super.mo60089clone();
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: h */
    public void mo57040h() {
        mo57058A();
        int length = this.f2325L.length;
        for (int i = 0; i < length; i++) {
            this.f2325L[i].m57171b(this.f2403P);
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: i */
    public void mo57039i() {
        mo57058A();
        int length = this.f2325L.length;
        for (int i = 0; i < length; i++) {
            this.f2325L[i].m57168d(this.f2403P);
        }
    }

    @Override // com.acse.ottn.animator.p031a.C1331L, com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: j */
    public void mo57038j() {
        super.mo57038j();
    }

    @Override // com.acse.ottn.animator.p031a.C1331L
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f2403P;
        if (this.f2325L != null) {
            for (int i = 0; i < this.f2325L.length; i++) {
                str = str + "\n    " + this.f2325L[i].toString();
            }
        }
        return str;
    }
}
