package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e;
import kotlin.reflect.jvm.internal.impl.name.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a implements p.c {

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f57207j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* renamed from: k  reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.b, KotlinClassHeader.Kind> f57208k;

    /* renamed from: a  reason: collision with root package name */
    private int[] f57209a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f57210b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f57211c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f57212d = null;

    /* renamed from: e  reason: collision with root package name */
    private String[] f57213e = null;

    /* renamed from: f  reason: collision with root package name */
    private String[] f57214f = null;

    /* renamed from: g  reason: collision with root package name */
    private String[] f57215g = null;

    /* renamed from: h  reason: collision with root package name */
    private KotlinClassHeader.Kind f57216h = null;

    /* renamed from: i  reason: collision with root package name */
    private String[] f57217i = null;

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static abstract class b implements p.b {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f57218a = new ArrayList();

        private static /* synthetic */ void e(int i4) {
            Object[] objArr = new Object[3];
            if (i4 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i4 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i4 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i4 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i4 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
        @Nullable
        public p.a a(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar) {
            if (bVar == null) {
                e(3);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
        public void b(@Nullable Object obj) {
            if (obj instanceof String) {
                this.f57218a.add((String) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
        public void c(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull f fVar) {
            if (bVar == null) {
                e(0);
            }
            if (fVar == null) {
                e(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
        public void d(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar) {
            if (fVar == null) {
                e(2);
            }
        }

        protected abstract void f(@NotNull String[] strArr);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.b
        public void visitEnd() {
            f((String[]) this.f57218a.toArray(new String[0]));
        }
    }

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class c implements p.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$c$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1151a extends b {
            C1151a() {
            }

            private static /* synthetic */ void e(int i4) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f57213e = strArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class b extends b {
            b() {
            }

            private static /* synthetic */ void e(int i4) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f57214f = strArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1152c extends b {
            C1152c() {
            }

            private static /* synthetic */ void e(int i4) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$3", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f57217i = strArr;
            }
        }

        private c() {
        }

        private static /* synthetic */ void f(int i4) {
            Object[] objArr = new Object[3];
            if (i4 == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i4 == 7) {
                objArr[0] = "classId";
            } else if (i4 == 4) {
                objArr[0] = "enumClassId";
            } else if (i4 != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i4) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @NotNull
        private p.b g() {
            return new C1151a();
        }

        @NotNull
        private p.b h() {
            return new C1152c();
        }

        @NotNull
        private p.b i() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void a(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull f fVar2) {
            if (fVar == null) {
                f(3);
            }
            if (bVar == null) {
                f(4);
            }
            if (fVar2 == null) {
                f(5);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        @Nullable
        public p.a b(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar) {
            if (fVar == null) {
                f(6);
            }
            if (bVar == null) {
                f(7);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void c(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2) {
            if (fVar == null) {
                f(0);
            }
            if (fVar2 == null) {
                f(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void d(@Nullable f fVar, @Nullable Object obj) {
            if (fVar == null) {
                return;
            }
            String b4 = fVar.b();
            if ("k".equals(b4)) {
                if (obj instanceof Integer) {
                    a.this.f57216h = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                }
            } else if ("mv".equals(b4)) {
                if (obj instanceof int[]) {
                    a.this.f57209a = (int[]) obj;
                }
            } else if ("xs".equals(b4)) {
                if (obj instanceof String) {
                    a.this.f57210b = (String) obj;
                }
            } else if ("xi".equals(b4)) {
                if (obj instanceof Integer) {
                    a.this.f57211c = ((Integer) obj).intValue();
                }
            } else if ("pn".equals(b4) && (obj instanceof String)) {
                a.this.f57212d = (String) obj;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        @Nullable
        public p.b e(@NotNull f fVar) {
            if (fVar == null) {
                f(2);
            }
            String b4 = fVar.b();
            if ("d1".equals(b4)) {
                return g();
            }
            if ("d2".equals(b4)) {
                return i();
            }
            if ("si".equals(b4)) {
                return h();
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void visitEnd() {
        }
    }

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class d implements p.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$d$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1153a extends b {
            C1153a() {
            }

            private static /* synthetic */ void e(int i4) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f57213e = strArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class b extends b {
            b() {
            }

            private static /* synthetic */ void e(int i4) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f57214f = strArr;
            }
        }

        private d() {
        }

        private static /* synthetic */ void f(int i4) {
            Object[] objArr = new Object[3];
            if (i4 == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i4 == 7) {
                objArr[0] = "classId";
            } else if (i4 == 4) {
                objArr[0] = "enumClassId";
            } else if (i4 != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i4) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @NotNull
        private p.b g() {
            return new C1153a();
        }

        @NotNull
        private p.b h() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void a(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull f fVar2) {
            if (fVar == null) {
                f(3);
            }
            if (bVar == null) {
                f(4);
            }
            if (fVar2 == null) {
                f(5);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        @Nullable
        public p.a b(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar) {
            if (fVar == null) {
                f(6);
            }
            if (bVar == null) {
                f(7);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void c(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2) {
            if (fVar == null) {
                f(0);
            }
            if (fVar2 == null) {
                f(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void d(@Nullable f fVar, @Nullable Object obj) {
            if (fVar == null) {
                return;
            }
            String b4 = fVar.b();
            if ("version".equals(b4)) {
                if (obj instanceof int[]) {
                    a.this.f57209a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(b4)) {
                a.this.f57210b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        @Nullable
        public p.b e(@NotNull f fVar) {
            if (fVar == null) {
                f(2);
            }
            String b4 = fVar.b();
            if (!"data".equals(b4) && !"filePartClassNames".equals(b4)) {
                if ("strings".equals(b4)) {
                    return h();
                }
                return null;
            }
            return g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.a
        public void visitEnd() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f57208k = hashMap;
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private static /* synthetic */ void c(int i4) {
        Object[] objArr = new Object[3];
        if (i4 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    private boolean m() {
        KotlinClassHeader.Kind kind = this.f57216h;
        return kind == KotlinClassHeader.Kind.CLASS || kind == KotlinClassHeader.Kind.FILE_FACADE || kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.c
    @Nullable
    public p.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull v0 v0Var) {
        KotlinClassHeader.Kind kind;
        if (bVar == null) {
            c(0);
        }
        if (v0Var == null) {
            c(1);
        }
        if (bVar.b().equals(y.f57105a)) {
            return new c();
        }
        if (f57207j || this.f57216h != null || (kind = f57208k.get(bVar)) == null) {
            return null;
        }
        this.f57216h = kind;
        return new d();
    }

    @Nullable
    public KotlinClassHeader l() {
        if (this.f57216h == null || this.f57209a == null) {
            return null;
        }
        e eVar = new e(this.f57209a, (this.f57211c & 8) != 0);
        if (!eVar.h()) {
            this.f57215g = this.f57213e;
            this.f57213e = null;
        } else if (m() && this.f57213e == null) {
            return null;
        }
        String[] strArr = this.f57217i;
        return new KotlinClassHeader(this.f57216h, eVar, this.f57213e, this.f57215g, this.f57214f, this.f57210b, this.f57211c, this.f57212d, strArr != null ? kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.a.e(strArr) : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.c
    public void visitEnd() {
    }
}
