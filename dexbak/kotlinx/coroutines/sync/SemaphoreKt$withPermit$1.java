package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/sync/e;", "Lkotlin/Function0;", CcgConstant.f38549t, "Lkotlin/coroutines/c;", "continuation", "", "withPermit"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.sync.SemaphoreKt", m8638f = "Semaphore.kt", m8637i = {0, 0}, m8636l = {85}, m8635m = "withPermit", m8634n = {"$this$withPermit", CcgConstant.f38549t}, m8633s = {"L$0", "L$1"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SemaphoreKt$withPermit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public SemaphoreKt$withPermit$1(InterfaceC14268c interfaceC14268c) {
        super(interfaceC14268c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Semaphore.m3639q(null, null, this);
    }
}