package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.core.network.InterfaceC10438n;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.sdk.core.network.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10437m<R extends InterfaceC10438n, T extends NormalResultData> extends AbstractC10402a<R> {
    private static final String TAG = "NormalNetworking";
    @Nullable
    private InterfaceC10421g<R, T> mListener = null;

    private void onRequest(@NonNull InterfaceC10421g<R, T> interfaceC10421g) {
        this.mListener = interfaceC10421g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.AbstractC10402a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected abstract T createResponseData();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.AbstractC10402a
    protected void fetchImpl() {
        C10415c c10415c;
        InterfaceC10438n interfaceC10438n = (InterfaceC10438n) createRequest();
        try {
            String url = interfaceC10438n.getUrl();
            if (interfaceC10438n.getMethod().equals("POST")) {
                c10415c = C10756f.m24902xT().doPost(url, interfaceC10438n.getHeader(), interfaceC10438n.getBody());
            } else {
                c10415c = C10756f.m24902xT().doGet(url, interfaceC10438n.getHeader());
            }
            if (c10415c != null && c10415c.code == 200) {
                C10331c.m26254d(TAG, "normal request success:" + c10415c.code);
            } else {
                C10331c.m26254d(TAG, "normal request failed");
            }
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            c10415c = 0 == 0 ? new C10415c() : null;
            c10415c.code = -1;
            c10415c.avr = e;
        }
        onResponse((AbstractC10437m<R, T>) interfaceC10438n, c10415c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.AbstractC10402a
    protected /* bridge */ /* synthetic */ void onResponse(InterfaceC10420f interfaceC10420f, C10415c c10415c) {
        onResponse((AbstractC10437m<R, T>) ((InterfaceC10438n) interfaceC10420f), c10415c);
    }

    protected void parseResponse(T t, C10415c c10415c) {
        t.parseResponse(c10415c);
    }

    public void request(@NonNull InterfaceC10421g<R, T> interfaceC10421g) {
        try {
            onRequest(interfaceC10421g);
            fetch();
        } catch (Throwable th) {
            interfaceC10421g.onError(null, C10419e.avD.errorCode, C11064bn.m23856t(th));
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    protected void onResponse(R r, C10415c c10415c) {
        if (this.mListener == null) {
            return;
        }
        if (c10415c.m26112DM()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, c10415c);
            this.mListener.onSuccess(r, createResponseData);
            return;
        }
        InterfaceC10421g<R, T> interfaceC10421g = this.mListener;
        int i = c10415c.code;
        Exception exc = c10415c.avr;
        interfaceC10421g.onError(r, i, exc != null ? exc.getMessage() : "");
    }
}
