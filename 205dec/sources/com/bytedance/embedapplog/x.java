package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class x extends i {
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Context context) {
        super(true, false);
        this.ux = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        ck.c(jSONObject, "sim_region", ((TelephonyManager) this.ux.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
