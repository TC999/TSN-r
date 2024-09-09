package com.bykv.vk.component.ttvideo.player;

@JNINamespace("UTILS")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
class AVClassLoad {
    AVClassLoad() {
    }

    @CalledByNative
    static Object getClassLoader() {
        return AVClassLoad.class.getClassLoader();
    }
}
