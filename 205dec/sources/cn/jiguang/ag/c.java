package cn.jiguang.ag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.acse.ottn.f3;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f2185a = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f2186b = {"fstab.andy", "ueventd.andy.rc"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f2187c = {"fstab.nox", "init.nox.rc", "ueventd.nox.rc"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f2188d = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f2189e = {"goldfish"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f2190f = {"ueventd.android_x86.rc", "x86.prop", "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc", "fstab.ttVM_x86", "fstab.vbox86", "init.vbox86.rc", "ueventd.vbox86.rc"};

    /* renamed from: g  reason: collision with root package name */
    private static final f[] f2191g = {new f("init.svc.qemud", null), new f("init.svc.qemu-props", null), new f("qemu.hw.mainkeys", null), new f("qemu.sf.fake_camera", null), new f("qemu.sf.lcd_density", null), new f("ro.bootloader", "unknown"), new f("ro.bootmode", "unknown"), new f("ro.hardware", "goldfish"), new f("ro.kernel.android.qemud", null), new f("ro.kernel.qemu.gles", null), new f("ro.kernel.qemu", "1"), new f("ro.product.device", "generic"), new f("ro.product.model", "sdk"), new f("ro.product.name", "sdk")};
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: n  reason: collision with root package name */
    private static c f2192n;

    /* renamed from: h  reason: collision with root package name */
    private final Context f2193h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2194i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2195j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2196k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2197l = false;

    /* renamed from: m  reason: collision with root package name */
    private final List<String> f2198m;

    private c(Context context) {
        ArrayList arrayList = new ArrayList();
        this.f2198m = arrayList;
        this.f2193h = context;
        arrayList.add("com.google.android.launcher.layouts.genymotion");
        arrayList.add("com.bluestacks");
        arrayList.add("com.bignox.app");
    }

    public static c a(Context context) {
        if (context != null) {
            if (f2192n == null) {
                f2192n = new c(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            return f2192n;
        }
        throw new IllegalArgumentException("Context \u4e0d\u80fd\u4e3a\u7a7a.");
    }

    private String a(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod(f3.f5657f, String.class).invoke(loadClass, str);
        } catch (Throwable th) {
            cn.jiguang.w.a.b("EmulatorDetector", th.getMessage());
            return null;
        }
    }

    private boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (new File(str2).exists()) {
                cn.jiguang.w.a.b("EmulatorDetector", "Check " + str + " is detected");
                return true;
            }
        }
        return false;
    }

    public static Boolean b(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) == null ? Boolean.TRUE : Boolean.FALSE;
    }

    private boolean b() {
        boolean z3 = false;
        boolean z4 = c() || e() || a(f2185a, "Geny") || a(f2186b, "Andy") || a(f2187c, "Nox") || a(f2188d, "Pipes") || g() || h();
        if (z4) {
            return z4;
        }
        if (this.f2196k) {
            if (f() && a(f2190f, "X86")) {
                z3 = true;
            }
            z4 = z3;
        }
        if (this.f2195j) {
            z4 = d();
        }
        return this.f2197l ? b(this.f2193h).booleanValue() : z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ag.c.c():boolean");
    }

    private boolean d() {
        Intent launchIntentForPackage;
        if (this.f2195j && !this.f2198m.isEmpty()) {
            PackageManager packageManager = this.f2193h.getPackageManager();
            for (String str : this.f2198m) {
                try {
                    launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
                } catch (Throwable unused) {
                }
                if (launchIntentForPackage != null) {
                    return packageManager.resolveActivity(launchIntentForPackage, 65536) != null;
                }
                continue;
            }
        }
        return false;
    }

    private boolean e() {
        if (a.a(this.f2193h, "android.permission.READ_PHONE_STATE") && i() && i.b(this.f2193h, false).equalsIgnoreCase("android")) {
            cn.jiguang.w.a.b("EmulatorDetector", "Check operator name android is detected");
            return true;
        }
        return false;
    }

    private boolean f() {
        f[] fVarArr;
        int i4 = 0;
        for (f fVar : f2191g) {
            if ((!"ro.product.name".equals(fVar.f2200a) || cn.jiguang.ar.a.a().e(1015)) && (!"ro.product.model".equals(fVar.f2200a) || cn.jiguang.ar.a.a().e(2009))) {
                String a4 = a(this.f2193h, fVar.f2200a);
                String str = fVar.f2201b;
                if (str == null && a4 != null) {
                    i4++;
                }
                if (str != null && a4 != null && a4.contains(str)) {
                    i4++;
                }
            }
        }
        if (i4 >= 5) {
            cn.jiguang.w.a.b("EmulatorDetector", "Check QEmuProps is detected");
            return true;
        }
        return false;
    }

    private boolean g() {
        File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
        for (int i4 = 0; i4 < 2; i4++) {
            File file = fileArr[i4];
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[1024];
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                } catch (Throwable th) {
                    cn.jiguang.w.a.f("EmulatorDetector", th.getMessage());
                }
                String str = new String(bArr);
                for (String str2 : f2189e) {
                    if (str.contains(str2)) {
                        cn.jiguang.w.a.b("EmulatorDetector", "Check QEmuDrivers is detected");
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private boolean h() {
        String[] split;
        if (a.a(this.f2193h, "android.permission.INTERNET")) {
            String[] strArr = {"/system/bin/netcfg"};
            StringBuilder sb = new StringBuilder();
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(strArr);
                processBuilder.directory(new File("/system/bin/"));
                processBuilder.redirectErrorStream(true);
                InputStream inputStream = processBuilder.start().getInputStream();
                byte[] bArr = new byte[1024];
                while (inputStream.read(bArr) != -1) {
                    sb.append(new String(bArr));
                }
                inputStream.close();
            } catch (Throwable th) {
                cn.jiguang.w.a.b("EmulatorDetector", th.getMessage());
            }
            String sb2 = sb.toString();
            cn.jiguang.w.a.b("EmulatorDetector", "netcfg data -> " + sb2);
            if (TextUtils.isEmpty(sb2)) {
                return false;
            }
            for (String str : sb2.split("\n")) {
                if ((str.contains("wlan0") || str.contains("tunl0") || str.contains("eth0")) && str.contains("10.0.2.15")) {
                    cn.jiguang.w.a.b("EmulatorDetector", "Check IP is detected");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean i() {
        boolean hasSystemFeature = this.f2193h.getPackageManager().hasSystemFeature("android.hardware.telephony");
        cn.jiguang.w.a.b("EmulatorDetector", "Supported TelePhony: " + hasSystemFeature);
        return hasSystemFeature;
    }

    public c a(boolean z3) {
        this.f2195j = z3;
        return this;
    }

    public boolean a() {
        boolean z3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            z3 = b();
        } catch (Throwable th) {
            th = th;
            z3 = false;
        }
        try {
            cn.jiguang.w.a.b("EmulatorDetector", "sync detect cost time: " + (System.currentTimeMillis() - currentTimeMillis) + ", isSimulator: " + z3);
        } catch (Throwable th2) {
            th = th2;
            cn.jiguang.w.a.f("EmulatorDetector", "detect si failed, error: " + th.getMessage());
            return z3;
        }
        return z3;
    }

    public c b(boolean z3) {
        this.f2196k = z3;
        return this;
    }

    public c c(boolean z3) {
        this.f2197l = z3;
        return this;
    }
}
