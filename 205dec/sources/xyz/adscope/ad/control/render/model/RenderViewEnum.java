package xyz.adscope.ad.control.render.model;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RenderViewEnum {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum RenderImageViewType {
        IMAGE_VIEW_ICON_TYPE("1"),
        IMAGE_VIEW_MAIN_TYPE("3");
        
        private String imageType;

        RenderImageViewType(String str) {
            this.imageType = str;
        }

        public String getImageType() {
            return this.imageType;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum RenderVideoViewType {
        VIDEO_VIEW_ICON_TYPE("1"),
        VIDEO_VIEW_MAIN_TYPE("3");
        
        private String videoType;

        RenderVideoViewType(String str) {
            this.videoType = str;
        }

        public String getVideoType() {
            return this.videoType;
        }
    }
}
