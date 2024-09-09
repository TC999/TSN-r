package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProtoEnumFlags.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final y f58199a = new y();

    /* compiled from: ProtoEnumFlags.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58200a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f58201b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f58202c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f58203d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ int[] f58204e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ int[] f58205f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ int[] f58206g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ int[] f58207h;

        static {
            int[] iArr = new int[ProtoBuf.Modality.values().length];
            iArr[ProtoBuf.Modality.FINAL.ordinal()] = 1;
            iArr[ProtoBuf.Modality.OPEN.ordinal()] = 2;
            iArr[ProtoBuf.Modality.ABSTRACT.ordinal()] = 3;
            iArr[ProtoBuf.Modality.SEALED.ordinal()] = 4;
            f58200a = iArr;
            int[] iArr2 = new int[Modality.values().length];
            iArr2[Modality.FINAL.ordinal()] = 1;
            iArr2[Modality.OPEN.ordinal()] = 2;
            iArr2[Modality.ABSTRACT.ordinal()] = 3;
            iArr2[Modality.SEALED.ordinal()] = 4;
            f58201b = iArr2;
            int[] iArr3 = new int[ProtoBuf.Visibility.values().length];
            iArr3[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            iArr3[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            iArr3[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            iArr3[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            iArr3[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            f58202c = iArr3;
            int[] iArr4 = new int[ProtoBuf.Class.Kind.values().length];
            iArr4[ProtoBuf.Class.Kind.CLASS.ordinal()] = 1;
            iArr4[ProtoBuf.Class.Kind.INTERFACE.ordinal()] = 2;
            iArr4[ProtoBuf.Class.Kind.ENUM_CLASS.ordinal()] = 3;
            iArr4[ProtoBuf.Class.Kind.ENUM_ENTRY.ordinal()] = 4;
            iArr4[ProtoBuf.Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;
            iArr4[ProtoBuf.Class.Kind.OBJECT.ordinal()] = 6;
            iArr4[ProtoBuf.Class.Kind.COMPANION_OBJECT.ordinal()] = 7;
            f58203d = iArr4;
            int[] iArr5 = new int[ClassKind.values().length];
            iArr5[ClassKind.CLASS.ordinal()] = 1;
            iArr5[ClassKind.INTERFACE.ordinal()] = 2;
            iArr5[ClassKind.ENUM_CLASS.ordinal()] = 3;
            iArr5[ClassKind.ENUM_ENTRY.ordinal()] = 4;
            iArr5[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
            iArr5[ClassKind.OBJECT.ordinal()] = 6;
            f58204e = iArr5;
            int[] iArr6 = new int[ProtoBuf.TypeParameter.Variance.values().length];
            iArr6[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            iArr6[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            iArr6[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            f58205f = iArr6;
            int[] iArr7 = new int[ProtoBuf.Type.Argument.Projection.values().length];
            iArr7[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            iArr7[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            iArr7[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            iArr7[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
            f58206g = iArr7;
            int[] iArr8 = new int[Variance.values().length];
            iArr8[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr8[Variance.OUT_VARIANCE.ordinal()] = 2;
            iArr8[Variance.INVARIANT.ordinal()] = 3;
            f58207h = iArr8;
        }
    }

    private y() {
    }

    @NotNull
    public final ClassKind a(@Nullable ProtoBuf.Class.Kind kind) {
        switch (kind == null ? -1 : a.f58203d[kind.ordinal()]) {
            case 1:
                return ClassKind.CLASS;
            case 2:
                return ClassKind.INTERFACE;
            case 3:
                return ClassKind.ENUM_CLASS;
            case 4:
                return ClassKind.ENUM_ENTRY;
            case 5:
                return ClassKind.ANNOTATION_CLASS;
            case 6:
            case 7:
                return ClassKind.OBJECT;
            default:
                return ClassKind.CLASS;
        }
    }

    @NotNull
    public final Modality b(@Nullable ProtoBuf.Modality modality) {
        int i4 = modality == null ? -1 : a.f58200a[modality.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return Modality.FINAL;
                    }
                    return Modality.SEALED;
                }
                return Modality.ABSTRACT;
            }
            return Modality.OPEN;
        }
        return Modality.FINAL;
    }

    @NotNull
    public final Variance c(@NotNull ProtoBuf.Type.Argument.Projection projection) {
        f0.p(projection, "projection");
        int i4 = a.f58206g[projection.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalArgumentException(f0.C("Only IN, OUT and INV are supported. Actual argument: ", projection));
                }
                return Variance.INVARIANT;
            }
            return Variance.OUT_VARIANCE;
        }
        return Variance.IN_VARIANCE;
    }

    @NotNull
    public final Variance d(@NotNull ProtoBuf.TypeParameter.Variance variance) {
        f0.p(variance, "variance");
        int i4 = a.f58205f[variance.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return Variance.INVARIANT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return Variance.OUT_VARIANCE;
        }
        return Variance.IN_VARIANCE;
    }
}
