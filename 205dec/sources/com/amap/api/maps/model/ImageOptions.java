package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ImageOptions {
    @JBindingInclude
    public int color;
    @JBindingInclude
    public String content;
    @JBindingInclude
    public int fontSize;
    @JBindingInclude
    public float radius;
    @JBindingInclude
    public double[] rgba;
    @JBindingInclude
    public int type;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum ShapeType {
        DEFAULT(0),
        CIRCLE(1),
        TEXT(2);
        
        private int index;

        ShapeType(int i4) {
            this.index = i4;
        }

        public final int value() {
            return this.index;
        }
    }
}
