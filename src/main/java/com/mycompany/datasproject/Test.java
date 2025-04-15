
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.datasproject;




/**
 *
 * @author talas
 */
public class Test {

    public static void main(String[] args) {
        // Create a PhotoManager
        InvIndexPhotoManager manager = new InvIndexPhotoManager();

        Photo photo1 = new Photo("hedgehog.jpg", toTagsLinkedList("animal, hedgehog, apple, grass, green"));
        manager.addPhoto(photo1);

        Photo photo2 = new Photo("bear.jpg", toTagsLinkedList("animal, bear, cab, grass, wind"));
        manager.addPhoto(photo2);

        Photo photo3 = new Photo("orange-butterfly.jpg", toTagsLinkedList("insect, butterfly, flower, color"));
        manager.addPhoto(photo3);

        InvertedIndexAlbum album1 = new InvertedIndexAlbum("Album1", "bear", manager);
        InvertedIndexAlbum album2 = new InvertedIndexAlbum("Album2", "animal AND grass", manager);
        InvertedIndexAlbum album3 = new InvertedIndexAlbum("Album3", "", manager);

        printAlbumDetails(album1);
        printAlbumDetails(album2);
        printAlbumDetails(album3);

        System.out.println("\nDeleting the photo 'bear.jpg'...");
        manager.deletePhoto("bear.jpg");
    }

    private static LinkedList<String> toTagsLinkedList(String tags) {
        LinkedList<String> result = new LinkedList<>();
        String[] tagsArray = tags.split("\\s*,\\s*");
        for (String tag : tagsArray) {
            result.insert(tag);
        }
        return result;
    }

    private static void printAlbumDetails(InvertedIndexAlbum album) {
        System.out.println("Album Name: " + album.getTitle());
        System.out.println("Condition: " + album.getCondition());
        LinkedList<Photo> photos = album.getMatchingPhotos();
        System.out.println("Matching Photos:");
        printLLPhoto(photos);
        System.out.println("Tag Comparisons: " + album.getComparisonCount());
    }

    private static void printLL(LinkedList<String> list) {
        list.findFirst();
        if (list.empty()) return;
        while (true) {
            System.out.print(list.retrieve() + " ");
            if (list.last()) return;
            list.findNext();
        }
    }

    private static void printLLPhoto(LinkedList<Photo> list) {
        list.findFirst();
        if (list.empty()) {
            System.out.println("No matching photos.");
            return;
        }
        while (true) {
            System.out.println("- " + list.retrieve().getPath());
            if (list.last()) return;
            list.findNext();
        }
    }

        }
