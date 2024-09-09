package com.bytedance.adsdk.ugeno.component.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.acse.ottn.adapter.AutoScrollViewPager;
import j0.a;
import l0.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends com.bytedance.adsdk.ugeno.component.b<RoundImageView> {

    /* renamed from: d  reason: collision with root package name */
    protected String f26177d;

    /* renamed from: e  reason: collision with root package name */
    protected ImageView.ScaleType f26178e;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f26179l;

    /* renamed from: o  reason: collision with root package name */
    private int f26180o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class a implements a.InterfaceC1087a {
        a() {
        }

        @Override // j0.a.InterfaceC1087a
        public void c(Bitmap bitmap) {
            Bitmap d4;
            if (bitmap == null) {
                return;
            }
            ((RoundImageView) ((com.bytedance.adsdk.ugeno.component.b) b.this).ux).setImageBitmap(bitmap);
            b bVar = b.this;
            if (!bVar.f26179l || (d4 = l0.b.d(((com.bytedance.adsdk.ugeno.component.b) bVar).f26040w, bitmap, 10)) == null) {
                return;
            }
            ((RoundImageView) ((com.bytedance.adsdk.ugeno.component.b) b.this).ux).setBackground(new BitmapDrawable(((com.bytedance.adsdk.ugeno.component.b) b.this).f26040w.getResources(), d4));
        }
    }

    public b(Context context) {
        super(context);
        this.f26178e = ImageView.ScaleType.FIT_CENTER;
        this.f26180o = -1;
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

    private void ev() {
        if (TextUtils.isEmpty(this.f26177d)) {
            return;
        }
        ((RoundImageView) this.ux).setImageDrawable(null);
        if (this.f26177d.startsWith("local://")) {
            ((RoundImageView) this.ux).setImageResource(f.d(this.f26040w, this.f26177d.replace("local://", "")));
            return;
        }
        j0.b.a().c().c(this.f26177d, new a());
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: c */
    public RoundImageView xv() {
        RoundImageView roundImageView = new RoundImageView(this.f26040w);
        roundImageView.d(this);
        return roundImageView;
    }

    public void d(Drawable drawable) {
        ((RoundImageView) this.ux).setImageDrawable(drawable);
    }

    public void h(String str) {
        this.f26177d = str;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ev();
        ((RoundImageView) this.ux).setScaleType(this.f26178e);
        ((RoundImageView) this.ux).setBorderColor(this.wx);
        ((RoundImageView) this.ux).setCornerRadius(this.f26042y);
        ((RoundImageView) this.ux).setBorderWidth(this.yu);
        int i4 = this.f26180o;
        if (i4 != -1) {
            ((RoundImageView) this.ux).setColorFilter(i4);
        }
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
            case -372324943:
                if (str.equals("isBgGaussianBlur")) {
                    c4 = 1;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f26178e = e(str2);
                return;
            case 1:
                try {
                    this.f26179l = Boolean.parseBoolean(str2);
                    return;
                } catch (NumberFormatException unused) {
                    this.f26179l = false;
                    return;
                }
            case 2:
                this.f26177d = str2;
                return;
            case 3:
                this.f26180o = l0.a.a(str2);
                return;
            default:
                return;
        }
    }
}
