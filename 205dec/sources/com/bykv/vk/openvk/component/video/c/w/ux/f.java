package com.bykv.vk.openvk.component.video.c.w.ux;

import com.bykv.vk.openvk.component.video.c.w.gd;
import com.bytedance.sdk.component.w.c.fp;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends c {
    private fp xv;

    public f(fp fpVar, ux uxVar) {
        com.bytedance.sdk.component.w.c.f r3;
        this.xv = fpVar;
        this.f25139c = new ArrayList();
        if (fpVar != null && (r3 = fpVar.r()) != null) {
            for (int i4 = 0; i4 < r3.c(); i4++) {
                this.f25139c.add(new gd.w(r3.c(i4), r3.w(i4)));
            }
        }
        this.f25140w = uxVar;
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.ux.c
    public int c() {
        return this.xv.xv();
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.ux.c
    public String f() {
        return c(this.xv.xv());
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.ux.c
    public InputStream sr() {
        return this.xv.f().xv();
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.ux.c
    public String ux() {
        fp fpVar = this.xv;
        return (fpVar == null || fpVar.ev() == null) ? "http/1.1" : this.xv.ev().toString();
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.ux.c
    public boolean w() {
        return this.xv.xv() >= 200 && this.xv.xv() < 300;
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.ux.c
    public List<gd.w> xv() {
        return this.f25139c;
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.ux.c
    public String c(String str, String str2) {
        return c(str) != null ? c(str).f25102w : str2;
    }
}
