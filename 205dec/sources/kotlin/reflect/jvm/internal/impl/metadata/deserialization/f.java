package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: protoTypeTableUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @Nullable
    public static final ProtoBuf.Type a(@NotNull ProtoBuf.Type type, @NotNull g typeTable) {
        f0.p(type, "<this>");
        f0.p(typeTable, "typeTable");
        if (type.hasAbbreviatedType()) {
            return type.getAbbreviatedType();
        }
        if (type.hasAbbreviatedTypeId()) {
            return typeTable.a(type.getAbbreviatedTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf.Type b(@NotNull ProtoBuf.TypeAlias typeAlias, @NotNull g typeTable) {
        f0.p(typeAlias, "<this>");
        f0.p(typeTable, "typeTable");
        if (typeAlias.hasExpandedType()) {
            ProtoBuf.Type expandedType = typeAlias.getExpandedType();
            f0.o(expandedType, "expandedType");
            return expandedType;
        } else if (typeAlias.hasExpandedTypeId()) {
            return typeTable.a(typeAlias.getExpandedTypeId());
        } else {
            throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        }
    }

    @Nullable
    public static final ProtoBuf.Type c(@NotNull ProtoBuf.Type type, @NotNull g typeTable) {
        f0.p(type, "<this>");
        f0.p(typeTable, "typeTable");
        if (type.hasFlexibleUpperBound()) {
            return type.getFlexibleUpperBound();
        }
        if (type.hasFlexibleUpperBoundId()) {
            return typeTable.a(type.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean d(@NotNull ProtoBuf.Function function) {
        f0.p(function, "<this>");
        return function.hasReceiverType() || function.hasReceiverTypeId();
    }

    public static final boolean e(@NotNull ProtoBuf.Property property) {
        f0.p(property, "<this>");
        return property.hasReceiverType() || property.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf.Type f(@NotNull ProtoBuf.Class r12, @NotNull g typeTable) {
        f0.p(r12, "<this>");
        f0.p(typeTable, "typeTable");
        if (r12.hasInlineClassUnderlyingType()) {
            return r12.getInlineClassUnderlyingType();
        }
        if (r12.hasInlineClassUnderlyingTypeId()) {
            return typeTable.a(r12.getInlineClassUnderlyingTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf.Type g(@NotNull ProtoBuf.Type type, @NotNull g typeTable) {
        f0.p(type, "<this>");
        f0.p(typeTable, "typeTable");
        if (type.hasOuterType()) {
            return type.getOuterType();
        }
        if (type.hasOuterTypeId()) {
            return typeTable.a(type.getOuterTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf.Type h(@NotNull ProtoBuf.Function function, @NotNull g typeTable) {
        f0.p(function, "<this>");
        f0.p(typeTable, "typeTable");
        if (function.hasReceiverType()) {
            return function.getReceiverType();
        }
        if (function.hasReceiverTypeId()) {
            return typeTable.a(function.getReceiverTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf.Type i(@NotNull ProtoBuf.Property property, @NotNull g typeTable) {
        f0.p(property, "<this>");
        f0.p(typeTable, "typeTable");
        if (property.hasReceiverType()) {
            return property.getReceiverType();
        }
        if (property.hasReceiverTypeId()) {
            return typeTable.a(property.getReceiverTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf.Type j(@NotNull ProtoBuf.Function function, @NotNull g typeTable) {
        f0.p(function, "<this>");
        f0.p(typeTable, "typeTable");
        if (function.hasReturnType()) {
            ProtoBuf.Type returnType = function.getReturnType();
            f0.o(returnType, "returnType");
            return returnType;
        } else if (function.hasReturnTypeId()) {
            return typeTable.a(function.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        }
    }

    @NotNull
    public static final ProtoBuf.Type k(@NotNull ProtoBuf.Property property, @NotNull g typeTable) {
        f0.p(property, "<this>");
        f0.p(typeTable, "typeTable");
        if (property.hasReturnType()) {
            ProtoBuf.Type returnType = property.getReturnType();
            f0.o(returnType, "returnType");
            return returnType;
        } else if (property.hasReturnTypeId()) {
            return typeTable.a(property.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        }
    }

    @NotNull
    public static final List<ProtoBuf.Type> l(@NotNull ProtoBuf.Class r3, @NotNull g typeTable) {
        int Z;
        f0.p(r3, "<this>");
        f0.p(typeTable, "typeTable");
        List<ProtoBuf.Type> supertypeList = r3.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = r3.getSupertypeIdList();
            f0.o(supertypeIdList, "supertypeIdList");
            Z = y.Z(supertypeIdList, 10);
            supertypeList = new ArrayList<>(Z);
            for (Integer it : supertypeIdList) {
                f0.o(it, "it");
                supertypeList.add(typeTable.a(it.intValue()));
            }
        }
        return supertypeList;
    }

    @Nullable
    public static final ProtoBuf.Type m(@NotNull ProtoBuf.Type.Argument argument, @NotNull g typeTable) {
        f0.p(argument, "<this>");
        f0.p(typeTable, "typeTable");
        if (argument.hasType()) {
            return argument.getType();
        }
        if (argument.hasTypeId()) {
            return typeTable.a(argument.getTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf.Type n(@NotNull ProtoBuf.ValueParameter valueParameter, @NotNull g typeTable) {
        f0.p(valueParameter, "<this>");
        f0.p(typeTable, "typeTable");
        if (valueParameter.hasType()) {
            ProtoBuf.Type type = valueParameter.getType();
            f0.o(type, "type");
            return type;
        } else if (valueParameter.hasTypeId()) {
            return typeTable.a(valueParameter.getTypeId());
        } else {
            throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        }
    }

    @NotNull
    public static final ProtoBuf.Type o(@NotNull ProtoBuf.TypeAlias typeAlias, @NotNull g typeTable) {
        f0.p(typeAlias, "<this>");
        f0.p(typeTable, "typeTable");
        if (typeAlias.hasUnderlyingType()) {
            ProtoBuf.Type underlyingType = typeAlias.getUnderlyingType();
            f0.o(underlyingType, "underlyingType");
            return underlyingType;
        } else if (typeAlias.hasUnderlyingTypeId()) {
            return typeTable.a(typeAlias.getUnderlyingTypeId());
        } else {
            throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        }
    }

    @NotNull
    public static final List<ProtoBuf.Type> p(@NotNull ProtoBuf.TypeParameter typeParameter, @NotNull g typeTable) {
        int Z;
        f0.p(typeParameter, "<this>");
        f0.p(typeTable, "typeTable");
        List<ProtoBuf.Type> upperBoundList = typeParameter.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = typeParameter.getUpperBoundIdList();
            f0.o(upperBoundIdList, "upperBoundIdList");
            Z = y.Z(upperBoundIdList, 10);
            upperBoundList = new ArrayList<>(Z);
            for (Integer it : upperBoundIdList) {
                f0.o(it, "it");
                upperBoundList.add(typeTable.a(it.intValue()));
            }
        }
        return upperBoundList;
    }

    @Nullable
    public static final ProtoBuf.Type q(@NotNull ProtoBuf.ValueParameter valueParameter, @NotNull g typeTable) {
        f0.p(valueParameter, "<this>");
        f0.p(typeTable, "typeTable");
        if (valueParameter.hasVarargElementType()) {
            return valueParameter.getVarargElementType();
        }
        if (valueParameter.hasVarargElementTypeId()) {
            return typeTable.a(valueParameter.getVarargElementTypeId());
        }
        return null;
    }
}
