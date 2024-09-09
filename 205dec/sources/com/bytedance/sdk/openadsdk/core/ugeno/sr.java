package com.bytedance.sdk.openadsdk.core.ugeno;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {

    /* renamed from: c  reason: collision with root package name */
    private static volatile sr f35030c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.f.c f35031w = ba.c("ugeno_template_file");

    private sr() {
    }

    public static sr c() {
        if (f35030c == null) {
            synchronized (sr.class) {
                if (f35030c == null) {
                    f35030c = new sr();
                }
            }
        }
        return f35030c;
    }

    public boolean w(String str, String str2) {
        return c(str, str2) != null;
    }

    public void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.f35031w.c("ugeno_" + str, str3);
        this.f35031w.c("ugeno__md5_" + str, str2);
    }

    public JSONObject c(String str, String str2) {
        String w3 = this.f35031w.w("ugeno_" + str, "");
        if (TextUtils.isEmpty(w3)) {
            return null;
        }
        String w4 = this.f35031w.w("ugeno__md5_" + str, "");
        if (!TextUtils.isEmpty(w4) && TextUtils.equals(w4, str2)) {
            try {
                return new JSONObject(w3);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }
}
