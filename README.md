[![Build Status](https://travis-ci.org/GrapeBaBa/hyperledger-java.svg?branch=master)](https://travis-ci.org/GrapeBaBa/hyperledger-java)

A java client SDK for Hyperledger
===============================
> It is a java client SDK for the project [Hyperledger](https://github.com/hyperledger/fabric).

How to get
---------------------------------------------------------
Now you can download 0.1.0-snapshot version from oss.jfrog.org, 0.1.0 final release will soon publish.

    repositories {
        mavenCentral()
        jcenter()
        maven { url 'https://oss.jfrog.org/libs-snapshot' }
    }
    
    dependencies {
        compile 'io.grapebaba:hyperledger-java-client:0.1.0-SNAPSHOT'
    }

How to use
----------------------------------------------------------

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
          
Example
---------------------------------------------------------
[An example project](https://github.com/GrapeBaBa/hyperledger-java/tree/master/hyperledger-java-examples)
                            
How to build
----------------------------------------------------------
    cd hyperledger-java
    ./gradlew build

Issues
----------------------------------------------------------
[Report issues](https://github.com/GrapeBaBa/hyperledger-java/issues)