package androidx.fragment.app;

import d2.l;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FragmentManager.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a0\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\t\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a:\u0010\u000b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00a8\u0006\f"}, d2 = {"Landroidx/fragment/app/FragmentManager;", "", "allowStateLoss", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "body", "commit", "commitNow", "now", "transaction", "fragment-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class FragmentManagerKt {
    public static final void commit(@NotNull FragmentManager commit, boolean z3, @NotNull l<? super FragmentTransaction, f1> body) {
        f0.q(commit, "$this$commit");
        f0.q(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        f0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z3) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager commit, boolean z3, l body, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        f0.q(commit, "$this$commit");
        f0.q(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        f0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z3) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(@NotNull FragmentManager commitNow, boolean z3, @NotNull l<? super FragmentTransaction, f1> body) {
        f0.q(commitNow, "$this$commitNow");
        f0.q(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        f0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z3) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager commitNow, boolean z3, l body, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        f0.q(commitNow, "$this$commitNow");
        f0.q(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        f0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z3) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    @Deprecated(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(@NotNull FragmentManager transaction, boolean z3, boolean z4, @NotNull l<? super FragmentTransaction, f1> body) {
        f0.q(transaction, "$this$transaction");
        f0.q(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        f0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z3) {
            if (z4) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z4) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager transaction, boolean z3, boolean z4, l body, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        f0.q(transaction, "$this$transaction");
        f0.q(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        f0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z3) {
            if (z4) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z4) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
