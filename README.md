kivy-centili-android
====================

Kivy framework on Android with Centili library for mobile payments.
The kind of mobile payments where the user pays with their phone bill.

The original Android instructions for Centili implementation are here: 
- short version https://www.centili.com/android-library.html
- detailed instructions https://www.centili.com/manual/android/android-instructions.pdf
- one small correction about the instructions is that should go "c.mpayments...", not "c.payments...". (when including the library, for example)

Additional file is the Centili Library .jar file (CentiliLib-2.jar), which I put in a libs folder and include it with buildozer like this:
android.add_jars = %(source.dir)s/libs/*.jar

The .java file is supposed to reside in /.buildozer/android/platform/python-for-android/dist/name-of-app/src/org/myapp directory of your buildozer. The 'name-of-app' folder can be called 'default', too, I am not sure how buildozer does the naming.

Status:
This is a working example, except for the onCheckServiceAvailabilityButtonClick part in Centili.java, which I haven't put right yet, but it works without it, it seems. Have fun!
