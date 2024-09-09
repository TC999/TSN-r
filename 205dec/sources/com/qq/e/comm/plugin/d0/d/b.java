package com.qq.e.comm.plugin.d0.d;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    protected volatile JSONObject f42239a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject a() {
        return this.f42239a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        String simpleName = getClass().getSimpleName();
        GDTLogger.d("Initialize " + simpleName + ",Json=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f42239a = new JSONObject(str);
            } catch (JSONException unused) {
                GDTLogger.d("JsonException While build" + simpleName + " Instance from JSON");
            }
        }
        if (this.f42239a == null) {
            this.f42239a = new JSONObject();
        }
    }
}
