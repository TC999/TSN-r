package com.amap.api.maps.model;

import android.util.Pair;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GL3DModelOptions extends BaseOptions {
    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;
    @JBindingInclude
    private LatLng latLng;
    @JBindingInclude
    private String modelData;
    @JBindingInclude
    private float rotate;
    @JBindingInclude
    private String snippet;
    @JBindingInclude
    private String title;
    private List<Float> vertextList = new ArrayList();
    private List<Float> textrueList = new ArrayList();
    @JBindingInclude
    private boolean isModeltUpdate = false;
    @JBindingInclude
    private int fixedLength = 50;
    @JBindingInclude
    private double altitude = 0.0d;
    @JBindingInclude
    private boolean fixedDisplaySizeEnabled = true;
    @JBindingInclude
    private double fixedDisplaySizeX = -1.0d;
    @JBindingInclude
    private double fixedDisplaySizeY = -1.0d;
    @JBindingInclude
    private boolean visibile = true;
    @JBindingInclude
    private int zIndex = 0;

    public GL3DModelOptions() {
        this.type = "GL3DModelOptions";
    }

    public GL3DModelOptions angle(float f4) {
        this.rotate = f4;
        return this;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getAngle() {
        return this.rotate;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public Pair<Double, Double> getFixDisplaySize() {
        return Pair.create(Double.valueOf(this.fixedDisplaySizeX), Double.valueOf(this.fixedDisplaySizeY));
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public List<Float> getTextrue() {
        return this.textrueList;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Float> getVertext() {
        return this.vertextList;
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public boolean isFixedDisplaySizeEnabled() {
        return this.fixedDisplaySizeEnabled;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public GL3DModelOptions position(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public GL3DModelOptions setAltitude(double d4) {
        this.altitude = d4;
        return this;
    }

    public GL3DModelOptions setFixDisplaySize(double d4, double d5) {
        this.fixedDisplaySizeX = d4;
        this.fixedDisplaySizeY = d5;
        return this;
    }

    public GL3DModelOptions setFixedDisplaySizeEnabled(boolean z3) {
        this.fixedDisplaySizeEnabled = z3;
        return this;
    }

    public GL3DModelOptions setModelFixedLength(int i4) {
        this.fixedLength = i4;
        return this;
    }

    public GL3DModelOptions setVisible(boolean z3) {
        this.visibile = z3;
        return this;
    }

    public GL3DModelOptions setzIndex(int i4) {
        this.zIndex = i4;
        return this;
    }

    public GL3DModelOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public GL3DModelOptions textureDrawable(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public GL3DModelOptions title(String str) {
        this.title = str;
        return this;
    }

    public GL3DModelOptions vertexData(String str) {
        if (str != null && str.length() > 0) {
            this.modelData = str;
            this.isModeltUpdate = true;
        }
        return this;
    }

    public GL3DModelOptions vertexData(List<Float> list, List<Float> list2) {
        this.vertextList = list;
        this.textrueList = list2;
        StringBuilder sb = new StringBuilder();
        if (this.vertextList != null) {
            for (int i4 = 0; i4 < this.vertextList.size() - 3; i4 += 3) {
                sb.append("v ");
                sb.append(this.vertextList.get(i4));
                sb.append(" ");
                sb.append(this.vertextList.get(i4 + 1));
                sb.append(" ");
                sb.append(this.vertextList.get(i4 + 2));
                sb.append("\n");
            }
        }
        if (this.textrueList != null) {
            for (int i5 = 0; i5 < this.textrueList.size() - 2; i5 += 2) {
                sb.append("vt ");
                sb.append(this.textrueList.get(i5));
                sb.append(" ");
                sb.append(1.0f - this.textrueList.get(i5 + 1).floatValue());
                sb.append("\n");
            }
        }
        vertexData(sb.toString());
        return this;
    }
}
