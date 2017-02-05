 -keepclassmembers class com.dom925.xxxx {
   public *;
}

-dontwarn com.android.**
   -keepattributes Signature
   -keepattributes Exceptions
   -keep class com.android.support.v7.** { *; }
   -dontwarn com.android.support.v7.**
   -keep class org.apache.http.** { *; }
   -keep class org.apache.james.mime4j.** { *; }
   -keep class javax.inject.** { *; }
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**
   -keepattributes *Annotation*
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}








