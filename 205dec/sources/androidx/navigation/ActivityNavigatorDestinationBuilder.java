package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.IdRes;
import androidx.navigation.ActivityNavigator;
import c2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.reflect.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ActivityNavigatorDestinationBuilder.kt */
@NavDestinationDsl
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010$\u001a\u00020#\u0012\b\b\u0001\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR,\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\r\u00a8\u0006)"}, d2 = {"Landroidx/navigation/ActivityNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/ActivityNavigator$Destination;", "build", "Landroid/content/Context;", "context", "Landroid/content/Context;", "", "targetPackage", "Ljava/lang/String;", "getTargetPackage", "()Ljava/lang/String;", "setTargetPackage", "(Ljava/lang/String;)V", "Lkotlin/reflect/d;", "Landroid/app/Activity;", "activityClass", "Lkotlin/reflect/d;", "getActivityClass", "()Lkotlin/reflect/d;", "setActivityClass", "(Lkotlin/reflect/d;)V", "action", "getAction", "setAction", "Landroid/net/Uri;", "data", "Landroid/net/Uri;", "getData", "()Landroid/net/Uri;", "setData", "(Landroid/net/Uri;)V", "dataPattern", "getDataPattern", "setDataPattern", "Landroidx/navigation/ActivityNavigator;", "navigator", "", "id", "<init>", "(Landroidx/navigation/ActivityNavigator;I)V", "navigation-runtime-ktx_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ActivityNavigatorDestinationBuilder extends NavDestinationBuilder<ActivityNavigator.Destination> {
    @Nullable
    private String action;
    @Nullable
    private d<? extends Activity> activityClass;
    private final Context context;
    @Nullable
    private Uri data;
    @Nullable
    private String dataPattern;
    @Nullable
    private String targetPackage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityNavigatorDestinationBuilder(@NotNull ActivityNavigator navigator, @IdRes int i4) {
        super(navigator, i4);
        f0.q(navigator, "navigator");
        Context context = navigator.getContext();
        f0.h(context, "navigator.context");
        this.context = context;
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final d<? extends Activity> getActivityClass() {
        return this.activityClass;
    }

    @Nullable
    public final Uri getData() {
        return this.data;
    }

    @Nullable
    public final String getDataPattern() {
        return this.dataPattern;
    }

    @Nullable
    public final String getTargetPackage() {
        return this.targetPackage;
    }

    public final void setAction(@Nullable String str) {
        this.action = str;
    }

    public final void setActivityClass(@Nullable d<? extends Activity> dVar) {
        this.activityClass = dVar;
    }

    public final void setData(@Nullable Uri uri) {
        this.data = uri;
    }

    public final void setDataPattern(@Nullable String str) {
        this.dataPattern = str;
    }

    public final void setTargetPackage(@Nullable String str) {
        this.targetPackage = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavDestinationBuilder
    @NotNull
    public ActivityNavigator.Destination build() {
        ActivityNavigator.Destination destination = (ActivityNavigator.Destination) super.build();
        destination.setTargetPackage(this.targetPackage);
        d<? extends Activity> dVar = this.activityClass;
        if (dVar != null) {
            destination.setComponentName(new ComponentName(this.context, a.c(dVar)));
        }
        destination.setAction(this.action);
        destination.setData(this.data);
        destination.setDataPattern(this.dataPattern);
        return destination;
    }
}
