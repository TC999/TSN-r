package kotlin.p613io;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.C2573a;
import com.kuaishou.weapon.p205p0.C7304t;
import com.umeng.analytics.pro.CoreProtocolImpl;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.ccg.CcgConstant;
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
import kotlin.Unit;
import kotlin.collections._ArraysJvm;
import kotlin.internal.C14307b;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges._Ranges;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileReadWrite.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a!\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u0017\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a!\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u0017\u0010\u000e\u001a\u00020\r*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\n\u0010\u0010\u001a\u00020\u000f*\u00020\u0000\u001a\u0012\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000f\u001a\u0012\u0010\u0014\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000f\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u001c\u0010\u0018\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u001c\u0010\u0019\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001aB\u0010 \u001a\u00020\u0012*\u00020\u000026\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00120\u001a\u001aJ\u0010\"\u001a\u00020\u0012*\u00020\u00002\u0006\u0010!\u001a\u00020\u000526\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00120\u001a\u001a7\u0010%\u001a\u00020\u0012*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00120#\u001a\r\u0010'\u001a\u00020&*\u00020\u0000H\u0087\b\u001a\r\u0010)\u001a\u00020(*\u00020\u0000H\u0087\b\u001a\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150**\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001aD\u00100\u001a\u00028\u0000\"\u0004\b\u0000\u0010,*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0018\u0010.\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150-\u0012\u0004\u0012\u00028\u00000#H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0082\u0002\u000f\n\u0006\b\u0011(/0\u0001\n\u0005\b\u009920\u0001¨\u00062"}, m12616d2 = {"Ljava/io/File;", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/InputStreamReader;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "bufferSize", "Ljava/io/BufferedReader;", "j", "Ljava/io/OutputStreamWriter;", "H", "Ljava/io/BufferedWriter;", C7304t.f25048d, "Ljava/io/PrintWriter;", UMCommonContent.f37782aL, "", "v", "array", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "g", "", "y", C2573a.f8443b, "F", "h", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", CcgConstant.f38549t, "o", "blockSize", "n", "Lkotlin/Function1;", "line", "p", "Ljava/io/FileInputStream;", "r", "Ljava/io/FileOutputStream;", "s", "", IAdInterListener.AdReqParam.WIDTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "block", "Requires newer compiler version to be inlined correctly.", "C", "(Ljava/io/File;Ljava/nio/charset/Charset;Ll1/l;)Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/io/FilesKt")
/* renamed from: kotlin.io.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14321l extends C14320k {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileReadWrite.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"", "it", "Lkotlin/f1;", "a", "(Ljava/lang/String;)V"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14322a extends Lambda implements InterfaceC15280l<String, Unit> {

        /* renamed from: a */
        final /* synthetic */ ArrayList f41093a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14322a(ArrayList arrayList) {
            super(1);
            this.f41093a = arrayList;
        }

        /* renamed from: a */
        public final void m8406a(@NotNull String it) {
            C14342f0.m8184p(it, "it");
            this.f41093a.add(it);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            m8406a(str);
            return Unit.f41048a;
        }
    }

    @InlineOnly
    /* renamed from: A */
    private static final InputStreamReader m8435A(File file, Charset charset) {
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    /* renamed from: B */
    static /* synthetic */ InputStreamReader m8434B(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    /* renamed from: C */
    public static final <T> T m8433C(@NotNull File useLines, @NotNull Charset charset, @NotNull InterfaceC15280l<? super Sequence<String>, ? extends T> block) {
        C14342f0.m8184p(useLines, "$this$useLines");
        C14342f0.m8184p(charset, "charset");
        C14342f0.m8184p(block, "block");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(useLines), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            T invoke = block.invoke(C14333t.m8243h(bufferedReader));
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            InlineMarker.m8229c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    /* renamed from: D */
    public static /* synthetic */ Object m8432D(File useLines, Charset charset, InterfaceC15280l block, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        C14342f0.m8184p(useLines, "$this$useLines");
        C14342f0.m8184p(charset, "charset");
        C14342f0.m8184p(block, "block");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(useLines), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            Object invoke = block.invoke(C14333t.m8243h(bufferedReader));
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            InlineMarker.m8229c(1);
            return invoke;
        } finally {
        }
    }

    /* renamed from: E */
    public static final void m8431E(@NotNull File writeBytes, @NotNull byte[] array) {
        C14342f0.m8184p(writeBytes, "$this$writeBytes");
        C14342f0.m8184p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(writeBytes);
        try {
            fileOutputStream.write(array);
            Unit unit = Unit.f41048a;
            Closeable.m8492a(fileOutputStream, null);
        } finally {
        }
    }

    /* renamed from: F */
    public static final void m8430F(@NotNull File writeText, @NotNull String text, @NotNull Charset charset) {
        C14342f0.m8184p(writeText, "$this$writeText");
        C14342f0.m8184p(text, "text");
        C14342f0.m8184p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
        m8431E(writeText, bytes);
    }

    /* renamed from: G */
    public static /* synthetic */ void m8429G(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        m8430F(file, str, charset);
    }

    @InlineOnly
    /* renamed from: H */
    private static final OutputStreamWriter m8428H(File file, Charset charset) {
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    /* renamed from: I */
    static /* synthetic */ OutputStreamWriter m8427I(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    /* renamed from: g */
    public static final void m8426g(@NotNull File appendBytes, @NotNull byte[] array) {
        C14342f0.m8184p(appendBytes, "$this$appendBytes");
        C14342f0.m8184p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(appendBytes, true);
        try {
            fileOutputStream.write(array);
            Unit unit = Unit.f41048a;
            Closeable.m8492a(fileOutputStream, null);
        } finally {
        }
    }

    /* renamed from: h */
    public static final void m8425h(@NotNull File appendText, @NotNull String text, @NotNull Charset charset) {
        C14342f0.m8184p(appendText, "$this$appendText");
        C14342f0.m8184p(text, "text");
        C14342f0.m8184p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
        m8426g(appendText, bytes);
    }

    /* renamed from: i */
    public static /* synthetic */ void m8424i(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        m8425h(file, str, charset);
    }

    @InlineOnly
    /* renamed from: j */
    private static final BufferedReader m8423j(File file, Charset charset, int i) {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i);
    }

    /* renamed from: k */
    static /* synthetic */ BufferedReader m8422k(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f41591a;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i);
    }

    @InlineOnly
    /* renamed from: l */
    private static final BufferedWriter m8421l(File file, Charset charset, int i) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i);
    }

    /* renamed from: m */
    static /* synthetic */ BufferedWriter m8420m(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f41591a;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, byte[]] */
    /* renamed from: n */
    public static final void m8419n(@NotNull File forEachBlock, int i, @NotNull InterfaceC15284p<? super byte[], ? super Integer, Unit> action) {
        int m7481n;
        C14342f0.m8184p(forEachBlock, "$this$forEachBlock");
        C14342f0.m8184p(action, "action");
        m7481n = _Ranges.m7481n(i, 512);
        ?? r2 = new byte[m7481n];
        FileInputStream fileInputStream = new FileInputStream(forEachBlock);
        while (true) {
            try {
                int read = fileInputStream.read(r2);
                if (read <= 0) {
                    Unit unit = Unit.f41048a;
                    Closeable.m8492a(fileInputStream, null);
                    return;
                }
                action.invoke(r2, Integer.valueOf(read));
            } finally {
            }
        }
    }

    /* renamed from: o */
    public static final void m8418o(@NotNull File forEachBlock, @NotNull InterfaceC15284p<? super byte[], ? super Integer, Unit> action) {
        C14342f0.m8184p(forEachBlock, "$this$forEachBlock");
        C14342f0.m8184p(action, "action");
        m8419n(forEachBlock, 4096, action);
    }

    /* renamed from: p */
    public static final void m8417p(@NotNull File forEachLine, @NotNull Charset charset, @NotNull InterfaceC15280l<? super String, Unit> action) {
        C14342f0.m8184p(forEachLine, "$this$forEachLine");
        C14342f0.m8184p(charset, "charset");
        C14342f0.m8184p(action, "action");
        C14333t.m8244g(new BufferedReader(new InputStreamReader(new FileInputStream(forEachLine), charset)), action);
    }

    /* renamed from: q */
    public static /* synthetic */ void m8416q(File file, Charset charset, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        m8417p(file, charset, interfaceC15280l);
    }

    @InlineOnly
    /* renamed from: r */
    private static final FileInputStream m8415r(File file) {
        return new FileInputStream(file);
    }

    @InlineOnly
    /* renamed from: s */
    private static final FileOutputStream m8414s(File file) {
        return new FileOutputStream(file);
    }

    @InlineOnly
    /* renamed from: t */
    private static final PrintWriter m8413t(File file, Charset charset) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    /* renamed from: u */
    static /* synthetic */ PrintWriter m8412u(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    @NotNull
    /* renamed from: v */
    public static final byte[] m8411v(@NotNull File readBytes) {
        C14342f0.m8184p(readBytes, "$this$readBytes");
        FileInputStream fileInputStream = new FileInputStream(readBytes);
        try {
            long length = readBytes.length();
            if (length <= Integer.MAX_VALUE) {
                int i = (int) length;
                byte[] bArr = new byte[i];
                int i2 = i;
                int i3 = 0;
                while (i2 > 0) {
                    int read = fileInputStream.read(bArr, i3, i2);
                    if (read < 0) {
                        break;
                    }
                    i2 -= read;
                    i3 += read;
                }
                if (i2 > 0) {
                    bArr = Arrays.copyOf(bArr, i3);
                    C14342f0.m8185o(bArr, "java.util.Arrays.copyOf(this, newSize)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        FileReadWrite fileReadWrite = new FileReadWrite(CoreProtocolImpl.C13167a.f38416r);
                        fileReadWrite.write(read2);
                        IOStreams.m8510l(fileInputStream, fileReadWrite, 0, 2, null);
                        int size = fileReadWrite.size() + i;
                        if (size >= 0) {
                            byte[] m8466a = fileReadWrite.m8466a();
                            byte[] copyOf = Arrays.copyOf(bArr, size);
                            C14342f0.m8185o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                            bArr = _ArraysJvm.m11655W0(m8466a, copyOf, i, 0, fileReadWrite.size());
                        } else {
                            throw new OutOfMemoryError("File " + readBytes + " is too big to fit in memory.");
                        }
                    }
                }
                Closeable.m8492a(fileInputStream, null);
                return bArr;
            }
            throw new OutOfMemoryError("File " + readBytes + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                Closeable.m8492a(fileInputStream, th);
                throw th2;
            }
        }
    }

    @NotNull
    /* renamed from: w */
    public static final List<String> m8410w(@NotNull File readLines, @NotNull Charset charset) {
        C14342f0.m8184p(readLines, "$this$readLines");
        C14342f0.m8184p(charset, "charset");
        ArrayList arrayList = new ArrayList();
        m8417p(readLines, charset, new C14322a(arrayList));
        return arrayList;
    }

    /* renamed from: x */
    public static /* synthetic */ List m8409x(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return m8410w(file, charset);
    }

    @NotNull
    /* renamed from: y */
    public static final String m8408y(@NotNull File readText, @NotNull Charset charset) {
        C14342f0.m8184p(readText, "$this$readText");
        C14342f0.m8184p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(readText), charset);
        try {
            String m8240k = C14333t.m8240k(inputStreamReader);
            Closeable.m8492a(inputStreamReader, null);
            return m8240k;
        } finally {
        }
    }

    /* renamed from: z */
    public static /* synthetic */ String m8407z(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return m8408y(file, charset);
    }
}
