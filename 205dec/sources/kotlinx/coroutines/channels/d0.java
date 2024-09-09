package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Channel.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u00a7@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0007\u0010\u0004J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u00a6\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH&J\b\u0010\u0011\u001a\u00020\u000fH\u0017J\u0014\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0012H'R\u001a\u0010\u0019\u001a\u00020\u00138&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00138&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001c8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b \u0010\u0018\u001a\u0004\b\u0001\u0010\u001eR)\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u001c8&X\u00a7\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b#\u0010\u0018\u001a\u0004\b\"\u0010\u001e\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006%"}, d2 = {"Lkotlinx/coroutines/channels/d0;", "E", "", "J", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "F", "Lkotlinx/coroutines/channels/m0;", "w", "poll", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/p;", "iterator", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lkotlin/f1;", "b", "cancel", "", "", "a", "g", "()Z", "isClosedForReceive$annotations", "()V", "isClosedForReceive", "isEmpty", "isEmpty$annotations", "Lkotlinx/coroutines/selects/d;", "C", "()Lkotlinx/coroutines/selects/d;", "onReceive", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "L", "getOnReceiveOrClosed$annotations", "onReceiveOrClosed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface d0<E> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Channel.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        public static /* synthetic */ void b(d0 d0Var, CancellationException cancellationException, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    cancellationException = null;
                }
                d0Var.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean c(d0 d0Var, Throwable th, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    th = null;
                }
                return d0Var.a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @InternalCoroutinesApi
        public static /* synthetic */ void d() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of onReceiveOrClosed and onReceiveOrNull extension", replaceWith = @ReplaceWith(expression = "onReceiveOrNull", imports = {"kotlinx.coroutines.channels.onReceiveOrNull"}))
        @LowPriorityInOverloadResolution
        @ObsoleteCoroutinesApi
        public static /* synthetic */ void e() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void f() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void g() {
        }
    }

    @NotNull
    kotlinx.coroutines.selects.d<E> C();

    @NotNull
    kotlinx.coroutines.selects.d<E> E();

    @ObsoleteCoroutinesApi
    @Nullable
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    Object F(@NotNull kotlin.coroutines.c<? super E> cVar);

    @Nullable
    Object J(@NotNull kotlin.coroutines.c<? super E> cVar);

    @NotNull
    kotlinx.coroutines.selects.d<m0<E>> L();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean a(@Nullable Throwable th);

    void b(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    boolean g();

    boolean isEmpty();

    @NotNull
    p<E> iterator();

    @Nullable
    E poll();

    @InternalCoroutinesApi
    @Nullable
    Object w(@NotNull kotlin.coroutines.c<? super m0<? extends E>> cVar);
}
