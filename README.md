A java client SDK for Hyperledger
===============================


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