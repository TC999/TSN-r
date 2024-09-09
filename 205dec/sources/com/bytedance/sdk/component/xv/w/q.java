package com.bytedance.sdk.component.xv.w;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class q extends ck {

    /* renamed from: a  reason: collision with root package name */
    private final List<w> f31084a;
    private long bk = -1;
    private final com.bytedance.sdk.component.xv.c.f gd;

    /* renamed from: k  reason: collision with root package name */
    private final i f31085k;

    /* renamed from: p  reason: collision with root package name */
    private final i f31086p;

    /* renamed from: c  reason: collision with root package name */
    public static final i f31080c = i.c("multipart/mixed");

    /* renamed from: w  reason: collision with root package name */
    public static final i f31083w = i.c("multipart/alternative");
    public static final i xv = i.c("multipart/digest");
    public static final i sr = i.c("multipart/parallel");
    public static final i ux = i.c("multipart/form-data");

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f31081f = {58, 32};

    /* renamed from: r  reason: collision with root package name */
    private static final byte[] f31082r = {13, 10};
    private static final byte[] ev = {45, 45};

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        private final com.bytedance.sdk.component.xv.c.f f31087c;

        /* renamed from: w  reason: collision with root package name */
        private i f31088w;
        private final List<w> xv;

        public c() {
            this(UUID.randomUUID().toString());
        }

        public c c(i iVar) {
            if (iVar != null) {
                if (iVar.c().equals("multipart")) {
                    this.f31088w = iVar;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + iVar);
            }
            throw new NullPointerException("type == null");
        }

        public c(String str) {
            this.f31088w = q.f31080c;
            this.xv = new ArrayList();
            this.f31087c = com.bytedance.sdk.component.xv.c.f.c(str);
        }

        public c c(String str, String str2, ck ckVar) {
            return c(w.c(str, str2, ckVar));
        }

        public c c(w wVar) {
            if (wVar != null) {
                this.xv.add(wVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public q c() {
            if (!this.xv.isEmpty()) {
                return new q(this.f31087c, this.f31088w, this.xv);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    q(com.bytedance.sdk.component.xv.c.f fVar, i iVar, List<w> list) {
        this.gd = fVar;
        this.f31086p = iVar;
        this.f31085k = i.c(iVar + "; boundary=" + fVar.c());
        this.f31084a = com.bytedance.sdk.component.xv.w.c.xv.c(list);
    }

    @Override // com.bytedance.sdk.component.xv.w.ck
    public i c() {
        return this.f31085k;
    }

    @Override // com.bytedance.sdk.component.xv.w.ck
    public long w() throws IOException {
        long j4 = this.bk;
        if (j4 != -1) {
            return j4;
        }
        long c4 = c((com.bytedance.sdk.component.xv.c.sr) null, true);
        this.bk = c4;
        return c4;
    }

    @Override // com.bytedance.sdk.component.xv.w.ck
    public void c(com.bytedance.sdk.component.xv.c.sr srVar) throws IOException {
        c(srVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long c(com.bytedance.sdk.component.xv.c.sr srVar, boolean z3) throws IOException {
        com.bytedance.sdk.component.xv.c.xv xvVar;
        if (z3) {
            srVar = new com.bytedance.sdk.component.xv.c.xv();
            xvVar = srVar;
        } else {
            xvVar = 0;
        }
        int size = this.f31084a.size();
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            w wVar = this.f31084a.get(i4);
            s sVar = wVar.f31089c;
            ck ckVar = wVar.f31090w;
            srVar.xv(ev);
            srVar.w(this.gd);
            srVar.xv(f31082r);
            if (sVar != null) {
                int c4 = sVar.c();
                for (int i5 = 0; i5 < c4; i5++) {
                    srVar.w(sVar.c(i5)).xv(f31081f).w(sVar.w(i5)).xv(f31082r);
                }
            }
            i c5 = ckVar.c();
            if (c5 != null) {
                srVar.w("Content-Type: ").w(c5.toString()).xv(f31082r);
            }
            long w3 = ckVar.w();
            if (w3 != -1) {
                srVar.w("Content-Length: ").a(w3).xv(f31082r);
            } else if (z3) {
                xvVar.s();
                return -1L;
            }
            byte[] bArr = f31082r;
            srVar.xv(bArr);
            if (z3) {
                j4 += w3;
            } else {
                ckVar.c(srVar);
            }
            srVar.xv(bArr);
        }
        byte[] bArr2 = ev;
        srVar.xv(bArr2);
        srVar.w(this.gd);
        srVar.xv(bArr2);
        srVar.xv(f31082r);
        if (z3) {
            long w4 = j4 + xvVar.w();
            xvVar.s();
            return w4;
        }
        return j4;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w {

        /* renamed from: c  reason: collision with root package name */
        final s f31089c;

        /* renamed from: w  reason: collision with root package name */
        final ck f31090w;

        private w(s sVar, ck ckVar) {
            this.f31089c = sVar;
            this.f31090w = ckVar;
        }

        public static w c(s sVar, ck ckVar) {
            if (ckVar != null) {
                if (sVar != null && sVar.c("Content-Type") != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if (sVar != null && sVar.c("Content-Length") != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                return new w(sVar, ckVar);
            }
            throw new NullPointerException("body == null");
        }

        public static w c(String str, String str2, ck ckVar) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                q.c(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    q.c(sb, str2);
                }
                return c(s.c(Headers.KEY_CONTENT_DISPOSITION, sb.toString()), ckVar);
            }
            throw new NullPointerException("name == null");
        }
    }

    static StringBuilder c(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }
}
