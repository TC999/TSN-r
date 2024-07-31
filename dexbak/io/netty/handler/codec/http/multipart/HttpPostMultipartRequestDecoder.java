package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpPostMultipartRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private Charset charset;
    private Attribute currentAttribute;
    private Map<CharSequence, Attribute> currentFieldAttributes;
    private FileUpload currentFileUpload;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private String multipartDataBoundary;
    private String multipartMixedBoundary;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C138141 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus */
        static final /* synthetic */ int[] f40232xeab8d0a3;

        static {
            int[] iArr = new int[HttpPostRequestDecoder.MultiPartStatus.values().length];
            f40232xeab8d0a3 = iArr;
            try {
                iArr[HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.PREAMBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.DISPOSITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.FIELD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.MIXEDDISPOSITION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f40232xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.EPILOGUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public HttpPostMultipartRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException(HttpPostMultipartRequestDecoder.class.getSimpleName() + " was destroyed already");
        }
    }

    private void cleanMixedAttributes() {
        this.currentFieldAttributes.remove(HttpHeaderValues.CHARSET);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_LENGTH);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TYPE);
        this.currentFieldAttributes.remove(HttpHeaderValues.FILENAME);
    }

    private static String cleanString(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ':') {
                sb.append(HttpConstants.SP_CHAR);
            } else if (charAt == ',') {
                sb.append(HttpConstants.SP_CHAR);
            } else if (charAt == '=') {
                sb.append(HttpConstants.SP_CHAR);
            } else if (charAt == ';') {
                sb.append(HttpConstants.SP_CHAR);
            } else if (charAt == '\t') {
                sb.append(HttpConstants.SP_CHAR);
            } else if (charAt != '\"') {
                sb.append(charAt);
            }
        }
        return sb.toString().trim();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008b A[Catch: IOException -> 0x00b8, IllegalArgumentException -> 0x00bf, NullPointerException -> 0x00c6, TRY_ENTER, TryCatch #7 {IOException -> 0x00b8, IllegalArgumentException -> 0x00bf, NullPointerException -> 0x00c6, blocks: (B:38:0x008b, B:39:0x009e), top: B:66:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e A[Catch: IOException -> 0x00b8, IllegalArgumentException -> 0x00bf, NullPointerException -> 0x00c6, TRY_LEAVE, TryCatch #7 {IOException -> 0x00b8, IllegalArgumentException -> 0x00bf, NullPointerException -> 0x00c6, blocks: (B:38:0x008b, B:39:0x009e), top: B:66:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.handler.codec.http.multipart.InterfaceHttpData decodeMultipart(io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus r8) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.decodeMultipart(io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus):io.netty.handler.codec.http.multipart.InterfaceHttpData");
    }

    private InterfaceHttpData findMultipartDelimiter(String str, HttpPostRequestDecoder.MultiPartStatus multiPartStatus, HttpPostRequestDecoder.MultiPartStatus multiPartStatus2) {
        int readerIndex = this.undecodedChunk.readerIndex();
        try {
            skipControlCharacters();
            skipOneLine();
            try {
                String readDelimiter = readDelimiter(str);
                if (readDelimiter.equals(str)) {
                    this.currentStatus = multiPartStatus;
                    return decodeMultipart(multiPartStatus);
                }
                if (readDelimiter.equals(str + "--")) {
                    this.currentStatus = multiPartStatus2;
                    HttpPostRequestDecoder.MultiPartStatus multiPartStatus3 = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
                    if (multiPartStatus2 == multiPartStatus3) {
                        this.currentFieldAttributes = null;
                        return decodeMultipart(multiPartStatus3);
                    }
                    return null;
                }
                this.undecodedChunk.readerIndex(readerIndex);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException("No Multipart delimiter found");
            } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused) {
                this.undecodedChunk.readerIndex(readerIndex);
                return null;
            }
        } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused2) {
            this.undecodedChunk.readerIndex(readerIndex);
            return null;
        }
    }

    private InterfaceHttpData findMultipartDisposition() {
        boolean z;
        String cleanString;
        int readerIndex = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            this.currentFieldAttributes = new TreeMap(CaseIgnoringComparator.INSTANCE);
        }
        while (!skipOneLine()) {
            try {
                skipControlCharacters();
                String readLine = readLine();
                String[] splitMultipartHeader = splitMultipartHeader(readLine);
                if (HttpHeaderNames.CONTENT_DISPOSITION.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                    if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
                        z = HttpHeaderValues.FORM_DATA.contentEqualsIgnoreCase(splitMultipartHeader[1]);
                    } else {
                        z = HttpHeaderValues.ATTACHMENT.contentEqualsIgnoreCase(splitMultipartHeader[1]) || HttpHeaderValues.FILE.contentEqualsIgnoreCase(splitMultipartHeader[1]);
                    }
                    if (z) {
                        for (int i = 2; i < splitMultipartHeader.length; i++) {
                            String[] split = splitMultipartHeader[i].split("=", 2);
                            try {
                                String cleanString2 = cleanString(split[0]);
                                String str = split[1];
                                if (HttpHeaderValues.FILENAME.contentEquals(cleanString2)) {
                                    cleanString = str.substring(1, str.length() - 1);
                                } else {
                                    cleanString = cleanString(str);
                                }
                                Attribute createAttribute = this.factory.createAttribute(this.request, cleanString2, cleanString);
                                this.currentFieldAttributes.put(createAttribute.getName(), createAttribute);
                            } catch (IllegalArgumentException e) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
                            } catch (NullPointerException e2) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e2);
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else {
                    AsciiString asciiString = HttpHeaderNames.CONTENT_TRANSFER_ENCODING;
                    if (asciiString.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                        try {
                            this.currentFieldAttributes.put(asciiString, this.factory.createAttribute(this.request, asciiString.toString(), cleanString(splitMultipartHeader[1])));
                        } catch (IllegalArgumentException e3) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e3);
                        } catch (NullPointerException e4) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e4);
                        }
                    } else {
                        AsciiString asciiString2 = HttpHeaderNames.CONTENT_LENGTH;
                        if (asciiString2.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                            try {
                                this.currentFieldAttributes.put(asciiString2, this.factory.createAttribute(this.request, asciiString2.toString(), cleanString(splitMultipartHeader[1])));
                            } catch (IllegalArgumentException e5) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e5);
                            } catch (NullPointerException e6) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e6);
                            }
                        } else if (HttpHeaderNames.CONTENT_TYPE.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                            if (HttpHeaderValues.MULTIPART_MIXED.contentEqualsIgnoreCase(splitMultipartHeader[1])) {
                                if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
                                    String substringAfter = StringUtil.substringAfter(splitMultipartHeader[2], '=');
                                    this.multipartMixedBoundary = "--" + substringAfter;
                                    HttpPostRequestDecoder.MultiPartStatus multiPartStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
                                    this.currentStatus = multiPartStatus;
                                    return decodeMultipart(multiPartStatus);
                                }
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Mixed Multipart found in a previous Mixed Multipart");
                            }
                            for (int i2 = 1; i2 < splitMultipartHeader.length; i2++) {
                                String lowerCase = splitMultipartHeader[i2].toLowerCase();
                                AsciiString asciiString3 = HttpHeaderValues.CHARSET;
                                if (lowerCase.startsWith(asciiString3.toString())) {
                                    try {
                                        this.currentFieldAttributes.put(asciiString3, this.factory.createAttribute(this.request, asciiString3.toString(), cleanString(StringUtil.substringAfter(splitMultipartHeader[i2], '='))));
                                    } catch (IllegalArgumentException e7) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e7);
                                    } catch (NullPointerException e8) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e8);
                                    }
                                } else {
                                    try {
                                        Attribute createAttribute2 = this.factory.createAttribute(this.request, cleanString(splitMultipartHeader[0]), splitMultipartHeader[i2]);
                                        this.currentFieldAttributes.put(createAttribute2.getName(), createAttribute2);
                                    } catch (IllegalArgumentException e9) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e9);
                                    } catch (NullPointerException e10) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
                                    }
                                }
                            }
                            continue;
                        } else {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Unknown Params: " + readLine);
                        }
                    }
                }
            } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused) {
                this.undecodedChunk.readerIndex(readerIndex);
                return null;
            }
        }
        Attribute attribute = this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            if (attribute != null) {
                HttpPostRequestDecoder.MultiPartStatus multiPartStatus2 = HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD;
                this.currentStatus = multiPartStatus2;
                return decodeMultipart(multiPartStatus2);
            }
            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Filename not found");
        } else if (attribute != null) {
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus3 = HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD;
            this.currentStatus = multiPartStatus3;
            return decodeMultipart(multiPartStatus3);
        } else {
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus4 = HttpPostRequestDecoder.MultiPartStatus.FIELD;
            this.currentStatus = multiPartStatus4;
            return decodeMultipart(multiPartStatus4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r7 != 13) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        r5 = r0.pos;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r5 >= r0.limit) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        r2 = r0.bytes;
        r6 = r5 + 1;
        r0.pos = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r2[r5] != 10) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        r2 = r6 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        r6 = r6 - 1;
        r0.pos = r6;
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r7 != 10) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        r2 = r0.pos - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
        r2 = r0.pos;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x005b, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadFieldMultipart(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.loadFieldMultipart(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r6 != 13) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r10.undecodedChunk.isReadable() == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r10.undecodedChunk.readByte() != 10) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        r1 = r10.undecodedChunk.readerIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        r1 = r10.undecodedChunk.readerIndex() - 1;
        r10.undecodedChunk.readerIndex(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        r1 = r10.undecodedChunk.readerIndex() - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        if (r6 != 10) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
        r1 = r10.undecodedChunk.readerIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
        r1 = r10.undecodedChunk.readerIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        r1 = r1 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
        r1 = r1 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadFieldMultipartStandard(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.loadFieldMultipartStandard(java.lang.String):void");
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyMultipart();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyMultipart() {
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null || byteBuf.readableBytes() == 0) {
            return;
        }
        InterfaceHttpData decodeMultipart = decodeMultipart(this.currentStatus);
        while (decodeMultipart != null) {
            addHttpData(decodeMultipart);
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
            if (multiPartStatus == HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE || multiPartStatus == HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
                return;
            }
            decodeMultipart = decodeMultipart(multiPartStatus);
        }
    }

    private String readDelimiter(String str) {
        int i;
        int i2;
        try {
            HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
            int readerIndex = this.undecodedChunk.readerIndex();
            int length = str.length();
            try {
                StringBuilder sb = new StringBuilder(64);
                int i3 = 0;
                while (true) {
                    i = seekAheadOptimize.pos;
                    i2 = seekAheadOptimize.limit;
                    if (i >= i2 || i3 >= length) {
                        break;
                    }
                    byte[] bArr = seekAheadOptimize.bytes;
                    seekAheadOptimize.pos = i + 1;
                    byte b = bArr[i];
                    if (b == str.charAt(i3)) {
                        i3++;
                        sb.append((char) b);
                    } else {
                        this.undecodedChunk.readerIndex(readerIndex);
                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                    }
                }
                if (i < i2) {
                    byte[] bArr2 = seekAheadOptimize.bytes;
                    int i4 = i + 1;
                    seekAheadOptimize.pos = i4;
                    byte b2 = bArr2[i];
                    if (b2 == 13) {
                        if (i4 < i2) {
                            seekAheadOptimize.pos = i4 + 1;
                            if (bArr2[i4] == 10) {
                                seekAheadOptimize.setReadPosition(0);
                                return sb.toString();
                            }
                            this.undecodedChunk.readerIndex(readerIndex);
                            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                        }
                        this.undecodedChunk.readerIndex(readerIndex);
                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                    } else if (b2 == 10) {
                        seekAheadOptimize.setReadPosition(0);
                        return sb.toString();
                    } else if (b2 == 45) {
                        sb.append('-');
                        int i5 = seekAheadOptimize.pos;
                        if (i5 < seekAheadOptimize.limit) {
                            byte[] bArr3 = seekAheadOptimize.bytes;
                            seekAheadOptimize.pos = i5 + 1;
                            if (bArr3[i5] == 45) {
                                sb.append('-');
                                int i6 = seekAheadOptimize.pos;
                                int i7 = seekAheadOptimize.limit;
                                if (i6 < i7) {
                                    byte[] bArr4 = seekAheadOptimize.bytes;
                                    int i8 = i6 + 1;
                                    seekAheadOptimize.pos = i8;
                                    byte b3 = bArr4[i6];
                                    if (b3 != 13) {
                                        if (b3 == 10) {
                                            seekAheadOptimize.setReadPosition(0);
                                            return sb.toString();
                                        }
                                        seekAheadOptimize.setReadPosition(1);
                                        return sb.toString();
                                    } else if (i8 < i7) {
                                        seekAheadOptimize.pos = i8 + 1;
                                        if (bArr4[i8] == 10) {
                                            seekAheadOptimize.setReadPosition(0);
                                            return sb.toString();
                                        }
                                        this.undecodedChunk.readerIndex(readerIndex);
                                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                                    } else {
                                        this.undecodedChunk.readerIndex(readerIndex);
                                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                                    }
                                }
                                seekAheadOptimize.setReadPosition(0);
                                return sb.toString();
                            }
                        }
                    }
                }
                this.undecodedChunk.readerIndex(readerIndex);
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
            } catch (IndexOutOfBoundsException e) {
                this.undecodedChunk.readerIndex(readerIndex);
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e);
            }
        } catch (HttpPostBodyUtil.SeekAheadNoBackArrayException unused) {
            return readDelimiterStandard(str);
        }
    }

    private String readDelimiterStandard(String str) {
        int readerIndex = this.undecodedChunk.readerIndex();
        try {
            StringBuilder sb = new StringBuilder(64);
            int i = 0;
            int length = str.length();
            while (this.undecodedChunk.isReadable() && i < length) {
                byte readByte = this.undecodedChunk.readByte();
                if (readByte == str.charAt(i)) {
                    i++;
                    sb.append((char) readByte);
                } else {
                    this.undecodedChunk.readerIndex(readerIndex);
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                }
            }
            if (this.undecodedChunk.isReadable()) {
                byte readByte2 = this.undecodedChunk.readByte();
                if (readByte2 == 13) {
                    if (this.undecodedChunk.readByte() == 10) {
                        return sb.toString();
                    }
                    this.undecodedChunk.readerIndex(readerIndex);
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                } else if (readByte2 == 10) {
                    return sb.toString();
                } else {
                    if (readByte2 == 45) {
                        sb.append('-');
                        if (this.undecodedChunk.readByte() == 45) {
                            sb.append('-');
                            if (this.undecodedChunk.isReadable()) {
                                byte readByte3 = this.undecodedChunk.readByte();
                                if (readByte3 == 13) {
                                    if (this.undecodedChunk.readByte() == 10) {
                                        return sb.toString();
                                    }
                                    this.undecodedChunk.readerIndex(readerIndex);
                                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                                } else if (readByte3 == 10) {
                                    return sb.toString();
                                } else {
                                    ByteBuf byteBuf = this.undecodedChunk;
                                    byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                                    return sb.toString();
                                }
                            }
                            return sb.toString();
                        }
                    }
                }
            }
            this.undecodedChunk.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        } catch (IndexOutOfBoundsException e) {
            this.undecodedChunk.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r7 != 13) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
        r5 = r0.pos;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r5 >= r0.limit) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        r2 = r0.bytes;
        r6 = r5 + 1;
        r0.pos = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
        if (r2[r5] != 10) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        r2 = r6 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
        r6 = r6 - 1;
        r0.pos = r6;
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r7 != 10) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        r2 = r0.pos - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        r2 = r0.pos;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0052, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readFileUploadByteMultipart(java.lang.String r14) {
        /*
            r13 = this;
            io.netty.handler.codec.http.multipart.HttpPostBodyUtil$SeekAheadOptimize r0 = new io.netty.handler.codec.http.multipart.HttpPostBodyUtil$SeekAheadOptimize     // Catch: io.netty.handler.codec.http.multipart.HttpPostBodyUtil.SeekAheadNoBackArrayException -> Lb1
            io.netty.buffer.ByteBuf r1 = r13.undecodedChunk     // Catch: io.netty.handler.codec.http.multipart.HttpPostBodyUtil.SeekAheadNoBackArrayException -> Lb1
            r0.<init>(r1)     // Catch: io.netty.handler.codec.http.multipart.HttpPostBodyUtil.SeekAheadNoBackArrayException -> Lb1
            io.netty.buffer.ByteBuf r1 = r13.undecodedChunk
            int r1 = r1.readerIndex()
            int r2 = r0.pos
            r3 = 0
            r4 = 1
        L11:
            r5 = 1
        L12:
            r6 = 0
        L13:
            int r7 = r0.pos
            int r8 = r0.limit
            if (r7 >= r8) goto L79
            byte[] r9 = r0.bytes
            int r10 = r7 + 1
            r0.pos = r10
            r7 = r9[r7]
            r11 = 13
            r12 = 10
            if (r5 == 0) goto L5d
            int r8 = r14.codePointAt(r6)
            if (r7 != r8) goto L37
            int r6 = r6 + 1
            int r7 = r14.length()
            if (r7 != r6) goto L13
            r14 = 1
            goto L7a
        L37:
            if (r7 != r11) goto L54
            int r5 = r0.pos
            int r6 = r0.limit
            if (r5 >= r6) goto L52
            byte[] r2 = r0.bytes
            int r6 = r5 + 1
            r0.pos = r6
            r2 = r2[r5]
            if (r2 != r12) goto L4d
            int r6 = r6 + (-2)
            r2 = r6
            goto L11
        L4d:
            int r6 = r6 + (-1)
            r0.pos = r6
            r2 = r6
        L52:
            r5 = 0
            goto L12
        L54:
            if (r7 != r12) goto L5a
            int r2 = r0.pos
            int r2 = r2 - r4
            goto L11
        L5a:
            int r2 = r0.pos
            goto L52
        L5d:
            if (r7 != r11) goto L71
            if (r10 >= r8) goto L13
            int r2 = r10 + 1
            r0.pos = r2
            r7 = r9[r10]
            if (r7 != r12) goto L6c
            int r2 = r2 + (-2)
            goto L11
        L6c:
            int r2 = r2 + (-1)
            r0.pos = r2
            goto L13
        L71:
            if (r7 != r12) goto L77
            int r10 = r10 + (-1)
            r2 = r10
            goto L11
        L77:
            r2 = r10
            goto L13
        L79:
            r14 = 0
        L7a:
            int r0 = r0.getReadPosition(r2)
            io.netty.buffer.ByteBuf r2 = r13.undecodedChunk
            int r5 = r0 - r1
            io.netty.buffer.ByteBuf r1 = r2.copy(r1, r5)
            if (r14 == 0) goto L9a
            io.netty.handler.codec.http.multipart.FileUpload r14 = r13.currentFileUpload     // Catch: java.io.IOException -> L93
            r14.addContent(r1, r4)     // Catch: java.io.IOException -> L93
            io.netty.buffer.ByteBuf r14 = r13.undecodedChunk     // Catch: java.io.IOException -> L93
            r14.readerIndex(r0)     // Catch: java.io.IOException -> L93
            return
        L93:
            r14 = move-exception
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r0 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r0.<init>(r14)
            throw r0
        L9a:
            io.netty.handler.codec.http.multipart.FileUpload r14 = r13.currentFileUpload     // Catch: java.io.IOException -> Laa
            r14.addContent(r1, r3)     // Catch: java.io.IOException -> Laa
            io.netty.buffer.ByteBuf r14 = r13.undecodedChunk     // Catch: java.io.IOException -> Laa
            r14.readerIndex(r0)     // Catch: java.io.IOException -> Laa
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$NotEnoughDataDecoderException r14 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$NotEnoughDataDecoderException     // Catch: java.io.IOException -> Laa
            r14.<init>()     // Catch: java.io.IOException -> Laa
            throw r14     // Catch: java.io.IOException -> Laa
        Laa:
            r14 = move-exception
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r0 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r0.<init>(r14)
            throw r0
        Lb1:
            r13.readFileUploadByteMultipartStandard(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.readFileUploadByteMultipart(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        if (r6 != 13) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r10.undecodedChunk.isReadable() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r10.undecodedChunk.readByte() != 10) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
        r1 = r10.undecodedChunk.readerIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        r1 = r10.undecodedChunk.readerIndex() - 1;
        r10.undecodedChunk.readerIndex(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
        if (r6 != 10) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        r1 = r10.undecodedChunk.readerIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
        r1 = r10.undecodedChunk.readerIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x005a, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readFileUploadByteMultipartStandard(java.lang.String r11) {
        /*
            r10 = this;
            io.netty.buffer.ByteBuf r0 = r10.undecodedChunk
            int r0 = r0.readerIndex()
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
            r2 = 0
            r3 = 1
        Le:
            r4 = 1
        Lf:
            r5 = 0
        L10:
            io.netty.buffer.ByteBuf r6 = r10.undecodedChunk
            boolean r6 = r6.isReadable()
            if (r6 == 0) goto La8
            io.netty.buffer.ByteBuf r6 = r10.undecodedChunk
            byte r6 = r6.readByte()
            r7 = 13
            r8 = 10
            if (r4 == 0) goto L6c
            int r9 = r11.codePointAt(r5)
            if (r6 != r9) goto L35
            int r5 = r5 + 1
            int r6 = r11.length()
            if (r6 != r5) goto L10
            r11 = 1
            goto La9
        L35:
            if (r6 != r7) goto L5c
            io.netty.buffer.ByteBuf r4 = r10.undecodedChunk
            boolean r4 = r4.isReadable()
            if (r4 == 0) goto L5a
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            byte r1 = r1.readByte()
            if (r1 != r8) goto L4e
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
            goto L84
        L4e:
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
            int r1 = r1 - r3
            io.netty.buffer.ByteBuf r4 = r10.undecodedChunk
            r4.readerIndex(r1)
        L5a:
            r4 = 0
            goto Lf
        L5c:
            if (r6 != r8) goto L65
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
            goto L9d
        L65:
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
            goto L5a
        L6c:
            if (r6 != r7) goto L95
            io.netty.buffer.ByteBuf r6 = r10.undecodedChunk
            boolean r6 = r6.isReadable()
            if (r6 == 0) goto L10
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            byte r1 = r1.readByte()
            if (r1 != r8) goto L87
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
        L84:
            int r1 = r1 + (-2)
            goto Le
        L87:
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
            int r1 = r1 - r3
            io.netty.buffer.ByteBuf r6 = r10.undecodedChunk
            r6.readerIndex(r1)
            goto L10
        L95:
            if (r6 != r8) goto La0
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
        L9d:
            int r1 = r1 - r3
            goto Le
        La0:
            io.netty.buffer.ByteBuf r1 = r10.undecodedChunk
            int r1 = r1.readerIndex()
            goto L10
        La8:
            r11 = 0
        La9:
            io.netty.buffer.ByteBuf r4 = r10.undecodedChunk
            int r5 = r1 - r0
            io.netty.buffer.ByteBuf r0 = r4.copy(r0, r5)
            if (r11 == 0) goto Lc5
            io.netty.handler.codec.http.multipart.FileUpload r11 = r10.currentFileUpload     // Catch: java.io.IOException -> Lbe
            r11.addContent(r0, r3)     // Catch: java.io.IOException -> Lbe
            io.netty.buffer.ByteBuf r11 = r10.undecodedChunk     // Catch: java.io.IOException -> Lbe
            r11.readerIndex(r1)     // Catch: java.io.IOException -> Lbe
            return
        Lbe:
            r11 = move-exception
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r0 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r0.<init>(r11)
            throw r0
        Lc5:
            io.netty.handler.codec.http.multipart.FileUpload r11 = r10.currentFileUpload     // Catch: java.io.IOException -> Ld5
            r11.addContent(r0, r2)     // Catch: java.io.IOException -> Ld5
            io.netty.buffer.ByteBuf r11 = r10.undecodedChunk     // Catch: java.io.IOException -> Ld5
            r11.readerIndex(r1)     // Catch: java.io.IOException -> Ld5
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$NotEnoughDataDecoderException r11 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$NotEnoughDataDecoderException     // Catch: java.io.IOException -> Ld5
            r11.<init>()     // Catch: java.io.IOException -> Ld5
            throw r11     // Catch: java.io.IOException -> Ld5
        Ld5:
            r11 = move-exception
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r0 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r0.<init>(r11)
            goto Ldd
        Ldc:
            throw r0
        Ldd:
            goto Ldc
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.readFileUploadByteMultipartStandard(java.lang.String):void");
    }

    private String readLine() {
        try {
            HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
            int readerIndex = this.undecodedChunk.readerIndex();
            try {
                ByteBuf buffer = Unpooled.buffer(64);
                while (true) {
                    int i = seekAheadOptimize.pos;
                    int i2 = seekAheadOptimize.limit;
                    if (i < i2) {
                        byte[] bArr = seekAheadOptimize.bytes;
                        int i3 = i + 1;
                        seekAheadOptimize.pos = i3;
                        byte b = bArr[i];
                        if (b == 13) {
                            if (i3 < i2) {
                                int i4 = i3 + 1;
                                seekAheadOptimize.pos = i4;
                                if (bArr[i3] == 10) {
                                    seekAheadOptimize.setReadPosition(0);
                                    return buffer.toString(this.charset);
                                }
                                seekAheadOptimize.pos = i4 - 1;
                                buffer.writeByte(13);
                            } else {
                                buffer.writeByte(b);
                            }
                        } else if (b == 10) {
                            seekAheadOptimize.setReadPosition(0);
                            return buffer.toString(this.charset);
                        } else {
                            buffer.writeByte(b);
                        }
                    } else {
                        this.undecodedChunk.readerIndex(readerIndex);
                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                this.undecodedChunk.readerIndex(readerIndex);
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e);
            }
        } catch (HttpPostBodyUtil.SeekAheadNoBackArrayException unused) {
            return readLineStandard();
        }
    }

    private String readLineStandard() {
        int readerIndex = this.undecodedChunk.readerIndex();
        try {
            ByteBuf buffer = Unpooled.buffer(64);
            while (this.undecodedChunk.isReadable()) {
                byte readByte = this.undecodedChunk.readByte();
                if (readByte == 13) {
                    ByteBuf byteBuf = this.undecodedChunk;
                    if (byteBuf.getByte(byteBuf.readerIndex()) == 10) {
                        this.undecodedChunk.readByte();
                        return buffer.toString(this.charset);
                    }
                    buffer.writeByte(13);
                } else if (readByte == 10) {
                    return buffer.toString(this.charset);
                } else {
                    buffer.writeByte(readByte);
                }
            }
            this.undecodedChunk.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        } catch (IndexOutOfBoundsException e) {
            this.undecodedChunk.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e);
        }
    }

    private void setMultipart(String str) {
        String[] multipartDataBoundary = HttpPostRequestDecoder.getMultipartDataBoundary(str);
        if (multipartDataBoundary != null) {
            this.multipartDataBoundary = multipartDataBoundary[0];
            if (multipartDataBoundary.length > 1 && multipartDataBoundary[1] != null) {
                this.charset = Charset.forName(multipartDataBoundary[1]);
            }
        } else {
            this.multipartDataBoundary = null;
        }
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
    }

    private boolean skipOneLine() {
        if (this.undecodedChunk.isReadable()) {
            byte readByte = this.undecodedChunk.readByte();
            if (readByte != 13) {
                if (readByte == 10) {
                    return true;
                }
                ByteBuf byteBuf = this.undecodedChunk;
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return false;
            } else if (!this.undecodedChunk.isReadable()) {
                ByteBuf byteBuf2 = this.undecodedChunk;
                byteBuf2.readerIndex(byteBuf2.readerIndex() - 1);
                return false;
            } else if (this.undecodedChunk.readByte() == 10) {
                return true;
            } else {
                ByteBuf byteBuf3 = this.undecodedChunk;
                byteBuf3.readerIndex(byteBuf3.readerIndex() - 2);
                return false;
            }
        }
        return false;
    }

    private static String[] splitMultipartHeader(String str) {
        String[] split;
        char charAt;
        ArrayList arrayList = new ArrayList(1);
        int findNonWhitespace = HttpPostBodyUtil.findNonWhitespace(str, 0);
        int i = findNonWhitespace;
        while (i < str.length() && (charAt = str.charAt(i)) != ':' && !Character.isWhitespace(charAt)) {
            i++;
        }
        int i2 = i;
        while (true) {
            if (i2 >= str.length()) {
                break;
            } else if (str.charAt(i2) == ':') {
                i2++;
                break;
            } else {
                i2++;
            }
        }
        int findNonWhitespace2 = HttpPostBodyUtil.findNonWhitespace(str, i2);
        int findEndOfString = HttpPostBodyUtil.findEndOfString(str);
        arrayList.add(str.substring(findNonWhitespace, i));
        String substring = str.substring(findNonWhitespace2, findEndOfString);
        if (substring.indexOf(59) >= 0) {
            split = splitMultipartHeaderValues(substring);
        } else {
            split = substring.split(",");
        }
        for (String str2 : split) {
            arrayList.add(str2.trim());
        }
        String[] strArr = new String[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            strArr[i3] = (String) arrayList.get(i3);
        }
        return strArr;
    }

    private static String[] splitMultipartHeaderValues(String str) {
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList(1);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (z) {
                if (z2) {
                    z2 = false;
                } else if (charAt == '\\') {
                    z2 = true;
                } else if (charAt == '\"') {
                    z = false;
                }
            } else if (charAt == '\"') {
                z = true;
            } else if (charAt == ';') {
                arrayList.add(str.substring(i, i2));
                i = i2 + 1;
            }
        }
        arrayList.add(str.substring(i));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    protected void addHttpData(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData == null) {
            return;
        }
        List<InterfaceHttpData> list = this.bodyMapHttpData.get(interfaceHttpData.getName());
        if (list == null) {
            list = new ArrayList<>(1);
            this.bodyMapHttpData.put(interfaceHttpData.getName(), list);
        }
        list.add(interfaceHttpData);
        this.bodyListHttpData.add(interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        checkDestroyed();
        this.factory.cleanRequestHttpData(this.request);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData currentPartialHttpData() {
        FileUpload fileUpload = this.currentFileUpload;
        return fileUpload != null ? fileUpload : this.currentAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        checkDestroyed();
        cleanFiles();
        this.destroyed = true;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf != null && byteBuf.refCnt() > 0) {
            this.undecodedChunk.release();
            this.undecodedChunk = null;
        }
        for (int i = this.bodyListHttpDataRank; i < this.bodyListHttpData.size(); i++) {
            this.bodyListHttpData.get(i).release();
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData getBodyHttpData(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            List<InterfaceHttpData> list = this.bodyMapHttpData.get(str);
            if (list != null) {
                return list.get(0);
            }
            return null;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas() {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyListHttpData;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    protected InterfaceHttpData getFileUpload(String str) {
        String value;
        Attribute attribute = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
        Charset charset = this.charset;
        HttpPostBodyUtil.TransferEncodingMechanism transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BIT7;
        if (attribute != null) {
            try {
                String lowerCase = attribute.getValue().toLowerCase();
                if (lowerCase.equals(transferEncodingMechanism.value())) {
                    charset = CharsetUtil.US_ASCII;
                } else {
                    transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BIT8;
                    if (lowerCase.equals(transferEncodingMechanism.value())) {
                        charset = CharsetUtil.ISO_8859_1;
                    } else {
                        transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BINARY;
                        if (!lowerCase.equals(transferEncodingMechanism.value())) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException("TransferEncoding Unknown: " + lowerCase);
                        }
                    }
                }
            } catch (IOException e) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
            }
        }
        Attribute attribute2 = this.currentFieldAttributes.get(HttpHeaderValues.CHARSET);
        if (attribute2 != null) {
            try {
                charset = Charset.forName(attribute2.getValue());
            } catch (IOException e2) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e2);
            } catch (UnsupportedCharsetException e3) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e3);
            }
        }
        Charset charset2 = charset;
        if (this.currentFileUpload == null) {
            Attribute attribute3 = this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
            Attribute attribute4 = this.currentFieldAttributes.get(HttpHeaderValues.NAME);
            Attribute attribute5 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TYPE);
            Attribute attribute6 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_LENGTH);
            long j = 0;
            if (attribute6 != null) {
                try {
                    j = Long.parseLong(attribute6.getValue());
                } catch (IOException e4) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e4);
                } catch (NumberFormatException unused) {
                }
            }
            long j2 = j;
            if (attribute5 != null) {
                try {
                    value = attribute5.getValue();
                } catch (IOException e5) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e5);
                } catch (IllegalArgumentException e6) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e6);
                } catch (NullPointerException e7) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e7);
                }
            } else {
                value = HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE;
            }
            this.currentFileUpload = this.factory.createFileUpload(this.request, cleanString(attribute4.getValue()), cleanString(attribute3.getValue()), value, transferEncodingMechanism.value(), charset2, j2);
        }
        try {
            readFileUploadByteMultipart(str);
            if (this.currentFileUpload.isCompleted()) {
                if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD) {
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
                    this.currentFieldAttributes = null;
                } else {
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
                    cleanMixedAttributes();
                }
                FileUpload fileUpload = this.currentFileUpload;
                this.currentFileUpload = null;
                return fileUpload;
            }
        } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused2) {
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean hasNext() {
        checkDestroyed();
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE || this.bodyListHttpDataRank < this.bodyListHttpData.size()) {
            return !this.bodyListHttpData.isEmpty() && this.bodyListHttpDataRank < this.bodyListHttpData.size();
        }
        throw new HttpPostRequestDecoder.EndOfDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean isMultipart() {
        checkDestroyed();
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData next() {
        checkDestroyed();
        if (hasNext()) {
            List<InterfaceHttpData> list = this.bodyListHttpData;
            int i = this.bodyListHttpDataRank;
            this.bodyListHttpDataRank = i + 1;
            return list.get(i);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        checkDestroyed();
        this.factory.removeHttpDataFromClean(this.request, interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void setDiscardThreshold(int i) {
        if (i >= 0) {
            this.discardThreshold = i;
            return;
        }
        throw new IllegalArgumentException("discardThreshold must be >= 0");
    }

    void skipControlCharacters() {
        try {
            try {
                HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
                while (true) {
                    int i = seekAheadOptimize.pos;
                    if (i < seekAheadOptimize.limit) {
                        byte[] bArr = seekAheadOptimize.bytes;
                        seekAheadOptimize.pos = i + 1;
                        char c = (char) (bArr[i] & UByte.f41242c);
                        if (!Character.isISOControl(c) && !Character.isWhitespace(c)) {
                            seekAheadOptimize.setReadPosition(1);
                            return;
                        }
                    } else {
                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException("Access out of bounds");
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e);
            }
        } catch (HttpPostBodyUtil.SeekAheadNoBackArrayException unused) {
            skipControlCharactersStandard();
        }
    }

    void skipControlCharactersStandard() {
        while (true) {
            char readUnsignedByte = (char) this.undecodedChunk.readUnsignedByte();
            if (!Character.isISOControl(readUnsignedByte) && !Character.isWhitespace(readUnsignedByte)) {
                ByteBuf byteBuf = this.undecodedChunk;
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return;
            }
        }
    }

    public HttpPostMultipartRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public HttpPostMultipartRequestDecoder offer(HttpContent httpContent) {
        checkDestroyed();
        ByteBuf content = httpContent.content();
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            this.undecodedChunk = content.copy();
        } else {
            byteBuf.writeBytes(content);
        }
        if (httpContent instanceof LastHttpContent) {
            this.isLastChunk = true;
        }
        parseBody();
        ByteBuf byteBuf2 = this.undecodedChunk;
        if (byteBuf2 != null && byteBuf2.writerIndex() > this.discardThreshold) {
            this.undecodedChunk.discardReadBytes();
        }
        return this;
    }

    public HttpPostMultipartRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) {
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        if (httpDataFactory == null) {
            throw new NullPointerException("factory");
        }
        if (httpRequest == null) {
            throw new NullPointerException("request");
        }
        if (charset != null) {
            this.request = httpRequest;
            this.charset = charset;
            this.factory = httpDataFactory;
            setMultipart(httpRequest.headers().get(HttpHeaderNames.CONTENT_TYPE));
            if (httpRequest instanceof HttpContent) {
                offer((HttpContent) httpRequest);
                return;
            }
            this.undecodedChunk = Unpooled.buffer();
            parseBody();
            return;
        }
        throw new NullPointerException("charset");
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyMapHttpData.get(str);
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }
}
