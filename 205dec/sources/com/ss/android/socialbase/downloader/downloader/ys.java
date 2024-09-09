package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface ys<T extends DownloadService> {
    IBinder c(Intent intent);

    void c(int i4);

    void c(int i4, Notification notification);

    void c(Intent intent, int i4, int i5);

    void c(t tVar);

    void c(WeakReference<T> weakReference);

    void c(boolean z3);

    boolean c();

    void sr();

    void startService();

    void w(DownloadTask downloadTask);

    boolean w();

    void xv();

    void xv(DownloadTask downloadTask);
}
