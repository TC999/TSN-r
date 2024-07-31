package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: GzipSink.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, m12616d2 = {"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, m12615k = 2, m12614mv = {1, 4, 0})
@JvmName(name = "-GzipSinkExtensions")
/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink gzip) {
        C14342f0.m8184p(gzip, "$this$gzip");
        return new GzipSink(gzip);
    }
}
