package com.amap.api.maps.model;

import com.amap.api.col.p0003l.j2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class MVTTileProvider implements TileProvider {
    private String id;
    private String key;
    private int tileSize = 256;
    private String url;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends j2 {

        /* renamed from: a  reason: collision with root package name */
        String f10738a;

        public a(String str) {
            this.isPostFlag = false;
            this.f10738a = str;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            return this.f10738a;
        }
    }

    public MVTTileProvider(String str, String str2, String str3) {
        this.url = str;
        this.key = str2;
        this.id = str3;
    }

    private byte[] a(int i4, int i5, int i6) {
        try {
            return new a(a(i4, i5, i6, this.tileSize)).makeHttpRequestWithInterrupted();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
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

    private String a(int i4, int i5, int i6, int i7) {
        return String.format(this.url + "?z=%d&x=%d&y=%d&size=%d&key=" + this.key + "&id=" + this.id, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }
}
