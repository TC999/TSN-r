package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackagePartProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface v {

    /* compiled from: PackagePartProvider.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements v {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f57260a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.v
        @NotNull
        public List<String> a(@NotNull String packageFqName) {
            List<String> F;
            f0.p(packageFqName, "packageFqName");
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
    }

    @NotNull
    List<String> a(@NotNull String str);
}
