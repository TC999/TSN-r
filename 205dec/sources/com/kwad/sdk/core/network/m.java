package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class m<R extends n, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";
    @Nullable
    private g<R, T> mListener = null;

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mListener = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected abstract T createResponseData();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    protected void fetchImpl() {
        c cVar;
        n nVar = (n) createRequest();
        try {
            String url = nVar.getUrl();
            if (nVar.getMethod().equals("POST")) {
                cVar = com.kwad.sdk.f.xT().doPost(url, nVar.getHeader(), nVar.getBody());
            } else {
                cVar = com.kwad.sdk.f.xT().doGet(url, nVar.getHeader());
            }
            if (cVar != null && cVar.code == 200) {
                com.kwad.sdk.core.e.c.d("NormalNetworking", "normal request success:" + cVar.code);
            } else {
                com.kwad.sdk.core.e.c.d("NormalNetworking", "normal request failed");
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            cVar = 0 == 0 ? new c() : null;
            cVar.code = -1;
            cVar.avr = e4;
        }
        onResponse((m<R, T>) nVar, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    protected /* bridge */ /* synthetic */ void onResponse(f fVar, c cVar) {
        onResponse((m<R, T>) ((n) fVar), cVar);
    }

    protected void parseResponse(T t3, c cVar) {
        t3.parseResponse(cVar);
    }

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            gVar.onError(null, e.avD.errorCode, bn.t(th));
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    protected void onResponse(R r3, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.DM()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, cVar);
            this.mListener.onSuccess(r3, createResponseData);
            return;
        }
        g<R, T> gVar = this.mListener;
        int i4 = cVar.code;
        Exception exc = cVar.avr;
        gVar.onError(r3, i4, exc != null ? exc.getMessage() : "");
    }
}
