package com.amap.api.col.p047s;

import java.io.File;

/* compiled from: FileNumUpdateStrategy.java */
/* renamed from: com.amap.api.col.s.r3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2137r3 extends AbstractC2189v3 {

    /* renamed from: b */
    private int f6458b;

    /* renamed from: c */
    private String f6459c;

    public C2137r3(String str, AbstractC2189v3 abstractC2189v3) {
        super(abstractC2189v3);
        this.f6458b = 30;
        this.f6459c = str;
    }

    /* renamed from: f */
    private static int m52577f(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            C2060g2.m52972o(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.p047s.AbstractC2189v3
    /* renamed from: c */
    protected final boolean mo52342c() {
        return m52577f(this.f6459c) >= this.f6458b;
    }
}
