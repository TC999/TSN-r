package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.u */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12916u {

    /* renamed from: a */
    public static final long f36932a = System.currentTimeMillis();

    /* renamed from: b */
    private static C12916u f36933b;

    /* renamed from: c */
    private Context f36934c;

    /* renamed from: f */
    private SharedPreferences f36937f;

    /* renamed from: e */
    private Map<Integer, Map<String, C12915t>> f36936e = new HashMap();

    /* renamed from: d */
    private String f36935d = C12786aa.m16005b().f36451d;

    private C12916u(Context context) {
        this.f36934c = context;
        this.f36937f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r6 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r6 == null) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T m15510d(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            android.content.Context r3 = r5.f36934c     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            if (r6 != 0) goto L1c
            monitor-exit(r5)
            return r0
        L1c:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L35 java.io.IOException -> L43 java.lang.Throwable -> L4d
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L35 java.io.IOException -> L43 java.lang.Throwable -> L4d
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            monitor-exit(r5)
            return r2
        L31:
            r2 = move-exception
            r6 = r0
            goto L4e
        L34:
            r6 = r0
        L35:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.proguard.C12820al.m15878a(r2, r3)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L5d
        L3e:
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            goto L5d
        L42:
            r6 = r0
        L43:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.proguard.C12820al.m15878a(r2, r3)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L5d
            goto L3e
        L4d:
            r2 = move-exception
        L4e:
            if (r6 == 0) goto L53
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L53:
            throw r2     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L54:
            r6 = move-exception
            goto L5f
        L56:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L54
            com.tencent.bugly.proguard.C12820al.m15872e(r6, r1)     // Catch: java.lang.Throwable -> L54
        L5d:
            monitor-exit(r5)
            return r0
        L5f:
            monitor-exit(r5)
            goto L62
        L61:
            throw r6
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12916u.m15510d(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized boolean m15512c(int i) {
        try {
            List<C12915t> m15510d = m15510d(i);
            if (m15510d == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (C12915t c12915t : m15510d) {
                String str = c12915t.f36926b;
                if (str != null && str.equalsIgnoreCase(this.f36935d) && c12915t.f36928d > 0) {
                    arrayList.add(c12915t);
                }
                if (c12915t.f36927c + 86400000 < currentTimeMillis) {
                    arrayList2.add(c12915t);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((C12915t) arrayList.get(arrayList.size() - 1)).f36927c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                m15510d.clear();
                m15522a(i, (int) m15510d);
                return false;
            }
            m15510d.removeAll(arrayList2);
            m15522a(i, (int) m15510d);
            return false;
        } catch (Exception unused) {
            C12820al.m15872e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    /* renamed from: b */
    public final synchronized boolean m15516b(final int i) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f36937f;
            z = sharedPreferences.getBoolean(i + "_" + this.f36935d, true);
            C12818ak.m15887a().m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.u.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean m15512c = C12916u.this.m15512c(i);
                    SharedPreferences.Editor edit = C12916u.this.f36937f.edit();
                    edit.putBoolean(i + "_" + C12916u.this.f36935d, !m15512c).commit();
                }
            });
        } catch (Exception unused) {
            C12820al.m15872e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }

    /* renamed from: a */
    public static synchronized C12916u m15521a(Context context) {
        C12916u c12916u;
        synchronized (C12916u.class) {
            if (f36933b == null) {
                f36933b = new C12916u(context);
            }
            c12916u = f36933b;
        }
        return c12916u;
    }

    /* renamed from: a */
    public static synchronized C12916u m15524a() {
        C12916u c12916u;
        synchronized (C12916u.class) {
            c12916u = f36933b;
        }
        return c12916u;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m15515b(C12915t c12915t, C12915t c12915t2) {
        String str = c12915t.f36929e;
        if (str == null || str.equalsIgnoreCase(c12915t2.f36929e)) {
            String str2 = c12915t.f36930f;
            return !(str2 == null || str2.equalsIgnoreCase(c12915t2.f36930f)) || c12915t.f36928d <= 0;
        }
        return true;
    }

    /* renamed from: a */
    public final void m15523a(final int i) {
        C12818ak.m15887a().m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.u.1

            /* renamed from: a */
            final /* synthetic */ int f36938a = 1004;

            @Override // java.lang.Runnable
            public final void run() {
                C12915t c12915t;
                try {
                    if (TextUtils.isEmpty(C12916u.this.f36935d)) {
                        return;
                    }
                    List<C12915t> m15510d = C12916u.this.m15510d(this.f36938a);
                    if (m15510d == null) {
                        m15510d = new ArrayList();
                    }
                    if (C12916u.this.f36936e.get(Integer.valueOf(this.f36938a)) == null) {
                        C12916u.this.f36936e.put(Integer.valueOf(this.f36938a), new HashMap());
                    }
                    if (((Map) C12916u.this.f36936e.get(Integer.valueOf(this.f36938a))).get(C12916u.this.f36935d) != null) {
                        c12915t = (C12915t) ((Map) C12916u.this.f36936e.get(Integer.valueOf(this.f36938a))).get(C12916u.this.f36935d);
                        c12915t.f36928d = i;
                    } else {
                        c12915t = new C12915t();
                        c12915t.f36925a = this.f36938a;
                        c12915t.f36931g = C12916u.f36932a;
                        c12915t.f36926b = C12916u.this.f36935d;
                        c12915t.f36930f = C12786aa.m16005b().f36462o;
                        c12915t.f36929e = C12786aa.m16005b().f36455h;
                        c12915t.f36927c = System.currentTimeMillis();
                        c12915t.f36928d = i;
                        ((Map) C12916u.this.f36936e.get(Integer.valueOf(this.f36938a))).put(C12916u.this.f36935d, c12915t);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (C12915t c12915t2 : m15510d) {
                        if (C12916u.m15520a(c12915t2, c12915t)) {
                            z = true;
                            c12915t2.f36928d = c12915t.f36928d;
                        }
                        if (C12916u.m15515b(c12915t2, c12915t)) {
                            arrayList.add(c12915t2);
                        }
                    }
                    m15510d.removeAll(arrayList);
                    if (!z) {
                        m15510d.add(c12915t);
                    }
                    C12916u.this.m15522a(this.f36938a, (int) m15510d);
                } catch (Exception unused) {
                    C12820al.m15872e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049 A[Catch: all -> 0x004d, Exception -> 0x004f, TRY_ENTER, TryCatch #1 {Exception -> 0x004f, blocks: (B:7:0x0006, B:11:0x0025, B:22:0x003f, B:29:0x0049, B:30:0x004c), top: B:40:0x0006, outer: #5 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> void m15522a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            android.content.Context r2 = r4.f36934c     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30
            r2.writeObject(r6)     // Catch: java.io.IOException -> L2a java.lang.Throwable -> L46
            r2.close()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            monitor-exit(r4)
            return
        L2a:
            r5 = move-exception
            goto L33
        L2c:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L47
        L30:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L33:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L46
            com.tencent.bugly.proguard.C12820al.m15878a(r5, r6)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L44
            r2.close()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            monitor-exit(r4)
            return
        L44:
            monitor-exit(r4)
            return
        L46:
            r5 = move-exception
        L47:
            if (r2 == 0) goto L4c
            r2.close()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
        L4c:
            throw r5     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
        L4d:
            r5 = move-exception
            goto L58
        L4f:
            java.lang.String r5 = "writeCrashRecord error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.proguard.C12820al.m15872e(r5, r6)     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r4)
            return
        L58:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12916u.m15522a(int, java.util.List):void");
    }

    /* renamed from: a */
    static /* synthetic */ boolean m15520a(C12915t c12915t, C12915t c12915t2) {
        String str;
        return c12915t.f36931g == c12915t2.f36931g && (str = c12915t.f36926b) != null && str.equalsIgnoreCase(c12915t2.f36926b);
    }
}
