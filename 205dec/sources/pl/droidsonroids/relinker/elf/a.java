package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: Dynamic32Structure.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class a extends c.a {
    public a(f fVar, c.b bVar, long j4, int i4) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(bVar.f61915a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j5 = j4 + (i4 * 8);
        this.f61910a = fVar.i(allocate, j5);
        this.f61911b = fVar.i(allocate, j5 + 4);
    }
}
