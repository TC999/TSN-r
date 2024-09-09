package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Ranges.kt */
@SinceKotlin(version = "1.1")
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\t\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lkotlin/ranges/f;", "", "T", "Lkotlin/ranges/g;", "value", "", "contains", "(Ljava/lang/Comparable;)Z", "isEmpty", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface f<T extends Comparable<? super T>> extends g<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Ranges.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@NotNull f<T> fVar, @NotNull T value) {
            f0.p(fVar, "this");
            f0.p(value, "value");
            return fVar.a(fVar.getStart(), value) && fVar.a(value, fVar.getEndInclusive());
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull f<T> fVar) {
            f0.p(fVar, "this");
            return !fVar.a(fVar.getStart(), fVar.getEndInclusive());
        }
    }

    boolean a(@NotNull T t3, @NotNull T t4);

    @Override // kotlin.ranges.g
    boolean contains(@NotNull T t3);

    @Override // kotlin.ranges.g
    boolean isEmpty();
}
