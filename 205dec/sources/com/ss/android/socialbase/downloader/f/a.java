package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a implements ux {

    /* renamed from: c  reason: collision with root package name */
    private final gd f49581c;

    /* renamed from: w  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.ux f49582w;
    private final ux xv;

    public a(DownloadInfo downloadInfo, w wVar, gd gdVar) throws BaseException {
        this.f49581c = gdVar;
        this.f49582w = c(downloadInfo, gdVar);
        this.xv = new ev(wVar, this);
    }

    public ux c() {
        return this.xv;
    }

    public void sr() {
        com.ss.android.socialbase.downloader.gd.f.c(this.f49582w);
    }

    public gd ux() {
        return this.f49581c;
    }

    @Override // com.ss.android.socialbase.downloader.f.ux
    public void w(@NonNull c cVar) throws IOException {
        this.f49582w.c(cVar.f49599c, 0, cVar.xv);
        this.f49581c.w(cVar.xv);
    }

    public void xv() throws IOException {
        this.f49582w.xv();
    }

    private com.ss.android.socialbase.downloader.model.ux c(DownloadInfo downloadInfo, gd gdVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.ux c4 = com.ss.android.socialbase.downloader.gd.f.c(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("flush_buffer_size_byte", -1));
        try {
            c4.c(gdVar.ux());
            return c4;
        } catch (IOException e4) {
            throw new BaseException(1054, e4);
        }
    }

    public void w() throws IOException {
        this.f49582w.w();
    }
}
