package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channels.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\u0010\b\u0002\u0010\u0004*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00028\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0087H"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "", "R", "", "C", "Lkotlinx/coroutines/channels/d0;", RtspHeaders.Values.DESTINATION, "Lkotlin/Function1;", "transform", "Lkotlin/coroutines/c;", "continuation", "mapNotNullTo"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", m8638f = "Channels.common.kt", m8637i = {0, 0, 0, 0, 0, 0, 0}, m8636l = {2753}, m8635m = "mapNotNullTo", m8634n = {"$this$mapNotNullTo", RtspHeaders.Values.DESTINATION, "transform", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ChannelsKt__Channels_commonKt$mapNotNullTo$1 extends ContinuationImpl {
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

    public ChannelsKt__Channels_commonKt$mapNotNullTo$1(InterfaceC14268c interfaceC14268c) {
        super(interfaceC14268c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return C14729r.m5257l1(null, null, null, this);
    }
}
