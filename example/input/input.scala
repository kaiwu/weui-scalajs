import scala.scalajs.js
import js.Dynamic.literal

object Input extends js.Object {
  val data = literal(
    showTopTips = false,
    radioItems = js.Array(
      literal(name="cell standard", value="0"),
      literal(name="cell standard", value="1", checked = true)
    ),
    checkboxItems = js.Array( 
      literal(name="standard is dealt for u.", value="0", checked = true),
      literal(name="standard is dealicient for u.", value="1")
    ),
    date = "2016-09-01",
    time = "12:01",
    countryCodes = js.Array("+86", "+80", "+84", "+87"),
    countryCodeIndex = 0,
    countries = js.Array("中国", "美国", "英国"),
    countryIndex = 0,
    accounts = js.Array("微信号", "QQ", "Email"),
    accountIndex = 0,
    isAgree = false
  )

  def showTopTips(): Unit = {
    Wechat.setData(literal(showTopTips=true))
    val cb = () => {
      Wechat.setData(literal(showTopTips=false))
    }
    WXGlobal.setTimeout(cb,3000)
  }

  def radioChange(e: WxEvent): Unit = {
    println("radio发生change事件，携带value值为：" + e.detail.value.asInstanceOf[String])
    val choose = (i: js.Dynamic) => {
      i.checked = i.value == e.detail.value
      i
    }
    val radioItems = this.data.radioItems.map(choose)
    Wechat.setData(literal(radioItems=radioItems))
  }

  def checkboxChange(e: WxEvent): Unit = {
    val values: js.Array[String] = e.detail.value.asInstanceOf[js.Array[String]]
    println("checkbox发生change事件，携带value值为：" + values)
    val choose = (i: js.Dynamic) => {
      i.checked = values.exists(_ == i.value)
      i
    }
    val checkboxItems = this.data.checkboxItems.map(choose)
    Wechat.setData(literal(checkboxItems=checkboxItems))
  }

  def bindDateChange(e: WxEvent): Unit = {
    Wechat.setData(literal(date = e.detail.value.asInstanceOf[String]))
  }

  def bindTimeChange(e: WxEvent): Unit = {
    Wechat.setData(literal(time = e.detail.value.asInstanceOf[String]))
  }

  def bindCountryCodeChange(e: WxEvent): Unit = {
    println("picker country code 发生选择改变，携带值为：" + e.detail.value.asInstanceOf[String])
    Wechat.setData(literal(countryCodeIndex = e.detail.value.asInstanceOf[String]))
  }

  def bindCountryChange(e: WxEvent): Unit = {
    println("picker country 发生选择改变，携带值为：" + e.detail.value.asInstanceOf[String])
    Wechat.setData(literal(countryIndex = e.detail.value.asInstanceOf[String]))
  }

  def bindAccountChange(e: WxEvent): Unit = {
    println("picker account 发生选择改变，携带值为：" + e.detail.value.asInstanceOf[String])
    Wechat.setData(literal(accountIndex = e.detail.value.asInstanceOf[String]))
  }

  def bindAgreeChange(e: WxEvent): Unit = {
    val agree: js.Array[String] = e.detail.value.asInstanceOf[js.Array[String]]
    Wechat.setData(literal(isAgree = agree.length > 0))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Page(Input)
  }
}
