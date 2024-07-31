package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.Elf;

/* renamed from: pl.droidsonroids.relinker.elf.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Elf32Header extends Elf.AbstractC15469b {

    /* renamed from: m */
    private final ElfParser f44518m;

    public Elf32Header(boolean z, ElfParser elfParser) throws IOException {
        this.f44502a = z;
        this.f44518m = elfParser;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f44503b = elfParser.m2323f(allocate, 16L);
        this.f44504c = elfParser.m2320i(allocate, 28L);
        this.f44505d = elfParser.m2320i(allocate, 32L);
        this.f44506e = elfParser.m2323f(allocate, 42L);
        this.f44507f = elfParser.m2323f(allocate, 44L);
        this.f44508g = elfParser.m2323f(allocate, 46L);
        this.f44509h = elfParser.m2323f(allocate, 48L);
        this.f44510i = elfParser.m2323f(allocate, 50L);
    }

    @Override // pl.droidsonroids.relinker.elf.Elf.AbstractC15469b
    /* renamed from: a */
    public Elf.AbstractC15468a mo2331a(long j, int i) throws IOException {
        return new Dynamic32Structure(this.f44518m, this, j, i);
    }

    @Override // pl.droidsonroids.relinker.elf.Elf.AbstractC15469b
    /* renamed from: b */
    public Elf.AbstractC15470c mo2330b(long j) throws IOException {
        return new Program32Header(this.f44518m, this, j);
    }

    @Override // pl.droidsonroids.relinker.elf.Elf.AbstractC15469b
    /* renamed from: c */
    public Elf.AbstractC15471d mo2329c(int i) throws IOException {
        return new Section32Header(this.f44518m, this, i);
    }
}
