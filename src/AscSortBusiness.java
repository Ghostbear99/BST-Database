import java.util.Comparator;

public class AscSortBusiness implements Comparator<Contacts>{

  public int compare(Contacts s1, Contacts s2)
  {
    return s2.business.compareTo(s1.business);
  }
}
 