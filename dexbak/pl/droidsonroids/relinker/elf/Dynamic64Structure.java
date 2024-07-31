package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.Elf;

/* renamed from: pl.droidsonroids.relinker.elf.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Dynamic64Structure extends Elf.AbstractC15468a {
    public Dynamic64Structure(ElfParser elfParser, Elf.AbstractC15469b abstractC15469b, long j, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(abstractC15469b.f44502a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 16);
        this.f44497a = elfParser.m2322g(allocate, j2);
        this.f44498b = elfParser.m2322g(allocate, j2 + 8);
    }
}
