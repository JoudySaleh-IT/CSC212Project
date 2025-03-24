/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datasproject;

/**
 *
 * @author joudalzahrani
 */


/**
 *
 * @author talas
 */
public class Test {

    public static void main(String[] args) {
        // Create a PhotoManager
        PhotoManager manager1 = new PhotoManager();

        // Use the toTagsLinkedList method to create the tags list and corresponding photos
        Photo firstphoto = new Photo("hedgehog.png", toTagsLinkedList("animal, hedgehog, apple, grass, green"));
        manager1.addPhoto(firstphoto);

        Photo secoundphoto = new Photo("bear.png", toTagsLinkedList("animal, bear, cab, grass, wind"));
        manager1.addPhoto(secoundphoto);

        Photo Thirdphoto = new Photo("butterflies.png", toTagsLinkedList("insect, butterfly, purple flower, colors"));
        manager1.addPhoto(Thirdphoto);

        Photo Fourthphoto = new Photo("butterfly.png", toTagsLinkedList("insect, butterfly, black, orange flower"));
        manager1.addPhoto(Fourthphoto);

        Photo Fifthphoto = new Photo("fox.png", toTagsLinkedList("animal, fox, tree, forest, grass"));
        manager1.addPhoto(Fifthphoto);

        Photo Sixthphoto = new Photo("panda.png ", toTagsLinkedList("animal, bear, panda, grass"));
        manager1.addPhoto(Sixthphoto);

        Photo Seventhphoto = new Photo("wolf.png", toTagsLinkedList("animal, wolf, mountain, sky, snow, cloud"));
        manager1.addPhoto(Seventhphoto);

        Photo Eighthphoto = new Photo("raccoon.png", toTagsLinkedList("animal, raccoon, log, snow"));
        manager1.addPhoto(Eighthphoto);

        //Retrieve and display the photos in the manager
        System.out.println("Photos in the manager:");
        LinkedList<Photo> photosInManager = manager1.getPhotos();
        photosInManager.findFirst();
        while (!photosInManager.last()) {
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
            photosInManager.findNext();
        }
        System.out.println("Photo: " + photosInManager.retrieve().getPath());

        // Example of creating an album and displaying the result
        Album album1 = new Album("Album1", "bear", manager1);
        System.out.println("\nAlbum 1 Photos:");
        LinkedList<Photo> albumPhotos1 = album1.getPhotos();
        albumPhotos1.findFirst();
        while (!albumPhotos1.last()) {
            System.out.println("Photo in Album1: " + albumPhotos1.retrieve().getPath());
            albumPhotos1.findNext();
        }
        System.out.println("Photo in Album1: " + albumPhotos1.retrieve().getPath());

        
       // System.out.println(firstphoto.getTags()); احتاج اتاكد منها
        
        
        
                // Delete a specific photo and verify the deletion
        System.out.println("\nDeleting photo 'hedgehog.png':");
        manager1.deletePhoto("hedgehog.png");

        // Verify the photo was deleted
        System.out.println("\nAfter deletion, remaining photos in manager:");
        photosInManager = manager1.getPhotos();
        photosInManager.findFirst();
        while (!photosInManager.last()) {
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
            photosInManager.findNext();
        }
        System.out.println("Photo: " + photosInManager.retrieve().getPath());


        // Delete the second photo and verify the deletion
        System.out.println("\nDeleting photo 'bear.png':");
        manager1.deletePhoto("bear.png");

        // Verify the photo was deleted
        System.out.println("\nAfter deletion, remaining photos in manager:");
        photosInManager = manager1.getPhotos();
        photosInManager.findFirst();
        while (!photosInManager.last()) {
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
            photosInManager.findNext();
        }
        System.out.println("Photo: " + photosInManager.retrieve().getPath());


        // Delete the third photo and verify the deletion
        System.out.println("\nDeleting photo 'butterfly1.png':");
        manager1.deletePhoto("butterflies.png");

        // Verify the photo was deleted
        System.out.println("\nAfter deletion, remaining photos in manager:");
        photosInManager = manager1.getPhotos();
        photosInManager.findFirst();
        while (!photosInManager.last()) {
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
            photosInManager.findNext();
        }
        System.out.println("Photo: " + photosInManager.retrieve().getPath());


        // Delete the fourth photo and verify the deletion
        System.out.println("\nDeleting photo 'butterfly2.png':");
        manager1.deletePhoto("butterfly.png");

        // Verify the photo was deleted
        System.out.println("\nAfter deletion, remaining photos in manager:");
        photosInManager = manager1.getPhotos();
        photosInManager.findFirst();
        while (!photosInManager.last()) {
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
            photosInManager.findNext();
        }
        System.out.println("Photo: " + photosInManager.retrieve().getPath());


        // Delete the fifth photo and verify the deletion
        System.out.println("\nDeleting photo 'fox.png':");
        manager1.deletePhoto("fox.png");

        // Verify the photo was deleted
        System.out.println("\nAfter deletion, remaining photos in manager:");
        photosInManager = manager1.getPhotos();
        photosInManager.findFirst();
        while (!photosInManager.last()) {
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
            photosInManager.findNext();
        }
        System.out.println("Photo: " + photosInManager.retrieve().getPath());


        // Delete the sixth photo and verify the deletion
        System.out.println("\nDeleting photo 'panda.png':");
        manager1.deletePhoto("panda.png");

        // Verify the photo was deleted
        System.out.println("\nAfter deletion, remaining photos in manager:");
        photosInManager = manager1.getPhotos();
        photosInManager.findFirst();
        while (!photosInManager.last()) {
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
            photosInManager.findNext();
        }
        System.out.println("Photo: " + photosInManager.retrieve().getPath());


        // Delete the seventh photo and verify the deletion
        System.out.println("\nDeleting photo 'wolf.png':");
        manager1.deletePhoto("wolf.png");

        // Verify the photo was deleted
        System.out.println("\nAfter deletion, remaining photos in manager:");
        photosInManager = manager1.getPhotos();
        photosInManager.findFirst();
        while (!photosInManager.last()) {
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
            photosInManager.findNext();
        }
        System.out.println("Photo: " + photosInManager.retrieve().getPath());


        // Delete the eighth photo and verify the deletion
        System.out.println("\nDeleting photo 'raccoon.png':");
        manager1.deletePhoto("raccoon.png");

        // Verify the photo was deleted
        System.out.println("\nAfter deletion, remaining photos in manager:");
        photosInManager = manager1.getPhotos();
        if (photosInManager.empty()) {
            System.out.println("No photos remaining.");
        } else {
            photosInManager.findFirst();
            while (!photosInManager.last()) {
                System.out.println("Photo: " + photosInManager.retrieve().getPath());
                photosInManager.findNext();
            }
            System.out.println("Photo: " + photosInManager.retrieve().getPath());
        }

            }

            private static LinkedList<String> toTagsLinkedList(String tags) {
            LinkedList<String> result = new LinkedList<String>();  // Initialize the LinkedList to store tags
            String[] tagsArray = tags.split("\\s*,\\s*");  // Split the input string by commas, allowing for spaces around them
            for (int i = 0; i < tagsArray.length; i++) {
                result.insert(tagsArray[i]);  // Insert each tag into the LinkedList
            }

            return result;  // Return the filled LinkedList
        }

        }