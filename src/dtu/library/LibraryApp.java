package dtu.library;

import dtu.library.app.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryApp {

    private boolean loggedIn = false;
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public boolean adminLogin(String password) {
        loggedIn = "adminadmin".equals(password);
        return adminLoggedIn();
    }

    public boolean adminLoggedIn() {
        return loggedIn;
    }

    public boolean adminLogout() {
        return loggedIn = false;
    }

    public void addBook(Book book) throws OperationNotAllowedException {
        if (!adminLoggedIn()) {
            throw new OperationNotAllowedException("Administrator login required");
        } else {
            books.add(book);
        }
    }


    public List getBooks() {
        return books;
    }

    public List<Book> search(String searchText) {
        List<Book> booksFound = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if ((books.get(i)).match(searchText)) {
                booksFound.add(books.get(i));
            }
        }
        return booksFound;
    }

    public void registerUser(User user) throws OperationNotAllowedException {
        if (!adminLoggedIn()) {
            throw new OperationNotAllowedException("Administrator login required");
        }
        if (adminLoggedIn()&&users.contains(user)) {
            throw new OperationNotAllowedException("User is already registered");
        }
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
