package kotlin.properties;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.InterfaceC14446n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\t\u0010\nJ+\u0010\f\u001a\u00020\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000f\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J.\u0010\u0012\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0011\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014¨\u0006\u0018"}, m12616d2 = {"Lkotlin/properties/c;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/properties/f;", "", "Lkotlin/reflect/n;", "property", "oldValue", "newValue", "", "d", "(Lkotlin/reflect/n;Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlin/f1;", "c", "(Lkotlin/reflect/n;Ljava/lang/Object;Ljava/lang/Object;)V", "thisRef", "a", "(Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "b", "(Ljava/lang/Object;Lkotlin/reflect/n;Ljava/lang/Object;)V", "Ljava/lang/Object;", "initialValue", "<init>", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.properties.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ObservableProperty<V> implements InterfaceC14386f<Object, V> {

    /* renamed from: a */
    private V f41257a;

    public ObservableProperty(V v) {
        this.f41257a = v;
    }

    @Override // kotlin.properties.InterfaceC14386f, kotlin.properties.InterfaceC14385e
    /* renamed from: a */
    public V mo7729a(@Nullable Object obj, @NotNull InterfaceC14446n<?> property) {
        C14342f0.m8184p(property, "property");
        return this.f41257a;
    }

    @Override // kotlin.properties.InterfaceC14386f
    /* renamed from: b */
    public void mo7728b(@Nullable Object obj, @NotNull InterfaceC14446n<?> property, V v) {
        C14342f0.m8184p(property, "property");
        V v2 = this.f41257a;
        if (mo7731d(property, v2, v)) {
            this.f41257a = v;
            mo7732c(property, v2, v);
        }
    }

    /* renamed from: c */
    protected void mo7732c(@NotNull InterfaceC14446n<?> property, V v, V v2) {
        C14342f0.m8184p(property, "property");
    }

    /* renamed from: d */
    protected boolean mo7731d(@NotNull InterfaceC14446n<?> property, V v, V v2) {
        C14342f0.m8184p(property, "property");
        return true;
    }
}
