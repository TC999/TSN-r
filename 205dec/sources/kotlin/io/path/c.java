package kotlin.io.path;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.l;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.io.r;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.m;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PathReadWrite.kt */
@Metadata(bv = {}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\b\u001a2\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b\u0007\u0010\b\u001a<\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b\f\u0010\r\u001a2\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a<\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0015\u001a\u00020\u0014*\u00020\u0000H\u0087\b\u001a0\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00142\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a\u0015\u0010\u001a\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0014H\u0087\b\u001a\u0016\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a9\u0010\u001f\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a=\u0010'\u001a\u00020\u0017*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00170\"H\u0087\b\u00f8\u0001\u0000\u001a(\u0010)\u001a\u00020(*\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b)\u0010*\u001a(\u0010,\u001a\u00020+*\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b,\u0010-\u001a\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001b0.*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001aA\u00103\u001a\u00028\u0000\"\u0004\b\u0000\u00100*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b01\u0012\u0004\u0012\u00028\u00000\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00104\u001a@\u00107\u001a\u00020\u0000*\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d052\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b7\u00108\u001a@\u00109\u001a\u00020\u0000*\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b\u00a2\u0006\u0004\b9\u0010:\u001a%\u0010;\u001a\u00020\u0000*\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d052\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a%\u0010<\u001a\u00020\u0000*\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d012\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006="}, d2 = {"Ljava/nio/file/Path;", "Ljava/nio/charset/Charset;", "charset", "", "Ljava/nio/file/OpenOption;", "options", "Ljava/io/InputStreamReader;", "u", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "", "bufferSize", "Ljava/io/BufferedReader;", "h", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "Ljava/io/OutputStreamWriter;", "F", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "Ljava/io/BufferedWriter;", "j", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "", "p", "array", "Lkotlin/f1;", "y", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "a", "", "s", "", "text", "D", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "f", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "action", "l", "Ljava/io/InputStream;", "n", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "o", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "", CampaignEx.JSON_KEY_AD_Q, "T", "Lkotlin/sequences/m;", "block", "w", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Ld2/l;)Ljava/lang/Object;", "", "lines", "z", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "A", "(Ljava/nio/file/Path;Lkotlin/sequences/m;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "b", "c", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 5, 1}, xs = "kotlin/io/path/PathsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class c {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path A(Path path, m<? extends CharSequence> mVar, Charset charset, OpenOption... openOptionArr) throws IOException {
        Iterable G;
        G = SequencesKt___SequencesKt.G(mVar);
        Path write = Files.write(path, G, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        f0.o(write, "Files.write(this, lines.\u2026ble(), charset, *options)");
        return write;
    }

    static /* synthetic */ Path B(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArr, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        Path write = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        f0.o(write, "Files.write(this, lines, charset, *options)");
        return write;
    }

    static /* synthetic */ Path C(Path path, m mVar, Charset charset, OpenOption[] openOptionArr, int i4, Object obj) throws IOException {
        Iterable G;
        if ((i4 & 2) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        G = SequencesKt___SequencesKt.G(mVar);
        Path write = Files.write(path, G, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        f0.o(write, "Files.write(this, lines.\u2026ble(), charset, *options)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void D(@NotNull Path writeText, @NotNull CharSequence text, @NotNull Charset charset, @NotNull OpenOption... options) throws IOException {
        f0.p(writeText, "$this$writeText");
        f0.p(text, "text");
        f0.p(charset, "charset");
        f0.p(options, "options");
        OutputStream newOutputStream = Files.newOutputStream(writeText, (OpenOption[]) Arrays.copyOf(options, options.length));
        f0.o(newOutputStream, "Files.newOutputStream(this, *options)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.b.a(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void E(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        D(path, charSequence, charset, openOptionArr);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final OutputStreamWriter F(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ OutputStreamWriter G(Path path, Charset charset, OpenOption[] openOptionArr, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void a(Path path, byte[] bArr) throws IOException {
        Files.write(path, bArr, StandardOpenOption.APPEND);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path b(Path path, Iterable<? extends CharSequence> iterable, Charset charset) throws IOException {
        Path write = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        f0.o(write, "Files.write(this, lines,\u2026tandardOpenOption.APPEND)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path c(Path path, m<? extends CharSequence> mVar, Charset charset) throws IOException {
        Iterable G;
        G = SequencesKt___SequencesKt.G(mVar);
        Path write = Files.write(path, G, charset, StandardOpenOption.APPEND);
        f0.o(write, "Files.write(this, lines.\u2026tandardOpenOption.APPEND)");
        return write;
    }

    static /* synthetic */ Path d(Path path, Iterable iterable, Charset charset, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        Path write = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        f0.o(write, "Files.write(this, lines,\u2026tandardOpenOption.APPEND)");
        return write;
    }

    static /* synthetic */ Path e(Path path, m mVar, Charset charset, int i4, Object obj) throws IOException {
        Iterable G;
        if ((i4 & 2) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        G = SequencesKt___SequencesKt.G(mVar);
        Path write = Files.write(path, G, charset, StandardOpenOption.APPEND);
        f0.o(write, "Files.write(this, lines.\u2026tandardOpenOption.APPEND)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void f(@NotNull Path appendText, @NotNull CharSequence text, @NotNull Charset charset) throws IOException {
        f0.p(appendText, "$this$appendText");
        f0.p(text, "text");
        f0.p(charset, "charset");
        OutputStream newOutputStream = Files.newOutputStream(appendText, StandardOpenOption.APPEND);
        f0.o(newOutputStream, "Files.newOutputStream(th\u2026tandardOpenOption.APPEND)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.b.a(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void g(Path path, CharSequence charSequence, Charset charset, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f(path, charSequence, charset);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final BufferedReader h(Path path, Charset charset, int i4, OpenOption... openOptionArr) throws IOException {
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i4);
    }

    static /* synthetic */ BufferedReader i(Path path, Charset charset, int i4, OpenOption[] openOptionArr, int i5, Object obj) throws IOException {
        if ((i5 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        if ((i5 & 2) != 0) {
            i4 = 8192;
        }
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final BufferedWriter j(Path path, Charset charset, int i4, OpenOption... openOptionArr) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i4);
    }

    static /* synthetic */ BufferedWriter k(Path path, Charset charset, int i4, OpenOption[] openOptionArr, int i5, Object obj) throws IOException {
        if ((i5 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        if ((i5 & 2) != 0) {
            i4 = 8192;
        }
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i4);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void l(Path path, Charset charset, l<? super String, f1> lVar) throws IOException {
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        f0.o(newBufferedReader, "Files.newBufferedReader(this, charset)");
        if (!(newBufferedReader instanceof BufferedReader)) {
            newBufferedReader = new BufferedReader(newBufferedReader, 8192);
        }
        try {
            for (String str : r.h(newBufferedReader)) {
                lVar.invoke(str);
            }
            f1 f1Var = f1.f55527a;
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                kotlin.io.b.a(newBufferedReader, null);
            } else {
                newBufferedReader.close();
            }
            c0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    kotlin.io.b.a(newBufferedReader, th);
                } else {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    static /* synthetic */ void m(Path path, Charset charset, l lVar, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        f0.o(newBufferedReader, "Files.newBufferedReader(this, charset)");
        if (!(newBufferedReader instanceof BufferedReader)) {
            newBufferedReader = new BufferedReader(newBufferedReader, 8192);
        }
        try {
            for (String str : r.h(newBufferedReader)) {
                lVar.invoke(str);
            }
            f1 f1Var = f1.f55527a;
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                kotlin.io.b.a(newBufferedReader, null);
            } else {
                newBufferedReader.close();
            }
            c0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    kotlin.io.b.a(newBufferedReader, th);
                } else {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final InputStream n(Path path, OpenOption... openOptionArr) throws IOException {
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        f0.o(newInputStream, "Files.newInputStream(this, *options)");
        return newInputStream;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final OutputStream o(Path path, OpenOption... openOptionArr) throws IOException {
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        f0.o(newOutputStream, "Files.newOutputStream(this, *options)");
        return newOutputStream;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final byte[] p(Path path) throws IOException {
        byte[] readAllBytes = Files.readAllBytes(path);
        f0.o(readAllBytes, "Files.readAllBytes(this)");
        return readAllBytes;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final List<String> q(Path path, Charset charset) throws IOException {
        List<String> readAllLines = Files.readAllLines(path, charset);
        f0.o(readAllLines, "Files.readAllLines(this, charset)");
        return readAllLines;
    }

    static /* synthetic */ List r(Path path, Charset charset, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        List<String> readAllLines = Files.readAllLines(path, charset);
        f0.o(readAllLines, "Files.readAllLines(this, charset)");
        return readAllLines;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final String s(@NotNull Path readText, @NotNull Charset charset) throws IOException {
        f0.p(readText, "$this$readText");
        f0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(readText, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String k4 = r.k(inputStreamReader);
            kotlin.io.b.a(inputStreamReader, null);
            return k4;
        } finally {
        }
    }

    public static /* synthetic */ String t(Path path, Charset charset, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        return s(path, charset);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final InputStreamReader u(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ InputStreamReader v(Path path, Charset charset, OpenOption[] openOptionArr, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final <T> T w(Path path, Charset charset, l<? super m<String>, ? extends T> lVar) throws IOException {
        BufferedReader it = Files.newBufferedReader(path, charset);
        try {
            f0.o(it, "it");
            T invoke = lVar.invoke(r.h(it));
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                kotlin.io.b.a(it, null);
            } else if (it != null) {
                it.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    kotlin.io.b.a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    static /* synthetic */ Object x(Path path, Charset charset, l lVar, int i4, Object obj) throws IOException {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        BufferedReader it = Files.newBufferedReader(path, charset);
        try {
            f0.o(it, "it");
            Object invoke = lVar.invoke(r.h(it));
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                kotlin.io.b.a(it, null);
            } else if (it != null) {
                it.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    kotlin.io.b.a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void y(Path path, byte[] bArr, OpenOption... openOptionArr) throws IOException {
        Files.write(path, bArr, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path z(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) throws IOException {
        Path write = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        f0.o(write, "Files.write(this, lines, charset, *options)");
        return write;
    }
}
