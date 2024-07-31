package com.mbridge.msdk.foundation.same.net.p486g;

import android.text.TextUtils;
import com.autonavi.base.p048ae.gmap.glanimation.AbstractAdglAnimation;
import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.CommonHttpConfig;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.net.g.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class CommonMBListener extends Listener<JSONObject> {

    /* renamed from: a */
    private static final String f30820a = "c";

    /* renamed from: b */
    private void m22225b(C11356k<JSONObject> c11356k) {
        JSONObject jSONObject = c11356k.f30855a;
        if (jSONObject == null) {
            mo20860a("response result is null");
            return;
        }
        int optInt = jSONObject.optInt("status", AbstractAdglAnimation.INVALIDE_VALUE);
        if (optInt == -9999) {
            mo20859a(c11356k.f30855a);
        } else if (optInt != 1 && optInt != 200) {
            String optString = c11356k.f30855a.optString("msg");
            if (TextUtils.isEmpty(optString)) {
                optString = "error message is null";
            }
            mo20860a(optString);
        } else {
            mo20859a(c11356k.f30855a.optJSONObject("data"));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21051a(C11356k<JSONObject> c11356k) {
        if (c11356k == null) {
            mo20860a("response is null");
            return;
        }
        NetworkResponse networkResponse = c11356k.f30857c;
        if (networkResponse == null) {
            m22225b(c11356k);
        } else if (networkResponse.f30751a == 204) {
            mo20859a(new JSONObject());
        } else {
            m22225b(c11356k);
        }
    }

    /* renamed from: a */
    public abstract void mo20860a(String str);

    /* renamed from: a */
    public abstract void mo20859a(JSONObject jSONObject);

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21052a(CommonError commonError) {
        String str = f30820a;
        SameLogTool.m21733d(str, "errorCode = " + commonError.f30690a);
        mo20860a(CommonHttpConfig.m22259a(commonError));
    }
}
