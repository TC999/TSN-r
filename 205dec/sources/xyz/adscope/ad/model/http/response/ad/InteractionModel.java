package xyz.adscope.ad.model.http.response.ad;

import java.util.List;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.model.BaseModel;
import xyz.adscope.common.json.inter.JsonNode;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InteractionModel extends BaseModel {
    @JsonNode(key = "align")
    private String align;
    @JsonNode(key = "animationType")
    private int animationType;
    @JsonNode(key = "autoClose")
    private String autoClose = "1";
    @JsonNode(key = "bgColor")
    private String bgColor;
    @JsonNode(key = "bindEvent")
    private String bindEvent;
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
    @JsonNode(key = "coolTime")
    private long coolTime;
    @JsonNode(key = "countDownTime")
    private int countDownTime;
    @JsonNode(key = "data")
    private String data;
    private IAdView dependenceView;
    @JsonNode(key = "eulerAngle")
    private EulerAngleModel eulerAngle;
    @JsonNode(key = "execution")
    private String execution;
    @JsonNode(key = "feedbackAnimation")
    private int feedbackAnimation;
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
    @JsonNode(key = "imageUrl")
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
    @JsonNode(key = "passivationTime")
    private long passivationTime;
    @JsonNode(key = "passivationType")
    private int passivationType;
    @JsonNode(key = "privacyUrl")
    private String privacyUrl;
    @JsonNode(key = "protectTime")
    private long protectTime;
    @JsonNode(key = "referencedObject")
    private String referencedObject;
    @JsonNode(key = "shake")
    private ShakeModel shake;
    @JsonNode(key = "slideDirection")
    private String slideDirection;
    @JsonNode(key = "slideDistance")
    private List<Integer> slideDistance;
    @JsonNode(key = "superView")
    private String superView;
    @JsonNode(key = "textAlign")
    private String textAlign;
    @JsonNode(key = "textColor")
    private String textColor;
    @JsonNode(key = "title")
    private String title;
    @JsonNode(key = "width")
    private RenderItemModel width;
    @JsonNode(key = "widthMode")
    private RenderItemModel widthMode;

    public String getAlign() {
        return this.align;
    }

    public int getAnimationType() {
        return this.animationType;
    }

    public String getAutoClose() {
        return this.autoClose;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String getBindEvent() {
        return this.bindEvent;
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

    public long getCoolTime() {
        return this.coolTime;
    }

    public int getCountDownTime() {
        return this.countDownTime;
    }

    public String getData() {
        return this.data;
    }

    public IAdView getDependenceView() {
        return this.dependenceView;
    }

    public EulerAngleModel getEulerAngle() {
        return this.eulerAngle;
    }

    public String getExecution() {
        return this.execution;
    }

    public int getFeedbackAnimation() {
        return this.feedbackAnimation;
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

    public long getPassivationTime() {
        return this.passivationTime;
    }

    public int getPassivationType() {
        return this.passivationType;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public long getProtectTime() {
        return this.protectTime;
    }

    public String getReferencedObject() {
        return this.referencedObject;
    }

    public ShakeModel getShake() {
        return this.shake;
    }

    public String getSlideDirection() {
        return this.slideDirection;
    }

    public List<Integer> getSlideDistance() {
        return this.slideDistance;
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

    public RenderItemModel getWidth() {
        return this.width;
    }

    public RenderItemModel getWidthMode() {
        return this.widthMode;
    }

    public int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e4) {
            String str2 = Constants.TAG;
            LogUtil.e(str2, "e : " + e4);
            return 0;
        }
    }

    public void setAlign(String str) {
        this.align = str;
    }

    public void setAnimationType(int i4) {
        this.animationType = i4;
    }

    public void setAutoClose(String str) {
        this.autoClose = str;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setBindEvent(String str) {
        this.bindEvent = str;
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

    public void setCoolTime(long j4) {
        this.coolTime = j4;
    }

    public void setCountDownTime(int i4) {
        this.countDownTime = i4;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDependenceView(IAdView iAdView) {
        this.dependenceView = iAdView;
    }

    public void setEulerAngle(EulerAngleModel eulerAngleModel) {
        this.eulerAngle = eulerAngleModel;
    }

    public void setExecution(String str) {
        this.execution = str;
    }

    public void setFeedbackAnimation(int i4) {
        this.feedbackAnimation = i4;
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

    public void setPassivationTime(long j4) {
        this.passivationTime = j4;
    }

    public void setPassivationType(int i4) {
        this.passivationType = i4;
    }

    public void setPrivacyUrl(String str) {
        this.privacyUrl = str;
    }

    public void setProtectTime(long j4) {
        this.protectTime = j4;
    }

    public void setReferencedObject(String str) {
        this.referencedObject = str;
    }

    public void setShake(ShakeModel shakeModel) {
        this.shake = shakeModel;
    }

    public void setSlideDirection(String str) {
        this.slideDirection = str;
    }

    public void setSlideDistance(List<Integer> list) {
        this.slideDistance = list;
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

    public void setWidth(RenderItemModel renderItemModel) {
        this.width = renderItemModel;
    }

    public void setWidthMode(RenderItemModel renderItemModel) {
        this.widthMode = renderItemModel;
    }
}
