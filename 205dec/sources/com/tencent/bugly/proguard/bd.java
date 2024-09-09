package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bd implements NativeExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f51089a;

    /* renamed from: b  reason: collision with root package name */
    private final as f51090b;

    /* renamed from: c  reason: collision with root package name */
    private final aa f51091c;

    /* renamed from: d  reason: collision with root package name */
    private final ac f51092d;

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.f51089a = context;
        this.f51090b = asVar;
        this.f51091c = aaVar;
        this.f51092d = acVar;
    }

    private static Map<String, String> a(String[] strArr) {
        HashMap hashMap = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            for (int i4 = 0; i4 < strArr.length; i4++) {
                String str = strArr[i4];
                if (str != null) {
                    al.a("Extra message[%d]: %s", Integer.valueOf(i4), str);
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        al.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            al.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay a4 = ay.a();
        if (a4.f51051a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = a4.f51052b;
        if (!((z.a(activityManager) || az.a(activityManager, 0L) == null) ? false : true)) {
            al.c("proc is not in anr, wait next check", new Object[0]);
            return false;
        } else if (a4.a(System.currentTimeMillis())) {
            return false;
        } else {
            return a4.a(true);
        }
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i4, int i5, long j4, long j5, String str, String str2, String str3, String str4, int i6, String str5, int i7, int i8, int i9, String str6, String str7) {
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i4, i5, j4, j5, str, str2, str3, str4, i6, str5, i7, i8, i9, str6, str7, null);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j4, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z3, boolean z4) {
        int i4;
        String str12;
        int indexOf;
        boolean i5 = at.a().i();
        if (i5) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f50766b = 1;
        crashDetailBean.f50769e = this.f51091c.g();
        aa aaVar = this.f51091c;
        crashDetailBean.f50770f = aaVar.f50836o;
        crashDetailBean.f50771g = aaVar.q();
        crashDetailBean.f50777m = this.f51091c.f();
        crashDetailBean.f50778n = str3;
        crashDetailBean.f50779o = i5 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f50780p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.f50781q = str13;
        crashDetailBean.f50782r = j4;
        crashDetailBean.f50785u = ap.c(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.f50764L = this.f51091c.s();
        crashDetailBean.f50772h = this.f51091c.p();
        crashDetailBean.f50773i = this.f51091c.A();
        crashDetailBean.f50786v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String a4 = be.a(dumpFilePath, str8);
        if (!ap.b(a4)) {
            crashDetailBean.Z = a4;
        }
        crashDetailBean.aa = be.b(dumpFilePath);
        crashDetailBean.f50787w = be.a(str9, at.f50988f, at.f50993k, at.f50998p);
        crashDetailBean.f50788x = be.a(str10, at.f50988f, null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.f51091c.k();
        crashDetailBean.G = this.f51091c.j();
        crashDetailBean.H = this.f51091c.l();
        crashDetailBean.I = ab.b(this.f51089a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (z3) {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.f50789y = ao.a();
            aa aaVar2 = this.f51091c;
            crashDetailBean.Q = aaVar2.f50822a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.f50790z = ap.a(this.f51091c.Q, at.f50990h);
            int indexOf2 = crashDetailBean.f50781q.indexOf("java:\n");
            if (indexOf2 > 0 && (i4 = indexOf2 + 6) < crashDetailBean.f50781q.length()) {
                String str14 = crashDetailBean.f50781q;
                String substring = str14.substring(i4, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f50790z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.f50790z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f50790z.put(crashDetailBean.B, substring2);
                    crashDetailBean.f50781q = crashDetailBean.f50781q.substring(0, i4);
                    crashDetailBean.f50781q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f51091c.f50825d;
            }
            crashDetailBean.U = this.f51091c.z();
            aa aaVar3 = this.f51091c;
            crashDetailBean.V = aaVar3.f50845x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.f51091c.y();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.f50787w == null) {
                crashDetailBean.f50787w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1L;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.f51091c.y();
            crashDetailBean.f50790z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f50789y = bArr;
            }
        }
        return crashDetailBean;
    }
}
