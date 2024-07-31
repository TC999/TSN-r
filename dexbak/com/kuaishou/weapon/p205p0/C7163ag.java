package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ag */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7163ag {
    /* renamed from: a */
    public static JSONObject m34421a(Context context) {
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
