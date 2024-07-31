package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.Serializable;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

/* compiled from: Lazy.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m12616d2 = {"Lkotlin/UnsafeLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/o;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "isInitialized", "", "toString", "_value", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/Function0;", "initializer", "<init>", "(Ll1/a;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UnsafeLazyImpl<T> implements InterfaceC14378o<T>, Serializable {
    private Object _value;
    private InterfaceC15269a<? extends T> initializer;

    public UnsafeLazyImpl(@NotNull InterfaceC15269a<? extends T> initializer) {
        C14342f0.m8184p(initializer, "initializer");
        this.initializer = initializer;
        this._value = C14613z0.f41683a;
    }

    private final Object writeReplace() {
        return new Lazy(getValue());
    }

    @Override // kotlin.InterfaceC14378o
    public T getValue() {
        if (this._value == C14613z0.f41683a) {
            InterfaceC15269a<? extends T> interfaceC15269a = this.initializer;
            C14342f0.m8187m(interfaceC15269a);
            this._value = interfaceC15269a.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // kotlin.InterfaceC14378o
    public boolean isInitialized() {
        return this._value != C14613z0.f41683a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
