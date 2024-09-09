package cn.jiguang.v;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f3872a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3873b;

    /* renamed from: c  reason: collision with root package name */
    private b f3874c;

    /* renamed from: d  reason: collision with root package name */
    private j f3875d;

    private h(Context context) {
        try {
            this.f3873b = context;
            f.a().a(context);
            b bVar = new b(context);
            this.f3874c = bVar;
            bVar.a(this);
            j jVar = new j(context);
            this.f3875d = jVar;
            jVar.a(this);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("LBSManager", "LBSManageer init error:" + th);
        }
    }

    public static h a(Context context) {
        if (f3872a == null) {
            f3872a = new h(JCoreManager.getAppContext(context));
        }
        return f3872a;
    }

    private String a(ScanResult scanResult, boolean z3) {
        long currentTimeMillis = System.currentTimeMillis() - (((SystemClock.elapsedRealtimeNanos() / 1000) / 1000) - ((scanResult != null ? scanResult.timestamp : 0L) / 1000));
        String b4 = cn.jiguang.ag.a.b(this.f3873b, false);
        String str = "connect";
        if (scanResult != null) {
            String replace = scanResult.SSID.replace("|", "").replace("#", "").replace(",", "");
            String str2 = scanResult.BSSID;
            if (str2 == null || !str2.equals(b4)) {
                str = z3 ? "strongest" : "";
            }
            return replace + "#" + scanResult.BSSID + "#" + scanResult.level + "#" + scanResult.capabilities + "#" + currentTimeMillis + "#" + str;
        }
        String a4 = cn.jiguang.ag.a.a(this.f3873b, false);
        int e4 = cn.jiguang.ag.a.e(this.f3873b);
        if (TextUtils.isEmpty(a4) && TextUtils.isEmpty(b4)) {
            return "";
        }
        String replace2 = a4.replace("|", "").replace("#", "").replace(",", "");
        String a5 = cn.jiguang.ag.i.a(this.f3873b);
        str = (TextUtils.isEmpty(a5) || !"WIFI".equalsIgnoreCase(a5)) ? "" : "";
        return replace2 + "#" + b4 + "#" + e4 + "##" + currentTimeMillis + "#" + str;
    }

    private String b(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append("g|");
        sb.append(System.currentTimeMillis());
        sb.append("|");
        if (location == null) {
            sb.append("none");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            sb.append("0");
        } else {
            sb.append(location.getProvider());
            sb.append("|");
            sb.append(location.getLongitude());
            sb.append("|");
            sb.append(location.getLatitude());
            sb.append("|");
            sb.append(location.getAltitude());
            sb.append("|");
            sb.append(location.getBearing());
            sb.append("|");
            sb.append(location.getAccuracy());
        }
        return sb.toString();
    }

    private String b(d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("c|");
        sb.append(System.currentTimeMillis());
        sb.append("|");
        if (dVar == null) {
            sb.append(0);
            sb.append("|");
            sb.append(0);
            sb.append("|");
            sb.append(0);
            sb.append("|");
            sb.append(0);
            sb.append("|");
            sb.append("");
            sb.append("|");
            sb.append("");
            sb.append("|");
            sb.append("");
            sb.append("|");
        } else {
            sb.append(dVar.a());
            sb.append("|");
            sb.append(dVar.b());
            sb.append("|");
            sb.append(dVar.c());
            sb.append("|");
            sb.append(dVar.d());
            sb.append("|");
            sb.append(dVar.h());
            sb.append("|");
            sb.append(dVar.f());
            sb.append("|");
            sb.append(dVar.g().replace("|", " "));
            sb.append("|");
            List<NeighboringCellInfo> e4 = dVar.e();
            if (e4 != null) {
                cn.jiguang.w.a.b("LBSManager", "neighborCells size:" + e4.size());
                for (int i4 = 0; i4 < e4.size(); i4++) {
                    sb.append(e4.get(i4).getCid());
                    if (i4 < e4.size() - 1) {
                        sb.append(",");
                    }
                }
            } else {
                cn.jiguang.w.a.b("LBSManager", "neighborCells is null");
            }
        }
        return sb.toString();
    }

    private String b(List<ScanResult> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            if (list.size() > 0) {
                Collections.sort(list, this.f3875d.a());
                sb.append("w|");
                int i4 = 0;
                while (i4 < list.size()) {
                    String a4 = a(list.get(i4), i4 == 0);
                    if (!TextUtils.isEmpty(a4)) {
                        sb.append(a4);
                        if (i4 < list.size() - 1) {
                            sb.append(",");
                        }
                    }
                    i4++;
                }
            } else {
                sb.append("w|");
                sb.append(a(null, false));
            }
        }
        return sb.toString();
    }

    public void a() {
        if (this.f3875d != null) {
            cn.jiguang.w.a.b("LBSManager", "start scan wifi");
            this.f3875d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"MissingPermission"})
    public void a(Location location) {
        Context context;
        int i4;
        String b4 = b(location);
        cn.jiguang.w.a.b("LBSManager", "location data:" + b4);
        if (TextUtils.isEmpty(b4)) {
            context = this.f3873b;
            i4 = -1;
        } else {
            a(b4);
            context = this.f3873b;
            i4 = 0;
        }
        cn.jiguang.y.a.a(context, "loc_info_v2", "g", i4);
    }

    public void a(d dVar) {
        Context context;
        int i4;
        String b4 = b(dVar);
        cn.jiguang.w.a.b("LBSManager", "cell data\uff1a" + b4);
        if (TextUtils.isEmpty(b4)) {
            context = this.f3873b;
            i4 = -1;
        } else {
            a(b4);
            context = this.f3873b;
            i4 = 0;
        }
        cn.jiguang.y.a.a(context, "loc_info_v2", "c", i4);
    }

    public void a(String str) {
        synchronized (this) {
            Context context = this.f3873b;
            boolean b4 = cn.jiguang.ao.e.b(context, "rl2.catch", str + "\n");
            cn.jiguang.w.a.b("LBSManager", "save lbs data success:" + b4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<ScanResult> list) {
        Context context;
        int i4;
        cn.jiguang.w.a.b("LBSManager", "wifi data. size:" + list.size());
        String b4 = b(list);
        cn.jiguang.w.a.b("LBSManager", "info:" + b4);
        if (TextUtils.isEmpty(b4)) {
            context = this.f3873b;
            i4 = -1;
        } else {
            a(b4);
            context = this.f3873b;
            i4 = 0;
        }
        cn.jiguang.y.a.a(context, "loc_info_v2", "w", i4);
    }

    public void b() {
        if (this.f3874c != null) {
            cn.jiguang.w.a.b("LBSManager", "start scanGps");
            this.f3874c.a();
        }
    }

    public void c() {
        boolean b4 = f.a().b();
        b bVar = this.f3874c;
        if (bVar == null || !b4) {
            return;
        }
        Location a4 = bVar.a(false);
        cn.jiguang.w.a.b("LBSManager", "get gps");
        if (a4 != null) {
            a(a4);
        } else {
            cn.jiguang.y.a.a(this.f3873b, "loc_info_v2", "g", -1);
        }
    }

    public void d() {
        if (this.f3874c != null) {
            cn.jiguang.w.a.b("LBSManager", "start scan cell");
            this.f3874c.b();
        }
    }

    public JSONObject e() {
        String[] split;
        synchronized (this) {
            String c4 = cn.jiguang.ao.e.c(this.f3873b, "rl2.catch");
            if (TextUtils.isEmpty(c4)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (String str : c4.split("\n")) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("g|")) {
                        jSONArray2.put(str.replaceFirst("g\\|", ""));
                    } else if (str.startsWith("w|")) {
                        jSONArray.put(str.replaceFirst("w\\|", ""));
                    } else if (str.startsWith("c|")) {
                        jSONArray3.put(str.replaceFirst("c\\|", ""));
                    }
                }
            }
            if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) {
                jSONObject.put("g", jSONArray2);
            }
            if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
                jSONObject.put("w", jSONArray);
            }
            if (cn.jiguang.ar.a.a().e(1501)) {
                jSONObject.put("c", jSONArray3);
            }
            cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsGetChecksumInfo);
            if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel)) {
                jSONObject.put("network_type", cn.jiguang.ah.d.l(this.f3873b));
            }
            String c5 = cn.jiguang.ay.e.d().c(this.f3873b);
            if (!TextUtils.isEmpty(c5)) {
                jSONObject.put("ipv6", c5);
            }
            return jSONObject;
        }
    }

    public void f() {
        synchronized (this) {
            cn.jiguang.ao.e.e(this.f3873b, "rl2.catch");
        }
    }
}
