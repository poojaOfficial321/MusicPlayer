package com.musicplayer;

import java.util.*;

public class Main {

    private static ArrayList<Album> albumArrayList = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","AC/DC");

        album.addSong("christmas",4.5);

        albumArrayList.add(album);

        album = new Album("Album2","Eminem");

        album.addSong("winter",4.5);

        albumArrayList.add(album);

        LinkedList<Song> playList1 = new LinkedList<>();
        albumArrayList.get(0).addToPlayList("TNT",playList1);
        albumArrayList.get(1).addToPlayList("Rap",playList1);
        play(playList1);


    }

    private static void play(LinkedList<Song> playList1) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList1.listIterator();

        if(playList1.size() == 0)
        {
            System.out.println("No song");
        }
        else
        {
            System.out.println("Now Playing" + listIterator.next().toString());
            printMenu();
        }

        while (!quit)
        {
            int action = sc.nextInt();
            sc.nextInt();

            switch (action)
            {
                case 0: System.out.println("Playlist complete");
                quit = true;
                break;

                case 1: if(!forward)
                {
                    if(listIterator.hasNext()){
                        listIterator.next();
                    }
                    forward = true;
                }
                if(listIterator.hasNext()){
                    System.out.println("Now Playing"+listIterator.next().toString());
                }
                else {
                    System.out.println("No song available,reached at end of list");
                    forward = false;
                }
                break;

                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing"+listIterator.previous().toString());
                    }
                    else {
                        System.out.println("We are at first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing"+listIterator.previous().toString());
                            forward =false;
                        }
                        else
                        {
                            System.out.println("At start of list");
                        }
                    }
                    else {
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing"+listIterator.next().toString());
                            forward = true;
                        }
                        else
                        {
                            System.out.println("Reached end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList1);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList1.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing"+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now playing"+listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printList(LinkedList<Song> playList1) {
        Iterator<Song> iterator = playList1.iterator();
        System.out.println("--------------------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------");
    }


    private static void printMenu() {
        System.out.println("Available options\n press");
        System.out.println("0 - Quit\n" +
                "1 - Next song\n" +
                "2 - Previous\n" +
                "3 - Replay\n" +
                "4 - All songs\n" +
                "5 - Available options\n" +
                "6 - Delete");
    }
}
