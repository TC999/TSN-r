package com.acse.ottn.animator.a;

import android.util.Log;
import com.acse.ottn.f3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class D implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final F f4831a = new C1369i();

    /* renamed from: b  reason: collision with root package name */
    private static final F f4832b = new C1367g();

    /* renamed from: c  reason: collision with root package name */
    private static Class[] f4833c;

    /* renamed from: d  reason: collision with root package name */
    private static Class[] f4834d;

    /* renamed from: e  reason: collision with root package name */
    private static Class[] f4835e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<Class, HashMap<String, Method>> f4836f;

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<Class, HashMap<String, Method>> f4837g;

    /* renamed from: h  reason: collision with root package name */
    String f4838h;

    /* renamed from: i  reason: collision with root package name */
    protected com.acse.ottn.animator.b.d f4839i;

    /* renamed from: j  reason: collision with root package name */
    Method f4840j;

    /* renamed from: k  reason: collision with root package name */
    private Method f4841k;

    /* renamed from: l  reason: collision with root package name */
    Class f4842l;

    /* renamed from: m  reason: collision with root package name */
    C1372l f4843m;

    /* renamed from: n  reason: collision with root package name */
    final ReentrantReadWriteLock f4844n;

    /* renamed from: o  reason: collision with root package name */
    final Object[] f4845o;

    /* renamed from: p  reason: collision with root package name */
    private F f4846p;

    /* renamed from: q  reason: collision with root package name */
    private Object f4847q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a extends D {

        /* renamed from: r  reason: collision with root package name */
        private com.acse.ottn.animator.b.a f4848r;

        /* renamed from: s  reason: collision with root package name */
        C1368h f4849s;

        /* renamed from: t  reason: collision with root package name */
        float f4850t;

        public a(com.acse.ottn.animator.b.d dVar, C1368h c1368h) {
            super(dVar);
            this.f4842l = Float.TYPE;
            this.f4843m = c1368h;
            this.f4849s = c1368h;
            if (dVar instanceof com.acse.ottn.animator.b.a) {
                this.f4848r = (com.acse.ottn.animator.b.a) this.f4839i;
            }
        }

        public a(com.acse.ottn.animator.b.d dVar, float... fArr) {
            super(dVar);
            a(fArr);
            if (dVar instanceof com.acse.ottn.animator.b.a) {
                this.f4848r = (com.acse.ottn.animator.b.a) this.f4839i;
            }
        }

        public a(String str, C1368h c1368h) {
            super(str);
            this.f4842l = Float.TYPE;
            this.f4843m = c1368h;
            this.f4849s = c1368h;
        }

        public a(String str, float... fArr) {
            super(str);
            a(fArr);
        }

        @Override // com.acse.ottn.animator.a.D
        Object a() {
            return Float.valueOf(this.f4850t);
        }

        @Override // com.acse.ottn.animator.a.D
        void a(float f4) {
            this.f4850t = this.f4849s.b(f4);
        }

        @Override // com.acse.ottn.animator.a.D
        void a(Class cls) {
            if (this.f4839i != null) {
                return;
            }
            super.a(cls);
        }

        @Override // com.acse.ottn.animator.a.D
        void a(Object obj) {
            String invocationTargetException;
            com.acse.ottn.animator.b.a aVar = this.f4848r;
            if (aVar != null) {
                aVar.a((com.acse.ottn.animator.b.a) obj, this.f4850t);
                return;
            }
            com.acse.ottn.animator.b.d dVar = this.f4839i;
            if (dVar != null) {
                dVar.a(obj, Float.valueOf(this.f4850t));
            } else if (this.f4840j != null) {
                try {
                    this.f4845o[0] = Float.valueOf(this.f4850t);
                    this.f4840j.invoke(obj, this.f4845o);
                } catch (IllegalAccessException e4) {
                    invocationTargetException = e4.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                } catch (InvocationTargetException e5) {
                    invocationTargetException = e5.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                }
            }
        }

        @Override // com.acse.ottn.animator.a.D
        public void a(float... fArr) {
            super.a(fArr);
            this.f4849s = (C1368h) this.f4843m;
        }

        @Override // com.acse.ottn.animator.a.D
        /* renamed from: clone */
        public a mo9clone() {
            a aVar = (a) super.mo9clone();
            aVar.f4849s = (C1368h) aVar.f4843m;
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b extends D {

        /* renamed from: r  reason: collision with root package name */
        private com.acse.ottn.animator.b.b f4851r;

        /* renamed from: s  reason: collision with root package name */
        C1370j f4852s;

        /* renamed from: t  reason: collision with root package name */
        int f4853t;

        public b(com.acse.ottn.animator.b.d dVar, C1370j c1370j) {
            super(dVar);
            this.f4842l = Integer.TYPE;
            this.f4843m = c1370j;
            this.f4852s = c1370j;
            if (dVar instanceof com.acse.ottn.animator.b.b) {
                this.f4851r = (com.acse.ottn.animator.b.b) this.f4839i;
            }
        }

        public b(com.acse.ottn.animator.b.d dVar, int... iArr) {
            super(dVar);
            a(iArr);
            if (dVar instanceof com.acse.ottn.animator.b.b) {
                this.f4851r = (com.acse.ottn.animator.b.b) this.f4839i;
            }
        }

        public b(String str, C1370j c1370j) {
            super(str);
            this.f4842l = Integer.TYPE;
            this.f4843m = c1370j;
            this.f4852s = c1370j;
        }

        public b(String str, int... iArr) {
            super(str);
            a(iArr);
        }

        @Override // com.acse.ottn.animator.a.D
        Object a() {
            return Integer.valueOf(this.f4853t);
        }

        @Override // com.acse.ottn.animator.a.D
        void a(float f4) {
            this.f4853t = this.f4852s.b(f4);
        }

        @Override // com.acse.ottn.animator.a.D
        void a(Class cls) {
            if (this.f4839i != null) {
                return;
            }
            super.a(cls);
        }

        @Override // com.acse.ottn.animator.a.D
        void a(Object obj) {
            String invocationTargetException;
            com.acse.ottn.animator.b.b bVar = this.f4851r;
            if (bVar != null) {
                bVar.a((com.acse.ottn.animator.b.b) obj, this.f4853t);
                return;
            }
            com.acse.ottn.animator.b.d dVar = this.f4839i;
            if (dVar != null) {
                dVar.a(obj, Integer.valueOf(this.f4853t));
            } else if (this.f4840j != null) {
                try {
                    this.f4845o[0] = Integer.valueOf(this.f4853t);
                    this.f4840j.invoke(obj, this.f4845o);
                } catch (IllegalAccessException e4) {
                    invocationTargetException = e4.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                } catch (InvocationTargetException e5) {
                    invocationTargetException = e5.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                }
            }
        }

        @Override // com.acse.ottn.animator.a.D
        public void a(int... iArr) {
            super.a(iArr);
            this.f4852s = (C1370j) this.f4843m;
        }

        @Override // com.acse.ottn.animator.a.D
        /* renamed from: clone */
        public b mo9clone() {
            b bVar = (b) super.mo9clone();
            bVar.f4852s = (C1370j) bVar.f4843m;
            return bVar;
        }
    }

    static {
        Class cls = Float.TYPE;
        Class cls2 = Double.TYPE;
        Class cls3 = Integer.TYPE;
        f4833c = new Class[]{cls, Float.class, cls2, cls3, Double.class, Integer.class};
        f4834d = new Class[]{cls3, Integer.class, cls, cls2, Float.class, Double.class};
        f4835e = new Class[]{cls2, Double.class, cls, cls3, Float.class, Integer.class};
        f4836f = new HashMap<>();
        f4837g = new HashMap<>();
    }

    private D(com.acse.ottn.animator.b.d dVar) {
        this.f4840j = null;
        this.f4841k = null;
        this.f4843m = null;
        this.f4844n = new ReentrantReadWriteLock();
        this.f4845o = new Object[1];
        this.f4839i = dVar;
        if (dVar != null) {
            this.f4838h = dVar.a();
        }
    }

    private D(String str) {
        this.f4840j = null;
        this.f4841k = null;
        this.f4843m = null;
        this.f4844n = new ReentrantReadWriteLock();
        this.f4845o = new Object[1];
        this.f4838h = str;
    }

    public static <V> D a(com.acse.ottn.animator.b.d dVar, F<V> f4, V... vArr) {
        D d4 = new D(dVar);
        d4.a((Object[]) vArr);
        d4.a((F) f4);
        return d4;
    }

    public static D a(com.acse.ottn.animator.b.d<?, Float> dVar, float... fArr) {
        return new a(dVar, fArr);
    }

    public static D a(com.acse.ottn.animator.b.d<?, Integer> dVar, int... iArr) {
        return new b(dVar, iArr);
    }

    public static D a(com.acse.ottn.animator.b.d dVar, AbstractC1371k... abstractC1371kArr) {
        C1372l a4 = C1372l.a(abstractC1371kArr);
        if (a4 instanceof C1370j) {
            return new b(dVar, (C1370j) a4);
        }
        if (a4 instanceof C1368h) {
            return new a(dVar, (C1368h) a4);
        }
        D d4 = new D(dVar);
        d4.f4843m = a4;
        d4.f4842l = abstractC1371kArr[0].c();
        return d4;
    }

    public static D a(String str, F f4, Object... objArr) {
        D d4 = new D(str);
        d4.a(objArr);
        d4.a(f4);
        return d4;
    }

    public static D a(String str, float... fArr) {
        return new a(str, fArr);
    }

    public static D a(String str, int... iArr) {
        return new b(str, iArr);
    }

    public static D a(String str, AbstractC1371k... abstractC1371kArr) {
        C1372l a4 = C1372l.a(abstractC1371kArr);
        if (a4 instanceof C1370j) {
            return new b(str, (C1370j) a4);
        }
        if (a4 instanceof C1368h) {
            return new a(str, (C1368h) a4);
        }
        D d4 = new D(str);
        d4.f4843m = a4;
        d4.f4842l = abstractC1371kArr[0].c();
        return d4;
    }

    static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }

    private Method a(Class cls, String str, Class cls2) {
        StringBuilder sb;
        Class<?>[] clsArr;
        String a4 = a(str, this.f4838h);
        Method method = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(a4, null);
            } catch (NoSuchMethodException e4) {
                try {
                    method = cls.getDeclaredMethod(a4, null);
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    sb = new StringBuilder();
                    sb.append("Couldn't find no-arg method for property ");
                    sb.append(this.f4838h);
                    sb.append(": ");
                    sb.append(e4);
                }
            }
        } else {
            Class<?>[] clsArr2 = new Class[1];
            for (Class<?> cls3 : this.f4842l.equals(Float.class) ? f4833c : this.f4842l.equals(Integer.class) ? f4834d : this.f4842l.equals(Double.class) ? f4835e : new Class[]{this.f4842l}) {
                clsArr2[0] = cls3;
                try {
                    try {
                        Method method2 = cls.getMethod(a4, clsArr2);
                        this.f4842l = cls3;
                        return method2;
                    } catch (NoSuchMethodException unused2) {
                        method = cls.getDeclaredMethod(a4, clsArr2);
                        method.setAccessible(true);
                        this.f4842l = cls3;
                        return method;
                    }
                } catch (NoSuchMethodException unused3) {
                }
            }
            sb = new StringBuilder();
            sb.append("Couldn't find setter/getter for property ");
            sb.append(this.f4838h);
            sb.append(" with value type ");
            sb.append(this.f4842l);
        }
        Log.e("PropertyValuesHolder", sb.toString());
        return method;
    }

    private Method a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.f4844n.writeLock().lock();
            HashMap<String, Method> hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? hashMap2.get(this.f4838h) : null;
            if (method == null) {
                method = a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f4838h, method);
            }
            return method;
        } finally {
            this.f4844n.writeLock().unlock();
        }
    }

    private void a(Object obj, AbstractC1371k abstractC1371k) {
        String invocationTargetException;
        com.acse.ottn.animator.b.d dVar = this.f4839i;
        if (dVar != null) {
            abstractC1371k.a(dVar.a(obj));
        }
        try {
            if (this.f4841k == null) {
                b((Class) obj.getClass());
            }
            abstractC1371k.a(this.f4841k.invoke(obj, new Object[0]));
        } catch (IllegalAccessException e4) {
            invocationTargetException = e4.toString();
            Log.e("PropertyValuesHolder", invocationTargetException);
        } catch (InvocationTargetException e5) {
            invocationTargetException = e5.toString();
            Log.e("PropertyValuesHolder", invocationTargetException);
        }
    }

    private void b(Class cls) {
        this.f4841k = a(cls, f4837g, f3.f5657f, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a() {
        return this.f4847q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f4) {
        this.f4847q = this.f4843m.a(f4);
    }

    public void a(F f4) {
        this.f4846p = f4;
        this.f4843m.a(f4);
    }

    public void a(com.acse.ottn.animator.b.d dVar) {
        this.f4839i = dVar;
    }

    void a(Class cls) {
        this.f4840j = a(cls, f4836f, f3.f5659h, this.f4842l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        String invocationTargetException;
        com.acse.ottn.animator.b.d dVar = this.f4839i;
        if (dVar != null) {
            dVar.a(obj, a());
        }
        if (this.f4840j != null) {
            try {
                this.f4845o[0] = a();
                this.f4840j.invoke(obj, this.f4845o);
            } catch (IllegalAccessException e4) {
                invocationTargetException = e4.toString();
                Log.e("PropertyValuesHolder", invocationTargetException);
            } catch (InvocationTargetException e5) {
                invocationTargetException = e5.toString();
                Log.e("PropertyValuesHolder", invocationTargetException);
            }
        }
    }

    public void a(String str) {
        this.f4838h = str;
    }

    public void a(float... fArr) {
        this.f4842l = Float.TYPE;
        this.f4843m = C1372l.a(fArr);
    }

    public void a(int... iArr) {
        this.f4842l = Integer.TYPE;
        this.f4843m = C1372l.a(iArr);
    }

    public void a(AbstractC1371k... abstractC1371kArr) {
        int length = abstractC1371kArr.length;
        AbstractC1371k[] abstractC1371kArr2 = new AbstractC1371k[Math.max(length, 2)];
        this.f4842l = abstractC1371kArr[0].c();
        for (int i4 = 0; i4 < length; i4++) {
            abstractC1371kArr2[i4] = abstractC1371kArr[i4];
        }
        this.f4843m = new C1372l(abstractC1371kArr2);
    }

    public void a(Object... objArr) {
        this.f4842l = objArr[0].getClass();
        this.f4843m = C1372l.a(objArr);
    }

    public String b() {
        return this.f4838h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Object obj) {
        ArrayList<AbstractC1371k> arrayList = this.f4843m.f4946e;
        a(obj, arrayList.get(arrayList.size() - 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f4846p == null) {
            Class cls = this.f4842l;
            this.f4846p = cls == Integer.class ? f4831a : cls == Float.class ? f4832b : null;
        }
        F f4 = this.f4846p;
        if (f4 != null) {
            this.f4843m.a(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Object obj) {
        String invocationTargetException;
        com.acse.ottn.animator.b.d dVar = this.f4839i;
        if (dVar != null) {
            try {
                dVar.a(obj);
                Iterator<AbstractC1371k> it = this.f4843m.f4946e.iterator();
                while (it.hasNext()) {
                    AbstractC1371k next = it.next();
                    if (!next.e()) {
                        next.a(this.f4839i.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f4839i.a() + ") on target object " + obj + ". Trying reflection instead");
                this.f4839i = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f4840j == null) {
            a((Class) cls);
        }
        Iterator<AbstractC1371k> it2 = this.f4843m.f4946e.iterator();
        while (it2.hasNext()) {
            AbstractC1371k next2 = it2.next();
            if (!next2.e()) {
                if (this.f4841k == null) {
                    b((Class) cls);
                }
                try {
                    next2.a(this.f4841k.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e4) {
                    invocationTargetException = e4.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                } catch (InvocationTargetException e5) {
                    invocationTargetException = e5.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                }
            }
        }
    }

    @Override // 
    /* renamed from: clone */
    public D mo9clone() {
        try {
            D d4 = (D) super.clone();
            d4.f4838h = this.f4838h;
            d4.f4839i = this.f4839i;
            d4.f4843m = this.f4843m.mo12clone();
            d4.f4846p = this.f4846p;
            return d4;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Object obj) {
        a(obj, this.f4843m.f4946e.get(0));
    }

    public String toString() {
        return this.f4838h + ": " + this.f4843m.toString();
    }
}
