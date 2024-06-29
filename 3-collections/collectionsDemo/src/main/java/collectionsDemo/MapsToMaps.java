package collectionsDemo;

import java.util.*;

public class MapsToMaps {
    public static void main(String[] args) {
        mapsToMaps();
    }
    public static void mapsToMaps(){
        Map<String, Integer> channelToSubscribers    = new TreeMap<>(); // channel, numSubscribers
        Map<String, String> channelToPublisher       = new TreeMap<>(); // channel, publisher
        Map<String, Integer> publisherToSubscribers  = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers
        // K -> V1
        channelToSubscribers.put("JustForLaughs", 120_000); 
        channelToSubscribers.put("JustForGags", 10_000); 
        channelToSubscribers.put("ContemplationTechniques", 10_000); 
        channelToSubscribers.put("A New Earth", 20_000); 
        
        // channel -> publisher
        // K -> V2
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // 1. Setup "publisherToSubscribers"
        // publisher -> number of subscribers (total)   
        // V2 -> V1


//        // because they are sorted
//        while (channelToSubscribersIterator.hasNext() && channelToPublisherIterator.hasNext()){
//            Map.Entry<String, String> entry1 = channelToPublisherIterator.next();
//            Map.Entry<String, Integer> entry2 = channelToSubscribersIterator.next();
//            if (entry1.getKey().equals(entry2.getKey())){
//                if (publisherToSubscribers.containsKey(entry1.getValue())){
//                    publisherToSubscribers.put(entry1.getValue(), publisherToSubscribers.get(entry1.getValue()) + entry2.getValue());
//                }else {
//                    publisherToSubscribers.put(entry1.getValue(), entry2.getValue());
//                }
//            }
//        }

        channelToPublisher.forEach(
                (channel1, pub) ->{
                    channelToSubscribers.forEach(
                            (channel2, sub) -> {
                                if (channel1.equals(channel2)){
                                    if (publisherToSubscribers.containsKey(pub)){
                                        publisherToSubscribers.put(pub, publisherToSubscribers.get(pub) + sub);
                                    }else {
                                        publisherToSubscribers.put(pub, sub);
                                    }
                                }
                            }
                    );
                }
        );
        // 2. Output "publisherToSubscribers"
        publisherToSubscribers.forEach((pub, sub) -> System.out.println("publisher: " + pub +  "; numSubscribers:" + sub + " "));

        // 3. Who has the most/least subscribers?
        String maxPublisher = "";
        String minPublisher = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry: publisherToSubscribers.entrySet()){
            String pub = entry.getKey();
            Integer sub = entry.getValue();
            if (sub > max){
                maxPublisher = pub;
                max = sub;
            }
            if (sub < min){
                minPublisher = pub;
                min = sub;
            }
        }

        System.out.printf("Publisher with most subscribers: %s %d\n",maxPublisher, max);
        System.out.printf("Publisher with fewest subscribers: %s %d\n",minPublisher, min);

        Map.Entry<String, Integer> max1 = Collections.max(publisherToSubscribers.entrySet(), Comparator.comparingInt(Map.Entry::getValue));
        System.out.println(max1);

        Map.Entry<String, Integer> min1 = Collections.min(publisherToSubscribers.entrySet(), Comparator.comparingInt(Map.Entry::getValue));
        System.out.println(min1);


    }
}
