package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class eq extends i {

    /* renamed from: f  reason: collision with root package name */
    private final n f26723f;
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(Context context, n nVar) {
        super(true, false);
        this.ux = context;
        this.f26723f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        String mac = c.k() != null ? c.k().getSensitiveInfoProvider().getMac() : "";
        if (TextUtils.isEmpty(mac)) {
            return true;
        }
        jSONObject.put("mc", mac);
        return true;
    }
}
