package com.bxkj.student.p094v2.p098ui.sports.p102v3.service;

import android.media.MediaPlayer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bxkj.student.App;
import com.bxkj.student.C4215R;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3SilentMusicObserver.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0003R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3SilentMusicObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f1;", "createMusic", "startPlayMusic", "stopPlayMusic", "Landroid/media/MediaPlayer;", "a", "Landroid/media/MediaPlayer;", "mMediaPlayer", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3SilentMusicObserver */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class V3SilentMusicObserver implements LifecycleObserver {
    @Nullable

    /* renamed from: a */
    private MediaPlayer f20849a;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void createMusic() {
        MediaPlayer create = MediaPlayer.create(App.m43005o(), (int) C4215R.raw.slient);
        create.setLooping(true);
        Unit unit = Unit.f41048a;
        this.f20849a = create;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void startPlayMusic() {
        MediaPlayer mediaPlayer = this.f20849a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void stopPlayMusic() {
        MediaPlayer mediaPlayer = this.f20849a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
    }
}
