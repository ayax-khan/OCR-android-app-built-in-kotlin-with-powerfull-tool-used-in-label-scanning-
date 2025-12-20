# 🔧 Troubleshooting Guide - APK Build

## If Build Fails

### 1. **"Unresolved reference: kapt"**
**Solution**: Make sure both modules have `kotlin.kapt` plugin:
```kotlin
plugins { 
    // ... other plugins ...
    alias(libs.plugins.kotlin.kapt) 
}
```

### 2. **"Kapt currently doesn't support language version 2.0+"**
This is just a WARNING - not an error. It will fall back to 1.9 automatically.

### 3. **Memory Issues During Build**
Increase heap size in `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx8g -Dfile.encoding=UTF-8
```

### 4. **Build Hangs or Takes Too Long**
Try clean build:
```bash
.\gradlew.bat clean assembleDebug --no-daemon
```

### 5. **"Compilation error" with cryptic messages**
Check full error log:
```bash
.\gradlew.bat assembleDebug --stacktrace
```

---

## Quick Build Commands

### Fast Debug Build
```bash
.\gradlew.bat assembleDebug --no-daemon
```

### Full Build with Cleanup
```bash
.\gradlew.bat clean build
```

### Build Only App Module
```bash
.\gradlew.bat app:assembleDebug
```

### Check Gradle Status
```bash
.\gradlew.bat --version
```

### Stop All Gradle Daemons
```bash
.\gradlew.bat --stop
```

---

## Expected Build Output

**Successful Build**:
```
BUILD SUCCESSFUL in Xs
123 actionable tasks: 123 executed
```

**APK Location**:
- Debug: `app/build/outputs/apk/debug/app-debug.apk`
- Release: `app/build/outputs/apk/release/app-release-unsigned.apk`

---

## Verify APK Was Created

```powershell
# Check file exists
Test-Path "D:\app\app\build\outputs\apk\debug\app-debug.apk"

# Show file size
Get-Item "D:\app\app\build\outputs\apk\debug\app-debug.apk" | Select-Object Name, @{Name="Size";Expression={[math]::Round($_.Length/1MB,2)}}

# List all APKs
Get-ChildItem "D:\app\app\build\outputs\apk\**\*.apk" -Recurse
```

---

## Install APK on Device

### Via ADB (Recommended)
```bash
adb install -r app\build\outputs\apk\debug\app-debug.apk
```

### Uninstall Previous Version
```bash
adb uninstall com.buy2enjoy.returnscanner
```

### Reinstall Fresh
```bash
adb uninstall com.buy2enjoy.returnscanner
adb install app\build\outputs\apk\debug\app-debug.apk
```

---

## Common Issues Fixed ✅

| Issue | Fix | Status |
|-------|-----|--------|
| Missing kapt plugin | Added to build.gradle.kts | ✅ Fixed |
| Unresolved Hilt references | Added hilt dependencies | ✅ Fixed |
| Coroutine scope issues | Added rememberCoroutineScope | ✅ Fixed |
| Missing imports | Added kotlinx.coroutines | ✅ Fixed |

---

## Module Dependencies Added

### feature-detail
- ✅ `hilt-android`
- ✅ `hilt-compiler` (kapt)
- ✅ `hilt-navigation-compose`
- ✅ `lifecycle-viewmodel-compose`
- ✅ `lifecycle-runtime-ktx`
- ✅ `activity-compose`

### feature-export
- ✅ `coroutines-core`
- ✅ `hilt-compiler` (kapt)

---

## Performance Tips

1. **Close other apps** - Free up RAM for build
2. **Use --no-daemon** - For isolated builds
3. **Increase heap** - Edit gradle.properties
4. **Use offline mode** - After first successful build
5. **Parallel builds** - Gradle 8.9 supports it

---

## After Successful Build

1. ✅ Test on emulator or device
2. ✅ Test all features work correctly
3. ✅ Check for crashes in logcat
4. ✅ Run automated tests
5. ✅ Sign and align for Play Store

---

## Support & Resources

- **Java 21 Docs**: https://docs.oracle.com/en/java/javase/21/
- **Gradle Docs**: https://gradle.org/
- **Kotlin Docs**: https://kotlinlang.org/docs/
- **Android Docs**: https://developer.android.com/

---

**Last Updated**: December 17, 2025  
**Java Version**: 21.0.8 LTS  
**Status**: Ready for Building ✅
