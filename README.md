kivy-centili-android
====================

Kivy framework on Android with Centili library for mobile payments.
The kind of mobile payments where the user pays with their phone bill.

The original Android instructions for Centili implementation are here: 
- short version https://www.centili.com/android-library.html
- detailed instructions https://www.centili.com/manual/android/android-instructions.pdf
- one small correction about the instructions is that should go "c.mpayments...", not "c.payments...". (when including the library, for example)

Additional file is the Centili Library .jar file, which I include with Buildozer into the package. (CentiliLib-2.jar)

I need to: 
- mimic what the original Java code does, using Kivy and Pyjnius.
