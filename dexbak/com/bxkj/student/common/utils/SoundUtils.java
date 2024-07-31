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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.C11792j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* compiled from: SoundUtils.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b5\u00106B\u0011\b\u0016\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b5\u00109B\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b5\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0014\u0010\u000e\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007J\u0014\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u001e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u0002H\u0007R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010&R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010+R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010+R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010+R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00100R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u0004028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00103¨\u0006>"}, m12616d2 = {"Lcom/bxkj/student/common/utils/SoundUtils;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f1;", "d", "", "rawId", "m", "", "soundList", "n", "g", "", "speed", "h", "j", "Lkotlin/Function0;", "completeListener", "p", "soundRes", "times", "i", "c", "soundVolType", CampaignEx.JSON_KEY_AD_Q, "order", "f", "o", "r", "release", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Landroid/media/SoundPool;", "b", "Landroid/media/SoundPool;", "soundPool", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "soundPoolMap", "soundDurationMap", "e", "I", "F", "maxVolumn", "currentVolumn", "volumnRatio", "Landroid/os/Handler;", "Landroid/os/Handler;", "playHandler", "", "Ljava/util/List;", "waitSoundList", "<init>", "(Landroid/content/Context;)V", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "(Landroidx/fragment/app/FragmentActivity;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)V", C7304t.f25048d, "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SoundUtils implements LifecycleObserver {
    @NotNull

    /* renamed from: l */
    public static final C4244a f16192l = new C4244a(null);

    /* renamed from: m */
    private static final int f16193m = -1;

    /* renamed from: n */
    private static final int f16194n = 0;

    /* renamed from: o */
    private static final int f16195o = 2;

    /* renamed from: p */
    private static final int f16196p = 3;
    @NotNull

    /* renamed from: a */
    private final Context f16197a;
    @Nullable

    /* renamed from: b */
    private SoundPool f16198b;
    @NotNull

    /* renamed from: c */
    private final SparseArray<Integer> f16199c;
    @NotNull

    /* renamed from: d */
    private final SparseArray<Integer> f16200d;

    /* renamed from: e */
    private int f16201e;

    /* renamed from: f */
    private float f16202f;

    /* renamed from: g */
    private float f16203g;

    /* renamed from: h */
    private float f16204h;
    @Nullable

    /* renamed from: i */
    private Handler f16205i;
    @NotNull

    /* renamed from: j */
    private List<Integer> f16206j;
    @Nullable

    /* renamed from: k */
    private InterfaceC15269a<Unit> f16207k;

    /* compiled from: SoundUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/common/utils/SoundUtils$a;", "", "", "INFINITE_PLAY", "I", "MEDIA_SOUND", "RING_SOUND", "SINGLE_PLAY", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.common.utils.SoundUtils$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C4244a {
        private C4244a() {
        }

        public /* synthetic */ C4244a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SoundUtils(@NotNull Context context) {
        Object systemService;
        AudioManager audioManager;
        SoundPool soundPool;
        C14342f0.m8184p(context, "context");
        this.f16197a = context;
        this.f16199c = new SparseArray<>();
        this.f16200d = new SparseArray<>();
        this.f16201e = 3;
        try {
            this.f16205i = new Handler();
            systemService = context.getSystemService("audio");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (systemService != null) {
            this.f16202f = audioManager.getStreamMaxVolume(this.f16201e);
            float streamVolume = ((AudioManager) systemService).getStreamVolume(this.f16201e);
            this.f16203g = streamVolume;
            this.f16204h = streamVolume / this.f16202f;
            if (Build.VERSION.SDK_INT >= 21) {
                soundPool = new SoundPool.Builder().setMaxStreams(5).build();
            } else {
                soundPool = new SoundPool(5, 3, 0);
            }
            this.f16198b = soundPool;
            this.f16206j = new ArrayList();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }

    /* renamed from: d */
    private final void m42886d() {
        if (this.f16206j.isEmpty()) {
            InterfaceC15269a<Unit> interfaceC15269a = this.f16207k;
            if (interfaceC15269a != null) {
                interfaceC15269a.invoke();
            }
            C11792j.m20469d("所有音乐播放完毕", new Object[0]);
            return;
        }
        final int intValue = this.f16206j.get(0).intValue();
        Handler handler = this.f16205i;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.bxkj.student.common.utils.k
            @Override // java.lang.Runnable
            public final void run() {
                SoundUtils.m42885e(SoundUtils.this, intValue);
            }
        }, this.f16200d.get(intValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static final void m42885e(SoundUtils this$0, int i) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m42883g(i);
        this$0.f16206j.remove(Integer.valueOf(i));
        this$0.m42886d();
    }

    /* renamed from: k */
    public static /* synthetic */ void m42879k(SoundUtils soundUtils, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        soundUtils.m42882h(i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static final void m42878l(SoundUtils this$0, int i, float f, SoundPool soundPool, int i2, int i3) {
        C14342f0.m8184p(this$0, "this$0");
        if (soundPool == null) {
            return;
        }
        Integer num = this$0.f16199c.get(i2);
        C14342f0.m8185o(num, "soundPoolMap[sampleId]");
        int intValue = num.intValue();
        float f2 = this$0.f16204h;
        soundPool.play(intValue, f2, f2, 1, i, f);
    }

    /* renamed from: c */
    public final int m42887c(int i) {
        try {
            Uri parse = Uri.parse("android.resource://" + ((Object) this.f16197a.getPackageName()) + '/' + i);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(this.f16197a, parse);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.prepare();
            return mediaPlayer.getDuration();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: f */
    public final void m42884f(int i) {
        SoundPool soundPool = this.f16198b;
        if (soundPool == null) {
            return;
        }
        Integer num = this.f16199c.get(i);
        C14342f0.m8185o(num, "soundPoolMap[order]");
        soundPool.pause(num.intValue());
    }

    /* renamed from: g */
    public final void m42883g(int i) {
        m42881i(i, 1.0f, 0);
    }

    /* renamed from: h */
    public final void m42882h(int i, float f) {
        m42881i(i, f, 0);
    }

    /* renamed from: i */
    public final void m42881i(int i, final float f, final int i2) {
        try {
            if (this.f16199c.indexOfKey(i) >= 0) {
                SoundPool soundPool = this.f16198b;
                if (soundPool != null) {
                    Integer num = this.f16199c.get(i);
                    C14342f0.m8185o(num, "soundPoolMap[soundRes]");
                    int intValue = num.intValue();
                    float f2 = this.f16204h;
                    soundPool.play(intValue, f2, f2, 1, i2, f);
                }
            } else {
                m42877m(i);
                SoundPool soundPool2 = this.f16198b;
                if (soundPool2 != null) {
                    soundPool2.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.bxkj.student.common.utils.j
                        @Override // android.media.SoundPool.OnLoadCompleteListener
                        public final void onLoadComplete(SoundPool soundPool3, int i3, int i4) {
                            SoundUtils.m42878l(SoundUtils.this, i2, f, soundPool3, i3, i4);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    public final void m42880j(@NotNull List<Integer> soundList) {
        C14342f0.m8184p(soundList, "soundList");
        if (this.f16206j.isEmpty()) {
            this.f16206j.addAll(soundList);
            m42886d();
            return;
        }
        this.f16206j.addAll(soundList);
    }

    /* renamed from: m */
    public final void m42877m(int i) {
        SparseArray<Integer> sparseArray = this.f16199c;
        SoundPool soundPool = this.f16198b;
        sparseArray.put(i, soundPool == null ? null : Integer.valueOf(soundPool.load(this.f16197a, i, 1)));
        this.f16200d.put(i, Integer.valueOf(m42887c(i)));
    }

    /* renamed from: n */
    public final void m42876n(@NotNull List<Integer> soundList) {
        C14342f0.m8184p(soundList, "soundList");
        for (Integer num : soundList) {
            m42877m(num.intValue());
        }
    }

    /* renamed from: o */
    public final void m42875o(int i) {
        SoundPool soundPool = this.f16198b;
        if (soundPool == null) {
            return;
        }
        Integer num = this.f16199c.get(i);
        C14342f0.m8185o(num, "soundPoolMap[order]");
        soundPool.resume(num.intValue());
    }

    /* renamed from: p */
    public final void m42874p(@NotNull InterfaceC15269a<Unit> completeListener) {
        C14342f0.m8184p(completeListener, "completeListener");
        this.f16207k = completeListener;
    }

    /* renamed from: q */
    public final void m42873q(int i) {
        this.f16201e = i;
    }

    /* renamed from: r */
    public final void m42872r(int i) {
        SoundPool soundPool = this.f16198b;
        if (soundPool != null) {
            Integer num = this.f16199c.get(i);
            C14342f0.m8185o(num, "soundPoolMap[order]");
            soundPool.stop(num.intValue());
        }
        Handler handler = this.f16205i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        SoundPool soundPool2 = this.f16198b;
        if (soundPool2 == null) {
            return;
        }
        soundPool2.release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        int i = 0;
        try {
            int size = this.f16199c.size();
            if (size > 0) {
                while (true) {
                    int i2 = i + 1;
                    int keyAt = this.f16199c.keyAt(i);
                    SoundPool soundPool = this.f16198b;
                    if (soundPool != null) {
                        Integer num = this.f16199c.get(keyAt);
                        C14342f0.m8185o(num, "soundPoolMap[key]");
                        soundPool.stop(num.intValue());
                    }
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            SoundPool soundPool2 = this.f16198b;
            if (soundPool2 == null) {
                return;
            }
            soundPool2.release();
        } catch (Exception e) {
            e.printStackTrace();
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
            kotlin.jvm.internal.C14342f0.m8184p(r3, r0)
            android.content.Context r0 = r3.getApplicationContext()
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)
            java.lang.String r1 = "activity.applicationContext"
            kotlin.jvm.internal.C14342f0.m8185o(r0, r1)
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
            kotlin.jvm.internal.C14342f0.m8184p(r3, r0)
            android.content.Context r0 = r3.requireContext()
            java.lang.String r1 = "fragment.requireContext()"
            kotlin.jvm.internal.C14342f0.m8185o(r0, r1)
            r2.<init>(r0)
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            r3.addObserver(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.utils.SoundUtils.<init>(androidx.fragment.app.Fragment):void");
    }
}
