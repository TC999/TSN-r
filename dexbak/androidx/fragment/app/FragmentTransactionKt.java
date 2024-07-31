package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FragmentTransaction.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a-\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a;\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b¨\u0006\u000b"}, m12616d2 = {"add", "Landroidx/fragment/app/FragmentTransaction;", "F", "Landroidx/fragment/app/Fragment;", "containerViewId", "", "tag", "", "args", "Landroid/os/Bundle;", "replace", "fragment-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 15})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FragmentTransactionKt {
    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(@NotNull FragmentTransaction add, @IdRes int i, @Nullable String str, @Nullable Bundle bundle) {
        C14342f0.m8183q(add, "$this$add");
        C14342f0.m8175y(4, "F");
        FragmentTransaction add2 = add.add(i, Fragment.class, bundle, str);
        C14342f0.m8192h(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        C14342f0.m8183q(add, "$this$add");
        C14342f0.m8175y(4, "F");
        FragmentTransaction add2 = add.add(i, Fragment.class, bundle, str);
        C14342f0.m8192h(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(@NotNull FragmentTransaction replace, @IdRes int i, @Nullable String str, @Nullable Bundle bundle) {
        C14342f0.m8183q(replace, "$this$replace");
        C14342f0.m8175y(4, "F");
        FragmentTransaction replace2 = replace.replace(i, Fragment.class, bundle, str);
        C14342f0.m8192h(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction replace, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        C14342f0.m8183q(replace, "$this$replace");
        C14342f0.m8175y(4, "F");
        FragmentTransaction replace2 = replace.replace(i, Fragment.class, bundle, str);
        C14342f0.m8192h(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(@NotNull FragmentTransaction add, @NotNull String tag, @Nullable Bundle bundle) {
        C14342f0.m8183q(add, "$this$add");
        C14342f0.m8183q(tag, "tag");
        C14342f0.m8175y(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        C14342f0.m8192h(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, String tag, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        C14342f0.m8183q(add, "$this$add");
        C14342f0.m8183q(tag, "tag");
        C14342f0.m8175y(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        C14342f0.m8192h(add2, "add(F::class.java, args, tag)");
        return add2;
    }
}
