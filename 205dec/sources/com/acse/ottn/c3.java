package com.acse.ottn;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c3 implements Cloneable {

    /* renamed from: k  reason: collision with root package name */
    public static final f4 f5340k = new q1();

    /* renamed from: l  reason: collision with root package name */
    public static final f4 f5341l = new a1();

    /* renamed from: m  reason: collision with root package name */
    public static Class[] f5342m;

    /* renamed from: n  reason: collision with root package name */
    public static Class[] f5343n;

    /* renamed from: o  reason: collision with root package name */
    public static Class[] f5344o;

    /* renamed from: p  reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f5345p;

    /* renamed from: q  reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f5346q;

    /* renamed from: a  reason: collision with root package name */
    public String f5347a;

    /* renamed from: b  reason: collision with root package name */
    public b3 f5348b;

    /* renamed from: c  reason: collision with root package name */
    public Method f5349c;

    /* renamed from: d  reason: collision with root package name */
    public Method f5350d;

    /* renamed from: e  reason: collision with root package name */
    public Class f5351e;

    /* renamed from: f  reason: collision with root package name */
    public v1 f5352f;

    /* renamed from: g  reason: collision with root package name */
    public final ReentrantReadWriteLock f5353g;

    /* renamed from: h  reason: collision with root package name */
    public final Object[] f5354h;

    /* renamed from: i  reason: collision with root package name */
    public f4 f5355i;

    /* renamed from: j  reason: collision with root package name */
    public Object f5356j;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b extends c3 {

        /* renamed from: r  reason: collision with root package name */
        public d1 f5357r;

        /* renamed from: s  reason: collision with root package name */
        public c1 f5358s;

        /* renamed from: t  reason: collision with root package name */
        public float f5359t;

        public b(String str, c1 c1Var) {
            super(str);
            this.f5351e = Float.TYPE;
            this.f5352f = c1Var;
            this.f5358s = c1Var;
        }

        @Override // com.acse.ottn.c3
        public Object b() {
            return Float.valueOf(this.f5359t);
        }

        @Override // com.acse.ottn.c3
        /* renamed from: e */
        public b clone() {
            b bVar = (b) super.clone();
            bVar.f5358s = (c1) bVar.f5352f;
            return bVar;
        }

        @Override // com.acse.ottn.c3
        public void a(float... fArr) {
            super.a(fArr);
            this.f5358s = (c1) this.f5352f;
        }

        @Override // com.acse.ottn.c3
        public void b(Class cls) {
            if (this.f5348b != null) {
                return;
            }
            super.b(cls);
        }

        @Override // com.acse.ottn.c3
        public void a(float f4) {
            this.f5359t = this.f5358s.b(f4);
        }

        public b(b3 b3Var, c1 c1Var) {
            super(b3Var);
            this.f5351e = Float.TYPE;
            this.f5352f = c1Var;
            this.f5358s = c1Var;
            if (b3Var instanceof d1) {
                this.f5357r = (d1) this.f5348b;
            }
        }

        @Override // com.acse.ottn.c3
        public void a(Object obj) {
            d1 d1Var = this.f5357r;
            if (d1Var != null) {
                d1Var.a((d1) obj, this.f5359t);
                return;
            }
            b3 b3Var = this.f5348b;
            if (b3Var != null) {
                b3Var.a(obj, Float.valueOf(this.f5359t));
            } else if (this.f5349c != null) {
                try {
                    this.f5354h[0] = Float.valueOf(this.f5359t);
                    this.f5349c.invoke(obj, this.f5354h);
                } catch (IllegalAccessException e4) {
                    Log.e("PropertyValuesHolder", e4.toString());
                } catch (InvocationTargetException e5) {
                    Log.e("PropertyValuesHolder", e5.toString());
                }
            }
        }

        public b(String str, float... fArr) {
            super(str);
            a(fArr);
        }

        public b(b3 b3Var, float... fArr) {
            super(b3Var);
            a(fArr);
            if (b3Var instanceof d1) {
                this.f5357r = (d1) this.f5348b;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class c extends c3 {

        /* renamed from: r  reason: collision with root package name */
        public s1 f5360r;

        /* renamed from: s  reason: collision with root package name */
        public r1 f5361s;

        /* renamed from: t  reason: collision with root package name */
        public int f5362t;

        public c(String str, r1 r1Var) {
            super(str);
            this.f5351e = Integer.TYPE;
            this.f5352f = r1Var;
            this.f5361s = r1Var;
        }

        @Override // com.acse.ottn.c3
        public Object b() {
            return Integer.valueOf(this.f5362t);
        }

        @Override // com.acse.ottn.c3
        /* renamed from: e */
        public c clone() {
            c cVar = (c) super.clone();
            cVar.f5361s = (r1) cVar.f5352f;
            return cVar;
        }

        @Override // com.acse.ottn.c3
        public void a(int... iArr) {
            super.a(iArr);
            this.f5361s = (r1) this.f5352f;
        }

        @Override // com.acse.ottn.c3
        public void b(Class cls) {
            if (this.f5348b != null) {
                return;
            }
            super.b(cls);
        }

        @Override // com.acse.ottn.c3
        public void a(float f4) {
            this.f5362t = this.f5361s.b(f4);
        }

        public c(b3 b3Var, r1 r1Var) {
            super(b3Var);
            this.f5351e = Integer.TYPE;
            this.f5352f = r1Var;
            this.f5361s = r1Var;
            if (b3Var instanceof s1) {
                this.f5360r = (s1) this.f5348b;
            }
        }

        @Override // com.acse.ottn.c3
        public void a(Object obj) {
            s1 s1Var = this.f5360r;
            if (s1Var != null) {
                s1Var.a((s1) obj, this.f5362t);
                return;
            }
            b3 b3Var = this.f5348b;
            if (b3Var != null) {
                b3Var.a(obj, Integer.valueOf(this.f5362t));
            } else if (this.f5349c != null) {
                try {
                    this.f5354h[0] = Integer.valueOf(this.f5362t);
                    this.f5349c.invoke(obj, this.f5354h);
                } catch (IllegalAccessException e4) {
                    Log.e("PropertyValuesHolder", e4.toString());
                } catch (InvocationTargetException e5) {
                    Log.e("PropertyValuesHolder", e5.toString());
                }
            }
        }

        public c(String str, int... iArr) {
            super(str);
            a(iArr);
        }

        public c(b3 b3Var, int... iArr) {
            super(b3Var);
            a(iArr);
            if (b3Var instanceof s1) {
                this.f5360r = (s1) this.f5348b;
            }
        }
    }

    static {
        Class cls = Float.TYPE;
        Class cls2 = Double.TYPE;
        Class cls3 = Integer.TYPE;
        f5342m = new Class[]{cls, Float.class, cls2, cls3, Double.class, Integer.class};
        f5343n = new Class[]{cls3, Integer.class, cls, cls2, Float.class, Double.class};
        f5344o = new Class[]{cls2, Double.class, cls, cls3, Float.class, Integer.class};
        f5345p = new HashMap<>();
        f5346q = new HashMap<>();
    }

    public static c3 a(String str, int... iArr) {
        return new c(str, iArr);
    }

    public void b(Class cls) {
        this.f5349c = a(cls, f5345p, f3.f5659h, this.f5351e);
    }

    public void c(Object obj) {
        b3 b3Var = this.f5348b;
        if (b3Var != null) {
            try {
                b3Var.a(obj);
                Iterator<u1> it = this.f5352f.f6909e.iterator();
                while (it.hasNext()) {
                    u1 next = it.next();
                    if (!next.f()) {
                        next.a(this.f5348b.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f5348b.a() + ") on target object " + obj + ". Trying reflection instead");
                this.f5348b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f5349c == null) {
            b((Class) cls);
        }
        Iterator<u1> it2 = this.f5352f.f6909e.iterator();
        while (it2.hasNext()) {
            u1 next2 = it2.next();
            if (!next2.f()) {
                if (this.f5350d == null) {
                    a((Class) cls);
                }
                try {
                    next2.a(this.f5350d.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e4) {
                    Log.e("PropertyValuesHolder", e4.toString());
                } catch (InvocationTargetException e5) {
                    Log.e("PropertyValuesHolder", e5.toString());
                }
            }
        }
    }

    public void d(Object obj) {
        a(obj, this.f5352f.f6909e.get(0));
    }

    public String toString() {
        return this.f5347a + ": " + this.f5352f.toString();
    }

    public static c3 a(b3<?, Integer> b3Var, int... iArr) {
        return new c(b3Var, iArr);
    }

    public void b(Object obj) {
        ArrayList<u1> arrayList = this.f5352f.f6909e;
        a(obj, arrayList.get(arrayList.size() - 1));
    }

    public void d() {
        f4 f4Var;
        if (this.f5355i == null) {
            Class cls = this.f5351e;
            if (cls == Integer.class) {
                f4Var = f5340k;
            } else {
                f4Var = cls == Float.class ? f5341l : null;
            }
            this.f5355i = f4Var;
        }
        f4 f4Var2 = this.f5355i;
        if (f4Var2 != null) {
            this.f5352f.a(f4Var2);
        }
    }

    public c3(String str) {
        this.f5349c = null;
        this.f5350d = null;
        this.f5352f = null;
        this.f5353g = new ReentrantReadWriteLock();
        this.f5354h = new Object[1];
        this.f5347a = str;
    }

    public static c3 a(String str, float... fArr) {
        return new b(str, fArr);
    }

    public Object b() {
        return this.f5356j;
    }

    public static c3 a(b3<?, Float> b3Var, float... fArr) {
        return new b(b3Var, fArr);
    }

    public static c3 a(String str, f4 f4Var, Object... objArr) {
        c3 c3Var = new c3(str);
        c3Var.a(objArr);
        c3Var.a(f4Var);
        return c3Var;
    }

    public static <V> c3 a(b3 b3Var, f4<V> f4Var, V... vArr) {
        c3 c3Var = new c3(b3Var);
        c3Var.a((Object[]) vArr);
        c3Var.a((f4) f4Var);
        return c3Var;
    }

    public c3(b3 b3Var) {
        this.f5349c = null;
        this.f5350d = null;
        this.f5352f = null;
        this.f5353g = new ReentrantReadWriteLock();
        this.f5354h = new Object[1];
        this.f5348b = b3Var;
        if (b3Var != null) {
            this.f5347a = b3Var.a();
        }
    }

    public static c3 a(String str, u1... u1VarArr) {
        v1 a4 = v1.a(u1VarArr);
        if (a4 instanceof r1) {
            return new c(str, (r1) a4);
        }
        if (a4 instanceof c1) {
            return new b(str, (c1) a4);
        }
        c3 c3Var = new c3(str);
        c3Var.f5352f = a4;
        c3Var.f5351e = u1VarArr[0].d();
        return c3Var;
    }

    public String c() {
        return this.f5347a;
    }

    public static c3 a(b3 b3Var, u1... u1VarArr) {
        v1 a4 = v1.a(u1VarArr);
        if (a4 instanceof r1) {
            return new c(b3Var, (r1) a4);
        }
        if (a4 instanceof c1) {
            return new b(b3Var, (c1) a4);
        }
        c3 c3Var = new c3(b3Var);
        c3Var.f5352f = a4;
        c3Var.f5351e = u1VarArr[0].d();
        return c3Var;
    }

    public void a(int... iArr) {
        this.f5351e = Integer.TYPE;
        this.f5352f = v1.a(iArr);
    }

    public void a(float... fArr) {
        this.f5351e = Float.TYPE;
        this.f5352f = v1.a(fArr);
    }

    public void a(u1... u1VarArr) {
        int length = u1VarArr.length;
        u1[] u1VarArr2 = new u1[Math.max(length, 2)];
        this.f5351e = u1VarArr[0].d();
        for (int i4 = 0; i4 < length; i4++) {
            u1VarArr2[i4] = u1VarArr[i4];
        }
        this.f5352f = new v1(u1VarArr2);
    }

    public void a(Object... objArr) {
        this.f5351e = objArr[0].getClass();
        this.f5352f = v1.a(objArr);
    }

    public final Method a(Class cls, String str, Class cls2) {
        Class<?>[] clsArr;
        String a4 = a(str, this.f5347a);
        Method method = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(a4, null);
            } catch (NoSuchMethodException e4) {
                try {
                    method = cls.getDeclaredMethod(a4, null);
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f5347a + ": " + e4);
                }
            }
        } else {
            Class<?>[] clsArr2 = new Class[1];
            if (this.f5351e.equals(Float.class)) {
                clsArr = f5342m;
            } else if (this.f5351e.equals(Integer.class)) {
                clsArr = f5343n;
            } else {
                clsArr = this.f5351e.equals(Double.class) ? f5344o : new Class[]{this.f5351e};
            }
            for (Class<?> cls3 : clsArr) {
                clsArr2[0] = cls3;
                try {
                    try {
                        Method method2 = cls.getMethod(a4, clsArr2);
                        this.f5351e = cls3;
                        return method2;
                    } catch (NoSuchMethodException unused2) {
                    }
                } catch (NoSuchMethodException unused3) {
                    method = cls.getDeclaredMethod(a4, clsArr2);
                    method.setAccessible(true);
                    this.f5351e = cls3;
                    return method;
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f5347a + " with value type " + this.f5351e);
        }
        return method;
    }

    public final Method a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.f5353g.writeLock().lock();
            HashMap<String, Method> hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? hashMap2.get(this.f5347a) : null;
            if (method == null) {
                method = a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f5347a, method);
            }
            return method;
        } finally {
            this.f5353g.writeLock().unlock();
        }
    }

    public final void a(Class cls) {
        this.f5350d = a(cls, f5346q, f3.f5657f, null);
    }

    public final void a(Object obj, u1 u1Var) {
        b3 b3Var = this.f5348b;
        if (b3Var != null) {
            u1Var.a(b3Var.a(obj));
        }
        try {
            if (this.f5350d == null) {
                a((Class) obj.getClass());
            }
            u1Var.a(this.f5350d.invoke(obj, new Object[0]));
        } catch (IllegalAccessException e4) {
            Log.e("PropertyValuesHolder", e4.toString());
        } catch (InvocationTargetException e5) {
            Log.e("PropertyValuesHolder", e5.toString());
        }
    }

    @Override // 
    /* renamed from: a */
    public c3 clone() {
        try {
            c3 c3Var = (c3) super.clone();
            c3Var.f5347a = this.f5347a;
            c3Var.f5348b = this.f5348b;
            c3Var.f5352f = this.f5352f.clone();
            c3Var.f5355i = this.f5355i;
            return c3Var;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void a(Object obj) {
        b3 b3Var = this.f5348b;
        if (b3Var != null) {
            b3Var.a(obj, b());
        }
        if (this.f5349c != null) {
            try {
                this.f5354h[0] = b();
                this.f5349c.invoke(obj, this.f5354h);
            } catch (IllegalAccessException e4) {
                Log.e("PropertyValuesHolder", e4.toString());
            } catch (InvocationTargetException e5) {
                Log.e("PropertyValuesHolder", e5.toString());
            }
        }
    }

    public void a(f4 f4Var) {
        this.f5355i = f4Var;
        this.f5352f.a(f4Var);
    }

    public void a(float f4) {
        this.f5356j = this.f5352f.a(f4);
    }

    public void a(String str) {
        this.f5347a = str;
    }

    public void a(b3 b3Var) {
        this.f5348b = b3Var;
    }

    public static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }
}
