package com.beizi.ad.internal;

import android.text.TextUtils;
import com.beizi.ad.internal.utilities.HTTPGet;
import com.beizi.ad.internal.utilities.HTTPResponse;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ClickTracker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class i extends HTTPGet {

    /* renamed from: a  reason: collision with root package name */
    private String f13825a;

    public i(String str) {
        super(false, false);
        this.f13825a = str;
    }

    @Override // com.beizi.ad.internal.utilities.HTTPGet
    protected String getUrl() {
        return this.f13825a;
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
        new i(locationUrl).execute(new Void[0]);
    }
}
