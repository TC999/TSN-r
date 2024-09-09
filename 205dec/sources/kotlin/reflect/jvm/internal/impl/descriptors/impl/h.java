package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h extends g {

    /* renamed from: p  reason: collision with root package name */
    static final /* synthetic */ boolean f56375p = false;

    /* renamed from: j  reason: collision with root package name */
    private final Modality f56376j;

    /* renamed from: k  reason: collision with root package name */
    private final ClassKind f56377k;

    /* renamed from: l  reason: collision with root package name */
    private final y0 f56378l;

    /* renamed from: m  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.h f56379m;

    /* renamed from: n  reason: collision with root package name */
    private Set<kotlin.reflect.jvm.internal.impl.descriptors.c> f56380n;

    /* renamed from: o  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.c f56381o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Modality modality, @NotNull ClassKind classKind, @NotNull Collection<kotlin.reflect.jvm.internal.impl.types.e0> collection, @NotNull v0 v0Var, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar, kVar, fVar, v0Var, z3);
        if (kVar == null) {
            h0(0);
        }
        if (fVar == null) {
            h0(1);
        }
        if (modality == null) {
            h0(2);
        }
        if (classKind == null) {
            h0(3);
        }
        if (collection == null) {
            h0(4);
        }
        if (v0Var == null) {
            h0(5);
        }
        if (nVar == null) {
            h0(6);
        }
        this.f56376j = modality;
        this.f56377k = classKind;
        this.f56378l = new kotlin.reflect.jvm.internal.impl.types.k(this, Collections.emptyList(), collection, nVar);
    }

    private static /* synthetic */ void h0(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i5 = 2;
                break;
            case 12:
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i4) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i4) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public kotlin.reflect.jvm.internal.impl.descriptors.c F() {
        return this.f56381o;
    }

    public final void F0(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, @NotNull Set<kotlin.reflect.jvm.internal.impl.descriptors.c> set, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.c cVar) {
        if (hVar == null) {
            h0(7);
        }
        if (set == null) {
            h0(8);
        }
        this.f56379m = hVar;
        this.f56380n = set;
        this.f56381o = cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean a0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h f0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            h0(12);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = this.f56379m;
        if (hVar == null) {
            h0(13);
        }
        return hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g() {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.c> set = this.f56380n;
        if (set == null) {
            h0(11);
        }
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        if (b4 == null) {
            h0(9);
        }
        return b4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f56531e;
        if (sVar == null) {
            h0(17);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind i() {
        ClassKind classKind = this.f56377k;
        if (classKind == null) {
            h0(15);
        }
        return classKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public y0 j() {
        y0 y0Var = this.f56378l;
        if (y0Var == null) {
            h0(10);
        }
        return y0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h k0() {
        h.c cVar = h.c.f57931b;
        if (cVar == null) {
            h0(14);
        }
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d l0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> m() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(19);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean n() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<a1> r() {
        List<a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(18);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        Modality modality = this.f56376j;
        if (modality == null) {
            h0(16);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean t() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean y() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.x<kotlin.reflect.jvm.internal.impl.types.m0> z() {
        return null;
    }
}
