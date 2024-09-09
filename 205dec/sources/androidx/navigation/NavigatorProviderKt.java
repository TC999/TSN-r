package androidx.navigation;

import c2.a;
import com.acse.ottn.f3;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.reflect.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: NavigatorProvider.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0006\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a4\u0010\u0006\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\n\u00a2\u0006\u0004\b\u0006\u0010\n\u001a7\u0010\r\u001a\u0014\u0012\u000e\b\u0001\u0012\n \f*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\u0086\n\u001a\u001d\u0010\u000f\u001a\u00020\u000e*\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\u0086\n\u00a8\u0006\u0010"}, d2 = {"Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "T", "Landroidx/navigation/NavigatorProvider;", "", "name", f3.f5657f, "(Landroidx/navigation/NavigatorProvider;Ljava/lang/String;)Landroidx/navigation/Navigator;", "Lkotlin/reflect/d;", "clazz", "(Landroidx/navigation/NavigatorProvider;Lkotlin/reflect/d;)Landroidx/navigation/Navigator;", "navigator", "kotlin.jvm.PlatformType", f3.f5659h, "Lkotlin/f1;", "plusAssign", "navigation-common-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavigatorProviderKt {
    @NotNull
    public static final <T extends Navigator<? extends NavDestination>> T get(@NotNull NavigatorProvider get, @NotNull String name) {
        f0.q(get, "$this$get");
        f0.q(name, "name");
        T t3 = (T) get.getNavigator(name);
        f0.h(t3, "getNavigator(name)");
        return t3;
    }

    public static final void plusAssign(@NotNull NavigatorProvider plusAssign, @NotNull Navigator<? extends NavDestination> navigator) {
        f0.q(plusAssign, "$this$plusAssign");
        f0.q(navigator, "navigator");
        plusAssign.addNavigator(navigator);
    }

    @Nullable
    public static final Navigator<? extends NavDestination> set(@NotNull NavigatorProvider set, @NotNull String name, @NotNull Navigator<? extends NavDestination> navigator) {
        f0.q(set, "$this$set");
        f0.q(name, "name");
        f0.q(navigator, "navigator");
        return set.addNavigator(name, navigator);
    }

    @NotNull
    public static final <T extends Navigator<? extends NavDestination>> T get(@NotNull NavigatorProvider get, @NotNull d<T> clazz) {
        f0.q(get, "$this$get");
        f0.q(clazz, "clazz");
        T t3 = (T) get.getNavigator(a.c(clazz));
        f0.h(t3, "getNavigator(clazz.java)");
        return t3;
    }
}
