package kotlinx.coroutines.channels;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.f1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Actor.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u009e\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062-\b\u0002\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000e2-\u0010\u0015\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010\u00a2\u0006\u0002\b\u0014H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"E", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/f;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/channels/h0;", "a", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILkotlinx/coroutines/CoroutineStart;Ld2/l;Ld2/p;)Lkotlinx/coroutines/channels/h0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> h0<E> a(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull CoroutineStart coroutineStart, @Nullable d2.l<? super Throwable, f1> lVar, @NotNull d2.p<? super f<E>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        d dVar;
        kotlin.coroutines.f d4 = kotlinx.coroutines.k0.d(q0Var, fVar);
        n d5 = q.d(i4, null, null, 6, null);
        if (coroutineStart.isLazy()) {
            dVar = new w(d4, d5, pVar);
        } else {
            dVar = new d(d4, d5, true);
        }
        if (lVar != null) {
            ((l2) dVar).m(lVar);
        }
        ((kotlinx.coroutines.a) dVar).r1(coroutineStart, dVar, pVar);
        return dVar;
    }

    public static /* synthetic */ h0 b(q0 q0Var, kotlin.coroutines.f fVar, int i4, CoroutineStart coroutineStart, d2.l lVar, d2.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        kotlin.coroutines.f fVar2 = fVar;
        int i6 = (i5 & 2) != 0 ? 0 : i4;
        if ((i5 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i5 & 8) != 0) {
            lVar = null;
        }
        return a(q0Var, fVar2, i6, coroutineStart2, lVar, pVar);
    }
}
