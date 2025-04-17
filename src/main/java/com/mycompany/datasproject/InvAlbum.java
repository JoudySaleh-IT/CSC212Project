/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datasproject;

/**
 *
 * @author talashail
 */
public class InvAlbum {
    private String albumTitle;
    private String filterCondition;
    private InvIndexPhotoManager indexManager;
    private int comparisonCount;

    // Constructor
    public InvAlbum(String title, String condition, InvIndexPhotoManager manager) {
        this.albumTitle = title;
        this.filterCondition = condition;
        this.indexManager = manager;
        comparisonCount = 0;
    }

    public String getTitle() {
        return albumTitle;
    }

    public String getCondition() {
        return filterCondition;
    }

    public InvIndexPhotoManager getIndexManager() {
        return indexManager;
    }

    public LinkedList<Photo> getMatchingPhotos() {
        BST<LinkedList<Photo>> photoTree = indexManager.getPhotos();
        LinkedList<Photo> matchedPhotos = new LinkedList<Photo>();
        comparisonCount = 0;
        String[] conditionTags;

        if (!filterCondition.equals(""))
            conditionTags = filterCondition.split(" AND ");
        else
            conditionTags = photoTree.inOrder().split(" AND ");

        for (int i = 0; i < conditionTags.length; i++) {
            if (photoTree.findkey(conditionTags[i])) {
                LinkedList<Photo> tagPhotos = photoTree.retrieve();

                if (i == 0) {
                    tagPhotos.findFirst();
                    while (!tagPhotos.last()) {
                        matchedPhotos.insert(tagPhotos.retrieve());
                        tagPhotos.findNext();
                    }
                    matchedPhotos.insert(tagPhotos.retrieve());
                } else {
                    if (!filterCondition.isEmpty())
                        matchedPhotos = intersectPhotos(matchedPhotos, tagPhotos);
                    else
                        matchedPhotos = unionPhotos(matchedPhotos, tagPhotos);
                }
            } else {
                matchedPhotos = new LinkedList<Photo>();
                break;
            }
        }
        return matchedPhotos;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    private LinkedList<Photo> intersectPhotos(LinkedList<Photo> listA, LinkedList<Photo> listB) {
        LinkedList<Photo> result = new LinkedList<Photo>();

        if (!listB.empty()) {
            listB.findFirst();
            while (!listB.last()) {
                if (!listA.empty()) {
                    boolean found = false;
                    listA.findFirst();
                    while (!listA.last() && !found) {
                        if (listB.retrieve().getPath().equalsIgnoreCase(listA.retrieve().getPath())) {
                            comparisonCount++;
                            found = true;
                        }
                        listA.findNext();
                    }
                    if (!found && listB.retrieve().getPath().equalsIgnoreCase(listA.retrieve().getPath())) {
                        comparisonCount++;
                        found = true;
                    }
                    if (found)
                        result.insert(listB.retrieve());
                }
                listB.findNext();
            }

            boolean found = false;
            listA.findFirst();
            while (!listA.last() && !found) {
                if (listB.retrieve().getPath().equalsIgnoreCase(listA.retrieve().getPath())) {
                    comparisonCount++;
                    found = true;
                }
                listA.findNext();
            }
            if (!found && listB.retrieve().getPath().equalsIgnoreCase(listA.retrieve().getPath())) {
                comparisonCount++;
                found = true;
            }
            if (found)
                result.insert(listB.retrieve());
        }
        return result;
    }

    private LinkedList<Photo> unionPhotos(LinkedList<Photo> mainList, LinkedList<Photo> newList) {
        if (!newList.empty()) {
            newList.findFirst();
            while (!newList.last()) {
                if (!mainList.empty()) {
                    boolean found = false;
                    mainList.findFirst();
                    while (!mainList.last() && !found) {
                        if (newList.retrieve().getPath().equalsIgnoreCase(mainList.retrieve().getPath())) {
                            comparisonCount++;
                            found = true;
                        }
                        mainList.findNext();
                    }
                    if (!found && newList.retrieve().getPath().equalsIgnoreCase(mainList.retrieve().getPath())) {
                        comparisonCount++;
                        found = true;
                    }
                    if (!found)
                        mainList.insert(newList.retrieve());
                }
                newList.findNext();
            }

            boolean found = false;
            mainList.findFirst();
            while (!mainList.last() && !found) {
                if (newList.retrieve().getPath().equalsIgnoreCase(mainList.retrieve().getPath())) {
                    comparisonCount++;
                    found = true;
                }
                mainList.findNext();
            }
            if (!found && newList.retrieve().getPath().equalsIgnoreCase(mainList.retrieve().getPath())) {
                comparisonCount++;
                found = true;
            }
            if (!found)
                mainList.insert(newList.retrieve());
        }
        return mainList;
    }
}
  
