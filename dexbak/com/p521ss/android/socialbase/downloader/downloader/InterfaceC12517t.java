package com.p521ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.p521ss.android.socialbase.downloader.downloader.DownloadService;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.socialbase.downloader.downloader.t */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12517t<T extends DownloadService> {
    /* renamed from: a */
    void mo17527a(DownloadTask downloadTask);

    /* renamed from: a */
    boolean mo17633a();

    /* renamed from: bl */
    void mo17532bl();

    /* renamed from: bl */
    void mo17526bl(DownloadTask downloadTask);

    /* renamed from: ok */
    IBinder mo17523ok(Intent intent);

    /* renamed from: ok */
    void mo17524ok(int i);

    /* renamed from: ok */
    void mo17631ok(int i, Notification notification);

    /* renamed from: ok */
    void mo17531ok(Intent intent, int i, int i2);

    /* renamed from: ok */
    void mo17522ok(InterfaceC12514rh interfaceC12514rh);

    /* renamed from: ok */
    void mo17630ok(WeakReference<T> weakReference);

    /* renamed from: ok */
    void mo17629ok(boolean z);

    /* renamed from: ok */
    boolean mo17632ok();

    /* renamed from: s */
    void mo17628s();

    void startService();
}
