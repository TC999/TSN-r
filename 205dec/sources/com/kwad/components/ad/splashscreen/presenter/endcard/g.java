package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ad;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class g {
    private float Fa;
    private Context mContext;

    public g(Context context, float f4) {
        this.mContext = context;
        this.Fa = f4;
    }

    private int g(Context context, int i4) {
        return (int) (com.kwad.sdk.c.a.a.h(context, i4) * this.Fa);
    }

    public final ad lG() {
        return new ad(g(this.mContext, R.dimen.ksad_splash_endcard_title_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_title_iconh_land));
    }

    public final ad lH() {
        return new ad(g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconh_land));
    }

    public final ad lI() {
        int g4 = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land);
        int g5 = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconh_land);
        int g6 = g(this.mContext, R.dimen.ksad_splash_endcard_app_margin_top_land);
        ad adVar = new ad(g4, g5);
        adVar.eb(g6);
        return adVar;
    }

    public final int lJ() {
        return com.kwad.sdk.c.a.a.px2dip(this.mContext, (int) (g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land) * 0.24f));
    }

    public final ad lK() {
        return new ad(g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconh_land));
    }

    public final ad lL() {
        int g4 = g(this.mContext, R.dimen.ksad_splash_endcard_appname_h_land);
        int g5 = g(this.mContext, R.dimen.ksad_splash_endcard_appname_margin_top_land);
        ad adVar = new ad(0, g4);
        adVar.eb(g5);
        return adVar;
    }

    public final ad lM() {
        return new ad(0, g(this.mContext, R.dimen.ksad_splash_endcard_appver_h_land));
    }

    public final ad lN() {
        int g4 = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_h_land);
        int g5 = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_margin_top_land);
        ad adVar = new ad(0, g4);
        adVar.eb(g5);
        return adVar;
    }

    public final ad lO() {
        int g4 = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_h_land);
        int g5 = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_margin_top_land);
        ad adVar = new ad(0, g4);
        adVar.eb(g5);
        return adVar;
    }

    public final int lP() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appname_text_sp_land);
    }

    public final int lQ() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appver_text_sp_land);
    }

    public final int lR() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_text_sp_land);
    }

    public final int lS() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_title_text_sp_land);
    }

    public final int lT() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_subtitle_text_sp_land);
    }
}
