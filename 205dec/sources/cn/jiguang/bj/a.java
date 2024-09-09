package cn.jiguang.bj;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static JSONObject a(Context context) {
        try {
            Object a4 = f.a(context, JConstants.SDK_TYPE, 101, null, null, new Object[0]);
            if (a4 instanceof JSONObject) {
                return (JSONObject) a4;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bi.b.e("JDeviceHelper", "getDInfo exception: " + th.getMessage());
            return null;
        }
    }
}
