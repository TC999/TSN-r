package u2;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* compiled from: Process.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u00a8\u0006\u0004"}, d2 = {"", "status", "", "a", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "ProcessKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @InlineOnly
    private static final Void a(int i4) {
        System.exit(i4);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
