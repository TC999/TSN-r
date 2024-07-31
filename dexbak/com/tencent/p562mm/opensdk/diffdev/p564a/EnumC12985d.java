package com.tencent.p562mm.opensdk.diffdev.p564a;

import com.bytedance.sdk.openadsdk.TTAdConstant;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum EnumC12985d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(TTAdConstant.INTERACTION_TYPE_CODE),
    UUID_ERROR(500);
    

    /* renamed from: a */
    private int f37211a;

    EnumC12985d(int i) {
        this.f37211a = i;
    }

    /* renamed from: a */
    public int m15271a() {
        return this.f37211a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f37211a;
    }
}
