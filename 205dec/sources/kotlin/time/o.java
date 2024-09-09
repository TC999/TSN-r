package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TimeSource.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lkotlin/time/m;", "other", "Lkotlin/time/d;", "b", "(Lkotlin/time/m;Lkotlin/time/m;)J", "", "a", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o {

    /* compiled from: TimeSource.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lkotlin/time/o$a;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f59012a = new a();

        private a() {
        }
    }

    /* compiled from: TimeSource.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001\u00a8\u0006\b"}, d2 = {"Lkotlin/time/o$b;", "Lkotlin/time/o;", "", "toString", "Lkotlin/time/n;", "a", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b implements o {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final b f59013c = new b();

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ l f59014b = l.c;

        private b() {
        }

        @NotNull
        public n a() {
            return this.f59014b.a();
        }

        @NotNull
        public String toString() {
            return l.c.toString();
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @ExperimentalTime
    private static final int a(m mVar, m other) {
        f0.p(mVar, "<this>");
        f0.p(other, "other");
        throw new Error("Operation is disallowed.");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @ExperimentalTime
    private static final long b(m mVar, m other) {
        f0.p(mVar, "<this>");
        f0.p(other, "other");
        throw new Error("Operation is disallowed.");
    }
}
