package xyz.adscope.common.network.connect;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Network {
    public static final Network DEFAULT = new Network() { // from class: xyz.adscope.common.network.connect.Network.1
        @Override // xyz.adscope.common.network.connect.Network
        public boolean isAvailable() {
            return true;
        }
    };

    boolean isAvailable();
}
