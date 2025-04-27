package com.mycompany.datasproject;
/**
 *
 * @author tala
 */
public class Test {

    public static void main(String[] args) {
        // Create a PhotoManager and InvIndexPhotoManager
        InvIndexPhotoManager manager = new InvIndexPhotoManager();
        PhotoManager photoManager = new PhotoManager();

        // Create photos and add them to PhotoManager and InvIndexPhotoManager
        Photo photo1 = new Photo("hedgehog.jpg", toTagsLinkedList("animal, hedgehog, apple, grass, green"));
        manager.addPhoto(photo1);
        photoManager.addPhoto(photo1);

        Photo photo2 = new Photo("bear.jpg", toTagsLinkedList("animal, bear, cab, grass, wind"));
        manager.addPhoto(photo2);
        photoManager.addPhoto(photo2);

        Photo photo3 = new Photo("orange-butterfly.jpg", toTagsLinkedList("insect, butterfly, flower, color"));
        manager.addPhoto(photo3);
        photoManager.addPhoto(photo3);

        // Print all photos in PhotoManager and InvIndexPhotoManager before deletion
        System.out.println("=== All photos before adding any photo now are: ===");
        printLLPhoto(photoManager.getPhotos());
        printLLPhoto(manager.getPhotos());

        System.out.println("---------------------");

        // Delete a photo 'hedgehog.jpg' and print updated lists
        System.out.println("\nDeleting 'hedgehog.jpg'...");
        manager.deletePhoto("hedgehog.jpg");
        photoManager.deletePhoto("hedgehog.jpg");

        System.out.println("=== All photos after trying to delete 'hedgehog.jpg' ===");
        printLLPhoto(photoManager.getPhotos());
        printLLPhoto(manager.getPhotos());

        // Add photos after deletion to see changes
        System.out.println("\nAdding photos after deletion...");
        Photo photo4 = new Photo("fox.jpg", toTagsLinkedList("animal, fox, tree, forest, grass"));
        manager.addPhoto(photo4);
        photoManager.addPhoto(photo4);

        System.out.println("=== All photos after adding 'fox.jpg' ===");
        printLLPhoto(photoManager.getPhotos());
        printLLPhoto(manager.getPhotos());

        // Deleting non-existing photo 'dog.jpg'
        System.out.println("\nTrying to delete non-existing photo 'dog.jpg'...");
        manager.deletePhoto("dog.jpg");
        photoManager.deletePhoto("dog.jpg");

        System.out.println("=== All photos after trying to delete 'dog.jpg' ===");
        printLLPhoto(photoManager.getPhotos());
        printLLPhoto(manager.getPhotos());

        // Create albums with conditions and display their details
        InvAlbum album1 = new InvAlbum("Album1", "bear", manager);
        InvAlbum album2 = new InvAlbum("Album2", "animal AND grass", manager);
        InvAlbum album3 = new InvAlbum("Album3", "", manager);

        System.out.println("\n=== Album 1 Photos ===");
        printAlbumDetails(album1);

        System.out.println("\n=== Album 2 Photos ===");
        printAlbumDetails(album2);

        System.out.println("\n=== Album 3 Photos (No condition) ===");
        printAlbumDetails(album3);
    }

    // Convert a comma-separated string of tags into a LinkedList of tags
    private static LinkedList<String> toTagsLinkedList(String tags) {
        LinkedList<String> result = new LinkedList<>();
        String[] tagsArray = tags.split("\\s*,\\s*");
        for (String tag : tagsArray) {
            result.insert(tag);
        }
        return result;
    }

    // Print the details of all photos in PhotoManager
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

    // Print all photos in InvIndexPhotoManager (BST<LinkedList<Photo>>)
    private static void printLLPhoto(BST<LinkedList<Photo>> index) {
        String inOrderKeys = index.inOrder();  // Get all keys (tags) in sorted order
        System.out.println("Inverted Index Keys: " + inOrderKeys);
        
        // Split the tags in the inverted index
        String[] tags = inOrderKeys.split(" AND ");
        
        // Loop through each tag and print associated photos
        for (String tag : tags) {
            if (index.findkey(tag)) {
                LinkedList<Photo> photos = index.retrieve();  // Retrieve the photos associated with the tag
                photos.findFirst();
                System.out.println("Photos for tag '" + tag + "':");
                
                // Print each photo in the LinkedList
                while (!photos.last()) {
                    System.out.println("- " + photos.retrieve().getPath());
                    photos.findNext();
                }
                System.out.println("- " + photos.retrieve().getPath());  // Print the last photo
            }
        }
    }

    // Print details of an album (photos, comparisons)
    private static void printAlbumDetails(InvAlbum album) {
        System.out.println("Album Name: " + album.getTitle());
        System.out.println("Condition: " + album.getCondition());
        LinkedList<Photo> photos = album.getMatchingPhotos();
        System.out.println("Matching Photos:");
        printLLPhoto(photos);
        System.out.println("Tag Comparisons: " + album.getComparisonCount());
    }

}
