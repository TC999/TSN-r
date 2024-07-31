package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bd */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12870bd implements NativeExceptionHandler {

    /* renamed from: a */
    private final Context f36719a;

    /* renamed from: b */
    private final C12832as f36720b;

    /* renamed from: c */
    private final C12786aa f36721c;

    /* renamed from: d */
    private final C12803ac f36722d;

    public C12870bd(Context context, C12786aa c12786aa, C12832as c12832as, C12803ac c12803ac) {
        this.f36719a = context;
        this.f36720b = c12832as;
        this.f36721c = c12786aa;
        this.f36722d = c12803ac;
    }

    /* renamed from: a */
    private static Map<String, String> m15695a(String[] strArr) {
        HashMap hashMap = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                if (str != null) {
                    C12820al.m15878a("Extra message[%d]: %s", Integer.valueOf(i), str);
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        C12820al.m15873d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            C12820al.m15874c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean getAndUpdateAnrState() {
        if (C12859ay.m15719a() == null) {
            return false;
        }
        C12859ay m15719a = C12859ay.m15719a();
        if (m15719a.f36681a.get()) {
            C12820al.m15874c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = m15719a.f36682b;
        if (!((C12924z.m15477a(activityManager) || C12865az.m15700a(activityManager, 0L) == null) ? false : true)) {
            C12820al.m15874c("proc is not in anr, wait next check", new Object[0]);
            return false;
        } else if (m15719a.m15718a(System.currentTimeMillis())) {
            return false;
        } else {
            return m15719a.m15711a(true);
        }
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        C12820al.m15878a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009c A[Catch: all -> 0x0227, TryCatch #2 {all -> 0x0227, blocks: (B:4:0x0016, B:6:0x0036, B:8:0x0049, B:10:0x0051, B:12:0x005d, B:14:0x0069, B:17:0x0070, B:19:0x007c, B:21:0x009c, B:23:0x00cf, B:25:0x00f2, B:26:0x00f9, B:29:0x0105, B:31:0x010d, B:39:0x0155, B:40:0x0159, B:42:0x0163, B:22:0x00ba, B:18:0x007a), top: B:80:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba A[Catch: all -> 0x0227, TryCatch #2 {all -> 0x0227, blocks: (B:4:0x0016, B:6:0x0036, B:8:0x0049, B:10:0x0051, B:12:0x005d, B:14:0x0069, B:17:0x0070, B:19:0x007c, B:21:0x009c, B:23:0x00cf, B:25:0x00f2, B:26:0x00f9, B:29:0x0105, B:31:0x010d, B:39:0x0155, B:40:0x0159, B:42:0x0163, B:22:0x00ba, B:18:0x007a), top: B:80:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f2 A[Catch: all -> 0x0227, TryCatch #2 {all -> 0x0227, blocks: (B:4:0x0016, B:6:0x0036, B:8:0x0049, B:10:0x0051, B:12:0x005d, B:14:0x0069, B:17:0x0070, B:19:0x007c, B:21:0x009c, B:23:0x00cf, B:25:0x00f2, B:26:0x00f9, B:29:0x0105, B:31:0x010d, B:39:0x0155, B:40:0x0159, B:42:0x0163, B:22:0x00ba, B:18:0x007a), top: B:80:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a6 A[Catch: all -> 0x0223, TryCatch #1 {all -> 0x0223, blocks: (B:46:0x01a0, B:48:0x01a6, B:50:0x01af), top: B:79:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01af A[Catch: all -> 0x0223, TRY_LEAVE, TryCatch #1 {all -> 0x0223, blocks: (B:46:0x01a0, B:48:0x01a6, B:50:0x01af), top: B:79:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12870bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean m15741i = C12848at.m15755a().m15741i();
        if (m15741i) {
            C12820al.m15872e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f36342b = 1;
        crashDetailBean.f36345e = this.f36721c.m15994g();
        C12786aa c12786aa = this.f36721c;
        crashDetailBean.f36346f = c12786aa.f36462o;
        crashDetailBean.f36347g = c12786aa.m15983q();
        crashDetailBean.f36353m = this.f36721c.m15996f();
        crashDetailBean.f36354n = str3;
        crashDetailBean.f36355o = m15741i ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f36356p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.f36357q = str13;
        crashDetailBean.f36358r = j;
        crashDetailBean.f36361u = C12828ap.m15810c(str13.getBytes());
        crashDetailBean.f36314A = str;
        crashDetailBean.f36315B = str2;
        crashDetailBean.f36325L = this.f36721c.m15981s();
        crashDetailBean.f36348h = this.f36721c.m15984p();
        crashDetailBean.f36349i = this.f36721c.m16018A();
        crashDetailBean.f36362v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String m15689a = C12871be.m15689a(dumpFilePath, str8);
        if (!C12828ap.m15817b(m15689a)) {
            crashDetailBean.f36339Z = m15689a;
        }
        crashDetailBean.f36341aa = C12871be.m15685b(dumpFilePath);
        crashDetailBean.f36363w = C12871be.m15690a(str9, C12848at.f36615f, C12848at.f36620k, C12848at.f36625p);
        crashDetailBean.f36364x = C12871be.m15690a(str10, C12848at.f36615f, null, true);
        crashDetailBean.f36327N = str7;
        crashDetailBean.f36328O = str6;
        crashDetailBean.f36329P = str11;
        crashDetailBean.f36319F = this.f36721c.m15989k();
        crashDetailBean.f36320G = this.f36721c.m15990j();
        crashDetailBean.f36321H = this.f36721c.m15988l();
        crashDetailBean.f36322I = C12787ab.m15970b(this.f36719a);
        crashDetailBean.f36323J = C12787ab.m15964g();
        crashDetailBean.f36324K = C12787ab.m15963h();
        if (z) {
            crashDetailBean.f36316C = C12787ab.m15961j();
            crashDetailBean.f36317D = C12787ab.m15965f();
            crashDetailBean.f36318E = C12787ab.m15959l();
            crashDetailBean.f36365y = C12824ao.m15864a();
            C12786aa c12786aa2 = this.f36721c;
            crashDetailBean.f36330Q = c12786aa2.f36424a;
            crashDetailBean.f36331R = c12786aa2.m16011a();
            crashDetailBean.f36366z = C12828ap.m15826a(this.f36721c.f36415Q, C12848at.f36617h);
            int indexOf2 = crashDetailBean.f36357q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.f36357q.length()) {
                String str14 = crashDetailBean.f36357q;
                String substring = str14.substring(i, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f36366z.containsKey(crashDetailBean.f36315B) && (indexOf = (str12 = crashDetailBean.f36366z.get(crashDetailBean.f36315B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f36366z.put(crashDetailBean.f36315B, substring2);
                    crashDetailBean.f36357q = crashDetailBean.f36357q.substring(0, i);
                    crashDetailBean.f36357q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.f36314A = this.f36721c.f36451d;
            }
            crashDetailBean.f36334U = this.f36721c.m15974z();
            C12786aa c12786aa3 = this.f36721c;
            crashDetailBean.f36335V = c12786aa3.f36471x;
            crashDetailBean.f36336W = c12786aa3.m15980t();
            crashDetailBean.f36337X = this.f36721c.m15975y();
        } else {
            crashDetailBean.f36316C = -1L;
            crashDetailBean.f36317D = -1L;
            crashDetailBean.f36318E = -1L;
            if (crashDetailBean.f36363w == null) {
                crashDetailBean.f36363w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f36330Q = -1L;
            crashDetailBean.f36334U = -1;
            crashDetailBean.f36335V = -1;
            crashDetailBean.f36336W = map;
            crashDetailBean.f36337X = this.f36721c.m15975y();
            crashDetailBean.f36366z = null;
            if (str == null) {
                crashDetailBean.f36314A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f36365y = bArr;
            }
        }
        return crashDetailBean;
    }
}
