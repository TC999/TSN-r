package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0000\"\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n¨\u0006\f"}, m12616d2 = {"Lkotlin/coroutines/f;", "context", "", "b", "countOrElement", "c", "oldState", "Lkotlin/f1;", "a", "Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/internal/j0;", "ZERO", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.o0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ThreadContext {

    /* renamed from: a */
    private static final Symbol f43065a = new Symbol("ZERO");

    /* renamed from: b */
    private static final InterfaceC15284p<Object, CoroutineContext.InterfaceC14275b, Object> f43066b = C15085a.f43070a;

    /* renamed from: c */
    private static final InterfaceC15284p<ThreadContextElement<?>, CoroutineContext.InterfaceC14275b, ThreadContextElement<?>> f43067c = C15086b.f43071a;

    /* renamed from: d */
    private static final InterfaceC15284p<C15103u0, CoroutineContext.InterfaceC14275b, C15103u0> f43068d = C15088d.f43073a;

    /* renamed from: e */
    private static final InterfaceC15284p<C15103u0, CoroutineContext.InterfaceC14275b, C15103u0> f43069e = C15087c.f43072a;

    /* compiled from: ThreadContext.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"", "countOrElement", "Lkotlin/coroutines/f$b;", "element", "a", "(Ljava/lang/Object;Lkotlin/coroutines/f$b;)Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.o0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15085a extends Lambda implements InterfaceC15284p<Object, CoroutineContext.InterfaceC14275b, Object> {

        /* renamed from: a */
        public static final C15085a f43070a = new C15085a();

        C15085a() {
            super(2);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: a */
        public final Object invoke(@Nullable Object obj, @NotNull CoroutineContext.InterfaceC14275b interfaceC14275b) {
            if (interfaceC14275b instanceof ThreadContextElement) {
                if (!(obj instanceof Integer)) {
                    obj = null;
                }
                Integer num = (Integer) obj;
                int intValue = num != null ? num.intValue() : 1;
                return intValue == 0 ? interfaceC14275b : Integer.valueOf(intValue + 1);
            }
            return obj;
        }
    }

    /* compiled from: ThreadContext.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\f\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"Lkotlinx/coroutines/i3;", "found", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlinx/coroutines/i3;Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/i3;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.o0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15086b extends Lambda implements InterfaceC15284p<ThreadContextElement<?>, CoroutineContext.InterfaceC14275b, ThreadContextElement<?>> {

        /* renamed from: a */
        public static final C15086b f43071a = new C15086b();

        C15086b() {
            super(2);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: a */
        public final ThreadContextElement<?> invoke(@Nullable ThreadContextElement<?> threadContextElement, @NotNull CoroutineContext.InterfaceC14275b interfaceC14275b) {
            if (threadContextElement != null) {
                return threadContextElement;
            }
            if (!(interfaceC14275b instanceof ThreadContextElement)) {
                interfaceC14275b = null;
            }
            return (ThreadContextElement) interfaceC14275b;
        }
    }

    /* compiled from: ThreadContext.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"Lkotlinx/coroutines/internal/u0;", "state", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlinx/coroutines/internal/u0;Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/internal/u0;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.o0$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15087c extends Lambda implements InterfaceC15284p<C15103u0, CoroutineContext.InterfaceC14275b, C15103u0> {

        /* renamed from: a */
        public static final C15087c f43072a = new C15087c();

        C15087c() {
            super(2);
        }

        @Override // p617l1.InterfaceC15284p
        @NotNull
        /* renamed from: a */
        public final C15103u0 invoke(@NotNull C15103u0 c15103u0, @NotNull CoroutineContext.InterfaceC14275b interfaceC14275b) {
            if (interfaceC14275b instanceof ThreadContextElement) {
                ((ThreadContextElement) interfaceC14275b).mo3936x(c15103u0.getContext(), c15103u0.m4160c());
            }
            return c15103u0;
        }
    }

    /* compiled from: ThreadContext.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"Lkotlinx/coroutines/internal/u0;", "state", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlinx/coroutines/internal/u0;Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/internal/u0;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.o0$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15088d extends Lambda implements InterfaceC15284p<C15103u0, CoroutineContext.InterfaceC14275b, C15103u0> {

        /* renamed from: a */
        public static final C15088d f43073a = new C15088d();

        C15088d() {
            super(2);
        }

        @Override // p617l1.InterfaceC15284p
        @NotNull
        /* renamed from: a */
        public final C15103u0 invoke(@NotNull C15103u0 c15103u0, @NotNull CoroutineContext.InterfaceC14275b interfaceC14275b) {
            if (interfaceC14275b instanceof ThreadContextElement) {
                c15103u0.m4162a(((ThreadContextElement) interfaceC14275b).mo3943R(c15103u0.getContext()));
            }
            return c15103u0;
        }
    }

    /* renamed from: a */
    public static final void m4255a(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == f43065a) {
            return;
        }
        if (obj instanceof C15103u0) {
            ((C15103u0) obj).m4161b();
            coroutineContext.fold(obj, f43069e);
            return;
        }
        Object fold = coroutineContext.fold(null, f43067c);
        if (fold != null) {
            ((ThreadContextElement) fold).mo3936x(coroutineContext, obj);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    @NotNull
    /* renamed from: b */
    public static final Object m4254b(@NotNull CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f43066b);
        C14342f0.m8187m(fold);
        return fold;
    }

    @Nullable
    /* renamed from: c */
    public static final Object m4253c(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = m4254b(coroutineContext);
        }
        if (obj == 0) {
            return f43065a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new C15103u0(coroutineContext, ((Number) obj).intValue()), f43068d);
        }
        if (obj != null) {
            return ((ThreadContextElement) obj).mo3943R(coroutineContext);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
