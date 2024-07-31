package net.sourceforge.zbar;

import java.util.AbstractCollection;
import java.util.Iterator;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SymbolSet extends AbstractCollection<Symbol> {
    private long peer;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SymbolSet(long j) {
        this.peer = j;
    }

    private native void destroy(long j);

    private native long firstSymbol(long j);

    private static native void init();

    public synchronized void destroy() {
        long j = this.peer;
        if (j != 0) {
            destroy(j);
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
            return new SymbolIterator(null);
        }
        return new SymbolIterator(new Symbol(firstSymbol));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public native int size();
}
