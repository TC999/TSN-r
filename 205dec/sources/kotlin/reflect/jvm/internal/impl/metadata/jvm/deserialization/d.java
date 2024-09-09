package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmMemberSignature.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class d {

    /* compiled from: JvmMemberSignature.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends d {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f57532a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f57533b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String name, @NotNull String desc) {
            super(null);
            f0.p(name, "name");
            f0.p(desc, "desc");
            this.f57532a = name;
            this.f57533b = desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d
        @NotNull
        public String a() {
            return c() + ':' + b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d
        @NotNull
        public String b() {
            return this.f57533b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d
        @NotNull
        public String c() {
            return this.f57532a;
        }

        @NotNull
        public final String d() {
            return c();
        }

        @NotNull
        public final String e() {
            return b();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(c(), aVar.c()) && f0.g(b(), aVar.b());
            }
            return false;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    /* compiled from: JvmMemberSignature.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends d {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f57534a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f57535b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String name, @NotNull String desc) {
            super(null);
            f0.p(name, "name");
            f0.p(desc, "desc");
            this.f57534a = name;
            this.f57535b = desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d
        @NotNull
        public String a() {
            return f0.C(c(), b());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d
        @NotNull
        public String b() {
            return this.f57535b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d
        @NotNull
        public String c() {
            return this.f57534a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f0.g(c(), bVar.c()) && f0.g(b(), bVar.b());
            }
            return false;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    private d() {
    }

    public /* synthetic */ d(u uVar) {
        this();
    }

    @NotNull
    public abstract String a();

    @NotNull
    public abstract String b();

    @NotNull
    public abstract String c();

    @NotNull
    public final String toString() {
        return a();
    }
}
