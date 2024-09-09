package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class vc {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f26828c = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    /* renamed from: w  reason: collision with root package name */
    private static final String[] f26829w = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", "version_name", "device_type", "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String c(Context context, JSONObject jSONObject, String str, boolean z3, IAppParam iAppParam) {
        HashMap<String, String> appSSIDs;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap hashMap = new HashMap(f26828c.length + 10);
        int i4 = 0;
        while (true) {
            String[] strArr = f26828c;
            if (i4 >= strArr.length) {
                break;
            }
            String optString = jSONObject.optString(strArr[i4], null);
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(f26829w[i4], optString);
            }
            i4++;
        }
        if (iAppParam != null) {
            try {
                appSSIDs = iAppParam.getAppSSIDs(context);
            } catch (Exception e4) {
                be.w(e4);
            }
        } else {
            appSSIDs = null;
        }
        if (g.w(context) && appSSIDs != null) {
            hashMap.putAll(appSSIDs);
        }
        try {
            HashMap<String, String> extraParams = c.w() == null ? null : c.w().getExtraParams();
            if (extraParams != null) {
                hashMap.putAll(extraParams);
            }
        } catch (Exception e5) {
            be.w(e5);
        }
        if (c.f26716w.size() > 0) {
            hashMap.putAll(c.f26716w);
        }
        if (z3) {
            hashMap.put("ssmix", "a");
        }
        String c4 = fm.c(context);
        if (!TextUtils.isEmpty(c4)) {
            hashMap.put("ac", c4);
        }
        String str2 = (String) c.c("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) c.c("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("channel", str2);
        }
        String optString2 = jSONObject.optString("os_version", null);
        if (optString2 != null && optString2.length() > 10) {
            optString2 = optString2.substring(0, 10);
        }
        hashMap.put("os_version", optString2);
        hashMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
        hashMap.put("device_platform", "android");
        int intValue = ((Integer) c.c("version_code", -1)).intValue();
        if (intValue != -1) {
            hashMap.put("version_code", String.valueOf(intValue));
        }
        int intValue2 = ((Integer) c.c("manifest_version_code", -1)).intValue();
        if (intValue2 != -1) {
            hashMap.put("manifest_version_code", String.valueOf(intValue2));
        }
        int intValue3 = ((Integer) c.c("update_version_code", -1)).intValue();
        if (intValue3 != -1) {
            hashMap.put("update_version_code", String.valueOf(intValue3));
        }
        String c5 = kk.c(jSONObject.optJSONObject(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY));
        if (!TextUtils.isEmpty(c5)) {
            hashMap.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, c5);
        }
        String optString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(optString3)) {
            hashMap.put("cdid", optString3);
        }
        if (!str.endsWith(TTPathConst.sSeparator)) {
            str = str + TTPathConst.sSeparator;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) >= 0 ? '&' : '?');
        return g.c(sb.toString(), hashMap, "UTF-8");
    }

    public static String[] c(ys ysVar, Context context, JSONObject jSONObject) {
        String[] sendUris = ysVar.ev().getSendUris();
        String[] strArr = new String[sendUris.length];
        String str = c.f() ? "?tt_data=a" : "?";
        for (int i4 = 0; i4 < sendUris.length; i4++) {
            strArr[i4] = c(context, jSONObject, sendUris[i4] + str, true, c.xv());
            strArr[i4] = gw.c(strArr[i4], gw.f26744w);
        }
        return strArr;
    }
}
