package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.InterfaceC15064i1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00018\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m12616d2 = {"Landroidx/lifecycle/LiveDataScope;", ExifInterface.GPS_DIRECTION_TRUE, "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/lifecycle/LiveData;", SocialConstants.PARAM_SOURCE, "Lkotlinx/coroutines/i1;", "emitSource", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/c;)Ljava/lang/Object;", "getLatestValue", "()Ljava/lang/Object;", "latestValue", "lifecycle-livedata-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 1})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface LiveDataScope<T> {
    @Nullable
    Object emit(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Nullable
    Object emitSource(@NotNull LiveData<T> liveData, @NotNull InterfaceC14268c<? super InterfaceC15064i1> interfaceC14268c);

    @Nullable
    T getLatestValue();
}
