package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: Program64Header.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class h extends c.AbstractC1255c {
    public h(f fVar, c.b bVar, long j4) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(bVar.f61915a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j5 = bVar.f61917c + (j4 * bVar.f61919e);
        this.f61926a = fVar.i(allocate, j5);
        this.f61927b = fVar.g(allocate, 8 + j5);
        this.f61928c = fVar.g(allocate, 16 + j5);
        this.f61929d = fVar.g(allocate, j5 + 40);
    }
}
