package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0011J\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, m12616d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/c;", "", "intercepted", "Lkotlin/f1;", "releaseIntercepted", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/f;", "_context", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "completion", "<init>", "(Lkotlin/coroutines/c;Lkotlin/coroutines/f;)V", "(Lkotlin/coroutines/c;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient InterfaceC14268c<Object> intercepted;

    public ContinuationImpl(@Nullable InterfaceC14268c<Object> interfaceC14268c, @Nullable CoroutineContext coroutineContext) {
        super(interfaceC14268c);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        C14342f0.m8187m(coroutineContext);
        return coroutineContext;
    }

    @NotNull
    public final InterfaceC14268c<Object> intercepted() {
        InterfaceC14268c<Object> interfaceC14268c = this.intercepted;
        if (interfaceC14268c == null) {
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) getContext().get(ContinuationInterceptor.f41024k0);
            if (continuationInterceptor == null || (interfaceC14268c = continuationInterceptor.interceptContinuation(this)) == null) {
                interfaceC14268c = this;
            }
            this.intercepted = interfaceC14268c;
        }
        return interfaceC14268c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        InterfaceC14268c<?> interfaceC14268c = this.intercepted;
        if (interfaceC14268c != null && interfaceC14268c != this) {
            CoroutineContext.InterfaceC14275b interfaceC14275b = getContext().get(ContinuationInterceptor.f41024k0);
            C14342f0.m8187m(interfaceC14275b);
            ((ContinuationInterceptor) interfaceC14275b).releaseInterceptedContinuation(interfaceC14268c);
        }
        this.intercepted = C14288b.f41032a;
    }

    public ContinuationImpl(@Nullable InterfaceC14268c<Object> interfaceC14268c) {
        this(interfaceC14268c, interfaceC14268c != null ? interfaceC14268c.getContext() : null);
    }
}
