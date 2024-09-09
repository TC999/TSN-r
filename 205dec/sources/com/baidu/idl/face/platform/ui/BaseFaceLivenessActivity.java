package com.baidu.idl.face.platform.ui;

import android.text.TextUtils;
import android.view.View;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.face.platform.ui.widget.TimeoutDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BaseFaceLivenessActivity extends FaceLivenessActivity implements TimeoutDialog.OnTimeoutDialogClickListener {
    private TimeoutDialog mTimeoutDialog;

    private void getBestImage(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        String str;
        if (hashMap != null && hashMap.size() > 0) {
            Collections.sort(new ArrayList(hashMap.entrySet()), new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                    return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
                }
            });
        }
        if (hashMap2 == null || hashMap2.size() <= 0) {
            str = null;
        } else {
            ArrayList arrayList = new ArrayList(hashMap2.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity.2
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                    return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
                }
            });
            str = ((ImageInfo) ((Map.Entry) arrayList.get(0)).getValue()).getBase64();
        }
        if (TextUtils.isEmpty(str)) {
            onRecollect();
        } else {
            onFace(str);
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

    @Override // com.baidu.idl.face.platform.ui.FaceLivenessActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFace(String str) {
    }

    @Override // com.baidu.idl.face.platform.ui.FaceLivenessActivity, com.baidu.idl.face.platform.ILivenessStrategyCallback
    public void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i4) {
        super.onLivenessCompletion(faceStatusNewEnum, str, hashMap, hashMap2, i4);
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

    @Override // com.baidu.idl.face.platform.ui.widget.TimeoutDialog.OnTimeoutDialogClickListener
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

    @Override // com.baidu.idl.face.platform.ui.widget.TimeoutDialog.OnTimeoutDialogClickListener
    public void onReturn() {
        TimeoutDialog timeoutDialog = this.mTimeoutDialog;
        if (timeoutDialog != null) {
            timeoutDialog.dismiss();
            this.mHasShownTimeoutDialog = false;
        }
        finish();
    }
}
