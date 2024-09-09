package io.netty.handler.codec.http.websocketx;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class WebSocketDecoderConfig {
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private final boolean closeOnProtocolViolation;
    private final boolean expectMaskedFrames;
    private final int maxFramePayloadLength;

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean allowExtensions() {
        return this.allowExtensions;
    }

    public boolean allowMaskMismatch() {
        return this.allowMaskMismatch;
    }

    public boolean closeOnProtocolViolation() {
        return this.closeOnProtocolViolation;
    }

    public boolean expectMaskedFrames() {
        return this.expectMaskedFrames;
    }

    public int maxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public String toString() {
        return "WebSocketDecoderConfig [maxFramePayloadLength=" + this.maxFramePayloadLength + ", expectMaskedFrames=" + this.expectMaskedFrames + ", allowMaskMismatch=" + this.allowMaskMismatch + ", allowExtensions=" + this.allowExtensions + ", closeOnProtocolViolation=" + this.closeOnProtocolViolation + "]";
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class Builder {
        private boolean allowExtensions;
        private boolean allowMaskMismatch;
        private boolean closeOnProtocolViolation;
        private boolean expectMaskedFrames;
        private int maxFramePayloadLength;

        public Builder allowExtensions(boolean z3) {
            this.allowExtensions = z3;
            return this;
        }

        public Builder allowMaskMismatch(boolean z3) {
            this.allowMaskMismatch = z3;
            return this;
        }

        public WebSocketDecoderConfig build() {
            return new WebSocketDecoderConfig(this.maxFramePayloadLength, this.expectMaskedFrames, this.allowMaskMismatch, this.allowExtensions, this.closeOnProtocolViolation);
        }

        public Builder closeOnProtocolViolation(boolean z3) {
            this.closeOnProtocolViolation = z3;
            return this;
        }

        public Builder expectMaskedFrames(boolean z3) {
            this.expectMaskedFrames = z3;
            return this;
        }

        public Builder maxFramePayloadLength(int i4) {
            this.maxFramePayloadLength = i4;
            return this;
        }

        private Builder() {
            this.maxFramePayloadLength = 65536;
            this.expectMaskedFrames = true;
            this.closeOnProtocolViolation = true;
        }

        private Builder(WebSocketDecoderConfig webSocketDecoderConfig) {
            this.maxFramePayloadLength = 65536;
            this.expectMaskedFrames = true;
            this.closeOnProtocolViolation = true;
            ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
            this.maxFramePayloadLength = webSocketDecoderConfig.maxFramePayloadLength();
            this.expectMaskedFrames = webSocketDecoderConfig.expectMaskedFrames();
            this.allowMaskMismatch = webSocketDecoderConfig.allowMaskMismatch();
            this.allowExtensions = webSocketDecoderConfig.allowExtensions();
            this.closeOnProtocolViolation = webSocketDecoderConfig.closeOnProtocolViolation();
        }
    }

    private WebSocketDecoderConfig(int i4, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.maxFramePayloadLength = i4;
        this.expectMaskedFrames = z3;
        this.allowMaskMismatch = z4;
        this.allowExtensions = z5;
        this.closeOnProtocolViolation = z6;
    }
}
