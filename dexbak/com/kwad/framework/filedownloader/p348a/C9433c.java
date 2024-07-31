package com.kwad.framework.filedownloader.p348a;

import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10972j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.kwad.framework.filedownloader.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9433c implements InterfaceC9432b {
    protected URLConnection afi;

    /* renamed from: com.kwad.framework.filedownloader.a.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9434a {
        private Proxy afj;
        private Integer afk;
        private Integer afl;
    }

    /* renamed from: com.kwad.framework.filedownloader.a.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9435b implements C9492c.InterfaceC9494b {
        private final C9434a afm;

        public C9435b() {
            this(null);
        }

        @Override // com.kwad.framework.filedownloader.p353f.C9492c.InterfaceC9494b
        /* renamed from: be */
        public final InterfaceC9432b mo24736be(String str) {
            return new C9433c(str, this.afm);
        }

        private C9435b(C9434a c9434a) {
            this.afm = null;
        }
    }

    public C9433c(String str, C9434a c9434a) {
        this(new URL(str), c9434a);
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    public final void addHeader(String str, String str2) {
        this.afi.addRequestProperty(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    /* renamed from: bd */
    public final String mo24750bd(String str) {
        return this.afi.getHeaderField(str);
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    public final void execute() {
        this.afi.connect();
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    public final InputStream getInputStream() {
        return ((InterfaceC10972j) ServiceProvider.get(InterfaceC10972j.class)).wrapInputStream(this.afi.getInputStream());
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    public final int getResponseCode() {
        URLConnection uRLConnection = this.afi;
        if (uRLConnection instanceof HttpURLConnection) {
            try {
                return ((HttpURLConnection) uRLConnection).getResponseCode();
            } catch (Throwable th) {
                throw new IOException(th);
            }
        }
        return 0;
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    /* renamed from: vc */
    public final Map<String, List<String>> mo24749vc() {
        return this.afi.getRequestProperties();
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    /* renamed from: vd */
    public final Map<String, List<String>> mo24748vd() {
        return this.afi.getHeaderFields();
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    /* renamed from: ve */
    public final void mo24747ve() {
    }

    private C9433c(URL url, C9434a c9434a) {
        if (c9434a != null && c9434a.afj != null) {
            this.afi = url.openConnection(c9434a.afj);
        } else {
            this.afi = url.openConnection();
        }
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.afi);
        } catch (Throwable unused) {
        }
        if (c9434a != null) {
            if (c9434a.afk != null) {
                this.afi.setReadTimeout(c9434a.afk.intValue());
            }
            if (c9434a.afl != null) {
                this.afi.setConnectTimeout(c9434a.afl.intValue());
            }
        }
    }
}
