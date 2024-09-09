package kotlinx.coroutines.flow.internal;

import cn.jpush.android.api.InAppSlotParams;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.flow.h0;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractSharedFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007\u00a2\u0006\u0004\b*\u0010\u001aJ\u000f\u0010\u0005\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H$\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0011H\u0084\bR>\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0004@BX\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00078\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070'8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010(\u00a8\u0006+"}, d2 = {"Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/internal/c;", "S", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "l", "()Lkotlinx/coroutines/flow/internal/c;", "", "size", "", "m", "(I)[Lkotlinx/coroutines/flow/internal/c;", "k", InAppSlotParams.SLOT_KEY.SLOT, "Lkotlin/f1;", "o", "(Lkotlinx/coroutines/flow/internal/c;)V", "Lkotlin/Function1;", "block", "n", "<set-?>", "a", "[Lkotlinx/coroutines/flow/internal/c;", CampaignEx.JSON_KEY_AD_Q, "()[Lkotlinx/coroutines/flow/internal/c;", "getSlots$annotations", "()V", "slots", "b", "I", "p", "()I", "nCollectors", "c", "nextIndex", "Lkotlinx/coroutines/flow/t;", "d", "Lkotlinx/coroutines/flow/t;", "_subscriptionCount", "Lkotlinx/coroutines/flow/h0;", "()Lkotlinx/coroutines/flow/h0;", "subscriptionCount", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a<S extends c<?>> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private S[] f60125a;

    /* renamed from: b  reason: collision with root package name */
    private int f60126b;

    /* renamed from: c  reason: collision with root package name */
    private int f60127c;

    /* renamed from: d  reason: collision with root package name */
    private kotlinx.coroutines.flow.t<Integer> f60128d;

    protected static /* synthetic */ void r() {
    }

    @NotNull
    public final h0<Integer> c() {
        kotlinx.coroutines.flow.t<Integer> tVar;
        synchronized (this) {
            tVar = this.f60128d;
            if (tVar == null) {
                tVar = j0.a(Integer.valueOf(this.f60126b));
                this.f60128d = tVar;
            }
        }
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final S k() {
        S s3;
        kotlinx.coroutines.flow.t<Integer> tVar;
        synchronized (this) {
            S[] sArr = this.f60125a;
            if (sArr == null) {
                sArr = m(2);
                this.f60125a = sArr;
            } else if (this.f60126b >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                f0.o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.f60125a = (S[]) ((c[]) copyOf);
                sArr = (S[]) ((c[]) copyOf);
            }
            int i4 = this.f60127c;
            do {
                s3 = sArr[i4];
                if (s3 == null) {
                    s3 = l();
                    sArr[i4] = s3;
                }
                i4++;
                if (i4 >= sArr.length) {
                    i4 = 0;
                }
                if (s3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                }
            } while (!s3.a(this));
            this.f60127c = i4;
            this.f60126b++;
            tVar = this.f60128d;
        }
        if (tVar != null) {
            j0.g(tVar, 1);
        }
        return s3;
    }

    @NotNull
    protected abstract S l();

    @NotNull
    protected abstract S[] m(int i4);

    protected final void n(@NotNull d2.l<? super S, f1> lVar) {
        c[] cVarArr;
        if (this.f60126b == 0 || (cVarArr = this.f60125a) == null) {
            return;
        }
        for (c cVar : cVarArr) {
            if (cVar != null) {
                lVar.invoke(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(@NotNull S s3) {
        kotlinx.coroutines.flow.t<Integer> tVar;
        int i4;
        kotlin.coroutines.c<f1>[] b4;
        synchronized (this) {
            int i5 = this.f60126b - 1;
            this.f60126b = i5;
            tVar = this.f60128d;
            if (i5 == 0) {
                this.f60127c = 0;
            }
            if (s3 != null) {
                b4 = s3.b(this);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            }
        }
        for (kotlin.coroutines.c<f1> cVar : b4) {
            if (cVar != null) {
                f1 f1Var = f1.f55527a;
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m119constructorimpl(f1Var));
            }
        }
        if (tVar != null) {
            j0.g(tVar, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int p() {
        return this.f60126b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final S[] q() {
        return this.f60125a;
    }
}
