package cn.jiguang.v;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import cn.jiguang.api.JCoreManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected Location f3825a;

    /* renamed from: b  reason: collision with root package name */
    public Context f3826b;

    /* renamed from: c  reason: collision with root package name */
    public h f3827c;

    /* renamed from: d  reason: collision with root package name */
    public long f3828d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f3829e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f3830f = 0;

    /* renamed from: g  reason: collision with root package name */
    private LocationManager f3831g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3832h;

    /* renamed from: i  reason: collision with root package name */
    private GpsStatus.Listener f3833i;

    /* renamed from: j  reason: collision with root package name */
    private GnssStatus.Callback f3834j;

    @SuppressLint({"MissingPermission"})
    public b(Context context) {
        this.f3826b = JCoreManager.getAppContext(context);
        this.f3831g = (LocationManager) context.getSystemService("location");
        if (Build.VERSION.SDK_INT < 24 || context.getApplicationInfo().targetSdkVersion < 31) {
            this.f3833i = new c(this);
        } else {
            this.f3834j = new a(this);
        }
    }

    private boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    private boolean c() {
        LocationManager locationManager;
        try {
            if (d() && (locationManager = this.f3831g) != null) {
                if (!locationManager.isProviderEnabled("gps") && !this.f3831g.isProviderEnabled("network")) {
                    if (!this.f3831g.isProviderEnabled("passive")) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean d() {
        return cn.jiguang.ah.d.a(this.f3826b, "android.permission.ACCESS_FINE_LOCATION") && cn.jiguang.ah.d.a(this.f3826b, "android.permission.ACCESS_COARSE_LOCATION") && a(this.f3826b, "android.permission.ACCESS_FINE_LOCATION") && a(this.f3826b, "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0097 A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:31:0x0091, B:33:0x0097), top: B:42:0x0091 }] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0078 -> B:42:0x0091). Please submit an issue!!! */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.jiguang.v.d e() {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.v.b.e():cn.jiguang.v.d");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"MissingPermission"})
    public Location a(boolean z3) {
        try {
            if (this.f3831g != null && c()) {
                return z3 ? this.f3831g.getLastKnownLocation("gps") : this.f3831g.getLastKnownLocation("network");
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.w.a.b("CellHelper", "getLocation error:" + th);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public void a() {
        try {
            if (this.f3832h) {
                cn.jiguang.w.a.b("CellHelper", "g is on listening");
                return;
            }
            boolean b4 = f.a().b();
            boolean c4 = c();
            cn.jiguang.w.a.b("CellHelper", " init checkSafeStatus = " + b4 + " , deviceEnv=" + c4);
            if (!b4) {
                cn.jiguang.y.a.a(this.f3826b, "loc_info_v2", "g", 2);
            }
            if (!c4) {
                cn.jiguang.y.a.a(this.f3826b, "loc_info_v2", "g", -6);
            }
            if (b4 && this.f3831g != null && c4) {
                new Handler(Looper.getMainLooper()).post(new cn.jiguang.ah.e() { // from class: cn.jiguang.v.b.1
                    @Override // cn.jiguang.ah.e
                    public void a() {
                        try {
                            if (Build.VERSION.SDK_INT < 24 || b.this.f3826b.getApplicationInfo().targetSdkVersion < 31) {
                                b.this.f3831g.addGpsStatusListener(b.this.f3833i);
                            } else {
                                b.this.f3831g.registerGnssStatusCallback(b.this.f3834j);
                            }
                        } catch (Throwable th) {
                            cn.jiguang.w.a.f("CellHelper", "addGpsStatusListener error:" + th);
                        }
                    }
                });
                this.f3832h = true;
                cn.jiguang.w.a.b("CellHelper", "g is start listening");
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.b("CellHelper", "init error:" + th);
            this.f3832h = false;
        }
    }

    public void a(h hVar) {
        this.f3827c = hVar;
    }

    public void b() {
        try {
            d e4 = e();
            if (e4 != null) {
                this.f3827c.a(e4);
            } else {
                cn.jiguang.y.a.a(this.f3826b, "loc_info_v2", "c", -6);
            }
        } catch (Throwable th) {
            cn.jiguang.y.a.a(this.f3826b, "loc_info_v2", "c", -1);
            cn.jiguang.w.a.f("CellHelper", "startScanCell error:" + th);
        }
    }
}
