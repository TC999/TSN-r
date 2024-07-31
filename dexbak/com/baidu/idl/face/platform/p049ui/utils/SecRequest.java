package com.baidu.idl.face.platform.p049ui.utils;

import android.content.Context;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.net.URLDecoder;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.baidu.idl.face.platform.ui.utils.SecRequest */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SecRequest {
    private static final String REQUEST_URL = "http://10.138.32.176:8518/api/v3/person/verify_sec?appid=7758258";
    private static final String TAG = "SecRequest";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b9 A[Catch: Exception -> 0x00ee, TRY_ENTER, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01be A[Catch: Exception -> 0x00ee, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c3 A[Catch: Exception -> 0x00ee, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c8 A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014a A[Catch: Exception -> 0x00ee, TRY_ENTER, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014f A[Catch: Exception -> 0x00ee, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0154 A[Catch: Exception -> 0x00ee, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0159 A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0182 A[Catch: Exception -> 0x00ee, TRY_ENTER, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0187 A[Catch: Exception -> 0x00ee, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018c A[Catch: Exception -> 0x00ee, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0191 A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ee, blocks: (B:39:0x00dc, B:41:0x00e1, B:43:0x00e6, B:44:0x00e9, B:78:0x014a, B:80:0x014f, B:82:0x0154, B:84:0x0159, B:91:0x0182, B:93:0x0187, B:95:0x018c, B:97:0x0191, B:104:0x01b9, B:106:0x01be, B:108:0x01c3, B:110:0x01c8), top: B:128:0x0003 }] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String requestPost(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.p049ui.utils.SecRequest.requestPost(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void sendMessage(final Context context, final String str, final int i) {
        new Thread(new Runnable() { // from class: com.baidu.idl.face.platform.ui.utils.SecRequest.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("image_type", "BASE64");
                    jSONObject.put(SocializeProtocolConstants.IMAGE, str);
                    jSONObject.put("id_card_number", "101111111111111111");
                    jSONObject.put("name", URLDecoder.decode("张三", "UTF-8"));
                    jSONObject.put("quality_control", "NONE");
                    jSONObject.put("liveness_control", "NONE");
                    jSONObject.put("risk_identify", false);
                    jSONObject.put(UMCommonContent.f37808al, FaceSDKManager.getInstance().getZid(context));
                    jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, "172.30.154.173");
                    jSONObject.put("phone", "13000000000");
                    int i2 = i;
                    if (i2 == 0) {
                        jSONObject.put("image_sec", false);
                    } else if (i2 == 1) {
                        jSONObject.put("image_sec", true);
                    }
                    jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, "Android");
                    jSONObject.put("ev", "smrz");
                    SecRequest.requestPost(jSONObject.toString(), SecRequest.REQUEST_URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
