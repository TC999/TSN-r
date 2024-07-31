package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: ThreadContext.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u001a\u001a\u00028\u0000\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\u00020\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016J*\u0010\u0010\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u000f*\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001e\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, m12616d2 = {"Lkotlinx/coroutines/internal/p0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/i3;", "Lkotlin/coroutines/f;", "context", "R", "(Lkotlin/coroutines/f;)Ljava/lang/Object;", "oldState", "Lkotlin/f1;", "x", "(Lkotlin/coroutines/f;Ljava/lang/Object;)V", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "minusKey", "Lkotlin/coroutines/f$b;", ExifInterface.LONGITUDE_EAST, "get", "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "", "toString", "a", "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", "b", "Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Ljava/lang/ThreadLocal;", "c", "Ljava/lang/ThreadLocal;", "threadLocal", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.p0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15090p0<T> implements ThreadContextElement<T> {
    @NotNull

    /* renamed from: a */
    private final CoroutineContext.InterfaceC14277c<?> f43074a;

    /* renamed from: b */
    private final T f43075b;

    /* renamed from: c */
    private final ThreadLocal<T> f43076c;

    public C15090p0(T t, @NotNull ThreadLocal<T> threadLocal) {
        this.f43075b = t;
        this.f43076c = threadLocal;
        this.f43074a = new C15092q0(threadLocal);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* renamed from: R */
    public T mo3943R(@NotNull CoroutineContext coroutineContext) {
        T t = this.f43076c.get();
        this.f43076c.set(this.f43075b);
        return t;
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
        return (R) ThreadContextElement.C15065a.m4400a(this, r, interfaceC15284p);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
        if (C14342f0.m8193g(getKey(), interfaceC14277c)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b
    @NotNull
    public CoroutineContext.InterfaceC14277c<?> getKey() {
        return this.f43074a;
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
        return C14342f0.m8193g(getKey(), interfaceC14277c) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return ThreadContextElement.C15065a.m4397d(this, coroutineContext);
    }

    @NotNull
    public String toString() {
        return "ThreadLocal(value=" + this.f43075b + ", threadLocal = " + this.f43076c + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* renamed from: x */
    public void mo3936x(@NotNull CoroutineContext coroutineContext, T t) {
        this.f43076c.set(t);
    }
}
