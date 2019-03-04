package dtu.library;

public class Book {

    private String title;
    private String author;
    private String signature;

    public Book (String T, String A, String S){
        this.title = T;
        this.author = A;
        this.signature = S;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getSignature(){
        return signature;
    }

    public Boolean match(String searchText){
        if(title.contains(searchText)||author.contains(searchText)||signature.contains(searchText)){
            return true;
        } else {
            return false;
        }
    }
}
