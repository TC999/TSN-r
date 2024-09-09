package xyz.adscope.ad.advertisings.nativead.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public enum NativeViewItemType {
    ITEM_VIEW_TYPE_LARGE_PIC(1),
    ITEM_VIEW_TYPE_VIDEO(2);
    
    private int type;

    NativeViewItemType(int i4) {
        this.type = i4;
    }

    public int getType() {
        return this.type;
    }
}
