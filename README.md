My [Giter8][g8] template for scala multi project.

- with sbt 0.13.13 and scala 2.11.8
- bundled with sbt, and sbt-launch.jar
- add a `repositories` file, for overriding global resolvers
- essential plugins
  - [coursier][coursier] for faster artifact fetching
  - [sbt-assembly][sbt-assembly] for packaging
  - [sbt-aether-deploy][sbt-aether-deploy] for better maven deploy support.

Usages:

```
sbt new xsy233/scala-multi-project.g8
```

[g8]: http://www.foundweekends.org/giter8/
[coursier]: https://github.com/alexarchambault/coursier
[sbt-assembly]: https://github.com/sbt/sbt-assembly
[sbt-aether-deploy]: https://github.com/arktekk/sbt-aether-deploy
