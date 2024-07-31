package com.p521ss.android.socialbase.downloader.p551kf;

import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.C12603n;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ss.android.socialbase.downloader.kf.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12578j implements InterfaceC12581n {

    /* renamed from: a */
    private final C12603n f35337a;

    /* renamed from: bl */
    private final InterfaceC12581n f35338bl;

    /* renamed from: ok */
    private final C12584q f35339ok;

    public C12578j(DownloadInfo downloadInfo, C12574a c12574a, C12584q c12584q) throws BaseException {
        this.f35339ok = c12584q;
        this.f35337a = m17299ok(downloadInfo, c12584q);
        this.f35338bl = new C12583p(c12574a, this);
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12581n
    /* renamed from: a */
    public void mo17297a(@NonNull C12582ok c12582ok) throws IOException {
        this.f35337a.m16991ok(c12582ok.f35343ok, 0, c12582ok.f35342bl);
        this.f35339ok.m17294a(c12582ok.f35342bl);
    }

    /* renamed from: bl */
    public void m17302bl() throws IOException {
        this.f35337a.m16994bl();
    }

    /* renamed from: n */
    public C12584q m17301n() {
        return this.f35339ok;
    }

    /* renamed from: ok */
    public InterfaceC12581n m17300ok() {
        return this.f35338bl;
    }

    /* renamed from: s */
    public void m17298s() {
        C12713kf.m16531ok(this.f35337a);
    }

    /* renamed from: ok */
    private C12603n m17299ok(DownloadInfo downloadInfo, C12584q c12584q) throws BaseException {
        C12603n m16560ok = C12713kf.m16560ok(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), C12534ok.m17599ok(downloadInfo.getId()).m17593ok("flush_buffer_size_byte", -1));
        try {
            m16560ok.m16992ok(c12584q.m17288n());
            return m16560ok;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }

    /* renamed from: a */
    public void m17303a() throws IOException {
        this.f35337a.m16996a();
    }
}
