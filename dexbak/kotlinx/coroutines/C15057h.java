package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"kotlinx/coroutines/i", "kotlinx/coroutines/j"}, m12616d2 = {}, m12615k = 4, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15057h {
    @NotNull
    /* renamed from: a */
    public static final <T> Deferred<T> m4453a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p) {
        return C15111j.m4131a(coroutineScope, coroutineContext, coroutineStart, interfaceC15284p);
    }

    @Nullable
    /* renamed from: c */
    public static final <T> Object m4451c(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return C15111j.m4129c(coroutineDispatcher, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    /* renamed from: d */
    private static final Object m4450d(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull InterfaceC15284p interfaceC15284p, @NotNull InterfaceC14268c interfaceC14268c) {
        return C15111j.m4129c(coroutineDispatcher, interfaceC15284p, interfaceC14268c);
    }

    @NotNull
    /* renamed from: e */
    public static final Job m4449e(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return C15111j.m4127e(coroutineScope, coroutineContext, coroutineStart, interfaceC15284p);
    }

    /* renamed from: f */
    public static /* synthetic */ Job m4448f(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, InterfaceC15284p interfaceC15284p, int i, Object obj) {
        return C15111j.m4126f(coroutineScope, coroutineContext, coroutineStart, interfaceC15284p, i, obj);
    }

    /* renamed from: g */
    public static final <T> T m4447g(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p) throws InterruptedException {
        return (T) C15062i.m4408a(coroutineContext, interfaceC15284p);
    }

    /* renamed from: h */
    public static /* synthetic */ Object m4446h(CoroutineContext coroutineContext, InterfaceC15284p interfaceC15284p, int i, Object obj) throws InterruptedException {
        return C15062i.m4407b(coroutineContext, interfaceC15284p, i, obj);
    }

    @Nullable
    /* renamed from: i */
    public static final <T> Object m4445i(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return C15111j.m4125g(coroutineContext, interfaceC15284p, interfaceC14268c);
    }
}
