package net.sourceforge.zbar;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SymbolIterator.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d implements Iterator<Symbol> {

    /* renamed from: a  reason: collision with root package name */
    private Symbol f61567a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Symbol symbol) {
        this.f61567a = symbol;
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public Symbol next() {
        Symbol symbol = this.f61567a;
        if (symbol != null) {
            long next = symbol.next();
            if (next != 0) {
                this.f61567a = new Symbol(next);
            } else {
                this.f61567a = null;
            }
            return symbol;
        }
        throw new NoSuchElementException("access past end of SymbolIterator");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f61567a != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("SymbolIterator is immutable");
    }
}
