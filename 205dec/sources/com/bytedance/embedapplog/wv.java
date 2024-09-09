package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class wv extends i {

    /* renamed from: f  reason: collision with root package name */
    private final n f26836f;
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public wv(Context context, n nVar) {
        super(true, false);
        this.ux = context;
        this.f26836f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        Map<String, String> c4 = kk.c(this.ux, this.f26836f.sr());
        if (c4 != null) {
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, new JSONObject(c4));
            return true;
        }
        return false;
    }
}
