package com.umeng.analytics;

import android.content.Context;
import com.stub.StubApp;
import com.umeng.analytics.pro.CoreProtocolImpl;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* renamed from: a */
    private static Context f37528a;

    /* renamed from: com.umeng.analytics.CoreProtocol$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13100a {

        /* renamed from: a */
        private static final CoreProtocol f37529a = new CoreProtocol();

        private C13100a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (f37528a == null && context != null) {
            f37528a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C13100a.f37529a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        CoreProtocolImpl.m14274a(f37528a).m14277a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        CoreProtocolImpl.m14274a(f37528a).m14265b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        CoreProtocolImpl.m14274a(f37528a).m14273a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        return CoreProtocolImpl.m14274a(f37528a).m14276a(j);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i) {
        CoreProtocolImpl.m14274a(f37528a).m14272a(obj, i);
    }

    private CoreProtocol() {
    }
}
