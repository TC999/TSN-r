package com.acse.ottn.animator.p031a;

import android.util.Log;
import com.acse.ottn.animator.p032b.AbstractC1370a;
import com.acse.ottn.animator.p032b.AbstractC1371b;
import com.acse.ottn.animator.p032b.AbstractC1373d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.acse.ottn.animator.a.D */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1320D implements Cloneable {

    /* renamed from: a */
    private static final InterfaceC1325F f2270a = new C1348i();

    /* renamed from: b */
    private static final InterfaceC1325F f2271b = new C1346g();

    /* renamed from: c */
    private static Class[] f2272c;

    /* renamed from: d */
    private static Class[] f2273d;

    /* renamed from: e */
    private static Class[] f2274e;

    /* renamed from: f */
    private static final HashMap<Class, HashMap<String, Method>> f2275f;

    /* renamed from: g */
    private static final HashMap<Class, HashMap<String, Method>> f2276g;

    /* renamed from: h */
    String f2277h;

    /* renamed from: i */
    protected AbstractC1373d f2278i;

    /* renamed from: j */
    Method f2279j;

    /* renamed from: k */
    private Method f2280k;

    /* renamed from: l */
    Class f2281l;

    /* renamed from: m */
    C1354l f2282m;

    /* renamed from: n */
    final ReentrantReadWriteLock f2283n;

    /* renamed from: o */
    final Object[] f2284o;

    /* renamed from: p */
    private InterfaceC1325F f2285p;

    /* renamed from: q */
    private Object f2286q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.acse.ottn.animator.a.D$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1321a extends C1320D {

        /* renamed from: r */
        private AbstractC1370a f2287r;

        /* renamed from: s */
        C1347h f2288s;

        /* renamed from: t */
        float f2289t;

        public C1321a(AbstractC1373d abstractC1373d, C1347h c1347h) {
            super(abstractC1373d);
            this.f2281l = Float.TYPE;
            this.f2282m = c1347h;
            this.f2288s = c1347h;
            if (abstractC1373d instanceof AbstractC1370a) {
                this.f2287r = (AbstractC1370a) this.f2278i;
            }
        }

        public C1321a(AbstractC1373d abstractC1373d, float... fArr) {
            super(abstractC1373d);
            mo57167a(fArr);
            if (abstractC1373d instanceof AbstractC1370a) {
                this.f2287r = (AbstractC1370a) this.f2278i;
            }
        }

        public C1321a(String str, C1347h c1347h) {
            super(str);
            this.f2281l = Float.TYPE;
            this.f2282m = c1347h;
            this.f2288s = c1347h;
        }

        public C1321a(String str, float... fArr) {
            super(str);
            mo57167a(fArr);
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        Object mo57166a() {
            return Float.valueOf(this.f2289t);
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        void mo57165a(float f) {
            this.f2289t = this.f2288s.m57083b(f);
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        void mo57164a(Class cls) {
            if (this.f2278i != null) {
                return;
            }
            super.mo57164a(cls);
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        void mo57163a(Object obj) {
            String invocationTargetException;
            AbstractC1370a abstractC1370a = this.f2287r;
            if (abstractC1370a != null) {
                abstractC1370a.mo57011a((AbstractC1370a) obj, this.f2289t);
                return;
            }
            AbstractC1373d abstractC1373d = this.f2278i;
            if (abstractC1373d != null) {
                abstractC1373d.mo57002a(obj, Float.valueOf(this.f2289t));
            } else if (this.f2279j != null) {
                try {
                    this.f2284o[0] = Float.valueOf(this.f2289t);
                    this.f2279j.invoke(obj, this.f2284o);
                } catch (IllegalAccessException e) {
                    invocationTargetException = e.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                } catch (InvocationTargetException e2) {
                    invocationTargetException = e2.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                }
            }
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        public void mo57167a(float... fArr) {
            super.mo57167a(fArr);
            this.f2288s = (C1347h) this.f2282m;
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: clone */
        public C1321a mo60088clone() {
            C1321a c1321a = (C1321a) super.mo60088clone();
            c1321a.f2288s = (C1347h) c1321a.f2282m;
            return c1321a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.acse.ottn.animator.a.D$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1322b extends C1320D {

        /* renamed from: r */
        private AbstractC1371b f2290r;

        /* renamed from: s */
        C1349j f2291s;

        /* renamed from: t */
        int f2292t;

        public C1322b(AbstractC1373d abstractC1373d, C1349j c1349j) {
            super(abstractC1373d);
            this.f2281l = Integer.TYPE;
            this.f2282m = c1349j;
            this.f2291s = c1349j;
            if (abstractC1373d instanceof AbstractC1371b) {
                this.f2290r = (AbstractC1371b) this.f2278i;
            }
        }

        public C1322b(AbstractC1373d abstractC1373d, int... iArr) {
            super(abstractC1373d);
            mo57162a(iArr);
            if (abstractC1373d instanceof AbstractC1371b) {
                this.f2290r = (AbstractC1371b) this.f2278i;
            }
        }

        public C1322b(String str, C1349j c1349j) {
            super(str);
            this.f2281l = Integer.TYPE;
            this.f2282m = c1349j;
            this.f2291s = c1349j;
        }

        public C1322b(String str, int... iArr) {
            super(str);
            mo57162a(iArr);
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        Object mo57166a() {
            return Integer.valueOf(this.f2292t);
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        void mo57165a(float f) {
            this.f2292t = this.f2291s.m57081b(f);
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        void mo57164a(Class cls) {
            if (this.f2278i != null) {
                return;
            }
            super.mo57164a(cls);
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        void mo57163a(Object obj) {
            String invocationTargetException;
            AbstractC1371b abstractC1371b = this.f2290r;
            if (abstractC1371b != null) {
                abstractC1371b.mo57009a((AbstractC1371b) obj, this.f2292t);
                return;
            }
            AbstractC1373d abstractC1373d = this.f2278i;
            if (abstractC1373d != null) {
                abstractC1373d.mo57002a(obj, Integer.valueOf(this.f2292t));
            } else if (this.f2279j != null) {
                try {
                    this.f2284o[0] = Integer.valueOf(this.f2292t);
                    this.f2279j.invoke(obj, this.f2284o);
                } catch (IllegalAccessException e) {
                    invocationTargetException = e.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                } catch (InvocationTargetException e2) {
                    invocationTargetException = e2.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                }
            }
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: a */
        public void mo57162a(int... iArr) {
            super.mo57162a(iArr);
            this.f2291s = (C1349j) this.f2282m;
        }

        @Override // com.acse.ottn.animator.p031a.C1320D
        /* renamed from: clone */
        public C1322b mo60088clone() {
            C1322b c1322b = (C1322b) super.mo60088clone();
            c1322b.f2291s = (C1349j) c1322b.f2282m;
            return c1322b;
        }
    }

    static {
        Class cls = Float.TYPE;
        Class cls2 = Double.TYPE;
        Class cls3 = Integer.TYPE;
        f2272c = new Class[]{cls, Float.class, cls2, cls3, Double.class, Integer.class};
        f2273d = new Class[]{cls3, Integer.class, cls, cls2, Float.class, Double.class};
        f2274e = new Class[]{cls2, Double.class, cls, cls3, Float.class, Integer.class};
        f2275f = new HashMap<>();
        f2276g = new HashMap<>();
    }

    private C1320D(AbstractC1373d abstractC1373d) {
        this.f2279j = null;
        this.f2280k = null;
        this.f2282m = null;
        this.f2283n = new ReentrantReadWriteLock();
        this.f2284o = new Object[1];
        this.f2278i = abstractC1373d;
        if (abstractC1373d != null) {
            this.f2277h = abstractC1373d.m57007a();
        }
    }

    private C1320D(String str) {
        this.f2279j = null;
        this.f2280k = null;
        this.f2282m = null;
        this.f2283n = new ReentrantReadWriteLock();
        this.f2284o = new Object[1];
        this.f2277h = str;
    }

    /* renamed from: a */
    public static <V> C1320D m57188a(AbstractC1373d abstractC1373d, InterfaceC1325F<V> interfaceC1325F, V... vArr) {
        C1320D c1320d = new C1320D(abstractC1373d);
        c1320d.m57174a((Object[]) vArr);
        c1320d.m57190a((InterfaceC1325F) interfaceC1325F);
        return c1320d;
    }

    /* renamed from: a */
    public static C1320D m57187a(AbstractC1373d<?, Float> abstractC1373d, float... fArr) {
        return new C1321a(abstractC1373d, fArr);
    }

    /* renamed from: a */
    public static C1320D m57186a(AbstractC1373d<?, Integer> abstractC1373d, int... iArr) {
        return new C1322b(abstractC1373d, iArr);
    }

    /* renamed from: a */
    public static C1320D m57185a(AbstractC1373d abstractC1373d, AbstractC1350k... abstractC1350kArr) {
        C1354l m57060a = C1354l.m57060a(abstractC1350kArr);
        if (m57060a instanceof C1349j) {
            return new C1322b(abstractC1373d, (C1349j) m57060a);
        }
        if (m57060a instanceof C1347h) {
            return new C1321a(abstractC1373d, (C1347h) m57060a);
        }
        C1320D c1320d = new C1320D(abstractC1373d);
        c1320d.f2282m = m57060a;
        c1320d.f2281l = abstractC1350kArr[0].m57072c();
        return c1320d;
    }

    /* renamed from: a */
    public static C1320D m57180a(String str, InterfaceC1325F interfaceC1325F, Object... objArr) {
        C1320D c1320d = new C1320D(str);
        c1320d.m57174a(objArr);
        c1320d.m57190a(interfaceC1325F);
        return c1320d;
    }

    /* renamed from: a */
    public static C1320D m57178a(String str, float... fArr) {
        return new C1321a(str, fArr);
    }

    /* renamed from: a */
    public static C1320D m57177a(String str, int... iArr) {
        return new C1322b(str, iArr);
    }

    /* renamed from: a */
    public static C1320D m57176a(String str, AbstractC1350k... abstractC1350kArr) {
        C1354l m57060a = C1354l.m57060a(abstractC1350kArr);
        if (m57060a instanceof C1349j) {
            return new C1322b(str, (C1349j) m57060a);
        }
        if (m57060a instanceof C1347h) {
            return new C1321a(str, (C1347h) m57060a);
        }
        C1320D c1320d = new C1320D(str);
        c1320d.f2282m = m57060a;
        c1320d.f2281l = abstractC1350kArr[0].m57072c();
        return c1320d;
    }

    /* renamed from: a */
    static String m57179a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }

    /* renamed from: a */
    private Method m57184a(Class cls, String str, Class cls2) {
        StringBuilder sb;
        Class<?>[] clsArr;
        String m57179a = m57179a(str, this.f2277h);
        Method method = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(m57179a, null);
            } catch (NoSuchMethodException e) {
                try {
                    method = cls.getDeclaredMethod(m57179a, null);
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    sb = new StringBuilder();
                    sb.append("Couldn't find no-arg method for property ");
                    sb.append(this.f2277h);
                    sb.append(": ");
                    sb.append(e);
                }
            }
        } else {
            Class<?>[] clsArr2 = new Class[1];
            for (Class<?> cls3 : this.f2281l.equals(Float.class) ? f2272c : this.f2281l.equals(Integer.class) ? f2273d : this.f2281l.equals(Double.class) ? f2274e : new Class[]{this.f2281l}) {
                clsArr2[0] = cls3;
                try {
                    try {
                        Method method2 = cls.getMethod(m57179a, clsArr2);
                        this.f2281l = cls3;
                        return method2;
                    } catch (NoSuchMethodException unused2) {
                        method = cls.getDeclaredMethod(m57179a, clsArr2);
                        method.setAccessible(true);
                        this.f2281l = cls3;
                        return method;
                    }
                } catch (NoSuchMethodException unused3) {
                }
            }
            sb = new StringBuilder();
            sb.append("Couldn't find setter/getter for property ");
            sb.append(this.f2277h);
            sb.append(" with value type ");
            sb.append(this.f2281l);
        }
        Log.e("PropertyValuesHolder", sb.toString());
        return method;
    }

    /* renamed from: a */
    private Method m57183a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.f2283n.writeLock().lock();
            HashMap<String, Method> hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? hashMap2.get(this.f2277h) : null;
            if (method == null) {
                method = m57184a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f2277h, method);
            }
            return method;
        } finally {
            this.f2283n.writeLock().unlock();
        }
    }

    /* renamed from: a */
    private void m57182a(Object obj, AbstractC1350k abstractC1350k) {
        String invocationTargetException;
        AbstractC1373d abstractC1373d = this.f2278i;
        if (abstractC1373d != null) {
            abstractC1350k.mo57066a(abstractC1373d.mo57003a(obj));
        }
        try {
            if (this.f2280k == null) {
                m57172b((Class) obj.getClass());
            }
            abstractC1350k.mo57066a(this.f2280k.invoke(obj, new Object[0]));
        } catch (IllegalAccessException e) {
            invocationTargetException = e.toString();
            Log.e("PropertyValuesHolder", invocationTargetException);
        } catch (InvocationTargetException e2) {
            invocationTargetException = e2.toString();
            Log.e("PropertyValuesHolder", invocationTargetException);
        }
    }

    /* renamed from: b */
    private void m57172b(Class cls) {
        this.f2280k = m57183a(cls, f2276g, "get", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo57166a() {
        return this.f2286q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57165a(float f) {
        this.f2286q = this.f2282m.mo57064a(f);
    }

    /* renamed from: a */
    public void m57190a(InterfaceC1325F interfaceC1325F) {
        this.f2285p = interfaceC1325F;
        this.f2282m.m57063a(interfaceC1325F);
    }

    /* renamed from: a */
    public void m57189a(AbstractC1373d abstractC1373d) {
        this.f2278i = abstractC1373d;
    }

    /* renamed from: a */
    void mo57164a(Class cls) {
        this.f2279j = m57183a(cls, f2275f, "set", this.f2281l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57163a(Object obj) {
        String invocationTargetException;
        AbstractC1373d abstractC1373d = this.f2278i;
        if (abstractC1373d != null) {
            abstractC1373d.mo57002a(obj, mo57166a());
        }
        if (this.f2279j != null) {
            try {
                this.f2284o[0] = mo57166a();
                this.f2279j.invoke(obj, this.f2284o);
            } catch (IllegalAccessException e) {
                invocationTargetException = e.toString();
                Log.e("PropertyValuesHolder", invocationTargetException);
            } catch (InvocationTargetException e2) {
                invocationTargetException = e2.toString();
                Log.e("PropertyValuesHolder", invocationTargetException);
            }
        }
    }

    /* renamed from: a */
    public void m57181a(String str) {
        this.f2277h = str;
    }

    /* renamed from: a */
    public void mo57167a(float... fArr) {
        this.f2281l = Float.TYPE;
        this.f2282m = C1354l.m57062a(fArr);
    }

    /* renamed from: a */
    public void mo57162a(int... iArr) {
        this.f2281l = Integer.TYPE;
        this.f2282m = C1354l.m57061a(iArr);
    }

    /* renamed from: a */
    public void m57175a(AbstractC1350k... abstractC1350kArr) {
        int length = abstractC1350kArr.length;
        AbstractC1350k[] abstractC1350kArr2 = new AbstractC1350k[Math.max(length, 2)];
        this.f2281l = abstractC1350kArr[0].m57072c();
        for (int i = 0; i < length; i++) {
            abstractC1350kArr2[i] = abstractC1350kArr[i];
        }
        this.f2282m = new C1354l(abstractC1350kArr2);
    }

    /* renamed from: a */
    public void m57174a(Object... objArr) {
        this.f2281l = objArr[0].getClass();
        this.f2282m = C1354l.m57059a(objArr);
    }

    /* renamed from: b */
    public String m57173b() {
        return this.f2277h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m57171b(Object obj) {
        ArrayList<AbstractC1350k> arrayList = this.f2282m.f2399e;
        m57182a(obj, arrayList.get(arrayList.size() - 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m57170c() {
        if (this.f2285p == null) {
            Class cls = this.f2281l;
            this.f2285p = cls == Integer.class ? f2270a : cls == Float.class ? f2271b : null;
        }
        InterfaceC1325F interfaceC1325F = this.f2285p;
        if (interfaceC1325F != null) {
            this.f2282m.m57063a(interfaceC1325F);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m57169c(Object obj) {
        String invocationTargetException;
        AbstractC1373d abstractC1373d = this.f2278i;
        if (abstractC1373d != null) {
            try {
                abstractC1373d.mo57003a(obj);
                Iterator<AbstractC1350k> it = this.f2282m.f2399e.iterator();
                while (it.hasNext()) {
                    AbstractC1350k next = it.next();
                    if (!next.m57069e()) {
                        next.mo57066a(this.f2278i.mo57003a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f2278i.m57007a() + ") on target object " + obj + ". Trying reflection instead");
                this.f2278i = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f2279j == null) {
            mo57164a((Class) cls);
        }
        Iterator<AbstractC1350k> it2 = this.f2282m.f2399e.iterator();
        while (it2.hasNext()) {
            AbstractC1350k next2 = it2.next();
            if (!next2.m57069e()) {
                if (this.f2280k == null) {
                    m57172b((Class) cls);
                }
                try {
                    next2.mo57066a(this.f2280k.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e) {
                    invocationTargetException = e.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                } catch (InvocationTargetException e2) {
                    invocationTargetException = e2.toString();
                    Log.e("PropertyValuesHolder", invocationTargetException);
                }
            }
        }
    }

    @Override // 
    /* renamed from: clone */
    public C1320D mo60088clone() {
        try {
            C1320D c1320d = (C1320D) super.clone();
            c1320d.f2277h = this.f2277h;
            c1320d.f2278i = this.f2278i;
            c1320d.f2282m = this.f2282m.mo60091clone();
            c1320d.f2285p = this.f2285p;
            return c1320d;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m57168d(Object obj) {
        m57182a(obj, this.f2282m.f2399e.get(0));
    }

    public String toString() {
        return this.f2277h + ": " + this.f2282m.toString();
    }
}
