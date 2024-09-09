package com.bytedance.sdk.component.ux.sr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements gd {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f30245c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.ux.f f30246w;

    public w(byte[] bArr, com.bytedance.sdk.component.ux.f fVar) {
        this.f30245c = bArr;
        this.f30246w = fVar;
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "image_type";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        gd evVar;
        int bk = xvVar.bk();
        xvVar.c(this.f30245c.length);
        if (bk != 2) {
            if (bk != 3) {
                boolean w3 = com.bytedance.sdk.component.ux.xv.xv.c.w(this.f30245c);
                if (w3) {
                    evVar = new bk(this.f30245c, this.f30246w, w3);
                } else if (com.bytedance.sdk.component.ux.xv.xv.c.c(this.f30245c)) {
                    evVar = new ux(this.f30245c, this.f30246w);
                } else {
                    evVar = new bk(this.f30245c, this.f30246w, w3);
                }
            } else {
                byte[] bArr = this.f30245c;
                evVar = new bk(bArr, this.f30246w, com.bytedance.sdk.component.ux.xv.xv.c.w(bArr));
            }
        } else if (com.bytedance.sdk.component.ux.xv.xv.c.c(this.f30245c)) {
            evVar = new ux(this.f30245c, this.f30246w);
        } else if (this.f30246w == null) {
            evVar = new k();
        } else {
            evVar = new ev(1001, "not image format", null);
        }
        xvVar.c(evVar);
    }
}
