package xyz.adscope.ad.control.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.adapter.AutoScrollViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.ad.config.model.ConfigResponseInfo;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.control.render.model.RenderViewEnum;
import xyz.adscope.ad.model.BaseModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.RenderItemModel;
import xyz.adscope.ad.model.http.response.ad.RenderModel;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RenderViewUtil {
    private static final String TAG = "RenderViewUtil";
    private static RenderViewUtil mInstance;

    private RenderViewUtil() {
    }

    public static void buildAlignView(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("left".equals(str)) {
            textView.setGravity(3);
        }
        if (AutoScrollViewPager.f4767g.equals(str)) {
            textView.setGravity(17);
        }
        if ("right".equals(str)) {
            textView.setGravity(5);
        }
        if ("top".equals(str)) {
            textView.setGravity(48);
        }
        if ("bottom".equals(str)) {
            textView.setGravity(80);
        }
    }

    public static BaseModel buildNone4Super(BaseModel baseModel) {
        if (baseModel != null) {
            if (baseModel instanceof RenderModel) {
                RenderModel renderModel = (RenderModel) baseModel;
                if (!TextUtils.isEmpty(renderModel.getSuperView()) && renderModel.getSuperView().equalsIgnoreCase("none")) {
                    renderModel.setSuperView("super");
                }
            }
            if (baseModel instanceof InteractionModel) {
                InteractionModel interactionModel = (InteractionModel) baseModel;
                if (!TextUtils.isEmpty(interactionModel.getSuperView()) && interactionModel.getSuperView().equalsIgnoreCase("none")) {
                    interactionModel.setSuperView("super");
                }
            }
        }
        return baseModel;
    }

    public static int buildRadius(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains("%")) {
            return (i4 * ((int) StringUtil.strToFloat(str.substring(0, str.indexOf("%"))))) / 100;
        }
        return Integer.parseInt(str);
    }

    public static void buildSuperReference(RenderItemModel renderItemModel, RenderItemModel renderItemModel2, RenderItemModel renderItemModel3, RenderItemModel renderItemModel4, RenderItemModel renderItemModel5, RenderItemModel renderItemModel6, String str) {
        if (renderItemModel != null && !TextUtils.isEmpty(renderItemModel.getReference()) && !TextUtils.isEmpty(str) && renderItemModel.getReference().equals(str)) {
            renderItemModel.setReference("super");
        }
        if (renderItemModel2 != null && !TextUtils.isEmpty(renderItemModel2.getReference()) && !TextUtils.isEmpty(str) && renderItemModel2.getReference().equals(str)) {
            renderItemModel2.setReference("super");
        }
        if (renderItemModel3 != null && !TextUtils.isEmpty(renderItemModel3.getReference()) && !TextUtils.isEmpty(str) && renderItemModel3.getReference().equals(str)) {
            renderItemModel3.setReference("super");
        }
        if (renderItemModel4 != null && !TextUtils.isEmpty(renderItemModel4.getReference()) && !TextUtils.isEmpty(str) && renderItemModel4.getReference().equals(str)) {
            renderItemModel4.setReference("super");
        }
        if (renderItemModel5 != null && !TextUtils.isEmpty(renderItemModel5.getReference()) && !TextUtils.isEmpty(str) && renderItemModel5.getReference().equals(str)) {
            renderItemModel5.setReference("super");
        }
        if (renderItemModel6 == null || TextUtils.isEmpty(renderItemModel6.getReference()) || TextUtils.isEmpty(str) || !renderItemModel6.getReference().equals(str)) {
            return;
        }
        renderItemModel6.setReference("super");
    }

    private int getEndAutoHeight(Context context, int i4, int[] iArr, int i5, int i6, String str, String str2, RenderModel renderModel, IAdView iAdView, List<IAdView> list) {
        int i7;
        int screenWidth = getScreenWidth(context);
        int screenHeight = getScreenHeight(context);
        int strToInt = StringUtil.strToInt(str);
        int strToInt2 = StringUtil.strToInt(str2);
        int marginValue = getMarginValue(context, screenWidth, renderModel.getMarginRight());
        int marginValue2 = getMarginValue(context, screenWidth, renderModel.getMarginLeft());
        getMarginValue(context, screenWidth, renderModel.getMarginTop());
        getMarginValue(context, screenWidth, renderModel.getMarginBottom());
        int i8 = (iArr[0] - marginValue2) - marginValue;
        int i9 = iArr[1];
        if (i5 != 0 && i5 <= i8) {
            i7 = (((i5 - marginValue) - marginValue2) * strToInt2) / strToInt;
        } else {
            i7 = (i8 * strToInt2) / strToInt;
        }
        int marginValue3 = i4 + i7 + getMarginValue(context, screenHeight, renderModel.getMarginTop()) + getMarginValue(context, screenHeight, renderModel.getMarginBottom());
        List<IAdView> renderModel2 = getRenderModel(iAdView, list);
        if (renderModel2 == null || renderModel2.size() <= 0) {
            return marginValue3;
        }
        Iterator<IAdView> it = renderModel2.iterator();
        int i10 = marginValue3;
        while (it.hasNext()) {
            RenderModel renderModel3 = (RenderModel) ((View) it.next()).getTag();
            i10 = i10 + getMarginValue(context, screenHeight, renderModel3.getMarginBottom()) + getTextWidthAndHeight(context, renderModel3.getWidth(), renderModel3.getHeight(), renderModel3.getWidthMode(), renderModel3.getHeightMode(), renderModel3.getMarginLeft(), renderModel3.getMarginTop(), renderModel3.getMarginRight(), renderModel3.getMarginBottom())[1] + getMarginValue(context, screenHeight, renderModel3.getMarginTop());
        }
        LogUtil.i(TAG, "endAutoHeight : " + i10);
        return i10;
    }

    public static RenderViewUtil getInstance() {
        if (mInstance == null) {
            synchronized (ConfigResponseInfo.class) {
                if (mInstance == null) {
                    mInstance = new RenderViewUtil();
                }
            }
        }
        return mInstance;
    }

    private int getMarginValue(Context context, int i4, RenderItemModel renderItemModel) {
        if (renderItemModel == null || TextUtils.isEmpty(renderItemModel.getSize()) || renderItemModel.getSize().equals("0") || renderItemModel.getSize().equals("0%")) {
            return 0;
        }
        if (renderItemModel.getSize().contains("%")) {
            return (i4 * ((int) StringUtil.strToFloat(renderItemModel.getSize().substring(0, renderItemModel.getSize().indexOf("%"))))) / 100;
        }
        return DeviceInfoUtil.dip2px(context, StringUtil.strToFloat(renderItemModel.getSize()));
    }

    private List<IAdView> getRenderModel(IAdView iAdView, List<IAdView> list) {
        IAdView referenceView;
        IAdView referenceView2;
        RenderModel renderModel = (RenderModel) ((View) iAdView).getTag();
        RenderItemModel marginTop = renderModel.getMarginTop();
        RenderItemModel marginTop2 = renderModel.getMarginTop();
        if (renderModel.getSuperView().equals("none")) {
            return null;
        }
        if (!TextUtils.isEmpty(marginTop.getReference()) || !TextUtils.isEmpty(marginTop2.getReference())) {
            if (!"super".equals(marginTop.getReference()) && !"super".equals(marginTop2.getReference())) {
                if (!"0".equals(marginTop.getSize()) || !"0".equals(marginTop2.getSize())) {
                    if (marginTop.getReferenceView() != null) {
                        referenceView2 = marginTop.getReferenceView();
                    } else if (marginTop2.getReferenceView() == null) {
                        return list;
                    } else {
                        referenceView2 = marginTop2.getReferenceView();
                    }
                    list.add(referenceView2);
                    return getRenderModel(referenceView2, list);
                }
            } else if ("0".equals(marginTop.getSize()) && "0".equals(marginTop2.getSize())) {
                return list;
            } else {
                if (marginTop.getReferenceView() != null) {
                    referenceView = marginTop.getReferenceView();
                } else if (marginTop2.getReferenceView() == null) {
                    return list;
                } else {
                    referenceView = marginTop2.getReferenceView();
                }
                list.add(referenceView);
                return getRenderModel(referenceView, list);
            }
        }
        return list;
    }

    private int getScreenHeight(Context context) {
        return DeviceInfo.getInstance(context).getResolutionHeight();
    }

    private int getScreenWidth(Context context) {
        return DeviceInfo.getInstance(context).getResolutionWidth();
    }

    private int[] getWidthAndHeightById(Context context, List<IAdView> list, String str) {
        Iterator<IAdView> it = list.iterator();
        int[] iArr = null;
        while (it.hasNext()) {
            Object tag = ((View) it.next()).getTag();
            if (tag instanceof RenderModel) {
                RenderModel renderModel = (RenderModel) tag;
                if (renderModel.getId().equals(str)) {
                    iArr = getTextWidthAndHeight(context, renderModel.getWidth(), renderModel.getHeight(), renderModel.getWidthMode(), renderModel.getHeightMode(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom());
                }
            } else {
                InteractionModel interactionModel = (InteractionModel) tag;
                if (interactionModel.getId().equals(str)) {
                    iArr = getTextWidthAndHeight(context, interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.RelativeLayout.LayoutParams buildMarginLayoutParams(android.content.Context r9, android.widget.RelativeLayout.LayoutParams r10, int[] r11, xyz.adscope.ad.model.BaseModel r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof xyz.adscope.ad.model.http.response.ad.InteractionModel
            r1 = 0
            if (r0 == 0) goto L24
            xyz.adscope.ad.model.http.response.ad.InteractionModel r12 = (xyz.adscope.ad.model.http.response.ad.InteractionModel) r12
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r1 = r12.getMarginLeft()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r0 = r12.getMarginRight()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r2 = r12.getMarginBottom()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r3 = r12.getMarginTop()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r4 = r12.getCenterX()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r12 = r12.getCenterY()
        L1f:
            r7 = r0
            r0 = r12
            r12 = r1
            r1 = r7
            goto L48
        L24:
            boolean r0 = r12 instanceof xyz.adscope.ad.model.http.response.ad.RenderModel
            if (r0 == 0) goto L43
            xyz.adscope.ad.model.http.response.ad.RenderModel r12 = (xyz.adscope.ad.model.http.response.ad.RenderModel) r12
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r1 = r12.getMarginLeft()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r0 = r12.getMarginRight()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r2 = r12.getMarginBottom()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r3 = r12.getMarginTop()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r4 = r12.getCenterX()
            xyz.adscope.ad.model.http.response.ad.RenderItemModel r12 = r12.getCenterY()
            goto L1f
        L43:
            r12 = r1
            r0 = r12
            r2 = r0
            r3 = r2
            r4 = r3
        L48:
            int r5 = r8.getScreenWidth(r9)
            int r6 = r8.getScreenHeight(r9)
            if (r1 == 0) goto L58
            int r1 = r8.getMarginValue(r9, r5, r1)
            r10.rightMargin = r1
        L58:
            if (r12 == 0) goto L60
            int r12 = r8.getMarginValue(r9, r5, r12)
            r10.leftMargin = r12
        L60:
            if (r3 == 0) goto L68
            int r12 = r8.getMarginValue(r9, r6, r3)
            r10.topMargin = r12
        L68:
            if (r2 == 0) goto L70
            int r12 = r8.getMarginValue(r9, r6, r2)
            r10.bottomMargin = r12
        L70:
            if (r0 == 0) goto L81
            int r12 = r8.getMarginValue(r9, r6, r0)
            int r6 = r6 / 2
            r0 = 1
            r0 = r11[r0]
            int r0 = r0 / 2
            int r6 = r6 - r0
            int r12 = r12 + r6
            r10.topMargin = r12
        L81:
            if (r4 == 0) goto L92
            int r9 = r8.getMarginValue(r9, r5, r4)
            int r5 = r5 / 2
            r12 = 0
            r11 = r11[r12]
            int r11 = r11 / 2
            int r5 = r5 - r11
            int r9 = r9 + r5
            r10.leftMargin = r9
        L92:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.util.RenderViewUtil.buildMarginLayoutParams(android.content.Context, android.widget.RelativeLayout$LayoutParams, int[], xyz.adscope.ad.model.BaseModel):android.widget.RelativeLayout$LayoutParams");
    }

    public RelativeLayout.LayoutParams buildRuleParams(RelativeLayout.LayoutParams layoutParams, RenderItemModel renderItemModel, RenderItemModel renderItemModel2, RenderItemModel renderItemModel3, RenderItemModel renderItemModel4, RenderItemModel renderItemModel5, RenderItemModel renderItemModel6, String str) {
        buildSuperReference(renderItemModel, renderItemModel2, renderItemModel3, renderItemModel4, renderItemModel5, renderItemModel6, str);
        if (renderItemModel != null && "super".equals(renderItemModel.getReference()) && "centerX".equals(renderItemModel.getLayout()) && ("0".equals(renderItemModel.getSize()) || "0%".equals(renderItemModel.getSize()))) {
            layoutParams.addRule(14, -1);
        }
        if (renderItemModel2 != null && "super".equals(renderItemModel2.getReference()) && "centerY".equals(renderItemModel2.getLayout()) && ("0".equals(renderItemModel2.getSize()) || "0%".equals(renderItemModel2.getSize()))) {
            layoutParams.addRule(15, -1);
        }
        if (renderItemModel5 != null && "super".equals(renderItemModel5.getReference()) && "right".equals(renderItemModel5.getLayout())) {
            layoutParams.addRule(21, -1);
        }
        if (renderItemModel4 != null && "super".equals(renderItemModel4.getReference()) && "top".equals(renderItemModel4.getLayout())) {
            layoutParams.addRule(10, -1);
        }
        if (renderItemModel3 != null && "super".equals(renderItemModel3.getReference()) && "left".equals(renderItemModel3.getLayout())) {
            layoutParams.addRule(20, -1);
        }
        if (renderItemModel6 != null && "super".equals(renderItemModel6.getReference()) && "bottom".equals(renderItemModel6.getLayout())) {
            layoutParams.addRule(12, -1);
        }
        return layoutParams;
    }

    public RelativeLayout.LayoutParams buildRuleToOtherViewParams(RelativeLayout.LayoutParams layoutParams, RenderItemModel renderItemModel, RenderItemModel renderItemModel2, RenderItemModel renderItemModel3, RenderItemModel renderItemModel4) {
        if (renderItemModel3 != null && !"super".equals(renderItemModel3.getReference()) && renderItemModel3.getReferenceView() != null) {
            if ("left".equals(renderItemModel3.getLayout())) {
                layoutParams.addRule(0, ((View) renderItemModel3.getReferenceView()).getId());
            } else if ("right".equals(renderItemModel3.getLayout())) {
                layoutParams.addRule(19, ((View) renderItemModel3.getReferenceView()).getId());
            }
        }
        if (renderItemModel2 != null && !"super".equals(renderItemModel2.getReference()) && renderItemModel2.getReferenceView() != null) {
            if ("bottom".equals(renderItemModel2.getLayout())) {
                layoutParams.addRule(3, ((View) renderItemModel2.getReferenceView()).getId());
            } else if ("top".equals(renderItemModel2.getLayout())) {
                layoutParams.addRule(6, ((View) renderItemModel2.getReferenceView()).getId());
            }
        }
        if (renderItemModel != null && !"super".equals(renderItemModel.getReference()) && renderItemModel.getReferenceView() != null) {
            if ("right".equals(renderItemModel.getLayout())) {
                layoutParams.addRule(1, ((View) renderItemModel.getReferenceView()).getId());
            } else if ("left".equals(renderItemModel.getLayout())) {
                layoutParams.addRule(18, ((View) renderItemModel.getReferenceView()).getId());
            }
        }
        if (renderItemModel4 != null && !"super".equals(renderItemModel4.getReference()) && renderItemModel4.getReferenceView() != null) {
            if ("top".equals(renderItemModel4.getLayout())) {
                layoutParams.addRule(2, ((View) renderItemModel4.getReferenceView()).getId());
            } else if ("bottom".equals(renderItemModel4.getLayout())) {
                layoutParams.addRule(8, ((View) renderItemModel4.getReferenceView()).getId());
            }
        }
        return layoutParams;
    }

    public int getAutoHeight(Context context, List<IAdView> list, int i4, int i5) {
        int i6 = 0;
        if (list != null && list.size() >= 1) {
            ArrayList arrayList = new ArrayList();
            for (IAdView iAdView : list) {
                RenderModel renderModel = (RenderModel) ((View) iAdView).getTag();
                int[] textWidthAndHeight = getTextWidthAndHeight(context, list, renderModel.getWidth(), renderModel.getHeight(), renderModel.getWidthMode(), renderModel.getHeightMode(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom());
                if (renderModel.getImageModel() != null && RenderViewEnum.RenderImageViewType.IMAGE_VIEW_MAIN_TYPE.getImageType().equals(renderModel.getImageModel().getType())) {
                    i6 = getEndAutoHeight(context, i6, textWidthAndHeight, i4, i5, renderModel.getImageModel().getW(), renderModel.getImageModel().getH(), renderModel, iAdView, arrayList);
                } else if (renderModel.getVideoModel() != null) {
                    String videoType = RenderViewEnum.RenderVideoViewType.VIDEO_VIEW_MAIN_TYPE.getVideoType();
                    if (videoType.equals(renderModel.getVideoModel().getType() + "")) {
                        i6 = getEndAutoHeight(context, i6, textWidthAndHeight, i4, i5, renderModel.getVideoModel().getW(), renderModel.getVideoModel().getH(), renderModel, iAdView, arrayList);
                    }
                }
            }
        }
        return i6;
    }

    public int[] getTextWidthAndHeight(Context context, RenderItemModel renderItemModel, RenderItemModel renderItemModel2, RenderItemModel renderItemModel3, RenderItemModel renderItemModel4, RenderItemModel renderItemModel5, RenderItemModel renderItemModel6, RenderItemModel renderItemModel7, RenderItemModel renderItemModel8) {
        return getTextWidthAndHeight(context, null, renderItemModel, renderItemModel2, renderItemModel3, renderItemModel4, renderItemModel5, renderItemModel6, renderItemModel7, renderItemModel8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0100, code lost:
        if ("auto".equals(r22.getSize()) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019e, code lost:
        if ("auto".equals(r22.getSize()) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] getTextWidthAndHeight(android.content.Context r17, java.util.List<xyz.adscope.ad.control.render.inter.IAdView> r18, xyz.adscope.ad.model.http.response.ad.RenderItemModel r19, xyz.adscope.ad.model.http.response.ad.RenderItemModel r20, xyz.adscope.ad.model.http.response.ad.RenderItemModel r21, xyz.adscope.ad.model.http.response.ad.RenderItemModel r22, xyz.adscope.ad.model.http.response.ad.RenderItemModel r23, xyz.adscope.ad.model.http.response.ad.RenderItemModel r24, xyz.adscope.ad.model.http.response.ad.RenderItemModel r25, xyz.adscope.ad.model.http.response.ad.RenderItemModel r26) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.util.RenderViewUtil.getTextWidthAndHeight(android.content.Context, java.util.List, xyz.adscope.ad.model.http.response.ad.RenderItemModel, xyz.adscope.ad.model.http.response.ad.RenderItemModel, xyz.adscope.ad.model.http.response.ad.RenderItemModel, xyz.adscope.ad.model.http.response.ad.RenderItemModel, xyz.adscope.ad.model.http.response.ad.RenderItemModel, xyz.adscope.ad.model.http.response.ad.RenderItemModel, xyz.adscope.ad.model.http.response.ad.RenderItemModel, xyz.adscope.ad.model.http.response.ad.RenderItemModel):int[]");
    }
}
