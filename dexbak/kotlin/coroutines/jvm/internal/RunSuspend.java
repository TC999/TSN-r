package kotlin.coroutines.jvm.internal;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0005\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0002R0\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, m12616d2 = {"Lkotlin/coroutines/jvm/internal/g;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "Lkotlin/Result;", CommonNetImpl.RESULT, "resumeWith", "(Ljava/lang/Object;)V", "b", "a", "Lkotlin/Result;", "c", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.jvm.internal.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class RunSuspend implements InterfaceC14268c<Unit> {
    @Nullable

    /* renamed from: a */
    private Result<Unit> f41040a;

    /* renamed from: b */
    public final void m8613b() {
        synchronized (this) {
            while (true) {
                Result<Unit> result = this.f41040a;
                if (result == null) {
                    wait();
                } else {
                    C14294d0.m8596n(result.m60157unboximpl());
                }
            }
        }
    }

    @Nullable
    /* renamed from: c */
    public final Result<Unit> m8612c() {
        return this.f41040a;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public void resumeWith(@NotNull Object obj) {
        synchronized (this) {
            this.f41040a = Result.m60147boximpl(obj);
            notifyAll();
            Unit unit = Unit.f41048a;
        }
    }

    public final void setResult(@Nullable Result<Unit> result) {
        this.f41040a = result;
    }
}
