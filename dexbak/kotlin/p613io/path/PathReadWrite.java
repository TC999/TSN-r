package kotlin.p613io.path;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.C2573a;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.ccg.CcgConstant;
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
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.C14307b;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.p613io.C14333t;
import kotlin.p613io.Closeable;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\b\u001a2\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001a<\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a2\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a<\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0015\u001a\u00020\u0014*\u00020\u0000H\u0087\b\u001a0\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00142\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0015\u0010\u001a\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0014H\u0087\b\u001a\u0016\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a9\u0010\u001f\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a=\u0010'\u001a\u00020\u0017*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00170\"H\u0087\bø\u0001\u0000\u001a(\u0010)\u001a\u00020(*\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b)\u0010*\u001a(\u0010,\u001a\u00020+*\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b,\u0010-\u001a\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001b0.*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001aA\u00103\u001a\u00028\u0000\"\u0004\b\u0000\u00100*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b01\u0012\u0004\u0012\u00028\u00000\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a@\u00107\u001a\u00020\u0000*\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d052\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b7\u00108\u001a@\u00109\u001a\u00020\u0000*\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0087\b¢\u0006\u0004\b9\u0010:\u001a%\u0010;\u001a\u00020\u0000*\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d052\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a%\u0010<\u001a\u00020\u0000*\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d012\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006="}, m12616d2 = {"Ljava/nio/file/Path;", "Ljava/nio/charset/Charset;", "charset", "", "Ljava/nio/file/OpenOption;", "options", "Ljava/io/InputStreamReader;", "u", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "", "bufferSize", "Ljava/io/BufferedReader;", "h", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "Ljava/io/OutputStreamWriter;", "F", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "Ljava/io/BufferedWriter;", "j", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "", "p", "array", "Lkotlin/f1;", "y", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "a", "", "s", "", C2573a.f8443b, "D", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "f", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", CcgConstant.f38549t, C7304t.f25048d, "Ljava/io/InputStream;", "n", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "o", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "", CampaignEx.JSON_KEY_AD_Q, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "block", IAdInterListener.AdReqParam.WIDTH, "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Ll1/l;)Ljava/lang/Object;", "", "lines", UMCommonContent.f37777aG, "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/nio/file/Path;Lkotlin/sequences/m;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "b", "c", "kotlin-stdlib-jdk7"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/io/path/PathsKt")
/* renamed from: kotlin.io.path.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class PathReadWrite {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: A */
    private static final Path m8361A(Path path, Sequence<? extends CharSequence> sequence, Charset charset, OpenOption... openOptionArr) throws IOException {
        Iterable m7252G;
        m7252G = _Sequences.m7252G(sequence);
        Path write = Files.write(path, m7252G, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C14342f0.m8185o(write, "Files.write(this, lines.…ble(), charset, *options)");
        return write;
    }

    /* renamed from: B */
    static /* synthetic */ Path m8360B(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        Path write = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C14342f0.m8185o(write, "Files.write(this, lines, charset, *options)");
        return write;
    }

    /* renamed from: C */
    static /* synthetic */ Path m8359C(Path path, Sequence sequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        Iterable m7252G;
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        m7252G = _Sequences.m7252G(sequence);
        Path write = Files.write(path, m7252G, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C14342f0.m8185o(write, "Files.write(this, lines.…ble(), charset, *options)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: D */
    public static final void m8358D(@NotNull Path writeText, @NotNull CharSequence text, @NotNull Charset charset, @NotNull OpenOption... options) throws IOException {
        C14342f0.m8184p(writeText, "$this$writeText");
        C14342f0.m8184p(text, "text");
        C14342f0.m8184p(charset, "charset");
        C14342f0.m8184p(options, "options");
        OutputStream newOutputStream = Files.newOutputStream(writeText, (OpenOption[]) Arrays.copyOf(options, options.length));
        C14342f0.m8185o(newOutputStream, "Files.newOutputStream(this, *options)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            Closeable.m8492a(outputStreamWriter, null);
        } finally {
        }
    }

    /* renamed from: E */
    public static /* synthetic */ void m8357E(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        m8358D(path, charSequence, charset, openOptionArr);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: F */
    private static final OutputStreamWriter m8356F(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    /* renamed from: G */
    static /* synthetic */ OutputStreamWriter m8355G(Path path, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: a */
    private static final void m8354a(Path path, byte[] bArr) throws IOException {
        Files.write(path, bArr, StandardOpenOption.APPEND);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: b */
    private static final Path m8353b(Path path, Iterable<? extends CharSequence> iterable, Charset charset) throws IOException {
        Path write = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        C14342f0.m8185o(write, "Files.write(this, lines,…tandardOpenOption.APPEND)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: c */
    private static final Path m8352c(Path path, Sequence<? extends CharSequence> sequence, Charset charset) throws IOException {
        Iterable m7252G;
        m7252G = _Sequences.m7252G(sequence);
        Path write = Files.write(path, m7252G, charset, StandardOpenOption.APPEND);
        C14342f0.m8185o(write, "Files.write(this, lines.…tandardOpenOption.APPEND)");
        return write;
    }

    /* renamed from: d */
    static /* synthetic */ Path m8351d(Path path, Iterable iterable, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        Path write = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        C14342f0.m8185o(write, "Files.write(this, lines,…tandardOpenOption.APPEND)");
        return write;
    }

    /* renamed from: e */
    static /* synthetic */ Path m8350e(Path path, Sequence sequence, Charset charset, int i, Object obj) throws IOException {
        Iterable m7252G;
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        m7252G = _Sequences.m7252G(sequence);
        Path write = Files.write(path, m7252G, charset, StandardOpenOption.APPEND);
        C14342f0.m8185o(write, "Files.write(this, lines.…tandardOpenOption.APPEND)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: f */
    public static final void m8349f(@NotNull Path appendText, @NotNull CharSequence text, @NotNull Charset charset) throws IOException {
        C14342f0.m8184p(appendText, "$this$appendText");
        C14342f0.m8184p(text, "text");
        C14342f0.m8184p(charset, "charset");
        OutputStream newOutputStream = Files.newOutputStream(appendText, StandardOpenOption.APPEND);
        C14342f0.m8185o(newOutputStream, "Files.newOutputStream(th…tandardOpenOption.APPEND)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            Closeable.m8492a(outputStreamWriter, null);
        } finally {
        }
    }

    /* renamed from: g */
    public static /* synthetic */ void m8348g(Path path, CharSequence charSequence, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        m8349f(path, charSequence, charset);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: h */
    private static final BufferedReader m8347h(Path path, Charset charset, int i, OpenOption... openOptionArr) throws IOException {
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    /* renamed from: i */
    static /* synthetic */ BufferedReader m8346i(Path path, Charset charset, int i, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.f41591a;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: j */
    private static final BufferedWriter m8345j(Path path, Charset charset, int i, OpenOption... openOptionArr) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    /* renamed from: k */
    static /* synthetic */ BufferedWriter m8344k(Path path, Charset charset, int i, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.f41591a;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: l */
    private static final void m8343l(Path path, Charset charset, InterfaceC15280l<? super String, Unit> interfaceC15280l) throws IOException {
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        C14342f0.m8185o(newBufferedReader, "Files.newBufferedReader(this, charset)");
        if (!(newBufferedReader instanceof BufferedReader)) {
            newBufferedReader = new BufferedReader(newBufferedReader, 8192);
        }
        try {
            for (String str : C14333t.m8243h(newBufferedReader)) {
                interfaceC15280l.invoke(str);
            }
            Unit unit = Unit.f41048a;
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(newBufferedReader, null);
            } else {
                newBufferedReader.close();
            }
            InlineMarker.m8229c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(newBufferedReader, th);
                } else {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    /* renamed from: m */
    static /* synthetic */ void m8342m(Path path, Charset charset, InterfaceC15280l interfaceC15280l, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        C14342f0.m8185o(newBufferedReader, "Files.newBufferedReader(this, charset)");
        if (!(newBufferedReader instanceof BufferedReader)) {
            newBufferedReader = new BufferedReader(newBufferedReader, 8192);
        }
        try {
            for (String str : C14333t.m8243h(newBufferedReader)) {
                interfaceC15280l.invoke(str);
            }
            Unit unit = Unit.f41048a;
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(newBufferedReader, null);
            } else {
                newBufferedReader.close();
            }
            InlineMarker.m8229c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(newBufferedReader, th);
                } else {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: n */
    private static final InputStream m8341n(Path path, OpenOption... openOptionArr) throws IOException {
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C14342f0.m8185o(newInputStream, "Files.newInputStream(this, *options)");
        return newInputStream;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: o */
    private static final OutputStream m8340o(Path path, OpenOption... openOptionArr) throws IOException {
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C14342f0.m8185o(newOutputStream, "Files.newOutputStream(this, *options)");
        return newOutputStream;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: p */
    private static final byte[] m8339p(Path path) throws IOException {
        byte[] readAllBytes = Files.readAllBytes(path);
        C14342f0.m8185o(readAllBytes, "Files.readAllBytes(this)");
        return readAllBytes;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: q */
    private static final List<String> m8338q(Path path, Charset charset) throws IOException {
        List<String> readAllLines = Files.readAllLines(path, charset);
        C14342f0.m8185o(readAllLines, "Files.readAllLines(this, charset)");
        return readAllLines;
    }

    /* renamed from: r */
    static /* synthetic */ List m8337r(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        List<String> readAllLines = Files.readAllLines(path, charset);
        C14342f0.m8185o(readAllLines, "Files.readAllLines(this, charset)");
        return readAllLines;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    /* renamed from: s */
    public static final String m8336s(@NotNull Path readText, @NotNull Charset charset) throws IOException {
        C14342f0.m8184p(readText, "$this$readText");
        C14342f0.m8184p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(readText, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String m8240k = C14333t.m8240k(inputStreamReader);
            Closeable.m8492a(inputStreamReader, null);
            return m8240k;
        } finally {
        }
    }

    /* renamed from: t */
    public static /* synthetic */ String m8335t(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return m8336s(path, charset);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: u */
    private static final InputStreamReader m8334u(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    /* renamed from: v */
    static /* synthetic */ InputStreamReader m8333v(Path path, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: w */
    private static final <T> T m8332w(Path path, Charset charset, InterfaceC15280l<? super Sequence<String>, ? extends T> interfaceC15280l) throws IOException {
        BufferedReader it = Files.newBufferedReader(path, charset);
        try {
            C14342f0.m8185o(it, "it");
            T invoke = interfaceC15280l.invoke(C14333t.m8243h(it));
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(it, null);
            } else if (it != null) {
                it.close();
            }
            InlineMarker.m8229c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    /* renamed from: x */
    static /* synthetic */ Object m8331x(Path path, Charset charset, InterfaceC15280l interfaceC15280l, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        BufferedReader it = Files.newBufferedReader(path, charset);
        try {
            C14342f0.m8185o(it, "it");
            Object invoke = interfaceC15280l.invoke(C14333t.m8243h(it));
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(it, null);
            } else if (it != null) {
                it.close();
            }
            InlineMarker.m8229c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(it, th);
                } else if (it != null) {
                    try {
                        it.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    /* renamed from: y */
    private static final void m8330y(Path path, byte[] bArr, OpenOption... openOptionArr) throws IOException {
        Files.write(path, bArr, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: z */
    private static final Path m8329z(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) throws IOException {
        Path write = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C14342f0.m8185o(write, "Files.write(this, lines, charset, *options)");
        return write;
    }
}
