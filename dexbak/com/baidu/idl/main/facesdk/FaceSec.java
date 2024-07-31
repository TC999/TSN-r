package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceSec {
    public static final String TAG = "FaceSec";
    public byte[] value;

    private native String decrypt(String str);

    private native String encrypt(String str);

    private native int init(AssetManager assetManager);

    private native String sec(byte[] bArr);

    /* renamed from: d */
    public String m51133d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return decrypt(str);
    }

    /* renamed from: e */
    public String m51131e(byte[] bArr) {
        return sec(bArr);
    }

    /* renamed from: i */
    public int m51130i(Context context) {
        if (context != null) {
            try {
                int init = init(context.getAssets());
                if (init == 0) {
                    return init;
                }
                throw new RuntimeException("face sdk init sec error");
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: e */
    public String m51132e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return encrypt(str);
    }
}
