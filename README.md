Sample project with examples for <a href="https://github.com/MaxonRash/openweathermap-sdk">OpenWeatherMapSDK</a>

Note: to be able to use dependency GitHub requires a private key to be set in `settings.xml` in your maven directory. On Windows OS it should be something like this - `C:\Users\username\.m2`. Content:
```xml
<settings>
<servers>
    <server>
        <id>github</id>
	<username>{your_username}</username>
	<password>{your_private_key}</password>
    </server>
</servers>
</settings>
```

To be able to see hints from source java docs you should download <a href="https://github.com/MaxonRash/openweathermap-sdk">source</a> project and select the folder as sources in your IDE

Also, there is some logging present in SDK, so it should be easier to test and understand what's going on during execution