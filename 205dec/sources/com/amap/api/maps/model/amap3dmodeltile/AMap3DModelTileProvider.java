package com.amap.api.maps.model.amap3dmodeltile;

import com.amap.api.col.p0003l.c;
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.j2;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class AMap3DModelTileProvider implements TileProvider {
    private static final String DEFAULT_URL = "https://lbs-3dtiles-service.amap.com/basemap/tiles/staging?compose=building@1669011850923&compose=tree@1668678765481&z=%d&x=%d&y=%d";
    private int tileSize = 256;
    private String url;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class AMap3DModelRequest extends j2 {
        private String baseQueryStr;
        private String baseUrl;

        public AMap3DModelRequest(String str) {
            this.baseUrl = "";
            this.baseQueryStr = "";
            this.isPostFlag = false;
            if (!str.contains("?")) {
                this.baseUrl = str + "?";
                return;
            }
            String[] split = str.split("\\?");
            if (split.length > 1) {
                this.baseUrl = split[0] + "?";
                this.baseQueryStr = split[1];
            }
        }

        @Override // com.amap.api.col.p0003l.Cif
        public String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.baseQueryStr);
            stringBuffer.append("&key=");
            stringBuffer.append(e4.j(c.f7290f));
            return this.baseUrl + appendTsScode(stringBuffer.toString());
        }
    }

    private byte[] a(int i4, int i5, int i6) {
        try {
            return new AMap3DModelRequest(b(i4, i5, i6)).makeHttpRequestWithInterrupted();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private String b(int i4, int i5, int i6) {
        String str = this.url;
        if (str == null) {
            str = "https://lbs-3dtiles-service.amap.com/basemap/tiles/staging?compose=building@1669011850923&compose=tree@1668678765481&z=%d&x=%d&y=%d";
        }
        return String.format(str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i4, int i5, int i6) {
        byte[] a4 = a(i6, i4, i5);
        if (a4 == null) {
            return TileProvider.NO_TILE;
        }
        int i7 = this.tileSize;
        return new Tile(i7, i7, a4, false);
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.tileSize;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.tileSize;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
