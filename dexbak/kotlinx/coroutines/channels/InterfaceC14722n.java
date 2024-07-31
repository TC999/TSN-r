package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.internal.C15082l0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Channel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0005¨\u0006\u0006"}, m12616d2 = {"Lkotlinx/coroutines/channels/n;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/h0;", "Lkotlinx/coroutines/channels/d0;", "n0", "b", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14722n<E> extends InterfaceC14704h0<E>, InterfaceC14695d0<E> {

    /* renamed from: n0 */
    public static final C14724b f42117n0 = C14724b.f42131h;

    /* renamed from: o0 */
    public static final int f42118o0 = Integer.MAX_VALUE;

    /* renamed from: q0 */
    public static final int f42119q0 = 0;

    /* renamed from: r0 */
    public static final int f42120r0 = -1;

    /* renamed from: s0 */
    public static final int f42121s0 = -2;

    /* renamed from: t0 */
    public static final int f42122t0 = -3;
    @NotNull

    /* renamed from: u0 */
    public static final String f42123u0 = "kotlinx.coroutines.channels.defaultBuffer";

    /* compiled from: Channel.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.n$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C14723a {
    }

    /* compiled from: Channel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0003\u0010\u0013¨\u0006\u0017"}, m12616d2 = {"Lkotlinx/coroutines/channels/n$b;", "", "", "a", "I", "UNLIMITED", "b", "RENDEZVOUS", "c", "CONFLATED", "d", "BUFFERED", "e", "OPTIONAL_CHANNEL", "", "f", "Ljava/lang/String;", "DEFAULT_BUFFER_PROPERTY_NAME", "g", "()I", "CHANNEL_DEFAULT_CAPACITY", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.n$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14724b {

        /* renamed from: a */
        public static final int f42124a = Integer.MAX_VALUE;

        /* renamed from: b */
        public static final int f42125b = 0;

        /* renamed from: c */
        public static final int f42126c = -1;

        /* renamed from: d */
        public static final int f42127d = -2;

        /* renamed from: e */
        public static final int f42128e = -3;
        @NotNull

        /* renamed from: f */
        public static final String f42129f = "kotlinx.coroutines.channels.defaultBuffer";

        /* renamed from: h */
        static final /* synthetic */ C14724b f42131h = new C14724b();

        /* renamed from: g */
        private static final int f42130g = C15082l0.m4280b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private C14724b() {
        }

        /* renamed from: a */
        public final int m5401a() {
            return f42130g;
        }
    }
}
