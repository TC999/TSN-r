package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channels.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006H\u0087H"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "", "R", "Lkotlinx/coroutines/channels/d0;", "Lkotlin/Function1;", "selector", "Lkotlin/coroutines/c;", "continuation", "", "minBy"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", m8638f = "Channels.common.kt", m8637i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, m8636l = {1937, 1940}, m8635m = "minBy", m8634n = {"$this$minBy", "selector", "$this$consume$iv", "cause$iv", "$this$consume", "iterator", "$this$minBy", "selector", "$this$consume$iv", "cause$iv", "$this$consume", "iterator", "minElem", "minValue"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ChannelsKt__Channels_commonKt$minBy$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$minBy$1(InterfaceC14268c interfaceC14268c) {
        super(interfaceC14268c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return C14729r.m5222w1(null, null, this);
    }
}