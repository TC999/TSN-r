package com.bytedance.sdk.component.k.w.c;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.c.w;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements w {

    /* renamed from: c  reason: collision with root package name */
    private long f29910c;

    /* renamed from: w  reason: collision with root package name */
    private String f29915w = "tt_video_reward_full";
    private String xv = "tt_video_brand";
    private String sr = "tt_video_splash";
    private String ux = "tt_video_default";

    /* renamed from: f  reason: collision with root package name */
    private String f29911f = null;

    /* renamed from: r  reason: collision with root package name */
    private String f29914r = null;
    private String ev = null;
    private String gd = null;

    /* renamed from: p  reason: collision with root package name */
    private String f29913p = null;

    /* renamed from: k  reason: collision with root package name */
    private String f29912k = null;

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public void c(String str) {
        if (!TextUtils.isEmpty(this.f29912k) && !this.f29912k.equals(str)) {
            this.f29911f = null;
            this.f29914r = null;
            this.ev = null;
            this.gd = null;
            this.f29913p = null;
        }
        this.f29912k = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public String sr() {
        if (this.f29913p == null) {
            this.f29913p = this.f29912k + File.separator + this.ux;
            File file = new File(this.f29913p);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f29913p;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public void ux() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public String w() {
        if (this.ev == null) {
            this.ev = this.f29912k + File.separator + this.xv;
            File file = new File(this.ev);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ev;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public String xv() {
        if (this.gd == null) {
            this.gd = this.f29912k + File.separator + this.sr;
            File file = new File(this.gd);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.gd;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public long w(sr srVar) {
        return this.f29910c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public String c() {
        if (this.f29914r == null) {
            this.f29914r = this.f29912k + File.separator + this.f29915w;
            File file = new File(this.f29914r);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f29914r;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c.w
    public boolean c(sr srVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(srVar.ia(), srVar.ux());
        if (cacheInfoByFilePath != null) {
            boolean bk = srVar.bk();
            this.f29910c = cacheInfoByFilePath.mCacheSizeFromZero;
            int w3 = srVar.w() > 0 ? srVar.w() : srVar.f();
            if (bk) {
                w3 = (int) srVar.a();
            }
            return cacheInfoByFilePath.mCacheSizeFromZero >= ((long) w3);
        }
        return false;
    }
}
