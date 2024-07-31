package androidx.navigation;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p612k1.JvmClassMapping;

/* compiled from: NavigatorProvider.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0006\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\n¢\u0006\u0004\b\u0006\u0010\u0007\u001a4\u0010\u0006\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\n¢\u0006\u0004\b\u0006\u0010\n\u001a7\u0010\r\u001a\u0014\u0012\u000e\b\u0001\u0012\n \f*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\u0086\n\u001a\u001d\u0010\u000f\u001a\u00020\u000e*\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\u0086\n¨\u0006\u0010"}, m12616d2 = {"Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/navigation/NavigatorProvider;", "", "name", "get", "(Landroidx/navigation/NavigatorProvider;Ljava/lang/String;)Landroidx/navigation/Navigator;", "Lkotlin/reflect/d;", "clazz", "(Landroidx/navigation/NavigatorProvider;Lkotlin/reflect/d;)Landroidx/navigation/Navigator;", "navigator", "kotlin.jvm.PlatformType", "set", "Lkotlin/f1;", "plusAssign", "navigation-common-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NavigatorProviderKt {
    @NotNull
    public static final <T extends Navigator<? extends NavDestination>> T get(@NotNull NavigatorProvider get, @NotNull String name) {
        C14342f0.m8183q(get, "$this$get");
        C14342f0.m8183q(name, "name");
        T t = (T) get.getNavigator(name);
        C14342f0.m8192h(t, "getNavigator(name)");
        return t;
    }

    public static final void plusAssign(@NotNull NavigatorProvider plusAssign, @NotNull Navigator<? extends NavDestination> navigator) {
        C14342f0.m8183q(plusAssign, "$this$plusAssign");
        C14342f0.m8183q(navigator, "navigator");
        plusAssign.addNavigator(navigator);
    }

    @Nullable
    public static final Navigator<? extends NavDestination> set(@NotNull NavigatorProvider set, @NotNull String name, @NotNull Navigator<? extends NavDestination> navigator) {
        C14342f0.m8183q(set, "$this$set");
        C14342f0.m8183q(name, "name");
        C14342f0.m8183q(navigator, "navigator");
        return set.addNavigator(name, navigator);
    }

    @NotNull
    public static final <T extends Navigator<? extends NavDestination>> T get(@NotNull NavigatorProvider get, @NotNull KClass<T> clazz) {
        C14342f0.m8183q(get, "$this$get");
        C14342f0.m8183q(clazz, "clazz");
        T t = (T) get.getNavigator(JvmClassMapping.m12626c(clazz));
        C14342f0.m8192h(t, "getNavigator(clazz.java)");
        return t;
    }
}
