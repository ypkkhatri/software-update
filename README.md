# Software Update GUI Api
[![Build Status](https://travis-ci.org/ypkkhatri/software-update.svg?branch=master)](https://travis-ci.org/ypkkhatri/software-update)
Software update library for swing application

Below is the code which you need to run from your application, that will exit you current app and start `sw-update` app in new JVM  
```
public static void updateLaunch(String appName, String currentVersion, String updateXmlUrl) {
    String[] run = {"java", "-jar", "libs/sw-update-1.0.jar", appName, currentVersion, updateXmlUrl};
    try {
        Runtime.getRuntime().exec(run);
        System.exit(0);
    } catch (IOException ex) {
        LogManager.getLogger(AppUtils.class).error(ex);
    }
}
```
