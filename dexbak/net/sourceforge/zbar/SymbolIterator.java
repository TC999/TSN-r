package net.sourceforge.zbar;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: net.sourceforge.zbar.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SymbolIterator implements Iterator<Symbol> {

    /* renamed from: a */
    private Symbol f44153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SymbolIterator(Symbol symbol) {
        this.f44153a = symbol;
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public Symbol next() {
        Symbol symbol = this.f44153a;
        if (symbol != null) {
            long next = symbol.next();
            if (next != 0) {
                this.f44153a = new Symbol(next);
            } else {
                this.f44153a = null;
            }
            return symbol;
        }
        throw new NoSuchElementException("access past end of SymbolIterator");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44153a != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("SymbolIterator is immutable");
    }
}
