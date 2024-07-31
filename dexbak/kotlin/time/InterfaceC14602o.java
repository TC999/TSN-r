package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: TimeSource.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0005"}, m12616d2 = {"Lkotlin/time/o;", "", "Lkotlin/time/n;", "a", "b", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalTime
/* renamed from: kotlin.time.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14602o {
    @NotNull

    /* renamed from: a */
    public static final C14603a f41668a = C14603a.f41669a;

    /* compiled from: TimeSource.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m12616d2 = {"Lkotlin/time/o$a;", "", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.time.o$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14603a {

        /* renamed from: a */
        static final /* synthetic */ C14603a f41669a = new C14603a();

        private C14603a() {
        }
    }

    /* compiled from: TimeSource.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¨\u0006\b"}, m12616d2 = {"Lkotlin/time/o$b;", "Lkotlin/time/o;", "", "toString", "Lkotlin/time/n;", "a", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.time.o$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14604b implements InterfaceC14602o {
        @NotNull

        /* renamed from: c */
        public static final C14604b f41670c = new C14604b();

        /* renamed from: b */
        private final /* synthetic */ MonoTimeSource f41671b = MonoTimeSource.f41666c;

        private C14604b() {
        }

        @Override // kotlin.time.InterfaceC14602o
        @NotNull
        /* renamed from: a */
        public AbstractC14601n mo5979a() {
            return this.f41671b.mo5979a();
        }

        @NotNull
        public String toString() {
            return MonoTimeSource.f41666c.toString();
        }
    }

    @NotNull
    /* renamed from: a */
    AbstractC14601n mo5979a();
}
