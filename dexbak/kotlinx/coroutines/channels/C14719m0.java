package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channel.kt */
@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u000b\u001eB\u0016\b\u0000\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00008F¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198F¢\u0006\f\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, m12616d2 = {"Lkotlinx/coroutines/channels/m0;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "m", "(Ljava/lang/Object;)Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "a", "Ljava/lang/Object;", "holder", C7304t.f25048d, "(Ljava/lang/Object;)Z", "isClosed", "h", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue$annotations", "()V", DomainCampaignEx.LOOPBACK_VALUE, "j", "getValueOrNull$annotations", "valueOrNull", "", "f", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getCloseCause$annotations", "closeCause", "b", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.m0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14719m0<T> {

    /* renamed from: b */
    public static final C14721b f42114b = new C14721b(null);

    /* renamed from: a */
    private final Object f42115a;

    /* compiled from: Channel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/channels/m0$a;", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "", "a", "Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.m0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14720a {
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: a */
        public final Throwable f42116a;

        public C14720a(@Nullable Throwable th) {
            this.f42116a = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof C14720a) && C14342f0.m8193g(this.f42116a, ((C14720a) obj).f42116a);
        }

        public int hashCode() {
            Throwable th = this.f42116a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Closed(" + this.f42116a + ')';
        }
    }

    /* compiled from: Channel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\u0080\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0080\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/channels/m0$b;", "", ExifInterface.LONGITUDE_EAST, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlinx/coroutines/channels/m0;", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "cause", "a", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.m0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14721b {
        private C14721b() {
        }

        @NotNull
        /* renamed from: a */
        public final <E> Object m5404a(@Nullable Throwable th) {
            return C14719m0.m5417b(new C14720a(th));
        }

        @NotNull
        /* renamed from: b */
        public final <E> Object m5403b(E e) {
            return C14719m0.m5417b(e);
        }

        public /* synthetic */ C14721b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ C14719m0(@Nullable Object obj) {
        this.f42115a = obj;
    }

    @NotNull
    /* renamed from: a */
    public static final /* synthetic */ C14719m0 m5418a(@Nullable Object obj) {
        return new C14719m0(obj);
    }

    @NotNull
    /* renamed from: b */
    public static Object m5417b(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: c */
    public static boolean m5416c(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof C14719m0) && C14342f0.m8193g(obj, ((C14719m0) obj2).m5405n());
    }

    /* renamed from: d */
    public static final boolean m5415d(@Nullable Object obj, @Nullable Object obj2) {
        return C14342f0.m8193g(obj, obj2);
    }

    /* renamed from: e */
    public static /* synthetic */ void m5414e() {
    }

    @Nullable
    /* renamed from: f */
    public static final Throwable m5413f(Object obj) {
        if (obj instanceof C14720a) {
            return ((C14720a) obj).f42116a;
        }
        throw new IllegalStateException("Channel was not closed".toString());
    }

    /* renamed from: g */
    public static /* synthetic */ void m5412g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    public static final T m5411h(Object obj) {
        if (obj instanceof C14720a) {
            throw new IllegalStateException(C14729r.f42137a.toString());
        }
        return obj;
    }

    /* renamed from: i */
    public static /* synthetic */ void m5410i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* renamed from: j */
    public static final T m5409j(Object obj) {
        if (obj instanceof C14720a) {
            return null;
        }
        return obj;
    }

    /* renamed from: k */
    public static int m5408k(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: l */
    public static final boolean m5407l(Object obj) {
        return obj instanceof C14720a;
    }

    @NotNull
    /* renamed from: m */
    public static String m5406m(Object obj) {
        if (obj instanceof C14720a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m5416c(this.f42115a, obj);
    }

    public int hashCode() {
        return m5408k(this.f42115a);
    }

    @Nullable
    /* renamed from: n */
    public final /* synthetic */ Object m5405n() {
        return this.f42115a;
    }

    @NotNull
    public String toString() {
        return m5406m(this.f42115a);
    }
}
