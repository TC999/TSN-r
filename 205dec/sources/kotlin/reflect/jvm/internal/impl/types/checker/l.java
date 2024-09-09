package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: NewKotlinTypeChecker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface l extends e {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f58296b = a.f58297a;

    /* compiled from: NewKotlinTypeChecker.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f58297a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final m f58298b = new m(g.a.f58278a, null, 2, null);

        private a() {
        }

        @NotNull
        public final m a() {
            return f58298b;
        }
    }

    @NotNull
    OverridingUtil a();

    @NotNull
    g c();
}
