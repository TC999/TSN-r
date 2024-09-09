package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: boxing.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0004H\u0001\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\rH\u0001\u001a\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0010H\u0001\u001a\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u0016H\u0001\u00a8\u0006\u0019"}, d2 = {"", "primitive", "Ljava/lang/Boolean;", "a", "", "Ljava/lang/Byte;", "b", "", "Ljava/lang/Short;", "h", "", "Ljava/lang/Integer;", "f", "", "Ljava/lang/Long;", "g", "", "Ljava/lang/Float;", "e", "", "Ljava/lang/Double;", "d", "", "Ljava/lang/Character;", "c", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "Boxing")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Boolean a(boolean z3) {
        return Boolean.valueOf(z3);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Byte b(byte b4) {
        return Byte.valueOf(b4);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Character c(char c4) {
        return new Character(c4);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Double d(double d4) {
        return new Double(d4);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Float e(float f4) {
        return new Float(f4);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Integer f(int i4) {
        return new Integer(i4);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Long g(long j4) {
        return new Long(j4);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Short h(short s3) {
        return new Short(s3);
    }
}
