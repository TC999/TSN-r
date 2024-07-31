package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.internal.Scopes;
import org.jetbrains.annotations.NotNull;

/* compiled from: Timeout.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/q3;", "U", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/f0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlin/f1;", "run", "", "M0", "()Ljava/lang/String;", "", "e", "J", RtspHeaders.Values.TIME, "Lkotlin/coroutines/c;", "uCont", "<init>", "(JLkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.q3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class RunnableC15160q3<U, T extends U> extends Scopes<T> implements Runnable {
    @JvmPlatformAnnotations

    /* renamed from: e */
    public final long f43227e;

    public RunnableC15160q3(long j, @NotNull InterfaceC14268c<? super U> interfaceC14268c) {
        super(interfaceC14268c.getContext(), interfaceC14268c);
        this.f43227e = j;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.C15125l2
    @NotNull
    /* renamed from: M0 */
    public String mo3854M0() {
        return super.mo3854M0() + "(timeMillis=" + this.f43227e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        m4046b0(C15164r3.m3817a(this.f43227e, this));
    }
}
