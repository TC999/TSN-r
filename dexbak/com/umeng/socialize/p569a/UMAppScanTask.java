package com.umeng.socialize.p569a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.kwad.components.offline.api.p341tk.model.report.TKDownloadReason;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.ccg.CcgConstant;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.socialize.a.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class UMAppScanTask implements Runnable {

    /* renamed from: a */
    private static final int f39314a = 1;

    /* renamed from: b */
    private static final int f39315b = 2;

    /* renamed from: c */
    private static final String f39316c = "AZX";

    @Override // java.lang.Runnable
    public void run() {
        if (UMShareAPI.getSmartEnableFlag()) {
            SharedPrefs m13413a = SharedPrefs.m13413a(ContextUtil.getContext());
            m13413a.m13406e();
            int m13408c = m13413a.m13408c();
            long m13407d = m13413a.m13407d();
            if (m13407d < m13408c) {
                if (AzxConstant.f39292c) {
                    UPLog.m13366a(f39316c, "launch times skipped. times:", Long.valueOf(m13407d), " config:", Integer.valueOf(m13408c));
                }
            } else if (!m13413a.m13410b()) {
                if (AzxConstant.f39292c) {
                    UPLog.m13366a(f39316c, "interval skipped.");
                }
            } else {
                try {
                    final Context context = ContextUtil.getContext();
                    final String appkey = UMUtils.getAppkey(context);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(UMCommonContent.f37808al, UMUtils.getZid(context));
                    try {
                        jSONObject.put("imei", DeviceConfig.getImeiNew(context));
                        jSONObject.put("oaid", DeviceConfig.getOaid(context));
                    } catch (Throwable unused) {
                    }
                    try {
                        jSONObject.put("idfa", DeviceConfig.getIdfa(context));
                    } catch (Throwable unused2) {
                    }
                    jSONObject.put("umid", UMUtils.getUMId(context));
                    jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                    jSONObject.put("sdk_v", "7.3.2");
                    jSONObject.put("os_v", Build.VERSION.RELEASE);
                    jSONObject.put("lvl", Build.VERSION.SDK_INT);
                    String[] networkAccessMode = UMUtils.getNetworkAccessMode(context);
                    if (TextUtils.isEmpty(networkAccessMode[0])) {
                        networkAccessMode[0] = "Unknown";
                    }
                    jSONObject.put(TKDownloadReason.KSAD_TK_NET, networkAccessMode[0]);
                    jSONObject.put(C2624bk.f8686j, C13308c.m13426a());
                    long m13416a = m13413a.m13416a();
                    if (m13416a > 0) {
                        jSONObject.put("last", m13416a);
                    }
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject2 = C13309d.m13417a(jSONObject, AzxConstant.f39290a, appkey, AzxConstant.f39292c);
                    } catch (Exception e) {
                        if (AzxConstant.f39292c) {
                            UPLog.m13359d(f39316c, "request failed. ", e.getMessage());
                        }
                    }
                    if (jSONObject2 == null) {
                        if (AzxConstant.f39292c) {
                            UPLog.m13366a(f39316c, "response == null");
                        }
                        m13413a.m13414a(7200L);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                    if (optJSONObject == null) {
                        if (AzxConstant.f39292c) {
                            UPLog.m13366a(f39316c, "data empty skipped.");
                        }
                        m13413a.m13414a(7200L);
                        return;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                    }
                    int optInt = optJSONObject2.optInt("launch", 5);
                    m13413a.m13415a(optInt);
                    if (m13413a.m13407d() < optInt) {
                        if (AzxConstant.f39292c) {
                            UPLog.m13366a(f39316c, "launch times skipped. config:", Integer.valueOf(optInt));
                            return;
                        }
                        return;
                    }
                    m13413a.m13414a(optJSONObject.optLong(RtspHeaders.Values.TTL, 86400L));
                    final long optLong = optJSONObject.optLong("id", -1L);
                    if (optLong <= 0) {
                        if (AzxConstant.f39292c) {
                            UPLog.m13366a(f39316c, "id skipped, id:", Long.valueOf(optLong));
                            return;
                        }
                        return;
                    }
                    final int max = Math.max(optJSONObject2.optInt(CcgConstant.f38548s, 300), 100);
                    final int optInt2 = optJSONObject2.optInt(CcgConstant.f38549t, 1);
                    int optInt3 = optJSONObject2.optInt("delay");
                    if (optInt2 != 1 && optInt2 != 2) {
                        if (AzxConstant.f39292c) {
                            UPLog.m13366a(f39316c, "action skipped. ", Integer.valueOf(optInt2));
                            return;
                        }
                        return;
                    }
                    C13312j.m13384a(new Runnable() { // from class: com.umeng.socialize.a.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TreeSet treeSet;
                            ByteArrayOutputStream byteArrayOutputStream;
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            try {
                                treeSet = new TreeSet();
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                byte[] bArr = {BinaryMemcacheOpcodes.ADDQ, -119, 31, BinaryMemcacheOpcodes.DECREMENTQ, 8, 45, 8, BinaryMemcacheOpcodes.PREPENDQ, 5, 10, 98, 78, -51, 47, -125, 34, BinaryMemcacheOpcodes.SETQ, 108, -112, -104, 95, 34, 120, HttpConstants.EQUALS, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, BinaryMemcacheOpcodes.GAT, BinaryMemcacheOpcodes.FLUSHQ, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, BinaryMemcacheOpcodes.GATKQ, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, 31, HttpConstants.COMMA, -83, 99, -108, -92, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, BinaryMemcacheOpcodes.TOUCH, -74, 88, BinaryMemcacheOpcodes.GATK, -118, -22, -74, -29, -103, -86, -25, BinaryMemcacheOpcodes.REPLACEQ, -78, 62, BinaryMemcacheOpcodes.TOUCH, -100, -68, 1, BinaryMemcacheOpcodes.GATK, -68, HttpConstants.COLON, -100, BinaryMemcacheOpcodes.GAT, 5, -10, -95, BinaryMemcacheOpcodes.DELETEQ, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, BinaryMemcacheOpcodes.INCREMENTQ, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, 12, 40, 14, BinaryMemcacheOpcodes.GAT};
                                byte[] copyOfRange = Arrays.copyOfRange(bArr, 179, 187);
                                byte[] copyOf = Arrays.copyOf(bArr, 179);
                                UMCryptXor.m13388a(copyOf, copyOfRange);
                                UMZipUtils.m13370b(copyOf, byteArrayOutputStream);
                                JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream.toString());
                                if (AzxConstant.f39292c) {
                                    UPLog.m13366a(UMAppScanTask.f39316c, jSONObject3.toString());
                                }
                                Object m13375a = UMReflectUtils.m13375a(jSONObject3.optString("c"), jSONObject3.optString("p"), null, context, null);
                                if (1 == optInt2) {
                                    Object m13375a2 = UMReflectUtils.m13375a(jSONObject3.optString("m"), jSONObject3.optString(CampaignEx.JSON_KEY_AD_Q), new Class[]{UMReflectUtils.m13379a(jSONObject3.optString("i")), Integer.TYPE}, m13375a, new Object[]{UMReflectUtils.m13374a(jSONObject3.optString("i"), new Class[]{String.class}, new Object[]{jSONObject3.optString("a")}), 0});
                                    if (m13375a2 instanceof List) {
                                        Field m13378a = UMReflectUtils.m13378a(jSONObject3.optString("r"), jSONObject3.optString("s"));
                                        Field m13378a2 = UMReflectUtils.m13378a(jSONObject3.optString(UMCommonContent.f37782aL), jSONObject3.optString("n"));
                                        for (Object obj : (List) m13375a2) {
                                            Object m13373a = UMReflectUtils.m13373a(m13378a2, UMReflectUtils.m13373a(m13378a, obj));
                                            if (m13373a != null) {
                                                treeSet.add((String) m13373a);
                                            }
                                        }
                                        if (AzxConstant.f39292c) {
                                            UPLog.m13366a(UMAppScanTask.f39316c, "size:" + treeSet.size());
                                        }
                                    }
                                } else {
                                    Object m13375a3 = UMReflectUtils.m13375a(jSONObject3.optString("m"), jSONObject3.optString("u"), new Class[]{Integer.TYPE}, m13375a, new Object[]{0});
                                    if (m13375a3 instanceof List) {
                                        Field m13378a3 = UMReflectUtils.m13378a(jSONObject3.optString("v"), jSONObject3.optString("n"));
                                        for (Object obj2 : (List) m13375a3) {
                                            Object m13373a2 = UMReflectUtils.m13373a(m13378a3, obj2);
                                            if (m13373a2 != null) {
                                                treeSet.add((String) m13373a2);
                                            }
                                        }
                                        if (AzxConstant.f39292c) {
                                            UPLog.m13366a(UMAppScanTask.f39316c, "size:" + treeSet.size());
                                        }
                                    }
                                }
                                if (treeSet.isEmpty()) {
                                    if (AzxConstant.f39292c) {
                                        UPLog.m13366a(UMAppScanTask.f39316c, "app list empty!");
                                    }
                                    C13308c.m13424a(byteArrayOutputStream);
                                } else if (m13375a == null) {
                                    C13308c.m13424a(byteArrayOutputStream);
                                } else {
                                    ArrayList arrayList = new ArrayList();
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it = treeSet.iterator();
                                    int i = 0;
                                    while (it.hasNext()) {
                                        Object m13423a = C13308c.m13423a(m13375a, (String) it.next(), 0);
                                        if (m13423a != null) {
                                            UMAppInfo uMAppInfo = new UMAppInfo(m13375a, m13423a);
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("a", uMAppInfo.f39309b);
                                            jSONObject4.put("p", uMAppInfo.f39308a);
                                            jSONObject4.put("v", uMAppInfo.f39310c);
                                            jSONObject4.put(UMCommonContent.f37782aL, uMAppInfo.f39313f);
                                            jSONObject4.put("i", uMAppInfo.f39311d);
                                            jSONObject4.put("u", uMAppInfo.f39312e);
                                            jSONArray.put(jSONObject4);
                                            i++;
                                            if (jSONArray.length() == max) {
                                                arrayList.add(jSONArray);
                                                jSONArray = new JSONArray();
                                            }
                                        }
                                    }
                                    if (jSONArray.length() > 0) {
                                        arrayList.add(jSONArray);
                                    }
                                    if (AzxConstant.f39292c) {
                                        UPLog.m13366a(UMAppScanTask.f39316c, "total:", Integer.valueOf(i));
                                        Iterator it2 = arrayList.iterator();
                                        while (it2.hasNext()) {
                                            JSONArray jSONArray2 = (JSONArray) it2.next();
                                            UPLog.m13360c(UMAppScanTask.f39316c, "--- start ---");
                                            UPLog.m13361b(UMAppScanTask.f39316c, "--- size:", Integer.valueOf(jSONArray2.length()));
                                            UPLog.m13361b(UMAppScanTask.f39316c, jSONArray2);
                                            UPLog.m13360c(UMAppScanTask.f39316c, "--- end ---");
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        C13308c.m13424a(byteArrayOutputStream);
                                        return;
                                    }
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put(UMCommonContent.f37808al, UMUtils.getZid(context));
                                    jSONObject5.put("appkey", appkey);
                                    jSONObject5.put("umid", UMUtils.getUMId(context));
                                    jSONObject5.put("v", MBridgeConstans.NATIVE_VIDEO_VERSION);
                                    jSONObject5.put("sdk_v", "7.3.2");
                                    jSONObject5.put("os_v", Build.VERSION.RELEASE);
                                    jSONObject5.put(C2624bk.f8686j, C13308c.m13426a());
                                    jSONObject5.put(C2624bk.f8685i, C13308c.m13422b());
                                    jSONObject5.put("smart_id", optLong);
                                    jSONObject5.put("src", "share");
                                    jSONObject5.put("imei", DeviceConfig.getImeiNew(context));
                                    try {
                                        jSONObject5.put("oaid", DeviceConfig.getOaid(context));
                                    } catch (Throwable unused3) {
                                    }
                                    try {
                                        jSONObject5.put("idfa", DeviceConfig.getIdfa(context));
                                    } catch (Throwable unused4) {
                                    }
                                    jSONObject5.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                                    jSONObject5.put("pkg", context.getPackageName());
                                    jSONObject5.put("app_v", UMUtils.getAppVersionName(context));
                                    jSONObject5.put("board", C13308c.m13420c());
                                    try {
                                        Locale locale = UMUtils.getLocale(context);
                                        if (locale != null) {
                                            jSONObject5.put("os_lang", locale.getLanguage());
                                        }
                                    } catch (Throwable unused5) {
                                    }
                                    jSONObject5.put("c_ts", System.currentTimeMillis());
                                    jSONObject5.put("total", i);
                                    try {
                                        jSONObject5.put("os_i", Build.VERSION.SDK_INT);
                                        jSONObject5.put("os_t", context.getApplicationInfo().targetSdkVersion);
                                        jSONObject5.put("grant", C13308c.m13421b(context) ? 1 : 0);
                                    } catch (Throwable unused6) {
                                    }
                                    Iterator it3 = arrayList.iterator();
                                    int i2 = 0;
                                    while (it3.hasNext()) {
                                        i2++;
                                        jSONObject5.put(CcgConstant.f38548s, i2);
                                        jSONObject5.put("data", (JSONArray) it3.next());
                                        try {
                                            C13309d.m13418a(jSONObject5, AzxConstant.f39291b, appkey);
                                        } catch (Exception e2) {
                                            if (AzxConstant.f39292c) {
                                                UPLog.m13359d(UMAppScanTask.f39316c, "upload error:", e2.getMessage());
                                            }
                                            throw e2;
                                        }
                                    }
                                    C13308c.m13424a(byteArrayOutputStream);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    UPLog.m13359d(UMAppScanTask.f39316c, th.getMessage());
                                } finally {
                                    C13308c.m13424a(byteArrayOutputStream2);
                                }
                            }
                        }
                    }, optInt3, TimeUnit.SECONDS);
                } catch (Throwable th) {
                    if (AzxConstant.f39292c) {
                        UPLog.m13359d(f39316c, th.getMessage());
                    }
                }
            }
        }
    }
}
