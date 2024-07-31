package io.netty.handler.codec.http;

import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class HttpMessageUtil {
    private HttpMessageUtil() {
    }

    private static void appendCommon(StringBuilder sb, HttpMessage httpMessage) {
        sb.append(StringUtil.simpleClassName(httpMessage));
        sb.append("(decodeResult: ");
        sb.append(httpMessage.decoderResult());
        sb.append(", version: ");
        sb.append(httpMessage.protocolVersion());
        sb.append(')');
        sb.append(StringUtil.NEWLINE);
    }

    private static void appendFullCommon(StringBuilder sb, FullHttpMessage fullHttpMessage) {
        sb.append(StringUtil.simpleClassName(fullHttpMessage));
        sb.append("(decodeResult: ");
        sb.append(fullHttpMessage.decoderResult());
        sb.append(", version: ");
        sb.append(fullHttpMessage.protocolVersion());
        sb.append(", content: ");
        sb.append(fullHttpMessage.content());
        sb.append(')');
        sb.append(StringUtil.NEWLINE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendFullRequest(StringBuilder sb, FullHttpRequest fullHttpRequest) {
        appendFullCommon(sb, fullHttpRequest);
        appendInitialLine(sb, fullHttpRequest);
        appendHeaders(sb, fullHttpRequest.headers());
        appendHeaders(sb, fullHttpRequest.trailingHeaders());
        removeLastNewLine(sb);
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendFullResponse(StringBuilder sb, FullHttpResponse fullHttpResponse) {
        appendFullCommon(sb, fullHttpResponse);
        appendInitialLine(sb, fullHttpResponse);
        appendHeaders(sb, fullHttpResponse.headers());
        appendHeaders(sb, fullHttpResponse.trailingHeaders());
        removeLastNewLine(sb);
        return sb;
    }

    private static void appendHeaders(StringBuilder sb, HttpHeaders httpHeaders) {
        Iterator<Map.Entry<String, String>> it = httpHeaders.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append(": ");
            sb.append(next.getValue());
            sb.append(StringUtil.NEWLINE);
        }
    }

    private static void appendInitialLine(StringBuilder sb, HttpRequest httpRequest) {
        sb.append(httpRequest.method());
        sb.append(HttpConstants.SP_CHAR);
        sb.append(httpRequest.uri());
        sb.append(HttpConstants.SP_CHAR);
        sb.append(httpRequest.protocolVersion());
        sb.append(StringUtil.NEWLINE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendRequest(StringBuilder sb, HttpRequest httpRequest) {
        appendCommon(sb, httpRequest);
        appendInitialLine(sb, httpRequest);
        appendHeaders(sb, httpRequest.headers());
        removeLastNewLine(sb);
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendResponse(StringBuilder sb, HttpResponse httpResponse) {
        appendCommon(sb, httpResponse);
        appendInitialLine(sb, httpResponse);
        appendHeaders(sb, httpResponse.headers());
        removeLastNewLine(sb);
        return sb;
    }

    private static void removeLastNewLine(StringBuilder sb) {
        sb.setLength(sb.length() - StringUtil.NEWLINE.length());
    }

    private static void appendInitialLine(StringBuilder sb, HttpResponse httpResponse) {
        sb.append(httpResponse.protocolVersion());
        sb.append(HttpConstants.SP_CHAR);
        sb.append(httpResponse.status());
        sb.append(StringUtil.NEWLINE);
    }
}
