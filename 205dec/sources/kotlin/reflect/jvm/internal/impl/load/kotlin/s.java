package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MemberSignature.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f57258b = new a(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f57259a;

    /* compiled from: MemberSignature.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final s a(@NotNull String name, @NotNull String desc) {
            f0.p(name, "name");
            f0.p(desc, "desc");
            return new s(name + '#' + desc, null);
        }

        @JvmStatic
        @NotNull
        public final s b(@NotNull kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d signature) {
            f0.p(signature, "signature");
            if (signature instanceof d.b) {
                return d(signature.c(), signature.b());
            }
            if (signature instanceof d.a) {
                return a(signature.c(), signature.b());
            }
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        @NotNull
        public final s c(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull JvmProtoBuf.JvmMethodSignature signature) {
            f0.p(nameResolver, "nameResolver");
            f0.p(signature, "signature");
            return d(nameResolver.getString(signature.getName()), nameResolver.getString(signature.getDesc()));
        }

        @JvmStatic
        @NotNull
        public final s d(@NotNull String name, @NotNull String desc) {
            f0.p(name, "name");
            f0.p(desc, "desc");
            return new s(f0.C(name, desc), null);
        }

        @JvmStatic
        @NotNull
        public final s e(@NotNull s signature, int i4) {
            f0.p(signature, "signature");
            return new s(signature.a() + '@' + i4, null);
        }
    }

    private s(String str) {
        this.f57259a = str;
    }

    public /* synthetic */ s(String str, kotlin.jvm.internal.u uVar) {
        this(str);
    }

    @NotNull
    public final String a() {
        return this.f57259a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && f0.g(this.f57259a, ((s) obj).f57259a);
    }

    public int hashCode() {
        return this.f57259a.hashCode();
    }

    @NotNull
    public String toString() {
        return "MemberSignature(signature=" + this.f57259a + ')';
    }
}
