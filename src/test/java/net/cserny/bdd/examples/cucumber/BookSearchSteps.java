package net.cserny.bdd.examples.cucumber;

import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.cserny.bdd.examples.Book;
import net.cserny.bdd.examples.Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 13.05.2016.
 */
public class BookSearchSteps
{
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @Given(".+ book with the title '(.+)', written by '(.+)', published in (.+)")
    public void addNewBook(String title, String author, @Format("dd MMMM yyyy") Date publishDate)
    {
        Book book = new Book(title, author, publishDate);
        library.addBook(book);
    }

    @When("^the customer searches for books published between (\\d+) and (\\d+)$")
    public void setSearchParameters(@Format("yyyy") Date from, @Format("yyyy") Date to)
    {
        result = library.findBooks(from, to);
    }

    @Then("(\\d+) books should have been found$")
    public void verifyAmountOfBooksFound(int booksFound)
    {
        assertThat(result.size(), equalTo(booksFound));
    }

    @Then("Book (\\d+) should have the title '(.+)'$")
    public void verifyBookAtPosition(int position, String title)
    {
        assertThat(result.get(position - 1).getTitle(), equalTo(title));
    }
}
