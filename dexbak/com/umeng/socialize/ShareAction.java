package com.umeng.socialize;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.shareboard.ShareBoard;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ShareAction {

    /* renamed from: b */
    private SHARE_MEDIA f39248b;

    /* renamed from: c */
    private UMShareListener f39249c;

    /* renamed from: d */
    private ShareBoardlistener f39250d;

    /* renamed from: e */
    private Activity f39251e;

    /* renamed from: f */
    private List<SHARE_MEDIA> f39252f;

    /* renamed from: k */
    private View f39257k;

    /* renamed from: l */
    private boolean f39258l;

    /* renamed from: m */
    private ShareBoard f39259m;

    /* renamed from: a */
    private ShareContent f39247a = new ShareContent();

    /* renamed from: g */
    private final List<SnsPlatform> f39253g = new ArrayList();

    /* renamed from: h */
    private List<ShareContent> f39254h = new ArrayList();

    /* renamed from: i */
    private List<UMShareListener> f39255i = new ArrayList();

    /* renamed from: j */
    private int f39256j = 80;

    /* renamed from: n */
    private ShareBoardlistener f39260n = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.1
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    /* renamed from: o */
    private ShareBoardlistener f39261o = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.2
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareContent shareContent;
            int indexOf = ShareAction.this.f39252f.indexOf(share_media);
            int size = ShareAction.this.f39254h.size();
            if (size != 0) {
                if (indexOf < size) {
                    shareContent = (ShareContent) ShareAction.this.f39254h.get(indexOf);
                } else {
                    shareContent = (ShareContent) ShareAction.this.f39254h.get(size - 1);
                }
                ShareAction.this.f39247a = shareContent;
            }
            int size2 = ShareAction.this.f39255i.size();
            if (size2 != 0) {
                if (indexOf < size2) {
                    ShareAction shareAction = ShareAction.this;
                    shareAction.f39249c = (UMShareListener) shareAction.f39255i.get(indexOf);
                } else {
                    ShareAction shareAction2 = ShareAction.this;
                    shareAction2.f39249c = (UMShareListener) shareAction2.f39255i.get(size2 - 1);
                }
            }
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.f39251e = (Activity) new WeakReference(activity).get();
        }
    }

    public static Rect locateView(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return null;
        }
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            int i = iArr[0];
            rect.left = i;
            rect.top = iArr[1];
            rect.right = i + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        } catch (NullPointerException e) {
            SLog.error(e);
            return null;
        }
    }

    public ShareAction addButton(String str, String str2, String str3, String str4) {
        this.f39253g.add(SHARE_MEDIA.createSnsPlatform(str, str2, str3, str4, 0));
        return this;
    }

    public ShareAction bySystem() {
        this.f39258l = true;
        return this;
    }

    public void close() {
        ShareBoard shareBoard = this.f39259m;
        if (shareBoard != null) {
            shareBoard.dismiss();
            this.f39259m = null;
        }
    }

    public SHARE_MEDIA getPlatform() {
        return this.f39248b;
    }

    public ShareContent getShareContent() {
        return this.f39247a;
    }

    public boolean getUrlValid() {
        UMediaObject uMediaObject;
        ShareContent shareContent = this.f39247a;
        return shareContent == null || (uMediaObject = shareContent.mMedia) == null || !(uMediaObject instanceof UMWeb) || uMediaObject.toUrl() == null || this.f39247a.mMedia.toUrl().startsWith(IDataSource.f43971a);
    }

    public void open(ShareBoardConfig shareBoardConfig) {
        if (CommonUtil.isSilentMode(this.f39251e)) {
            return;
        }
        if (this.f39253g.size() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("listener", this.f39249c);
            hashMap.put("content", this.f39247a);
            try {
                ShareBoard shareBoard = new ShareBoard(this.f39251e, this.f39253g, shareBoardConfig);
                this.f39259m = shareBoard;
                ShareBoardlistener shareBoardlistener = this.f39250d;
                if (shareBoardlistener == null) {
                    shareBoard.setShareBoardlistener(this.f39261o);
                } else {
                    shareBoard.setShareBoardlistener(shareBoardlistener);
                }
                this.f39259m.setFocusable(true);
                this.f39259m.setBackgroundDrawable(new BitmapDrawable());
                if (this.f39257k == null) {
                    this.f39257k = this.f39251e.getWindow().getDecorView();
                }
                this.f39259m.showAtLocation(this.f39257k, this.f39256j, 0, 0);
                return;
            } catch (Exception e) {
                SLog.error(e);
                return;
            }
        }
        this.f39253g.add(SHARE_MEDIA.WEIXIN.toSnsPlatform());
        this.f39253g.add(SHARE_MEDIA.WEIXIN_CIRCLE.toSnsPlatform());
        this.f39253g.add(SHARE_MEDIA.SINA.toSnsPlatform());
        this.f39253g.add(SHARE_MEDIA.QQ.toSnsPlatform());
        this.f39253g.add(SHARE_MEDIA.DINGTALK.toSnsPlatform());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("listener", this.f39249c);
        hashMap2.put("content", this.f39247a);
        ShareBoard shareBoard2 = new ShareBoard(this.f39251e, this.f39253g, shareBoardConfig);
        this.f39259m = shareBoard2;
        ShareBoardlistener shareBoardlistener2 = this.f39250d;
        if (shareBoardlistener2 == null) {
            shareBoard2.setShareBoardlistener(this.f39260n);
        } else {
            shareBoard2.setShareBoardlistener(shareBoardlistener2);
        }
        this.f39259m.setFocusable(true);
        this.f39259m.setBackgroundDrawable(new BitmapDrawable());
        if (this.f39257k == null) {
            this.f39257k = this.f39251e.getWindow().getDecorView();
        }
        this.f39259m.showAtLocation(this.f39257k, 80, 0, 0);
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.f39249c = uMShareListener;
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr != null && Arrays.asList(shareContentArr).size() != 0) {
            this.f39254h = Arrays.asList(shareContentArr);
        } else {
            ShareContent shareContent = new ShareContent();
            shareContent.mText = "empty";
            this.f39254h.add(shareContent);
        }
        return this;
    }

    public ShareAction setDisplayList(SHARE_MEDIA... share_mediaArr) {
        this.f39252f = Arrays.asList(share_mediaArr);
        this.f39253g.clear();
        for (SHARE_MEDIA share_media : this.f39252f) {
            this.f39253g.add(share_media.toSnsPlatform());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.f39255i = Arrays.asList(uMShareListenerArr);
        return this;
    }

    public ShareAction setPlatform(SHARE_MEDIA share_media) {
        this.f39248b = share_media;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.f39247a = shareContent;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.f39250d = shareBoardlistener;
        return this;
    }

    public void share() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f39251e);
        if (uMShareAPI != null) {
            ShareContent shareContent = getShareContent();
            if (shareContent != null) {
                shareContent.bySystem = this.f39258l;
            }
            uMShareAPI.doShare(this.f39251e, this, this.f39249c);
        }
    }

    public ShareAction withApp(File file) {
        this.f39247a.app = file;
        return this;
    }

    public ShareAction withExtra(UMImage uMImage) {
        this.f39247a.mExtra = uMImage;
        return this;
    }

    public ShareAction withFile(File file) {
        this.f39247a.file = file;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.f39247a.mFollow = str;
        return this;
    }

    public ShareAction withMedia(UMImage uMImage) {
        this.f39247a.mMedia = uMImage;
        return this;
    }

    public ShareAction withMedias(UMImage... uMImageArr) {
        if (uMImageArr != null && uMImageArr.length > 0) {
            this.f39247a.mMedia = uMImageArr[0];
        }
        this.f39247a.mMedias = uMImageArr;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i) {
        this.f39256j = i;
        this.f39257k = view;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.f39247a.subject = str;
        return this;
    }

    public ShareAction withText(String str) {
        this.f39247a.mText = str;
        return this;
    }

    public ShareAction withMedia(UMMin uMMin) {
        this.f39247a.mMedia = uMMin;
        return this;
    }

    public ShareAction withMedia(UMQQMini uMQQMini) {
        this.f39247a.mMedia = uMQQMini;
        return this;
    }

    public ShareAction withMedia(UMEmoji uMEmoji) {
        this.f39247a.mMedia = uMEmoji;
        return this;
    }

    public ShareAction withMedias(UMVideo... uMVideoArr) {
        if (uMVideoArr != null && uMVideoArr.length > 0) {
            this.f39247a.mMedia = uMVideoArr[0];
        }
        this.f39247a.Video_mMedias = uMVideoArr;
        return this;
    }

    public ShareAction withMedia(UMWeb uMWeb) {
        this.f39247a.mMedia = uMWeb;
        return this;
    }

    public ShareAction withMedia(UMusic uMusic) {
        this.f39247a.mMedia = uMusic;
        return this;
    }

    public ShareAction withMedia(UMVideo uMVideo) {
        this.f39247a.mMedia = uMVideo;
        return this;
    }

    public void open() {
        open(null);
    }
}
