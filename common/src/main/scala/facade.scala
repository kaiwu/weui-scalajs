import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSGlobal
class App extends js.Object {
  def onLaunch(options: js.Object): Unit = js.native
  def onShow(options: js.Object): Unit = js.native
  def onHide(): Unit = js.native
  def onError(msg: String): Unit = js.native
}

@js.native
@JSGlobal
object App extends js.Object {
  def apply(o: js.Object): App = js.native
}

@js.native
@JSGlobal
class Page extends js.Object {
  def setData(o: js.Object, f: js.Function): Unit = js.native
}

@js.native
@JSGlobal
object Page extends js.Object {
  def apply(o: js.Object): Page = js.native
}

@js.native
@JSGlobalScope
object WXGlobal extends js.Object {
  def getApp(): js.Dynamic = js.native
  def getCurrentPages(): js.Array[Page] = js.native
  def setTimeout(callback: js.Function, timeout: Int): Unit = js.native
}

@js.native
@JSGlobal
class RequestTask extends js.Object {
  def abort (): Unit = js.native
}

@js.native
@JSGlobal
class SocketTask extends js.Object {
  def send (o: js.Object): Unit = js.native
  def close (o: js.Object): Unit = js.native
  def onOpen (f: js.Function): Unit = js.native
  def onClose (f: js.Function): Unit = js.native
  def onError (f: js.Function): Unit = js.native
  def onMessage (f: js.Function): Unit = js.native
}

@js.native
@JSGlobal
class RecorderManager extends js.Object {
  def start (o: js.Object): Unit = js.native
  def pause (): Unit = js.native
  def resume (): Unit = js.native
  def stop (): Unit = js.native
  def onStart (f: js.Function): Unit = js.native
  def onPause (f: js.Function): Unit = js.native
  def onStop (f: js.Function): Unit = js.native
  def onFrameRecorded (f: js.Function): Unit = js.native
  def onError (f: js.Function): Unit = js.native
}

@js.native
@JSGlobal
class BackgroundAudioManager extends js.Object {
  val duration: Int = js.native
  val currentTime: Int = js.native
  val paused: Boolean = js.native
  val src: String = js.native
  val startTime: Int = js.native
  val buffered: Int = js.native
  val title: String = js.native
  val epname: String = js.native
  val singer: String = js.native
  val coverImgUrl: String = js.native
  val webUrl: String = js.native

  def play (): Unit = js.native
  def pause (): Unit = js.native
  def stop (): Unit = js.native
  def seek (p: Int): Unit = js.native
  def onCanplay (f: js.Function): Unit = js.native
  def onPlay (f: js.Function): Unit = js.native
  def onPause (f: js.Function): Unit = js.native
  def onStop (f: js.Function): Unit = js.native
  def onEnded (f: js.Function): Unit = js.native
  def onTimeUpdate (f: js.Function): Unit = js.native
  def onPrev (f: js.Function): Unit = js.native
  def onNext (f: js.Function): Unit = js.native
  def onError (f: js.Function): Unit = js.native
  def onWaiting (f: js.Function): Unit = js.native
}

@js.native
@JSGlobal
class InnerAudioContext extends js.Object {
  val src: String = js.native
  val startTime: Int = js.native
  val autoplay: Boolean = js.native
  val loop: Boolean = js.native
  val obeyMuteSwitch: Boolean = js.native
  val duration: Int = js.native
  val currentTime: Int = js.native
  val paused: Boolean = js.native
  val buffered: Int = js.native

  def play (): Unit = js.native
  def pause (): Unit = js.native
  def stop (): Unit = js.native
  def seek (p: Int): Unit = js.native
  def destroy (): Unit = js.native
  def onCanplay (f: js.Function): Unit = js.native
  def onPlay (f: js.Function): Unit = js.native
  def onPause (f: js.Function): Unit = js.native
  def onStop (f: js.Function): Unit = js.native
  def onEnded (f: js.Function): Unit = js.native
  def onTimeUpdate (f: js.Function): Unit = js.native
  def onError (f: js.Function): Unit = js.native
  def onWaiting (f: js.Function): Unit = js.native
  def onSeeking (f: js.Function): Unit = js.native
  def onSeeked (f: js.Function): Unit = js.native
}

@js.native
@JSGlobal
class MapContext(val mapId: String) extends js.Object {
  def getCenterLocation (o: js.Object): Unit = js.native
  def translateMarker (o: js.Object): Unit = js.native
  def includePoints (o: js.Object): Unit = js.native
  def getRegion (o: js.Object): Unit = js.native
  def getScale (o: js.Object): Unit = js.native
  def moveToLocation(): Unit =js.native
}

@js.native
@JSGlobal("wx")
object wx extends js.Object {
  def request (o: js.Object): RequestTask = js.native
  def uploadFile (o: js.Object): Unit = js.native
  def downloadFile (o: js.Object): Unit = js.native
  def connectSocket (o: js.Object): SocketTask = js.native
  def onSocketOpen (f: js.Function): Unit = js.native
  def onSocketError (f: js.Function): Unit = js.native
  def sendSocketMessage (o: js.Object): Unit = js.native
  def onSocketMessage (f: js.Function): Unit = js.native
  def closeSocket (o: js.Object): Unit = js.native
  def onSocketClose (f: js.Function): Unit = js.native

  def chooseImage (o: js.Object): Unit = js.native
  def previewImage (o: js.Object): Unit = js.native
  def getImageInfo (o: js.Object): Unit = js.native
  def saveImageToPhotosAlbum (o: js.Object): Unit = js.native
  def startRecord (o: js.Object): Unit = js.native
  def stopRecord (o: js.Object): Unit = js.native
  def getRecorderManager (): RecorderManager = js.native
  def playVoice (o: js.Object): Unit = js.native
  def pauseVoice (): Unit = js.native
  def stopVoice (): Unit = js.native
  def getBackgroundAudioPlayerState (o: js.Object): Unit = js.native
  def playBackgroundAudio (o: js.Object): Unit = js.native
  def pauseBackgroundAudio (): Unit = js.native
  def seekBackgroundAudio (o: js.Object): Unit = js.native
  def stopBackgroundAudio (): Unit = js.native
  def onBackgroundAudioPlay (f: js.Function): Unit = js.native
  def onBackgroundAudioPause (f: js.Function): Unit = js.native
  def onBackgroundAudioStop (f: js.Function): Unit = js.native
  def getBackgroundAudioManager(): BackgroundAudioManager = js.native
  def createInnerAudioContext(): InnerAudioContext = js.native
  def chooseVideo (o: js.Object): Unit = js.native
  def saveVideoToPhotosAlbum (o: js.Object): Unit = js.native

  def saveFile (o: js.Object): Unit = js.native
  def getFileInfo (o: js.Object): Unit = js.native
  def getSavedFileList (o: js.Object): Unit = js.native
  def getSavedFileInfo (o: js.Object): Unit = js.native
  def removeSavedFile (o: js.Object): Unit = js.native
  def openDocument (o: js.Object): Unit = js.native

  def setStorage (o: js.Object): Unit = js.native
  def setStorageSync (key: String, data: js.Object): Unit = js.native
  def getStorage (o: js.Object): Unit = js.native
  def getStorageSync (key: String): js.UndefOr[js.Dynamic] = js.native
  def getStorageInfo (o: js.Object): Unit = js.native
  def getStorageInfoSync (): js.UndefOr[js.Dynamic] = js.native
  def removeStorage (o: js.Object): Unit = js.native
  def removeStorageSync (key: String): Unit = js.native
  def clearStorage(): Unit = js.native
  def clearStorageSync(): Unit = js.native

  def getLocation (o: js.Object): Unit = js.native
  def chooseLocation (o: js.Object): Unit = js.native
  def openLocation (o: js.Object): Unit = js.native
  def createMapContext(id: String): MapContext = js.native

  def getSystemInfo (o: js.Object): Unit = js.native
  def getSystemInfoSync (): js.UndefOr[js.Dynamic] = js.native
  def canIUse(feature: String): Boolean = js.native
  def getNetworkType (o: js.Object): Unit = js.native
  def onNextworkStatusChange (f: js.Function): Unit = js.native
  def setScreenBrightness (o: js.Object): Unit = js.native
  def getScreenBrightness (o: js.Object): Unit = js.native
  def vibrateLong (o: js.Object): Unit = js.native
  def vibrateShort (o: js.Object): Unit = js.native
  def makePhoneCall (o: js.Object): Unit = js.native
  def scanCode (o: js.Object): Unit = js.native
  def setClipboardData (o: js.Object): Unit = js.native
  def getClipboardData (o: js.Object): Unit = js.native
  def onUserCaptureScreen (f: js.Function): Unit = js.native
  def addPhoneContact(o: js.Object): Unit = js.native

  def showToast (o: js.Object): Unit = js.native
  def showLoading (o: js.Object): Unit = js.native
  def hideToast (): Unit = js.native
  def hideLoading (): Unit = js.native
  def showModal (o: js.Object): Unit = js.native
  def showActionSheet (o: js.Object): Unit = js.native

  def setNavigationBarTitle (o: js.Object): Unit = js.native
  def showNavigationBarLoading(): Unit = js.native
  def hideNavigationBarLoading(): Unit = js.native
  def setNavigationBarColor (o: js.Object): Unit = js.native

  def setTabBarBadge (o: js.Object): Unit = js.native
  def removeTabBarBadge (o: js.Object): Unit = js.native
  def showTabBarRedDot (o: js.Object): Unit = js.native
  def hideTabBarRedDot (o: js.Object): Unit = js.native
  def setTabBarStyle (o: js.Object): Unit = js.native
  def setTabBarItem (o: js.Object): Unit = js.native
  def showTabBar (o: js.Object): Unit = js.native
  def hideTabBar (o: js.Object): Unit = js.native
  def setTopBarText (o: js.Object): Unit = js.native

  def navigateTo(o: js.Object): Unit = js.native
  def redirectTo(o: js.Object): Unit = js.native
  def reLaunch(o: js.Object): Unit = js.native
  def switchTab(o: js.Object): Unit = js.native
  def navigateBack(o: js.Object): Unit = js.native

  def pageScrollTo(o: js.Object): Unit = js.native

  def login (o: js.Object): Unit = js.native
  def checkSession (o: js.Object): Unit = js.native
  def authorize (o: js.Object): Unit = js.native
  def getUserInfo (o: js.Object): Unit = js.native
  def getPhoneNumber (o: js.Object): Unit = js.native

  def showShareMenu (o: js.Object): Unit = js.native
  def hideShareMenu (o: js.Object): Unit = js.native
  def updateShareMenu (o: js.Object): Unit = js.native
  def getShareInfo (o: js.Object): Unit = js.native

  def chooseAddress (o: js.Object): Unit = js.native
  def openSetting (o: js.Object): Unit = js.native
  def getSetting (o: js.Object): Unit = js.native
  def getWeRunData (o: js.Object): Unit = js.native

  def navigateToMiniProgram (o: js.Object): Unit = js.native
  def navigateBackMiniProgram (o: js.Object): Unit = js.native
  def chooseInvoiceTitle (o: js.Object): Unit = js.native

}

@js.native
@JSGlobal
class WxTarget extends js.Object {
  val id: String = js.native
  val tagName: String = js.native
  val dataset: js.Dynamic = js.native 

  val offsetLeft: js.UndefOr[Int] = js.native
  val offsetRight: js.UndefOr[Int] = js.native
}

@js.native
@JSGlobal
class WxTouch extends js.Object {
  val identifier: Int = js.native
  val pageX: js.UndefOr[Int] = js.native
  val pageY: js.UndefOr[Int] = js.native
  val clientX: js.UndefOr[Int] = js.native
  val clientY: js.UndefOr[Int] = js.native
  val x: js.UndefOr[Int] = js.native
  val y: js.UndefOr[Int] = js.native
}

@js.native
@JSGlobal
class WxEvent extends js.Object {
  val `type`: String = js.native
  val timeStamp: Int = js.native
  val target: WxTarget = js.native
  val currentTarget: WxTarget = js.native
  val detail: js.Dynamic = js.native
  val touches: js.Array[WxTouch] = js.native
  val changedTouches: js.Array[WxTouch] = js.native
}
