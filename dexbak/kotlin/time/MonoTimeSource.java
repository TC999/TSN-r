package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, m12616d2 = {"Lkotlin/time/l;", "Lkotlin/time/b;", "Lkotlin/time/o;", "", "c", "", "toString", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalTime
/* renamed from: kotlin.time.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class MonoTimeSource extends AbstractC14594b implements InterfaceC14602o {
    @NotNull

    /* renamed from: c */
    public static final MonoTimeSource f41666c = new MonoTimeSource();

    private MonoTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.time.AbstractC14594b
    /* renamed from: c */
    protected long mo5987c() {
        return System.nanoTime();
    }

    @NotNull
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
