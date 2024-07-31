package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: SharedFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH'R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/flow/s;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/x;", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "", "b", "(Ljava/lang/Object;)Z", "Lkotlin/f1;", "g", "Lkotlinx/coroutines/flow/h0;", "", "c", "()Lkotlinx/coroutines/flow/h0;", "subscriptionCount", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC15043s<T> extends InterfaceC15048x<T>, FlowCollector<T> {
    /* renamed from: b */
    boolean mo4472b(T t);

    @NotNull
    /* renamed from: c */
    StateFlow<Integer> m4501c();

    @ExperimentalCoroutinesApi
    /* renamed from: g */
    void mo4469g();
}
