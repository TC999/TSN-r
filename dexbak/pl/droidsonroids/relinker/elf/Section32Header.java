package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.Elf;

/* renamed from: pl.droidsonroids.relinker.elf.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Section32Header extends Elf.AbstractC15471d {
    public Section32Header(ElfParser elfParser, Elf.AbstractC15469b abstractC15469b, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(abstractC15469b.f44502a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f44517a = elfParser.m2320i(allocate, abstractC15469b.f44505d + (i * abstractC15469b.f44508g) + 28);
    }
}
