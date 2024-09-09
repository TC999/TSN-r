package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Charsets.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u00a8\u0006\u0004"}, d2 = {"", "charsetName", "Ljava/nio/charset/Charset;", "a", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "CharsetsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    @InlineOnly
    private static final Charset a(String charsetName) {
        f0.p(charsetName, "charsetName");
        Charset forName = Charset.forName(charsetName);
        f0.o(forName, "forName(charsetName)");
        return forName;
    }
}
