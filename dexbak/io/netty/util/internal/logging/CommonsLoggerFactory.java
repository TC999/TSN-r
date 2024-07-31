package io.netty.util.internal.logging;

import org.apache.commons.logging.LogFactory;

@Deprecated
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class CommonsLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new CommonsLoggerFactory();

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return new CommonsLogger(LogFactory.getLog(str), str);
    }
}
