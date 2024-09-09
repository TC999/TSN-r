package com.qq.e.comm.plugin.i0;

import com.qq.e.comm.util.GDTLogger;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class j implements b {
    public abstract void a(com.qq.e.comm.plugin.i0.n.f fVar, int i4, Exception exc);

    @Override // com.qq.e.comm.plugin.i0.b
    public final void a(com.qq.e.comm.plugin.i0.n.f fVar, Exception exc) {
        int i4;
        if (exc instanceof SocketTimeoutException) {
            i4 = 3002;
            GDTLogger.e("\u7f51\u7edc\u8d85\u65f6\uff1a\u7f51\u7edc\u8bf7\u6c42\u51fa\u73b0\u5f02\u5e38" + exc.getMessage());
        } else if (exc instanceof UnknownHostException) {
            i4 = 3003;
            GDTLogger.e("\u7f51\u7edc\u4e0d\u53ef\u7528\uff1a\u7f51\u7edc\u8bf7\u6c42\u51fa\u73b0\u5f02\u5e38" + exc.getMessage());
        } else if (exc instanceof ConnectException) {
            i4 = 3001;
            GDTLogger.e("\u7f51\u7edc\u5f02\u5e38\uff1a\u7f51\u7edc\u8bf7\u6c42\u51fa\u73b0\u5f02\u5e38" + exc.getMessage());
        } else if (exc instanceof SSLHandshakeException) {
            i4 = 3004;
            GDTLogger.e("\u7f51\u7edc\u5f02\u5e38\uff1a\u7f51\u7edc\u8bf7\u6c42\u51fa\u73b0\u5f02\u5e38" + exc.getMessage());
        } else {
            i4 = 3000;
            GDTLogger.e("\u7f51\u7edc\u5f02\u5e38\uff1a\u7f51\u7edc\u8bf7\u6c42\u51fa\u73b0\u5f02\u5e38" + exc.getMessage());
        }
        a(fVar, i4, exc);
    }
}
