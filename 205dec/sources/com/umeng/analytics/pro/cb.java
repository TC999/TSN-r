package com.umeng.analytics.pro;

import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cb;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TUnion.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class cb<T extends cb<?, ?>, F extends by> implements br<T, F> {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f52749c;

    /* renamed from: a  reason: collision with root package name */
    protected Object f52750a;

    /* renamed from: b  reason: collision with root package name */
    protected F f52751b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TUnion.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a extends da<cb> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public void b(cq cqVar, cb cbVar) throws bx {
            cbVar.f52751b = null;
            cbVar.f52750a = null;
            cqVar.j();
            cl l4 = cqVar.l();
            Object a4 = cbVar.a(cqVar, l4);
            cbVar.f52750a = a4;
            if (a4 != null) {
                cbVar.f52751b = (F) cbVar.a(l4.f52816c);
            }
            cqVar.m();
            cqVar.l();
            cqVar.k();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b */
        public void a(cq cqVar, cb cbVar) throws bx {
            if (cbVar.a() != null && cbVar.b() != null) {
                cqVar.a(cbVar.d());
                cqVar.a(cbVar.c(cbVar.f52751b));
                cbVar.a(cqVar);
                cqVar.c();
                cqVar.d();
                cqVar.b();
                return;
            }
            throw new cr("Cannot write a TUnion with no set value!");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TUnion.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class b implements cz {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TUnion.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c extends db<cb> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public void b(cq cqVar, cb cbVar) throws bx {
            cbVar.f52751b = null;
            cbVar.f52750a = null;
            short v3 = cqVar.v();
            Object a4 = cbVar.a(cqVar, v3);
            cbVar.f52750a = a4;
            if (a4 != null) {
                cbVar.f52751b = (F) cbVar.a(v3);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b */
        public void a(cq cqVar, cb cbVar) throws bx {
            if (cbVar.a() != null && cbVar.b() != null) {
                cqVar.a(cbVar.f52751b.a());
                cbVar.b(cqVar);
                return;
            }
            throw new cr("Cannot write a TUnion with no set value!");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TUnion.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class d implements cz {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f52749c = hashMap;
        hashMap.put(da.class, new b());
        hashMap.put(db.class, new d());
    }

    protected cb() {
        this.f52751b = null;
        this.f52750a = null;
    }

    private static Object a(Object obj) {
        if (obj instanceof br) {
            return ((br) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return bs.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s3);

    protected abstract Object a(cq cqVar, cl clVar) throws bx;

    protected abstract Object a(cq cqVar, short s3) throws bx;

    protected abstract void a(cq cqVar) throws bx;

    public Object b() {
        return this.f52750a;
    }

    protected abstract void b(F f4, Object obj) throws ClassCastException;

    protected abstract void b(cq cqVar) throws bx;

    protected abstract cl c(F f4);

    public boolean c() {
        return this.f52751b != null;
    }

    @Override // com.umeng.analytics.pro.br
    public final void clear() {
        this.f52751b = null;
        this.f52750a = null;
    }

    protected abstract cv d();

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f52749c.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b4 = b();
            sb.append(c(a()).f52814a);
            sb.append(":");
            if (b4 instanceof ByteBuffer) {
                bs.a((ByteBuffer) b4, sb);
            } else {
                sb.append(b4.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f52749c.get(cqVar.D()).b().a(cqVar, this);
    }

    public boolean b(F f4) {
        return this.f52751b == f4;
    }

    public boolean b(int i4) {
        return b((cb<T, F>) a((short) i4));
    }

    protected cb(F f4, Object obj) {
        a((cb<T, F>) f4, obj);
    }

    protected cb(cb<T, F> cbVar) {
        if (cbVar.getClass().equals(getClass())) {
            this.f52751b = cbVar.f52751b;
            this.f52750a = a(cbVar.f52750a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            hashSet.add(a(obj));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(a(obj));
        }
        return arrayList;
    }

    public F a() {
        return this.f52751b;
    }

    public Object a(F f4) {
        if (f4 == this.f52751b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f4 + " because union's set field is " + this.f52751b);
    }

    public Object a(int i4) {
        return a((cb<T, F>) a((short) i4));
    }

    public void a(F f4, Object obj) {
        b(f4, obj);
        this.f52751b = f4;
        this.f52750a = obj;
    }

    public void a(int i4, Object obj) {
        a((cb<T, F>) a((short) i4), obj);
    }
}
