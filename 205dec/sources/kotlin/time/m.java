package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TimeSource.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0003\u001a\u00020\u0002H&\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u000e"}, d2 = {"Lkotlin/time/m;", "", "Lkotlin/time/d;", "a", "()J", "duration", "e", "(J)Lkotlin/time/m;", "d", "", "c", "b", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalTime
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class m {
    public abstract long a();

    public final boolean b() {
        return d.f0(a());
    }

    public final boolean c() {
        return !d.f0(a());
    }

    @NotNull
    public m d(long j4) {
        return e(d.y0(j4));
    }

    @NotNull
    public m e(long j4) {
        return new c(this, j4, null);
    }
}
