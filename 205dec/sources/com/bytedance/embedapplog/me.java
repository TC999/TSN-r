package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class me extends i {
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public me(Context context) {
        super(true, true);
        this.ux = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    @SuppressLint({"MissingPermission"})
    public boolean c(JSONObject jSONObject) {
        ck.c(jSONObject, "access", fm.c(this.ux));
        return true;
    }
}
