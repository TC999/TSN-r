package com.p521ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.notification.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractC12645ok {

    /* renamed from: a */
    private int f35644a;

    /* renamed from: bl */
    private long f35645bl;

    /* renamed from: h */
    private long f35646h;

    /* renamed from: kf */
    private int f35647kf = 0;

    /* renamed from: n */
    private String f35648n;

    /* renamed from: ok */
    protected Notification f35649ok;

    /* renamed from: p */
    private int f35650p;

    /* renamed from: q */
    private boolean f35651q;

    /* renamed from: s */
    private long f35652s;

    public AbstractC12645ok(int i, String str) {
        this.f35644a = i;
        this.f35648n = str;
    }

    /* renamed from: a */
    public long m16870a() {
        return this.f35645bl;
    }

    /* renamed from: bl */
    public long m16868bl() {
        return this.f35652s;
    }

    /* renamed from: h */
    public synchronized void m16867h() {
        this.f35650p++;
    }

    /* renamed from: kf */
    public long m16866kf() {
        if (this.f35646h == 0) {
            this.f35646h = System.currentTimeMillis();
        }
        return this.f35646h;
    }

    /* renamed from: n */
    public int m16865n() {
        return this.f35647kf;
    }

    /* renamed from: ok */
    public abstract void mo16858ok(BaseException baseException, boolean z);

    /* renamed from: ok */
    public void mo16857ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f35644a = downloadInfo.getId();
        this.f35648n = downloadInfo.getTitle();
    }

    /* renamed from: p */
    public boolean m16856p() {
        return this.f35651q;
    }

    /* renamed from: s */
    public String m16855s() {
        return this.f35648n;
    }

    /* renamed from: a */
    public void m16869a(long j) {
        this.f35652s = j;
    }

    /* renamed from: ok */
    public int m16864ok() {
        return this.f35644a;
    }

    /* renamed from: ok */
    public void m16861ok(long j) {
        this.f35645bl = j;
    }

    /* renamed from: ok */
    public void m16863ok(int i, BaseException baseException, boolean z) {
        m16862ok(i, baseException, z, false);
    }

    /* renamed from: ok */
    public void m16862ok(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f35647kf != i) {
            this.f35647kf = i;
            mo16858ok(baseException, z);
        }
    }

    /* renamed from: ok */
    public void m16860ok(long j, long j2) {
        this.f35645bl = j;
        this.f35652s = j2;
        this.f35647kf = 4;
        mo16858ok((BaseException) null, false);
    }

    /* renamed from: ok */
    public void m16859ok(Notification notification) {
        if (this.f35644a == 0 || notification == null) {
            return;
        }
        C12644a.m16876ok().m16874ok(this.f35644a, this.f35647kf, notification);
    }
}
