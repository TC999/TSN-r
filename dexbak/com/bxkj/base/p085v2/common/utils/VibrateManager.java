package com.bxkj.base.p085v2.common.utils;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\n¨\u0006\u000e"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/s;", "", "", "vibrationTime", "pauseTime", "Lkotlin/f1;", "a", "b", "c", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class VibrateManager {
    @NotNull

    /* renamed from: a */
    private final Context f15143a;

    public VibrateManager(@NotNull Context context) {
        C14342f0.m8184p(context, "context");
        this.f15143a = context;
    }

    /* renamed from: a */
    private final void m43736a(long j, long j2) {
        Object systemService = this.f15143a.getSystemService("vibrator");
        if (systemService != null) {
            Vibrator vibrator = (Vibrator) systemService;
            if (vibrator.hasVibrator()) {
                long[] jArr = {0, j, j2};
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createWaveform(jArr, 0));
                    return;
                } else {
                    vibrator.vibrate(jArr, -1);
                    return;
                }
            }
            Log.e("VibrateManager", "Device does not support vibration.");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }

    /* renamed from: b */
    public final void m43735b() {
        m43736a(1000L, 2000L);
    }

    /* renamed from: c */
    public final void m43734c() {
        Object systemService = this.f15143a.getSystemService("vibrator");
        if (systemService != null) {
            ((Vibrator) systemService).cancel();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }
}
