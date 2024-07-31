package com.mbridge.msdk.foundation.same.net.p484e;

import android.os.SystemClock;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.AbstractC11354i;
import com.mbridge.msdk.foundation.same.net.Delivery;
import com.mbridge.msdk.foundation.same.net.Network;
import com.mbridge.msdk.foundation.same.net.RetryPolicy;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.stack.HttpStack;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

/* renamed from: com.mbridge.msdk.foundation.same.net.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BasicNetwork implements Network {

    /* renamed from: a */
    private static final String f30745a = "a";

    /* renamed from: b */
    private HttpStack f30746b;

    /* renamed from: c */
    private Delivery f30747c;

    public BasicNetwork(HttpStack httpStack, Delivery delivery) {
        this.f30746b = httpStack;
        this.f30747c = delivery;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    @Override // com.mbridge.msdk.foundation.same.net.Network
    /* renamed from: a */
    public final NetworkResponse mo22237a(AbstractC11354i<?> abstractC11354i) throws CommonError {
        String str;
        String str2;
        String str3;
        String str4;
        byte[] bArr;
        C11348b c11348b;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i;
        C11348b c11348b2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        RetryPolicy m22186m = abstractC11354i != null ? abstractC11354i.m22186m() : null;
        byte[] bArr2 = "UnknownHostException ex= ";
        String str10 = "perform-discard-cancelled";
        if ((m22186m != null ? m22186m.mo22174a() : 0) <= 0) {
            if (!abstractC11354i.m22196c()) {
                try {
                    try {
                        try {
                            abstractC11354i.m22193f();
                            C11348b performRequest = this.f30746b.performRequest(abstractC11354i);
                            try {
                                int m22271a = performRequest.m22271a();
                                byte[] mo22206a = abstractC11354i.mo22206a(performRequest, this.f30747c);
                                try {
                                    str7 = "SocketTimeoutException ex= ";
                                    str6 = "UnknownHostException ex= ";
                                    str5 = "ConnectTimeoutException ex= ";
                                    str9 = "IOException ex= ";
                                    str8 = "ConnectException ex= ";
                                    c11348b2 = performRequest;
                                    i = 15;
                                    try {
                                        try {
                                            m22273a(SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i, mo22206a, m22271a);
                                            try {
                                                if (m22271a >= 200 && m22271a <= 399) {
                                                    return new NetworkResponse(m22271a, mo22206a, c11348b2.m22270b());
                                                }
                                                throw new IOException();
                                            } catch (IOException e) {
                                                e = e;
                                                m22272a(str9 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                                if (c11348b2 != null) {
                                                    int m22271a2 = c11348b2.m22271a();
                                                    if (bArr2 != 0) {
                                                        NetworkResponse networkResponse = new NetworkResponse(m22271a2, bArr2, c11348b2.m22270b());
                                                        if (m22271a2 < 400 || m22271a2 > 499) {
                                                            if (m22271a2 >= 500 && m22271a2 <= 599) {
                                                                throw new CommonError(7, networkResponse);
                                                            }
                                                            throw new CommonError(2, networkResponse);
                                                        }
                                                        throw new CommonError(6, networkResponse);
                                                    }
                                                    throw new CommonError(i, null);
                                                }
                                                throw new CommonError(14, null);
                                            }
                                        } catch (ConnectException e2) {
                                            e = e2;
                                            m22272a(str8 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                            throw new CommonError(12, null);
                                        } catch (SocketTimeoutException e3) {
                                            e = e3;
                                            m22272a(str7 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                            throw new CommonError(10, null);
                                        } catch (UnknownHostException e4) {
                                            e = e4;
                                            m22272a(str6 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                            throw new CommonError(9, null);
                                        } catch (ConnectTimeoutException e5) {
                                            e = e5;
                                            m22272a(str5 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                            throw new CommonError(3, null);
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                        bArr2 = mo22206a;
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    bArr2 = mo22206a;
                                    str9 = "IOException ex= ";
                                    c11348b2 = performRequest;
                                    i = 15;
                                }
                            } catch (IOException e8) {
                                e = e8;
                                str9 = "IOException ex= ";
                                c11348b2 = performRequest;
                                i = 15;
                                bArr2 = 0;
                            }
                        } catch (ConnectException e9) {
                            e = e9;
                            str8 = "ConnectException ex= ";
                        } catch (SocketTimeoutException e10) {
                            e = e10;
                            str7 = "SocketTimeoutException ex= ";
                        } catch (UnknownHostException e11) {
                            e = e11;
                            str6 = "UnknownHostException ex= ";
                        } catch (ConnectTimeoutException e12) {
                            e = e12;
                            str5 = "ConnectTimeoutException ex= ";
                        }
                    } catch (MalformedURLException e13) {
                        m22272a("MalformedURLException ex= " + e13.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                        throw new CommonError(4, null);
                    } catch (SSLProtocolException e14) {
                        m22272a("SSLProtocolException ex= " + e14.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                        throw new CommonError(11, null);
                    }
                } catch (IOException e15) {
                    e = e15;
                    str9 = "IOException ex= ";
                    i = 15;
                    bArr2 = 0;
                    c11348b2 = null;
                }
            } else {
                abstractC11354i.m22200a("perform-discard-cancelled");
                this.f30747c.mo22285b(abstractC11354i);
                throw new CommonError(-2, null);
            }
        } else {
            String str11 = "ConnectException ex= ";
            String str12 = "SocketTimeoutException ex= ";
            String str13 = "ConnectTimeoutException ex= ";
            while (!abstractC11354i.m22196c()) {
                try {
                    try {
                        try {
                            abstractC11354i.m22193f();
                            C11348b performRequest2 = this.f30746b.performRequest(abstractC11354i);
                            try {
                                int m22271a3 = performRequest2.m22271a();
                                bArr = abstractC11354i.mo22206a(performRequest2, this.f30747c);
                                try {
                                    c11348b = performRequest2;
                                    str2 = str12;
                                    str = str13;
                                    str3 = str11;
                                    str4 = str10;
                                    try {
                                        try {
                                            m22273a(SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i, bArr, m22271a3);
                                            try {
                                                if (m22271a3 >= 200 && m22271a3 <= 399) {
                                                    return new NetworkResponse(m22271a3, bArr, c11348b.m22270b());
                                                }
                                                throw new IOException();
                                            } catch (IOException e16) {
                                                e = e16;
                                                m22272a("IOException ex= " + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                                if (c11348b != null) {
                                                    int m22271a4 = c11348b.m22271a();
                                                    if (bArr != null) {
                                                        NetworkResponse networkResponse2 = new NetworkResponse(m22271a4, bArr, c11348b.m22270b());
                                                        if (m22271a4 < 400 || m22271a4 > 499) {
                                                            if (m22271a4 >= 500 && m22271a4 <= 599) {
                                                                throw new CommonError(7, networkResponse2);
                                                            }
                                                            throw new CommonError(2, networkResponse2);
                                                        }
                                                        throw new CommonError(6, networkResponse2);
                                                    }
                                                    CommonError commonError = new CommonError(15, null);
                                                    if (abstractC11354i.m22186m().mo22173a(commonError)) {
                                                        this.f30747c.mo22282e(abstractC11354i);
                                                        str12 = str2;
                                                        str13 = str;
                                                        str11 = str3;
                                                        str10 = str4;
                                                    } else {
                                                        throw commonError;
                                                    }
                                                } else {
                                                    throw new CommonError(14, null);
                                                }
                                            }
                                        } catch (ConnectException e17) {
                                            e = e17;
                                            m22272a(str3 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                            throw new CommonError(12, null);
                                        } catch (SocketTimeoutException e18) {
                                            e = e18;
                                            m22272a(str2 + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                            throw new CommonError(10, null);
                                        } catch (ConnectTimeoutException e19) {
                                            e = e19;
                                            m22272a(str + e.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                                            throw new CommonError(3, null);
                                        }
                                    } catch (IOException e20) {
                                        e = e20;
                                        bArr = bArr;
                                    }
                                } catch (IOException e21) {
                                    e = e21;
                                    c11348b = performRequest2;
                                    str2 = str12;
                                    str = str13;
                                    str3 = str11;
                                    str4 = str10;
                                }
                            } catch (IOException e22) {
                                e = e22;
                                c11348b = performRequest2;
                                str2 = str12;
                                str = str13;
                                str3 = str11;
                                str4 = str10;
                                bArr = null;
                            }
                        } catch (MalformedURLException e23) {
                            m22272a("MalformedURLException ex= " + e23.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                            throw new CommonError(4, null);
                        } catch (UnknownHostException e24) {
                            m22272a("UnknownHostException ex= " + e24.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                            throw new CommonError(9, null);
                        } catch (SSLProtocolException e25) {
                            m22272a("SSLProtocolException ex= " + e25.getMessage(), SystemClock.elapsedRealtime() - elapsedRealtime, abstractC11354i);
                            throw new CommonError(11, null);
                        }
                    } catch (ConnectException e26) {
                        e = e26;
                        str3 = str11;
                    } catch (SocketTimeoutException e27) {
                        e = e27;
                        str2 = str12;
                    } catch (ConnectTimeoutException e28) {
                        e = e28;
                        str = str13;
                    }
                } catch (IOException e29) {
                    e = e29;
                    str2 = str12;
                    str = str13;
                    str3 = str11;
                    str4 = str10;
                    bArr = null;
                    c11348b = null;
                }
            }
            abstractC11354i.m22200a(str10);
            this.f30747c.mo22285b(abstractC11354i);
            throw new CommonError(-2, null);
        }
    }

    /* renamed from: a */
    private void m22273a(long j, AbstractC11354i<?> abstractC11354i, byte[] bArr, int i) {
        if (MBridgeConstans.DEBUG) {
            try {
                if (j > 3000) {
                    String str = f30745a;
                    Object[] objArr = new Object[6];
                    objArr[0] = abstractC11354i.m22198b();
                    objArr[1] = Integer.valueOf(abstractC11354i.m22211a());
                    objArr[2] = Long.valueOf(j);
                    objArr[3] = bArr != null ? Integer.valueOf(bArr.length) : "null";
                    objArr[4] = Integer.valueOf(i);
                    objArr[5] = Integer.valueOf(abstractC11354i.m22186m().mo22171c());
                    SameLogTool.m21736b(str, String.format("Slow HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", objArr));
                    return;
                }
                String str2 = f30745a;
                Object[] objArr2 = new Object[6];
                objArr2[0] = abstractC11354i.m22198b();
                objArr2[1] = Integer.valueOf(abstractC11354i.m22211a());
                objArr2[2] = Long.valueOf(j);
                objArr2[3] = bArr != null ? Integer.valueOf(bArr.length) : "null";
                objArr2[4] = Integer.valueOf(i);
                objArr2[5] = Integer.valueOf(abstractC11354i.m22186m().mo22171c());
                SameLogTool.m21736b(str2, String.format("Normal HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", objArr2));
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m22272a(String str, long j, AbstractC11354i<?> abstractC11354i) {
        if (MBridgeConstans.DEBUG) {
            try {
                String str2 = f30745a;
                Object[] objArr = new Object[4];
                objArr[0] = abstractC11354i.m22198b();
                objArr[1] = Long.valueOf(j);
                if (str == null) {
                    str = "null";
                }
                objArr[2] = str;
                objArr[3] = Integer.valueOf(abstractC11354i.m22186m().mo22171c());
                SameLogTool.m21736b(str2, String.format("HTTP exception for request=<%s> [lifetime=%d], [size=%s], [retryCount=%s]", objArr));
            } catch (Exception unused) {
            }
        }
    }
}
