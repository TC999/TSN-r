package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import java.io.File;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ag {
    public static JSONObject a(Context context) {
        File file;
        JSONObject jSONObject = new JSONObject();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(context.getDataDir(), "xreplace");
            } else {
                file = new File("/data/data/" + context.getPackageName() + "/xreplace");
            }
            if (file.exists()) {
                jSONObject.put("xreplace", 1);
            }
            if (new File("/storage/emulated/0/xxsq").exists()) {
                jSONObject.put("xxsq", 1);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
