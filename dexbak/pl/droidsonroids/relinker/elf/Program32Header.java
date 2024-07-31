package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.Elf;

/* renamed from: pl.droidsonroids.relinker.elf.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Program32Header extends Elf.AbstractC15470c {
    public Program32Header(ElfParser elfParser, Elf.AbstractC15469b abstractC15469b, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(abstractC15469b.f44502a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = abstractC15469b.f44504c + (j * abstractC15469b.f44506e);
        this.f44513a = elfParser.m2320i(allocate, j2);
        this.f44514b = elfParser.m2320i(allocate, 4 + j2);
        this.f44515c = elfParser.m2320i(allocate, 8 + j2);
        this.f44516d = elfParser.m2320i(allocate, j2 + 20);
    }
}
