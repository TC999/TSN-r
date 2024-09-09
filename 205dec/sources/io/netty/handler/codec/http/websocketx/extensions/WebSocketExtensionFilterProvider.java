package io.netty.handler.codec.http.websocketx.extensions;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface WebSocketExtensionFilterProvider {
    public static final WebSocketExtensionFilterProvider DEFAULT = new WebSocketExtensionFilterProvider() { // from class: io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider.1
        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider
        public WebSocketExtensionFilter decoderFilter() {
            return WebSocketExtensionFilter.NEVER_SKIP;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider
        public WebSocketExtensionFilter encoderFilter() {
            return WebSocketExtensionFilter.NEVER_SKIP;
        }
    };

    WebSocketExtensionFilter decoderFilter();

    WebSocketExtensionFilter encoderFilter();
}
