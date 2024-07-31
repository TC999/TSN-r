package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m12616d2 = {"Lkotlinx/coroutines/i3;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "context", "R", "(Lkotlin/coroutines/f;)Ljava/lang/Object;", "oldState", "Lkotlin/f1;", "x", "(Lkotlin/coroutines/f;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.i3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ThreadContextElement<S> extends CoroutineContext.InterfaceC14275b {

    /* compiled from: ThreadContextElement.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.i3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15065a {
        /* renamed from: a */
        public static <S, R> R m4400a(@NotNull ThreadContextElement<S> threadContextElement, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
            return (R) CoroutineContext.InterfaceC14275b.C14276a.m8661a(threadContextElement, r, interfaceC15284p);
        }

        @Nullable
        /* renamed from: b */
        public static <S, E extends CoroutineContext.InterfaceC14275b> E m4399b(@NotNull ThreadContextElement<S> threadContextElement, @NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
            return (E) CoroutineContext.InterfaceC14275b.C14276a.m8660b(threadContextElement, interfaceC14277c);
        }

        @NotNull
        /* renamed from: c */
        public static <S> CoroutineContext m4398c(@NotNull ThreadContextElement<S> threadContextElement, @NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
            return CoroutineContext.InterfaceC14275b.C14276a.m8659c(threadContextElement, interfaceC14277c);
        }

        @NotNull
        /* renamed from: d */
        public static <S> CoroutineContext m4397d(@NotNull ThreadContextElement<S> threadContextElement, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.InterfaceC14275b.C14276a.m8658d(threadContextElement, coroutineContext);
        }
    }

    /* renamed from: R */
    S mo3943R(@NotNull CoroutineContext coroutineContext);

    /* renamed from: x */
    void mo3936x(@NotNull CoroutineContext coroutineContext, S s);
}
