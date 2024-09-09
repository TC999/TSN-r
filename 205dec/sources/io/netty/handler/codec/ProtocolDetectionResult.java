package io.netty.handler.codec;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ProtocolDetectionResult<T> {
    private final T result;
    private final ProtocolDetectionState state;
    private static final ProtocolDetectionResult NEEDS_MORE_DATE = new ProtocolDetectionResult(ProtocolDetectionState.NEEDS_MORE_DATA, null);
    private static final ProtocolDetectionResult INVALID = new ProtocolDetectionResult(ProtocolDetectionState.INVALID, null);

    private ProtocolDetectionResult(ProtocolDetectionState protocolDetectionState, T t3) {
        this.state = protocolDetectionState;
        this.result = t3;
    }

    public static <T> ProtocolDetectionResult<T> detected(T t3) {
        return new ProtocolDetectionResult<>(ProtocolDetectionState.DETECTED, ObjectUtil.checkNotNull(t3, "protocol"));
    }

    public static <T> ProtocolDetectionResult<T> invalid() {
        return INVALID;
    }

    public static <T> ProtocolDetectionResult<T> needsMoreData() {
        return NEEDS_MORE_DATE;
    }

    public T detectedProtocol() {
        return this.result;
    }

    public ProtocolDetectionState state() {
        return this.state;
    }
}
