package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {
    public static File a(Context context, boolean z3) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i4 = 0; i4 < length; i4++) {
                Object obj = Array.get(invoke, i4);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z3 == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                    return new File(str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Environment.getExternalStorageDirectory();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr3[i4] = (byte) i4;
        }
        if (bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < 256; i7++) {
                i6 = ((bArr2[i5] & 255) + (bArr3[i7] & 255) + i6) & 255;
                byte b4 = bArr3[i7];
                bArr3[i7] = bArr3[i6];
                bArr3[i6] = b4;
                i5 = (i5 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            i8 = (i8 + 1) & 255;
            i9 = ((bArr3[i8] & 255) + i9) & 255;
            byte b5 = bArr3[i8];
            bArr3[i8] = bArr3[i9];
            bArr3[i9] = b5;
            bArr4[i10] = (byte) (bArr3[((bArr3[i8] & 255) + (bArr3[i9] & 255)) & 255] ^ bArr[i10]);
            bArr4[i10] = (byte) (bArr4[i10] ^ 42);
        }
        return bArr4;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    return a(bArr, bArr2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    return a(bArr, bArr2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
