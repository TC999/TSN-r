package com.mbridge.msdk.foundation.same.net.p481b;

import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p485f.CommonHttpConfig;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* renamed from: com.mbridge.msdk.foundation.same.net.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class CommonStringResponseHandler extends Listener<String> {

    /* renamed from: a */
    private static final String f30700a = "a";

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21051a(C11356k<String> c11356k) {
        if (c11356k != null) {
            mo22294a(c11356k.f30855a);
        }
    }

    /* renamed from: a */
    public abstract void mo22294a(String str);

    /* renamed from: b */
    public abstract void mo22293b(String str);

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21052a(CommonError commonError) {
        String str = f30700a;
        SameLogTool.m21733d(str, "errorCode = " + commonError.f30690a);
        mo22293b(CommonHttpConfig.m22259a(commonError));
    }
}
