package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.C13131bm;
import com.umeng.analytics.pro.CacheDBHelper;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.analytics.pro.UMStoreManager;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.UMInternalData;
import com.umeng.commonsdk.statistics.EnvelopeManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag;

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject != null && jSONObject2 != null) {
            UMStoreManager m14345a = UMStoreManager.m14345a(context);
            long currentTimeMillis = System.currentTimeMillis();
            UUID randomUUID = UUID.randomUUID();
            ContentValues contentValues = new ContentValues();
            contentValues.put(C13131bm.f37928e, str2);
            contentValues.put(C13131bm.f37929f, m14345a.m14323c(jSONObject.toString()));
            contentValues.put(C13131bm.f37930g, m14345a.m14323c(jSONObject2.toString()));
            contentValues.put(C13131bm.f37931h, String.valueOf(currentTimeMillis));
            contentValues.put(C13131bm.f37932i, randomUUID.toString());
            contentValues.put(C13131bm.f37933j, str);
            contentValues.put(C13131bm.f37934k, str3);
            CacheDBHelper.m14580a(context).m14577a(C13131bm.f37926c, contentValues);
            if ("i".equalsIgnoreCase(str2)) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
            } else if ("s".equalsIgnoreCase(str2)) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]分享业务 返回body。");
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("header", new JSONObject());
                    jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                    return jSONObject3;
                } catch (JSONException unused) {
                }
            } else if (!"p".equalsIgnoreCase(str2)) {
                try {
                    if (UMCommonContent.f37782aL.equalsIgnoreCase(str2)) {
                        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(EnvelopeManager.m13836a("header"), new JSONObject());
                        jSONObject4.put(EnvelopeManager.m13836a("analytics"), jSONObject2.getJSONObject("analytics"));
                        return jSONObject4;
                    }
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(EnvelopeManager.m13836a("header"), new JSONObject());
                    jSONObject5.put(EnvelopeManager.m13836a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject5;
                } catch (JSONException unused2) {
                    return jSONObject2;
                }
            }
            return new JSONObject();
        }
        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
        return null;
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject.has("st")) {
            str = UMCommonContent.f37782aL;
        } else {
            str = jSONObject2.has(UMCommonContent.f37820ax) ? "i" : "a";
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
        return new EnvelopeManager().m13839a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str);
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
        return new EnvelopeManager().m13831b(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str);
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
        boolean z;
        synchronized (UMEnvelopeBuild.class) {
            z = transmissionSendFlag;
        }
        return z;
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(StubApp.getOrigApplicationContext(context.getApplicationContext())).m13729c().m13721a(str, str2);
    }

    public static boolean isOnline(Context context) {
        return UMFrUtils.isOnline(context) && (UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        UMNetWorkSender.m13994a(context);
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
            boolean r7 = com.umeng.commonsdk.framework.UMNetWorkSender.m13998a()
            if (r7 == 0) goto L33
            int r5 = com.umeng.commonsdk.framework.UMNetWorkSender.m13991b()
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
            com.umeng.commonsdk.framework.UMNetWorkSender.m13986d()
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMEnvelopeBuild.isRet(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType, boolean):boolean");
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return EnvelopeManager.m13842a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static void registerNetReceiver(Context context) {
        UMNetWorkSender.m13989b(context);
    }

    public static void sendProcessNextMsgOnce() {
        UMNetWorkSender.m13986d();
    }

    public static synchronized void setTransmissionSendFlag(boolean z) {
        synchronized (UMEnvelopeBuild.class) {
            transmissionSendFlag = z;
        }
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
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
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
            return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        } else {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
            if (CacheDBHelper.m14580a(context).m14570c()) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
                return new EnvelopeManager().m13838a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str, str2, str3);
            }
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
            JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
            if (!UMWorkDispatch.eventHasExist(UMInternalConfig.f38808t)) {
                UMWorkDispatch.sendEvent(context, UMInternalConfig.f38808t, UMInternalData.m13974a(context).m13975a(), null);
            }
            return add2CacheTable;
        }
    }
}
