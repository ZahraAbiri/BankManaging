public class Customer {
    private String name;
    public int lastIndex;
    Account[] account = new Account[100];
    public Customer() {
        for (int i = 0; i <100 ; i++) {
            account[i]=new Account();
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Customer(String name) {
        this.name = name;
    }


}
