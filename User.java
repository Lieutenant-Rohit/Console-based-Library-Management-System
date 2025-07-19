public abstract class User {
    String name;
    String memberId;

    User(String name,String memberId)
    {
        this.name=name;
        this.memberId=memberId;
    }

    public abstract void borrowBook(Book book);
    public abstract void returnBook(Book book);

    public String getMemberId()
    {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
