package okhttp3.internal;

import d2.a;
import d2.l;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.p;
import kotlin.collections.r0;
import kotlin.collections.y;
import kotlin.collections.z0;
import kotlin.f1;
import kotlin.io.b;
import kotlin.j;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t0;
import kotlin.ranges.k;
import kotlin.ranges.o;
import kotlin.text.Regex;
import kotlin.text.d;
import kotlin.text.x;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Util.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00b4\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u001a;\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0012\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0016\u001a\u00020\u0006*\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\b\u001a-\u0010\u0019\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0017\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001f\u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\u001e\u0010 \u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\u001e\u0010!\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a&\u0010#\u001a\u00020\u0018*\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a&\u0010#\u001a\u00020\u0018*\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\n\u0010&\u001a\u00020\u0018*\u00020\u0006\u001a\n\u0010'\u001a\u00020\b*\u00020\u0006\u001a)\u0010(\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0\f\"\u00020)\u00a2\u0006\u0004\b(\u0010+\u001a\u0012\u0010/\u001a\u00020-*\u00020,2\u0006\u0010.\u001a\u00020-\u001a \u00103\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u000101\u001a\n\u00104\u001a\u00020\u0018*\u00020$\u001a\u0010\u00108\u001a\u000207*\b\u0012\u0004\u0012\u00020605\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020605*\u000207\u001a\u0012\u0010:\u001a\u00020\b*\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014\u001a\n\u0010=\u001a\u00020<*\u00020;\u001a\u0015\u0010@\u001a\u00020\u0018*\u00020>2\u0006\u0010?\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0018*\u00020A2\u0006\u0010?\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0000*\u00020\u00182\u0006\u0010?\u001a\u00020\u0000H\u0086\u0004\u001a\u0012\u0010D\u001a\u00020\u0004*\u00020B2\u0006\u0010C\u001a\u00020\u0018\u001a\n\u0010E\u001a\u00020\u0018*\u00020,\u001a\u001a\u0010H\u001a\u00020\b*\u00020F2\u0006\u00100\u001a\u00020\u00182\u0006\u0010G\u001a\u000201\u001a\u001a\u0010J\u001a\u00020\b*\u00020F2\u0006\u0010I\u001a\u00020\u00182\u0006\u0010G\u001a\u000201\u001a\n\u0010L\u001a\u00020\u0006*\u00020K\u001a\u0012\u0010N\u001a\u00020\b*\u00020K2\u0006\u0010M\u001a\u00020,\u001a\u001a\u0010Q\u001a\u00020\u00042\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040OH\u0086\b\u00f8\u0001\u0000\u001a\"\u0010R\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040OH\u0086\b\u00f8\u0001\u0000\u001a\u0012\u0010H\u001a\u00020\u0018*\u00020S2\u0006\u0010T\u001a\u00020>\u001a\u0014\u0010U\u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u001a\n\u0010W\u001a\u00020\u0000*\u00020V\u001a\u0012\u0010Y\u001a\u00020\u0000*\u00020\u00062\u0006\u0010X\u001a\u00020\u0000\u001a\u0014\u0010Z\u001a\u00020\u0018*\u0004\u0018\u00010\u00062\u0006\u0010X\u001a\u00020\u0018\u001a\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u000005\"\u0004\b\u0000\u0010[*\b\u0012\u0004\u0012\u00028\u000005\u001a/\u0010^\u001a\b\u0012\u0004\u0012\u00028\u000005\"\u0004\b\u0000\u0010[2\u0012\u0010]\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f\"\u00028\u0000H\u0007\u00a2\u0006\u0004\b^\u0010_\u001a.\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010b\"\u0004\b\u0000\u0010`\"\u0004\b\u0001\u0010a*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010b\u001a\n\u0010e\u001a\u00020\u0004*\u00020d\u001a\n\u0010e\u001a\u00020\u0004*\u00020K\u001a\n\u0010e\u001a\u00020\u0004*\u00020f\u001a\u0012\u0010j\u001a\u00020\b*\u00020g2\u0006\u0010i\u001a\u00020h\u001a\n\u0010k\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010k\u001a\u00020\u0006*\u00020\u0018\u001a\r\u0010l\u001a\u00020\u0004*\u00020)H\u0086\b\u001a\r\u0010m\u001a\u00020\u0004*\u00020)H\u0086\b\u001a\r\u0010n\u001a\u00020\u0004*\u00020)H\u0086\b\u001a3\u0010s\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010[2\u0006\u0010o\u001a\u00020)2\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000p2\u0006\u0010r\u001a\u00020\u0006\u00a2\u0006\u0004\bs\u0010t\u001a'\u0010x\u001a\u00020\u0004\"\u0004\b\u0000\u0010u*\b\u0012\u0004\u0012\u00028\u00000v2\u0006\u0010w\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\bx\u0010y\u001a\r\u0010z\u001a\u00020\u0004*\u00020)H\u0080\b\u001a\r\u0010{\u001a\u00020\u0004*\u00020)H\u0080\b\u001a!\u0010\u0080\u0001\u001a\u00020\u007f*\u00060|j\u0002`}2\u0010\u0010~\u001a\f\u0012\b\u0012\u00060|j\u0002`}05\u001a@\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00028\u000005\"\u0004\b\u0000\u0010[*\t\u0012\u0004\u0012\u00028\u00000\u0081\u00012\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0082\u0001\u00a2\u0006\u0003\b\u0083\u0001H\u0086\b\u00f8\u0001\u0000\"\u0018\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0017\u0010\u0089\u0001\u001a\u0002078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0018\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0018\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0018\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0017\u0010\u009a\u0001\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0017\u0010\u009c\u0001\u001a\u00020\u00068\u0000X\u0081\u0004\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0017\u0010\u009e\u0001\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009d\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u009f\u0001"}, d2 = {"", "arrayLength", "offset", "count", "Lkotlin/f1;", "checkOffsetAndCount", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "", "other", "Ljava/util/Comparator;", "comparator", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/HttpUrl;", "includeDefaultPort", "toHostHeader", "value", "", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "trimSubstring", "delimiters", "delimiterOffset", "", "delimiter", "indexOfControlOrNonAscii", "canParseAsIpAddress", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lokio/BufferedSource;", "Ljava/nio/charset/Charset;", "default", "readBomAsCharset", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "checkDuration", "parseHexDigit", "", "Lokhttp3/internal/http2/Header;", "Lokhttp3/Headers;", "toHeaders", "toHeaderList", "canReuseConnectionFor", "Lokhttp3/EventListener;", "Lokhttp3/EventListener$Factory;", "asFactory", "", "mask", "and", "", "Lokio/BufferedSink;", "medium", "writeMedium", "readMedium", "Lokio/Source;", "timeUnit", "skipAll", "timeout", "discard", "Ljava/net/Socket;", "peerName", "source", "isHealthy", "Lkotlin/Function0;", "block", "ignoreIoExceptions", "threadName", "Lokio/Buffer;", "b", "indexOfNonWhitespace", "Lokhttp3/Response;", "headersContentLength", "defaultValue", "toLongOrDefault", "toNonNegativeInt", "T", "toImmutableList", "elements", "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "K", "V", "", "toImmutableMap", "Ljava/io/Closeable;", "closeQuietly", "Ljava/net/ServerSocket;", "Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "file", "isCivilized", "toHexString", "wait", "notify", "notifyAll", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "readFieldOrNull", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "E", "", "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "assertThreadHoldsLock", "assertThreadDoesntHoldLock", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "withSuppressed", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "predicate", "filterList", "", "EMPTY_BYTE_ARRAY", "[B", "EMPTY_HEADERS", "Lokhttp3/Headers;", "Lokhttp3/ResponseBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "Lokhttp3/RequestBody;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "Lokio/Options;", "UNICODE_BOMS", "Lokio/Options;", "Ljava/util/TimeZone;", "UTC", "Ljava/util/TimeZone;", "Lkotlin/text/Regex;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "Z", "okHttpName", "Ljava/lang/String;", "userAgent", "okhttp"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Util")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Util {
    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY;
    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST;
    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    @JvmField
    @NotNull
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;
    @JvmField
    public static final boolean assertionsEnabled;
    @JvmField
    @NotNull
    public static final String okHttpName;
    @NotNull
    public static final String userAgent = "okhttp/4.9.0";

    static {
        String c4;
        String i4;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        f0.m(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        f0.o(name, "OkHttpClient::class.java.name");
        c4 = x.c4(name, "okhttp3.");
        i4 = x.i4(c4, "Client");
        okHttpName = i4;
    }

    public static final <E> void addIfAbsent(@NotNull List<E> addIfAbsent, E e4) {
        f0.p(addIfAbsent, "$this$addIfAbsent");
        if (addIfAbsent.contains(e4)) {
            return;
        }
        addIfAbsent.add(e4);
    }

    public static final int and(byte b4, int i4) {
        return b4 & i4;
    }

    public static final int and(short s3, int i4) {
        return s3 & i4;
    }

    public static final long and(int i4, long j4) {
        return j4 & i4;
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull final EventListener asFactory) {
        f0.p(asFactory, "$this$asFactory");
        return new EventListener.Factory() { // from class: okhttp3.internal.Util$asFactory$1
            @Override // okhttp3.EventListener.Factory
            @NotNull
            public final EventListener create(@NotNull Call it) {
                f0.p(it, "it");
                return EventListener.this;
            }
        };
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object assertThreadDoesntHoldLock) {
        f0.p(assertThreadDoesntHoldLock, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(assertThreadDoesntHoldLock)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            f0.o(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(assertThreadDoesntHoldLock);
            throw new AssertionError(sb.toString());
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object assertThreadHoldsLock) {
        f0.p(assertThreadHoldsLock, "$this$assertThreadHoldsLock");
        if (!assertionsEnabled || Thread.holdsLock(assertThreadHoldsLock)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        f0.o(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(assertThreadHoldsLock);
        throw new AssertionError(sb.toString());
    }

    public static final boolean canParseAsIpAddress(@NotNull String canParseAsIpAddress) {
        f0.p(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches(canParseAsIpAddress);
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl canReuseConnectionFor, @NotNull HttpUrl other) {
        f0.p(canReuseConnectionFor, "$this$canReuseConnectionFor");
        f0.p(other, "other");
        return f0.g(canReuseConnectionFor.host(), other.host()) && canReuseConnectionFor.port() == other.port() && f0.g(canReuseConnectionFor.scheme(), other.scheme());
    }

    public static final int checkDuration(@NotNull String name, long j4, @Nullable TimeUnit timeUnit) {
        f0.p(name, "name");
        boolean z3 = true;
        if (!(j4 >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j4);
            if (!(millis <= ((long) Integer.MAX_VALUE))) {
                throw new IllegalArgumentException((name + " too large.").toString());
            }
            if (millis == 0 && j4 > 0) {
                z3 = false;
            }
            if (z3) {
                return (int) millis;
            }
            throw new IllegalArgumentException((name + " too small.").toString());
        }
        throw new IllegalStateException("unit == null".toString());
    }

    public static final void checkOffsetAndCount(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(@NotNull Closeable closeQuietly) {
        f0.p(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e4) {
            throw e4;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final String[] concat(@NotNull String[] concat, @NotNull String value) {
        int Td;
        f0.p(concat, "$this$concat");
        f0.p(value, "value");
        Object[] copyOf = Arrays.copyOf(concat, concat.length + 1);
        f0.o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) copyOf;
        Td = p.Td(strArr);
        strArr[Td] = value;
        return strArr;
    }

    public static final int delimiterOffset(@NotNull String delimiterOffset, @NotNull String delimiters, int i4, int i5) {
        boolean U2;
        f0.p(delimiterOffset, "$this$delimiterOffset");
        f0.p(delimiters, "delimiters");
        while (i4 < i5) {
            U2 = x.U2(delimiters, delimiterOffset.charAt(i4), false, 2, null);
            if (U2) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = str.length();
        }
        return delimiterOffset(str, str2, i4, i5);
    }

    public static final boolean discard(@NotNull Source discard, int i4, @NotNull TimeUnit timeUnit) {
        f0.p(discard, "$this$discard");
        f0.p(timeUnit, "timeUnit");
        try {
            return skipAll(discard, i4, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> filterList, @NotNull l<? super T, Boolean> predicate) {
        List<T> F;
        f0.p(filterList, "$this$filterList");
        f0.p(predicate, "predicate");
        F = CollectionsKt__CollectionsKt.F();
        for (Object obj : filterList) {
            if (predicate.invoke(obj).booleanValue()) {
                if (F.isEmpty()) {
                    F = new ArrayList<>();
                }
                t0.g(F).add(obj);
            }
        }
        return F;
    }

    @NotNull
    public static final String format(@NotNull String format, @NotNull Object... args) {
        f0.p(format, "format");
        f0.p(args, "args");
        s0 s0Var = s0.f55680a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        f0.o(format2, "java.lang.String.format(locale, format, *args)");
        return format2;
    }

    public static final boolean hasIntersection(@NotNull String[] hasIntersection, @Nullable String[] strArr, @NotNull Comparator<? super String> comparator) {
        f0.p(hasIntersection, "$this$hasIntersection");
        f0.p(comparator, "comparator");
        if (!(hasIntersection.length == 0) && strArr != null) {
            if (!(strArr.length == 0)) {
                for (String str : hasIntersection) {
                    for (String str2 : strArr) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(@NotNull Response headersContentLength) {
        f0.p(headersContentLength, "$this$headersContentLength");
        String str = headersContentLength.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(@NotNull a<f1> block) {
        f0.p(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(@NotNull T... elements) {
        List M;
        f0.p(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        M = CollectionsKt__CollectionsKt.M(Arrays.copyOf(objArr, objArr.length));
        List<T> unmodifiableList = Collections.unmodifiableList(M);
        f0.o(unmodifiableList, "Collections.unmodifiable\u2026istOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(@NotNull String[] indexOf, @NotNull String value, @NotNull Comparator<String> comparator) {
        f0.p(indexOf, "$this$indexOf");
        f0.p(value, "value");
        f0.p(comparator, "comparator");
        int length = indexOf.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (comparator.compare(indexOf[i4], value) == 0) {
                return i4;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@NotNull String indexOfControlOrNonAscii) {
        f0.p(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = indexOfControlOrNonAscii.charAt(i4);
            if (f0.t(charAt, 31) <= 0 || f0.t(charAt, 127) >= 0) {
                return i4;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String indexOfFirstNonAsciiWhitespace, int i4, int i5) {
        f0.p(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i4 < i5) {
            char charAt = indexOfFirstNonAsciiWhitespace.charAt(i4);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i4, i5);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String indexOfLastNonAsciiWhitespace, int i4, int i5) {
        f0.p(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i6 = i5 - 1;
        if (i6 >= i4) {
            while (true) {
                char charAt = indexOfLastNonAsciiWhitespace.charAt(i6);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i6 + 1;
                }
                if (i6 == i4) {
                    break;
                }
                i6--;
            }
        }
        return i4;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i4, i5);
    }

    public static final int indexOfNonWhitespace(@NotNull String indexOfNonWhitespace, int i4) {
        f0.p(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i4 < length) {
            char charAt = indexOfNonWhitespace.charAt(i4);
            if (charAt != ' ' && charAt != '\t') {
                return i4;
            }
            i4++;
        }
        return indexOfNonWhitespace.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        return indexOfNonWhitespace(str, i4);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] intersect, @NotNull String[] other, @NotNull Comparator<? super String> comparator) {
        f0.p(intersect, "$this$intersect");
        f0.p(other, "other");
        f0.p(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            int length = other.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (comparator.compare(str, other[i4]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i4++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isCivilized(@NotNull FileSystem isCivilized, @NotNull File file) {
        f0.p(isCivilized, "$this$isCivilized");
        f0.p(file, "file");
        Sink sink = isCivilized.sink(file);
        try {
            try {
                isCivilized.delete(file);
                b.a(sink, null);
                return true;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    b.a(sink, th);
                    throw th2;
                }
            }
        } catch (IOException unused) {
            f1 f1Var = f1.f55527a;
            b.a(sink, null);
            isCivilized.delete(file);
            return false;
        }
    }

    public static final boolean isHealthy(@NotNull Socket isHealthy, @NotNull BufferedSource source) {
        f0.p(isHealthy, "$this$isHealthy");
        f0.p(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                boolean z3 = !source.exhausted();
                isHealthy.setSoTimeout(soTimeout);
                return z3;
            } catch (Throwable th) {
                isHealthy.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void notify(@NotNull Object notify) {
        f0.p(notify, "$this$notify");
        notify.notify();
    }

    public static final void notifyAll(@NotNull Object notifyAll) {
        f0.p(notifyAll, "$this$notifyAll");
        notifyAll.notifyAll();
    }

    public static final int parseHexDigit(char c4) {
        if ('0' <= c4 && '9' >= c4) {
            return c4 - '0';
        }
        char c5 = 'a';
        if ('a' > c4 || 'f' < c4) {
            c5 = 'A';
            if ('A' > c4 || 'F' < c4) {
                return -1;
            }
        }
        return (c4 - c5) + 10;
    }

    @NotNull
    public static final String peerName(@NotNull Socket peerName) {
        f0.p(peerName, "$this$peerName");
        SocketAddress remoteSocketAddress = peerName.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            f0.o(hostName, "address.hostName");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource readBomAsCharset, @NotNull Charset charset) throws IOException {
        f0.p(readBomAsCharset, "$this$readBomAsCharset");
        f0.p(charset, "default");
        int select = readBomAsCharset.select(UNICODE_BOMS);
        if (select != -1) {
            if (select == 0) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                f0.o(UTF_8, "UTF_8");
                return UTF_8;
            } else if (select == 1) {
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                f0.o(UTF_16BE, "UTF_16BE");
                return UTF_16BE;
            } else if (select == 2) {
                Charset UTF_16LE = StandardCharsets.UTF_16LE;
                f0.o(UTF_16LE, "UTF_16LE");
                return UTF_16LE;
            } else if (select != 3) {
                if (select == 4) {
                    return d.f58929a.c();
                }
                throw new AssertionError();
            } else {
                return d.f58929a.b();
            }
        }
        return charset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
        return r4;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> T readFieldOrNull(@org.jetbrains.annotations.NotNull java.lang.Object r6, @org.jetbrains.annotations.NotNull java.lang.Class<T> r7, @org.jetbrains.annotations.NotNull java.lang.String r8) {
        /*
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r1 = "instance"
            kotlin.jvm.internal.f0.p(r6, r1)
            java.lang.String r1 = "fieldType"
            kotlin.jvm.internal.f0.p(r7, r1)
            java.lang.String r1 = "fieldName"
            kotlin.jvm.internal.f0.p(r8, r1)
            java.lang.Class r1 = r6.getClass()
        L15:
            boolean r2 = kotlin.jvm.internal.f0.g(r1, r0)
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 == 0) goto L44
            java.lang.reflect.Field r2 = r1.getDeclaredField(r8)     // Catch: java.lang.NoSuchFieldException -> L3a
            java.lang.String r5 = "field"
            kotlin.jvm.internal.f0.o(r2, r5)     // Catch: java.lang.NoSuchFieldException -> L3a
            r2.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L3a
            java.lang.Object r2 = r2.get(r6)     // Catch: java.lang.NoSuchFieldException -> L3a
            boolean r3 = r7.isInstance(r2)     // Catch: java.lang.NoSuchFieldException -> L3a
            if (r3 != 0) goto L35
            goto L39
        L35:
            java.lang.Object r4 = r7.cast(r2)     // Catch: java.lang.NoSuchFieldException -> L3a
        L39:
            return r4
        L3a:
            java.lang.Class r1 = r1.getSuperclass()
            java.lang.String r2 = "c.superclass"
            kotlin.jvm.internal.f0.o(r1, r2)
            goto L15
        L44:
            java.lang.String r1 = "delegate"
            boolean r2 = kotlin.jvm.internal.f0.g(r8, r1)
            r2 = r2 ^ r3
            if (r2 == 0) goto L58
            java.lang.Object r6 = readFieldOrNull(r6, r0, r1)
            if (r6 == 0) goto L58
            java.lang.Object r6 = readFieldOrNull(r6, r7, r8)
            return r6
        L58:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.readFieldOrNull(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static final int readMedium(@NotNull BufferedSource readMedium) throws IOException {
        f0.p(readMedium, "$this$readMedium");
        return and(readMedium.readByte(), 255) | (and(readMedium.readByte(), 255) << 16) | (and(readMedium.readByte(), 255) << 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r5 == Long.MAX_VALUE) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
        r11.timeout().clearDeadline();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
        r11.timeout().deadlineNanoTime(r0 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r5 != Long.MAX_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean skipAll(@org.jetbrains.annotations.NotNull okio.Source r11, int r12, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            java.lang.String r0 = "$this$skipAll"
            kotlin.jvm.internal.f0.p(r11, r0)
            java.lang.String r0 = "timeUnit"
            kotlin.jvm.internal.f0.p(r13, r0)
            long r0 = java.lang.System.nanoTime()
            okio.Timeout r2 = r11.timeout()
            boolean r2 = r2.hasDeadline()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L27
            okio.Timeout r2 = r11.timeout()
            long r5 = r2.deadlineNanoTime()
            long r5 = r5 - r0
            goto L28
        L27:
            r5 = r3
        L28:
            okio.Timeout r2 = r11.timeout()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.deadlineNanoTime(r12)
            okio.Buffer r12 = new okio.Buffer     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r12.<init>()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
        L3e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.read(r12, r7)     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L4e
            r12.clear()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            goto L3e
        L4e:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
        L53:
            okio.Timeout r11 = r11.timeout()
            r11.clearDeadline()
            goto L81
        L5b:
            okio.Timeout r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
            goto L81
        L64:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L71
            okio.Timeout r11 = r11.timeout()
            r11.clearDeadline()
            goto L79
        L71:
            okio.Timeout r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
        L79:
            throw r12
        L7a:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
            goto L53
        L81:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull final String name, final boolean z3) {
        f0.p(name, "name");
        return new ThreadFactory() { // from class: okhttp3.internal.Util$threadFactory$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, name);
                thread.setDaemon(z3);
                return thread;
            }
        };
    }

    public static final void threadName(@NotNull String name, @NotNull a<f1> block) {
        f0.p(name, "name");
        f0.p(block, "block");
        Thread currentThread = Thread.currentThread();
        f0.o(currentThread, "currentThread");
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            c0.d(1);
            currentThread.setName(name2);
            c0.c(1);
        }
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers toHeaderList) {
        int Z;
        f0.p(toHeaderList, "$this$toHeaderList");
        k n12 = o.n1(0, toHeaderList.size());
        Z = y.Z(n12, 10);
        ArrayList arrayList = new ArrayList(Z);
        Iterator<Integer> it = n12.iterator();
        while (it.hasNext()) {
            int nextInt = ((r0) it).nextInt();
            arrayList.add(new Header(toHeaderList.name(nextInt), toHeaderList.value(nextInt)));
        }
        return arrayList;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> toHeaders) {
        f0.p(toHeaders, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : toHeaders) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final String toHexString(long j4) {
        String hexString = Long.toHexString(j4);
        f0.o(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl toHostHeader, boolean z3) {
        boolean V2;
        String host;
        f0.p(toHostHeader, "$this$toHostHeader");
        V2 = x.V2(toHostHeader.host(), ":", false, 2, null);
        if (V2) {
            host = '[' + toHostHeader.host() + ']';
        } else {
            host = toHostHeader.host();
        }
        if (z3 || toHostHeader.port() != HttpUrl.Companion.defaultPort(toHostHeader.scheme())) {
            return host + ':' + toHostHeader.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return toHostHeader(httpUrl, z3);
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> toImmutableList) {
        List J5;
        f0.p(toImmutableList, "$this$toImmutableList");
        J5 = kotlin.collections.f0.J5(toImmutableList);
        List<T> unmodifiableList = Collections.unmodifiableList(J5);
        f0.o(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> toImmutableMap) {
        Map<K, V> z3;
        f0.p(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            z3 = z0.z();
            return z3;
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        f0.o(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(@NotNull String toLongOrDefault, long j4) {
        f0.p(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j4;
        }
    }

    public static final int toNonNegativeInt(@Nullable String str, int i4) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i4;
    }

    @NotNull
    public static final String trimSubstring(@NotNull String trimSubstring, int i4, int i5) {
        f0.p(trimSubstring, "$this$trimSubstring");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(trimSubstring, i4, i5);
        String substring = trimSubstring.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(trimSubstring, indexOfFirstNonAsciiWhitespace, i5));
        f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return trimSubstring(str, i4, i5);
    }

    public static final void wait(@NotNull Object wait) {
        f0.p(wait, "$this$wait");
        wait.wait();
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception withSuppressed, @NotNull List<? extends Exception> suppressed) {
        f0.p(withSuppressed, "$this$withSuppressed");
        f0.p(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        for (Exception exc : suppressed) {
            j.a(withSuppressed, exc);
        }
        return withSuppressed;
    }

    public static final void writeMedium(@NotNull BufferedSink writeMedium, int i4) throws IOException {
        f0.p(writeMedium, "$this$writeMedium");
        writeMedium.writeByte((i4 >>> 16) & 255);
        writeMedium.writeByte((i4 >>> 8) & 255);
        writeMedium.writeByte(i4 & 255);
    }

    public static final int delimiterOffset(@NotNull String delimiterOffset, char c4, int i4, int i5) {
        f0.p(delimiterOffset, "$this$delimiterOffset");
        while (i4 < i5) {
            if (delimiterOffset.charAt(i4) == c4) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c4, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = str.length();
        }
        return delimiterOffset(str, c4, i4, i5);
    }

    @NotNull
    public static final String toHexString(int i4) {
        String hexString = Integer.toHexString(i4);
        f0.o(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final void closeQuietly(@NotNull Socket closeQuietly) {
        f0.p(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e4) {
            throw e4;
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(@NotNull ServerSocket closeQuietly) {
        f0.p(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e4) {
            throw e4;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(@NotNull Buffer skipAll, byte b4) {
        f0.p(skipAll, "$this$skipAll");
        int i4 = 0;
        while (!skipAll.exhausted() && skipAll.getByte(0L) == b4) {
            i4++;
            skipAll.readByte();
        }
        return i4;
    }
}
