package com.amap.api.col.p0463l;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.p048ae.gmap.bean.TileSourceProvider;
import com.autonavi.base.p048ae.gmap.bean.TileSourceReq;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class TerrainTileSourceProvider implements TileSourceProvider {

    /* renamed from: a */
    private int f4227a = 256;

    /* renamed from: b */
    private final TileOverlaySource f4228b;

    /* renamed from: c */
    private final TileOverlaySource f4229c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TerrainTileSourceProvider.java */
    /* renamed from: com.amap.api.col.3l.g$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1816a extends BaseTileRequest {

        /* renamed from: i */
        private String f4230i;

        /* renamed from: j */
        private String f4231j;

        public C1816a(int i, int i2, int i3, String str) {
            this.f4230i = "";
            this.f4231j = "";
            String format = String.format(str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
            if (!format.contains("?")) {
                this.f4230i = format + "?";
                return;
            }
            String[] split = format.split("\\?");
            if (split.length > 1) {
                this.f4230i = split[0] + "?";
                this.f4231j = split[1];
            }
        }

        @Override // com.amap.api.col.p0463l.BaseTileRequest, com.amap.api.col.p0463l.AbstractC1840if
        public final Map<String, String> getRequestHead() {
            return super.getRequestHead();
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f4231j);
            stringBuffer.append("&key=");
            stringBuffer.append(C1780e4.m55240j(MapFragmentDelegateImp.f3708f));
            stringBuffer.append("&channel=amapapi");
            return this.f4230i + appendTsScode(stringBuffer.toString());
        }
    }

    public TerrainTileSourceProvider(TileOverlaySource tileOverlaySource, TileOverlaySource tileOverlaySource2) {
        this.f4228b = tileOverlaySource;
        this.f4229c = tileOverlaySource2;
    }

    /* renamed from: a */
    private Tile m54967a(TileSourceReq tileSourceReq) {
        String str = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH;
        try {
            int i = tileSourceReq.f8416x;
            if (i > 0) {
                i /= 10;
            }
            int i2 = tileSourceReq.f8417y;
            if (i2 > 0) {
                i2 /= 10;
            }
            FileInputStream fileInputStream = new FileInputStream(new File(str + tileSourceReq.zoom + "/" + i + "/" + i2 + "/" + tileSourceReq.f8416x + "_" + tileSourceReq.f8417y + PhotoBitmapUtils.f15141c));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            int i3 = this.f4227a;
            Tile tile = new Tile(i3, i3, bArr, true);
            fileInputStream.close();
            return tile;
        } catch (FileNotFoundException unused) {
            int i4 = tileSourceReq.f8416x;
            int i5 = tileSourceReq.zoom;
            int i6 = i4 >> (i5 - 6);
            int i7 = tileSourceReq.f8417y >> (i5 - 6);
            if (i6 >= 51 && i6 <= 53 && i7 >= 28 && i7 <= 31) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(str + "default.png"));
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    int i8 = this.f4227a;
                    Tile tile2 = new Tile(i8, i8, bArr2, true);
                    fileInputStream2.close();
                    return tile2;
                } catch (Exception e) {
                    e.printStackTrace();
                    return TileProvider.NO_TILE;
                }
            }
            return TileProvider.NO_TILE;
        } catch (IOException unused2) {
            return TileProvider.NO_TILE;
        }
    }

    /* renamed from: b */
    private byte[] m54966b(int i, int i2, int i3, String str) {
        try {
            return new C1816a(i, i2, i3, str).makeHttpRequestWithInterrupted();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.p048ae.gmap.bean.TileSourceProvider
    public final void cancel(TileSourceReq tileSourceReq) {
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        return null;
    }

    @Override // com.autonavi.base.p048ae.gmap.bean.TileSourceProvider
    public final Tile getTile(TileSourceReq tileSourceReq) {
        String url;
        if (tileSourceReq == null) {
            return TileProvider.NO_TILE;
        }
        Tile tile = TileProvider.NO_TILE;
        try {
            if (tileSourceReq.sourceType == this.f4229c.getId()) {
                url = this.f4229c.getUrl();
            } else {
                url = this.f4228b.getUrl();
            }
            if (url == null) {
                return tile;
            }
            Tile m54967a = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH != null ? m54967a(tileSourceReq) : tile;
            if (m54967a == tile) {
                int i = this.f4227a;
                return new Tile(i, i, m54966b(tileSourceReq.f8416x, tileSourceReq.f8417y, tileSourceReq.zoom, url), true);
            }
            return m54967a;
        } catch (Exception e) {
            Tile tile2 = TileProvider.NO_TILE;
            e.printStackTrace();
            return tile2;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f4227a;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f4227a;
    }
}
