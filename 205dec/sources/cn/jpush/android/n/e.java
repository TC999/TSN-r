package cn.jpush.android.n;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.stub.StubApp;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static int f4257c = 200;

    /* renamed from: f  reason: collision with root package name */
    private static e f4258f;

    /* renamed from: a  reason: collision with root package name */
    protected Context f4259a;

    /* renamed from: b  reason: collision with root package name */
    protected int f4260b = 100;

    /* renamed from: d  reason: collision with root package name */
    private volatile LinkedHashMap<String, cn.jpush.android.b.b> f4261d;

    /* renamed from: e  reason: collision with root package name */
    private volatile LinkedHashMap<String, cn.jpush.android.b.b> f4262e;

    /* renamed from: g  reason: collision with root package name */
    private a f4263g;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(cn.jpush.android.b.b bVar);

        void a(cn.jpush.android.b.b bVar, cn.jpush.android.b.b bVar2);

        void a(boolean z3);

        void b(cn.jpush.android.b.b bVar);
    }

    private e() {
    }

    private static cn.jpush.android.b.b a(cn.jpush.android.d.d dVar) {
        cn.jpush.android.b.b bVar = new cn.jpush.android.b.b();
        bVar.f4074a = dVar.aj;
        bVar.f4075b = dVar.ak;
        bVar.f4076c = dVar.al;
        bVar.f4077d = dVar.am;
        bVar.f4078e = dVar.ao;
        bVar.f4079f = dVar.ap;
        bVar.f4080g = dVar.aq;
        bVar.f4081h = dVar.ar;
        return bVar;
    }

    public static e a() {
        if (f4258f == null) {
            synchronized (e.class) {
                if (f4258f == null) {
                    f4258f = new e();
                }
            }
        }
        return f4258f;
    }

    private LinkedHashMap<String, cn.jpush.android.b.b> a(Context context, int i4) {
        if (context == null) {
            Logger.w("GeofenceDataHelper", "unexcepted , context is null");
            return null;
        }
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        try {
            File a4 = cn.jpush.android.ad.c.a(context, i4 == 2 ? "jpush_geofence_v5_report" : "jpush_geofence_v5");
            if (a4.exists()) {
                String c4 = cn.jpush.android.ad.c.c(a4);
                if (!TextUtils.isEmpty(c4)) {
                    JSONObject jSONObject = new JSONObject(c4);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jpush.android.b.b a5 = cn.jpush.android.b.b.a(context, jSONObject.getJSONObject(keys.next()));
                        if (a5 != null) {
                            linkedHashMap.put(a5.f4074a, a5);
                        }
                    }
                }
            }
        } finally {
            try {
                return linkedHashMap;
            } finally {
            }
        }
        return linkedHashMap;
    }

    private void a(String str, JSONObject jSONObject, int i4, boolean z3) {
        a aVar;
        LinkedHashMap<String, cn.jpush.android.b.b> d4 = d(i4);
        Logger.dd("GeofenceDataHelper", "Before update.Current geofence size:" + d4.size() + ",type:" + i4);
        cn.jpush.android.b.b bVar = d4.get(str);
        if (bVar == null) {
            Logger.ww("GeofenceDataHelper", "can not update geofence because origin one not found");
            return;
        }
        bVar.b(jSONObject);
        if (bVar.f4078e * 1000 <= System.currentTimeMillis()) {
            d4.remove(str);
            a(bVar);
        } else if (z3 && (aVar = this.f4263g) != null) {
            aVar.a(bVar, bVar);
        }
        e(i4);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|2|3|(1:7)|8|(13:50|(1:(2:69|(1:71)))(2:53|(5:57|(2:60|58)|61|62|(2:64|65)))|14|15|16|(1:18)|19|(1:21)(3:32|(4:35|(3:40|41|42)|43|33)|46)|22|(1:31)|(1:30)|27|28)(1:12)|13|14|15|16|(0)|19|(0)(0)|22|(0)|31|(0)|30|27|28|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
        if (r8.f4261d.isEmpty() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00da, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00de, code lost:
        cn.jpush.android.helper.Logger.dd("GeofenceDataHelper", "recover geofence failed:" + r9);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0164 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.n.e.b(android.content.Context):void");
    }

    private boolean b(int i4) {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = i4 == 2 ? this.f4262e : this.f4261d;
        boolean z3 = false;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            Iterator<Map.Entry<String, cn.jpush.android.b.b>> it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                cn.jpush.android.b.b value = it.next().getValue();
                if (value != null && value.f4078e * 1000 <= System.currentTimeMillis()) {
                    z3 = true;
                    Logger.dd("GeofenceDataHelper", "Geofence " + value.f4074a + " is out of date!");
                    it.remove();
                }
            }
        }
        return z3;
    }

    private void c(int i4) {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap;
        String str;
        if (i4 == 0) {
            c(2);
            c(1);
            return;
        }
        if (i4 == 2) {
            linkedHashMap = this.f4262e;
            Logger.dd("GeofenceDataHelper", "save report geofence to file");
            str = "jpush_geofence_v5_report";
        } else {
            linkedHashMap = this.f4261d;
            Logger.dd("GeofenceDataHelper", "save show geofence to file");
            str = "jpush_geofence_v5";
        }
        if (linkedHashMap == null) {
            return;
        }
        try {
            File a4 = cn.jpush.android.ad.c.a(this.f4259a, str);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, cn.jpush.android.b.b> entry : linkedHashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().a());
            }
            cn.jpush.android.ad.c.a(a4.getAbsolutePath(), jSONObject.toString());
        } catch (Throwable th) {
            Logger.ww("GeofenceDataHelper", "save geo to file error:" + th.getMessage());
        }
    }

    private boolean c(cn.jpush.android.b.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.f4074a) && bVar.f4075b != -1) {
            double d4 = bVar.f4080g;
            if (d4 >= -90.0d && d4 <= 90.0d) {
                double d5 = bVar.f4079f;
                if (d5 >= -180.0d && d5 <= 180.0d) {
                    return true;
                }
            }
        }
        Logger.ww("GeofenceDataHelper", "The geofence is invalid, won't operate!");
        return false;
    }

    private LinkedHashMap<String, cn.jpush.android.b.b> d(int i4) {
        return i4 == 2 ? this.f4262e : this.f4261d;
    }

    private void e(int i4) {
        c(i4);
        a aVar = this.f4263g;
        if (aVar != null) {
            aVar.a(this.f4261d.isEmpty() && this.f4262e.isEmpty());
        }
    }

    private void f(int i4) {
        int size = this.f4261d.size();
        if (size > i4) {
            Logger.dd("GeofenceDataHelper", "ShowGeofence count= " + size + ",limit=" + i4 + ",need remove earliest");
            Iterator<cn.jpush.android.b.b> it = this.f4261d.values().iterator();
            while (it.hasNext() && size > i4) {
                cn.jpush.android.b.b next = it.next();
                if (next != null) {
                    a(next);
                }
                it.remove();
                size--;
            }
        }
    }

    public void a(int i4) {
        cn.jpush.android.cache.a.d(this.f4259a, i4);
        this.f4260b = i4;
        f(i4);
    }

    public synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        this.f4259a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f4260b = cn.jpush.android.cache.a.e(context, 10);
        b(context);
        f(this.f4260b);
    }

    public void a(cn.jpush.android.b.b bVar) {
        if (bVar == null || !TextUtils.isEmpty(bVar.f4074a)) {
            int i4 = bVar.f4082i;
            String str = bVar.f4074a;
            LinkedHashMap<String, cn.jpush.android.b.b> d4 = d(i4);
            Logger.dd("GeofenceDataHelper", "Before delete.Current geofence size:" + d4.size() + ",type:" + i4);
            if (d4.remove(str) != null) {
                e(i4);
                a aVar = this.f4263g;
                if (aVar != null) {
                    aVar.b(bVar);
                    return;
                }
                return;
            }
            Logger.d("GeofenceDataHelper", "geofence=" + bVar.f4074a + " already not exists");
        }
    }

    public void a(a aVar) {
        this.f4263g = aVar;
    }

    public void a(String str) {
        Logger.d("GeofenceDataHelper", "will delete geofence=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cn.jpush.android.b.b bVar = this.f4261d.get(str);
        cn.jpush.android.b.b bVar2 = this.f4262e.get(str);
        if (bVar != null) {
            a(bVar);
        }
        if (bVar2 != null) {
            a(bVar2);
        }
        if (bVar == null && bVar2 == null) {
            Logger.d("GeofenceDataHelper", "geofence=" + str + " already not exists");
        }
    }

    public void a(String str, JSONObject jSONObject, boolean z3) {
        int i4;
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (jSONObject.has("type")) {
            i4 = jSONObject.optInt("type", 1);
        } else {
            a(str, jSONObject, 1, z3);
            i4 = 2;
        }
        a(str, jSONObject, i4, z3);
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        int i4 = 0;
        while (true) {
            try {
                int length = jSONArray.length();
                int i5 = f4257c;
                if (length <= i5) {
                    i5 = jSONArray.length();
                }
                if (i4 >= i5) {
                    break;
                }
                cn.jpush.android.b.b a4 = cn.jpush.android.b.b.a(jSONArray.getJSONObject(i4));
                linkedHashMap.put(a4.f4074a, a4);
                i4++;
            } catch (Throwable th) {
                Logger.dd("GeofenceDataHelper", "Replace report geofences failed:" + th.getMessage());
                return;
            }
        }
        this.f4262e = linkedHashMap;
        e(2);
        a aVar = this.f4263g;
        if (aVar != null) {
            aVar.a(null, null);
        }
    }

    public LinkedHashMap<String, cn.jpush.android.b.b> b() {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(this.f4262e);
        linkedHashMap.putAll(this.f4261d);
        return linkedHashMap;
    }

    public void b(cn.jpush.android.b.b bVar) {
        StringBuilder sb;
        String str;
        if (c(bVar)) {
            int i4 = bVar.f4082i;
            LinkedHashMap<String, cn.jpush.android.b.b> d4 = d(i4);
            Logger.dd("GeofenceDataHelper", "Before add.Current geofence size:" + d4.size() + ",type:" + i4);
            cn.jpush.android.b.b bVar2 = d4.get(bVar.f4074a);
            if (bVar2 == null) {
                if (i4 == 2 && d4.size() >= f4257c) {
                    sb = new StringBuilder();
                    sb.append("Report geofence size limit :");
                    sb.append(f4257c);
                    sb.append(",won't add geofence");
                    str = bVar.f4074a;
                } else if (bVar.f4078e * 1000 <= System.currentTimeMillis()) {
                    sb = new StringBuilder();
                    sb.append("The geofence ");
                    sb.append(bVar.f4074a);
                    str = " is out of date, will not create!";
                } else {
                    f(this.f4260b - 1);
                    d4.put(bVar.f4074a, bVar);
                    a aVar = this.f4263g;
                    if (aVar != null) {
                        aVar.a(bVar);
                    }
                }
                sb.append(str);
                Logger.dd("GeofenceDataHelper", sb.toString());
                return;
            } else if (bVar.f4078e * 1000 <= System.currentTimeMillis()) {
                d4.remove(bVar.f4074a);
                a(bVar2);
            } else {
                bVar.a(bVar2);
                d4.put(bVar.f4074a, bVar);
                a aVar2 = this.f4263g;
                if (aVar2 != null) {
                    aVar2.a(bVar2, bVar);
                }
            }
            e(i4);
        }
    }

    public int c() {
        return this.f4261d.size() + this.f4262e.size();
    }
}
