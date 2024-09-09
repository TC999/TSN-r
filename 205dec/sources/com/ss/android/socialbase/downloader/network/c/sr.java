package com.ss.android.socialbase.downloader.network.c;

import com.ss.android.socialbase.downloader.network.gd;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr implements gd {

    /* renamed from: c  reason: collision with root package name */
    protected final Object f50018c;

    /* renamed from: f  reason: collision with root package name */
    private InputStream f50019f;
    private boolean sr;
    private long ux;

    /* renamed from: w  reason: collision with root package name */
    private final List<com.ss.android.socialbase.downloader.model.xv> f50020w;
    private gd xv;

    @Override // com.ss.android.socialbase.downloader.network.gd
    public InputStream c() throws IOException {
        InputStream inputStream = this.f50019f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public boolean c(int i4) {
        return i4 >= 200 && i4 < 300;
    }

    public boolean ev() {
        return System.currentTimeMillis() - this.ux < w.f50021c;
    }

    public List<com.ss.android.socialbase.downloader.model.xv> f() {
        return this.f50020w;
    }

    public boolean r() {
        try {
            gd gdVar = this.xv;
            if (gdVar != null) {
                return c(gdVar.w());
            }
            return false;
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.gd
    public void sr() {
        gd gdVar = this.xv;
        if (gdVar != null) {
            gdVar.sr();
        }
    }

    public void ux() throws InterruptedException {
        synchronized (this.f50018c) {
            if (this.sr && this.xv == null) {
                this.f50018c.wait();
            }
        }
    }

    public int w() throws IOException {
        gd gdVar = this.xv;
        if (gdVar != null) {
            return gdVar.w();
        }
        return 0;
    }

    public void xv() {
        gd gdVar = this.xv;
        if (gdVar != null) {
            gdVar.xv();
        }
    }

    public String c(String str) {
        gd gdVar = this.xv;
        if (gdVar != null) {
            return gdVar.c(str);
        }
        return null;
    }
}
