package com.beizi.ad.internal;

import android.text.TextUtils;
import com.beizi.ad.internal.utilities.HTTPGet;
import com.beizi.ad.internal.utilities.HTTPResponse;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ShowMonitorTracker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class p extends HTTPGet {

    /* renamed from: a  reason: collision with root package name */
    private String f14017a;

    public p(String str) {
        super(false, false);
        this.f14017a = str;
    }

    public void a() {
        com.beizi.ad.internal.network.c a4 = com.beizi.ad.internal.network.c.a(h.a().e());
        if (a4.b(h.a().e())) {
            executeOnExecutor(com.beizi.ad.lance.a.c.b().d(), new Void[0]);
        } else {
            a4.a(this.f14017a, h.a().e());
        }
    }

    @Override // com.beizi.ad.internal.utilities.HTTPGet
    protected String getUrl() {
        return this.f14017a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.beizi.ad.internal.utilities.HTTPGet, android.os.AsyncTask
    public void onPostExecute(HTTPResponse hTTPResponse) {
        if (hTTPResponse == null || !hTTPResponse.getSucceeded()) {
            return;
        }
        int code = hTTPResponse.getCode();
        String locationUrl = hTTPResponse.getLocationUrl();
        if (code != 302 || TextUtils.isEmpty(locationUrl)) {
            return;
        }
        new p(locationUrl).a();
    }
}
