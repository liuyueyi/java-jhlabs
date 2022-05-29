jhlabs
---
<a href="https://blog.hhui.top" target="_blank">
    <img src="https://img.shields.io/badge/-微信关注“一灰灰blog”公众号-orange.svg" alt="#" align="right">
</a>

[![JitPack](https://jitpack.io/v/liuyueyi/java-jhlabs.svg)](https://jitpack.io/#liuyueyi/java-jhlabs)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/liuyueyi/java-jhlabs.svg)](http://isitmaintained.com/project/liuyueyi/java-jhlabs "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/liuyueyi/java-jhlabs.svg)](http://isitmaintained.com/project/liuyueyi/java-jhlabs "Percentage of issues still open")


the source code from [http://www.jhlabs.com/ip/filters/index.html](http://www.jhlabs.com/ip/filters/index.html)

this repository just for build jar by jetpack

## Adding jhlabs to your build

jhlabs’s source group id is `com.jhlabs` and its artifact ID is `jhlabs-filters`, the min jdk version is `jdk1.5`

the newest version is `1.0`, use it to replace version bellow

To add a dependency on jhlabs using Maven by jitpack, use the following:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.liuyueyi</groupId>
    <artifactId>java-jhlabs</artifactId>
    <!-- replace by newest version  -->
    <version>1.0</version>
</dependency>
```

gradle like this

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
        implementation 'com.github.liuyueyi:java-jhlabs:1.0'
}
```


## use case

### 1. image to sketch

code: [Img2SketchTest](src/test/java/com/jhlabs/test/Img2SketchTest.java)
output:

| input                                               | output                                      |
|-----------------------------------------------------|---------------------------------------------|
| <img src="src/test/resources/photo.jpg?raw=true">   | <img src="assets/img/photo.png?raw=true">   | 
| <img src="src/test/resources/cartoon.jpg?raw=true"> | <img src="assets/img/cartoon.png?raw=true"> | 