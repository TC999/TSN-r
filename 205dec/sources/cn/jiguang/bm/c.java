package cn.jiguang.bm;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.embedapplog.GameReportHelper;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {
    public static Bundle a(Context context, int i4, JSONObject jSONObject) {
        cn.jiguang.bp.h.b("JOperateHelper", "testDemo");
        return d.a(context, i4, jSONObject);
    }

    public static Bundle a(Context context, String str, JSONObject jSONObject) {
        cn.jiguang.bp.h.b("JOperateHelper", "userProfile");
        return d.a(context, str, jSONObject);
    }

    public static Bundle a(Context context, JSONObject jSONObject) {
        cn.jiguang.bp.h.b("JOperateHelper", "setLoginTag");
        return d.a(context, jSONObject);
    }

    public static Object a(Context context, String str) {
        cn.jiguang.bp.h.b("JOperateHelper", "unUserProfile");
        return d.b(context, str);
    }

    public static void a(Context context) {
        cn.jiguang.bp.h.b("JOperateHelper", "init");
        d.a(context, 0L, (String) null, false);
    }

    public static void a(Context context, long j4, String str) {
        cn.jiguang.bp.h.b("JOperateHelper", GameReportHelper.REGISTER);
    }

    public static Bundle b(Context context, JSONObject jSONObject) {
        cn.jiguang.bp.h.b("JOperateHelper", "setChannel");
        return d.b(context, jSONObject);
    }

    public static void b(Context context) {
        cn.jiguang.bp.h.b("JOperateHelper", "periodTask");
        d.a(context, 0L, (String) null, false);
    }

    public static void b(Context context, long j4, String str) {
        cn.jiguang.bp.h.b("JOperateHelper", "login");
        d.a(context, j4, str, false);
    }
}
