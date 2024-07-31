package io.netty.util.internal.logging;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLoggerFactory INSTANCE = new Slf4JLoggerFactory();

    @Deprecated
    public Slf4JLoggerFactory() {
    }

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return new Slf4JLogger(LoggerFactory.m2655j(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Slf4JLoggerFactory(boolean z) {
        final StringBuffer stringBuffer = new StringBuffer();
        PrintStream printStream = System.err;
        try {
            System.setErr(new PrintStream(new OutputStream() { // from class: io.netty.util.internal.logging.Slf4JLoggerFactory.1
                @Override // java.io.OutputStream
                public void write(int i) {
                    stringBuffer.append((char) i);
                }
            }, true, "US-ASCII"));
            try {
                if (!(LoggerFactory.m2657h() instanceof NOPLoggerFactory)) {
                    printStream.print(stringBuffer);
                    printStream.flush();
                    return;
                }
                throw new NoClassDefFoundError(stringBuffer.toString());
            } finally {
                System.setErr(printStream);
            }
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }
}
