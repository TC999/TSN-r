package com.bykv.vk.component.ttvideo.player;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTPlayerPluginLoader {
    public static final int PLUGIN_INTERTRUST_DRM = 100;
    private static IPluginLoader mPluginLoader;

    public static ClassLoader loadPlugin(int i4) {
        IPluginLoader iPluginLoader = mPluginLoader;
        if (iPluginLoader != null) {
            return iPluginLoader.loadPlugin(i4);
        }
        return null;
    }

    public static void setPluginLoader(IPluginLoader iPluginLoader) {
        mPluginLoader = iPluginLoader;
    }
}
