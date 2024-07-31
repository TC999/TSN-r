package p000XI.p008xo.p009XI.p010XI;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* renamed from: XI.xo.XI.XI.CA */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C0018CA {

    /* renamed from: J9 */
    public static volatile C0018CA f35J9;

    /* renamed from: vs */
    public BroadcastReceiver f40vs;

    /* renamed from: XI */
    public C0020XI f38XI = new C0020XI("udid");

    /* renamed from: K0 */
    public C0020XI f37K0 = new C0020XI("oaid");

    /* renamed from: xo */
    public C0020XI f41xo = new C0020XI("vaid");

    /* renamed from: kM */
    public C0020XI f39kM = new C0020XI("aaid");

    /* renamed from: CA */
    public C0019K0 f36CA = new C0019K0();

    /* renamed from: XI */
    public static final C0018CA m60060XI() {
        if (f35J9 == null) {
            synchronized (C0018CA.class) {
                if (f35J9 == null) {
                    f35J9 = new C0018CA();
                }
            }
        }
        return f35J9;
    }

    /* renamed from: XI */
    public static C0021kM m60056XI(Cursor cursor) {
        C0021kM c0021kM = new C0021kM(null, 0);
        if (cursor.isClosed()) {
            return c0021kM;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE);
        if (columnIndex >= 0) {
            c0021kM.f49XI = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            c0021kM.f48K0 = cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            c0021kM.f50kM = cursor.getLong(columnIndex3);
        }
        return c0021kM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* renamed from: XI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m60058XI(android.content.Context r14, p000XI.p008xo.p009XI.p010XI.C0020XI r15) {
        /*
            r13 = this;
            r0 = 0
            if (r15 != 0) goto L4
            return r0
        L4:
            long r1 = r15.f45XI
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 0
            r6 = 1
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L12
            r1 = 1
            goto L13
        L12:
            r1 = 0
        L13:
            if (r1 == 0) goto L18
            java.lang.String r14 = r15.f44K0
            return r14
        L18:
            boolean r1 = r13.m60057XI(r14, r6)
            if (r1 != 0) goto L1f
            return r0
        L1f:
            java.lang.String r1 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r8 = android.net.Uri.parse(r1)
            android.content.ContentResolver r7 = r14.getContentResolver()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            r9 = 0
            r10 = 0
            java.lang.String[] r11 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            java.lang.String r1 = r15.f46kM     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            r11[r5] = r1     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            r12 = 0
            android.database.Cursor r1 = r7.query(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            if (r1 == 0) goto L66
            XI.xo.XI.XI.kM r2 = m60056XI(r1)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r0 = r2.f49XI     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.f44K0 = r0     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            long r3 = r2.f50kM     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.f45XI = r3     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            int r3 = r2.f48K0     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.f47xo = r3     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            int r15 = r2.f48K0     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r15 == r2) goto L7b
            r13.m60059XI(r14)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            boolean r15 = r13.m60057XI(r14, r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            if (r15 != 0) goto L7b
            boolean r14 = r13.m60057XI(r14, r6)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.<init>()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r2 = "not support, forceQuery isSupported: "
        L62:
            r15.append(r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            goto L78
        L66:
            boolean r15 = r13.m60057XI(r14, r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            if (r15 == 0) goto L7b
            boolean r14 = r13.m60057XI(r14, r6)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.<init>()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r2 = "forceQuery isSupported : "
            goto L62
        L78:
            r15.append(r14)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
        L7b:
            if (r1 == 0) goto L95
            goto L90
        L7e:
            r14 = move-exception
            r0 = r1
            goto L96
        L81:
            r14 = move-exception
            r15 = r0
            r0 = r1
            goto L89
        L85:
            r14 = move-exception
            goto L96
        L87:
            r14 = move-exception
            r15 = r0
        L89:
            r14.getMessage()     // Catch: java.lang.Throwable -> L85
            if (r0 == 0) goto L94
            r1 = r0
            r0 = r15
        L90:
            r1.close()
            goto L95
        L94:
            r0 = r15
        L95:
            return r0
        L96:
            if (r0 == 0) goto L9b
            r0.close()
        L9b:
            goto L9d
        L9c:
            throw r14
        L9d:
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: p000XI.p008xo.p009XI.p010XI.C0018CA.m60058XI(android.content.Context, XI.xo.XI.XI.XI):java.lang.String");
    }

    /* renamed from: XI */
    public final synchronized void m60059XI(Context context) {
        if (this.f40vs != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        C0022xo c0022xo = new C0022xo();
        this.f40vs = c0022xo;
        context.registerReceiver(c0022xo, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ad, code lost:
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b6, code lost:
        if (r1 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b8, code lost:
        r1.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ca  */
    /* renamed from: XI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m60057XI(android.content.Context r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000XI.p008xo.p009XI.p010XI.C0018CA.m60057XI(android.content.Context, boolean):boolean");
    }
}
