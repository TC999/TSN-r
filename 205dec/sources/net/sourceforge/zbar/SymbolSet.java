package net.sourceforge.zbar;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SymbolSet extends AbstractCollection<Symbol> {
    private long peer;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SymbolSet(long j4) {
        this.peer = j4;
    }

    private native void destroy(long j4);

    private native long firstSymbol(long j4);

    private static native void init();

    public synchronized void destroy() {
        long j4 = this.peer;
        if (j4 != 0) {
            destroy(j4);
            this.peer = 0L;
        }
    }

    protected void finalize() {
        destroy();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Symbol> iterator() {
        long firstSymbol = firstSymbol(this.peer);
        if (firstSymbol == 0) {
            return new d(null);
        }
        return new d(new Symbol(firstSymbol));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public native int size();
}
