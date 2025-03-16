package aplicacaojavaaula4;

public abstract class Service{
  protected int id;
  protected String petName;
  protected String ownerName;
  protected String service;
  protected double price;

  public Service(){}

  public Service(int id, String petName, String ownerName, String service, double price){
    this.id = id;
    this.petName = petName;
    this.ownerName = ownerName;
    this.service = service;
    this.price = price;
  }

  public abstract void performService();
  
  public int getId() {return id;}
  public void setId(int id) {this.id = id;}
  public String getPetName() { return petName; }
  public void setPetName(String petName) { this.petName = petName; }
  public String getOwnerName() { return ownerName; }
  public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
  public double getPrice() { return price; }
  public void setPrice(double price) { this.price = price; }
}