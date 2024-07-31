package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.network.p405b.C10413c;
import com.kwad.sdk.core.network.p405b.InterfaceC10412b;
import com.kwad.sdk.core.network.p406c.C10417b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.p438ip.direct.C10808a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11064bn;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.network.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10436l<R extends InterfaceC10420f, T extends BaseResultData> extends AbstractC10402a<R> {
    private static final String TAG = "Networking";
    @Nullable
    private InterfaceC10421g<R, T> mListener = null;
    private final InterfaceC10412b mMonitorRecorder = C10413c.m26155Ej();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.mo26127dg(1);
        }
    }

    private void checkIpDirect(C10415c c10415c) {
        InterfaceC10968f interfaceC10968f;
        if (c10415c == null || c10415c.m26112DM() || (interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)) == null || !C11013ag.isNetworkConnected(interfaceC10968f.getContext())) {
            return;
        }
        C10808a.m24781II();
    }

    private String getHostTypeByUrl(@NonNull String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(@NonNull R r, C10415c c10415c, String str) {
        String url = r.getUrl();
        DomainException domainException = new DomainException(c10415c.avq, c10415c.avr);
        C10425a.m26107DU().m26094a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((AbstractC10436l<R, T>) r, c10415c.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r) {
        InterfaceC10421g<R, T> interfaceC10421g = this.mListener;
        if (interfaceC10421g == null) {
            return;
        }
        interfaceC10421g.onStartRequest(r);
    }

    private void notifyOnSuccess(@NonNull R r, T t) {
        if (C10425a.m26107DU().m26105DW()) {
            String hostTypeByUrl = getHostTypeByUrl(r.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                C10425a.m26107DU().m26088dR(hostTypeByUrl);
            }
        }
        InterfaceC10421g<R, T> interfaceC10421g = this.mListener;
        if (interfaceC10421g == null) {
            return;
        }
        interfaceC10421g.onSuccess(r, t);
        this.mMonitorRecorder.mo26148Ei();
    }

    private void onRequest(@NonNull InterfaceC10421g<R, T> interfaceC10421g) {
        this.mMonitorRecorder.mo26154Ec();
        this.mListener = interfaceC10421g;
    }

    private void parseCommonData(String str, String str2) {
        try {
            C10441q.m26065DQ().m26064U(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            C10331c.printStackTrace(th);
        }
    }

    private void setMonitorRequestId(@NonNull InterfaceC10420f interfaceC10420f) {
        Map<String, String> header = interfaceC10420f.getHeader();
        if (header != null) {
            String str = header.get(AbstractC10418d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.mo26120eb(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterParseData(T t) {
    }

    @Override // com.kwad.sdk.core.network.AbstractC10402a
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
    @Override // com.kwad.sdk.core.network.AbstractC10402a
    @WorkerThread
    protected void fetchImpl() {
        InterfaceC10420f interfaceC10420f;
        Throwable th;
        C10415c c10415c = null;
        try {
            this.mMonitorRecorder.mo26150Eg();
            interfaceC10420f = createRequest();
        } catch (Throwable th2) {
            interfaceC10420f = null;
            th = th2;
        }
        try {
            notifyOnStartRequest(interfaceC10420f);
            this.mMonitorRecorder.mo26131dX(interfaceC10420f.getUrl()).mo26130dY(interfaceC10420f.getUrl());
            setMonitorRequestId(interfaceC10420f);
            if (!C11013ag.isNetworkConnected(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext())) {
                C10419e c10419e = C10419e.avw;
                notifyOnErrorListener((AbstractC10436l<R, T>) interfaceC10420f, c10419e.errorCode, c10419e.msg);
                this.mMonitorRecorder.mo26128df(C10419e.avw.errorCode).mo26129dZ(C10419e.avw.msg);
            } else {
                try {
                    String url = interfaceC10420f.getUrl();
                    AdHttpProxy m24902xT = C10756f.m24902xT();
                    if (m24902xT instanceof C10417b) {
                        this.mMonitorRecorder.mo26121ea("ok_http").mo26151Ef();
                    } else {
                        this.mMonitorRecorder.mo26121ea(IDataSource.f43971a).mo26151Ef();
                    }
                    if (isPostByJson()) {
                        c10415c = m24902xT.doPost(url, interfaceC10420f.getHeader(), interfaceC10420f.getBody());
                    } else {
                        c10415c = m24902xT.doPost(url, interfaceC10420f.getHeader(), interfaceC10420f.getBodyMap());
                    }
                    C10331c.m26248i(TAG, "url: " + url + ", response: " + c10415c);
                } catch (Exception e) {
                    notifyOnErrorListener((AbstractC10436l<R, T>) interfaceC10420f, C10419e.avD.errorCode, C11064bn.m23856t(e));
                    C10331c.printStackTraceOnly(e);
                    this.mMonitorRecorder.mo26129dZ("requestError:" + e.getMessage());
                }
                this.mMonitorRecorder.mo26153Ed().mo26152Ee().mo26125di(C10808a.getType());
                try {
                    onResponse(interfaceC10420f, c10415c);
                } catch (Exception e2) {
                    notifyOnErrorListener((AbstractC10436l<R, T>) interfaceC10420f, C10419e.avD.errorCode, C11064bn.m23856t(e2));
                    this.mMonitorRecorder.mo26129dZ("onResponseError:" + e2.getMessage());
                    C10331c.printStackTraceOnly(e2);
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
                    this.mMonitorRecorder.mo26129dZ("requestError:" + th.getMessage());
                } catch (Exception unused2) {
                    notifyOnErrorListener((AbstractC10436l<R, T>) interfaceC10420f, C10419e.avD.errorCode, C11064bn.m23856t(th));
                    C10331c.printStackTrace(th);
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
    @Override // com.kwad.sdk.core.network.AbstractC10402a
    public void onResponse(R r, C10415c c10415c) {
        if (c10415c == null) {
            C10419e c10419e = C10419e.avw;
            notifyOnErrorListener((AbstractC10436l<R, T>) r, c10419e.errorCode, c10419e.msg);
            this.mMonitorRecorder.mo26129dZ("responseBase is null");
            C10331c.m26250e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.mo26128df(c10415c.code);
        checkIpDirect(c10415c);
        if (!TextUtils.isEmpty(c10415c.avs) && c10415c.m26112DM()) {
            try {
                parseCommonData(r.getUrl(), c10415c.avs);
                T parseData = parseData(c10415c.avs);
                afterParseData(parseData);
                String str = c10415c.avs;
                if (str != null) {
                    this.mMonitorRecorder.mo26138ak(str.length()).mo26149Eh().mo26126dh(parseData.result);
                }
                if (!parseData.isResultOk()) {
                    InterfaceC10412b interfaceC10412b = this.mMonitorRecorder;
                    interfaceC10412b.mo26129dZ("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
                    if (parseData.notifyFailOnResultError()) {
                        notifyOnErrorListener((AbstractC10436l<R, T>) r, parseData.result, parseData.errorMsg);
                        return;
                    }
                }
                if (parseData.isDataEmpty()) {
                    notifyOnErrorListener((AbstractC10436l<R, T>) r, C10419e.avy.errorCode, !TextUtils.isEmpty(parseData.testErrorMsg) ? parseData.testErrorMsg : C10419e.avy.msg);
                    return;
                }
                checkAndSetHasData(parseData);
                notifyOnSuccess(r, parseData);
                return;
            } catch (Exception e) {
                C10419e c10419e2 = C10419e.avx;
                notifyOnErrorListener((AbstractC10436l<R, T>) r, c10419e2.errorCode, c10419e2.msg);
                C10331c.printStackTraceOnly(e);
                InterfaceC10412b interfaceC10412b2 = this.mMonitorRecorder;
                interfaceC10412b2.mo26129dZ("parseDataError:" + e.getMessage());
                return;
            }
        }
        notifyOnErrorListener((AbstractC10436l<R, T>) r, c10415c, "网络错误");
        InterfaceC10412b interfaceC10412b3 = this.mMonitorRecorder;
        interfaceC10412b3.mo26129dZ("httpCodeError:" + c10415c.code + ":" + c10415c.avs);
        StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
        sb.append(c10415c.code);
        C10331c.m26246w(TAG, sb.toString());
    }

    @NonNull
    protected abstract T parseData(String str);

    public void request(@NonNull InterfaceC10421g<R, T> interfaceC10421g) {
        try {
            onRequest(interfaceC10421g);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((AbstractC10436l<R, T>) null, C10419e.avD.errorCode, C11064bn.m23856t(th));
            reportSdkCaughtException(th);
        }
    }

    private void notifyOnErrorListener(@NonNull R r, int i, String str) {
        try {
            C10422h.m26111DN().m26109b(r, i);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        InterfaceC10421g<R, T> interfaceC10421g = this.mListener;
        if (interfaceC10421g == null) {
            return;
        }
        interfaceC10421g.onError(r, i, str);
        this.mMonitorRecorder.mo26148Ei();
    }
}
