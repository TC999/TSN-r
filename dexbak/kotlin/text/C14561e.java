package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;

/* compiled from: Charsets.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¨\u0006\u0004"}, m12616d2 = {"", "charsetName", "Ljava/nio/charset/Charset;", "a", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "CharsetsKt")
/* renamed from: kotlin.text.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14561e {
    @InlineOnly
    /* renamed from: a */
    private static final Charset m6830a(String str) {
        Charset forName = Charset.forName(str);
        C14342f0.m8185o(forName, "Charset.forName(charsetName)");
        return forName;
    }
}
