package cn.jpush.android.helper;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {
    public static void a(Context context, String str, byte b4, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "", b4, 1000L, context, str2, null);
            return;
        }
        Logger.ee("JPushReportHelper", "The msgId is not valid - " + str);
    }

    public static void a(Context context, String str, long j4, int i4) {
        a(str, e.a(i4, j4), (String) null, context);
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        Logger.d("JPushReportHelper", "action:reportOperation - content:" + jSONObject.toString());
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 14, null, null, jSONObject);
    }

    public static void a(Context context, boolean z3, String str) {
        try {
            Logger.d("JPushReportHelper", "report smartp :" + z3);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", str);
            jSONObject2.put("status", z3 ? 1 : 2);
            jSONObject.put("data", jSONObject2);
            JCoreHelper.fillBase(context, jSONObject, "collect_statu");
            a(context, jSONObject);
        } catch (Throwable th) {
            Logger.w("JPushReportHelper", "report smartp_statu failed, error:" + th.getMessage());
        }
    }

    public static void a(String str, long j4, Context context) {
        a(str, j4, (String) null, context);
    }

    public static void a(String str, long j4, String str2, Context context) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportActionResult - messageId: " + str + ", code: " + j4 + "-" + e.a(j4));
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("\uff0c report content: " + str2);
        }
        String c4 = cn.jpush.android.d.d.c(str);
        if (!TextUtils.isEmpty(c4)) {
            stringBuffer.append("\uff0c report jData:" + c4);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
            jSONObject.put("result", j4);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("data", str2);
            }
            if (!TextUtils.isEmpty(c4)) {
                jSONObject.put("_j_data_", c4);
            }
            JSONObject fillBase = JCoreHelper.fillBase(context, jSONObject, "msg_status");
            if (fillBase != null) {
                fillBase.put("type", "msg_status");
                a(context, fillBase);
                return;
            }
            Logger.ww("JPushReportHelper", "report msg json is null, code: " + j4);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, byte b4, long j4, Context context) {
        a(str, str2, b4, j4, context, null, null);
    }

    public static void a(String str, String str2, byte b4, long j4, Context context, String str3, String str4) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportThirdSDKMsgActionResult - messageId: " + str + ", code: " + j4);
        if (!TextUtils.isEmpty(str4)) {
            stringBuffer.append("\uff0c report content: " + str4);
        }
        String c4 = cn.jpush.android.d.d.c(str);
        if (TextUtils.isEmpty(c4) && !TextUtils.isEmpty(str3)) {
            try {
                c4 = new JSONObject(str3).optString("_j_data_", "");
                Logger.d("JPushReportHelper", "get jdata from third push msg:" + c4);
            } catch (Throwable th) {
                Logger.d("JPushReportHelper", "get jdata from third push msg error:" + th.getMessage());
            }
        }
        if (!TextUtils.isEmpty(c4)) {
            stringBuffer.append("\uff0c report jData:" + c4);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
            jSONObject.put("tmsg_id", str2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("data", str4);
            }
            jSONObject.put("result", j4);
            jSONObject.put("sdk_type", (int) b4);
            if (!TextUtils.isEmpty(c4)) {
                jSONObject.put("_j_data_", c4);
            }
            JSONObject fillBase = JCoreHelper.fillBase(context, jSONObject, "third_msg_status");
            if (fillBase != null) {
                fillBase.put("type", "third_msg_status");
                a(context, fillBase);
                return;
            }
            Logger.ww("JPushReportHelper", "report third sdk msg json is null, code: " + j4);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, Map<String, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            JCoreHelper.fillBase(context, jSONObject, "api_record");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().intValue() != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("method", entry.getKey());
                    jSONObject2.put("count", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("record_list", jSONArray);
            a(context, jSONObject);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }
}
