## Firebase database (Insert data,fecth data,Insert picture) on android studio
### Download
First we need to create project on android studio and don't be forget put some library of firebase into dependencies of your project
```gradle
repositories {
        jcenter()
    }
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    //Adding Firebase

    compile 'com.android.support:design:22.2.0'
    compile 'com.android.support:appcompat-v7:25.1.1'
    compile 'com.google.firebase:firebase-database:10.0.1'
    compile 'com.google.firebase:firebase-storage:10.0.1'
    compile 'com.google.firebase:firebase-auth:10.0.1'
    compile 'com.firebase:firebase-client-android:2.4.0'
    compile 'com.android.support.constraint:constraint-layout:1.0.2'
    compile 'com.github.bumptech.glide:glide:3.7.0'
    testCompile 'junit:junit:4.12'
}
```
when you finish install firebase dependencies you will see firebase in tool menu on android studio.
### Set imge with Glide
You can check this library and example for this https://github.com/bumptech/glide