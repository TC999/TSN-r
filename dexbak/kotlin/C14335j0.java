package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.Serializable;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* compiled from: LazyJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B!\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0012\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, m12616d2 = {"Lkotlin/j0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/o;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "isInitialized", "", "toString", "b", "Ljava/lang/Object;", "_value", "c", "lock", "getValue", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/Function0;", "initializer", "<init>", "(Ll1/a;Ljava/lang/Object;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.j0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14335j0<T> implements InterfaceC14378o<T>, Serializable {

    /* renamed from: a */
    private InterfaceC15269a<? extends T> f41113a;

    /* renamed from: b */
    private volatile Object f41114b;

    /* renamed from: c */
    private final Object f41115c;

    public C14335j0(@NotNull InterfaceC15269a<? extends T> initializer, @Nullable Object obj) {
        C14342f0.m8184p(initializer, "initializer");
        this.f41113a = initializer;
        this.f41114b = C14613z0.f41683a;
        this.f41115c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new Lazy(getValue());
    }

    @Override // kotlin.InterfaceC14378o
    public T getValue() {
        T t;
        T t2 = (T) this.f41114b;
        C14613z0 c14613z0 = C14613z0.f41683a;
        if (t2 != c14613z0) {
            return t2;
        }
        synchronized (this.f41115c) {
            t = (T) this.f41114b;
            if (t == c14613z0) {
                InterfaceC15269a<? extends T> interfaceC15269a = this.f41113a;
                C14342f0.m8187m(interfaceC15269a);
                t = interfaceC15269a.invoke();
                this.f41114b = t;
                this.f41113a = null;
            }
        }
        return t;
    }

    @Override // kotlin.InterfaceC14378o
    public boolean isInitialized() {
        return this.f41114b != C14613z0.f41683a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ C14335j0(InterfaceC15269a interfaceC15269a, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC15269a, (i & 2) != 0 ? null : obj);
    }
}
