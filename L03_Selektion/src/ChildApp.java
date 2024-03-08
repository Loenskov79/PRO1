public class ChildApp {
   // Opgave 4
   // Metoden skal returnere en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
   // Reglerne for dette kan ses på opgavedsedlen
  public static String institution(int age) {
      String myString = new String();
      if (age == 0)
          myString = "Home";
      if (age >=1 && age <= 2)
          myString = "Nursery";
      if (age >=3 && age <=5)
          myString = "Kindergarten";
      if (age >=6 && age <=16)
          myString = "School";
      if (age >=17)
          myString = "Out of school";
      return myString;

  }

    // Opgave 5
    // Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen
  public static String team(boolean isBoy, int age) {
      String myString = new String();
      if (isBoy == true && age <8)
          myString = "Young cubs";
      if (isBoy == false && age <8)
          myString = "Tumbling girls";
      if (isBoy == true && age >=8)
          myString = "Cool boys";
      if (isBoy == false && age >=8)
          myString = "Springy girls";
      return myString;

    }

}
