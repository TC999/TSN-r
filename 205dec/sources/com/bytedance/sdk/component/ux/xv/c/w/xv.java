package com.bytedance.sdk.component.ux.xv.c.w;

import com.bytedance.sdk.component.ux.fz;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements fz {

    /* renamed from: c  reason: collision with root package name */
    private int f30287c;
    private com.bytedance.sdk.component.ux.xv.c.xv<String, byte[]> sr;

    /* renamed from: w  reason: collision with root package name */
    private int f30288w;
    private int xv;

    public xv(int i4, int i5) {
        this.xv = i4;
        this.f30287c = i5;
        this.sr = new com.bytedance.sdk.component.ux.xv.c.xv<String, byte[]>(i4) { // from class: com.bytedance.sdk.component.ux.xv.c.w.xv.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.ux.xv.c.xv
            /* renamed from: c */
            public int w(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.ux.c
    public boolean w(String str) {
        return this.sr.c((com.bytedance.sdk.component.ux.xv.c.xv<String, byte[]>) str) != null;
    }

    @Override // com.bytedance.sdk.component.ux.c
    public boolean c(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.sr.c(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.ux.c
    public byte[] c(String str) {
        return this.sr.c((com.bytedance.sdk.component.ux.xv.c.xv<String, byte[]>) str);
    }

    @Override // com.bytedance.sdk.component.ux.c
    public void c(double d4) {
        com.bytedance.sdk.component.ux.xv.c.xv<String, byte[]> xvVar = this.sr;
        double d5 = this.xv;
        Double.isNaN(d5);
        xvVar.c((int) (d5 * d4));
    }
}
