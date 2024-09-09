package io.netty.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface BooleanSupplier {
    public static final BooleanSupplier FALSE_SUPPLIER = new BooleanSupplier() { // from class: io.netty.util.BooleanSupplier.1
        @Override // io.netty.util.BooleanSupplier
        public boolean get() {
            return false;
        }
    };
    public static final BooleanSupplier TRUE_SUPPLIER = new BooleanSupplier() { // from class: io.netty.util.BooleanSupplier.2
        @Override // io.netty.util.BooleanSupplier
        public boolean get() {
            return true;
        }
    };

    boolean get() throws Exception;
}
