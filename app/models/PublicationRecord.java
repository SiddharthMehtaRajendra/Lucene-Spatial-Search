/*
 * This project is the sole property of Siddharth Mehta. It may not be duplicated or reproduced without my consent. Please direct all technical queries to mehtasiddharth@hotmail.co.uk
 */

package models;

public class PublicationRecord {

    private String authorName;
    private String publicationTitle;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }
}
