package com.bytedance.sdk.component.ux.xv.c.w;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ux.s;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements s {

    /* renamed from: c  reason: collision with root package name */
    private final s f30282c;

    /* renamed from: w  reason: collision with root package name */
    private final com.bytedance.sdk.component.ux.xv.c.w f30283w;

    public sr(s sVar) {
        this(sVar, null);
    }

    public sr(s sVar, com.bytedance.sdk.component.ux.xv.c.w wVar) {
        this.f30282c = sVar;
        this.f30283w = wVar;
    }

    @Override // com.bytedance.sdk.component.ux.c
    public boolean w(String str) {
        return this.f30282c.w(str);
    }

    @Override // com.bytedance.sdk.component.ux.c
    public boolean c(String str, Bitmap bitmap) {
        boolean c4 = this.f30282c.c(str, bitmap);
        com.bytedance.sdk.component.ux.xv.c.w wVar = this.f30283w;
        if (wVar != null) {
            wVar.c(str, Boolean.valueOf(c4));
        }
        return c4;
    }

    @Override // com.bytedance.sdk.component.ux.c
    public Bitmap c(String str) {
        Bitmap c4 = this.f30282c.c((s) str);
        com.bytedance.sdk.component.ux.xv.c.w wVar = this.f30283w;
        if (wVar != null) {
            wVar.w(str, c4);
        }
        return c4;
    }

    @Override // com.bytedance.sdk.component.ux.c
    public void c(double d4) {
        this.f30282c.c(d4);
    }
}
