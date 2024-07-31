package com.p521ss.android.socialbase.downloader.network.p553ok;

import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.network.ok.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12633s implements InterfaceC12635q {

    /* renamed from: a */
    private final List<C12601bl> f35598a;

    /* renamed from: bl */
    private InterfaceC12635q f35599bl;

    /* renamed from: kf */
    private InputStream f35600kf;

    /* renamed from: n */
    private long f35601n;

    /* renamed from: ok */
    protected final Object f35602ok;

    /* renamed from: s */
    private boolean f35603s;

    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
    /* renamed from: a */
    public int mo16918a() throws IOException {
        InterfaceC12635q interfaceC12635q = this.f35599bl;
        if (interfaceC12635q != null) {
            return interfaceC12635q.mo16918a();
        }
        return 0;
    }

    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
    /* renamed from: bl */
    public void mo16917bl() {
        InterfaceC12635q interfaceC12635q = this.f35599bl;
        if (interfaceC12635q != null) {
            interfaceC12635q.mo16917bl();
        }
    }

    /* renamed from: h */
    public boolean m16916h() {
        try {
            InterfaceC12635q interfaceC12635q = this.f35599bl;
            if (interfaceC12635q != null) {
                return m16913ok(interfaceC12635q.mo16918a());
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: kf */
    public List<C12601bl> m16915kf() {
        return this.f35598a;
    }

    /* renamed from: n */
    public void m16914n() throws InterruptedException {
        synchronized (this.f35602ok) {
            if (this.f35603s && this.f35599bl == null) {
                this.f35602ok.wait();
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12635q
    /* renamed from: ok */
    public InputStream mo16909ok() throws IOException {
        InputStream inputStream = this.f35600kf;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    /* renamed from: ok */
    public boolean m16913ok(int i) {
        return i >= 200 && i < 300;
    }

    /* renamed from: p */
    public boolean m16911p() {
        return System.currentTimeMillis() - this.f35601n < C12626a.f35579ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12635q
    /* renamed from: s */
    public void mo16908s() {
        InterfaceC12635q interfaceC12635q = this.f35599bl;
        if (interfaceC12635q != null) {
            interfaceC12635q.mo16908s();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
    /* renamed from: ok */
    public String mo16912ok(String str) {
        InterfaceC12635q interfaceC12635q = this.f35599bl;
        if (interfaceC12635q != null) {
            return interfaceC12635q.mo16912ok(str);
        }
        return null;
    }
}
