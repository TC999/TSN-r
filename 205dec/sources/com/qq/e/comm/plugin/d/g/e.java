package com.qq.e.comm.plugin.d.g;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.utils.AVErrorInfo;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.p;
import com.qq.e.comm.plugin.util.v0;
import com.qq.e.comm.plugin.util.w1;
import com.qq.e.comm.plugin.util.x1;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements d {
    private JSONObject b(b bVar) throws Throwable {
        Context a4 = com.qq.e.comm.plugin.d.a.a();
        com.qq.e.comm.plugin.d0.e.a b4 = com.qq.e.comm.plugin.d0.a.d().b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdk", a());
        jSONObject.put("app", a(b4));
        jSONObject.put("device", b(a4));
        jSONObject.put("state", c(bVar));
        jSONObject.put(AVErrorInfo.CRASH, a(b4, bVar));
        return jSONObject;
    }

    private JSONObject c(b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (p.b().c()) {
            jSONObject.put("foreground", 1);
        }
        jSONObject.put("it", com.qq.e.comm.plugin.d.a.g());
        jSONObject.put("net", v0.b().b());
        jSONObject.put("life", bVar.f42190e);
        return jSONObject;
    }

    @Override // com.qq.e.comm.plugin.d.g.d
    public boolean a(b bVar) {
        try {
            byte[] a4 = com.qq.e.comm.plugin.d.e.a(b(bVar).toString().getBytes(com.qq.e.comm.plugin.k.a.f44515a));
            if (a4 != null && a4.length != 0) {
                bVar.f42196k = a4;
                File file = new File(com.qq.e.comm.plugin.d.a.c(), bVar.f42192g);
                bVar.f42193h = file;
                b1.a(file, a4);
                return bVar.f42194i;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject b(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("os", 2);
        jSONObject.put("osVer", Build.VERSION.SDK_INT);
        jSONObject.put("tgtVer", context.getApplicationInfo().targetSdkVersion);
        jSONObject.put("name", a(context));
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("arch", w1.b());
        return jSONObject;
    }

    private JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", com.qq.e.comm.plugin.d.a.b());
        jSONObject.put("ver", com.qq.e.comm.plugin.d.a.j() + "." + com.qq.e.comm.plugin.d.a.i());
        jSONObject.put("pv", com.qq.e.comm.plugin.d.a.i());
        if (com.qq.e.comm.plugin.d.a.k()) {
            jSONObject.put("np", 1);
        }
        return jSONObject;
    }

    private JSONObject a(com.qq.e.comm.plugin.d0.e.a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pkg", aVar.b());
        jSONObject.put("ver", aVar.d());
        return jSONObject;
    }

    private String a(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), x1.a("Ymx1ZXRvb3RoX25hbWU="));
        } catch (Throwable unused) {
            return "";
        }
    }

    private JSONObject a(com.qq.e.comm.plugin.d0.e.a aVar, b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("crashID", bVar.f42186a);
        jSONObject.put("process", aVar.e());
        jSONObject.put("thread", bVar.f42187b.getName());
        jSONObject.put("index", bVar.f42187b.getId());
        jSONObject.put("time", bVar.f42189d);
        jSONObject.put("type", "Java");
        Throwable th = bVar.f42188c;
        jSONObject.put("name", th.getClass().getName());
        jSONObject.put("reason", th.getMessage());
        jSONObject.put("stacktrace", a(bVar.f42191f));
        return jSONObject;
    }

    private JSONArray a(StackTraceElement[] stackTraceElementArr) throws JSONException {
        String fileName;
        JSONArray jSONArray = new JSONArray();
        if (stackTraceElementArr == null) {
            return jSONArray;
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            JSONObject jSONObject = new JSONObject();
            if (stackTraceElement.isNativeMethod()) {
                fileName = "Native Method";
            } else {
                fileName = stackTraceElement.getFileName();
                if (fileName == null) {
                    fileName = "Unknown Source";
                }
            }
            jSONObject.put("object_name", fileName);
            jSONObject.put("symbol_name", stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
            int lineNumber = stackTraceElement.getLineNumber();
            if (lineNumber >= 0) {
                jSONObject.put("symbol_addr_offset", lineNumber);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
