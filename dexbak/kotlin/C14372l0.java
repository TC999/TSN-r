package kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Tuples.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0001H\u0086\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003\u001a(\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t¨\u0006\u000b"}, m12616d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "that", "Lkotlin/Pair;", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "", "b", "Lkotlin/Triple;", "c", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "TuplesKt")
/* renamed from: kotlin.l0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14372l0 {
    @NotNull
    /* renamed from: a */
    public static final <A, B> Tuples<A, B> m7952a(A a, B b) {
        return new Tuples<>(a, b);
    }

    @NotNull
    /* renamed from: b */
    public static final <T> List<T> m7951b(@NotNull Tuples<? extends T, ? extends T> toList) {
        List<T> m12471L;
        C14342f0.m8184p(toList, "$this$toList");
        m12471L = CollectionsKt__CollectionsKt.m12471L(toList.getFirst(), toList.getSecond());
        return m12471L;
    }

    @NotNull
    /* renamed from: c */
    public static final <T> List<T> m7950c(@NotNull Triple<? extends T, ? extends T, ? extends T> toList) {
        List<T> m12471L;
        C14342f0.m8184p(toList, "$this$toList");
        m12471L = CollectionsKt__CollectionsKt.m12471L(toList.getFirst(), toList.getSecond(), toList.getThird());
        return m12471L;
    }
}
