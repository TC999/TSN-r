package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.Cif;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DownloadManager.java */
/* renamed from: com.amap.api.col.3l.t6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class t6 {

    /* renamed from: a  reason: collision with root package name */
    private v6 f9068a;

    /* renamed from: b  reason: collision with root package name */
    private Cif f9069b;

    /* renamed from: c  reason: collision with root package name */
    private long f9070c;

    /* renamed from: d  reason: collision with root package name */
    private long f9071d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DownloadManager.java */
    /* renamed from: com.amap.api.col.3l.t6$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void onDownload(byte[] bArr, long j4);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.3l.t6$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        x6 f9072a;

        /* renamed from: b  reason: collision with root package name */
        long f9073b;

        private b() {
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    public t6(Cif cif) {
        this(cif, (byte) 0);
    }

    public final void a() {
        v6 v6Var = this.f9068a;
        if (v6Var != null) {
            v6Var.k();
        }
    }

    public final void b(a aVar) {
        try {
            v6 v6Var = new v6();
            this.f9068a = v6Var;
            v6Var.t(this.f9071d);
            this.f9068a.l(this.f9070c);
            q6.b();
            if (q6.g(this.f9069b)) {
                this.f9069b.setDegradeType(Cif.b.NEVER_GRADE);
                this.f9068a.m(this.f9069b, aVar);
                return;
            }
            this.f9069b.setDegradeType(Cif.b.DEGRADE_ONLY);
            this.f9068a.m(this.f9069b, aVar);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private t6(Cif cif, byte b4) {
        this(cif, 0L, -1L, false);
    }

    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.3l.t6$c */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        Map<String, List<a>> f9074a;

        /* renamed from: b  reason: collision with root package name */
        Map<String, String> f9075b;

        private c() {
            this.f9074a = new HashMap(8);
            this.f9075b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f9074a.equals(cVar.f9074a) && this.f9075b.equals(cVar.f9075b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f9074a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f9075b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        /* synthetic */ c(byte b4) {
            this();
        }
    }

    public t6(Cif cif, long j4, long j5, boolean z3) {
        this.f9069b = cif;
        this.f9070c = j4;
        this.f9071d = j5;
        cif.setHttpProtocol(z3 ? Cif.c.HTTPS : Cif.c.HTTP);
        this.f9069b.setDegradeAbility(Cif.a.SINGLE);
    }
}
