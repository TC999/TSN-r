package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: KType.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lkotlin/reflect/r;", "Lkotlin/reflect/b;", "Lkotlin/reflect/g;", "a", "()Lkotlin/reflect/g;", "getClassifier$annotations", "()V", "classifier", "", "Lkotlin/reflect/t;", "getArguments", "()Ljava/util/List;", "getArguments$annotations", "arguments", "", "b", "()Z", "isMarkedNullable", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface r extends b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: KType.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void a() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void b() {
        }
    }

    @Nullable
    g a();

    boolean b();

    @NotNull
    List<t> getArguments();
}
