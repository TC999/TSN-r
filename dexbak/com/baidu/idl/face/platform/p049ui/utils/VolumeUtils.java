package com.baidu.idl.face.platform.p049ui.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/* renamed from: com.baidu.idl.face.platform.ui.utils.VolumeUtils */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class VolumeUtils {
    public static final String TAG = "VolumeUtils";

    /* renamed from: com.baidu.idl.face.platform.ui.utils.VolumeUtils$VolumeCallback */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface VolumeCallback {
        void volumeChanged();
    }

    /* renamed from: com.baidu.idl.face.platform.ui.utils.VolumeUtils$VolumeReceiver */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
            } catch (IllegalArgumentException e) {
                e = e;
                volumeReceiver = volumeReceiver2;
                e.printStackTrace();
                return volumeReceiver;
            } catch (Exception e2) {
                e = e2;
                volumeReceiver = volumeReceiver2;
                e.printStackTrace();
                return volumeReceiver;
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static void unRegisterVolumeReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null || broadcastReceiver == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
