package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12891d extends C12890c {

    /* renamed from: e */
    protected HashMap<String, byte[]> f36857e = null;

    /* renamed from: g */
    private HashMap<String, Object> f36859g = new HashMap<>();

    /* renamed from: f */
    C12898k f36858f = new C12898k();

    /* renamed from: c */
    private void m15663c(String str, Object obj) {
        this.f36859g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.C12890c
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo15665a(String str) {
        super.mo15665a(str);
    }

    /* renamed from: b */
    public void mo15659b() {
        this.f36857e = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.C12890c
    /* renamed from: a */
    public <T> void mo15661a(String str, T t) {
        if (this.f36857e == null) {
            super.mo15661a(str, (String) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t != null) {
                if (!(t instanceof Set)) {
                    C12900l c12900l = new C12900l();
                    c12900l.m15594a(this.f36854c);
                    c12900l.m15595a(t, 0);
                    this.f36857e.put(str, C12902n.m15573a(c12900l.f36885a));
                    return;
                }
                throw new IllegalArgumentException("can not support Set");
            }
            throw new IllegalArgumentException("put value can not is null");
        }
    }

    /* renamed from: b */
    public final <T> T m15664b(String str, T t) throws C12866b {
        HashMap<String, byte[]> hashMap = this.f36857e;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.f36859g.containsKey(str)) {
                    return (T) this.f36859g.get(str);
                }
                try {
                    this.f36858f.m15615a(this.f36857e.get(str));
                    this.f36858f.m15620a(this.f36854c);
                    T t2 = (T) this.f36858f.m15621a((C12898k) t, 0, true);
                    if (t2 != null) {
                        m15663c(str, t2);
                    }
                    return t2;
                } catch (Exception e) {
                    throw new C12866b(e);
                }
            }
            return null;
        } else if (this.f36852a.containsKey(str)) {
            if (this.f36859g.containsKey(str)) {
                return (T) this.f36859g.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f36852a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.f36858f.m15615a(bArr);
                this.f36858f.m15620a(this.f36854c);
                T t3 = (T) this.f36858f.m15621a((C12898k) t, 0, true);
                m15663c(str, t3);
                return t3;
            } catch (Exception e2) {
                throw new C12866b(e2);
            }
        } else {
            return null;
        }
    }

    @Override // com.tencent.bugly.proguard.C12890c
    /* renamed from: a */
    public byte[] mo15662a() {
        if (this.f36857e != null) {
            C12900l c12900l = new C12900l(0);
            c12900l.m15594a(this.f36854c);
            c12900l.m15591a((Map) this.f36857e, 0);
            return C12902n.m15573a(c12900l.f36885a);
        }
        return super.mo15662a();
    }

    @Override // com.tencent.bugly.proguard.C12890c
    /* renamed from: a */
    public void mo15660a(byte[] bArr) {
        try {
            super.mo15660a(bArr);
        } catch (Exception unused) {
            this.f36858f.m15615a(bArr);
            this.f36858f.m15620a(this.f36854c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f36857e = this.f36858f.m15618a((Map) hashMap, 0, false);
        }
    }
}
