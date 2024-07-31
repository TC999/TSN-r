package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CacheControl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpDate;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CacheStrategy {

    /* renamed from: a */
    public final Request f898a;

    /* renamed from: b */
    public final Response f899b;

    CacheStrategy(Request request, Response response) {
        this.f898a = request;
        this.f899b = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r3.m58847b().m58440b() == false) goto L22;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m58809a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response r3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request r4) {
        /*
            int r0 = r3.m58846c()
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
            java.lang.String r0 = r3.m58849a(r0)
            if (r0 != 0) goto L5a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r3.m58847b()
            int r0 = r0.m58438d()
            r1 = -1
            if (r0 != r1) goto L5a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r3.m58847b()
            boolean r0 = r0.m58439c()
            if (r0 != 0) goto L5a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r3.m58847b()
            boolean r0 = r0.m58440b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r3 = r3.m58847b()
            boolean r3 = r3.m58433i()
            if (r3 != 0) goto L6f
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r3 = r4.m58210b()
            boolean r3 = r3.m58433i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.CacheStrategy.m58809a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y):boolean");
    }

    /* compiled from: CacheStrategy.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1021a {

        /* renamed from: a */
        final long f900a;

        /* renamed from: b */
        final Request f901b;

        /* renamed from: c */
        final Response f902c;

        /* renamed from: d */
        private Date f903d;

        /* renamed from: e */
        private String f904e;

        /* renamed from: f */
        private Date f905f;

        /* renamed from: g */
        private String f906g;

        /* renamed from: h */
        private Date f907h;

        /* renamed from: i */
        private long f908i;

        /* renamed from: j */
        private long f909j;

        /* renamed from: k */
        private String f910k;

        /* renamed from: l */
        private int f911l;

        public C1021a(long j, Request request, Response response) {
            this.f911l = -1;
            this.f900a = j;
            this.f901b = request;
            this.f902c = response;
            if (response != null) {
                this.f908i = response.m58837l();
                this.f909j = response.m58839j();
                Headers m58844e = response.m58844e();
                int m58338b = m58844e.m58338b();
                for (int i = 0; i < m58338b; i++) {
                    String m58341a = m58844e.m58341a(i);
                    String m58337b = m58844e.m58337b(i);
                    if ("Date".equalsIgnoreCase(m58341a)) {
                        this.f903d = HttpDate.m58773a(m58337b);
                        this.f904e = m58337b;
                    } else if ("Expires".equalsIgnoreCase(m58341a)) {
                        this.f907h = HttpDate.m58773a(m58337b);
                    } else if ("Last-Modified".equalsIgnoreCase(m58341a)) {
                        this.f905f = HttpDate.m58773a(m58337b);
                        this.f906g = m58337b;
                    } else if ("ETag".equalsIgnoreCase(m58341a)) {
                        this.f910k = m58337b;
                    } else if (HttpHeaders.Names.AGE.equalsIgnoreCase(m58341a)) {
                        this.f911l = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpHeaders.m58767a(m58337b, -1);
                    }
                }
            }
        }

        /* renamed from: b */
        private long m58806b() {
            Date date = this.f903d;
            long max = date != null ? Math.max(0L, this.f909j - date.getTime()) : 0L;
            int i = this.f911l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.f909j;
            return max + (j - this.f908i) + (this.f900a - j);
        }

        /* renamed from: c */
        private long m58805c() {
            CacheControl m58847b = this.f902c.m58847b();
            if (m58847b.m58438d() != -1) {
                return TimeUnit.SECONDS.toMillis(m58847b.m58438d());
            }
            if (this.f907h != null) {
                Date date = this.f903d;
                long time = this.f907h.getTime() - (date != null ? date.getTime() : this.f909j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f905f == null || this.f902c.m58838k().m58205g().m58303k() != null) {
                return 0L;
            } else {
                Date date2 = this.f903d;
                long time2 = (date2 != null ? date2.getTime() : this.f908i) - this.f905f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        /* renamed from: d */
        private CacheStrategy m58804d() {
            if (this.f902c == null) {
                return new CacheStrategy(this.f901b, null);
            }
            if (this.f901b.m58208d() && this.f902c.m58845d() == null) {
                return new CacheStrategy(this.f901b, null);
            }
            if (!CacheStrategy.m58809a(this.f902c, this.f901b)) {
                return new CacheStrategy(this.f901b, null);
            }
            CacheControl m58210b = this.f901b.m58210b();
            if (!m58210b.m58434h() && !m58807a(this.f901b)) {
                CacheControl m58847b = this.f902c.m58847b();
                if (m58847b.m58442a()) {
                    return new CacheStrategy(null, this.f902c);
                }
                long m58806b = m58806b();
                long m58805c = m58805c();
                if (m58210b.m58438d() != -1) {
                    m58805c = Math.min(m58805c, TimeUnit.SECONDS.toMillis(m58210b.m58438d()));
                }
                long j = 0;
                long millis = m58210b.m58436f() != -1 ? TimeUnit.SECONDS.toMillis(m58210b.m58436f()) : 0L;
                if (!m58847b.m58435g() && m58210b.m58437e() != -1) {
                    j = TimeUnit.SECONDS.toMillis(m58210b.m58437e());
                }
                if (!m58847b.m58434h()) {
                    long j2 = millis + m58806b;
                    if (j2 < j + m58805c) {
                        Response.C1017a m58841h = this.f902c.m58841h();
                        if (j2 >= m58805c) {
                            m58841h.m58825a(HttpHeaders.Names.WARNING, "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (m58806b > 86400000 && m58803e()) {
                            m58841h.m58825a(HttpHeaders.Names.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new CacheStrategy(null, m58841h.m58836a());
                    }
                }
                String str = this.f910k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = HttpHeaders.Names.IF_NONE_MATCH;
                } else if (this.f905f != null) {
                    str = this.f906g;
                } else if (this.f903d != null) {
                    str = this.f904e;
                } else {
                    return new CacheStrategy(this.f901b, null);
                }
                Headers.C1076a m58342a = this.f901b.m58209c().m58342a();
                Internal.f891a.mo58231a(m58342a, str2, str);
                return new CacheStrategy(this.f901b.m58206f().m58202a(m58342a.m58335a()).m58204a(), this.f902c);
            }
            return new CacheStrategy(this.f901b, null);
        }

        /* renamed from: e */
        private boolean m58803e() {
            return this.f902c.m58847b().m58438d() == -1 && this.f907h == null;
        }

        /* renamed from: a */
        public CacheStrategy m58808a() {
            CacheStrategy m58804d = m58804d();
            return (m58804d.f898a == null || !this.f901b.m58210b().m58432j()) ? m58804d : new CacheStrategy(null, null);
        }

        /* renamed from: a */
        private static boolean m58807a(Request request) {
            return (request.m58211a("If-Modified-Since") == null && request.m58211a(HttpHeaders.Names.IF_NONE_MATCH) == null) ? false : true;
        }
    }
}
