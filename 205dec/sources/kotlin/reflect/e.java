package kotlin.reflect;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: KClasses.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0004\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"", "T", "Lkotlin/reflect/d;", "value", "a", "(Lkotlin/reflect/d;Ljava/lang/Object;)Ljava/lang/Object;", "b", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KClasses")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @NotNull
    @LowPriorityInOverloadResolution
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T a(@NotNull d<T> dVar, @Nullable Object obj) {
        f0.p(dVar, "<this>");
        if (dVar.C(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
        }
        throw new ClassCastException(f0.C("Value cannot be cast to ", dVar.D()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @Nullable
    @LowPriorityInOverloadResolution
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T b(@NotNull d<T> dVar, @Nullable Object obj) {
        f0.p(dVar, "<this>");
        if (dVar.C(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
        }
        return null;
    }
}
