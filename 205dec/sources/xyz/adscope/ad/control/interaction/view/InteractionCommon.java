package xyz.adscope.ad.control.interaction.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import xyz.adscope.ad.R;
import xyz.adscope.ad.control.action.ActionDeepLink;
import xyz.adscope.ad.control.action.ActionDownload;
import xyz.adscope.ad.control.action.inter.IAction;
import xyz.adscope.ad.control.interaction.InteractionClick;
import xyz.adscope.ad.control.interaction.InteractionComplaint;
import xyz.adscope.ad.control.interaction.InteractionEulerAngle;
import xyz.adscope.ad.control.interaction.InteractionGestures;
import xyz.adscope.ad.control.interaction.InteractionShake;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.tool.monitor.AdScopeADNScreenTool;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InteractionCommon {
    public static final String CLOSE_TYPE_EXECUTION = "close";
    public static final String COMPLAIN_TYPE_EXECUTION = "complain";
    public static final String DISLIKE_TYPE_EXECUTION = "dislike";
    private static final String TAG = "InteractionCommon";
    private IAction action;
    private WeakReference<Context> finalContext;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionClick interactionClick;
    private InteractionEulerAngle interactionEulerAngle;
    private InteractionGestures interactionGestures;
    private InteractionShake interactionShake;
    private WeakReference<View> targetViewWR;
    private boolean needListenTouchEvent = false;
    private boolean isRegister = true;
    private String apiKey = null;
    private String adType = null;

    public InteractionCommon(View view) {
        this.targetViewWR = new WeakReference<>(view);
    }

    private void checkTargetView(final View view) {
        view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: xyz.adscope.ad.control.interaction.view.InteractionCommon.2
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z3) {
                LogUtil.i(InteractionCommon.TAG, "checkView_asnp hasFocus : " + z3 + " , isRegister : " + InteractionCommon.this.isRegister);
                if (AdScopeADNScreenTool.isVisible(view, 100)) {
                    if (InteractionCommon.this.isRegister) {
                        return;
                    }
                    InteractionCommon.this.isRegister = true;
                    InteractionCommon.this.onResume();
                } else if (InteractionCommon.this.isRegister) {
                    InteractionCommon.this.isRegister = false;
                    InteractionCommon.this.onPause();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAction(Context context, NativeModel nativeModel, InteractionModel interactionModel, IInteractionExecute iInteractionExecute, IAction iAction, AdScopeCycleModel adScopeCycleModel) {
        if (interactionModel != null) {
            try {
                if (TextUtils.isEmpty(interactionModel.getExecution())) {
                    return;
                }
                String execution = interactionModel.getExecution();
                if (execution.equals("close")) {
                    if (iInteractionExecute != null) {
                        iInteractionExecute.customClose();
                    }
                } else if (execution.equals(DISLIKE_TYPE_EXECUTION)) {
                    if (iInteractionExecute != null) {
                        iInteractionExecute.customDislike();
                    }
                } else if (execution.equals(COMPLAIN_TYPE_EXECUTION)) {
                    new InteractionComplaint().showComplainDialog(this.targetViewWR.get(), adScopeCycleModel, iInteractionExecute);
                } else {
                    if (iInteractionExecute != null) {
                        iInteractionExecute.customClick();
                    }
                    iAction.execute(context, nativeModel);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initInteraction$0(InteractionModel interactionModel, NativeModel nativeModel, IInteractionExecute iInteractionExecute, AdScopeCycleModel adScopeCycleModel, String str) {
        if (this.finalContext.get() != null) {
            if (str.equals(interactionModel.getSlideDirection())) {
                executeAction(this.finalContext.get(), nativeModel, interactionModel, iInteractionExecute, this.action, adScopeCycleModel);
            } else {
                Toast.makeText(this.finalContext.get(), this.finalContext.get().getString(R.string.adscope_wrong_sliding_direction), 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initInteraction$1(View view, NativeModel nativeModel, InteractionModel interactionModel, IInteractionExecute iInteractionExecute, AdScopeCycleModel adScopeCycleModel) {
        if (!AdScopeADNScreenTool.isVisible(((IInteractionView) view).getTotalAdView(), 60) || this.finalContext.get() == null) {
            return;
        }
        executeAction(this.finalContext.get(), nativeModel, interactionModel, iInteractionExecute, this.action, adScopeCycleModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initInteraction$2(NativeModel nativeModel, InteractionModel interactionModel, IInteractionExecute iInteractionExecute, AdScopeCycleModel adScopeCycleModel) {
        if (this.finalContext.get() != null) {
            executeAction(this.finalContext.get(), nativeModel, interactionModel, iInteractionExecute, this.action, adScopeCycleModel);
        }
    }

    public void destroy() {
        try {
            InteractionShake interactionShake = this.interactionShake;
            if (interactionShake != null) {
                interactionShake.onDestroy();
            }
            InteractionEulerAngle interactionEulerAngle = this.interactionEulerAngle;
            if (interactionEulerAngle != null) {
                interactionEulerAngle.onDestroy();
            }
            this.interactionShake = null;
            this.interactionEulerAngle = null;
            WeakReference<Context> weakReference = this.finalContext;
            if (weakReference != null) {
                weakReference.clear();
                this.finalContext = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public IBaseInteraction initInteraction(final IInteractionExecute iInteractionExecute, final InteractionModel interactionModel, final NativeModel nativeModel, final AdScopeCycleModel adScopeCycleModel) {
        int i4;
        int i5;
        if (nativeModel != null) {
            try {
                if (nativeModel.getLink() != null) {
                    if (nativeModel.getLink().getStyle() == IInteractionView.INTERACTION_ACTION_CODE.INTERACTION_CODE_DEEPLINK.getCode()) {
                        this.action = new ActionDeepLink();
                    } else if (nativeModel.getLink().getStyle() == IInteractionView.INTERACTION_ACTION_CODE.INTERACTION_CODE_DOWNLOAD.getCode()) {
                        this.action = new ActionDownload();
                    }
                    this.action.setITrackEventStatus(this.iTrackEventStatus);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        try {
            this.apiKey = adScopeCycleModel.getApiKey();
            this.adType = adScopeCycleModel.getSpaceType();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        final View view = this.targetViewWR.get();
        this.finalContext = SystemUtil.findActivityContext(((IInteractionView) view).getTotalAdView());
        if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_GESTURE.getValue().equals(interactionModel.getBindEvent())) {
            this.needListenTouchEvent = true;
            if (interactionModel.getSlideDistance() != null) {
                int intValue = interactionModel.getSlideDistance().get(0).intValue();
                i5 = interactionModel.getSlideDistance().get(1).intValue();
                i4 = intValue;
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (view != null) {
                InteractionGestures create = InteractionGestures.create(view, new InteractionGestures.CallBack() { // from class: xyz.adscope.ad.control.interaction.view.k
                    @Override // xyz.adscope.ad.control.interaction.InteractionGestures.CallBack
                    public final void onListener(String str) {
                        InteractionCommon.this.lambda$initInteraction$0(interactionModel, nativeModel, iInteractionExecute, adScopeCycleModel, str);
                    }
                }, adScopeCycleModel);
                this.interactionGestures = create;
                create.setPassivationType(interactionModel.getPassivationType());
                if (!TextUtils.isEmpty(interactionModel.getSlideDirection())) {
                    this.interactionGestures.setSlideDirection(interactionModel.getSlideDirection());
                }
                this.interactionGestures.startTouchEventListen(i4, i5, (int) interactionModel.getPassivationTime());
            }
            return this.interactionGestures;
        } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_SHARK.getValue().equals(interactionModel.getBindEvent())) {
            if (view != null) {
                checkTargetView(((IInteractionView) view).getSelfView());
                this.interactionShake = new InteractionShake(view, this.apiKey, this.adType, interactionModel, new InteractionShake.InteractionShakeListener() { // from class: xyz.adscope.ad.control.interaction.view.l
                    @Override // xyz.adscope.ad.control.interaction.InteractionShake.InteractionShakeListener
                    public final void onClick() {
                        InteractionCommon.this.lambda$initInteraction$1(view, nativeModel, interactionModel, iInteractionExecute, adScopeCycleModel);
                    }
                });
            }
            return this.interactionShake;
        } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_CLICK.getValue().equals(interactionModel.getBindEvent())) {
            InteractionClick interactionClick = new InteractionClick(new InteractionClick.ClickCallbackInterface() { // from class: xyz.adscope.ad.control.interaction.view.j
                @Override // xyz.adscope.ad.control.interaction.InteractionClick.ClickCallbackInterface
                public final void clickCallback() {
                    InteractionCommon.this.lambda$initInteraction$2(nativeModel, interactionModel, iInteractionExecute, adScopeCycleModel);
                }
            });
            this.interactionClick = interactionClick;
            return interactionClick;
        } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_EULERANGLE.getValue().equals(interactionModel.getBindEvent())) {
            if (view != null) {
                checkTargetView(((IInteractionView) view).getSelfView());
                this.interactionEulerAngle = new InteractionEulerAngle(view, this.apiKey, this.adType, interactionModel, new InteractionEulerAngle.InteractionEulerAngleListener() { // from class: xyz.adscope.ad.control.interaction.view.InteractionCommon.1
                    @Override // xyz.adscope.ad.control.interaction.InteractionEulerAngle.InteractionEulerAngleListener
                    public void onClick() {
                        if (!AdScopeADNScreenTool.isVisible(((IInteractionView) view).getTotalAdView(), 60) || InteractionCommon.this.finalContext.get() == null) {
                            return;
                        }
                        InteractionCommon interactionCommon = InteractionCommon.this;
                        interactionCommon.executeAction((Context) interactionCommon.finalContext.get(), nativeModel, interactionModel, iInteractionExecute, InteractionCommon.this.action, adScopeCycleModel);
                    }
                });
            }
            return this.interactionEulerAngle;
        } else {
            return null;
        }
    }

    public void onPause() {
        try {
            InteractionShake interactionShake = this.interactionShake;
            if (interactionShake != null) {
                interactionShake.onPause();
            }
            InteractionEulerAngle interactionEulerAngle = this.interactionEulerAngle;
            if (interactionEulerAngle != null) {
                interactionEulerAngle.onPause();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void onResume() {
        try {
            InteractionShake interactionShake = this.interactionShake;
            if (interactionShake != null) {
                interactionShake.onResume();
            }
            InteractionEulerAngle interactionEulerAngle = this.interactionEulerAngle;
            if (interactionEulerAngle != null) {
                interactionEulerAngle.onResume();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InteractionGestures interactionGestures;
        try {
            if (!this.needListenTouchEvent || (interactionGestures = this.interactionGestures) == null) {
                return false;
            }
            return interactionGestures.onTouchEvent(motionEvent);
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
        this.iTrackEventStatus = iTrackEventStatus;
    }
}
