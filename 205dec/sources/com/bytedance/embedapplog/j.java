package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class j extends i {
    private final n ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, n nVar) {
        super(true, false);
        this.ux = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        String c4 = kk.c(this.ux.sr());
        if (TextUtils.isEmpty(c4)) {
            return false;
        }
        jSONObject.put("cdid", c4);
        return true;
    }
}
