package androidx.core.location;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0086\n¨\u0006\u0004"}, m12616d2 = {"component1", "", "Landroid/location/Location;", "component2", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.location.LocationKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Location {
    public static final double component1(@NotNull android.location.Location component1) {
        C14342f0.m8183q(component1, "$this$component1");
        return component1.getLatitude();
    }

    public static final double component2(@NotNull android.location.Location component2) {
        C14342f0.m8183q(component2, "$this$component2");
        return component2.getLongitude();
    }
}
