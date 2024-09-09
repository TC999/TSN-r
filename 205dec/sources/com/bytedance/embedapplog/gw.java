package com.bytedance.embedapplog;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gw {

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f26743c;
    private static final String[] sr = {"GET", "POST"};
    private static final String[] ux = {"aid", "app_version", "tt_data"};

    /* renamed from: w  reason: collision with root package name */
    static final String[] f26744w = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] xv = {"tt_data", "device_platform"};

    private static String c(String str) {
        String[] strArr;
        if (!TextUtils.isEmpty(str) && c.f()) {
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            ArrayList<Pair> arrayList = new ArrayList();
            for (String str2 : ux) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    arrayList.add(new Pair(str2, queryParameter));
                }
            }
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.clearQuery();
            for (Pair pair : arrayList) {
                buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
            }
            buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(ok.c(query), 8)));
            return buildUpon.build().toString();
        }
        return str;
    }

    public static boolean c(int i4) {
        return i4 >= 500 && i4 < 600;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject w(java.lang.String r3, org.json.JSONObject r4) {
        /*
            java.lang.String r4 = r4.toString()
            byte[] r4 = com.bytedance.embedapplog.ok.c(r4)
            r0 = 1
            r1 = 0
            java.lang.String r3 = c(r0, r3, r1, r4)
            if (r3 == 0) goto L1a
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L16
            r4.<init>(r3)     // Catch: org.json.JSONException -> L16
            goto L1b
        L16:
            r3 = move-exception
            r3.printStackTrace()
        L1a:
            r4 = r1
        L1b:
            if (r4 == 0) goto L2e
            java.lang.String r3 = "magic_tag"
            java.lang.String r2 = ""
            java.lang.String r3 = r4.optString(r3, r2)
            java.lang.String r2 = "ss_app_log"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L2e
            goto L2f
        L2e:
            r0 = 0
        L2f:
            if (r0 == 0) goto L38
            java.lang.String r3 = "config"
            org.json.JSONObject r3 = r4.optJSONObject(r3)
            return r3
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.gw.w(java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject xv(java.lang.String r3, org.json.JSONObject r4) {
        /*
            java.lang.String r4 = r4.toString()
            byte[] r4 = com.bytedance.embedapplog.ok.c(r4)
            r0 = 1
            r1 = 0
            java.lang.String r3 = c(r0, r3, r1, r4)
            if (r3 == 0) goto L1a
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L16
            r4.<init>(r3)     // Catch: org.json.JSONException -> L16
            goto L1b
        L16:
            r3 = move-exception
            r3.printStackTrace()
        L1a:
            r4 = r1
        L1b:
            if (r4 == 0) goto L2e
            java.lang.String r3 = "message"
            java.lang.String r2 = ""
            java.lang.String r3 = r4.optString(r3, r2)
            java.lang.String r2 = "success"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L2e
            goto L2f
        L2e:
            r0 = 0
        L2f:
            if (r0 == 0) goto L38
            java.lang.String r3 = "data"
            org.json.JSONObject r3 = r4.optJSONObject(r3)
            return r3
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.gw.xv(java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }

    public static String c(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(int r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.gw.c(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    public static JSONObject c(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap(2);
        if (c.f()) {
            hashMap.put("Content-Type", EventNetApiImpl.CONTENT_TYPE_APPLICATION_STREAM);
        } else {
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
        String c4 = c(1, c(str), hashMap, ok.c(jSONObject.toString()));
        if (c4 != null) {
            try {
                return new JSONObject(c4);
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(java.lang.String[] r9, byte[] r10, com.bytedance.embedapplog.n r11) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.gw.c(java.lang.String[], byte[], com.bytedance.embedapplog.n):int");
    }
}
