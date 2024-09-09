package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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

/* compiled from: MutableClassDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class y extends g {

    /* renamed from: r  reason: collision with root package name */
    static final /* synthetic */ boolean f56512r = false;

    /* renamed from: j  reason: collision with root package name */
    private final ClassKind f56513j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f56514k;

    /* renamed from: l  reason: collision with root package name */
    private Modality f56515l;

    /* renamed from: m  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.s f56516m;

    /* renamed from: n  reason: collision with root package name */
    private y0 f56517n;

    /* renamed from: o  reason: collision with root package name */
    private List<a1> f56518o;

    /* renamed from: p  reason: collision with root package name */
    private final Collection<kotlin.reflect.jvm.internal.impl.types.e0> f56519p;

    /* renamed from: q  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f56520q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull ClassKind classKind, boolean z3, boolean z4, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull v0 v0Var, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar, kVar, fVar, v0Var, z4);
        if (kVar == null) {
            h0(0);
        }
        if (classKind == null) {
            h0(1);
        }
        if (fVar == null) {
            h0(2);
        }
        if (v0Var == null) {
            h0(3);
        }
        if (nVar == null) {
            h0(4);
        }
        this.f56519p = new ArrayList();
        this.f56520q = nVar;
        this.f56513j = classKind;
        this.f56514k = z3;
    }

    private static /* synthetic */ void h0(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i5 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i4) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i4) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c F() {
        return null;
    }

    public void F0() {
        this.f56517n = new kotlin.reflect.jvm.internal.impl.types.k(this, this.f56518o, this.f56519p, this.f56520q);
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.c> it = g().iterator();
        while (it.hasNext()) {
            ((f) it.next()).b1(q());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: G0 */
    public Set<kotlin.reflect.jvm.internal.impl.descriptors.c> g() {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.c> emptySet = Collections.emptySet();
        if (emptySet == null) {
            h0(13);
        }
        return emptySet;
    }

    public void H0(@NotNull Modality modality) {
        if (modality == null) {
            h0(6);
        }
        this.f56515l = modality;
    }

    public void I0(@NotNull List<a1> list) {
        if (list == null) {
            h0(14);
        }
        if (this.f56518o == null) {
            this.f56518o = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public void J0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (sVar == null) {
            h0(9);
        }
        this.f56516m = sVar;
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
            h0(16);
        }
        h.c cVar = h.c.f57931b;
        if (cVar == null) {
            h0(17);
        }
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        if (b4 == null) {
            h0(5);
        }
        return b4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = this.f56516m;
        if (sVar == null) {
            h0(10);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind i() {
        ClassKind classKind = this.f56513j;
        if (classKind == null) {
            h0(8);
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
        y0 y0Var = this.f56517n;
        if (y0Var == null) {
            h0(11);
        }
        return y0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h k0() {
        h.c cVar = h.c.f57931b;
        if (cVar == null) {
            h0(18);
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
        return this.f56514k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<a1> r() {
        List<a1> list = this.f56518o;
        if (list == null) {
            h0(15);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        Modality modality = this.f56515l;
        if (modality == null) {
            h0(7);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean t() {
        return false;
    }

    public String toString() {
        return j.f0(this);
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
