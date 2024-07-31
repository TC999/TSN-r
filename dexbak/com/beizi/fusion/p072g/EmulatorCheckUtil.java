package com.beizi.fusion.p072g;

import android.content.Context;
import com.baidu.idl.face.platform.FaceEnvironment;

/* renamed from: com.beizi.fusion.g.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class EmulatorCheckUtil {

    /* compiled from: EmulatorCheckUtil.java */
    /* renamed from: com.beizi.fusion.g.w$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3169a {

        /* renamed from: a */
        private static final EmulatorCheckUtil f11439a = new EmulatorCheckUtil();
    }

    /* renamed from: a */
    public static final EmulatorCheckUtil m48200a() {
        return C3169a.f11439a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        if (r0.equals("cancro") == false) goto L7;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m48197b() {
        /*
            r6 = this;
            java.lang.String r0 = "ro.hardware"
            java.lang.String r0 = r6.m48198a(r0)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            java.lang.String r0 = r0.toLowerCase()
            r0.hashCode()
            r2 = -1
            int r3 = r0.hashCode()
            r4 = 2
            r5 = 1
            switch(r3) {
                case -1367724016: goto L5f;
                case -822798509: goto L54;
                case 109271: goto L49;
                case 3570999: goto L3e;
                case 3613077: goto L33;
                case 100361430: goto L28;
                case 937844646: goto L1d;
                default: goto L1b;
            }
        L1b:
            r1 = -1
            goto L68
        L1d:
            java.lang.String r1 = "android_x86"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L26
            goto L1b
        L26:
            r1 = 6
            goto L68
        L28:
            java.lang.String r1 = "intel"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L31
            goto L1b
        L31:
            r1 = 5
            goto L68
        L33:
            java.lang.String r1 = "vbox"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3c
            goto L1b
        L3c:
            r1 = 4
            goto L68
        L3e:
            java.lang.String r1 = "ttvm"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L47
            goto L1b
        L47:
            r1 = 3
            goto L68
        L49:
            java.lang.String r1 = "nox"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L52
            goto L1b
        L52:
            r1 = 2
            goto L68
        L54:
            java.lang.String r1 = "vbox86"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5d
            goto L1b
        L5d:
            r1 = 1
            goto L68
        L5f:
            java.lang.String r3 = "cancro"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L68
            goto L1b
        L68:
            switch(r1) {
                case 0: goto L6c;
                case 1: goto L6c;
                case 2: goto L6c;
                case 3: goto L6c;
                case 4: goto L6c;
                case 5: goto L6c;
                case 6: goto L6c;
                default: goto L6b;
            }
        L6b:
            goto L6d
        L6c:
            r4 = 1
        L6d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.EmulatorCheckUtil.m48197b():int");
    }

    /* renamed from: c */
    private int m48195c() {
        String m48198a = m48198a("ro.build.flavor");
        if (m48198a == null) {
            return 0;
        }
        String lowerCase = m48198a.toLowerCase();
        return (lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2;
    }

    /* renamed from: d */
    private int m48193d() {
        String m48198a = m48198a("ro.product.model");
        if (m48198a == null) {
            return 0;
        }
        String lowerCase = m48198a.toLowerCase();
        return (lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2;
    }

    /* renamed from: e */
    private int m48191e() {
        String m48198a = m48198a("ro.product.manufacturer");
        if (m48198a == null) {
            return 0;
        }
        String lowerCase = m48198a.toLowerCase();
        return (lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2;
    }

    /* renamed from: f */
    private int m48190f() {
        String m48198a = m48198a("ro.product.board");
        if (m48198a == null) {
            return 0;
        }
        String lowerCase = m48198a.toLowerCase();
        return (lowerCase.contains(FaceEnvironment.f8430OS) || lowerCase.contains("goldfish")) ? 1 : 2;
    }

    /* renamed from: g */
    private int m48189g() {
        String m48198a = m48198a("ro.board.platform");
        if (m48198a == null) {
            return 0;
        }
        return m48198a.toLowerCase().contains(FaceEnvironment.f8430OS) ? 1 : 2;
    }

    /* renamed from: h */
    private int m48188h() {
        String m48198a = m48198a("gsm.version.baseband");
        if (m48198a == null) {
            return 0;
        }
        return m48198a.contains(C3144f.m48267a("MS4wLjAuMA==")) ? 1 : 2;
    }

    private EmulatorCheckUtil() {
    }

    /* renamed from: a */
    public boolean m48199a(Context context) {
        int i;
        if (context == null) {
            return true;
        }
        int m48197b = m48197b();
        if (m48197b == 0) {
            i = 1;
        } else if (m48197b == 1) {
            return true;
        } else {
            i = 0;
        }
        int m48195c = m48195c();
        if (m48195c == 0) {
            i++;
        } else if (m48195c == 1) {
            return true;
        }
        int m48193d = m48193d();
        if (m48193d == 0) {
            i++;
        } else if (m48193d == 1) {
            return true;
        }
        int m48191e = m48191e();
        if (m48191e == 0) {
            i++;
        } else if (m48191e == 1) {
            return true;
        }
        int m48190f = m48190f();
        if (m48190f == 0) {
            i++;
        } else if (m48190f == 1) {
            return true;
        }
        int m48189g = m48189g();
        if (m48189g == 0) {
            i++;
        } else if (m48189g == 1) {
            return true;
        }
        int m48188h = m48188h();
        if (m48188h == 0) {
            i += 2;
        } else if (m48188h == 1) {
            return true;
        }
        if (!m48194c(context)) {
            i++;
        }
        if (!m48196b(context)) {
            i++;
        }
        if (!m48192d(context)) {
            i++;
        }
        return i > 3;
    }

    /* renamed from: b */
    private boolean m48196b(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.camera");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private boolean m48194c(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    private boolean m48192d(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private String m48198a(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
