package com.baidu.idl.face.platform.ui.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class VolumeUtils {
    public static final String TAG = "VolumeUtils";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface VolumeCallback {
        void volumeChanged();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class VolumeReceiver extends BroadcastReceiver {
        private VolumeCallback callback;

        public VolumeReceiver(VolumeCallback volumeCallback) {
            this.callback = volumeCallback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") || this.callback == null) {
                return;
            }
            Log.e(VolumeUtils.TAG, "android.media.VOLUME_CHANGED_ACTION");
            this.callback.volumeChanged();
        }
    }

    public static BroadcastReceiver registerVolumeReceiver(Context context, VolumeCallback volumeCallback) {
        VolumeReceiver volumeReceiver = null;
        try {
            VolumeReceiver volumeReceiver2 = new VolumeReceiver(volumeCallback);
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                context.registerReceiver(volumeReceiver2, intentFilter);
                return volumeReceiver2;
            } catch (IllegalArgumentException e4) {
                e = e4;
                volumeReceiver = volumeReceiver2;
                e.printStackTrace();
                return volumeReceiver;
            } catch (Exception e5) {
                e = e5;
                volumeReceiver = volumeReceiver2;
                e.printStackTrace();
                return volumeReceiver;
            }
        } catch (IllegalArgumentException e6) {
            e = e6;
        } catch (Exception e7) {
            e = e7;
        }
    }

    public static void unRegisterVolumeReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null || broadcastReceiver == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
