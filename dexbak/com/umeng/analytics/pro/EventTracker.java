package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.CoreProtocolImpl;
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

/* renamed from: com.umeng.analytics.pro.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EventTracker {

    /* renamed from: a */
    private static final String f38444a = "fs_lc_tl_uapp";

    /* renamed from: f */
    private static final String f38445f = "-1";

    /* renamed from: g */
    private static Context f38446g;

    /* renamed from: b */
    private final int f38447b;

    /* renamed from: c */
    private final int f38448c;

    /* renamed from: d */
    private final int f38449d;

    /* renamed from: e */
    private final int f38450e;

    /* renamed from: h */
    private JSONObject f38451h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EventTracker.java */
    /* renamed from: com.umeng.analytics.pro.s$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13175a {

        /* renamed from: a */
        private static final EventTracker f38452a = new EventTracker();

        private C13175a() {
        }
    }

    /* renamed from: a */
    public static EventTracker m14204a(Context context) {
        if (f38446g == null && context != null) {
            f38446g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C13175a.f38452a;
    }

    /* renamed from: b */
    private void m14195b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(f38444a, null);
            if (!TextUtils.isEmpty(string)) {
                this.f38451h = new JSONObject(string);
            }
            m14205a();
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private void m14192c(Context context) {
        try {
            if (this.f38451h != null) {
                PreferenceWrapper.getDefault(f38446g).edit().putString(f38444a, this.f38451h.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private EventTracker() {
        this.f38447b = 128;
        this.f38448c = 256;
        this.f38449d = 1024;
        this.f38450e = 10;
        this.f38451h = null;
        try {
            m14195b(f38446g);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private boolean m14191c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public void m14202a(String str, String str2, long j, int i, String str3) {
        String m14155a;
        try {
            if (m14203a(str) && m14194b(str2)) {
                if (Arrays.asList(UContent.f38109aM).contains(str)) {
                    MLog.m13820e("key is " + str + ", please check key, illegal");
                    UMLog.m14015aq(UMLogAnalytics.f38325m, 0, "\\|");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", currentTimeMillis);
                if (j > 0) {
                    jSONObject.put(UContent.f38113ac, j);
                }
                jSONObject.put("__t", UMStoreManager.f38249a);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                if (UMUtils.isMainProgress(f38446g)) {
                    m14155a = SessionIdManager.m14159a().m14148d(UMGlobalContext.getAppContext(f38446g));
                } else {
                    m14155a = SessionIdManager.m14159a().m14155a(UMGlobalContext.getAppContext(f38446g), currentTimeMillis);
                }
                if (TextUtils.isEmpty(m14155a)) {
                    m14155a = "-1";
                }
                jSONObject.put("__i", m14155a);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(UContent.f38097aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f38446g).getProcessName(f38446g));
                m14205a();
                JSONObject jSONObject3 = this.f38451h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f38451h.get(str)).booleanValue()) {
                    jSONObject.put(UContent.f38115ae, 1);
                    this.f38451h.put(str, true);
                    m14192c(f38446g);
                }
                Context context = f38446g;
                UMWorkDispatch.sendEvent(context, 4097, CoreProtocol.getInstance(context), jSONObject);
                return;
            }
            UMLog.m14015aq(UMLogAnalytics.f38324l, 0, "\\|");
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    private boolean m14194b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception unused) {
        }
        MLog.m13820e("value is " + str + ", please check value, illegal");
        return false;
    }

    /* renamed from: b */
    private boolean m14193b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!m14203a(entry.getKey())) {
                            UMLog.m14015aq(UMLogAnalytics.f38320h, 0, "\\|");
                            return false;
                        } else if (entry.getValue() == null) {
                            UMLog.m14015aq(UMLogAnalytics.f38321i, 0, "\\|");
                            return false;
                        } else if (entry.getValue() instanceof String) {
                            if (UContent.f38107aK.equals(entry.getKey())) {
                                if (!m14191c(entry.getValue().toString())) {
                                    UMLog.m14015aq(UMLogAnalytics.f38284P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!m14191c(entry.getValue().toString())) {
                                    UMLog.m14015aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!m14194b(entry.getValue().toString())) {
                                UMLog.m14015aq(UMLogAnalytics.f38322j, 0, "\\|");
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
        UMLog.m14015aq(UMLogAnalytics.f38319g, 0, "\\|");
        return false;
    }

    /* renamed from: a */
    public void m14201a(String str, Map<String, Object> map, long j, String str2, boolean z) {
        String m14155a;
        try {
            if (!m14203a(str)) {
                UMLog.m14015aq(UMLogAnalytics.f38318f, 0, "\\|");
            } else if (m14193b(map)) {
                if (map.size() > 100) {
                    MLog.m13820e("map size is " + map.size() + ", please check");
                } else if (Arrays.asList(UContent.f38109aM).contains(str)) {
                    MLog.m13820e("key is " + str + ", please check key, illegal");
                    UMLog.m14015aq(UMLogAnalytics.f38314b, 0, "\\|");
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put("ts", System.currentTimeMillis());
                    if (j > 0) {
                        jSONObject.put(UContent.f38113ac, j);
                    }
                    jSONObject.put("__t", UMStoreManager.f38249a);
                    ULog.m13784i("befort ekv map, event is " + jSONObject.toString());
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!Arrays.asList(UContent.f38109aM).contains(entry.getKey())) {
                            Object value = entry.getValue();
                            if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float) && !(value instanceof Double)) {
                                if (value.getClass().isArray()) {
                                    if (value instanceof int[]) {
                                        int[] iArr = (int[]) value;
                                        if (iArr.length > 10) {
                                            MLog.m13820e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray = new JSONArray();
                                        for (int i : iArr) {
                                            jSONArray.put(i);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray);
                                    } else if (value instanceof double[]) {
                                        double[] dArr = (double[]) value;
                                        if (dArr.length > 10) {
                                            MLog.m13820e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray2 = new JSONArray();
                                        for (double d : dArr) {
                                            jSONArray2.put(d);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray2);
                                    } else if (value instanceof long[]) {
                                        long[] jArr = (long[]) value;
                                        if (jArr.length > 10) {
                                            MLog.m13820e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray3 = new JSONArray();
                                        for (long j2 : jArr) {
                                            jSONArray3.put(j2);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray3);
                                    } else if (value instanceof float[]) {
                                        float[] fArr = (float[]) value;
                                        if (fArr.length > 10) {
                                            MLog.m13820e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray4 = new JSONArray();
                                        for (float f : fArr) {
                                            jSONArray4.put(f);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray4);
                                    } else if (value instanceof short[]) {
                                        short[] sArr = (short[]) value;
                                        if (sArr.length > 10) {
                                            MLog.m13820e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray5 = new JSONArray();
                                        for (short s : sArr) {
                                            jSONArray5.put((int) s);
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray5);
                                    } else if (value instanceof String[]) {
                                        String[] strArr = (String[]) value;
                                        if (strArr.length > 10) {
                                            MLog.m13820e("please check key or value, size overlength!");
                                            return;
                                        }
                                        JSONArray jSONArray6 = new JSONArray();
                                        for (int i2 = 0; i2 < strArr.length; i2++) {
                                            if (strArr[i2] == null) {
                                                MLog.m13820e("please check array, null item!");
                                                return;
                                            } else if (!m14194b(strArr[i2])) {
                                                return;
                                            } else {
                                                jSONArray6.put(strArr[i2]);
                                            }
                                        }
                                        jSONObject.put(entry.getKey(), jSONArray6);
                                    } else {
                                        MLog.m13820e("please check key or value, illegal type!");
                                        return;
                                    }
                                } else {
                                    MLog.m13820e("please check key or value, illegal type!");
                                    return;
                                }
                            }
                            jSONObject.put(entry.getKey(), value);
                        } else {
                            UMLog.m14015aq(UMLogAnalytics.f38317e, 0, "\\|");
                            return;
                        }
                    }
                    if (UMUtils.isMainProgress(f38446g)) {
                        m14155a = SessionIdManager.m14159a().m14148d(UMGlobalContext.getAppContext(f38446g));
                    } else {
                        m14155a = SessionIdManager.m14159a().m14155a(UMGlobalContext.getAppContext(f38446g), jSONObject.getLong("ts"));
                    }
                    if (TextUtils.isEmpty(m14155a)) {
                        m14155a = "-1";
                    }
                    jSONObject.put("__i", m14155a);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str2);
                            if (jSONObject2.length() > 0) {
                                jSONObject.put(UContent.f38097aA, jSONObject2);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    jSONObject.put("ds", 0);
                    jSONObject.put("pn", UMGlobalContext.getInstance(f38446g).getProcessName(f38446g));
                    m14205a();
                    JSONObject jSONObject3 = this.f38451h;
                    if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f38451h.get(str)).booleanValue()) {
                        jSONObject.put(UContent.f38115ae, 1);
                        this.f38451h.put(str, true);
                        m14192c(f38446g);
                    }
                    ULog.m13784i("----->>>>>ekv event json is " + jSONObject.toString());
                    if (!z) {
                        Context context = f38446g;
                        UMWorkDispatch.sendEvent(context, 4097, CoreProtocol.getInstance(context), jSONObject);
                        return;
                    }
                    Context context2 = f38446g;
                    UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38412n, CoreProtocol.getInstance(context2), jSONObject);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m14200a(String str, Map<String, Object> map, String str2) {
        try {
            if (m14203a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(UContent.f38113ac, 0);
                jSONObject.put("__t", UMStoreManager.f38250b);
                ULog.m13784i("befort gkv map, event is " + jSONObject.toString());
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    Map.Entry<String, Object> next = it.next();
                    if (!UContent.f38115ae.equals(next.getKey()) && !UContent.f38113ac.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                String m14148d = SessionIdManager.m14159a().m14148d(UMGlobalContext.getAppContext(f38446g));
                if (TextUtils.isEmpty(m14148d)) {
                    m14148d = "-1";
                }
                jSONObject.put("__i", m14148d);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(UContent.f38097aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f38446g).getProcessName(f38446g));
                ULog.m13784i("----->>>>>gkv event json is " + jSONObject.toString());
                Context context = f38446g;
                UMWorkDispatch.sendEvent(context, 4098, CoreProtocol.getInstance(context), jSONObject);
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    private void m14205a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f38446g, "track_list", "");
            if (TextUtils.isEmpty(imprintProperty)) {
                return;
            }
            String[] split = imprintProperty.split("!");
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (this.f38451h != null) {
                for (String str : split) {
                    String subStr = HelperUtils.subStr(str, 128);
                    if (this.f38451h.has(subStr)) {
                        jSONObject.put(subStr, this.f38451h.get(subStr));
                    }
                }
            }
            this.f38451h = new JSONObject();
            if (split.length >= 10) {
                while (i < 10) {
                    m14199a(split[i], jSONObject);
                    i++;
                }
            } else {
                while (i < split.length) {
                    m14199a(split[i], jSONObject);
                    i++;
                }
            }
            m14192c(f38446g);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m14199a(String str, JSONObject jSONObject) throws JSONException {
        String subStr = HelperUtils.subStr(str, 128);
        if (jSONObject.has(subStr)) {
            m14198a(subStr, ((Boolean) jSONObject.get(subStr)).booleanValue());
        } else {
            m14198a(subStr, false);
        }
    }

    /* renamed from: a */
    private void m14198a(String str, boolean z) {
        try {
            if (UContent.f38115ae.equals(str) || UContent.f38113ac.equals(str) || "id".equals(str) || "ts".equals(str) || this.f38451h.has(str)) {
                return;
            }
            this.f38451h.put(str, z);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void m14197a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    m14205a();
                    JSONObject jSONObject = this.f38451h;
                    if (jSONObject == null) {
                        this.f38451h = new JSONObject();
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            JSONObject jSONObject2 = this.f38451h;
                            if (jSONObject2 == null) {
                                this.f38451h = new JSONObject();
                            } else if (jSONObject2.length() >= 5) {
                                break;
                            }
                            String str = list.get(i);
                            if (!TextUtils.isEmpty(str)) {
                                m14198a(HelperUtils.subStr(str, 128), false);
                            }
                        }
                        m14192c(f38446g);
                        return;
                    } else if (jSONObject.length() >= 5) {
                        MLog.m13826d("already setFistLaunchEvent, igone.");
                        return;
                    } else {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (this.f38451h.length() >= 5) {
                                MLog.m13826d(" add setFistLaunchEvent over.");
                                return;
                            }
                            m14198a(HelperUtils.subStr(list.get(i2), 128), false);
                        }
                        m14192c(f38446g);
                        return;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        UMLog.m14015aq(UMLogAnalytics.f38306ak, 0, "\\|");
    }

    /* renamed from: a */
    private JSONObject m14196a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String subStr = HelperUtils.subStr(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            int i = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    JSONArray jSONArray = new JSONArray();
                                    while (i < iArr.length) {
                                        jSONArray.put(iArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    JSONArray jSONArray2 = new JSONArray();
                                    while (i < dArr.length) {
                                        jSONArray2.put(dArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    JSONArray jSONArray3 = new JSONArray();
                                    while (i < jArr.length) {
                                        jSONArray3.put(jArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    JSONArray jSONArray4 = new JSONArray();
                                    while (i < fArr.length) {
                                        jSONArray4.put(fArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    JSONArray jSONArray5 = new JSONArray();
                                    while (i < sArr.length) {
                                        jSONArray5.put((int) sArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray5);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                JSONArray jSONArray6 = new JSONArray();
                                while (i < list.size()) {
                                    Object obj = list.get(i);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray6.put(list.get(i));
                                    }
                                    i++;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(subStr, jSONArray6);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(subStr, HelperUtils.subStr(value.toString(), 256));
                            } else {
                                if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && !(value instanceof Short)) {
                                    MLog.m13820e("The param has not support type. please check !");
                                }
                                jSONObject.put(subStr, value);
                            }
                        }
                    }
                } catch (Exception e) {
                    MLog.m13816e(e);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private boolean m14203a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        MLog.m13820e("key is " + str + ", please check key, illegal");
        return false;
    }
}
