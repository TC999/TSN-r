package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractC14266a;
import kotlin.coroutines.AbstractC14267b;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH&J\u001c\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0017J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0017J\u0011\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0087\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016¨\u0006\u001a"}, m12616d2 = {"Lkotlinx/coroutines/l0;", "Lkotlin/coroutines/a;", "Lkotlin/coroutines/d;", "Lkotlin/coroutines/f;", "context", "", "isDispatchNeeded", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "dispatchYield", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", "continuation", "interceptContinuation", "releaseInterceptedContinuation", AdnName.OTHER, "plus", "", "toString", "<init>", "()V", "Key", "a", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.l0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class CoroutineDispatcher extends AbstractC14266a implements ContinuationInterceptor {
    public static final C15122a Key = new C15122a(null);

    /* compiled from: CoroutineDispatcher.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"Lkotlinx/coroutines/l0$a;", "Lkotlin/coroutines/b;", "Lkotlin/coroutines/d;", "Lkotlinx/coroutines/l0;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    @ExperimentalStdlibApi
    /* renamed from: kotlinx.coroutines.l0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15122a extends AbstractC14267b<ContinuationInterceptor, CoroutineDispatcher> {

        /* compiled from: CoroutineDispatcher.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlin/coroutines/f$b;", "it", "Lkotlinx/coroutines/l0;", "a", "(Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/l0;"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.l0$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C15123a extends Lambda implements InterfaceC15280l<CoroutineContext.InterfaceC14275b, CoroutineDispatcher> {

            /* renamed from: a */
            public static final C15123a f43150a = new C15123a();

            C15123a() {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            @Nullable
            /* renamed from: a */
            public final CoroutineDispatcher invoke(@NotNull CoroutineContext.InterfaceC14275b interfaceC14275b) {
                if (!(interfaceC14275b instanceof CoroutineDispatcher)) {
                    interfaceC14275b = null;
                }
                return (CoroutineDispatcher) interfaceC14275b;
            }
        }

        public /* synthetic */ C15122a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private C15122a() {
            super(ContinuationInterceptor.f41024k0, C15123a.f43150a);
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.f41024k0);
    }

    public abstract void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable);

    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.AbstractC14266a, kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
        return (E) ContinuationInterceptor.C14269a.m8677b(this, interfaceC14277c);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @NotNull
    public final <T> InterfaceC14268c<T> interceptContinuation(@NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return new DispatchedContinuation(this, interfaceC14268c);
    }

    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return true;
    }

    @Override // kotlin.coroutines.AbstractC14266a, kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
        return ContinuationInterceptor.C14269a.m8676c(this, interfaceC14277c);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @NotNull
    public final CoroutineDispatcher plus(@NotNull CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @InternalCoroutinesApi
    public void releaseInterceptedContinuation(@NotNull InterfaceC14268c<?> interfaceC14268c) {
        if (interfaceC14268c == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        }
        C15153p<?> m4308n = ((DispatchedContinuation) interfaceC14268c).m4308n();
        if (m4308n != null) {
            m4308n.m3888t();
        }
    }

    @NotNull
    public String toString() {
        return DebugStrings.m3554a(this) + '@' + DebugStrings.m3553b(this);
    }
}
