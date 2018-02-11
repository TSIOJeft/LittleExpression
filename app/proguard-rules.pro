# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-printmapping proguardMapping.txt
-optimizations !code/simplification/cast,!field/*,!class/merging/*
-keepattributes *Annotation*,InnerClasses
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable


-dontwarn okhttp3.**
-keep class okhttp3.** { *;}
-keep interface okhttp3.** { *; }
-dontwarn okio.**

# 如果你需要兼容6.0系统，请不要混淆org.apache.http.legacy.jar
-dontwarn android.net.compatibility.**
-dontwarn android.net.http.**
-dontwarn com.android.internal.http.multipart.**
-dontwarn org.apache.commons.**
-dontwarn org.apache.http.**
-keep class org.apache.http.**{*;}
-keep class android.net.compatibility.**{*;}
-keep class android.net.http.**{*;}
-keep class com.android.internal.http.multipart.**{*;}
-keep class org.apache.commons.**{*;}

# 保持native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# Retrolambda ，去除Lambda表达式的警告
-dontwarn java.lang.invoke.*

#去掉不影响程序的代码
-assumenosideeffects class **{*;}

#MD设置类
-keep class rikka.materialpreference.**{*;}
-keep class android.support.v7.preference.** {*;}

#包含有类名->混淆后类名的映射关系
#-verbose

#不做预校验
#-dontpreverify

#优化时允许访问并修改有修饰符的类和类的成员
-allowaccessmodification

-optimizations !code/simplification/cast,!field/*,!class/merging/*