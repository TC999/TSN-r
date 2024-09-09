package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.provider.Settings;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MockLocationUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/run/app/utils/n;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f22883a = new a(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, String> f22884b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MockLocationUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/bxkj/student/run/app/utils/n$a;", "", "", "", "b", "Landroid/location/Location;", "location", "Landroid/content/Context;", "context", "", "d", "c", "", "virtualList", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "e", "(Ljava/util/Map;)V", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        private final Map<String, String> b() {
            return a();
        }

        @NotNull
        public final Map<String, String> a() {
            return n.f22884b;
        }

        public final boolean c(@NotNull Context context) {
            f0.p(context, "context");
            Map<String, String> b4 = b();
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            f0.o(installedPackages, "packageManager.getInstalledPackages(0)");
            StringBuilder sb = new StringBuilder();
            int size = installedPackages.size() - 1;
            if (size >= 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    String obj = packageManager.getApplicationLabel(installedPackages.get(i4).applicationInfo).toString();
                    String str = installedPackages.get(i4).packageName;
                    f0.o(str, "installPackageList[i].packageName");
                    sb.append("appName: " + obj + " packageName: " + str);
                    sb.append("\n");
                    if (b4.get(installedPackages.get(i4).packageName) != null) {
                        com.orhanobut.logger.j.d(f0.C("", b4.get(installedPackages.get(i4).packageName)), new Object[0]);
                        return true;
                    } else if (i5 > size) {
                        break;
                    } else {
                        i4 = i5;
                    }
                }
            }
            com.orhanobut.logger.j.c(sb);
            return false;
        }

        public final boolean d(@NotNull Location location, @NotNull Context context) {
            f0.p(location, "location");
            f0.p(context, "context");
            if (Build.VERSION.SDK_INT >= 18) {
                return location.isFromMockProvider();
            }
            return !f0.g(Settings.Secure.getString(context.getContentResolver(), "mock_location"), "0");
        }

        public final void e(@NotNull Map<String, String> map) {
            f0.p(map, "<set-?>");
            n.f22884b = map;
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("com.lerist.fakelocation", "com.lerist.fakelocation");
        linkedHashMap.put("top.a1024bytes.mockloc.ca.pro", "top.a1024bytes.mockloc.ca.pro");
        linkedHashMap.put("com.qgwapp.shadowside", "com.qgwapp.shadowside");
        linkedHashMap.put("net.superal", "net.superal");
        linkedHashMap.put("com.deniu.daniu", "com.deniu.daniu");
        linkedHashMap.put("com.deniu.multi", "com.deniu.multi");
        linkedHashMap.put("com.txy.anywhere", "com.txy.anywhere");
        linkedHashMap.put("de.robv.android.xposed.installer", "de.robv.android.xposed.installer");
        linkedHashMap.put("github.tornaco.xposedmoduletest", "github.tornaco.xposedmoduletest");
        f22884b = linkedHashMap;
    }
}
