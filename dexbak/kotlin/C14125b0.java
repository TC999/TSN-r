package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.internal.InlineOnly;
import p617l1.InterfaceC15269a;

/* compiled from: Preconditions.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a1\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\u0087\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\t\u0010\n\u001aB\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a1\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\u0087\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u000f\u0010\n\u001aB\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0010\u0010\f\u001a\u0011\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0005H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, m12616d2 = {"", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "h", "Lkotlin/Function0;", "", "lazyMessage", "i", ExifInterface.GPS_DIRECTION_TRUE, "j", "(Ljava/lang/Object;)Ljava/lang/Object;", "k", "(Ljava/lang/Object;Ll1/a;)Ljava/lang/Object;", "c", "d", "e", "f", "message", "", "g", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/PreconditionsKt")
/* renamed from: kotlin.b0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14125b0 extends AssertionsJVM {
    @InlineOnly
    /* renamed from: c */
    private static final void m12576c(boolean z) {
        if (!z) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @InlineOnly
    /* renamed from: d */
    private static final void m12575d(boolean z, InterfaceC15269a<? extends Object> interfaceC15269a) {
        if (!z) {
            throw new IllegalStateException(interfaceC15269a.invoke().toString());
        }
    }

    @InlineOnly
    /* renamed from: e */
    private static final <T> T m12574e(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @InlineOnly
    /* renamed from: f */
    private static final <T> T m12573f(T t, InterfaceC15269a<? extends Object> interfaceC15269a) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(interfaceC15269a.invoke().toString());
    }

    @InlineOnly
    /* renamed from: g */
    private static final Void m12572g(Object obj) {
        throw new IllegalStateException(obj.toString());
    }

    @InlineOnly
    /* renamed from: h */
    private static final void m12571h(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @InlineOnly
    /* renamed from: i */
    private static final void m12570i(boolean z, InterfaceC15269a<? extends Object> interfaceC15269a) {
        if (!z) {
            throw new IllegalArgumentException(interfaceC15269a.invoke().toString());
        }
    }

    @InlineOnly
    /* renamed from: j */
    private static final <T> T m12569j(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @InlineOnly
    /* renamed from: k */
    private static final <T> T m12568k(T t, InterfaceC15269a<? extends Object> interfaceC15269a) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(interfaceC15269a.invoke().toString());
    }
}
