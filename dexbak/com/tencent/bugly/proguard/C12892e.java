package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12892e extends C12891d {

    /* renamed from: h */
    static HashMap<String, byte[]> f36860h;

    /* renamed from: i */
    static HashMap<String, HashMap<String, byte[]>> f36861i;

    /* renamed from: g */
    protected C12894g f36862g;

    /* renamed from: j */
    private int f36863j;

    public C12892e() {
        C12894g c12894g = new C12894g();
        this.f36862g = c12894g;
        this.f36863j = 0;
        c12894g.f36869a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.C12891d, com.tencent.bugly.proguard.C12890c
    /* renamed from: a */
    public final <T> void mo15661a(String str, T t) {
        if (!str.startsWith(".")) {
            super.mo15661a(str, (String) t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
    }

    @Override // com.tencent.bugly.proguard.C12891d
    /* renamed from: b */
    public final void mo15659b() {
        super.mo15659b();
        this.f36862g.f36869a = (short) 3;
    }

    /* renamed from: c */
    public final void m15656c(String str) {
        this.f36862g.f36874f = str;
    }

    /* renamed from: c */
    public final void m15657c() {
        this.f36862g.f36872d = 1;
    }

    /* renamed from: b */
    public final void m15658b(String str) {
        this.f36862g.f36873e = str;
    }

    @Override // com.tencent.bugly.proguard.C12891d, com.tencent.bugly.proguard.C12890c
    /* renamed from: a */
    public final byte[] mo15662a() {
        C12894g c12894g = this.f36862g;
        if (c12894g.f36869a == 2) {
            if (!c12894g.f36873e.equals("")) {
                if (this.f36862g.f36874f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (c12894g.f36873e == null) {
                c12894g.f36873e = "";
            }
            if (c12894g.f36874f == null) {
                c12894g.f36874f = "";
            }
        }
        C12900l c12900l = new C12900l(0);
        c12900l.m15594a(this.f36854c);
        if (this.f36862g.f36869a == 2) {
            c12900l.m15591a((Map) this.f36852a, 0);
        } else {
            c12900l.m15591a((Map) ((C12891d) this).f36857e, 0);
        }
        this.f36862g.f36875g = C12902n.m15573a(c12900l.f36885a);
        C12900l c12900l2 = new C12900l(0);
        c12900l2.m15594a(this.f36854c);
        this.f36862g.mo15578a(c12900l2);
        byte[] m15573a = C12902n.m15573a(c12900l2.f36885a);
        int length = m15573a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(m15573a).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.C12891d, com.tencent.bugly.proguard.C12890c
    /* renamed from: a */
    public final void mo15660a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                C12898k c12898k = new C12898k(bArr, (byte) 0);
                c12898k.m15620a(this.f36854c);
                this.f36862g.mo15579a(c12898k);
                C12894g c12894g = this.f36862g;
                if (c12894g.f36869a == 3) {
                    C12898k c12898k2 = new C12898k(c12894g.f36875g);
                    c12898k2.m15620a(this.f36854c);
                    if (f36860h == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f36860h = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((C12891d) this).f36857e = c12898k2.m15618a((Map) f36860h, 0, false);
                    return;
                }
                C12898k c12898k3 = new C12898k(c12894g.f36875g);
                c12898k3.m15620a(this.f36854c);
                if (f36861i == null) {
                    f36861i = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f36861i.put("", hashMap2);
                }
                this.f36852a = c12898k3.m15618a((Map) f36861i, 0, false);
                this.f36853b = new HashMap<>();
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }
}
