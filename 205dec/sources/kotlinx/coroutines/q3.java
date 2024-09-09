package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Timeout.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00020\bH\u0010\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/q3;", "U", "T", "Lkotlinx/coroutines/internal/f0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlin/f1;", "run", "", "M0", "()Ljava/lang/String;", "", "e", "J", "time", "Lkotlin/coroutines/c;", "uCont", "<init>", "(JLkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class q3<U, T extends U> extends kotlinx.coroutines.internal.f0<T> implements Runnable {
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public final long f60544e;

    public q3(long j4, @NotNull kotlin.coroutines.c<? super U> cVar) {
        super(cVar.getContext(), cVar);
        this.f60544e = j4;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.l2
    @NotNull
    public String M0() {
        return super.M0() + "(timeMillis=" + this.f60544e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        b0(r3.a(this.f60544e, this));
    }
}
