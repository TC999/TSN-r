package com.bytedance.sdk.component.xv.w;

import cn.jpush.android.local.JPushConstants;
import com.bytedance.sdk.component.xv.w.c.c.sr;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv implements Closeable, Flushable {

    /* renamed from: c  reason: collision with root package name */
    final com.bytedance.sdk.component.xv.w.c.c.f f31115c;

    /* renamed from: w  reason: collision with root package name */
    final com.bytedance.sdk.component.xv.w.c.c.sr f31116w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c extends y {

        /* renamed from: c  reason: collision with root package name */
        final sr.xv f31117c;
        private final String sr;

        /* renamed from: w  reason: collision with root package name */
        private final com.bytedance.sdk.component.xv.c.ux f31118w;
        private final String xv;

        @Override // com.bytedance.sdk.component.xv.w.y
        public i c() {
            String str = this.xv;
            if (str != null) {
                return i.c(str);
            }
            return null;
        }

        @Override // com.bytedance.sdk.component.xv.w.y
        public long w() {
            try {
                String str = this.sr;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.y
        public com.bytedance.sdk.component.xv.c.ux xv() {
            return this.f31118w;
        }
    }

    private void c(sr.c cVar) {
        if (cVar != null) {
            try {
                cVar.xv();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f31116w.close();
    }

    public void delete() throws IOException {
        this.f31116w.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f31116w.flush();
    }

    void update(ba baVar, ba baVar2) {
        sr.c cVar;
        w wVar = new w(baVar2);
        try {
            cVar = ((c) baVar.ev()).f31117c.c();
            if (cVar != null) {
                try {
                    wVar.c(cVar);
                    cVar.w();
                } catch (IOException unused) {
                    c(cVar);
                }
            }
        } catch (IOException unused2) {
            cVar = null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static final class w {

        /* renamed from: c  reason: collision with root package name */
        private static final String f31119c = com.bytedance.sdk.component.xv.w.c.r.ux.w().xv() + "-Sent-Millis";

        /* renamed from: w  reason: collision with root package name */
        private static final String f31120w = com.bytedance.sdk.component.xv.w.c.r.ux.w().xv() + "-Received-Millis";

        /* renamed from: a  reason: collision with root package name */
        private final long f31121a;
        private final String ev;

        /* renamed from: f  reason: collision with root package name */
        private final ls f31122f;
        private final s gd;

        /* renamed from: k  reason: collision with root package name */
        private final long f31123k;

        /* renamed from: p  reason: collision with root package name */
        private final ia f31124p;

        /* renamed from: r  reason: collision with root package name */
        private final int f31125r;
        private final s sr;
        private final String ux;
        private final String xv;

        w(ba baVar) {
            this.xv = baVar.c().c().toString();
            this.sr = com.bytedance.sdk.component.xv.w.c.xv.ux.w(baVar);
            this.ux = baVar.c().w();
            this.f31122f = baVar.w();
            this.f31125r = baVar.xv();
            this.ev = baVar.ux();
            this.gd = baVar.r();
            this.f31124p = baVar.f();
            this.f31123k = baVar.bk();
            this.f31121a = baVar.t();
        }

        public void c(sr.c cVar) throws IOException {
            com.bytedance.sdk.component.xv.c.sr c4 = com.bytedance.sdk.component.xv.c.a.c(cVar.c(0));
            c4.w(this.xv).gd(10);
            c4.w(this.ux).gd(10);
            c4.a(this.sr.c()).gd(10);
            int c5 = this.sr.c();
            for (int i4 = 0; i4 < c5; i4++) {
                c4.w(this.sr.c(i4)).w(": ").w(this.sr.w(i4)).gd(10);
            }
            c4.w(new com.bytedance.sdk.component.xv.w.c.xv.k(this.f31122f, this.f31125r, this.ev).toString()).gd(10);
            c4.a(this.gd.c() + 2).gd(10);
            int c6 = this.gd.c();
            for (int i5 = 0; i5 < c6; i5++) {
                c4.w(this.gd.c(i5)).w(": ").w(this.gd.w(i5)).gd(10);
            }
            c4.w(f31119c).w(": ").a(this.f31123k).gd(10);
            c4.w(f31120w).w(": ").a(this.f31121a).gd(10);
            if (c()) {
                c4.gd(10);
                c4.w(this.f31124p.w().c()).gd(10);
                c(c4, this.f31124p.xv());
                c(c4, this.f31124p.sr());
                c4.w(this.f31124p.c().c()).gd(10);
            }
            c4.close();
        }

        private boolean c() {
            return this.xv.startsWith(JPushConstants.HTTPS_PRE);
        }

        private void c(com.bytedance.sdk.component.xv.c.sr srVar, List<Certificate> list) throws IOException {
            try {
                srVar.a(list.size()).gd(10);
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    srVar.w(com.bytedance.sdk.component.xv.c.f.c(list.get(i4).getEncoded()).w()).gd(10);
                }
            } catch (CertificateEncodingException e4) {
                throw new IOException(e4.getMessage());
            }
        }
    }
}
