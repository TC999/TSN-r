package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentWeakMap.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/h;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "", "a", "I", "hash", "ref", "Ljava/lang/ref/ReferenceQueue;", "queue", "<init>", "(Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.debug.internal.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14771h<T> extends WeakReference<T> {
    @JvmPlatformAnnotations

    /* renamed from: a */
    public final int f42274a;

    public C14771h(T t, @Nullable ReferenceQueue<T> referenceQueue) {
        super(t, referenceQueue);
        this.f42274a = t != null ? t.hashCode() : 0;
    }
}
