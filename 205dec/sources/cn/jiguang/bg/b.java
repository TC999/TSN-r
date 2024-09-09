package cn.jiguang.bg;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bj.g;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f2618a;

    /* renamed from: b  reason: collision with root package name */
    private int f2619b;

    /* renamed from: c  reason: collision with root package name */
    private String f2620c;

    /* renamed from: d  reason: collision with root package name */
    private int f2621d;

    /* renamed from: e  reason: collision with root package name */
    private int f2622e;

    /* renamed from: f  reason: collision with root package name */
    private int f2623f;

    /* renamed from: g  reason: collision with root package name */
    private int f2624g;

    /* renamed from: h  reason: collision with root package name */
    private int f2625h;

    /* renamed from: i  reason: collision with root package name */
    private int f2626i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, Integer> f2627j;

    /* renamed from: k  reason: collision with root package name */
    private String f2628k;

    public b() {
    }

    public b(Context context, a aVar, int i4, int i5) {
        if (aVar != null) {
            this.f2619b = aVar.f2616k;
            this.f2620c = aVar.f2617l;
        }
        this.f2618a = context;
        a(i4, i5);
        this.f2627j = new HashMap();
        this.f2628k = g.a(context);
    }

    public int a() {
        return this.f2619b;
    }

    public void a(int i4, int i5) {
        this.f2621d = i4;
        this.f2622e = i5;
        String a4 = cn.jiguang.bf.a.a(i4, 4);
        if (TextUtils.isEmpty(a4)) {
            return;
        }
        try {
            this.f2623f = Integer.parseInt(a4);
        } catch (Throwable unused) {
        }
    }

    public void a(b bVar) {
        if (equals(bVar)) {
            this.f2624g += bVar.f2624g;
            this.f2625h += bVar.f2625h;
            this.f2626i += bVar.f2626i;
            for (String str : bVar.f2627j.keySet()) {
                if (this.f2627j.containsKey(str)) {
                    Integer num = this.f2627j.get(str);
                    Integer num2 = bVar.f2627j.get(str);
                    if (num != null && num2 != null) {
                        this.f2627j.put(str, Integer.valueOf(num.intValue() + num2.intValue()));
                    }
                } else {
                    Integer num3 = bVar.f2627j.get(str);
                    if (num3 != null) {
                        this.f2627j.put(str, num3);
                    }
                }
            }
        }
    }

    public void a(String str) {
        this.f2626i++;
        Integer num = this.f2627j.get(str);
        if (num == null) {
            this.f2627j.put(str, 0);
        } else {
            this.f2627j.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f2619b = jSONObject.optInt("type");
        this.f2620c = jSONObject.optString("cl");
        this.f2622e = jSONObject.optInt("p_ver");
        this.f2621d = jSONObject.optInt("plugin_id");
        this.f2623f = jSONObject.optInt("l_ver");
        this.f2624g = jSONObject.optInt("cnt_start");
        this.f2625h = jSONObject.optInt("cnt_suc");
        this.f2626i = jSONObject.optInt("cnt_fai");
        this.f2628k = jSONObject.optString("process_name");
        JSONArray optJSONArray = jSONObject.optJSONArray("msg");
        this.f2627j = new HashMap();
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                this.f2627j.put(optJSONObject.optString("error_msg"), Integer.valueOf(optJSONObject.optInt("count")));
            }
        }
    }

    public boolean b() {
        Context context;
        if (TextUtils.isEmpty(this.f2628k) || (context = this.f2618a) == null) {
            return false;
        }
        return !this.f2628k.equals(context.getPackageName());
    }

    public void c() {
        this.f2624g++;
    }

    public void d() {
        this.f2625h++;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cl", this.f2620c);
            jSONObject.put("type", this.f2619b);
            jSONObject.put("p_ver", this.f2622e);
            jSONObject.put("plugin_id", this.f2621d);
            jSONObject.put("l_ver", this.f2623f);
            jSONObject.put("cnt_start", this.f2624g);
            jSONObject.put("cnt_suc", this.f2625h);
            jSONObject.put("cnt_fai", this.f2626i);
            jSONObject.put("process_name", this.f2628k);
            Set<String> keySet = this.f2627j.keySet();
            JSONArray jSONArray = new JSONArray();
            for (String str : keySet) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error_msg", str);
                jSONObject2.put("count", this.f2627j.get(str));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("msg", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (a() == bVar.a() && this.f2622e == bVar.f2622e && this.f2621d == bVar.f2621d && this.f2623f == bVar.f2623f) {
            String str = this.f2620c;
            if (str == null ? bVar.f2620c == null : str.equals(bVar.f2620c)) {
                String str2 = this.f2628k;
                String str3 = bVar.f2628k;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.f2628k;
    }
}
