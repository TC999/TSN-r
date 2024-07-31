package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.Elf;

/* renamed from: pl.droidsonroids.relinker.elf.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Dynamic32Structure extends Elf.AbstractC15468a {
    public Dynamic32Structure(ElfParser elfParser, Elf.AbstractC15469b abstractC15469b, long j, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(abstractC15469b.f44502a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 8);
        this.f44497a = elfParser.m2320i(allocate, j2);
        this.f44498b = elfParser.m2320i(allocate, j2 + 4);
    }
}
