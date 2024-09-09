package com.amap.api.col.p0003l;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceReq;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: TerrainTileSourceProvider.java */
/* renamed from: com.amap.api.col.3l.g  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g implements TileSourceProvider {

    /* renamed from: a  reason: collision with root package name */
    private int f7792a = 256;

    /* renamed from: b  reason: collision with root package name */
    private final TileOverlaySource f7793b;

    /* renamed from: c  reason: collision with root package name */
    private final TileOverlaySource f7794c;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: TerrainTileSourceProvider.java */
    /* renamed from: com.amap.api.col.3l.g$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends j2 {

        /* renamed from: i  reason: collision with root package name */
        private String f7795i;

        /* renamed from: j  reason: collision with root package name */
        private String f7796j;

        public a(int i4, int i5, int i6, String str) {
            this.f7795i = "";
            this.f7796j = "";
            String format = String.format(str, Integer.valueOf(i6), Integer.valueOf(i4), Integer.valueOf(i5));
            if (!format.contains("?")) {
                this.f7795i = format + "?";
                return;
            }
            String[] split = format.split("\\?");
            if (split.length > 1) {
                this.f7795i = split[0] + "?";
                this.f7796j = split[1];
            }
        }

        @Override // com.amap.api.col.p0003l.j2, com.amap.api.col.p0003l.Cif
        public final Map<String, String> getRequestHead() {
            return super.getRequestHead();
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f7796j);
            stringBuffer.append("&key=");
            stringBuffer.append(e4.j(c.f7290f));
            stringBuffer.append("&channel=amapapi");
            return this.f7795i + appendTsScode(stringBuffer.toString());
        }
    }

    public g(TileOverlaySource tileOverlaySource, TileOverlaySource tileOverlaySource2) {
        this.f7793b = tileOverlaySource;
        this.f7794c = tileOverlaySource2;
    }

    private Tile a(TileSourceReq tileSourceReq) {
        String str = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH;
        try {
            int i4 = tileSourceReq.f12054x;
            if (i4 > 0) {
                i4 /= 10;
            }
            int i5 = tileSourceReq.f12055y;
            if (i5 > 0) {
                i5 /= 10;
            }
            FileInputStream fileInputStream = new FileInputStream(new File(str + tileSourceReq.zoom + TTPathConst.sSeparator + i4 + TTPathConst.sSeparator + i5 + TTPathConst.sSeparator + tileSourceReq.f12054x + "_" + tileSourceReq.f12055y + ".png"));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            int i6 = this.f7792a;
            Tile tile = new Tile(i6, i6, bArr, true);
            fileInputStream.close();
            return tile;
        } catch (FileNotFoundException unused) {
            int i7 = tileSourceReq.f12054x;
            int i8 = tileSourceReq.zoom;
            int i9 = i7 >> (i8 - 6);
            int i10 = tileSourceReq.f12055y >> (i8 - 6);
            if (i9 >= 51 && i9 <= 53 && i10 >= 28 && i10 <= 31) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(str + "default.png"));
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    int i11 = this.f7792a;
                    Tile tile2 = new Tile(i11, i11, bArr2, true);
                    fileInputStream2.close();
                    return tile2;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return TileProvider.NO_TILE;
                }
            }
            return TileProvider.NO_TILE;
        } catch (IOException unused2) {
            return TileProvider.NO_TILE;
        }
    }

    private byte[] b(int i4, int i5, int i6, String str) {
        try {
            return new a(i4, i5, i6, str).makeHttpRequestWithInterrupted();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final void cancel(TileSourceReq tileSourceReq) {
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i4, int i5, int i6) {
        return null;
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final Tile getTile(TileSourceReq tileSourceReq) {
        String url;
        if (tileSourceReq == null) {
            return TileProvider.NO_TILE;
        }
        Tile tile = TileProvider.NO_TILE;
        try {
            if (tileSourceReq.sourceType == this.f7794c.getId()) {
                url = this.f7794c.getUrl();
            } else {
                url = this.f7793b.getUrl();
            }
            if (url == null) {
                return tile;
            }
            Tile a4 = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH != null ? a(tileSourceReq) : tile;
            if (a4 == tile) {
                int i4 = this.f7792a;
                return new Tile(i4, i4, b(tileSourceReq.f12054x, tileSourceReq.f12055y, tileSourceReq.zoom, url), true);
            }
            return a4;
        } catch (Exception e4) {
            Tile tile2 = TileProvider.NO_TILE;
            e4.printStackTrace();
            return tile2;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f7792a;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f7792a;
    }
}
