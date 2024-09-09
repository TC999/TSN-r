package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: ExtensionRegistryLite.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f57651b;

    /* renamed from: c  reason: collision with root package name */
    private static final f f57652c = new f(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<a, GeneratedMessageLite.f<?, ?>> f57653a;

    /* compiled from: ExtensionRegistryLite.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f57654a;

        /* renamed from: b  reason: collision with root package name */
        private final int f57655b;

        a(Object obj, int i4) {
            this.f57654a = obj;
            this.f57655b = i4;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f57654a == aVar.f57654a && this.f57655b == aVar.f57655b;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f57654a) * 65535) + this.f57655b;
        }
    }

    f() {
        this.f57653a = new HashMap();
    }

    public static f c() {
        return f57652c;
    }

    public static f d() {
        return new f();
    }

    public final void a(GeneratedMessageLite.f<?, ?> fVar) {
        this.f57653a.put(new a(fVar.b(), fVar.d()), fVar);
    }

    public <ContainingType extends n> GeneratedMessageLite.f<ContainingType, ?> b(ContainingType containingtype, int i4) {
        return (GeneratedMessageLite.f<ContainingType, ?>) this.f57653a.get(new a(containingtype, i4));
    }

    private f(boolean z3) {
        this.f57653a = Collections.emptyMap();
    }
}
