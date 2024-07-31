package com.baidu.idl.main.facesdk.test;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PaddleLiteTest {
    Context context;

    static {
        try {
            System.loadLibrary("bdface_sdk");
            System.loadLibrary("bd_license");
            System.loadLibrary("aikl_calc_arm");
            System.loadLibrary("aikl_cluster_arm");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PaddleLiteTest(Context context) {
        this.context = context;
    }

    private native int nativeCreate(byte[] bArr, byte[] bArr2);

    private native int nativeRun();

    public void create(String str, String str2) {
        if (this.context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        byte[] modelContent = FileUitls.getModelContent(this.context, str);
        byte[] modelContent2 = FileUitls.getModelContent(this.context, str2);
        if (modelContent.length == 0 || modelContent2.length == 0) {
            return;
        }
        nativeCreate(modelContent, modelContent2);
    }

    public void run() {
        nativeRun();
    }
}
