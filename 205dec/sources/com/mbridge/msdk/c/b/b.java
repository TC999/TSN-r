package com.mbridge.msdk.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;

/* compiled from: MraidJSController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38728a = "/iphone|mac|ipad|ipod/i.test(window.navigator.userAgent.toLowerCase())&&(console={},console.log=function(e){var t=document.createElement(\"iframe\");t.setAttribute(\"src\",\"ios-log: \"+e),document.documentElement.appendChild(t),t.parentNode.removeChild(t),t=null},console.debug=console.info=console.warn=console.error=console.log),function(){var e=window.mraid={},t=window.navigator.userAgent.toLowerCase(),n=/iphone|mac|ipad|ipod/i.test(t),r=/android/i.test(t),i=window.mraidbridge={nativeSDKFiredReady:!1,nativeCallQueue:[],nativeCallInFlight:!1,lastSizeChangeProperties:null};function o(e){var t,i;N(s.INFO,\"\u975a\ufffd\ufffd\u9342\ufffd\u4cae\u761c\ufffd:\"+e),n?(t=e,(i=document.createElement(\"iframe\")).setAttribute(\"frameborder\",\"0\"),i.style.cssText=\"width:0;height:0;border:0;display:none;\",i.setAttribute(\"src\",t),setTimeout(function(){document.body.appendChild(i)},5)):r&&window.prompt(e,\"mraid:\")}i.fireChangeEvent=function(e){for(var t in e){if(e.hasOwnProperty(t))(0,A[t])(e[t])}},i.nativeCallComplete=function(e){0!==this.nativeCallQueue.length?o(this.nativeCallQueue.pop()):this.nativeCallInFlight=!1},i.executeNativeCall=function(e){var t=e.shift();if(!this.nativeSDKFiredReady)return console.log(\"rejecting \"+t+\" because mraid is not ready\"),void i.notifyErrorEvent(\"mraid is not ready\",t);for(var n,r,a=\"mraid://\"+t,s=!0,u=0;u<e.length;u+=2)n=e[u],null!==(r=e[u+1])&&(s?(a+=\"?\",s=!1):a+=\"&\",a+=encodeURIComponent(n)+\"=\"+encodeURIComponent(r));this.nativeCallInFlight?this.nativeCallQueue.push(a):(this.nativeCallInFlight=!0,o(a))},i.setCurrentPosition=function(e,t,n,r){d={x:e,y:t,width:n,height:r},N(s.INFO,\"Set current position to \"+I(d))},i.setDefaultPosition=function(e,t,n,r){g={x:e,y:t,width:n,height:r},N(s.INFO,\"Set default position to \"+I(g))},i.setMaxSize=function(e,t){p={width:e,height:t},h.width=e,h.height=t,N(s.INFO,\"Set max size to \"+I(p))},i.setPlacementType=function(e){w=e,N(s.INFO,\"Set placement type to \"+I(w))},i.setScreenSize=function(e,t){m={width:e,height:t},N(s.INFO,\"Set screen size to \"+I(m))},i.setState=function(e){y=e,N(s.INFO,\"Set state to \"+I(y)),N(s.STATECHANGE,y)},i.setIsViewable=function(e){O=e,N(s.INFO,\"Set isViewable to \"+I(O)),N(s.VIEWABLECHANGE,O)},i.setSupports=function(e,t,n,r,i){f={sms:e,tel:t,calendar:n,storePicture:r,inlineVideo:i}},i.notifyReadyEvent=function(){this.nativeSDKFiredReady=!0,N(s.READY)},i.notifyErrorEvent=function(e,t){N(s.ERROR,e,t)},i.fireReadyEvent=i.notifyReadyEvent,i.fireErrorEvent=i.notifyErrorEvent,i.notifySizeChangeEvent=function(e,t){this.lastSizeChangeProperties&&e==this.lastSizeChangeProperties.width&&t==this.lastSizeChangeProperties.height||(this.lastSizeChangeProperties={width:e,height:t},N(s.SIZECHANGE,e,t))},i.notifyStateChangeEvent=function(){y===a.LOADING&&N(s.INFO,\"Native SDK initialized.\"),N(s.INFO,\"Set state to \"+I(y)),N(s.STATECHANGE,y)},i.notifyViewableChangeEvent=function(){N(s.INFO,\"Set isViewable to \"+I(O)),N(s.VIEWABLECHANGE,O)},i.audioVolumeChange=function(e){R=e,N(s.INFO,\"Set audioVolumeChange to \"+I(e)),N(s.AUDIOVOLUMECHANGE,R)};e.VERSION=\"3.0\";var a=e.STATES={LOADING:\"loading\",DEFAULT:\"default\",EXPANDED:\"expanded\",HIDDEN:\"hidden\",RESIZED:\"resized\"},s=e.EVENTS={ERROR:\"error\",INFO:\"info\",READY:\"ready\",STATECHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\",SIZECHANGE:\"sizeChange\",AUDIOVOLUMECHANGE:\"audioVolumeChange\"},u=e.PLACEMENT_TYPES={UNKNOWN:\"unknown\",INLINE:\"inline\",INTERSTITIAL:\"interstitial\"},h={width:!1,height:!1,useCustomClose:!1,isModal:!0},l={width:!1,height:!1,offsetX:!1,offsetY:!1,customClosePosition:\"top-right\",allowOffscreen:!0},c={allowOrientationChange:!0,forceOrientation:\"none\"},f={sms:!1,tel:!1,calendar:!1,storePicture:!1,inlineVideo:!1},p={},d={},g={},m={},v={},E={},R=\"\",y=a.LOADING,O=!1,w=u.UNKNOWN,C={major:0,minor:0,patch:0},N=function(){for(var e=new Array(arguments.length),t=arguments.length,n=0;n<t;n++)e[n]=arguments[n];var r=e.shift();v[r]&&v[r].broadcast(e)},S=function(e,t){for(var n in t)if(t[n]===e)return!0;return!1},I=function(e){if(\"object\"==typeof e){var t=[];if(e.push){for(var n in e)t.push(e[n]);return\"[\"+t.join(\",\")+\"]\"}for(var n in e)t.push(\"'\"+n+\"': \"+e[n]);return\"{\"+t.join(\",\")+\"}\"}return String(e)},A={state:function(e){y===a.LOADING&&N(s.INFO,\"Native SDK initialized.\"),y=e,N(s.INFO,\"Set state to \"+I(e)),N(s.STATECHANGE,y)},viewable:function(e){O=e,N(s.INFO,\"Set isViewable to \"+I(e)),N(s.VIEWABLECHANGE,O)},placementType:function(e){N(s.INFO,\"Set placementType to \"+I(e)),w=e},sizeChange:function(e){for(var t in N(s.INFO,\"Set screenSize to \"+I(e)),e)e.hasOwnProperty(t)&&(m[t]=e[t])},currentAppOrientation:function(e,t){E={orientation:e,locked:t},N(s.INFO,\"Set app orientation to \"+I(E))},supports:function(e){N(s.INFO,\"Set supports to \"+I(e)),f=e},hostSDKVersion:function(e){var t=e.split(\".\").map(function(e){return parseInt(e,10)}).filter(function(e){return e>=0});t.length>=3&&(C.major=parseInt(t[0],10),C.minor=parseInt(t[1],10),C.patch=parseInt(t[2],10),N(s.INFO,\"Set hostSDKVersion to \"+I(C)))}},P=function(e,t,n,r){if(!r){if(null===e)return N(s.ERROR,\"Required object not provided.\",n),!1;for(var i in t)if(t.hasOwnProperty(i)&&void 0===e[i])return N(s.ERROR,\"Object is missing required property: \"+i,n),!1}for(var o in e){var a=t[o],u=e[o];if(a&&!a(u))return N(s.ERROR,\"Value of property \"+o+\" is invalid: \"+u,n),!1}return!0},b={useCustomClose:function(e){return\"boolean\"==typeof e}};e.addEventListener=function(t,n){t&&n?S(t,s)?(v[t]||(v[t]=new function(t){this.event=t,this.count=0;var n={};this.add=function(e){var t=String(e);n[t]||(n[t]=e,this.count++)},this.remove=function(e){var t=String(e);return!!n[t]&&(n[t]=null,delete n[t],this.count--,!0)},this.removeAll=function(){for(var e in n)n.hasOwnProperty(e)&&this.remove(n[e])},this.broadcast=function(t){for(var r in n)n.hasOwnProperty(r)&&n[r].apply(e,t)},this.toString=function(){var e=[t,\":\"];for(var r in n)n.hasOwnProperty(r)&&e.push(\"|\",r,\"|\");return e.join(\"\")}}(t)),v[t].add(n)):N(s.ERROR,\"Unknown MRAID event: \"+t,\"addEventListener\"):N(s.ERROR,\"Both event and listener are required.\",\"addEventListener\")},e.close=function(){y===a.HIDDEN?N(s.ERROR,\"Ad cannot be closed when it is already hidden.\",\"close\"):i.executeNativeCall([\"close\"])},e.unload=function(){y===a.EXPANDED?N(s.ERROR,\"Ad cannot be unload when it is already EXPANDED.\",\"close\"):i.executeNativeCall([\"unload\"])},e.expand=function(e){if(this.getState()!==a.DEFAULT&&this.getState()!==a.RESIZED)N(s.ERROR,\"Ad can only be expanded from the default or resized state.\",\"expand\");else{var t=[\"expand\",\"shouldUseCustomClose\",!1];e&&(t=t.concat([\"url\",e])),i.executeNativeCall(t)}},e.getExpandProperties=function(){return{width:h.width,height:h.height,useCustomClose:h.useCustomClose,isModal:h.isModal}},e.getCurrentPosition=function(){return{x:d.x,y:d.y,width:d.width,height:d.height}},e.getDefaultPosition=function(){return{x:g.x,y:g.y,width:g.width,height:g.height}},e.getMaxSize=function(){return{width:p.width,height:p.height}},e.getPlacementType=function(){return w},e.getScreenSize=function(){return{width:m.width,height:m.height}},e.getState=function(){return y},e.isViewable=function(){return O},e.getVersion=function(){return e.VERSION},e.getCurrentAppOrientation=function(){return{orientation:E.orientation,locked:E.locked}},e.getAudioVolume=function(){return R},e.open=function(e){e?i.executeNativeCall([\"open\",\"url\",e]):N(s.ERROR,\"URL is required.\",\"open\")},e.removeEventListener=function(e,t){if(e){if(t){var n=!1;if(v[e]&&(n=v[e].remove(t)),!n)return void N(s.ERROR,\"Listener not currently registered for event.\",\"removeEventListener\")}else!t&&v[e]&&v[e].removeAll();v[e]&&0===v[e].count&&(v[e]=null,delete v[e])}else N(s.ERROR,\"Event is required.\",\"removeEventListener\")},e.setExpandProperties=function(e){P(e,b,\"setExpandProperties\",!0)&&e.hasOwnProperty(\"useCustomClose\")&&(h.useCustomClose=!1)},e.useCustomClose=function(e){},e.createCalendarEvent=function(e){D.initialize(e),D.parse()?i.executeNativeCall(D.arguments):N(s.ERROR,D.errors[0],\"createCalendarEvent\")},e.supports=function(e){return f[e]},e.playVideo=function(t){e.isViewable()?t?i.executeNativeCall([\"playVideo\",\"uri\",t]):N(s.ERROR,\"playVideo must be called with a valid URI\",\"playVideo\"):N(s.ERROR,\"playVideo cannot be called until the ad is viewable\",\"playVideo\")},e.storePicture=function(t){e.isViewable()?t?i.executeNativeCall([\"storePicture\",\"uri\",t]):N(s.ERROR,\"storePicture must be called with a valid URI\",\"storePicture\"):N(s.ERROR,\"storePicture cannot be called until the ad is viewable\",\"storePicture\")};var V={width:function(e){return!isNaN(e)&&e>0},height:function(e){return!isNaN(e)&&e>0},offsetX:function(e){return!isNaN(e)},offsetY:function(e){return!isNaN(e)},customClosePosition:function(e){return\"string\"==typeof e&&[\"top-right\",\"bottom-right\",\"top-left\",\"bottom-left\",\"center\",\"top-center\",\"bottom-center\"].indexOf(e)>-1},allowOffscreen:function(e){return\"boolean\"==typeof e}};e.setOrientationProperties=function(e){e.hasOwnProperty(\"allowOrientationChange\")&&(c.allowOrientationChange=e.allowOrientationChange),e.hasOwnProperty(\"forceOrientation\")&&(c.forceOrientation=e.forceOrientation);var t=[\"setOrientationProperties\",\"allowOrientationChange\",c.allowOrientationChange,\"forceOrientation\",c.forceOrientation];i.executeNativeCall(t)},e.getOrientationProperties=function(){return{allowOrientationChange:c.allowOrientationChange,forceOrientation:c.forceOrientation}},e.resize=function(){if(this.getState()!==a.DEFAULT&&this.getState()!==a.RESIZED)N(s.ERROR,\"Ad can only be resized from the default or resized state.\",\"resize\");else if(l.width&&l.height){var e=[\"resize\",\"width\",l.width,\"height\",l.height,\"offsetX\",l.offsetX||0,\"offsetY\",l.offsetY||0,\"customClosePosition\",l.customClosePosition,\"allowOffscreen\",!!l.allowOffscreen];i.executeNativeCall(e)}else N(s.ERROR,\"Must set resize properties before calling resize()\",\"resize\")},e.getResizeProperties=function(){return{width:l.width,height:l.height,offsetX:l.offsetX,offsetY:l.offsetY,customClosePosition:l.customClosePosition,allowOffscreen:l.allowOffscreen}},e.setResizeProperties=function(e){if(P(e,V,\"setResizeProperties\",!0))for(var t=[\"width\",\"height\",\"offsetX\",\"offsetY\",\"customClosePosition\",\"allowOffscreen\"],n=t.length,r=0;r<n;r++){var i=t[r];e.hasOwnProperty(i)&&(l[i]=e[i])}},e.getHostSDKVersion=function(){return C};var D={initialize:function(e){this.parameters=e,this.errors=[],this.arguments=[\"createCalendarEvent\"]},parse:function(){this.parameters?(this.parseDescription(),this.parseLocation(),this.parseSummary(),this.parseStartAndEndDates(),this.parseReminder(),this.parseRecurrence(),this.parseTransparency()):this.errors.push(\"The object passed to createCalendarEvent cannot be null.\");var e=this.errors.length;return e&&(this.arguments.length=0),0===e},parseDescription:function(){this._processStringValue(\"description\")},parseLocation:function(){this._processStringValue(\"location\")},parseSummary:function(){this._processStringValue(\"summary\")},parseStartAndEndDates:function(){this._processDateValue(\"start\"),this._processDateValue(\"end\")},parseReminder:function(){var e=this._getParameter(\"reminder\");e&&(e<0?(this.arguments.push(\"relativeReminder\"),this.arguments.push(parseInt(e)/1e3)):(this.arguments.push(\"absoluteReminder\"),this.arguments.push(e)))},parseRecurrence:function(){var e=this._getParameter(\"recurrence\");e&&(this.parseRecurrenceInterval(e),this.parseRecurrenceFrequency(e),this.parseRecurrenceEndDate(e),this.parseRecurrenceArrayValue(e,\"daysInWeek\"),this.parseRecurrenceArrayValue(e,\"daysInMonth\"),this.parseRecurrenceArrayValue(e,\"daysInYear\"),this.parseRecurrenceArrayValue(e,\"monthsInYear\"))},parseTransparency:function(){if(this.parameters.hasOwnProperty(\"transparency\")){var e=this.parameters.transparency;S(e,[\"opaque\",\"transparent\"])?(this.arguments.push(\"transparency\"),this.arguments.push(e)):this.errors.push(\"transparency must be opaque or transparent\")}},parseRecurrenceArrayValue:function(e,t){if(e.hasOwnProperty(t)){var n=e[t];if(n&&n instanceof Array){var r=n.join(\",\");this.arguments.push(t),this.arguments.push(r)}else this.errors.push(t+\" must be an array.\")}},parseRecurrenceInterval:function(e){if(e.hasOwnProperty(\"interval\")){var t=e.interval;t?(this.arguments.push(\"interval\"),this.arguments.push(t)):this.errors.push(\"Recurrence interval cannot be null.\")}else this.arguments.push(\"interval\"),this.arguments.push(1)},parseRecurrenceFrequency:function(e){if(e.hasOwnProperty(\"frequency\")){var t=e.frequency;S(t,[\"daily\",\"weekly\",\"monthly\",\"yearly\"])?(this.arguments.push(\"frequency\"),this.arguments.push(t)):this.errors.push('Recurrence frequency must be one of: \"daily\", \"weekly\", \"monthly\", \"yearly\".')}},parseRecurrenceEndDate:function(e){var t=e.expires;t&&(this.arguments.push(\"expires\"),this.arguments.push(t))},_getParameter:function(e){return this.parameters.hasOwnProperty(e)?this.parameters[e]:null},_processStringValue:function(e){if(this.parameters.hasOwnProperty(e)){var t=this.parameters[e];this.arguments.push(e),this.arguments.push(t)}},_processDateValue:function(e){if(this.parameters.hasOwnProperty(e)){var t=this._getParameter(e);this.arguments.push(e),this.arguments.push(t)}}}}();".replaceAll("(?m)^\\s+", "").replaceAll("(?m)^//.*(?=\\n)", "");

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f38729b;

    /* renamed from: c  reason: collision with root package name */
    private String f38730c;

    private b() {
    }

    private String c() {
        try {
            File file = new File(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_OTHER), "mraid_js.txt");
            return (file.exists() && file.canRead()) ? v.a(file) : "";
        } catch (Exception e4) {
            x.a("MraidJSController", e4.getMessage());
            return "";
        }
    }

    public final String b() {
        try {
            if (TextUtils.isEmpty(this.f38730c)) {
                this.f38730c = c();
            }
            if (TextUtils.isEmpty(this.f38730c)) {
                com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                if (b4 != null && !TextUtils.isEmpty(b4.aR())) {
                    a(com.mbridge.msdk.foundation.controller.a.f().j(), b4.aR());
                }
                return f38728a;
            }
            return this.f38730c;
        } catch (Exception unused) {
            return f38728a;
        }
    }

    public static b a() {
        if (f38729b == null) {
            synchronized (b.class) {
                if (f38729b == null) {
                    f38729b = new b();
                }
            }
        }
        return f38729b;
    }

    public final void a(Context context, final String str) {
        if (context == null) {
            return;
        }
        String b4 = com.mbridge.msdk.foundation.a.a.a.a().b("MraidJSController");
        if (TextUtils.isEmpty(b4) || !b4.equals(str)) {
            try {
                new com.mbridge.msdk.c.a.a(context).a(0, str, (d) null, new com.mbridge.msdk.foundation.same.net.b.a() { // from class: com.mbridge.msdk.c.b.b.1
                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void a(String str2) {
                        x.a("MraidJSController", "request mraid js success, content = " + str2);
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        b.this.f38730c = str2;
                        b.b(b.this, str2);
                        com.mbridge.msdk.foundation.a.a.a.a().a("MraidJSController", str);
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void b(String str2) {
                        x.a("MraidJSController", "fail request mraid js. " + str2);
                    }
                });
            } catch (Exception e4) {
                x.d("MraidJSController", e4.getMessage());
            }
        }
    }

    static /* synthetic */ void b(b bVar, final String str) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.c.b.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    File file = new File(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_OTHER), "mraid_js.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    v.a(str.getBytes(), file);
                } catch (Exception e4) {
                    x.a("MraidJSController", e4.getMessage());
                }
            }
        }).start();
    }
}
