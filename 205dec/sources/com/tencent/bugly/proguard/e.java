package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class e extends d {

    /* renamed from: h  reason: collision with root package name */
    static HashMap<String, byte[]> f51227h;

    /* renamed from: i  reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f51228i;

    /* renamed from: g  reason: collision with root package name */
    protected g f51229g;

    /* renamed from: j  reason: collision with root package name */
    private int f51230j;

    public e() {
        g gVar = new g();
        this.f51229g = gVar;
        this.f51230j = 0;
        gVar.f51236a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final <T> void a(String str, T t3) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t3);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
    }

    @Override // com.tencent.bugly.proguard.d
    public final void b() {
        super.b();
        this.f51229g.f51236a = (short) 3;
    }

    public final void c(String str) {
        this.f51229g.f51241f = str;
    }

    public final void c() {
        this.f51229g.f51239d = 1;
    }

    public final void b(String str) {
        this.f51229g.f51240e = str;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final byte[] a() {
        g gVar = this.f51229g;
        if (gVar.f51236a == 2) {
            if (!gVar.f51240e.equals("")) {
                if (this.f51229g.f51241f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (gVar.f51240e == null) {
                gVar.f51240e = "";
            }
            if (gVar.f51241f == null) {
                gVar.f51241f = "";
            }
        }
        l lVar = new l(0);
        lVar.a(this.f51221c);
        if (this.f51229g.f51236a == 2) {
            lVar.a((Map) this.f51219a, 0);
        } else {
            lVar.a((Map) ((d) this).f51224e, 0);
        }
        this.f51229g.f51242g = n.a(lVar.f51252a);
        l lVar2 = new l(0);
        lVar2.a(this.f51221c);
        this.f51229g.a(lVar2);
        byte[] a4 = n.a(lVar2.f51252a);
        int length = a4.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a4).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, (byte) 0);
                kVar.a(this.f51221c);
                this.f51229g.a(kVar);
                g gVar = this.f51229g;
                if (gVar.f51236a == 3) {
                    k kVar2 = new k(gVar.f51242g);
                    kVar2.a(this.f51221c);
                    if (f51227h == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f51227h = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((d) this).f51224e = kVar2.a((Map) f51227h, 0, false);
                    return;
                }
                k kVar3 = new k(gVar.f51242g);
                kVar3.a(this.f51221c);
                if (f51228i == null) {
                    f51228i = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f51228i.put("", hashMap2);
                }
                this.f51219a = kVar3.a((Map) f51228i, 0, false);
                this.f51220b = new HashMap<>();
                return;
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }
}
