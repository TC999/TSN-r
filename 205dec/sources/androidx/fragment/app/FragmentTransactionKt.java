package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FragmentTransaction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a-\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a;\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u00a8\u0006\u000b"}, d2 = {"add", "Landroidx/fragment/app/FragmentTransaction;", "F", "Landroidx/fragment/app/Fragment;", "containerViewId", "", "tag", "", "args", "Landroid/os/Bundle;", "replace", "fragment-ktx_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class FragmentTransactionKt {
    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(@NotNull FragmentTransaction add, @IdRes int i4, @Nullable String str, @Nullable Bundle bundle) {
        f0.q(add, "$this$add");
        f0.y(4, "F");
        FragmentTransaction add2 = add.add(i4, Fragment.class, bundle, str);
        f0.h(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, int i4, String str, Bundle bundle, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            bundle = null;
        }
        f0.q(add, "$this$add");
        f0.y(4, "F");
        FragmentTransaction add2 = add.add(i4, Fragment.class, bundle, str);
        f0.h(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(@NotNull FragmentTransaction replace, @IdRes int i4, @Nullable String str, @Nullable Bundle bundle) {
        f0.q(replace, "$this$replace");
        f0.y(4, "F");
        FragmentTransaction replace2 = replace.replace(i4, Fragment.class, bundle, str);
        f0.h(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction replace, int i4, String str, Bundle bundle, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            bundle = null;
        }
        f0.q(replace, "$this$replace");
        f0.y(4, "F");
        FragmentTransaction replace2 = replace.replace(i4, Fragment.class, bundle, str);
        f0.h(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(@NotNull FragmentTransaction add, @NotNull String tag, @Nullable Bundle bundle) {
        f0.q(add, "$this$add");
        f0.q(tag, "tag");
        f0.y(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        f0.h(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, String tag, Bundle bundle, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            bundle = null;
        }
        f0.q(add, "$this$add");
        f0.q(tag, "tag");
        f0.y(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        f0.h(add2, "add(F::class.java, args, tag)");
        return add2;
    }
}
