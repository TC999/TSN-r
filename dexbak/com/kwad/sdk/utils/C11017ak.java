package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.stub.StubApp;
import java.io.File;

/* renamed from: com.kwad.sdk.utils.ak */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11017ak {

    /* renamed from: com.kwad.sdk.utils.ak$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11018a {
        /* renamed from: d */
        void mo24107d(Throwable th);

        /* renamed from: ol */
        void mo24106ol();
    }

    /* renamed from: a */
    public static boolean m24115a(@Nullable String str, InterfaceC11018a interfaceC11018a) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Context context = ServiceProvider.getContext();
            File file = new File(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(3);
            Uri uriForFile = Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file) : Uri.fromFile(file);
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                context.grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 3);
            }
            context.startActivity(intent);
            if (interfaceC11018a != null) {
                interfaceC11018a.mo24106ol();
                return true;
            }
            return true;
        } catch (Throwable th) {
            if (interfaceC11018a != null) {
                interfaceC11018a.mo24107d(th);
            }
            return false;
        }
    }

    /* renamed from: an */
    public static boolean m24114an(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    /* renamed from: ao */
    public static int m24113ao(@Nullable Context context, String str) {
        if (context == null || str == null || C11077c.m23839bF(context) || ContextCompat.checkSelfPermission(context, C7282g.f24951i) != 0) {
            return -1;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(absolutePath + "/Android/data/" + str);
        return (file.exists() && file.isDirectory()) ? 1 : 0;
    }

    /* renamed from: ap */
    public static boolean m24112ap(@Nullable Context context, @Nullable String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            C10331c.m26254d("PackageUtil", "openApp context: " + context);
            launchIntentForPackage.setFlags(337641472);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: av */
    public static void m24111av(String str, String str2) {
        C10331c.m26246w("PackageUtil", "saveDownloadFile " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (!file.exists()) {
                C10331c.m26246w("PackageUtil", "cannot save package, download apk is not exists.");
                return;
            }
            Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
            if (context == null) {
                return;
            }
            C11137y.m23576f(context, str2, file.length());
            try {
                C11137y.m23575g(context, str2, C10977a.getFileMD5(file));
                return;
            } catch (Exception e) {
                C10331c.printStackTrace(e);
                return;
            }
        }
        C10331c.m26246w("PackageUtil", "cannot save package, has no download apk info.");
    }

    /* renamed from: aw */
    public static int m24110aw(String str, String str2) {
        ApplicationInfo applicationInfo;
        C10331c.m26246w("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null) {
            return 0;
        }
        long m23622U = C11137y.m23622U(context, str);
        String m23621V = C11137y.m23621V(context, str);
        if (!TextUtils.isEmpty(m23621V) && m23622U > 0) {
            try {
                PackageInfo packageInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(str2, 0);
                if (!TextUtils.isEmpty(str2) && packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && !TextUtils.isEmpty(applicationInfo.publicSourceDir)) {
                    File file = new File(packageInfo.applicationInfo.publicSourceDir);
                    if (!file.exists()) {
                        C10331c.m26246w("PackageUtil", "cannot judge package, insgtalled apk is not exists.");
                        return 0;
                    } else if (m23622U != file.length()) {
                        return 1;
                    } else {
                        if (TextUtils.isEmpty(m23621V)) {
                            C10331c.m26246w("PackageUtil", "cannot judge package, cannot calculate md5 of download file.");
                            return 0;
                        }
                        String fileMD5 = C10977a.getFileMD5(file);
                        if (!TextUtils.isEmpty(fileMD5)) {
                            return m23621V.equalsIgnoreCase(fileMD5) ? 2 : 1;
                        }
                        C10331c.m26246w("PackageUtil", "cannot judge package, cannot calculate md5 of installed file.");
                        return 0;
                    }
                }
                C10331c.m26246w("PackageUtil", "cannot judge package, cannot get installed apk info.");
                return 0;
            } catch (PackageManager.NameNotFoundException e) {
                C10331c.printStackTrace(e);
                return 0;
            }
        }
        C10331c.m26246w("PackageUtil", "cannot judge package, has no download apk info.");
        return 0;
    }

    /* renamed from: gE */
    public static boolean m24109gE(@Nullable String str) {
        return m24115a(str, null);
    }

    /* renamed from: gF */
    public static String m24108gF(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            C10331c.m26246w("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }
}
