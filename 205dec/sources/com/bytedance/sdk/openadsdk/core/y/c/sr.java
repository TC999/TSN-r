package com.bytedance.sdk.openadsdk.core.y.c;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    private static String c(long j4) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", "300012449765");
            jSONObject.put("version", "1.0");
            String c4 = c(System.currentTimeMillis());
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, c4);
            jSONObject.put("appkey", "90E4DEDAD9B1CB57EA1538871ED468A7");
            jSONObject.put("businessType", "3");
            String uuid = UUID.randomUUID().toString();
            jSONObject.put("traceId", uuid);
            jSONObject.put("msgId", uuid);
            jSONObject.put("sign", com.bytedance.sdk.component.utils.ux.w("3000124497653" + uuid + c4 + uuid + "1.090E4DEDAD9B1CB57EA1538871ED468A7"));
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append("?");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", "9386206798");
            jSONObject.put("clientType", "Android-30100");
            jSONObject.put("format", "json");
            jSONObject.put("version", "v1.5");
            String c4 = c.c(str2.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB");
            jSONObject.put("paramKey", c4);
            long currentTimeMillis = System.currentTimeMillis();
            String c5 = c.c(true, ("timeStamp=" + currentTimeMillis).getBytes(), str2);
            jSONObject.put("paramStr", c5);
            String[] strArr = {"9386206798", "Android-30100", "json", c4, c5, "v1.5"};
            StringBuilder sb2 = new StringBuilder();
            for (int i4 = 0; i4 < 6; i4++) {
                sb2.append(strArr[i4]);
            }
            jSONObject.put("sign", c.c(sb2.toString(), "tgIBkg304BUpjGHLSq1wYYb0Xs77pMIm"));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                sb.append(next);
                sb.append("=");
                sb.append(string);
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
