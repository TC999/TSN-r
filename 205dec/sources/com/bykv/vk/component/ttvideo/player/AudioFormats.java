package com.bykv.vk.component.ttvideo.player;

import android.media.audiofx.AudioEffect;
import android.os.Build;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AudioFormats {
    private static final int[] validSampleRates = {4000, AVMDLDataLoader.KeyIsLiveSetLoaderType, 11025, 16000, 22050, 32000, 37800, 44056, 44100, 47250, 48000, 50000, 50400, 88200, 96000, 176400, 192000, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int length = validSampleRates.length;
        int i4 = Build.VERSION.SDK_INT;
        int i5 = i4 >= 23 ? length - 3 : i4 >= 21 ? length - 5 : length - 9;
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = validSampleRates[i6];
        }
        return i5;
    }

    @CalledByNative
    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
        int length = queryEffects.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            } else if (queryEffects[i4].implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            } else {
                i4++;
            }
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }
}
