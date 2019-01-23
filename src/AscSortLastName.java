import java.util.Comparator;

public class AscSortLastName implements Comparator<Contacts>{

  public int compare(Contacts s1, Contacts s2)
  {
    return s2.last.compareTo(s1.last);
  }
}
 