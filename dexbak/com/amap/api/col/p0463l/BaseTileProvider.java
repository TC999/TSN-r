package com.amap.api.col.p0463l;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.tencent.bugly.BUGLY;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.amap.api.col.3l.i2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class BaseTileProvider implements TileProvider {

    /* renamed from: c */
    private MapConfig f4488c;

    /* renamed from: a */
    private final int f4486a = 256;

    /* renamed from: b */
    private final int f4487b = 256;

    /* renamed from: d */
    private final boolean f4489d = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseTileProvider.java */
    /* renamed from: com.amap.api.col.3l.i2$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1837a extends BaseTileRequest {

        /* renamed from: i */
        private int f4490i;

        /* renamed from: j */
        private int f4491j;

        /* renamed from: k */
        private int f4492k;

        /* renamed from: p */
        private String f4493p;

        /* renamed from: q */
        private String f4494q;

        /* renamed from: r */
        Random f4495r = new Random();

        public C1837a(int i, int i2, int i3, String str) {
            this.f4494q = "";
            this.f4490i = i;
            this.f4491j = i2;
            this.f4492k = i3;
            this.f4493p = str;
            this.f4494q = m54731m();
        }

        /* renamed from: m */
        private String m54731m() {
            if (!RegionUtil.m53891b(this.f4490i, this.f4491j, this.f4492k) && this.f4492k >= 6) {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    return "http://restsdk.amap.com/v4/gridmap?";
                }
                return null;
            }
            return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", Integer.valueOf((this.f4495r.nextInt(BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH) % 4) + 1));
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(C1780e4.m55240j(MapFragmentDelegateImp.f3708f));
            stringBuffer.append("&channel=amapapi");
            if (!RegionUtil.m53891b(this.f4490i, this.f4491j, this.f4492k) && this.f4492k >= 6) {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    stringBuffer.append("&x=");
                    stringBuffer.append(this.f4490i);
                    stringBuffer.append("&y=");
                    stringBuffer.append(this.f4491j);
                    stringBuffer.append("&z=");
                    stringBuffer.append(this.f4492k);
                    stringBuffer.append("&ds=0");
                    stringBuffer.append("&dpitype=webrd");
                    stringBuffer.append("&lang=");
                    stringBuffer.append(this.f4493p);
                    stringBuffer.append("&scale=2");
                }
            } else {
                stringBuffer.append("&z=");
                stringBuffer.append(this.f4492k);
                stringBuffer.append("&x=");
                stringBuffer.append(this.f4490i);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f4491j);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            }
            return this.f4494q + appendTsScode(stringBuffer.toString());
        }
    }

    public BaseTileProvider(MapConfig mapConfig) {
        this.f4488c = mapConfig;
    }

    /* renamed from: a */
    private byte[] m54732a(int i, int i2, int i3, String str) throws IOException {
        try {
            return new C1837a(i, i2, i3, str).makeHttpRequestWithInterrupted();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        try {
            if (!this.f4489d) {
                if (this.f4488c.getMapLanguage().equals("zh_cn")) {
                    if (!MapsInitializer.isLoadWorldGridMap()) {
                        return TileProvider.NO_TILE;
                    }
                    if (i3 < 6 || RegionUtil.m53891b(i, i2, i3)) {
                        return TileProvider.NO_TILE;
                    }
                } else if (!MapsInitializer.isLoadWorldGridMap() && i3 >= 6 && !RegionUtil.m53891b(i, i2, i3)) {
                    return TileProvider.NO_TILE;
                }
            }
            MapConfig mapConfig = this.f4488c;
            byte[] m54732a = m54732a(i, i2, i3, mapConfig != null ? mapConfig.getMapLanguage() : "zh_cn");
            if (m54732a == null) {
                return TileProvider.NO_TILE;
            }
            return Tile.obtain(this.f4486a, this.f4487b, m54732a);
        } catch (IOException unused) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f4487b;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f4486a;
    }
}
