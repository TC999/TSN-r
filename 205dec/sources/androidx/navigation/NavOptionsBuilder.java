package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavOptions;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: NavOptionsBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J)\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007J\u001f\u0010\f\u001a\u00020\u00062\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007J\u000f\u0010\u0010\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\t\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028\u0006@FX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016\u00a8\u0006$"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "", "", "id", "Lkotlin/Function1;", "Landroidx/navigation/PopUpToBuilder;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "popUpToBuilder", "popUpTo", "Landroidx/navigation/AnimBuilder;", "animBuilder", "anim", "Landroidx/navigation/NavOptions;", "build$navigation_common_ktx_release", "()Landroidx/navigation/NavOptions;", "build", "Landroidx/navigation/NavOptions$Builder;", "builder", "Landroidx/navigation/NavOptions$Builder;", "", "launchSingleTop", "Z", "getLaunchSingleTop", "()Z", "setLaunchSingleTop", "(Z)V", "value", "I", "getPopUpTo", "()I", "setPopUpTo", "(I)V", "inclusive", "<init>", "()V", "navigation-common-ktx_release"}, k = 1, mv = {1, 4, 0})
@NavOptionsDsl
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavOptionsBuilder {
    private boolean inclusive;
    private boolean launchSingleTop;
    private final NavOptions.Builder builder = new NavOptions.Builder();
    @IdRes
    private int popUpTo = -1;

    public final void anim(@NotNull l<? super AnimBuilder, f1> animBuilder) {
        f0.q(animBuilder, "animBuilder");
        AnimBuilder animBuilder2 = new AnimBuilder();
        animBuilder.invoke(animBuilder2);
        this.builder.setEnterAnim(animBuilder2.getEnter()).setExitAnim(animBuilder2.getExit()).setPopEnterAnim(animBuilder2.getPopEnter()).setPopExitAnim(animBuilder2.getPopExit());
    }

    @NotNull
    public final NavOptions build$navigation_common_ktx_release() {
        NavOptions.Builder builder = this.builder;
        builder.setLaunchSingleTop(this.launchSingleTop);
        builder.setPopUpTo(this.popUpTo, this.inclusive);
        NavOptions build = builder.build();
        f0.h(build, "builder.apply {\n        \u2026 inclusive)\n    }.build()");
        return build;
    }

    public final boolean getLaunchSingleTop() {
        return this.launchSingleTop;
    }

    public final int getPopUpTo() {
        return this.popUpTo;
    }

    public final void popUpTo(@IdRes int i4, @NotNull l<? super PopUpToBuilder, f1> popUpToBuilder) {
        f0.q(popUpToBuilder, "popUpToBuilder");
        setPopUpTo(i4);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
    }

    public final void setLaunchSingleTop(boolean z3) {
        this.launchSingleTop = z3;
    }

    public final void setPopUpTo(int i4) {
        this.popUpTo = i4;
        this.inclusive = false;
    }
}
