package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.channel.C13675a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u0017*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0018B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0012\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, m12616d2 = {"Lkotlin/e0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/o;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "isInitialized", "", "toString", "b", "Ljava/lang/Object;", "_value", "c", "final", "getValue", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/Function0;", "initializer", "<init>", "(Ll1/a;)V", "e", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.e0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class LazyJVM<T> implements InterfaceC14378o<T>, Serializable {

    /* renamed from: a */
    private volatile InterfaceC15269a<? extends T> f41045a;

    /* renamed from: b */
    private volatile Object f41046b;

    /* renamed from: c */
    private final Object f41047c;
    @NotNull

    /* renamed from: e */
    public static final C14297a f41044e = new C14297a(null);

    /* renamed from: d */
    private static final AtomicReferenceFieldUpdater<LazyJVM<?>, Object> f41043d = AtomicReferenceFieldUpdater.newUpdater(LazyJVM.class, Object.class, "b");

    /* compiled from: LazyJVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bRd\u0010\u0005\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001 \u0004*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m12616d2 = {"Lkotlin/e0$a;", "", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/e0;", "kotlin.jvm.PlatformType", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.e0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14297a {
        private C14297a() {
        }

        public /* synthetic */ C14297a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LazyJVM(@NotNull InterfaceC15269a<? extends T> initializer) {
        C14342f0.m8184p(initializer, "initializer");
        this.f41045a = initializer;
        C14613z0 c14613z0 = C14613z0.f41683a;
        this.f41046b = c14613z0;
        this.f41047c = c14613z0;
    }

    private final Object writeReplace() {
        return new Lazy(getValue());
    }

    @Override // kotlin.InterfaceC14378o
    public T getValue() {
        T t = (T) this.f41046b;
        C14613z0 c14613z0 = C14613z0.f41683a;
        if (t != c14613z0) {
            return t;
        }
        InterfaceC15269a<? extends T> interfaceC15269a = this.f41045a;
        if (interfaceC15269a != null) {
            T invoke = interfaceC15269a.invoke();
            if (C13675a.m12692a(f41043d, this, c14613z0, invoke)) {
                this.f41045a = null;
                return invoke;
            }
        }
        return (T) this.f41046b;
    }

    @Override // kotlin.InterfaceC14378o
    public boolean isInitialized() {
        return this.f41046b != C14613z0.f41683a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
