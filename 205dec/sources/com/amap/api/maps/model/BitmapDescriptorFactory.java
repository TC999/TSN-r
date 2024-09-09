package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c;
import com.amap.api.col.p0003l.c3;
import com.amap.api.col.p0003l.dk;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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
            return fromAsset(dk.a.marker_default.name() + ".png");
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(a3.l(context, str));
            }
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(String.valueOf(str)));
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Throwable th) {
            a3.D(th);
            String str2 = b3.f7209f;
            c3.l(str2, "read bitmap from assets failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDescriptor(bitmap, "com.amap.api.icon_" + a3.V());
        } catch (Throwable th) {
            a3.D(th);
            String str = b3.f7209f;
            c3.l(str, "read bitmap from bitmap failed " + th.getMessage());
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
                a3.B(decodeStream);
                return fromBitmap;
            }
            return null;
        } catch (Throwable th) {
            a3.D(th);
            String str2 = b3.f7209f;
            c3.l(str2, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable th) {
            a3.D(th);
            String str2 = b3.f7209f;
            c3.l(str2, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i4) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i4)));
            }
            return null;
        } catch (Throwable th) {
            a3.D(th);
            String str = b3.f7209f;
            c3.l(str, "read bitmap from res failed " + th.getMessage());
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
                return fromBitmap(a3.n(frameLayout));
            }
            return null;
        } catch (Throwable th) {
            a3.D(th);
            String str = b3.f7209f;
            c3.l(str, "read bitmap from view failed " + th.getMessage());
            return null;
        }
    }

    public static Context getContext() {
        return c.f7290f;
    }

    public static BitmapDescriptor defaultMarker(float f4) {
        try {
            float f5 = (((int) (f4 + 15.0f)) / 30) * 30;
            if (f5 > 330.0f) {
                f5 = 330.0f;
            } else if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            String str = "";
            if (f5 == 0.0f) {
                str = "RED";
            } else if (f5 == 30.0f) {
                str = "ORANGE";
            } else if (f5 == 60.0f) {
                str = "YELLOW";
            } else if (f5 == 120.0f) {
                str = "GREEN";
            } else if (f5 == 180.0f) {
                str = "CYAN";
            } else if (f5 == 210.0f) {
                str = "AZURE";
            } else if (f5 == 240.0f) {
                str = "BLUE";
            } else if (f5 == 270.0f) {
                str = "VIOLET";
            } else if (f5 == 300.0f) {
                str = "MAGENTA";
            } else if (f5 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + ".png");
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }
}
