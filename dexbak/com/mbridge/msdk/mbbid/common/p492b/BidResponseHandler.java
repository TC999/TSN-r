package com.mbridge.msdk.mbbid.common.p492b;

import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p482c.C11336b;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.CommonHttpConfig;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.mbbid.common.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class BidResponseHandler extends Listener<JSONObject> {

    /* renamed from: a */
    private static final String f31234a = "b";

    public BidResponseHandler(String str, String str2) {
        this.f30757d = str2;
        this.f30758e = str;
    }

    /* renamed from: a */
    public abstract void mo21688a(int i, String str);

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21051a(C11356k<JSONObject> c11356k) {
        NetworkResponse networkResponse;
        super.mo21051a(c11356k);
        if (c11356k == null || (networkResponse = c11356k.f30857c) == null) {
            return;
        }
        List<C11336b> list = networkResponse.f30754d;
        JSONObject jSONObject = c11356k.f30855a;
        int optInt = jSONObject.optInt("status");
        if (200 == optInt) {
            BidResponsedEx parseBidResponsedEx = BidResponsedEx.parseBidResponsedEx(jSONObject.optJSONObject("data"), this.f30757d);
            if (parseBidResponsedEx != null) {
                mo21687a(parseBidResponsedEx);
                return;
            } else {
                mo21688a(optInt, jSONObject.optString("msg"));
                return;
            }
        }
        mo21688a(optInt, jSONObject.optString("msg"));
    }

    /* renamed from: a */
    public abstract void mo21687a(BidResponsedEx bidResponsedEx);

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21052a(CommonError commonError) {
        String str = f31234a;
        SameLogTool.m21733d(str, "errorCode = " + commonError.f30690a);
        mo21688a(commonError.f30690a, CommonHttpConfig.m22259a(commonError));
    }
}
