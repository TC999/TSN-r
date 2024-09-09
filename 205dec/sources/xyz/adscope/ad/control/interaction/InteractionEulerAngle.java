package xyz.adscope.ad.control.interaction;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;
import xyz.adscope.ad.control.interaction.view.AdEulerAngleInteractionView;
import xyz.adscope.ad.control.strategy.StrategyUserProtection;
import xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel;
import xyz.adscope.ad.model.http.response.ad.EulerAngleAxisModel;
import xyz.adscope.ad.model.http.response.ad.EulerAngleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InteractionEulerAngle implements IBaseInteraction {
    private WeakReference<Context> context;
    private String mAdType;
    private String mApiKey;
    private long mCoolTime;
    private EulerAngleModel mEulerAngleModel;
    private Sensor mGyroscopeSensor;
    private InteractionEulerAngleListener mInteractionEulerAngleListener;
    private InteractionModel mInteractionModel;
    private long mPassivationTime;
    private int mPassivationType;
    private long mProtectTime;
    private float mSensorEventTimestamp;
    private SensorManager mSensorManager;
    private ActionParamConfigModel mSubTitleActionParamConfigModel;
    private View mTargetView;
    private ActionParamConfigModel mTitleActionParamConfigModel;
    private ActionParamConfigModel mXAngleActionParamConfigModel;
    private String mXDirection;
    private ActionParamConfigModel mXDirectionActionParamConfigModel;
    private ActionParamConfigModel mYAngleActionParamConfigModel;
    private String mYDirection;
    private ActionParamConfigModel mYDirectionActionParamConfigModel;
    private ActionParamConfigModel mZAngleActionParamConfigModel;
    private String mZDirection;
    private ActionParamConfigModel mZDirectionActionParamConfigModel;
    private String subTitle;
    private String title;
    private String TAG = getClass().getSimpleName();
    private int ACTION_PARAM_CONFIG_TYPE_NORMAL = 0;
    private int ACTION_PARAM_CONFIG_TYPE_PASSIVATION = 1;
    private int ACTION_PARAM_CONFIG_TYPE_COOL = 2;
    private float NS2S = 1.0E-9f;
    private float[] angleValues = new float[3];
    private double mXAngle = 0.0d;
    private double mYAngle = 0.0d;
    private double mZAngle = 0.0d;
    private boolean isCallBack = false;
    private boolean isUseCoolInteraction = false;
    private SensorEventListener sensorEventListener = new SensorEventListener() { // from class: xyz.adscope.ad.control.interaction.InteractionEulerAngle.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            InteractionEulerAngle.this.handleSensorEventData(sensorEvent);
        }
    };

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface InteractionEulerAngleListener {
        void onClick();
    }

    public InteractionEulerAngle(View view, String str, String str2, InteractionModel interactionModel, InteractionEulerAngleListener interactionEulerAngleListener) {
        this.context = null;
        if (view == null) {
            return;
        }
        try {
            this.mTargetView = view;
            WeakReference<Context> weakReference = new WeakReference<>(this.mTargetView.getContext());
            this.context = weakReference;
            if (this.mSensorManager == null && weakReference.get() != null) {
                this.mSensorManager = (SensorManager) this.context.get().getSystemService("sensor");
            }
            this.mGyroscopeSensor = this.mSensorManager.getDefaultSensor(4);
            this.mApiKey = str;
            this.mAdType = str2;
            this.mInteractionModel = interactionModel;
            this.mInteractionEulerAngleListener = interactionEulerAngleListener;
            handleInteractionParams();
            setIndicateArrowMaxProgress();
            registerSensorListener();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void callBackResult() {
        try {
            if (this.mInteractionEulerAngleListener == null || this.isCallBack) {
                return;
            }
            onPause();
            if (!this.isUseCoolInteraction) {
                StrategyUserProtection.getInstance().putUserCoolData(this.mApiKey, this.mAdType);
            }
            this.mInteractionEulerAngleListener.onClick();
            LogUtil.e(this.TAG, "callBackResult ");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean checkIsExistCoolData() {
        ActionParamConfigModel actionParamConfigModel = this.mXAngleActionParamConfigModel;
        String cool = actionParamConfigModel != null ? actionParamConfigModel.getCool() : null;
        ActionParamConfigModel actionParamConfigModel2 = this.mYAngleActionParamConfigModel;
        String cool2 = actionParamConfigModel2 != null ? actionParamConfigModel2.getCool() : null;
        ActionParamConfigModel actionParamConfigModel3 = this.mZAngleActionParamConfigModel;
        String cool3 = actionParamConfigModel3 != null ? actionParamConfigModel3.getCool() : null;
        ActionParamConfigModel actionParamConfigModel4 = this.mXDirectionActionParamConfigModel;
        String cool4 = actionParamConfigModel4 != null ? actionParamConfigModel4.getCool() : null;
        ActionParamConfigModel actionParamConfigModel5 = this.mYDirectionActionParamConfigModel;
        String cool5 = actionParamConfigModel5 != null ? actionParamConfigModel5.getCool() : null;
        ActionParamConfigModel actionParamConfigModel6 = this.mZDirectionActionParamConfigModel;
        String cool6 = actionParamConfigModel6 != null ? actionParamConfigModel6.getCool() : null;
        if (TextUtils.isEmpty(cool) || TextUtils.isEmpty(cool4)) {
            if (TextUtils.isEmpty(cool2) || TextUtils.isEmpty(cool5)) {
                return (TextUtils.isEmpty(cool3) || TextUtils.isEmpty(cool6)) ? false : true;
            }
            return true;
        }
        return true;
    }

    private double getAngleData(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return Float.parseFloat(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0.0d;
        }
    }

    private void handleInteractionParams() {
        try {
            InteractionModel interactionModel = this.mInteractionModel;
            if (interactionModel == null) {
                return;
            }
            EulerAngleModel eulerAngle = interactionModel.getEulerAngle();
            this.mEulerAngleModel = eulerAngle;
            if (eulerAngle == null) {
                return;
            }
            this.mTitleActionParamConfigModel = eulerAngle.getTitle();
            this.mSubTitleActionParamConfigModel = this.mEulerAngleModel.getSubTitle();
            EulerAngleAxisModel eulerAngleAxisModel = this.mEulerAngleModel.getxAxis();
            if (eulerAngleAxisModel != null) {
                this.mXAngleActionParamConfigModel = eulerAngleAxisModel.getAngle();
                this.mXDirectionActionParamConfigModel = eulerAngleAxisModel.getDirection();
            }
            EulerAngleAxisModel eulerAngleAxisModel2 = this.mEulerAngleModel.getyAxis();
            if (eulerAngleAxisModel2 != null) {
                this.mYAngleActionParamConfigModel = eulerAngleAxisModel2.getAngle();
                this.mYDirectionActionParamConfigModel = eulerAngleAxisModel2.getDirection();
            }
            EulerAngleAxisModel eulerAngleAxisModel3 = this.mEulerAngleModel.getzAxis();
            if (eulerAngleAxisModel3 != null) {
                this.mZAngleActionParamConfigModel = eulerAngleAxisModel3.getAngle();
                this.mZDirectionActionParamConfigModel = eulerAngleAxisModel3.getDirection();
            }
            this.mPassivationTime = this.mInteractionModel.getPassivationTime();
            this.mPassivationType = this.mInteractionModel.getPassivationType();
            this.mProtectTime = this.mInteractionModel.getProtectTime();
            this.mCoolTime = this.mInteractionModel.getCoolTime();
            if ((StrategyUserProtection.getInstance().isNewUser(this.mProtectTime) || StrategyUserProtection.getInstance().isInCooling(this.mApiKey, this.mAdType, this.mCoolTime)) && checkIsExistCoolData()) {
                this.isUseCoolInteraction = true;
                setActionParamConfigData(this.ACTION_PARAM_CONFIG_TYPE_COOL, 0.0d, true);
            } else if (this.mPassivationTime <= 0) {
                this.isUseCoolInteraction = false;
                setActionParamConfigData(this.ACTION_PARAM_CONFIG_TYPE_NORMAL, 0.0d, true);
            } else {
                startPassivationAnimation();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSensorEventData(SensorEvent sensorEvent) {
        Sensor sensor;
        float[] fArr;
        if (sensorEvent != null) {
            try {
                if (this.isCallBack || (sensor = sensorEvent.sensor) == null || (fArr = sensorEvent.values) == null || sensor.getType() != 4) {
                    return;
                }
                float f4 = this.mSensorEventTimestamp;
                if (f4 != 0.0f) {
                    float f5 = fArr[0];
                    float f6 = fArr[1];
                    float f7 = fArr[2];
                    float f8 = (((float) sensorEvent.timestamp) - f4) * this.NS2S;
                    float[] fArr2 = this.angleValues;
                    double d4 = fArr2[0];
                    double degrees = Math.toDegrees(f5 * f8);
                    Double.isNaN(d4);
                    fArr2[0] = (float) (d4 + degrees);
                    float[] fArr3 = this.angleValues;
                    double d5 = fArr3[1];
                    double degrees2 = Math.toDegrees(f6 * f8);
                    Double.isNaN(d5);
                    fArr3[1] = (float) (d5 + degrees2);
                    float[] fArr4 = this.angleValues;
                    double d6 = fArr4[2];
                    double degrees3 = Math.toDegrees(f7 * f8);
                    Double.isNaN(d6);
                    fArr4[2] = (float) (d6 + degrees3);
                    float[] fArr5 = this.angleValues;
                    setIndicateArrowCurrentProgress(fArr5[0], fArr5[1], fArr5[2]);
                    LogUtil.d(this.TAG, "eulerAngle  x: " + String.format("%.4f", Float.valueOf(this.angleValues[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.angleValues[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.angleValues[2])) + ",x : " + this.mXAngle + "(" + this.mXDirection + "),y : " + this.mYAngle + "(" + this.mYDirection + "),z : " + this.mZAngle + "(" + this.mZDirection + ")");
                    if (judgeIsHit()) {
                        callBackResult();
                    }
                }
                this.mSensorEventTimestamp = (float) sensorEvent.timestamp;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private boolean judgeIsHit() {
        try {
            if (this.mXAngle > 0.0d) {
                if ("2".equals(this.mXDirection)) {
                    float[] fArr = this.angleValues;
                    if (fArr[0] > 0.0f && Math.abs(fArr[0]) >= this.mXAngle) {
                        return true;
                    }
                } else if ("1".equals(this.mXDirection)) {
                    float[] fArr2 = this.angleValues;
                    if (fArr2[0] < 0.0f && Math.abs(fArr2[0]) >= this.mXAngle) {
                        return true;
                    }
                } else if ("0".equals(this.mXDirection) && Math.abs(this.angleValues[0]) >= this.mXAngle) {
                    return true;
                }
            }
            if (this.mYAngle > 0.0d) {
                if ("2".equals(this.mYDirection)) {
                    float[] fArr3 = this.angleValues;
                    if (fArr3[1] < 0.0f && Math.abs(fArr3[1]) >= this.mYAngle) {
                        return true;
                    }
                } else if ("1".equals(this.mYDirection)) {
                    float[] fArr4 = this.angleValues;
                    if (fArr4[1] > 0.0f && Math.abs(fArr4[1]) >= this.mYAngle) {
                        return true;
                    }
                } else if ("0".equals(this.mYDirection) && Math.abs(this.angleValues[1]) >= this.mYAngle) {
                    return true;
                }
            }
            if (this.mZAngle > 0.0d) {
                if ("2".equals(this.mZDirection)) {
                    float[] fArr5 = this.angleValues;
                    if (fArr5[2] > 0.0f && Math.abs(fArr5[2]) >= this.mZAngle) {
                        return true;
                    }
                } else if ("1".equals(this.mZDirection)) {
                    float[] fArr6 = this.angleValues;
                    if (fArr6[2] < 0.0f && Math.abs(fArr6[2]) >= this.mZAngle) {
                        return true;
                    }
                } else if ("0".equals(this.mZDirection) && Math.abs(this.angleValues[2]) >= this.mZAngle) {
                    return true;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    private void registerSensorListener() {
        SensorManager sensorManager;
        Sensor sensor;
        try {
            if (this.context == null || (sensorManager = this.mSensorManager) == null || (sensor = this.mGyroscopeSensor) == null) {
                return;
            }
            sensorManager.registerListener(this.sensorEventListener, sensor, 1);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionParamConfigData(int i4, double d4, boolean z3) {
        ActionParamConfigModel actionParamConfigModel = this.mTitleActionParamConfigModel;
        if (actionParamConfigModel != null) {
            this.title = actionParamConfigModel.getNormal();
        }
        ActionParamConfigModel actionParamConfigModel2 = this.mSubTitleActionParamConfigModel;
        if (actionParamConfigModel2 != null) {
            this.subTitle = actionParamConfigModel2.getNormal();
        }
        if (i4 == this.ACTION_PARAM_CONFIG_TYPE_NORMAL) {
            ActionParamConfigModel actionParamConfigModel3 = this.mXAngleActionParamConfigModel;
            if (actionParamConfigModel3 != null && !TextUtils.isEmpty(actionParamConfigModel3.getNormal())) {
                this.mXAngle = getAngleData(this.mXAngleActionParamConfigModel.getNormal());
            } else {
                this.mXAngle = 0.0d;
            }
            ActionParamConfigModel actionParamConfigModel4 = this.mYAngleActionParamConfigModel;
            if (actionParamConfigModel4 != null && !TextUtils.isEmpty(actionParamConfigModel4.getNormal())) {
                this.mYAngle = getAngleData(this.mYAngleActionParamConfigModel.getNormal());
            } else {
                this.mYAngle = 0.0d;
            }
            ActionParamConfigModel actionParamConfigModel5 = this.mZAngleActionParamConfigModel;
            if (actionParamConfigModel5 != null && !TextUtils.isEmpty(actionParamConfigModel5.getNormal())) {
                this.mZAngle = getAngleData(this.mZAngleActionParamConfigModel.getNormal());
            } else {
                this.mZAngle = 0.0d;
            }
            ActionParamConfigModel actionParamConfigModel6 = this.mXDirectionActionParamConfigModel;
            if (actionParamConfigModel6 != null && !TextUtils.isEmpty(actionParamConfigModel6.getNormal())) {
                this.mXDirection = this.mXDirectionActionParamConfigModel.getNormal();
            } else {
                this.mXDirection = null;
            }
            ActionParamConfigModel actionParamConfigModel7 = this.mYDirectionActionParamConfigModel;
            if (actionParamConfigModel7 != null && !TextUtils.isEmpty(actionParamConfigModel7.getNormal())) {
                this.mYDirection = this.mYDirectionActionParamConfigModel.getNormal();
            } else {
                this.mYDirection = null;
            }
            ActionParamConfigModel actionParamConfigModel8 = this.mZDirectionActionParamConfigModel;
            if (actionParamConfigModel8 != null && !TextUtils.isEmpty(actionParamConfigModel8.getNormal())) {
                this.mZDirection = this.mZDirectionActionParamConfigModel.getNormal();
            } else {
                this.mZDirection = null;
            }
            setIndicateArrowCurrentProgress(0.0d, 0.0d, 0.0d);
        } else if (i4 == this.ACTION_PARAM_CONFIG_TYPE_PASSIVATION) {
            ActionParamConfigModel actionParamConfigModel9 = this.mXAngleActionParamConfigModel;
            if (actionParamConfigModel9 != null) {
                double angleData = !TextUtils.isEmpty(actionParamConfigModel9.getNormal()) ? getAngleData(this.mXAngleActionParamConfigModel.getNormal()) : 0.0d;
                double angleData2 = !TextUtils.isEmpty(this.mXAngleActionParamConfigModel.getPassivation()) ? getAngleData(this.mXAngleActionParamConfigModel.getPassivation()) : 0.0d;
                if (angleData2 <= 0.0d) {
                    this.mXAngle = angleData;
                } else if (d4 > 0.0d) {
                    this.mXAngle = angleData + ((angleData2 - angleData) * d4);
                } else {
                    this.mXAngle = angleData2;
                }
            }
            ActionParamConfigModel actionParamConfigModel10 = this.mYAngleActionParamConfigModel;
            if (actionParamConfigModel10 != null) {
                double angleData3 = !TextUtils.isEmpty(actionParamConfigModel10.getNormal()) ? getAngleData(this.mYAngleActionParamConfigModel.getNormal()) : 0.0d;
                double angleData4 = !TextUtils.isEmpty(this.mYAngleActionParamConfigModel.getPassivation()) ? getAngleData(this.mYAngleActionParamConfigModel.getPassivation()) : 0.0d;
                if (angleData4 <= 0.0d) {
                    this.mYAngle = angleData3;
                } else if (d4 > 0.0d) {
                    this.mYAngle = angleData3 + ((angleData4 - angleData3) * d4);
                } else {
                    this.mYAngle = angleData4;
                }
            }
            ActionParamConfigModel actionParamConfigModel11 = this.mZAngleActionParamConfigModel;
            if (actionParamConfigModel11 != null) {
                double angleData5 = !TextUtils.isEmpty(actionParamConfigModel11.getNormal()) ? getAngleData(this.mZAngleActionParamConfigModel.getNormal()) : 0.0d;
                double angleData6 = !TextUtils.isEmpty(this.mZAngleActionParamConfigModel.getPassivation()) ? getAngleData(this.mZAngleActionParamConfigModel.getPassivation()) : 0.0d;
                if (angleData6 <= 0.0d) {
                    this.mZAngle = angleData5;
                } else if (d4 > 0.0d) {
                    this.mZAngle = angleData5 + ((angleData6 - angleData5) * d4);
                } else {
                    this.mZAngle = angleData6;
                }
            }
            ActionParamConfigModel actionParamConfigModel12 = this.mXDirectionActionParamConfigModel;
            if (actionParamConfigModel12 != null && !TextUtils.isEmpty(actionParamConfigModel12.getNormal())) {
                this.mXDirection = this.mXDirectionActionParamConfigModel.getNormal();
            } else {
                this.mXDirection = null;
            }
            ActionParamConfigModel actionParamConfigModel13 = this.mYDirectionActionParamConfigModel;
            if (actionParamConfigModel13 != null && !TextUtils.isEmpty(actionParamConfigModel13.getNormal())) {
                this.mYDirection = this.mYDirectionActionParamConfigModel.getNormal();
            } else {
                this.mYDirection = null;
            }
            ActionParamConfigModel actionParamConfigModel14 = this.mZDirectionActionParamConfigModel;
            if (actionParamConfigModel14 != null && !TextUtils.isEmpty(actionParamConfigModel14.getNormal())) {
                this.mZDirection = this.mZDirectionActionParamConfigModel.getNormal();
            } else {
                this.mZDirection = null;
            }
        } else if (i4 == this.ACTION_PARAM_CONFIG_TYPE_COOL) {
            ActionParamConfigModel actionParamConfigModel15 = this.mTitleActionParamConfigModel;
            if (actionParamConfigModel15 != null && !TextUtils.isEmpty(actionParamConfigModel15.getCool())) {
                this.title = this.mTitleActionParamConfigModel.getCool();
            }
            ActionParamConfigModel actionParamConfigModel16 = this.mSubTitleActionParamConfigModel;
            if (actionParamConfigModel16 != null && !TextUtils.isEmpty(actionParamConfigModel16.getCool())) {
                this.subTitle = this.mSubTitleActionParamConfigModel.getCool();
            }
            ActionParamConfigModel actionParamConfigModel17 = this.mXAngleActionParamConfigModel;
            if (actionParamConfigModel17 != null && !TextUtils.isEmpty(actionParamConfigModel17.getCool())) {
                this.mXAngle = getAngleData(this.mXAngleActionParamConfigModel.getCool());
            } else {
                this.mXAngle = 0.0d;
            }
            ActionParamConfigModel actionParamConfigModel18 = this.mYAngleActionParamConfigModel;
            if (actionParamConfigModel18 != null && !TextUtils.isEmpty(actionParamConfigModel18.getCool())) {
                this.mYAngle = getAngleData(this.mYAngleActionParamConfigModel.getCool());
            } else {
                this.mYAngle = 0.0d;
            }
            ActionParamConfigModel actionParamConfigModel19 = this.mZAngleActionParamConfigModel;
            if (actionParamConfigModel19 != null && !TextUtils.isEmpty(actionParamConfigModel19.getCool())) {
                this.mZAngle = getAngleData(this.mZAngleActionParamConfigModel.getCool());
            } else {
                this.mZAngle = 0.0d;
            }
            ActionParamConfigModel actionParamConfigModel20 = this.mXDirectionActionParamConfigModel;
            if (actionParamConfigModel20 != null && !TextUtils.isEmpty(actionParamConfigModel20.getCool())) {
                this.mXDirection = this.mXDirectionActionParamConfigModel.getCool();
            } else {
                this.mXDirection = null;
            }
            ActionParamConfigModel actionParamConfigModel21 = this.mYDirectionActionParamConfigModel;
            if (actionParamConfigModel21 != null && !TextUtils.isEmpty(actionParamConfigModel21.getCool())) {
                this.mYDirection = this.mYDirectionActionParamConfigModel.getCool();
            } else {
                this.mYDirection = null;
            }
            ActionParamConfigModel actionParamConfigModel22 = this.mZDirectionActionParamConfigModel;
            if (actionParamConfigModel22 != null && !TextUtils.isEmpty(actionParamConfigModel22.getCool())) {
                this.mZDirection = this.mZDirectionActionParamConfigModel.getCool();
            } else {
                this.mZDirection = null;
            }
            setIndicateArrowCurrentProgress(0.0d, 0.0d, 0.0d);
        }
        if (i4 == this.ACTION_PARAM_CONFIG_TYPE_NORMAL || i4 == this.ACTION_PARAM_CONFIG_TYPE_COOL || z3) {
            setTitleData();
        }
        if (z3) {
            startViewAnimation();
        }
    }

    private void setIndicateArrowCurrentProgress(double d4, double d5, double d6) {
        try {
            View view = this.mTargetView;
            if (view != null && (view instanceof AdEulerAngleInteractionView)) {
                double d7 = 0.0d;
                double abs = (this.mXAngle <= 0.0d || ((!"2".equals(this.mXDirection) || d4 <= 0.0d) && ((!"1".equals(this.mXDirection) || d4 >= 0.0d) && !"0".equals(this.mXDirection)))) ? 0.0d : (Math.abs(d4) * 100.0d) / this.mXAngle;
                double abs2 = (this.mYAngle <= 0.0d || ((!"2".equals(this.mYDirection) || d5 >= 0.0d) && ((!"1".equals(this.mYDirection) || d5 <= 0.0d) && !"0".equals(this.mYDirection)))) ? 0.0d : (Math.abs(d5) * 100.0d) / this.mYAngle;
                if (this.mZAngle > 0.0d && (("2".equals(this.mZDirection) && d6 > 0.0d) || (("1".equals(this.mZDirection) && d6 < 0.0d) || "0".equals(this.mZDirection)))) {
                    d7 = (Math.abs(d6) * 100.0d) / this.mZAngle;
                }
                ((AdEulerAngleInteractionView) this.mTargetView).setCurrentProgress(Math.max(Math.max(abs, abs2), d7));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void setIndicateArrowMaxProgress() {
        try {
            View view = this.mTargetView;
            if (view != null && (view instanceof AdEulerAngleInteractionView)) {
                ((AdEulerAngleInteractionView) view).setMaxProgress(100.0d);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void setTitleData() {
        try {
            View view = this.mTargetView;
            if (view != null && (view instanceof AdEulerAngleInteractionView)) {
                ((AdEulerAngleInteractionView) view).setTitle(this.title, this.subTitle);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void startPassivationAnimation() {
        try {
            ValueAnimator ofInt = ValueAnimator.ofInt(10, 1);
            ofInt.setDuration(this.mPassivationTime);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.adscope.ad.control.interaction.InteractionEulerAngle.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    try {
                        if (InteractionEulerAngle.this.mPassivationType == 1) {
                            double intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            Double.isNaN(intValue);
                            double d4 = intValue / 10.0d;
                            if (d4 > 0.0d) {
                                InteractionEulerAngle interactionEulerAngle = InteractionEulerAngle.this;
                                interactionEulerAngle.setActionParamConfigData(interactionEulerAngle.ACTION_PARAM_CONFIG_TYPE_PASSIVATION, d4, false);
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: xyz.adscope.ad.control.interaction.InteractionEulerAngle.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    try {
                        InteractionEulerAngle interactionEulerAngle = InteractionEulerAngle.this;
                        interactionEulerAngle.setActionParamConfigData(interactionEulerAngle.ACTION_PARAM_CONFIG_TYPE_NORMAL, 0.0d, false);
                        InteractionEulerAngle.this.mSensorEventTimestamp = 0.0f;
                        InteractionEulerAngle.this.angleValues[0] = 0.0f;
                        InteractionEulerAngle.this.angleValues[1] = 0.0f;
                        InteractionEulerAngle.this.angleValues[2] = 0.0f;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    try {
                        InteractionEulerAngle interactionEulerAngle = InteractionEulerAngle.this;
                        interactionEulerAngle.setActionParamConfigData(interactionEulerAngle.ACTION_PARAM_CONFIG_TYPE_PASSIVATION, 0.0d, true);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            ofInt.start();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void startViewAnimation() {
        try {
            View view = this.mTargetView;
            if (view != null && (view instanceof AdEulerAngleInteractionView)) {
                ((AdEulerAngleInteractionView) view).startInteractionAnimation(this.mXDirection, this.mYDirection, this.mZDirection);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void execute() {
    }

    public void onDestroy() {
        onPause();
        this.mSensorManager = null;
        this.mGyroscopeSensor = null;
        this.mInteractionEulerAngleListener = null;
        this.sensorEventListener = null;
        this.mTargetView = null;
        this.mInteractionModel = null;
        this.mEulerAngleModel = null;
        this.context = null;
    }

    public void onPause() {
        try {
            LogUtil.e(this.TAG, "onPause");
            this.isCallBack = true;
            this.mSensorEventTimestamp = 0.0f;
            float[] fArr = this.angleValues;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.sensorEventListener);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035 A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:5:0x0010, B:8:0x0021, B:13:0x002f, B:15:0x0035, B:17:0x0040, B:16:0x003b, B:9:0x0024, B:11:0x002a, B:12:0x002d), top: B:22:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:5:0x0010, B:8:0x0021, B:13:0x002f, B:15:0x0035, B:17:0x0040, B:16:0x003b, B:9:0x0024, B:11:0x002a, B:12:0x002d), top: B:22:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r7 = this;
            r0 = 0
            r7.isCallBack = r0     // Catch: java.lang.Exception -> L5c
            xyz.adscope.ad.control.strategy.StrategyUserProtection r1 = xyz.adscope.ad.control.strategy.StrategyUserProtection.getInstance()     // Catch: java.lang.Exception -> L5c
            long r2 = r7.mProtectTime     // Catch: java.lang.Exception -> L5c
            boolean r1 = r1.isNewUser(r2)     // Catch: java.lang.Exception -> L5c
            r2 = 1
            if (r1 != 0) goto L24
            xyz.adscope.ad.control.strategy.StrategyUserProtection r1 = xyz.adscope.ad.control.strategy.StrategyUserProtection.getInstance()     // Catch: java.lang.Exception -> L5c
            java.lang.String r3 = r7.mApiKey     // Catch: java.lang.Exception -> L5c
            java.lang.String r4 = r7.mAdType     // Catch: java.lang.Exception -> L5c
            long r5 = r7.mCoolTime     // Catch: java.lang.Exception -> L5c
            boolean r1 = r1.isInCooling(r3, r4, r5)     // Catch: java.lang.Exception -> L5c
            if (r1 == 0) goto L21
            goto L24
        L21:
            r7.isUseCoolInteraction = r0     // Catch: java.lang.Exception -> L5c
            goto L2f
        L24:
            boolean r1 = r7.checkIsExistCoolData()     // Catch: java.lang.Exception -> L5c
            if (r1 == 0) goto L2d
            r7.isUseCoolInteraction = r2     // Catch: java.lang.Exception -> L5c
            goto L2f
        L2d:
            r7.isUseCoolInteraction = r0     // Catch: java.lang.Exception -> L5c
        L2f:
            boolean r0 = r7.isUseCoolInteraction     // Catch: java.lang.Exception -> L5c
            r3 = 0
            if (r0 == 0) goto L3b
            int r0 = r7.ACTION_PARAM_CONFIG_TYPE_COOL     // Catch: java.lang.Exception -> L5c
            r7.setActionParamConfigData(r0, r3, r2)     // Catch: java.lang.Exception -> L5c
            goto L40
        L3b:
            int r0 = r7.ACTION_PARAM_CONFIG_TYPE_NORMAL     // Catch: java.lang.Exception -> L5c
            r7.setActionParamConfigData(r0, r3, r2)     // Catch: java.lang.Exception -> L5c
        L40:
            java.lang.String r0 = r7.TAG     // Catch: java.lang.Exception -> L5c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5c
            r1.<init>()     // Catch: java.lang.Exception -> L5c
            java.lang.String r2 = "onResume isUseInteraction\uff1a"
            r1.append(r2)     // Catch: java.lang.Exception -> L5c
            boolean r2 = r7.isUseCoolInteraction     // Catch: java.lang.Exception -> L5c
            r1.append(r2)     // Catch: java.lang.Exception -> L5c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L5c
            xyz.adscope.common.tool.LogUtil.e(r0, r1)     // Catch: java.lang.Exception -> L5c
            r7.registerSensorListener()     // Catch: java.lang.Exception -> L5c
            goto L60
        L5c:
            r0 = move-exception
            r0.printStackTrace()
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.interaction.InteractionEulerAngle.onResume():void");
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void setAdListener(AdListener adListener) {
    }
}
