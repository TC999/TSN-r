package com.bytedance.sdk.component.ux.xv.c.c;

import android.util.Log;
import com.bytedance.sdk.component.ux.xv.c.c.c;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bytedance.sdk.component.ux.xv {

    /* renamed from: c  reason: collision with root package name */
    private long f30277c;

    /* renamed from: w  reason: collision with root package name */
    private c f30278w;

    public w(File file, long j4, ExecutorService executorService) {
        this.f30277c = j4;
        try {
            this.f30278w = c.c(file, 20210302, 1, j4, executorService);
        } catch (IOException e4) {
            Log.w("LruCountDiskCache", e4.toString());
        }
    }

    @Override // com.bytedance.sdk.component.ux.c
    /* renamed from: xv */
    public boolean w(String str) {
        try {
            try {
                c.xv c4 = this.f30278w.c(str);
                boolean z3 = c4 != null;
                com.bytedance.sdk.component.ux.xv.xv.w.c(c4);
                return z3;
            } catch (IOException e4) {
                Log.w("LruCountDiskCache", e4.getMessage());
                com.bytedance.sdk.component.ux.xv.xv.w.c(null);
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.ux.xv.xv.w.c(null);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.ux.c
    /* renamed from: w  reason: avoid collision after fix types in other method */
    public byte[] c(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        c cVar = this.f30278w;
        InputStream inputStream2 = null;
        if (cVar == null || str == null) {
            return null;
        }
        try {
            c.xv c4 = cVar.c(str);
            if (c4 == null) {
                com.bytedance.sdk.component.ux.xv.xv.w.c(null);
                com.bytedance.sdk.component.ux.xv.xv.w.c(null);
                return null;
            }
            inputStream = c4.c(0);
            if (inputStream != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e4) {
                    e = e4;
                    byteArrayOutputStream = null;
                    Log.w("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
                    com.bytedance.sdk.component.ux.xv.xv.w.c(byteArrayOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream2);
                    com.bytedance.sdk.component.ux.xv.xv.w.c(byteArrayOutputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream2);
                        com.bytedance.sdk.component.ux.xv.xv.w.c(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    Log.w("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
                    com.bytedance.sdk.component.ux.xv.xv.w.c(byteArrayOutputStream);
                    return null;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
            com.bytedance.sdk.component.ux.xv.xv.w.c(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e6) {
            e = e6;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream2);
            com.bytedance.sdk.component.ux.xv.xv.w.c(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.ux.xv
    public InputStream c(String str) {
        c cVar = this.f30278w;
        if (cVar == null) {
            return null;
        }
        try {
            c.xv c4 = cVar.c(str);
            if (c4 != null) {
                return c4.c(0);
            }
        } catch (IOException e4) {
            Log.w("LruCountDiskCache", e4.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ux.c
    public boolean c(String str, byte[] bArr) {
        Closeable closeable;
        c cVar = this.f30278w;
        if (cVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        c.C0453c c0453c = null;
        try {
            try {
                c.C0453c w3 = cVar.w(str);
                try {
                    if (w3 == null) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.ux.xv.xv.w.c(null);
                        return false;
                    }
                    OutputStream c4 = w3.c(0);
                    if (c4 == c.xv) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.ux.xv.xv.w.c(c4);
                        return false;
                    }
                    c4.write(bArr);
                    w3.c();
                    this.f30278w.c();
                    com.bytedance.sdk.component.ux.xv.xv.w.c(c4);
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    closeable = null;
                    c0453c = w3;
                    try {
                        Log.w("LruCountDiskCache", e.toString());
                        if (c0453c != null) {
                            try {
                                c0453c.w();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.ux.xv.xv.w.c(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        com.bytedance.sdk.component.ux.xv.xv.w.c(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.ux.xv.xv.w.c(closeable2);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            closeable = null;
        }
    }

    @Override // com.bytedance.sdk.component.ux.c
    public void c(double d4) {
        c cVar = this.f30278w;
        double d5 = this.f30277c;
        Double.isNaN(d5);
        cVar.c((long) (d5 * d4));
    }
}
