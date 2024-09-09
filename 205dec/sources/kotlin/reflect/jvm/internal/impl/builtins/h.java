package kotlin.reflect.jvm.internal.impl.builtins;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import h2.a;
import h2.c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.x;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.f0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinBuiltIns.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class h {

    /* renamed from: g  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.name.f f56042g = kotlin.reflect.jvm.internal.impl.name.f.i("<built-ins module>");

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ boolean f56043h = false;

    /* renamed from: a  reason: collision with root package name */
    private x f56044a;

    /* renamed from: b  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.storage.i<x> f56045b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<e> f56046c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<l0>> f56047d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> f56048e;

    /* renamed from: f  reason: collision with root package name */
    private final n f56049f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KotlinBuiltIns.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements d2.a<Collection<l0>> {
        a() {
        }

        @Override // d2.a
        /* renamed from: a */
        public Collection<l0> invoke() {
            return Arrays.asList(h.this.r().j0(j.f56084m), h.this.r().j0(j.f56086o), h.this.r().j0(j.f56087p), h.this.r().j0(j.f56085n));
        }
    }

    /* compiled from: KotlinBuiltIns.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b implements d2.a<e> {
        b() {
        }

        @Override // d2.a
        /* renamed from: a */
        public e invoke() {
            PrimitiveType[] values;
            EnumMap enumMap = new EnumMap(PrimitiveType.class);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                m0 q3 = h.this.q(primitiveType.getTypeName().b());
                m0 q4 = h.this.q(primitiveType.getArrayTypeName().b());
                enumMap.put((EnumMap) primitiveType, (PrimitiveType) q4);
                hashMap.put(q3, q4);
                hashMap2.put(q4, q3);
            }
            return new e(enumMap, hashMap, hashMap2, null);
        }
    }

    /* compiled from: KotlinBuiltIns.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class c implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> {
        c() {
        }

        @Override // d2.l
        /* renamed from: a */
        public kotlin.reflect.jvm.internal.impl.descriptors.d invoke(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.f h4 = h.this.s().h(fVar, NoLookupLocation.FROM_BUILTINS);
            if (h4 != null) {
                if (h4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                    return (kotlin.reflect.jvm.internal.impl.descriptors.d) h4;
                }
                throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + h4);
            }
            throw new AssertionError("Built-in class " + j.f56084m.c(fVar) + " is not found");
        }
    }

    /* compiled from: KotlinBuiltIns.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class d implements d2.a<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f56053a;

        d(x xVar) {
            this.f56053a = xVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public Void invoke() {
            if (h.this.f56044a == null) {
                h.this.f56044a = this.f56053a;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + h.this.f56044a + " (attempting to reset to " + this.f56053a + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KotlinBuiltIns.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final Map<PrimitiveType, m0> f56055a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<e0, m0> f56056b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<m0, m0> f56057c;

        /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i4) {
            Object[] objArr = new Object[3];
            if (i4 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i4 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private e(@NotNull Map<PrimitiveType, m0> map, @NotNull Map<e0, m0> map2, @NotNull Map<m0, m0> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.f56055a = map;
            this.f56056b = map2;
            this.f56057c = map3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(@NotNull n nVar) {
        if (nVar == null) {
            a(0);
        }
        this.f56049f = nVar;
        this.f56047d = nVar.g(new a());
        this.f56046c = nVar.g(new b());
        this.f56048e = nVar.c(new c());
    }

    @Nullable
    private static e0 A(@NotNull e0 e0Var, @NotNull d0 d0Var) {
        kotlin.reflect.jvm.internal.impl.name.b h4;
        kotlin.reflect.jvm.internal.impl.name.b a4;
        kotlin.reflect.jvm.internal.impl.descriptors.d a5;
        if (e0Var == null) {
            a(71);
        }
        if (d0Var == null) {
            a(72);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (b4 == null) {
            return null;
        }
        l lVar = l.f56224a;
        if (!lVar.b(b4.getName()) || (h4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(b4)) == null || (a4 = lVar.a(h4)) == null || (a5 = v.a(d0Var, a4)) == null) {
            return null;
        }
        return a5.q();
    }

    public static boolean A0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(142);
        }
        return k0(e0Var, j.a.f56101f);
    }

    public static boolean B0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(132);
        }
        return v0(e0Var) || y0(e0Var) || w0(e0Var) || x0(e0Var);
    }

    @Nullable
    public static PrimitiveType N(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(92);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (b4 == null) {
            return null;
        }
        return P(b4);
    }

    @Nullable
    public static PrimitiveType P(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(77);
        }
        if (j.a.C0.contains(kVar.getName())) {
            return j.a.E0.get(kotlin.reflect.jvm.internal.impl.resolve.d.m(kVar));
        }
        return null;
    }

    @NotNull
    private kotlin.reflect.jvm.internal.impl.descriptors.d Q(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(16);
        }
        return p(primitiveType.getTypeName().b());
    }

    @Nullable
    public static PrimitiveType S(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(76);
        }
        if (j.a.B0.contains(kVar.getName())) {
            return j.a.D0.get(kotlin.reflect.jvm.internal.impl.resolve.d.m(kVar));
        }
        return null;
    }

    private static /* synthetic */ void a(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i5 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
            case 72:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 76:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case 145:
            case 146:
            case 148:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME /* 156 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME /* 157 */:
            case 158:
            case 159:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 53:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 147:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME /* 155 */:
            case 161:
                objArr[0] = "type";
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case 67:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 160:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i4) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKCallable";
                break;
            case 23:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case 27:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case 31:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case 35:
                objArr[1] = "getMutableCollection";
                break;
            case 36:
                objArr[1] = "getList";
                break;
            case 37:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case 39:
                objArr[1] = "getMutableSet";
                break;
            case 40:
                objArr[1] = "getMap";
                break;
            case 41:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case 44:
                objArr[1] = "getListIterator";
                break;
            case 45:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case 49:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case 51:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 55:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case 65:
                objArr[1] = "getStringType";
                break;
            case 66:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i4) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 53:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 67:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 76:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 144:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 145:
                objArr[2] = "isMemberOfAny";
                break;
            case 146:
            case 147:
                objArr[2] = "isEnum";
                break;
            case 148:
            case 149:
                objArr[2] = "isComparable";
                break;
            case 150:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 151:
                objArr[2] = "isListOrNullableList";
                break;
            case 152:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 153:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 154:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME /* 155 */:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME /* 156 */:
                objArr[2] = "isThrowable";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME /* 157 */:
                objArr[2] = "isKClass";
                break;
            case 158:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 159:
                objArr[2] = "isCloneable";
                break;
            case 160:
                objArr[2] = "isDeprecated";
                break;
            case 161:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean a0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(108);
        }
        return e(dVar, j.a.f56093b);
    }

    public static boolean b0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(139);
        }
        return f0(e0Var, j.a.f56093b);
    }

    public static boolean c0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(88);
        }
        return f0(e0Var, j.a.f56107i);
    }

    public static boolean d0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(89);
        }
        return e(dVar, j.a.f56107i) || P(dVar) != null;
    }

    private static boolean e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (fVar == null) {
            a(103);
        }
        if (dVar == null) {
            a(104);
        }
        return fVar.getName().equals(dVar.i()) && dVar.equals(kotlin.reflect.jvm.internal.impl.resolve.d.m(fVar));
    }

    public static boolean e0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(9);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.d.r(kVar, kotlin.reflect.jvm.internal.impl.builtins.b.class, false) != null;
    }

    private static boolean f0(@NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (e0Var == null) {
            a(97);
        }
        if (dVar == null) {
            a(98);
        }
        return u0(e0Var.H0(), dVar);
    }

    private static boolean g0(@NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (e0Var == null) {
            a(134);
        }
        if (dVar == null) {
            a(135);
        }
        return f0(e0Var, dVar) && !e0Var.I0();
    }

    public static boolean h0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(141);
        }
        return n0(e0Var);
    }

    public static boolean i0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(160);
        }
        if (kVar.a().getAnnotations().i(j.a.f56139y)) {
            return true;
        }
        if (kVar instanceof p0) {
            p0 p0Var = (p0) kVar;
            boolean O = p0Var.O();
            q0 getter = p0Var.getGetter();
            r0 setter = p0Var.getSetter();
            if (getter != null && i0(getter)) {
                if (!O) {
                    return true;
                }
                if (setter != null && i0(setter)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean j0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME);
        }
        return e(dVar, j.a.f56098d0);
    }

    private static boolean k0(@NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (e0Var == null) {
            a(105);
        }
        if (dVar == null) {
            a(106);
        }
        return !e0Var.I0() && f0(e0Var, dVar);
    }

    public static boolean l0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(136);
        }
        return m0(e0Var) && !h1.m(e0Var);
    }

    public static boolean m0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(138);
        }
        return f0(e0Var, j.a.f56095c);
    }

    public static boolean n0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(140);
        }
        return b0(e0Var) && e0Var.I0();
    }

    public static boolean o0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(91);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        return (b4 == null || P(b4) == null) ? false : true;
    }

    @NotNull
    private kotlin.reflect.jvm.internal.impl.descriptors.d p(@NotNull String str) {
        if (str == null) {
            a(14);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d invoke = this.f56048e.invoke(kotlin.reflect.jvm.internal.impl.name.f.f(str));
        if (invoke == null) {
            a(15);
        }
        return invoke;
    }

    public static boolean p0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(96);
        }
        return S(dVar) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public m0 q(@NotNull String str) {
        if (str == null) {
            a(46);
        }
        m0 q3 = p(str).q();
        if (q3 == null) {
            a(47);
        }
        return q3;
    }

    public static boolean q0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(94);
        }
        return !e0Var.I0() && r0(e0Var);
    }

    public static boolean r0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(95);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        return (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && p0((kotlin.reflect.jvm.internal.impl.descriptors.d) b4);
    }

    public static boolean s0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(107);
        }
        return e(dVar, j.a.f56093b) || e(dVar, j.a.f56095c);
    }

    public static boolean t0(@Nullable e0 e0Var) {
        return e0Var != null && k0(e0Var, j.a.f56105h);
    }

    public static boolean u0(@NotNull y0 y0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (y0Var == null) {
            a(101);
        }
        if (dVar == null) {
            a(102);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = y0Var.b();
        return (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && e(b4, dVar);
    }

    public static boolean v0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(128);
        }
        return g0(e0Var, j.a.f56138x0.j());
    }

    public static boolean w0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(130);
        }
        return g0(e0Var, j.a.f56142z0.j());
    }

    public static boolean x0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(131);
        }
        return g0(e0Var, j.a.A0.j());
    }

    public static boolean y0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(129);
        }
        return g0(e0Var, j.a.f56140y0.j());
    }

    public static boolean z0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(10);
        }
        while (kVar != null) {
            if (kVar instanceof g0) {
                return ((g0) kVar).e().i(j.f56083l);
            }
            kVar = kVar.b();
        }
        return false;
    }

    @NotNull
    public m0 B() {
        m0 R = R(PrimitiveType.FLOAT);
        if (R == null) {
            a(60);
        }
        return R;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d C(int i4) {
        return p(j.b(i4));
    }

    public void C0(@NotNull x xVar) {
        if (xVar == null) {
            a(1);
        }
        this.f56049f.a(new d(xVar));
    }

    @NotNull
    public m0 D() {
        m0 R = R(PrimitiveType.INT);
        if (R == null) {
            a(58);
        }
        return R;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d E() {
        kotlin.reflect.jvm.internal.impl.descriptors.d o4 = o(j.a.f56098d0.l());
        if (o4 == null) {
            a(21);
        }
        return o4;
    }

    @NotNull
    public m0 F() {
        m0 R = R(PrimitiveType.LONG);
        if (R == null) {
            a(59);
        }
        return R;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d G() {
        return p("Nothing");
    }

    @NotNull
    public m0 H() {
        m0 q3 = G().q();
        if (q3 == null) {
            a(48);
        }
        return q3;
    }

    @NotNull
    public m0 I() {
        m0 O0 = i().O0(true);
        if (O0 == null) {
            a(51);
        }
        return O0;
    }

    @NotNull
    public m0 J() {
        m0 O0 = H().O0(true);
        if (O0 == null) {
            a(49);
        }
        return O0;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d K() {
        return p("Number");
    }

    @NotNull
    public m0 L() {
        m0 q3 = K().q();
        if (q3 == null) {
            a(55);
        }
        return q3;
    }

    @NotNull
    protected h2.c M() {
        c.b bVar = c.b.f54736a;
        if (bVar == null) {
            a(4);
        }
        return bVar;
    }

    @NotNull
    public m0 O(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(73);
        }
        m0 m0Var = this.f56046c.invoke().f56055a.get(primitiveType);
        if (m0Var == null) {
            a(74);
        }
        return m0Var;
    }

    @NotNull
    public m0 R(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(53);
        }
        m0 q3 = Q(primitiveType).q();
        if (q3 == null) {
            a(54);
        }
        return q3;
    }

    @NotNull
    public m0 T() {
        m0 R = R(PrimitiveType.SHORT);
        if (R == null) {
            a(57);
        }
        return R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public n U() {
        n nVar = this.f56049f;
        if (nVar == null) {
            a(6);
        }
        return nVar;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d V() {
        return p("String");
    }

    @NotNull
    public m0 W() {
        m0 q3 = V().q();
        if (q3 == null) {
            a(65);
        }
        return q3;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d X(int i4) {
        kotlin.reflect.jvm.internal.impl.descriptors.d o4 = o(j.f56076e.c(kotlin.reflect.jvm.internal.impl.name.f.f(j.d(i4))));
        if (o4 == null) {
            a(18);
        }
        return o4;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d Y() {
        return p("Unit");
    }

    @NotNull
    public m0 Z() {
        m0 q3 = Y().q();
        if (q3 == null) {
            a(64);
        }
        return q3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(boolean z3) {
        x xVar = new x(f56042g, this.f56049f, this, null);
        this.f56044a = xVar;
        xVar.N0(kotlin.reflect.jvm.internal.impl.builtins.a.f56017a.a().a(this.f56049f, this.f56044a, v(), M(), g(), z3));
        x xVar2 = this.f56044a;
        xVar2.T0(xVar2);
    }

    @NotNull
    protected h2.a g() {
        a.C1078a c1078a = a.C1078a.f54734a;
        if (c1078a == null) {
            a(3);
        }
        return c1078a;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d h() {
        return p("Any");
    }

    @NotNull
    public m0 i() {
        m0 q3 = h().q();
        if (q3 == null) {
            a(50);
        }
        return q3;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d j() {
        return p("Array");
    }

    @NotNull
    public e0 k(@NotNull e0 e0Var) {
        e0 A;
        if (e0Var == null) {
            a(67);
        }
        if (c0(e0Var)) {
            if (e0Var.G0().size() == 1) {
                e0 type = e0Var.G0().get(0).getType();
                if (type == null) {
                    a(68);
                }
                return type;
            }
            throw new IllegalStateException();
        }
        e0 o4 = h1.o(e0Var);
        m0 m0Var = this.f56046c.invoke().f56057c.get(o4);
        if (m0Var != null) {
            return m0Var;
        }
        d0 i4 = kotlin.reflect.jvm.internal.impl.resolve.d.i(o4);
        if (i4 == null || (A = A(o4, i4)) == null) {
            throw new IllegalStateException("not array: " + e0Var);
        }
        return A;
    }

    @NotNull
    public m0 l(@NotNull Variance variance, @NotNull e0 e0Var) {
        if (variance == null) {
            a(82);
        }
        if (e0Var == null) {
            a(83);
        }
        m0 m4 = m(variance, e0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b());
        if (m4 == null) {
            a(84);
        }
        return m4;
    }

    @NotNull
    public m0 m(@NotNull Variance variance, @NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        if (variance == null) {
            a(78);
        }
        if (e0Var == null) {
            a(79);
        }
        if (fVar == null) {
            a(80);
        }
        m0 g4 = f0.g(fVar, j(), Collections.singletonList(new c1(variance, e0Var)));
        if (g4 == null) {
            a(81);
        }
        return g4;
    }

    @NotNull
    public m0 n() {
        m0 R = R(PrimitiveType.BOOLEAN);
        if (R == null) {
            a(63);
        }
        return R;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d o(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        if (cVar == null) {
            a(12);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d c4 = q.c(r(), cVar, NoLookupLocation.FROM_BUILTINS);
        if (c4 == null) {
            a(13);
        }
        return c4;
    }

    @NotNull
    public x r() {
        if (this.f56044a == null) {
            this.f56044a = this.f56045b.invoke();
        }
        x xVar = this.f56044a;
        if (xVar == null) {
            a(7);
        }
        return xVar;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h s() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h p3 = r().j0(j.f56084m).p();
        if (p3 == null) {
            a(11);
        }
        return p3;
    }

    @NotNull
    public m0 t() {
        m0 R = R(PrimitiveType.BYTE);
        if (R == null) {
            a(56);
        }
        return R;
    }

    @NotNull
    public m0 u() {
        m0 R = R(PrimitiveType.CHAR);
        if (R == null) {
            a(62);
        }
        return R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Iterable<h2.b> v() {
        List singletonList = Collections.singletonList(new kotlin.reflect.jvm.internal.impl.builtins.functions.a(this.f56049f, r()));
        if (singletonList == null) {
            a(5);
        }
        return singletonList;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d w() {
        kotlin.reflect.jvm.internal.impl.descriptors.d o4 = o(j.a.P);
        if (o4 == null) {
            a(34);
        }
        return o4;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d x() {
        return p("Comparable");
    }

    @NotNull
    public m0 y() {
        m0 I = I();
        if (I == null) {
            a(52);
        }
        return I;
    }

    @NotNull
    public m0 z() {
        m0 R = R(PrimitiveType.DOUBLE);
        if (R == null) {
            a(61);
        }
        return R;
    }
}
