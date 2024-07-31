package p634p1;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¨\u0006\u0004"}, m12616d2 = {"", "status", "", "a", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "ProcessKt")
/* renamed from: p1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Process {
    @InlineOnly
    /* renamed from: a */
    private static final Void m2544a(int i) {
        System.exit(i);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
