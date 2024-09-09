package com.acse.ottn;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class p2 extends g4 {
    public static final boolean Q = false;
    public static final Map<String, b3> R;
    public Object N;
    public String O;
    public b3 P;

    static {
        HashMap hashMap = new HashMap();
        R = hashMap;
        hashMap.put("alpha", z2.f7011a);
        hashMap.put("pivotX", z2.f7012b);
        hashMap.put("pivotY", z2.f7013c);
        hashMap.put("translationX", z2.f7014d);
        hashMap.put("translationY", z2.f7015e);
        hashMap.put("rotation", z2.f7016f);
        hashMap.put("rotationX", z2.f7017g);
        hashMap.put("rotationY", z2.f7018h);
        hashMap.put("scaleX", z2.f7019i);
        hashMap.put("scaleY", z2.f7020j);
        hashMap.put("scrollX", z2.f7021k);
        hashMap.put("scrollY", z2.f7022l);
        hashMap.put("x", z2.f7023m);
        hashMap.put("y", z2.f7024n);
    }

    public p2() {
    }

    @Override // com.acse.ottn.g4
    public void D() {
        if (this.f5698l) {
            return;
        }
        if (this.P == null && l.f5841q && (this.N instanceof View)) {
            Map<String, b3> map = R;
            if (map.containsKey(this.O)) {
                a(map.get(this.O));
            }
        }
        int length = this.f5705s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f5705s[i4].c(this.N);
        }
        super.D();
    }

    @Override // com.acse.ottn.g4
    /* renamed from: H */
    public p2 s() {
        return (p2) super.clone();
    }

    public String I() {
        return this.O;
    }

    public Object J() {
        return this.N;
    }

    public void b(String str) {
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr != null) {
            c3 c3Var = c3VarArr[0];
            String c4 = c3Var.c();
            c3Var.a(str);
            this.f5706t.remove(c4);
            this.f5706t.put(str, c3Var);
        }
        this.O = str;
        this.f5698l = false;
    }

    @Override // com.acse.ottn.g4
    /* renamed from: h */
    public p2 f(long j4) {
        super.a(j4);
        return this;
    }

    @Override // com.acse.ottn.i
    public void i() {
        D();
        int length = this.f5705s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f5705s[i4].b(this.N);
        }
    }

    @Override // com.acse.ottn.i
    public void j() {
        D();
        int length = this.f5705s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f5705s[i4].d(this.N);
        }
    }

    @Override // com.acse.ottn.g4, com.acse.ottn.i
    public void k() {
        super.k();
    }

    @Override // com.acse.ottn.g4
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.N;
        if (this.f5705s != null) {
            for (int i4 = 0; i4 < this.f5705s.length; i4++) {
                str = str + "\n    " + this.f5705s[i4].toString();
            }
        }
        return str;
    }

    public p2(Object obj, String str) {
        this.N = obj;
        b(str);
    }

    public void a(b3 b3Var) {
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr != null) {
            c3 c3Var = c3VarArr[0];
            String c4 = c3Var.c();
            c3Var.a(b3Var);
            this.f5706t.remove(c4);
            this.f5706t.put(this.O, c3Var);
        }
        if (this.P != null) {
            this.O = b3Var.a();
        }
        this.P = b3Var;
        this.f5698l = false;
    }

    public <T> p2(T t3, b3<T, ?> b3Var) {
        this.N = t3;
        a((b3) b3Var);
    }

    @Override // com.acse.ottn.g4
    public void b(int... iArr) {
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr != null && c3VarArr.length != 0) {
            super.b(iArr);
            return;
        }
        b3 b3Var = this.P;
        if (b3Var != null) {
            b(c3.a((b3<?, Integer>) b3Var, iArr));
        } else {
            b(c3.a(this.O, iArr));
        }
    }

    public static p2 a(Object obj, String str, int... iArr) {
        p2 p2Var = new p2(obj, str);
        p2Var.b(iArr);
        return p2Var;
    }

    @Override // com.acse.ottn.g4
    public void b(float... fArr) {
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr != null && c3VarArr.length != 0) {
            super.b(fArr);
            return;
        }
        b3 b3Var = this.P;
        if (b3Var != null) {
            b(c3.a(b3Var, fArr));
        } else {
            b(c3.a(this.O, fArr));
        }
    }

    public static <T> p2 a(T t3, b3<T, Integer> b3Var, int... iArr) {
        p2 p2Var = new p2(t3, b3Var);
        p2Var.b(iArr);
        return p2Var;
    }

    public static p2 a(Object obj, String str, float... fArr) {
        p2 p2Var = new p2(obj, str);
        p2Var.b(fArr);
        return p2Var;
    }

    public static <T> p2 a(T t3, b3<T, Float> b3Var, float... fArr) {
        p2 p2Var = new p2(t3, b3Var);
        p2Var.b(fArr);
        return p2Var;
    }

    public static p2 a(Object obj, String str, f4 f4Var, Object... objArr) {
        p2 p2Var = new p2(obj, str);
        p2Var.a(objArr);
        p2Var.a(f4Var);
        return p2Var;
    }

    public static <T, V> p2 a(T t3, b3<T, V> b3Var, f4<V> f4Var, V... vArr) {
        p2 p2Var = new p2(t3, b3Var);
        p2Var.a((Object[]) vArr);
        p2Var.a((f4) f4Var);
        return p2Var;
    }

    public static p2 a(Object obj, c3... c3VarArr) {
        p2 p2Var = new p2();
        p2Var.N = obj;
        p2Var.b(c3VarArr);
        return p2Var;
    }

    @Override // com.acse.ottn.g4
    public void a(Object... objArr) {
        c3[] c3VarArr = this.f5705s;
        if (c3VarArr != null && c3VarArr.length != 0) {
            super.a(objArr);
            return;
        }
        b3 b3Var = this.P;
        if (b3Var != null) {
            b(c3.a(b3Var, (f4) null, objArr));
        } else {
            b(c3.a(this.O, (f4) null, objArr));
        }
    }

    @Override // com.acse.ottn.i
    public void a(Object obj) {
        Object obj2 = this.N;
        if (obj2 != obj) {
            this.N = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.f5698l = false;
            }
        }
    }

    @Override // com.acse.ottn.g4
    public void a(float f4) {
        super.a(f4);
        int length = this.f5705s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f5705s[i4].a(this.N);
        }
    }
}
