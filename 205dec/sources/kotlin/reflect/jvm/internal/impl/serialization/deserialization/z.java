package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProtoEnumFlagsUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z {

    /* compiled from: ProtoEnumFlagsUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58208a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f58209b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f58210c;

        static {
            int[] iArr = new int[ProtoBuf.MemberKind.values().length];
            iArr[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
            iArr[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
            iArr[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
            f58208a = iArr;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            f58209b = iArr2;
            int[] iArr3 = new int[ProtoBuf.Visibility.values().length];
            iArr3[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            iArr3[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            iArr3[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            iArr3[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            iArr3[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            f58210c = iArr3;
        }
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s a(@NotNull y yVar, @Nullable ProtoBuf.Visibility visibility) {
        f0.p(yVar, "<this>");
        switch (visibility == null ? -1 : a.f58210c[visibility.ordinal()]) {
            case 1:
                kotlin.reflect.jvm.internal.impl.descriptors.s INTERNAL = kotlin.reflect.jvm.internal.impl.descriptors.r.f56530d;
                f0.o(INTERNAL, "INTERNAL");
                return INTERNAL;
            case 2:
                kotlin.reflect.jvm.internal.impl.descriptors.s PRIVATE = kotlin.reflect.jvm.internal.impl.descriptors.r.f56527a;
                f0.o(PRIVATE, "PRIVATE");
                return PRIVATE;
            case 3:
                kotlin.reflect.jvm.internal.impl.descriptors.s PRIVATE_TO_THIS = kotlin.reflect.jvm.internal.impl.descriptors.r.f56528b;
                f0.o(PRIVATE_TO_THIS, "PRIVATE_TO_THIS");
                return PRIVATE_TO_THIS;
            case 4:
                kotlin.reflect.jvm.internal.impl.descriptors.s PROTECTED = kotlin.reflect.jvm.internal.impl.descriptors.r.f56529c;
                f0.o(PROTECTED, "PROTECTED");
                return PROTECTED;
            case 5:
                kotlin.reflect.jvm.internal.impl.descriptors.s PUBLIC = kotlin.reflect.jvm.internal.impl.descriptors.r.f56531e;
                f0.o(PUBLIC, "PUBLIC");
                return PUBLIC;
            case 6:
                kotlin.reflect.jvm.internal.impl.descriptors.s LOCAL = kotlin.reflect.jvm.internal.impl.descriptors.r.f56532f;
                f0.o(LOCAL, "LOCAL");
                return LOCAL;
            default:
                kotlin.reflect.jvm.internal.impl.descriptors.s PRIVATE2 = kotlin.reflect.jvm.internal.impl.descriptors.r.f56527a;
                f0.o(PRIVATE2, "PRIVATE");
                return PRIVATE2;
        }
    }

    @NotNull
    public static final CallableMemberDescriptor.Kind b(@NotNull y yVar, @Nullable ProtoBuf.MemberKind memberKind) {
        f0.p(yVar, "<this>");
        int i4 = memberKind == null ? -1 : a.f58208a[memberKind.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return CallableMemberDescriptor.Kind.DECLARATION;
                    }
                    return CallableMemberDescriptor.Kind.SYNTHESIZED;
                }
                return CallableMemberDescriptor.Kind.DELEGATION;
            }
            return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
        }
        return CallableMemberDescriptor.Kind.DECLARATION;
    }
}
