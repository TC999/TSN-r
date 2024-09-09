package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OnBackPressedDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\n\u001a\u00020\u0006*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\b\b\u00a8\u0006\u000b"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "enabled", "Lkotlin/Function1;", "Landroidx/activity/OnBackPressedCallback;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "onBackPressed", "addCallback", "activity-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class OnBackPressedDispatcherKt {
    @NotNull
    public static final OnBackPressedCallback addCallback(@NotNull OnBackPressedDispatcher addCallback, @Nullable LifecycleOwner lifecycleOwner, final boolean z3, @NotNull final l<? super OnBackPressedCallback, f1> onBackPressed) {
        f0.q(addCallback, "$this$addCallback");
        f0.q(onBackPressed, "onBackPressed");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(z3) { // from class: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                l.this.invoke(this);
            }
        };
        if (lifecycleOwner != null) {
            addCallback.addCallback(lifecycleOwner, onBackPressedCallback);
        } else {
            addCallback.addCallback(onBackPressedCallback);
        }
        return onBackPressedCallback;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z3, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i4 & 2) != 0) {
            z3 = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z3, lVar);
    }
}
