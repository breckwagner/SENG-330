public class Items extends game {

  public Integer amount;

  public String type;

  public Integer damageModifier;

  public Integer healthModifier;

  public Integer UUID;

  public Boolean isUsed;


  use(Player player){
  	if(type = "potion"){
  		player.Health = player.Health + healthModifier;
  	} else if(type = "weapon"){
  		player.Attack = player.Attack + damageModifier;
  	}
  }


}