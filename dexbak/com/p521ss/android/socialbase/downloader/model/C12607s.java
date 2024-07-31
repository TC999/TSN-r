package com.p521ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12620h;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;

/* renamed from: com.ss.android.socialbase.downloader.model.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12607s {

    /* renamed from: a */
    public final InterfaceC12620h f35523a;

    /* renamed from: bl */
    public final int f35524bl;

    /* renamed from: n */
    private long f35525n;

    /* renamed from: ok */
    public final String f35526ok;

    /* renamed from: s */
    private long f35527s;

    public C12607s(String str, InterfaceC12620h interfaceC12620h) throws IOException {
        this.f35526ok = str;
        this.f35524bl = interfaceC12620h.mo16918a();
        this.f35523a = interfaceC12620h;
    }

    /* renamed from: a */
    public boolean m16988a() {
        return C12713kf.m16573ok(this.f35524bl, this.f35523a.mo16912ok(HttpHeaders.Names.ACCEPT_RANGES));
    }

    /* renamed from: bl */
    public String m16987bl() {
        return this.f35523a.mo16912ok("Etag");
    }

    /* renamed from: h */
    public String m16986h() {
        return C12713kf.m16615a(this.f35523a, "Cache-Control");
    }

    /* renamed from: k */
    public long m16985k() {
        if (this.f35525n <= 0) {
            if (!m16980q()) {
                String m16983n = m16983n();
                if (!TextUtils.isEmpty(m16983n)) {
                    this.f35525n = C12713kf.m16612a(m16983n);
                }
            } else {
                this.f35525n = -1L;
            }
        }
        return this.f35525n;
    }

    /* renamed from: kf */
    public String m16984kf() {
        String m16615a = C12713kf.m16615a(this.f35523a, "last-modified");
        return TextUtils.isEmpty(m16615a) ? C12713kf.m16615a(this.f35523a, "Last-Modified") : m16615a;
    }

    /* renamed from: n */
    public String m16983n() {
        return C12713kf.m16615a(this.f35523a, HttpHeaders.Names.CONTENT_RANGE);
    }

    /* renamed from: ok */
    public boolean m16982ok() {
        return C12713kf.m16604bl(this.f35524bl);
    }

    /* renamed from: p */
    public long m16981p() {
        if (this.f35527s <= 0) {
            this.f35527s = C12713kf.m16557ok(this.f35523a);
        }
        return this.f35527s;
    }

    /* renamed from: q */
    public boolean m16980q() {
        if (C12717ok.m16510ok(8)) {
            return C12713kf.m16599bl(this.f35523a);
        }
        return C12713kf.m16621a(m16981p());
    }

    /* renamed from: r */
    public long m16979r() {
        return C12713kf.m16526q(m16986h());
    }

    /* renamed from: s */
    public String m16978s() {
        return this.f35523a.mo16912ok("Content-Type");
    }
}
