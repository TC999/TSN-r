package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum UBYTE uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: UnsignedType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class UnsignedType {
    private static final /* synthetic */ UnsignedType[] $VALUES;
    public static final UnsignedType UBYTE;
    public static final UnsignedType UINT;
    public static final UnsignedType ULONG;
    public static final UnsignedType USHORT;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.b arrayClassId;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.b classId;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.b e4 = kotlin.reflect.jvm.internal.impl.name.b.e("kotlin/UByte");
        f0.o(e4, "fromString(\"kotlin/UByte\")");
        UBYTE = new UnsignedType("UBYTE", 0, e4);
        kotlin.reflect.jvm.internal.impl.name.b e5 = kotlin.reflect.jvm.internal.impl.name.b.e("kotlin/UShort");
        f0.o(e5, "fromString(\"kotlin/UShort\")");
        USHORT = new UnsignedType("USHORT", 1, e5);
        kotlin.reflect.jvm.internal.impl.name.b e6 = kotlin.reflect.jvm.internal.impl.name.b.e("kotlin/UInt");
        f0.o(e6, "fromString(\"kotlin/UInt\")");
        UINT = new UnsignedType("UINT", 2, e6);
        kotlin.reflect.jvm.internal.impl.name.b e7 = kotlin.reflect.jvm.internal.impl.name.b.e("kotlin/ULong");
        f0.o(e7, "fromString(\"kotlin/ULong\")");
        ULONG = new UnsignedType("ULONG", 3, e7);
        $VALUES = $values();
    }

    private UnsignedType(String str, int i4, kotlin.reflect.jvm.internal.impl.name.b bVar) {
        this.classId = bVar;
        kotlin.reflect.jvm.internal.impl.name.f j4 = bVar.j();
        f0.o(j4, "classId.shortClassName");
        this.typeName = j4;
        this.arrayClassId = new kotlin.reflect.jvm.internal.impl.name.b(bVar.h(), kotlin.reflect.jvm.internal.impl.name.f.f(f0.C(j4.b(), "Array")));
    }

    public static UnsignedType valueOf(String str) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b getArrayClassId() {
        return this.arrayClassId;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b getClassId() {
        return this.classId;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f getTypeName() {
        return this.typeName;
    }
}
