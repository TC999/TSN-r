package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.h;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public final h f49969a;
    public final int bl;

    /* renamed from: n  reason: collision with root package name */
    private long f49970n;
    public final String ok;

    /* renamed from: s  reason: collision with root package name */
    private long f49971s;

    public s(String str, h hVar) throws IOException {
        this.ok = str;
        this.bl = hVar.a();
        this.f49969a = hVar;
    }

    public boolean a() {
        return kf.ok(this.bl, this.f49969a.ok("Accept-Ranges"));
    }

    public String bl() {
        return this.f49969a.ok("Etag");
    }

    public String h() {
        return kf.a(this.f49969a, "Cache-Control");
    }

    public long k() {
        if (this.f49970n <= 0) {
            if (!q()) {
                String n4 = n();
                if (!TextUtils.isEmpty(n4)) {
                    this.f49970n = kf.a(n4);
                }
            } else {
                this.f49970n = -1L;
            }
        }
        return this.f49970n;
    }

    public String kf() {
        String a4 = kf.a(this.f49969a, "last-modified");
        return TextUtils.isEmpty(a4) ? kf.a(this.f49969a, "Last-Modified") : a4;
    }

    public String n() {
        return kf.a(this.f49969a, "Content-Range");
    }

    public boolean ok() {
        return kf.bl(this.bl);
    }

    public long p() {
        if (this.f49971s <= 0) {
            this.f49971s = kf.ok(this.f49969a);
        }
        return this.f49971s;
    }

    public boolean q() {
        if (com.ss.android.socialbase.downloader.q.ok.ok(8)) {
            return kf.bl(this.f49969a);
        }
        return kf.a(p());
    }

    public long r() {
        return kf.q(h());
    }

    public String s() {
        return this.f49969a.ok("Content-Type");
    }
}
