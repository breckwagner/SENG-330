public class Inventory extends game {

  public Item[] stuff = new Item[2];

  public Inventory(){
  	stuff[0] = new Item("potion");
  	stuff[1] = new Item("weapon");
  }

}