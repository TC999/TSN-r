package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n {
    public static com.kwad.sdk.l.a.d aOF;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a extends com.kwad.sdk.l.a.a {
        public a() {
            Lh();
        }

        private void Lh() {
            ArrayList arrayList = new ArrayList();
            this.aMR = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    String str = Build.PRODUCT;
                    int i4 = (str.contains("sdk") || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                    String str2 = Build.MANUFACTURER;
                    if (str2.equals("unknown") || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                        i4++;
                    }
                    String str3 = Build.BRAND;
                    if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                        i4++;
                    }
                    String str4 = Build.DEVICE;
                    if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                        i4++;
                    }
                    String str5 = Build.MODEL;
                    if (str5.equals("sdk") || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                        i4++;
                    }
                    String str6 = Build.HARDWARE;
                    if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                        i4++;
                    }
                    String str7 = Build.FINGERPRINT;
                    if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                        i4++;
                    }
                    try {
                        if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                            i4 += 10;
                        }
                    } catch (Exception unused) {
                    }
                    return i4 > 3;
                }
            });
            this.aMR.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    return "1".equals(bh.get("ro.kernel.qemu"));
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b extends com.kwad.sdk.l.a.a {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class c extends com.kwad.sdk.l.a.a {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class d extends com.kwad.sdk.l.a.a {
        public d() {
            Lh();
        }

        private void Lh() {
            ArrayList arrayList = new ArrayList();
            this.aMR = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.aMR.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i4 = 0; i4 < 5; i4++) {
                        if (new File(strArr[i4] + "su").exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.aMR.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.3
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    return !TextUtils.isEmpty(n.g(new String[]{"/system/xbin/which", "su"}));
                }
            });
            this.aMR.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.4
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        q.a(file, "ok", forName, false);
                        return q.a(file, forName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class e extends com.kwad.sdk.l.a.a {
        public e() {
            Lh();
        }

        private void Lh() {
            ArrayList arrayList = new ArrayList();
            this.aMR = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    return ak.an(context, "de.robv.android.xposed.installer") || ak.an(context, "com.saurik.substrate");
                }
            });
            this.aMR.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    StackTraceElement[] stackTrace;
                    try {
                        throw new Exception("empty");
                    } catch (Exception e4) {
                        boolean z3 = false;
                        int i4 = 0;
                        for (StackTraceElement stackTraceElement : e4.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i4 = i4 + 1) == 2) {
                                z3 = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z3 = true;
                            }
                            if (className.equals("de.robv.android.xposed.XposedBridge") && methodName.equals("main")) {
                                z3 = true;
                            }
                            if (className.equals("de.robv.android.xposed.XposedBridge") && methodName.equals("handleHookedMethod")) {
                                z3 = true;
                            }
                        }
                        return z3;
                    }
                }
            });
            this.aMR.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.3
                @Override // com.kwad.sdk.l.a.a
                public final boolean bB(Context context) {
                    BufferedReader bufferedReader;
                    FileReader fileReader;
                    Throwable th;
                    BufferedReader bufferedReader2 = null;
                    boolean z3 = false;
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
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    return z3;
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    throw th;
                                }
                            }
                            for (String str : hashSet) {
                                if (str.contains("com.saurik.substrate")) {
                                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                    z3 = true;
                                }
                                if (str.contains("XposedBridge.jar")) {
                                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                    z3 = true;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        } catch (Exception unused2) {
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                            throw th;
                        }
                    } catch (Exception unused3) {
                        fileReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        fileReader = null;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z3;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.l.a.d Lg() {
        synchronized (n.class) {
            if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yD()) {
                com.kwad.sdk.l.a.d dVar = aOF;
                if (dVar != null) {
                    return dVar;
                }
                Context origApplicationContext = StubApp.getOrigApplicationContext(ServiceProvider.getContext().getApplicationContext());
                com.kwad.sdk.l.a.d dVar2 = new com.kwad.sdk.l.a.d(origApplicationContext);
                boolean bA = new d().bA(origApplicationContext);
                boolean bA2 = new e().bA(origApplicationContext);
                boolean bA3 = new b().bA(origApplicationContext);
                boolean bA4 = new a().bA(origApplicationContext);
                boolean bA5 = new c().bA(origApplicationContext);
                dVar2.bJ(bA);
                dVar2.bK(bA2);
                dVar2.bL(bA3);
                dVar2.bN(bA4);
                dVar2.bO(bA5);
                aOF = dVar2;
                return dVar2;
            }
            return null;
        }
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
