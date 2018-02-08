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

### setData

`Wechat.setData` does NOT write `this.data`, it simply writes data to the view layer asynchronously.
First of all it is trivial enough to update `this.data` anytime, secondly, the side effect might not always be the needed.

### Facade

For demo purpose, it does not complete the entire WeApp [facade](https://mp.weixin.qq.com/debug/wxadoc/dev/api/), nevertheless,
this work is straightforward and could be supplemented as WeApp itself is evolving.

### SBT

SBT is [hard](http://www.lihaoyi.com/post/SowhatswrongwithSBT.html) and slow. I have to say it again, SBT IS SLOW.

### Less

To use `Less` and the sbt plugin, all the secondary component files are prefixed with underscore, such as `_weui.wxss`

### External library

This demo illustrates an easy approach to add an external Javascript library, the [PouchDB](https://pouchdb.com/).
However, Scala.js compiler keeps bundling those Javascript sources in the webjar, which will be picked up and loaded by WeApp. Since WeApp requires the size be less than 2M, we can simply remove the unneeded `classes` folders.

```
project $ find target/ -name classes -print | xargs rm -rf
```

## License

[The MIT License](http://opensource.org/licenses/MIT)
