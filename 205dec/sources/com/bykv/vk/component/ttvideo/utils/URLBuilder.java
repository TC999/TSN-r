package com.bykv.vk.component.ttvideo.utils;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.Keep;
import java.net.URL;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class URLBuilder {
    private static final String TAG = "URLBuilder";

    public static final URL build(String str) {
        try {
            return new URL(str);
        } catch (Exception e4) {
            Log.d(TAG, e4.toString());
            return null;
        }
    }
}
