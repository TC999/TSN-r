package com.umeng.socialize.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.utils.ContextUtil;
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
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMAppScanTask.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final int f53903a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f53904b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final String f53905c = "AZX";

    @Override // java.lang.Runnable
    public void run() {
        if (UMShareAPI.getSmartEnableFlag()) {
            e a4 = e.a(ContextUtil.getContext());
            a4.e();
            int c4 = a4.c();
            long d4 = a4.d();
            if (d4 < c4) {
                if (a.f53878c) {
                    m.a("AZX", "launch times skipped. times:", Long.valueOf(d4), " config:", Integer.valueOf(c4));
                }
            } else if (!a4.b()) {
                if (a.f53878c) {
                    m.a("AZX", "interval skipped.");
                }
            } else {
                try {
                    final Context context = ContextUtil.getContext();
                    final String appkey = UMUtils.getAppkey(context);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("zid", UMUtils.getZid(context));
                    try {
                        jSONObject.put("imei", DeviceConfig.getImeiNew(context));
                        jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, DeviceConfig.getOaid(context));
                    } catch (Throwable unused) {
                    }
                    try {
                        jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_IDFA_KEY, DeviceConfig.getIdfa(context));
                    } catch (Throwable unused2) {
                    }
                    jSONObject.put("umid", UMUtils.getUMId(context));
                    jSONObject.put("android_id", DeviceConfig.getAndroidId(context));
                    jSONObject.put("sdk_v", "7.3.2");
                    jSONObject.put("os_v", Build.VERSION.RELEASE);
                    jSONObject.put("lvl", Build.VERSION.SDK_INT);
                    String[] networkAccessMode = UMUtils.getNetworkAccessMode(context);
                    if (TextUtils.isEmpty(networkAccessMode[0])) {
                        networkAccessMode[0] = "Unknown";
                    }
                    jSONObject.put("net", networkAccessMode[0]);
                    jSONObject.put("brand", c.a());
                    long a5 = a4.a();
                    if (a5 > 0) {
                        jSONObject.put("last", a5);
                    }
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject2 = d.a(jSONObject, "https://ccs.umeng.com/sa", appkey, a.f53878c);
                    } catch (Exception e4) {
                        if (a.f53878c) {
                            m.d("AZX", "request failed. ", e4.getMessage());
                        }
                    }
                    if (jSONObject2 == null) {
                        if (a.f53878c) {
                            m.a("AZX", "response == null");
                        }
                        a4.a(7200L);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                    if (optJSONObject == null) {
                        if (a.f53878c) {
                            m.a("AZX", "data empty skipped.");
                        }
                        a4.a(7200L);
                        return;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                    }
                    int optInt = optJSONObject2.optInt("launch", 5);
                    a4.a(optInt);
                    if (a4.d() < optInt) {
                        if (a.f53878c) {
                            m.a("AZX", "launch times skipped. config:", Integer.valueOf(optInt));
                            return;
                        }
                        return;
                    }
                    a4.a(optJSONObject.optLong("ttl", 86400L));
                    final long optLong = optJSONObject.optLong("id", -1L);
                    if (optLong <= 0) {
                        if (a.f53878c) {
                            m.a("AZX", "id skipped, id:", Long.valueOf(optLong));
                            return;
                        }
                        return;
                    }
                    final int max = Math.max(optJSONObject2.optInt("batch", 300), 100);
                    final int optInt2 = optJSONObject2.optInt("action", 1);
                    int optInt3 = optJSONObject2.optInt("delay");
                    if (optInt2 != 1 && optInt2 != 2) {
                        if (a.f53878c) {
                            m.a("AZX", "action skipped. ", Integer.valueOf(optInt2));
                            return;
                        }
                        return;
                    }
                    j.a(new Runnable() { // from class: com.umeng.socialize.a.g.1
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
                                byte[] bArr = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, 21, 21, 12, 40, 14, 29};
                                byte[] copyOfRange = Arrays.copyOfRange(bArr, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 187);
                                byte[] copyOf = Arrays.copyOf(bArr, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT);
                                i.a(copyOf, copyOfRange);
                                l.b(copyOf, byteArrayOutputStream);
                                JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream.toString());
                                if (a.f53878c) {
                                    m.a("AZX", jSONObject3.toString());
                                }
                                Object a6 = k.a(jSONObject3.optString("c"), jSONObject3.optString("p"), null, context, null);
                                if (1 == optInt2) {
                                    Object a7 = k.a(jSONObject3.optString("m"), jSONObject3.optString(CampaignEx.JSON_KEY_AD_Q), new Class[]{k.a(jSONObject3.optString("i")), Integer.TYPE}, a6, new Object[]{k.a(jSONObject3.optString("i"), new Class[]{String.class}, new Object[]{jSONObject3.optString("a")}), 0});
                                    if (a7 instanceof List) {
                                        Field a8 = k.a(jSONObject3.optString("r"), jSONObject3.optString("s"));
                                        Field a9 = k.a(jSONObject3.optString("t"), jSONObject3.optString("n"));
                                        for (Object obj : (List) a7) {
                                            Object a10 = k.a(a9, k.a(a8, obj));
                                            if (a10 != null) {
                                                treeSet.add((String) a10);
                                            }
                                        }
                                        if (a.f53878c) {
                                            m.a("AZX", "size:" + treeSet.size());
                                        }
                                    }
                                } else {
                                    Object a11 = k.a(jSONObject3.optString("m"), jSONObject3.optString("u"), new Class[]{Integer.TYPE}, a6, new Object[]{0});
                                    if (a11 instanceof List) {
                                        Field a12 = k.a(jSONObject3.optString("v"), jSONObject3.optString("n"));
                                        for (Object obj2 : (List) a11) {
                                            Object a13 = k.a(a12, obj2);
                                            if (a13 != null) {
                                                treeSet.add((String) a13);
                                            }
                                        }
                                        if (a.f53878c) {
                                            m.a("AZX", "size:" + treeSet.size());
                                        }
                                    }
                                }
                                if (treeSet.isEmpty()) {
                                    if (a.f53878c) {
                                        m.a("AZX", "app list empty!");
                                    }
                                    c.a(byteArrayOutputStream);
                                } else if (a6 == null) {
                                    c.a(byteArrayOutputStream);
                                } else {
                                    ArrayList arrayList = new ArrayList();
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it = treeSet.iterator();
                                    int i4 = 0;
                                    while (it.hasNext()) {
                                        Object a14 = c.a(a6, (String) it.next(), 0);
                                        if (a14 != null) {
                                            f fVar = new f(a6, a14);
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("a", fVar.f53898b);
                                            jSONObject4.put("p", fVar.f53897a);
                                            jSONObject4.put("v", fVar.f53899c);
                                            jSONObject4.put("t", fVar.f53902f);
                                            jSONObject4.put("i", fVar.f53900d);
                                            jSONObject4.put("u", fVar.f53901e);
                                            jSONArray.put(jSONObject4);
                                            i4++;
                                            if (jSONArray.length() == max) {
                                                arrayList.add(jSONArray);
                                                jSONArray = new JSONArray();
                                            }
                                        }
                                    }
                                    if (jSONArray.length() > 0) {
                                        arrayList.add(jSONArray);
                                    }
                                    if (a.f53878c) {
                                        m.a("AZX", "total:", Integer.valueOf(i4));
                                        Iterator it2 = arrayList.iterator();
                                        while (it2.hasNext()) {
                                            JSONArray jSONArray2 = (JSONArray) it2.next();
                                            m.c("AZX", "--- start ---");
                                            m.b("AZX", "--- size:", Integer.valueOf(jSONArray2.length()));
                                            m.b("AZX", jSONArray2);
                                            m.c("AZX", "--- end ---");
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        c.a(byteArrayOutputStream);
                                        return;
                                    }
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put("zid", UMUtils.getZid(context));
                                    jSONObject5.put("appkey", appkey);
                                    jSONObject5.put("umid", UMUtils.getUMId(context));
                                    jSONObject5.put("v", MBridgeConstans.NATIVE_VIDEO_VERSION);
                                    jSONObject5.put("sdk_v", "7.3.2");
                                    jSONObject5.put("os_v", Build.VERSION.RELEASE);
                                    jSONObject5.put("brand", c.a());
                                    jSONObject5.put("model", c.b());
                                    jSONObject5.put("smart_id", optLong);
                                    jSONObject5.put("src", "share");
                                    jSONObject5.put("imei", DeviceConfig.getImeiNew(context));
                                    try {
                                        jSONObject5.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, DeviceConfig.getOaid(context));
                                    } catch (Throwable unused3) {
                                    }
                                    try {
                                        jSONObject5.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_IDFA_KEY, DeviceConfig.getIdfa(context));
                                    } catch (Throwable unused4) {
                                    }
                                    jSONObject5.put("android_id", DeviceConfig.getAndroidId(context));
                                    jSONObject5.put("pkg", context.getPackageName());
                                    jSONObject5.put("app_v", UMUtils.getAppVersionName(context));
                                    jSONObject5.put("board", c.c());
                                    try {
                                        Locale locale = UMUtils.getLocale(context);
                                        if (locale != null) {
                                            jSONObject5.put("os_lang", locale.getLanguage());
                                        }
                                    } catch (Throwable unused5) {
                                    }
                                    jSONObject5.put("c_ts", System.currentTimeMillis());
                                    jSONObject5.put("total", i4);
                                    try {
                                        jSONObject5.put("os_i", Build.VERSION.SDK_INT);
                                        jSONObject5.put("os_t", context.getApplicationInfo().targetSdkVersion);
                                        jSONObject5.put("grant", c.b(context) ? 1 : 0);
                                    } catch (Throwable unused6) {
                                    }
                                    Iterator it3 = arrayList.iterator();
                                    int i5 = 0;
                                    while (it3.hasNext()) {
                                        i5++;
                                        jSONObject5.put("batch", i5);
                                        jSONObject5.put("data", (JSONArray) it3.next());
                                        try {
                                            d.a(jSONObject5, "https://sss.umeng.com/api/v2/al", appkey);
                                        } catch (Exception e5) {
                                            if (a.f53878c) {
                                                m.d("AZX", "upload error:", e5.getMessage());
                                            }
                                            throw e5;
                                        }
                                    }
                                    c.a(byteArrayOutputStream);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    m.d("AZX", th.getMessage());
                                } finally {
                                    c.a(byteArrayOutputStream2);
                                }
                            }
                        }
                    }, optInt3, TimeUnit.SECONDS);
                } catch (Throwable th) {
                    if (a.f53878c) {
                        m.d("AZX", th.getMessage());
                    }
                }
            }
        }
    }
}
