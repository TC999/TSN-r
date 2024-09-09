package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.o;
import kotlin.collections.y0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.ranges.q;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinClassHeader.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class KotlinClassHeader {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Kind f57198a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final e f57199b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String[] f57200c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String[] f57201d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String[] f57202e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f57203f;

    /* renamed from: g  reason: collision with root package name */
    private final int f57204g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final String f57205h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f57206i;

    /* compiled from: KotlinClassHeader.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        private static final Map<Integer, Kind> entryById;
        private final int id;

        /* compiled from: KotlinClassHeader.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Kind a(int i4) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i4));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }

        static {
            int j4;
            int n4;
            int i4 = 0;
            Kind[] values = values();
            j4 = y0.j(values.length);
            n4 = q.n(j4, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
            int length = values.length;
            while (i4 < length) {
                Kind kind = values[i4];
                i4++;
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            entryById = linkedHashMap;
        }

        Kind(int i4) {
            this.id = i4;
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int i4) {
            return Companion.a(i4);
        }

        public final int getId() {
            return this.id;
        }
    }

    public KotlinClassHeader(@NotNull Kind kind, @NotNull e metadataVersion, @Nullable String[] strArr, @Nullable String[] strArr2, @Nullable String[] strArr3, @Nullable String str, int i4, @Nullable String str2, @Nullable byte[] bArr) {
        f0.p(kind, "kind");
        f0.p(metadataVersion, "metadataVersion");
        this.f57198a = kind;
        this.f57199b = metadataVersion;
        this.f57200c = strArr;
        this.f57201d = strArr2;
        this.f57202e = strArr3;
        this.f57203f = str;
        this.f57204g = i4;
        this.f57205h = str2;
        this.f57206i = bArr;
    }

    private final boolean h(int i4, int i5) {
        return (i4 & i5) != 0;
    }

    @Nullable
    public final String[] a() {
        return this.f57200c;
    }

    @Nullable
    public final String[] b() {
        return this.f57201d;
    }

    @NotNull
    public final Kind c() {
        return this.f57198a;
    }

    @NotNull
    public final e d() {
        return this.f57199b;
    }

    @Nullable
    public final String e() {
        String str = this.f57203f;
        if (c() == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    @NotNull
    public final List<String> f() {
        List<String> F;
        String[] strArr = this.f57200c;
        if (!(c() == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> t3 = strArr != null ? o.t(strArr) : null;
        if (t3 == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return t3;
    }

    @Nullable
    public final String[] g() {
        return this.f57202e;
    }

    public final boolean i() {
        return h(this.f57204g, 2);
    }

    public final boolean j() {
        return h(this.f57204g, 64) && !h(this.f57204g, 32);
    }

    public final boolean k() {
        return h(this.f57204g, 16) && !h(this.f57204g, 32);
    }

    @NotNull
    public String toString() {
        return this.f57198a + " version=" + this.f57199b;
    }
}
