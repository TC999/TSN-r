package com.bytedance.sdk.component.xv.w;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ys {

    /* renamed from: c  reason: collision with root package name */
    public static final ys f31128c = new ys() { // from class: com.bytedance.sdk.component.xv.w.ys.1
        @Override // com.bytedance.sdk.component.xv.w.ys
        public List<InetAddress> c(String str) throws UnknownHostException {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (Throwable unused) {
                    return new ArrayList();
                }
            }
            throw new UnknownHostException("hostname == null");
        }
    };

    List<InetAddress> c(String str) throws UnknownHostException;
}
