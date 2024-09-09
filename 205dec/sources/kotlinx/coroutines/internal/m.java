package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FastServiceLoader.kt */
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "a", "Z", "()Z", "ANDROID_DETECTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f60379a;

    static {
        Object m119constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th));
        }
        f60379a = Result.m126isSuccessimpl(m119constructorimpl);
    }

    public static final boolean a() {
        return f60379a;
    }
}
