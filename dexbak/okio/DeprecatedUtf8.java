package okio;

import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: -DeprecatedUtf8.kt */
@Annotations(message = "changed in Okio 2.x")
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, m12616d2 = {"Lokio/-DeprecatedUtf8;", "", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "okio"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: okio.-DeprecatedUtf8  reason: invalid class name */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size()", imports = {"okio.utf8Size"}))
    public final long size(@NotNull String string) {
        C14342f0.m8184p(string, "string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size(beginIndex, endIndex)", imports = {"okio.utf8Size"}))
    public final long size(@NotNull String string, int i, int i2) {
        C14342f0.m8184p(string, "string");
        return Utf8.size(string, i, i2);
    }
}
