package com.baidu.idl.face.platform.p049ui;

import android.text.TextUtils;
import android.view.View;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.face.platform.p049ui.widget.TimeoutDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.idl.face.platform.ui.BaseFaceDetectActivity */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseFaceDetectActivity extends FaceDetectActivity implements TimeoutDialog.OnTimeoutDialogClickListener {
    private String mBmpStr;
    private TimeoutDialog mTimeoutDialog;

    private void getBestImage(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        if (hashMap != null && hashMap.size() > 0) {
            Collections.sort(new ArrayList(hashMap.entrySet()), new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.BaseFaceDetectActivity.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                    return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
                }
            });
        }
        if (hashMap2 != null && hashMap2.size() > 0) {
            ArrayList arrayList = new ArrayList(hashMap2.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.BaseFaceDetectActivity.2
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                    return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
                }
            });
            this.mBmpStr = ((ImageInfo) ((Map.Entry) arrayList.get(0)).getValue()).getBase64();
        }
        if (TextUtils.isEmpty(this.mBmpStr)) {
            onRecollect();
        } else {
            onFace(this.mBmpStr);
        }
    }

    private void showMessageDialog() {
        TimeoutDialog timeoutDialog = new TimeoutDialog(this);
        this.mTimeoutDialog = timeoutDialog;
        timeoutDialog.setDialogListener(this);
        this.mTimeoutDialog.setCanceledOnTouchOutside(false);
        this.mTimeoutDialog.setCancelable(false);
        this.mTimeoutDialog.show();
        this.mHasShownTimeoutDialog = true;
        onPause();
    }

    @Override // com.baidu.idl.face.platform.p049ui.FaceDetectActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // com.baidu.idl.face.platform.p049ui.FaceDetectActivity, com.baidu.idl.face.platform.IDetectStrategyCallback
    public void onDetectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        super.onDetectCompletion(faceStatusNewEnum, str, hashMap, hashMap2);
        if (faceStatusNewEnum == FaceStatusNewEnum.OK && this.mIsCompletion) {
            getBestImage(hashMap, hashMap2);
        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
            View view = this.mViewBg;
            if (view != null) {
                view.setVisibility(0);
            }
            showMessageDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFace(String str) {
    }

    @Override // com.baidu.idl.face.platform.p049ui.widget.TimeoutDialog.OnTimeoutDialogClickListener
    public void onRecollect() {
        TimeoutDialog timeoutDialog = this.mTimeoutDialog;
        if (timeoutDialog != null) {
            timeoutDialog.dismiss();
            this.mHasShownTimeoutDialog = false;
        }
        View view = this.mViewBg;
        if (view != null) {
            view.setVisibility(8);
        }
        onResume();
    }

    @Override // com.baidu.idl.face.platform.p049ui.widget.TimeoutDialog.OnTimeoutDialogClickListener
    public void onReturn() {
        TimeoutDialog timeoutDialog = this.mTimeoutDialog;
        if (timeoutDialog != null) {
            timeoutDialog.dismiss();
            this.mHasShownTimeoutDialog = false;
        }
        finish();
    }
}
