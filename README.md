<div align="center">

# curve-gdx

[![stability-beta](https://img.shields.io/badge/stability-beta-33bbff.svg)](https://github.com/mkenney/software-guides/blob/master/STABILITY-BADGES.md#beta)
[![](https://jitpack.io/v/JVMFrog/curve-gdx.svg)](https://jitpack.io/#JVMFrog/curve-gdx)

<h3>curve-gdx is a libgdx extension library :D</h2>
</div>

## Gradle

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
    ext {
        //...
        curvegdx = 'com.github.JVMFrog.curve-gdx'
        curvegdxVersion = 'VERSION'
    }
}
```

Add the dependency to modules:

```groovy
//...
project(":core") {
    dependencies {
        //...
        implementation "$curvegdx:core:$curvegdxVersion"
    }
}
//...
project(":android") {
    dependencies {
        //...
        implementation "$curvegdx:androidBackend:$curvegdxVersion"
    }
}
//...
project(":desktop") {
    dependencies {
        //...
        implementation "$curvegdx:desktopBackend:$curvegdxVersion"
    }
}
```

## Examples

You can find examples for curve-gdx [here](examples#readme)

### [CONTRIBUTING.md](docs/CONTRIBUTING.md)
