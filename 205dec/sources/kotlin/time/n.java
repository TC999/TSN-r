package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TimeSource.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lkotlin/time/n;", "", "Lkotlin/time/m;", "a", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalTime
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f59008a = a.f59009a;

    /* compiled from: TimeSource.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lkotlin/time/n$a;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f59009a = new a();

        private a() {
        }
    }

    /* compiled from: TimeSource.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lkotlin/time/n$b;", "Lkotlin/time/n;", "Lkotlin/time/m;", "a", "", "toString", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements n {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final b f59010c = new b();

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ k f59011b = k.f59006c;

        private b() {
        }

        @Override // kotlin.time.n
        @NotNull
        public m a() {
            return this.f59011b.a();
        }

        @NotNull
        public String toString() {
            return k.f59006c.toString();
        }
    }

    @NotNull
    m a();
}
