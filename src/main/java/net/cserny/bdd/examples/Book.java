package net.cserny.bdd.examples;

import java.util.Date;

/**
 * Created by user on 13.05.2016.
 */
public class Book
{
    private String title;
    private String author;
    private Date published;

    public Book(String title, String author, Date published)
    {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Date getPublished()
    {
        return published;
    }

    public void setPublished(Date published)
    {
        this.published = published;
    }
}
