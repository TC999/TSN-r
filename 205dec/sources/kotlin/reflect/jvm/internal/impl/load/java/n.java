package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaClassFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface n {
    @Nullable
    m2.g a(@NotNull a aVar);

    @Nullable
    m2.u b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @Nullable
    Set<String> c(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    /* compiled from: JavaClassFinder.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.name.b f56970a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f56971b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final m2.g f56972c;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @Nullable byte[] bArr, @Nullable m2.g gVar) {
            f0.p(classId, "classId");
            this.f56970a = classId;
            this.f56971b = bArr;
            this.f56972c = gVar;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b a() {
            return this.f56970a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(this.f56970a, aVar.f56970a) && f0.g(this.f56971b, aVar.f56971b) && f0.g(this.f56972c, aVar.f56972c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f56970a.hashCode() * 31;
            byte[] bArr = this.f56971b;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            m2.g gVar = this.f56972c;
            return hashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Request(classId=" + this.f56970a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f56971b) + ", outerClass=" + this.f56972c + ')';
        }

        public /* synthetic */ a(kotlin.reflect.jvm.internal.impl.name.b bVar, byte[] bArr, m2.g gVar, int i4, kotlin.jvm.internal.u uVar) {
            this(bVar, (i4 & 2) != 0 ? null : bArr, (i4 & 4) != 0 ? null : gVar);
        }
    }
}
