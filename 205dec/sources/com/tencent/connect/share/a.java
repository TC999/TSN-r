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
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str, int i4, int i5) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e4) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e4);
        }
        int i6 = options.outWidth;
        int i7 = options.outHeight;
        if (options.mCancel || i6 == -1 || i7 == -1) {
            return false;
        }
        int i8 = i6 > i7 ? i6 : i7;
        if (i6 >= i7) {
            i6 = i7;
        }
        SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i8 + "shortSide=" + i6);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i8 > i5 || i6 > i4;
    }

    public static final void a(final Context context, final String str, final d dVar) {
        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            dVar.a(1, (String) null);
        } else if (!m.a()) {
            dVar.a(2, (String) null);
        } else {
            final Handler handler = new Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i4 = message.what;
                    if (i4 == 101) {
                        dVar.a(0, (ArrayList) message.obj);
                    } else if (i4 != 102) {
                        super.handleMessage(message);
                    } else {
                        dVar.a(message.arg1, (String) null);
                    }
                }
            };
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    String str3;
                    try {
                        Bitmap a4 = a.a(str, 840);
                        if (a4 != null) {
                            File a5 = g.a("Images");
                            String str4 = null;
                            if (a5 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(a5.getAbsolutePath());
                                String str5 = File.separator;
                                sb.append(str5);
                                sb.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb.append(str5);
                                str3 = sb.toString();
                                str2 = null;
                            } else {
                                File d4 = g.d();
                                if (d4 == null) {
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                    Message obtainMessage = handler.obtainMessage();
                                    obtainMessage.arg1 = 102;
                                    handler.sendMessage(obtainMessage);
                                    return;
                                }
                                String absolutePath = d4.getAbsolutePath();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(absolutePath);
                                String str6 = File.separator;
                                sb2.append(str6);
                                sb2.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb2.append(str6);
                                String sb3 = sb2.toString();
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + sb3);
                                str2 = absolutePath;
                                str3 = sb3;
                            }
                            String str7 = "share2qq_temp" + m.g(str) + ".jpg";
                            String str8 = str;
                            if (!a.b(str8, 840, 840)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                            } else {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                String a6 = a.a(a4, str3, str7);
                                if (!TextUtils.isEmpty(a6)) {
                                    str8 = a6;
                                }
                            }
                            boolean m4 = m.m(str8);
                            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + m4);
                            ArrayList arrayList = new ArrayList(2);
                            if (m4) {
                                str4 = str8;
                            } else if (TextUtils.isEmpty(str2)) {
                                String str9 = str3 + str7;
                                boolean a7 = m.a(context, str8, str9);
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str9 + ",isSuccess=" + a7);
                                if (a7) {
                                    str4 = str9;
                                }
                            }
                            arrayList.add(str8);
                            arrayList.add(str4);
                            if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + "]");
                                Message obtainMessage2 = handler.obtainMessage(101);
                                obtainMessage2.obj = arrayList;
                                handler.sendMessage(obtainMessage2);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e4);
                    }
                    SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                    Message obtainMessage3 = handler.obtainMessage(102);
                    obtainMessage3.arg1 = 3;
                    handler.sendMessage(obtainMessage3);
                }
            }).start();
        }
    }

    private static Bitmap a(Bitmap bitmap, int i4) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f4 = i4 / width;
        matrix.postScale(f4, f4);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static int b(BitmapFactory.Options options, int i4, int i5) {
        int ceil;
        int min;
        double d4 = options.outWidth;
        double d5 = options.outHeight;
        if (i5 == -1) {
            ceil = 1;
        } else {
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = i5;
            Double.isNaN(d6);
            ceil = (int) Math.ceil(Math.sqrt((d4 * d5) / d6));
        }
        if (i4 == -1) {
            min = 128;
        } else {
            double d7 = i4;
            Double.isNaN(d4);
            Double.isNaN(d7);
            double floor = Math.floor(d4 / d7);
            Double.isNaN(d5);
            Double.isNaN(d7);
            min = (int) Math.min(floor, Math.floor(d5 / d7));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i5 == -1 && i4 == -1) {
            return 1;
        }
        return i4 == -1 ? ceil : min;
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
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
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                return null;
            } catch (IOException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap a(java.lang.String r6, int r7) {
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
            com.tencent.open.log.SLog.e(r0, r4, r3)
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
            int r3 = a(r1, r5, r3)
            r1.inSampleSize = r3
        L3c:
            r3 = 0
            r1.inJustDecodeBounds = r3
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L44 java.lang.Exception -> L4b
            goto L52
        L44:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap OutOfMemoryError:"
            com.tencent.open.log.SLog.e(r0, r3, r6)
            goto L51
        L4b:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap exception2:"
            com.tencent.open.log.SLog.e(r0, r3, r6)
        L51:
            r6 = r2
        L52:
            if (r6 != 0) goto L5a
            java.lang.String r6 = "scaleBitmap return null"
            com.tencent.open.log.SLog.e(r0, r6)
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
            android.graphics.Bitmap r6 = a(r6, r7)
        L68:
            return r6
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.a.a(java.lang.String, int):android.graphics.Bitmap");
    }

    public static final int a(BitmapFactory.Options options, int i4, int i5) {
        int b4 = b(options, i4, i5);
        if (b4 <= 8) {
            int i6 = 1;
            while (i6 < b4) {
                i6 <<= 1;
            }
            return i6;
        }
        return ((b4 + 7) / 8) * 8;
    }
}
