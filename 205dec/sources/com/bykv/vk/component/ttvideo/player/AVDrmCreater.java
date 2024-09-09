package com.bykv.vk.component.ttvideo.player;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVDrmCreater {
    public static final int DrmTypeIntertrust = 1;
    public static final int DrmTypeNone = 0;

    @CalledByNative
    public static synchronized long createDrm(int i4) {
        synchronized (AVDrmCreater.class) {
            if (i4 == 1) {
                return createDrm(100, "com.bykv.vk.component.ttvideo.drm.intertrust.IntertrustDrm");
            }
            return 0L;
        }
    }

    private static long createDrm(int i4, String str) {
        try {
            ClassLoader loadPlugin = TTPlayerPluginLoader.loadPlugin(i4);
            return Long.parseLong(String.valueOf((loadPlugin != null ? Class.forName(str, true, loadPlugin) : Class.forName(str)).getMethod("createDrm", new Class[0]).invoke(null, new Object[0])));
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0L;
        }
    }
}
