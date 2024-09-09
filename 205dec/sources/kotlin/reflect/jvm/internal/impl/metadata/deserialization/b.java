package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.acse.ottn.f3;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Flags.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {
    public static final C1156b A;
    public static final C1156b B;
    public static final C1156b C;
    public static final C1156b D;
    public static final C1156b E;
    public static final C1156b F;
    public static final C1156b G;
    public static final C1156b H;
    public static final C1156b I;
    public static final C1156b J;
    public static final C1156b K;

    /* renamed from: L  reason: collision with root package name */
    public static final C1156b f57450L;
    public static final C1156b M;
    public static final C1156b N;
    public static final C1156b O;

    /* renamed from: a  reason: collision with root package name */
    public static final C1156b f57451a;

    /* renamed from: b  reason: collision with root package name */
    public static final C1156b f57452b;

    /* renamed from: c  reason: collision with root package name */
    public static final C1156b f57453c;

    /* renamed from: d  reason: collision with root package name */
    public static final d<ProtoBuf.Visibility> f57454d;

    /* renamed from: e  reason: collision with root package name */
    public static final d<ProtoBuf.Modality> f57455e;

    /* renamed from: f  reason: collision with root package name */
    public static final d<ProtoBuf.Class.Kind> f57456f;

    /* renamed from: g  reason: collision with root package name */
    public static final C1156b f57457g;

    /* renamed from: h  reason: collision with root package name */
    public static final C1156b f57458h;

    /* renamed from: i  reason: collision with root package name */
    public static final C1156b f57459i;

    /* renamed from: j  reason: collision with root package name */
    public static final C1156b f57460j;

    /* renamed from: k  reason: collision with root package name */
    public static final C1156b f57461k;

    /* renamed from: l  reason: collision with root package name */
    public static final C1156b f57462l;

    /* renamed from: m  reason: collision with root package name */
    public static final C1156b f57463m;

    /* renamed from: n  reason: collision with root package name */
    public static final C1156b f57464n;

    /* renamed from: o  reason: collision with root package name */
    public static final d<ProtoBuf.MemberKind> f57465o;

    /* renamed from: p  reason: collision with root package name */
    public static final C1156b f57466p;

    /* renamed from: q  reason: collision with root package name */
    public static final C1156b f57467q;

    /* renamed from: r  reason: collision with root package name */
    public static final C1156b f57468r;

    /* renamed from: s  reason: collision with root package name */
    public static final C1156b f57469s;

    /* renamed from: t  reason: collision with root package name */
    public static final C1156b f57470t;

    /* renamed from: u  reason: collision with root package name */
    public static final C1156b f57471u;

    /* renamed from: v  reason: collision with root package name */
    public static final C1156b f57472v;

    /* renamed from: w  reason: collision with root package name */
    public static final C1156b f57473w;

    /* renamed from: x  reason: collision with root package name */
    public static final C1156b f57474x;

    /* renamed from: y  reason: collision with root package name */
    public static final C1156b f57475y;

    /* renamed from: z  reason: collision with root package name */
    public static final C1156b f57476z;

    /* compiled from: Flags.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1156b extends d<Boolean> {
        public C1156b(int i4) {
            super(i4, 1);
        }

        private static /* synthetic */ void f(int i4) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", f3.f5657f));
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.d
        @NotNull
        /* renamed from: g */
        public Boolean d(int i4) {
            Boolean valueOf = Boolean.valueOf((i4 & (1 << this.f57478a)) != 0);
            if (valueOf == null) {
                f(0);
            }
            return valueOf;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.d
        /* renamed from: h */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f57478a;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Flags.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c<E extends h.a> extends d<E> {

        /* renamed from: c  reason: collision with root package name */
        private final E[] f57477c;

        public c(int i4, E[] eArr) {
            super(i4, g(eArr));
            this.f57477c = eArr;
        }

        private static /* synthetic */ void f(int i4) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(@NotNull E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i4 = 31; i4 >= 0; i4--) {
                if (((1 << i4) & length) != 0) {
                    return i4 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.d
        @Nullable
        /* renamed from: h */
        public E d(int i4) {
            E[] eArr;
            int i5 = this.f57478a;
            int i6 = (i4 & (((1 << this.f57479b) - 1) << i5)) >> i5;
            for (E e4 : this.f57477c) {
                if (e4.getNumber() == i6) {
                    return e4;
                }
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.d
        /* renamed from: i */
        public int e(E e4) {
            return e4.getNumber() << this.f57478a;
        }
    }

    /* compiled from: Flags.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class d<E> {

        /* renamed from: a  reason: collision with root package name */
        public final int f57478a;

        /* renamed from: b  reason: collision with root package name */
        public final int f57479b;

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/h$a;>(Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/b$d<*>;[TE;)Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/b$d<TE;>; */
        public static d a(d dVar, h.a[] aVarArr) {
            return new c(dVar.f57478a + dVar.f57479b, aVarArr);
        }

        public static C1156b b(d<?> dVar) {
            return new C1156b(dVar.f57478a + dVar.f57479b);
        }

        public static C1156b c() {
            return new C1156b(0);
        }

        public abstract E d(int i4);

        public abstract int e(E e4);

        private d(int i4, int i5) {
            this.f57478a = i4;
            this.f57479b = i5;
        }
    }

    static {
        C1156b c4 = d.c();
        f57451a = c4;
        f57452b = d.b(c4);
        C1156b c5 = d.c();
        f57453c = c5;
        d<ProtoBuf.Visibility> a4 = d.a(c5, ProtoBuf.Visibility.values());
        f57454d = a4;
        d<ProtoBuf.Modality> a5 = d.a(a4, ProtoBuf.Modality.values());
        f57455e = a5;
        d<ProtoBuf.Class.Kind> a6 = d.a(a5, ProtoBuf.Class.Kind.values());
        f57456f = a6;
        C1156b b4 = d.b(a6);
        f57457g = b4;
        C1156b b5 = d.b(b4);
        f57458h = b5;
        C1156b b6 = d.b(b5);
        f57459i = b6;
        C1156b b7 = d.b(b6);
        f57460j = b7;
        C1156b b8 = d.b(b7);
        f57461k = b8;
        f57462l = d.b(b8);
        C1156b b9 = d.b(a4);
        f57463m = b9;
        f57464n = d.b(b9);
        d<ProtoBuf.MemberKind> a7 = d.a(a5, ProtoBuf.MemberKind.values());
        f57465o = a7;
        C1156b b10 = d.b(a7);
        f57466p = b10;
        C1156b b11 = d.b(b10);
        f57467q = b11;
        C1156b b12 = d.b(b11);
        f57468r = b12;
        C1156b b13 = d.b(b12);
        f57469s = b13;
        C1156b b14 = d.b(b13);
        f57470t = b14;
        C1156b b15 = d.b(b14);
        f57471u = b15;
        C1156b b16 = d.b(b15);
        f57472v = b16;
        f57473w = d.b(b16);
        C1156b b17 = d.b(a7);
        f57474x = b17;
        C1156b b18 = d.b(b17);
        f57475y = b18;
        C1156b b19 = d.b(b18);
        f57476z = b19;
        C1156b b20 = d.b(b19);
        A = b20;
        C1156b b21 = d.b(b20);
        B = b21;
        C1156b b22 = d.b(b21);
        C = b22;
        C1156b b23 = d.b(b22);
        D = b23;
        C1156b b24 = d.b(b23);
        E = b24;
        F = d.b(b24);
        C1156b b25 = d.b(c5);
        G = b25;
        C1156b b26 = d.b(b25);
        H = b26;
        I = d.b(b26);
        C1156b b27 = d.b(a5);
        J = b27;
        C1156b b28 = d.b(b27);
        K = b28;
        f57450L = d.b(b28);
        C1156b c6 = d.c();
        M = c6;
        N = d.b(c6);
        O = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 1
            r2 = 0
            r3 = 2
            if (r5 == r1) goto L2b
            if (r5 == r3) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r2] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r2] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r2] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r2] = r4
        L2f:
            java.lang.String r2 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r1] = r2
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r3] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r3] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r3] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r3] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r3] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.a(int):void");
    }

    public static int b(boolean z3, @NotNull ProtoBuf.Visibility visibility, @NotNull ProtoBuf.Modality modality, boolean z4, boolean z5, boolean z6) {
        if (visibility == null) {
            a(10);
        }
        if (modality == null) {
            a(11);
        }
        return f57453c.e(Boolean.valueOf(z3)) | f57455e.e(modality) | f57454d.e(visibility) | J.e(Boolean.valueOf(z4)) | K.e(Boolean.valueOf(z5)) | f57450L.e(Boolean.valueOf(z6));
    }
}
