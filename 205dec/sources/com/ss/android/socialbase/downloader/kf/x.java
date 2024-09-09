package com.ss.android.socialbase.downloader.kf;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    final String f49877a;
    final String bl;

    /* renamed from: h  reason: collision with root package name */
    private boolean f49878h;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicLong f49879k;
    private int kf;

    /* renamed from: n  reason: collision with root package name */
    private final List<z> f49880n;
    final String ok;

    /* renamed from: p  reason: collision with root package name */
    private int f49881p;

    /* renamed from: q  reason: collision with root package name */
    private String f49882q;

    /* renamed from: s  reason: collision with root package name */
    final boolean f49883s;

    public x(String str, boolean z3) {
        this.f49880n = new ArrayList();
        this.f49879k = new AtomicLong();
        this.ok = str;
        this.f49883s = z3;
        this.f49877a = null;
        this.bl = null;
    }

    private String n() {
        if (this.f49882q == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.ok);
            sb.append("_");
            String str = this.f49877a;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f49883s);
            this.f49882q = sb.toString();
        }
        return this.f49882q;
    }

    private String ok(String str) {
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

    public synchronized void a(z zVar) {
        try {
            this.f49880n.remove(zVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void bl() {
        this.f49878h = false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return n().equals(((x) obj).n());
        }
        return false;
    }

    public int hashCode() {
        if (this.f49881p == 0) {
            this.f49881p = n().hashCode();
        }
        return this.f49881p;
    }

    public synchronized boolean s() {
        return this.f49878h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.ok + "', ip='" + this.f49877a + "', ipFamily='" + this.bl + "', isMainUrl=" + this.f49883s + ", failedTimes=" + this.kf + ", isCurrentFailed=" + this.f49878h + '}';
    }

    public synchronized void a() {
        this.kf++;
        this.f49878h = true;
    }

    public synchronized void ok(z zVar) {
        this.f49880n.add(zVar);
    }

    public x(String str, String str2) {
        this.f49880n = new ArrayList();
        this.f49879k = new AtomicLong();
        this.ok = str;
        this.f49883s = false;
        this.f49877a = str2;
        this.bl = ok(str2);
    }

    public synchronized int ok() {
        return this.f49880n.size();
    }

    public void ok(long j4) {
        this.f49879k.addAndGet(j4);
    }
}
