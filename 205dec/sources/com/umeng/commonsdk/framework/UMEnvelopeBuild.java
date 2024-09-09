package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.i;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag;

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject != null && jSONObject2 != null) {
            i a4 = i.a(context);
            long currentTimeMillis = System.currentTimeMillis();
            UUID randomUUID = UUID.randomUUID();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_tp", str2);
            contentValues.put("_hd", a4.c(jSONObject.toString()));
            contentValues.put("_bd", a4.c(jSONObject2.toString()));
            contentValues.put("_ts", String.valueOf(currentTimeMillis));
            contentValues.put("_uuid", randomUUID.toString());
            contentValues.put("_re1", str);
            contentValues.put("_re2", str3);
            bk.a(context).a("stf", contentValues);
            if ("i".equalsIgnoreCase(str2)) {
                UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]inner\u4e1a\u52a1\uff0c\u8fd4\u56de\u7a7a JSONObject\u3002");
            } else if ("s".equalsIgnoreCase(str2)) {
                UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u5206\u4eab\u4e1a\u52a1 \u8fd4\u56debody\u3002");
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("header", new JSONObject());
                    jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                    return jSONObject3;
                } catch (JSONException unused) {
                }
            } else if (!"p".equalsIgnoreCase(str2)) {
                try {
                    if ("t".equalsIgnoreCase(str2)) {
                        UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u7edf\u8ba1\u4e1a\u52a1 \u534a\u5f00\u62a5\u6587\uff0c\u8fd4\u56debody\u3002");
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(b.a("header"), new JSONObject());
                        jSONObject4.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                        return jSONObject4;
                    }
                    UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u7edf\u8ba1\u4e1a\u52a1 \u95ed\u5408\u62a5\u6587\uff0c\u8fd4\u56debody\u3002");
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(b.a("header"), new JSONObject());
                    jSONObject5.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject5;
                } catch (JSONException unused2) {
                    return jSONObject2;
                }
            }
            return new JSONObject();
        }
        UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u6784\u5efa\u4fe1\u5c01\u4f20\u5165 header \u6216 body \u5b57\u6bb5\u4e3a\u7a7a\uff0c\u76f4\u63a5\u8fd4\u56de");
        return null;
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject.has("st")) {
            str = "t";
        } else {
            str = jSONObject2.has("inner") ? "i" : "a";
        }
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, UMServerURL.PATH_ANALYTICS, str, "9.6.5");
    }

    public static JSONObject buildSilentEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        JSONObject jSONObject3;
        if (!UMUtils.isMainProgress(context)) {
            JSONObject jSONObject4 = null;
            try {
                jSONObject3 = new JSONObject();
            } catch (JSONException unused) {
            }
            try {
                jSONObject3.put("exception", 120);
                return jSONObject3;
            } catch (JSONException unused2) {
                jSONObject4 = jSONObject3;
                return jSONObject4;
            }
        }
        return new b().a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str);
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        JSONObject jSONObject3;
        if (!UMUtils.isMainProgress(context)) {
            JSONObject jSONObject4 = null;
            try {
                jSONObject3 = new JSONObject();
            } catch (JSONException unused) {
            }
            try {
                jSONObject3.put("exception", 120);
                return jSONObject3;
            } catch (JSONException unused2) {
                jSONObject4 = jSONObject3;
                return jSONObject4;
            }
        }
        return new b().b(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str);
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastInstantBuildTime(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static synchronized boolean getTransmissionSendFlag() {
        boolean z3;
        synchronized (UMEnvelopeBuild.class) {
            z3 = transmissionSendFlag;
        }
        return z3;
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(StubApp.getOrigApplicationContext(context.getApplicationContext())).c().a(str, str2);
    }

    public static boolean isOnline(Context context) {
        return UMFrUtils.isOnline(context) && (UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        a.a(context);
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (getTransmissionSendFlag()) {
            return isRet(context, uMBusinessType, false);
        }
        return false;
    }

    public static boolean isReadyBuildStateless() {
        return getTransmissionSendFlag();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5) == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isRet(android.content.Context r5, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r6, boolean r7) {
        /*
            if (r5 == 0) goto L47
            android.content.Context r0 = r5.getApplicationContext()
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)
            boolean r1 = com.umeng.commonsdk.framework.UMFrUtils.isOnline(r0)
            int r2 = com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(r0)
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L40
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r7 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL
            if (r6 != r7) goto L23
            boolean r5 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r5 == 0) goto L21
            goto L31
        L21:
            r7 = 1
            goto L40
        L23:
            boolean r7 = com.umeng.commonsdk.framework.a.a()
            if (r7 == 0) goto L33
            int r5 = com.umeng.commonsdk.framework.a.b()
            long r5 = (long) r5
            com.umeng.commonsdk.framework.UMWorkDispatch.sendDelayProcessMsg(r5)
        L31:
            r7 = 0
            goto L40
        L33:
            boolean r6 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r6 != 0) goto L31
            boolean r5 = com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5)
            if (r5 == 0) goto L21
            goto L31
        L40:
            if (r1 == 0) goto L47
            if (r2 <= 0) goto L47
            com.umeng.commonsdk.framework.a.d()
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMEnvelopeBuild.isRet(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType, boolean):boolean");
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return b.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static void registerNetReceiver(Context context) {
        a.b(context);
    }

    public static void sendProcessNextMsgOnce() {
        a.d();
    }

    public static synchronized void setTransmissionSendFlag(boolean z3) {
        synchronized (UMEnvelopeBuild.class) {
            transmissionSendFlag = z3;
        }
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u4e1a\u52a1\u53d1\u8d77\u6784\u5efa\u666e\u901a\u6709\u72b6\u6001\u4fe1\u5c01\u8bf7\u6c42\u3002");
        JSONObject jSONObject5 = null;
        if (TextUtils.isEmpty(str)) {
            try {
                jSONObject3 = new JSONObject();
            } catch (JSONException unused) {
            }
            try {
                jSONObject3.put("exception", 121);
                return jSONObject3;
            } catch (JSONException unused2) {
                jSONObject5 = jSONObject3;
                return jSONObject5;
            }
        } else if (!UMUtils.isMainProgress(context)) {
            try {
                jSONObject4 = new JSONObject();
            } catch (JSONException unused3) {
            }
            try {
                jSONObject4.put("exception", 120);
                return jSONObject4;
            } catch (JSONException unused4) {
                jSONObject5 = jSONObject4;
                return jSONObject5;
            }
        } else if (UMConfigure.needSendZcfgEnv(context)) {
            UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u96f6\u53f7\u62a5\u6587\u5e94\u7b54\u6570\u636e \u672a\u83b7\u53d6\u5230\uff0c\u5199\u5165\u4e8c\u7ea7\u7f13\u5b58");
            return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        } else {
            UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u96f6\u53f7\u62a5\u6587\u5e94\u7b54\u6570\u636e \u5df2\u83b7\u53d6\u5230\uff0c\u5224\u65ad\u4e8c\u7ea7\u7f13\u5b58\u662f\u5426\u4e3a\u7a7a");
            if (bk.a(context).c()) {
                UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u4e8c\u7ea7\u7f13\u5b58\u4e3a\u7a7a\uff0c\u76f4\u63a5\u6253\u4fe1\u5c01");
                return new b().a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str, str2, str3);
            }
            UMRTLog.e("MobclickRT", "--->>> [\u6709\u72b6\u6001]\u4e8c\u7ea7\u7f13\u5b58\u4e0d\u4e3a\u7a7a\uff0c\u5199\u5165\u4e8c\u7ea7\u7f13\u5b58");
            JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
            if (!UMWorkDispatch.eventHasExist(32785)) {
                UMWorkDispatch.sendEvent(context, 32785, com.umeng.commonsdk.internal.b.a(context).a(), null);
            }
            return add2CacheTable;
        }
    }
}
