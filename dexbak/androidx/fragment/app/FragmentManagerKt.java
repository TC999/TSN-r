package androidx.fragment.app;

import kotlin.Annotations;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: FragmentManager.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a0\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\t\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a:\u0010\u000b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\b¨\u0006\f"}, m12616d2 = {"Landroidx/fragment/app/FragmentManager;", "", "allowStateLoss", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "body", "commit", "commitNow", "now", "transaction", "fragment-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FragmentManagerKt {
    public static final void commit(@NotNull FragmentManager commit, boolean z, @NotNull InterfaceC15280l<? super FragmentTransaction, Unit> body) {
        C14342f0.m8183q(commit, "$this$commit");
        C14342f0.m8183q(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        C14342f0.m8192h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager commit, boolean z, InterfaceC15280l body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        C14342f0.m8183q(commit, "$this$commit");
        C14342f0.m8183q(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        C14342f0.m8192h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(@NotNull FragmentManager commitNow, boolean z, @NotNull InterfaceC15280l<? super FragmentTransaction, Unit> body) {
        C14342f0.m8183q(commitNow, "$this$commitNow");
        C14342f0.m8183q(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        C14342f0.m8192h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager commitNow, boolean z, InterfaceC15280l body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        C14342f0.m8183q(commitNow, "$this$commitNow");
        C14342f0.m8183q(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        C14342f0.m8192h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    @Annotations(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(@NotNull FragmentManager transaction, boolean z, boolean z2, @NotNull InterfaceC15280l<? super FragmentTransaction, Unit> body) {
        C14342f0.m8183q(transaction, "$this$transaction");
        C14342f0.m8183q(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        C14342f0.m8192h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            if (z2) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z2) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager transaction, boolean z, boolean z2, InterfaceC15280l body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        C14342f0.m8183q(transaction, "$this$transaction");
        C14342f0.m8183q(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        C14342f0.m8192h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            if (z2) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z2) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
