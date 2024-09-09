package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Job.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u001a\u0012\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\n\u001a\u00020\t2\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\b\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tH\u0000\u001a\u0017\u0010\r\u001a\u00020\u0007*\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0012\u001a\u00020\u0007*\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010\u0013\u001a\u00020\u0007*\u00020\u0000H\u0007\u001a\u0018\u0010\u0015\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u0007*\u00020\u00162\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010\u0018\u001a\u00020\u0007*\u00020\u0016H\u0007\u001a\n\u0010\u0019\u001a\u00020\u0007*\u00020\u0000\u001a\n\u0010\u001a\u001a\u00020\u0007*\u00020\u0016\u001a\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014\u001a\u0018\u0010\u001f\u001a\u00020\u001e*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001c\u0010 \u001a\u00020\u0007*\u00020\u00162\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010!\u001a\u00020\u0007*\u00020\u0016H\u0007\u001a\u0018\u0010\"\u001a\u00020\u0007*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001d\u0010$\u001a\u00020\u0014*\u0004\u0018\u00010\u00142\u0006\u0010#\u001a\u00020\u0000H\u0002\u00a2\u0006\u0004\b$\u0010%\"\u0015\u0010(\u001a\u00020\u001e*\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\"\u0015\u0010#\u001a\u00020\u0000*\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lkotlinx/coroutines/e2;", "parent", "Lkotlinx/coroutines/b0;", "b", "c", "(Lkotlinx/coroutines/e2;)Lkotlinx/coroutines/e2;", "Lkotlin/Function0;", "Lkotlin/f1;", "block", "Lkotlinx/coroutines/i1;", "a", "handle", "x", "m", "(Lkotlinx/coroutines/e2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "s", CampaignEx.JSON_KEY_AD_Q, "", "r", "Lkotlin/coroutines/f;", "g", "f", "z", "y", "", "message", "h", "", "i", "p", "n", "o", "job", "C", "(Ljava/lang/Throwable;Lkotlinx/coroutines/e2;)Ljava/lang/Throwable;", "B", "(Lkotlin/coroutines/f;)Z", "isActive", "A", "(Lkotlin/coroutines/f;)Lkotlinx/coroutines/e2;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/JobKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final /* synthetic */ class j2 {

    /* compiled from: Job.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"kotlinx/coroutines/j2$a", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements i1 {

        /* renamed from: a */
        final /* synthetic */ d2.a f60457a;

        public a(d2.a aVar) {
            this.f60457a = aVar;
        }

        @Override // kotlinx.coroutines.i1
        public void dispose() {
            this.f60457a.invoke();
        }
    }

    @NotNull
    public static final e2 A(@NotNull kotlin.coroutines.f fVar) {
        e2 e2Var = (e2) fVar.get(e2.f59626i0);
        if (e2Var != null) {
            return e2Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + fVar).toString());
    }

    public static final boolean B(@NotNull kotlin.coroutines.f fVar) {
        e2 e2Var = (e2) fVar.get(e2.f59626i0);
        return e2Var != null && e2Var.isActive();
    }

    private static final Throwable C(Throwable th, e2 e2Var) {
        return th != null ? th : new JobCancellationException("Job was cancelled", null, e2Var);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final i1 a(@NotNull d2.a<kotlin.f1> aVar) {
        return new a(aVar);
    }

    @NotNull
    public static final b0 b(@Nullable e2 e2Var) {
        return new g2(e2Var);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @JvmName(name = "Job")
    @NotNull
    public static final /* synthetic */ e2 c(@Nullable e2 e2Var) {
        return h2.b(e2Var);
    }

    public static /* synthetic */ b0 d(e2 e2Var, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            e2Var = null;
        }
        return h2.b(e2Var);
    }

    public static /* synthetic */ e2 e(e2 e2Var, int i4, Object obj) {
        e2 c4;
        if ((i4 & 1) != 0) {
            e2Var = null;
        }
        c4 = c(e2Var);
        return c4;
    }

    public static final void g(@NotNull kotlin.coroutines.f fVar, @Nullable CancellationException cancellationException) {
        e2 e2Var = (e2) fVar.get(e2.f59626i0);
        if (e2Var != null) {
            e2Var.b(cancellationException);
        }
    }

    public static final void h(@NotNull e2 e2Var, @NotNull String str, @Nullable Throwable th) {
        e2Var.b(r1.a(str, th));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean i(@NotNull kotlin.coroutines.f fVar, @Nullable Throwable th) {
        f.b bVar = fVar.get(e2.f59626i0);
        if (!(bVar instanceof l2)) {
            bVar = null;
        }
        l2 l2Var = (l2) bVar;
        if (l2Var != null) {
            l2Var.d0(C(th, l2Var));
            return true;
        }
        return false;
    }

    public static /* synthetic */ void j(kotlin.coroutines.f fVar, CancellationException cancellationException, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            cancellationException = null;
        }
        h2.g(fVar, cancellationException);
    }

    public static /* synthetic */ void k(e2 e2Var, String str, Throwable th, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            th = null;
        }
        h2.h(e2Var, str, th);
    }

    public static /* synthetic */ boolean l(kotlin.coroutines.f fVar, Throwable th, int i4, Object obj) {
        boolean i5;
        if ((i4 & 1) != 0) {
            th = null;
        }
        i5 = i(fVar, th);
        return i5;
    }

    @Nullable
    public static final Object m(@NotNull e2 e2Var, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        Object h4;
        e2.a.b(e2Var, null, 1, null);
        Object A = e2Var.A(cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return A == h4 ? A : kotlin.f1.f55527a;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void o(@NotNull kotlin.coroutines.f fVar, @Nullable Throwable th) {
        e2 e2Var = (e2) fVar.get(e2.f59626i0);
        if (e2Var != null) {
            for (e2 e2Var2 : e2Var.h()) {
                if (!(e2Var2 instanceof l2)) {
                    e2Var2 = null;
                }
                l2 l2Var = (l2) e2Var2;
                if (l2Var != null) {
                    l2Var.d0(C(th, e2Var));
                }
            }
        }
    }

    public static final void p(@NotNull kotlin.coroutines.f fVar, @Nullable CancellationException cancellationException) {
        kotlin.sequences.m<e2> h4;
        e2 e2Var = (e2) fVar.get(e2.f59626i0);
        if (e2Var == null || (h4 = e2Var.h()) == null) {
            return;
        }
        for (e2 e2Var2 : h4) {
            e2Var2.b(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void r(@NotNull e2 e2Var, @Nullable Throwable th) {
        for (e2 e2Var2 : e2Var.h()) {
            if (!(e2Var2 instanceof l2)) {
                e2Var2 = null;
            }
            l2 l2Var = (l2) e2Var2;
            if (l2Var != null) {
                l2Var.d0(C(th, e2Var));
            }
        }
    }

    public static final void s(@NotNull e2 e2Var, @Nullable CancellationException cancellationException) {
        for (e2 e2Var2 : e2Var.h()) {
            e2Var2.b(cancellationException);
        }
    }

    public static /* synthetic */ void t(kotlin.coroutines.f fVar, Throwable th, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            th = null;
        }
        o(fVar, th);
    }

    public static /* synthetic */ void u(kotlin.coroutines.f fVar, CancellationException cancellationException, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            cancellationException = null;
        }
        h2.p(fVar, cancellationException);
    }

    public static /* synthetic */ void v(e2 e2Var, Throwable th, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            th = null;
        }
        r(e2Var, th);
    }

    public static /* synthetic */ void w(e2 e2Var, CancellationException cancellationException, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            cancellationException = null;
        }
        h2.s(e2Var, cancellationException);
    }

    @NotNull
    public static final i1 x(@NotNull e2 e2Var, @NotNull i1 i1Var) {
        return e2Var.m(new k1(e2Var, i1Var));
    }

    public static final void y(@NotNull kotlin.coroutines.f fVar) {
        e2 e2Var = (e2) fVar.get(e2.f59626i0);
        if (e2Var != null) {
            h2.B(e2Var);
        }
    }

    public static final void z(@NotNull e2 e2Var) {
        if (!e2Var.isActive()) {
            throw e2Var.l();
        }
    }
}
