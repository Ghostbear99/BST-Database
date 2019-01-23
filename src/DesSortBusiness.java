import java.util.Comparator;

public class DesSortBusiness implements Comparator<Contacts>{

  public int compare(Contacts s1, Contacts s2)
  {
    return s1.business.compareTo(s2.business);
  }
}
 