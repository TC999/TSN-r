package com.bytedance.adsdk.xv;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.h;
import com.bytedance.adsdk.lottie.p;
import com.bytedance.adsdk.ugeno.component.b;
import j0.a;
import java.util.HashMap;
import l0.i;
import n0.d;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends b<LottieAnimationView> {
    private float A;
    private float B;
    private HashMap<String, Bitmap> C;
    protected ImageView.ScaleType D;

    /* renamed from: d  reason: collision with root package name */
    private String f26465d;

    /* renamed from: e  reason: collision with root package name */
    private String f26466e;

    /* renamed from: l  reason: collision with root package name */
    private boolean f26467l;

    /* renamed from: o  reason: collision with root package name */
    private boolean f26468o;

    /* renamed from: v  reason: collision with root package name */
    private boolean f26469v;

    /* renamed from: com.bytedance.adsdk.xv.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class C0366a implements p {

        /* renamed from: com.bytedance.adsdk.xv.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        class C0367a implements a.InterfaceC1087a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f26471a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f26472b;

            C0367a(h hVar, String str) {
                this.f26471a = hVar;
                this.f26472b = str;
            }

            @Override // j0.a.InterfaceC1087a
            public void c(Bitmap bitmap) {
                if (bitmap != null) {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, this.f26471a.a(), this.f26471a.e(), false);
                    a.this.C.put(this.f26472b, createScaledBitmap);
                    ((LottieAnimationView) ((b) a.this).ux).c(this.f26471a.f(), createScaledBitmap);
                }
            }
        }

        C0366a() {
        }

        @Override // com.bytedance.adsdk.lottie.p
        public Bitmap c(h hVar) {
            if (hVar == null) {
                return null;
            }
            String c4 = hVar.c();
            if (TextUtils.isEmpty(c4)) {
                return null;
            }
            String a4 = d.a(c4, ((b) a.this).sr);
            j0.b.a().c().c(a4, new C0367a(hVar, a4));
            return (Bitmap) a.this.C.get(a4);
        }
    }

    public a(Context context) {
        super(context);
        this.f26466e = "images";
        this.B = 1.0f;
        this.D = ImageView.ScaleType.FIT_CENTER;
        this.C = new HashMap<>();
    }

    private ImageView.ScaleType e(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(AutoScrollViewPager.f4767g)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1274298614:
                if (str.equals("fitEnd")) {
                    c4 = 1;
                    break;
                }
                break;
            case -522179887:
                if (str.equals("fitStart")) {
                    c4 = 2;
                    break;
                }
                break;
            case -340708175:
                if (str.equals("centerInside")) {
                    c4 = 3;
                    break;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    c4 = 4;
                    break;
                }
                break;
            case 520762310:
                if (str.equals("fitCenter")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return ImageView.ScaleType.CENTER;
            case 1:
                return ImageView.ScaleType.FIT_END;
            case 2:
                return ImageView.ScaleType.FIT_START;
            case 3:
                return ImageView.ScaleType.CENTER_INSIDE;
            case 4:
                return ImageView.ScaleType.FIT_XY;
            case 5:
                return ImageView.ScaleType.FIT_CENTER;
            case 6:
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private String g(String str) {
        return (!TextUtils.isEmpty(str) && str.contains("local")) ? str.contains("shake_phone") ? "lottie_json/shake_phone.json" : str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "" : "";
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: b */
    public LottieAnimationView xv() {
        return new LottieAnimationView(this.f26040w);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.c(str, str2);
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1877911644:
                if (str.equals("scaleType")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c4 = 1;
                    break;
                }
                break;
            case -878289888:
                if (str.equals("imagePath")) {
                    c4 = 2;
                    break;
                }
                break;
            case -291235277:
                if (str.equals("autoReverse")) {
                    c4 = 3;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c4 = 4;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c4 = 5;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1438608771:
                if (str.equals("autoPlay")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.D = e(str2);
                return;
            case 1:
                this.A = i.a(str2, 0.0f);
                return;
            case 2:
                this.f26466e = str2;
                return;
            case 3:
                this.f26467l = i.d(str2, false);
                return;
            case 4:
                this.f26465d = str2;
                return;
            case 5:
                this.f26468o = i.d(str2, false);
                return;
            case 6:
                this.B = i.a(str2, 1.0f);
                return;
            case 7:
                this.f26469v = i.d(str2, false);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ((LottieAnimationView) this.ux).setProgress(this.A);
        if (this.B <= 0.0f) {
            this.B = 1.0f;
        }
        ((LottieAnimationView) this.ux).setSpeed(this.B);
        if (this.f26465d.startsWith("local")) {
            ((LottieAnimationView) this.ux).setAnimation(g(this.f26465d));
            ((LottieAnimationView) this.ux).setImageAssetsFolder(this.f26466e);
        } else {
            ((LottieAnimationView) this.ux).setAnimationFromUrl(this.f26465d);
            ((LottieAnimationView) this.ux).setImageAssetDelegate(new C0366a());
        }
        ((LottieAnimationView) this.ux).setScaleType(this.D);
        ((LottieAnimationView) this.ux).w(this.f26468o);
        ((LottieAnimationView) this.ux).c();
    }
}
