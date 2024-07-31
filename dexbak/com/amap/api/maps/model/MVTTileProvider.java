package com.amap.api.maps.model;

import com.amap.api.col.p0463l.BaseTileRequest;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MVTTileProvider implements TileProvider {

    /* renamed from: id */
    private String f7038id;
    private String key;
    private int tileSize = 256;
    private String url;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.maps.model.MVTTileProvider$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2265a extends BaseTileRequest {

        /* renamed from: a */
        String f7039a;

        public C2265a(String str) {
            this.isPostFlag = false;
            this.f7039a = str;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getURL() {
            return this.f7039a;
        }
    }

    public MVTTileProvider(String str, String str2, String str3) {
        this.url = str;
        this.key = str2;
        this.f7038id = str3;
    }

    /* renamed from: a */
    private byte[] m52042a(int i, int i2, int i3) {
        try {
            return new C2265a(m52041a(i, i2, i3, this.tileSize)).makeHttpRequestWithInterrupted();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getId() {
        return this.f7038id;
    }

    public final String getKey() {
        return this.key;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        byte[] m52042a = m52042a(i3, i, i2);
        if (m52042a == null) {
            return TileProvider.NO_TILE;
        }
        int i4 = this.tileSize;
        return new Tile(i4, i4, m52042a, false);
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

    /* renamed from: a */
    private String m52041a(int i, int i2, int i3, int i4) {
        return String.format(this.url + "?z=%d&x=%d&y=%d&size=%d&key=" + this.key + "&id=" + this.f7038id, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
