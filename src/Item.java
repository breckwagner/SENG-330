public class Item extends Game {

  public Integer amount;

  public String type;

  public Integer damageModifier;

  public Integer healthModifier;

  public Integer UUID;

  public Boolean isUsed;

  public Item(String type){
    this.amount = 0;
    this.type = type;
    this.healthModifier = 20;
    this.damageModifier = 10;
  }

  public void use(Player player){
  	if(type == "potion"){
  		player.Health = player.Health + healthModifier;
  	} else if(type == "weapon"){
  		player.Attack = player.Attack + damageModifier;
  	}
  }


}