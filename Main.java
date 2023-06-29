import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main{

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args){

        

        Album album = new Album ("Album 1" ,"Sahrukh");

        album.addSong( "mohabbattein",4.5);
        album.addSong("Rab ne bana di",3.5);
        album.addSong("kuch kuch hota",5.5);
        albums.add(album);

        album = new Album("Album2","Amir");
     
        album.addSong( "pardesi",5.0);
        album.addSong( "chanda chamke",3.5);
        album.addSong( "chand sifaaris",4.3);

        albums.add(album);   
    
        LinkedList<Song>playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList( "mohabbattein", playList_1);
        albums.get(0).addToPlayList( "rab ne bana di", playList_1);
        albums.get(1).addToPlayList( "pardesi", playList_1);
        albums.get(1).addToPlayList( "chanda chamke", playList_1);

        play(playList_1);
       
    }
    private static void play(LinkedList<Song> playList) {
           Scanner sc=new Scanner(System.in);
           boolean quit=false;
           boolean forward=true;
           ListIterator<Song> listIterator=playList.listIterator();

           if(playList.size() ==0){
            System.out.println("this playlist have no songs");

           }
           else{
            System.out.println("Now playing"+listIterator.next().toString());
            printMenu();
           }
           while(!quit){
            int action=sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0:
                      System.out.println("playlist complete");
                      quit=true;
                      break;
                case 1:
                     if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                     } 
                     if(listIterator.hasNext()){
                        System.out.println("now playing" +listIterator.next().toString());

                     } 
                     else{
                        System.out.println("no song available,reached to the end of the list");
                        forward = false;
                     } 
                     break;
                     
                     case 2:
                           if(forward){
                            if(listIterator.hasPrevious()){
                                listIterator.previous();
                            }
                            forward=false;
                           }
                           if(listIterator.hasPrevious()){
                            System.out.println("now playing" +listIterator.previous().toString());

                           }else{
                            System.out.println("we are the first song");
                            forward= false;
                           }
                           break;
                          
                           case 3:
                                if(forward){
                                    if(listIterator.hasPrevious()){
                                        System.out.println("now playing" +listIterator.previous().toString());
                                         forward=false;
                                    }else{
                                        System.out.println("we are at the start of the list");
                                    }
                                }else{
                                    if(listIterator.hasNext()){
                                        System.out.println("now playing"+ listIterator.next().toString());
                                        forward=true;
                                    }else{
                                        System.out.println("we are at the start of the list"); 
                                    }
                                }
                                break;

                                case 4:
                                      printList(playList);
                                      break;

                                 case 5:
                                      printMenu();
                                      break;
                                      
                                 case 6:
                                      if(playList.size() >0){
                                        listIterator.remove();
                                        if(listIterator.hasNext()){
                                            System.out.println("now playing"+ listIterator.next().toString());
                                        }
                                        else{
                                            if(listIterator.hasPrevious()){
                                                System.out.println("now playing" +listIterator.previous().toString()); 
                                            }
                                        }
                                      }     
            }
          
        }
    }
    private static void printMenu(){
        System.out.println("available options\n press");
        System.out.println("0 - for quit\n" + "1-for play next song\n"+ "2-for playprevious song\n" + "3-for current song\n"
        + "4-list of all songs\n"+"5-for all available options\n" + "6-for delete current song");
    }
    private static void printList(LinkedList<Song>playList){
        Iterator<Song> iterator= playList.iterator();
        System.out.println("......");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("......");
    }
}

