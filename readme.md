# JavaFX UI Controls Sample App

![Demo Application](https://jogiles.blob.core.windows.net/misc/modern-java-ch3-app.png)

This is a project to demonstrate all JavaFX UI controls in a simplistic way. To run, simply use the embedded gradle wrapper:

MacOS / Linux:
```./gradlew clean assemble run```

Windows:
```gradlew clean assemble run```

## Contributing
If you are keen to contribute to this project to get good samples - thanks so much!

We use the standard GitHub pull request approach. So, for this repo, push changes to your fork, and then create a pull request. I will then review and merge. Here's some important tips:

1. When you want to work on a sample, file an issue to make sure no one else is working on it. If you already see an issue with your sample, don't work on it! 
1. Check out ButtonDemo for an example of the proof of concept 'control panel'. If you want to toggle state in the UI controls, put the controls in the control panel area of your sample.
1. If you want to log to the console area, use the `console.accept("text")` approach that you see in other demos.
1. Keep things simple - don't over complicate the demos - the intent is to teach newcomers to JavaFX how to use the JavaFX UI controls. These demos may also make their way into the JavaFX book chapter that I (Jonathan) am writing.
1. Feel free to add an `@author Jonathan Giles <jonathan@jonathangiles.net>` style javadoc annotation to any sample you write. I haven't done that for myself yet, but I encourage contributors to do this to highlight their own contributions.

Thanks!
