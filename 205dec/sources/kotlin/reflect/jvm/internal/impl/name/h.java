package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpecialNames.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final h f57577a = new h();
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final f f57578b;
    @JvmField
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final f f57579c;
    @JvmField
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final f f57580d;
    @JvmField
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final f f57581e;
    @JvmField
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final f f57582f;
    @JvmField
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final f f57583g;
    @JvmField
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final f f57584h;
    @JvmField
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final f f57585i;
    @JvmField
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public static final f f57586j;
    @JvmField
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public static final f f57587k;
    @JvmField
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    public static final f f57588l;
    @JvmField
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    public static final f f57589m;

    static {
        f i4 = f.i("<no name provided>");
        f0.o(i4, "special(\"<no name provided>\")");
        f57578b = i4;
        f i5 = f.i("<root package>");
        f0.o(i5, "special(\"<root package>\")");
        f57579c = i5;
        f f4 = f.f("Companion");
        f0.o(f4, "identifier(\"Companion\")");
        f57580d = f4;
        f f5 = f.f("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        f0.o(f5, "identifier(\"no_name_in_P\u2026_4cd0_b7f5_b46aa3cd5d40\")");
        f57581e = f5;
        f i6 = f.i("<anonymous>");
        f0.o(i6, "special(ANONYMOUS_STRING)");
        f57582f = i6;
        f i7 = f.i("<unary>");
        f0.o(i7, "special(\"<unary>\")");
        f57583g = i7;
        f i8 = f.i("<this>");
        f0.o(i8, "special(\"<this>\")");
        f57584h = i8;
        f i9 = f.i("<init>");
        f0.o(i9, "special(\"<init>\")");
        f57585i = i9;
        f i10 = f.i("<iterator>");
        f0.o(i10, "special(\"<iterator>\")");
        f57586j = i10;
        f i11 = f.i("<destruct>");
        f0.o(i11, "special(\"<destruct>\")");
        f57587k = i11;
        f i12 = f.i("<local>");
        f0.o(i12, "special(\"<local>\")");
        f57588l = i12;
        f i13 = f.i("<unused var>");
        f0.o(i13, "special(\"<unused var>\")");
        f57589m = i13;
    }

    private h() {
    }

    @JvmStatic
    @NotNull
    public static final f b(@Nullable f fVar) {
        return (fVar == null || fVar.g()) ? f57581e : fVar;
    }

    public final boolean a(@NotNull f name) {
        f0.p(name, "name");
        String b4 = name.b();
        f0.o(b4, "name.asString()");
        return (b4.length() > 0) && !name.g();
    }
}
