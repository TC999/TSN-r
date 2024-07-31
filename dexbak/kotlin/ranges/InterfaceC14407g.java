package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Range.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\u000b\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u000e"}, m12616d2 = {"Lkotlin/ranges/g;", "", ExifInterface.GPS_DIRECTION_TRUE, "", DomainCampaignEx.LOOPBACK_VALUE, "", "contains", "(Ljava/lang/Comparable;)Z", "isEmpty", "getStart", "()Ljava/lang/Comparable;", CampaignEx.JSON_NATIVE_VIDEO_START, "getEndInclusive", "endInclusive", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14407g<T extends Comparable<? super T>> {

    /* compiled from: Range.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.g$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14408a {
        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m7606a(@NotNull InterfaceC14407g<T> interfaceC14407g, @NotNull T value) {
            C14342f0.m8184p(value, "value");
            return value.compareTo(interfaceC14407g.getStart()) >= 0 && value.compareTo(interfaceC14407g.getEndInclusive()) <= 0;
        }

        /* renamed from: b */
        public static <T extends Comparable<? super T>> boolean m7605b(@NotNull InterfaceC14407g<T> interfaceC14407g) {
            return interfaceC14407g.getStart().compareTo(interfaceC14407g.getEndInclusive()) > 0;
        }
    }

    boolean contains(@NotNull T t);

    @NotNull
    T getEndInclusive();

    @NotNull
    T getStart();

    boolean isEmpty();
}
