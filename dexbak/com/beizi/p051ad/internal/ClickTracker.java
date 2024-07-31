package com.beizi.p051ad.internal;

import android.text.TextUtils;
import com.beizi.p051ad.internal.utilities.HTTPGet;
import com.beizi.p051ad.internal.utilities.HTTPResponse;

/* renamed from: com.beizi.ad.internal.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ClickTracker extends HTTPGet {

    /* renamed from: a */
    private String f10157a;

    public ClickTracker(String str) {
        super(false, false);
        this.f10157a = str;
    }

    @Override // com.beizi.p051ad.internal.utilities.HTTPGet
    protected String getUrl() {
        return this.f10157a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.beizi.p051ad.internal.utilities.HTTPGet, android.os.AsyncTask
    public void onPostExecute(HTTPResponse hTTPResponse) {
        if (hTTPResponse == null || !hTTPResponse.getSucceeded()) {
            return;
        }
        int code = hTTPResponse.getCode();
        String locationUrl = hTTPResponse.getLocationUrl();
        if (code != 302 || TextUtils.isEmpty(locationUrl)) {
            return;
        }
        new ClickTracker(locationUrl).execute(new Void[0]);
    }
}
