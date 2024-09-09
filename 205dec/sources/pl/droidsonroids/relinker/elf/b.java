package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: Dynamic64Structure.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class b extends c.a {
    public b(f fVar, c.b bVar, long j4, int i4) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(bVar.f61915a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j5 = j4 + (i4 * 16);
        this.f61910a = fVar.g(allocate, j5);
        this.f61911b = fVar.g(allocate, j5 + 8);
    }
}
