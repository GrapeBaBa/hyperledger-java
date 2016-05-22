Hyperledger-java
=======
[![Build Status](https://travis-ci.org/GrapeBaBa/hyperledger-java.svg?branch=master)](https://travis-ci.org/GrapeBaBa/hyperledger-java)

It is a java client SDK for the project [Hyperledger](https://github.com/hyperledger/fabric).

Getting Started
==========
You can find some common examples created using hyperledger-java-client in [an example project](https://github.com/GrapeBaBa/hyperledger-java/tree/master/hyperledger-java-examples)


Example
==========

```java
 
    Fabric FABRIC = Hyperledger.fabric("http://localhost:3000/")
    
    FABRIC.getNetworkPeers().subscribe(new Action1<PeersMessage>() {
        @Override
        public void call(PeersMessage peersMessage) {
            for (PeerEndpoint peerEndpoint : peersMessage.getPeers()) {
                System.out.printf("Peer message:%s\n", peerEndpoint);
            }
    
        }
    });
    
    FABRIC.getBlock(0)
          .subscribe(new Action1<Block>() {
              @Override
              public void call(Block block) {
                  System.out.printf("Get Block info:%s\n", block);
              }
          }, new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {
                  Error error = ErrorResolver.resolve(throwable, Error.class);
                  System.out.printf("Error message:%s\n", error.getError());
              }
          });
```

## Binaries

Binaries and dependency information for Maven, Ivy, Gradle and others can be found at [http://search.maven.org](http://search.maven.org/#search|ga|1|hyperledger-java-client).

Example for Maven:

```xml
<dependency>
    <groupId>me.grapebaba</groupId>
    <artifactId>hyperledger-java-client</artifactId>
    <version>0.1.1</version>
</dependency>
```
and for Ivy:

```xml
<dependency org="me.grapebaba" name="hyperledger-java-client" rev="0.1.1" />
```
and for Gradle:

```groovy
compile 'me.grapebaba:hyperledger-java-client:0.1.1'
```

## Build

To build:

```
$ git clone git@github.com:GrapeBaBa/hyperledger-java.git
$ cd hyperledger-java/
$ ./gradlew build
```


## Bugs and Feedback

For bugs, questions and discussions please use the [Github Issues](https://github.com/GrapeBaBa/hyperledger-java/issues).


## LICENSE

Copyright 2016 281165273@qq.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


