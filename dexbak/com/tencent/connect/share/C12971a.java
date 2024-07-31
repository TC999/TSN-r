package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13071m;
import com.tencent.open.utils.InterfaceC13056d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.share.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12971a {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final boolean m15283b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            SLog.m15128e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e);
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || i3 == -1 || i4 == -1) {
            return false;
        }
        int i5 = i3 > i4 ? i3 : i4;
        if (i3 >= i4) {
            i3 = i4;
        }
        SLog.m15131d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i5 + "shortSide=" + i3);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i5 > i2 || i3 > i;
    }

    /* renamed from: a */
    public static final void m15290a(final Context context, final String str, final InterfaceC13056d interfaceC13056d) {
        SLog.m15127i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            interfaceC13056d.mo15039a(1, (String) null);
        } else if (!C13071m.m14971a()) {
            interfaceC13056d.mo15039a(2, (String) null);
        } else {
            final Handler handler = new Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 101) {
                        interfaceC13056d.mo15038a(0, (ArrayList) message.obj);
                    } else if (i != 102) {
                        super.handleMessage(message);
                    } else {
                        interfaceC13056d.mo15039a(message.arg1, (String) null);
                    }
                }
            };
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    String str3;
                    try {
                        Bitmap m15286a = C12971a.m15286a(str, 840);
                        if (m15286a != null) {
                            File m15025a = C13061g.m15025a("Images");
                            String str4 = null;
                            if (m15025a != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(m15025a.getAbsolutePath());
                                String str5 = File.separator;
                                sb.append(str5);
                                sb.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb.append(str5);
                                str3 = sb.toString();
                                str2 = null;
                            } else {
                                File m15022d = C13061g.m15022d();
                                if (m15022d == null) {
                                    SLog.m15127i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                    Message obtainMessage = handler.obtainMessage();
                                    obtainMessage.arg1 = 102;
                                    handler.sendMessage(obtainMessage);
                                    return;
                                }
                                String absolutePath = m15022d.getAbsolutePath();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(absolutePath);
                                String str6 = File.separator;
                                sb2.append(str6);
                                sb2.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb2.append(str6);
                                String sb3 = sb2.toString();
                                SLog.m15127i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + sb3);
                                str2 = absolutePath;
                                str3 = sb3;
                            }
                            String str7 = "share2qq_temp" + C13071m.m14924g(str) + ".jpg";
                            String str8 = str;
                            if (!C12971a.m15283b(str8, 840, 840)) {
                                SLog.m15127i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                            } else {
                                SLog.m15127i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                String m15288a = C12971a.m15288a(m15286a, str3, str7);
                                if (!TextUtils.isEmpty(m15288a)) {
                                    str8 = m15288a;
                                }
                            }
                            boolean m14916m = C13071m.m14916m(str8);
                            SLog.m15127i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + m14916m);
                            ArrayList arrayList = new ArrayList(2);
                            if (m14916m) {
                                str4 = str8;
                            } else if (TextUtils.isEmpty(str2)) {
                                String str9 = str3 + str7;
                                boolean m14965a = C13071m.m14965a(context, str8, str9);
                                SLog.m15127i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str9 + ",isSuccess=" + m14965a);
                                if (m14965a) {
                                    str4 = str9;
                                }
                            }
                            arrayList.add(str8);
                            arrayList.add(str4);
                            if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                                SLog.m15127i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + "]");
                                Message obtainMessage2 = handler.obtainMessage(101);
                                obtainMessage2.obj = arrayList;
                                handler.sendMessage(obtainMessage2);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        SLog.m15128e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e);
                    }
                    SLog.m15131d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                    Message obtainMessage3 = handler.obtainMessage(102);
                    obtainMessage3.arg1 = 3;
                    handler.sendMessage(obtainMessage3);
                }
            }).start();
        }
    }

    /* renamed from: a */
    private static Bitmap m15289a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = i / width;
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: b */
    private static int m15284b(BitmapFactory.Options options, int i, int i2) {
        int ceil;
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        if (i2 == -1) {
            ceil = 1;
        } else {
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = i2;
            Double.isNaN(d3);
            ceil = (int) Math.ceil(Math.sqrt((d * d2) / d3));
        }
        if (i == -1) {
            min = 128;
        } else {
            double d4 = i;
            Double.isNaN(d);
            Double.isNaN(d4);
            double floor = Math.floor(d / d4);
            Double.isNaN(d2);
            Double.isNaN(d4);
            min = (int) Math.min(floor, Math.floor(d2 / d4));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? ceil : min;
    }

    /* renamed from: a */
    protected static final String m15288a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        File file2 = new File(stringBuffer2);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return stringBuffer2;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap m15286a(java.lang.String r6, int r7) {
        /*
            java.lang.String r0 = "openSDK_LOG.AsynScaleCompressImage"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r3 = 1
            r1.inJustDecodeBounds = r3
            android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L16
            goto L1c
        L16:
            r3 = move-exception
            java.lang.String r4 = "scaleBitmap exception1:"
            com.tencent.open.log.SLog.m15128e(r0, r4, r3)
        L1c:
            int r3 = r1.outWidth
            int r4 = r1.outHeight
            boolean r5 = r1.mCancel
            if (r5 != 0) goto L69
            r5 = -1
            if (r3 == r5) goto L69
            if (r4 != r5) goto L2a
            goto L69
        L2a:
            if (r3 <= r4) goto L2d
            goto L2e
        L2d:
            r3 = r4
        L2e:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            r1.inPreferredConfig = r4
            if (r3 <= r7) goto L3c
            int r3 = r7 * r7
            int r3 = m15287a(r1, r5, r3)
            r1.inSampleSize = r3
        L3c:
            r3 = 0
            r1.inJustDecodeBounds = r3
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L44 java.lang.Exception -> L4b
            goto L52
        L44:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap OutOfMemoryError:"
            com.tencent.open.log.SLog.m15128e(r0, r3, r6)
            goto L51
        L4b:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap exception2:"
            com.tencent.open.log.SLog.m15128e(r0, r3, r6)
        L51:
            r6 = r2
        L52:
            if (r6 != 0) goto L5a
            java.lang.String r6 = "scaleBitmap return null"
            com.tencent.open.log.SLog.m15129e(r0, r6)
            return r2
        L5a:
            int r0 = r1.outWidth
            int r1 = r1.outHeight
            if (r0 <= r1) goto L61
            goto L62
        L61:
            r0 = r1
        L62:
            if (r0 <= r7) goto L68
            android.graphics.Bitmap r6 = m15289a(r6, r7)
        L68:
            return r6
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.C12971a.m15286a(java.lang.String, int):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static final int m15287a(BitmapFactory.Options options, int i, int i2) {
        int m15284b = m15284b(options, i, i2);
        if (m15284b <= 8) {
            int i3 = 1;
            while (i3 < m15284b) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((m15284b + 7) / 8) * 8;
    }
}
