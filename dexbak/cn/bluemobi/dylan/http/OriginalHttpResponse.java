package cn.bluemobi.dylan.http;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface OriginalHttpResponse {
    void netOnFailure(Throwable th);

    void netOnFinish();

    void netOnStart();

    void netOnSuccess(String str);
}
