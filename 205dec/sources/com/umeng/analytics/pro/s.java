package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: EventTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53115a = "fs_lc_tl_uapp";

    /* renamed from: f  reason: collision with root package name */
    private static final String f53116f = "-1";

    /* renamed from: g  reason: collision with root package name */
    private static Context f53117g;

    /* renamed from: b  reason: collision with root package name */
    private final int f53118b;

    /* renamed from: c  reason: collision with root package name */
    private final int f53119c;

    /* renamed from: d  reason: collision with root package name */
    private final int f53120d;

    /* renamed from: e  reason: collision with root package name */
    private final int f53121e;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f53122h;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: EventTracker.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final s f53123a = new s();

        private a() {
        }
    }

    public static s a(Context context) {
        if (f53117g == null && context != null) {
            f53117g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f53123a;
    }

    private void b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString("fs_lc_tl_uapp", null);
            if (!TextUtils.isEmpty(string)) {
                this.f53122h = new JSONObject(string);
            }
            a();
        } catch (Exception unused) {
        }
    }

    private void c(Context context) {
        try {
            if (this.f53122h != null) {
                PreferenceWrapper.getDefault(f53117g).edit().putString("fs_lc_tl_uapp", this.f53122h.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private s() {
        this.f53118b = 128;
        this.f53119c = 256;
        this.f53120d = 1024;
        this.f53121e = 10;
        this.f53122h = null;
        try {
            b(f53117g);
        } catch (Throwable unused) {
        }
    }

    private boolean c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(String str, String str2, long j4, int i4, String str3) {
        String a4;
        try {
            if (a(str) && b(str2)) {
                if (Arrays.asList(d.aM).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(j.f53003m, 0, "\\|");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", currentTimeMillis);
                if (j4 > 0) {
                    jSONObject.put("du", j4);
                }
                jSONObject.put("__t", 2049);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                if (UMUtils.isMainProgress(f53117g)) {
                    a4 = y.a().d(UMGlobalContext.getAppContext(f53117g));
                } else {
                    a4 = y.a().a(UMGlobalContext.getAppContext(f53117g), currentTimeMillis);
                }
                if (TextUtils.isEmpty(a4)) {
                    a4 = "-1";
                }
                jSONObject.put("__i", a4);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put("_$sp", jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f53117g).getProcessName(f53117g));
                a();
                JSONObject jSONObject3 = this.f53122h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f53122h.get(str)).booleanValue()) {
                    jSONObject.put("$st_fl", 1);
                    this.f53122h.put(str, true);
                    c(f53117g);
                }
                Context context = f53117g;
                UMWorkDispatch.sendEvent(context, 4097, CoreProtocol.getInstance(context), jSONObject);
                return;
            }
            UMLog.aq(j.f53002l, 0, "\\|");
        } catch (Throwable unused2) {
        }
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception unused) {
        }
        MLog.e("value is " + str + ", please check value, illegal");
        return false;
    }

    private boolean b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!a(entry.getKey())) {
                            UMLog.aq(j.f52998h, 0, "\\|");
                            return false;
                        } else if (entry.getValue() == null) {
                            UMLog.aq(j.f52999i, 0, "\\|");
                            return false;
                        } else if (entry.getValue() instanceof String) {
                            if ("_$!link".equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq("MobclickAgent.onDeepLinkReceived\u65b9\u6cd5link\u53c2\u6570\u957f\u5ea6\u8d85\u8fc7\u9650\u5236\u3002|\u53c2\u6570link\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc71024\u5b57\u7b26\u3002", 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq("url\u53c2\u6570\u957f\u5ea6\u8d85\u8fc7\u9650\u5236\u3002|\u53c2\u6570url\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc71024\u5b57\u7b26\u3002", 0, "\\|");
                                    return false;
                                }
                            } else if (!b(entry.getValue().toString())) {
                                UMLog.aq(j.f53000j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        UMLog.aq(j.f52997g, 0, "\\|");
        return false;
    }

    public void a(String str, Map<String, Object> map, long j4, String str2, boolean z3) {
        String a4;
        try {
            if (!a(str)) {
                UMLog.aq(j.f52996f, 0, "\\|");
            } else if (b(map)) {
                if (map.size() > 100) {
                    MLog.e("map size is " + map.size() + ", please check");
                } else if (Arrays.asList(d.aM).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(j.f52992b, 0, "\\|");
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put("ts", System.currentTimeMillis());
                    if (j4 > 0) {
                        jSONObject.put("du", j4);
                    }
                    jSONObject.put("__t", 2049);
                    ULog.i("befort ekv map, event is " + jSONObject.toString());
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!Arrays.asList(d.aM).contains(entry.getKey())) {
                            Object value = entry.getValue();
                            if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float) && !(value instanceof Double)) {
                                if (value.getClass().isArray()) {
                                    if (value instanceof int[]) {
                                        int[] iArr = (int[]) value;
                                        if (iArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray = new JSONArray();
                                        for (int i4 : iArr) {
                                            jSONArray.put(i4);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray);
                                    } else if (value instanceof double[]) {
                                        double[] dArr = (double[]) value;
                                        if (dArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray2 = new JSONArray();
                                        for (double d4 : dArr) {
                                            jSONArray2.put(d4);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray2);
                                    } else if (value instanceof long[]) {
                                        long[] jArr = (long[]) value;
                                        if (jArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray3 = new JSONArray();
                                        for (long j5 : jArr) {
                                            jSONArray3.put(j5);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray3);
                                    } else if (value instanceof float[]) {
                                        float[] fArr = (float[]) value;
                                        if (fArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray4 = new JSONArray();
                                        for (float f4 : fArr) {
                                            jSONArray4.put(f4);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray4);
                                    } else if (value instanceof short[]) {
                                        short[] sArr = (short[]) value;
                                        if (sArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray5 = new JSONArray();
                                        for (short s3 : sArr) {
                                            jSONArray5.put((int) s3);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray5);
                                    } else if (value instanceof String[]) {
                                        String[] strArr = (String[]) value;
                                        if (strArr.length > 10) {
                                            MLog.e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray6 = new JSONArray();
                                        for (int i5 = 0; i5 < strArr.length; i5++) {
                                            if (strArr[i5] == null) {
                                                MLog.e("please check array, null item!");
                                                return;
                                            } else if (!b(strArr[i5])) {
                                                return;
                                            } else {
                                                jSONArray6.put(strArr[i5]);
                                            }
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray6);
                                    } else {
                                        MLog.e("please check key or value, illegal type!");
                                        return;
                                    }
                                } else {
                                    MLog.e("please check key or value, illegal type!");
                                    return;
                                }
                            }
                            jSONObject.put(entry.getKey(), value);
                        } else {
                            UMLog.aq(j.f52995e, 0, "\\|");
                            return;
                        }
                    }
                    if (UMUtils.isMainProgress(f53117g)) {
                        a4 = y.a().d(UMGlobalContext.getAppContext(f53117g));
                    } else {
                        a4 = y.a().a(UMGlobalContext.getAppContext(f53117g), jSONObject.getLong("ts"));
                    }
                    if (TextUtils.isEmpty(a4)) {
                        a4 = "-1";
                    }
                    jSONObject.put("__i", a4);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str2);
                            if (jSONObject2.length() > 0) {
                                jSONObject.put("_$sp", jSONObject2);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    jSONObject.put("ds", 0);
                    jSONObject.put("pn", UMGlobalContext.getInstance(f53117g).getProcessName(f53117g));
                    a();
                    JSONObject jSONObject3 = this.f53122h;
                    if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f53122h.get(str)).booleanValue()) {
                        jSONObject.put("$st_fl", 1);
                        this.f53122h.put(str, true);
                        c(f53117g);
                    }
                    ULog.i("----->>>>>ekv event json is " + jSONObject.toString());
                    if (!z3) {
                        Context context = f53117g;
                        UMWorkDispatch.sendEvent(context, 4097, CoreProtocol.getInstance(context), jSONObject);
                        return;
                    }
                    Context context2 = f53117g;
                    UMWorkDispatch.sendEvent(context2, 4355, CoreProtocol.getInstance(context2), jSONObject);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, Map<String, Object> map, String str2) {
        try {
            if (a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("du", 0);
                jSONObject.put("__t", 2050);
                ULog.i("befort gkv map, event is " + jSONObject.toString());
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i4 = 0; i4 < 10 && it.hasNext(); i4++) {
                    Map.Entry<String, Object> next = it.next();
                    if (!"$st_fl".equals(next.getKey()) && !"du".equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                String d4 = y.a().d(UMGlobalContext.getAppContext(f53117g));
                if (TextUtils.isEmpty(d4)) {
                    d4 = "-1";
                }
                jSONObject.put("__i", d4);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put("_$sp", jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f53117g).getProcessName(f53117g));
                ULog.i("----->>>>>gkv event json is " + jSONObject.toString());
                Context context = f53117g;
                UMWorkDispatch.sendEvent(context, 4098, CoreProtocol.getInstance(context), jSONObject);
            }
        } catch (Throwable unused2) {
        }
    }

    private void a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f53117g, "track_list", "");
            if (TextUtils.isEmpty(imprintProperty)) {
                return;
            }
            String[] split = imprintProperty.split("!");
            JSONObject jSONObject = new JSONObject();
            int i4 = 0;
            if (this.f53122h != null) {
                for (String str : split) {
                    String subStr = HelperUtils.subStr(str, 128);
                    if (this.f53122h.has(subStr)) {
                        jSONObject.put(subStr, this.f53122h.get(subStr));
                    }
                }
            }
            this.f53122h = new JSONObject();
            if (split.length >= 10) {
                while (i4 < 10) {
                    a(split[i4], jSONObject);
                    i4++;
                }
            } else {
                while (i4 < split.length) {
                    a(split[i4], jSONObject);
                    i4++;
                }
            }
            c(f53117g);
        } catch (Exception unused) {
        }
    }

    private void a(String str, JSONObject jSONObject) throws JSONException {
        String subStr = HelperUtils.subStr(str, 128);
        if (jSONObject.has(subStr)) {
            a(subStr, ((Boolean) jSONObject.get(subStr)).booleanValue());
        } else {
            a(subStr, false);
        }
    }

    private void a(String str, boolean z3) {
        try {
            if ("$st_fl".equals(str) || "du".equals(str) || "id".equals(str) || "ts".equals(str) || this.f53122h.has(str)) {
                return;
            }
            this.f53122h.put(str, z3);
        } catch (Exception unused) {
        }
    }

    public void a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a();
                    JSONObject jSONObject = this.f53122h;
                    if (jSONObject == null) {
                        this.f53122h = new JSONObject();
                        int size = list.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            JSONObject jSONObject2 = this.f53122h;
                            if (jSONObject2 == null) {
                                this.f53122h = new JSONObject();
                            } else if (jSONObject2.length() >= 5) {
                                break;
                            }
                            String str = list.get(i4);
                            if (!TextUtils.isEmpty(str)) {
                                a(HelperUtils.subStr(str, 128), false);
                            }
                        }
                        c(f53117g);
                        return;
                    } else if (jSONObject.length() >= 5) {
                        MLog.d("already setFistLaunchEvent, igone.");
                        return;
                    } else {
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            if (this.f53122h.length() >= 5) {
                                MLog.d(" add setFistLaunchEvent over.");
                                return;
                            }
                            a(HelperUtils.subStr(list.get(i5), 128), false);
                        }
                        c(f53117g);
                        return;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        UMLog.aq(j.ak, 0, "\\|");
    }

    private JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String subStr = HelperUtils.subStr(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            int i4 = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    JSONArray jSONArray = new JSONArray();
                                    while (i4 < iArr.length) {
                                        jSONArray.put(iArr[i4]);
                                        i4++;
                                    }
                                    jSONObject.put(subStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    JSONArray jSONArray2 = new JSONArray();
                                    while (i4 < dArr.length) {
                                        jSONArray2.put(dArr[i4]);
                                        i4++;
                                    }
                                    jSONObject.put(subStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    JSONArray jSONArray3 = new JSONArray();
                                    while (i4 < jArr.length) {
                                        jSONArray3.put(jArr[i4]);
                                        i4++;
                                    }
                                    jSONObject.put(subStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    JSONArray jSONArray4 = new JSONArray();
                                    while (i4 < fArr.length) {
                                        jSONArray4.put(fArr[i4]);
                                        i4++;
                                    }
                                    jSONObject.put(subStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    JSONArray jSONArray5 = new JSONArray();
                                    while (i4 < sArr.length) {
                                        jSONArray5.put((int) sArr[i4]);
                                        i4++;
                                    }
                                    jSONObject.put(subStr, jSONArray5);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                JSONArray jSONArray6 = new JSONArray();
                                while (i4 < list.size()) {
                                    Object obj = list.get(i4);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray6.put(list.get(i4));
                                    }
                                    i4++;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(subStr, jSONArray6);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(subStr, HelperUtils.subStr(value.toString(), 256));
                            } else {
                                if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && !(value instanceof Short)) {
                                    MLog.e("The param has not support type. please check !");
                                }
                                jSONObject.put(subStr, value);
                            }
                        }
                    }
                } catch (Exception e4) {
                    MLog.e(e4);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private boolean a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        MLog.e("key is " + str + ", please check key, illegal");
        return false;
    }
}
