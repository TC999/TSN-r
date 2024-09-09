package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ErrorUtils.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.descriptors.d0 f58442a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final c f58443b = new c(kotlin.reflect.jvm.internal.impl.name.f.i("<ERROR CLASS>"));

    /* renamed from: c  reason: collision with root package name */
    public static final m0 f58444c = j("<LOOP IN SUPERTYPES>");

    /* renamed from: d  reason: collision with root package name */
    private static final e0 f58445d = j("<ERROR PROPERTY TYPE>");

    /* renamed from: e  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.descriptors.p0 f58446e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.descriptors.p0> f58447f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorUtils.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements kotlin.reflect.jvm.internal.impl.descriptors.d0 {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00af A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00bc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void B(int r12) {
            /*
                Method dump skipped, instructions count: 304
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.w.a.B(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
        public <R, D> R C(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
            if (mVar == null) {
                B(11);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
        @Nullable
        public <T> T D0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.c0<T> c0Var) {
            if (c0Var == null) {
                B(0);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
        public boolean L(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var) {
            if (d0Var == null) {
                B(12);
                return false;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.k a() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
            if (b4 == null) {
                B(1);
            }
            return b4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.name.f getName() {
            kotlin.reflect.jvm.internal.impl.name.f i4 = kotlin.reflect.jvm.internal.impl.name.f.i("<ERROR MODULE>");
            if (i4 == null) {
                B(5);
            }
            return i4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.l0 j0(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
            if (cVar == null) {
                B(7);
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.h k() {
            kotlin.reflect.jvm.internal.impl.builtins.e E0 = kotlin.reflect.jvm.internal.impl.builtins.e.E0();
            if (E0 == null) {
                B(14);
            }
            return E0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.name.c> u(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
            List F;
            if (cVar == null) {
                B(2);
            }
            if (lVar == null) {
                B(3);
            }
            F = CollectionsKt__CollectionsKt.F();
            if (F == null) {
                B(4);
            }
            return F;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
        @NotNull
        public List<kotlin.reflect.jvm.internal.impl.descriptors.d0> w0() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.d0> F;
            F = CollectionsKt__CollectionsKt.F();
            if (F == null) {
                B(9);
            }
            return F;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorUtils.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b implements y0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58448a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f58449b;

        b(c cVar, String str) {
            this.f58448a = cVar;
            this.f58449b = str;
        }

        private static /* synthetic */ void d(int i4) {
            String str = i4 != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i4 != 3 ? 2 : 3];
            if (i4 != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i4 == 1) {
                objArr[1] = "getSupertypes";
            } else if (i4 == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i4 == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i4 != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i4 == 3) {
                objArr[2] = "refine";
            }
            String format = String.format(str, objArr);
            if (i4 == 3) {
                throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public y0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (gVar == null) {
                d(3);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.f b() {
            return this.f58448a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        public boolean c() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public List<kotlin.reflect.jvm.internal.impl.descriptors.a1> getParameters() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> F;
            F = CollectionsKt__CollectionsKt.F();
            if (F == null) {
                d(0);
            }
            return F;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public Collection<e0> j() {
            List F;
            F = CollectionsKt__CollectionsKt.F();
            if (F == null) {
                d(1);
            }
            return F;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.h k() {
            kotlin.reflect.jvm.internal.impl.builtins.e E0 = kotlin.reflect.jvm.internal.impl.builtins.e.E0();
            if (E0 == null) {
                d(2);
            }
            return E0;
        }

        public String toString() {
            return this.f58449b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ErrorUtils.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c extends kotlin.reflect.jvm.internal.impl.descriptors.impl.h {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.f r11) {
            /*
                r10 = this;
                if (r11 != 0) goto L6
                r0 = 0
                h0(r0)
            L6:
                kotlin.reflect.jvm.internal.impl.descriptors.d0 r2 = kotlin.reflect.jvm.internal.impl.types.w.q()
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
                java.util.List r6 = java.util.Collections.emptyList()
                kotlin.reflect.jvm.internal.impl.descriptors.v0 r0 = kotlin.reflect.jvm.internal.impl.descriptors.v0.f56634a
                r8 = 0
                kotlin.reflect.jvm.internal.impl.storage.n r9 = kotlin.reflect.jvm.internal.impl.storage.f.f58216e
                r1 = r10
                r3 = r11
                r7 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.f$a r11 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r11 = r11.b()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.descriptors.impl.f r11 = kotlin.reflect.jvm.internal.impl.descriptors.impl.f.h1(r10, r11, r1, r0)
                java.util.List r0 = java.util.Collections.emptyList()
                kotlin.reflect.jvm.internal.impl.descriptors.s r1 = kotlin.reflect.jvm.internal.impl.descriptors.r.f56530d
                r11.k1(r0, r1)
                kotlin.reflect.jvm.internal.impl.name.f r0 = r10.getName()
                java.lang.String r0 = r0.b()
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h r0 = kotlin.reflect.jvm.internal.impl.types.w.h(r0)
                kotlin.reflect.jvm.internal.impl.types.v r1 = new kotlin.reflect.jvm.internal.impl.types.v
                java.lang.String r2 = "<ERROR>"
                kotlin.reflect.jvm.internal.impl.types.y0 r2 = kotlin.reflect.jvm.internal.impl.types.w.d(r2, r10)
                r1.<init>(r2, r0)
                r11.b1(r1)
                java.util.Set r1 = java.util.Collections.singleton(r11)
                r10.F0(r0, r1, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.w.c.<init>(kotlin.reflect.jvm.internal.impl.name.f):void");
        }

        private static /* synthetic */ void h0(int i4) {
            String str = (i4 == 2 || i4 == 5 || i4 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i4 == 2 || i4 == 5 || i4 == 8) ? 2 : 3];
            switch (i4) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            if (i4 == 2) {
                objArr[1] = "substitute";
            } else if (i4 == 5 || i4 == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i4) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i4 != 2 && i4 != 5 && i4 != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.impl.t
        @NotNull
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.h B(@NotNull d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (d1Var == null) {
                h0(6);
            }
            if (gVar == null) {
                h0(7);
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h h4 = w.h("Error scope for class " + getName() + " with arguments: " + d1Var);
            if (h4 == null) {
                h0(8);
            }
            return h4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.x0
        @NotNull
        /* renamed from: C0 */
        public kotlin.reflect.jvm.internal.impl.descriptors.d c(@NotNull f1 f1Var) {
            if (f1Var == null) {
                h0(1);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
        public String toString() {
            return getName().b();
        }
    }

    /* compiled from: ErrorUtils.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d implements kotlin.reflect.jvm.internal.impl.resolve.scopes.h {

        /* renamed from: b  reason: collision with root package name */
        private final String f58450b;

        /* synthetic */ d(String str, a aVar) {
            this(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0099 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void i(int r10) {
            /*
                r0 = 18
                r1 = 7
                if (r10 == r1) goto Ld
                if (r10 == r0) goto Ld
                switch(r10) {
                    case 10: goto Ld;
                    case 11: goto Ld;
                    case 12: goto Ld;
                    case 13: goto Ld;
                    default: goto La;
                }
            La:
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lf
            Ld:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lf:
                r3 = 2
                if (r10 == r1) goto L19
                if (r10 == r0) goto L19
                switch(r10) {
                    case 10: goto L19;
                    case 11: goto L19;
                    case 12: goto L19;
                    case 13: goto L19;
                    default: goto L17;
                }
            L17:
                r4 = 3
                goto L1a
            L19:
                r4 = 2
            L1a:
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope"
                r6 = 0
                switch(r10) {
                    case 1: goto L3e;
                    case 2: goto L39;
                    case 3: goto L3e;
                    case 4: goto L39;
                    case 5: goto L3e;
                    case 6: goto L39;
                    case 7: goto L36;
                    case 8: goto L3e;
                    case 9: goto L39;
                    case 10: goto L36;
                    case 11: goto L36;
                    case 12: goto L36;
                    case 13: goto L36;
                    case 14: goto L3e;
                    case 15: goto L39;
                    case 16: goto L31;
                    case 17: goto L2c;
                    case 18: goto L36;
                    case 19: goto L3e;
                    case 20: goto L27;
                    default: goto L22;
                }
            L22:
                java.lang.String r7 = "debugMessage"
                r4[r6] = r7
                goto L42
            L27:
                java.lang.String r7 = "p"
                r4[r6] = r7
                goto L42
            L2c:
                java.lang.String r7 = "nameFilter"
                r4[r6] = r7
                goto L42
            L31:
                java.lang.String r7 = "kindFilter"
                r4[r6] = r7
                goto L42
            L36:
                r4[r6] = r5
                goto L42
            L39:
                java.lang.String r7 = "location"
                r4[r6] = r7
                goto L42
            L3e:
                java.lang.String r7 = "name"
                r4[r6] = r7
            L42:
                java.lang.String r6 = "getContributedDescriptors"
                java.lang.String r7 = "getContributedFunctions"
                java.lang.String r8 = "getContributedVariables"
                r9 = 1
                if (r10 == r1) goto L68
                if (r10 == r0) goto L65
                switch(r10) {
                    case 10: goto L62;
                    case 11: goto L5d;
                    case 12: goto L58;
                    case 13: goto L53;
                    default: goto L50;
                }
            L50:
                r4[r9] = r5
                goto L6a
            L53:
                java.lang.String r5 = "getClassifierNames"
                r4[r9] = r5
                goto L6a
            L58:
                java.lang.String r5 = "getVariableNames"
                r4[r9] = r5
                goto L6a
            L5d:
                java.lang.String r5 = "getFunctionNames"
                r4[r9] = r5
                goto L6a
            L62:
                r4[r9] = r7
                goto L6a
            L65:
                r4[r9] = r6
                goto L6a
            L68:
                r4[r9] = r8
            L6a:
                switch(r10) {
                    case 1: goto L8f;
                    case 2: goto L8f;
                    case 3: goto L8a;
                    case 4: goto L8a;
                    case 5: goto L87;
                    case 6: goto L87;
                    case 7: goto L93;
                    case 8: goto L84;
                    case 9: goto L84;
                    case 10: goto L93;
                    case 11: goto L93;
                    case 12: goto L93;
                    case 13: goto L93;
                    case 14: goto L7f;
                    case 15: goto L7f;
                    case 16: goto L7c;
                    case 17: goto L7c;
                    case 18: goto L93;
                    case 19: goto L77;
                    case 20: goto L72;
                    default: goto L6d;
                }
            L6d:
                java.lang.String r5 = "<init>"
                r4[r3] = r5
                goto L93
            L72:
                java.lang.String r5 = "printScopeStructure"
                r4[r3] = r5
                goto L93
            L77:
                java.lang.String r5 = "definitelyDoesNotContainName"
                r4[r3] = r5
                goto L93
            L7c:
                r4[r3] = r6
                goto L93
            L7f:
                java.lang.String r5 = "recordLookup"
                r4[r3] = r5
                goto L93
            L84:
                r4[r3] = r7
                goto L93
            L87:
                r4[r3] = r8
                goto L93
            L8a:
                java.lang.String r5 = "getContributedClassifierIncludeDeprecated"
                r4[r3] = r5
                goto L93
            L8f:
                java.lang.String r5 = "getContributedClassifier"
                r4[r3] = r5
            L93:
                java.lang.String r2 = java.lang.String.format(r2, r4)
                if (r10 == r1) goto La4
                if (r10 == r0) goto La4
                switch(r10) {
                    case 10: goto La4;
                    case 11: goto La4;
                    case 12: goto La4;
                    case 13: goto La4;
                    default: goto L9e;
                }
            L9e:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r2)
                goto La9
            La4:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r2)
            La9:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.w.d.i(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> emptySet = Collections.emptySet();
            if (emptySet == null) {
                i(11);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> emptySet = Collections.emptySet();
            if (emptySet == null) {
                i(12);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(14);
            }
            if (bVar == null) {
                i(15);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
            if (dVar == null) {
                i(16);
            }
            if (lVar == null) {
                i(17);
            }
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                i(18);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> emptySet = Collections.emptySet();
            if (emptySet == null) {
                i(13);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(1);
            }
            if (bVar == null) {
                i(2);
            }
            return w.e(fVar.b());
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        /* renamed from: j */
        public Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(8);
            }
            if (bVar == null) {
                i(9);
            }
            Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.u0> singleton = Collections.singleton(w.f(this));
            if (singleton == null) {
                i(10);
            }
            return singleton;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        /* renamed from: k */
        public Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(5);
            }
            if (bVar == null) {
                i(6);
            }
            Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.p0> set = w.f58447f;
            if (set == null) {
                i(7);
            }
            return set;
        }

        public String toString() {
            return "ErrorScope{" + this.f58450b + '}';
        }

        private d(@NotNull String str) {
            if (str == null) {
                i(0);
            }
            this.f58450b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ErrorUtils.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class e implements kotlin.reflect.jvm.internal.impl.resolve.scopes.h {

        /* renamed from: b  reason: collision with root package name */
        private final String f58451b;

        /* synthetic */ e(String str, a aVar) {
            this(str);
        }

        private static /* synthetic */ void i(int i4) {
            Object[] objArr = new Object[3];
            switch (i4) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i4) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(7);
            }
            if (bVar == null) {
                i(8);
            }
            throw new IllegalStateException(this.f58451b + ", required name: " + fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(5);
            }
            if (bVar == null) {
                i(6);
            }
            throw new IllegalStateException(this.f58451b + ", required name: " + fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(11);
            }
            if (bVar == null) {
                i(12);
            }
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
            if (dVar == null) {
                i(9);
            }
            if (lVar == null) {
                i(10);
            }
            throw new IllegalStateException(this.f58451b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(1);
            }
            if (bVar == null) {
                i(2);
            }
            throw new IllegalStateException(this.f58451b + ", required name: " + fVar);
        }

        public String toString() {
            return "ThrowingScope{" + this.f58451b + '}';
        }

        private e(@NotNull String str) {
            if (str == null) {
                i(0);
            }
            this.f58451b = str;
        }
    }

    /* compiled from: ErrorUtils.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class f implements y0 {

        /* renamed from: a  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.descriptors.a1 f58452a;

        /* renamed from: b  reason: collision with root package name */
        private final y0 f58453b;

        private static /* synthetic */ void d(int i4) {
            String str = (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 || i4 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 || i4 == 6) ? 2 : 3];
            switch (i4) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i4 == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i4 == 2) {
                objArr[1] = "getParameters";
            } else if (i4 == 3) {
                objArr[1] = "getSupertypes";
            } else if (i4 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i4 != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i4) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i4 != 1 && i4 != 2 && i4 != 3 && i4 != 4 && i4 != 6) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public y0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (gVar == null) {
                d(5);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.f b() {
            return this.f58453b.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        public boolean c() {
            return this.f58453b.c();
        }

        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.a1 e() {
            kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var = this.f58452a;
            if (a1Var == null) {
                d(1);
            }
            return a1Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public List<kotlin.reflect.jvm.internal.impl.descriptors.a1> getParameters() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = this.f58453b.getParameters();
            if (parameters == null) {
                d(2);
            }
            return parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public Collection<e0> j() {
            Collection<e0> j4 = this.f58453b.j();
            if (j4 == null) {
                d(3);
            }
            return j4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.h k() {
            kotlin.reflect.jvm.internal.impl.builtins.h g4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(this.f58452a);
            if (g4 == null) {
                d(4);
            }
            return g4;
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 g4 = g();
        f58446e = g4;
        f58447f = Collections.singleton(g4);
    }

    private static /* synthetic */ void a(int i4) {
        String str = (i4 == 4 || i4 == 6 || i4 == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 4 || i4 == 6 || i4 == 19) ? 2 : 3];
        switch (i4) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i4 == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i4 == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i4 != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i4) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 4 && i4 != 6 && i4 != 19) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.d e(@NotNull String str) {
        if (str == null) {
            a(1);
        }
        return new c(kotlin.reflect.jvm.internal.impl.name.f.i("<ERROR CLASS: " + str + ">"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.u0 f(@NotNull d dVar) {
        if (dVar == null) {
            a(5);
        }
        kotlin.reflect.jvm.internal.impl.types.error.a aVar = new kotlin.reflect.jvm.internal.impl.types.error.a(f58443b, dVar);
        aVar.M0(null, null, Collections.emptyList(), Collections.emptyList(), j("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, kotlin.reflect.jvm.internal.impl.descriptors.r.f56531e);
        return aVar;
    }

    @NotNull
    private static kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 g() {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 J0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.c0.J0(f58443b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), Modality.OPEN, kotlin.reflect.jvm.internal.impl.descriptors.r.f56531e, true, kotlin.reflect.jvm.internal.impl.name.f.i("<ERROR PROPERTY>"), CallableMemberDescriptor.Kind.DECLARATION, kotlin.reflect.jvm.internal.impl.descriptors.v0.f56634a, false, false, false, false, false, false);
        J0.W0(f58445d, Collections.emptyList(), null, null);
        return J0;
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.resolve.scopes.h h(@NotNull String str) {
        if (str == null) {
            a(2);
        }
        return i(str, false);
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.resolve.scopes.h i(@NotNull String str, boolean z3) {
        if (str == null) {
            a(3);
        }
        if (z3) {
            return new e(str, null);
        }
        return new d(str, null);
    }

    @NotNull
    public static m0 j(@NotNull String str) {
        if (str == null) {
            a(7);
        }
        return n(str, Collections.emptyList());
    }

    @NotNull
    public static y0 k(@NotNull String str) {
        if (str == null) {
            a(15);
        }
        return m("[ERROR : " + str + "]", f58443b);
    }

    @NotNull
    public static y0 l(@NotNull String str) {
        if (str == null) {
            a(16);
        }
        return m(str, f58443b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static y0 m(@NotNull String str, @NotNull c cVar) {
        if (str == null) {
            a(17);
        }
        if (cVar == null) {
            a(18);
        }
        return new b(cVar, str);
    }

    @NotNull
    public static m0 n(@NotNull String str, @NotNull List<a1> list) {
        if (str == null) {
            a(11);
        }
        if (list == null) {
            a(12);
        }
        return new v(k(str), h(str), list, false);
    }

    @NotNull
    public static m0 o(@NotNull String str, @NotNull y0 y0Var) {
        if (str == null) {
            a(9);
        }
        if (y0Var == null) {
            a(10);
        }
        return new v(y0Var, h(str));
    }

    @NotNull
    public static m0 p(@NotNull String str) {
        if (str == null) {
            a(8);
        }
        return o(str, l(str));
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.d0 q() {
        kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var = f58442a;
        if (d0Var == null) {
            a(19);
        }
        return d0Var;
    }

    public static boolean r(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            return false;
        }
        return s(kVar) || s(kVar.b()) || kVar == f58442a;
    }

    private static boolean s(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return kVar instanceof c;
    }

    public static boolean t(@Nullable e0 e0Var) {
        return e0Var != null && (e0Var.H0() instanceof f);
    }
}
