package com.beizi.fusion.p072g;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.JsonResolver;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p066d.p067a.BidS2SRequestModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.offline.api.p341tk.model.report.TKDownloadReason;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.beizi.fusion.g.ab */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HttpUtil {

    /* renamed from: a */
    private static String f11226a = "HttpUtil";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae A[Catch: IOException -> 0x00c9, TRY_ENTER, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:79:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3 A[Catch: IOException -> 0x00c9, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:79:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8 A[Catch: IOException -> 0x00c9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:79:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c5 A[Catch: IOException -> 0x00c9, TRY_ENTER, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:79:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd A[Catch: IOException -> 0x00c9, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:79:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d2 A[Catch: IOException -> 0x00c9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00c9, blocks: (B:44:0x00ae, B:46:0x00b3, B:48:0x00b8, B:55:0x00c5, B:59:0x00cd, B:61:0x00d2, B:33:0x009b), top: B:79:0x0006 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48508a(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.HttpUtil.m48508a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private static byte[] m48506b(Context context, String str) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ConstantHelper.LOG_VS, "4.90.4.5");
            jSONObject.put("srcType", 1);
            jSONObject.put("timeStamp", System.currentTimeMillis());
            jSONObject.put("appid", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkUID", devInfo.getSdkUID());
            jSONObject2.put("sdkUIDOrig", devInfo.getSdkUIDOrig());
            jSONObject2.put("os", devInfo.getOs());
            jSONObject2.put(Constants.PARAM_PLATFORM, 2);
            jSONObject2.put("devType", Integer.valueOf(devInfo.getDevType()));
            jSONObject2.put(C2624bk.f8686j, devInfo.getBrand());
            jSONObject2.put(C2624bk.f8685i, devInfo.getModel());
            jSONObject2.put(UMCommonContent.f37867z, devInfo.getResolution());
            jSONObject2.put("screenSize", devInfo.getScreenSize());
            jSONObject2.put("language", devInfo.getLanguage());
            jSONObject2.put("density", devInfo.getDensity());
            jSONObject2.put("root", devInfo.getRoot());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TKDownloadReason.KSAD_TK_NET, Integer.valueOf(envInfo.getNet()));
            jSONObject3.put("isp", Integer.valueOf(envInfo.getIsp()));
            jSONObject.putOpt("devInfo", jSONObject2);
            jSONObject.putOpt("envInfo", jSONObject3);
            String m48270a = AesUtils.m48270a(C3112ad.m48504a(), jSONObject.toString());
            if (TextUtils.isEmpty(m48270a)) {
                return null;
            }
            return m48270a.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ed A[Catch: IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0117, blocks: (B:72:0x00ed, B:89:0x0113, B:47:0x00b4), top: B:116:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0113 A[Catch: IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0117, blocks: (B:72:0x00ed, B:89:0x0113, B:47:0x00b4), top: B:116:0x0001 }] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48507a(java.lang.String r7, byte[] r8) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.HttpUtil.m48507a(java.lang.String, byte[]):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ac A[Catch: IOException -> 0x01b0, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x01b0, blocks: (B:84:0x0186, B:100:0x01ac, B:58:0x0147), top: B:129:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0186 A[Catch: IOException -> 0x01b0, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x01b0, blocks: (B:84:0x0186, B:100:0x01ac, B:58:0x0147), top: B:129:0x0003 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.OutputStream] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48512a(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.HttpUtil.m48512a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48509a(java.lang.String r11, java.io.File r12) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.HttpUtil.m48509a(java.lang.String, java.io.File):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f9 A[Catch: IOException -> 0x013a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x013a, blocks: (B:70:0x00f9, B:93:0x0136, B:52:0x00c4), top: B:99:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0136 A[Catch: IOException -> 0x013a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x013a, blocks: (B:70:0x00f9, B:93:0x0136, B:52:0x00c4), top: B:99:0x0018 }] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.InputStreamReader] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48511a(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.Boolean r8) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.HttpUtil.m48511a(android.content.Context, java.lang.String, java.lang.String, java.lang.Boolean):java.lang.String");
    }

    /* renamed from: a */
    private static byte[] m48513a(Context context, String str) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", str);
            jSONObject.put(TTDownloadField.TT_PACKAGE_NAME, C3138av.m48296c(context));
            jSONObject.put("installTime", String.valueOf(C3138av.m48305a(context)));
            jSONObject.put("updateTime", String.valueOf(C3138av.m48299b(context)));
            jSONObject.put("uploadTime", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("appVersion", C3138av.m48294d(context));
            jSONObject.put("sdkVersion", "4.90.4.5");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkUID", devInfo.getSdkUID());
            jSONObject2.put("sdkUIDOrig", devInfo.getSdkUIDOrig());
            if (!TextUtils.isEmpty(devInfo.getOaid())) {
                jSONObject2.put("oaid", devInfo.getOaid());
            } else if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
                jSONObject2.put("oaid", requestInfo.getCustomOaid());
            }
            jSONObject2.put("gaid", devInfo.getGaid());
            jSONObject2.put("os", devInfo.getOs());
            jSONObject2.put(Constants.PARAM_PLATFORM, "2");
            jSONObject2.put("devType", devInfo.getDevType());
            jSONObject2.put(C2624bk.f8686j, devInfo.getBrand());
            jSONObject2.put(C2624bk.f8685i, devInfo.getModel());
            jSONObject2.put(UMCommonContent.f37867z, devInfo.getResolution());
            jSONObject2.put("screenSize", devInfo.getScreenSize());
            jSONObject2.put("language", devInfo.getLanguage());
            jSONObject2.put("density", devInfo.getDensity());
            jSONObject2.put("root", devInfo.getRoot());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TKDownloadReason.KSAD_TK_NET, envInfo.getNet());
            jSONObject3.put("isp", envInfo.getIsp());
            jSONObject3.put("developerMode", C3138av.m48290h(context));
            jSONObject3.put("isDebugApk", C3138av.m48291g(context));
            jSONObject3.put("isDebugConnected", Debug.isDebuggerConnected());
            jSONObject3.put("isWifiProxy", C3138av.m48289i(context));
            jSONObject3.put("isVpn", C3138av.m48300b());
            jSONObject3.put("isSimulator", EmulatorCheckUtil.m48200a().m48199a(context));
            jSONObject.putOpt("devInfo", jSONObject2);
            jSONObject.putOpt("envInfo", jSONObject3);
            String m48272a = C3143c.m48272a(jSONObject.toString(), C3112ad.m48503b());
            if (TextUtils.isEmpty(m48272a)) {
                return null;
            }
            return m48272a.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m48510a(Context context, String str, String str2, boolean z, List<String> list, List<BidS2SRequestModel.C3068k> list2, int i) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            BidS2SRequestModel bidS2SRequestModel = new BidS2SRequestModel();
            BidS2SRequestModel.C3066i c3066i = new BidS2SRequestModel.C3066i();
            c3066i.m48809a(str);
            c3066i.m48812a(0);
            c3066i.m48807b(i);
            c3066i.m48805c(1);
            ArrayList arrayList = new ArrayList();
            arrayList.add("CNY");
            c3066i.m48808a(arrayList);
            c3066i.m48806b(list);
            c3066i.m48803d(1);
            ArrayList arrayList2 = new ArrayList();
            BidS2SRequestModel.C3063f c3063f = new BidS2SRequestModel.C3063f();
            c3063f.m48821a("1");
            c3063f.m48823a(1);
            c3063f.m48820b(1);
            c3063f.m48819c(1);
            BidS2SRequestModel.C3064g c3064g = new BidS2SRequestModel.C3064g();
            BidS2SRequestModel.C3065h c3065h = new BidS2SRequestModel.C3065h();
            c3065h.m48815a(str2);
            c3065h.m48814b("AdScope");
            c3065h.m48813c("4.90.4.5");
            c3065h.m48816a(z ? 1 : 0);
            c3064g.m48817a(c3065h);
            c3063f.m48822a(c3064g);
            c3063f.m48818d(1);
            arrayList2.add(c3063f);
            c3066i.m48804c(arrayList2);
            BidS2SRequestModel.C3060c c3060c = new BidS2SRequestModel.C3060c();
            BidS2SRequestModel.C3058a c3058a = new BidS2SRequestModel.C3058a();
            c3058a.m48845a(C3138av.m48296c(context));
            c3058a.m48844b(C3138av.m48294d(context));
            BidS2SRequestModel.C3059b c3059b = new BidS2SRequestModel.C3059b();
            c3059b.m48843a(AdManager.m48786a().m48782b());
            c3058a.m48846a(c3059b);
            c3060c.m48842a(c3058a);
            BidS2SRequestModel.C3061d c3061d = new BidS2SRequestModel.C3061d();
            c3061d.m48839a(Integer.valueOf(devInfo.getDevType()).intValue());
            c3061d.m48837a(envInfo.getUserAgent());
            c3061d.m48835b(1);
            c3061d.m48837a(envInfo.getUserAgent());
            c3061d.m48834b(devInfo.getBrand());
            c3061d.m48832c(devInfo.getModel());
            c3061d.m48833c(2);
            c3061d.m48831d(Build.VERSION.RELEASE);
            c3061d.m48840a(C3138av.m48285m(context));
            c3061d.m48836b(C3138av.m48286l(context));
            c3061d.m48830e(devInfo.getDensityDpi());
            c3061d.m48829f(devInfo.getDensity());
            c3061d.m48828g(devInfo.getLanguage());
            c3061d.m48827h(envInfo.getIsp());
            c3061d.m48826i(envInfo.getNet());
            BidS2SRequestModel.C3062e c3062e = new BidS2SRequestModel.C3062e();
            c3062e.m48825a(devInfo.getSdkUID());
            if (!TextUtils.isEmpty(devInfo.getOaid())) {
                c3062e.m48824b(devInfo.getOaid());
            } else if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
                c3062e.m48824b(requestInfo.getCustomOaid());
            }
            c3061d.m48838a(c3062e);
            c3060c.m48841a(c3061d);
            c3066i.m48811a(c3060c);
            BidS2SRequestModel.C3067j c3067j = new BidS2SRequestModel.C3067j();
            c3067j.m48802a(list2);
            c3066i.m48810a(c3067j);
            bidS2SRequestModel.m48847a(c3066i);
            String m48270a = AesUtils.m48270a(C3112ad.m48504a(), JsonResolver.toJson(bidS2SRequestModel));
            if (TextUtils.isEmpty(m48270a)) {
                return null;
            }
            return m48270a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
