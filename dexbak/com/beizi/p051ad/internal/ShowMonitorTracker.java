package com.beizi.p051ad.internal;

import android.text.TextUtils;
import com.beizi.p051ad.internal.network.SharedNetworkManager;
import com.beizi.p051ad.internal.utilities.HTTPGet;
import com.beizi.p051ad.internal.utilities.HTTPResponse;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;

/* renamed from: com.beizi.ad.internal.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ShowMonitorTracker extends HTTPGet {

    /* renamed from: a */
    private String f10408a;

    public ShowMonitorTracker(String str) {
        super(false, false);
        this.f10408a = str;
    }

    /* renamed from: a */
    public void m49298a() {
        SharedNetworkManager m49304a = SharedNetworkManager.m49304a(BeiZiImpl.m49492a().m49473e());
        if (m49304a.m49301b(BeiZiImpl.m49492a().m49473e())) {
            executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
        } else {
            m49304a.m49302a(this.f10408a, BeiZiImpl.m49492a().m49473e());
        }
    }

    @Override // com.beizi.p051ad.internal.utilities.HTTPGet
    protected String getUrl() {
        return this.f10408a;
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
        new ShowMonitorTracker(locationUrl).m49298a();
    }
}
