package k2;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import org.jetbrains.annotations.NotNull;

/* compiled from: LookupTracker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface c {

    /* compiled from: LookupTracker.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements c {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f55236a = new a();

        private a() {
        }

        @Override // k2.c
        public boolean a() {
            return false;
        }

        @Override // k2.c
        public void b(@NotNull String filePath, @NotNull Position position, @NotNull String scopeFqName, @NotNull ScopeKind scopeKind, @NotNull String name) {
            f0.p(filePath, "filePath");
            f0.p(position, "position");
            f0.p(scopeFqName, "scopeFqName");
            f0.p(scopeKind, "scopeKind");
            f0.p(name, "name");
        }
    }

    boolean a();

    void b(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3);
}
