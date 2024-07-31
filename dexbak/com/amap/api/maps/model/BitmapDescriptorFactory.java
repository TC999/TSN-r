package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.p0463l.C1732a3;
import com.amap.api.col.p0463l.IResourceProxy;
import com.amap.api.col.p0463l.LinkLogConfig;
import com.amap.api.col.p0463l.LinkLogManager;
import com.amap.api.col.p0463l.MapFragmentDelegateImp;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final String ICON_ID_PREFIX = "com.amap.api.icon_";

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(IResourceProxy.EnumC1779a.marker_default.name() + PhotoBitmapUtils.f15141c);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(C1732a3.m55698l(context, str));
            }
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(String.valueOf(str)));
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str2 = LinkLogConfig.f3648f;
            LinkLogManager.m55482l(str2, "read bitmap from assets failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDescriptor(bitmap, ICON_ID_PREFIX + C1732a3.m55723V());
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str = LinkLogConfig.f3648f;
            LinkLogManager.m55482l(str, "read bitmap from bitmap failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = getContext();
            if (context != null) {
                FileInputStream openFileInput = context.openFileInput(str);
                Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
                openFileInput.close();
                BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
                C1732a3.m55743B(decodeStream);
                return fromBitmap;
            }
            return null;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str2 = LinkLogConfig.f3648f;
            LinkLogManager.m55482l(str2, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str2 = LinkLogConfig.f3648f;
            LinkLogManager.m55482l(str2, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i)));
            }
            return null;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str = LinkLogConfig.f3648f;
            LinkLogManager.m55482l(str, "read bitmap from res failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = getContext();
            if (context != null) {
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.addView(view);
                frameLayout.setDrawingCacheEnabled(true);
                return fromBitmap(C1732a3.m55696n(frameLayout));
            }
            return null;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str = LinkLogConfig.f3648f;
            LinkLogManager.m55482l(str, "read bitmap from view failed " + th.getMessage());
            return null;
        }
    }

    public static Context getContext() {
        return MapFragmentDelegateImp.f3708f;
    }

    public static BitmapDescriptor defaultMarker(float f) {
        try {
            float f2 = (((int) (f + 15.0f)) / 30) * 30;
            if (f2 > 330.0f) {
                f2 = 330.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            String str = "";
            if (f2 == 0.0f) {
                str = "RED";
            } else if (f2 == 30.0f) {
                str = "ORANGE";
            } else if (f2 == 60.0f) {
                str = "YELLOW";
            } else if (f2 == 120.0f) {
                str = "GREEN";
            } else if (f2 == 180.0f) {
                str = "CYAN";
            } else if (f2 == 210.0f) {
                str = "AZURE";
            } else if (f2 == 240.0f) {
                str = "BLUE";
            } else if (f2 == 270.0f) {
                str = "VIOLET";
            } else if (f2 == 300.0f) {
                str = "MAGENTA";
            } else if (f2 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + PhotoBitmapUtils.f15141c);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }
}
