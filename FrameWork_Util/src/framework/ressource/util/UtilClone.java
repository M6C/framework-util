package framework.ressource.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

public class UtilClone {
  private UtilClone() {
  }

  public static Object makeClone(Serializable pSource) throws IOException, ClassNotFoundException {
    Object lvClone = null;
    ByteArrayOutputStream lvBAOS = new ByteArrayOutputStream();
    ObjectOutputStream lvOOS = new ObjectOutputStream(lvBAOS);
    lvOOS.writeObject(pSource);
    lvOOS.close();
    ByteArrayInputStream lvBAIS = new ByteArrayInputStream(lvBAOS.toByteArray());
    ObjectInputStream lvOIS = new ObjectInputStream(lvBAIS);
    lvClone = lvOIS.readObject();
    lvOIS.close();
    return lvClone;
  }
}
