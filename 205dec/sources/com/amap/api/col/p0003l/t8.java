package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.w1;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileProvider;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapCustomStyleManager.java */
/* renamed from: com.amap.api.col.3l.t8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t8 implements w1.a {
    private boolean B;
    private AMap3DModelTileOverlay D;
    private a F;

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f9083b;

    /* renamed from: c  reason: collision with root package name */
    private CustomMapStyleOptions f9084c;

    /* renamed from: i  reason: collision with root package name */
    private int f9090i;

    /* renamed from: j  reason: collision with root package name */
    private Context f9091j;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9098q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f9099r;

    /* renamed from: v  reason: collision with root package name */
    private w1 f9103v;

    /* renamed from: w  reason: collision with root package name */
    private w1 f9104w;

    /* renamed from: a  reason: collision with root package name */
    private final String f9082a = "__MACOSX";

    /* renamed from: d  reason: collision with root package name */
    private boolean f9085d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9086e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9087f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9088g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9089h = false;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f9092k = null;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f9093l = null;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f9094m = null;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f9095n = null;

    /* renamed from: o  reason: collision with root package name */
    private byte[] f9096o = null;

    /* renamed from: p  reason: collision with root package name */
    private byte[] f9097p = null;

    /* renamed from: s  reason: collision with root package name */
    private boolean f9100s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f9101t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9102u = false;

    /* renamed from: x  reason: collision with root package name */
    private byte[] f9105x = null;

    /* renamed from: y  reason: collision with root package name */
    private byte[] f9106y = null;

    /* renamed from: z  reason: collision with root package name */
    private byte[] f9107z = null;
    private boolean A = false;
    private HashMap<String, byte[]> C = new HashMap<>();
    private MyTrafficStyle E = new MyTrafficStyle();

    /* compiled from: AMapCustomStyleManager.java */
    /* renamed from: com.amap.api.col.3l.t8$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();
    }

    public t8(IAMapDelegate iAMapDelegate, Context context, boolean z3) {
        this.f9090i = -1;
        this.f9098q = false;
        this.f9099r = false;
        this.B = false;
        this.f9083b = iAMapDelegate;
        this.f9091j = context;
        this.f9098q = false;
        this.f9099r = false;
        this.B = z3;
        this.f9090i = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
    }

    private void e(MapConfig mapConfig) {
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.C.clear();
            return;
        }
        String styleResDataPath = this.f9084c.getStyleResDataPath();
        if (this.f9084c.getStyleResData() == null && !TextUtils.isEmpty(styleResDataPath)) {
            this.f9084c.setStyleResData(FileUtil.readFileContents(styleResDataPath));
        }
        if (this.f9084c.getStyleResData() == null && this.f9107z == null) {
            return;
        }
        byte[] bArr2 = this.f9107z;
        if (bArr2 == null) {
            bArr2 = this.f9084c.getStyleResData();
        }
        if (bArr2 != null) {
            mapConfig.setUseProFunction(true);
            this.C.clear();
            Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr2, null);
            if (uncompressToByteWithKeys != null) {
                for (String str : uncompressToByteWithKeys.keySet()) {
                    if (str != null && !str.contains("__MACOSX") && (bArr = uncompressToByteWithKeys.get(str)) != null) {
                        if (FileUtil.isGzip(bArr)) {
                            this.C.put(str, bArr);
                        } else {
                            this.C.put(str, FileUtil.compress(bArr));
                        }
                    }
                }
            }
        }
    }

    private void f(String str, boolean z3) {
        boolean z4;
        int b4 = !TextUtils.isEmpty(str) ? c2.b(str) : Integer.MIN_VALUE;
        IAMapDelegate iAMapDelegate = this.f9083b;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        if (this.f9094m == null) {
            Context context = this.f9091j;
            this.f9094m = FileUtil.readFileContentsFromAssets(context, "map_custom" + File.separator + "custom_bktile.data");
        }
        byte[] bArr = this.f9094m;
        if (bArr != null) {
            if (!z3) {
                b4 = 0;
            } else if (b4 == Integer.MIN_VALUE) {
                z4 = true;
                this.f9083b.getGLMapEngine().setBackgroundTexture(this.f9090i, a3.T((byte[]) bArr.clone(), 0, b4, z4));
            }
            z4 = false;
            this.f9083b.getGLMapEngine().setBackgroundTexture(this.f9090i, a3.T((byte[]) bArr.clone(), 0, b4, z4));
        }
    }

    private void g(JSONObject jSONObject) {
        this.f9083b.getGLMapEngine().setCustomThirdLayerStyle(this.f9090i, jSONObject.toString());
    }

    private void h(byte[] bArr) {
        a2 c4;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (bArr == null || (c4 = c2.c(bArr)) == null || c4.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(c4.a());
            JSONObject optJSONObject3 = jSONObject.optJSONObject("mapStyle");
            String str = null;
            boolean z3 = true;
            if (optJSONObject3 != null && (optJSONObject2 = optJSONObject3.optJSONObject("bg")) != null) {
                z3 = optJSONObject2.optBoolean("visible", true);
                str = optJSONObject2.optString("lineColor", null);
            }
            f(str, z3);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("layer");
            if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("traffic")) != null) {
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("multiFillColors");
                if (optJSONObject.optBoolean("visible") && optJSONObject5 != null) {
                    int b4 = c2.b(optJSONObject5.optString("smooth"));
                    int b5 = c2.b(optJSONObject5.optString("slow"));
                    int b6 = c2.b(optJSONObject5.optString("congested"));
                    int b7 = c2.b(optJSONObject5.optString("seriousCongested"));
                    this.E.setSmoothColor(b4);
                    this.E.setSlowColor(b5);
                    this.E.setCongestedColor(b6);
                    this.E.setSeriousCongestedColor(b7);
                    if (this.f9097p == null) {
                        Context context = this.f9091j;
                        this.f9097p = FileUtil.readFileContentsFromAssets(context, "map_assets" + File.separator + "tmc_allinone.data");
                    }
                    this.f9083b.setTrafficStyleWithTexture(this.f9097p, this.E);
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("third_layer");
            if (optJSONObject6 != null) {
                g(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("model_layer");
            if (optJSONObject7 != null) {
                k(optJSONObject7.optString("id"));
            }
        } catch (Throwable th) {
            u5.p(th, "AMapCustomStyleManager", "setExtraStyle");
            a3.D(th);
        }
    }

    private void k(String str) {
        AMap3DModelTileProvider aMap3DModelTileProvider = new AMap3DModelTileProvider();
        aMap3DModelTileProvider.setUrl("https://restapi.amap.com/rest/lbs/geohub/3d/tiles?z=%d&x=%d&y=%d&id=" + str);
        AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions = new AMap3DModelTileOverlayOptions();
        aMap3DModelTileOverlayOptions.setTileProvider(aMap3DModelTileProvider);
        try {
            this.D = this.f9083b.add3DModelTileOverlay(aMap3DModelTileOverlayOptions);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean l(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            return this.f9083b.getGLMapEngine().checkCustomStyleData(this.f9090i, bArr);
        } catch (Throwable th) {
            u5.p(th, "AMapCustomStyleManager", "checkData");
            a3.D(th);
            return true;
        }
    }

    private static String m(String str) {
        int indexOf;
        return (str == null || (indexOf = str.indexOf("99999_")) == -1) ? str : str.substring(0, indexOf).replace("99999_", "");
    }

    private static byte[] o(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                a3.D(th);
                th.printStackTrace();
                return null;
            } finally {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
            }
        }
    }

    private void r() {
        IAMapDelegate iAMapDelegate = this.f9083b;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.f9097p != null) {
            this.f9083b.getGLMapEngine().setTrafficStyleWithTexture(this.f9090i, this.f9097p, new MyTrafficStyle());
        }
        IAMapDelegate iAMapDelegate2 = this.f9083b;
        if (iAMapDelegate2 != null && iAMapDelegate2.getGLMapEngine() != null && this.f9094m != null) {
            this.f9083b.getGLMapEngine().setBackgroundTexture(this.f9090i, this.f9094m);
        }
        AMap3DModelTileOverlay aMap3DModelTileOverlay = this.D;
        if (aMap3DModelTileOverlay != null) {
            aMap3DModelTileOverlay.remove();
        }
        this.f9102u = false;
    }

    private void s() {
        if (this.B) {
            if (this.f9093l == null) {
                Context context = this.f9091j;
                this.f9093l = o(FileUtil.readFileContentsFromAssets(context, "map_assets" + File.separator + "style_1_16_3569740208.data"));
            }
        } else if (this.f9093l == null) {
            Context context2 = this.f9091j;
            this.f9093l = o(FileUtil.readFileContentsFromAssets(context2, "map_assets" + File.separator + "style_1_s_21_1680092748.data"));
        }
        this.f9083b.getGLMapEngine().setCustomStyleData(this.f9090i, this.f9093l, this.f9092k);
        this.f9101t = false;
        this.C.clear();
    }

    private void t() {
        if (this.f9100s) {
            if (this.f9095n == null) {
                Context context = this.f9091j;
                this.f9095n = FileUtil.readFileContentsFromAssets(context, "map_custom" + File.separator + "icons-for-custom_5_18_1616413149.data");
            }
            this.f9100s = false;
            this.f9083b.getGLMapEngine().setCustomStyleTexture(this.f9090i, this.f9095n);
        }
    }

    private void u() {
        CustomMapStyleOptions customMapStyleOptions = this.f9084c;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.f9084c.setStyleDataPath(null);
            this.f9084c.setStyleData(null);
            this.f9084c.setStyleTexturePath(null);
            this.f9084c.setStyleTextureData(null);
            this.f9084c.setStyleExtraData(null);
            this.f9084c.setStyleExtraPath(null);
        }
    }

    public final void a() {
        IAMapDelegate iAMapDelegate;
        if (this.f9084c == null || this.f9099r) {
            return;
        }
        try {
            MapConfig mapConfig = this.f9083b.getMapConfig();
            if (mapConfig == null) {
                return;
            }
            synchronized (this) {
                if (mapConfig.isHideLogoEnable() && (iAMapDelegate = this.f9083b) != null && iAMapDelegate.getUiSettings() != null) {
                    if (this.f9083b.getUiSettings().isLogoEnable()) {
                        if (this.f9084c.isEnable()) {
                            if (this.f9101t) {
                                this.f9083b.getUiSettings().setLogoEnable(false);
                            }
                        } else {
                            this.f9083b.getUiSettings().setLogoEnable(true);
                        }
                    } else if (!this.f9101t) {
                        this.f9083b.getUiSettings().setLogoEnable(true);
                    }
                }
                if (this.f9085d) {
                    if (this.f9084c.isEnable()) {
                        this.f9083b.getGLMapEngine().setNativeMapModeAndStyle(this.f9090i, 0, 0);
                        mapConfig.setCustomStyleEnable(true);
                        this.f9085d = false;
                    } else {
                        this.f9083b.getGLMapEngine().setNativeMapModeAndStyle(this.f9090i, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime());
                        this.f9101t = false;
                        if (mapConfig.isCustomStyleEnable()) {
                            if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0) {
                                s();
                            }
                            t();
                            if (this.f9102u) {
                                r();
                            }
                            mapConfig.setCustomStyleEnable(false);
                        }
                        this.f9085d = false;
                        return;
                    }
                }
                if (this.f9087f) {
                    String styleTexturePath = this.f9084c.getStyleTexturePath();
                    if (this.f9084c.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                        this.f9084c.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                    }
                    if (this.f9084c.getStyleTextureData() != null) {
                        this.A = true;
                        if (mapConfig.isProFunctionAuthEnable()) {
                            this.f9100s = true;
                            this.f9083b.getGLMapEngine().setCustomStyleTexture(this.f9090i, this.f9084c.getStyleTextureData());
                            mapConfig.setUseProFunction(true);
                        } else {
                            t();
                        }
                    } else {
                        t();
                        this.A = false;
                    }
                    this.f9087f = false;
                }
                if (this.f9086e) {
                    String styleDataPath = this.f9084c.getStyleDataPath();
                    if (this.f9084c.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                        this.f9084c.setStyleData(FileUtil.readFileContents(styleDataPath));
                    }
                    if (this.f9084c.getStyleData() == null && this.f9105x == null) {
                        if (this.f9101t) {
                            this.f9085d = true;
                            this.f9084c.setEnable(false);
                        }
                        this.f9086e = false;
                    }
                    if (this.f9096o == null) {
                        Context context = this.f9091j;
                        this.f9096o = o(FileUtil.readFileContentsFromAssets(context, "map_custom" + File.separator + "style-for-custom_0_18_1641525834.data"));
                    }
                    byte[] bArr = this.f9105x;
                    if (bArr == null) {
                        bArr = this.f9084c.getStyleData();
                    }
                    if (!l(bArr)) {
                        h2.a();
                    } else {
                        this.f9083b.getGLMapEngine().setCustomStyleData(this.f9090i, bArr, this.f9096o);
                        this.f9101t = true;
                        IAMapDelegate iAMapDelegate2 = this.f9083b;
                        if (iAMapDelegate2 != null) {
                            iAMapDelegate2.resetRenderTime();
                        }
                    }
                    this.f9086e = false;
                }
                if (this.f9088g) {
                    String styleExtraPath = this.f9084c.getStyleExtraPath();
                    if (this.f9084c.getStyleExtraData() == null && !TextUtils.isEmpty(styleExtraPath)) {
                        this.f9084c.setStyleExtraData(FileUtil.readFileContents(styleExtraPath));
                    }
                    if (this.f9084c.getStyleExtraData() != null || this.f9106y != null) {
                        byte[] bArr2 = this.f9106y;
                        if (bArr2 == null) {
                            bArr2 = this.f9084c.getStyleExtraData();
                        }
                        if (bArr2 != null) {
                            h(bArr2);
                            this.f9102u = true;
                        }
                    }
                    this.f9088g = false;
                }
                if (this.f9089h) {
                    e(mapConfig);
                    this.f9089h = false;
                }
            }
        } catch (Throwable th) {
            u5.p(th, "AMapCustomStyleManager", "updateStyle");
            a3.D(th);
        }
    }

    @Override // com.amap.api.col.p0003l.w1.a
    public final void b(byte[] bArr, int i4) {
        MapConfig mapConfig;
        a aVar;
        if (this.f9084c != null) {
            synchronized (this) {
                IAMapDelegate iAMapDelegate = this.f9083b;
                if (iAMapDelegate != null && (mapConfig = iAMapDelegate.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                    mapConfig.setUseProFunction(true);
                    if (i4 == 1) {
                        this.f9105x = bArr;
                        this.f9086e = true;
                    } else if (i4 == 0) {
                        this.f9106y = bArr;
                        this.f9088g = true;
                    } else if (i4 == 2) {
                        String str = this.f9084c.getStyleId() + "_sdk_1000.data";
                        String str2 = this.f9084c.getStyleId() + "_abroad_sdk.json";
                        Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                        if (uncompressToByteWithKeys != null) {
                            byte[] bArr2 = uncompressToByteWithKeys.get(str);
                            if (bArr2 != null) {
                                this.f9105x = bArr2;
                                this.f9086e = true;
                            }
                            if (uncompressToByteWithKeys.get(str2) != null && (aVar = this.F) != null) {
                                aVar.a();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(a aVar) {
        this.F = aVar;
    }

    public final void d(CustomMapStyleOptions customMapStyleOptions) {
        IAMapDelegate iAMapDelegate;
        if (this.f9084c == null || customMapStyleOptions == null) {
            return;
        }
        synchronized (this) {
            if (!this.f9098q) {
                this.f9098q = true;
                if (this.f9084c.isEnable()) {
                    this.f9085d = true;
                }
            }
            if (this.f9084c.isEnable() != customMapStyleOptions.isEnable()) {
                this.f9084c.setEnable(customMapStyleOptions.isEnable());
                this.f9085d = true;
                x2.m(this.f9091j, customMapStyleOptions.isEnable());
            }
            if (this.f9084c.isEnable()) {
                if (!TextUtils.equals(this.f9084c.getStyleId(), customMapStyleOptions.getStyleId())) {
                    this.f9084c.setStyleId(customMapStyleOptions.getStyleId());
                    String styleId = this.f9084c.getStyleId();
                    if (!TextUtils.isEmpty(styleId) && (iAMapDelegate = this.f9083b) != null && iAMapDelegate.getMapConfig() != null && this.f9083b.getMapConfig().isProFunctionAuthEnable()) {
                        if (this.f9103v == null) {
                            if (this.B) {
                                this.f9103v = new w1(this.f9091j, this, 2, "abroad_sdk_json_sdk_1000_zip");
                            } else {
                                this.f9103v = new w1(this.f9091j, this, 1, "sdk_1000");
                            }
                        }
                        this.f9103v.b(styleId);
                        this.f9103v.b();
                        if (this.f9104w == null) {
                            this.f9104w = new w1(this.f9091j, this, 0, null);
                        }
                        this.f9104w.b(styleId);
                        this.f9104w.b();
                    }
                }
                if (!TextUtils.equals(this.f9084c.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                    this.f9084c.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                    this.f9086e = true;
                }
                if (this.f9084c.getStyleData() != customMapStyleOptions.getStyleData()) {
                    this.f9084c.setStyleData(customMapStyleOptions.getStyleData());
                    this.f9086e = true;
                }
                if (!TextUtils.equals(this.f9084c.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                    this.f9084c.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                    this.f9087f = true;
                }
                if (this.f9084c.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                    this.f9084c.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                    this.f9087f = true;
                }
                if (!TextUtils.equals(this.f9084c.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                    this.f9084c.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                    this.f9088g = true;
                }
                if (this.f9084c.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                    this.f9084c.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                    this.f9088g = true;
                }
                if (!TextUtils.equals(this.f9084c.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                    this.f9084c.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                    this.f9089h = true;
                }
                if (this.f9084c.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                    this.f9084c.setStyleResData(customMapStyleOptions.getStyleResData());
                    this.f9089h = true;
                }
                x2.j(this.f9091j, true);
            } else {
                u();
                x2.j(this.f9091j, false);
            }
        }
    }

    public final byte[] i(String str) {
        MapConfig mapConfig;
        if (str == null || (mapConfig = this.f9083b.getMapConfig()) == null) {
            return null;
        }
        if (!mapConfig.isProFunctionAuthEnable()) {
            return FileUtil.readFileContentsFromAssetsByPreName(this.f9091j, "map_assets", m(str));
        }
        for (String str2 : this.C.keySet()) {
            if (str.contains(str2)) {
                return this.C.get(str2);
            }
        }
        return null;
    }

    public final void j() {
        if (this.f9084c == null) {
            return;
        }
        synchronized (this) {
            IAMapDelegate iAMapDelegate = this.f9083b;
            if (iAMapDelegate != null && iAMapDelegate.getMapConfig() != null && !this.f9083b.getMapConfig().isProFunctionAuthEnable()) {
                this.f9084c.setStyleId(null);
                this.f9105x = null;
                this.f9106y = null;
                this.f9107z = null;
            }
            this.f9087f = true;
            this.f9086e = true;
            if (this.f9102u) {
                this.f9088g = true;
            }
            this.f9085d = true;
            this.f9089h = true;
        }
    }

    public final void n() {
        if (this.f9084c == null) {
            this.f9084c = new CustomMapStyleOptions();
        }
    }

    public final boolean p() {
        return this.f9084c != null;
    }

    public final void q() {
        synchronized (this) {
            CustomMapStyleOptions customMapStyleOptions = this.f9084c;
            if (customMapStyleOptions != null) {
                customMapStyleOptions.setEnable(false);
                u();
                this.f9085d = true;
            }
        }
    }

    @Override // com.amap.api.col.p0003l.w1.a
    public final void a(byte[] bArr, int i4) {
        b(bArr, i4);
    }
}
