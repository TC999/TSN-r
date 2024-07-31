package com.mbridge.msdk.widget.custom.p516a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.internal.C2573a;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.widget.custom.p517b.C11754d;
import com.mbridge.msdk.widget.custom.p517b.DensityUtil;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.mbridge.msdk.widget.custom.a.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MBResource {

    /* renamed from: g */
    private static MBResource f32408g;

    /* renamed from: a */
    private SoftReference<HashMap<String, ParamValue>> f32409a;

    /* renamed from: b */
    private SoftReference<HashMap<String, String>> f32410b;

    /* renamed from: c */
    private SoftReference<HashMap<String, ParamValue>> f32411c;

    /* renamed from: d */
    private String f32412d;

    /* renamed from: e */
    private String f32413e;

    /* renamed from: f */
    private Context f32414f;

    private MBResource() {
    }

    /* renamed from: a */
    public static MBResource m20600a() {
        if (f32408g == null) {
            f32408g = new MBResource();
        }
        return f32408g;
    }

    /* renamed from: b */
    public final HashMap m20597b() {
        SoftReference<HashMap<String, ParamValue>> softReference = this.f32409a;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("layout_width", ParamValue.layout_width);
            hashMap.put("layout_height", ParamValue.layout_height);
            hashMap.put("orientation", ParamValue.orientation);
            hashMap.put("layout_centerHorizontal", ParamValue.layout_centerHorizontal);
            hashMap.put("layout_centerVertical", ParamValue.layout_centerVertical);
            ParamValue paramValue = ParamValue.layout_marginLeft;
            hashMap.put("layout_marginLeft", paramValue);
            ParamValue paramValue2 = ParamValue.layout_marginRight;
            hashMap.put("layout_marginRight", paramValue2);
            hashMap.put("layout_margin", ParamValue.layout_margin);
            hashMap.put("layout_gravity", ParamValue.layout_gravity);
            hashMap.put("layout_alignParentRight", ParamValue.layout_alignParentRight);
            hashMap.put("layout_weight", ParamValue.layout_weight);
            hashMap.put("contentDescription", ParamValue.contentDescription);
            hashMap.put("gravity", ParamValue.gravity);
            hashMap.put("id", ParamValue.id);
            hashMap.put("layout_below", ParamValue.layout_below);
            hashMap.put("layout_above", ParamValue.layout_above);
            hashMap.put("layout_toLeftOf", ParamValue.layout_toLeftOf);
            hashMap.put("layout_toRightOf", ParamValue.layout_toRightOf);
            hashMap.put("background", ParamValue.background);
            hashMap.put("layout_marginTop", ParamValue.layout_marginTop);
            hashMap.put("layout_marginBottom", ParamValue.layout_marginBottom);
            hashMap.put("layout_marginLeft", paramValue);
            hashMap.put("layout_marginRight", paramValue2);
            hashMap.put("layout_alignParentBottom", ParamValue.layout_alignParentBottom);
            hashMap.put("layout_alignParentTop", ParamValue.layout_alignParentTop);
            hashMap.put("layout_alignParentLeft", ParamValue.layout_alignParentLeft);
            this.f32409a = new SoftReference<>(hashMap);
        }
        return this.f32409a.get();
    }

    /* renamed from: c */
    public final HashMap<String, ParamValue> m20595c() {
        SoftReference<HashMap<String, ParamValue>> softReference = this.f32411c;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", ParamValue.id);
            hashMap.put(C2573a.f8443b, ParamValue.text);
            hashMap.put("ellipsize", ParamValue.ellipsize);
            hashMap.put("fadingEdge", ParamValue.fadingEdge);
            hashMap.put("scrollHorizontally", ParamValue.scrollHorizontally);
            hashMap.put("textColor", ParamValue.textColor);
            hashMap.put("textSize", ParamValue.textSize);
            hashMap.put("visibility", ParamValue.visibility);
            ParamValue paramValue = ParamValue.background;
            hashMap.put("background", paramValue);
            hashMap.put("textStyle", ParamValue.textStyle);
            hashMap.put("style", ParamValue.style);
            hashMap.put("layout_width", ParamValue.layout_width);
            hashMap.put("layout_height", ParamValue.layout_height);
            hashMap.put("layout_below", ParamValue.layout_below);
            hashMap.put("contentDescription", ParamValue.contentDescription);
            hashMap.put("src", ParamValue.src);
            hashMap.put("gravity", ParamValue.gravity);
            hashMap.put("orientation", ParamValue.orientation);
            hashMap.put("numColumns", ParamValue.numColumns);
            hashMap.put("verticalSpacing", ParamValue.verticalSpacing);
            hashMap.put("horizontalSpacing", ParamValue.horizontalSpacing);
            hashMap.put("background", paramValue);
            hashMap.put("layout_marginBottom", ParamValue.layout_marginBottom);
            hashMap.put("scaleType", ParamValue.scaleType);
            hashMap.put("singleLine", ParamValue.singleLine);
            hashMap.put("paddingBottom", ParamValue.paddingBottom);
            hashMap.put("paddingTop", ParamValue.paddingTop);
            hashMap.put("letterSpacing", ParamValue.letterSpacing);
            hashMap.put("paddingRight", ParamValue.paddingRight);
            hashMap.put("layout_right", ParamValue.layout_right);
            this.f32411c = new SoftReference<>(hashMap);
        }
        return this.f32411c.get();
    }

    /* renamed from: d */
    public final int m20592d(String str) {
        String[] split = str.toUpperCase().split("\\|");
        int i = 48;
        try {
            Class<?> cls = Class.forName("android.view.Gravity");
            for (String str2 : split) {
                i |= cls.getField(str2).getInt(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /* renamed from: e */
    public final String m20591e(String str) {
        if (str.startsWith("@")) {
            SoftReference<HashMap<String, String>> softReference = this.f32410b;
            if (softReference == null || softReference.get() == null) {
                C11754d.m20566a("字符串变空了");
                this.f32410b = new SoftReference<>(m20593d());
            }
            return this.f32410b.get().get(str.substring(8));
        }
        return str;
    }

    /* renamed from: f */
    public final View m20590f(String str) {
        MBLayoutInflate mBLayoutInflate = new MBLayoutInflate(this.f32414f);
        return mBLayoutInflate.m20605a(mBLayoutInflate.m20609a(str), (ViewGroup) null, false);
    }

    /* renamed from: a */
    public final void m20598a(String str) {
        Context m22861j = MBSDKContext.m22865f().m22861j();
        this.f32414f = m22861j;
        if (C11754d.f32505a) {
            this.f32412d = m22861j.getFilesDir().toString();
        } else {
            this.f32412d = str;
        }
        DensityUtil.m20580a(this.f32414f);
        this.f32413e = "/drawable/";
        C11754d.m20566a("屏幕：" + this.f32413e);
        this.f32414f = this.f32414f;
    }

    /* renamed from: d */
    private HashMap<String, String> m20593d() {
        InputStream inputStream;
        try {
            inputStream = this.f32414f.getAssets().open("strings.xml");
        } catch (IOException e) {
            e.printStackTrace();
            inputStream = null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(inputStream, "utf-8");
            HashMap<String, String> hashMap = new HashMap<>();
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    if ("string".equals(newPullParser.getName())) {
                        hashMap.put(newPullParser.getAttributeValue(0), newPullParser.nextText());
                    }
                }
            }
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final int m20599a(Context context, String str) {
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(".R$");
        String[] split = str.split("\\.");
        sb.append(split[1]);
        try {
            Class<?> cls = Class.forName(sb.toString());
            Object newInstance = cls.newInstance();
            Field declaredField = cls.getDeclaredField(split[2]);
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(newInstance)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: b */
    public final int m20596b(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("#")) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        int length = str.length();
        if (length == 7) {
            return (int) Long.decode(str.replace("#", "#FF")).longValue();
        }
        if (length == 9) {
            return (int) Long.decode(str).longValue();
        }
        C11754d.m20566a("返回白色背景");
        return -1;
    }

    /* renamed from: c */
    public final int m20594c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            int indexOf = str.indexOf("d");
            int indexOf2 = str.indexOf("s");
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            return str.contains("d") ? DensityUtil.m20578a(this.f32414f, parseInt) : parseInt;
        }
    }
}
