package com.amap.api.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class UrlTileProvider implements TileProvider {
    private final int height;
    private final int width;

    public UrlTileProvider(int i4, int i5) {
        this.width = i4;
        this.height = i5;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i4, int i5, int i6) {
        URL tileUrl = getTileUrl(i4, i5, i6);
        if (tileUrl == null) {
            return TileProvider.NO_TILE;
        }
        try {
            return Tile.obtain(this.width, this.height, a(tileUrl.openStream()));
        } catch (IOException e4) {
            Tile tile = TileProvider.NO_TILE;
            e4.printStackTrace();
            return tile;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.height;
    }

    public abstract URL getTileUrl(int i4, int i5, int i6);

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.width;
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j4 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j4;
            }
            outputStream.write(bArr, 0, read);
            j4 += read;
        }
    }
}
