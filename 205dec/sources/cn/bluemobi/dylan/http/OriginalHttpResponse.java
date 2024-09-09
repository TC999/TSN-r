package cn.bluemobi.dylan.http;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface OriginalHttpResponse {
    void netOnFailure(Throwable th);

    void netOnFinish();

    void netOnStart();

    void netOnSuccess(String str);
}
