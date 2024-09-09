package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.AsciiString;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HttpPostRequestDecoder implements InterfaceHttpPostRequestDecoder {
    static final int DEFAULT_DISCARD_THRESHOLD = 10485760;
    private final InterfaceHttpPostRequestDecoder decoder;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class EndOfDataDecoderException extends DecoderException {
        private static final long serialVersionUID = 1336267941020800769L;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ErrorDataDecoderException extends DecoderException {
        private static final long serialVersionUID = 5020247425493164465L;

        public ErrorDataDecoderException() {
        }

        public ErrorDataDecoderException(String str) {
            super(str);
        }

        public ErrorDataDecoderException(Throwable th) {
            super(th);
        }

        public ErrorDataDecoderException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum MultiPartStatus {
        NOTSTARTED,
        PREAMBLE,
        HEADERDELIMITER,
        DISPOSITION,
        FIELD,
        FILEUPLOAD,
        MIXEDPREAMBLE,
        MIXEDDELIMITER,
        MIXEDDISPOSITION,
        MIXEDFILEUPLOAD,
        MIXEDCLOSEDELIMITER,
        CLOSEDELIMITER,
        PREEPILOGUE,
        EPILOGUE
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class NotEnoughDataDecoderException extends DecoderException {
        private static final long serialVersionUID = -7846841864603865638L;

        public NotEnoughDataDecoderException() {
        }

        public NotEnoughDataDecoderException(String str) {
            super(str);
        }

        public NotEnoughDataDecoderException(Throwable th) {
            super(th);
        }

        public NotEnoughDataDecoderException(String str, Throwable th) {
            super(str, th);
        }
    }

    public HttpPostRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String[] getMultipartDataBoundary(String str) {
        char c4;
        char c5;
        String substringAfter;
        String[] splitHeaderContentType = splitHeaderContentType(str);
        if (splitHeaderContentType[0].toLowerCase().startsWith(HttpHeaderValues.MULTIPART_FORM_DATA.toString())) {
            String lowerCase = splitHeaderContentType[1].toLowerCase();
            AsciiString asciiString = HttpHeaderValues.BOUNDARY;
            if (lowerCase.startsWith(asciiString.toString())) {
                c4 = 1;
                c5 = 2;
            } else if (splitHeaderContentType[2].toLowerCase().startsWith(asciiString.toString())) {
                c4 = 2;
                c5 = 1;
            }
            String substringAfter2 = StringUtil.substringAfter(splitHeaderContentType[c4], '=');
            if (substringAfter2 != null) {
                if (substringAfter2.charAt(0) == '\"') {
                    String trim = substringAfter2.trim();
                    int length = trim.length() - 1;
                    if (trim.charAt(length) == '\"') {
                        substringAfter2 = trim.substring(1, length);
                    }
                }
                if (splitHeaderContentType[c5].toLowerCase().startsWith(HttpHeaderValues.CHARSET.toString()) && (substringAfter = StringUtil.substringAfter(splitHeaderContentType[c5], '=')) != null) {
                    return new String[]{"--" + substringAfter2, substringAfter};
                }
                return new String[]{"--" + substringAfter2};
            }
            throw new ErrorDataDecoderException("Needs a boundary value");
        }
        return null;
    }

    public static boolean isMultipart(HttpRequest httpRequest) {
        HttpHeaders headers = httpRequest.headers();
        AsciiString asciiString = HttpHeaderNames.CONTENT_TYPE;
        return headers.contains(asciiString) && getMultipartDataBoundary(httpRequest.headers().get(asciiString)) != null;
    }

    private static String[] splitHeaderContentType(String str) {
        int findNonWhitespace = HttpPostBodyUtil.findNonWhitespace(str, 0);
        int indexOf = str.indexOf(59);
        if (indexOf == -1) {
            return new String[]{str, "", ""};
        }
        int findNonWhitespace2 = HttpPostBodyUtil.findNonWhitespace(str, indexOf + 1);
        if (str.charAt(indexOf - 1) == ' ') {
            indexOf--;
        }
        int indexOf2 = str.indexOf(59, findNonWhitespace2);
        if (indexOf2 == -1) {
            return new String[]{str.substring(findNonWhitespace, indexOf), str.substring(findNonWhitespace2, HttpPostBodyUtil.findEndOfString(str)), ""};
        }
        int findNonWhitespace3 = HttpPostBodyUtil.findNonWhitespace(str, indexOf2 + 1);
        if (str.charAt(indexOf2 - 1) == ' ') {
            indexOf2--;
        }
        return new String[]{str.substring(findNonWhitespace, indexOf), str.substring(findNonWhitespace2, indexOf2), str.substring(findNonWhitespace3, HttpPostBodyUtil.findEndOfString(str))};
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        this.decoder.cleanFiles();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData currentPartialHttpData() {
        return this.decoder.currentPartialHttpData();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        this.decoder.destroy();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData getBodyHttpData(String str) {
        return this.decoder.getBodyHttpData(str);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas() {
        return this.decoder.getBodyHttpDatas();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.decoder.getDiscardThreshold();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean hasNext() {
        return this.decoder.hasNext();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData next() {
        return this.decoder.next();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpPostRequestDecoder offer(HttpContent httpContent) {
        return this.decoder.offer(httpContent);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        this.decoder.removeHttpDataFromClean(interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void setDiscardThreshold(int i4) {
        this.decoder.setDiscardThreshold(i4);
    }

    public HttpPostRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        return this.decoder.getBodyHttpDatas(str);
    }

    public HttpPostRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) {
        if (httpDataFactory == null) {
            throw new NullPointerException("factory");
        }
        if (httpRequest == null) {
            throw new NullPointerException("request");
        }
        if (charset != null) {
            if (isMultipart(httpRequest)) {
                this.decoder = new HttpPostMultipartRequestDecoder(httpDataFactory, httpRequest, charset);
                return;
            } else {
                this.decoder = new HttpPostStandardRequestDecoder(httpDataFactory, httpRequest, charset);
                return;
            }
        }
        throw new NullPointerException("charset");
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean isMultipart() {
        return this.decoder.isMultipart();
    }
}
