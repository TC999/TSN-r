package xyz.adscope.ad.tool.request.inter;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface DownloadProgress {
    void onException(Exception exc);

    void onFinish(String str);

    void onProgress(int i4, long j4, long j5);

    void onStart();
}
