package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kuaishou.weapon.p205p0.C7170an;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.p441l.p442a.AbstractC10852a;
import com.kwad.sdk.p441l.p442a.C10855d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.kwad.sdk.utils.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11105n {
    public static C10855d aOF;

    /* renamed from: com.kwad.sdk.utils.n$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11106a extends AbstractC10852a {
        public C11106a() {
            m23766Lh();
        }

        /* renamed from: Lh */
        private void m23766Lh() {
            ArrayList arrayList = new ArrayList();
            this.aMR = arrayList;
            arrayList.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.1
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    String str = Build.PRODUCT;
                    int i = (str.contains("sdk") || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                    String str2 = Build.MANUFACTURER;
                    if (str2.equals("unknown") || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                        i++;
                    }
                    String str3 = Build.BRAND;
                    if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                        i++;
                    }
                    String str4 = Build.DEVICE;
                    if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                        i++;
                    }
                    String str5 = Build.MODEL;
                    if (str5.equals("sdk") || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                        i++;
                    }
                    String str6 = Build.HARDWARE;
                    if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                        i++;
                    }
                    String str7 = Build.FINGERPRINT;
                    if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                        i++;
                    }
                    try {
                        if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                            i += 10;
                        }
                    } catch (Exception unused) {
                    }
                    return i > 3;
                }
            });
            this.aMR.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.2
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    return "1".equals(C11054bh.get("ro.kernel.qemu"));
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.utils.n$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11109b extends AbstractC10852a {
    }

    /* renamed from: com.kwad.sdk.utils.n$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11110c extends AbstractC10852a {
    }

    /* renamed from: com.kwad.sdk.utils.n$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11111d extends AbstractC10852a {
        public C11111d() {
            m23765Lh();
        }

        /* renamed from: Lh */
        private void m23765Lh() {
            ArrayList arrayList = new ArrayList();
            this.aMR = arrayList;
            arrayList.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.1
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.aMR.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.2
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + "su").exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.aMR.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.3
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    return !TextUtils.isEmpty(C11105n.m23767g(new String[]{"/system/xbin/which", "su"}));
                }
            });
            this.aMR.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.4
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        C11122q.m23730a(file, "ok", forName, false);
                        return C11122q.m23729a(file, forName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.utils.n$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11116e extends AbstractC10852a {
        public C11116e() {
            m23764Lh();
        }

        /* renamed from: Lh */
        private void m23764Lh() {
            ArrayList arrayList = new ArrayList();
            this.aMR = arrayList;
            arrayList.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.1
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    return C11017ak.m24114an(context, "de.robv.android.xposed.installer") || C11017ak.m24114an(context, "com.saurik.substrate");
                }
            });
            this.aMR.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.2
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    StackTraceElement[] stackTrace;
                    try {
                        throw new Exception("empty");
                    } catch (Exception e) {
                        boolean z = false;
                        int i = 0;
                        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i = i + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals(C7170an.f24524b) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(C7170an.f24524b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.aMR.add(new AbstractC10852a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.3
                @Override // com.kwad.sdk.p441l.p442a.AbstractC10852a
                /* renamed from: bB */
                public final boolean mo23763bB(Context context) {
                    BufferedReader bufferedReader;
                    FileReader fileReader;
                    Throwable th;
                    BufferedReader bufferedReader2 = null;
                    boolean z = false;
                    try {
                        HashSet<String> hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                        try {
                            bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                        hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                    }
                                } catch (Exception unused) {
                                    bufferedReader2 = bufferedReader;
                                    C10738b.closeQuietly(bufferedReader2);
                                    C10738b.closeQuietly(fileReader);
                                    return z;
                                } catch (Throwable th2) {
                                    th = th2;
                                    C10738b.closeQuietly(bufferedReader);
                                    C10738b.closeQuietly(fileReader);
                                    throw th;
                                }
                            }
                            for (String str : hashSet) {
                                if (str.contains("com.saurik.substrate")) {
                                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                    z = true;
                                }
                                if (str.contains("XposedBridge.jar")) {
                                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                    z = true;
                                }
                            }
                            C10738b.closeQuietly(bufferedReader);
                        } catch (Exception unused2) {
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                            th = th;
                            C10738b.closeQuietly(bufferedReader);
                            C10738b.closeQuietly(fileReader);
                            throw th;
                        }
                    } catch (Exception unused3) {
                        fileReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        fileReader = null;
                    }
                    C10738b.closeQuietly(fileReader);
                    return z;
                }
            });
        }
    }

    @WorkerThread
    /* renamed from: Lg */
    public static synchronized C10855d m23768Lg() {
        synchronized (C11105n.class) {
            if (((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24320yD()) {
                C10855d c10855d = aOF;
                if (c10855d != null) {
                    return c10855d;
                }
                Context origApplicationContext = StubApp.getOrigApplicationContext(ServiceProvider.getContext().getApplicationContext());
                C10855d c10855d2 = new C10855d(origApplicationContext);
                boolean mo24639bA = new C11111d().mo24639bA(origApplicationContext);
                boolean mo24639bA2 = new C11116e().mo24639bA(origApplicationContext);
                boolean mo24639bA3 = new C11109b().mo24639bA(origApplicationContext);
                boolean mo24639bA4 = new C11106a().mo24639bA(origApplicationContext);
                boolean mo24639bA5 = new C11110c().mo24639bA(origApplicationContext);
                c10855d2.m24636bJ(mo24639bA);
                c10855d2.m24635bK(mo24639bA2);
                c10855d2.m24634bL(mo24639bA3);
                c10855d2.m24632bN(mo24639bA4);
                c10855d2.m24631bO(mo24639bA5);
                aOF = c10855d2;
                return c10855d2;
            }
            return null;
        }
    }

    /* renamed from: g */
    public static String m23767g(String[] strArr) {
        try {
            return C10747h.m24943c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
