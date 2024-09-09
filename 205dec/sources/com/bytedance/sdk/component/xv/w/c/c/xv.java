package com.bytedance.sdk.component.xv.w.c.c;

import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.s;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv {

    /* renamed from: c  reason: collision with root package name */
    public final n f30763c;

    /* renamed from: w  reason: collision with root package name */
    public final ba f30764w;

    xv(n nVar, ba baVar) {
        this.f30763c = nVar;
        this.f30764w = baVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r3.a().sr() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(com.bytedance.sdk.component.xv.w.ba r3, com.bytedance.sdk.component.xv.w.n r4) {
        /*
            int r0 = r3.xv()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.c(r0)
            if (r0 != 0) goto L5a
            com.bytedance.sdk.component.xv.w.sr r0 = r3.a()
            int r0 = r0.xv()
            r1 = -1
            if (r0 != r1) goto L5a
            com.bytedance.sdk.component.xv.w.sr r0 = r3.a()
            boolean r0 = r0.ux()
            if (r0 != 0) goto L5a
            com.bytedance.sdk.component.xv.w.sr r0 = r3.a()
            boolean r0 = r0.sr()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.bytedance.sdk.component.xv.w.sr r3 = r3.a()
            boolean r3 = r3.w()
            if (r3 != 0) goto L6f
            com.bytedance.sdk.component.xv.w.sr r3 = r4.r()
            boolean r3 = r3.w()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.c.c.xv.c(com.bytedance.sdk.component.xv.w.ba, com.bytedance.sdk.component.xv.w.n):boolean");
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private int f30765a;

        /* renamed from: c  reason: collision with root package name */
        final long f30766c;
        private Date ev;

        /* renamed from: f  reason: collision with root package name */
        private Date f30767f;
        private long gd;

        /* renamed from: k  reason: collision with root package name */
        private String f30768k;

        /* renamed from: p  reason: collision with root package name */
        private long f30769p;

        /* renamed from: r  reason: collision with root package name */
        private String f30770r;
        private Date sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        final n f30771w;
        final ba xv;

        public c(long j4, n nVar, ba baVar) {
            this.f30765a = -1;
            this.f30766c = j4;
            this.f30771w = nVar;
            this.xv = baVar;
            if (baVar != null) {
                this.gd = baVar.bk();
                this.f30769p = baVar.t();
                s r3 = baVar.r();
                int c4 = r3.c();
                for (int i4 = 0; i4 < c4; i4++) {
                    String c5 = r3.c(i4);
                    String w3 = r3.w(i4);
                    if ("Date".equalsIgnoreCase(c5)) {
                        this.sr = com.bytedance.sdk.component.xv.w.c.xv.sr.c(w3);
                        this.ux = w3;
                    } else if ("Expires".equalsIgnoreCase(c5)) {
                        this.ev = com.bytedance.sdk.component.xv.w.c.xv.sr.c(w3);
                    } else if ("Last-Modified".equalsIgnoreCase(c5)) {
                        this.f30767f = com.bytedance.sdk.component.xv.w.c.xv.sr.c(w3);
                        this.f30770r = w3;
                    } else if ("ETag".equalsIgnoreCase(c5)) {
                        this.f30768k = w3;
                    } else if ("Age".equalsIgnoreCase(c5)) {
                        this.f30765a = com.bytedance.sdk.component.xv.w.c.xv.ux.w(w3, -1);
                    }
                }
            }
        }

        private long sr() {
            Date date = this.sr;
            long max = date != null ? Math.max(0L, this.f30769p - date.getTime()) : 0L;
            int i4 = this.f30765a;
            if (i4 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i4));
            }
            long j4 = this.f30769p;
            return max + (j4 - this.gd) + (this.f30766c - j4);
        }

        private boolean ux() {
            return this.xv.a().xv() == -1 && this.ev == null;
        }

        private xv w() {
            if (this.xv == null) {
                return new xv(this.f30771w, null);
            }
            if (this.f30771w.ev() && this.xv.f() == null) {
                return new xv(this.f30771w, null);
            }
            if (!xv.c(this.xv, this.f30771w)) {
                return new xv(this.f30771w, null);
            }
            com.bytedance.sdk.component.xv.w.sr r3 = this.f30771w.r();
            if (!r3.c() && !c(this.f30771w)) {
                com.bytedance.sdk.component.xv.w.sr a4 = this.xv.a();
                if (a4.p()) {
                    return new xv(null, this.xv);
                }
                long sr = sr();
                long xv = xv();
                if (r3.xv() != -1) {
                    xv = Math.min(xv, TimeUnit.SECONDS.toMillis(r3.xv()));
                }
                long j4 = 0;
                long millis = r3.ev() != -1 ? TimeUnit.SECONDS.toMillis(r3.ev()) : 0L;
                if (!a4.f() && r3.r() != -1) {
                    j4 = TimeUnit.SECONDS.toMillis(r3.r());
                }
                if (!a4.c()) {
                    long j5 = millis + sr;
                    if (j5 < j4 + xv) {
                        ba.c gd = this.xv.gd();
                        if (j5 >= xv) {
                            gd.c("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (sr > 86400000 && ux()) {
                            gd.c("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new xv(null, gd.c());
                    }
                }
                String str = this.f30768k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f30767f != null) {
                    str = this.f30770r;
                } else if (this.sr != null) {
                    str = this.ux;
                } else {
                    return new xv(this.f30771w, null);
                }
                s.c w3 = this.f30771w.xv().w();
                com.bytedance.sdk.component.xv.w.c.c.f30735c.c(w3, str2, str);
                return new xv(this.f30771w.f().c(w3.c()).c(), this.xv);
            }
            return new xv(this.f30771w, null);
        }

        private long xv() {
            com.bytedance.sdk.component.xv.w.sr a4 = this.xv.a();
            if (a4.xv() != -1) {
                return TimeUnit.SECONDS.toMillis(a4.xv());
            }
            if (this.ev != null) {
                Date date = this.sr;
                long time = this.ev.getTime() - (date != null ? date.getTime() : this.f30769p);
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f30767f == null || this.xv.c().c().query() != null) {
                return 0L;
            } else {
                Date date2 = this.sr;
                long time2 = (date2 != null ? date2.getTime() : this.gd) - this.f30767f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        public xv c() {
            xv w3 = w();
            return (w3.f30763c == null || !this.f30771w.r().gd()) ? w3 : new xv(null, null);
        }

        private static boolean c(n nVar) {
            return (nVar.c("If-Modified-Since") == null && nVar.c("If-None-Match") == null) ? false : true;
        }
    }
}
