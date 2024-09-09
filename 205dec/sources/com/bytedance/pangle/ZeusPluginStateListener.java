package com.bytedance.pangle;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static void postStateChange(@Nullable final String str, final int i4, final Object... objArr) {
        mHandler.post(new Runnable() { // from class: com.bytedance.pangle.ZeusPluginStateListener.1
            @Override // java.lang.Runnable
            public final void run() {
                List<ZeusPluginStateListener> list = i.a().f28820b;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (ZeusPluginStateListener zeusPluginStateListener : list) {
                    zeusPluginStateListener.onPluginStateChange(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i4, objArr);
                }
            }
        });
        List<ZeusPluginStateListener> list = i.a().f28820b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ZeusPluginStateListener zeusPluginStateListener : list) {
            zeusPluginStateListener.onStateChangeOnCurThread(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i4, objArr);
        }
    }

    @Deprecated
    public void onPluginStateChange(String str, int i4, Object... objArr) {
    }

    public void onStateChangeOnCurThread(String str, int i4, Object... objArr) {
    }
}
