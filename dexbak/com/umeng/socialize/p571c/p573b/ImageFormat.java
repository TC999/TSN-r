package com.umeng.socialize.p571c.p573b;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* renamed from: com.umeng.socialize.c.b.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImageFormat {

    /* renamed from: a */
    public static final int f39406a = 0;

    /* renamed from: b */
    public static final int f39407b = 1;

    /* renamed from: c */
    public static final int f39408c = 2;

    /* renamed from: d */
    public static final int f39409d = 3;

    /* renamed from: e */
    public static final int f39410e = 4;

    /* renamed from: f */
    public static final int f39411f = 5;

    /* renamed from: g */
    public static final int f39412g = 6;

    /* renamed from: h */
    public static final int f39413h = 7;

    /* renamed from: i */
    public static final int f39414i = 8;

    /* renamed from: j */
    public static final int f39415j = 9;

    /* renamed from: k */
    public static final int f39416k = 10;

    /* renamed from: l */
    public static final int f39417l = 11;

    /* renamed from: m */
    public static final String[] f39418m = {"jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf"};

    /* renamed from: a */
    public static String m13291a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    int read = byteArrayInputStream2.read();
                    int read2 = byteArrayInputStream2.read();
                    if (read == 71 && read2 == 73) {
                        String str = f39418m[1];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e) {
                            SLog.error(UmengText.IMAGE.CLOSE, e);
                        }
                        return str;
                    } else if (read == 137 && read2 == 80) {
                        String str2 = f39418m[2];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e2) {
                            SLog.error(UmengText.IMAGE.CLOSE, e2);
                        }
                        return str2;
                    } else if (read == 255 && read2 == 216) {
                        String str3 = f39418m[0];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e3) {
                            SLog.error(UmengText.IMAGE.CLOSE, e3);
                        }
                        return str3;
                    } else if (read == 66 && read2 == 77) {
                        String str4 = f39418m[3];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e4) {
                            SLog.error(UmengText.IMAGE.CLOSE, e4);
                        }
                        return str4;
                    } else if (read == 10 && read2 < 6) {
                        String str5 = f39418m[4];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e5) {
                            SLog.error(UmengText.IMAGE.CLOSE, e5);
                        }
                        return str5;
                    } else if (read == 70 && read2 == 79) {
                        String str6 = f39418m[5];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e6) {
                            SLog.error(UmengText.IMAGE.CLOSE, e6);
                        }
                        return str6;
                    } else if (read == 89 && read2 == 166) {
                        String str7 = f39418m[6];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e7) {
                            SLog.error(UmengText.IMAGE.CLOSE, e7);
                        }
                        return str7;
                    } else if (read == 80 && read2 >= 49 && read2 <= 54) {
                        int i = read2 - 48;
                        if (i >= 1 && i <= 6) {
                            String str8 = f39418m[new int[]{7, 8, 9}[(i - 1) % 3]];
                            try {
                                byteArrayInputStream2.close();
                            } catch (IOException e8) {
                                SLog.error(UmengText.IMAGE.CLOSE, e8);
                            }
                            return str8;
                        }
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e9) {
                            SLog.error(UmengText.IMAGE.CLOSE, e9);
                        }
                        return "";
                    } else if (read == 56 && read2 == 66) {
                        String str9 = f39418m[10];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e10) {
                            SLog.error(UmengText.IMAGE.CLOSE, e10);
                        }
                        return str9;
                    } else if (read == 70 && read2 == 87) {
                        String str10 = f39418m[11];
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e11) {
                            SLog.error(UmengText.IMAGE.CLOSE, e11);
                        }
                        return str10;
                    } else {
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e12) {
                            SLog.error(UmengText.IMAGE.CLOSE, e12);
                        }
                        return "";
                    }
                } catch (Exception e13) {
                    e = e13;
                    byteArrayInputStream = byteArrayInputStream2;
                    SLog.error(UmengText.IMAGE.CHECK_FORMAT_ERROR, e);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e14) {
                            SLog.error(UmengText.IMAGE.CLOSE, e14);
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e15) {
                            SLog.error(UmengText.IMAGE.CLOSE, e15);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e16) {
            e = e16;
        }
    }
}
