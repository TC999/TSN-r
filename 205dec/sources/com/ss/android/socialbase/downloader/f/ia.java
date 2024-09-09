package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ia {

    /* renamed from: c  reason: collision with root package name */
    final String f49607c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f49608f;
    private String gd;

    /* renamed from: p  reason: collision with root package name */
    private final AtomicLong f49609p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f49610r;
    final boolean sr;
    private final List<bk> ux;

    /* renamed from: w  reason: collision with root package name */
    final String f49611w;
    final String xv;

    public ia(String str, boolean z3) {
        this.ux = new ArrayList();
        this.f49609p = new AtomicLong();
        this.f49607c = str;
        this.sr = z3;
        this.f49611w = null;
        this.xv = null;
    }

    private String c(String str) {
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

    private String ux() {
        if (this.gd == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f49607c);
            sb.append("_");
            String str = this.f49611w;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.sr);
            this.gd = sb.toString();
        }
        return this.gd;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ia) {
            return ux().equals(((ia) obj).ux());
        }
        return false;
    }

    public int hashCode() {
        if (this.ev == 0) {
            this.ev = ux().hashCode();
        }
        return this.ev;
    }

    public synchronized boolean sr() {
        return this.f49610r;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f49607c + "', ip='" + this.f49611w + "', ipFamily='" + this.xv + "', isMainUrl=" + this.sr + ", failedTimes=" + this.f49608f + ", isCurrentFailed=" + this.f49610r + '}';
    }

    public synchronized void w(bk bkVar) {
        try {
            this.ux.remove(bkVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void xv() {
        this.f49610r = false;
    }

    public synchronized void w() {
        this.f49608f++;
        this.f49610r = true;
    }

    public synchronized void c(bk bkVar) {
        this.ux.add(bkVar);
    }

    public ia(String str, String str2) {
        this.ux = new ArrayList();
        this.f49609p = new AtomicLong();
        this.f49607c = str;
        this.sr = false;
        this.f49611w = str2;
        this.xv = c(str2);
    }

    public synchronized int c() {
        return this.ux.size();
    }

    public void c(long j4) {
        this.f49609p.addAndGet(j4);
    }
}
