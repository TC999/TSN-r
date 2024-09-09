package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class TileOverlayOptions extends BaseOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private TileProvider _tileProvider;
    @JBindingInclude
    private String diskCacheDir;
    @JBindingInclude
    private boolean diskCacheEnabled;
    @JBindingInclude
    private long diskCacheSize;
    @JBindingInclude
    private TileProviderInner mTileProvider;
    private final int mVersionCode;
    @JBindingInclude
    private boolean mVisible;
    @JBindingInclude
    private float mZIndex;
    @JBindingInclude
    private int memCacheSize;
    @JBindingInclude
    private boolean memoryCacheEnabled;

    public TileOverlayOptions() {
        this.mVisible = true;
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = 1;
        this.type = "TileOverlayOptions";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final TileOverlayOptions diskCacheDir(String str) {
        this.diskCacheDir = str;
        return this;
    }

    public final TileOverlayOptions diskCacheEnabled(boolean z3) {
        this.diskCacheEnabled = z3;
        return this;
    }

    public final TileOverlayOptions diskCacheSize(int i4) {
        this.diskCacheSize = i4 * 1024;
        return this;
    }

    public final String getDiskCacheDir() {
        return this.diskCacheDir;
    }

    public final boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public final long getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public final int getMemCacheSize() {
        return this.memCacheSize;
    }

    public final boolean getMemoryCacheEnabled() {
        return this.memoryCacheEnabled;
    }

    public final TileProvider getTileProvider() {
        return this._tileProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TileProviderInner getTileProviderInner() {
        return this.mTileProvider;
    }

    public final float getZIndex() {
        return this.mZIndex;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public final TileOverlayOptions memCacheSize(int i4) {
        this.memCacheSize = i4;
        return this;
    }

    public final TileOverlayOptions memoryCacheEnabled(boolean z3) {
        this.memoryCacheEnabled = z3;
        return this;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this._tileProvider = tileProvider;
        this.mTileProvider = new TileProviderInner(tileProvider);
        return this;
    }

    public final TileOverlayOptions visible(boolean z3) {
        this.mVisible = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeValue(this.mTileProvider);
        parcel.writeByte(this.mVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.mZIndex);
        parcel.writeInt(this.memCacheSize);
        parcel.writeLong(this.diskCacheSize);
        parcel.writeString(this.diskCacheDir);
        parcel.writeByte(this.memoryCacheEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.diskCacheEnabled ? (byte) 1 : (byte) 0);
    }

    public final TileOverlayOptions zIndex(float f4) {
        this.mZIndex = f4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(int i4, boolean z3, float f4) {
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = i4;
        this.mVisible = z3;
        this.mZIndex = f4;
        this.type = "TileOverlayOptions";
    }
}
