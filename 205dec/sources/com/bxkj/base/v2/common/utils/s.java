package com.bxkj.base.v2.common.utils;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: VibrateManager.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/bxkj/base/v2/common/utils/s;", "", "", "vibrationTime", "pauseTime", "Lkotlin/f1;", "a", "b", "c", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class s {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f18635a;

    public s(@NotNull Context context) {
        f0.p(context, "context");
        this.f18635a = context;
    }

    private final void a(long j4, long j5) {
        Object systemService = this.f18635a.getSystemService("vibrator");
        if (systemService != null) {
            Vibrator vibrator = (Vibrator) systemService;
            if (vibrator.hasVibrator()) {
                long[] jArr = {0, j4, j5};
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

    public final void b() {
        a(1000L, 2000L);
    }

    public final void c() {
        Object systemService = this.f18635a.getSystemService("vibrator");
        if (systemService != null) {
            ((Vibrator) systemService).cancel();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }
}
