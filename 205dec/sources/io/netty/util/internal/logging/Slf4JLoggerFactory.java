package io.netty.util.internal.logging;

import java.io.OutputStream;
import l3.a;
import org.slf4j.c;
import org.slf4j.d;
import org.slf4j.helpers.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLoggerFactory INSTANCE = new Slf4JLoggerFactory();

    /* renamed from: io.netty.util.internal.logging.Slf4JLoggerFactory$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class AnonymousClass1 extends OutputStream {
        final /* synthetic */ StringBuffer val$buf;

        AnonymousClass1(StringBuffer stringBuffer) {
            this.val$buf = stringBuffer;
        }

        @Override // java.io.OutputStream
        public void write(int i4) {
            this.val$buf.append((char) i4);
        }
    }

    @Deprecated
    public Slf4JLoggerFactory() {
    }

    static InternalLogger wrapLogger(c cVar) {
        return cVar instanceof a ? new LocationAwareSlf4JLogger((a) cVar) : new Slf4JLogger(cVar);
    }

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return wrapLogger(d.j(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Slf4JLoggerFactory(boolean z3) {
        if (d.h() instanceof e) {
            throw new NoClassDefFoundError("NOPLoggerFactory not supported");
        }
    }
}
