package com.mbridge.msdk.mbdownload.manager;

import com.mbridge.msdk.out.IDownloadListener;
import java.util.Observable;
import java.util.Observer;

/* compiled from: ApkDownloadTaskObserver.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    private boolean f40179a = true;

    /* renamed from: b  reason: collision with root package name */
    private IDownloadListener f40180b;

    public b(IDownloadListener iDownloadListener) {
        this.f40180b = iDownloadListener;
    }

    public final void a(IDownloadListener iDownloadListener) {
        this.f40180b = iDownloadListener;
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        try {
            IDownloadListener iDownloadListener = this.f40180b;
            if (iDownloadListener != null) {
                if (obj != null) {
                    c cVar = (c) obj;
                    int b4 = cVar.b();
                    if (b4 == -1) {
                        this.f40180b.onStatus(-1);
                        return;
                    } else if (b4 == 5) {
                        this.f40180b.onStatus(5);
                        return;
                    } else if (b4 == 1) {
                        this.f40180b.onEnd(1, 0, cVar.a());
                        this.f40180b.onStatus(1);
                        return;
                    } else if (b4 == 2) {
                        this.f40180b.onStatus(2);
                        if (this.f40179a) {
                            this.f40180b.onStart();
                            this.f40179a = false;
                        }
                        this.f40180b.onProgressUpdate(cVar.c());
                        return;
                    } else if (b4 == 8) {
                        this.f40180b.onStatus(8);
                        return;
                    } else if (b4 != 9) {
                        this.f40180b.onStatus(cVar.b());
                        return;
                    } else {
                        this.f40180b.onStatus(9);
                        return;
                    }
                }
                iDownloadListener.onStatus(8);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
