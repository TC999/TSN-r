package com.beizi.p051ad.internal.video;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.activity.InterstitialAdActivity;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.p058b.HttpProxyCacheServer;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.UserEnvInfoUtil;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.video.AdVideoManager;
import com.beizi.p051ad.internal.view.AdViewImpl;
import com.beizi.p051ad.internal.view.AdWebView;
import com.beizi.p051ad.internal.view.Displayable;
import com.beizi.p051ad.internal.view.InterstitialAdViewImpl;
import com.beizi.p051ad.p056c.EnumType;
import com.google.android.material.badge.BadgeDrawable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.beizi.ad.internal.video.AdVideoView */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, Displayable {

    /* renamed from: a */
    protected MediaPlayer f10422a;

    /* renamed from: b */
    protected AdVideoManager.EnumC2945b f10423b;

    /* renamed from: c */
    private boolean f10424c;

    /* renamed from: d */
    private int f10425d;

    /* renamed from: e */
    private int f10426e;

    /* renamed from: f */
    private int f10427f;

    /* renamed from: g */
    private int f10428g;

    /* renamed from: h */
    private int f10429h;

    /* renamed from: i */
    private boolean f10430i;

    /* renamed from: j */
    private boolean f10431j;

    /* renamed from: k */
    private EnumC2942a f10432k;

    /* renamed from: l */
    private Pair<String, Integer> f10433l;

    /* renamed from: m */
    private int f10434m;
    public AdWebView mAdWebView;

    /* renamed from: n */
    private long f10435n;

    /* renamed from: o */
    private float f10436o;

    /* renamed from: p */
    private float f10437p;

    /* renamed from: q */
    private boolean f10438q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.ad.internal.video.AdVideoView$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2942a {
        NRF_NONE,
        NRF_START,
        NRF_PAUSE
    }

    public AdVideoView(AdWebView adWebView) {
        super(new MutableContextWrapper(adWebView.getContextFromMutableContext()));
        this.f10424c = false;
        this.f10430i = false;
        this.f10431j = false;
        this.f10432k = EnumC2942a.NRF_NONE;
        this.f10433l = null;
        this.f10423b = AdVideoManager.EnumC2945b.FIT_CENTER;
        this.f10434m = -1;
        this.mAdWebView = adWebView;
    }

    private void setDataSource(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void destroy() {
        stop();
        ViewUtil.removeChildFromParent(this);
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public boolean failed() {
        return this.f10424c;
    }

    public AdWebView getAdWebView() {
        return this.mAdWebView;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getCreativeHeight() {
        return this.f10428g;
    }

    public int getCreativeLeft() {
        return this.f10425d;
    }

    public int getCreativeTop() {
        return this.f10426e;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getCreativeWidth() {
        return this.f10427f;
    }

    public int getCurrentPosition() {
        return this.f10422a.getCurrentPosition();
    }

    public int getDuration() {
        return this.f10422a.getDuration();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getRefreshInterval() {
        return this.f10429h;
    }

    public int getVideoHeight() {
        return this.f10422a.getVideoHeight();
    }

    public int getVideoWidth() {
        return this.f10422a.getVideoWidth();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public View getView() {
        return this;
    }

    public boolean isLooping() {
        return this.f10422a.isLooping();
    }

    public boolean isPlaying() {
        return this.f10422a.isPlaying();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void onDestroy() {
        destroy();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f10422a == null) {
            return;
        }
        if (isPlaying()) {
            stop();
        }
        release();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void onPause() {
        if (this.f10432k == EnumC2942a.NRF_START) {
            pause();
            this.f10432k = EnumC2942a.NRF_PAUSE;
        }
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void onResume() {
        if (this.f10432k == EnumC2942a.NRF_PAUSE) {
            start(1);
            this.f10432k = EnumC2942a.NRF_START;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.f10422a;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AdWebView adWebView;
        AdViewImpl adViewImpl;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.f10438q && m49280a(this.f10436o, this.f10437p, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                    this.f10438q = false;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis() - this.f10435n;
                Log.d("lance", "ACTION_UP:" + currentTimeMillis);
                if (currentTimeMillis < 1000 && this.f10438q && (adWebView = this.mAdWebView) != null && (adViewImpl = adWebView.adViewImpl) != null && adViewImpl.getAdDispatcher() != null) {
                    AdViewImpl adViewImpl2 = this.mAdWebView.adViewImpl;
                    adViewImpl2.clickCount++;
                    adViewImpl2.getAdDispatcher().mo49212d();
                    AdWebView adWebView2 = this.mAdWebView;
                    adWebView2.f10626ad.setOpenInNativeBrowser(adWebView2.adViewImpl.getOpensNativeBrowser());
                }
            }
            z = false;
        } else {
            this.f10435n = System.currentTimeMillis();
            this.f10436o = motionEvent.getX();
            this.f10437p = motionEvent.getY();
            this.f10438q = true;
            Log.d("lance", "ACTION_DOWN");
            z = true;
        }
        return super.onTouchEvent(motionEvent) || z;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        m49274b(getWindowVisibility(), i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        m49274b(i, getVisibility());
    }

    public void pause() {
        MediaPlayer mediaPlayer = this.f10422a;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            this.mAdWebView.f10626ad.handleOnPause(this);
        }
    }

    public void prepare(@Nullable MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        this.f10422a.setOnPreparedListener(onPreparedListener);
        this.f10422a.prepare();
    }

    public void prepareAsync(@Nullable MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.f10422a.setOnPreparedListener(onPreparedListener);
        this.f10422a.prepareAsync();
    }

    public void release() {
        reset();
        this.f10422a.release();
        this.f10422a = null;
    }

    public void reset() {
        this.f10422a.reset();
    }

    public void seekTo(int i) {
        MediaPlayer mediaPlayer = this.f10422a;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
        }
    }

    public void setAssetData(@NonNull String str) throws IOException {
        setDataSource(getContext().getAssets().openFd(str));
    }

    public void setCreativeLeft(int i) {
        this.f10425d = i;
    }

    public void setCreativeTop(int i) {
        this.f10426e = i;
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.f10422a;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setOnCompletionListener(@Nullable MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f10422a.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(@Nullable MediaPlayer.OnErrorListener onErrorListener) {
        this.f10422a.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(@Nullable MediaPlayer.OnInfoListener onInfoListener) {
        this.f10422a.setOnInfoListener(onInfoListener);
    }

    public void setRawData(@RawRes int i) throws IOException {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setRefreshInterval(int i) {
        this.f10429h = i;
    }

    public void setScalableType(AdVideoManager.EnumC2945b enumC2945b) {
        this.f10423b = enumC2945b;
        m49279a(getVideoWidth(), getVideoHeight());
    }

    public void setVolume(float f, float f2) {
        MediaPlayer mediaPlayer = this.f10422a;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    public void start(int i) {
        MediaPlayer mediaPlayer = this.f10422a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.mAdWebView.f10626ad.handleOnStart(this, i);
        }
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.f10422a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public boolean toggleMute() {
        boolean z = !this.f10431j;
        this.f10431j = z;
        if (z) {
            setVolume(0.0f, 0.0f);
        } else {
            setVolume(1.0f, 1.0f);
        }
        return this.f10431j;
    }

    public void transferAd(final AdWebView adWebView, String str) {
        int i;
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.f10428g = adWebView.getCreativeHeight();
        this.f10427f = adWebView.getCreativeWidth();
        this.f10426e = adWebView.getCreativeTop();
        this.f10425d = adWebView.getCreativeLeft();
        this.f10429h = adWebView.getRefreshInterval();
        try {
            new URI(str);
            this.f10423b = AdVideoManager.EnumC2945b.FIT_CENTER;
            HaoboLog.m49286v(HaoboLog.videoLogTag, HaoboLog.getString(C2750R.C2755string.videoview_loading, str));
            m49275a(adWebView.getAdExtras());
            try {
                HttpProxyCacheServer m49480b = BeiZiImpl.m49492a().m49480b();
                if (!UserEnvInfoUtil.isUsingWifi(BeiZiImpl.m49492a().m49473e()) && this.mAdWebView.IsVideoWifiOnly() && !m49480b.m49602b(str)) {
                    HaoboLog.m49290e(HaoboLog.videoLogTag, HaoboLog.getString(C2750R.C2755string.wifi_video_load, str));
                    failed();
                    return;
                }
                setDataSource(m49480b.m49607a(str));
                boolean isMuted = adWebView.isMuted();
                this.f10431j = isMuted;
                if (isMuted) {
                    setVolume(0.0f, 0.0f);
                } else {
                    setVolume(1.0f, 1.0f);
                }
                float m49470h = BeiZiImpl.m49492a().m49470h();
                float m49469i = BeiZiImpl.m49492a().m49469i();
                int i2 = -1;
                if (getCreativeWidth() == 1 && getCreativeHeight() == 1) {
                    i = -1;
                } else {
                    int creativeWidth = (int) ((getCreativeWidth() * m49470h) + 0.5f);
                    i2 = (int) ((getCreativeHeight() * m49469i) + 0.5f);
                    i = creativeWidth;
                }
                if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                    setLayoutParams(new FrameLayout.LayoutParams(i, i2, 17));
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2, BadgeDrawable.TOP_START);
                    layoutParams.setMargins((int) ((getCreativeLeft() * m49470h) + 0.5f), (int) ((getCreativeTop() * m49469i) + 0.5f), 0, 0);
                    setLayoutParams(layoutParams);
                    setScalableType(AdVideoManager.EnumC2945b.FIT_START);
                }
                setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.beizi.ad.internal.video.AdVideoView.1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        AdVideoView.this.mAdWebView.f10626ad.handleOnCompletion();
                        if (AdVideoView.this.f10433l != null) {
                            AdVideoView.this.mAdWebView.adViewImpl.getAdDispatcher().mo49216a((String) AdVideoView.this.f10433l.first, ((Integer) AdVideoView.this.f10433l.second).intValue());
                        }
                        if (!AdVideoView.this.mAdWebView.loadAdBy(1)) {
                            Log.d("lance", "We can't go next, just stand here");
                            return;
                        }
                        AdViewImpl adViewImpl = adWebView.adViewImpl;
                        if (adViewImpl instanceof InterstitialAdViewImpl) {
                            if (((InterstitialAdViewImpl) adViewImpl).getAdImplementation() != null) {
                                ((InterstitialAdActivity) ((InterstitialAdViewImpl) adWebView.adViewImpl).getAdImplementation()).m49658g();
                            } else {
                                Log.d("lance", "Error in incentive video ad adaptation model !");
                            }
                        }
                    }
                });
                setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.beizi.ad.internal.video.AdVideoView.2
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i4) {
                        AdWebView adWebView2;
                        AdViewImpl adViewImpl;
                        if (i3 != 3 || (adWebView2 = AdVideoView.this.mAdWebView) == null || (adViewImpl = adWebView2.adViewImpl) == null || adViewImpl.getAdDispatcher() == null) {
                            return false;
                        }
                        AdVideoView.this.mAdWebView.adViewImpl.getAdDispatcher().mo49210f();
                        return false;
                    }
                });
                prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.beizi.ad.internal.video.AdVideoView.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        AdVideoView.this.f10434m = mediaPlayer.getDuration() / 1000;
                        Log.d("lance", "mPlayTime:" + AdVideoView.this.f10434m);
                        if (AdVideoView.this.f10430i) {
                            HaoboLog.m49290e(HaoboLog.baseLogTag, "Video start called!");
                            AdVideoView.this.start(0);
                            AdVideoView.this.f10432k = EnumC2942a.NRF_START;
                            return;
                        }
                        AdVideoView.this.f10432k = EnumC2942a.NRF_PAUSE;
                    }
                });
            } catch (IOException | NullPointerException e) {
                HaoboLog.m49290e(HaoboLog.videoLogTag, HaoboLog.getString(C2750R.C2755string.failed_video_load, str, e.getMessage()));
                failed();
            }
        } catch (NullPointerException | URISyntaxException unused) {
            HaoboLog.m49290e(HaoboLog.videoLogTag, HaoboLog.getString(C2750R.C2755string.invalid_video_url, str));
            failed();
        }
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void visible() {
        this.mAdWebView.setVisibility(0);
        this.mAdWebView.adViewImpl.showAdLogo(this);
        AdWebView adWebView = this.mAdWebView;
        if (adWebView == null || !adWebView.shouldDisplayButton()) {
            return;
        }
        AdWebView adWebView2 = this.mAdWebView;
        if (adWebView2.adViewImpl != null) {
            int autoCloseTime = adWebView2.getAutoCloseTime();
            int i = this.f10434m;
            if (autoCloseTime > i) {
                AdWebView adWebView3 = this.mAdWebView;
                adWebView3.adViewImpl.addCloseButton(i, adWebView3.getShowCloseBtnTime(), this.f10434m, this, this.mAdWebView.f10626ad.getAdType() == EnumType.EnumC2812a.ADP_IVIDEO);
            } else {
                AdWebView adWebView4 = this.mAdWebView;
                adWebView4.adViewImpl.addCloseButton(i, adWebView4.getShowCloseBtnTime(), this.mAdWebView.getAutoCloseTime(), this, this.mAdWebView.f10626ad.getAdType() == EnumType.EnumC2812a.ADP_IVIDEO);
                this.mAdWebView.adViewImpl.addMuteButton(this, this.f10431j);
            }
        }
        AdViewImpl adViewImpl = this.mAdWebView.adViewImpl;
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
            return;
        }
        this.mAdWebView.adViewImpl.getAdDispatcher().mo49222a();
        AdWebView adWebView5 = this.mAdWebView;
        adWebView5.f10626ad.handleView(this, adWebView5.adViewImpl.getAdParameters().m49519a());
    }

    /* renamed from: b */
    private void m49274b(int i, int i2) {
        if (i == 0 && i2 == 0) {
            onResume();
            this.f10430i = true;
            return;
        }
        onPause();
        this.f10430i = false;
    }

    public void prepare() throws IOException, IllegalStateException {
        prepare(null);
    }

    public void prepareAsync() throws IllegalStateException {
        prepareAsync(null);
    }

    public void setDataSource(@NonNull String str) throws IOException {
        m49282a();
        this.f10422a.setDataSource(str);
    }

    /* renamed from: a */
    private void m49279a(int i, int i2) {
        Matrix m49267a;
        if (i == 0 || i2 == 0 || (m49267a = new AdVideoManager(new AdVideoManager.C2946c(getWidth(), getHeight()), new AdVideoManager.C2946c(i, i2)).m49267a(this.f10423b)) == null) {
            return;
        }
        setTransform(m49267a);
    }

    public void setDataSource(@NonNull Context context, @NonNull Uri uri, @Nullable Map<String, String> map) throws IOException {
        m49282a();
        this.f10422a.setDataSource(context, uri, map);
    }

    public void setDataSource(@NonNull Context context, @NonNull Uri uri) throws IOException {
        m49282a();
        this.f10422a.setDataSource(context, uri);
    }

    /* renamed from: a */
    private void m49282a() {
        if (this.f10422a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f10422a = mediaPlayer;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void setDataSource(@NonNull FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        m49282a();
        this.f10422a.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(@NonNull FileDescriptor fileDescriptor) throws IOException {
        m49282a();
        this.f10422a.setDataSource(fileDescriptor);
    }

    /* renamed from: a */
    private void m49275a(HashMap hashMap) {
        if (hashMap.isEmpty()) {
            return;
        }
        if (hashMap.containsKey(ServerResponse.EXTRAS_KEY_SCALE)) {
            String str = (String) hashMap.get(ServerResponse.EXTRAS_KEY_SCALE);
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -2092301763:
                    if (str.equals("RIGHT_TOP_CROP")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1943089714:
                    if (str.equals("RIGHT_BOTTOM")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1923874824:
                    if (str.equals("RIGHT_CENTER")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1792626435:
                    if (str.equals("LEFT_TOP")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1629510025:
                    if (str.equals("RIGHT_CENTER_CROP")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1130639214:
                    if (str.equals("LEFT_TOP_CROP")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1092027392:
                    if (str.equals("END_INSIDE")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1025888925:
                    if (str.equals("LEFT_BOTTOM")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1006674035:
                    if (str.equals("LEFT_CENTER")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -440887238:
                    if (str.equals("CENTER_CROP")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -438941894:
                    if (str.equals("CENTER_BOTTOM_CROP")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -188276732:
                    if (str.equals("CENTER_TOP_CROP")) {
                        c = 11;
                        break;
                    }
                    break;
                case -172377086:
                    if (str.equals("LEFT_CENTER_CROP")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -128849043:
                    if (str.equals("FIT_END")) {
                        c = io.netty.util.internal.StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 378209945:
                    if (str.equals("START_INSIDE")) {
                        c = 14;
                        break;
                    }
                    break;
                case 384437857:
                    if (str.equals("RIGHT_BOTTOM_CROP")) {
                        c = 15;
                        break;
                    }
                    break;
                case 743229044:
                    if (str.equals("FIT_START")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1093733475:
                    if (str.equals("FIT_CENTER")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1218764914:
                    if (str.equals("RIGHT_TOP")) {
                        c = 18;
                        break;
                    }
                    break;
                case 1477882197:
                    if (str.equals("CENTER_BOTTOM")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1648362059:
                    if (str.equals("CENTER_TOP")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1677322022:
                    if (str.equals("CENTER_INSIDE")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1841570796:
                    if (str.equals("LEFT_BOTTOM_CROP")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1984282709:
                    if (str.equals("CENTER")) {
                        c = 23;
                        break;
                    }
                    break;
                case 2074054159:
                    if (str.equals("FIT_XY")) {
                        c = 24;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.f10423b = AdVideoManager.EnumC2945b.RIGHT_TOP_CROP;
                    break;
                case 1:
                    this.f10423b = AdVideoManager.EnumC2945b.RIGHT_BOTTOM;
                    break;
                case 2:
                    this.f10423b = AdVideoManager.EnumC2945b.RIGHT_CENTER;
                    break;
                case 3:
                    this.f10423b = AdVideoManager.EnumC2945b.LEFT_TOP;
                    break;
                case 4:
                    this.f10423b = AdVideoManager.EnumC2945b.RIGHT_CENTER_CROP;
                    break;
                case 5:
                    this.f10423b = AdVideoManager.EnumC2945b.LEFT_TOP_CROP;
                    break;
                case 6:
                    this.f10423b = AdVideoManager.EnumC2945b.END_INSIDE;
                    break;
                case 7:
                    this.f10423b = AdVideoManager.EnumC2945b.LEFT_BOTTOM;
                    break;
                case '\b':
                    this.f10423b = AdVideoManager.EnumC2945b.LEFT_CENTER;
                    break;
                case '\t':
                    this.f10423b = AdVideoManager.EnumC2945b.CENTER_CROP;
                    break;
                case '\n':
                    this.f10423b = AdVideoManager.EnumC2945b.CENTER_BOTTOM_CROP;
                    break;
                case 11:
                    this.f10423b = AdVideoManager.EnumC2945b.CENTER_TOP_CROP;
                    break;
                case '\f':
                    this.f10423b = AdVideoManager.EnumC2945b.LEFT_CENTER_CROP;
                    break;
                case '\r':
                    this.f10423b = AdVideoManager.EnumC2945b.FIT_END;
                    break;
                case 14:
                    this.f10423b = AdVideoManager.EnumC2945b.START_INSIDE;
                    break;
                case 15:
                    this.f10423b = AdVideoManager.EnumC2945b.RIGHT_BOTTOM_CROP;
                    break;
                case 16:
                    this.f10423b = AdVideoManager.EnumC2945b.FIT_START;
                    break;
                case 17:
                    this.f10423b = AdVideoManager.EnumC2945b.FIT_CENTER;
                    break;
                case 18:
                    this.f10423b = AdVideoManager.EnumC2945b.RIGHT_TOP;
                    break;
                case 19:
                    this.f10423b = AdVideoManager.EnumC2945b.CENTER_BOTTOM;
                    break;
                case 20:
                    this.f10423b = AdVideoManager.EnumC2945b.CENTER_TOP;
                    break;
                case 21:
                    this.f10423b = AdVideoManager.EnumC2945b.CENTER_INSIDE;
                    break;
                case 22:
                    this.f10423b = AdVideoManager.EnumC2945b.LEFT_BOTTOM_CROP;
                    break;
                case 23:
                    this.f10423b = AdVideoManager.EnumC2945b.CENTER;
                    break;
                case 24:
                    this.f10423b = AdVideoManager.EnumC2945b.FIT_XY;
                    break;
                default:
                    this.f10423b = AdVideoManager.EnumC2945b.FIT_CENTER;
                    break;
            }
        }
        if (hashMap.containsKey(ServerResponse.EXTRAS_KEY_REWARD_ITEM)) {
            String str2 = (String) hashMap.get(ServerResponse.EXTRAS_KEY_REWARD_ITEM);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("type");
                Integer valueOf = Integer.valueOf(jSONObject.optInt(RewardPlus.AMOUNT));
                if (!TextUtils.isEmpty(optString)) {
                    this.f10433l = Pair.create(optString, valueOf);
                } else {
                    this.f10433l = Pair.create("coin", 10);
                }
            } catch (JSONException unused) {
                String str3 = HaoboLog.jsonLogTag;
                HaoboLog.m49290e(str3, "Error parse rewarded item: " + str2);
                this.f10433l = Pair.create("coin", 10);
            }
        }
    }

    /* renamed from: a */
    private static float m49280a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return m49281a((float) Math.sqrt((f5 * f5) + (f6 * f6)));
    }

    /* renamed from: a */
    private static float m49281a(float f) {
        return f / BeiZiImpl.m49492a().m49467k().density;
    }
}
