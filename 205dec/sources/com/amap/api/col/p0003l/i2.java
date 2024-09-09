package com.amap.api.col.p0003l;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: BaseTileProvider.java */
/* renamed from: com.amap.api.col.3l.i2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i2 implements TileProvider {

    /* renamed from: c  reason: collision with root package name */
    private MapConfig f8074c;

    /* renamed from: a  reason: collision with root package name */
    private final int f8072a = 256;

    /* renamed from: b  reason: collision with root package name */
    private final int f8073b = 256;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8075d = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: BaseTileProvider.java */
    /* renamed from: com.amap.api.col.3l.i2$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends j2 {

        /* renamed from: i  reason: collision with root package name */
        private int f8076i;

        /* renamed from: j  reason: collision with root package name */
        private int f8077j;

        /* renamed from: k  reason: collision with root package name */
        private int f8078k;

        /* renamed from: p  reason: collision with root package name */
        private String f8079p;

        /* renamed from: q  reason: collision with root package name */
        private String f8080q;

        /* renamed from: r  reason: collision with root package name */
        Random f8081r = new Random();

        public a(int i4, int i5, int i6, String str) {
            this.f8080q = "";
            this.f8076i = i4;
            this.f8077j = i5;
            this.f8078k = i6;
            this.f8079p = str;
            this.f8080q = m();
        }

        private String m() {
            if (!t2.b(this.f8076i, this.f8077j, this.f8078k) && this.f8078k >= 6) {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    return "http://restsdk.amap.com/v4/gridmap?";
                }
                return null;
            }
            return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", Integer.valueOf((this.f8081r.nextInt(100000) % 4) + 1));
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(e4.j(c.f7290f));
            stringBuffer.append("&channel=amapapi");
            if (!t2.b(this.f8076i, this.f8077j, this.f8078k) && this.f8078k >= 6) {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    stringBuffer.append("&x=");
                    stringBuffer.append(this.f8076i);
                    stringBuffer.append("&y=");
                    stringBuffer.append(this.f8077j);
                    stringBuffer.append("&z=");
                    stringBuffer.append(this.f8078k);
                    stringBuffer.append("&ds=0");
                    stringBuffer.append("&dpitype=webrd");
                    stringBuffer.append("&lang=");
                    stringBuffer.append(this.f8079p);
                    stringBuffer.append("&scale=2");
                }
            } else {
                stringBuffer.append("&z=");
                stringBuffer.append(this.f8078k);
                stringBuffer.append("&x=");
                stringBuffer.append(this.f8076i);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f8077j);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            }
            return this.f8080q + appendTsScode(stringBuffer.toString());
        }
    }

    public i2(MapConfig mapConfig) {
        this.f8074c = mapConfig;
    }

    private byte[] a(int i4, int i5, int i6, String str) throws IOException {
        try {
            return new a(i4, i5, i6, str).makeHttpRequestWithInterrupted();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i4, int i5, int i6) {
        try {
            if (!this.f8075d) {
                if (this.f8074c.getMapLanguage().equals("zh_cn")) {
                    if (!MapsInitializer.isLoadWorldGridMap()) {
                        return TileProvider.NO_TILE;
                    }
                    if (i6 < 6 || t2.b(i4, i5, i6)) {
                        return TileProvider.NO_TILE;
                    }
                } else if (!MapsInitializer.isLoadWorldGridMap() && i6 >= 6 && !t2.b(i4, i5, i6)) {
                    return TileProvider.NO_TILE;
                }
            }
            MapConfig mapConfig = this.f8074c;
            byte[] a4 = a(i4, i5, i6, mapConfig != null ? mapConfig.getMapLanguage() : "zh_cn");
            if (a4 == null) {
                return TileProvider.NO_TILE;
            }
            return Tile.obtain(this.f8072a, this.f8073b, a4);
        } catch (IOException unused) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f8073b;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f8072a;
    }
}
