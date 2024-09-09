package com.jg.ids;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class IdsHelper {
    public static Context CONTEXT = null;
    private static final IdsHelper ourInstance = new IdsHelper();
    private i provider = null;

    public static IdsHelper getInstance() {
        return ourInstance;
    }

    private IdsHelper() {
    }

    public void init(Context context) {
        boolean z3 = false;
        if (context != null && this.provider == null) {
            k.a().a(context);
            CONTEXT = context;
            if (!(Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI"))) {
                if (!(!TextUtils.isEmpty(j.a("ro.miui.ui.version.name", "")))) {
                    if (!(Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK"))) {
                        if (Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(j.a("ro.vivo.os.version", ""))) {
                            this.provider = new com.jg.ids.k.a(context, "100215079");
                        } else {
                            if (!(Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HONOR"))) {
                                if (!(!TextUtils.isEmpty(j.a("ro.build.version.emui", "")))) {
                                    if (!(Build.MANUFACTURER.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) || Build.BRAND.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) || Build.BRAND.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(j.a("ro.build.version.opporom", "")))) {
                                        if (!(Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS"))) {
                                            if (!(Build.MANUFACTURER.equalsIgnoreCase("LENOVO") || Build.BRAND.equalsIgnoreCase("LENOVO") || Build.BRAND.equalsIgnoreCase("ZUK"))) {
                                                if (!(Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA"))) {
                                                    if (Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS")) {
                                                        this.provider = new com.jg.ids.a.a(context);
                                                    } else {
                                                        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
                                                            this.provider = new com.jg.ids.j.d(context);
                                                        } else {
                                                            if ((Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME")) || Build.MANUFACTURER.equalsIgnoreCase("alps")) {
                                                                this.provider = new com.jg.ids.meizu.c(context);
                                                            } else {
                                                                if (Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA")) {
                                                                    this.provider = new com.jg.ids.h.a(context);
                                                                } else if (j.a(context)) {
                                                                    this.provider = new com.jg.ids.b.a(context);
                                                                } else if (j.a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE")) {
                                                                    this.provider = new com.jg.ids.c.a(context);
                                                                } else {
                                                                    if (!TextUtils.isEmpty(j.a("ro.build.freeme.label", ""))) {
                                                                        this.provider = new com.jg.ids.d.a(context);
                                                                    } else {
                                                                        if (Build.MANUFACTURER.equalsIgnoreCase("ZTE") || Build.BRAND.equalsIgnoreCase("ZTE")) {
                                                                            z3 = true;
                                                                        }
                                                                        if (z3) {
                                                                            this.provider = new com.jg.ids.i.j(context);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            this.provider = new com.jg.ids.g.d(context);
                                        }
                                    }
                                    this.provider = new com.jg.ids.i.i(context);
                                }
                            }
                            this.provider = new com.jg.ids.f.a(context);
                        }
                        if (this.provider != null || !this.provider.d()) {
                            this.provider = new com.jg.ids.e.a(context);
                        }
                        return;
                    }
                }
            }
            this.provider = new com.jg.ids.l.a();
            if (this.provider != null) {
            }
            this.provider = new com.jg.ids.e.a(context);
        }
    }

    public String getOAID() {
        if (this.provider == null) {
            return "";
        }
        return this.provider.b(CONTEXT);
    }

    public String getVAID() {
        return this.provider != null ? this.provider.a(CONTEXT) : "";
    }

    public String getAAID() {
        return this.provider != null ? this.provider.c(CONTEXT) : "";
    }
}
