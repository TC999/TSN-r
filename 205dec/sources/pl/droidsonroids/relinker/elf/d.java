package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: Elf32Header.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class d extends c.b {

    /* renamed from: m  reason: collision with root package name */
    private final f f61931m;

    public d(boolean z3, f fVar) throws IOException {
        this.f61915a = z3;
        this.f61931m = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z3 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f61916b = fVar.f(allocate, 16L);
        this.f61917c = fVar.i(allocate, 28L);
        this.f61918d = fVar.i(allocate, 32L);
        this.f61919e = fVar.f(allocate, 42L);
        this.f61920f = fVar.f(allocate, 44L);
        this.f61921g = fVar.f(allocate, 46L);
        this.f61922h = fVar.f(allocate, 48L);
        this.f61923i = fVar.f(allocate, 50L);
    }

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.a a(long j4, int i4) throws IOException {
        return new a(this.f61931m, this, j4, i4);
    }

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.AbstractC1255c b(long j4) throws IOException {
        return new g(this.f61931m, this, j4);
    }

    @Override // pl.droidsonroids.relinker.elf.c.b
    public c.d c(int i4) throws IOException {
        return new i(this.f61931m, this, i4);
    }
}
