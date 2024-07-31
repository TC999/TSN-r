package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bn */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12881bn extends AbstractC12901m implements Cloneable {

    /* renamed from: d */
    static byte[] f36748d;

    /* renamed from: a */
    public byte f36749a;

    /* renamed from: b */
    public String f36750b;

    /* renamed from: c */
    public byte[] f36751c;

    public C12881bn() {
        this.f36749a = (byte) 0;
        this.f36750b = "";
        this.f36751c = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15602a(this.f36749a, 0);
        c12900l.m15593a(this.f36750b, 1);
        byte[] bArr = this.f36751c;
        if (bArr != null) {
            c12900l.m15588a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15577a(StringBuilder sb, int i) {
    }

    public C12881bn(byte b, String str, byte[] bArr) {
        this.f36749a = b;
        this.f36750b = str;
        this.f36751c = bArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        this.f36749a = c12898k.m15631a(this.f36749a, 0, true);
        this.f36750b = c12898k.m15611b(1, true);
        if (f36748d == null) {
            f36748d = r0;
            byte[] bArr = {0};
        }
        this.f36751c = c12898k.m15609c(2, false);
    }
}
