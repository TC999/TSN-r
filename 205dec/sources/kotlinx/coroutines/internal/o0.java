package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.i3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadContext.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0000\"\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\f"}, d2 = {"Lkotlin/coroutines/f;", "context", "", "b", "countOrElement", "c", "oldState", "Lkotlin/f1;", "a", "Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/internal/j0;", "ZERO", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private static final j0 f60382a = new j0("ZERO");

    /* renamed from: b  reason: collision with root package name */
    private static final d2.p<Object, f.b, Object> f60383b = a.f60387a;

    /* renamed from: c  reason: collision with root package name */
    private static final d2.p<i3<?>, f.b, i3<?>> f60384c = b.f60388a;

    /* renamed from: d  reason: collision with root package name */
    private static final d2.p<u0, f.b, u0> f60385d = d.f60390a;

    /* renamed from: e  reason: collision with root package name */
    private static final d2.p<u0, f.b, u0> f60386e = c.f60389a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ThreadContext.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "countOrElement", "Lkotlin/coroutines/f$b;", "element", "a", "(Ljava/lang/Object;Lkotlin/coroutines/f$b;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.p<Object, f.b, Object> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f60387a = new a();

        a() {
            super(2);
        }

        @Override // d2.p
        @Nullable
        /* renamed from: a */
        public final Object invoke(@Nullable Object obj, @NotNull f.b bVar) {
            if (bVar instanceof i3) {
                if (!(obj instanceof Integer)) {
                    obj = null;
                }
                Integer num = (Integer) obj;
                int intValue = num != null ? num.intValue() : 1;
                return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
            }
            return obj;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ThreadContext.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\f\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/i3;", "found", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlinx/coroutines/i3;Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/i3;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.p<i3<?>, f.b, i3<?>> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f60388a = new b();

        b() {
            super(2);
        }

        @Override // d2.p
        @Nullable
        /* renamed from: a */
        public final i3<?> invoke(@Nullable i3<?> i3Var, @NotNull f.b bVar) {
            if (i3Var != null) {
                return i3Var;
            }
            if (!(bVar instanceof i3)) {
                bVar = null;
            }
            return (i3) bVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ThreadContext.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/internal/u0;", "state", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlinx/coroutines/internal/u0;Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/internal/u0;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.p<u0, f.b, u0> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f60389a = new c();

        c() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final u0 invoke(@NotNull u0 u0Var, @NotNull f.b bVar) {
            if (bVar instanceof i3) {
                ((i3) bVar).u(u0Var.getContext(), u0Var.c());
            }
            return u0Var;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ThreadContext.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/internal/u0;", "state", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlinx/coroutines/internal/u0;Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/internal/u0;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.p<u0, f.b, u0> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f60390a = new d();

        d() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final u0 invoke(@NotNull u0 u0Var, @NotNull f.b bVar) {
            if (bVar instanceof i3) {
                u0Var.a(((i3) bVar).Q(u0Var.getContext()));
            }
            return u0Var;
        }
    }

    public static final void a(@NotNull kotlin.coroutines.f fVar, @Nullable Object obj) {
        if (obj == f60382a) {
            return;
        }
        if (obj instanceof u0) {
            ((u0) obj).b();
            fVar.fold(obj, f60386e);
            return;
        }
        Object fold = fVar.fold(null, f60384c);
        if (fold != null) {
            ((i3) fold).u(fVar, obj);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    @NotNull
    public static final Object b(@NotNull kotlin.coroutines.f fVar) {
        Object fold = fVar.fold(0, f60383b);
        kotlin.jvm.internal.f0.m(fold);
        return fold;
    }

    @Nullable
    public static final Object c(@NotNull kotlin.coroutines.f fVar, @Nullable Object obj) {
        if (obj == null) {
            obj = b(fVar);
        }
        if (obj == 0) {
            return f60382a;
        }
        if (obj instanceof Integer) {
            return fVar.fold(new u0(fVar, ((Number) obj).intValue()), f60385d);
        }
        if (obj != null) {
            return ((i3) obj).Q(fVar);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
