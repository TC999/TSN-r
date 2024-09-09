package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DispatchAdSdkInitializerHolder {

    /* renamed from: c  reason: collision with root package name */
    private static volatile Initializer f31245c;

    /* renamed from: w  reason: collision with root package name */
    private static Initializer f31246w;

    public static Loader getCsjLoader(Context context) {
        if (getCsjManger() != null) {
            return getCsjManger().createLoader(context);
        }
        return null;
    }

    public static Manager getCsjManger() {
        Initializer initializer = f31246w;
        if (initializer != null) {
            return initializer.getManager();
        }
        return null;
    }

    public static Initializer getInstance(Bundle bundle, Initializer initializer) {
        f31246w = initializer;
        if (f31245c == null) {
            synchronized (DispatchAdSdkInitializerHolder.class) {
                if (f31245c == null) {
                    f31245c = new ys(bundle, initializer);
                }
            }
        }
        return f31245c;
    }

    public static boolean isInitSuccess() {
        Initializer initializer = f31246w;
        return initializer != null && initializer.isInitSuccess();
    }
}
