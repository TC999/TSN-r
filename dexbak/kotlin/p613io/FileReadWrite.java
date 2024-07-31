package kotlin.p613io;

import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, m12616d2 = {"Lkotlin/io/f;", "Ljava/io/ByteArrayOutputStream;", "", "a", "()[B", "buffer", "", "size", "<init>", "(I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class FileReadWrite extends ByteArrayOutputStream {
    public FileReadWrite(int i) {
        super(i);
    }

    @NotNull
    /* renamed from: a */
    public final byte[] m8466a() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        C14342f0.m8185o(buf, "buf");
        return buf;
    }
}
