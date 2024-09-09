package com.umeng.socialize.c.b;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ImageFormat.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f53993a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f53994b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f53995c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f53996d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f53997e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f53998f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f53999g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f54000h = 7;

    /* renamed from: i  reason: collision with root package name */
    public static final int f54001i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static final int f54002j = 9;

    /* renamed from: k  reason: collision with root package name */
    public static final int f54003k = 10;

    /* renamed from: l  reason: collision with root package name */
    public static final int f54004l = 11;

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f54005m = {"jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf"};

    public static String a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    int read = byteArrayInputStream2.read();
                    int read2 = byteArrayInputStream2.read();
                    if (read == 71 && read2 == 73) {
                        String str = f54005m[1];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e4) {
                            SLog.error(UmengText.IMAGE.CLOSE, e4);
                        }
                        return str;
                    } else if (read == 137 && read2 == 80) {
                        String str2 = f54005m[2];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e5) {
                            SLog.error(UmengText.IMAGE.CLOSE, e5);
                        }
                        return str2;
                    } else if (read == 255 && read2 == 216) {
                        String str3 = f54005m[0];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e6) {
                            SLog.error(UmengText.IMAGE.CLOSE, e6);
                        }
                        return str3;
                    } else if (read == 66 && read2 == 77) {
                        String str4 = f54005m[3];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e7) {
                            SLog.error(UmengText.IMAGE.CLOSE, e7);
                        }
                        return str4;
                    } else if (read == 10 && read2 < 6) {
                        String str5 = f54005m[4];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e8) {
                            SLog.error(UmengText.IMAGE.CLOSE, e8);
                        }
                        return str5;
                    } else if (read == 70 && read2 == 79) {
                        String str6 = f54005m[5];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e9) {
                            SLog.error(UmengText.IMAGE.CLOSE, e9);
                        }
                        return str6;
                    } else if (read == 89 && read2 == 166) {
                        String str7 = f54005m[6];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e10) {
                            SLog.error(UmengText.IMAGE.CLOSE, e10);
                        }
                        return str7;
                    } else if (read == 80 && read2 >= 49 && read2 <= 54) {
                        int i4 = read2 - 48;
                        if (i4 >= 1 && i4 <= 6) {
                            String str8 = f54005m[new int[]{7, 8, 9}[(i4 - 1) % 3]];
                            try {
                                byteArrayInputStream2.close();
                            } catch (IOException e11) {
                                SLog.error(UmengText.IMAGE.CLOSE, e11);
                            }
                            return str8;
                        }
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e12) {
                            SLog.error(UmengText.IMAGE.CLOSE, e12);
                        }
                        return "";
                    } else if (read == 56 && read2 == 66) {
                        String str9 = f54005m[10];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e13) {
                            SLog.error(UmengText.IMAGE.CLOSE, e13);
                        }
                        return str9;
                    } else if (read == 70 && read2 == 87) {
                        String str10 = f54005m[11];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e14) {
                            SLog.error(UmengText.IMAGE.CLOSE, e14);
                        }
                        return str10;
                    } else {
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e15) {
                            SLog.error(UmengText.IMAGE.CLOSE, e15);
                        }
                        return "";
                    }
                } catch (Exception e16) {
                    e = e16;
                    byteArrayInputStream = byteArrayInputStream2;
                    SLog.error(UmengText.IMAGE.CHECK_FORMAT_ERROR, e);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e17) {
                            SLog.error(UmengText.IMAGE.CLOSE, e17);
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e18) {
                            SLog.error(UmengText.IMAGE.CLOSE, e18);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e19) {
            e = e19;
        }
    }
}
