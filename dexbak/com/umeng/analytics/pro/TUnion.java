package com.umeng.analytics.pro;

import com.umeng.analytics.pro.TFieldIdEnum;
import com.umeng.analytics.pro.TUnion;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.umeng.analytics.pro.cb */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class TUnion<T extends TUnion<?, ?>, F extends TFieldIdEnum> implements TBase<T, F> {

    /* renamed from: c */
    private static final Map<Class<? extends IScheme>, SchemeFactory> f37963c;

    /* renamed from: a */
    protected Object f37964a;

    /* renamed from: b */
    protected F f37965b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TUnion.java */
    /* renamed from: com.umeng.analytics.pro.cb$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13135a extends StandardScheme<TUnion> {
        private C13135a() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, TUnion tUnion) throws TException {
            tUnion.f37965b = null;
            tUnion.f37964a = null;
            tProtocol.mo14416j();
            TField mo14414l = tProtocol.mo14414l();
            Object m14496a = tUnion.m14496a(tProtocol, mo14414l);
            tUnion.f37964a = m14496a;
            if (m14496a != null) {
                tUnion.f37965b = (F) tUnion.m14490a(mo14414l.f38030c);
            }
            tProtocol.mo14413m();
            tProtocol.mo14414l();
            tProtocol.mo14415k();
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, TUnion tUnion) throws TException {
            if (tUnion.m14502a() != null && tUnion.m14489b() != null) {
                tProtocol.mo14429a(tUnion.m14482d());
                tProtocol.mo14434a(tUnion.m14483c(tUnion.f37965b));
                tUnion.m14497a(tProtocol);
                tProtocol.mo14423c();
                tProtocol.mo14422d();
                tProtocol.mo14424b();
                return;
            }
            throw new TProtocolException("Cannot write a TUnion with no set value!");
        }
    }

    /* compiled from: TUnion.java */
    /* renamed from: com.umeng.analytics.pro.cb$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13136b implements SchemeFactory {
        private C13136b() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13135a mo13482b() {
            return new C13135a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TUnion.java */
    /* renamed from: com.umeng.analytics.pro.cb$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13137c extends TupleScheme<TUnion> {
        private C13137c() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, TUnion tUnion) throws TException {
            tUnion.f37965b = null;
            tUnion.f37964a = null;
            short mo14404v = tProtocol.mo14404v();
            Object m14495a = tUnion.m14495a(tProtocol, mo14404v);
            tUnion.f37964a = m14495a;
            if (m14495a != null) {
                tUnion.f37965b = (F) tUnion.m14490a(mo14404v);
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, TUnion tUnion) throws TException {
            if (tUnion.m14502a() != null && tUnion.m14489b() != null) {
                tProtocol.mo14426a(tUnion.f37965b.mo13481a());
                tUnion.m14485b(tProtocol);
                return;
            }
            throw new TProtocolException("Cannot write a TUnion with no set value!");
        }
    }

    /* compiled from: TUnion.java */
    /* renamed from: com.umeng.analytics.pro.cb$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13138d implements SchemeFactory {
        private C13138d() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13137c mo13482b() {
            return new C13137c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f37963c = hashMap;
        hashMap.put(StandardScheme.class, new C13136b());
        hashMap.put(TupleScheme.class, new C13138d());
    }

    protected TUnion() {
        this.f37965b = null;
        this.f37964a = null;
    }

    /* renamed from: a */
    private static Object m14494a(Object obj) {
        if (obj instanceof TBase) {
            return ((TBase) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return TBaseHelper.m14524d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return m14493a((List) obj);
        }
        if (obj instanceof Set) {
            return m14491a((Set) obj);
        }
        return obj instanceof Map ? m14492a((Map<Object, Object>) obj) : obj;
    }

    /* renamed from: a */
    protected abstract F m14490a(short s);

    /* renamed from: a */
    protected abstract Object m14496a(TProtocol tProtocol, TField tField) throws TException;

    /* renamed from: a */
    protected abstract Object m14495a(TProtocol tProtocol, short s) throws TException;

    /* renamed from: a */
    protected abstract void m14497a(TProtocol tProtocol) throws TException;

    /* renamed from: b */
    public Object m14489b() {
        return this.f37964a;
    }

    /* renamed from: b */
    protected abstract void m14486b(F f, Object obj) throws ClassCastException;

    /* renamed from: b */
    protected abstract void m14485b(TProtocol tProtocol) throws TException;

    /* renamed from: c */
    protected abstract TField m14483c(F f);

    /* renamed from: c */
    public boolean m14484c() {
        return this.f37965b != null;
    }

    @Override // com.umeng.analytics.pro.TBase
    public final void clear() {
        this.f37965b = null;
        this.f37964a = null;
    }

    /* renamed from: d */
    protected abstract TStruct m14482d();

    @Override // com.umeng.analytics.pro.TBase
    public void read(TProtocol tProtocol) throws TException {
        f37963c.get(tProtocol.mo14394D()).mo13482b().mo13485b(tProtocol, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (m14502a() != null) {
            Object m14489b = m14489b();
            sb.append(m14483c(m14502a()).f38028a);
            sb.append(":");
            if (m14489b instanceof ByteBuffer) {
                TBaseHelper.m14535a((ByteBuffer) m14489b, sb);
            } else {
                sb.append(m14489b.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.TBase
    public void write(TProtocol tProtocol) throws TException {
        f37963c.get(tProtocol.mo14394D()).mo13482b().mo13487a(tProtocol, this);
    }

    /* renamed from: b */
    public boolean m14487b(F f) {
        return this.f37965b == f;
    }

    /* renamed from: b */
    public boolean m14488b(int i) {
        return m14487b((TUnion<T, F>) m14490a((short) i));
    }

    protected TUnion(F f, Object obj) {
        m14498a((TUnion<T, F>) f, obj);
    }

    protected TUnion(TUnion<T, F> tUnion) {
        if (tUnion.getClass().equals(getClass())) {
            this.f37965b = tUnion.f37965b;
            this.f37964a = m14494a(tUnion.f37964a);
            return;
        }
        throw new ClassCastException();
    }

    /* renamed from: a */
    private static Map m14492a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(m14494a(entry.getKey()), m14494a(entry.getValue()));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Set m14491a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            hashSet.add(m14494a(obj));
        }
        return hashSet;
    }

    /* renamed from: a */
    private static List m14493a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(m14494a(obj));
        }
        return arrayList;
    }

    /* renamed from: a */
    public F m14502a() {
        return this.f37965b;
    }

    /* renamed from: a */
    public Object m14499a(F f) {
        if (f == this.f37965b) {
            return m14489b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.f37965b);
    }

    /* renamed from: a */
    public Object m14501a(int i) {
        return m14499a((TUnion<T, F>) m14490a((short) i));
    }

    /* renamed from: a */
    public void m14498a(F f, Object obj) {
        m14486b(f, obj);
        this.f37965b = f;
        this.f37964a = obj;
    }

    /* renamed from: a */
    public void m14500a(int i, Object obj) {
        m14498a((TUnion<T, F>) m14490a((short) i), obj);
    }
}
