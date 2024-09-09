package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.bytedance.adsdk.ugeno.component.b;
import l0.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends b<UgenGif> {

    /* renamed from: c  reason: collision with root package name */
    protected String f34927c;
    protected ImageView.ScaleType mt;

    public c(Context context) {
        super(context);
        this.mt = ImageView.ScaleType.FIT_CENTER;
    }

    private void ev() {
        if (TextUtils.isEmpty(this.f34927c)) {
            return;
        }
        if (this.f34927c.startsWith("local://")) {
            ((UgenGif) this.ux).c(f.d(this.f26040w, this.f34927c.replace("local://", "")), false);
            return;
        }
        j0.b.a().c().c(this.f26040w, this.f34927c, (ImageView) this.ux);
    }

    private ImageView.ScaleType ux(String str) {
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

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: c */
    public UgenGif xv() {
        UgenGif ugenGif = new UgenGif(this.f26040w);
        this.ux = ugenGif;
        ugenGif.c(this);
        return (UgenGif) this.ux;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b, j0.d
    public void f() {
        super.f();
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ev();
        ((UgenGif) this.ux).setScaleType(this.mt);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        super.c(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("scaleType")) {
            this.mt = ux(str2);
        } else if (str.equals("src")) {
            this.f34927c = str2;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b, j0.d
    public void c(boolean z3) {
        super.c(z3);
        if (z3) {
            w();
        }
    }
}
