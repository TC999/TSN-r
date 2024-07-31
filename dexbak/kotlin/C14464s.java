package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.InterfaceC14446n;
import org.jetbrains.annotations.NotNull;

/* compiled from: Lazy.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0087\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/o;", "e", "(Ljava/lang/Object;)Lkotlin/o;", "", "thisRef", "Lkotlin/reflect/n;", "property", "d", "(Lkotlin/o;Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/LazyKt")
/* renamed from: kotlin.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14464s extends C14389r {
    @InlineOnly
    /* renamed from: d */
    private static final <T> T m7295d(InterfaceC14378o<? extends T> getValue, Object obj, InterfaceC14446n<?> interfaceC14446n) {
        C14342f0.m8184p(getValue, "$this$getValue");
        return getValue.getValue();
    }

    @NotNull
    /* renamed from: e */
    public static final <T> InterfaceC14378o<T> m7294e(T t) {
        return new Lazy(t);
    }
}
