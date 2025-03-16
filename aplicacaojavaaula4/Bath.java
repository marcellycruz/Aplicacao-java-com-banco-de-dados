package aplicacaojavaaula4;

public class Bath extends Service implements ISchedulable {
  private int duration;

  public Bath(){
    super();
  }

  public Bath(int id,String petName, String ownerName, double price, int duration){
    super(id,petName, ownerName, "banho",price);
    this.duration = duration;
  }

  public int getDuration(){
    return duration;
  }

  public void setDuration(int duration){
    this.duration = duration;
  }

  public void performService(){
    System.out.println("Banho realizado para " + getPetName() + ", " + 
                        "Tutor(a): " + getOwnerName() + ", " + 
                        "Duração: " + getDuration() + "min" + ", " + 
                        "Preço: R$ " + getPrice());
  }

  public void schedule(String date, String time){
    System.out.println("Banho agendado para " + getPetName() + " em " + date + " às " + time);
  }
}
