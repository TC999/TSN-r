package cn.jiguang.cf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.cm.d;
import cn.jiguang.internal.JConstants;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3367a = "ex_stat.catch.";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f3368b;

    /* renamed from: c  reason: collision with root package name */
    private Context f3369c;

    private a() {
    }

    public static a a() {
        if (f3368b == null) {
            synchronized (a.class) {
                if (f3368b == null) {
                    f3368b = new a();
                }
            }
        }
        return f3368b;
    }

    private void a(final cn.jiguang.cg.a aVar) {
        d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cf.a.2
            /* JADX WARN: Removed duplicated region for block: B:14:0x006b A[Catch: all -> 0x00c4, TryCatch #1 {all -> 0x00c7, blocks: (B:3:0x0002, B:4:0x0003, B:6:0x0040, B:9:0x0049, B:12:0x0064, B:14:0x006b, B:29:0x00b0, B:17:0x0072, B:20:0x007f, B:23:0x008f, B:26:0x009c, B:28:0x00a8, B:31:0x00b5, B:32:0x00b8, B:33:0x00c2, B:10:0x0050), top: B:41:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[Catch: all -> 0x00c4, TryCatch #1 {all -> 0x00c7, blocks: (B:3:0x0002, B:4:0x0003, B:6:0x0040, B:9:0x0049, B:12:0x0064, B:14:0x006b, B:29:0x00b0, B:17:0x0072, B:20:0x007f, B:23:0x008f, B:26:0x009c, B:28:0x00a8, B:31:0x00b5, B:32:0x00b8, B:33:0x00c2, B:10:0x0050), top: B:41:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x00b3 A[EDGE_INSN: B:44:0x00b3->B:30:0x00b3 ?: BREAK  , SYNTHETIC] */
            @Override // cn.jiguang.cm.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a() {
                /*
                    r15 = this;
                    java.lang.Class<cn.jiguang.cf.a> r0 = cn.jiguang.cf.a.class
                    monitor-enter(r0)     // Catch: java.lang.Throwable -> Lc7
                    cn.jiguang.cg.a r1 = r2     // Catch: java.lang.Throwable -> Lc4
                    org.json.JSONObject r1 = r1.b()     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r2 = "moniter_type"
                    java.lang.String r2 = r1.optString(r2)     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r3 = "timestamp"
                    long r3 = r1.optLong(r3)     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r5 = "extra"
                    org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r6 = "sdk_type"
                    java.lang.String r5 = r5.optString(r6)     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r6 = "ExceptMonitorManager"
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4
                    r7.<init>()     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r8 = "save exception data:"
                    r7.append(r8)     // Catch: java.lang.Throwable -> Lc4
                    r7.append(r1)     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lc4
                    cn.jiguang.bq.d.c(r6, r7)     // Catch: java.lang.Throwable -> Lc4
                    cn.jiguang.cf.a r6 = cn.jiguang.cf.a.this     // Catch: java.lang.Throwable -> Lc4
                    org.json.JSONObject r6 = cn.jiguang.cf.a.a(r6)     // Catch: java.lang.Throwable -> Lc4
                    if (r6 == 0) goto L50
                    java.lang.String r7 = "data"
                    boolean r7 = r6.has(r7)     // Catch: java.lang.Throwable -> Lc4
                    if (r7 != 0) goto L49
                    goto L50
                L49:
                    java.lang.String r7 = "data"
                    org.json.JSONArray r7 = r6.optJSONArray(r7)     // Catch: java.lang.Throwable -> Lc4
                    goto L62
                L50:
                    org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lc4
                    r6.<init>()     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r7 = "type"
                    java.lang.String r8 = "sdk_moniter"
                    r6.put(r7, r8)     // Catch: java.lang.Throwable -> Lc4
                    org.json.JSONArray r7 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Lc4
                    r7.<init>()     // Catch: java.lang.Throwable -> Lc4
                L62:
                    r8 = 0
                    r9 = 0
                L64:
                    int r10 = r7.length()     // Catch: java.lang.Throwable -> Lc4
                    r11 = 1
                    if (r9 >= r10) goto Lb3
                    org.json.JSONObject r10 = r7.optJSONObject(r9)     // Catch: java.lang.Throwable -> Lc4
                    if (r10 != 0) goto L72
                    goto Lb0
                L72:
                    java.lang.String r12 = "moniter_type"
                    java.lang.String r12 = r10.optString(r12)     // Catch: java.lang.Throwable -> Lc4
                    boolean r12 = android.text.TextUtils.equals(r2, r12)     // Catch: java.lang.Throwable -> Lc4
                    if (r12 != 0) goto L7f
                    goto Lb0
                L7f:
                    java.lang.String r12 = "timestamp"
                    long r12 = r10.optLong(r12)     // Catch: java.lang.Throwable -> Lc4
                    java.lang.String r14 = "extra"
                    org.json.JSONObject r10 = r10.optJSONObject(r14)     // Catch: java.lang.Throwable -> Lc4
                    if (r10 != 0) goto L8f
                    goto Lb0
                L8f:
                    java.lang.String r14 = "sdk_type"
                    java.lang.String r14 = r10.optString(r14)     // Catch: java.lang.Throwable -> Lc4
                    boolean r14 = android.text.TextUtils.equals(r5, r14)     // Catch: java.lang.Throwable -> Lc4
                    if (r14 != 0) goto L9c
                    goto Lb0
                L9c:
                    java.lang.String r14 = "count"
                    int r14 = r10.optInt(r14)     // Catch: java.lang.Throwable -> Lc4
                    boolean r12 = cn.jiguang.cj.b.a(r3, r12)     // Catch: java.lang.Throwable -> Lc4
                    if (r12 == 0) goto Lb0
                    java.lang.String r2 = "count"
                    int r14 = r14 + r11
                    r10.put(r2, r14)     // Catch: java.lang.Throwable -> Lc4
                    r8 = 1
                    goto Lb3
                Lb0:
                    int r9 = r9 + 1
                    goto L64
                Lb3:
                    if (r8 != 0) goto Lb8
                    r7.put(r1)     // Catch: java.lang.Throwable -> Lc4
                Lb8:
                    java.lang.String r1 = "data"
                    r6.put(r1, r7)     // Catch: java.lang.Throwable -> Lc4
                    cn.jiguang.cf.a r1 = cn.jiguang.cf.a.this     // Catch: java.lang.Throwable -> Lc4
                    cn.jiguang.cf.a.a(r1, r6)     // Catch: java.lang.Throwable -> Lc4
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc4
                    goto Le2
                Lc4:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc4
                    throw r1     // Catch: java.lang.Throwable -> Lc7
                Lc7:
                    r0 = move-exception
                    java.lang.String r1 = "ExceptMonitorManager"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "save data failed, "
                    r2.append(r3)
                    java.lang.String r0 = r0.getMessage()
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    cn.jiguang.bq.d.i(r1, r0)
                Le2:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.cf.a.AnonymousClass2.a():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(JSONObject jSONObject) {
        try {
            Object onEvent = JCoreManager.onEvent(this.f3369c, JConstants.SDK_TYPE, 41, null, null, f3367a, jSONObject);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ExceptMonitorManager", "writeJson throwable:" + th.getMessage());
            return false;
        }
    }

    private void c() {
        d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cf.a.1
            @Override // cn.jiguang.cm.b
            public void a() {
                try {
                    synchronized (a.class) {
                        JSONObject d4 = a.this.d();
                        if (d4 != null && d4.has("data")) {
                            cn.jiguang.bq.d.c("ExceptMonitorManager", "start report exception monitor data");
                            JCoreManager.onEvent(a.this.f3369c, JConstants.SDK_TYPE, 39, null, null, cn.jiguang.d.a.a(a.this.f3369c, d4, "sdk_moniter"));
                            if (!a.this.a((JSONObject) null)) {
                                a.this.f3369c.deleteFile(a.f3367a);
                            }
                            cn.jiguang.g.b.a(a.this.f3369c, cn.jiguang.g.a.d().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
                        }
                    }
                } catch (Throwable th) {
                    cn.jiguang.bq.d.i("ExceptMonitorManager", "save data error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject d() {
        try {
            Object onEvent = JCoreManager.onEvent(this.f3369c, JConstants.SDK_TYPE, 42, null, null, f3367a);
            if (onEvent instanceof JSONObject) {
                return (JSONObject) onEvent;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ExceptMonitorManager", "readJson throwable:" + th.getMessage());
            return null;
        }
    }

    public void a(Context context) {
        if (this.f3369c == null) {
            synchronized (a.class) {
                this.f3369c = StubApp.getOrigApplicationContext(context.getApplicationContext());
                f3367a += cn.jiguang.f.a.a(this.f3369c).replace(this.f3369c.getPackageName(), "");
                long longValue = ((Long) cn.jiguang.g.b.a(this.f3369c, cn.jiguang.g.a.d())).longValue();
                if (0 == longValue) {
                    longValue = System.currentTimeMillis();
                    cn.jiguang.g.b.a(this.f3369c, cn.jiguang.g.a.d().a((cn.jiguang.g.a<Long>) Long.valueOf(longValue)));
                }
                if (System.currentTimeMillis() - longValue < 86400000) {
                    cn.jiguang.bq.d.c("ExceptMonitorManager", "it not business time, interval: 86400000");
                } else {
                    c();
                }
            }
        }
    }

    public void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.j())).booleanValue()) {
                a(TextUtils.equals(str2, "EX_ANR") ? new cn.jiguang.ch.a(context, str) : new cn.jiguang.ch.b(context, str));
                return;
            }
            return;
        }
        cn.jiguang.bq.d.i("ExceptMonitorManager", "exception occurred for param is null, exType is " + str2);
    }
}
