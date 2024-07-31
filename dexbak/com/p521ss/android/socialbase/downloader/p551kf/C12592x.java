package com.p521ss.android.socialbase.downloader.p551kf;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ss.android.socialbase.downloader.kf.x */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12592x {

    /* renamed from: a */
    final String f35390a;

    /* renamed from: bl */
    final String f35391bl;

    /* renamed from: h */
    private boolean f35392h;

    /* renamed from: k */
    private final AtomicLong f35393k;

    /* renamed from: kf */
    private int f35394kf;

    /* renamed from: n */
    private final List<RunnableC12593z> f35395n;

    /* renamed from: ok */
    final String f35396ok;

    /* renamed from: p */
    private int f35397p;

    /* renamed from: q */
    private String f35398q;

    /* renamed from: s */
    final boolean f35399s;

    public C12592x(String str, boolean z) {
        this.f35395n = new ArrayList();
        this.f35393k = new AtomicLong();
        this.f35396ok = str;
        this.f35399s = z;
        this.f35390a = null;
        this.f35391bl = null;
    }

    /* renamed from: n */
    private String m17189n() {
        if (this.f35398q == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f35396ok);
            sb.append("_");
            String str = this.f35390a;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f35399s);
            this.f35398q = sb.toString();
        }
        return this.f35398q;
    }

    /* renamed from: ok */
    private String m17185ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public synchronized void m17191a(RunnableC12593z runnableC12593z) {
        try {
            this.f35395n.remove(runnableC12593z);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: bl */
    public synchronized void m17190bl() {
        this.f35392h = false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C12592x) {
            return m17189n().equals(((C12592x) obj).m17189n());
        }
        return false;
    }

    public int hashCode() {
        if (this.f35397p == 0) {
            this.f35397p = m17189n().hashCode();
        }
        return this.f35397p;
    }

    /* renamed from: s */
    public synchronized boolean m17184s() {
        return this.f35392h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f35396ok + "', ip='" + this.f35390a + "', ipFamily='" + this.f35391bl + "', isMainUrl=" + this.f35399s + ", failedTimes=" + this.f35394kf + ", isCurrentFailed=" + this.f35392h + '}';
    }

    /* renamed from: a */
    public synchronized void m17192a() {
        this.f35394kf++;
        this.f35392h = true;
    }

    /* renamed from: ok */
    public synchronized void m17186ok(RunnableC12593z runnableC12593z) {
        this.f35395n.add(runnableC12593z);
    }

    public C12592x(String str, String str2) {
        this.f35395n = new ArrayList();
        this.f35393k = new AtomicLong();
        this.f35396ok = str;
        this.f35399s = false;
        this.f35390a = str2;
        this.f35391bl = m17185ok(str2);
    }

    /* renamed from: ok */
    public synchronized int m17188ok() {
        return this.f35395n.size();
    }

    /* renamed from: ok */
    public void m17187ok(long j) {
        this.f35393k.addAndGet(j);
    }
}
