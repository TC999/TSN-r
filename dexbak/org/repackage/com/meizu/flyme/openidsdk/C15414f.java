package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* renamed from: org.repackage.com.meizu.flyme.openidsdk.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C15414f {

    /* renamed from: g */
    private static volatile C15414f f44180g;

    /* renamed from: h */
    private static boolean f44181h;

    /* renamed from: f */
    private BroadcastReceiver f44187f;

    /* renamed from: a */
    C15409a f44182a = new C15409a("udid");

    /* renamed from: b */
    C15409a f44183b = new C15409a("oaid");

    /* renamed from: d */
    C15409a f44185d = new C15409a("vaid");

    /* renamed from: c */
    C15409a f44184c = new C15409a("aaid");

    /* renamed from: e */
    private C15411c f44186e = new C15411c();

    private C15414f() {
    }

    /* renamed from: b */
    private static String m2775b(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    /* renamed from: c */
    private static C15412d m2774c(Cursor cursor) {
        String str;
        C15412d c15412d = new C15412d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE);
            if (columnIndex >= 0) {
                c15412d.f44177a = cursor.getString(columnIndex);
            } else {
                m2772e("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                c15412d.f44178b = cursor.getInt(columnIndex2);
            } else {
                m2772e("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                c15412d.f44179c = cursor.getLong(columnIndex3);
            } else {
                m2772e("parseExpired fail, index < 0.");
            }
            return c15412d;
        } else {
            str = "parseValue fail, cursor is closed.";
        }
        m2772e(str);
        return c15412d;
    }

    /* renamed from: d */
    public static final C15414f m2773d() {
        if (f44180g == null) {
            synchronized (C15414f.class) {
                if (f44180g == null) {
                    f44180g = new C15414f();
                }
            }
        }
        return f44180g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static void m2772e(String str) {
        if (f44181h) {
            Log.d("OpenIdManager", str);
        }
    }

    /* renamed from: f */
    public static void m2771f(boolean z) {
        f44181h = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r7 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
        if ("0".equals(r1.f44177a) != false) goto L13;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m2770g(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            m2772e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r3 = 0
            r4 = 0
            r8 = 1
            java.lang.String[] r5 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r6 = "supported"
            r5[r0] = r6     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r7 == 0) goto L3a
            org.repackage.com.meizu.flyme.openidsdk.d r1 = m2774c(r7)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = r1.f44178b     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r2 != r3) goto L35
            java.lang.String r2 = "0"
            java.lang.String r1 = r1.f44177a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r1 == 0) goto L36
        L35:
            r0 = 1
        L36:
            r7.close()
            return r0
        L3a:
            if (r7 == 0) goto L5b
        L3c:
            r7.close()
            goto L5b
        L40:
            r8 = move-exception
            goto L5c
        L42:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L40
            r1.append(r8)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L40
            m2772e(r8)     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L5b
            goto L3c
        L5b:
            return r0
        L5c:
            if (r7 == 0) goto L61
            r7.close()
        L61:
            goto L63
        L62:
            throw r8
        L63:
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.C15414f.m2770g(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m2768i(android.content.Context r10, org.repackage.com.meizu.flyme.openidsdk.C15409a r11) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.f44171c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            m2772e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r6 = r11.f44171c     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 == 0) goto L7e
            org.repackage.com.meizu.flyme.openidsdk.d r2 = m2774c(r1)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r0 = r2.f44177a     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.m2790c(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            long r3 = r2.f44179c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.m2791b(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r3 = r2.f44178b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.m2792a(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r4 = r11.f44171c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.append(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r11 = r11.f44172d     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.append(r11)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            m2772e(r11)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r11 = r2.f44178b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L93
            r9.m2766k(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            boolean r11 = r9.m2769h(r10, r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            if (r11 != 0) goto L93
            boolean r10 = r9.m2769h(r10, r7)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
        L7a:
            m2772e(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            goto L93
        L7e:
            boolean r11 = r9.m2769h(r10, r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            if (r11 == 0) goto L93
            boolean r10 = r9.m2769h(r10, r7)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            goto L7a
        L93:
            if (r1 == 0) goto Lbf
            r1.close()
            goto Lbf
        L99:
            r10 = move-exception
            r0 = r1
            goto Lc0
        L9c:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto La4
        La0:
            r10 = move-exception
            goto Lc0
        La2:
            r10 = move-exception
            r11 = r0
        La4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> La0
            r1.append(r10)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> La0
            m2772e(r10)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto Lbe
            r0.close()
        Lbe:
            r0 = r11
        Lbf:
            return r0
        Lc0:
            if (r0 == 0) goto Lc5
            r0.close()
        Lc5:
            goto Lc7
        Lc6:
            throw r10
        Lc7:
            goto Lc6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.C15414f.m2768i(android.content.Context, org.repackage.com.meizu.flyme.openidsdk.a):java.lang.String");
    }

    /* renamed from: j */
    private static String m2767j(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            m2772e("getAppVersion, Exception : " + e.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    private synchronized void m2766k(Context context) {
        if (this.f44187f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        C15413e c15413e = new C15413e();
        this.f44187f = c15413e;
        context.registerReceiver(c15413e, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final String m2776a(Context context, C15409a c15409a) {
        String str;
        if (c15409a == null) {
            str = "getId, openId = null.";
        } else if (c15409a.m2789d()) {
            return c15409a.f44170b;
        } else {
            if (m2769h(context, true)) {
                return m2768i(context, c15409a);
            }
            str = "getId, isSupported = false.";
        }
        m2772e(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final boolean m2769h(Context context, boolean z) {
        if (!this.f44186e.m2780b() || z) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String m2775b = m2775b(packageManager, "com.meizu.flyme.openidsdk");
            if (TextUtils.isEmpty(m2775b)) {
                return false;
            }
            String m2767j = m2767j(packageManager, m2775b);
            if (this.f44186e.m2780b() && this.f44186e.m2779c(m2767j)) {
                m2772e("use same version cache, safeVersion : ".concat(String.valueOf(m2767j)));
                return this.f44186e.m2777e();
            }
            this.f44186e.m2778d(m2767j);
            boolean m2770g = m2770g(context);
            m2772e("query support, result : ".concat(String.valueOf(m2770g)));
            this.f44186e.m2781a(m2770g);
            return m2770g;
        }
        return this.f44186e.m2777e();
    }
}
