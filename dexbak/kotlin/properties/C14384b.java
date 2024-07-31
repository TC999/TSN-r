package kotlin.properties;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.InterfaceC14446n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delegates.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0007\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u0010"}, m12616d2 = {"Lkotlin/properties/b;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/properties/f;", "thisRef", "Lkotlin/reflect/n;", "property", "a", "(Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "b", "(Ljava/lang/Object;Lkotlin/reflect/n;Ljava/lang/Object;)V", "Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.properties.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14384b<T> implements InterfaceC14386f<Object, T> {

    /* renamed from: a */
    private T f41256a;

    @Override // kotlin.properties.InterfaceC14386f, kotlin.properties.InterfaceC14385e
    @NotNull
    /* renamed from: a */
    public T mo7729a(@Nullable Object obj, @NotNull InterfaceC14446n<?> property) {
        C14342f0.m8184p(property, "property");
        T t = this.f41256a;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    @Override // kotlin.properties.InterfaceC14386f
    /* renamed from: b */
    public void mo7728b(@Nullable Object obj, @NotNull InterfaceC14446n<?> property, @NotNull T value) {
        C14342f0.m8184p(property, "property");
        C14342f0.m8184p(value, "value");
        this.f41256a = value;
    }
}
