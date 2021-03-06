# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/steve/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-dontobfuscate
-dontoptimize
-dontpreverify

-ignorewarnings

-keep class org.stevesea.**
-keepclassmembers class org.stevesea.** { *; }

# make crashlytics reports more meaningful
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**


-keep class org.codehaus.groovy.vmplugin.**
-keep class org.codehaus.groovy.runtime.dgm*
-keep class org.codehaus.groovy.util.**
-keep class org.codehaus.groovy.runtime.**
-keep class org.codehaus.groovy.reflection.**
-keep class org.codehaus.groovy.control.**

-keepclassmembers class org.codehaus.groovy.util.** {  *; }
-keepclassmembers class org.codehaus.groovy.runtime.dgm* { *; }
-keepclassmembers class ** implements org.codehaus.groovy.runtime.GeneratedClosure { *; }
-keepclassmembers class org.codehaus.groovy.reflection.** { *;}
-keepclassmembers class org.codehaus.groovy.runtime.** { *; }
-keepclassmembers class org.codehaus.groovy.control.SourceUnit { *; }

-keep class groovy.lang.** { *; }

-dontwarn org.codehaus.groovy.**
-dontwarn groovy**

-keep class android.support.v7.widget.SearchView { *; }
