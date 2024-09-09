package cn.jiguang.aj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f2251a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f2252b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final FileFilter f2253c = new FileFilter() { // from class: cn.jiguang.aj.a.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i4 = 3; i4 < name.length(); i4++) {
                    if (name.charAt(i4) < '0' || name.charAt(i4) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };

    public static JSONObject a(Context context) {
        StringBuilder sb;
        String message;
        if (context == null) {
            cn.jiguang.w.a.f("JDeviceHelper", "when getDInfo, context can't be null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String c4 = cn.jiguang.ag.a.c(context);
            String a4 = cn.jiguang.bb.a.a(context);
            if (TextUtils.isEmpty(c4)) {
                c4 = "";
            }
            jSONObject.put("resolution", c4);
            if (TextUtils.isEmpty(a4)) {
                a4 = "";
            }
            jSONObject.put("screensize", a4);
            if (cn.jiguang.ar.a.a().e(1014)) {
                jSONObject.put("os_version", cn.jiguang.ag.a.v(context));
            }
            if (cn.jiguang.ar.a.a().e(2009)) {
                jSONObject.put("model", cn.jiguang.ag.a.p(context));
            }
            jSONObject.put("brand", cn.jiguang.ag.a.r(context));
            jSONObject.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, cn.jiguang.ag.a.n(context));
            if (cn.jiguang.ar.a.a().e(1009)) {
                jSONObject.put("language", cn.jiguang.ag.a.s(context));
            }
            if (cn.jiguang.ar.a.a().e(2008)) {
                jSONObject.put("manufacturer", cn.jiguang.ag.a.t(context));
            }
            jSONObject.put("timezone", cn.jiguang.ag.a.u(context));
            return jSONObject;
        } catch (JSONException e4) {
            sb = new StringBuilder();
            sb.append("package json exception: ");
            message = e4.getMessage();
            sb.append(message);
            cn.jiguang.w.a.f("JDeviceHelper", sb.toString());
            return null;
        } catch (Throwable th) {
            sb = new StringBuilder();
            sb.append("getDInfo exception: ");
            message = th.getMessage();
            sb.append(message);
            cn.jiguang.w.a.f("JDeviceHelper", sb.toString());
            return null;
        }
    }
}
