package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.Elf;

/* renamed from: pl.droidsonroids.relinker.elf.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Elf64Header extends Elf.AbstractC15469b {

    /* renamed from: m */
    private final ElfParser f44519m;

    public Elf64Header(boolean z, ElfParser elfParser) throws IOException {
        this.f44502a = z;
        this.f44519m = elfParser;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f44503b = elfParser.m2323f(allocate, 16L);
        this.f44504c = elfParser.m2322g(allocate, 32L);
        this.f44505d = elfParser.m2322g(allocate, 40L);
        this.f44506e = elfParser.m2323f(allocate, 54L);
        this.f44507f = elfParser.m2323f(allocate, 56L);
        this.f44508g = elfParser.m2323f(allocate, 58L);
        this.f44509h = elfParser.m2323f(allocate, 60L);
        this.f44510i = elfParser.m2323f(allocate, 62L);
    }

    @Override // pl.droidsonroids.relinker.elf.Elf.AbstractC15469b
    /* renamed from: a */
    public Elf.AbstractC15468a mo2331a(long j, int i) throws IOException {
        return new Dynamic64Structure(this.f44519m, this, j, i);
    }

    @Override // pl.droidsonroids.relinker.elf.Elf.AbstractC15469b
    /* renamed from: b */
    public Elf.AbstractC15470c mo2330b(long j) throws IOException {
        return new Program64Header(this.f44519m, this, j);
    }

    @Override // pl.droidsonroids.relinker.elf.Elf.AbstractC15469b
    /* renamed from: c */
    public Elf.AbstractC15471d mo2329c(int i) throws IOException {
        return new Section64Header(this.f44519m, this, i);
    }
}
