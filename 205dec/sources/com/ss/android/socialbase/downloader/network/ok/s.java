package com.ss.android.socialbase.downloader.network.ok;

import com.ss.android.socialbase.downloader.network.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s implements q {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.ss.android.socialbase.downloader.model.bl> f50048a;
    private q bl;
    private InputStream kf;

    /* renamed from: n  reason: collision with root package name */
    private long f50049n;
    protected final Object ok;

    /* renamed from: s  reason: collision with root package name */
    private boolean f50050s;

    @Override // com.ss.android.socialbase.downloader.network.h
    public int a() throws IOException {
        q qVar = this.bl;
        if (qVar != null) {
            return qVar.a();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public void bl() {
        q qVar = this.bl;
        if (qVar != null) {
            qVar.bl();
        }
    }

    public boolean h() {
        try {
            q qVar = this.bl;
            if (qVar != null) {
                return ok(qVar.a());
            }
            return false;
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public List<com.ss.android.socialbase.downloader.model.bl> kf() {
        return this.f50048a;
    }

    public void n() throws InterruptedException {
        synchronized (this.ok) {
            if (this.f50050s && this.bl == null) {
                this.ok.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.q
    public InputStream ok() throws IOException {
        InputStream inputStream = this.kf;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public boolean ok(int i4) {
        return i4 >= 200 && i4 < 300;
    }

    public boolean p() {
        return System.currentTimeMillis() - this.f50049n < a.ok;
    }

    @Override // com.ss.android.socialbase.downloader.network.q
    public void s() {
        q qVar = this.bl;
        if (qVar != null) {
            qVar.s();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public String ok(String str) {
        q qVar = this.bl;
        if (qVar != null) {
            return qVar.ok(str);
        }
        return null;
    }
}
