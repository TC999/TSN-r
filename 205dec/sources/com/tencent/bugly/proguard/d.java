package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d extends c {

    /* renamed from: e  reason: collision with root package name */
    protected HashMap<String, byte[]> f51224e = null;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, Object> f51226g = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    k f51225f = new k();

    private void c(String str, Object obj) {
        this.f51226g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.c
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void b() {
        this.f51224e = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.c
    public <T> void a(String str, T t3) {
        if (this.f51224e == null) {
            super.a(str, (String) t3);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t3 != null) {
                if (!(t3 instanceof Set)) {
                    l lVar = new l();
                    lVar.a(this.f51221c);
                    lVar.a(t3, 0);
                    this.f51224e.put(str, n.a(lVar.f51252a));
                    return;
                }
                throw new IllegalArgumentException("can not support Set");
            }
            throw new IllegalArgumentException("put value can not is null");
        }
    }

    public final <T> T b(String str, T t3) throws b {
        HashMap<String, byte[]> hashMap = this.f51224e;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.f51226g.containsKey(str)) {
                    return (T) this.f51226g.get(str);
                }
                try {
                    this.f51225f.a(this.f51224e.get(str));
                    this.f51225f.a(this.f51221c);
                    T t4 = (T) this.f51225f.a((k) t3, 0, true);
                    if (t4 != null) {
                        c(str, t4);
                    }
                    return t4;
                } catch (Exception e4) {
                    throw new b(e4);
                }
            }
            return null;
        } else if (this.f51219a.containsKey(str)) {
            if (this.f51226g.containsKey(str)) {
                return (T) this.f51226g.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f51219a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.f51225f.a(bArr);
                this.f51225f.a(this.f51221c);
                T t5 = (T) this.f51225f.a((k) t3, 0, true);
                c(str, t5);
                return t5;
            } catch (Exception e5) {
                throw new b(e5);
            }
        } else {
            return null;
        }
    }

    @Override // com.tencent.bugly.proguard.c
    public byte[] a() {
        if (this.f51224e != null) {
            l lVar = new l(0);
            lVar.a(this.f51221c);
            lVar.a((Map) this.f51224e, 0);
            return n.a(lVar.f51252a);
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f51225f.a(bArr);
            this.f51225f.a(this.f51221c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f51224e = this.f51225f.a((Map) hashMap, 0, false);
        }
    }
}
