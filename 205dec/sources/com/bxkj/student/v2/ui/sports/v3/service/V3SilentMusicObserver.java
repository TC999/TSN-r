package com.bxkj.student.v2.ui.sports.v3.service;

import android.media.MediaPlayer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bxkj.student.App;
import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: V3SilentMusicObserver.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0003R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3SilentMusicObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f1;", "createMusic", "startPlayMusic", "stopPlayMusic", "Landroid/media/MediaPlayer;", "a", "Landroid/media/MediaPlayer;", "mMediaPlayer", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class V3SilentMusicObserver implements LifecycleObserver {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayer f24268a;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void createMusic() {
        MediaPlayer create = MediaPlayer.create(App.o(), 2131755101);
        create.setLooping(true);
        f1 f1Var = f1.f55527a;
        this.f24268a = create;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void startPlayMusic() {
        MediaPlayer mediaPlayer = this.f24268a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void stopPlayMusic() {
        MediaPlayer mediaPlayer = this.f24268a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
    }
}
