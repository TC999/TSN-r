package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ok {

    /* renamed from: a  reason: collision with root package name */
    private int f50092a;
    private long bl;

    /* renamed from: h  reason: collision with root package name */
    private long f50093h;
    private int kf = 0;

    /* renamed from: n  reason: collision with root package name */
    private String f50094n;
    protected Notification ok;

    /* renamed from: p  reason: collision with root package name */
    private int f50095p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f50096q;

    /* renamed from: s  reason: collision with root package name */
    private long f50097s;

    public ok(int i4, String str) {
        this.f50092a = i4;
        this.f50094n = str;
    }

    public long a() {
        return this.bl;
    }

    public long bl() {
        return this.f50097s;
    }

    public synchronized void h() {
        this.f50095p++;
    }

    public long kf() {
        if (this.f50093h == 0) {
            this.f50093h = System.currentTimeMillis();
        }
        return this.f50093h;
    }

    public int n() {
        return this.kf;
    }

    public abstract void ok(BaseException baseException, boolean z3);

    public void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f50092a = downloadInfo.getId();
        this.f50094n = downloadInfo.getTitle();
    }

    public boolean p() {
        return this.f50096q;
    }

    public String s() {
        return this.f50094n;
    }

    public void a(long j4) {
        this.f50097s = j4;
    }

    public int ok() {
        return this.f50092a;
    }

    public void ok(long j4) {
        this.bl = j4;
    }

    public void ok(int i4, BaseException baseException, boolean z3) {
        ok(i4, baseException, z3, false);
    }

    public void ok(int i4, BaseException baseException, boolean z3, boolean z4) {
        if (z4 || this.kf != i4) {
            this.kf = i4;
            ok(baseException, z3);
        }
    }

    public void ok(long j4, long j5) {
        this.bl = j4;
        this.f50097s = j5;
        this.kf = 4;
        ok((BaseException) null, false);
    }

    public void ok(Notification notification) {
        if (this.f50092a == 0 || notification == null) {
            return;
        }
        a.ok().ok(this.f50092a, this.kf, notification);
    }
}
