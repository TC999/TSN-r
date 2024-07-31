package com.mbridge.msdk.foundation.same.net.p485f;

import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;

/* renamed from: com.mbridge.msdk.foundation.same.net.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonHttpConfig {
    /* renamed from: a */
    public static String m22259a(CommonError commonError) {
        if (commonError == null) {
            return "Network error,Load failed";
        }
        try {
            int i = commonError.f30690a;
            NetworkResponse networkResponse = commonError.f30691b;
            int i2 = networkResponse != null ? networkResponse.f30751a : 0;
            if (i != -2) {
                switch (i) {
                    case 1:
                        return "Network error,Load failed";
                    case 2:
                        return "Network error,I/O exception";
                    case 3:
                        return "Network error,timeout exception";
                    case 4:
                        return "Network unknown error";
                    case 5:
                        return "Network error，https is not work,please check your phone time";
                    case 6:
                        if (i2 != 0) {
                            return "Network error,please check state code " + i2;
                        }
                        return "Network error,please check ";
                    case 7:
                        if (i2 != 0) {
                            return "The server returns an exception state code " + i2;
                        }
                        return "The server returns an exception ";
                    case 8:
                        return "Cast exception, return data can not be casted correctly";
                    case 9:
                        return "Network error,UnknownHostException";
                    case 10:
                        return "Network error,socket timeout exception";
                    case 11:
                        return "Network error，sslp exception";
                    case 12:
                        return "Network error,ConnectException";
                    case 13:
                        if (networkResponse != null) {
                            byte[] bArr = networkResponse.f30752b;
                            return bArr != null ? new String(bArr) : "Socket exception message is NULL";
                        }
                        return "Unknown socket exception";
                    default:
                        return "Network error,unknown";
                }
            }
            return "Network is canceled";
        } catch (Exception e) {
            e.printStackTrace();
            return "Network error,Load failed";
        }
    }
}
