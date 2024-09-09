package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m extends i {

    /* renamed from: f  reason: collision with root package name */
    private final n f26763f;
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context, n nVar) {
        super(true, false);
        this.ux = context;
        this.f26763f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.ux.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                ck.c(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                ck.c(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                ck.c(jSONObject, "udid", this.f26763f.m() ? te.c(telephonyManager) : this.f26763f.bw());
                return true;
            } catch (Exception e4) {
                be.w(e4);
            }
        }
        return false;
    }
}
