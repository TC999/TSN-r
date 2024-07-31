package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000T\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0004H\u0001\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\rH\u0001\u001a\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0010H\u0001\u001a\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u0016H\u0001¨\u0006\u0019"}, m12616d2 = {"", "primitive", "Ljava/lang/Boolean;", "a", "", "Ljava/lang/Byte;", "b", "", "Ljava/lang/Short;", "h", "", "Ljava/lang/Integer;", "f", "", "Ljava/lang/Long;", "g", "", "Ljava/lang/Float;", "e", "", "Ljava/lang/Double;", "d", "", "Ljava/lang/Character;", "c", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "Boxing")
/* renamed from: kotlin.coroutines.jvm.internal.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class boxing {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: a */
    public static final Boolean m8631a(boolean z) {
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: b */
    public static final Byte m8630b(byte b) {
        return Byte.valueOf(b);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: c */
    public static final Character m8629c(char c) {
        return new Character(c);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: d */
    public static final Double m8628d(double d) {
        return new Double(d);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: e */
    public static final Float m8627e(float f) {
        return new Float(f);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: f */
    public static final Integer m8626f(int i) {
        return new Integer(i);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: g */
    public static final Long m8625g(long j) {
        return new Long(j);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: h */
    public static final Short m8624h(short s) {
        return new Short(s);
    }
}
