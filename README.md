# Software Update GUI API
[![Build Status](https://travis-ci.org/ypkkhatri/software-update.svg?branch=master)](https://travis-ci.org/ypkkhatri/software-update)

Software update library for swing application

## File Structure
```
update/
      update.xml
      main.jar
      test1.jar
      test2.jar
```

Put version files into server and dependencies in `libs` folder at server with below XML file `update.xml` 
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE appudpate>

<update>
    <version>1.0</version>
    <main-file>main.jar</main-file>
    <dependencies>
        <dependency>test1.jar</dependency>
        <dependency>test2.jar</dependency>
    </dependencies>
</update>
```

Below is the code which you need to run from your application, that will exit you current app and start `sw-update` app in new JVM
`AppUtil.java`
```
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppUtils { 
    public static void updateLaunch(String appName, String currentVersion, String updateXmlUrl) {
        String[] run = {"java", "-jar", "libs/sw-update-1.0.jar", appName, currentVersion, updateXmlUrl};
        try {
            Runtime.getRuntime().exec(run);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
```

```
AppUtils.updateLaunch("Your App Name", "0.1", "http://localhost/update/update.xml");
```
