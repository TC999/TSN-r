package kotlin.coroutines.jvm.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Serializable;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0019\u0012\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H$ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0014J\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R!\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m12616d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/c;", "", "Lkotlin/coroutines/jvm/internal/c;", "Ljava/io/Serializable;", "Lkotlin/Result;", CommonNetImpl.RESULT, "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "completion", "create", DomainCampaignEx.LOOPBACK_VALUE, "", "toString", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/coroutines/c;", "getCompletion", "()Lkotlin/coroutines/c;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "<init>", "(Lkotlin/coroutines/c;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class BaseContinuationImpl implements InterfaceC14268c<Object>, CoroutineStackFrame, Serializable {
    @Nullable
    private final InterfaceC14268c<Object> completion;

    public BaseContinuationImpl(@Nullable InterfaceC14268c<Object> interfaceC14268c) {
        this.completion = interfaceC14268c;
    }

    @NotNull
    public InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8184p(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        InterfaceC14268c<Object> interfaceC14268c = this.completion;
        if (!(interfaceC14268c instanceof CoroutineStackFrame)) {
            interfaceC14268c = null;
        }
        return (CoroutineStackFrame) interfaceC14268c;
    }

    @Nullable
    public final InterfaceC14268c<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return C14289d.m8619e(this);
    }

    @Nullable
    protected abstract Object invokeSuspend(@NotNull Object obj);

    protected void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public final void resumeWith(@NotNull Object obj) {
        Object invokeSuspend;
        Object m8642h;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            DebugProbes.m8617b(baseContinuationImpl);
            InterfaceC14268c<Object> interfaceC14268c = baseContinuationImpl.completion;
            C14342f0.m8187m(interfaceC14268c);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                m8642h = C14287b.m8642h();
            } catch (Throwable th) {
                Result.C14124a c14124a = Result.Companion;
                obj = Result.m60148constructorimpl(C14294d0.m8609a(th));
            }
            if (invokeSuspend == m8642h) {
                return;
            }
            Result.C14124a c14124a2 = Result.Companion;
            obj = Result.m60148constructorimpl(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (interfaceC14268c instanceof BaseContinuationImpl) {
                baseContinuationImpl = (BaseContinuationImpl) interfaceC14268c;
            } else {
                interfaceC14268c.resumeWith(obj);
                return;
            }
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @NotNull
    public InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8184p(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
