package com.kwad.sdk.core.video.p411a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.TimedText;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import java.io.FileDescriptor;
import java.util.Map;

/* renamed from: com.kwad.sdk.core.video.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC10522c {

    /* renamed from: com.kwad.sdk.core.video.a.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10523a {
        /* renamed from: av */
        void mo25496av(int i);
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10524b {
        /* renamed from: oZ */
        void mo25499oZ();
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10525c {
        /* renamed from: l */
        boolean mo25498l(int i, int i2);
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10526d {
        /* renamed from: m */
        boolean mo25497m(int i, int i2);
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10527e {
        /* renamed from: a */
        void mo25501a(InterfaceC10522c interfaceC10522c);
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10528f {
        /* renamed from: ry */
        void mo25546ry();
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$g */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10529g {
        /* renamed from: pa */
        void mo25545pa();
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$h */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10530h {
        /* renamed from: a */
        void mo25544a(TimedText timedText);
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$i */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10531i {
        /* renamed from: k */
        void mo25500k(int i, int i2);
    }

    /* renamed from: FZ */
    boolean mo25542FZ();

    /* renamed from: a */
    void mo25536a(@NonNull C9878b c9878b);

    /* renamed from: a */
    void mo25555a(InterfaceC10523a interfaceC10523a);

    /* renamed from: a */
    void mo25554a(InterfaceC10524b interfaceC10524b);

    /* renamed from: a */
    void mo25553a(InterfaceC10525c interfaceC10525c);

    /* renamed from: a */
    void mo25552a(InterfaceC10528f interfaceC10528f);

    /* renamed from: a */
    void mo25551a(InterfaceC10529g interfaceC10529g);

    /* renamed from: a */
    void mo25550a(InterfaceC10530h interfaceC10530h);

    /* renamed from: a */
    void mo25549a(InterfaceC10531i interfaceC10531i);

    /* renamed from: b */
    void mo25548b(InterfaceC10527e interfaceC10527e);

    /* renamed from: c */
    void mo25547c(InterfaceC10526d interfaceC10526d);

    int getAudioSessionId();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    int getMediaPlayerType();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    boolean prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setAudioStreamType(int i);

    void setDataSource(Context context, Uri uri);

    @TargetApi(14)
    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void start();

    void stop();
}
