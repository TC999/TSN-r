package cn.bluemobi.dylan.http;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class HttpCallBack implements HttpResponse {
    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnFailure(Throwable th) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnFinish() {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnOtherStatus(int i, String str) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnOtherStatus(int i, String str, Map<String, Object> map) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnStart() {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnSuccess(Map<String, Object> map, String str) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnSuccessServerError(int i, String str) {
    }

    @Override // cn.bluemobi.dylan.http.download.ProgressResponseListener
    public void onResponseProgress(long j, long j2, boolean z) {
    }
}
