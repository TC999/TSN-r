package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RawRes;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LottieAnimationView extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private static final String f25276c = LottieAnimationView.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private static final l<Throwable> f25277w = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f25278a;
    private final Set<g> bk;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f25279f;
    private com.bytedance.adsdk.lottie.e fp;
    @RawRes
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25280k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f25281p;

    /* renamed from: r  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25282r;
    private final l<Throwable> sr;

    /* renamed from: t  reason: collision with root package name */
    private final Set<com.bytedance.adsdk.lottie.a> f25283t;
    private l<Throwable> ux;
    private final l<com.bytedance.adsdk.lottie.e> xv;
    private q<com.bytedance.adsdk.lottie.e> ys;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a implements l<Throwable> {
        a() {
        }

        @Override // com.bytedance.adsdk.lottie.l
        /* renamed from: a */
        public void c(Throwable th) {
            if (com.bytedance.adsdk.lottie.f.b.m(th)) {
                com.bytedance.adsdk.lottie.f.e.b("Unable to load composition.", th);
            } else {
                com.bytedance.adsdk.lottie.f.e.b("Unable to parse composition:", th);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class b implements l<com.bytedance.adsdk.lottie.e> {
        b() {
        }

        @Override // com.bytedance.adsdk.lottie.l
        /* renamed from: a */
        public void c(com.bytedance.adsdk.lottie.e eVar) {
            LottieAnimationView.this.setComposition(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f25285a;

        /* renamed from: b  reason: collision with root package name */
        int f25286b;

        /* renamed from: c  reason: collision with root package name */
        float f25287c;

        /* renamed from: d  reason: collision with root package name */
        boolean f25288d;

        /* renamed from: e  reason: collision with root package name */
        String f25289e;

        /* renamed from: f  reason: collision with root package name */
        int f25290f;

        /* renamed from: g  reason: collision with root package name */
        int f25291g;

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        static class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public c[] newArray(int i4) {
                return new c[i4];
            }
        }

        /* synthetic */ c(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeString(this.f25285a);
            parcel.writeFloat(this.f25287c);
            parcel.writeInt(this.f25288d ? 1 : 0);
            parcel.writeString(this.f25289e);
            parcel.writeInt(this.f25290f);
            parcel.writeInt(this.f25291g);
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        private c(Parcel parcel) {
            super(parcel);
            this.f25285a = parcel.readString();
            this.f25287c = parcel.readFloat();
            this.f25288d = parcel.readInt() == 1;
            this.f25289e = parcel.readString();
            this.f25290f = parcel.readInt();
            this.f25291g = parcel.readInt();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class d implements l<Throwable> {
        d() {
        }

        @Override // com.bytedance.adsdk.lottie.l
        /* renamed from: a */
        public void c(Throwable th) {
            if (LottieAnimationView.this.f25279f != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f25279f);
            }
            (LottieAnimationView.this.ux == null ? LottieAnimationView.f25277w : LottieAnimationView.this.ux).c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class e implements Callable<com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f25293a;

        e(int i4) {
            this.f25293a = i4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> call() throws Exception {
            return LottieAnimationView.this.f25278a ? n.p(LottieAnimationView.this.getContext(), this.f25293a) : n.q(LottieAnimationView.this.getContext(), this.f25293a, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class f implements Callable<com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f25295a;

        f(String str) {
            this.f25295a = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> call() throws Exception {
            return LottieAnimationView.this.f25278a ? n.w(LottieAnimationView.this.getContext(), this.f25295a) : n.x(LottieAnimationView.this.getContext(), this.f25295a, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum g {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.xv = new b();
        this.sr = new d();
        this.f25279f = 0;
        this.f25282r = new com.bytedance.adsdk.lottie.d();
        this.f25281p = false;
        this.f25280k = false;
        this.f25278a = true;
        this.bk = new HashSet();
        this.f25283t = new HashSet();
        f();
    }

    private void ev() {
        this.fp = null;
        this.f25282r.A();
    }

    private void f() {
        setSaveEnabled(false);
        this.f25278a = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        c(0.0f, false);
        c(false);
        setIgnoreDisabledSystemAnimations(false);
        this.f25282r.s(Boolean.valueOf(com.bytedance.adsdk.lottie.f.b.b(getContext()) != 0.0f));
    }

    private void gd() {
        boolean w3 = w();
        setImageDrawable(null);
        setImageDrawable(this.f25282r);
        if (w3) {
            this.f25282r.N();
        }
    }

    private void r() {
        q<com.bytedance.adsdk.lottie.e> qVar = this.ys;
        if (qVar != null) {
            qVar.j(this.xv);
            this.ys.i(this.sr);
        }
    }

    private void setCompositionTask(q<com.bytedance.adsdk.lottie.e> qVar) {
        this.bk.add(g.SET_ANIMATION);
        ev();
        r();
        this.ys = qVar.b(this.xv).k(this.sr);
    }

    public boolean getClipToCompositionBounds() {
        return this.f25282r.o0();
    }

    public com.bytedance.adsdk.lottie.e getComposition() {
        return this.fp;
    }

    public long getDuration() {
        com.bytedance.adsdk.lottie.e eVar = this.fp;
        if (eVar != null) {
            return eVar.q();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f25282r.v0();
    }

    public String getImageAssetsFolder() {
        return this.f25282r.p0();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f25282r.b0();
    }

    public float getMaxFrame() {
        return this.f25282r.c();
    }

    public float getMinFrame() {
        return this.f25282r.a();
    }

    public r getPerformanceTracker() {
        return this.f25282r.D();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f25282r.H();
    }

    public i getRenderMode() {
        return this.f25282r.f0();
    }

    public int getRepeatCount() {
        return this.f25282r.L();
    }

    public int getRepeatMode() {
        return this.f25282r.F();
    }

    public float getSpeed() {
        return this.f25282r.c0();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof com.bytedance.adsdk.lottie.d) && ((com.bytedance.adsdk.lottie.d) drawable).f0() == i.SOFTWARE) {
            this.f25282r.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        com.bytedance.adsdk.lottie.d dVar = this.f25282r;
        if (drawable2 == dVar) {
            super.invalidateDrawable(dVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.f25280k) {
            return;
        }
        this.f25282r.I();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i4;
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.ev = cVar.f25285a;
        Set<g> set = this.bk;
        g gVar = g.SET_ANIMATION;
        if (!set.contains(gVar) && !TextUtils.isEmpty(this.ev)) {
            setAnimation(this.ev);
        }
        this.gd = cVar.f25286b;
        if (!this.bk.contains(gVar) && (i4 = this.gd) != 0) {
            setAnimation(i4);
        }
        if (!this.bk.contains(g.SET_PROGRESS)) {
            c(cVar.f25287c, false);
        }
        if (!this.bk.contains(g.PLAY_OPTION) && cVar.f25288d) {
            c();
        }
        if (!this.bk.contains(g.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(cVar.f25289e);
        }
        if (!this.bk.contains(g.SET_REPEAT_MODE)) {
            setRepeatMode(cVar.f25290f);
        }
        if (this.bk.contains(g.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(cVar.f25291g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f25285a = this.ev;
        cVar.f25286b = this.gd;
        cVar.f25287c = this.f25282r.H();
        cVar.f25288d = this.f25282r.G();
        cVar.f25289e = this.f25282r.p0();
        cVar.f25290f = this.f25282r.F();
        cVar.f25291g = this.f25282r.L();
        return cVar;
    }

    public void setAnimation(@RawRes int i4) {
        this.gd = i4;
        this.ev = null;
        setCompositionTask(c(i4));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        c(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f25278a ? n.h(getContext(), str) : n.i(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z3) {
        this.f25282r.E(z3);
    }

    public void setCacheComposition(boolean z3) {
        this.f25278a = z3;
    }

    public void setClipToCompositionBounds(boolean z3) {
        this.f25282r.n0(z3);
    }

    public void setComposition(com.bytedance.adsdk.lottie.e eVar) {
        if (s.f25706a) {
            String str = f25276c;
            Log.v(str, "Set Composition \n" + eVar);
        }
        this.f25282r.setCallback(this);
        this.fp = eVar;
        this.f25281p = true;
        boolean x3 = this.f25282r.x(eVar);
        this.f25281p = false;
        if (getDrawable() != this.f25282r || x3) {
            if (!x3) {
                gd();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (com.bytedance.adsdk.lottie.a aVar : this.f25283t) {
                aVar.a(eVar);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f25282r.T(str);
    }

    public void setFailureListener(l<Throwable> lVar) {
        this.ux = lVar;
    }

    public void setFallbackResource(int i4) {
        this.f25279f = i4;
    }

    public void setFontAssetDelegate(u uVar) {
        this.f25282r.r(uVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.f25282r.u(map);
    }

    public void setFrame(int i4) {
        this.f25282r.r0(i4);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z3) {
        this.f25282r.B(z3);
    }

    public void setImageAssetDelegate(p pVar) {
        this.f25282r.q(pVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f25282r.t(str);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        r();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        r();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i4) {
        r();
        super.setImageResource(i4);
    }

    public void setMaintainOriginalImageBounds(boolean z3) {
        this.f25282r.t0(z3);
    }

    public void setMaxFrame(int i4) {
        this.f25282r.k0(i4);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f25282r.j0(f4);
    }

    public void setMinAndMaxFrame(String str) {
        this.f25282r.Z(str);
    }

    public void setMinFrame(int i4) {
        this.f25282r.h(i4);
    }

    public void setMinProgress(float f4) {
        this.f25282r.g(f4);
    }

    public void setOutlineMasksAndMattes(boolean z3) {
        this.f25282r.h0(z3);
    }

    public void setPerformanceTrackingEnabled(boolean z3) {
        this.f25282r.a0(z3);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        c(f4, true);
    }

    public void setRenderMode(i iVar) {
        this.f25282r.o(iVar);
    }

    public void setRepeatCount(int i4) {
        this.bk.add(g.SET_REPEAT_COUNT);
        this.f25282r.g0(i4);
    }

    public void setRepeatMode(int i4) {
        this.bk.add(g.SET_REPEAT_MODE);
        this.f25282r.Y(i4);
    }

    public void setSafeMode(boolean z3) {
        this.f25282r.U(z3);
    }

    public void setSpeed(float f4) {
        this.f25282r.q0(f4);
    }

    public void setTextDelegate(m mVar) {
        this.f25282r.p(mVar);
    }

    public void setUseCompositionFrameRate(boolean z3) {
        this.f25282r.J(z3);
    }

    @MainThread
    public void sr() {
        this.f25280k = false;
        this.f25282r.O();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        com.bytedance.adsdk.lottie.d dVar;
        if (!this.f25281p && drawable == (dVar = this.f25282r) && dVar.W()) {
            sr();
        } else if (!this.f25281p && (drawable instanceof com.bytedance.adsdk.lottie.d)) {
            com.bytedance.adsdk.lottie.d dVar2 = (com.bytedance.adsdk.lottie.d) drawable;
            if (dVar2.W()) {
                dVar2.O();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void c(boolean z3) {
        this.f25282r.v(z3);
    }

    public void setMaxFrame(String str) {
        this.f25282r.s0(str);
    }

    public void setMinFrame(String str) {
        this.f25282r.m0(str);
    }

    @Deprecated
    public void w(boolean z3) {
        this.f25282r.g0(z3 ? -1 : 0);
    }

    @MainThread
    public void xv() {
        this.bk.add(g.PLAY_OPTION);
        this.f25282r.M();
    }

    private q<com.bytedance.adsdk.lottie.e> c(@RawRes int i4) {
        if (isInEditMode()) {
            return new q<>(new e(i4), true);
        }
        return this.f25278a ? n.f(getContext(), i4) : n.g(getContext(), i4, null);
    }

    public boolean w() {
        return this.f25282r.W();
    }

    public void setAnimation(String str) {
        this.ev = str;
        this.gd = 0;
        setCompositionTask(c(str));
    }

    private q<com.bytedance.adsdk.lottie.e> c(String str) {
        if (isInEditMode()) {
            return new q<>(new f(str), true);
        }
        return this.f25278a ? n.t(getContext(), str) : n.u(getContext(), str, null);
    }

    public void c(String str, String str2) {
        c(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void c(InputStream inputStream, String str) {
        setCompositionTask(n.j(inputStream, str));
    }

    @MainThread
    public void c() {
        this.bk.add(g.PLAY_OPTION);
        this.f25282r.I();
    }

    public Bitmap c(String str, Bitmap bitmap) {
        return this.f25282r.d(str, bitmap);
    }

    private void c(@FloatRange(from = 0.0d, to = 1.0d) float f4, boolean z3) {
        if (z3) {
            this.bk.add(g.SET_PROGRESS);
        }
        this.f25282r.X(f4);
    }
}
