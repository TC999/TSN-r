package com.kwad.sdk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a {
    protected int mTaskId;

    public abstract void a(DownloadTask downloadTask);

    public abstract void a(DownloadTask downloadTask, int i4, int i5);

    public abstract void a(DownloadTask downloadTask, Throwable th);

    public abstract void b(DownloadTask downloadTask);

    public abstract void c(DownloadTask downloadTask);

    public abstract void d(DownloadTask downloadTask);

    public abstract void e(DownloadTask downloadTask);

    public abstract void f(DownloadTask downloadTask);

    public final void setId(int i4) {
        this.mTaskId = i4;
    }
}
