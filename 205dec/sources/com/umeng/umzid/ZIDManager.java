package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ZIDManager {

    /* renamed from: d  reason: collision with root package name */
    public static ZIDManager f54223d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54224a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54225b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54226c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f54227a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IZIDCompletionCallback f54228b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f54227a = context;
            this.f54228b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a4 = ZIDManager.a(ZIDManager.this, this.f54227a);
            if (TextUtils.isEmpty(a4)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f54228b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "\u83b7\u53d6zid\u5931\u8d25");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f54228b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a4);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f54230a;

        public b(Context context) {
            this.f54230a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.b(this.f54230a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f54232a;

        public c(Context context) {
            this.f54232a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f54232a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:6:0x0010, B:21:0x0056, B:22:0x005b, B:26:0x006b, B:28:0x008a, B:30:0x009f, B:32:0x00b4, B:33:0x00b7, B:35:0x00c3, B:36:0x00c6, B:38:0x00d2, B:39:0x00d5, B:19:0x0051), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:6:0x0010, B:21:0x0056, B:22:0x005b, B:26:0x006b, B:28:0x008a, B:30:0x009f, B:32:0x00b4, B:33:0x00b7, B:35:0x00c3, B:36:0x00c6, B:38:0x00d2, B:39:0x00d5, B:19:0x0051), top: B:50:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.String a(com.umeng.umzid.ZIDManager r10, android.content.Context r11) {
        /*
            boolean r0 = r10.f54224a
            r1 = 0
            if (r0 == 0) goto L7
            goto Ldf
        L7:
            r0 = 1
            r10.f54224a = r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r3 = 0
            java.lang.String r4 = com.umeng.umzid.Spy.getID()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "z"
            r2.put(r5, r4)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = com.umeng.umzid.d.e(r11)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r6 = "mc"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r6 = com.umeng.umzid.d.f(r11)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = "o"
            r2.put(r7, r6)     // Catch: java.lang.Throwable -> Ld9
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            r7.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r8 = "vpn_pxy"
            boolean r9 = com.umeng.umzid.d.i(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r8 = "wifi_pxy"
            boolean r9 = com.umeng.umzid.d.j(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r8 = "double"
            boolean r9 = com.umeng.umzid.d.g(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            goto L54
        L4c:
            r8 = move-exception
            goto L51
        L4e:
            r7 = move-exception
            r8 = r7
            r7 = r1
        L51:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> Ld9
        L54:
            if (r7 == 0) goto L5b
            java.lang.String r8 = "anti"
            r2.put(r8, r7)     // Catch: java.lang.Throwable -> Ld9
        L5b:
            r10.a(r11, r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = com.umeng.umzid.d.b(r11)     // Catch: java.lang.Throwable -> Ld9
            int r8 = r7.length()     // Catch: java.lang.Throwable -> Ld9
            if (r8 <= 0) goto L69
            goto L6b
        L69:
            java.lang.String r7 = "https://utoken.umeng.com"
        L6b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld9
            r8.<init>()     // Catch: java.lang.Throwable -> Ld9
            r8.append(r7)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = "/anti/postZdata"
            r8.append(r7)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = r8.toString()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = com.umeng.umzid.a.a(r7, r2)     // Catch: java.lang.Throwable -> Ld9
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Ld9
            if (r7 != 0) goto Ld5
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ld9
            r7.<init>(r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = "suc"
            boolean r2 = r7.optBoolean(r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> Ld9
            if (r2 != r0) goto Ld5
            com.umeng.umzid.d.f(r11, r4)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.umzid.d.a(r11, r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.umzid.d.b(r11, r6)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r0 = "aaid"
            java.lang.String r1 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Ld9
            if (r0 != 0) goto Lb7
            com.umeng.umzid.d.e(r11, r1)     // Catch: java.lang.Throwable -> Ld9
        Lb7:
            java.lang.String r0 = "uabc"
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r2 != 0) goto Lc6
            com.umeng.umzid.d.d(r11, r0)     // Catch: java.lang.Throwable -> Ld9
        Lc6:
            java.lang.String r0 = "resetToken"
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r2 != 0) goto Ld5
            com.umeng.umzid.d.c(r11, r0)     // Catch: java.lang.Throwable -> Ld9
        Ld5:
            r10.a(r11)     // Catch: java.lang.Throwable -> Ld9
            goto Ldd
        Ld9:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> Le0
        Ldd:
            r10.f54224a = r3
        Ldf:
            return r1
        Le0:
            r11 = move-exception
            r10.f54224a = r3
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(com.umeng.umzid.ZIDManager, android.content.Context):java.lang.String");
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences a4;
        SharedPreferences.Editor edit;
        String b4 = d.b(str);
        if (context == null || b4 == null || TextUtils.isEmpty(b4) || (a4 = com.umeng.umzid.a.a(context)) == null || (edit = a4.edit()) == null) {
            return;
        }
        edit.putString("inputDomain", b4).commit();
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f54223d == null) {
                f54223d = new ZIDManager();
            }
            zIDManager = f54223d;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.8.0";
    }

    public final void a(Context context) {
        Object invoke;
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            Method declaredMethod2 = cls.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(cls, new Object[0])) == null || (declaredMethod = cls.getDeclaredMethod("init", Context.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(invoke, context);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:14|(3:80|81|(27:83|17|(1:79)(2:21|(1:23))|24|(1:78)(2:28|(1:30))|31|32|(1:36)|37|(1:39)|40|41|42|43|44|45|46|47|48|(1:50)|51|(1:53)|54|(2:56|(6:58|(1:60)|61|(1:63)|64|(1:66)))|67|68|69))|16|17|(1:19)|79|24|(1:26)|78|31|32|(2:34|36)|37|(0)|40|41|42|43|44|45|46|47|48|(0)|51|(0)|54|(0)|67|68|69) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ef, code lost:
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f1, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f2, code lost:
        r11 = r6;
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f4, code lost:
        r11.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:18:0x0038, B:20:0x003e, B:22:0x0046, B:24:0x0056, B:26:0x005c, B:28:0x0068, B:30:0x006e, B:32:0x007e, B:34:0x0084, B:36:0x0090, B:38:0x0096, B:41:0x00b9, B:43:0x00bf, B:44:0x00c3, B:46:0x00c9, B:61:0x00f9, B:62:0x00fe, B:66:0x010b, B:68:0x012a, B:70:0x013f, B:72:0x0152, B:73:0x0155, B:75:0x015f, B:76:0x0162, B:78:0x016c, B:79:0x016f, B:59:0x00f4), top: B:85:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:18:0x0038, B:20:0x003e, B:22:0x0046, B:24:0x0056, B:26:0x005c, B:28:0x0068, B:30:0x006e, B:32:0x007e, B:34:0x0084, B:36:0x0090, B:38:0x0096, B:41:0x00b9, B:43:0x00bf, B:44:0x00c3, B:46:0x00c9, B:61:0x00f9, B:62:0x00fe, B:66:0x010b, B:68:0x012a, B:70:0x013f, B:72:0x0152, B:73:0x0155, B:75:0x015f, B:76:0x0162, B:78:0x016c, B:79:0x016f, B:59:0x00f4), top: B:85:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9 A[Catch: all -> 0x0172, TRY_ENTER, TryCatch #1 {all -> 0x0172, blocks: (B:18:0x0038, B:20:0x003e, B:22:0x0046, B:24:0x0056, B:26:0x005c, B:28:0x0068, B:30:0x006e, B:32:0x007e, B:34:0x0084, B:36:0x0090, B:38:0x0096, B:41:0x00b9, B:43:0x00bf, B:44:0x00c3, B:46:0x00c9, B:61:0x00f9, B:62:0x00fe, B:66:0x010b, B:68:0x012a, B:70:0x013f, B:72:0x0152, B:73:0x0155, B:75:0x015f, B:76:0x0162, B:78:0x016c, B:79:0x016f, B:59:0x00f4), top: B:85:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9 A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #1 {all -> 0x0172, blocks: (B:18:0x0038, B:20:0x003e, B:22:0x0046, B:24:0x0056, B:26:0x005c, B:28:0x0068, B:30:0x006e, B:32:0x007e, B:34:0x0084, B:36:0x0090, B:38:0x0096, B:41:0x00b9, B:43:0x00bf, B:44:0x00c3, B:46:0x00c9, B:61:0x00f9, B:62:0x00fe, B:66:0x010b, B:68:0x012a, B:70:0x013f, B:72:0x0152, B:73:0x0155, B:75:0x015f, B:76:0x0162, B:78:0x016c, B:79:0x016f, B:59:0x00f4), top: B:85:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f9 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:18:0x0038, B:20:0x003e, B:22:0x0046, B:24:0x0056, B:26:0x005c, B:28:0x0068, B:30:0x006e, B:32:0x007e, B:34:0x0084, B:36:0x0090, B:38:0x0096, B:41:0x00b9, B:43:0x00bf, B:44:0x00c3, B:46:0x00c9, B:61:0x00f9, B:62:0x00fe, B:66:0x010b, B:68:0x012a, B:70:0x013f, B:72:0x0152, B:73:0x0155, B:75:0x015f, B:76:0x0162, B:78:0x016c, B:79:0x016f, B:59:0x00f4), top: B:85:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012a A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:18:0x0038, B:20:0x003e, B:22:0x0046, B:24:0x0056, B:26:0x005c, B:28:0x0068, B:30:0x006e, B:32:0x007e, B:34:0x0084, B:36:0x0090, B:38:0x0096, B:41:0x00b9, B:43:0x00bf, B:44:0x00c3, B:46:0x00c9, B:61:0x00f9, B:62:0x00fe, B:66:0x010b, B:68:0x012a, B:70:0x013f, B:72:0x0152, B:73:0x0155, B:75:0x015f, B:76:0x0162, B:78:0x016c, B:79:0x016f, B:59:0x00f4), top: B:85:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.b(android.content.Context):java.lang.String");
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String d4 = d.d(origApplicationContext);
        if (TextUtils.isEmpty(d4)) {
            com.umeng.umzid.c.a(new c(origApplicationContext));
            return "";
        }
        return d4;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[Catch: all -> 0x00aa, TryCatch #1 {, blocks: (B:3:0x0001, B:9:0x000f, B:12:0x0018, B:15:0x0020, B:18:0x0029, B:21:0x0035, B:23:0x003b, B:25:0x0041, B:27:0x0047, B:28:0x0050, B:30:0x0056, B:33:0x005d, B:35:0x0067, B:37:0x0073, B:39:0x007b, B:40:0x0083, B:42:0x0089, B:47:0x009b, B:36:0x006b), top: B:55:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0089 A[Catch: all -> 0x00aa, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:9:0x000f, B:12:0x0018, B:15:0x0020, B:18:0x0029, B:21:0x0035, B:23:0x003b, B:25:0x0041, B:27:0x0047, B:28:0x0050, B:30:0x0056, B:33:0x005d, B:35:0x0067, B:37:0x0073, B:39:0x007b, B:40:0x0083, B:42:0x0089, B:47:0x009b, B:36:0x006b), top: B:55:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r4, java.lang.String r5, com.umeng.umzid.IZIDCompletionCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.umeng.umzid.d.h(r4)     // Catch: java.lang.Throwable -> Laa
            r3.f54226c = r0     // Catch: java.lang.Throwable -> Laa
            if (r0 != 0) goto Lb
            monitor-exit(r3)
            return
        Lb:
            if (r4 != 0) goto L18
            if (r6 == 0) goto L16
            java.lang.String r4 = "1001"
            java.lang.String r5 = "\u4f20\u5165\u53c2\u6570Context\u4e3anull"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> Laa
        L16:
            monitor-exit(r3)
            return
        L18:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Laa
            if (r0 == 0) goto L29
            if (r6 == 0) goto L27
            java.lang.String r4 = "1003"
            java.lang.String r5 = "\u4f20\u5165\u53c2\u6570appkey\u4e3a\u7a7a"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> Laa
        L27:
            monitor-exit(r3)
            return
        L29:
            android.content.Context r0 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> Laa
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)     // Catch: java.lang.Throwable -> Laa
            if (r0 == 0) goto L50
            if (r5 == 0) goto L50
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Laa
            if (r1 != 0) goto L50
            android.content.SharedPreferences r1 = com.umeng.umzid.a.a(r0)     // Catch: java.lang.Throwable -> Laa
            if (r1 == 0) goto L50
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> Laa
            if (r1 == 0) goto L50
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch: java.lang.Throwable -> Laa
            r5.commit()     // Catch: java.lang.Throwable -> Laa
        L50:
            java.lang.String r5 = com.umeng.umzid.d.d(r0)     // Catch: java.lang.Throwable -> Laa
            if (r5 == 0) goto L6b
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Laa
            if (r1 == 0) goto L5d
            goto L6b
        L5d:
            com.umeng.umzid.ZIDManager$b r1 = new com.umeng.umzid.ZIDManager$b     // Catch: java.lang.Throwable -> Laa
            r1.<init>(r0)     // Catch: java.lang.Throwable -> Laa
            com.umeng.umzid.c.a(r1)     // Catch: java.lang.Throwable -> Laa
            if (r6 == 0) goto L73
            r6.onSuccess(r5)     // Catch: java.lang.Throwable -> Laa
            goto L73
        L6b:
            com.umeng.umzid.ZIDManager$a r5 = new com.umeng.umzid.ZIDManager$a     // Catch: java.lang.Throwable -> Laa
            r5.<init>(r0, r6)     // Catch: java.lang.Throwable -> Laa
            com.umeng.umzid.c.a(r5)     // Catch: java.lang.Throwable -> Laa
        L73:
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> Laa
            if (r6 == 0) goto L83
            java.lang.String r5 = "uuid"
            java.lang.String r0 = ""
            java.lang.String r5 = r6.getString(r5, r0)     // Catch: java.lang.Throwable -> Laa
        L83:
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Laa
            if (r5 == 0) goto La8
            java.lang.String r5 = ""
            android.content.SharedPreferences r4 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> Laa
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L98
            goto L99
        L98:
        L99:
            if (r4 == 0) goto La8
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r6 = "uuid"
            android.content.SharedPreferences$Editor r4 = r4.putString(r6, r5)     // Catch: java.lang.Throwable -> Laa
            r4.commit()     // Catch: java.lang.Throwable -> Laa
        La8:
            monitor-exit(r3)
            return
        Laa:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:1|(5:88|89|(2:96|97)|91|(37:93|4|5|6|7|8|(2:10|(30:14|15|16|17|18|19|(3:69|70|(5:72|73|(2:76|74)|77|78))|21|(1:23)(1:68)|24|(1:26)(1:67)|27|28|29|30|31|32|33|34|35|36|(1:40)|41|42|43|44|45|(2:47|(2:51|52))|54|55))|86|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(2:38|40)|41|42|43|44|45|(0)|54|55))|3|4|5|6|7|8|(0)|86|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(0)|41|42|43|44|45|(0)|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x012f, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0130, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0152, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0153, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x016b, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016c, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[Catch: all -> 0x0087, TryCatch #4 {all -> 0x0087, blocks: (B:16:0x0061, B:18:0x0067, B:20:0x0073, B:22:0x0080, B:24:0x0084), top: B:95:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019a A[Catch: all -> 0x01ae, TryCatch #8 {all -> 0x01ae, blocks: (B:72:0x0188, B:74:0x018e, B:76:0x019a, B:78:0x01a7, B:80:0x01ab), top: B:103:0x0188 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject a(android.content.Context r10, org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }
}
