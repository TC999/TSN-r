package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassConstructorDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f extends p implements kotlin.reflect.jvm.internal.impl.descriptors.c {
    static final /* synthetic */ boolean E = false;
    protected final boolean D;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.j jVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var) {
        super(dVar, jVar, fVar, kotlin.reflect.jvm.internal.impl.name.h.f57585i, kind, v0Var);
        if (dVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (kind == null) {
            B(2);
        }
        if (v0Var == null) {
            B(3);
        }
        this.D = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void B(int r8) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.f.B(int):void");
    }

    @NotNull
    public static f h1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, @NotNull v0 v0Var) {
        if (dVar == null) {
            B(4);
        }
        if (fVar == null) {
            B(5);
        }
        if (v0Var == null) {
            B(6);
        }
        return new f(dVar, null, fVar, z3, CallableMemberDescriptor.Kind.DECLARATION, v0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void A0(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            B(20);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.j(this, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j
    public boolean b0() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d c0() {
        kotlin.reflect.jvm.internal.impl.descriptors.d b4 = b();
        if (b4 == null) {
            B(16);
        }
        return b4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w> d() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            B(19);
        }
        return emptySet;
    }

    @Nullable
    public s0 f1() {
        kotlin.reflect.jvm.internal.impl.descriptors.d b4 = b();
        if (b4.n()) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b5 = b4.b();
            if (b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return ((kotlin.reflect.jvm.internal.impl.descriptors.d) b5).E0();
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: g1 */
    public kotlin.reflect.jvm.internal.impl.descriptors.c P(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z3) {
        kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) super.P(kVar, modality, sVar, kind, z3);
        if (cVar == null) {
            B(25);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    @NotNull
    /* renamed from: i1 */
    public f G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, @NotNull v0 v0Var) {
        if (kVar == null) {
            B(21);
        }
        if (kind == null) {
            B(22);
        }
        if (fVar2 == null) {
            B(23);
        }
        if (v0Var == null) {
            B(24);
        }
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2 && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + kVar + "\nkind: " + kind);
        }
        return new f((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar, this, fVar2, this.D, kind2, v0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: j1 */
    public kotlin.reflect.jvm.internal.impl.descriptors.d b() {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) super.b();
        if (dVar == null) {
            B(15);
        }
        return dVar;
    }

    public f k1(@NotNull List<d1> list, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (list == null) {
            B(13);
        }
        if (sVar == null) {
            B(14);
        }
        l1(list, sVar, b().r());
        return this;
    }

    public f l1(@NotNull List<d1> list, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @NotNull List<a1> list2) {
        if (list == null) {
            B(10);
        }
        if (sVar == null) {
            B(11);
        }
        if (list2 == null) {
            B(12);
        }
        super.M0(null, f1(), list2, list, null, Modality.FINAL, sVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w, kotlin.reflect.jvm.internal.impl.descriptors.x0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c c(@NotNull f1 f1Var) {
        if (f1Var == null) {
            B(18);
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.c) super.c(f1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: a */
    public kotlin.reflect.jvm.internal.impl.descriptors.c h0() {
        kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) super.h0();
        if (cVar == null) {
            B(17);
        }
        return cVar;
    }
}
