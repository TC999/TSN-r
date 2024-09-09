package com.bxkj.student.v2.ui.sports.safe;

import android.content.Intent;
import android.provider.Settings;
import com.bxkj.base.BaseApp;
import com.bxkj.student.App;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SettingSafe.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/safe/b;", "", "", "b", "Lkotlin/f1;", "c", "", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "tips", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f23945a = new b();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static String f23946b = "\u7cfb\u7edf\u68c0\u67e5\u5230\u7591\u4f3c\u6a21\u62df\u5b9a\u4f4d\uff0c\u5df2\u88ab\u7cfb\u7edf\u8bb0\u5f55\uff0c\u8bf7\u3010\u5378\u8f7d\u865a\u62df\u5b9a\u4f4d\u8f6f\u4ef6\u3011\u5e76\u3010\u5173\u95ed\u5f00\u53d1\u8005\u9009\u9879\u3011\u540e\u518d\u8bd5";

    private b() {
    }

    @NotNull
    public final String a() {
        return f23946b;
    }

    public final boolean b() {
        return Settings.Secure.getInt(BaseApp.b().getContentResolver(), "development_settings_enabled", 0) > 0;
    }

    public final void c() {
        Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
        intent.setFlags(268435456);
        App.n().startActivity(intent);
    }

    public final void d(@NotNull String str) {
        f0.p(str, "<set-?>");
        f23946b = str;
    }
}
