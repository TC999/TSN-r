package com.acse.ottn.animator.a;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class m extends L {
    private static final boolean N = false;
    private static final Map<String, com.acse.ottn.animator.b.d> O;
    private Object P;
    private String Q;
    private com.acse.ottn.animator.b.d R;

    static {
        HashMap hashMap = new HashMap();
        O = hashMap;
        hashMap.put("alpha", B.f4817a);
        hashMap.put("pivotX", B.f4818b);
        hashMap.put("pivotY", B.f4819c);
        hashMap.put("translationX", B.f4820d);
        hashMap.put("translationY", B.f4821e);
        hashMap.put("rotation", B.f4822f);
        hashMap.put("rotationX", B.f4823g);
        hashMap.put("rotationY", B.f4824h);
        hashMap.put("scaleX", B.f4825i);
        hashMap.put("scaleY", B.f4826j);
        hashMap.put("scrollX", B.f4827k);
        hashMap.put("scrollY", B.f4828l);
        hashMap.put("x", B.f4829m);
        hashMap.put("y", B.f4830n);
    }

    public m() {
    }

    private <T> m(T t3, com.acse.ottn.animator.b.d<T, ?> dVar) {
        this.P = t3;
        a((com.acse.ottn.animator.b.d) dVar);
    }

    private m(Object obj, String str) {
        this.P = obj;
        b(str);
    }

    public static <T, V> m a(T t3, com.acse.ottn.animator.b.d<T, V> dVar, F<V> f4, V... vArr) {
        m mVar = new m(t3, dVar);
        mVar.a((Object[]) vArr);
        mVar.a((F) f4);
        return mVar;
    }

    public static <T> m a(T t3, com.acse.ottn.animator.b.d<T, Float> dVar, float... fArr) {
        m mVar = new m(t3, dVar);
        mVar.b(fArr);
        return mVar;
    }

    public static <T> m a(T t3, com.acse.ottn.animator.b.d<T, Integer> dVar, int... iArr) {
        m mVar = new m(t3, dVar);
        mVar.b(iArr);
        return mVar;
    }

    public static m a(Object obj, String str, F f4, Object... objArr) {
        m mVar = new m(obj, str);
        mVar.a(objArr);
        mVar.a(f4);
        return mVar;
    }

    public static m a(Object obj, String str, float... fArr) {
        m mVar = new m(obj, str);
        mVar.b(fArr);
        return mVar;
    }

    public static m a(Object obj, String str, int... iArr) {
        m mVar = new m(obj, str);
        mVar.b(iArr);
        return mVar;
    }

    public static m a(Object obj, D... dArr) {
        m mVar = new m();
        mVar.P = obj;
        mVar.b(dArr);
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.acse.ottn.animator.a.L
    public void A() {
        if (this.E) {
            return;
        }
        if (this.R == null && com.acse.ottn.animator.c.a.a.f4958a && (this.P instanceof View)) {
            Map<String, com.acse.ottn.animator.b.d> map = O;
            if (map.containsKey(this.Q)) {
                a(map.get(this.Q));
            }
        }
        int length = this.f4873L.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f4873L[i4].c(this.P);
        }
        super.A();
    }

    public String D() {
        return this.Q;
    }

    public Object E() {
        return this.P;
    }

    @Override // com.acse.ottn.animator.a.L, com.acse.ottn.animator.a.AbstractC1361a
    public m a(long j4) {
        super.a(j4);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.acse.ottn.animator.a.L
    public void a(float f4) {
        super.a(f4);
        int length = this.f4873L.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f4873L[i4].a(this.P);
        }
    }

    public void a(com.acse.ottn.animator.b.d dVar) {
        D[] dArr = this.f4873L;
        if (dArr != null) {
            D d4 = dArr[0];
            String b4 = d4.b();
            d4.a(dVar);
            this.M.remove(b4);
            this.M.put(this.Q, d4);
        }
        if (this.R != null) {
            this.Q = dVar.a();
        }
        this.R = dVar;
        this.E = false;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void a(Object obj) {
        Object obj2 = this.P;
        if (obj2 != obj) {
            this.P = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.E = false;
            }
        }
    }

    @Override // com.acse.ottn.animator.a.L
    public void a(Object... objArr) {
        D[] dArr = this.f4873L;
        if (dArr != null && dArr.length != 0) {
            super.a(objArr);
            return;
        }
        com.acse.ottn.animator.b.d dVar = this.R;
        if (dVar != null) {
            b(D.a(dVar, (F) null, objArr));
        } else {
            b(D.a(this.Q, (F) null, objArr));
        }
    }

    public void b(String str) {
        D[] dArr = this.f4873L;
        if (dArr != null) {
            D d4 = dArr[0];
            String b4 = d4.b();
            d4.a(str);
            this.M.remove(b4);
            this.M.put(str, d4);
        }
        this.Q = str;
        this.E = false;
    }

    @Override // com.acse.ottn.animator.a.L
    public void b(float... fArr) {
        D[] dArr = this.f4873L;
        if (dArr != null && dArr.length != 0) {
            super.b(fArr);
            return;
        }
        com.acse.ottn.animator.b.d dVar = this.R;
        if (dVar != null) {
            b(D.a(dVar, fArr));
        } else {
            b(D.a(this.Q, fArr));
        }
    }

    @Override // com.acse.ottn.animator.a.L
    public void b(int... iArr) {
        D[] dArr = this.f4873L;
        if (dArr != null && dArr.length != 0) {
            super.b(iArr);
            return;
        }
        com.acse.ottn.animator.b.d dVar = this.R;
        if (dVar != null) {
            b(D.a((com.acse.ottn.animator.b.d<?, Integer>) dVar, iArr));
        } else {
            b(D.a(this.Q, iArr));
        }
    }

    @Override // com.acse.ottn.animator.a.L, com.acse.ottn.animator.a.AbstractC1361a
    /* renamed from: clone */
    public m mo10clone() {
        return (m) super.mo10clone();
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void h() {
        A();
        int length = this.f4873L.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f4873L[i4].b(this.P);
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void i() {
        A();
        int length = this.f4873L.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f4873L[i4].d(this.P);
        }
    }

    @Override // com.acse.ottn.animator.a.L, com.acse.ottn.animator.a.AbstractC1361a
    public void j() {
        super.j();
    }

    @Override // com.acse.ottn.animator.a.L
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.P;
        if (this.f4873L != null) {
            for (int i4 = 0; i4 < this.f4873L.length; i4++) {
                str = str + "\n    " + this.f4873L[i4].toString();
            }
        }
        return str;
    }
}
