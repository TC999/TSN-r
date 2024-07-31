package com.mbridge.msdk.mbdownload.manager;

import com.mbridge.msdk.out.IDownloadListener;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.mbridge.msdk.mbdownload.manager.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ApkDownloadTaskObserver implements Observer {

    /* renamed from: a */
    private boolean f31407a = true;

    /* renamed from: b */
    private IDownloadListener f31408b;

    public ApkDownloadTaskObserver(IDownloadListener iDownloadListener) {
        this.f31408b = iDownloadListener;
    }

    /* renamed from: a */
    public final void m21551a(IDownloadListener iDownloadListener) {
        this.f31408b = iDownloadListener;
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        try {
            IDownloadListener iDownloadListener = this.f31408b;
            if (iDownloadListener != null) {
                if (obj != null) {
                    UpdateObject updateObject = (UpdateObject) obj;
                    int m21547b = updateObject.m21547b();
                    if (m21547b == -1) {
                        this.f31408b.onStatus(-1);
                        return;
                    } else if (m21547b == 5) {
                        this.f31408b.onStatus(5);
                        return;
                    } else if (m21547b == 1) {
                        this.f31408b.onEnd(1, 0, updateObject.m21550a());
                        this.f31408b.onStatus(1);
                        return;
                    } else if (m21547b == 2) {
                        this.f31408b.onStatus(2);
                        if (this.f31407a) {
                            this.f31408b.onStart();
                            this.f31407a = false;
                        }
                        this.f31408b.onProgressUpdate(updateObject.m21545c());
                        return;
                    } else if (m21547b == 8) {
                        this.f31408b.onStatus(8);
                        return;
                    } else if (m21547b != 9) {
                        this.f31408b.onStatus(updateObject.m21547b());
                        return;
                    } else {
                        this.f31408b.onStatus(9);
                        return;
                    }
                }
                iDownloadListener.onStatus(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
