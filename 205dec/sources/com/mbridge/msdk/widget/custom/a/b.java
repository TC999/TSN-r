package com.mbridge.msdk.widget.custom.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: MBResource.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b {

    /* renamed from: g  reason: collision with root package name */
    private static b f41119g;

    /* renamed from: a  reason: collision with root package name */
    private SoftReference<HashMap<String, c>> f41120a;

    /* renamed from: b  reason: collision with root package name */
    private SoftReference<HashMap<String, String>> f41121b;

    /* renamed from: c  reason: collision with root package name */
    private SoftReference<HashMap<String, c>> f41122c;

    /* renamed from: d  reason: collision with root package name */
    private String f41123d;

    /* renamed from: e  reason: collision with root package name */
    private String f41124e;

    /* renamed from: f  reason: collision with root package name */
    private Context f41125f;

    private b() {
    }

    public static b a() {
        if (f41119g == null) {
            f41119g = new b();
        }
        return f41119g;
    }

    public final HashMap b() {
        SoftReference<HashMap<String, c>> softReference = this.f41120a;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("layout_width", c.layout_width);
            hashMap.put("layout_height", c.layout_height);
            hashMap.put("orientation", c.orientation);
            hashMap.put("layout_centerHorizontal", c.layout_centerHorizontal);
            hashMap.put("layout_centerVertical", c.layout_centerVertical);
            c cVar = c.layout_marginLeft;
            hashMap.put("layout_marginLeft", cVar);
            c cVar2 = c.layout_marginRight;
            hashMap.put("layout_marginRight", cVar2);
            hashMap.put("layout_margin", c.layout_margin);
            hashMap.put("layout_gravity", c.layout_gravity);
            hashMap.put("layout_alignParentRight", c.layout_alignParentRight);
            hashMap.put("layout_weight", c.layout_weight);
            hashMap.put("contentDescription", c.contentDescription);
            hashMap.put("gravity", c.gravity);
            hashMap.put("id", c.id);
            hashMap.put("layout_below", c.layout_below);
            hashMap.put("layout_above", c.layout_above);
            hashMap.put("layout_toLeftOf", c.layout_toLeftOf);
            hashMap.put("layout_toRightOf", c.layout_toRightOf);
            hashMap.put("background", c.background);
            hashMap.put("layout_marginTop", c.layout_marginTop);
            hashMap.put("layout_marginBottom", c.layout_marginBottom);
            hashMap.put("layout_marginLeft", cVar);
            hashMap.put("layout_marginRight", cVar2);
            hashMap.put("layout_alignParentBottom", c.layout_alignParentBottom);
            hashMap.put("layout_alignParentTop", c.layout_alignParentTop);
            hashMap.put("layout_alignParentLeft", c.layout_alignParentLeft);
            this.f41120a = new SoftReference<>(hashMap);
        }
        return this.f41120a.get();
    }

    public final HashMap<String, c> c() {
        SoftReference<HashMap<String, c>> softReference = this.f41122c;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", c.id);
            hashMap.put("text", c.text);
            hashMap.put("ellipsize", c.ellipsize);
            hashMap.put("fadingEdge", c.fadingEdge);
            hashMap.put("scrollHorizontally", c.scrollHorizontally);
            hashMap.put("textColor", c.textColor);
            hashMap.put("textSize", c.textSize);
            hashMap.put("visibility", c.visibility);
            c cVar = c.background;
            hashMap.put("background", cVar);
            hashMap.put("textStyle", c.textStyle);
            hashMap.put("style", c.style);
            hashMap.put("layout_width", c.layout_width);
            hashMap.put("layout_height", c.layout_height);
            hashMap.put("layout_below", c.layout_below);
            hashMap.put("contentDescription", c.contentDescription);
            hashMap.put("src", c.src);
            hashMap.put("gravity", c.gravity);
            hashMap.put("orientation", c.orientation);
            hashMap.put("numColumns", c.numColumns);
            hashMap.put("verticalSpacing", c.verticalSpacing);
            hashMap.put("horizontalSpacing", c.horizontalSpacing);
            hashMap.put("background", cVar);
            hashMap.put("layout_marginBottom", c.layout_marginBottom);
            hashMap.put("scaleType", c.scaleType);
            hashMap.put("singleLine", c.singleLine);
            hashMap.put("paddingBottom", c.paddingBottom);
            hashMap.put("paddingTop", c.paddingTop);
            hashMap.put("letterSpacing", c.letterSpacing);
            hashMap.put("paddingRight", c.paddingRight);
            hashMap.put("layout_right", c.layout_right);
            this.f41122c = new SoftReference<>(hashMap);
        }
        return this.f41122c.get();
    }

    public final int d(String str) {
        String[] split = str.toUpperCase().split("\\|");
        int i4 = 48;
        try {
            Class<?> cls = Class.forName("android.view.Gravity");
            for (String str2 : split) {
                i4 |= cls.getField(str2).getInt(null);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return i4;
    }

    public final String e(String str) {
        if (str.startsWith("@")) {
            SoftReference<HashMap<String, String>> softReference = this.f41121b;
            if (softReference == null || softReference.get() == null) {
                com.mbridge.msdk.widget.custom.b.d.a("\u5b57\u7b26\u4e32\u53d8\u7a7a\u4e86");
                this.f41121b = new SoftReference<>(d());
            }
            return this.f41121b.get().get(str.substring(8));
        }
        return str;
    }

    public final View f(String str) {
        a aVar = new a(this.f41125f);
        return aVar.a(aVar.a(str), (ViewGroup) null, false);
    }

    public final void a(String str) {
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        this.f41125f = j4;
        if (com.mbridge.msdk.widget.custom.b.d.f41194a) {
            this.f41123d = j4.getFilesDir().toString();
        } else {
            this.f41123d = str;
        }
        com.mbridge.msdk.widget.custom.b.a.a(this.f41125f);
        this.f41124e = "/drawable/";
        com.mbridge.msdk.widget.custom.b.d.a("\u5c4f\u5e55\uff1a" + this.f41124e);
        this.f41125f = this.f41125f;
    }

    private HashMap<String, String> d() {
        InputStream inputStream;
        try {
            inputStream = this.f41125f.getAssets().open("strings.xml");
        } catch (IOException e4) {
            e4.printStackTrace();
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
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final int a(Context context, String str) {
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
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public final int b(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("#")) {
            return -16777216;
        }
        int length = str.length();
        if (length == 7) {
            return (int) Long.decode(str.replace("#", "#FF")).longValue();
        }
        if (length == 9) {
            return (int) Long.decode(str).longValue();
        }
        com.mbridge.msdk.widget.custom.b.d.a("\u8fd4\u56de\u767d\u8272\u80cc\u666f");
        return -1;
    }

    public final int c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            int indexOf = str.indexOf("d");
            int indexOf2 = str.indexOf("s");
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            return str.contains("d") ? com.mbridge.msdk.widget.custom.b.a.a(this.f41125f, parseInt) : parseInt;
        }
    }
}
