package kotlinx.coroutines.internal;

import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;

/* compiled from: FastServiceLoader.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"", "a", "Z", "()Z", "ANDROID_DETECTED", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15083m {

    /* renamed from: a */
    private static final boolean f43062a;

    static {
        Object m60148constructorimpl;
        try {
            Result.C14124a c14124a = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
        }
        f43062a = Result.m60155isSuccessimpl(m60148constructorimpl);
    }

    /* renamed from: a */
    public static final boolean m4274a() {
        return f43062a;
    }
}
