package com.amap.api.col.p0463l;

import com.amap.api.col.p0463l.DiskLruCache;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.b7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LogEngine {
    /* renamed from: a */
    public static int m55541a(LogConfig logConfig) {
        DiskLruCache diskLruCache = null;
        try {
            try {
                if (logConfig.f3559f.m53643e()) {
                    logConfig.f3559f.mo53644c(true);
                    DiskLruCache m54503b = DiskLruCache.m54503b(new File(logConfig.f3554a), logConfig.f3555b);
                    try {
                        ArrayList arrayList = new ArrayList();
                        byte[] m55537e = m55537e(m54503b, logConfig, arrayList);
                        if (m55537e != null && m55537e.length != 0) {
                            LogUpdateRequest logUpdateRequest = new LogUpdateRequest(m55537e, logConfig.f3556c);
                            BaseNetManager.m54175b();
                            JSONObject jSONObject = new JSONObject(new String(BaseNetManager.m54173d(logUpdateRequest).f5682a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                UpdateStrategy updateStrategy = logConfig.f3559f;
                                if (updateStrategy != null) {
                                    updateStrategy.mo53645b(m55537e.length);
                                }
                                if (logConfig.f3559f.mo53646a() < Integer.MAX_VALUE) {
                                    m55540b(m54503b, arrayList);
                                } else {
                                    m54503b.m54518A();
                                }
                                return m55537e.length;
                            }
                            diskLruCache = m54503b;
                        }
                        try {
                            m54503b.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        diskLruCache = m54503b;
                        try {
                            SDKLogHandler.m53863p(th, "leg", "uts");
                            if (diskLruCache != null) {
                                diskLruCache.close();
                            }
                            return -1;
                        } catch (Throwable th3) {
                            if (diskLruCache != null) {
                                try {
                                    diskLruCache.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
            if (diskLruCache != null) {
                diskLruCache.close();
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        return -1;
    }

    /* renamed from: b */
    private static void m55540b(DiskLruCache diskLruCache, List<String> list) {
        if (diskLruCache != null) {
            try {
                for (String str : list) {
                    diskLruCache.m54488r(str);
                }
                diskLruCache.close();
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "ofm", "dlo");
            }
        }
    }

    /* renamed from: c */
    public static void m55539c(String str, byte[] bArr, LogConfig logConfig) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        DiskLruCache diskLruCache;
        OutputStream outputStream = null;
        try {
            if (m55538d(logConfig.f3554a, str)) {
                return;
            }
            File file = new File(logConfig.f3554a);
            if (!file.exists()) {
                file.mkdirs();
            }
            diskLruCache = DiskLruCache.m54503b(file, logConfig.f3555b);
            try {
                diskLruCache.m54500e(logConfig.f3557d);
                byte[] m54710b = logConfig.f3558e.m54710b(bArr);
                DiskLruCache.C1856d m54494k = diskLruCache.m54494k(str);
                outputStream = m54494k.m54484b();
                outputStream.write(m54710b);
                m54494k.m54483c();
                diskLruCache.m54490p();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    diskLruCache.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (diskLruCache != null) {
                    try {
                        diskLruCache.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            diskLruCache = null;
        }
    }

    /* renamed from: d */
    private static boolean m55538d(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "leg", IAdInterListener.AdReqParam.FET);
            return false;
        }
    }

    /* renamed from: e */
    private static byte[] m55537e(DiskLruCache diskLruCache, LogConfig logConfig, List<String> list) {
        String[] list2;
        try {
            File m54493l = diskLruCache.m54493l();
            if (m54493l != null && m54493l.exists()) {
                int i = 0;
                for (String str : m54493l.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] m54744g = Utils.m54744g(diskLruCache, str2);
                        i += m54744g.length;
                        list.add(str2);
                        if (i > logConfig.f3559f.mo53646a()) {
                            break;
                        }
                        logConfig.f3560g.mo54362c(m54744g);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return logConfig.f3560g.m54363a();
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
