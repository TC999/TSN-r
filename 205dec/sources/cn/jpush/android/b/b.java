package cn.jpush.android.b;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.acse.ottn.adapter.AutoScrollViewPager;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b implements Serializable {
    private static final long serialVersionUID = 2310616383854860780L;

    /* renamed from: a  reason: collision with root package name */
    public String f4074a;

    /* renamed from: b  reason: collision with root package name */
    public long f4075b;

    /* renamed from: c  reason: collision with root package name */
    public String f4076c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4077d;

    /* renamed from: e  reason: collision with root package name */
    public long f4078e;

    /* renamed from: f  reason: collision with root package name */
    public double f4079f = 200.0d;

    /* renamed from: g  reason: collision with root package name */
    public double f4080g = 200.0d;

    /* renamed from: h  reason: collision with root package name */
    public String f4081h;

    /* renamed from: i  reason: collision with root package name */
    public int f4082i;

    /* renamed from: j  reason: collision with root package name */
    public String f4083j;

    /* renamed from: k  reason: collision with root package name */
    public String f4084k;

    /* renamed from: l  reason: collision with root package name */
    public int f4085l;

    /* renamed from: m  reason: collision with root package name */
    public int f4086m;

    /* renamed from: n  reason: collision with root package name */
    public int f4087n;

    /* renamed from: o  reason: collision with root package name */
    public long f4088o;

    /* renamed from: p  reason: collision with root package name */
    public String f4089p;

    /* renamed from: q  reason: collision with root package name */
    public int f4090q;

    /* renamed from: r  reason: collision with root package name */
    public String f4091r;

    /* renamed from: s  reason: collision with root package name */
    public int f4092s;

    /* renamed from: t  reason: collision with root package name */
    public cn.jpush.android.d.d f4093t;

    public static b a(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.f4084k = jSONObject.optString("op");
            bVar.f4074a = jSONObject.optString("geofenceid");
            bVar.f4083j = jSONObject.optString("name");
            bVar.f4075b = jSONObject.optLong("radius");
            bVar.f4076c = jSONObject.optString("status");
            bVar.f4077d = jSONObject.optBoolean("repeat");
            bVar.f4085l = jSONObject.optInt("repeat_week_num");
            bVar.f4086m = jSONObject.optInt("repeat_day_num");
            bVar.f4087n = jSONObject.optInt("repeat_time");
            bVar.f4078e = jSONObject.optLong("expiration");
            bVar.f4082i = jSONObject.optInt("type", 1);
            bVar.f4079f = jSONObject.optDouble("lon", 200.0d);
            bVar.f4080g = jSONObject.optDouble("lat", 200.0d);
            bVar.f4088o = jSONObject.optLong("lastTime");
            bVar.f4089p = jSONObject.optString("lastTimeWeek");
            bVar.f4090q = jSONObject.optInt("weekNum");
            bVar.f4091r = jSONObject.optString("lastTimeDay");
            bVar.f4092s = jSONObject.optInt("dayNum");
            bVar.f4081h = jSONObject.optString("lastGeoStatus");
            String optString = jSONObject.optString("entity");
            if (!TextUtils.isEmpty(optString)) {
                bVar.f4093t = cn.jpush.android.d.d.a(optString, context.getPackageName(), JCoreHelper.getAppKey(context), 0L);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static b a(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.f4084k = jSONObject.optString("op");
            bVar.f4074a = jSONObject.optString("geofenceid");
            bVar.f4083j = jSONObject.optString("name");
            bVar.f4075b = jSONObject.optLong("radius");
            bVar.f4076c = jSONObject.optString("status");
            bVar.f4077d = jSONObject.optBoolean("repeat");
            bVar.f4085l = jSONObject.optInt("repeat_week_num");
            bVar.f4086m = jSONObject.optInt("repeat_day_num");
            bVar.f4087n = jSONObject.optInt("repeat_time");
            bVar.f4078e = jSONObject.optLong("expiration");
            bVar.f4082i = jSONObject.optInt("type", 1);
            JSONObject optJSONObject = jSONObject.optJSONObject(AutoScrollViewPager.f4767g);
            if (optJSONObject != null) {
                bVar.f4079f = optJSONObject.optDouble("lon", 200.0d);
                bVar.f4080g = optJSONObject.optDouble("lat", 200.0d);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", this.f4084k);
            jSONObject.put("geofenceid", this.f4074a);
            jSONObject.put("name", this.f4083j);
            jSONObject.put("radius", this.f4075b);
            jSONObject.put("status", this.f4076c);
            jSONObject.put("repeat", this.f4077d);
            jSONObject.put("repeat_week_num", this.f4085l);
            jSONObject.put("repeat_day_num", this.f4086m);
            jSONObject.put("repeat_time", this.f4087n);
            jSONObject.put("expiration", this.f4078e);
            jSONObject.put("type", this.f4082i);
            jSONObject.put("lon", this.f4079f);
            jSONObject.put("lat", this.f4080g);
            jSONObject.put("lastTime", this.f4088o);
            jSONObject.put("lastTimeWeek", this.f4089p);
            jSONObject.put("weekNum", this.f4090q);
            jSONObject.put("lastTimeDay", this.f4091r);
            jSONObject.put("dayNum", this.f4092s);
            jSONObject.put("lastGeoStatus", this.f4081h);
            cn.jpush.android.d.d dVar = this.f4093t;
            if (dVar != null) {
                jSONObject.put("entity", dVar.f4132i);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(b bVar) {
        this.f4081h = bVar.f4081h;
        this.f4088o = bVar.f4088o;
        this.f4089p = bVar.f4089p;
        this.f4091r = bVar.f4091r;
        this.f4090q = bVar.f4090q;
        this.f4092s = bVar.f4092s;
    }

    public void b(JSONObject jSONObject) {
        try {
            if (jSONObject.has("name")) {
                this.f4083j = jSONObject.optString("name");
            }
            long optLong = jSONObject.optLong("radius", -1L);
            if (optLong > 0) {
                this.f4075b = optLong;
            }
            if (jSONObject.has("status")) {
                this.f4076c = jSONObject.optString("status");
            }
            if (jSONObject.has("repeat")) {
                boolean optBoolean = jSONObject.optBoolean("repeat");
                this.f4077d = optBoolean;
                if (optBoolean) {
                    if (jSONObject.has("repeat_week_num")) {
                        this.f4085l = jSONObject.optInt("repeat_week_num");
                    }
                    if (jSONObject.has("repeat_day_num")) {
                        this.f4086m = jSONObject.optInt("repeat_day_num");
                    }
                    if (jSONObject.has("repeat_time")) {
                        this.f4087n = jSONObject.optInt("repeat_time");
                    }
                }
            }
            if (jSONObject.has("expiration")) {
                this.f4078e = jSONObject.optLong("expiration");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(AutoScrollViewPager.f4767g);
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("lon", 200.0d);
                double optDouble2 = optJSONObject.optDouble("lat", 200.0d);
                if (optDouble >= -180.0d && optDouble <= 180.0d && optDouble2 >= -90.0d && optDouble2 <= 90.0d) {
                    this.f4079f = optDouble;
                    this.f4080g = optDouble2;
                    return;
                }
                Logger.w("Geofence", "update center failed because value invalid, [" + optDouble2 + "," + optDouble + "]");
            }
        } catch (Throwable unused) {
        }
    }
}
