package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.Elf;

/* renamed from: pl.droidsonroids.relinker.elf.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Program64Header extends Elf.AbstractC15470c {
    public Program64Header(ElfParser elfParser, Elf.AbstractC15469b abstractC15469b, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(abstractC15469b.f44502a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = abstractC15469b.f44504c + (j * abstractC15469b.f44506e);
        this.f44513a = elfParser.m2320i(allocate, j2);
        this.f44514b = elfParser.m2322g(allocate, 8 + j2);
        this.f44515c = elfParser.m2322g(allocate, 16 + j2);
        this.f44516d = elfParser.m2322g(allocate, j2 + 40);
    }
}
