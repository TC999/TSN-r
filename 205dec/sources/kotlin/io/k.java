package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FileReadWrite.kt */
@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a!\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u0017\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a!\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u0017\u0010\u000e\u001a\u00020\r*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\n\u0010\u0010\u001a\u00020\u000f*\u00020\u0000\u001a\u0012\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000f\u001a\u0012\u0010\u0014\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000f\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u001c\u0010\u0018\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u001c\u0010\u0019\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001aB\u0010 \u001a\u00020\u0012*\u00020\u000026\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00120\u001a\u001aJ\u0010\"\u001a\u00020\u0012*\u00020\u00002\u0006\u0010!\u001a\u00020\u000526\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00120\u001a\u001a7\u0010%\u001a\u00020\u0012*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00120#\u001a\r\u0010'\u001a\u00020&*\u00020\u0000H\u0087\b\u001a\r\u0010)\u001a\u00020(*\u00020\u0000H\u0087\b\u001a\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150**\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001aD\u00100\u001a\u00028\u0000\"\u0004\b\u0000\u0010,*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0018\u0010.\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150-\u0012\u0004\u0012\u00028\u00000#H\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u00101\u0082\u0002\u000f\n\u0006\b\u0011(/0\u0001\n\u0005\b\u009920\u0001\u00a8\u00062"}, d2 = {"Ljava/io/File;", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/InputStreamReader;", "A", "", "bufferSize", "Ljava/io/BufferedReader;", "j", "Ljava/io/OutputStreamWriter;", "H", "Ljava/io/BufferedWriter;", "l", "Ljava/io/PrintWriter;", "t", "", "v", "array", "Lkotlin/f1;", "E", "g", "", "y", "text", "F", "h", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "action", "o", "blockSize", "n", "Lkotlin/Function1;", "line", "p", "Ljava/io/FileInputStream;", "r", "Ljava/io/FileOutputStream;", "s", "", "w", "T", "Lkotlin/sequences/m;", "block", "Requires newer compiler version to be inlined correctly.", "C", "(Ljava/io/File;Ljava/nio/charset/Charset;Ld2/l;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/io/FilesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class k extends j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileReadWrite.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/f1;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<String, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f55576a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList<String> arrayList) {
            super(1);
            this.f55576a = arrayList;
        }

        public final void a(@NotNull String it) {
            f0.p(it, "it");
            this.f55576a.add(it);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(String str) {
            a(str);
            return f1.f55527a;
        }
    }

    @InlineOnly
    private static final InputStreamReader A(File file, Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    static /* synthetic */ InputStreamReader B(File file, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T C(@NotNull File file, @NotNull Charset charset, @NotNull d2.l<? super kotlin.sequences.m<String>, ? extends T> block) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        f0.p(block, "block");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            T invoke = block.invoke(r.h(bufferedReader));
            c0.d(1);
            b.a(bufferedReader, null);
            c0.c(1);
            return invoke;
        } finally {
        }
    }

    public static /* synthetic */ Object D(File file, Charset charset, d2.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            Object invoke = lVar.invoke(r.h(bufferedReader));
            c0.d(1);
            b.a(bufferedReader, null);
            c0.c(1);
            return invoke;
        } finally {
        }
    }

    public static final void E(@NotNull File file, @NotNull byte[] array) {
        f0.p(file, "<this>");
        f0.p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            f1 f1Var = f1.f55527a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void F(@NotNull File file, @NotNull String text, @NotNull Charset charset) {
        f0.p(file, "<this>");
        f0.p(text, "text");
        f0.p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        E(file, bytes);
    }

    public static /* synthetic */ void G(File file, String str, Charset charset, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        F(file, str, charset);
    }

    @InlineOnly
    private static final OutputStreamWriter H(File file, Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    static /* synthetic */ OutputStreamWriter I(File file, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static final void g(@NotNull File file, @NotNull byte[] array) {
        f0.p(file, "<this>");
        f0.p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            f1 f1Var = f1.f55527a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void h(@NotNull File file, @NotNull String text, @NotNull Charset charset) {
        f0.p(file, "<this>");
        f0.p(text, "text");
        f0.p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        g(file, bytes);
    }

    public static /* synthetic */ void i(File file, String str, Charset charset, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        h(file, str, charset);
    }

    @InlineOnly
    private static final BufferedReader j(File file, Charset charset, int i4) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i4);
    }

    static /* synthetic */ BufferedReader k(File file, Charset charset, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        if ((i5 & 2) != 0) {
            i4 = 8192;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i4);
    }

    @InlineOnly
    private static final BufferedWriter l(File file, Charset charset, int i4) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i4);
    }

    static /* synthetic */ BufferedWriter m(File file, Charset charset, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        if ((i5 & 2) != 0) {
            i4 = 8192;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, byte[]] */
    public static final void n(@NotNull File file, int i4, @NotNull d2.p<? super byte[], ? super Integer, f1> action) {
        int n4;
        f0.p(file, "<this>");
        f0.p(action, "action");
        n4 = kotlin.ranges.q.n(i4, 512);
        ?? r22 = new byte[n4];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(r22);
                if (read <= 0) {
                    f1 f1Var = f1.f55527a;
                    b.a(fileInputStream, null);
                    return;
                }
                action.invoke(r22, Integer.valueOf(read));
            } finally {
            }
        }
    }

    public static final void o(@NotNull File file, @NotNull d2.p<? super byte[], ? super Integer, f1> action) {
        f0.p(file, "<this>");
        f0.p(action, "action");
        n(file, 4096, action);
    }

    public static final void p(@NotNull File file, @NotNull Charset charset, @NotNull d2.l<? super String, f1> action) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        f0.p(action, "action");
        r.g(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    public static /* synthetic */ void q(File file, Charset charset, d2.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        p(file, charset, lVar);
    }

    @InlineOnly
    private static final FileInputStream r(File file) {
        f0.p(file, "<this>");
        return new FileInputStream(file);
    }

    @InlineOnly
    private static final FileOutputStream s(File file) {
        f0.p(file, "<this>");
        return new FileOutputStream(file);
    }

    @InlineOnly
    private static final PrintWriter t(File file, Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    static /* synthetic */ PrintWriter u(File file, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    @NotNull
    public static final byte[] v(@NotNull File file) {
        f0.p(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                int i4 = (int) length;
                byte[] bArr = new byte[i4];
                int i5 = i4;
                int i6 = 0;
                while (i5 > 0) {
                    int read = fileInputStream.read(bArr, i6, i5);
                    if (read < 0) {
                        break;
                    }
                    i5 -= read;
                    i6 += read;
                }
                if (i5 > 0) {
                    bArr = Arrays.copyOf(bArr, i6);
                    f0.o(bArr, "copyOf(this, newSize)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        f fVar = new f(8193);
                        fVar.write(read2);
                        kotlin.io.a.l(fileInputStream, fVar, 0, 2, null);
                        int size = fVar.size() + i4;
                        if (size >= 0) {
                            byte[] b4 = fVar.b();
                            byte[] copyOf = Arrays.copyOf(bArr, size);
                            f0.o(copyOf, "copyOf(this, newSize)");
                            bArr = kotlin.collections.o.W0(b4, copyOf, i4, 0, fVar.size());
                        } else {
                            throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                        }
                    }
                }
                b.a(fileInputStream, null);
                return bArr;
            }
            throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    @NotNull
    public static final List<String> w(@NotNull File file, @NotNull Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        ArrayList arrayList = new ArrayList();
        p(file, charset, new a(arrayList));
        return arrayList;
    }

    public static /* synthetic */ List x(File file, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        return w(file, charset);
    }

    @NotNull
    public static final String y(@NotNull File file, @NotNull Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String k4 = r.k(inputStreamReader);
            b.a(inputStreamReader, null);
            return k4;
        } finally {
        }
    }

    public static /* synthetic */ String z(File file, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        return y(file, charset);
    }
}
