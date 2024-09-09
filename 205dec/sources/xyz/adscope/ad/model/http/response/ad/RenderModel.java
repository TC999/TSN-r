package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.model.BaseModel;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RenderModel extends BaseModel {
    @JsonNode(key = "align")
    private String align;
    @JsonNode(key = "bgColor")
    private String bgColor;
    @JsonNode(key = "borderColor")
    private String borderColor;
    @JsonNode(key = "borderRadius")
    private String borderRadius;
    @JsonNode(key = "borderSize")
    private String borderSize;
    @JsonNode(key = "centerX")
    private RenderItemModel centerX;
    @JsonNode(key = "centerY")
    private RenderItemModel centerY;
    @JsonNode(key = "controlType")
    private String controlType;
    @JsonNode(key = "data")
    private String data;
    public IAdView dependenceView;
    @JsonNode(key = "fontSize")
    private int fontSize;
    @JsonNode(key = "fontWeight")
    private String fontWeight;
    @JsonNode(key = "height")
    private RenderItemModel height;
    @JsonNode(key = "heightMode")
    private RenderItemModel heightMode;
    @JsonNode(key = "id")
    private String id;
    private ImageModel imageModel;
    private String imageUrl;
    @JsonNode(key = "layer")
    private int layer;
    @JsonNode(key = "lineCount")
    private int lineCount;
    @JsonNode(key = "lineHeight")
    private String lineHeight;
    @JsonNode(key = "marginBottom")
    private RenderItemModel marginBottom;
    @JsonNode(key = "marginLeft")
    private RenderItemModel marginLeft;
    @JsonNode(key = "marginRight")
    private RenderItemModel marginRight;
    @JsonNode(key = "marginTop")
    private RenderItemModel marginTop;
    @JsonNode(key = "paddingBottom")
    private RenderItemModel paddingBottom;
    @JsonNode(key = "paddingLeft")
    private RenderItemModel paddingLeft;
    @JsonNode(key = "paddingRight")
    private RenderItemModel paddingRight;
    @JsonNode(key = "paddingTop")
    private RenderItemModel paddingTop;
    @JsonNode(key = "referencedObject")
    private String referencedObject;
    @JsonNode(key = "superView")
    private String superView;
    @JsonNode(key = "textAlign")
    private String textAlign;
    @JsonNode(key = "textColor")
    private String textColor;
    private String title;
    private VideoModel videoModel;
    @JsonNode(key = "width")
    private RenderItemModel width;
    @JsonNode(key = "widthMode")
    private RenderItemModel widthMode;

    public String getAlign() {
        return this.align;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String getBorderColor() {
        return this.borderColor;
    }

    public String getBorderRadius() {
        return this.borderRadius;
    }

    public String getBorderSize() {
        return this.borderSize;
    }

    public RenderItemModel getCenterX() {
        return this.centerX;
    }

    public RenderItemModel getCenterY() {
        return this.centerY;
    }

    public String getControlType() {
        return this.controlType;
    }

    public String getData() {
        return this.data;
    }

    public IAdView getDependenceView() {
        return this.dependenceView;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public String getFontWeight() {
        return this.fontWeight;
    }

    public RenderItemModel getHeight() {
        return this.height;
    }

    public RenderItemModel getHeightMode() {
        return this.heightMode;
    }

    public String getId() {
        return this.id;
    }

    public ImageModel getImageModel() {
        return this.imageModel;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getLayer() {
        return this.layer;
    }

    public int getLineCount() {
        return this.lineCount;
    }

    public String getLineHeight() {
        return this.lineHeight;
    }

    public RenderItemModel getMarginBottom() {
        return this.marginBottom;
    }

    public RenderItemModel getMarginLeft() {
        return this.marginLeft;
    }

    public RenderItemModel getMarginRight() {
        return this.marginRight;
    }

    public RenderItemModel getMarginTop() {
        return this.marginTop;
    }

    public RenderItemModel getPaddingBottom() {
        return this.paddingBottom;
    }

    public RenderItemModel getPaddingLeft() {
        return this.paddingLeft;
    }

    public RenderItemModel getPaddingRight() {
        return this.paddingRight;
    }

    public RenderItemModel getPaddingTop() {
        return this.paddingTop;
    }

    public String getReferencedObject() {
        return this.referencedObject;
    }

    public String getSuperView() {
        return this.superView;
    }

    public String getTextAlign() {
        return this.textAlign;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public String getTitle() {
        return this.title;
    }

    public VideoModel getVideoModel() {
        return this.videoModel;
    }

    public RenderItemModel getWidth() {
        return this.width;
    }

    public RenderItemModel getWidthMode() {
        return this.widthMode;
    }

    public void setAlign(String str) {
        this.align = str;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setBorderColor(String str) {
        this.borderColor = str;
    }

    public void setBorderRadius(String str) {
        this.borderRadius = str;
    }

    public void setBorderSize(String str) {
        this.borderSize = str;
    }

    public void setCenterX(RenderItemModel renderItemModel) {
        this.centerX = renderItemModel;
    }

    public void setCenterY(RenderItemModel renderItemModel) {
        this.centerY = renderItemModel;
    }

    public void setControlType(String str) {
        this.controlType = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDependenceView(IAdView iAdView) {
        this.dependenceView = iAdView;
    }

    public void setFontSize(int i4) {
        this.fontSize = i4;
    }

    public void setFontWeight(String str) {
        this.fontWeight = str;
    }

    public void setHeight(RenderItemModel renderItemModel) {
        this.height = renderItemModel;
    }

    public void setHeightMode(RenderItemModel renderItemModel) {
        this.heightMode = renderItemModel;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setLayer(int i4) {
        this.layer = i4;
    }

    public void setLineCount(int i4) {
        this.lineCount = i4;
    }

    public void setLineHeight(String str) {
        this.lineHeight = str;
    }

    public void setMarginBottom(RenderItemModel renderItemModel) {
        this.marginBottom = renderItemModel;
    }

    public void setMarginLeft(RenderItemModel renderItemModel) {
        this.marginLeft = renderItemModel;
    }

    public void setMarginRight(RenderItemModel renderItemModel) {
        this.marginRight = renderItemModel;
    }

    public void setMarginTop(RenderItemModel renderItemModel) {
        this.marginTop = renderItemModel;
    }

    public void setPaddingBottom(RenderItemModel renderItemModel) {
        this.paddingBottom = renderItemModel;
    }

    public void setPaddingLeft(RenderItemModel renderItemModel) {
        this.paddingLeft = renderItemModel;
    }

    public void setPaddingRight(RenderItemModel renderItemModel) {
        this.paddingRight = renderItemModel;
    }

    public void setPaddingTop(RenderItemModel renderItemModel) {
        this.paddingTop = renderItemModel;
    }

    public void setReferencedObject(String str) {
        this.referencedObject = str;
    }

    public void setSuperView(String str) {
        this.superView = str;
    }

    public void setTextAlign(String str) {
        this.textAlign = str;
    }

    public void setTextColor(String str) {
        this.textColor = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideoModel(VideoModel videoModel) {
        this.videoModel = videoModel;
    }

    public void setWidth(RenderItemModel renderItemModel) {
        this.width = renderItemModel;
    }

    public void setWidthMode(RenderItemModel renderItemModel) {
        this.widthMode = renderItemModel;
    }
}
