package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final long f51298a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    private static u f51299b;

    /* renamed from: c  reason: collision with root package name */
    private Context f51300c;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f51303f;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, Map<String, t>> f51302e = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f51301d = aa.b().f50825d;

    private u(Context context) {
        this.f51300c = context;
        this.f51303f = context.getSharedPreferences("crashrecord", 0);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T d(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            android.content.Context r3 = r5.f51300c     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
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
            com.tencent.bugly.proguard.al.a(r2, r3)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L5d
        L3e:
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            goto L5d
        L42:
            r6 = r0
        L43:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.proguard.al.a(r2, r3)     // Catch: java.lang.Throwable -> L4d
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
            com.tencent.bugly.proguard.al.e(r6, r1)     // Catch: java.lang.Throwable -> L54
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.d(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean c(int i4) {
        try {
            List<t> d4 = d(i4);
            if (d4 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (t tVar : d4) {
                String str = tVar.f51292b;
                if (str != null && str.equalsIgnoreCase(this.f51301d) && tVar.f51294d > 0) {
                    arrayList.add(tVar);
                }
                if (tVar.f51293c + 86400000 < currentTimeMillis) {
                    arrayList2.add(tVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((t) arrayList.get(arrayList.size() - 1)).f51293c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                d4.clear();
                a(i4, (int) d4);
                return false;
            }
            d4.removeAll(arrayList2);
            a(i4, (int) d4);
            return false;
        } catch (Exception unused) {
            al.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final synchronized boolean b(final int i4) {
        boolean z3;
        z3 = true;
        try {
            SharedPreferences sharedPreferences = this.f51303f;
            z3 = sharedPreferences.getBoolean(i4 + "_" + this.f51301d, true);
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.u.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean c4 = u.this.c(i4);
                    SharedPreferences.Editor edit = u.this.f51303f.edit();
                    edit.putBoolean(i4 + "_" + u.this.f51301d, !c4).commit();
                }
            });
        } catch (Exception unused) {
            al.e("canInit error", new Object[0]);
            return z3;
        }
        return z3;
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (f51299b == null) {
                f51299b = new u(context);
            }
            uVar = f51299b;
        }
        return uVar;
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = f51299b;
        }
        return uVar;
    }

    static /* synthetic */ boolean b(t tVar, t tVar2) {
        String str = tVar.f51295e;
        if (str == null || str.equalsIgnoreCase(tVar2.f51295e)) {
            String str2 = tVar.f51296f;
            return !(str2 == null || str2.equalsIgnoreCase(tVar2.f51296f)) || tVar.f51294d <= 0;
        }
        return true;
    }

    public final void a(final int i4) {
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.u.1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f51304a = 1004;

            @Override // java.lang.Runnable
            public final void run() {
                t tVar;
                try {
                    if (TextUtils.isEmpty(u.this.f51301d)) {
                        return;
                    }
                    List<t> d4 = u.this.d(this.f51304a);
                    if (d4 == null) {
                        d4 = new ArrayList();
                    }
                    if (u.this.f51302e.get(Integer.valueOf(this.f51304a)) == null) {
                        u.this.f51302e.put(Integer.valueOf(this.f51304a), new HashMap());
                    }
                    if (((Map) u.this.f51302e.get(Integer.valueOf(this.f51304a))).get(u.this.f51301d) != null) {
                        tVar = (t) ((Map) u.this.f51302e.get(Integer.valueOf(this.f51304a))).get(u.this.f51301d);
                        tVar.f51294d = i4;
                    } else {
                        tVar = new t();
                        tVar.f51291a = this.f51304a;
                        tVar.f51297g = u.f51298a;
                        tVar.f51292b = u.this.f51301d;
                        tVar.f51296f = aa.b().f50836o;
                        tVar.f51295e = aa.b().f50829h;
                        tVar.f51293c = System.currentTimeMillis();
                        tVar.f51294d = i4;
                        ((Map) u.this.f51302e.get(Integer.valueOf(this.f51304a))).put(u.this.f51301d, tVar);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z3 = false;
                    for (t tVar2 : d4) {
                        if (u.a(tVar2, tVar)) {
                            z3 = true;
                            tVar2.f51294d = tVar.f51294d;
                        }
                        if (u.b(tVar2, tVar)) {
                            arrayList.add(tVar2);
                        }
                    }
                    d4.removeAll(arrayList);
                    if (!z3) {
                        d4.add(tVar);
                    }
                    u.this.a(this.f51304a, (int) d4);
                } catch (Exception unused) {
                    al.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049 A[Catch: all -> 0x004d, Exception -> 0x004f, TRY_ENTER, TryCatch #1 {Exception -> 0x004f, blocks: (B:7:0x0006, B:11:0x0025, B:22:0x003f, B:29:0x0049, B:30:0x004c), top: B:40:0x0006, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            android.content.Context r2 = r4.f51300c     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
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
            com.tencent.bugly.proguard.al.a(r5, r6)     // Catch: java.lang.Throwable -> L46
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
            com.tencent.bugly.proguard.al.e(r5, r6)     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r4)
            return
        L58:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.a(int, java.util.List):void");
    }

    static /* synthetic */ boolean a(t tVar, t tVar2) {
        String str;
        return tVar.f51297g == tVar2.f51297g && (str = tVar.f51292b) != null && str.equalsIgnoreCase(tVar2.f51292b);
    }
}
