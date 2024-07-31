package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlowExceptions.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000\u001a\u0011\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0081\b¨\u0006\b"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Lkotlinx/coroutines/flow/i;", "owner", "Lkotlin/f1;", "b", "", "index", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14994m {
    @PublishedApi
    /* renamed from: a */
    public static final int m4763a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    /* renamed from: b */
    public static final void m4762b(@NotNull FlowExceptions flowExceptions, @NotNull FlowCollector<?> flowCollector) {
        if (flowExceptions.getOwner() != flowCollector) {
            throw flowExceptions;
        }
    }
}
