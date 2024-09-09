package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    protected Notification f50088c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f50089f = 0;
    private boolean gd;

    /* renamed from: r  reason: collision with root package name */
    private long f50090r;
    private long sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private int f50091w;
    private long xv;

    public c(int i4, String str) {
        this.f50091w = i4;
        this.ux = str;
    }

    public abstract void c(BaseException baseException, boolean z3);

    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f50091w = downloadInfo.getId();
        this.ux = downloadInfo.getTitle();
    }

    public boolean ev() {
        return this.gd;
    }

    public long f() {
        if (this.f50090r == 0) {
            this.f50090r = System.currentTimeMillis();
        }
        return this.f50090r;
    }

    public synchronized void r() {
        this.ev++;
    }

    public String sr() {
        return this.ux;
    }

    public int ux() {
        return this.f50089f;
    }

    public long w() {
        return this.xv;
    }

    public long xv() {
        return this.sr;
    }

    public void w(long j4) {
        this.sr = j4;
    }

    public int c() {
        return this.f50091w;
    }

    public void c(long j4) {
        this.xv = j4;
    }

    public void c(int i4, BaseException baseException, boolean z3) {
        c(i4, baseException, z3, false);
    }

    public void c(int i4, BaseException baseException, boolean z3, boolean z4) {
        if (z4 || this.f50089f != i4) {
            this.f50089f = i4;
            c(baseException, z3);
        }
    }

    public void c(long j4, long j5) {
        this.xv = j4;
        this.sr = j5;
        this.f50089f = 4;
        c((BaseException) null, false);
    }

    public void c(Notification notification) {
        if (this.f50091w == 0 || notification == null) {
            return;
        }
        w.c().c(this.f50091w, this.f50089f, notification);
    }
}
