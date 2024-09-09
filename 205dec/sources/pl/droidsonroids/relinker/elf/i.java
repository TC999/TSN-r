package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: Section32Header.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class i extends c.d {
    public i(f fVar, c.b bVar, int i4) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(bVar.f61915a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f61930a = fVar.i(allocate, bVar.f61918d + (i4 * bVar.f61921g) + 28);
    }
}
