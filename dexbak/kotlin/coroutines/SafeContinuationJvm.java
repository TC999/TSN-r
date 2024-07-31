package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.channel.C13675a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.Intrinsics;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0001\u0010B!\b\u0000\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001b\u0010\u001cB\u0017\b\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001b\u0010\u001dJ \u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, m12616d2 = {"Lkotlin/coroutines/h;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlin/Result;", CommonNetImpl.RESULT, "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "", "b", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "", "toString", "Ljava/lang/Object;", "a", "Lkotlin/coroutines/c;", "delegate", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "initialResult", "<init>", "(Lkotlin/coroutines/c;Ljava/lang/Object;)V", "(Lkotlin/coroutines/c;)V", "c", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@PublishedApi
/* renamed from: kotlin.coroutines.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SafeContinuationJvm<T> implements InterfaceC14268c<T>, CoroutineStackFrame {

    /* renamed from: a */
    private final InterfaceC14268c<T> f41031a;
    private volatile Object result;
    @NotNull

    /* renamed from: c */
    private static final C14279a f41030c = new C14279a(null);
    @Deprecated

    /* renamed from: b */
    private static final AtomicReferenceFieldUpdater<SafeContinuationJvm<?>, Object> f41029b = AtomicReferenceFieldUpdater.newUpdater(SafeContinuationJvm.class, Object.class, CommonNetImpl.RESULT);

    /* compiled from: SafeContinuationJvm.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\bRj\u0010\u0005\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001 \u0004*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b¨\u0006\n"}, m12616d2 = {"Lkotlin/coroutines/h$a;", "", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/h;", "kotlin.jvm.PlatformType", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "getRESULT$annotations", "()V", "<init>", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14279a {
        private C14279a() {
        }

        /* renamed from: a */
        private static /* synthetic */ void m8654a() {
        }

        public /* synthetic */ C14279a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuationJvm(@NotNull InterfaceC14268c<? super T> delegate, @Nullable Object obj) {
        C14342f0.m8184p(delegate, "delegate");
        this.f41031a = delegate;
        this.result = obj;
    }

    @PublishedApi
    @Nullable
    /* renamed from: b */
    public final Object m8655b() {
        Object m8642h;
        Object m8642h2;
        Object m8642h3;
        Object obj = this.result;
        Intrinsics intrinsics = Intrinsics.UNDECIDED;
        if (obj == intrinsics) {
            AtomicReferenceFieldUpdater<SafeContinuationJvm<?>, Object> atomicReferenceFieldUpdater = f41029b;
            m8642h2 = C14287b.m8642h();
            if (C13675a.m12692a(atomicReferenceFieldUpdater, this, intrinsics, m8642h2)) {
                m8642h3 = C14287b.m8642h();
                return m8642h3;
            }
            obj = this.result;
        }
        if (obj == Intrinsics.RESUMED) {
            m8642h = C14287b.m8642h();
            return m8642h;
        } else if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        } else {
            return obj;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        InterfaceC14268c<T> interfaceC14268c = this.f41031a;
        if (!(interfaceC14268c instanceof CoroutineStackFrame)) {
            interfaceC14268c = null;
        }
        return (CoroutineStackFrame) interfaceC14268c;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        return this.f41031a.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public void resumeWith(@NotNull Object obj) {
        Object m8642h;
        Object m8642h2;
        while (true) {
            Object obj2 = this.result;
            Intrinsics intrinsics = Intrinsics.UNDECIDED;
            if (obj2 != intrinsics) {
                m8642h = C14287b.m8642h();
                if (obj2 != m8642h) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater<SafeContinuationJvm<?>, Object> atomicReferenceFieldUpdater = f41029b;
                m8642h2 = C14287b.m8642h();
                if (C13675a.m12692a(atomicReferenceFieldUpdater, this, m8642h2, Intrinsics.RESUMED)) {
                    this.f41031a.resumeWith(obj);
                    return;
                }
            } else if (C13675a.m12692a(f41029b, this, intrinsics, obj)) {
                return;
            }
        }
    }

    @NotNull
    public String toString() {
        return "SafeContinuation for " + this.f41031a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public SafeContinuationJvm(@NotNull InterfaceC14268c<? super T> delegate) {
        this(delegate, Intrinsics.UNDECIDED);
        C14342f0.m8184p(delegate, "delegate");
    }
}
