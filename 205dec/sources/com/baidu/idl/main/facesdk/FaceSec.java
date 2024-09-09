package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceSec {
    public static final String TAG = "FaceSec";
    public byte[] value;

    private native String decrypt(String str);

    private native String encrypt(String str);

    private native int init(AssetManager assetManager);

    private native String sec(byte[] bArr);

    public String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return decrypt(str);
    }

    public String e(byte[] bArr) {
        return sec(bArr);
    }

    public int i(Context context) {
        if (context != null) {
            try {
                int init = init(context.getAssets());
                if (init == 0) {
                    return init;
                }
                throw new RuntimeException("face sdk init sec error");
            } catch (Exception e4) {
                e4.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return encrypt(str);
    }
}
