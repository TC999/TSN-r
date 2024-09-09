package com.bytedance.sdk.component.xv.w.c.ux;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.xv.c.fz;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.network.Headers;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {

    /* renamed from: c  reason: collision with root package name */
    static final xv[] f30886c;

    /* renamed from: w  reason: collision with root package name */
    static final Map<com.bytedance.sdk.component.xv.c.f, Integer> f30887w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class c {

        /* renamed from: c  reason: collision with root package name */
        xv[] f30888c;
        private int ev;

        /* renamed from: f  reason: collision with root package name */
        private final com.bytedance.sdk.component.xv.c.ux f30889f;

        /* renamed from: r  reason: collision with root package name */
        private final int f30890r;
        int sr;
        private final List<xv> ux;

        /* renamed from: w  reason: collision with root package name */
        int f30891w;
        int xv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i4, fz fzVar) {
            this(i4, i4, fzVar);
        }

        private int c(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f30888c.length;
                while (true) {
                    length--;
                    i5 = this.f30891w;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    xv[] xvVarArr = this.f30888c;
                    i4 -= xvVarArr[length].gd;
                    this.sr -= xvVarArr[length].gd;
                    this.xv--;
                    i6++;
                }
                xv[] xvVarArr2 = this.f30888c;
                System.arraycopy(xvVarArr2, i5 + 1, xvVarArr2, i5 + 1 + i6, this.xv);
                this.f30891w += i6;
            }
            return i6;
        }

        private int ev() throws IOException {
            return this.f30889f.ev() & 255;
        }

        private void f() throws IOException {
            this.ux.add(new xv(sr.c(xv()), xv()));
        }

        private void r() throws IOException {
            c(-1, new xv(sr.c(xv()), xv()));
        }

        private void sr() {
            int i4 = this.ev;
            int i5 = this.sr;
            if (i4 < i5) {
                if (i4 == 0) {
                    ux();
                } else {
                    c(i5 - i4);
                }
            }
        }

        private void ux() {
            Arrays.fill(this.f30888c, (Object) null);
            this.f30891w = this.f30888c.length - 1;
            this.xv = 0;
            this.sr = 0;
        }

        private int xv(int i4) {
            return this.f30891w + 1 + i4;
        }

        public List<xv> w() {
            ArrayList arrayList = new ArrayList(this.ux);
            this.ux.clear();
            return arrayList;
        }

        c(int i4, int i5, fz fzVar) {
            this.ux = new ArrayList();
            xv[] xvVarArr = new xv[8];
            this.f30888c = xvVarArr;
            this.f30891w = xvVarArr.length - 1;
            this.xv = 0;
            this.sr = 0;
            this.f30890r = i4;
            this.ev = i5;
            this.f30889f = com.bytedance.sdk.component.xv.c.a.c(fzVar);
        }

        com.bytedance.sdk.component.xv.c.f xv() throws IOException {
            int ev = ev();
            boolean z3 = (ev & 128) == 128;
            int c4 = c(ev, 127);
            if (z3) {
                return com.bytedance.sdk.component.xv.c.f.c(k.c().c(this.f30889f.r(c4)));
            }
            return this.f30889f.xv(c4);
        }

        private void w(int i4) throws IOException {
            if (r(i4)) {
                this.ux.add(sr.f30886c[i4]);
                return;
            }
            int xv = xv(i4 - sr.f30886c.length);
            if (xv >= 0) {
                xv[] xvVarArr = this.f30888c;
                if (xv <= xvVarArr.length - 1) {
                    this.ux.add(xvVarArr[xv]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private com.bytedance.sdk.component.xv.c.f f(int i4) {
            if (r(i4)) {
                return sr.f30886c[i4].f30908r;
            }
            return this.f30888c[xv(i4 - sr.f30886c.length)].f30908r;
        }

        private boolean r(int i4) {
            return i4 >= 0 && i4 <= sr.f30886c.length - 1;
        }

        private void sr(int i4) throws IOException {
            this.ux.add(new xv(f(i4), xv()));
        }

        private void ux(int i4) throws IOException {
            c(-1, new xv(f(i4), xv()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() throws IOException {
            while (!this.f30889f.ux()) {
                int ev = this.f30889f.ev() & 255;
                if (ev == 128) {
                    throw new IOException("index == 0");
                }
                if ((ev & 128) == 128) {
                    w(c(ev, 127) - 1);
                } else if (ev == 64) {
                    r();
                } else if ((ev & 64) == 64) {
                    ux(c(ev, 63) - 1);
                } else if ((ev & 32) == 32) {
                    int c4 = c(ev, 31);
                    this.ev = c4;
                    if (c4 >= 0 && c4 <= this.f30890r) {
                        sr();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.ev);
                    }
                } else if (ev != 16 && ev != 0) {
                    sr(c(ev, 15) - 1);
                } else {
                    f();
                }
            }
        }

        private void c(int i4, xv xvVar) {
            this.ux.add(xvVar);
            int i5 = xvVar.gd;
            if (i4 != -1) {
                i5 -= this.f30888c[xv(i4)].gd;
            }
            int i6 = this.ev;
            if (i5 > i6) {
                ux();
                return;
            }
            int c4 = c((this.sr + i5) - i6);
            if (i4 == -1) {
                int i7 = this.xv + 1;
                xv[] xvVarArr = this.f30888c;
                if (i7 > xvVarArr.length) {
                    xv[] xvVarArr2 = new xv[xvVarArr.length * 2];
                    System.arraycopy(xvVarArr, 0, xvVarArr2, xvVarArr.length, xvVarArr.length);
                    this.f30891w = this.f30888c.length - 1;
                    this.f30888c = xvVarArr2;
                }
                int i8 = this.f30891w;
                this.f30891w = i8 - 1;
                this.f30888c[i8] = xvVar;
                this.xv++;
            } else {
                this.f30888c[i4 + xv(i4) + c4] = xvVar;
            }
            this.sr += i5;
        }

        int c(int i4, int i5) throws IOException {
            int i6 = i4 & i5;
            if (i6 < i5) {
                return i6;
            }
            int i7 = 0;
            while (true) {
                int ev = ev();
                if ((ev & 128) == 0) {
                    return i5 + (ev << i7);
                }
                i5 += (ev & 127) << i7;
                i7 += 7;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class w {

        /* renamed from: c  reason: collision with root package name */
        int f30892c;
        private final boolean ev;

        /* renamed from: f  reason: collision with root package name */
        int f30893f;
        private int gd;

        /* renamed from: p  reason: collision with root package name */
        private boolean f30894p;

        /* renamed from: r  reason: collision with root package name */
        private final com.bytedance.sdk.component.xv.c.xv f30895r;
        int sr;
        int ux;

        /* renamed from: w  reason: collision with root package name */
        int f30896w;
        xv[] xv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public w(com.bytedance.sdk.component.xv.c.xv xvVar) {
            this(4096, true, xvVar);
        }

        private void c() {
            Arrays.fill(this.xv, (Object) null);
            this.sr = this.xv.length - 1;
            this.ux = 0;
            this.f30893f = 0;
        }

        private int w(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.xv.length;
                while (true) {
                    length--;
                    i5 = this.sr;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    xv[] xvVarArr = this.xv;
                    i4 -= xvVarArr[length].gd;
                    this.f30893f -= xvVarArr[length].gd;
                    this.ux--;
                    i6++;
                }
                xv[] xvVarArr2 = this.xv;
                System.arraycopy(xvVarArr2, i5 + 1, xvVarArr2, i5 + 1 + i6, this.ux);
                xv[] xvVarArr3 = this.xv;
                int i7 = this.sr;
                Arrays.fill(xvVarArr3, i7 + 1, i7 + 1 + i6, (Object) null);
                this.sr += i6;
            }
            return i6;
        }

        w(int i4, boolean z3, com.bytedance.sdk.component.xv.c.xv xvVar) {
            this.gd = Integer.MAX_VALUE;
            xv[] xvVarArr = new xv[8];
            this.xv = xvVarArr;
            this.sr = xvVarArr.length - 1;
            this.ux = 0;
            this.f30893f = 0;
            this.f30892c = i4;
            this.f30896w = i4;
            this.ev = z3;
            this.f30895r = xvVar;
        }

        private void c(xv xvVar) {
            int i4 = xvVar.gd;
            int i5 = this.f30896w;
            if (i4 > i5) {
                c();
                return;
            }
            w((this.f30893f + i4) - i5);
            int i6 = this.ux + 1;
            xv[] xvVarArr = this.xv;
            if (i6 > xvVarArr.length) {
                xv[] xvVarArr2 = new xv[xvVarArr.length * 2];
                System.arraycopy(xvVarArr, 0, xvVarArr2, xvVarArr.length, xvVarArr.length);
                this.sr = this.xv.length - 1;
                this.xv = xvVarArr2;
            }
            int i7 = this.sr;
            this.sr = i7 - 1;
            this.xv[i7] = xvVar;
            this.ux++;
            this.f30893f += i4;
        }

        private void w() {
            int i4 = this.f30896w;
            int i5 = this.f30893f;
            if (i4 < i5) {
                if (i4 == 0) {
                    c();
                } else {
                    w(i5 - i4);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(List<xv> list) throws IOException {
            int i4;
            int i5;
            if (this.f30894p) {
                int i6 = this.gd;
                if (i6 < this.f30896w) {
                    c(i6, 31, 32);
                }
                this.f30894p = false;
                this.gd = Integer.MAX_VALUE;
                c(this.f30896w, 31, 32);
            }
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                xv xvVar = list.get(i7);
                com.bytedance.sdk.component.xv.c.f f4 = xvVar.f30908r.f();
                com.bytedance.sdk.component.xv.c.f fVar = xvVar.ev;
                Integer num = sr.f30887w.get(f4);
                if (num != null) {
                    i4 = num.intValue() + 1;
                    if (i4 > 1 && i4 < 8) {
                        xv[] xvVarArr = sr.f30886c;
                        if (com.bytedance.sdk.component.xv.w.c.xv.c(xvVarArr[i4 - 1].ev, fVar)) {
                            i5 = i4;
                        } else if (com.bytedance.sdk.component.xv.w.c.xv.c(xvVarArr[i4].ev, fVar)) {
                            i5 = i4;
                            i4++;
                        }
                    }
                    i5 = i4;
                    i4 = -1;
                } else {
                    i4 = -1;
                    i5 = -1;
                }
                if (i4 == -1) {
                    int i8 = this.sr + 1;
                    int length = this.xv.length;
                    while (true) {
                        if (i8 >= length) {
                            break;
                        }
                        if (com.bytedance.sdk.component.xv.w.c.xv.c(this.xv[i8].f30908r, f4)) {
                            if (com.bytedance.sdk.component.xv.w.c.xv.c(this.xv[i8].ev, fVar)) {
                                i4 = sr.f30886c.length + (i8 - this.sr);
                                break;
                            } else if (i5 == -1) {
                                i5 = (i8 - this.sr) + sr.f30886c.length;
                            }
                        }
                        i8++;
                    }
                }
                if (i4 != -1) {
                    c(i4, 127, 128);
                } else if (i5 == -1) {
                    this.f30895r.gd(64);
                    c(f4);
                    c(fVar);
                    c(xvVar);
                } else if (f4.c(xv.f30905c) && !xv.f30906f.equals(f4)) {
                    c(i5, 15, 0);
                    c(fVar);
                } else {
                    c(i5, 63, 64);
                    c(fVar);
                    c(xvVar);
                }
            }
        }

        void c(int i4, int i5, int i6) {
            if (i4 < i5) {
                this.f30895r.gd(i4 | i6);
                return;
            }
            this.f30895r.gd(i6 | i5);
            int i7 = i4 - i5;
            while (i7 >= 128) {
                this.f30895r.gd(128 | (i7 & 127));
                i7 >>>= 7;
            }
            this.f30895r.gd(i7);
        }

        void c(com.bytedance.sdk.component.xv.c.f fVar) throws IOException {
            if (this.ev && k.c().c(fVar) < fVar.r()) {
                com.bytedance.sdk.component.xv.c.xv xvVar = new com.bytedance.sdk.component.xv.c.xv();
                k.c().c(fVar, xvVar);
                com.bytedance.sdk.component.xv.c.f t3 = xvVar.t();
                c(t3.r(), 127, 128);
                this.f30895r.w(t3);
                return;
            }
            c(fVar.r(), 127, 0);
            this.f30895r.w(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(int i4) {
            this.f30892c = i4;
            int min = Math.min(i4, 16384);
            int i5 = this.f30896w;
            if (i5 == min) {
                return;
            }
            if (min < i5) {
                this.gd = Math.min(this.gd, min);
            }
            this.f30894p = true;
            this.f30896w = min;
            w();
        }
    }

    static {
        com.bytedance.sdk.component.xv.c.f fVar = xv.xv;
        com.bytedance.sdk.component.xv.c.f fVar2 = xv.sr;
        com.bytedance.sdk.component.xv.c.f fVar3 = xv.ux;
        com.bytedance.sdk.component.xv.c.f fVar4 = xv.f30907w;
        f30886c = new xv[]{new xv(xv.f30906f, ""), new xv(fVar, "GET"), new xv(fVar, "POST"), new xv(fVar2, TTPathConst.sSeparator), new xv(fVar2, "/index.html"), new xv(fVar3, "http"), new xv(fVar3, "https"), new xv(fVar4, "200"), new xv(fVar4, "204"), new xv(fVar4, "206"), new xv(fVar4, "304"), new xv(fVar4, "400"), new xv(fVar4, "404"), new xv(fVar4, "500"), new xv("accept-charset", ""), new xv("accept-encoding", Headers.VALUE_ACCEPT_ENCODING), new xv("accept-language", ""), new xv("accept-ranges", ""), new xv("accept", ""), new xv("access-control-allow-origin", ""), new xv("age", ""), new xv("allow", ""), new xv("authorization", ""), new xv("cache-control", ""), new xv("content-disposition", ""), new xv("content-encoding", ""), new xv("content-language", ""), new xv("content-length", ""), new xv("content-location", ""), new xv("content-range", ""), new xv("content-type", ""), new xv("cookie", ""), new xv("date", ""), new xv(DownloadModel.ETAG, ""), new xv("expect", ""), new xv("expires", ""), new xv("from", ""), new xv("host", ""), new xv("if-match", ""), new xv("if-modified-since", ""), new xv("if-none-match", ""), new xv("if-range", ""), new xv("if-unmodified-since", ""), new xv("last-modified", ""), new xv("link", ""), new xv("location", ""), new xv("max-forwards", ""), new xv("proxy-authenticate", ""), new xv("proxy-authorization", ""), new xv("range", ""), new xv("referer", ""), new xv("refresh", ""), new xv("retry-after", ""), new xv("server", ""), new xv("set-cookie", ""), new xv("strict-transport-security", ""), new xv("transfer-encoding", ""), new xv("user-agent", ""), new xv("vary", ""), new xv("via", ""), new xv("www-authenticate", "")};
        f30887w = c();
    }

    private static Map<com.bytedance.sdk.component.xv.c.f, Integer> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f30886c.length);
        int i4 = 0;
        while (true) {
            xv[] xvVarArr = f30886c;
            if (i4 < xvVarArr.length) {
                if (!linkedHashMap.containsKey(xvVarArr[i4].f30908r)) {
                    linkedHashMap.put(xvVarArr[i4].f30908r, Integer.valueOf(i4));
                }
                i4++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static com.bytedance.sdk.component.xv.c.f c(com.bytedance.sdk.component.xv.c.f fVar) throws IOException {
        int r3 = fVar.r();
        for (int i4 = 0; i4 < r3; i4++) {
            byte c4 = fVar.c(i4);
            if (c4 >= 65 && c4 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.c());
            }
        }
        return fVar;
    }
}
