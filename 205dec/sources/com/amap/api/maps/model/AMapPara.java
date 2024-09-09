package com.amap.api.maps.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapPara {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_DEFAULT = -1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);
        
        private int type;

        LineCapType(int i4) {
            this.type = i4;
        }

        public final int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int i4) {
            LineCapType[] values = values();
            return values[Math.max(0, Math.min(i4, values.length))];
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);
        
        private int type;

        LineJoinType(int i4) {
            this.type = i4;
        }

        public final int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int i4) {
            LineJoinType[] values = values();
            return values[Math.max(0, Math.min(i4, values.length))];
        }
    }
}
