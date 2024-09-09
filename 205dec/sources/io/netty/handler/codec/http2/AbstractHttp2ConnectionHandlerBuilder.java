package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder;
import io.netty.handler.codec.http2.Http2ConnectionHandler;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractHttp2ConnectionHandlerBuilder<T extends Http2ConnectionHandler, B extends AbstractHttp2ConnectionHandlerBuilder<T, B>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS);
    private static final Http2HeadersEncoder.SensitivityDetector DEFAULT_HEADER_SENSITIVITY_DETECTOR = Http2HeadersEncoder.NEVER_SENSITIVE;
    private Http2Connection connection;
    private Http2ConnectionDecoder decoder;
    private Http2ConnectionEncoder encoder;
    private Boolean encoderEnforceMaxConcurrentStreams;
    private Http2FrameListener frameListener;
    private Http2FrameLogger frameLogger;
    private Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector;
    private Boolean isServer;
    private Boolean validateHeaders;
    private Http2Settings initialSettings = new Http2Settings();
    private long gracefulShutdownTimeoutMillis = DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS;

    private T buildFromCodec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        try {
            T build = build(http2ConnectionDecoder, http2ConnectionEncoder, this.initialSettings);
            build.gracefulShutdownTimeoutMillis(this.gracefulShutdownTimeoutMillis);
            if (build.decoder().frameListener() == null) {
                build.decoder().frameListener(this.frameListener);
            }
            return build;
        } catch (Throwable th) {
            http2ConnectionEncoder.close();
            http2ConnectionDecoder.close();
            throw new IllegalStateException("failed to build a Http2ConnectionHandler", th);
        }
    }

    private T buildFromConnection(Http2Connection http2Connection) {
        Http2FrameReader defaultHttp2FrameReader = new DefaultHttp2FrameReader(isValidateHeaders());
        Http2FrameWriter defaultHttp2FrameWriter = new DefaultHttp2FrameWriter(headerSensitivityDetector());
        Http2FrameLogger http2FrameLogger = this.frameLogger;
        if (http2FrameLogger != null) {
            Http2FrameReader http2InboundFrameLogger = new Http2InboundFrameLogger(defaultHttp2FrameReader, http2FrameLogger);
            defaultHttp2FrameWriter = new Http2OutboundFrameLogger(defaultHttp2FrameWriter, this.frameLogger);
            defaultHttp2FrameReader = http2InboundFrameLogger;
        }
        Http2ConnectionEncoder defaultHttp2ConnectionEncoder = new DefaultHttp2ConnectionEncoder(http2Connection, defaultHttp2FrameWriter);
        boolean encoderEnforceMaxConcurrentStreams = encoderEnforceMaxConcurrentStreams();
        if (encoderEnforceMaxConcurrentStreams) {
            if (!http2Connection.isServer()) {
                defaultHttp2ConnectionEncoder = new StreamBufferingEncoder(defaultHttp2ConnectionEncoder);
            } else {
                defaultHttp2ConnectionEncoder.close();
                defaultHttp2FrameReader.close();
                throw new IllegalArgumentException("encoderEnforceMaxConcurrentStreams: " + encoderEnforceMaxConcurrentStreams + " not supported for server");
            }
        }
        return buildFromCodec(new DefaultHttp2ConnectionDecoder(http2Connection, defaultHttp2ConnectionEncoder, defaultHttp2FrameReader), defaultHttp2ConnectionEncoder);
    }

    private static void enforceConstraint(String str, String str2, Object obj) {
        if (obj == null) {
            return;
        }
        throw new IllegalStateException(str + "() cannot be called because " + str2 + "() has been called already.");
    }

    private void enforceNonCodecConstraints(String str) {
        enforceConstraint(str, "server/connection", this.decoder);
        enforceConstraint(str, "server/connection", this.encoder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T build() {
        Http2ConnectionEncoder http2ConnectionEncoder = this.encoder;
        if (http2ConnectionEncoder != null) {
            return buildFromCodec(this.decoder, http2ConnectionEncoder);
        }
        Http2Connection http2Connection = this.connection;
        if (http2Connection == null) {
            http2Connection = new DefaultHttp2Connection(isServer());
        }
        return buildFromConnection(http2Connection);
    }

    protected abstract T build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public B codec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        enforceConstraint("codec", "server", this.isServer);
        enforceConstraint("codec", "connection", this.connection);
        enforceConstraint("codec", "frameLogger", this.frameLogger);
        enforceConstraint("codec", "validateHeaders", this.validateHeaders);
        enforceConstraint("codec", "headerSensitivityDetector", this.headerSensitivityDetector);
        enforceConstraint("codec", "encoderEnforceMaxConcurrentStreams", this.encoderEnforceMaxConcurrentStreams);
        ObjectUtil.checkNotNull(http2ConnectionDecoder, "decoder");
        ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        if (http2ConnectionDecoder.connection() == http2ConnectionEncoder.connection()) {
            this.decoder = http2ConnectionDecoder;
            this.encoder = http2ConnectionEncoder;
            return self();
        }
        throw new IllegalArgumentException("The specified encoder and decoder have different connections.");
    }

    protected Http2Connection connection() {
        return this.connection;
    }

    protected Http2ConnectionDecoder decoder() {
        return this.decoder;
    }

    protected Http2ConnectionEncoder encoder() {
        return this.encoder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean encoderEnforceMaxConcurrentStreams() {
        Boolean bool = this.encoderEnforceMaxConcurrentStreams;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    protected Http2FrameListener frameListener() {
        return this.frameListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Http2FrameLogger frameLogger() {
        return this.frameLogger;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long gracefulShutdownTimeoutMillis() {
        return this.gracefulShutdownTimeoutMillis;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector() {
        Http2HeadersEncoder.SensitivityDetector sensitivityDetector = this.headerSensitivityDetector;
        return sensitivityDetector != null ? sensitivityDetector : DEFAULT_HEADER_SENSITIVITY_DETECTOR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Http2Settings initialSettings() {
        return this.initialSettings;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isServer() {
        Boolean bool = this.isServer;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isValidateHeaders() {
        Boolean bool = this.validateHeaders;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    protected final B self() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B server(boolean z3) {
        enforceConstraint("server", "connection", this.connection);
        enforceConstraint("server", "codec", this.decoder);
        enforceConstraint("server", "codec", this.encoder);
        this.isServer = Boolean.valueOf(z3);
        return self();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B validateHeaders(boolean z3) {
        enforceNonCodecConstraints("validateHeaders");
        this.validateHeaders = Boolean.valueOf(z3);
        return self();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B connection(Http2Connection http2Connection) {
        enforceConstraint("connection", "server", this.isServer);
        enforceConstraint("connection", "codec", this.decoder);
        enforceConstraint("connection", "codec", this.encoder);
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        return self();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B encoderEnforceMaxConcurrentStreams(boolean z3) {
        enforceNonCodecConstraints("encoderEnforceMaxConcurrentStreams");
        this.encoderEnforceMaxConcurrentStreams = Boolean.valueOf(z3);
        return self();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B frameListener(Http2FrameListener http2FrameListener) {
        this.frameListener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, "frameListener");
        return self();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B frameLogger(Http2FrameLogger http2FrameLogger) {
        enforceNonCodecConstraints("frameLogger");
        this.frameLogger = (Http2FrameLogger) ObjectUtil.checkNotNull(http2FrameLogger, "frameLogger");
        return self();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B gracefulShutdownTimeoutMillis(long j4) {
        this.gracefulShutdownTimeoutMillis = j4;
        return self();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        enforceNonCodecConstraints("headerSensitivityDetector");
        this.headerSensitivityDetector = (Http2HeadersEncoder.SensitivityDetector) ObjectUtil.checkNotNull(sensitivityDetector, "headerSensitivityDetector");
        return self();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public B initialSettings(Http2Settings http2Settings) {
        this.initialSettings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "settings");
        return self();
    }
}
