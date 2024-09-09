package com.beizi.ad.internal.video;

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
import com.beizi.ad.R;
import com.beizi.ad.c.e;
import com.beizi.ad.internal.activity.b;
import com.beizi.ad.internal.b.f;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.utilities.UserEnvInfoUtil;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.internal.video.a;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.InterstitialAdViewImpl;
import com.beizi.ad.internal.view.c;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, c {

    /* renamed from: a  reason: collision with root package name */
    protected MediaPlayer f14023a;

    /* renamed from: b  reason: collision with root package name */
    protected a.b f14024b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14025c;

    /* renamed from: d  reason: collision with root package name */
    private int f14026d;

    /* renamed from: e  reason: collision with root package name */
    private int f14027e;

    /* renamed from: f  reason: collision with root package name */
    private int f14028f;

    /* renamed from: g  reason: collision with root package name */
    private int f14029g;

    /* renamed from: h  reason: collision with root package name */
    private int f14030h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14031i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14032j;

    /* renamed from: k  reason: collision with root package name */
    private a f14033k;

    /* renamed from: l  reason: collision with root package name */
    private Pair<String, Integer> f14034l;

    /* renamed from: m  reason: collision with root package name */
    private int f14035m;
    public AdWebView mAdWebView;

    /* renamed from: n  reason: collision with root package name */
    private long f14036n;

    /* renamed from: o  reason: collision with root package name */
    private float f14037o;

    /* renamed from: p  reason: collision with root package name */
    private float f14038p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f14039q;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        NRF_NONE,
        NRF_START,
        NRF_PAUSE
    }

    public AdVideoView(AdWebView adWebView) {
        super(new MutableContextWrapper(adWebView.getContextFromMutableContext()));
        this.f14025c = false;
        this.f14031i = false;
        this.f14032j = false;
        this.f14033k = a.NRF_NONE;
        this.f14034l = null;
        this.f14024b = a.b.FIT_CENTER;
        this.f14035m = -1;
        this.mAdWebView = adWebView;
    }

    private void setDataSource(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    @Override // com.beizi.ad.internal.view.c
    public void destroy() {
        stop();
        ViewUtil.removeChildFromParent(this);
    }

    @Override // com.beizi.ad.internal.view.c
    public boolean failed() {
        return this.f14025c;
    }

    public AdWebView getAdWebView() {
        return this.mAdWebView;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeHeight() {
        return this.f14029g;
    }

    public int getCreativeLeft() {
        return this.f14026d;
    }

    public int getCreativeTop() {
        return this.f14027e;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeWidth() {
        return this.f14028f;
    }

    public int getCurrentPosition() {
        return this.f14023a.getCurrentPosition();
    }

    public int getDuration() {
        return this.f14023a.getDuration();
    }

    @Override // com.beizi.ad.internal.view.c
    public int getRefreshInterval() {
        return this.f14030h;
    }

    public int getVideoHeight() {
        return this.f14023a.getVideoHeight();
    }

    public int getVideoWidth() {
        return this.f14023a.getVideoWidth();
    }

    @Override // com.beizi.ad.internal.view.c
    public View getView() {
        return this;
    }

    public boolean isLooping() {
        return this.f14023a.isLooping();
    }

    public boolean isPlaying() {
        return this.f14023a.isPlaying();
    }

    @Override // com.beizi.ad.internal.view.c
    public void onDestroy() {
        destroy();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f14023a == null) {
            return;
        }
        if (isPlaying()) {
            stop();
        }
        release();
    }

    @Override // com.beizi.ad.internal.view.c
    public void onPause() {
        if (this.f14033k == a.NRF_START) {
            pause();
            this.f14033k = a.NRF_PAUSE;
        }
    }

    @Override // com.beizi.ad.internal.view.c
    public void onResume() {
        if (this.f14033k == a.NRF_PAUSE) {
            start(1);
            this.f14033k = a.NRF_START;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.f14023a;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        AdWebView adWebView;
        AdViewImpl adViewImpl;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.f14039q && a(this.f14037o, this.f14038p, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                    this.f14039q = false;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis() - this.f14036n;
                Log.d("lance", "ACTION_UP:" + currentTimeMillis);
                if (currentTimeMillis < 1000 && this.f14039q && (adWebView = this.mAdWebView) != null && (adViewImpl = adWebView.adViewImpl) != null && adViewImpl.getAdDispatcher() != null) {
                    AdViewImpl adViewImpl2 = this.mAdWebView.adViewImpl;
                    adViewImpl2.clickCount++;
                    adViewImpl2.getAdDispatcher().d();
                    AdWebView adWebView2 = this.mAdWebView;
                    adWebView2.ad.setOpenInNativeBrowser(adWebView2.adViewImpl.getOpensNativeBrowser());
                }
            }
            z3 = false;
        } else {
            this.f14036n = System.currentTimeMillis();
            this.f14037o = motionEvent.getX();
            this.f14038p = motionEvent.getY();
            this.f14039q = true;
            Log.d("lance", "ACTION_DOWN");
            z3 = true;
        }
        return super.onTouchEvent(motionEvent) || z3;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i4, int i5) {
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        b(getWindowVisibility(), i4);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        b(i4, getVisibility());
    }

    public void pause() {
        MediaPlayer mediaPlayer = this.f14023a;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            this.mAdWebView.ad.handleOnPause(this);
        }
    }

    public void prepare(@Nullable MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        this.f14023a.setOnPreparedListener(onPreparedListener);
        this.f14023a.prepare();
    }

    public void prepareAsync(@Nullable MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.f14023a.setOnPreparedListener(onPreparedListener);
        this.f14023a.prepareAsync();
    }

    public void release() {
        reset();
        this.f14023a.release();
        this.f14023a = null;
    }

    public void reset() {
        this.f14023a.reset();
    }

    public void seekTo(int i4) {
        MediaPlayer mediaPlayer = this.f14023a;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i4);
        }
    }

    public void setAssetData(@NonNull String str) throws IOException {
        setDataSource(getContext().getAssets().openFd(str));
    }

    public void setCreativeLeft(int i4) {
        this.f14026d = i4;
    }

    public void setCreativeTop(int i4) {
        this.f14027e = i4;
    }

    public void setLooping(boolean z3) {
        MediaPlayer mediaPlayer = this.f14023a;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z3);
        }
    }

    public void setOnCompletionListener(@Nullable MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f14023a.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(@Nullable MediaPlayer.OnErrorListener onErrorListener) {
        this.f14023a.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(@Nullable MediaPlayer.OnInfoListener onInfoListener) {
        this.f14023a.setOnInfoListener(onInfoListener);
    }

    public void setRawData(@RawRes int i4) throws IOException {
        setDataSource(getResources().openRawResourceFd(i4));
    }

    public void setRefreshInterval(int i4) {
        this.f14030h = i4;
    }

    public void setScalableType(a.b bVar) {
        this.f14024b = bVar;
        a(getVideoWidth(), getVideoHeight());
    }

    public void setVolume(float f4, float f5) {
        MediaPlayer mediaPlayer = this.f14023a;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f4, f5);
        }
    }

    public void start(int i4) {
        MediaPlayer mediaPlayer = this.f14023a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.mAdWebView.ad.handleOnStart(this, i4);
        }
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.f14023a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public boolean toggleMute() {
        boolean z3 = !this.f14032j;
        this.f14032j = z3;
        if (z3) {
            setVolume(0.0f, 0.0f);
        } else {
            setVolume(1.0f, 1.0f);
        }
        return this.f14032j;
    }

    public void transferAd(final AdWebView adWebView, String str) {
        int i4;
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.f14029g = adWebView.getCreativeHeight();
        this.f14028f = adWebView.getCreativeWidth();
        this.f14027e = adWebView.getCreativeTop();
        this.f14026d = adWebView.getCreativeLeft();
        this.f14030h = adWebView.getRefreshInterval();
        try {
            new URI(str);
            this.f14024b = a.b.FIT_CENTER;
            HaoboLog.v(HaoboLog.videoLogTag, HaoboLog.getString(R.string.videoview_loading, str));
            a(adWebView.getAdExtras());
            try {
                f b4 = h.a().b();
                if (!UserEnvInfoUtil.isUsingWifi(h.a().e()) && this.mAdWebView.IsVideoWifiOnly() && !b4.b(str)) {
                    HaoboLog.e(HaoboLog.videoLogTag, HaoboLog.getString(R.string.wifi_video_load, str));
                    failed();
                    return;
                }
                setDataSource(b4.a(str));
                boolean isMuted = adWebView.isMuted();
                this.f14032j = isMuted;
                if (isMuted) {
                    setVolume(0.0f, 0.0f);
                } else {
                    setVolume(1.0f, 1.0f);
                }
                float h4 = h.a().h();
                float i5 = h.a().i();
                int i6 = -1;
                if (getCreativeWidth() == 1 && getCreativeHeight() == 1) {
                    i4 = -1;
                } else {
                    int creativeWidth = (int) ((getCreativeWidth() * h4) + 0.5f);
                    i6 = (int) ((getCreativeHeight() * i5) + 0.5f);
                    i4 = creativeWidth;
                }
                if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                    setLayoutParams(new FrameLayout.LayoutParams(i4, i6, 17));
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i6, 8388659);
                    layoutParams.setMargins((int) ((getCreativeLeft() * h4) + 0.5f), (int) ((getCreativeTop() * i5) + 0.5f), 0, 0);
                    setLayoutParams(layoutParams);
                    setScalableType(a.b.FIT_START);
                }
                setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.beizi.ad.internal.video.AdVideoView.1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        AdVideoView.this.mAdWebView.ad.handleOnCompletion();
                        if (AdVideoView.this.f14034l != null) {
                            AdVideoView.this.mAdWebView.adViewImpl.getAdDispatcher().a((String) AdVideoView.this.f14034l.first, ((Integer) AdVideoView.this.f14034l.second).intValue());
                        }
                        if (!AdVideoView.this.mAdWebView.loadAdBy(1)) {
                            Log.d("lance", "We can't go next, just stand here");
                            return;
                        }
                        AdViewImpl adViewImpl = adWebView.adViewImpl;
                        if (adViewImpl instanceof InterstitialAdViewImpl) {
                            if (((InterstitialAdViewImpl) adViewImpl).getAdImplementation() != null) {
                                ((b) ((InterstitialAdViewImpl) adWebView.adViewImpl).getAdImplementation()).g();
                            } else {
                                Log.d("lance", "Error in incentive video ad adaptation model !");
                            }
                        }
                    }
                });
                setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.beizi.ad.internal.video.AdVideoView.2
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer, int i7, int i8) {
                        AdWebView adWebView2;
                        AdViewImpl adViewImpl;
                        if (i7 != 3 || (adWebView2 = AdVideoView.this.mAdWebView) == null || (adViewImpl = adWebView2.adViewImpl) == null || adViewImpl.getAdDispatcher() == null) {
                            return false;
                        }
                        AdVideoView.this.mAdWebView.adViewImpl.getAdDispatcher().f();
                        return false;
                    }
                });
                prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.beizi.ad.internal.video.AdVideoView.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        AdVideoView.this.f14035m = mediaPlayer.getDuration() / 1000;
                        Log.d("lance", "mPlayTime:" + AdVideoView.this.f14035m);
                        if (AdVideoView.this.f14031i) {
                            HaoboLog.e(HaoboLog.baseLogTag, "Video start called!");
                            AdVideoView.this.start(0);
                            AdVideoView.this.f14033k = a.NRF_START;
                            return;
                        }
                        AdVideoView.this.f14033k = a.NRF_PAUSE;
                    }
                });
            } catch (IOException | NullPointerException e4) {
                HaoboLog.e(HaoboLog.videoLogTag, HaoboLog.getString(R.string.failed_video_load, str, e4.getMessage()));
                failed();
            }
        } catch (NullPointerException | URISyntaxException unused) {
            HaoboLog.e(HaoboLog.videoLogTag, HaoboLog.getString(R.string.invalid_video_url, str));
            failed();
        }
    }

    @Override // com.beizi.ad.internal.view.c
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
            int i4 = this.f14035m;
            if (autoCloseTime > i4) {
                AdWebView adWebView3 = this.mAdWebView;
                adWebView3.adViewImpl.addCloseButton(i4, adWebView3.getShowCloseBtnTime(), this.f14035m, this, this.mAdWebView.ad.getAdType() == e.a.ADP_IVIDEO);
            } else {
                AdWebView adWebView4 = this.mAdWebView;
                adWebView4.adViewImpl.addCloseButton(i4, adWebView4.getShowCloseBtnTime(), this.mAdWebView.getAutoCloseTime(), this, this.mAdWebView.ad.getAdType() == e.a.ADP_IVIDEO);
                this.mAdWebView.adViewImpl.addMuteButton(this, this.f14032j);
            }
        }
        AdViewImpl adViewImpl = this.mAdWebView.adViewImpl;
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
            return;
        }
        this.mAdWebView.adViewImpl.getAdDispatcher().a();
        AdWebView adWebView5 = this.mAdWebView;
        adWebView5.ad.handleView(this, adWebView5.adViewImpl.getAdParameters().a());
    }

    private void b(int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            onResume();
            this.f14031i = true;
            return;
        }
        onPause();
        this.f14031i = false;
    }

    public void prepare() throws IOException, IllegalStateException {
        prepare(null);
    }

    public void prepareAsync() throws IllegalStateException {
        prepareAsync(null);
    }

    public void setDataSource(@NonNull String str) throws IOException {
        a();
        this.f14023a.setDataSource(str);
    }

    private void a(int i4, int i5) {
        Matrix a4;
        if (i4 == 0 || i5 == 0 || (a4 = new com.beizi.ad.internal.video.a(new a.c(getWidth(), getHeight()), new a.c(i4, i5)).a(this.f14024b)) == null) {
            return;
        }
        setTransform(a4);
    }

    public void setDataSource(@NonNull Context context, @NonNull Uri uri, @Nullable Map<String, String> map) throws IOException {
        a();
        this.f14023a.setDataSource(context, uri, map);
    }

    public void setDataSource(@NonNull Context context, @NonNull Uri uri) throws IOException {
        a();
        this.f14023a.setDataSource(context, uri);
    }

    private void a() {
        if (this.f14023a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f14023a = mediaPlayer;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void setDataSource(@NonNull FileDescriptor fileDescriptor, long j4, long j5) throws IOException {
        a();
        this.f14023a.setDataSource(fileDescriptor, j4, j5);
    }

    public void setDataSource(@NonNull FileDescriptor fileDescriptor) throws IOException {
        a();
        this.f14023a.setDataSource(fileDescriptor);
    }

    private void a(HashMap hashMap) {
        if (hashMap.isEmpty()) {
            return;
        }
        if (hashMap.containsKey("SCALE")) {
            String str = (String) hashMap.get("SCALE");
            str.hashCode();
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -2092301763:
                    if (str.equals("RIGHT_TOP_CROP")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1943089714:
                    if (str.equals("RIGHT_BOTTOM")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1923874824:
                    if (str.equals("RIGHT_CENTER")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -1792626435:
                    if (str.equals("LEFT_TOP")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -1629510025:
                    if (str.equals("RIGHT_CENTER_CROP")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case -1130639214:
                    if (str.equals("LEFT_TOP_CROP")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -1092027392:
                    if (str.equals("END_INSIDE")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case -1025888925:
                    if (str.equals("LEFT_BOTTOM")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case -1006674035:
                    if (str.equals("LEFT_CENTER")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case -440887238:
                    if (str.equals("CENTER_CROP")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case -438941894:
                    if (str.equals("CENTER_BOTTOM_CROP")) {
                        c4 = '\n';
                        break;
                    }
                    break;
                case -188276732:
                    if (str.equals("CENTER_TOP_CROP")) {
                        c4 = 11;
                        break;
                    }
                    break;
                case -172377086:
                    if (str.equals("LEFT_CENTER_CROP")) {
                        c4 = '\f';
                        break;
                    }
                    break;
                case -128849043:
                    if (str.equals("FIT_END")) {
                        c4 = '\r';
                        break;
                    }
                    break;
                case 378209945:
                    if (str.equals("START_INSIDE")) {
                        c4 = 14;
                        break;
                    }
                    break;
                case 384437857:
                    if (str.equals("RIGHT_BOTTOM_CROP")) {
                        c4 = 15;
                        break;
                    }
                    break;
                case 743229044:
                    if (str.equals("FIT_START")) {
                        c4 = 16;
                        break;
                    }
                    break;
                case 1093733475:
                    if (str.equals("FIT_CENTER")) {
                        c4 = 17;
                        break;
                    }
                    break;
                case 1218764914:
                    if (str.equals("RIGHT_TOP")) {
                        c4 = 18;
                        break;
                    }
                    break;
                case 1477882197:
                    if (str.equals("CENTER_BOTTOM")) {
                        c4 = 19;
                        break;
                    }
                    break;
                case 1648362059:
                    if (str.equals("CENTER_TOP")) {
                        c4 = 20;
                        break;
                    }
                    break;
                case 1677322022:
                    if (str.equals("CENTER_INSIDE")) {
                        c4 = 21;
                        break;
                    }
                    break;
                case 1841570796:
                    if (str.equals("LEFT_BOTTOM_CROP")) {
                        c4 = 22;
                        break;
                    }
                    break;
                case 1984282709:
                    if (str.equals("CENTER")) {
                        c4 = 23;
                        break;
                    }
                    break;
                case 2074054159:
                    if (str.equals("FIT_XY")) {
                        c4 = 24;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    this.f14024b = a.b.RIGHT_TOP_CROP;
                    break;
                case 1:
                    this.f14024b = a.b.RIGHT_BOTTOM;
                    break;
                case 2:
                    this.f14024b = a.b.RIGHT_CENTER;
                    break;
                case 3:
                    this.f14024b = a.b.LEFT_TOP;
                    break;
                case 4:
                    this.f14024b = a.b.RIGHT_CENTER_CROP;
                    break;
                case 5:
                    this.f14024b = a.b.LEFT_TOP_CROP;
                    break;
                case 6:
                    this.f14024b = a.b.END_INSIDE;
                    break;
                case 7:
                    this.f14024b = a.b.LEFT_BOTTOM;
                    break;
                case '\b':
                    this.f14024b = a.b.LEFT_CENTER;
                    break;
                case '\t':
                    this.f14024b = a.b.CENTER_CROP;
                    break;
                case '\n':
                    this.f14024b = a.b.CENTER_BOTTOM_CROP;
                    break;
                case 11:
                    this.f14024b = a.b.CENTER_TOP_CROP;
                    break;
                case '\f':
                    this.f14024b = a.b.LEFT_CENTER_CROP;
                    break;
                case '\r':
                    this.f14024b = a.b.FIT_END;
                    break;
                case 14:
                    this.f14024b = a.b.START_INSIDE;
                    break;
                case 15:
                    this.f14024b = a.b.RIGHT_BOTTOM_CROP;
                    break;
                case 16:
                    this.f14024b = a.b.FIT_START;
                    break;
                case 17:
                    this.f14024b = a.b.FIT_CENTER;
                    break;
                case 18:
                    this.f14024b = a.b.RIGHT_TOP;
                    break;
                case 19:
                    this.f14024b = a.b.CENTER_BOTTOM;
                    break;
                case 20:
                    this.f14024b = a.b.CENTER_TOP;
                    break;
                case 21:
                    this.f14024b = a.b.CENTER_INSIDE;
                    break;
                case 22:
                    this.f14024b = a.b.LEFT_BOTTOM_CROP;
                    break;
                case 23:
                    this.f14024b = a.b.CENTER;
                    break;
                case 24:
                    this.f14024b = a.b.FIT_XY;
                    break;
                default:
                    this.f14024b = a.b.FIT_CENTER;
                    break;
            }
        }
        if (hashMap.containsKey("REWARD_ITEM")) {
            String str2 = (String) hashMap.get("REWARD_ITEM");
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("type");
                Integer valueOf = Integer.valueOf(jSONObject.optInt(RewardPlus.AMOUNT));
                if (!TextUtils.isEmpty(optString)) {
                    this.f14034l = Pair.create(optString, valueOf);
                } else {
                    this.f14034l = Pair.create("coin", 10);
                }
            } catch (JSONException unused) {
                String str3 = HaoboLog.jsonLogTag;
                HaoboLog.e(str3, "Error parse rewarded item: " + str2);
                this.f14034l = Pair.create("coin", 10);
            }
        }
    }

    private static float a(float f4, float f5, float f6, float f7) {
        float f8 = f4 - f6;
        float f9 = f5 - f7;
        return a((float) Math.sqrt((f8 * f8) + (f9 * f9)));
    }

    private static float a(float f4) {
        return f4 / h.a().k().density;
    }
}
