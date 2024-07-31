package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.provider.Settings;
import com.orhanobut.logger.C11792j;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.umeng.socialize.common.SocializeConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/run/app/utils/n;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.run.app.utils.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MockLocationUtils {
    @NotNull

    /* renamed from: a */
    public static final C5403a f19653a = new C5403a(null);
    @NotNull

    /* renamed from: b */
    private static Map<String, String> f19654b;

    /* compiled from: MockLocationUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, m12616d2 = {"Lcom/bxkj/student/run/app/utils/n$a;", "", "", "", "b", "Landroid/location/Location;", SocializeConstants.KEY_LOCATION, "Landroid/content/Context;", "context", "", "d", "c", "", "virtualList", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "e", "(Ljava/util/Map;)V", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.utils.n$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5403a {
        private C5403a() {
        }

        public /* synthetic */ C5403a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        private final Map<String, String> m39594b() {
            return m39595a();
        }

        @NotNull
        /* renamed from: a */
        public final Map<String, String> m39595a() {
            return MockLocationUtils.f19654b;
        }

        /* renamed from: c */
        public final boolean m39593c(@NotNull Context context) {
            C14342f0.m8184p(context, "context");
            Map<String, String> m39594b = m39594b();
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            C14342f0.m8185o(installedPackages, "packageManager.getInstalledPackages(0)");
            StringBuilder sb = new StringBuilder();
            int size = installedPackages.size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String obj = packageManager.getApplicationLabel(installedPackages.get(i).applicationInfo).toString();
                    String str = installedPackages.get(i).packageName;
                    C14342f0.m8185o(str, "installPackageList[i].packageName");
                    sb.append("appName: " + obj + " packageName: " + str);
                    sb.append(ShellAdbUtils.f33810d);
                    if (m39594b.get(installedPackages.get(i).packageName) != null) {
                        C11792j.m20469d(C14342f0.m8216C("", m39594b.get(installedPackages.get(i).packageName)), new Object[0]);
                        return true;
                    } else if (i2 > size) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            C11792j.m20470c(sb);
            return false;
        }

        /* renamed from: d */
        public final boolean m39592d(@NotNull Location location, @NotNull Context context) {
            C14342f0.m8184p(location, "location");
            C14342f0.m8184p(context, "context");
            if (Build.VERSION.SDK_INT >= 18) {
                return location.isFromMockProvider();
            }
            return !C14342f0.m8193g(Settings.Secure.getString(context.getContentResolver(), "mock_location"), "0");
        }

        /* renamed from: e */
        public final void m39591e(@NotNull Map<String, String> map) {
            C14342f0.m8184p(map, "<set-?>");
            MockLocationUtils.f19654b = map;
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
        f19654b = linkedHashMap;
    }
}
