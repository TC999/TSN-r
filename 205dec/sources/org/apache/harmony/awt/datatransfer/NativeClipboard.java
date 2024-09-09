package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.Clipboard;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class NativeClipboard extends Clipboard {
    protected static final int OPS_TIMEOUT = 10000;

    public NativeClipboard(String str) {
        super(str);
    }

    public void onRestart() {
    }

    public void onShutdown() {
    }
}
