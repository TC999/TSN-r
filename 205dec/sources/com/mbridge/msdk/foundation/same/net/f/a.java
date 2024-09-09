package com.mbridge.msdk.foundation.same.net.f;

/* compiled from: CommonHttpConfig.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static String a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        if (aVar == null) {
            return "Network error,Load failed";
        }
        try {
            int i4 = aVar.f39484a;
            com.mbridge.msdk.foundation.same.net.e.c cVar = aVar.f39485b;
            int i5 = cVar != null ? cVar.f39545a : 0;
            if (i4 != -2) {
                switch (i4) {
                    case 1:
                        return "Network error,Load failed";
                    case 2:
                        return "Network error,I/O exception";
                    case 3:
                        return "Network error,timeout exception";
                    case 4:
                        return "Network unknown error";
                    case 5:
                        return "Network error\uff0chttps is not work,please check your phone time";
                    case 6:
                        if (i5 != 0) {
                            return "Network error,please check state code " + i5;
                        }
                        return "Network error,please check ";
                    case 7:
                        if (i5 != 0) {
                            return "The server returns an exception state code " + i5;
                        }
                        return "The server returns an exception ";
                    case 8:
                        return "Cast exception, return data can not be casted correctly";
                    case 9:
                        return "Network error,UnknownHostException";
                    case 10:
                        return "Network error,socket timeout exception";
                    case 11:
                        return "Network error\uff0csslp exception";
                    case 12:
                        return "Network error,ConnectException";
                    case 13:
                        if (cVar != null) {
                            byte[] bArr = cVar.f39546b;
                            return bArr != null ? new String(bArr) : "Socket exception message is NULL";
                        }
                        return "Unknown socket exception";
                    default:
                        return "Network error,unknown";
                }
            }
            return "Network is canceled";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "Network error,Load failed";
        }
    }
}
