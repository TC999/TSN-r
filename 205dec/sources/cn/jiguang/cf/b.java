package cn.jiguang.cf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;
import cn.jiguang.bx.h;
import cn.jiguang.bx.i;
import cn.jiguang.internal.JConstants;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static long f3373a = 314572800;

    /* renamed from: b  reason: collision with root package name */
    public static long f3374b = 7000;

    /* renamed from: c  reason: collision with root package name */
    public static long f3375c = 104857600;

    /* renamed from: d  reason: collision with root package name */
    public static long f3376d = 3000;

    /* renamed from: e  reason: collision with root package name */
    public static String f3377e = "sync_net_monitor";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    private static volatile b f3378f;

    /* renamed from: g  reason: collision with root package name */
    private JSONObject f3379g;

    /* renamed from: h  reason: collision with root package name */
    private long f3380h;

    /* renamed from: i  reason: collision with root package name */
    private long f3381i;

    /* renamed from: j  reason: collision with root package name */
    private long f3382j;

    /* renamed from: k  reason: collision with root package name */
    private long f3383k;

    /* renamed from: l  reason: collision with root package name */
    private long f3384l;

    /* renamed from: m  reason: collision with root package name */
    private long f3385m;

    /* renamed from: n  reason: collision with root package name */
    private Context f3386n;

    /* renamed from: o  reason: collision with root package name */
    private Boolean f3387o;

    /* renamed from: p  reason: collision with root package name */
    private long f3388p = 0;

    /* renamed from: q  reason: collision with root package name */
    private long f3389q = 3000;

    private b() {
    }

    private long a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(str));
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(simpleDateFormat.parse(str2));
            return (calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 86400000;
        } catch (Exception e4) {
            e4.printStackTrace();
            return Long.MAX_VALUE;
        }
    }

    public static b a() {
        if (f3378f == null) {
            synchronized (b.class) {
                if (f3378f == null) {
                    f3378f = new b();
                }
            }
        }
        return f3378f;
    }

    private String a(Context context, boolean z3) {
        try {
            Calendar calendar = Calendar.getInstance();
            if (z3) {
                calendar.add(5, -1);
            }
            String format = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
            File file = new File(context.getFilesDir() + "/nes");
            return cn.jiguang.f.c.d(new File(file, format + ".l"));
        } catch (Throwable th) {
            d.i("NetDataMonitorManager", "read Throwable " + th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j4, long j5, long j6, String str) {
        StringBuilder sb;
        long j7;
        g();
        boolean z3 = System.currentTimeMillis() - this.f3388p >= this.f3389q;
        if (TextUtils.isEmpty(str) || !str.contains("conn")) {
            this.f3382j += j6;
            this.f3381i += j5;
            this.f3380h += j4;
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.r().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3382j)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.s().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3381i)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.q().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3380h)));
            if (!z3) {
                return;
            }
            d.i("NetDataMonitorManager", "current data mAllReqLength, " + this.f3380h);
            d.i("NetDataMonitorManager", "current data mAllResLength, " + this.f3381i);
            sb = new StringBuilder();
            sb.append("current  mAllCount, ");
            j7 = this.f3382j;
        } else {
            this.f3385m += j6;
            this.f3383k += j4;
            this.f3384l += j5;
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.u().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3385m)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.v().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3384l)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.t().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3383k)));
            if (!z3) {
                return;
            }
            d.i("NetDataMonitorManager", "current conn data mAllReqLength, " + this.f3383k);
            d.i("NetDataMonitorManager", "current conn data mAllResLength, " + this.f3384l);
            sb = new StringBuilder();
            sb.append("current conn mAllCount, ");
            j7 = this.f3385m;
        }
        sb.append(j7);
        d.i("NetDataMonitorManager", sb.toString());
        this.f3388p = System.currentTimeMillis();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject) {
        try {
            File file = new File(context.getFilesDir() + "/nes");
            if (!file.exists()) {
                file.mkdirs();
            }
            String format = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
            File file2 = new File(file, format + ".l");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            cn.jiguang.f.c.c(file2, jSONObject != null ? jSONObject.toString() : "");
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 15) {
                return;
            }
            for (File file3 : listFiles) {
                if (a(format, file3.getName()) > 15) {
                    file3.delete();
                }
            }
        } catch (IOException unused) {
        }
    }

    private void a(cn.jiguang.cg.a aVar) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("save_data", aVar.b().toString());
            cn.jiguang.a.a.a(this.f3386n, "a12", bundle);
        } catch (Throwable unused) {
        }
    }

    private String c(String str) {
        return str.contains("wi/cjc4sa") ? "1" : str.contains("wi/d8n3hj") ? "2" : str.contains("v1/status") ? "3" : str.contains("tsis") ? "4" : str.contains("ali-stats") ? "6" : str.contains("gd-stats") ? "7" : str.contains("stats") ? "5" : str.contains("v1/version-check") ? "8" : str.contains("wi/plp8j0k") ? "9" : str.contains("wi/spoml") ? "10" : str.contains("qiniup") ? "11" : str.contains("1/getEvent") ? "12" : str.contains("1/setUserInfo") ? "13" : str.contains("1/setChannel") ? "14" : str.contains("1/updateUserProperties") ? "15" : str.contains("1/switcUserProperties") ? "16" : str.contains("v1/user") ? "17" : str.contains("wi/qj18op") ? "18" : str.contains("wi/op8jdu") ? "19" : str.contains("v1/reqtime") ? "20" : str.contains("appgwc/status") ? "21" : str.contains("appawake/status") ? "22" : str.contains("jx/6ae71c") ? "23" : str.contains("wi/swelbv") ? "24" : str.contains("wi/ysdiox") ? "25" : str.startsWith("http") ? "1000" : str;
    }

    private void c() {
        cn.jiguang.cm.d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cf.b.1
            @Override // cn.jiguang.cm.b
            public void a() {
                try {
                    synchronized (b.class) {
                        d.c("NetDataMonitorManager", "real start ");
                        JSONObject e4 = b.this.e();
                        d.c("NetDataMonitorManager", "start report lastJson: " + e4);
                        if (e4 != null && e4.has("data")) {
                            d.c("NetDataMonitorManager", "start report net data monitor");
                            JCoreManager.onEvent(b.this.f3386n, JConstants.SDK_TYPE, 39, null, null, cn.jiguang.d.a.a(b.this.f3386n, e4, "sdk_moniter"));
                            cn.jiguang.g.b.a(b.this.f3386n, cn.jiguang.g.a.d().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
                        }
                    }
                } catch (Throwable th) {
                    d.i("NetDataMonitorManager", "save data error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject d() {
        try {
            if (this.f3379g == null) {
                this.f3379g = new JSONObject(a(this.f3386n, false));
            }
            return this.f3379g;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject e() {
        try {
            return new JSONObject(a(this.f3386n, true));
        } catch (Throwable unused) {
            return null;
        }
    }

    private void f() {
        if (this.f3382j > f3374b || this.f3381i + this.f3380h > f3373a) {
            StringBuilder sb = new StringBuilder();
            sb.append("check business count is more than COUNT= ");
            sb.append(this.f3382j > f3374b);
            d.i("NetDataMonitorManager", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("check business data length is more than NET_LENGTH_THRESHOLD= ");
            sb2.append(this.f3381i + this.f3380h > f3373a);
            d.i("NetDataMonitorManager", sb2.toString());
            b();
            i.a().a(this.f3386n);
        }
        if (this.f3385m > f3376d || this.f3384l + this.f3383k > f3375c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("check conn count is more than CONN_COUNT= ");
            sb3.append(this.f3385m > f3376d);
            d.i("NetDataMonitorManager", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("check conn data length is more than NET_CONN_LENGTH_THRESHOLD= ");
            sb4.append(this.f3384l + this.f3383k > f3375c);
            d.i("NetDataMonitorManager", sb4.toString());
            b();
            h.a().a(this.f3386n, "tcp_a23", null);
        }
    }

    private void g() {
        long longValue = ((Long) cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.w())).longValue();
        long b4 = cn.jiguang.cj.b.b();
        if (longValue == 0 || longValue != b4) {
            d.i("NetDataMonitorManager", "checkCurrentDayTime saveCurrentDayTime " + longValue);
            d.i("NetDataMonitorManager", "checkCurrentDayTime currentDayTime " + b4);
            d.i("NetDataMonitorManager", "recover all data");
            this.f3382j = 0L;
            this.f3380h = 0L;
            this.f3381i = 0L;
            this.f3385m = 0L;
            this.f3383k = 0L;
            this.f3384l = 0L;
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.w().a((cn.jiguang.g.a<Long>) Long.valueOf(b4)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.r().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3382j)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.s().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3381i)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.q().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3380h)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.u().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3385m)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.v().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3384l)));
            cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.t().a((cn.jiguang.g.a<Long>) Long.valueOf(this.f3383k)));
            this.f3379g = null;
            this.f3379g = d();
        }
    }

    public void a(Context context) {
        if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.l())).booleanValue() && this.f3387o == null) {
            synchronized (b.class) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f3386n = origApplicationContext;
                long longValue = ((Long) cn.jiguang.g.b.a(origApplicationContext, cn.jiguang.g.a.d())).longValue();
                if (0 == longValue) {
                    longValue = System.currentTimeMillis();
                    cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.d().a((cn.jiguang.g.a<Long>) Long.valueOf(longValue)));
                }
                this.f3387o = Boolean.TRUE;
                d.c("NetDataMonitorManager", "start report lastReportTime " + longValue + " BuildConfig.INTERNAL_USE=false");
                long longValue2 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.m())).longValue();
                if (longValue2 > 0) {
                    f3374b = longValue2;
                }
                long longValue3 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.n())).longValue();
                if (longValue3 > 0) {
                    f3373a = longValue3;
                }
                long longValue4 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.o())).longValue();
                if (longValue4 > 0) {
                    f3376d = longValue4;
                }
                long longValue5 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.p())).longValue();
                if (longValue5 > 0) {
                    f3375c = longValue5;
                }
                d.c("NetDataMonitorManager", "use count=" + f3374b + " net threshold=" + f3373a);
                d.c("NetDataMonitorManager", "use conn count=" + f3376d + " net conn threshold=" + f3375c);
                this.f3382j = ((Long) cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.r())).longValue();
                this.f3380h = ((Long) cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.q())).longValue();
                this.f3381i = ((Long) cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.s())).longValue();
                this.f3385m = ((Long) cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.u())).longValue();
                this.f3383k = ((Long) cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.t())).longValue();
                this.f3384l = ((Long) cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.v())).longValue();
                d.c("NetDataMonitorManager", "init first mAllCount=" + this.f3382j + " mAllReqLength=" + this.f3380h + " mAllResLength=" + this.f3381i);
                d.c("NetDataMonitorManager", "init first conn mAllCount=" + this.f3385m + " mAllReqLength=" + this.f3383k + " mAllResLength=" + this.f3384l);
                g();
                b();
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("start report currentTimestamp ");
                sb.append(currentTimeMillis);
                d.c("NetDataMonitorManager", sb.toString());
                if (currentTimeMillis - longValue < 86400000) {
                    d.c("NetDataMonitorManager", "it not business time, interval: 86400000");
                    return;
                }
                d.c("NetDataMonitorManager", "need to  report");
                c();
            }
        }
    }

    public void a(Bundle bundle) {
        try {
            String string = bundle.getString("url");
            long j4 = bundle.getLong("req");
            long j5 = bundle.getLong("res");
            String string2 = bundle.getString("type");
            cn.jiguang.ci.i iVar = new cn.jiguang.ci.i(this.f3386n);
            iVar.a(c(string));
            iVar.b(string2);
            iVar.b(j4);
            iVar.a(j5);
            iVar.c(1L);
            a(iVar);
        } catch (Throwable unused) {
        }
    }

    public void a(HttpRequest httpRequest, boolean z3) {
        long length;
        String str;
        try {
            if (z3) {
                str = httpRequest.getUrl();
                length = httpRequest.getParas().length;
            } else {
                String[] split = httpRequest.getUrl().split(" \\?");
                String str2 = split[0];
                length = split.length > 1 ? split[1].getBytes().length : -1L;
                str = str2;
            }
            b(c(str), httpRequest.getType(), length);
        } catch (Throwable unused) {
        }
    }

    public void a(HttpRequest httpRequest, boolean z3, HttpResponse httpResponse) {
        c(c(z3 ? httpRequest.getUrl() : httpRequest.getUrl().split(" \\?")[0]), httpRequest.getType(), !TextUtils.isEmpty(httpResponse.getResponseBody()) ? httpResponse.getResponseBody().getBytes().length : 0L);
    }

    public synchronized void a(final String str) {
        if (((Boolean) cn.jiguang.g.b.a(this.f3386n, cn.jiguang.g.a.l())).booleanValue()) {
            cn.jiguang.cm.d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cf.b.2
                /* JADX WARN: Removed duplicated region for block: B:15:0x008a A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x0120, blocks: (B:4:0x0004, B:5:0x0005, B:7:0x0061, B:10:0x006a, B:13:0x0084, B:15:0x008a, B:29:0x00ea, B:18:0x0091, B:21:0x009e, B:24:0x00a7, B:26:0x00cd, B:28:0x00d3, B:32:0x00f0, B:33:0x0102, B:34:0x011b, B:11:0x0071), top: B:42:0x0004 }] */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00f0 A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x0120, blocks: (B:4:0x0004, B:5:0x0005, B:7:0x0061, B:10:0x006a, B:13:0x0084, B:15:0x008a, B:29:0x00ea, B:18:0x0091, B:21:0x009e, B:24:0x00a7, B:26:0x00cd, B:28:0x00d3, B:32:0x00f0, B:33:0x0102, B:34:0x011b, B:11:0x0071), top: B:42:0x0004 }] */
                /* JADX WARN: Removed duplicated region for block: B:44:0x00ed A[SYNTHETIC] */
                @Override // cn.jiguang.cm.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a() {
                    /*
                        Method dump skipped, instructions count: 316
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.cf.b.AnonymousClass2.a():void");
                }
            });
        }
    }

    public void a(String str, String str2, long j4) {
        cn.jiguang.ci.i iVar = new cn.jiguang.ci.i(this.f3386n);
        iVar.a(str);
        iVar.b(str2);
        iVar.a(j4);
        iVar.c(1L);
        a(iVar);
    }

    public void b() {
        try {
            if (this.f3386n.getPackageName().equals(cn.jiguang.f.a.a(this.f3386n))) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("count", this.f3382j);
            jSONObject.put("res_l", this.f3381i);
            jSONObject.put("req_l", this.f3380h);
            jSONObject.put("count_th", f3374b);
            jSONObject.put("l_th", f3373a);
            jSONObject.put("conn_count", this.f3385m);
            jSONObject.put("conn_res_l", this.f3384l);
            jSONObject.put("conn_req_l", this.f3383k);
            jSONObject.put("conn_count_th", f3376d);
            jSONObject.put("conn_length_th", f3375c);
            d.i("NetDataMonitorManager", "sendMessageToMain json=" + jSONObject);
            cn.jiguang.f.a.b(this.f3386n, f3377e, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d.i("NetDataMonitorManager", "syncMessage json=" + jSONObject);
            long optLong = jSONObject.optLong("count");
            if (optLong > 0) {
                this.f3382j = optLong;
            }
            long optLong2 = jSONObject.optLong("res_l");
            if (optLong2 > 0) {
                this.f3381i = optLong2;
            }
            long optLong3 = jSONObject.optLong("req_l");
            if (optLong > 0) {
                this.f3380h = optLong3;
            }
            long optLong4 = jSONObject.optLong("count_th");
            if (optLong4 > 0) {
                f3374b = optLong4;
            }
            long optLong5 = jSONObject.optLong("l_th");
            if (optLong5 > 0) {
                f3373a = optLong5;
            }
            long optLong6 = jSONObject.optLong("conn_count");
            if (optLong6 > 0) {
                this.f3385m = optLong6;
            }
            long optLong7 = jSONObject.optLong("conn_res_l");
            if (optLong7 > 0) {
                this.f3384l = optLong7;
            }
            long optLong8 = jSONObject.optLong("conn_req_l");
            if (optLong8 > 0) {
                this.f3383k = optLong8;
            }
            long optLong9 = jSONObject.optLong("conn_count_th");
            if (optLong9 > 0) {
                f3376d = optLong9;
            }
            long optLong10 = jSONObject.optLong("conn_length_th");
            if (optLong10 > 0) {
                f3375c = optLong10;
            }
        } catch (Throwable unused) {
        }
    }

    public void b(String str, String str2, long j4) {
        cn.jiguang.ci.i iVar = new cn.jiguang.ci.i(this.f3386n);
        iVar.a(str);
        iVar.b(str2);
        iVar.b(j4);
        iVar.c(1L);
        a(iVar);
    }

    public boolean b(Context context) {
        StringBuilder sb;
        long j4;
        if (this.f3386n == null) {
            a(context);
        }
        g();
        if (this.f3382j > f3374b) {
            sb = new StringBuilder();
            sb.append("business count is more than count: ");
            j4 = f3374b;
        } else if (this.f3381i + this.f3380h <= f3373a) {
            return true;
        } else {
            sb = new StringBuilder();
            sb.append("business data length is more than data threshold: ");
            j4 = f3373a;
        }
        sb.append(j4);
        sb.append(",so sdk limit");
        d.i("NetDataMonitorManager", sb.toString());
        return false;
    }

    public void c(String str, String str2, long j4) {
        cn.jiguang.ci.i iVar = new cn.jiguang.ci.i(this.f3386n);
        iVar.a(str);
        iVar.b(str2);
        iVar.a(j4);
        a(iVar);
    }

    public boolean c(Context context) {
        StringBuilder sb;
        long j4;
        if (this.f3386n == null) {
            a(context);
        }
        g();
        if (this.f3385m > f3376d) {
            sb = new StringBuilder();
            sb.append("conn count is more than count: ");
            j4 = f3376d;
        } else if (this.f3384l + this.f3383k <= f3375c) {
            return true;
        } else {
            sb = new StringBuilder();
            sb.append("conn data length is more than data threshold: ");
            j4 = f3375c;
        }
        sb.append(j4);
        sb.append(",so sdk limit");
        d.i("NetDataMonitorManager", sb.toString());
        return false;
    }
}
