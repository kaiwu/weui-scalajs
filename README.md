[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-0.6.17.svg)](https://www.scala-js.org)

# WeApp meets Scala.js

By implementing [WeUI demo](https://github.com/Tencent/weui-wxss/), this project is a POC that [WeChat App](https://github.com/Wechat-Group/awesome-wechat-weapp)
can be implemented with [Scala.js](https://www.scala-js.org/) and [SBT](https://www.scala-sbt.org/), specifically,
it uses the Scala.js plugin to compile Scala sources and [sbt-less](https://github.com/sbt/sbt-less#sbt-less) to compile style sources.

A few motivations behind the project :

1. Enjoy the Scala ecosystem !
2. Avoid `this` and `that` of JavaScript and all of its hells and pitfalls, Scala causes much less hassles.
3. [WePY](https://tencent.github.io/wepy/), the Tencent backed framework, only created extra boilerplates.

Following is a typical array of asynchronous calls, written in Scala way

```Scala
def onLoad(): Unit = {
  val info = for {
    msg  <- Wechat.login{}
    info <- Wechat.getUserInfo(false,"en"){}
  } yield info

  Wechat.setData("userInfo", info)
}

```
## How to use

```
sbt > assets
sbt > fullOptJS
```

Then use [WeApp Development Tool](https://mp.weixin.qq.com/debug/wxadoc/dev/devtools/download.html) to open the `target` directory.
Under WeApp circumstances it makes no sense to do `fastOptJS`, since `fullOptJS` generates highly optimized JavaScript already,
these options will need to be turned **OFF** from the project's settings:

 - convert Es6 to Es5
 - autocomplete on upload
 - compress on upload

Each page is built as a separate sbt project, so one can always use the project specific sbt tasks, for example

```
sbt > progress/fullOptJS
sbt > images/assets
```

## Caveats

### Component

Scala.js supports component based development, as illustrated by page `example/component/component`, if a component is written in Javascript
it can be used directly in pages. If a component is written in Scala.js and it defines custom event, be careful to resolve the needed handlers
from `onReady` of Pages instead of `methods` of Components, because Scala.js cannot (for the good) declare a magic `this`, which is a major
sources of mystery of Javascript

### Facade

For demo purpose, it does not complete the entire WeApp [facade](https://mp.weixin.qq.com/debug/wxadoc/dev/api/), nevertheless,
this work is straightforward and could be supplemented as WeApp itself is evolving.

### SBT

SBT is [hard](http://www.lihaoyi.com/post/SowhatswrongwithSBT.html)

### Less

To use `Less` and the sbt plugin, all the secondary component files are prefixed with underscore, such as `_weui.wxss`

### Others

Scala.js compiler keeps bundling those Javascript sources in the webjar, which will be picked up and loaded by WeApp. Since WeApp requires the size be less than 2M, we can simply remove the unneeded `classes` folders. You can use the `cleanup.sh` script directly.

```
project $ ./cleanup.sh
```

## License

[MIT](http://opensource.org/licenses/MIT)
