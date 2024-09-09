package com.baidu.liantian.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0003l.f4;
import com.baidu.liantian.b;
import com.baidu.liantian.b.a;
import com.baidu.liantian.b.e;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.d;
import com.baidu.liantian.core.g;
import com.baidu.liantian.core.h;
import com.baidu.liantian.jni.Asc;
import com.stub.StubApp;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class F implements FI {
    private static F instance;
    private static Asc sAsc;

    private F() {
    }

    public static synchronized F getInstance() {
        F f4;
        synchronized (F.class) {
            if (instance == null) {
                instance = new F();
            }
            f4 = instance;
        }
        return f4;
    }

    @Override // com.baidu.liantian.ac.FI
    public byte[] ad(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    e.f("3");
                    byte[] a4 = a.a(bArr2, bArr, true);
                    if (a4 == null || a4.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.f("4");
                        byte[] dc = sAsc.dc(bArr, bArr2);
                        if (dc == null || dc.length == 0) {
                            e.f("5");
                        }
                        return dc;
                    }
                    return a4;
                }
            } catch (Throwable unused) {
                e.a();
            }
        }
        return null;
    }

    @Override // com.baidu.liantian.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    e.f("0");
                    byte[] a4 = a.a(bArr2, bArr);
                    if (a4 == null || a4.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.f("1");
                        byte[] ac = sAsc.ac(bArr, bArr2);
                        if (ac == null || ac.length == 0) {
                            e.f("2");
                        }
                        return ac;
                    }
                    return a4;
                }
            } catch (Throwable unused) {
                e.a();
            }
        }
        return null;
    }

    @Override // com.baidu.liantian.ac.FI
    public boolean chh(Context context, String str) {
        try {
            return e.a(context, str);
        } catch (Throwable unused) {
            e.a();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
        r8.onEnd(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
        return;
     */
    @Override // com.baidu.liantian.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cm(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.baidu.liantian.ac.Callback r8, java.lang.Class<?>[] r9, java.lang.Object... r10) {
        /*
            r4 = this;
            com.amap.api.col.p0003l.f4.a(r8)     // Catch: java.lang.Throwable -> L88
            com.baidu.liantian.b.a()     // Catch: java.lang.Throwable -> L88
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L88
            r1 = 0
            if (r0 != 0) goto L80
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L88
            if (r0 != 0) goto L80
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L88
            if (r0 == 0) goto L1a
            goto L80
        L1a:
            com.baidu.liantian.core.g r0 = com.baidu.liantian.core.g.a()     // Catch: java.lang.Throwable -> L88
            if (r0 != 0) goto L28
            if (r8 == 0) goto L27
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L88
            r8.onEnd(r5)     // Catch: java.lang.Throwable -> L88
        L27:
            return
        L28:
            com.baidu.liantian.core.ApkInfo r6 = r0.d(r6)     // Catch: java.lang.Throwable -> L88
            com.baidu.liantian.core.ApkInfo r5 = r0.d(r5)     // Catch: java.lang.Throwable -> L88
            if (r5 == 0) goto L78
            if (r6 != 0) goto L35
            goto L78
        L35:
            java.lang.ClassLoader r5 = r6.classLoader     // Catch: java.lang.Throwable -> L69
            com.baidu.liantian.core.f r5 = (com.baidu.liantian.core.f) r5     // Catch: java.lang.Throwable -> L69
            java.lang.String r6 = "com.baidu.liantian.engine.EngineImpl"
            java.lang.Class r5 = r5.a(r6)     // Catch: java.lang.Throwable -> L69
            java.lang.String r6 = "getInstance"
            r0 = 1
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L69
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r1] = r3     // Catch: java.lang.Throwable -> L69
            java.lang.reflect.Method r6 = r5.getDeclaredMethod(r6, r2)     // Catch: java.lang.Throwable -> L69
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L69
            r3 = 0
            r2[r1] = r3     // Catch: java.lang.Throwable -> L69
            java.lang.Object r5 = r6.invoke(r5, r2)     // Catch: java.lang.Throwable -> L69
            java.lang.Object r5 = com.baidu.liantian.b.e.a(r5, r7, r9, r10)     // Catch: java.lang.Throwable -> L69
            com.amap.api.col.p0003l.f4.a(r5)     // Catch: java.lang.Throwable -> L69
            com.baidu.liantian.b.a()     // Catch: java.lang.Throwable -> L69
            if (r8 == 0) goto L68
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L69
            r6[r1] = r5     // Catch: java.lang.Throwable -> L69
            r8.onEnd(r6)     // Catch: java.lang.Throwable -> L69
        L68:
            return
        L69:
            r5 = move-exception
            r5.getMessage()     // Catch: java.lang.Throwable -> L88
            com.baidu.liantian.b.b()     // Catch: java.lang.Throwable -> L88
            if (r8 == 0) goto L77
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L88
            r8.onEnd(r5)     // Catch: java.lang.Throwable -> L88
        L77:
            return
        L78:
            if (r8 == 0) goto L7f
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L88
            r8.onEnd(r5)     // Catch: java.lang.Throwable -> L88
        L7f:
            return
        L80:
            if (r8 == 0) goto L87
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L88
            r8.onEnd(r5)     // Catch: java.lang.Throwable -> L88
        L87:
            return
        L88:
            com.baidu.liantian.b.e.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.ac.F.cm(java.lang.String, java.lang.String, java.lang.String, com.baidu.liantian.ac.Callback, java.lang.Class[], java.lang.Object[]):void");
    }

    @Override // com.baidu.liantian.ac.FI
    public Pair<Integer, Object> cmsi(int i4, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            d a4 = d.a();
            if (a4 == null) {
                return new Pair<>(4, null);
            }
            return a4.a(i4, str, clsArr, objArr);
        } catch (Throwable unused) {
            e.a();
            return new Pair<>(3, null);
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public Map<Integer, String> gpd() {
        try {
            com.baidu.liantian.a.a aVar = com.baidu.liantian.a.a.f12102d;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public String gs(String str) {
        ApkInfo d4;
        try {
            g a4 = g.a();
            return (a4 == null || (d4 = a4.d(str)) == null) ? "" : d4.libPath;
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public String p(String str) {
        try {
            ApkInfo apkInfo = g.a().f12213a.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            f4.a(intentFilter);
            b.a();
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                g a4 = g.a();
                f4.a(a4);
                b.a();
                if (a4 != null) {
                    a4.a(new h(str, intentFilter, str2, str3));
                    intentFilter.hasAction("android.intent.action.BOOT_COMPLETED");
                    b.a();
                    if (intentFilter.hasAction("android.intent.action.BOOT_COMPLETED")) {
                        com.baidu.liantian.a.a aVar = com.baidu.liantian.a.a.f12102d;
                        f4.a(aVar);
                        b.a();
                        if (aVar != null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("r", (Integer) 1);
                            contentValues.put("b", str2);
                            contentValues.put("t", str3);
                            aVar.f12105c.update("tbchliantian", contentValues, "p=?", new String[]{str});
                        }
                    }
                }
            }
        } catch (Throwable unused) {
            e.a();
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a4 = com.baidu.liantian.b.h.a(bArr, bArr2);
                    if (a4 == null || a4.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        return sAsc.dr(bArr, bArr2);
                    }
                    return a4;
                }
            } catch (Throwable unused) {
                e.a();
            }
        }
        return null;
    }

    @Override // com.baidu.liantian.ac.FI
    public byte[] re(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    e.f("6");
                    byte[] a4 = com.baidu.liantian.b.h.a(bArr, bArr2);
                    if (a4 == null || a4.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.f("7");
                        byte[] ar = sAsc.ar(bArr, bArr2);
                        if (ar == null || ar.length == 0) {
                            e.f("8");
                        }
                        return ar;
                    }
                    return a4;
                }
            } catch (Throwable unused) {
                e.a();
            }
        }
        return null;
    }

    @Override // com.baidu.liantian.ac.FI
    public void rf(Context context) {
        try {
            new U(StubApp.getOrigApplicationContext(context.getApplicationContext()), 5, true).start();
        } catch (Throwable unused) {
            e.a();
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public void s(int i4, boolean z3) {
        try {
            com.baidu.liantian.a.a aVar = com.baidu.liantian.a.a.f12102d;
            if (aVar != null) {
                int i5 = z3 ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i5));
                SQLiteDatabase sQLiteDatabase = aVar.f12105c;
                sQLiteDatabase.update("tbchliantian", contentValues, "k=" + i4 + " and n=1", null);
            }
        } catch (Throwable unused) {
            e.a();
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public void sp(String str, boolean z3) {
        try {
            com.baidu.liantian.a.a aVar = com.baidu.liantian.a.a.f12102d;
            if (aVar != null) {
                int i4 = z3 ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i4));
                aVar.f12105c.update("tbchliantian", contentValues, "p=? and n=1", new String[]{str});
            }
        } catch (Throwable unused) {
            e.a();
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public void u(String str) {
        try {
            d.a().a(str);
        } catch (Throwable unused) {
            e.a();
        }
    }

    @Override // com.baidu.liantian.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        g a4;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (a4 = g.a()) == null) {
                return;
            }
            a4.b(new h(str, intentFilter, str2, str3));
        } catch (Throwable unused) {
            e.a();
        }
    }
}
