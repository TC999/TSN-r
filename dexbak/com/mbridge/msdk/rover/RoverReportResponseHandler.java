package com.mbridge.msdk.rover;

import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.rover.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class RoverReportResponseHandler extends Listener<JSONObject> {
    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21051a(C11356k<JSONObject> c11356k) {
        mo21304f();
    }

    /* renamed from: a */
    public abstract void mo21305a(String str);

    /* renamed from: f */
    public abstract void mo21304f();

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21052a(CommonError commonError) {
        mo21305a(commonError.f30690a + "");
    }
}
