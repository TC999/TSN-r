package cn.jiguang.dy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.bj.f;
import cn.jiguang.bj.g;
import cn.jiguang.bj.j;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f3587a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f3588b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f3589c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f3590d;

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f3591e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3592f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Context f3594b;

        /* renamed from: c  reason: collision with root package name */
        private cn.jiguang.bg.b f3595c;

        /* renamed from: d  reason: collision with root package name */
        private int f3596d;

        public a(Context context, cn.jiguang.bg.b bVar, int i4) {
            this.f3594b = context;
            this.f3595c = bVar;
            this.f3596d = i4;
        }

        private void a(Context context) {
            try {
                cn.jiguang.bi.b.b("PluginAnalytics", "[reportNow]:" + System.currentTimeMillis());
                File file = new File(cn.jiguang.bj.c.a(context), "dy_analysis");
                if (!file.exists()) {
                    cn.jiguang.bi.b.b("PluginAnalytics", "no event file to report");
                    return;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (!file2.getName().endsWith(".tmp")) {
                            cn.jiguang.bi.b.b("PluginAnalytics", "read event from file:" + file2.getAbsolutePath());
                            String a4 = cn.jiguang.bj.c.a(file2);
                            if (!TextUtils.isEmpty(a4)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("itime", System.currentTimeMillis());
                                jSONObject.put("type", "sdk_stat");
                                jSONObject.put("events", new JSONArray(a4));
                                f.a(context, JConstants.SDK_TYPE, 14, null, null, jSONObject.toString());
                                cn.jiguang.bj.c.a(file2, "");
                            }
                        }
                    }
                    synchronized (c.this.f3590d) {
                        for (File file3 : listFiles) {
                            try {
                                String name = file3.getName();
                                if (name.endsWith(".tmp")) {
                                    file3.renameTo(new File(file3.getParentFile(), name.substring(0, name.length() - 4)));
                                }
                            } catch (Throwable th) {
                                cn.jiguang.bi.b.b("PluginAnalytics", "report file failed:" + th.getMessage());
                            }
                        }
                        c.this.b(context);
                    }
                    return;
                }
                cn.jiguang.bi.b.b("PluginAnalytics", "not found child event file to report");
            } catch (Throwable th2) {
                cn.jiguang.bi.b.g("PluginAnalytics", "report analysis error:" + th2.getMessage());
            }
        }

        private void a(Context context, List<cn.jiguang.bg.b> list) {
            String g4;
            String jSONArray;
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i4 = 0; i4 < list.size(); i4++) {
                    jSONArray2.put(new JSONObject(list.get(i4).e()));
                }
                if (!c.this.c(context) || c.this.f3592f) {
                    g4 = c.this.g(context);
                    jSONArray = jSONArray2.toString();
                } else {
                    g4 = c.this.g(context) + ".tmp";
                    jSONArray = jSONArray2.toString();
                }
                cn.jiguang.bj.c.a(context, g4, jSONArray);
                cn.jiguang.bi.b.b("PluginAnalytics", "saveObjects finished");
            } catch (Throwable th) {
                cn.jiguang.bi.b.e("PluginAnalytics", "[saveObjects] failed:" + th.getMessage());
            }
        }

        private List<cn.jiguang.bg.b> b(Context context) {
            ArrayList arrayList = null;
            try {
                cn.jiguang.bi.b.b("PluginAnalytics", "loadObjects start");
                String a4 = cn.jiguang.bj.c.a(context, (!c.this.c(context) || c.this.f3592f) ? c.this.g(context) : c.this.g(context) + ".tmp");
                if (TextUtils.isEmpty(a4)) {
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                try {
                    try {
                        JSONArray jSONArray = new JSONArray(a4);
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i4);
                            cn.jiguang.bg.b bVar = new cn.jiguang.bg.b();
                            bVar.a(jSONObject);
                            arrayList2.add(bVar);
                        }
                    } catch (Throwable unused) {
                        cn.jiguang.bj.c.a(context, c.this.g(context), "");
                    }
                    return arrayList2;
                } catch (Throwable th) {
                    th = th;
                    arrayList = arrayList2;
                    cn.jiguang.bi.b.e("PluginAnalytics", "[loadObjects] failed:" + th.getMessage());
                    cn.jiguang.bj.c.a(context, c.this.g(context), "");
                    return arrayList;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f3594b == null) {
                    return;
                }
                int i4 = this.f3596d;
                if (i4 == 0 && this.f3595c == null) {
                    cn.jiguang.bi.b.e("PluginAnalytics", "save event info is null");
                } else if (i4 == 1) {
                    if (c.this.f3592f) {
                        cn.jiguang.bi.b.b("PluginAnalytics", "first need not report");
                    } else if (c.this.c(this.f3594b)) {
                        a(this.f3594b);
                    }
                } else {
                    synchronized (c.this.f3590d) {
                        List<cn.jiguang.bg.b> b4 = b(this.f3594b);
                        if (b4 == null) {
                            b4 = new ArrayList<>();
                        }
                        cn.jiguang.bi.b.b("PluginAnalytics", "will save event info:" + this.f3595c.e());
                        if (b4.contains(this.f3595c)) {
                            cn.jiguang.bg.b bVar = b4.get(b4.indexOf(this.f3595c));
                            bVar.a(this.f3595c);
                            cn.jiguang.bi.b.b("PluginAnalytics", "just update,need not add:" + bVar.e());
                        } else {
                            b4.add(this.f3595c);
                        }
                        if (b4.size() >= 200) {
                            b4.remove(0);
                        }
                        a(this.f3594b, b4);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bi.b.e("PluginAnalytics", "saveAction failed:" + th.getMessage());
            }
        }
    }

    private c() {
        this.f3590d = Boolean.TRUE;
        try {
            Class.forName("cn.jiguang.dy.FileLocker");
            this.f3590d = FileLocker.fileLock;
        } catch (Throwable unused) {
            cn.jiguang.bi.b.e("PluginAnalytics", "FileLocker not exist");
        }
    }

    public static c a() {
        if (f3587a == null) {
            synchronized (c.class) {
                if (f3587a == null) {
                    f3587a = new c();
                }
            }
        }
        return f3587a;
    }

    private boolean c(Context context, boolean z3) {
        SharedPreferences f4 = f(context);
        boolean z4 = f4.getBoolean("first_" + z3, true);
        if (z4) {
            this.f3592f = true;
            SharedPreferences.Editor edit = f(context).edit();
            edit.putBoolean("first_" + z3, false).apply();
        }
        return z4;
    }

    private boolean d(Context context) {
        c(context, g.b(context));
        boolean z3 = f(context).getBoolean("plugin_report_switch", false);
        if (z3) {
            return z3;
        }
        Boolean bool = this.f3588b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(f(context).getBoolean("need_report", false));
        this.f3588b = valueOf;
        return valueOf.booleanValue();
    }

    private boolean e(Context context) {
        boolean z3 = f(context).getBoolean("plugin_multi_switch", false);
        if (z3) {
            return z3;
        }
        Boolean bool = this.f3589c;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(f(context).getBoolean("multi_process", false));
        this.f3589c = valueOf;
        return valueOf.booleanValue();
    }

    private SharedPreferences f(Context context) {
        if (this.f3591e == null) {
            this.f3591e = context.getSharedPreferences("cn.jiguang.prefs", 0);
        }
        return this.f3591e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(Context context) {
        String d4 = j.d(g.a(context));
        if (TextUtils.isEmpty(d4)) {
            return "dy_analysis" + File.separator + Process.myPid();
        }
        return "dy_analysis" + File.separator + d4;
    }

    public void a(Context context) {
        try {
            cn.jiguang.bi.b.b("PluginAnalytics", "will [report]");
            if (d(context)) {
                f.a(context, JConstants.SDK_TYPE, 76, null, null, new a(context, null, 1));
            } else {
                cn.jiguang.bi.b.b("PluginAnalytics", "need not report");
            }
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("PluginAnalytics", "[report] failed:" + th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        r2.c();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r8, int r9, int r10, cn.jiguang.bg.a r11, int r12, java.lang.String r13) {
        /*
            r7 = this;
            java.lang.String r0 = "PluginAnalytics"
            boolean r1 = r7.d(r8)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L80
            r1 = 4
            java.lang.String r1 = cn.jiguang.bf.a.a(r9, r1)     // Catch: java.lang.Throwable -> L83
            r2 = 2147483647(0x7fffffff, float:NaN)
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L83
            if (r3 != 0) goto L1c
            int r2 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L1b
            goto L1c
        L1b:
        L1c:
            r1 = 1
            if (r10 > r2) goto L2b
            int r2 = r11.f2616k     // Catch: java.lang.Throwable -> L83
            int r2 = r2 / 1000
            if (r2 != r1) goto L2b
            java.lang.String r8 = "no plugin ,need not save event"
            cn.jiguang.bi.b.b(r0, r8)     // Catch: java.lang.Throwable -> L83
            return
        L2b:
            if (r11 == 0) goto L9c
            cn.jiguang.bg.b r2 = new cn.jiguang.bg.b     // Catch: java.lang.Throwable -> L83
            r2.<init>(r8, r11, r9, r10)     // Catch: java.lang.Throwable -> L83
            boolean r9 = r2.b()     // Catch: java.lang.Throwable -> L83
            if (r9 == 0) goto L58
            boolean r9 = r7.e(r8)     // Catch: java.lang.Throwable -> L83
            if (r9 == 0) goto L3f
            goto L58
        L3f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r8.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r9 = "need not save event in sub process:"
            r8.append(r9)     // Catch: java.lang.Throwable -> L83
            java.lang.String r9 = r2.f()     // Catch: java.lang.Throwable -> L83
            r8.append(r9)     // Catch: java.lang.Throwable -> L83
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L83
        L54:
            cn.jiguang.bi.b.b(r0, r8)     // Catch: java.lang.Throwable -> L83
            goto L9c
        L58:
            if (r12 != 0) goto L5e
            r2.c()     // Catch: java.lang.Throwable -> L83
            goto L6a
        L5e:
            if (r12 != r1) goto L64
            r2.d()     // Catch: java.lang.Throwable -> L83
            goto L6a
        L64:
            r9 = 2
            if (r12 != r9) goto L6a
            r2.a(r13)     // Catch: java.lang.Throwable -> L83
        L6a:
            java.lang.String r9 = "JCore"
            r3 = 76
            r4 = 0
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L83
            cn.jiguang.dy.c$a r10 = new cn.jiguang.dy.c$a     // Catch: java.lang.Throwable -> L83
            r11 = 0
            r10.<init>(r8, r2, r11)     // Catch: java.lang.Throwable -> L83
            r6[r11] = r10     // Catch: java.lang.Throwable -> L83
            r1 = r8
            r2 = r9
            cn.jiguang.bj.f.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L83
            goto L9c
        L80:
            java.lang.String r8 = "need not save event"
            goto L54
        L83:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "onEvent:"
            r9.append(r10)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            cn.jiguang.bi.b.b(r0, r8)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.dy.c.a(android.content.Context, int, int, cn.jiguang.bg.a, int, java.lang.String):void");
    }

    public void a(Context context, boolean z3) {
        cn.jiguang.bi.b.b("PluginAnalytics", "[setNeedReport] enable:" + z3);
        this.f3588b = Boolean.valueOf(z3);
        f(context).edit().putBoolean("need_report", z3).apply();
    }

    public void b(Context context) {
        f(context).edit().putLong("plugin_report_time_", System.currentTimeMillis()).apply();
    }

    public void b(Context context, boolean z3) {
        cn.jiguang.bi.b.b("PluginAnalytics", "[setMultiProcessOpen] enable:" + z3);
        this.f3589c = Boolean.valueOf(z3);
        f(context).edit().putBoolean("multi_process", z3).apply();
    }

    public boolean c(Context context) {
        long j4 = f(context).getLong("plugin_report_time_", 0L);
        boolean z3 = j4 <= 0 || System.currentTimeMillis() > f(context).getLong("plugin_report_interval_", 86400000L) + j4;
        if (!z3) {
            cn.jiguang.bi.b.b("PluginAnalytics", "no need report, last is " + cn.jiguang.bj.b.a(j4));
        }
        return z3;
    }
}
