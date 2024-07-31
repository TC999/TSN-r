package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"kotlinx/coroutines/i2", "kotlinx/coroutines/j2"}, m12616d2 = {}, m12615k = 4, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.h2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C15060h2 {
    /* renamed from: A */
    public static final void m4443A(@NotNull CoroutineContext coroutineContext) {
        C15113j2.m4097y(coroutineContext);
    }

    /* renamed from: B */
    public static final void m4442B(@NotNull Job job) {
        C15113j2.m4096z(job);
    }

    @NotNull
    /* renamed from: C */
    public static final Job m4441C(@NotNull CoroutineContext coroutineContext) {
        return C15113j2.m4124A(coroutineContext);
    }

    /* renamed from: D */
    public static final boolean m4440D(@NotNull CoroutineContext coroutineContext) {
        return C15113j2.m4123B(coroutineContext);
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: a */
    public static final InterfaceC15064i1 m4439a(@NotNull InterfaceC15269a<Unit> interfaceC15269a) {
        return C15113j2.m4121a(interfaceC15269a);
    }

    @NotNull
    /* renamed from: b */
    public static final CompletableJob m4438b(@Nullable Job job) {
        return C15113j2.m4120b(job);
    }

    /* renamed from: g */
    public static final void m4433g(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        C15113j2.m4115g(coroutineContext, cancellationException);
    }

    /* renamed from: h */
    public static final void m4432h(@NotNull Job job, @NotNull String str, @Nullable Throwable th) {
        C15113j2.m4114h(job, str, th);
    }

    @Nullable
    /* renamed from: m */
    public static final Object m4427m(@NotNull Job job, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return C15113j2.m4109m(job, interfaceC14268c);
    }

    /* renamed from: p */
    public static final void m4424p(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        C15113j2.m4106p(coroutineContext, cancellationException);
    }

    /* renamed from: s */
    public static final void m4421s(@NotNull Job job, @Nullable CancellationException cancellationException) {
        C15113j2.m4103s(job, cancellationException);
    }

    /* renamed from: x */
    public static final void m4416x(@NotNull InterfaceC15146o<?> interfaceC15146o, @NotNull Future<?> future) {
        Future.m4402a(interfaceC15146o, future);
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: y */
    public static final InterfaceC15064i1 m4415y(@NotNull Job job, @NotNull Future<?> future) {
        return Future.m4401b(job, future);
    }

    @NotNull
    /* renamed from: z */
    public static final InterfaceC15064i1 m4414z(@NotNull Job job, @NotNull InterfaceC15064i1 interfaceC15064i1) {
        return C15113j2.m4098x(job, interfaceC15064i1);
    }
}
