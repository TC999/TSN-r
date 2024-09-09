package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.f1;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.flow.internal.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Context.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\t\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a[\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00022#\u0010\u0012\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0010\u00a2\u0006\u0002\b\u0011H\u0007\u001a\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "b", "a", "g", "Lkotlin/coroutines/f;", "context", "h", "e", "R", "flowContext", "bufferSize", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "builder", "i", "Lkotlin/f1;", "f", "(Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final /* synthetic */ class n {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<R> implements h<R> {

        /* renamed from: a */
        final /* synthetic */ h f60209a;

        /* renamed from: b */
        final /* synthetic */ int f60210b;

        /* renamed from: c */
        final /* synthetic */ d2.l f60211c;

        /* renamed from: d */
        final /* synthetic */ kotlin.coroutines.f f60212d;

        /* compiled from: Collect.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ContextKt$$special$$inlined$collect$1"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.n$a$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1216a implements i<R> {

            /* renamed from: a */
            final /* synthetic */ i f60213a;

            public C1216a(i iVar) {
                this.f60213a = iVar;
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
                Object h4;
                Object emit = this.f60213a.emit(obj, cVar);
                h4 = kotlin.coroutines.intrinsics.b.h();
                return emit == h4 ? emit : f1.f55527a;
            }
        }

        public a(h hVar, int i4, d2.l lVar, kotlin.coroutines.f fVar) {
            this.f60209a = hVar;
            this.f60210b = i4;
            this.f60211c = lVar;
            this.f60212d = fVar;
        }

        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
            h d4;
            h d5;
            Object h4;
            d4 = n.d(k.S0(this.f60209a, cVar.getContext().minusKey(e2.f59626i0)), this.f60210b, null, 2, null);
            d5 = n.d(k.S0((h) this.f60211c.invoke(d4), this.f60212d), this.f60210b, null, 2, null);
            Object e4 = d5.e(new C1216a(iVar), cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return e4 == h4 ? e4 : f1.f55527a;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    @NotNull
    public static final /* synthetic */ <T> h<T> a(@NotNull h<? extends T> hVar, int i4) {
        h<T> d4;
        d4 = d(hVar, i4, null, 2, null);
        return d4;
    }

    @NotNull
    public static final <T> h<T> b(@NotNull h<? extends T> hVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        int i5;
        BufferOverflow bufferOverflow2;
        boolean z3 = true;
        if (i4 >= 0 || i4 == -2 || i4 == -1) {
            if (i4 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z3 = false;
            }
            if (z3) {
                if (i4 == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i5 = 0;
                } else {
                    i5 = i4;
                    bufferOverflow2 = bufferOverflow;
                }
                return hVar instanceof kotlinx.coroutines.flow.internal.o ? o.a.a((kotlinx.coroutines.flow.internal.o) hVar, null, i5, bufferOverflow2, 1, null) : new kotlinx.coroutines.flow.internal.h(hVar, null, i5, bufferOverflow2, 2, null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i4).toString());
    }

    public static /* synthetic */ h c(h hVar, int i4, int i5, Object obj) {
        h a4;
        if ((i5 & 1) != 0) {
            i4 = -2;
        }
        a4 = a(hVar, i4);
        return a4;
    }

    public static /* synthetic */ h d(h hVar, int i4, BufferOverflow bufferOverflow, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = -2;
        }
        if ((i5 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return k.q(hVar, i4, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> h<T> e(@NotNull h<? extends T> hVar) {
        return hVar instanceof c ? hVar : new d(hVar);
    }

    private static final void f(kotlin.coroutines.f fVar) {
        if (fVar.get(e2.f59626i0) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + fVar).toString());
    }

    @NotNull
    public static final <T> h<T> g(@NotNull h<? extends T> hVar) {
        h<T> d4;
        d4 = d(hVar, -1, null, 2, null);
        return d4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> h<T> h(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar) {
        f(fVar);
        return kotlin.jvm.internal.f0.g(fVar, EmptyCoroutineContext.INSTANCE) ? hVar : hVar instanceof kotlinx.coroutines.flow.internal.o ? o.a.a((kotlinx.coroutines.flow.internal.o) hVar, fVar, 0, null, 6, null) : new kotlinx.coroutines.flow.internal.h(hVar, fVar, 0, null, 12, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @FlowPreview
    @NotNull
    public static final <T, R> h<R> i(@NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull d2.l<? super h<? extends T>, ? extends h<? extends R>> lVar) {
        f(fVar);
        return new a(hVar, i4, lVar, fVar);
    }

    public static /* synthetic */ h j(h hVar, kotlin.coroutines.f fVar, int i4, d2.l lVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = -2;
        }
        return k.V0(hVar, fVar, i4, lVar);
    }
}
