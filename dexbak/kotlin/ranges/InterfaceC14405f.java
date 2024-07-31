package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Ranges.kt */
@SinceKotlin(version = "1.1")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\u000b¨\u0006\f"}, m12616d2 = {"Lkotlin/ranges/f;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ranges/g;", DomainCampaignEx.LOOPBACK_VALUE, "", "contains", "(Ljava/lang/Comparable;)Z", "isEmpty", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14405f<T extends Comparable<? super T>> extends InterfaceC14407g<T> {

    /* compiled from: Ranges.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14406a {
        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m7608a(@NotNull InterfaceC14405f<T> interfaceC14405f, @NotNull T value) {
            C14342f0.m8184p(value, "value");
            return interfaceC14405f.mo7609a(interfaceC14405f.getStart(), value) && interfaceC14405f.mo7609a(value, interfaceC14405f.getEndInclusive());
        }

        /* renamed from: b */
        public static <T extends Comparable<? super T>> boolean m7607b(@NotNull InterfaceC14405f<T> interfaceC14405f) {
            return !interfaceC14405f.mo7609a(interfaceC14405f.getStart(), interfaceC14405f.getEndInclusive());
        }
    }

    /* renamed from: a */
    boolean mo7609a(@NotNull T t, @NotNull T t2);

    @Override // kotlin.ranges.InterfaceC14407g
    boolean contains(@NotNull T t);

    @Override // kotlin.ranges.InterfaceC14407g
    boolean isEmpty();
}
