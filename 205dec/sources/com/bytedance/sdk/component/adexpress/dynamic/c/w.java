package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicClose;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislike;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislikeFeedBack;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLeisureWidget;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLogoAd;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLogoUnion;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLottie;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicMutedView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicPrivacyView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRoot;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDown;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDownBtn;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDownContainer;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSplitLineView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicStarView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuter;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterContainerWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterRewardFullSkip;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterSkip;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicUnKnowView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVideoView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.utils.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static DynamicBaseWidget c(Context context, DynamicRootView dynamicRootView, ev evVar) {
        bk renderRequest;
        if (context == null || dynamicRootView == null || evVar == null || evVar.p() == null) {
            return null;
        }
        switch (evVar.p().c()) {
            case -1:
                return new DynamicUnKnowView(context, dynamicRootView, evVar);
            case 0:
                return new DynamicTextView(context, dynamicRootView, evVar);
            case 1:
                return new DynamicImageView(context, dynamicRootView, evVar);
            case 2:
                return new DynamicButton(context, dynamicRootView, evVar);
            case 3:
                return new DynamicDislike(context, dynamicRootView, evVar);
            case 4:
                return new DynamicLogoAd(context, dynamicRootView, evVar);
            case 5:
                return new DynamicLogoUnion(context, dynamicRootView, evVar);
            case 6:
            case 9:
            case 17:
                return new DynamicBaseWidgetImp(context, dynamicRootView, evVar);
            case 7:
                return new DynamicVideoView(context, dynamicRootView, evVar);
            case 8:
                return new DynamicRoot(context, dynamicRootView, evVar);
            case 10:
                return new DynamicMutedView(context, dynamicRootView, evVar);
            case 11:
                return new DynamicStarView(context, dynamicRootView, evVar);
            case 12:
                return new DynamicDislikeFeedBack(context, dynamicRootView, evVar);
            case 13:
                return new DynamicTimeOuter(context, dynamicRootView, evVar);
            case 14:
                return new DynamicTimeOuterContainerWidgetImp(context, dynamicRootView, evVar);
            case 15:
                if (sr.c()) {
                    return new DynamicTimeOuterRewardFullSkip(context, dynamicRootView, evVar);
                }
                return new DynamicTimeOuterSkip(context, dynamicRootView, evVar);
            case 16:
                return new DynamicImageView(context, dynamicRootView, evVar);
            case 18:
                return new DynamicSplitLineView(context, dynamicRootView, evVar);
            case 19:
                return new DynamicSkipCountDownContainer(context, dynamicRootView, evVar);
            case 20:
                return new DynamicSkipCountDown(context, dynamicRootView, evVar);
            case 21:
                return new DynamicSkipCountDownBtn(context, dynamicRootView, evVar);
            case 22:
                return new DynamicClose(context, dynamicRootView, evVar);
            case 23:
                return new DynamicPrivacyView(context, dynamicRootView, evVar);
            case 24:
                return new DynamicBaseScrollWidgetImp(context, dynamicRootView, evVar);
            case 25:
                return new DynamicLeisureWidget(context, dynamicRootView, evVar);
            case 26:
                if ("vertical".equals(evVar.p().sr().tl())) {
                    return new DynamicVerticalScrollWidgetImp(context, dynamicRootView, evVar);
                }
                return new DynamicBaseInternalScrollWidgetImp(context, dynamicRootView, evVar);
            case 27:
                return new DynamicTimeOuterSkip(context, dynamicRootView, evVar);
            case 28:
                if (!sr.c() || (renderRequest = dynamicRootView.getRenderRequest()) == null) {
                    return null;
                }
                a.w("DynamicViewFactory", "type is lottie");
                return new DynamicLottie(context, dynamicRootView, evVar, renderRequest.q());
            default:
                return null;
        }
    }
}
