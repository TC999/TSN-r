package io.netty.channel.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class SelectedSelectionKeySetSelector extends Selector {
    private final Selector delegate;
    private final SelectedSelectionKeySet selectionKeys;

    SelectedSelectionKeySetSelector(Selector selector, SelectedSelectionKeySet selectedSelectionKeySet) {
        this.delegate = selector;
        this.selectionKeys = selectedSelectionKeySet;
    }

    @Override // java.nio.channels.Selector, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // java.nio.channels.Selector
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // java.nio.channels.Selector
    public Set<SelectionKey> keys() {
        return this.delegate.keys();
    }

    @Override // java.nio.channels.Selector
    public SelectorProvider provider() {
        return this.delegate.provider();
    }

    @Override // java.nio.channels.Selector
    public int select(long j4) throws IOException {
        this.selectionKeys.reset();
        return this.delegate.select(j4);
    }

    @Override // java.nio.channels.Selector
    public int selectNow() throws IOException {
        this.selectionKeys.reset();
        return this.delegate.selectNow();
    }

    @Override // java.nio.channels.Selector
    public Set<SelectionKey> selectedKeys() {
        return this.delegate.selectedKeys();
    }

    @Override // java.nio.channels.Selector
    public Selector wakeup() {
        return this.delegate.wakeup();
    }

    @Override // java.nio.channels.Selector
    public int select() throws IOException {
        this.selectionKeys.reset();
        return this.delegate.select();
    }
}
