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
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;
import xyz.adscope.ad.control.interaction.view.AdSharkInteractionView;
import xyz.adscope.ad.control.strategy.StrategyUserProtection;
import xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.ShakeModel;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InteractionShake implements IBaseInteraction {
    private Sensor mAccelerometerSensor;
    private String mAdType;
    private String mApiKey;
    private ActionParamConfigModel mAxialActionParamConfigModel;
    private long mCoolTime;
    private ActionParamConfigModel mCountActionParamConfigModel;
    private ActionParamConfigModel mEndAmplitudeActionParamConfigModel;
    private InteractionModel mInteractionModel;
    private InteractionShakeListener mInteractionShakeListener;
    private long mLastExecuteTime;
    private long mPassivationTime;
    private int mPassivationType;
    private long mProtectTime;
    private SensorManager mSensorManager;
    private double[] mShakeAmplitude;
    private int mShakeCount;
    private ShakeModel mShakeModel;
    private ActionParamConfigModel mStartAmplitudeActionParamConfigModel;
    private View mTargetView;
    private String TAG = getClass().getSimpleName();
    private int ACTION_PARAM_CONFIG_TYPE_NORMAL = 0;
    private int ACTION_PARAM_CONFIG_TYPE_PASSIVATION = 1;
    private int ACTION_PARAM_CONFIG_TYPE_COOL = 2;
    private double G_STATIC_NUM = 9.8d;
    private int SHAKE_EXECUTE_TIME_INTERVAL = 100;
    private double SHAKE_START_DEFAULT = 1.1d;
    private double mShakeInitialAmplitude = 0.0d;
    private int SHAKE_STATUS_TYPE_DEFAULT = 0;
    private int SHAKE_STATUS_TYPE_START = 1;
    private int SHAKE_STATUS_TYPE_END = 2;
    private float SHAKE_AMPLITUDE_DEFAULT = -1.0f;
    private String SHAKE_AXIAL_DEFAULT = "xyz";
    private String mShakeAxial = null;
    private int mShakeStatus = 0;
    private int mShakeExecuteCount = 0;
    private boolean isCallBackShake = false;
    private boolean isUseCoolInteraction = false;
    private SensorEventListener sensorEventListener = new SensorEventListener() { // from class: xyz.adscope.ad.control.interaction.InteractionShake.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            InteractionShake.this.handleSensorEventData(sensorEvent);
        }
    };

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface InteractionShakeListener {
        void onClick();
    }

    public InteractionShake(View view, String str, String str2, InteractionModel interactionModel, InteractionShakeListener interactionShakeListener) {
        double d4 = -1.0f;
        this.mShakeAmplitude = new double[]{d4, d4};
        if (view == null) {
            return;
        }
        try {
            this.mTargetView = view;
            this.mApiKey = str;
            this.mAdType = str2;
            this.mInteractionModel = interactionModel;
            this.mInteractionShakeListener = interactionShakeListener;
            handleInteractionParams();
            setShakeIndicateArrowMaxProgress();
            registerSensorListener();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private double calcShakeAmplitude(float f4, float f5, float f6, String str) {
        double pow;
        try {
            if (!str.contains("x") && !str.contains("X")) {
                pow = 0.0d;
                if (!str.contains("y") || str.contains("Y")) {
                    double d4 = f5;
                    double d5 = this.G_STATIC_NUM;
                    Double.isNaN(d4);
                    pow += Math.pow(d4 / d5, 2.0d);
                }
                if (!str.contains("z") || str.contains("Z")) {
                    double d6 = f6;
                    double d7 = this.G_STATIC_NUM;
                    Double.isNaN(d6);
                    pow += Math.pow(d6 / d7, 2.0d);
                }
                return Math.sqrt(pow);
            }
            double d8 = f4;
            double d9 = this.G_STATIC_NUM;
            Double.isNaN(d8);
            pow = Math.pow(d8 / d9, 2.0d) + 0.0d;
            if (!str.contains("y")) {
            }
            double d42 = f5;
            double d52 = this.G_STATIC_NUM;
            Double.isNaN(d42);
            pow += Math.pow(d42 / d52, 2.0d);
            if (!str.contains("z")) {
            }
            double d62 = f6;
            double d72 = this.G_STATIC_NUM;
            Double.isNaN(d62);
            pow += Math.pow(d62 / d72, 2.0d);
            return Math.sqrt(pow);
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0.0d;
        }
    }

    private void callBackShakeResult() {
        try {
            if (this.mInteractionShakeListener == null || this.isCallBackShake) {
                return;
            }
            onPause();
            if (!this.isUseCoolInteraction) {
                StrategyUserProtection.getInstance().putUserCoolData(this.mApiKey, this.mAdType);
            }
            this.mInteractionShakeListener.onClick();
            this.mShakeExecuteCount = 0;
            LogUtil.e(this.TAG, "callBackResult ");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkIsExistCoolData() {
        /*
            r10 = this;
            r0 = 0
            xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel r1 = r10.mStartAmplitudeActionParamConfigModel     // Catch: java.lang.Exception -> L7d
            r2 = 0
            if (r1 == 0) goto L1c
            java.lang.String r1 = r1.getCool()     // Catch: java.lang.Exception -> L7d
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L7d
            if (r1 != 0) goto L1c
            xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel r1 = r10.mStartAmplitudeActionParamConfigModel     // Catch: java.lang.Exception -> L7d
            java.lang.String r1 = r1.getCool()     // Catch: java.lang.Exception -> L7d
            double r4 = r10.getAmplitudeData(r1)     // Catch: java.lang.Exception -> L7d
            goto L1d
        L1c:
            r4 = r2
        L1d:
            xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel r1 = r10.mEndAmplitudeActionParamConfigModel     // Catch: java.lang.Exception -> L7d
            if (r1 == 0) goto L36
            java.lang.String r1 = r1.getCool()     // Catch: java.lang.Exception -> L7d
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L7d
            if (r1 != 0) goto L36
            xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel r1 = r10.mEndAmplitudeActionParamConfigModel     // Catch: java.lang.Exception -> L7d
            java.lang.String r1 = r1.getCool()     // Catch: java.lang.Exception -> L7d
            double r6 = r10.getAmplitudeData(r1)     // Catch: java.lang.Exception -> L7d
            goto L37
        L36:
            r6 = r2
        L37:
            xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel r1 = r10.mCountActionParamConfigModel     // Catch: java.lang.Exception -> L7d
            if (r1 == 0) goto L54
            java.lang.String r1 = r1.getCool()     // Catch: java.lang.Exception -> L7d
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L7d
            if (r1 != 0) goto L54
            xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel r1 = r10.mCountActionParamConfigModel     // Catch: java.lang.Exception -> L50
            java.lang.String r1 = r1.getCool()     // Catch: java.lang.Exception -> L50
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L50
            goto L55
        L50:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Exception -> L7d
        L54:
            r1 = 0
        L55:
            xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel r8 = r10.mAxialActionParamConfigModel     // Catch: java.lang.Exception -> L7d
            if (r8 == 0) goto L6a
            java.lang.String r8 = r8.getCool()     // Catch: java.lang.Exception -> L7d
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> L7d
            if (r8 != 0) goto L6a
            xyz.adscope.ad.model.http.response.ad.ActionParamConfigModel r8 = r10.mAxialActionParamConfigModel     // Catch: java.lang.Exception -> L7d
            java.lang.String r8 = r8.getCool()     // Catch: java.lang.Exception -> L7d
            goto L6b
        L6a:
            r8 = 0
        L6b:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 <= 0) goto L81
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 <= 0) goto L81
            if (r1 <= 0) goto L81
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> L7d
            if (r1 != 0) goto L81
            r0 = 1
            return r0
        L7d:
            r1 = move-exception
            r1.printStackTrace()
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.interaction.InteractionShake.checkIsExistCoolData():boolean");
    }

    private double getAmplitudeData(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -1.0d;
            }
            return Double.parseDouble(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return -1.0d;
        }
    }

    private void handleInteractionParams() {
        try {
            InteractionModel interactionModel = this.mInteractionModel;
            if (interactionModel == null) {
                return;
            }
            ShakeModel shake = interactionModel.getShake();
            this.mShakeModel = shake;
            if (shake == null) {
                return;
            }
            this.mStartAmplitudeActionParamConfigModel = shake.getStartAmplitude();
            this.mEndAmplitudeActionParamConfigModel = this.mShakeModel.getEndAmplitude();
            this.mCountActionParamConfigModel = this.mShakeModel.getCount();
            this.mAxialActionParamConfigModel = this.mShakeModel.getAxial();
            this.mPassivationTime = this.mInteractionModel.getPassivationTime();
            this.mPassivationType = this.mInteractionModel.getPassivationType();
            this.mProtectTime = this.mInteractionModel.getProtectTime();
            this.mCoolTime = this.mInteractionModel.getCoolTime();
            if ((StrategyUserProtection.getInstance().isNewUser(this.mProtectTime) || StrategyUserProtection.getInstance().isInCooling(this.mApiKey, this.mAdType, this.mCoolTime)) && checkIsExistCoolData()) {
                this.isUseCoolInteraction = true;
                setActionParamConfigData(this.ACTION_PARAM_CONFIG_TYPE_COOL, 0.0d);
            } else if (this.mPassivationTime <= 0) {
                this.isUseCoolInteraction = false;
                setActionParamConfigData(this.ACTION_PARAM_CONFIG_TYPE_NORMAL, 0.0d);
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
        try {
            if (System.currentTimeMillis() - this.mLastExecuteTime < this.SHAKE_EXECUTE_TIME_INTERVAL || this.isCallBackShake || sensorEvent == null || (sensor = sensorEvent.sensor) == null || (fArr = sensorEvent.values) == null) {
                return;
            }
            double[] dArr = this.mShakeAmplitude;
            double d4 = dArr[0];
            double d5 = this.SHAKE_AMPLITUDE_DEFAULT;
            if (d4 != d5 && dArr[1] != d5) {
                this.mLastExecuteTime = System.currentTimeMillis();
                if (sensor.getType() == 1) {
                    float f4 = fArr[0];
                    float f5 = fArr[1];
                    float f6 = fArr[2];
                    double calcShakeAmplitude = calcShakeAmplitude(f4, f5, f6, this.SHAKE_AXIAL_DEFAULT);
                    double calcShakeAmplitude2 = calcShakeAmplitude(f4, f5, f6, this.mShakeAxial);
                    if (calcShakeAmplitude < this.SHAKE_START_DEFAULT || this.mShakeInitialAmplitude == 0.0d) {
                        this.mShakeInitialAmplitude = Math.min(calcShakeAmplitude2, 1.0d);
                    }
                    double d6 = calcShakeAmplitude2 - this.mShakeInitialAmplitude;
                    double[] dArr2 = this.mShakeAmplitude;
                    double d7 = dArr2[0] - 1.0d;
                    double d8 = dArr2[1] - 1.0d;
                    if (d6 >= d7) {
                        this.mShakeStatus = this.SHAKE_STATUS_TYPE_START;
                    } else if (d6 <= d8 && this.mShakeStatus == this.SHAKE_STATUS_TYPE_START) {
                        this.mShakeExecuteCount++;
                        setShakeIndicateArrowCurrentProgress();
                        this.mShakeStatus = this.SHAKE_STATUS_TYPE_DEFAULT;
                        int i4 = this.mShakeCount;
                        if (i4 > 0 && this.mShakeExecuteCount >= i4) {
                            callBackShakeResult();
                        }
                    }
                    LogUtil.i(this.TAG, " current: " + String.format("%.4f", Double.valueOf(d6)) + ", execute: " + this.mShakeExecuteCount + ", start : " + String.format("%.4f", Double.valueOf(d7)) + ", end:" + String.format("%.4f", Double.valueOf(d8)) + ", count: " + this.mShakeCount + ", axial: " + this.mShakeAxial);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void registerSensorListener() {
        try {
            View view = this.mTargetView;
            Context context = view != null ? view.getContext() : null;
            if (context == null) {
                return;
            }
            if (this.mSensorManager == null) {
                this.mSensorManager = (SensorManager) context.getSystemService("sensor");
            }
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                this.mAccelerometerSensor = defaultSensor;
                if (defaultSensor != null) {
                    this.mSensorManager.registerListener(this.sensorEventListener, defaultSensor, 2);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionParamConfigData(int i4, double d4) {
        try {
            if (i4 == this.ACTION_PARAM_CONFIG_TYPE_NORMAL) {
                ActionParamConfigModel actionParamConfigModel = this.mStartAmplitudeActionParamConfigModel;
                if (actionParamConfigModel != null && !TextUtils.isEmpty(actionParamConfigModel.getNormal())) {
                    this.mShakeAmplitude[0] = getAmplitudeData(this.mStartAmplitudeActionParamConfigModel.getNormal());
                } else {
                    this.mShakeAmplitude[0] = this.SHAKE_AMPLITUDE_DEFAULT;
                }
                ActionParamConfigModel actionParamConfigModel2 = this.mEndAmplitudeActionParamConfigModel;
                if (actionParamConfigModel2 != null && !TextUtils.isEmpty(actionParamConfigModel2.getNormal())) {
                    this.mShakeAmplitude[1] = getAmplitudeData(this.mEndAmplitudeActionParamConfigModel.getNormal());
                } else {
                    this.mShakeAmplitude[1] = this.SHAKE_AMPLITUDE_DEFAULT;
                }
                ActionParamConfigModel actionParamConfigModel3 = this.mCountActionParamConfigModel;
                if (actionParamConfigModel3 != null && !TextUtils.isEmpty(actionParamConfigModel3.getNormal())) {
                    try {
                        this.mShakeCount = Integer.parseInt(this.mCountActionParamConfigModel.getNormal());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } else {
                    this.mShakeCount = 0;
                }
                ActionParamConfigModel actionParamConfigModel4 = this.mAxialActionParamConfigModel;
                if (actionParamConfigModel4 != null && !TextUtils.isEmpty(actionParamConfigModel4.getNormal())) {
                    this.mShakeAxial = this.mAxialActionParamConfigModel.getNormal();
                } else {
                    this.mShakeAxial = null;
                }
                setShakeIndicateArrowMaxProgress();
                setShakeIndicateArrowCurrentProgress();
            } else if (i4 == this.ACTION_PARAM_CONFIG_TYPE_PASSIVATION) {
                ActionParamConfigModel actionParamConfigModel5 = this.mStartAmplitudeActionParamConfigModel;
                if (actionParamConfigModel5 != null) {
                    double d5 = this.SHAKE_AMPLITUDE_DEFAULT;
                    if (!TextUtils.isEmpty(actionParamConfigModel5.getNormal())) {
                        d5 = getAmplitudeData(this.mStartAmplitudeActionParamConfigModel.getNormal());
                    }
                    double d6 = this.SHAKE_AMPLITUDE_DEFAULT;
                    if (!TextUtils.isEmpty(this.mStartAmplitudeActionParamConfigModel.getPassivation())) {
                        d6 = getAmplitudeData(this.mStartAmplitudeActionParamConfigModel.getPassivation());
                    }
                    if (d6 <= 0.0d) {
                        this.mShakeAmplitude[0] = d5;
                    } else if (d4 > 0.0d) {
                        this.mShakeAmplitude[0] = d5 + ((d6 - d5) * d4);
                    } else {
                        this.mShakeAmplitude[0] = d6;
                    }
                }
                ActionParamConfigModel actionParamConfigModel6 = this.mEndAmplitudeActionParamConfigModel;
                if (actionParamConfigModel6 != null) {
                    double d7 = this.SHAKE_AMPLITUDE_DEFAULT;
                    if (!TextUtils.isEmpty(actionParamConfigModel6.getNormal())) {
                        d7 = getAmplitudeData(this.mEndAmplitudeActionParamConfigModel.getNormal());
                    }
                    double d8 = this.SHAKE_AMPLITUDE_DEFAULT;
                    if (!TextUtils.isEmpty(this.mEndAmplitudeActionParamConfigModel.getPassivation())) {
                        d8 = getAmplitudeData(this.mEndAmplitudeActionParamConfigModel.getPassivation());
                    }
                    if (d8 <= 0.0d) {
                        this.mShakeAmplitude[1] = d7;
                    } else if (d4 > 0.0d) {
                        this.mShakeAmplitude[1] = d7 + ((d8 - d7) * d4);
                    } else {
                        this.mShakeAmplitude[1] = d8;
                    }
                }
                ActionParamConfigModel actionParamConfigModel7 = this.mCountActionParamConfigModel;
                if (actionParamConfigModel7 != null) {
                    try {
                        int parseInt = !TextUtils.isEmpty(actionParamConfigModel7.getPassivation()) ? Integer.parseInt(this.mCountActionParamConfigModel.getPassivation()) : 0;
                        if (parseInt > 0) {
                            this.mShakeCount = parseInt;
                        } else if (!TextUtils.isEmpty(this.mCountActionParamConfigModel.getNormal())) {
                            this.mShakeCount = Integer.parseInt(this.mCountActionParamConfigModel.getNormal());
                        } else {
                            this.mShakeCount = 0;
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                ActionParamConfigModel actionParamConfigModel8 = this.mAxialActionParamConfigModel;
                if (actionParamConfigModel8 != null && !TextUtils.isEmpty(actionParamConfigModel8.getNormal())) {
                    this.mShakeAxial = this.mAxialActionParamConfigModel.getNormal();
                } else {
                    this.mShakeAxial = null;
                }
                setShakeIndicateArrowMaxProgress();
                setShakeIndicateArrowCurrentProgress();
            } else {
                if (i4 == this.ACTION_PARAM_CONFIG_TYPE_COOL) {
                    ActionParamConfigModel actionParamConfigModel9 = this.mStartAmplitudeActionParamConfigModel;
                    if (actionParamConfigModel9 != null && !TextUtils.isEmpty(actionParamConfigModel9.getCool())) {
                        this.mShakeAmplitude[0] = getAmplitudeData(this.mStartAmplitudeActionParamConfigModel.getCool());
                    } else {
                        this.mShakeAmplitude[0] = this.SHAKE_AMPLITUDE_DEFAULT;
                    }
                    ActionParamConfigModel actionParamConfigModel10 = this.mEndAmplitudeActionParamConfigModel;
                    if (actionParamConfigModel10 != null && !TextUtils.isEmpty(actionParamConfigModel10.getCool())) {
                        this.mShakeAmplitude[1] = getAmplitudeData(this.mEndAmplitudeActionParamConfigModel.getCool());
                    } else {
                        this.mShakeAmplitude[1] = this.SHAKE_AMPLITUDE_DEFAULT;
                    }
                    ActionParamConfigModel actionParamConfigModel11 = this.mCountActionParamConfigModel;
                    if (actionParamConfigModel11 != null && !TextUtils.isEmpty(actionParamConfigModel11.getCool())) {
                        try {
                            this.mShakeCount = Integer.parseInt(this.mCountActionParamConfigModel.getCool());
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    } else {
                        this.mShakeCount = 0;
                    }
                    ActionParamConfigModel actionParamConfigModel12 = this.mAxialActionParamConfigModel;
                    if (actionParamConfigModel12 != null && !TextUtils.isEmpty(actionParamConfigModel12.getCool())) {
                        this.mShakeAxial = this.mAxialActionParamConfigModel.getCool();
                    } else {
                        this.mShakeAxial = null;
                    }
                }
                setShakeIndicateArrowMaxProgress();
                setShakeIndicateArrowCurrentProgress();
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    private void setShakeIndicateArrowCurrentProgress() {
        try {
            View view = this.mTargetView;
            if (view != null && (view instanceof AdSharkInteractionView)) {
                ((AdSharkInteractionView) view).setCurrentProgress(this.mShakeExecuteCount);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void setShakeIndicateArrowMaxProgress() {
        try {
            View view = this.mTargetView;
            if (view != null && (view instanceof AdSharkInteractionView)) {
                ((AdSharkInteractionView) view).setMaxProgress(this.mShakeCount);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void startPassivationAnimation() {
        try {
            ValueAnimator ofInt = ValueAnimator.ofInt(10, 1);
            ofInt.setDuration(this.mPassivationTime);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.adscope.ad.control.interaction.InteractionShake.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    try {
                        if (InteractionShake.this.mPassivationType == 1) {
                            double intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            Double.isNaN(intValue);
                            double d4 = intValue / 10.0d;
                            InteractionShake interactionShake = InteractionShake.this;
                            interactionShake.setActionParamConfigData(interactionShake.ACTION_PARAM_CONFIG_TYPE_PASSIVATION, d4);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: xyz.adscope.ad.control.interaction.InteractionShake.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    try {
                        InteractionShake.this.mShakeExecuteCount = 0;
                        InteractionShake interactionShake = InteractionShake.this;
                        interactionShake.mShakeStatus = interactionShake.SHAKE_STATUS_TYPE_DEFAULT;
                        InteractionShake interactionShake2 = InteractionShake.this;
                        interactionShake2.setActionParamConfigData(interactionShake2.ACTION_PARAM_CONFIG_TYPE_NORMAL, 0.0d);
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
                        InteractionShake.this.mShakeExecuteCount = 0;
                        InteractionShake interactionShake = InteractionShake.this;
                        interactionShake.setActionParamConfigData(interactionShake.ACTION_PARAM_CONFIG_TYPE_PASSIVATION, 0.0d);
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

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void execute() {
    }

    public void onDestroy() {
        onPause();
        this.mSensorManager = null;
        this.mAccelerometerSensor = null;
        this.mInteractionShakeListener = null;
        this.sensorEventListener = null;
        this.mTargetView = null;
        this.mInteractionModel = null;
        this.mShakeModel = null;
    }

    public void onPause() {
        try {
            LogUtil.e(this.TAG, "onPause");
            this.isCallBackShake = true;
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.sensorEventListener);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:3:0x0001, B:5:0x0019, B:8:0x002a, B:13:0x0039, B:15:0x003f, B:17:0x004a, B:16:0x0045, B:9:0x002d, B:11:0x0033, B:12:0x0037), top: B:22:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:3:0x0001, B:5:0x0019, B:8:0x002a, B:13:0x0039, B:15:0x003f, B:17:0x004a, B:16:0x0045, B:9:0x002d, B:11:0x0033, B:12:0x0037), top: B:22:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r6 = this;
            r0 = 0
            r6.mShakeExecuteCount = r0     // Catch: java.lang.Exception -> L6c
            int r1 = r6.SHAKE_STATUS_TYPE_DEFAULT     // Catch: java.lang.Exception -> L6c
            r6.mShakeStatus = r1     // Catch: java.lang.Exception -> L6c
            r1 = 0
            r6.mLastExecuteTime = r1     // Catch: java.lang.Exception -> L6c
            r6.isCallBackShake = r0     // Catch: java.lang.Exception -> L6c
            xyz.adscope.ad.control.strategy.StrategyUserProtection r1 = xyz.adscope.ad.control.strategy.StrategyUserProtection.getInstance()     // Catch: java.lang.Exception -> L6c
            long r2 = r6.mProtectTime     // Catch: java.lang.Exception -> L6c
            boolean r1 = r1.isNewUser(r2)     // Catch: java.lang.Exception -> L6c
            if (r1 != 0) goto L2d
            xyz.adscope.ad.control.strategy.StrategyUserProtection r1 = xyz.adscope.ad.control.strategy.StrategyUserProtection.getInstance()     // Catch: java.lang.Exception -> L6c
            java.lang.String r2 = r6.mApiKey     // Catch: java.lang.Exception -> L6c
            java.lang.String r3 = r6.mAdType     // Catch: java.lang.Exception -> L6c
            long r4 = r6.mCoolTime     // Catch: java.lang.Exception -> L6c
            boolean r1 = r1.isInCooling(r2, r3, r4)     // Catch: java.lang.Exception -> L6c
            if (r1 == 0) goto L2a
            goto L2d
        L2a:
            r6.isUseCoolInteraction = r0     // Catch: java.lang.Exception -> L6c
            goto L39
        L2d:
            boolean r1 = r6.checkIsExistCoolData()     // Catch: java.lang.Exception -> L6c
            if (r1 == 0) goto L37
            r0 = 1
            r6.isUseCoolInteraction = r0     // Catch: java.lang.Exception -> L6c
            goto L39
        L37:
            r6.isUseCoolInteraction = r0     // Catch: java.lang.Exception -> L6c
        L39:
            boolean r0 = r6.isUseCoolInteraction     // Catch: java.lang.Exception -> L6c
            r1 = 0
            if (r0 == 0) goto L45
            int r0 = r6.ACTION_PARAM_CONFIG_TYPE_COOL     // Catch: java.lang.Exception -> L6c
            r6.setActionParamConfigData(r0, r1)     // Catch: java.lang.Exception -> L6c
            goto L4a
        L45:
            int r0 = r6.ACTION_PARAM_CONFIG_TYPE_NORMAL     // Catch: java.lang.Exception -> L6c
            r6.setActionParamConfigData(r0, r1)     // Catch: java.lang.Exception -> L6c
        L4a:
            r6.setShakeIndicateArrowMaxProgress()     // Catch: java.lang.Exception -> L6c
            r6.setShakeIndicateArrowCurrentProgress()     // Catch: java.lang.Exception -> L6c
            java.lang.String r0 = r6.TAG     // Catch: java.lang.Exception -> L6c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6c
            r1.<init>()     // Catch: java.lang.Exception -> L6c
            java.lang.String r2 = "onResume isUseInteraction\uff1a"
            r1.append(r2)     // Catch: java.lang.Exception -> L6c
            boolean r2 = r6.isUseCoolInteraction     // Catch: java.lang.Exception -> L6c
            r1.append(r2)     // Catch: java.lang.Exception -> L6c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L6c
            xyz.adscope.common.tool.LogUtil.e(r0, r1)     // Catch: java.lang.Exception -> L6c
            r6.registerSensorListener()     // Catch: java.lang.Exception -> L6c
            goto L70
        L6c:
            r0 = move-exception
            r0.printStackTrace()
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.interaction.InteractionShake.onResume():void");
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void setAdListener(AdListener adListener) {
    }
}
