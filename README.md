# The Listener
A character living in your terminal to listen to your problems. Just explain it your problems and your will most likly magically find the solution to it all by your self ;)

# Building it
You will need to have the JDK 17 installed on your path.
Then just type
```shell
./gradlew shadowJar
```

Or to install it on your linux system:
```shell
./gradlew install
```
This will install the `listen` command in `/usr/local/sbin/listen` and the binary at `/opt/thelistener/bin/the-listener.jar`. Then you can summon a listener for you just by typing `listen` in your terminal!