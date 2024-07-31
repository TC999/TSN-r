package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

/* compiled from: Synchronized.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007*\u0010\b\u0007\u0010\t\"\u00020\u00012\u00020\u0001B\u0002\b\b¨\u0006\n"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "lock", "Lkotlin/Function0;", "block", "b", "(Ljava/lang/Object;Ll1/a;)Ljava/lang/Object;", "Lkotlinx/coroutines/InternalCoroutinesApi;", "SynchronizedObject", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.k0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15081k0 {
    @InternalCoroutinesApi
    /* renamed from: a */
    public static /* synthetic */ void m4291a() {
    }

    @InternalCoroutinesApi
    /* renamed from: b */
    public static final <T> T m4290b(@NotNull Object obj, @NotNull InterfaceC15269a<? extends T> interfaceC15269a) {
        T invoke;
        synchronized (obj) {
            try {
                invoke = interfaceC15269a.invoke();
                InlineMarker.m8228d(1);
            } catch (Throwable th) {
                InlineMarker.m8228d(1);
                InlineMarker.m8229c(1);
                throw th;
            }
        }
        InlineMarker.m8229c(1);
        return invoke;
    }
}
