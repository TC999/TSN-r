package com.bxkj.student.common.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.SparseArray;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SoundUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b5\u00106B\u0011\b\u0016\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b5\u00109B\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b5\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0014\u0010\u000e\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007J\u0014\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u001e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u0002H\u0007R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010&R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010&R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010+R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010+R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010+R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00100R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u0004028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00103\u00a8\u0006>"}, d2 = {"Lcom/bxkj/student/common/utils/SoundUtils;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f1;", "d", "", "rawId", "m", "", "soundList", "n", "g", "", "speed", "h", "j", "Lkotlin/Function0;", "completeListener", "p", "soundRes", "times", "i", "c", "soundVolType", CampaignEx.JSON_KEY_AD_Q, "order", "f", "o", "r", "release", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Landroid/media/SoundPool;", "b", "Landroid/media/SoundPool;", "soundPool", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "soundPoolMap", "soundDurationMap", "e", "I", "F", "maxVolumn", "currentVolumn", "volumnRatio", "Landroid/os/Handler;", "Landroid/os/Handler;", "playHandler", "", "Ljava/util/List;", "waitSoundList", "<init>", "(Landroid/content/Context;)V", "Landroidx/fragment/app/FragmentActivity;", "activity", "(Landroidx/fragment/app/FragmentActivity;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)V", "l", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class SoundUtils implements LifecycleObserver {
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    public static final a f19591l = new a(null);

    /* renamed from: m  reason: collision with root package name */
    private static final int f19592m = -1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f19593n = 0;

    /* renamed from: o  reason: collision with root package name */
    private static final int f19594o = 2;

    /* renamed from: p  reason: collision with root package name */
    private static final int f19595p = 3;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f19596a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private SoundPool f19597b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Integer> f19598c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<Integer> f19599d;

    /* renamed from: e  reason: collision with root package name */
    private int f19600e;

    /* renamed from: f  reason: collision with root package name */
    private float f19601f;

    /* renamed from: g  reason: collision with root package name */
    private float f19602g;

    /* renamed from: h  reason: collision with root package name */
    private float f19603h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Handler f19604i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private List<Integer> f19605j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private d2.a<f1> f19606k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SoundUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/student/common/utils/SoundUtils$a;", "", "", "INFINITE_PLAY", "I", "MEDIA_SOUND", "RING_SOUND", "SINGLE_PLAY", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public SoundUtils(@NotNull Context context) {
        Object systemService;
        AudioManager audioManager;
        SoundPool soundPool;
        f0.p(context, "context");
        this.f19596a = context;
        this.f19598c = new SparseArray<>();
        this.f19599d = new SparseArray<>();
        this.f19600e = 3;
        try {
            this.f19604i = new Handler();
            systemService = context.getSystemService("audio");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (systemService != null) {
            this.f19601f = audioManager.getStreamMaxVolume(this.f19600e);
            float streamVolume = ((AudioManager) systemService).getStreamVolume(this.f19600e);
            this.f19602g = streamVolume;
            this.f19603h = streamVolume / this.f19601f;
            if (Build.VERSION.SDK_INT >= 21) {
                soundPool = new SoundPool.Builder().setMaxStreams(5).build();
            } else {
                soundPool = new SoundPool(5, 3, 0);
            }
            this.f19597b = soundPool;
            this.f19605j = new ArrayList();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bxkj.student.common.utils.j, java.lang.Runnable] */
    private final void d() {
        if (this.f19605j.isEmpty()) {
            d2.a<f1> aVar = this.f19606k;
            if (aVar != null) {
                aVar.invoke();
            }
            com.orhanobut.logger.j.d("\u6240\u6709\u97f3\u4e50\u64ad\u653e\u5b8c\u6bd5", new Object[0]);
            return;
        }
        int intValue = this.f19605j.get(0).intValue();
        Handler handler = this.f19604i;
        if (handler == 0) {
            return;
        }
        handler.postDelayed(new j(this, intValue), this.f19599d.get(intValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SoundUtils this$0, int i4) {
        f0.p(this$0, "this$0");
        this$0.g(i4);
        this$0.f19605j.remove(Integer.valueOf(i4));
        this$0.d();
    }

    public static /* synthetic */ void k(SoundUtils soundUtils, int i4, float f4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f4 = 1.0f;
        }
        soundUtils.h(i4, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SoundUtils this$0, int i4, float f4, SoundPool soundPool, int i5, int i6) {
        f0.p(this$0, "this$0");
        if (soundPool == null) {
            return;
        }
        Integer num = this$0.f19598c.get(i5);
        f0.o(num, "soundPoolMap[sampleId]");
        int intValue = num.intValue();
        float f5 = this$0.f19603h;
        soundPool.play(intValue, f5, f5, 1, i4, f4);
    }

    public final int c(int i4) {
        try {
            Uri parse = Uri.parse("android.resource://" + ((Object) this.f19596a.getPackageName()) + '/' + i4);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(this.f19596a, parse);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.prepare();
            return mediaPlayer.getDuration();
        } catch (IOException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public final void f(int i4) {
        SoundPool soundPool = this.f19597b;
        if (soundPool == null) {
            return;
        }
        Integer num = this.f19598c.get(i4);
        f0.o(num, "soundPoolMap[order]");
        soundPool.pause(num.intValue());
    }

    public final void g(int i4) {
        i(i4, 1.0f, 0);
    }

    public final void h(int i4, float f4) {
        i(i4, f4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bxkj.student.common.utils.i, android.media.SoundPool$OnLoadCompleteListener] */
    public final void i(int i4, float f4, int i5) {
        try {
            if (this.f19598c.indexOfKey(i4) >= 0) {
                SoundPool soundPool = this.f19597b;
                if (soundPool != null) {
                    Integer num = this.f19598c.get(i4);
                    f0.o(num, "soundPoolMap[soundRes]");
                    int intValue = num.intValue();
                    float f5 = this.f19603h;
                    soundPool.play(intValue, f5, f5, 1, i5, f4);
                }
            } else {
                m(i4);
                SoundPool soundPool2 = this.f19597b;
                if (soundPool2 != 0) {
                    soundPool2.setOnLoadCompleteListener(new i(this, i5, f4));
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void j(@NotNull List<Integer> soundList) {
        f0.p(soundList, "soundList");
        if (this.f19605j.isEmpty()) {
            this.f19605j.addAll(soundList);
            d();
            return;
        }
        this.f19605j.addAll(soundList);
    }

    public final void m(int i4) {
        SparseArray<Integer> sparseArray = this.f19598c;
        SoundPool soundPool = this.f19597b;
        sparseArray.put(i4, soundPool == null ? null : Integer.valueOf(soundPool.load(this.f19596a, i4, 1)));
        this.f19599d.put(i4, Integer.valueOf(c(i4)));
    }

    public final void n(@NotNull List<Integer> soundList) {
        f0.p(soundList, "soundList");
        for (Integer num : soundList) {
            m(num.intValue());
        }
    }

    public final void o(int i4) {
        SoundPool soundPool = this.f19597b;
        if (soundPool == null) {
            return;
        }
        Integer num = this.f19598c.get(i4);
        f0.o(num, "soundPoolMap[order]");
        soundPool.resume(num.intValue());
    }

    public final void p(@NotNull d2.a<f1> completeListener) {
        f0.p(completeListener, "completeListener");
        this.f19606k = completeListener;
    }

    public final void q(int i4) {
        this.f19600e = i4;
    }

    public final void r(int i4) {
        SoundPool soundPool = this.f19597b;
        if (soundPool != null) {
            Integer num = this.f19598c.get(i4);
            f0.o(num, "soundPoolMap[order]");
            soundPool.stop(num.intValue());
        }
        Handler handler = this.f19604i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        SoundPool soundPool2 = this.f19597b;
        if (soundPool2 == null) {
            return;
        }
        soundPool2.release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        int i4 = 0;
        try {
            int size = this.f19598c.size();
            if (size > 0) {
                while (true) {
                    int i5 = i4 + 1;
                    int keyAt = this.f19598c.keyAt(i4);
                    SoundPool soundPool = this.f19597b;
                    if (soundPool != null) {
                        Integer num = this.f19598c.get(keyAt);
                        f0.o(num, "soundPoolMap[key]");
                        soundPool.stop(num.intValue());
                    }
                    if (i5 >= size) {
                        break;
                    }
                    i4 = i5;
                }
            }
            SoundPool soundPool2 = this.f19597b;
            if (soundPool2 == null) {
                return;
            }
            soundPool2.release();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SoundUtils(@org.jetbrains.annotations.NotNull androidx.fragment.app.FragmentActivity r3) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.f0.p(r3, r0)
            android.content.Context r0 = r3.getApplicationContext()
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)
            java.lang.String r1 = "activity.applicationContext"
            kotlin.jvm.internal.f0.o(r0, r1)
            r2.<init>(r0)
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            r3.addObserver(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.utils.SoundUtils.<init>(androidx.fragment.app.FragmentActivity):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SoundUtils(@org.jetbrains.annotations.NotNull androidx.fragment.app.Fragment r3) {
        /*
            r2 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.f0.p(r3, r0)
            android.content.Context r0 = r3.requireContext()
            java.lang.String r1 = "fragment.requireContext()"
            kotlin.jvm.internal.f0.o(r0, r1)
            r2.<init>(r0)
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            r3.addObserver(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.utils.SoundUtils.<init>(androidx.fragment.app.Fragment):void");
    }
}
