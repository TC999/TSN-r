package pl.droidsonroids.relinker.elf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.UShort;
import okhttp3.internal.p629ws.WebSocketProtocol;
import pl.droidsonroids.relinker.elf.Elf;

/* renamed from: pl.droidsonroids.relinker.elf.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ElfParser implements Closeable, Elf {

    /* renamed from: a */
    private final int f44520a = 1179403647;

    /* renamed from: b */
    private final FileChannel f44521b;

    public ElfParser(File file) throws FileNotFoundException {
        if (file != null && file.exists()) {
            this.f44521b = new FileInputStream(file).getChannel();
            return;
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }

    /* renamed from: a */
    private long m2328a(Elf.AbstractC15469b abstractC15469b, long j, long j2) throws IOException {
        for (long j3 = 0; j3 < j; j3++) {
            Elf.AbstractC15470c mo2330b = abstractC15469b.mo2330b(j3);
            if (mo2330b.f44513a == 1) {
                long j4 = mo2330b.f44515c;
                if (j4 <= j2 && j2 <= mo2330b.f44516d + j4) {
                    return (j2 - j4) + mo2330b.f44514b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    /* renamed from: b */
    public Elf.AbstractC15469b m2327b() throws IOException {
        this.f44521b.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (m2320i(allocate, 0L) == 1179403647) {
            short m2324e = m2324e(allocate, 4L);
            boolean z = m2324e(allocate, 5L) == 2;
            if (m2324e == 1) {
                return new Elf32Header(z, this);
            }
            if (m2324e == 2) {
                return new Elf64Header(z, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    /* renamed from: c */
    public List<String> m2326c() throws IOException {
        long j;
        this.f44521b.position(0L);
        ArrayList arrayList = new ArrayList();
        Elf.AbstractC15469b m2327b = m2327b();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(m2327b.f44502a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = m2327b.f44507f;
        int i = 0;
        if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j2 = m2327b.mo2329c(0).f44517a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            Elf.AbstractC15470c mo2330b = m2327b.mo2330b(j3);
            if (mo2330b.f44513a == 2) {
                j = mo2330b.f44514b;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList<Long> arrayList2 = new ArrayList();
        long j4 = 0;
        while (true) {
            Elf.AbstractC15468a mo2331a = m2327b.mo2331a(j, i);
            long j5 = j;
            long j6 = mo2331a.f44497a;
            if (j6 == 1) {
                arrayList2.add(Long.valueOf(mo2331a.f44498b));
            } else if (j6 == 5) {
                j4 = mo2331a.f44498b;
            }
            i++;
            if (mo2331a.f44497a == 0) {
                break;
            }
            j = j5;
        }
        if (j4 != 0) {
            long m2328a = m2328a(m2327b, j2, j4);
            for (Long l : arrayList2) {
                arrayList.add(m2321h(allocate, l.longValue() + m2328a));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f44521b.close();
    }

    /* renamed from: d */
    protected void m2325d(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int read = this.f44521b.read(byteBuffer, j + j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 += read;
        }
        byteBuffer.position(0);
    }

    /* renamed from: e */
    protected short m2324e(ByteBuffer byteBuffer, long j) throws IOException {
        m2325d(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & UByte.f41242c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public int m2323f(ByteBuffer byteBuffer, long j) throws IOException {
        m2325d(byteBuffer, j, 2);
        return byteBuffer.getShort() & UShort.f40820c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public long m2322g(ByteBuffer byteBuffer, long j) throws IOException {
        m2325d(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    /* renamed from: h */
    protected String m2321h(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short m2324e = m2324e(byteBuffer, j);
            if (m2324e != 0) {
                sb.append((char) m2324e);
                j = j2;
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public long m2320i(ByteBuffer byteBuffer, long j) throws IOException {
        m2325d(byteBuffer, j, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}
