package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineStackFrame.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lkotlin/coroutines/jvm/internal/c;", "", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface c {
    @Nullable
    c getCallerFrame();

    @Nullable
    StackTraceElement getStackTraceElement();
}
