package net.cserny.bdd.examples;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by user on 13.05.2016.
 */
public class Library
{
    private List<Book> store = new ArrayList<>();

    public void addBook(Book book)
    {
        store.add(book);
    }

    public List<Book> findBooks(Date fromDate, Date toDate)
    {
        Calendar end = Calendar.getInstance();
        end.setTime(toDate);
        end.roll(Calendar.YEAR, 1);

        return store.stream()
            .filter(book -> fromDate.before(book.getPublished()) && end.getTime().after(book.getPublished()))
            .sorted(Comparator.comparing(Book::getPublished).reversed())
            .collect(Collectors.toList());
    }
}
