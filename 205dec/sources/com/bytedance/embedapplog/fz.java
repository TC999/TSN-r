package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fz extends i {

    /* renamed from: f  reason: collision with root package name */
    private final n f26729f;
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(Context context, n nVar) {
        super(true, false);
        this.ux = context;
        this.f26729f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f26729f.xk())) {
            jSONObject.put("ab_client", this.f26729f.xk());
        }
        if (!TextUtils.isEmpty(this.f26729f.fz())) {
            if (be.f26702w) {
                be.c("init config has abversion:" + this.f26729f.fz(), null);
            }
            jSONObject.put("ab_version", this.f26729f.fz());
        }
        if (!TextUtils.isEmpty(this.f26729f.yu())) {
            jSONObject.put("ab_group", this.f26729f.yu());
        }
        if (TextUtils.isEmpty(this.f26729f.wx())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f26729f.wx());
        return true;
    }
}
