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
import pl.droidsonroids.relinker.elf.c;

/* compiled from: ElfParser.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class f implements Closeable, c {

    /* renamed from: a  reason: collision with root package name */
    private final int f61933a = 1179403647;

    /* renamed from: b  reason: collision with root package name */
    private final FileChannel f61934b;

    public f(File file) throws FileNotFoundException {
        if (file != null && file.exists()) {
            this.f61934b = new FileInputStream(file).getChannel();
            return;
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }

    private long a(c.b bVar, long j4, long j5) throws IOException {
        for (long j6 = 0; j6 < j4; j6++) {
            c.AbstractC1255c b4 = bVar.b(j6);
            if (b4.f61926a == 1) {
                long j7 = b4.f61928c;
                if (j7 <= j5 && j5 <= b4.f61929d + j7) {
                    return (j5 - j7) + b4.f61927b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public c.b b() throws IOException {
        this.f61934b.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (i(allocate, 0L) == 1179403647) {
            short e4 = e(allocate, 4L);
            boolean z3 = e(allocate, 5L) == 2;
            if (e4 == 1) {
                return new d(z3, this);
            }
            if (e4 == 2) {
                return new e(z3, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> c() throws IOException {
        long j4;
        this.f61934b.position(0L);
        ArrayList arrayList = new ArrayList();
        c.b b4 = b();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(b4.f61915a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j5 = b4.f61920f;
        int i4 = 0;
        if (j5 == 65535) {
            j5 = b4.c(0).f61930a;
        }
        long j6 = 0;
        while (true) {
            if (j6 >= j5) {
                j4 = 0;
                break;
            }
            c.AbstractC1255c b5 = b4.b(j6);
            if (b5.f61926a == 2) {
                j4 = b5.f61927b;
                break;
            }
            j6++;
        }
        if (j4 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList<Long> arrayList2 = new ArrayList();
        long j7 = 0;
        while (true) {
            c.a a4 = b4.a(j4, i4);
            long j8 = j4;
            long j9 = a4.f61910a;
            if (j9 == 1) {
                arrayList2.add(Long.valueOf(a4.f61911b));
            } else if (j9 == 5) {
                j7 = a4.f61911b;
            }
            i4++;
            if (a4.f61910a == 0) {
                break;
            }
            j4 = j8;
        }
        if (j7 != 0) {
            long a5 = a(b4, j5, j7);
            for (Long l4 : arrayList2) {
                arrayList.add(h(allocate, l4.longValue() + a5));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f61934b.close();
    }

    protected void d(ByteBuffer byteBuffer, long j4, int i4) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i4);
        long j5 = 0;
        while (j5 < i4) {
            int read = this.f61934b.read(byteBuffer, j4 + j5);
            if (read == -1) {
                throw new EOFException();
            }
            j5 += read;
        }
        byteBuffer.position(0);
    }

    protected short e(ByteBuffer byteBuffer, long j4) throws IOException {
        d(byteBuffer, j4, 1);
        return (short) (byteBuffer.get() & 255);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f(ByteBuffer byteBuffer, long j4) throws IOException {
        d(byteBuffer, j4, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long g(ByteBuffer byteBuffer, long j4) throws IOException {
        d(byteBuffer, j4, 8);
        return byteBuffer.getLong();
    }

    protected String h(ByteBuffer byteBuffer, long j4) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j5 = 1 + j4;
            short e4 = e(byteBuffer, j4);
            if (e4 != 0) {
                sb.append((char) e4);
                j4 = j5;
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long i(ByteBuffer byteBuffer, long j4) throws IOException {
        d(byteBuffer, j4, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}
