package com.mbridge.msdk.mbbid.common.b;

import com.mbridge.msdk.foundation.same.net.e.c;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BidResponseHandler.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b extends f<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40008a = "b";

    public b(String str, String str2) {
        this.f39551d = str2;
        this.f39552e = str;
    }

    public abstract void a(int i4, String str);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(k<JSONObject> kVar) {
        c cVar;
        super.a(kVar);
        if (kVar == null || (cVar = kVar.f39630c) == null) {
            return;
        }
        List<com.mbridge.msdk.foundation.same.net.c.b> list = cVar.f39548d;
        JSONObject jSONObject = kVar.f39628a;
        int optInt = jSONObject.optInt("status");
        if (200 == optInt) {
            BidResponsedEx parseBidResponsedEx = BidResponsedEx.parseBidResponsedEx(jSONObject.optJSONObject("data"), this.f39551d);
            if (parseBidResponsedEx != null) {
                a(parseBidResponsedEx);
                return;
            } else {
                a(optInt, jSONObject.optString("msg"));
                return;
            }
        }
        a(optInt, jSONObject.optString("msg"));
    }

    public abstract void a(BidResponsedEx bidResponsedEx);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f40008a;
        x.d(str, "errorCode = " + aVar.f39484a);
        a(aVar.f39484a, com.mbridge.msdk.foundation.same.net.f.a.a(aVar));
    }
}
