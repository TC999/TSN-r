package cn.jiguang.v;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    private static String f3878b = "WifiHelper";

    /* renamed from: a  reason: collision with root package name */
    protected int f3879a;

    /* renamed from: c  reason: collision with root package name */
    private h f3880c;

    /* renamed from: d  reason: collision with root package name */
    private Comparator<ScanResult> f3881d;

    /* renamed from: e  reason: collision with root package name */
    private Comparator<Long> f3882e;

    /* renamed from: f  reason: collision with root package name */
    private i<Long> f3883f;

    /* renamed from: g  reason: collision with root package name */
    private List<ScanResult> f3884g;

    /* renamed from: h  reason: collision with root package name */
    private WifiManager f3885h;

    /* renamed from: i  reason: collision with root package name */
    private Context f3886i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Comparator<Long> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Long l4, Long l5) {
            if (l4.longValue() == l5.longValue()) {
                return 0;
            }
            return l4.longValue() > l5.longValue() ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Comparator<ScanResult> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    public j(Context context) {
        this.f3886i = context;
        c();
    }

    private void b(List<ScanResult> list) {
        List<Long> a4;
        try {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                Collections.sort(list, this.f3881d);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ScanResult scanResult = list.get(i5);
                    if (scanResult != null) {
                        long parseLong = Long.parseLong(scanResult.BSSID.replaceAll(":", ""), 16);
                        if (parseLong != 0 && scanResult.level > e.f3854h && !arrayList.contains(Long.valueOf(parseLong))) {
                            if (i4 >= e.f3853g) {
                                break;
                            }
                            arrayList.add(Long.valueOf(parseLong));
                            this.f3884g.add(scanResult);
                            i4++;
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    Collections.sort(arrayList, this.f3882e);
                    if (!e.f3861o.isEmpty() && (a4 = this.f3883f.a(arrayList, e.f3861o)) != null && !a4.isEmpty()) {
                        double size = arrayList.size() - a4.size();
                        double size2 = arrayList.size();
                        Double.isNaN(size);
                        Double.isNaN(size2);
                        if (((int) ((size / size2) * 100.0d)) < e.f3855i) {
                            d();
                            return;
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                a(arrayList);
            }
            this.f3880c.a(this.f3884g);
        } catch (Throwable th) {
            cn.jiguang.y.a.a(this.f3886i, "loc_info_v2", "w", -1);
            cn.jiguang.w.a.b(f3878b, "" + th);
        }
        this.f3879a = 101;
    }

    private void c() {
        this.f3884g = new ArrayList();
        this.f3881d = new b();
        a aVar = new a();
        this.f3882e = aVar;
        this.f3883f = new i<>(aVar);
        this.f3879a = 101;
        this.f3885h = (WifiManager) this.f3886i.getSystemService("wifi");
        ArrayList<Long> arrayList = e.f3861o;
        if (arrayList == null) {
            e.f3861o = new ArrayList<>();
        } else if (arrayList.isEmpty()) {
        } else {
            Collections.sort(e.f3861o, this.f3882e);
        }
    }

    private void d() {
        try {
            this.f3884g.clear();
            cn.jiguang.w.a.b(f3878b, "clearWifiData ");
        } catch (Throwable th) {
            String str = f3878b;
            cn.jiguang.w.a.b(str, "" + th);
        }
    }

    public Comparator<ScanResult> a() {
        return this.f3881d;
    }

    public void a(h hVar) {
        this.f3880c = hVar;
    }

    public void a(List<Long> list) {
        if (list != null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                e.f3861o.clear();
                for (int i4 = 0; i4 < list.size(); i4++) {
                    e.f3861o.add(Long.valueOf(list.get(i4).longValue()));
                    int size = list.size() - 1;
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.b(f3878b, "" + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        try {
            boolean z3 = e.f3847a;
            if (!z3 || this.f3879a != 101) {
                if (z3) {
                    return;
                }
                cn.jiguang.y.a.a(this.f3886i, "loc_info_v2", "w", 1);
                return;
            }
            boolean b4 = f.a().b();
            Context context = this.f3886i;
            boolean a4 = context != null ? cn.jiguang.ah.d.a(context, "android.permission.ACCESS_WIFI_STATE") : false;
            String str = f3878b;
            cn.jiguang.w.a.b(str, "doSample checkSafeStatus = " + b4 + "  , wifi permission:" + a4);
            if (!b4) {
                cn.jiguang.y.a.a(this.f3886i, "loc_info_v2", "w", 2);
            }
            if (!a4) {
                cn.jiguang.y.a.a(this.f3886i, "loc_info_v2", "w", -5);
            }
            if (!b4 || !a4) {
                this.f3879a = 101;
                return;
            }
            this.f3884g.clear();
            this.f3879a = 100;
            b(this.f3885h.getScanResults());
        } catch (Throwable th) {
            String str2 = f3878b;
            cn.jiguang.w.a.f(str2, "[WifiHelper] startScan error:" + th);
        }
    }
}
