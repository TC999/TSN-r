package xyz.adscope.ad.control.interaction.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.render.model.AdScopeRenderCustomTrackerModel;
import xyz.adscope.ad.control.render.widget.CustomRoundImageView;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdCustomImageView extends CustomRoundImageView {
    private AdScopeCycleModel adScopeCycleModel;

    public AdCustomImageView(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adScopeCycleModel != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setDownTS(DeviceInfo.getInstance(getContext()).getTimeStamp());
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel.setClickDownX(motionEvent.getX() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel2 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel2.setClickDownY(motionEvent.getY() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel3 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel3.setSrcDownX(motionEvent.getRawX() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel4 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel4.setSrcDownY(motionEvent.getRawY() + "");
                String str = Constants.TAG;
                LogUtil.i(str, "ACTION_DOWN event.getX() : " + motionEvent.getX() + " , event.getY() : " + motionEvent.getY());
                String str2 = Constants.TAG;
                LogUtil.i(str2, "ACTION_DOWN event.getRaw() : " + motionEvent.getRawX() + " , event.getRawX() : " + motionEvent.getRawX());
                String str3 = Constants.TAG;
                LogUtil.i(str3, "ACTION_DOWN getRight() : " + getRight() + " , getTop() : " + getTop());
            } else if (action == 1) {
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel5 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel5.setClickUpY(motionEvent.getX() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel6 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel6.setClickUpY(motionEvent.getY() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel7 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel7.setSrcUpX(motionEvent.getRawX() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel8 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel8.setSrcUpY(motionEvent.getRawY() + "");
                this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setUpTS(DeviceInfo.getInstance(getContext()).getTimeStamp());
                String str4 = Constants.TAG;
                LogUtil.i(str4, "ACTION_UP event.getX() : " + motionEvent.getX() + " , event.getY() : " + motionEvent.getY());
                String str5 = Constants.TAG;
                LogUtil.i(str5, "ACTION_DOWN event.getRaw() : " + motionEvent.getRawX() + " , event.getRawX() : " + motionEvent.getRawX());
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
        adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickView(this);
    }

    public AdCustomImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdCustomImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
