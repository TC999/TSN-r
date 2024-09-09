package org.apache.harmony.awt;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import org.apache.harmony.awt.datatransfer.DTK;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ContextStorage {
    private static final ContextStorage globalContext = new ContextStorage();
    private DTK dtk;
    private GraphicsEnvironment graphicsEnvironment;
    private Toolkit toolkit;
    private volatile boolean shutdownPending = false;
    private final Object contextLock = new ContextLock(this, null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class ContextLock {
        private ContextLock() {
        }

        /* synthetic */ ContextLock(ContextStorage contextStorage, ContextLock contextLock) {
            this();
        }
    }

    public static Object getContextLock() {
        return getCurrentContext().contextLock;
    }

    private static ContextStorage getCurrentContext() {
        return globalContext;
    }

    public static DTK getDTK() {
        return getCurrentContext().dtk;
    }

    public static Toolkit getDefaultToolkit() {
        return getCurrentContext().toolkit;
    }

    public static GraphicsEnvironment getGraphicsEnvironment() {
        return getCurrentContext().graphicsEnvironment;
    }

    public static void setDTK(DTK dtk) {
        getCurrentContext().dtk = dtk;
    }

    public static void setDefaultToolkit(Toolkit toolkit) {
        getCurrentContext().toolkit = toolkit;
    }

    public static void setGraphicsEnvironment(GraphicsEnvironment graphicsEnvironment) {
        getCurrentContext().graphicsEnvironment = graphicsEnvironment;
    }

    public static boolean shutdownPending() {
        return getCurrentContext().shutdownPending;
    }

    void shutdown() {
    }
}
