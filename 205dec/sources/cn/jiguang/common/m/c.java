package cn.jiguang.common.m;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f3488a;

    /* renamed from: b  reason: collision with root package name */
    public long f3489b;

    /* renamed from: c  reason: collision with root package name */
    public int f3490c;

    /* renamed from: e  reason: collision with root package name */
    public List<Long> f3492e = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f3491d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<String> f3493f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public List<Long> f3494g = new ArrayList();

    public static c a(String str) {
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.f3488a = jSONObject.optString("pkg");
            cVar.f3490c = jSONObject.optInt("launch_cnt");
            cVar.f3489b = jSONObject.optLong("active_duration");
            cVar.f3492e = c(jSONObject.optString("active_time"));
            cVar.f3491d = d(jSONObject.optString("source"));
            cVar.f3494g = c(jSONObject.optString("traffic_usage"));
            cVar.f3493f = b(jSONObject.optString("page_name"));
        } catch (Throwable unused) {
        }
        return cVar;
    }

    private static CharSequence a(CharSequence charSequence, int i4) {
        return (i4 < 0 || i4 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i4);
    }

    private static String a(Collection<?> collection, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Collections.addAll(arrayList, str.split("&"));
        return arrayList;
    }

    private static List<Long> c(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : str.split("&")) {
            arrayList.add(Long.valueOf(Long.parseLong(str2)));
        }
        return arrayList;
    }

    private static List<Integer> d(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : str.split("&")) {
            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
        }
        return arrayList;
    }

    public JSONObject a(int i4) {
        try {
            return new JSONObject().put("pkg", a(this.f3488a, i4)).put("active_time", a(this.f3492e, "&")).put("source", a(this.f3491d, "&")).put("active_duration", this.f3489b).put("launch_cnt", this.f3490c).put("page_name", a(this.f3493f, "&")).put("traffic_usage", a(this.f3494g, "&"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject b(int i4) {
        try {
            if (this.f3489b == 0 && this.f3492e.isEmpty() && this.f3493f.isEmpty()) {
                return null;
            }
            JSONObject put = new JSONObject().put("pkg", a(this.f3488a, i4));
            long j4 = this.f3489b;
            if (j4 > 0) {
                put.put("active_duration", j4);
            }
            if (this.f3492e.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Long l4 : this.f3492e) {
                    long longValue = l4.longValue();
                    if (longValue > 0) {
                        jSONArray.put(longValue);
                    }
                }
                put.put("active_time", jSONArray);
            }
            if (this.f3491d.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (Integer num : this.f3491d) {
                    if (num.intValue() > 0) {
                        jSONArray2.put(num);
                    }
                }
                put.put("source", jSONArray2);
            }
            if (this.f3493f.size() > 0) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str : this.f3493f) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray3.put(str);
                    }
                }
                put.put("page_name", jSONArray3);
            }
            put.put("launch_count", this.f3490c);
            return put;
        } catch (Throwable unused) {
            return null;
        }
    }
}
