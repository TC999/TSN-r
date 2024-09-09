package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bn;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";
    @Nullable
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.Ej();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.dg(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.DM() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !ag.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.II();
    }

    private String getHostTypeByUrl(@NonNull String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(@NonNull R r3, c cVar, String str) {
        String url = r3.getUrl();
        DomainException domainException = new DomainException(cVar.avq, cVar.avr);
        com.kwad.sdk.core.network.idc.a.DU().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((l<R, T>) r3, cVar.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r3) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r3);
    }

    private void notifyOnSuccess(@NonNull R r3, T t3) {
        if (com.kwad.sdk.core.network.idc.a.DU().DW()) {
            String hostTypeByUrl = getHostTypeByUrl(r3.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.DU().dR(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r3, t3);
        this.mMonitorRecorder.Ei();
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mMonitorRecorder.Ec();
        this.mListener = gVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.DQ().U(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    private void setMonitorRequestId(@NonNull f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get("kuaishou-tracing-token");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.eb(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterParseData(T t3) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected boolean enableCrashReport() {
        return true;
    }

    protected boolean enableMonitorReport() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    protected void fetchImpl() {
        f fVar;
        Throwable th;
        c cVar = null;
        try {
            this.mMonitorRecorder.Eg();
            fVar = createRequest();
        } catch (Throwable th2) {
            fVar = null;
            th = th2;
        }
        try {
            notifyOnStartRequest(fVar);
            this.mMonitorRecorder.dX(fVar.getUrl()).dY(fVar.getUrl());
            setMonitorRequestId(fVar);
            if (!ag.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                e eVar = e.avw;
                notifyOnErrorListener((l<R, T>) fVar, eVar.errorCode, eVar.msg);
                this.mMonitorRecorder.df(e.avw.errorCode).dZ(e.avw.msg);
            } else {
                try {
                    String url = fVar.getUrl();
                    AdHttpProxy xT = com.kwad.sdk.f.xT();
                    if (xT instanceof com.kwad.sdk.core.network.c.b) {
                        this.mMonitorRecorder.ea("ok_http").Ef();
                    } else {
                        this.mMonitorRecorder.ea("http").Ef();
                    }
                    if (isPostByJson()) {
                        cVar = xT.doPost(url, fVar.getHeader(), fVar.getBody());
                    } else {
                        cVar = xT.doPost(url, fVar.getHeader(), fVar.getBodyMap());
                    }
                    com.kwad.sdk.core.e.c.i("Networking", "url: " + url + ", response: " + cVar);
                } catch (Exception e4) {
                    notifyOnErrorListener((l<R, T>) fVar, e.avD.errorCode, bn.t(e4));
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                    this.mMonitorRecorder.dZ("requestError:" + e4.getMessage());
                }
                this.mMonitorRecorder.Ed().Ee().di(com.kwad.sdk.ip.direct.a.getType());
                try {
                    onResponse(fVar, cVar);
                } catch (Exception e5) {
                    notifyOnErrorListener((l<R, T>) fVar, e.avD.errorCode, bn.t(e5));
                    this.mMonitorRecorder.dZ("onResponseError:" + e5.getMessage());
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e5);
                }
            }
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                try {
                    this.mMonitorRecorder.dZ("requestError:" + th.getMessage());
                } catch (Exception unused2) {
                    notifyOnErrorListener((l<R, T>) fVar, e.avD.errorCode, bn.t(th));
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th4) {
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.report();
                    }
                } catch (Exception unused4) {
                }
                throw th4;
            }
        }
    }

    protected boolean isPostByJson() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r3, c cVar) {
        if (cVar == null) {
            e eVar = e.avw;
            notifyOnErrorListener((l<R, T>) r3, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.dZ("responseBase is null");
            com.kwad.sdk.core.e.c.e("Networking", "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.df(cVar.code);
        checkIpDirect(cVar);
        if (!TextUtils.isEmpty(cVar.avs) && cVar.DM()) {
            try {
                parseCommonData(r3.getUrl(), cVar.avs);
                T parseData = parseData(cVar.avs);
                afterParseData(parseData);
                String str = cVar.avs;
                if (str != null) {
                    this.mMonitorRecorder.ak(str.length()).Eh().dh(parseData.result);
                }
                if (!parseData.isResultOk()) {
                    com.kwad.sdk.core.network.b.b bVar = this.mMonitorRecorder;
                    bVar.dZ("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
                    if (parseData.notifyFailOnResultError()) {
                        notifyOnErrorListener((l<R, T>) r3, parseData.result, parseData.errorMsg);
                        return;
                    }
                }
                if (parseData.isDataEmpty()) {
                    notifyOnErrorListener((l<R, T>) r3, e.avy.errorCode, !TextUtils.isEmpty(parseData.testErrorMsg) ? parseData.testErrorMsg : e.avy.msg);
                    return;
                }
                checkAndSetHasData(parseData);
                notifyOnSuccess(r3, parseData);
                return;
            } catch (Exception e4) {
                e eVar2 = e.avx;
                notifyOnErrorListener((l<R, T>) r3, eVar2.errorCode, eVar2.msg);
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                com.kwad.sdk.core.network.b.b bVar2 = this.mMonitorRecorder;
                bVar2.dZ("parseDataError:" + e4.getMessage());
                return;
            }
        }
        notifyOnErrorListener((l<R, T>) r3, cVar, "\u7f51\u7edc\u9519\u8bef");
        com.kwad.sdk.core.network.b.b bVar3 = this.mMonitorRecorder;
        bVar3.dZ("httpCodeError:" + cVar.code + ":" + cVar.avs);
        StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
        sb.append(cVar.code);
        com.kwad.sdk.core.e.c.w("Networking", sb.toString());
    }

    @NonNull
    protected abstract T parseData(String str);

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((l<R, T>) null, e.avD.errorCode, bn.t(th));
            reportSdkCaughtException(th);
        }
    }

    private void notifyOnErrorListener(@NonNull R r3, int i4, String str) {
        try {
            h.DN().b(r3, i4);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r3, i4, str);
        this.mMonitorRecorder.Ei();
    }
}
