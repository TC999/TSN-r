package androidx.core.p018os;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "sectionName", "Lkotlin/Function0;", "block", "trace", "(Ljava/lang/String;Ll1/a;)Ljava/lang/Object;", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.os.TraceKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Trace {
    public static final <T> T trace(@NotNull String sectionName, @NotNull InterfaceC15269a<? extends T> block) {
        C14342f0.m8183q(sectionName, "sectionName");
        C14342f0.m8183q(block, "block");
        TraceCompat.beginSection(sectionName);
        try {
            return block.invoke();
        } finally {
            InlineMarker.m8228d(1);
            TraceCompat.endSection();
            InlineMarker.m8229c(1);
        }
    }
}
