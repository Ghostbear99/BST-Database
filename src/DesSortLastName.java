import java.util.Comparator;

public class DesSortLastName implements Comparator<Contacts>{

  public int compare(Contacts s1, Contacts s2)
  {
    return s1.last.compareTo(s2.last);
  }
}
 