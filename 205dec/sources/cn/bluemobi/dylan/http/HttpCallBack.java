package cn.bluemobi.dylan.http;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class HttpCallBack implements HttpResponse {
    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnFailure(Throwable th) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnFinish() {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnOtherStatus(int i4, String str) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnOtherStatus(int i4, String str, Map<String, Object> map) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnStart() {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnSuccess(Map<String, Object> map, String str) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnSuccessServerError(int i4, String str) {
    }

    @Override // cn.bluemobi.dylan.http.download.ProgressResponseListener
    public void onResponseProgress(long j4, long j5, boolean z3) {
    }
}
