package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.gd.f;
import com.ss.android.socialbase.downloader.network.r;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    public final String f49972c;
    private long sr;
    private long ux;

    /* renamed from: w  reason: collision with root package name */
    public final r f49973w;
    public final int xv;

    public sr(String str, r rVar) throws IOException {
        this.f49972c = str;
        this.xv = rVar.w();
        this.f49973w = rVar;
    }

    public boolean c() {
        return f.xv(this.xv);
    }

    public long ev() {
        if (this.sr <= 0) {
            this.sr = f.c(this.f49973w);
        }
        return this.sr;
    }

    public String f() {
        String w3 = f.w(this.f49973w, "last-modified");
        return TextUtils.isEmpty(w3) ? f.w(this.f49973w, "Last-Modified") : w3;
    }

    public boolean gd() {
        if (com.ss.android.socialbase.downloader.gd.c.c(8)) {
            return f.xv(this.f49973w);
        }
        return f.w(ev());
    }

    public long k() {
        return f.gd(r());
    }

    public long p() {
        if (this.ux <= 0) {
            if (!gd()) {
                String ux = ux();
                if (!TextUtils.isEmpty(ux)) {
                    this.ux = f.w(ux);
                }
            } else {
                this.ux = -1L;
            }
        }
        return this.ux;
    }

    public String r() {
        return f.w(this.f49973w, "Cache-Control");
    }

    public String sr() {
        return this.f49973w.c("Content-Type");
    }

    public String ux() {
        return f.w(this.f49973w, "Content-Range");
    }

    public boolean w() {
        return f.c(this.xv, this.f49973w.c("Accept-Ranges"));
    }

    public String xv() {
        return this.f49973w.c("Etag");
    }
}
