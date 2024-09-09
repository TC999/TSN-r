package com.ss.android.socialbase.downloader.kf;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j implements n {

    /* renamed from: a  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.n f49848a;
    private final n bl;
    private final q ok;

    public j(DownloadInfo downloadInfo, a aVar, q qVar) throws BaseException {
        this.ok = qVar;
        this.f49848a = ok(downloadInfo, qVar);
        this.bl = new p(aVar, this);
    }

    @Override // com.ss.android.socialbase.downloader.kf.n
    public void a(@NonNull ok okVar) throws IOException {
        this.f49848a.ok(okVar.ok, 0, okVar.bl);
        this.ok.a(okVar.bl);
    }

    public void bl() throws IOException {
        this.f49848a.bl();
    }

    public q n() {
        return this.ok;
    }

    public n ok() {
        return this.bl;
    }

    public void s() {
        com.ss.android.socialbase.downloader.q.kf.ok(this.f49848a);
    }

    private com.ss.android.socialbase.downloader.model.n ok(DownloadInfo downloadInfo, q qVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.n ok = com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("flush_buffer_size_byte", -1));
        try {
            ok.ok(qVar.n());
            return ok;
        } catch (IOException e4) {
            throw new BaseException(1054, e4);
        }
    }

    public void a() throws IOException {
        this.f49848a.a();
    }
}
