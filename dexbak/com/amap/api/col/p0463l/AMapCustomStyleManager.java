package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0463l.CustomStyleTask;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.umeng.analytics.pro.UContent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.s8 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapCustomStyleManager implements CustomStyleTask.InterfaceC1979a {

    /* renamed from: B */
    private boolean f5298B;

    /* renamed from: D */
    private AMap3DModelTileOverlay f5300D;

    /* renamed from: F */
    private InterfaceC1942a f5302F;

    /* renamed from: b */
    private IAMapDelegate f5304b;

    /* renamed from: c */
    private CustomMapStyleOptions f5305c;

    /* renamed from: i */
    private int f5311i;

    /* renamed from: j */
    private Context f5312j;

    /* renamed from: q */
    private boolean f5319q;

    /* renamed from: r */
    private boolean f5320r;

    /* renamed from: v */
    private CustomStyleTask f5324v;

    /* renamed from: w */
    private CustomStyleTask f5325w;

    /* renamed from: a */
    private final String f5303a = "__MACOSX";

    /* renamed from: d */
    private boolean f5306d = false;

    /* renamed from: e */
    private boolean f5307e = false;

    /* renamed from: f */
    private boolean f5308f = false;

    /* renamed from: g */
    private boolean f5309g = false;

    /* renamed from: h */
    private boolean f5310h = false;

    /* renamed from: k */
    private byte[] f5313k = null;

    /* renamed from: l */
    private byte[] f5314l = null;

    /* renamed from: m */
    private byte[] f5315m = null;

    /* renamed from: n */
    private byte[] f5316n = null;

    /* renamed from: o */
    private byte[] f5317o = null;

    /* renamed from: p */
    private byte[] f5318p = null;

    /* renamed from: s */
    private boolean f5321s = false;

    /* renamed from: t */
    private boolean f5322t = false;

    /* renamed from: u */
    private boolean f5323u = false;

    /* renamed from: x */
    private byte[] f5326x = null;

    /* renamed from: y */
    private byte[] f5327y = null;

    /* renamed from: z */
    private byte[] f5328z = null;

    /* renamed from: A */
    private boolean f5297A = false;

    /* renamed from: C */
    private HashMap<String, byte[]> f5299C = new HashMap<>();

    /* renamed from: E */
    private MyTrafficStyle f5301E = new MyTrafficStyle();

    /* compiled from: AMapCustomStyleManager.java */
    /* renamed from: com.amap.api.col.3l.s8$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1942a {
        /* renamed from: a */
        void mo53905a();
    }

    public AMapCustomStyleManager(IAMapDelegate iAMapDelegate, Context context, boolean z) {
        this.f5311i = -1;
        this.f5319q = false;
        this.f5320r = false;
        this.f5298B = false;
        this.f5304b = iAMapDelegate;
        this.f5312j = context;
        this.f5319q = false;
        this.f5320r = false;
        this.f5298B = z;
        this.f5311i = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
    }

    /* renamed from: e */
    private void m53922e(MapConfig mapConfig) {
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.f5299C.clear();
            return;
        }
        String styleResDataPath = this.f5305c.getStyleResDataPath();
        if (this.f5305c.getStyleResData() == null && !TextUtils.isEmpty(styleResDataPath)) {
            this.f5305c.setStyleResData(FileUtil.readFileContents(styleResDataPath));
        }
        if (this.f5305c.getStyleResData() == null && this.f5328z == null) {
            return;
        }
        byte[] bArr2 = this.f5328z;
        if (bArr2 == null) {
            bArr2 = this.f5305c.getStyleResData();
        }
        if (bArr2 != null) {
            mapConfig.setUseProFunction(true);
            this.f5299C.clear();
            Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr2, null);
            if (uncompressToByteWithKeys != null) {
                for (String str : uncompressToByteWithKeys.keySet()) {
                    if (str != null && !str.contains("__MACOSX") && (bArr = uncompressToByteWithKeys.get(str)) != null) {
                        if (FileUtil.isGzip(bArr)) {
                            this.f5299C.put(str, bArr);
                        } else {
                            this.f5299C.put(str, FileUtil.compress(bArr));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: f */
    private void m53921f(String str, boolean z) {
        boolean z2;
        int m55514b = !TextUtils.isEmpty(str) ? StyleParser.m55514b(str) : Integer.MIN_VALUE;
        IAMapDelegate iAMapDelegate = this.f5304b;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        if (this.f5315m == null) {
            Context context = this.f5312j;
            this.f5315m = FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_CUSTOM_BACKGROUND_NAME);
        }
        byte[] bArr = this.f5315m;
        if (bArr != null) {
            if (!z) {
                m55514b = 0;
            } else if (m55514b == Integer.MIN_VALUE) {
                z2 = true;
                this.f5304b.getGLMapEngine().setBackgroundTexture(this.f5311i, C1732a3.m55725T((byte[]) bArr.clone(), 0, m55514b, z2));
            }
            z2 = false;
            this.f5304b.getGLMapEngine().setBackgroundTexture(this.f5311i, C1732a3.m55725T((byte[]) bArr.clone(), 0, m55514b, z2));
        }
    }

    /* renamed from: g */
    private void m53920g(JSONObject jSONObject) {
        this.f5304b.getGLMapEngine().setCustomThirdLayerStyle(this.f5311i, jSONObject.toString());
    }

    /* renamed from: h */
    private void m53919h(byte[] bArr) {
        StyleConfig m55513c;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (bArr == null || (m55513c = StyleParser.m55513c(bArr)) == null || m55513c.m55749a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(m55513c.m55749a());
            JSONObject optJSONObject3 = jSONObject.optJSONObject("mapStyle");
            String str = null;
            boolean z = true;
            if (optJSONObject3 != null && (optJSONObject2 = optJSONObject3.optJSONObject("bg")) != null) {
                z = optJSONObject2.optBoolean("visible", true);
                str = optJSONObject2.optString("lineColor", null);
            }
            m53921f(str, z);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("layer");
            if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject(UContent.f38075F)) != null) {
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("multiFillColors");
                if (optJSONObject.optBoolean("visible") && optJSONObject5 != null) {
                    int m55514b = StyleParser.m55514b(optJSONObject5.optString("smooth"));
                    int m55514b2 = StyleParser.m55514b(optJSONObject5.optString("slow"));
                    int m55514b3 = StyleParser.m55514b(optJSONObject5.optString("congested"));
                    int m55514b4 = StyleParser.m55514b(optJSONObject5.optString("seriousCongested"));
                    this.f5301E.setSmoothColor(m55514b);
                    this.f5301E.setSlowColor(m55514b2);
                    this.f5301E.setCongestedColor(m55514b3);
                    this.f5301E.setSeriousCongestedColor(m55514b4);
                    if (this.f5318p == null) {
                        Context context = this.f5312j;
                        this.f5318p = FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_TRL_NAME);
                    }
                    this.f5304b.setTrafficStyleWithTexture(this.f5318p, this.f5301E);
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("third_layer");
            if (optJSONObject6 != null) {
                m53920g(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("model_layer");
            if (optJSONObject7 != null) {
                m53916k(optJSONObject7.optString("id"));
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapCustomStyleManager", "setExtraStyle");
            C1732a3.m55741D(th);
        }
    }

    /* renamed from: k */
    private void m53916k(String str) {
        AMap3DModelTileProvider aMap3DModelTileProvider = new AMap3DModelTileProvider();
        aMap3DModelTileProvider.setUrl("https://restapi.amap.com/rest/lbs/geohub/3d/tiles?z=%d&x=%d&y=%d&id=" + str);
        AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions = new AMap3DModelTileOverlayOptions();
        aMap3DModelTileOverlayOptions.setTileProvider(aMap3DModelTileProvider);
        try {
            this.f5300D = this.f5304b.add3DModelTileOverlay(aMap3DModelTileOverlayOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    private boolean m53915l(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            return this.f5304b.getGLMapEngine().checkCustomStyleData(this.f5311i, bArr);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapCustomStyleManager", "checkData");
            C1732a3.m55741D(th);
            return true;
        }
    }

    /* renamed from: m */
    private static String m53914m(String str) {
        int indexOf;
        return (str == null || (indexOf = str.indexOf("99999_")) == -1) ? str : str.substring(0, indexOf).replace("99999_", "");
    }

    /* renamed from: o */
    private static byte[] m53912o(byte[] bArr) {
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
                C1732a3.m55741D(th);
                th.printStackTrace();
                return null;
            } finally {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
            }
        }
    }

    /* renamed from: r */
    private void m53909r() {
        IAMapDelegate iAMapDelegate = this.f5304b;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.f5318p != null) {
            this.f5304b.getGLMapEngine().setTrafficStyleWithTexture(this.f5311i, this.f5318p, new MyTrafficStyle());
        }
        IAMapDelegate iAMapDelegate2 = this.f5304b;
        if (iAMapDelegate2 != null && iAMapDelegate2.getGLMapEngine() != null && this.f5315m != null) {
            this.f5304b.getGLMapEngine().setBackgroundTexture(this.f5311i, this.f5315m);
        }
        AMap3DModelTileOverlay aMap3DModelTileOverlay = this.f5300D;
        if (aMap3DModelTileOverlay != null) {
            aMap3DModelTileOverlay.remove();
        }
        this.f5323u = false;
    }

    /* renamed from: s */
    private void m53908s() {
        if (this.f5298B) {
            if (this.f5314l == null) {
                Context context = this.f5312j;
                this.f5314l = m53912o(FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_ABROAD));
            }
        } else if (this.f5314l == null) {
            Context context2 = this.f5312j;
            this.f5314l = m53912o(FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
        }
        this.f5304b.getGLMapEngine().setCustomStyleData(this.f5311i, this.f5314l, this.f5313k);
        this.f5322t = false;
        this.f5299C.clear();
    }

    /* renamed from: t */
    private void m53907t() {
        if (this.f5321s) {
            if (this.f5316n == null) {
                Context context = this.f5312j;
                this.f5316n = FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.f5321s = false;
            this.f5304b.getGLMapEngine().setCustomStyleTexture(this.f5311i, this.f5316n);
        }
    }

    /* renamed from: u */
    private void m53906u() {
        CustomMapStyleOptions customMapStyleOptions = this.f5305c;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.f5305c.setStyleDataPath(null);
            this.f5305c.setStyleData(null);
            this.f5305c.setStyleTexturePath(null);
            this.f5305c.setStyleTextureData(null);
            this.f5305c.setStyleExtraData(null);
            this.f5305c.setStyleExtraPath(null);
        }
    }

    /* renamed from: a */
    public final void m53925a() {
        IAMapDelegate iAMapDelegate;
        if (this.f5305c == null || this.f5320r) {
            return;
        }
        try {
            MapConfig mapConfig = this.f5304b.getMapConfig();
            if (mapConfig == null) {
                return;
            }
            synchronized (this) {
                if (mapConfig.isHideLogoEnable() && (iAMapDelegate = this.f5304b) != null && iAMapDelegate.getUiSettings() != null) {
                    if (this.f5304b.getUiSettings().isLogoEnable()) {
                        if (this.f5305c.isEnable()) {
                            if (this.f5322t) {
                                this.f5304b.getUiSettings().setLogoEnable(false);
                            }
                        } else {
                            this.f5304b.getUiSettings().setLogoEnable(true);
                        }
                    } else if (!this.f5322t) {
                        this.f5304b.getUiSettings().setLogoEnable(true);
                    }
                }
                if (this.f5306d) {
                    if (this.f5305c.isEnable()) {
                        this.f5304b.getGLMapEngine().setNativeMapModeAndStyle(this.f5311i, 0, 0);
                        mapConfig.setCustomStyleEnable(true);
                        this.f5306d = false;
                    } else {
                        this.f5304b.getGLMapEngine().setNativeMapModeAndStyle(this.f5311i, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime());
                        this.f5322t = false;
                        if (mapConfig.isCustomStyleEnable()) {
                            if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0) {
                                m53908s();
                            }
                            m53907t();
                            if (this.f5323u) {
                                m53909r();
                            }
                            mapConfig.setCustomStyleEnable(false);
                        }
                        this.f5306d = false;
                        return;
                    }
                }
                if (this.f5308f) {
                    String styleTexturePath = this.f5305c.getStyleTexturePath();
                    if (this.f5305c.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                        this.f5305c.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                    }
                    if (this.f5305c.getStyleTextureData() != null) {
                        this.f5297A = true;
                        if (mapConfig.isProFunctionAuthEnable()) {
                            this.f5321s = true;
                            this.f5304b.getGLMapEngine().setCustomStyleTexture(this.f5311i, this.f5305c.getStyleTextureData());
                            mapConfig.setUseProFunction(true);
                        } else {
                            m53907t();
                        }
                    } else {
                        m53907t();
                        this.f5297A = false;
                    }
                    this.f5308f = false;
                }
                if (this.f5307e) {
                    String styleDataPath = this.f5305c.getStyleDataPath();
                    if (this.f5305c.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                        this.f5305c.setStyleData(FileUtil.readFileContents(styleDataPath));
                    }
                    if (this.f5305c.getStyleData() == null && this.f5326x == null) {
                        if (this.f5322t) {
                            this.f5306d = true;
                            this.f5305c.setEnable(false);
                        }
                        this.f5307e = false;
                    }
                    if (this.f5317o == null) {
                        Context context = this.f5312j;
                        this.f5317o = m53912o(FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_0_FOR_TEXTURE));
                    }
                    byte[] bArr = this.f5326x;
                    if (bArr == null) {
                        bArr = this.f5305c.getStyleData();
                    }
                    if (!m53915l(bArr)) {
                        AuthLogUtil.m54857a();
                    } else {
                        this.f5304b.getGLMapEngine().setCustomStyleData(this.f5311i, bArr, this.f5317o);
                        this.f5322t = true;
                        IAMapDelegate iAMapDelegate2 = this.f5304b;
                        if (iAMapDelegate2 != null) {
                            iAMapDelegate2.resetRenderTime();
                        }
                    }
                    this.f5307e = false;
                }
                if (this.f5309g) {
                    String styleExtraPath = this.f5305c.getStyleExtraPath();
                    if (this.f5305c.getStyleExtraData() == null && !TextUtils.isEmpty(styleExtraPath)) {
                        this.f5305c.setStyleExtraData(FileUtil.readFileContents(styleExtraPath));
                    }
                    if (this.f5305c.getStyleExtraData() != null || this.f5327y != null) {
                        byte[] bArr2 = this.f5327y;
                        if (bArr2 == null) {
                            bArr2 = this.f5305c.getStyleExtraData();
                        }
                        if (bArr2 != null) {
                            m53919h(bArr2);
                            this.f5323u = true;
                        }
                    }
                    this.f5309g = false;
                }
                if (this.f5310h) {
                    m53922e(mapConfig);
                    this.f5310h = false;
                }
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapCustomStyleManager", "updateStyle");
            C1732a3.m55741D(th);
        }
    }

    @Override // com.amap.api.col.p0463l.CustomStyleTask.InterfaceC1979a
    /* renamed from: b */
    public final void mo53603b(byte[] bArr, int i) {
        MapConfig mapConfig;
        InterfaceC1942a interfaceC1942a;
        if (this.f5305c != null) {
            synchronized (this) {
                IAMapDelegate iAMapDelegate = this.f5304b;
                if (iAMapDelegate != null && (mapConfig = iAMapDelegate.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                    mapConfig.setUseProFunction(true);
                    if (i == 1) {
                        this.f5326x = bArr;
                        this.f5307e = true;
                    } else if (i == 0) {
                        this.f5327y = bArr;
                        this.f5309g = true;
                    } else if (i == 2) {
                        String str = this.f5305c.getStyleId() + "_sdk_1000.data";
                        String str2 = this.f5305c.getStyleId() + "_abroad_sdk.json";
                        Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                        if (uncompressToByteWithKeys != null) {
                            byte[] bArr2 = uncompressToByteWithKeys.get(str);
                            if (bArr2 != null) {
                                this.f5326x = bArr2;
                                this.f5307e = true;
                            }
                            if (uncompressToByteWithKeys.get(str2) != null && (interfaceC1942a = this.f5302F) != null) {
                                interfaceC1942a.mo53905a();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public final void m53924c(InterfaceC1942a interfaceC1942a) {
        this.f5302F = interfaceC1942a;
    }

    /* renamed from: d */
    public final void m53923d(CustomMapStyleOptions customMapStyleOptions) {
        IAMapDelegate iAMapDelegate;
        if (this.f5305c == null || customMapStyleOptions == null) {
            return;
        }
        synchronized (this) {
            if (!this.f5319q) {
                this.f5319q = true;
                if (this.f5305c.isEnable()) {
                    this.f5306d = true;
                }
            }
            if (this.f5305c.isEnable() != customMapStyleOptions.isEnable()) {
                this.f5305c.setEnable(customMapStyleOptions.isEnable());
                this.f5306d = true;
                StatisticsUtil.m53548m(this.f5312j, customMapStyleOptions.isEnable());
            }
            if (this.f5305c.isEnable()) {
                if (!TextUtils.equals(this.f5305c.getStyleId(), customMapStyleOptions.getStyleId())) {
                    this.f5305c.setStyleId(customMapStyleOptions.getStyleId());
                    String styleId = this.f5305c.getStyleId();
                    if (!TextUtils.isEmpty(styleId) && (iAMapDelegate = this.f5304b) != null && iAMapDelegate.getMapConfig() != null && this.f5304b.getMapConfig().isProFunctionAuthEnable()) {
                        if (this.f5324v == null) {
                            if (this.f5298B) {
                                this.f5324v = new CustomStyleTask(this.f5312j, this, 2, "abroad_sdk_json_sdk_1000_zip");
                            } else {
                                this.f5324v = new CustomStyleTask(this.f5312j, this, 1, "sdk_1000");
                            }
                        }
                        this.f5324v.m53609b(styleId);
                        this.f5324v.m53610b();
                        if (this.f5325w == null) {
                            this.f5325w = new CustomStyleTask(this.f5312j, this, 0, null);
                        }
                        this.f5325w.m53609b(styleId);
                        this.f5325w.m53610b();
                    }
                }
                if (!TextUtils.equals(this.f5305c.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                    this.f5305c.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                    this.f5307e = true;
                }
                if (this.f5305c.getStyleData() != customMapStyleOptions.getStyleData()) {
                    this.f5305c.setStyleData(customMapStyleOptions.getStyleData());
                    this.f5307e = true;
                }
                if (!TextUtils.equals(this.f5305c.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                    this.f5305c.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                    this.f5308f = true;
                }
                if (this.f5305c.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                    this.f5305c.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                    this.f5308f = true;
                }
                if (!TextUtils.equals(this.f5305c.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                    this.f5305c.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                    this.f5309g = true;
                }
                if (this.f5305c.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                    this.f5305c.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                    this.f5309g = true;
                }
                if (!TextUtils.equals(this.f5305c.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                    this.f5305c.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                    this.f5310h = true;
                }
                if (this.f5305c.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                    this.f5305c.setStyleResData(customMapStyleOptions.getStyleResData());
                    this.f5310h = true;
                }
                StatisticsUtil.m53551j(this.f5312j, true);
            } else {
                m53906u();
                StatisticsUtil.m53551j(this.f5312j, false);
            }
        }
    }

    /* renamed from: i */
    public final byte[] m53918i(String str) {
        MapConfig mapConfig;
        if (str == null || (mapConfig = this.f5304b.getMapConfig()) == null) {
            return null;
        }
        if (!mapConfig.isProFunctionAuthEnable()) {
            return FileUtil.readFileContentsFromAssetsByPreName(this.f5312j, AMapEngineUtils.MAP_MAP_ASSETS_NAME, m53914m(str));
        }
        for (String str2 : this.f5299C.keySet()) {
            if (str.contains(str2)) {
                return this.f5299C.get(str2);
            }
        }
        return null;
    }

    /* renamed from: j */
    public final void m53917j() {
        if (this.f5305c == null) {
            return;
        }
        synchronized (this) {
            IAMapDelegate iAMapDelegate = this.f5304b;
            if (iAMapDelegate != null && iAMapDelegate.getMapConfig() != null && !this.f5304b.getMapConfig().isProFunctionAuthEnable()) {
                this.f5305c.setStyleId(null);
                this.f5326x = null;
                this.f5327y = null;
                this.f5328z = null;
            }
            this.f5308f = true;
            this.f5307e = true;
            if (this.f5323u) {
                this.f5309g = true;
            }
            this.f5306d = true;
            this.f5310h = true;
        }
    }

    /* renamed from: n */
    public final void m53913n() {
        if (this.f5305c == null) {
            this.f5305c = new CustomMapStyleOptions();
        }
    }

    /* renamed from: p */
    public final boolean m53911p() {
        return this.f5305c != null;
    }

    /* renamed from: q */
    public final void m53910q() {
        synchronized (this) {
            CustomMapStyleOptions customMapStyleOptions = this.f5305c;
            if (customMapStyleOptions != null) {
                customMapStyleOptions.setEnable(false);
                m53906u();
                this.f5306d = true;
            }
        }
    }

    @Override // com.amap.api.col.p0463l.CustomStyleTask.InterfaceC1979a
    /* renamed from: a */
    public final void mo53604a(byte[] bArr, int i) {
        mo53603b(bArr, i);
    }
}
