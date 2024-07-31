package com.bxkj.student.p094v2.p098ui.sports.safe;

import android.content.Intent;
import android.provider.Settings;
import com.bxkj.base.BaseApp;
import com.bxkj.student.App;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/safe/b;", "", "", "b", "Lkotlin/f1;", "c", "", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "tips", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.safe.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SettingSafe {
    @NotNull

    /* renamed from: a */
    public static final SettingSafe f20547a = new SettingSafe();
    @NotNull

    /* renamed from: b */
    private static String f20548b = "系统检查到疑似模拟定位，已被系统记录，请【卸载虚拟定位软件】并【关闭开发者选项】后再试";

    private SettingSafe() {
    }

    @NotNull
    /* renamed from: a */
    public final String m38619a() {
        return f20548b;
    }

    /* renamed from: b */
    public final boolean m38618b() {
        return Settings.Secure.getInt(BaseApp.m44341b().getContentResolver(), "development_settings_enabled", 0) > 0;
    }

    /* renamed from: c */
    public final void m38617c() {
        Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
        intent.setFlags(268435456);
        App.m43006n().startActivity(intent);
    }

    /* renamed from: d */
    public final void m38616d(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        f20548b = str;
    }
}
