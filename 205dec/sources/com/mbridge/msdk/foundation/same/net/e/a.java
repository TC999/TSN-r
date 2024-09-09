package com.mbridge.msdk.foundation.same.net.e;

import android.os.SystemClock;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.g;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.x;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: BasicNetwork.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39539a = "a";

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.net.stack.a f39540b;

    /* renamed from: c  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.net.c f39541c;

    public a(com.mbridge.msdk.foundation.same.net.stack.a aVar, com.mbridge.msdk.foundation.same.net.c cVar) {
        this.f39540b = aVar;
        this.f39541c = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    @Override // com.mbridge.msdk.foundation.same.net.g
    public final c a(i<?> iVar) throws com.mbridge.msdk.foundation.same.net.a.a {
        String str;
        String str2;
        String str3;
        String str4;
        byte[] bArr;
        b bVar;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i4;
        b bVar2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        l m4 = iVar != null ? iVar.m() : null;
        byte[] bArr2 = "UnknownHostException ex= ";
        String str10 = "perform-discard-cancelled";
        if ((m4 != null ? m4.a() : 0) <= 0) {
            if (!iVar.c()) {
                try {
                    try {
                        try {
                            iVar.f();
                            b performRequest = this.f39540b.performRequest(iVar);
                            try {
                                int a4 = performRequest.a();
                                byte[] a5 = iVar.a(performRequest, this.f39541c);
                                try {
                                    str7 = "SocketTimeoutException ex= ";
                                    str6 = "UnknownHostException ex= ";
                                    str5 = "ConnectTimeoutException ex= ";
                                    str9 = "IOException ex= ";
                                    str8 = "ConnectException ex= ";
                                    bVar2 = performRequest;
                                    i4 = 15;
                                    try {
                                        try {
                                            a(SystemClock.elapsedRealtime() - elapsedRealtime, iVar, a5, a4);
                                            try {
                                                if (a4 >= 200 && a4 <= 399) {
                                                    return new c(a4, a5, bVar2.b());
                                                }
                                                throw new IOException();
                                            } catch (IOException e4) {
                                                e = e4;
                                                a(str9 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                                if (bVar2 != null) {
                                                    int a6 = bVar2.a();
                                                    if (bArr2 != 0) {
                                                        c cVar = new c(a6, bArr2, bVar2.b());
                                                        if (a6 < 400 || a6 > 499) {
                                                            if (a6 >= 500 && a6 <= 599) {
                                                                throw new com.mbridge.msdk.foundation.same.net.a.a(7, cVar);
                                                            }
                                                            throw new com.mbridge.msdk.foundation.same.net.a.a(2, cVar);
                                                        }
                                                        throw new com.mbridge.msdk.foundation.same.net.a.a(6, cVar);
                                                    }
                                                    throw new com.mbridge.msdk.foundation.same.net.a.a(i4, null);
                                                }
                                                throw new com.mbridge.msdk.foundation.same.net.a.a(14, null);
                                            }
                                        } catch (ConnectException e5) {
                                            e = e5;
                                            a(str8 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                            throw new com.mbridge.msdk.foundation.same.net.a.a(12, null);
                                        } catch (SocketTimeoutException e6) {
                                            e = e6;
                                            a(str7 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                            throw new com.mbridge.msdk.foundation.same.net.a.a(10, null);
                                        } catch (UnknownHostException e7) {
                                            e = e7;
                                            a(str6 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                            throw new com.mbridge.msdk.foundation.same.net.a.a(9, null);
                                        } catch (ConnectTimeoutException e8) {
                                            e = e8;
                                            a(str5 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                            throw new com.mbridge.msdk.foundation.same.net.a.a(3, null);
                                        }
                                    } catch (IOException e9) {
                                        e = e9;
                                        bArr2 = a5;
                                    }
                                } catch (IOException e10) {
                                    e = e10;
                                    bArr2 = a5;
                                    str9 = "IOException ex= ";
                                    bVar2 = performRequest;
                                    i4 = 15;
                                }
                            } catch (IOException e11) {
                                e = e11;
                                str9 = "IOException ex= ";
                                bVar2 = performRequest;
                                i4 = 15;
                                bArr2 = 0;
                            }
                        } catch (ConnectException e12) {
                            e = e12;
                            str8 = "ConnectException ex= ";
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            str7 = "SocketTimeoutException ex= ";
                        } catch (UnknownHostException e14) {
                            e = e14;
                            str6 = "UnknownHostException ex= ";
                        } catch (ConnectTimeoutException e15) {
                            e = e15;
                            str5 = "ConnectTimeoutException ex= ";
                        }
                    } catch (MalformedURLException e16) {
                        a("MalformedURLException ex= " + e16.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                        throw new com.mbridge.msdk.foundation.same.net.a.a(4, null);
                    } catch (SSLProtocolException e17) {
                        a("SSLProtocolException ex= " + e17.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                        throw new com.mbridge.msdk.foundation.same.net.a.a(11, null);
                    }
                } catch (IOException e18) {
                    e = e18;
                    str9 = "IOException ex= ";
                    i4 = 15;
                    bArr2 = 0;
                    bVar2 = null;
                }
            } else {
                iVar.a("perform-discard-cancelled");
                this.f39541c.b(iVar);
                throw new com.mbridge.msdk.foundation.same.net.a.a(-2, null);
            }
        } else {
            String str11 = "ConnectException ex= ";
            String str12 = "SocketTimeoutException ex= ";
            String str13 = "ConnectTimeoutException ex= ";
            while (!iVar.c()) {
                try {
                    try {
                        try {
                            iVar.f();
                            b performRequest2 = this.f39540b.performRequest(iVar);
                            try {
                                int a7 = performRequest2.a();
                                bArr = iVar.a(performRequest2, this.f39541c);
                                try {
                                    bVar = performRequest2;
                                    str2 = str12;
                                    str = str13;
                                    str3 = str11;
                                    str4 = str10;
                                    try {
                                        try {
                                            a(SystemClock.elapsedRealtime() - elapsedRealtime, iVar, bArr, a7);
                                            try {
                                                if (a7 >= 200 && a7 <= 399) {
                                                    return new c(a7, bArr, bVar.b());
                                                }
                                                throw new IOException();
                                            } catch (IOException e19) {
                                                e = e19;
                                                a("IOException ex= " + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                                if (bVar != null) {
                                                    int a8 = bVar.a();
                                                    if (bArr != null) {
                                                        c cVar2 = new c(a8, bArr, bVar.b());
                                                        if (a8 < 400 || a8 > 499) {
                                                            if (a8 >= 500 && a8 <= 599) {
                                                                throw new com.mbridge.msdk.foundation.same.net.a.a(7, cVar2);
                                                            }
                                                            throw new com.mbridge.msdk.foundation.same.net.a.a(2, cVar2);
                                                        }
                                                        throw new com.mbridge.msdk.foundation.same.net.a.a(6, cVar2);
                                                    }
                                                    com.mbridge.msdk.foundation.same.net.a.a aVar = new com.mbridge.msdk.foundation.same.net.a.a(15, null);
                                                    if (iVar.m().a(aVar)) {
                                                        this.f39541c.e(iVar);
                                                        str12 = str2;
                                                        str13 = str;
                                                        str11 = str3;
                                                        str10 = str4;
                                                    } else {
                                                        throw aVar;
                                                    }
                                                } else {
                                                    throw new com.mbridge.msdk.foundation.same.net.a.a(14, null);
                                                }
                                            }
                                        } catch (ConnectException e20) {
                                            e = e20;
                                            a(str3 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                            throw new com.mbridge.msdk.foundation.same.net.a.a(12, null);
                                        } catch (SocketTimeoutException e21) {
                                            e = e21;
                                            a(str2 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                            throw new com.mbridge.msdk.foundation.same.net.a.a(10, null);
                                        } catch (ConnectTimeoutException e22) {
                                            e = e22;
                                            a(str + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                                            throw new com.mbridge.msdk.foundation.same.net.a.a(3, null);
                                        }
                                    } catch (IOException e23) {
                                        e = e23;
                                        bArr = bArr;
                                    }
                                } catch (IOException e24) {
                                    e = e24;
                                    bVar = performRequest2;
                                    str2 = str12;
                                    str = str13;
                                    str3 = str11;
                                    str4 = str10;
                                }
                            } catch (IOException e25) {
                                e = e25;
                                bVar = performRequest2;
                                str2 = str12;
                                str = str13;
                                str3 = str11;
                                str4 = str10;
                                bArr = null;
                            }
                        } catch (MalformedURLException e26) {
                            a("MalformedURLException ex= " + e26.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                            throw new com.mbridge.msdk.foundation.same.net.a.a(4, null);
                        } catch (UnknownHostException e27) {
                            a("UnknownHostException ex= " + e27.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                            throw new com.mbridge.msdk.foundation.same.net.a.a(9, null);
                        } catch (SSLProtocolException e28) {
                            a("SSLProtocolException ex= " + e28.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                            throw new com.mbridge.msdk.foundation.same.net.a.a(11, null);
                        }
                    } catch (ConnectException e29) {
                        e = e29;
                        str3 = str11;
                    } catch (SocketTimeoutException e30) {
                        e = e30;
                        str2 = str12;
                    } catch (ConnectTimeoutException e31) {
                        e = e31;
                        str = str13;
                    }
                } catch (IOException e32) {
                    e = e32;
                    str2 = str12;
                    str = str13;
                    str3 = str11;
                    str4 = str10;
                    bArr = null;
                    bVar = null;
                }
            }
            iVar.a(str10);
            this.f39541c.b(iVar);
            throw new com.mbridge.msdk.foundation.same.net.a.a(-2, null);
        }
    }

    private void a(long j4, i<?> iVar, byte[] bArr, int i4) {
        if (MBridgeConstans.DEBUG) {
            try {
                if (j4 > 3000) {
                    String str = f39539a;
                    Object[] objArr = new Object[6];
                    objArr[0] = iVar.b();
                    objArr[1] = Integer.valueOf(iVar.a());
                    objArr[2] = Long.valueOf(j4);
                    objArr[3] = bArr != null ? Integer.valueOf(bArr.length) : "null";
                    objArr[4] = Integer.valueOf(i4);
                    objArr[5] = Integer.valueOf(iVar.m().c());
                    x.b(str, String.format("Slow HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", objArr));
                    return;
                }
                String str2 = f39539a;
                Object[] objArr2 = new Object[6];
                objArr2[0] = iVar.b();
                objArr2[1] = Integer.valueOf(iVar.a());
                objArr2[2] = Long.valueOf(j4);
                objArr2[3] = bArr != null ? Integer.valueOf(bArr.length) : "null";
                objArr2[4] = Integer.valueOf(i4);
                objArr2[5] = Integer.valueOf(iVar.m().c());
                x.b(str2, String.format("Normal HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", objArr2));
            } catch (Exception unused) {
            }
        }
    }

    private void a(String str, long j4, i<?> iVar) {
        if (MBridgeConstans.DEBUG) {
            try {
                String str2 = f39539a;
                Object[] objArr = new Object[4];
                objArr[0] = iVar.b();
                objArr[1] = Long.valueOf(j4);
                if (str == null) {
                    str = "null";
                }
                objArr[2] = str;
                objArr[3] = Integer.valueOf(iVar.m().c());
                x.b(str2, String.format("HTTP exception for request=<%s> [lifetime=%d], [size=%s], [retryCount=%s]", objArr));
            } catch (Exception unused) {
            }
        }
    }
}
