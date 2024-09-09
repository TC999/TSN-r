package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorUtils.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.name.c f57856a = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmName");

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f57857b = false;

    private d() {
    }

    public static boolean A(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.ENUM_CLASS);
    }

    public static boolean B(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(36);
        }
        return D(kVar, ClassKind.ENUM_ENTRY);
    }

    public static boolean C(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.INTERFACE);
    }

    private static boolean D(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull ClassKind classKind) {
        if (classKind == null) {
            a(37);
        }
        return (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).i() == classKind;
    }

    public static boolean E(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(1);
        }
        while (kVar != null) {
            if (u(kVar) || y(kVar)) {
                return true;
            }
            kVar = kVar.b();
        }
        return false;
    }

    private static boolean F(@NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (e0Var == null) {
            a(30);
        }
        if (kVar == null) {
            a(31);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (b4 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.k a4 = b4.a();
            return (a4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.f) && (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.f) && ((kotlin.reflect.jvm.internal.impl.descriptors.f) kVar).j().equals(((kotlin.reflect.jvm.internal.impl.descriptors.f) a4).j());
        }
        return false;
    }

    public static boolean G(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return (D(kVar, ClassKind.CLASS) || D(kVar, ClassKind.INTERFACE)) && ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).s() == Modality.SEALED;
    }

    public static boolean H(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar2) {
        if (dVar == null) {
            a(28);
        }
        if (dVar2 == null) {
            a(29);
        }
        return I(dVar.q(), dVar2.a());
    }

    public static boolean I(@NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (e0Var == null) {
            a(32);
        }
        if (kVar == null) {
            a(33);
        }
        if (F(e0Var, kVar)) {
            return true;
        }
        for (e0 e0Var2 : e0Var.H0().j()) {
            if (I(e0Var2, kVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return kVar != null && (kVar.b() instanceof g0);
    }

    public static boolean K(@NotNull f1 f1Var, @NotNull e0 e0Var) {
        if (f1Var == null) {
            a(63);
        }
        if (e0Var == null) {
            a(64);
        }
        if (f1Var.O() || kotlin.reflect.jvm.internal.impl.types.g0.a(e0Var)) {
            return false;
        }
        if (h1.b(e0Var)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.builtins.h g4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(f1Var);
        if (!kotlin.reflect.jvm.internal.impl.builtins.h.q0(e0Var)) {
            kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f58276a;
            if (!eVar.b(g4.W(), e0Var) && !eVar.b(g4.K().q(), e0Var) && !eVar.b(g4.i(), e0Var)) {
                kotlin.reflect.jvm.internal.impl.builtins.l lVar = kotlin.reflect.jvm.internal.impl.builtins.l.f56224a;
                if (!kotlin.reflect.jvm.internal.impl.builtins.l.d(e0Var)) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> D L(@NotNull D d4) {
        if (d4 == null) {
            a(59);
        }
        while (d4.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Collection<? extends CallableMemberDescriptor> d5 = d4.d();
            if (!d5.isEmpty()) {
                d4 = (D) d5.iterator().next();
            } else {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d4);
            }
        }
        return d4;
    }

    @NotNull
    public static <D extends o> D M(@NotNull D d4) {
        if (d4 == null) {
            a(61);
        }
        if (d4 instanceof CallableMemberDescriptor) {
            return L((CallableMemberDescriptor) d4);
        }
        if (d4 == null) {
            a(62);
        }
        return d4;
    }

    private static /* synthetic */ void a(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                i5 = 2;
                break;
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case 61:
            case 79:
            case 92:
            case 94:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = "second";
                break;
            case 18:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case 64:
                objArr[0] = "type";
                break;
            case 31:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case 65:
            case 66:
            case 67:
            case 74:
            case 75:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case 63:
                objArr[0] = "variable";
                break;
            case 68:
                objArr[0] = "f";
                break;
            case 70:
                objArr[0] = "current";
                break;
            case 71:
                objArr[0] = "result";
                break;
            case 72:
                objArr[0] = "memberDescriptor";
                break;
            case 76:
            case 77:
            case 78:
                objArr[0] = "annotated";
                break;
            case 82:
            case 84:
            case 87:
            case 89:
                objArr[0] = "scope";
                break;
            case 85:
            case 88:
            case 90:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i4) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 69:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 73:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 80:
            case 81:
                objArr[1] = "getContainingSourceFile";
                break;
            case 83:
                objArr[1] = "getAllDescriptors";
                break;
            case 86:
                objArr[1] = "getFunctionByName";
                break;
            case 91:
                objArr[1] = "getPropertyByName";
                break;
            case 93:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i4) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 63:
            case 64:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 65:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 66:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 67:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 68:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 70:
            case 71:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 72:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 74:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 75:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 76:
                objArr[2] = "getJvmName";
                break;
            case 77:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 78:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 79:
                objArr[2] = "getContainingSourceFile";
                break;
            case 82:
                objArr[2] = "getAllDescriptors";
                break;
            case 84:
            case 85:
                objArr[2] = "getFunctionByName";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 89:
            case 90:
                objArr[2] = "getPropertyByName";
                break;
            case 92:
                objArr[2] = "getDirectMember";
                break;
            case 94:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        if (kVar == null) {
            a(16);
        }
        if (kVar2 == null) {
            a(17);
        }
        return g(kVar).equals(g(kVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> void c(@NotNull D d4, @NotNull Set<D> set) {
        if (d4 == null) {
            a(70);
        }
        if (set == 0) {
            a(71);
        }
        if (set.contains(d4)) {
            return;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.a aVar : d4.a().d()) {
            kotlin.reflect.jvm.internal.impl.descriptors.a a4 = aVar.a();
            c(a4, set);
            set.add(a4);
        }
    }

    @NotNull
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> d(@NotNull D d4) {
        if (d4 == null) {
            a(68);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d4.a(), linkedHashSet);
        return linkedHashSet;
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.d e(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(45);
        }
        return f(e0Var.H0());
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.d f(@NotNull y0 y0Var) {
        if (y0Var == null) {
            a(46);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) y0Var.b();
        if (dVar == null) {
            a(47);
        }
        return dVar;
    }

    @NotNull
    public static d0 g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(21);
        }
        d0 h4 = h(kVar);
        if (h4 == null) {
            a(22);
        }
        return h4;
    }

    @Nullable
    public static d0 h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(23);
        }
        while (kVar != null) {
            if (kVar instanceof d0) {
                return (d0) kVar;
            }
            if (kVar instanceof l0) {
                return ((l0) kVar).y0();
            }
            kVar = kVar.b();
        }
        return null;
    }

    @Nullable
    public static d0 i(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(20);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (b4 == null) {
            return null;
        }
        return h(b4);
    }

    @NotNull
    public static w0 j(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(79);
        }
        if (kVar instanceof r0) {
            kVar = ((r0) kVar).V();
        }
        if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.n) {
            w0 b4 = ((kotlin.reflect.jvm.internal.impl.descriptors.n) kVar).getSource().b();
            if (b4 == null) {
                a(80);
            }
            return b4;
        }
        w0 w0Var = w0.f56635a;
        if (w0Var == null) {
            a(81);
        }
        return w0Var;
    }

    @NotNull
    public static s k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, boolean z3) {
        if (dVar == null) {
            a(48);
        }
        ClassKind i4 = dVar.i();
        if (i4 != ClassKind.ENUM_CLASS && !i4.isSingleton()) {
            if (G(dVar)) {
                if (z3) {
                    s sVar = r.f56529c;
                    if (sVar == null) {
                        a(50);
                    }
                    return sVar;
                }
                s sVar2 = r.f56527a;
                if (sVar2 == null) {
                    a(51);
                }
                return sVar2;
            } else if (u(dVar)) {
                s sVar3 = r.f56538l;
                if (sVar3 == null) {
                    a(52);
                }
                return sVar3;
            } else {
                s sVar4 = r.f56531e;
                if (sVar4 == null) {
                    a(53);
                }
                return sVar4;
            }
        }
        s sVar5 = r.f56527a;
        if (sVar5 == null) {
            a(49);
        }
        return sVar5;
    }

    @Nullable
    public static s0 l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(0);
        }
        if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).E0();
        }
        return null;
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.name.d m(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(2);
        }
        kotlin.reflect.jvm.internal.impl.name.c o4 = o(kVar);
        return o4 != null ? o4.j() : p(kVar);
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.name.c n(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(3);
        }
        kotlin.reflect.jvm.internal.impl.name.c o4 = o(kVar);
        if (o4 == null) {
            o4 = p(kVar).l();
        }
        if (o4 == null) {
            a(4);
        }
        return o4;
    }

    @Nullable
    private static kotlin.reflect.jvm.internal.impl.name.c o(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(5);
        }
        if (!(kVar instanceof d0) && !w.r(kVar)) {
            if (kVar instanceof l0) {
                return ((l0) kVar).e();
            }
            if (kVar instanceof g0) {
                return ((g0) kVar).e();
            }
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.name.c.f57562c;
    }

    @NotNull
    private static kotlin.reflect.jvm.internal.impl.name.d p(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(6);
        }
        kotlin.reflect.jvm.internal.impl.name.d c4 = m(kVar.b()).c(kVar.getName());
        if (c4 == null) {
            a(7);
        }
        return c4;
    }

    @Nullable
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.k> D q(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull Class<D> cls) {
        if (cls == null) {
            a(18);
        }
        return (D) r(kVar, cls, true);
    }

    @Nullable
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.k> D r(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull Class<D> cls, boolean z3) {
        if (cls == null) {
            a(19);
        }
        if (kVar == null) {
            return null;
        }
        if (z3) {
            kVar = (D) kVar.b();
        }
        while (kVar != null) {
            if (cls.isInstance(kVar)) {
                return (D) kVar;
            }
            kVar = (D) kVar.b();
        }
        return null;
    }

    @Nullable
    public static kotlin.reflect.jvm.internal.impl.descriptors.d s(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(44);
        }
        for (e0 e0Var : dVar.j().j()) {
            kotlin.reflect.jvm.internal.impl.descriptors.d e4 = e(e0Var);
            if (e4.i() != ClassKind.INTERFACE) {
                return e4;
            }
        }
        return null;
    }

    public static boolean t(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean u(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(34);
        }
        return v(kVar) && kVar.getName().equals(kotlin.reflect.jvm.internal.impl.name.h.f57578b);
    }

    public static boolean v(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.CLASS);
    }

    public static boolean w(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return v(kVar) || A(kVar);
    }

    public static boolean x(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.OBJECT) && ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).a0();
    }

    public static boolean y(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return (kVar instanceof o) && ((o) kVar).getVisibility() == r.f56532f;
    }

    public static boolean z(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar2) {
        if (dVar == null) {
            a(26);
        }
        if (dVar2 == null) {
            a(27);
        }
        for (e0 e0Var : dVar.j().j()) {
            if (F(e0Var, dVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
